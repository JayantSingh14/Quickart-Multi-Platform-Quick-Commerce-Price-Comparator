package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdmh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27950a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdlt f27951b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdmk f27952c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdmn f27953d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdoe f27954e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f27955f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f27956g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f27957h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f27958i;

    /* renamed from: j, reason: collision with root package name */
    public final zzcwb f27959j;

    /* renamed from: k, reason: collision with root package name */
    public final zzcmg f27960k;

    /* renamed from: l, reason: collision with root package name */
    public final zzdab f27961l;

    /* renamed from: m, reason: collision with root package name */
    public final zzijf f27962m;
    public final zzijf n;
    public final zzijf o;
    public final zzijf p;
    public final zzijf q;
    public final zzijf r;
    public final zzijf s;
    public final zzijf t;
    public final zzijf u;
    public final zzijf v;
    public final zzijf w;
    public final zzijf x;
    public final zzijf y;

    public zzdmh(zzijf zzijfVar, zzdlt zzdltVar, zzdmk zzdmkVar, zzdmn zzdmnVar, zzdoe zzdoeVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5, zzcwb zzcwbVar, zzcmg zzcmgVar, zzdab zzdabVar, zzijf zzijfVar6, zzijf zzijfVar7, zzijf zzijfVar8, zzijf zzijfVar9, zzijf zzijfVar10, zzijf zzijfVar11, zzijf zzijfVar12, zzijf zzijfVar13, zzijf zzijfVar14, zzijf zzijfVar15, zzijf zzijfVar16, zzijf zzijfVar17, zzijf zzijfVar18) {
        this.f27950a = zzijfVar;
        this.f27951b = zzdltVar;
        this.f27952c = zzdmkVar;
        this.f27953d = zzdmnVar;
        this.f27954e = zzdoeVar;
        this.f27955f = zzijfVar2;
        this.f27956g = zzijfVar3;
        this.f27957h = zzijfVar4;
        this.f27958i = zzijfVar5;
        this.f27959j = zzcwbVar;
        this.f27960k = zzcmgVar;
        this.f27961l = zzdabVar;
        this.f27962m = zzijfVar6;
        this.n = zzijfVar7;
        this.o = zzijfVar8;
        this.p = zzijfVar9;
        this.q = zzijfVar10;
        this.r = zzijfVar11;
        this.s = zzijfVar12;
        this.t = zzijfVar13;
        this.u = zzijfVar14;
        this.v = zzijfVar15;
        this.w = zzijfVar16;
        this.x = zzijfVar17;
        this.y = zzijfVar18;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f27950a.zzb();
        zzdnw zzdnwVar = this.f27951b.f27913a.f27909a;
        zzijo.a(zzdnwVar);
        JSONObject jSONObject = this.f27952c.f27968a.f27963a;
        zzijo.a(jSONObject);
        zzdsp zzdspVar = this.f27953d.f27971a.f27964b;
        zzijo.a(zzdspVar);
        zzdnm zzdnmVarA = this.f27954e.a();
        zzayq zzayqVar = (zzayq) this.f27955f.zzb();
        zzdbc zzdbcVar = (zzdbc) this.f27956g.zzb();
        zzdai zzdaiVar = (zzdai) this.f27957h.zzb();
        zzdip zzdipVar = (zzdip) this.f27958i.zzb();
        zzfhr zzfhrVarA = this.f27959j.a();
        VersionInfoParcel versionInfoParcelA = this.f27960k.a();
        zzfik zzfikVarA = this.f27961l.a();
        zzcrx zzcrxVar = (zzcrx) this.f27962m.zzb();
        zzdor zzdorVar = (zzdor) this.n.zzb();
        Clock clock = (Clock) this.o.zzb();
        zzdil zzdilVar = (zzdil) this.p.zzb();
        zzfpi zzfpiVar = (zzfpi) this.q.zzb();
        zzfno zzfnoVar = (zzfno) this.r.zzb();
        zzeif zzeifVar = (zzeif) this.s.zzb();
        zzduf zzdufVar = (zzduf) this.t.zzb();
        zzdon zzdonVar = (zzdon) this.u.zzb();
        zzdcz zzdczVar = (zzdcz) this.v.zzb();
        com.google.android.gms.ads.internal.zzb zzbVar = (com.google.android.gms.ads.internal.zzb) this.w.zzb();
        return new zzdmg(context, zzdnwVar, jSONObject, zzdspVar, zzdnmVarA, zzayqVar, zzdbcVar, zzdaiVar, zzdipVar, zzfhrVarA, versionInfoParcelA, zzfikVarA, zzcrxVar, zzdorVar, clock, zzdilVar, zzfpiVar, zzfnoVar, zzeifVar, zzdufVar, zzdonVar, zzdczVar, zzbVar, (zzcze) this.y.zzb());
    }
}
