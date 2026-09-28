package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdzb extends zzcah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdzc f28813a;

    public zzdzb(zzdzc zzdzcVar) {
        Objects.requireNonNull(zzdzcVar);
        this.f28813a = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void L5(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        int i2 = zzeVar.f21161a;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdFailedToShow";
        zzdyqVar.f28798d = Integer.valueOf(i2);
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void e7(zzcac zzcacVar) {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onUserEarnedReward";
        zzdyqVar.f28799e = zzcacVar.zze();
        zzdyqVar.f28800f = Integer.valueOf(zzcacVar.zzf());
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zze() {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdOpened";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzf() {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdClosed";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzh(int i2) {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdFailedToShow";
        zzdyqVar.f28798d = Integer.valueOf(i2);
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzj() {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onAdImpression";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzk() {
        zzdzc zzdzcVar = this.f28813a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onAdClicked";
        zzdyrVar.b(zzdyqVar);
    }
}
