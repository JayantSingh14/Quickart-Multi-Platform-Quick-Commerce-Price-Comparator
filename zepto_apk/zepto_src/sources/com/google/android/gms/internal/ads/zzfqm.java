package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzfqm {

    /* renamed from: a, reason: collision with root package name */
    public final Object f31646a;

    /* renamed from: b, reason: collision with root package name */
    public final long f31647b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f31648c;

    /* renamed from: d, reason: collision with root package name */
    public final long f31649d = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.U)).longValue() * 1000;

    /* renamed from: e, reason: collision with root package name */
    public final double f31650e;

    /* renamed from: f, reason: collision with root package name */
    public final int f31651f;

    public zzfqm(Object obj, Clock clock, double d2, int i2) {
        this.f31646a = obj;
        this.f31648c = clock;
        this.f31647b = clock.currentTimeMillis();
        this.f31650e = d2;
        this.f31651f = i2;
    }

    public final long a() {
        return (this.f31649d + Math.min(Math.max(((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.F)).longValue(), -900000L), 10000L)) - (this.f31648c.currentTimeMillis() - this.f31647b);
    }
}
