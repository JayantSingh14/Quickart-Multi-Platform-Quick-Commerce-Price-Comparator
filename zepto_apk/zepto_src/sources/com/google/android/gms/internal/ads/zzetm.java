package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzetm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f30284a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30285b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30286c;

    public zzetm(zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30284a = zzclpVar;
        this.f30285b = zzijfVar;
        this.f30286c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f30284a.a();
        zzcda zzcdaVar = (zzcda) this.f30285b.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f30286c.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzetk(contextA, zzcdaVar, scheduledExecutorService, zzgywVar);
    }
}
