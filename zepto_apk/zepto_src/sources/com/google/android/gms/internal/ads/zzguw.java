package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzguw {
    public static void a(int i2, Object[] objArr) {
        for (int i3 = 0; i3 < i2; i3++) {
            b(i3, objArr[i3]);
        }
    }

    public static void b(int i2, Object obj) {
        if (obj == null) {
            throw new NullPointerException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 9), i2, "at index "));
        }
    }
}
