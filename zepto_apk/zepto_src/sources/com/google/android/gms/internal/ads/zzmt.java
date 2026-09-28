package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class zzmt implements zzlj {

    /* renamed from: a, reason: collision with root package name */
    public boolean f35228a;

    /* renamed from: b, reason: collision with root package name */
    public long f35229b;

    /* renamed from: c, reason: collision with root package name */
    public long f35230c;

    /* renamed from: d, reason: collision with root package name */
    public zzav f35231d;

    public final void a(long j2) {
        this.f35229b = j2;
        if (this.f35228a) {
            this.f35230c = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final void s(zzav zzavVar) {
        if (this.f35228a) {
            a(zzg());
        }
        this.f35231d = zzavVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final long zzg() {
        long j2 = this.f35229b;
        if (!this.f35228a) {
            return j2;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f35230c;
        return this.f35231d.f24412a == 1.0f ? zzfj.s(jElapsedRealtime) + j2 : (jElapsedRealtime * r4.f24414c) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final zzav zzj() {
        return this.f35231d;
    }
}
