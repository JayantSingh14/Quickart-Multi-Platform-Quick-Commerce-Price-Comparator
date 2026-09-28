package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeuh f30442a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30443b;

    public zzevu(zzeuh zzeuhVar, zzijf zzijfVar) {
        this.f30442a = zzeuhVar;
        this.f30443b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(new zzeug((zzfer) this.f30442a.f30344a.f34899a), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.td)).intValue(), (ScheduledExecutorService) this.f30443b.zzb());
    }
}
