package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.internal.Finalizer;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ClassUtils;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class FinalizableReferenceQueue implements Closeable, AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f42267d = Logger.getLogger(FinalizableReferenceQueue.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final Method f42268e;

    /* renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f42269a;

    /* renamed from: b, reason: collision with root package name */
    public final PhantomReference f42270b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f42271c;

    public static class DecoupledLoader implements FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public final Class a() {
            try {
                return new URLClassLoader(new URL[]{b()}, null).loadClass("com.google.common.base.internal.Finalizer");
            } catch (Exception e2) {
                FinalizableReferenceQueue.f42267d.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (Throwable) e2);
                return null;
            }
        }

        public final URL b() throws IOException {
            String str = "com.google.common.base.internal.Finalizer".replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String string = resource.toString();
            if (string.endsWith(str)) {
                return new URL(resource, string.substring(0, string.length() - str.length()));
            }
            throw new IOException("Unsupported path style: ".concat(string));
        }
    }

    public static class DirectLoader implements FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public final Class a() {
            try {
                Logger logger = Finalizer.f42325a;
                return Finalizer.class;
            } catch (ClassNotFoundException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public interface FinalizerLoader {
        Class a();
    }

    public static class SystemLoader implements FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public final Class a() {
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader == null) {
                    return null;
                }
                try {
                    return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.f42267d.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    static {
        FinalizerLoader[] finalizerLoaderArr = {new SystemLoader(), new DecoupledLoader(), new DirectLoader()};
        for (int i2 = 0; i2 < 3; i2++) {
            Class clsA = finalizerLoaderArr[i2].a();
            if (clsA != null) {
                try {
                    f42268e = clsA.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
                    return;
                } catch (NoSuchMethodException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        throw new AssertionError();
    }

    public FinalizableReferenceQueue() {
        boolean z;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.f42269a = referenceQueue;
        PhantomReference phantomReference = new PhantomReference(this, referenceQueue);
        this.f42270b = phantomReference;
        try {
            f42268e.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
            z = true;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (Throwable th) {
            f42267d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            z = false;
        }
        this.f42271c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f42270b.enqueue();
        if (this.f42271c) {
            return;
        }
        while (true) {
            Reference referencePoll = this.f42269a.poll();
            if (referencePoll == 0) {
                return;
            }
            referencePoll.clear();
            try {
                ((FinalizableReference) referencePoll).a();
            } catch (Throwable th) {
                f42267d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }
}
