package com.google.ads.interactivemedia.v3.internal;

import android.os.StrictMode;

/* loaded from: classes3.dex */
public final class zzlh {
    public static Object zza(zzph zzphVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzphVar.zza();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
