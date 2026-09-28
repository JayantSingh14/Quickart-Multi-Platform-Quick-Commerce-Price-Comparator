package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public class zzaee implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final long f22863a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22864b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22865c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22866d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22867e;

    /* renamed from: f, reason: collision with root package name */
    public final long f22868f;

    public zzaee(int i2, int i3, long j2, long j3) {
        this.f22863a = j2;
        this.f22864b = j3;
        this.f22865c = i3 == -1 ? 1 : i3;
        this.f22867e = i2;
        if (j2 == -1) {
            this.f22866d = -1L;
            this.f22868f = -9223372036854775807L;
        } else {
            long j4 = j2 - j3;
            this.f22866d = j4;
            this.f22868f = (Math.max(0L, j4) * 8000000) / i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        long j3 = this.f22866d;
        long j4 = this.f22864b;
        if (j3 == -1) {
            zzafs zzafsVar = new zzafs(0L, j4);
            return new zzafp(zzafsVar, zzafsVar);
        }
        int i2 = this.f22867e;
        long j5 = this.f22865c;
        long jMin = (((i2 * j2) / 8000000) / j5) * j5;
        if (j3 != -1) {
            jMin = Math.min(jMin, j3 - j5);
        }
        long jMax = Math.max(jMin, 0L) + j4;
        long jMax2 = (Math.max(0L, jMax - j4) * 8000000) / i2;
        zzafs zzafsVar2 = new zzafs(jMax2, jMax);
        if (j3 != -1 && jMax2 < j2) {
            long j6 = jMax + j5;
            if (j6 < this.f22863a) {
                return new zzafp(zzafsVar2, new zzafs((Math.max(0L, j6 - j4) * 8000000) / i2, j6));
            }
        }
        return new zzafp(zzafsVar2, zzafsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f22868f;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return this.f22866d != -1;
    }
}
