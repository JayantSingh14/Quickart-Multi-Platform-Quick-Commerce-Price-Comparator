package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* loaded from: classes4.dex */
final class zzsg {

    /* renamed from: a, reason: collision with root package name */
    public final zzsf f35494a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfc f35495b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f35496c;

    /* renamed from: d, reason: collision with root package name */
    public final AudioTrack f35497d;

    /* renamed from: e, reason: collision with root package name */
    public final int f35498e;

    /* renamed from: f, reason: collision with root package name */
    public final long f35499f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f35500g;

    /* renamed from: h, reason: collision with root package name */
    public final zzrh f35501h;

    /* renamed from: i, reason: collision with root package name */
    public final float f35502i;

    /* renamed from: j, reason: collision with root package name */
    public long f35503j;

    /* renamed from: k, reason: collision with root package name */
    public long f35504k;

    /* renamed from: l, reason: collision with root package name */
    public long f35505l;

    /* renamed from: m, reason: collision with root package name */
    public Method f35506m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public int s;
    public int t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    public zzsg(zzsf zzsfVar, zzfc zzfcVar, AudioTrack audioTrack, int i2, int i3, int i4) {
        this.f35494a = zzsfVar;
        this.f35495b = zzfcVar;
        this.f35497d = audioTrack;
        try {
            this.f35506m = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f35496c = new long[10];
        this.z = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.f35501h = new zzrh(audioTrack, zzsfVar);
        int sampleRate = audioTrack.getSampleRate();
        this.f35498e = sampleRate;
        boolean zA = zzfj.a(i2);
        this.f35500g = zA;
        this.f35499f = zA ? zzfj.t(sampleRate, i4 / i3) : -9223372036854775807L;
        this.q = 0L;
        this.r = 0L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.o = 0L;
        this.n = 0L;
        this.f35502i = 1.0f;
        this.f35503j = -9223372036854775807L;
    }

    public final void a(long j2) {
        long j3 = this.f35503j;
        if (j3 == -9223372036854775807L || j2 < j3) {
            return;
        }
        float f2 = this.f35502i;
        long jRound = j2 - j3;
        String str = zzfj.f31254a;
        if (f2 != 1.0f) {
            jRound = Math.round(jRound / f2);
        }
        long jR = zzfj.r(jRound);
        this.f35495b.getClass();
        final long jCurrentTimeMillis = System.currentTimeMillis() - jR;
        this.f35503j = -9223372036854775807L;
        zzrs zzrsVar = (zzrs) this.f35494a;
        zzdy zzdyVar = new zzdy() { // from class: com.google.android.gms.internal.ads.zzrr
            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                ((zzpx) obj).a(jCurrentTimeMillis);
            }
        };
        zzed zzedVar = zzrsVar.f35456a.f35472h;
        zzedVar.c(-1, zzdyVar);
        zzedVar.d();
    }

    public final long b(long j2) {
        int i2 = this.t;
        int i3 = this.f35498e;
        long jMax = Math.max(0L, (i2 == 0 ? this.u != -9223372036854775807L ? zzfj.t(i3, d()) : zzfj.t(i3, c()) : zzfj.w(j2 + this.f35504k, this.f35502i)) - this.n);
        return this.u != -9223372036854775807L ? Math.min(zzfj.t(i3, this.x), jMax) : jMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c() {
        /*
            r12 = this;
            long r0 = r12.u
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L16
            long r0 = r12.d()
            long r2 = r12.x
            long r0 = java.lang.Math.min(r2, r0)
            return r0
        L16:
            com.google.android.gms.internal.ads.zzfc r0 = r12.f35495b
            r0.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r4 = r12.p
            long r4 = r0 - r4
            r6 = 5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L6f
            android.media.AudioTrack r4 = r12.f35497d
            int r5 = r4.getPlayState()
            r6 = 1
            if (r5 != r6) goto L33
            goto L6d
        L33:
            int r4 = r4.getPlaybackHeadPosition()
            long r6 = (long) r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r8
            r8 = 29
            if (r4 > r8) goto L5e
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L5c
            long r10 = r12.q
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 <= 0) goto L5c
            r4 = 3
            if (r5 != r4) goto L5c
            long r4 = r12.v
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L6d
            r12.v = r0
            goto L6d
        L5c:
            r12.v = r2
        L5e:
            long r2 = r12.q
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L6b
            long r2 = r12.r
            r4 = 1
            long r2 = r2 + r4
            r12.r = r2
        L6b:
            r12.q = r6
        L6d:
            r12.p = r0
        L6f:
            long r0 = r12.q
            long r2 = r12.r
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsg.c():long");
    }

    public final long d() {
        if (this.f35497d.getPlayState() == 2) {
            return this.w;
        }
        this.f35495b.getClass();
        return this.w + zzfj.u(zzfj.w(zzfj.s(SystemClock.elapsedRealtime()) - this.u, this.f35502i), this.f35498e, 1000000L, RoundingMode.UP);
    }
}
