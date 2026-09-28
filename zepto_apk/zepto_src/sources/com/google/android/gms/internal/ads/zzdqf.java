package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzdqf {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f28243a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdqu f28244b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdqz f28245c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdwy f28246d;

    public zzdqf(zzgyw zzgywVar, zzdqu zzdquVar, zzdqz zzdqzVar, zzdwy zzdwyVar) {
        this.f28243a = zzgywVar;
        this.f28244b = zzdquVar;
        this.f28245c = zzdqzVar;
        this.f28246d = zzdwyVar;
    }

    public final void a(ListenableFuture listenableFuture, zzdwm zzdwmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.G2)).booleanValue()) {
            zzdqc zzdqcVar = new zzdqc(this, zzdwmVar);
            listenableFuture.q(new zzgyk(listenableFuture, zzdqcVar), this.f28243a);
        }
    }
}
