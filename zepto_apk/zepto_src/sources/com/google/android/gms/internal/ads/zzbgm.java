package com.google.android.gms.internal.ads;

import android.os.StrictMode;

/* loaded from: classes4.dex */
public final class zzbgm {
    public static Object a(zzgqs zzgqsVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzgqsVar.zza();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
