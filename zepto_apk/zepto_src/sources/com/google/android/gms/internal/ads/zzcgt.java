package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
final class zzcgt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26192a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26193b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f26194c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f26195d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f26196e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f26197f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f26198g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f26199h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f26200i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzchd f26201j;

    public zzcgt(zzchd zzchdVar, String str, String str2, int i2, int i3, long j2, long j3, boolean z, int i4, int i5) {
        this.f26192a = str;
        this.f26193b = str2;
        this.f26194c = i2;
        this.f26195d = i3;
        this.f26196e = j2;
        this.f26197f = j3;
        this.f26198g = z;
        this.f26199h = i4;
        this.f26200i = i5;
        this.f26201j = zzchdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f26192a);
        map.put("cachedSrc", this.f26193b);
        map.put("bytesLoaded", Integer.toString(this.f26194c));
        map.put("totalBytes", Integer.toString(this.f26195d));
        map.put("bufferedDuration", Long.toString(this.f26196e));
        map.put("totalDuration", Long.toString(this.f26197f));
        map.put("cacheReady", true != this.f26198g ? "0" : "1");
        map.put("playerCount", Integer.toString(this.f26199h));
        map.put("playerPreparedCount", Integer.toString(this.f26200i));
        this.f26201j.r(map);
    }
}
