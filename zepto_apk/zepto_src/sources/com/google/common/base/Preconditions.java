package com.google.common.base;

import android.support.v4.media.b;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public final class Preconditions {
    public static String a(int i2, int i3, String str) {
        if (i2 < 0) {
            return Strings.a("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return Strings.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(b.f(i3, "negative size: "));
    }

    public static void b(int i2, int i3, String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(Strings.a(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void c(long j2, String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(Strings.a(str, Long.valueOf(j2)));
        }
    }

    public static void d(Object obj, Object obj2, String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(Strings.a(str, obj, obj2));
        }
    }

    public static void e(String str, int i2, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(Strings.a(str, Integer.valueOf(i2)));
        }
    }

    public static void f(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void g(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void h(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.a(str, obj));
        }
    }

    public static void i(int i2, int i3) {
        String strA;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                strA = Strings.a("%s (%s) must not be negative", "index", Integer.valueOf(i2));
            } else {
                if (i3 < 0) {
                    throw new IllegalArgumentException(b.f(i3, "negative size: "));
                }
                strA = Strings.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void k(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(a(i2, i3, "index"));
        }
    }

    public static void l(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? a(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? a(i3, i4, "end index") : Strings.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static void m(String str, boolean z) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void n(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void o(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.a(str, obj));
        }
    }
}
