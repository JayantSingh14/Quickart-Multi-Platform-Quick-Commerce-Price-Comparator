package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.SharedReference;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable, AutoCloseable {

    /* renamed from: e, reason: collision with root package name */
    public static final ResourceReleaser f17107e = new AnonymousClass1();

    /* renamed from: f, reason: collision with root package name */
    public static final LeakHandler f17108f = new AnonymousClass2();

    /* renamed from: a, reason: collision with root package name */
    public boolean f17109a = false;

    /* renamed from: b, reason: collision with root package name */
    public final SharedReference f17110b;

    /* renamed from: c, reason: collision with root package name */
    public final LeakHandler f17111c;

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f17112d;

    /* renamed from: com.facebook.common.references.CloseableReference$1, reason: invalid class name */
    public class AnonymousClass1 implements ResourceReleaser<Closeable> {
        @Override // com.facebook.common.references.ResourceReleaser
        public final void a(Object obj) {
            try {
                Closeables.a((Closeable) obj);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: com.facebook.common.references.CloseableReference$2, reason: invalid class name */
    public class AnonymousClass2 implements LeakHandler {
        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public final void a(SharedReference sharedReference, Throwable th) {
            Object objB = sharedReference.b();
            FLog.p(CloseableReference.class, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), objB == null ? null : objB.getClass().getName());
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public final boolean b() {
            return false;
        }
    }

    public @interface CloseableRefType {
    }

    /* loaded from: classes.dex */
    public interface LeakHandler {
        void a(SharedReference sharedReference, Throwable th);

        boolean b();
    }

    public CloseableReference(SharedReference sharedReference, LeakHandler leakHandler, Throwable th) {
        int i2;
        boolean z;
        sharedReference.getClass();
        this.f17110b = sharedReference;
        synchronized (sharedReference) {
            synchronized (sharedReference) {
                i2 = sharedReference.f17118b;
                z = i2 > 0;
            }
            this.f17111c = leakHandler;
            this.f17112d = th;
        }
        if (!z) {
            throw new SharedReference.NullReferenceException();
        }
        sharedReference.f17118b = i2 + 1;
        this.f17111c = leakHandler;
        this.f17112d = th;
    }

    public static boolean A(CloseableReference closeableReference) {
        return closeableReference != null && closeableReference.x();
    }

    public static DefaultCloseableReference D(Closeable closeable) {
        return T(closeable, f17107e, f17108f);
    }

    public static DefaultCloseableReference O(Object obj, ResourceReleaser resourceReleaser) {
        return T(obj, resourceReleaser, f17108f);
    }

    public static DefaultCloseableReference T(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler) {
        if (obj == null) {
            return null;
        }
        Throwable th = leakHandler.b() ? new Throwable() : null;
        if (!(obj instanceof Bitmap)) {
            boolean z = obj instanceof HasBitmap;
        }
        return new DefaultCloseableReference(obj, resourceReleaser, leakHandler, th, true);
    }

    public static CloseableReference c(CloseableReference closeableReference) {
        if (closeableReference != null) {
            return closeableReference.b();
        }
        return null;
    }

    public static void e(CloseableReference closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract CloseableReference clone();

    public synchronized CloseableReference b() {
        if (!x()) {
            return null;
        }
        return clone();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (this.f17109a) {
                    return;
                }
                this.f17109a = true;
                this.f17110b.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Object l() {
        Object objB;
        Preconditions.e(!this.f17109a);
        objB = this.f17110b.b();
        objB.getClass();
        return objB;
    }

    public synchronized boolean x() {
        return !this.f17109a;
    }

    public CloseableReference(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler, Throwable th, boolean z) {
        this.f17110b = new SharedReference(obj, resourceReleaser, z);
        this.f17111c = leakHandler;
        this.f17112d = th;
    }
}
