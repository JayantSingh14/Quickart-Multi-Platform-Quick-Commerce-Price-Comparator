package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaez implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final zzafb f22900a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22901b;

    public zzaez(zzafb zzafbVar, long j2) {
        this.f22900a = zzafbVar;
        this.f22901b = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzafb zzafbVar = this.f22900a;
        zzafa zzafaVar = zzafbVar.f22914k;
        zzafaVar.getClass();
        String str = zzfj.f31254a;
        long jMax = Math.max(0L, Math.min((zzafbVar.f22908e * j2) / 1000000, zzafbVar.f22913j - 1));
        long[] jArr = zzafaVar.f22902a;
        int iQ = zzfj.q(jArr, jMax, false);
        long j3 = iQ == -1 ? 0L : jArr[iQ];
        long[] jArr2 = zzafaVar.f22903b;
        long j4 = iQ != -1 ? jArr2[iQ] : 0L;
        int i2 = zzafbVar.f22908e;
        long j5 = (j3 * 1000000) / i2;
        long j6 = this.f22901b;
        zzafs zzafsVar = new zzafs(j5, j4 + j6);
        if (j5 == j2 || iQ == jArr.length - 1) {
            return new zzafp(zzafsVar, zzafsVar);
        }
        int i3 = iQ + 1;
        return new zzafp(zzafsVar, new zzafs((jArr[i3] * 1000000) / i2, j6 + jArr2[i3]));
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f22900a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
