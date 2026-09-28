package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzfno implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final zzfnr f31477b;

    /* renamed from: c, reason: collision with root package name */
    public String f31478c;

    /* renamed from: e, reason: collision with root package name */
    public String f31480e;

    /* renamed from: f, reason: collision with root package name */
    public zzfib f31481f;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zze f31482g;

    /* renamed from: h, reason: collision with root package name */
    public ScheduledFuture f31483h;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f31476a = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public int f31484i = 2;

    /* renamed from: d, reason: collision with root package name */
    public zzfnt f31479d = zzfnt.SCAR_REQUEST_TYPE_UNSPECIFIED;

    public zzfno(zzfnr zzfnrVar) {
        this.f31477b = zzfnrVar;
    }

    public final synchronized void a(zzfne zzfneVar) {
        try {
            if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
                ArrayList arrayList = this.f31476a;
                zzfneVar.zzc();
                arrayList.add(zzfneVar);
                ScheduledFuture scheduledFuture = this.f31483h;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f31483h = ((ScheduledThreadPoolExecutor) zzcdo.f25985d).schedule(this, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.N9)).intValue(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(ArrayList arrayList) {
        try {
            if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
                if (arrayList.contains("banner") || arrayList.contains("BANNER")) {
                    this.f31484i = 3;
                } else if (arrayList.contains("interstitial") || arrayList.contains("INTERSTITIAL")) {
                    this.f31484i = 4;
                } else if (arrayList.contains("native") || arrayList.contains("NATIVE")) {
                    this.f31484i = 8;
                } else if (arrayList.contains("rewarded") || arrayList.contains("REWARDED")) {
                    this.f31484i = 5;
                } else if (arrayList.contains("app_open_ad")) {
                    this.f31484i = 7;
                } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains("REWARDED_INTERSTITIAL")) {
                    this.f31484i = 6;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(String str) {
        boolean zMatches;
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                zMatches = false;
            } else {
                zMatches = Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.O9), str);
            }
            if (zMatches) {
                this.f31478c = str;
            }
        }
    }

    public final synchronized void d(Bundle bundle) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            this.f31479d = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.c(bundle);
        }
    }

    public final synchronized void e(zzfib zzfibVar) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            this.f31481f = zzfibVar;
        }
    }

    public final synchronized void f(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            this.f31482g = zzeVar;
        }
    }

    public final synchronized void g(String str) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            this.f31480e = str;
        }
    }

    public final synchronized void h() {
        try {
            if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
                ScheduledFuture scheduledFuture = this.f31483h;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ArrayList arrayList = this.f31476a;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzfne zzfneVar = (zzfne) it.next();
                    int i2 = this.f31484i;
                    if (i2 != 2) {
                        zzfneVar.h(i2);
                    }
                    if (!TextUtils.isEmpty(this.f31478c)) {
                        zzfneVar.q(this.f31478c);
                    }
                    if (!TextUtils.isEmpty(this.f31480e) && !zzfneVar.zzl()) {
                        zzfneVar.zzi(this.f31480e);
                    }
                    zzfib zzfibVar = this.f31481f;
                    if (zzfibVar != null) {
                        zzfneVar.i(zzfibVar);
                    } else {
                        com.google.android.gms.ads.internal.client.zze zzeVar = this.f31482g;
                        if (zzeVar != null) {
                            zzfneVar.d(zzeVar);
                        }
                    }
                    zzfneVar.g(this.f31479d);
                    this.f31477b.b(zzfneVar.zzm());
                }
                arrayList.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void i(int i2) {
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            this.f31484i = i2;
        }
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        h();
    }
}
