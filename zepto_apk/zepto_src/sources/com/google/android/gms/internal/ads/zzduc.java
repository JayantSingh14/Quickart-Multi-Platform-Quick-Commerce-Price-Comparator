package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzduc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28579a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28580b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28581c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcmg f28582d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcoe f28583e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f28584f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijg f28585g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f28586h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f28587i;

    /* renamed from: j, reason: collision with root package name */
    public final zzijf f28588j;

    /* renamed from: k, reason: collision with root package name */
    public final zzijf f28589k;

    public zzduc(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzcmg zzcmgVar, zzcoe zzcoeVar, zzijf zzijfVar4, zzijg zzijgVar, zzijf zzijfVar5, zzijf zzijfVar6, zzijf zzijfVar7, zzijf zzijfVar8) {
        this.f28579a = zzijfVar;
        this.f28580b = zzijfVar2;
        this.f28581c = zzijfVar3;
        this.f28582d = zzcmgVar;
        this.f28583e = zzcoeVar;
        this.f28584f = zzijfVar4;
        this.f28585g = zzijgVar;
        this.f28586h = zzijfVar5;
        this.f28587i = zzijfVar6;
        this.f28588j = zzijfVar7;
        this.f28589k = zzijfVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        new zzcjh();
        Context context = (Context) this.f28579a.zzb();
        zzayq zzayqVar = (zzayq) this.f28580b.zzb();
        zzbhr zzbhrVar = (zzbhr) this.f28581c.zzb();
        VersionInfoParcel versionInfoParcelA = this.f28582d.a();
        zzcod zzcodVar = this.f28583e.f26811a;
        return new zzdua(context, zzayqVar, zzbhrVar, versionInfoParcelA, zzcoe.a(), (zzbfj) this.f28584f.zzb(), (zzddl) this.f28585g.zzb(), (zzeif) this.f28586h.zzb(), (zzfio) this.f28587i.zzb(), (zzdxe) this.f28588j.zzb(), (zzckq) this.f28589k.zzb());
    }
}
