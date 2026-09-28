package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbdf {

    /* renamed from: a, reason: collision with root package name */
    public final Object f24770a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public zzbdd f24771b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24772c = false;

    public final void a(Context context) {
        synchronized (this.f24770a) {
            try {
                if (!this.f24772c) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Can not cast Context to Application");
                        return;
                    }
                    if (this.f24771b == null) {
                        this.f24771b = new zzbdd();
                    }
                    zzbdd zzbddVar = this.f24771b;
                    if (!zzbddVar.f24768i) {
                        application.registerActivityLifecycleCallbacks(zzbddVar);
                        if (context instanceof Activity) {
                            zzbddVar.a((Activity) context);
                        }
                        zzbddVar.f24761b = application;
                        zzbddVar.f24769j = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.p1)).longValue();
                        zzbddVar.f24768i = true;
                    }
                    this.f24772c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(zzbde zzbdeVar) {
        synchronized (this.f24770a) {
            try {
                if (this.f24771b == null) {
                    this.f24771b = new zzbdd();
                }
                zzbdd zzbddVar = this.f24771b;
                synchronized (zzbddVar.f24762c) {
                    zzbddVar.f24765f.add(zzbdeVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(zzbde zzbdeVar) {
        synchronized (this.f24770a) {
            try {
                zzbdd zzbddVar = this.f24771b;
                if (zzbddVar == null) {
                    return;
                }
                synchronized (zzbddVar.f24762c) {
                    zzbddVar.f24765f.remove(zzbdeVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Activity d() {
        synchronized (this.f24770a) {
            try {
                zzbdd zzbddVar = this.f24771b;
                if (zzbddVar == null) {
                    return null;
                }
                return zzbddVar.f24760a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        synchronized (this.f24770a) {
            try {
                zzbdd zzbddVar = this.f24771b;
                if (zzbddVar == null) {
                    return false;
                }
                return zzbddVar.f24763d.get();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
