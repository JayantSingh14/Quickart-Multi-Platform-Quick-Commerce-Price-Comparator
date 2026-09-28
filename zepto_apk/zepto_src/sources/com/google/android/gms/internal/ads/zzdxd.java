package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzdxd {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f28727a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdxe f28728b;

    public zzdxd(zzdxe zzdxeVar) {
        Objects.requireNonNull(zzdxeVar);
        this.f28728b = zzdxeVar;
        this.f28727a = new ConcurrentHashMap();
    }

    public final void a(zzfhr zzfhrVar) {
        b("aai", zzfhrVar.w);
        b("request_id", zzfhrVar.n0);
        b("ad_format", zzfhr.a(zzfhrVar.f31150b));
    }

    public final void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f28727a.put(str, str2);
    }

    public final void c() {
        this.f28728b.f28730b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxc
            @Override // java.lang.Runnable
            public final void run() {
                zzdxd zzdxdVar = this.f28726a;
                zzdxdVar.f28728b.f28729a.a(zzdxdVar.f28727a, false);
            }
        });
    }

    public final com.google.android.gms.ads.internal.util.client.zzt d() {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.rf)).booleanValue();
        com.google.android.gms.ads.internal.util.client.zzt zztVar = com.google.android.gms.ads.internal.util.client.zzt.f21443a;
        if (!zBooleanValue) {
            c();
            return zztVar;
        }
        ConcurrentHashMap concurrentHashMap = this.f28727a;
        zzdxj zzdxjVar = this.f28728b.f28729a;
        zzdxjVar.getClass();
        if (concurrentHashMap.isEmpty()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty paramMap.");
            return zztVar;
        }
        String strA = zzdxjVar.f28753f.a(concurrentHashMap);
        com.google.android.gms.ads.internal.util.zze.k(strA);
        return zzdxjVar.f28751d.b(strA, null);
    }

    public final void e() {
        this.f28728b.f28730b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxa
            @Override // java.lang.Runnable
            public final void run() {
                zzdxd zzdxdVar = this.f28724a;
                final zzdxj zzdxjVar = zzdxdVar.f28728b.f28729a;
                ConcurrentHashMap concurrentHashMap = zzdxdVar.f28727a;
                zzdxjVar.getClass();
                if (concurrentHashMap.isEmpty()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Empty paramMap.");
                    return;
                }
                zzdxjVar.b(concurrentHashMap);
                final String strA = zzdxjVar.f28753f.a(concurrentHashMap);
                com.google.android.gms.ads.internal.util.zze.k(strA);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.oe)).booleanValue() || zzdxjVar.f28752e) {
                    zzdxjVar.f28750c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxm
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzdxjVar.f28751d.b(strA, null);
                        }
                    });
                }
            }
        });
    }
}
