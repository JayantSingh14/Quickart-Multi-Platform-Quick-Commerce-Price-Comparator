package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewl implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzezu f30481a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30482b;

    public zzewl(zzezu zzezuVar, zzijf zzijfVar) {
        this.f30481a = zzezuVar;
        this.f30482b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzezu zzezuVar = this.f30481a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzezt(zzezuVar.f30694a.a(), zzgywVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.id)).intValue(), (ScheduledExecutorService) this.f30482b.zzb());
    }
}
