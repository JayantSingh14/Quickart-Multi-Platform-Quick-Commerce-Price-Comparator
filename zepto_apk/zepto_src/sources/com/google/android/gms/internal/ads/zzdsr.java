package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdsr implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f28469a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28470b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28471c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcmg f28472d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f28473e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f28474f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f28475g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f28476h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f28477i;

    public zzdsr(zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2, zzcmg zzcmgVar, zzcoe zzcoeVar, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6, zzijf zzijfVar7) {
        this.f28469a = zzclpVar;
        this.f28470b = zzijfVar;
        this.f28471c = zzijfVar2;
        this.f28472d = zzcmgVar;
        this.f28473e = zzijfVar3;
        this.f28474f = zzijfVar4;
        this.f28475g = zzijfVar5;
        this.f28476h = zzijfVar6;
        this.f28477i = zzijfVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f28469a.a();
        Executor executor = (Executor) this.f28470b.zzb();
        zzayq zzayqVar = (zzayq) this.f28471c.zzb();
        VersionInfoParcel versionInfoParcelA = this.f28472d.a();
        com.google.android.gms.ads.internal.zza zzaVarA = zzcoe.a();
        new zzcjh();
        return new zzdsn(contextA, executor, zzayqVar, versionInfoParcelA, zzaVarA, (zzehu) this.f28473e.zzb(), (zzfpi) this.f28474f.zzb(), (zzdxe) this.f28475g.zzb(), (zzeif) this.f28476h.zzb(), (zzfio) this.f28477i.zzb());
    }
}
