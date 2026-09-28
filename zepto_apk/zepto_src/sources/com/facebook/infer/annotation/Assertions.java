package com.facebook.infer.annotation;

/* loaded from: classes.dex */
public class Assertions {
    public static void a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static void b(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static void c(Object obj) {
        if (obj == null) {
            throw new AssertionError();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw new AssertionError(str);
        }
    }
}
