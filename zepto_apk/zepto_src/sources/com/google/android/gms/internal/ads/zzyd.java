package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzyd implements zzxw {

    /* renamed from: a, reason: collision with root package name */
    public final zzxw f35897a;

    /* renamed from: b, reason: collision with root package name */
    public final long f35898b;

    public zzyd(zzxw zzxwVar, long j2) {
        this.f35897a = zzxwVar;
        this.f35898b = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final int a(long j2) {
        return this.f35897a.a(j2 - this.f35898b);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final int b(zzle zzleVar, zzih zzihVar, int i2) {
        int iB = this.f35897a.b(zzleVar, zzihVar, i2);
        if (iB != -4) {
            return iB;
        }
        zzihVar.f34831f += this.f35898b;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final boolean zzb() {
        return this.f35897a.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void zzc() {
        this.f35897a.zzc();
    }
}
