package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcda {

    /* renamed from: a, reason: collision with root package name */
    public final Object f25931a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f25932b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcdf f25933c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25934d;

    /* renamed from: e, reason: collision with root package name */
    public Context f25935e;

    /* renamed from: f, reason: collision with root package name */
    public VersionInfoParcel f25936f;

    /* renamed from: g, reason: collision with root package name */
    public String f25937g;

    /* renamed from: h, reason: collision with root package name */
    public zzbgp f25938h;

    /* renamed from: i, reason: collision with root package name */
    public zzdxe f25939i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f25940j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f25941k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f25942l;

    /* renamed from: m, reason: collision with root package name */
    public final zzccz f25943m;
    public final Object n;
    public ListenableFuture o;
    public final AtomicBoolean p;

    public zzcda() {
        com.google.android.gms.ads.internal.util.zzj zzjVar = new com.google.android.gms.ads.internal.util.zzj();
        this.f25932b = zzjVar;
        this.f25933c = new zzcdf(com.google.android.gms.ads.internal.client.zzbb.f21141g.f21147f, zzjVar);
        this.f25934d = false;
        this.f25938h = null;
        this.f25939i = null;
        this.f25940j = null;
        this.f25941k = new AtomicInteger(0);
        this.f25942l = new AtomicInteger(0);
        this.f25943m = new zzccz();
        this.n = new Object();
        this.p = new AtomicBoolean();
    }

    public final zzbgp a() {
        zzbgp zzbgpVar;
        synchronized (this.f25931a) {
            zzbgpVar = this.f25938h;
        }
        return zzbgpVar;
    }

    public final void b(Context context, VersionInfoParcel versionInfoParcel, zzdxe zzdxeVar) {
        zzbgp zzbgpVar;
        synchronized (this.f25931a) {
            try {
                if (!this.f25934d) {
                    this.f25935e = context.getApplicationContext();
                    this.f25936f = versionInfoParcel;
                    com.google.android.gms.ads.internal.zzt.C.f21683g.b(this.f25933c);
                    this.f25932b.f(this.f25935e);
                    zzbxv.d(this.f25935e, this.f25936f);
                    this.f25939i = zzdxeVar;
                    zzbgb zzbgbVar = zzbgk.s2;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                        zzbgpVar = new zzbgp();
                    } else {
                        com.google.android.gms.ads.internal.util.zze.k("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                        zzbgpVar = null;
                    }
                    this.f25938h = zzbgpVar;
                    if (zzbgpVar != null) {
                        zzcdr.a(new zzccw(this).b(), "AppState.registerCsiReporter");
                    }
                    Context context2 = this.f25935e;
                    if (PlatformVersion.isAtLeastO()) {
                        if (((Boolean) zzbdVar.f21153c.a(zzbgk.t9)).booleanValue()) {
                            try {
                                ((ConnectivityManager) context2.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzccx(this));
                            } catch (RuntimeException e2) {
                                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.g("Failed to register network callback", e2);
                                this.p.set(true);
                            }
                        }
                    }
                    this.f25934d = true;
                    h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.af)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.C.f21679c.E(context, versionInfoParcel.f21400a);
    }

    public final Resources c() {
        if (this.f25936f.f21403d) {
            return this.f25935e.getResources();
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Zb)).booleanValue()) {
                return com.google.android.gms.ads.internal.util.client.zzs.b(this.f25935e).f22330a.getResources();
            }
            com.google.android.gms.ads.internal.util.client.zzs.b(this.f25935e).f22330a.getResources();
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final void d(String str, Throwable th) {
        zzbxv.d(this.f25935e, this.f25936f).a(str, th);
    }

    public final void e(String str, Throwable th) {
        zzbxv.d(this.f25935e, this.f25936f).b(th, str, ((Double) zzbit.f25218f.c()).floatValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x001d, B:10:0x002d, B:13:0x0037, B:14:0x003e), top: B:19:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r7, java.lang.Throwable r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f25935e
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r1 = r6.f25936f
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzbxv.f25677l
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbxx r3 = com.google.android.gms.internal.ads.zzbxv.n     // Catch: java.lang.Throwable -> L35
            if (r3 != 0) goto L3e
            com.google.android.gms.internal.ads.zzbgb r3 = com.google.android.gms.internal.ads.zzbgk.u8     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.ads.internal.client.zzbd r4 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbgi r5 = r4.f21153c     // Catch: java.lang.Throwable -> L35
            java.lang.Object r3 = r5.a(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L35
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L37
            com.google.android.gms.internal.ads.zzbgb r3 = com.google.android.gms.internal.ads.zzbgk.t8     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbgi r4 = r4.f21153c     // Catch: java.lang.Throwable -> L35
            java.lang.Object r3 = r4.a(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L35
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r3 != 0) goto L37
            com.google.android.gms.internal.ads.zzbxv r3 = new com.google.android.gms.internal.ads.zzbxv     // Catch: java.lang.Throwable -> L35
            r3.<init>(r0, r1)     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbxv.n = r3     // Catch: java.lang.Throwable -> L35
            goto L3e
        L35:
            r7 = move-exception
            goto L45
        L37:
            com.google.android.gms.internal.ads.zzbxw r0 = new com.google.android.gms.internal.ads.zzbxw     // Catch: java.lang.Throwable -> L35
            r0.<init>()     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbxv.n = r0     // Catch: java.lang.Throwable -> L35
        L3e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbxx r0 = com.google.android.gms.internal.ads.zzbxv.n
            r0.a(r7, r8)
            return
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L35
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcda.f(java.lang.String, java.lang.Throwable):void");
    }

    public final com.google.android.gms.ads.internal.util.zzj g() {
        com.google.android.gms.ads.internal.util.zzj zzjVar;
        synchronized (this.f25931a) {
            zzjVar = this.f25932b;
        }
        return zzjVar;
    }

    public final ListenableFuture h() {
        if (this.f25935e != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y3)).booleanValue()) {
                synchronized (this.n) {
                    try {
                        ListenableFuture listenableFuture = this.o;
                        if (listenableFuture != null) {
                            return listenableFuture;
                        }
                        ListenableFuture listenableFutureSubmit = ((zzgxi) zzcdo.f25982a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzccy
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                Context contextA = zzbzk.a(this.f25919a.f25935e);
                                ArrayList arrayList = new ArrayList();
                                try {
                                    PackageInfo packageInfo = Wrappers.packageManager(contextA).getPackageInfo(contextA.getApplicationInfo().packageName, 4096);
                                    if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                                        int i2 = 0;
                                        while (true) {
                                            String[] strArr = packageInfo.requestedPermissions;
                                            if (i2 >= strArr.length) {
                                                break;
                                            }
                                            if ((packageInfo.requestedPermissionsFlags[i2] & 2) != 0) {
                                                arrayList.add(strArr[i2]);
                                            }
                                            i2++;
                                        }
                                    }
                                } catch (PackageManager.NameNotFoundException unused) {
                                }
                                return arrayList;
                            }
                        });
                        this.o = listenableFutureSubmit;
                        return listenableFutureSubmit;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        return zzgym.a(new ArrayList());
    }

    public final boolean i(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.t9)).booleanValue()) {
                return this.p.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
