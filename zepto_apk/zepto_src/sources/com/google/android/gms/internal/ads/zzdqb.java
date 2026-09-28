package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzdqb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijp f28223a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28224b;

    public zzdqb(zzijp zzijpVar, zzijf zzijfVar) {
        this.f28223a = zzijpVar;
        this.f28224b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        com.google.android.gms.ads.internal.util.zzbl zzblVar = (com.google.android.gms.ads.internal.util.zzbl) this.f28223a.zzb();
        Clock clock = (Clock) this.f28224b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzdqa(zzblVar, clock, zzgywVar);
    }
}
