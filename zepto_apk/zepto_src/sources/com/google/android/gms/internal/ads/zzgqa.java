package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgqa {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(String str, int i2, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(zzgqr.b(str, Integer.valueOf(i2)));
        }
    }

    public static void d(long j2, String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(zzgqr.b(str, Long.valueOf(j2)));
        }
    }

    public static void e(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(zzgqr.b(str, obj));
        }
    }

    public static void f(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void g(String str, boolean z) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void i(int i2, int i3) {
        String strB;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                strB = zzgqr.b("%s (%s) must not be negative", "index", Integer.valueOf(i2));
            } else {
                if (i3 < 0) {
                    throw new IllegalArgumentException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 15), i3, "negative size: "));
                }
                strB = zzgqr.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strB);
        }
    }

    public static void j(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(l(i2, i3, "index"));
        }
    }

    public static void k(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? l(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? l(i3, i4, "end index") : zzgqr.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static String l(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzgqr.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return zzgqr.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 15), i3, "negative size: "));
    }
}
