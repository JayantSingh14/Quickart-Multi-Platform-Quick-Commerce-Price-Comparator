package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfat implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclj f30772a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f30773b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30774c;

    /* renamed from: d, reason: collision with root package name */
    public final zzejf f30775d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdab f30776e;

    /* renamed from: f, reason: collision with root package name */
    public final zzcmg f30777f;

    public zzfat(zzclj zzcljVar, zzclp zzclpVar, zzijf zzijfVar, zzejf zzejfVar, zzdab zzdabVar, zzcmg zzcmgVar) {
        this.f30772a = zzcljVar;
        this.f30773b = zzclpVar;
        this.f30774c = zzijfVar;
        this.f30775d = zzejfVar;
        this.f30776e = zzdabVar;
        this.f30777f = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        com.google.android.gms.ads.internal.util.zzj zzjVarZzb = this.f30772a.zzb();
        Context contextA = this.f30773b.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzfar(zzjVarZzb, contextA, zzgywVar, (ScheduledExecutorService) this.f30774c.zzb(), new zzeje(this.f30775d.f29459a.a()), this.f30776e.a(), this.f30777f.a());
    }
}
