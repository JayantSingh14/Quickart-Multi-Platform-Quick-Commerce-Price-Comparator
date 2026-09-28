package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzdxp {

    /* renamed from: e, reason: collision with root package name */
    public final String f28766e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxj f28767f;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f28763b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f28764c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28765d = false;

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f28762a = com.google.android.gms.ads.internal.zzt.C.f21684h.g();

    public zzdxp(String str, zzdxj zzdxjVar) {
        this.f28766e = str;
        this.f28767f = zzdxjVar;
    }

    public final synchronized void a(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.u2)).booleanValue()) {
            HashMap mapE = e();
            mapE.put("action", "adapter_init_started");
            mapE.put("ancn", str);
            this.f28763b.add(mapE);
        }
    }

    public final synchronized void b(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.u2)).booleanValue()) {
            HashMap mapE = e();
            mapE.put("action", "adapter_init_finished");
            mapE.put("ancn", str);
            this.f28763b.add(mapE);
        }
    }

    public final synchronized void c(String str, String str2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.u2)).booleanValue()) {
            HashMap mapE = e();
            mapE.put("action", "adapter_init_finished");
            mapE.put("ancn", str);
            mapE.put("rqe", str2);
            this.f28763b.add(mapE);
        }
    }

    public final synchronized void d() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.u2)).booleanValue() && !this.f28764c) {
            HashMap mapE = e();
            mapE.put("action", "init_started");
            this.f28763b.add(mapE);
            this.f28764c = true;
        }
    }

    public final HashMap e() {
        zzdxj zzdxjVar = this.f28767f;
        zzdxjVar.getClass();
        HashMap map = new HashMap(zzdxjVar.f28748a);
        map.put("tms", Long.toString(com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime(), 10));
        map.put("tid", this.f28762a.q() ? "" : this.f28766e);
        return map;
    }
}
