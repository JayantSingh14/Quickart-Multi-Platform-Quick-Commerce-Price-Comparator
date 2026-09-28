package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcgv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26206a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26207b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f26208c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzcgx f26209d;

    public zzcgv(zzcgx zzcgxVar, String str, String str2, long j2) {
        this.f26206a = str;
        this.f26207b = str2;
        this.f26208c = j2;
        Objects.requireNonNull(zzcgxVar);
        this.f26209d = zzcgxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.f26206a);
        map.put("cachedSrc", this.f26207b);
        map.put("totalDuration", Long.toString(this.f26208c));
        this.f26209d.r(map);
    }
}
