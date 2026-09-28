package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdom implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclj f28110a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdab f28111b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijp f28112c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdoe f28113d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijg f28114e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijg f28115f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f28116g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f28117h;

    public zzdom(zzclj zzcljVar, zzdab zzdabVar, zzijp zzijpVar, zzdoe zzdoeVar, zzijg zzijgVar, zzijg zzijgVar2, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f28110a = zzcljVar;
        this.f28111b = zzdabVar;
        this.f28112c = zzijpVar;
        this.f28113d = zzdoeVar;
        this.f28114e = zzijgVar;
        this.f28115f = zzijgVar2;
        this.f28116g = zzijfVar;
        this.f28117h = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzdol zzb() {
        com.google.android.gms.ads.internal.util.zzj zzjVarZzb = this.f28110a.zzb();
        zzfik zzfikVarA = this.f28111b.a();
        zzdnr zzdnrVar = (zzdnr) this.f28112c.zzb();
        zzdnm zzdnmVarA = this.f28113d.a();
        zzdoz zzdozVar = (zzdoz) this.f28114e.zzb();
        zzdph zzdphVar = (zzdph) this.f28115f.zzb();
        Executor executor = (Executor) this.f28116g.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzdol(zzjVarZzb, zzfikVarA, zzdnrVar, zzdnmVarA, zzdozVar, zzdphVar, executor, zzgywVar, (zzdnj) this.f28117h.zzb());
    }
}
