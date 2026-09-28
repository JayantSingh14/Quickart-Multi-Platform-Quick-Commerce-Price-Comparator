package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajn implements zzajk {

    /* renamed from: a, reason: collision with root package name */
    public final long f23289a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23290b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23291c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23292d;

    /* renamed from: e, reason: collision with root package name */
    public final long f23293e;

    /* renamed from: f, reason: collision with root package name */
    public final long f23294f;

    /* renamed from: g, reason: collision with root package name */
    public final long[] f23295g;

    public zzajn(long j2, int i2, long j3, int i3, long j4, long[] jArr) {
        this.f23289a = j2;
        this.f23290b = i2;
        this.f23291c = j3;
        this.f23292d = i3;
        this.f23293e = j4;
        this.f23295g = jArr;
        this.f23294f = j4 != -1 ? j2 + j4 : -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long a(long j2) {
        if (!zzb()) {
            return 0L;
        }
        long j3 = j2 - this.f23289a;
        if (j3 <= this.f23290b) {
            return 0L;
        }
        long[] jArr = this.f23295g;
        jArr.getClass();
        double d2 = (j3 * 256.0d) / this.f23293e;
        int iQ = zzfj.q(jArr, (long) d2, true);
        long j4 = this.f23291c;
        long j5 = (iQ * j4) / 100;
        long j6 = jArr[iQ];
        int i2 = iQ + 1;
        long j7 = (j4 * i2) / 100;
        return Math.round((j6 == (iQ == 99 ? 256L : jArr[i2]) ? 0.0d : (d2 - j6) / (r0 - j6)) * (j7 - j5)) + j5;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        double d2;
        double d3;
        boolean zZzb = zzb();
        int i2 = this.f23290b;
        long j3 = this.f23289a;
        if (!zZzb) {
            zzafs zzafsVar = new zzafs(0L, j3 + i2);
            return new zzafp(zzafsVar, zzafsVar);
        }
        String str = zzfj.f31254a;
        long j4 = this.f23291c;
        long jMax = Math.max(0L, Math.min(j2, j4));
        double d4 = (jMax * 100.0d) / j4;
        double d5 = 0.0d;
        if (d4 <= 0.0d) {
            d2 = 256.0d;
        } else if (d4 >= 100.0d) {
            d2 = 256.0d;
            d5 = 256.0d;
        } else {
            int i3 = (int) d4;
            long[] jArr = this.f23295g;
            jArr.getClass();
            double d6 = jArr[i3];
            if (i3 == 99) {
                d2 = 256.0d;
                d3 = 256.0d;
            } else {
                d2 = 256.0d;
                d3 = jArr[i3 + 1];
            }
            d5 = ((d3 - d6) * (d4 - i3)) + d6;
        }
        long j5 = this.f23293e;
        zzafs zzafsVar2 = new zzafs(jMax, j3 + Math.max(i2, Math.min(Math.round((d5 / d2) * j5), j5 - 1)));
        return new zzafp(zzafsVar2, zzafsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f23291c;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return this.f23295g != null;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long zzf() {
        return this.f23294f;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final int zzg() {
        return this.f23292d;
    }
}
