package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* loaded from: classes4.dex */
final class zzrh {

    /* renamed from: a, reason: collision with root package name */
    public final zzrg f35430a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35431b;

    /* renamed from: c, reason: collision with root package name */
    public final zzsf f35432c;

    /* renamed from: d, reason: collision with root package name */
    public int f35433d;

    /* renamed from: e, reason: collision with root package name */
    public long f35434e;

    /* renamed from: f, reason: collision with root package name */
    public long f35435f;

    /* renamed from: g, reason: collision with root package name */
    public long f35436g;

    /* renamed from: h, reason: collision with root package name */
    public long f35437h;

    /* renamed from: i, reason: collision with root package name */
    public long f35438i;

    public zzrh(AudioTrack audioTrack, zzsf zzsfVar) {
        this.f35430a = new zzrg(audioTrack);
        this.f35431b = audioTrack.getSampleRate();
        this.f35432c = zzsfVar;
        a(0);
    }

    public final void a(int i2) {
        this.f35433d = i2;
        long j2 = 10000;
        if (i2 == 0) {
            this.f35436g = 0L;
            this.f35437h = -1L;
            this.f35438i = -9223372036854775807L;
            this.f35434e = System.nanoTime() / 1000;
        } else {
            if (i2 == 1) {
                this.f35435f = 10000L;
                return;
            }
            j2 = (i2 == 2 || i2 == 3) ? 10000000L : 500000L;
        }
        this.f35435f = j2;
    }
}
