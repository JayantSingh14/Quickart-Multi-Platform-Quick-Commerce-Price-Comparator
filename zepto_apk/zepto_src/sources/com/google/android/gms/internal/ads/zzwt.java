package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzwt extends zzzy {

    /* renamed from: b, reason: collision with root package name */
    public final zzbg f35787b;

    public zzwt(zzzw zzzwVar, zzbg zzbgVar) {
        super(zzzwVar);
        this.f35787b = zzbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzy
    public final boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof zzwt)) {
            return this.f35787b.equals(((zzwt) obj).f35787b);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzy
    public final int hashCode() {
        return this.f35787b.hashCode() + (this.f35999a.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzzy, com.google.android.gms.internal.ads.zzaab
    public final zzbg zza() {
        return this.f35787b;
    }

    @Override // com.google.android.gms.internal.ads.zzzy, com.google.android.gms.internal.ads.zzaab
    public final zzv zzb(int i2) {
        return this.f35787b.f24986d[this.f35999a.zzf(i2)];
    }

    @Override // com.google.android.gms.internal.ads.zzzy, com.google.android.gms.internal.ads.zzzw
    public final zzv zzc() {
        return this.f35787b.f24986d[this.f35999a.zzh()];
    }
}
