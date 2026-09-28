package com.google.android.gms.internal.common;

import androidx.fragment.app.e;

/* loaded from: classes4.dex */
public final class zzai {
    public static void a(int i2, Object[] objArr) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (objArr[i3] == null) {
                throw new NullPointerException(e.r(new StringBuilder(String.valueOf(i3).length() + 9), i3, "at index "));
            }
        }
    }
}
