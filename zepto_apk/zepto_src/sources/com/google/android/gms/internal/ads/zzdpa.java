package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdpa implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28148a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdmn f28149b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28150c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdmm f28151d;

    public zzdpa(zzijf zzijfVar, zzdmn zzdmnVar, zzijf zzijfVar2, zzdmm zzdmmVar) {
        this.f28148a = zzijfVar;
        this.f28149b = zzdmnVar;
        this.f28150c = zzijfVar2;
        this.f28151d = zzdmmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdua zzduaVar = (zzdua) this.f28148a.zzb();
        zzdsp zzdspVar = this.f28149b.f27971a.f27964b;
        zzijo.a(zzdspVar);
        zzcsh zzcshVar = (zzcsh) this.f28150c.zzb();
        zzdmg zzdmgVar = (zzdmg) this.f28151d.f27970a.zzb();
        zzijo.a(zzdmgVar);
        return new zzdoz(zzduaVar, zzdspVar, zzcshVar, zzdmgVar);
    }
}
