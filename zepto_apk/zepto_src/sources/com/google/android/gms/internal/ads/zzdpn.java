package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdpn implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdoe f28179a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdml f28180b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28181c;

    public zzdpn(zzdoe zzdoeVar, zzdml zzdmlVar, zzijf zzijfVar) {
        this.f28179a = zzdoeVar;
        this.f28180b = zzdmlVar;
        this.f28181c = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdnm zzdnmVarA = this.f28179a.a();
        zzdnq zzdnqVar = (zzdnq) this.f28180b.f27969a.zzb();
        zzijo.a(zzdnqVar);
        Executor executor = (Executor) this.f28181c.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzdpm(zzdnmVarA, zzdnqVar, executor, zzgywVar);
    }
}
