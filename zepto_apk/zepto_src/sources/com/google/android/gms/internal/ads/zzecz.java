package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzecz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f29091a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdab f29092b;

    /* renamed from: c, reason: collision with root package name */
    public final zzeca f29093c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29094d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f29095e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f29096f;

    public zzecz(zzclp zzclpVar, zzdab zzdabVar, zzeca zzecaVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f29091a = zzclpVar;
        this.f29092b = zzdabVar;
        this.f29093c = zzecaVar;
        this.f29094d = zzijfVar;
        this.f29095e = zzijfVar2;
        this.f29096f = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f29091a.a();
        zzfik zzfikVarA = this.f29092b.a();
        zzeca zzecaVar = this.f29093c;
        zzgyw zzgywVar = zzcdo.f25983b;
        zzijo.a(zzgywVar);
        zzgyw zzgywVar2 = zzcdo.f25982a;
        zzijo.a(zzgywVar2);
        zzebz zzebzVar = new zzebz(zzgywVar, zzgywVar2, new zzedj((Context) zzecaVar.f29045a.f29064a.zzb(), zzgywVar2), zzijf.b(zzecaVar.f29046b));
        zzijo.a(zzgywVar2);
        return new zzecy(contextA, zzfikVarA, zzebzVar, zzgywVar2, (ScheduledExecutorService) this.f29094d.zzb(), (zzegr) this.f29095e.zzb(), (zzfno) this.f29096f.zzb());
    }
}
