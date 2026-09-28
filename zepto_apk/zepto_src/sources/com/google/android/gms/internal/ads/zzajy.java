package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajy implements zzaju {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23325a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23326b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23327c;

    /* renamed from: d, reason: collision with root package name */
    public int f23328d;

    /* renamed from: e, reason: collision with root package name */
    public int f23329e;

    public zzajy(zzfv zzfvVar) {
        zzer zzerVar = zzfvVar.f31916b;
        this.f23325a = zzerVar;
        zzerVar.E(12);
        this.f23327c = zzerVar.h() & 255;
        this.f23326b = zzerVar.h();
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final int zza() {
        return this.f23326b;
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final int zzb() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    public final int zzc() {
        zzer zzerVar = this.f23325a;
        int i2 = this.f23327c;
        if (i2 == 8) {
            return zzerVar.K();
        }
        if (i2 == 16) {
            return zzerVar.L();
        }
        int i3 = this.f23328d;
        this.f23328d = i3 + 1;
        if (i3 % 2 != 0) {
            return this.f23329e & 15;
        }
        int iK = zzerVar.K();
        this.f23329e = iK;
        return (iK & 240) >> 4;
    }
}
