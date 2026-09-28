package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzcdc {

    /* renamed from: h, reason: collision with root package name */
    public final String f25954h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f25955i;

    /* renamed from: a, reason: collision with root package name */
    public long f25947a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f25948b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f25949c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f25950d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f25951e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Object f25952f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final Object f25953g = new Object();

    /* renamed from: j, reason: collision with root package name */
    public int f25956j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f25957k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f25958l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f25959m = 0;
    public final HashMap n = new HashMap();
    public final HashMap o = new HashMap();

    public zzcdc(String str, com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f25954h = str;
        this.f25955i = zzjVar;
    }

    public final void a(com.google.android.gms.ads.internal.client.zzm zzmVar, long j2) {
        long j3;
        Bundle bundle;
        synchronized (this.f25952f) {
            try {
                com.google.android.gms.ads.internal.util.zzj zzjVar = this.f25955i;
                long j4 = zzjVar.j();
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                if (this.f25948b == -1) {
                    if (jCurrentTimeMillis - j4 > ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q1)).longValue()) {
                        this.f25950d = -1;
                    } else {
                        this.f25950d = zzjVar.l();
                    }
                    this.f25948b = j2;
                    this.f25947a = j2;
                } else {
                    this.f25947a = j2;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l4)).booleanValue() || (bundle = zzmVar.f21256c) == null || bundle.getInt("gw", 2) != 1) {
                    this.f25949c++;
                    int i2 = this.f25950d + 1;
                    this.f25950d = i2;
                    if (i2 == 0) {
                        this.f25951e = 0L;
                        zzjVar.m(jCurrentTimeMillis);
                    } else {
                        zzjVar.d();
                        synchronized (zzjVar.f21580a) {
                            j3 = zzjVar.p;
                        }
                        this.f25951e = jCurrentTimeMillis - j3;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        if (((Boolean) zzbir.f25210a.c()).booleanValue()) {
            synchronized (this.f25952f) {
                this.f25949c--;
                this.f25950d--;
            }
        }
    }
}
