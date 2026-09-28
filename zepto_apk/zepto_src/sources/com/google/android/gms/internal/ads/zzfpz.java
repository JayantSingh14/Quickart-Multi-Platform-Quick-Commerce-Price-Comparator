package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfpz extends com.google.android.gms.ads.internal.client.zzbm {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgzf f31615a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzeqx f31616b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfqa f31617c;

    public zzfpz(zzfqa zzfqaVar, zzgzf zzgzfVar, zzeqx zzeqxVar) {
        this.f31615a = zzgzfVar;
        this.f31616b = zzeqxVar;
        Objects.requireNonNull(zzfqaVar);
        this.f31617c = zzfqaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void k1(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.r().toString();
        zzfqa zzfqaVar = this.f31617c;
        String str = zzfqaVar.f31671e.f21239a;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 57 + String.valueOf(str).length());
        sb.append("Failed to load interstitial ad with error: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        zzfqaVar.a(zzeVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb() {
        Objects.requireNonNull(this.f31617c);
        this.f31615a.c(this.f31616b);
    }
}
