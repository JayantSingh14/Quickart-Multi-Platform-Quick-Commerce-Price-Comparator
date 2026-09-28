package com.google.android.gms.internal.ads;

import android.util.Pair;

/* loaded from: classes4.dex */
final class zzajf implements zzajk {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f23264a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f23265b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23266c;

    public zzajf(long j2, long[] jArr, long[] jArr2) {
        this.f23264a = jArr;
        this.f23265b = jArr2;
        this.f23266c = j2 == -9223372036854775807L ? zzfj.s(jArr2[jArr2.length - 1]) : j2;
    }

    public static Pair c(long j2, long[] jArr, long[] jArr2) {
        int iQ = zzfj.q(jArr, j2, true);
        long j3 = jArr[iQ];
        long j4 = jArr2[iQ];
        int i2 = iQ + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j4));
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) ((jArr[i2] == j3 ? 0.0d : (j2 - j3) / (r6 - j3)) * (jArr2[i2] - j4))) + j4));
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long a(long j2) {
        return zzfj.s(((Long) c(j2, this.f23264a, this.f23265b).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        String str = zzfj.f31254a;
        Pair pairC = c(zzfj.r(Math.max(0L, Math.min(j2, this.f23266c))), this.f23265b, this.f23264a);
        zzafs zzafsVar = new zzafs(zzfj.s(((Long) pairC.first).longValue()), ((Long) pairC.second).longValue());
        return new zzafp(zzafsVar, zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f23266c;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long zzf() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final int zzg() {
        return -2147483647;
    }
}
