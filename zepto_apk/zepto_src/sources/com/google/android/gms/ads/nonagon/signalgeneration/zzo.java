package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzgyw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzo {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f21917a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f21918b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Context f21919c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdxj f21920d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f21921e;

    public zzo(Context context, zzdxj zzdxjVar, zzgyw zzgywVar) {
        this.f21919c = context;
        this.f21920d = zzdxjVar;
        this.f21921e = zzgywVar;
    }

    public final synchronized void a(final Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        final Pair pair = new Pair(queryInfoGenerationCallback, Long.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis()));
        zzcdo.f25987f.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
            @Override // java.lang.Runnable
            public final void run() {
                CookieManager cookieManagerH;
                zzo zzoVar = this.f21914a;
                zzoVar.getClass();
                Object obj2 = obj;
                boolean zAcceptThirdPartyCookies = false;
                if ((obj2 instanceof WebView) && (cookieManagerH = com.google.android.gms.ads.internal.zzt.C.f21682f.h()) != null) {
                    zAcceptThirdPartyCookies = cookieManagerH.acceptThirdPartyCookies((WebView) obj2);
                }
                HashMap map = zzoVar.f21917a;
                Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies);
                zzq zzqVar = (zzq) map.get(boolValueOf);
                Pair pair2 = pair;
                if (zzqVar != null) {
                    if (zzqVar.f21930c > com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis()) {
                        zzoVar.e(zzqVar, pair2, true);
                        return;
                    }
                }
                HashMap map2 = zzoVar.f21918b;
                List arrayList = (List) map2.get(boolValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map2.put(boolValueOf, arrayList);
                }
                arrayList.add(pair2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x0024, B:12:0x0028, B:15:0x002f, B:17:0x0033, B:21:0x0046, B:25:0x0050, B:28:0x0071, B:29:0x0075, B:31:0x007b, B:20:0x003e, B:14:0x002c), top: B:37:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void b(final boolean r10, com.google.android.gms.ads.nonagon.signalgeneration.zzq r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.HashMap r0 = r9.f21917a     // Catch: java.lang.Throwable -> L3c
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r2 = (com.google.android.gms.ads.nonagon.signalgeneration.zzq) r2     // Catch: java.lang.Throwable -> L3c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L2c
            com.google.android.gms.ads.internal.zzt r5 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.common.util.Clock r5 = r5.f21687k     // Catch: java.lang.Throwable -> L3c
            long r5 = r5.currentTimeMillis()     // Catch: java.lang.Throwable -> L3c
            long r7 = r2.f21930c     // Catch: java.lang.Throwable -> L3c
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 > 0) goto L21
            r5 = r4
            goto L22
        L21:
            r5 = r3
        L22:
            if (r5 != 0) goto L2c
            com.google.android.gms.ads.query.QueryInfo r2 = r2.f21928a     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L2c
            com.google.android.gms.ads.query.QueryInfo r2 = r11.f21928a     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L2f
        L2c:
            r0.put(r1, r11)     // Catch: java.lang.Throwable -> L3c
        L2f:
            com.google.android.gms.ads.query.QueryInfo r0 = r11.f21928a     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L3e
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbip.f25200f     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L3c
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Throwable -> L3c
            goto L46
        L3c:
            r10 = move-exception
            goto L87
        L3e:
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbip.f25201g     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L3c
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Throwable -> L3c
        L46:
            long r5 = r0.longValue()     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.ads.query.QueryInfo r0 = r11.f21928a     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L4f
            goto L50
        L4f:
            r4 = r3
        L50:
            java.util.concurrent.ScheduledExecutorService r0 = com.google.android.gms.internal.ads.zzcdo.f25985d     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.ads.nonagon.signalgeneration.zzk r2 = new com.google.android.gms.ads.nonagon.signalgeneration.zzk     // Catch: java.lang.Throwable -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L3c
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L3c
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = (java.util.concurrent.ScheduledThreadPoolExecutor) r0     // Catch: java.lang.Throwable -> L3c
            r0.schedule(r2, r5, r10)     // Catch: java.lang.Throwable -> L3c
            java.util.HashMap r10 = r9.f21918b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r0 = r10.get(r1)     // Catch: java.lang.Throwable -> L3c
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L3c
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L3c
            r10.put(r1, r2)     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L71
            goto L85
        L71:
            java.util.Iterator r10 = r0.iterator()     // Catch: java.lang.Throwable -> L3c
        L75:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L85
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Throwable -> L3c
            android.util.Pair r0 = (android.util.Pair) r0     // Catch: java.lang.Throwable -> L3c
            r9.e(r11, r0, r3)     // Catch: java.lang.Throwable -> L3c
            goto L75
        L85:
            monitor-exit(r9)
            return
        L87:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L3c
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzo.b(boolean, com.google.android.gms.ads.nonagon.signalgeneration.zzq):void");
    }

    public final void c(final boolean z) {
        HashMap map = this.f21918b;
        Boolean boolValueOf = Boolean.valueOf(z);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        map.put(boolValueOf, new ArrayList());
        this.f21921e.submit(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws Throwable {
                this.f21909a.d(z, false);
            }
        });
    }

    public final synchronized void d(boolean z, boolean z2) throws Throwable {
        Throwable th;
        try {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("query_info_type", "requester_type_6");
                bundle.putBoolean("accept_3p_cookie", z);
                HashMap map = this.f21917a;
                Boolean boolValueOf = Boolean.valueOf(z);
                zzq zzqVar = (zzq) map.get(boolValueOf);
                int i2 = 0;
                if (z2 && zzqVar != null) {
                    try {
                        i2 = zzqVar.f21931d + 1;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                zzq zzqVar2 = (zzq) map.get(boolValueOf);
                final zzp zzpVar = new zzp(this, z, i2, zzqVar2 == null ? null : Boolean.valueOf(zzqVar2.f21932e.get()), this.f21920d);
                final AdRequest adRequest = new AdRequest((AdRequest.Builder) new AdRequest.Builder().c(bundle));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.jc)).booleanValue()) {
                    this.f21921e.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            QueryInfo.a(this.f21911a.f21919c, adRequest, zzpVar);
                            return Boolean.TRUE;
                        }
                    });
                } else {
                    QueryInfo.a(this.f21919c, adRequest, zzpVar);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void e(zzq zzqVar, Pair pair, boolean z) {
        zzqVar.f21932e.set(true);
        QueryInfo queryInfo = zzqVar.f21928a;
        if (queryInfo != null) {
            ((QueryInfoGenerationCallback) pair.first).b(queryInfo);
        } else {
            ((QueryInfoGenerationCallback) pair.first).a(zzqVar.f21929b);
        }
        zzaa.d(this.f21920d, "sgpcr", new Pair("se", "query_g"), new Pair("ad_format", "BANNER"), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("lat_ms", Long.toString(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - ((Long) pair.second).longValue())), new Pair("sgpc_h", Boolean.toString(z)), new Pair("sgpc_rs", Boolean.toString(queryInfo != null)));
    }
}
