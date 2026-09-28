package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcvu implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgyj f27245a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcvz f27246b;

    public zzcvu(zzcvz zzcvzVar, zzgyj zzgyjVar) {
        this.f27245a = zzgyjVar;
        Objects.requireNonNull(zzcvzVar);
        this.f27246b = zzcvzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzcvz zzcvzVar = this.f27246b;
        zzcvzVar.getClass();
        ((zzcdn) zzcdo.f25987f).execute(new zzcvx(zzcvzVar));
        ((zzerj) this.f27245a).zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        zzcvz zzcvzVar = this.f27246b;
        zzcvzVar.getClass();
        ((zzcdn) zzcdo.f25987f).execute(new zzcvx(zzcvzVar));
        ((zzerj) this.f27245a).zzb((zzcvk) obj);
    }
}
