package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajl implements zzajk {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f23282a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f23283b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23284c;

    /* renamed from: d, reason: collision with root package name */
    public final long f23285d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23286e;

    public zzajl(long[] jArr, long[] jArr2, long j2, long j3, int i2) {
        this.f23282a = jArr;
        this.f23283b = jArr2;
        this.f23284c = j2;
        this.f23285d = j3;
        this.f23286e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long a(long j2) {
        return this.f23282a[zzfj.q(this.f23283b, j2, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        long[] jArr = this.f23282a;
        int iQ = zzfj.q(jArr, j2, true);
        long j3 = jArr[iQ];
        long[] jArr2 = this.f23283b;
        zzafs zzafsVar = new zzafs(j3, jArr2[iQ]);
        if (j3 >= j2 || iQ == jArr.length - 1) {
            return new zzafp(zzafsVar, zzafsVar);
        }
        int i2 = iQ + 1;
        return new zzafp(zzafsVar, new zzafs(jArr[i2], jArr2[i2]));
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f23284c;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long zzf() {
        return this.f23285d;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final int zzg() {
        return this.f23286e;
    }
}
