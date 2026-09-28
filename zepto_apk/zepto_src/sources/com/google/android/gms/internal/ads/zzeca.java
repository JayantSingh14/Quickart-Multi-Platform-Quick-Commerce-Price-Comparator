package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzeca implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzecn f29045a;

    /* renamed from: b, reason: collision with root package name */
    public final zzefx f29046b;

    public zzeca(zzecn zzecnVar, zzefx zzefxVar) {
        this.f29045a = zzecnVar;
        this.f29046b = zzefxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25983b;
        zzijo.a(zzgywVar);
        zzgyw zzgywVar2 = zzcdo.f25982a;
        zzijo.a(zzgywVar2);
        return new zzebz(zzgywVar, zzgywVar2, new zzedj((Context) this.f29045a.f29064a.zzb(), zzgywVar2), zzijf.b(this.f29046b));
    }
}
