package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzecu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29077a;

    /* renamed from: b, reason: collision with root package name */
    public final zzedt f29078b;

    /* renamed from: c, reason: collision with root package name */
    public final zzefx f29079c;

    public zzecu(zzijf zzijfVar, zzedt zzedtVar, zzefx zzefxVar) {
        this.f29077a = zzijfVar;
        this.f29078b = zzedtVar;
        this.f29079c = zzefxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzect zzb() {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f29077a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzgyw zzgywVar2 = zzcdo.f25983b;
        zzijo.a(zzgywVar2);
        Context contextA = this.f29078b.f29157a.a();
        zzijo.a(zzgywVar);
        return new zzect(scheduledExecutorService, zzgywVar, zzgywVar2, new zzeds(contextA, zzgywVar), zzijf.b(this.f29079c));
    }
}
