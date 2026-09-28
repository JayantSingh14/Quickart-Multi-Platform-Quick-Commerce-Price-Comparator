package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzfhq {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f31144a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxe f31145b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f31146c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public volatile int f31148e = 1;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f31147d = 0;

    public zzfhq(Clock clock, zzdxe zzdxeVar) {
        this.f31144a = clock;
        this.f31145b = zzdxeVar;
    }

    public final void a(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.je)).booleanValue()) {
            zzdxd zzdxdVarA = this.f31145b.a();
            zzdxdVarA.b("action", "mbs_state");
            zzdxdVarA.b("mbs_state", true != z ? "0" : "1");
            zzdxdVarA.c();
        }
        if (z) {
            c(1, 2);
        } else {
            c(2, 1);
        }
    }

    public final void b() {
        long jCurrentTimeMillis = this.f31144a.currentTimeMillis();
        synchronized (this.f31146c) {
            try {
                if (this.f31148e == 3) {
                    if (this.f31147d + ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.F6)).longValue() <= jCurrentTimeMillis) {
                        this.f31148e = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(int i2, int i3) {
        b();
        Object obj = this.f31146c;
        long jCurrentTimeMillis = this.f31144a.currentTimeMillis();
        synchronized (obj) {
            try {
                if (this.f31148e != i2) {
                    return;
                }
                this.f31148e = i3;
                if (this.f31148e == 3) {
                    this.f31147d = jCurrentTimeMillis;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
