package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzedh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f29128a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f29129b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcmg f29130c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdab f29131d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijg f29132e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f29133f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f29134g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f29135h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f29136i;

    /* renamed from: j, reason: collision with root package name */
    public final zzddp f29137j;

    public zzedh(zzijh zzijhVar, zzclp zzclpVar, zzcmg zzcmgVar, zzdab zzdabVar, zzijg zzijgVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzddp zzddpVar) {
        this.f29128a = zzijhVar;
        this.f29129b = zzclpVar;
        this.f29130c = zzcmgVar;
        this.f29131d = zzdabVar;
        this.f29132e = zzijgVar;
        this.f29133f = zzijfVar;
        this.f29134g = zzijfVar2;
        this.f29135h = zzijfVar3;
        this.f29136i = zzijfVar4;
        this.f29137j = zzddpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzedg zzb() {
        zzclg zzclgVar = (zzclg) this.f29128a.f34899a;
        Context contextA = this.f29129b.a();
        VersionInfoParcel versionInfoParcelA = this.f29130c.a();
        zzfik zzfikVarA = this.f29131d.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        String str = (String) this.f29132e.zzb();
        zzfno zzfnoVar = (zzfno) this.f29133f.zzb();
        zzdwy zzdwyVar = (zzdwy) this.f29134g.zzb();
        zzbzi zzbziVar = new zzbzi();
        new zzegb();
        return new zzedg(zzclgVar, contextA, versionInfoParcelA, zzfikVarA, zzgywVar, str, zzfnoVar, zzdwyVar, zzbziVar, (ScheduledExecutorService) this.f29135h.zzb(), (zzfpi) this.f29136i.zzb(), new zzddo(this.f29137j.f27647a.zzb()));
    }
}
