package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzqv {
    public static Object zza(@CheckForNull Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(b.f(i2, "at index "));
    }

    public static Object[] zzb(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            zza(objArr[i3], i3);
        }
        return objArr;
    }
}
