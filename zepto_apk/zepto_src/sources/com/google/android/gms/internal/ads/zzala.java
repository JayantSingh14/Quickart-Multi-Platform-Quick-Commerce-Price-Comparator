package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzala implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzalb f23453a;

    public /* synthetic */ zzala(zzalb zzalbVar) {
        Objects.requireNonNull(zzalbVar);
        this.f23453a = zzalbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzalb zzalbVar = this.f23453a;
        BigInteger bigIntegerValueOf = BigInteger.valueOf((zzalbVar.f23457d.f23496i * j2) / 1000000);
        long j3 = zzalbVar.f23456c;
        long j4 = zzalbVar.f23455b;
        long jLongValue = bigIntegerValueOf.multiply(BigInteger.valueOf(j3 - j4)).divide(BigInteger.valueOf(zzalbVar.f23459f)).longValue() + j4;
        String str = zzfj.f31254a;
        zzafs zzafsVar = new zzafs(j2, Math.max(j4, Math.min(jLongValue - 30000, j3 - 1)));
        return new zzafp(zzafsVar, zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        zzalb zzalbVar = this.f23453a;
        zzalm zzalmVar = zzalbVar.f23457d;
        return (zzalbVar.f23459f * 1000000) / zzalmVar.f23496i;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
