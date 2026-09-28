package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzbhq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f25087a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f25088b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f25089c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f25090d;

    public zzbhq(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f25087a = zzijfVar;
        this.f25088b = zzijfVar2;
        this.f25089c = zzijfVar3;
        this.f25090d = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbhp zzb() {
        return new zzbhp((ScheduledExecutorService) this.f25087a.zzb(), (com.google.android.gms.ads.nonagon.signalgeneration.zzo) this.f25088b.zzb(), (com.google.android.gms.ads.nonagon.signalgeneration.zzf) this.f25089c.zzb(), (zzdxj) this.f25090d.zzb());
    }
}
