package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import java.util.Enumeration;

/* loaded from: classes5.dex */
public final class ClassLoaderUtils {

    /* renamed from: a, reason: collision with root package name */
    static Class f57328a;

    /* renamed from: org.apache.xml.security.utils.ClassLoaderUtils$1, reason: invalid class name */
    class AnonymousClass1 implements Enumeration {
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return null;
        }
    }

    private ClassLoaderUtils() {
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private static Class b(String str, Class cls) throws Throwable {
        Class clsA;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            try {
                if (f57328a == null) {
                    clsA = a("org.apache.xml.security.utils.ClassLoaderUtils");
                    f57328a = clsA;
                } else {
                    clsA = f57328a;
                }
                if (clsA.getClassLoader() != null) {
                    Class clsA2 = f57328a;
                    if (clsA2 == null) {
                        clsA2 = a("org.apache.xml.security.utils.ClassLoaderUtils");
                        f57328a = clsA2;
                    }
                    return clsA2.getClassLoader().loadClass(str);
                }
            } catch (ClassNotFoundException unused) {
                if (cls != null && cls.getClassLoader() != null) {
                    return cls.getClassLoader().loadClass(str);
                }
            }
            throw e2;
        }
    }

    public static Class a(String str, Class cls) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.loadClass(str);
            }
        } catch (ClassNotFoundException unused) {
        }
        return b(str, cls);
    }
}
