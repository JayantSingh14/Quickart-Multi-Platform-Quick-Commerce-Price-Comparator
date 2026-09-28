package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajx implements zzaju {

    /* renamed from: a, reason: collision with root package name */
    public final int f23322a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23323b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23324c;

    public zzajx(zzfv zzfvVar, zzv zzvVar) {
        zzer zzerVar = zzfvVar.f31916b;
        this.f23324c = zzerVar;
        zzerVar.E(12);
        int iH = zzerVar.h();
        if ("audio/raw".equals(zzvVar.f35691m)) {
            int iD = zzfj.d(zzvVar.G) * zzvVar.E;
            if (iH == 0 || iH % iD != 0) {
                zzee.c("BoxParsers", androidx.fragment.app.e.n(iD, iH, "Audio sample size mismatch. stsd sample size: ", ", stsz sample size: ", new StringBuilder(String.valueOf(iD).length() + 66 + String.valueOf(iH).length())));
                iH = iD;
            }
        }
        this.f23322a = iH == 0 ? -1 : iH;
        this.f23323b = zzerVar.h();
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final int zza() {
        return this.f23323b;
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final int zzb() {
        return this.f23322a;
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final int zzc() {
        int i2 = this.f23322a;
        return i2 == -1 ? this.f23324c.h() : i2;
    }
}
