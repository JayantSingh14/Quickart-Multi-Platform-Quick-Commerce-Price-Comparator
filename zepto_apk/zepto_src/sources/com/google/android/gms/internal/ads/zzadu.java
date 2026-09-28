package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzadu implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final zzadx f22834a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22835b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22836c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22837d;

    /* renamed from: e, reason: collision with root package name */
    public final long f22838e;

    /* renamed from: f, reason: collision with root package name */
    public final long f22839f;

    public zzadu(zzadx zzadxVar, long j2, long j3, long j4, long j5, long j6) {
        this.f22834a = zzadxVar;
        this.f22835b = j2;
        this.f22836c = j3;
        this.f22837d = j4;
        this.f22838e = j5;
        this.f22839f = j6;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzafs zzafsVar = new zzafs(j2, zzadw.a(this.f22834a.a(j2), 0L, this.f22836c, this.f22837d, this.f22838e, this.f22839f));
        return new zzafp(zzafsVar, zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f22835b;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
