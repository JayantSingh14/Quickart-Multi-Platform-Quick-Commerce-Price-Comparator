package com.google.android.gms.ads.admanager;

import com.google.android.gms.internal.ads.zzbqi;
import com.google.android.gms.internal.ads.zzbxv;

/* loaded from: classes4.dex */
final /* synthetic */ class zzb implements Runnable {
    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        try {
            new zzbqi(null, null);
            throw null;
        } catch (IllegalStateException e2) {
            zzbxv.c(null).a("AdManagerInterstitialAd.load", e2);
        }
    }
}
