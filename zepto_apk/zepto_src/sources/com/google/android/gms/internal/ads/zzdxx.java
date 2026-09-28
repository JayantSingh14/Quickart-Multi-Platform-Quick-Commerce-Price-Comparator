package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdxx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28775a;

    public zzdxx(zzdxt zzdxtVar, zzijf zzijfVar) {
        this.f28775a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdyd zzdydVar = (zzdyd) this.f28775a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        Set setA = zzdxt.a(zzdydVar, zzgywVar);
        zzijo.a(setA);
        return setA;
    }
}
