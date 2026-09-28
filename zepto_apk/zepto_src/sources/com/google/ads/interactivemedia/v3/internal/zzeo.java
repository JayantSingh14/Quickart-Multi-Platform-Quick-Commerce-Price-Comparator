package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* loaded from: classes3.dex */
public final class zzeo {
    public static void zza(String str) {
        if (zze(2)) {
            Log.e("IMASDK", str);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zze(2)) {
            Log.e("IMASDK", str, th);
        }
    }

    public static void zzc(String str) {
        if (zze(1)) {
            Log.i("IMASDK", str);
        }
    }

    public static void zzd(String str) {
        if (zze(2)) {
            Log.w("IMASDK", str);
        }
    }

    private static boolean zze(int i2) {
        return i2 + (-1) > 0;
    }
}
