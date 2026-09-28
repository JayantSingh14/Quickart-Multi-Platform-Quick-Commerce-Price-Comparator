package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzehe implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29333a;

    /* renamed from: b, reason: collision with root package name */
    public final zzegw f29334b;

    public zzehe(zzijf zzijfVar, zzegw zzegwVar) {
        this.f29333a = zzijfVar;
        this.f29334b = zzegwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzegr zzegrVar = (zzegr) this.f29333a.zzb();
        zzegw zzegwVar = this.f29334b;
        return new zzehd(zzegrVar, new zzegv(zzegwVar.f29309a.zzb(), zzegwVar.f29310b.zzb()));
    }
}
