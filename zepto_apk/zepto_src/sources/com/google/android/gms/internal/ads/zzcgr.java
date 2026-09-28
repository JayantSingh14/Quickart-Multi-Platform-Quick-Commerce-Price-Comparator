package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
final class zzcgr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26176a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26177b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f26178c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f26179d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzcha f26180e;

    public zzcgr(zzcha zzchaVar, String str, String str2, int i2, int i3) {
        this.f26176a = str;
        this.f26177b = str2;
        this.f26178c = i2;
        this.f26179d = i3;
        this.f26180e = zzchaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f26176a);
        map.put("cachedSrc", this.f26177b);
        map.put("bytesLoaded", Integer.toString(this.f26178c));
        map.put("totalBytes", Integer.toString(this.f26179d));
        map.put("cacheReady", "0");
        this.f26180e.r(map);
    }
}
