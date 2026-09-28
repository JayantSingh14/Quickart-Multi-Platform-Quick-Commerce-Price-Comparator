package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public class zzafq implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final long f22957a;

    /* renamed from: b, reason: collision with root package name */
    public final zzafp f22958b;

    public zzafq(long j2, long j3) {
        this.f22957a = j2;
        zzafs zzafsVar = j3 == 0 ? zzafs.f22959c : new zzafs(0L, j3);
        this.f22958b = new zzafp(zzafsVar, zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        return this.f22958b;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f22957a;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return false;
    }
}
