package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcgu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26203b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f26204c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzcgx f26205d;

    public zzcgu(zzcgx zzcgxVar, String str, String str2, int i2) {
        this.f26202a = str;
        this.f26203b = str2;
        this.f26204c = i2;
        Objects.requireNonNull(zzcgxVar);
        this.f26205d = zzcgxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.f26202a);
        map.put("cachedSrc", this.f26203b);
        map.put("totalBytes", Integer.toString(this.f26204c));
        this.f26205d.r(map);
    }
}
