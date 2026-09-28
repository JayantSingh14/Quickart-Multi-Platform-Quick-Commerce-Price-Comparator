package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzalc implements zzali {

    /* renamed from: a, reason: collision with root package name */
    public final zzafb f23466a;

    /* renamed from: b, reason: collision with root package name */
    public final zzafa f23467b;

    /* renamed from: c, reason: collision with root package name */
    public long f23468c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f23469d = -1;

    public zzalc(zzafb zzafbVar, zzafa zzafaVar) {
        this.f23466a = zzafbVar;
        this.f23467b = zzafaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void a(long j2) {
        long[] jArr = this.f23467b.f22902a;
        this.f23469d = jArr[zzfj.q(jArr, j2, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final long b(zzaef zzaefVar) {
        long j2 = this.f23469d;
        if (j2 < 0) {
            return -1L;
        }
        this.f23469d = -1L;
        return -(j2 + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final zzafr zzc() {
        zzgqa.f(this.f23468c != -1);
        return new zzaez(this.f23466a, this.f23468c);
    }
}
