package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfpw extends zzbef {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgzf f31604a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzft f31605b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfpx f31606c;

    public zzfpw(zzfpx zzfpxVar, zzgzf zzgzfVar, com.google.android.gms.ads.internal.client.zzft zzftVar) {
        this.f31604a = zzgzfVar;
        this.f31605b = zzftVar;
        Objects.requireNonNull(zzfpxVar);
        this.f31606c = zzfpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void gb(zzbed zzbedVar) {
        Objects.requireNonNull(this.f31606c);
        this.f31604a.c(zzbedVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void l(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void t0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.r().toString();
        String str = this.f31605b.f21239a;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 60 + String.valueOf(str).length());
        sb.append("Failed to load app open ad with error parcel: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        zzfpx zzfpxVar = this.f31606c;
        Objects.requireNonNull(zzfpxVar);
        zzfpxVar.a(zzeVar);
    }
}
