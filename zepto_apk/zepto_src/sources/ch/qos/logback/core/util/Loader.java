package ch.qos.logback.core.util;

import java.net.URL;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes.dex */
public class Loader {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f13812a;

    /* renamed from: ch.qos.logback.core.util.Loader$1, reason: invalid class name */
    public static class AnonymousClass1 implements PrivilegedAction<Boolean> {
        @Override // java.security.PrivilegedAction
        public final Boolean run() throws AccessControlException {
            try {
                AccessController.checkPermission(new RuntimePermission("getClassLoader"));
                return Boolean.TRUE;
            } catch (SecurityException unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* renamed from: ch.qos.logback.core.util.Loader$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    final class AnonymousClass2 implements PrivilegedAction<ClassLoader> {
        @Override // java.security.PrivilegedAction
        public final ClassLoader run() {
            throw null;
        }
    }

    static {
        String property = null;
        try {
            property = System.getProperty("logback.ignoreTCL", null);
        } catch (SecurityException unused) {
        }
        if (property != null) {
            f13812a = OptionHelper.d(property, true);
        }
        ((Boolean) AccessController.doPrivileged(new AnonymousClass1())).getClass();
    }

    public static ClassLoader a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        ClassLoader classLoader = obj.getClass().getClassLoader();
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    public static URL b(String str) {
        ClassLoader classLoader = Loader.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            return classLoader.getResource(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
