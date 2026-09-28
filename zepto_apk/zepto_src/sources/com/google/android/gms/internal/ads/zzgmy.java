package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
final class zzgmy implements zzglz, zzgcb {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f32946h = {"android:establish_vpn_service", "android:establish_vpn_manager"};

    /* renamed from: a, reason: collision with root package name */
    public final Context f32947a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f32948b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f32949c;

    /* renamed from: d, reason: collision with root package name */
    public long f32950d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f32951e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f32952f = -1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f32953g = false;

    public zzgmy(Context context, ExecutorService executorService, String[] strArr) {
        this.f32947a = context;
        this.f32948b = executorService;
        this.f32949c = strArr;
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void a(HashMap map, Context context, View view) {
        d();
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void b(HashMap map) {
        d();
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void c(HashMap map) {
        long j2;
        long j3;
        d();
        synchronized (this) {
            try {
                j2 = this.f32953g ? this.f32951e - this.f32950d : -1L;
            } finally {
            }
        }
        map.put("vs", Long.valueOf(j2));
        synchronized (this) {
            j3 = this.f32952f;
            this.f32952f = -1L;
        }
        map.put("vf", Long.valueOf(j3));
    }

    public final void d() {
        synchronized (this) {
            try {
                if (this.f32953g) {
                    this.f32951e = System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final ListenableFuture zza() {
        if (Build.VERSION.SDK_INT < 30) {
            return zzgyq.f33377b;
        }
        zzgzl zzgzlVar = new zzgzl(Executors.callable(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgmx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzgmy zzgmyVar = this.f32945a;
                zzgmyVar.getClass();
                zzgmw zzgmwVar = new zzgmw(zzgmyVar);
                try {
                    Object systemService = zzgmyVar.f32947a.getSystemService("appops");
                    if (systemService == null) {
                        throw null;
                    }
                    ((AppOpsManager) systemService).startWatchingActive(zzgmyVar.f32949c, zzgmyVar.f32948b, zzgmwVar);
                } catch (Throwable unused) {
                }
            }
        }, null));
        this.f32948b.execute(zzgzlVar);
        return zzgzlVar;
    }
}
