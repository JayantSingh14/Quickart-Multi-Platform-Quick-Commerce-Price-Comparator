package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzdzp {

    /* renamed from: f, reason: collision with root package name */
    public final Context f28851f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakReference f28852g;

    /* renamed from: h, reason: collision with root package name */
    public final zzduu f28853h;

    /* renamed from: i, reason: collision with root package name */
    public final zzgyw f28854i;

    /* renamed from: j, reason: collision with root package name */
    public final Executor f28855j;

    /* renamed from: k, reason: collision with root package name */
    public final ScheduledExecutorService f28856k;

    /* renamed from: l, reason: collision with root package name */
    public final zzdxp f28857l;

    /* renamed from: m, reason: collision with root package name */
    public final VersionInfoParcel f28858m;
    public final zzdhq o;
    public final zzfnr p;

    /* renamed from: a, reason: collision with root package name */
    public boolean f28846a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f28847b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f28848c = false;

    /* renamed from: e, reason: collision with root package name */
    public final zzcdt f28850e = new zzcdt();
    public final ConcurrentHashMap n = new ConcurrentHashMap();
    public boolean q = true;

    /* renamed from: d, reason: collision with root package name */
    public final long f28849d = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();

    public zzdzp(Executor executor, Context context, WeakReference weakReference, zzgyw zzgywVar, zzduu zzduuVar, ScheduledExecutorService scheduledExecutorService, zzdxp zzdxpVar, VersionInfoParcel versionInfoParcel, zzdhq zzdhqVar, zzfnr zzfnrVar) {
        this.f28853h = zzduuVar;
        this.f28851f = context;
        this.f28852g = weakReference;
        this.f28854i = zzgywVar;
        this.f28856k = scheduledExecutorService;
        this.f28855j = executor;
        this.f28857l = zzdxpVar;
        this.f28858m = versionInfoParcel;
        this.o = zzdhqVar;
        this.p = zzfnrVar;
        d("com.google.android.gms.ads.MobileAds", 0, "", false);
    }

    public final void a() {
        if (!((Boolean) zzbiq.f25203a.c()).booleanValue()) {
            int i2 = this.f28858m.f21402c;
            zzbgb zzbgbVar = zzbgk.i2;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (i2 >= ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue() && this.q) {
                if (this.f28846a) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.f28846a) {
                            return;
                        }
                        this.f28857l.d();
                        this.o.zze();
                        zzcdt zzcdtVar = this.f28850e;
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzh
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdzp zzdzpVar = this.f28826a;
                                zzdxp zzdxpVar = zzdzpVar.f28857l;
                                synchronized (zzdxpVar) {
                                    try {
                                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.u2)).booleanValue() && !zzdxpVar.f28765d) {
                                            HashMap mapE = zzdxpVar.e();
                                            mapE.put("action", "init_finished");
                                            ArrayList arrayList = zzdxpVar.f28763b;
                                            arrayList.add(mapE);
                                            Iterator it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                zzdxpVar.f28767f.a((Map) it.next(), false);
                                            }
                                            zzdxpVar.f28765d = true;
                                        }
                                    } finally {
                                    }
                                }
                                zzdzpVar.o.zzf();
                                zzdzpVar.f28847b = true;
                            }
                        };
                        zzgyw zzgywVar = this.f28854i;
                        zzcdtVar.f25992a.q(runnable, zzgywVar);
                        this.f28846a = true;
                        ListenableFuture listenableFutureC = c();
                        this.f28856k.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzj
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdzp zzdzpVar = this.f28829a;
                                synchronized (zzdzpVar) {
                                    try {
                                        if (zzdzpVar.f28848c) {
                                            return;
                                        }
                                        zzdzpVar.d("com.google.android.gms.ads.MobileAds", (int) (com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzdzpVar.f28849d), "Timeout.", false);
                                        zzdzpVar.f28857l.c("com.google.android.gms.ads.MobileAds", "timeout");
                                        zzdzpVar.o.c("com.google.android.gms.ads.MobileAds", "timeout");
                                        zzdzpVar.f28850e.c(new Exception());
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }, ((Long) zzbdVar.f21153c.a(zzbgk.k2)).longValue(), TimeUnit.SECONDS);
                        listenableFutureC.q(new zzgyk(listenableFutureC, new zzdzf(this)), zzgywVar);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        if (this.f28846a) {
            return;
        }
        d("com.google.android.gms.ads.MobileAds", 0, "", true);
        this.f28850e.b(Boolean.FALSE);
        this.f28846a = true;
        this.f28847b = true;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = this.n;
        for (String str : concurrentHashMap.keySet()) {
            zzbpm zzbpmVar = (zzbpm) concurrentHashMap.get(str);
            arrayList.add(new zzbpm(str, zzbpmVar.f25413c, zzbpmVar.f25414d, zzbpmVar.f25412b));
        }
        return arrayList;
    }

    public final synchronized ListenableFuture c() {
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        String str = zztVar.f21684h.g().i().f25911e;
        if (!TextUtils.isEmpty(str)) {
            return zzgym.a(str);
        }
        final zzcdt zzcdtVar = new zzcdt();
        com.google.android.gms.ads.internal.util.zzj zzjVarG = zztVar.f21684h.g();
        zzjVarG.f21582c.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzdzp zzdzpVar = this.f28827a;
                zzdzpVar.getClass();
                final zzcdt zzcdtVar2 = zzcdtVar;
                zzdzpVar.f28854i.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzn
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2 = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25911e;
                        boolean zIsEmpty = TextUtils.isEmpty(str2);
                        zzcdt zzcdtVar3 = zzcdtVar2;
                        if (zIsEmpty) {
                            zzcdtVar3.c(new Exception());
                        } else {
                            zzcdtVar3.b(str2);
                        }
                    }
                });
            }
        });
        return zzcdtVar;
    }

    public final void d(String str, int i2, String str2, boolean z) {
        this.n.put(str, new zzbpm(str, i2, str2, z));
    }
}
