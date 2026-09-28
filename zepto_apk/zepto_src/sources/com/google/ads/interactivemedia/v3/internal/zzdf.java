package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzdf implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (zzdi.zzc != null) {
            zzdi.zzc.post(zzdi.zzd);
            zzdi.zzc.postDelayed(zzdi.zze, 200L);
        }
    }
}
