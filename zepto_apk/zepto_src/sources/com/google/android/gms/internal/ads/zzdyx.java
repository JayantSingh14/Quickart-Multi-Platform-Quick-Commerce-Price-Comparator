package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzdyx extends com.google.android.gms.ads.internal.client.zzbj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdyr f28808a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdyy f28809b;

    public zzdyx(zzdyy zzdyyVar, zzdyr zzdyrVar) {
        this.f28808a = zzdyrVar;
        Objects.requireNonNull(zzdyyVar);
        this.f28809b = zzdyyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void l(int i2) {
        long j2 = this.f28809b.f28810a;
        zzdyr zzdyrVar = this.f28808a;
        zzdyq zzdyqVar = new zzdyq("interstitial");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "onAdFailedToLoad";
        zzdyqVar.f28798d = Integer.valueOf(i2);
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void t0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        long j2 = this.f28809b.f28810a;
        int i2 = zzeVar.f21161a;
        zzdyr zzdyrVar = this.f28808a;
        zzdyq zzdyqVar = new zzdyq("interstitial");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "onAdFailedToLoad";
        zzdyqVar.f28798d = Integer.valueOf(i2);
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() {
        long j2 = this.f28809b.f28810a;
        zzdyr zzdyrVar = this.f28808a;
        zzdyq zzdyqVar = new zzdyq("interstitial");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "onAdClosed";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf() {
        long j2 = this.f28809b.f28810a;
        zzdyr zzdyrVar = this.f28808a;
        zzdyq zzdyqVar = new zzdyq("interstitial");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "onAdLoaded";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() {
        long j2 = this.f28809b.f28810a;
        zzdyr zzdyrVar = this.f28808a;
        zzdyq zzdyqVar = new zzdyq("interstitial");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "onAdOpened";
        zzdyrVar.b(zzdyqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() throws JSONException {
        long j2 = this.f28809b.f28810a;
        zzdyr zzdyrVar = this.f28808a;
        zzdyq zzdyqVar = new zzdyq("interstitial");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "onAdClicked";
        zzdyrVar.f28801a.b(zzdyqVar.a());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() {
    }
}
