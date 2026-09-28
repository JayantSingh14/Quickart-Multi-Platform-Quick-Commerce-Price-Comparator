package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes4.dex */
final class zzbdd implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public Activity f24760a;

    /* renamed from: b, reason: collision with root package name */
    public Application f24761b;

    /* renamed from: h, reason: collision with root package name */
    public Runnable f24767h;

    /* renamed from: j, reason: collision with root package name */
    public long f24769j;

    /* renamed from: c, reason: collision with root package name */
    public final Object f24762c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f24763d = new AtomicBoolean(true);

    /* renamed from: e, reason: collision with root package name */
    public boolean f24764e = false;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f24765f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f24766g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f24768i = false;

    public final void a(Activity activity) {
        synchronized (this.f24762c) {
            try {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.f24760a = activity;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f24762c) {
            try {
                Activity activity2 = this.f24760a;
                if (activity2 == null) {
                    return;
                }
                if (activity2.equals(activity)) {
                    this.f24760a = null;
                }
                Iterator it = this.f24766g.iterator();
                while (it.hasNext()) {
                    zzdum zzdumVar = (zzdum) it.next();
                    try {
                        if (zzdumVar.f28597b.getAndSet(false)) {
                            zzfza zzfzaVar = zzdumVar.f28596a;
                            zzfzaVar.getClass();
                            BuildersKt.c(zzfzaVar.f32075a, null, new zzfyx(zzfzaVar, null), 3);
                        }
                    } catch (Exception e2) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("AppActivityTracker.ActivityListener.onActivityDestroyed", e2);
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity);
        synchronized (this.f24762c) {
            try {
                Iterator it = this.f24766g.iterator();
                while (it.hasNext()) {
                    zzdum zzdumVar = (zzdum) it.next();
                    try {
                        if (zzdumVar.f28597b.get()) {
                            zzfza zzfzaVar = zzdumVar.f28596a;
                            zzfzaVar.getClass();
                            BuildersKt.c(zzfzaVar.f32075a, null, new zzfyl(zzfzaVar, null), 3);
                        }
                    } catch (Exception e2) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("AppActivityTracker.ActivityListener.onActivityPaused", e2);
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f24764e = true;
        Runnable runnable = this.f24767h;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.removeCallbacks(runnable);
        }
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
        zzbdc zzbdcVar = new zzbdc(this);
        this.f24767h = zzbdcVar;
        zzfVar.postDelayed(zzbdcVar, this.f24769j);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity);
        this.f24764e = false;
        boolean andSet = this.f24763d.getAndSet(true);
        Runnable runnable = this.f24767h;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.removeCallbacks(runnable);
        }
        synchronized (this.f24762c) {
            try {
                Iterator it = this.f24766g.iterator();
                while (it.hasNext()) {
                    zzdum zzdumVar = (zzdum) it.next();
                    try {
                        if (zzdumVar.f28597b.get()) {
                            zzfza zzfzaVar = zzdumVar.f28596a;
                            zzfzaVar.getClass();
                            BuildersKt.c(zzfzaVar.f32075a, null, new zzfyz(zzfzaVar, null), 3);
                        }
                    } catch (Exception e2) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("AppActivityTracker.ActivityListener.onActivityResumed", e2);
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
                    }
                }
                if (andSet) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("App is still foreground.");
                } else {
                    Iterator it2 = this.f24765f.iterator();
                    while (it2.hasNext()) {
                        try {
                            ((zzbde) it2.next()).j1(true);
                        } catch (Exception e3) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
