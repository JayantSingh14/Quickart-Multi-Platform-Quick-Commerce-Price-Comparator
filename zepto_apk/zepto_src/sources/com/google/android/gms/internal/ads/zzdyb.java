package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdyb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28779a;

    public zzdyb(zzijf zzijfVar) {
        this.f28779a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdyd zzdydVar = (zzdyd) this.f28779a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        Set setA = zzdxt.a(zzdydVar, zzgywVar);
        zzijo.a(setA);
        return setA;
    }
}
