package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewe implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzexv f30464a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30465b;

    public zzewe(zzexv zzexvVar, zzijf zzijfVar) {
        this.f30464a = zzexvVar;
        this.f30465b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(new zzext((zzfhq) this.f30464a.f30546a.zzb()), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gd)).intValue(), (ScheduledExecutorService) this.f30465b.zzb());
    }
}
