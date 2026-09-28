package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfqe implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f31623a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f31624b;

    public zzfqe(zzclp zzclpVar, zzijf zzijfVar) {
        this.f31623a = zzijfVar;
        this.f31624b = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzfqd zzb() {
        zzdxe zzdxeVar = (zzdxe) this.f31623a.zzb();
        this.f31624b.a();
        return new zzfqd(zzdxeVar);
    }
}
