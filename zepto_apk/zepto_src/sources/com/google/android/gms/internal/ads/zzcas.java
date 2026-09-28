package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* loaded from: classes4.dex */
public final class zzcas extends zzcal {

    /* renamed from: a, reason: collision with root package name */
    public final RewardedAdLoadCallback f25793a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcao f25794b;

    public zzcas(RewardedAdLoadCallback rewardedAdLoadCallback, zzcao zzcaoVar) {
        this.f25793a = rewardedAdLoadCallback;
        this.f25794b = zzcaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f25793a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.a(zzeVar.r());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zze() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f25793a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.b(this.f25794b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzf(int i2) {
    }
}
