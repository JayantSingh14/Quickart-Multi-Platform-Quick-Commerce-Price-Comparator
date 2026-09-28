package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzczp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27499a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f27500b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27501c;

    /* renamed from: d, reason: collision with root package name */
    public final zzecm f27502d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f27503e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f27504f;

    /* renamed from: g, reason: collision with root package name */
    public final zzclj f27505g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f27506h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfab f27507i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdab f27508j;

    /* renamed from: k, reason: collision with root package name */
    public final zzijf f27509k;

    /* renamed from: l, reason: collision with root package name */
    public final zzijf f27510l;

    public zzczp(zzijf zzijfVar, zzcmg zzcmgVar, zzijf zzijfVar2, zzecm zzecmVar, zzijf zzijfVar3, zzijf zzijfVar4, zzclj zzcljVar, zzijf zzijfVar5, zzfab zzfabVar, zzdab zzdabVar, zzijf zzijfVar6, zzijf zzijfVar7) {
        this.f27499a = zzijfVar;
        this.f27500b = zzcmgVar;
        this.f27501c = zzijfVar2;
        this.f27502d = zzecmVar;
        this.f27503e = zzijfVar3;
        this.f27504f = zzijfVar4;
        this.f27505g = zzcljVar;
        this.f27506h = zzijfVar5;
        this.f27507i = zzfabVar;
        this.f27508j = zzdabVar;
        this.f27509k = zzijfVar6;
        this.f27510l = zzijfVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzczo zzb() {
        zzfmu zzfmuVar = (zzfmu) this.f27499a.zzb();
        VersionInfoParcel versionInfoParcelA = this.f27500b.a();
        ApplicationInfo applicationInfo = (ApplicationInfo) this.f27501c.zzb();
        String packageName = this.f27502d.f29063a.a().getPackageName();
        zzijo.a(packageName);
        zzbgb zzbgbVar = zzbgk.f25011a;
        return new zzczo(zzfmuVar, versionInfoParcelA, applicationInfo, packageName, com.google.android.gms.ads.internal.client.zzbd.f21150e.f21151a.a(), (PackageInfo) this.f27503e.zzb(), zzijf.b(this.f27504f), this.f27505g.zzb(), (String) this.f27506h.zzb(), this.f27507i.zzb(), this.f27508j.a(), (zzdgd) this.f27509k.zzb(), ((Integer) this.f27510l.zzb()).intValue());
    }
}
