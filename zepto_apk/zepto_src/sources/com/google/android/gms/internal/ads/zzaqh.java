package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
final class zzaqh implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final zzaqe f24155a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24156b;

    /* renamed from: c, reason: collision with root package name */
    public final long f24157c;

    /* renamed from: d, reason: collision with root package name */
    public final long f24158d;

    /* renamed from: e, reason: collision with root package name */
    public final long f24159e;

    public zzaqh(zzaqe zzaqeVar, int i2, long j2, long j3) {
        this.f24155a = zzaqeVar;
        this.f24156b = i2;
        this.f24157c = j2;
        long j4 = (j3 - j2) / zzaqeVar.f24148c;
        this.f24158d = j4;
        this.f24159e = c(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        long j3 = this.f24156b;
        zzaqe zzaqeVar = this.f24155a;
        long j4 = (zzaqeVar.f24147b * j2) / (j3 * 1000000);
        String str = zzfj.f31254a;
        long j5 = this.f24158d - 1;
        long jMax = Math.max(0L, Math.min(j4, j5));
        long j6 = zzaqeVar.f24148c;
        long jC = c(jMax);
        long j7 = this.f24157c;
        zzafs zzafsVar = new zzafs(jC, (jMax * j6) + j7);
        if (jC >= j2 || jMax == j5) {
            return new zzafp(zzafsVar, zzafsVar);
        }
        long j8 = jMax + 1;
        return new zzafp(zzafsVar, new zzafs(c(j8), (j6 * j8) + j7));
    }

    public final long c(long j2) {
        return zzfj.u(j2 * this.f24156b, 1000000L, this.f24155a.f24147b, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f24159e;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
