package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdpi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28171a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdmn f28172b;

    public zzdpi(zzdmn zzdmnVar, zzijf zzijfVar) {
        this.f28171a = zzijfVar;
        this.f28172b = zzdmnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdua zzduaVar = (zzdua) this.f28171a.zzb();
        zzdsp zzdspVar = this.f28172b.f27971a.f27964b;
        zzijo.a(zzdspVar);
        return new zzdph(zzduaVar, zzdspVar);
    }
}
