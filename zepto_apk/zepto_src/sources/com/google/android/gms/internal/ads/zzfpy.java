package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Random;

/* loaded from: classes4.dex */
public final class zzfpy {

    /* renamed from: a, reason: collision with root package name */
    public final long f31607a;

    /* renamed from: b, reason: collision with root package name */
    public final long f31608b;

    /* renamed from: f, reason: collision with root package name */
    public final Clock f31612f;

    /* renamed from: g, reason: collision with root package name */
    public long f31613g;

    /* renamed from: d, reason: collision with root package name */
    public long f31610d = 5;

    /* renamed from: e, reason: collision with root package name */
    public long f31611e = 0;

    /* renamed from: h, reason: collision with root package name */
    public final Random f31614h = new Random();

    /* renamed from: c, reason: collision with root package name */
    public long f31609c = 0;

    public zzfpy(long j2, long j3, Clock clock) {
        this.f31607a = j2;
        this.f31608b = j3;
        this.f31612f = clock;
        a();
    }

    public final void a() {
        this.f31613g = this.f31607a;
        this.f31609c = 0L;
        this.f31611e = 0L;
    }

    public final long b() {
        double d2 = this.f31613g;
        double d3 = 0.2d * d2;
        long j2 = (long) (d2 + d3);
        return ((long) (d2 - d3)) + ((long) (this.f31614h.nextDouble() * ((j2 - r0) + 1)));
    }

    public final void c() {
        this.f31611e = this.f31612f.currentTimeMillis() + b();
        double d2 = this.f31613g;
        this.f31613g = Math.min((long) (d2 + d2), this.f31608b);
        this.f31609c++;
    }

    public final boolean d() {
        zzbgb zzbgbVar = zzbgk.J;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        return ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue() >= 0 && this.f31609c > Math.max(this.f31610d, (long) ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue()) && this.f31613g >= this.f31608b;
    }
}
