package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdza extends zzcal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdzc f28812a;

    public zzdza(zzdzc zzdzcVar) {
        Objects.requireNonNull(zzdzcVar);
        this.f28812a = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdzc zzdzcVar = this.f28812a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        int i2 = zzeVar.f21161a;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdFailedToLoad";
        zzdyqVar.f28798d = Integer.valueOf(i2);
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zze() {
        zzdzc zzdzcVar = this.f28812a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdLoaded";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzf(int i2) {
        zzdzc zzdzcVar = this.f28812a;
        zzdyr zzdyrVar = zzdzcVar.f28815b;
        zzdyq zzdyqVar = new zzdyq("rewarded");
        zzdyqVar.f28795a = Long.valueOf(zzdzcVar.f28814a);
        zzdyqVar.f28797c = "onRewardedAdFailedToLoad";
        zzdyqVar.f28798d = Integer.valueOf(i2);
        zzdyrVar.b(zzdyqVar);
    }
}
