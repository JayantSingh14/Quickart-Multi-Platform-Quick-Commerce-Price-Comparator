package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfay implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f30789a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30790b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfce f30791c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfcf f30792d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfcg f30793e;

    public zzfay(zzclp zzclpVar, zzijf zzijfVar, zzfce zzfceVar, zzfcf zzfcfVar, zzfcg zzfcgVar) {
        this.f30789a = zzclpVar;
        this.f30790b = zzijfVar;
        this.f30791c = zzfceVar;
        this.f30792d = zzfcfVar;
        this.f30793e = zzfcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzccs zzccsVar = new zzccs();
        Context contextA = this.f30789a.a();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30790b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzfcc zzfccVar = this.f30791c.f30835a;
        return new zzfaw(zzccsVar, contextA, scheduledExecutorService, zzgywVar, zzfccVar.f30833b, this.f30792d.f30836a.f30832a.f25731l, this.f30793e.f30837a.f30832a.f25730k);
    }
}
