package com.google.android.gms.internal.common;

import androidx.fragment.app.e;

/* loaded from: classes4.dex */
public final class zzr {
    public static void a(int i2, int i3) {
        String strA;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                strA = zzx.a("%s (%s) must not be negative", "index", Integer.valueOf(i2));
            } else {
                if (i3 < 0) {
                    throw new IllegalArgumentException(e.r(new StringBuilder(String.valueOf(i3).length() + 15), i3, "negative size: "));
                }
                strA = zzx.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void b(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(d(i2, i3, "index"));
        }
    }

    public static void c(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? d(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? d(i3, i4, "end index") : zzx.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static String d(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzx.a("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return zzx.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(e.r(new StringBuilder(String.valueOf(i3).length() + 15), i3, "negative size: "));
    }
}
