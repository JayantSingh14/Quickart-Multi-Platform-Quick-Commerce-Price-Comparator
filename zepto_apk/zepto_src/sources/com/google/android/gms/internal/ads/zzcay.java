package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* loaded from: classes4.dex */
public final class zzcay extends zzcal {

    /* renamed from: a, reason: collision with root package name */
    public final RewardedInterstitialAdLoadCallback f25800a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcaz f25801b;

    public zzcay(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcaz zzcazVar) {
        this.f25800a = rewardedInterstitialAdLoadCallback;
        this.f25801b = zzcazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.f25800a;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.a(zzeVar.r());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zze() {
        zzcaz zzcazVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.f25800a;
        if (rewardedInterstitialAdLoadCallback == null || (zzcazVar = this.f25801b) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.b(zzcazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzf(int i2) {
    }
}
