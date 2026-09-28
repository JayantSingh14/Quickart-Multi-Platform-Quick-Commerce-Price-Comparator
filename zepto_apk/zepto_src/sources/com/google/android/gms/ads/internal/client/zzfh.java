package com.google.android.gms.ads.internal.client;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfh extends zzbp {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfi f21231a;

    public /* synthetic */ zzfh(zzfi zzfiVar) {
        Objects.requireNonNull(zzfiVar);
        this.f21231a = zzfiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void P7(zzm zzmVar, int i2) {
        com.google.android.gms.ads.internal.util.client.zzo.c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzfg(this));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void U0(zzm zzmVar) {
        P7(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final boolean zzg() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final String zzh() {
        return null;
    }
}
