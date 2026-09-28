package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzddl extends zzdgi {

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f27635b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f27636c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdxe f27637d;

    /* renamed from: e, reason: collision with root package name */
    public long f27638e;

    /* renamed from: f, reason: collision with root package name */
    public long f27639f;

    /* renamed from: g, reason: collision with root package name */
    public long f27640g;

    /* renamed from: h, reason: collision with root package name */
    public long f27641h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f27642i;

    /* renamed from: j, reason: collision with root package name */
    public ScheduledFuture f27643j;

    /* renamed from: k, reason: collision with root package name */
    public ScheduledFuture f27644k;

    public zzddl(ScheduledExecutorService scheduledExecutorService, Clock clock, zzdxe zzdxeVar) {
        super(Collections.EMPTY_SET);
        this.f27638e = -1L;
        this.f27639f = -1L;
        this.f27640g = -1L;
        this.f27641h = -1L;
        this.f27642i = false;
        this.f27635b = scheduledExecutorService;
        this.f27636c = clock;
        this.f27637d = zzdxeVar;
    }

    public final synchronized void A0(long j2) {
        try {
            ScheduledFuture scheduledFuture = this.f27644k;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.f27644k.cancel(false);
            }
            this.f27639f = this.f27636c.elapsedRealtime() + j2;
            this.f27644k = this.f27635b.schedule(new zzddk(this), j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void w0(int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 20);
        sb.append("In scheduleRefresh: ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        if (i2 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i2);
            if (this.f27642i) {
                long j2 = this.f27640g;
                if (j2 <= 0 || millis >= j2) {
                    millis = j2;
                }
                this.f27640g = millis;
                return;
            }
            long jElapsedRealtime = this.f27636c.elapsedRealtime();
            zzbgb zzbgbVar = zzbgk.se;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                long j3 = this.f27638e;
                if (jElapsedRealtime >= j3 || j3 - jElapsedRealtime > millis) {
                    z0(millis);
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.Pe)).booleanValue()) {
                        zzdxd zzdxdVarA = this.f27637d.a();
                        zzdxdVarA.b("action", "rtnc");
                        zzdxdVarA.e();
                    }
                }
            } else {
                long j4 = this.f27638e;
                if (jElapsedRealtime > j4 || j4 - jElapsedRealtime > millis) {
                    z0(millis);
                }
            }
        }
    }

    public final synchronized void x0(int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 28);
        sb.append("In scheduleShowRefreshedAd: ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        if (i2 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i2);
            if (this.f27642i) {
                long j2 = this.f27641h;
                if (j2 <= 0 || millis >= j2) {
                    millis = j2;
                }
                this.f27641h = millis;
                return;
            }
            long jElapsedRealtime = this.f27636c.elapsedRealtime();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.se)).booleanValue()) {
                if (jElapsedRealtime == this.f27639f) {
                    com.google.android.gms.ads.internal.util.zze.k("In scheduleShowRefreshedAd: currentTimeMs = scheduledShowTimeMs");
                }
                long j3 = this.f27639f;
                if (jElapsedRealtime >= j3 || j3 - jElapsedRealtime > millis) {
                    A0(millis);
                }
            } else {
                long j4 = this.f27639f;
                if (jElapsedRealtime > j4 || j4 - jElapsedRealtime > millis) {
                    A0(millis);
                }
            }
        }
    }

    public final synchronized void z0(long j2) {
        try {
            ScheduledFuture scheduledFuture = this.f27643j;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.f27643j.cancel(false);
            }
            this.f27638e = this.f27636c.elapsedRealtime() + j2;
            this.f27643j = this.f27635b.schedule(new zzddj(this), j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        this.f27642i = false;
        z0(0L);
    }
}
