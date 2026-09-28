package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzpm {
    public static int zza(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    public static void zzb(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 == null) {
            throw new NullPointerException(b.D("null value in entry: ", obj.toString(), "=null"));
        }
    }
}
