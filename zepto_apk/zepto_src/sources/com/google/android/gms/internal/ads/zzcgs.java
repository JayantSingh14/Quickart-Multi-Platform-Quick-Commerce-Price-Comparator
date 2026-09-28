package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcgs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26182b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f26183c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f26184d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f26185e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f26186f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f26187g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f26188h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f26189i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f26190j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzcgx f26191k;

    public zzcgs(zzcgx zzcgxVar, String str, String str2, long j2, long j3, long j4, long j5, long j6, boolean z, int i2, int i3) {
        this.f26181a = str;
        this.f26182b = str2;
        this.f26183c = j2;
        this.f26184d = j3;
        this.f26185e = j4;
        this.f26186f = j5;
        this.f26187g = j6;
        this.f26188h = z;
        this.f26189i = i2;
        this.f26190j = i3;
        Objects.requireNonNull(zzcgxVar);
        this.f26191k = zzcgxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f26181a);
        map.put("cachedSrc", this.f26182b);
        map.put("bufferedDuration", Long.toString(this.f26183c));
        map.put("totalDuration", Long.toString(this.f26184d));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue()) {
            map.put("qoeLoadedBytes", Long.toString(this.f26185e));
            map.put("qoeCachedBytes", Long.toString(this.f26186f));
            map.put("totalBytes", Long.toString(this.f26187g));
            map.put("reportTime", Long.toString(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis()));
        }
        map.put("cacheReady", true != this.f26188h ? "0" : "1");
        map.put("playerCount", Integer.toString(this.f26189i));
        map.put("playerPreparedCount", Integer.toString(this.f26190j));
        this.f26191k.r(map);
    }
}
