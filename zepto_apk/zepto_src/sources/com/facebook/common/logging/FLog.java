package com.facebook.common.logging;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class FLog {

    /* renamed from: a, reason: collision with root package name */
    public static final FLogDefaultLoggingDelegate f17086a = FLogDefaultLoggingDelegate.f17087a;

    public static void a(String str, String str2) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(3)) {
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(3, str, str2);
        }
    }

    public static void b(String str, String str2, Integer num, Object obj, Object obj2) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(3)) {
            String str3 = String.format(null, str2, num, obj, obj2);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(3, str, str3);
        }
    }

    public static void c(String str, String str2, Object obj) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(3)) {
            String str3 = String.format(null, str2, obj);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(3, str, str3);
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(3)) {
            String str3 = String.format(null, str2, obj, obj2);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(3, str, str3);
        }
    }

    public static void e(Class cls, String str) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(6)) {
            String simpleName = cls.getSimpleName();
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(6, simpleName, str);
        }
    }

    public static void f(Class cls, String str, Throwable th) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(6)) {
            String simpleName = cls.getSimpleName();
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.c(6, simpleName, str, th);
        }
    }

    public static void g(String str, String str2) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(6)) {
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(6, str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(6)) {
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.c(6, str, str2, th);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(6)) {
            String str3 = String.format(null, str2, objArr);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(6, str, str3);
        }
    }

    public static void j(Class cls, String str, Integer num, Object obj) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(2)) {
            String simpleName = cls.getSimpleName();
            String str2 = String.format(null, str, num, obj);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(2, simpleName, str2);
        }
    }

    public static void k(Class cls, String str, Integer num, Object obj, Object obj2) {
        if (f17086a.a(2)) {
            String str2 = String.format(null, str, num, obj, obj2);
            if (f17086a.a(2)) {
                FLogDefaultLoggingDelegate.b(2, cls.getSimpleName(), str2);
            }
        }
    }

    public static void l(Class cls, String str, Object obj) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(2)) {
            String simpleName = cls.getSimpleName();
            String str2 = String.format(null, str, obj);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(2, simpleName, str2);
        }
    }

    public static void m(String str, Long l2, String str2, Object obj) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(2)) {
            String str3 = String.format(null, str, l2, str2, obj);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(2, "RequestLoggingListener", str3);
        }
    }

    public static void n(String str, String str2, Object... objArr) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(2)) {
            String str3 = String.format(null, str2, objArr);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(2, str, str3);
        }
    }

    public static void o(Class cls, String str) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(5)) {
            String simpleName = cls.getSimpleName();
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(5, simpleName, str);
        }
    }

    public static void p(Class cls, String str, Object... objArr) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(5)) {
            String simpleName = cls.getSimpleName();
            String str2 = String.format(null, str, objArr);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(5, simpleName, str2);
        }
    }

    public static void q(String str, String str2) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(5)) {
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(5, str, str2);
        }
    }

    public static void r(String str, String str2, Exception exc) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(5)) {
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.c(5, str, str2, exc);
        }
    }

    public static void s(String str, String str2, Object... objArr) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(5)) {
            String str3 = String.format(null, str2, objArr);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(5, str, str3);
        }
    }

    public static void t(String str, Throwable th, String str2, Object... objArr) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(5)) {
            String str3 = String.format(null, str2, objArr);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.c(5, str, str3, th);
        }
    }

    public static void u(String str, Object[] objArr, Exception exc) {
        if (f17086a.a(5)) {
            String str2 = String.format(null, str, objArr);
            if (f17086a.a(5)) {
                FLogDefaultLoggingDelegate.c(5, "BufferedDiskCache", str2, exc);
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = f17086a;
        if (fLogDefaultLoggingDelegate.a(6)) {
            String str3 = String.format(null, str2, objArr);
            fLogDefaultLoggingDelegate.getClass();
            FLogDefaultLoggingDelegate.b(6, str, str3);
        }
    }
}
