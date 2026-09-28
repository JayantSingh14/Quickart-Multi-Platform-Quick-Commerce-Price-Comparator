package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzijf;
import com.google.android.gms.internal.ads.zzijg;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f21882a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f21883b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f21884c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f21885d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f21886e;

    public zzc(zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f21882a = zzclpVar;
        this.f21883b = zzijfVar;
        this.f21884c = zzijfVar2;
        this.f21885d = zzijfVar3;
        this.f21886e = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzb(this.f21882a.a(), ((Long) this.f21883b.zzb()).longValue(), (PackageInfo) this.f21884c.zzb(), (zzd) this.f21885d.zzb(), (ScheduledExecutorService) this.f21886e.zzb());
    }
}
