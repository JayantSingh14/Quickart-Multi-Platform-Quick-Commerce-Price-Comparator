package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzfb {

    /* renamed from: h, reason: collision with root package name */
    public static volatile zzfb f36943h;

    /* renamed from: a, reason: collision with root package name */
    public final Clock f36944a = DefaultClock.getInstance();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f36945b;

    /* renamed from: c, reason: collision with root package name */
    public final AppMeasurementSdk f36946c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f36947d;

    /* renamed from: e, reason: collision with root package name */
    public int f36948e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f36949f;

    /* renamed from: g, reason: collision with root package name */
    public volatile zzcr f36950g;

    public zzfb(Context context, Bundle bundle) throws ClassNotFoundException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzed(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f36945b = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f36946c = new AppMeasurementSdk(this);
        this.f36947d = new ArrayList();
        try {
            if (com.google.android.gms.measurement.internal.zzls.a(context, com.google.android.gms.measurement.internal.zzht.a(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzfb.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.f36949f = true;
                    Log.w("FA", "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        j(new zzdr(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w("FA", "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzfa(this));
        }
    }

    public static zzfb m(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (f36943h == null) {
            synchronized (zzfb.class) {
                try {
                    if (f36943h == null) {
                        f36943h = new zzfb(context, bundle);
                    }
                } finally {
                }
            }
        }
        return f36943h;
    }

    public final void A(String str) {
        j(new zzdt(this, str));
    }

    public final void B(Runnable runnable) {
        j(new zzdv(this, runnable));
    }

    public final String C() {
        zzco zzcoVar = new zzco();
        j(new zzdw(this, zzcoVar));
        return zzcoVar.z0(500L);
    }

    public final String D() {
        zzco zzcoVar = new zzco();
        j(new zzdx(this, zzcoVar));
        return zzcoVar.z0(50L);
    }

    public final long E() {
        zzco zzcoVar = new zzco();
        j(new zzdy(this, zzcoVar));
        Long l2 = (Long) zzco.w1(zzcoVar.j1(500L), Long.class);
        if (l2 != null) {
            return l2.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.f36944a.currentTimeMillis()).nextLong();
        int i2 = this.f36948e + 1;
        this.f36948e = i2;
        return jNextLong + i2;
    }

    public final String a() {
        zzco zzcoVar = new zzco();
        j(new zzdz(this, zzcoVar));
        return zzcoVar.z0(500L);
    }

    public final String b() {
        zzco zzcoVar = new zzco();
        j(new zzea(this, zzcoVar));
        return zzcoVar.z0(500L);
    }

    public final Map c(String str, String str2, boolean z) {
        zzco zzcoVar = new zzco();
        j(new zzeb(this, str, str2, z, zzcoVar));
        Bundle bundleJ1 = zzcoVar.j1(5000L);
        if (bundleJ1 == null || bundleJ1.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleJ1.size());
        for (String str3 : bundleJ1.keySet()) {
            Object obj = bundleJ1.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void d(String str, Exception exc) {
        j(new zzec(this, str, exc));
    }

    public final int e(String str) {
        zzco zzcoVar = new zzco();
        j(new zzef(this, str, zzcoVar));
        Integer num = (Integer) zzco.w1(zzcoVar.j1(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String f() {
        zzco zzcoVar = new zzco();
        j(new zzeg(this, zzcoVar));
        return zzcoVar.z0(120000L);
    }

    public final Long g() {
        zzco zzcoVar = new zzco();
        j(new zzeh(this, zzcoVar));
        return (Long) zzco.w1(zzcoVar.j1(120000L), Long.class);
    }

    public final void h(boolean z) {
        j(new zzej(this, z));
    }

    public final void i(Bundle bundle) {
        j(new zzek(this, bundle));
    }

    public final void j(zzeq zzeqVar) {
        this.f36945b.execute(zzeqVar);
    }

    public final void k(Exception exc, boolean z, boolean z2) {
        this.f36949f |= z;
        if (z) {
            Log.w("FA", "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            d("Error with data collection. Data lost.", exc);
        }
        Log.w("FA", "Error with data collection. Data lost.", exc);
    }

    public final void l(Bundle bundle, String str, String str2, boolean z) {
        j(new zzep(this, str, str2, bundle, z));
    }

    public final void n(Intent intent) {
        j(new zzem(this, intent));
    }

    public final void o(AppMeasurementSdk.OnEventListener onEventListener) {
        Preconditions.checkNotNull(onEventListener);
        ArrayList arrayList = this.f36947d;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    if (onEventListener.equals(((Pair) arrayList.get(i2)).first)) {
                        Log.w("FA", "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzes zzesVar = new zzes(onEventListener);
            arrayList.add(new Pair(onEventListener, zzesVar));
            if (this.f36950g != null) {
                try {
                    this.f36950g.registerOnMeasurementEventListener(zzesVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w("FA", "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            j(new zzen(this, zzesVar));
        }
    }

    public final void p(String str, String str2, String str3, boolean z) {
        j(new zzdh(this, str, str2, str3, z));
    }

    public final void q(Bundle bundle) {
        j(new zzdi(this, bundle));
    }

    public final void r(String str, String str2, Bundle bundle) {
        j(new zzdj(this, str, str2, bundle));
    }

    public final List s(String str, String str2) {
        zzco zzcoVar = new zzco();
        j(new zzdk(this, str, str2, zzcoVar));
        List list = (List) zzco.w1(zzcoVar.j1(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final void t(String str) {
        j(new zzdl(this, str));
    }

    public final void u(zzdf zzdfVar, String str, String str2) {
        j(new zzdm(this, zzdfVar, str, str2));
    }

    public final void v(Boolean bool) {
        j(new zzdn(this, bool));
    }

    public final void w(Bundle bundle) {
        j(new zzdo(this, bundle));
    }

    public final void x() {
        j(new zzdp(this));
    }

    public final void y(long j2) {
        j(new zzdq(this, j2));
    }

    public final void z(String str) {
        j(new zzds(this, str));
    }
}
