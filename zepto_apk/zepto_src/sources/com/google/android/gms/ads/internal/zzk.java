package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzaut;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzayl;
import com.google.android.gms.internal.ads.zzaym;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzayo;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayw;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbac;
import com.google.android.gms.internal.ads.zzbby;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzfuf;
import com.google.android.gms.internal.ads.zzfvc;
import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgxf;
import com.google.android.gms.internal.ads.zzgym;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzk implements Runnable, zzayl {
    public static final long p = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public boolean f21643d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f21644e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f21645f;

    /* renamed from: g, reason: collision with root package name */
    public final ExecutorService f21646g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfuf f21647h;

    /* renamed from: i, reason: collision with root package name */
    public Context f21648i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f21649j;

    /* renamed from: k, reason: collision with root package name */
    public VersionInfoParcel f21650k;

    /* renamed from: l, reason: collision with root package name */
    public final VersionInfoParcel f21651l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f21652m;
    public int o;

    /* renamed from: a, reason: collision with root package name */
    public final Vector f21640a = new Vector();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f21641b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f21642c = new AtomicReference();
    public final CountDownLatch n = new CountDownLatch(1);

    public zzk(Context context, VersionInfoParcel versionInfoParcel) {
        this.f21648i = context;
        this.f21649j = context;
        this.f21650k = versionInfoParcel;
        this.f21651l = versionInfoParcel;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.f21646g = executorServiceNewCachedThreadPool;
        zzbgb zzbgbVar = zzbgk.T2;
        zzbd zzbdVar = zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        this.f21652m = zBooleanValue;
        this.f21647h = zzfuf.a(context, executorServiceNewCachedThreadPool, zBooleanValue);
        zzbgb zzbgbVar2 = zzbgk.Q2;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        this.f21644e = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
        this.f21645f = ((Boolean) zzbgiVar.a(zzbgk.U2)).booleanValue();
        if (((Boolean) zzbgiVar.a(zzbgk.S2)).booleanValue()) {
            this.o = 2;
        } else {
            this.o = 1;
        }
        if (!((Boolean) zzbgiVar.a(zzbgk.d4)).booleanValue()) {
            this.f21643d = l();
        }
        if (((Boolean) zzbgiVar.a(zzbgk.W3)).booleanValue()) {
            zzcdo.f25982a.execute(this);
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbb.f21141g.f21142a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzcdo.f25982a.execute(this);
        } else {
            run();
        }
    }

    public final boolean a() throws InterruptedException {
        try {
            this.n.await();
            return true;
        } catch (InterruptedException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Interrupted during GADSignals creation.", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void b(int i2, int i3, int i4) {
        zzayl zzaylVarO = o();
        if (zzaylVarO == null) {
            this.f21640a.add(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        m();
        try {
            zzaylVarO.b(i2, i3, i4);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String c(final Context context) {
        try {
            return (String) ((zzgxf) zzgym.c(new Callable() { // from class: com.google.android.gms.ads.internal.zzj
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.f21638a.k(context);
                }
            }, this.f21646g)).get(((Integer) zzbd.f21150e.f21153c.a(zzbgk.k3)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            return Integer.toString(17);
        } catch (TimeoutException unused2) {
            return zzaye.a(context, this.f21651l.f21400a, p);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String d(Context context) {
        return k(context);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String e(Context context, String str, View view) {
        return g(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void f(MotionEvent motionEvent) {
        zzayl zzaylVarO = o();
        if (zzaylVarO == null) {
            this.f21640a.add(new Object[]{motionEvent});
            return;
        }
        m();
        try {
            zzaylVarO.f(motionEvent);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String g(Context context, String str, View view, Activity activity) {
        if (!a()) {
            return "";
        }
        zzayl zzaylVarO = o();
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Nb)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = zzt.C.f21679c;
            com.google.android.gms.ads.internal.util.zzs.j(4, view);
        }
        if (zzaylVarO == null) {
            return "";
        }
        m();
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            return zzaylVarO.g(context, str, view, activity);
        } catch (NullPointerException unused) {
            return "";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void h(StackTraceElement[] stackTraceElementArr) {
        zzayl zzaylVarO;
        zzayl zzaylVarO2;
        try {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.r3)).booleanValue()) {
                if (this.n.getCount() != 0 || (zzaylVarO2 = o()) == null) {
                    return;
                }
                zzaylVarO2.h(stackTraceElementArr);
                return;
            }
            if (!a() || (zzaylVarO = o()) == null) {
                return;
            }
            zzaylVarO.h(stackTraceElementArr);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void i(View view) {
        zzayl zzaylVarO = o();
        if (zzaylVarO != null) {
            try {
                zzaylVarO.i(view);
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String j(Context context, View view, Activity activity) {
        zzbgb zzbgbVar = zzbgk.Mb;
        zzbd zzbdVar = zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzbgi zzbgiVar = zzbdVar.f21153c;
        try {
            if (!zBooleanValue) {
                zzayl zzaylVarO = o();
                if (((Boolean) zzbgiVar.a(zzbgk.Nb)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar = zzt.C.f21679c;
                    com.google.android.gms.ads.internal.util.zzs.j(2, view);
                }
                return zzaylVarO != null ? zzaylVarO.j(context, view, activity) : "";
            }
            if (!a()) {
                return "";
            }
            zzayl zzaylVarO2 = o();
            if (((Boolean) zzbgiVar.a(zzbgk.Nb)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzt.C.f21679c;
                com.google.android.gms.ads.internal.util.zzs.j(2, view);
            }
            return zzaylVarO2 != null ? zzaylVarO2.j(context, view, activity) : "";
        } catch (NullPointerException unused) {
            return "";
        }
    }

    public final String k(Context context) {
        zzayl zzaylVarO;
        if (!a() || (zzaylVarO = o()) == null) {
            return "";
        }
        m();
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            return zzaylVarO.d(context);
        } catch (NullPointerException unused) {
            return "";
        }
    }

    public final boolean l() {
        Context context = this.f21648i;
        zzh zzhVar = new zzh(this);
        zzfuf zzfufVar = this.f21647h;
        zzfvw zzfvwVar = new zzfvw(this.f21648i, zzfvc.b(context, zzfufVar), zzhVar, ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.R2)).booleanValue());
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzfvw.f31949f) {
            try {
                zzbby zzbbyVarF = zzfvwVar.f(1);
                if (zzbbyVarF == null) {
                    zzfvwVar.e(4025, jCurrentTimeMillis);
                    return false;
                }
                File fileC = zzfvwVar.c(zzbbyVarF.C());
                if (!new File(fileC, "pcam.jar").exists()) {
                    zzfvwVar.e(4026, jCurrentTimeMillis);
                    return false;
                }
                if (new File(fileC, "pcbc").exists()) {
                    zzfvwVar.e(5019, jCurrentTimeMillis);
                    return true;
                }
                zzfvwVar.e(4027, jCurrentTimeMillis);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m() {
        Vector vector = this.f21640a;
        zzayl zzaylVarO = o();
        if (vector.isEmpty() || zzaylVarO == null) {
            return;
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            Object[] objArr = (Object[]) it.next();
            try {
                int length = objArr.length;
                if (length == 1) {
                    zzaylVarO.f((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzaylVarO.b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            } catch (NullPointerException unused) {
            }
        }
        vector.clear();
    }

    public final void n(boolean z) {
        String str = this.f21650k.f21400a;
        Context context = this.f21648i;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        zzaut zzautVarG = zzauu.G();
        zzautVarG.j();
        ((zzauu) zzautVarG.f34638b).I(z);
        zzautVarG.j();
        ((zzauu) zzautVarG.f34638b).H(str);
        zzayn zzaynVar = new zzayn((zzauu) zzautVarG.l());
        synchronized (zzayo.class) {
            try {
                if (!zzayo.z) {
                    zzayo.A = System.currentTimeMillis() / 1000;
                    zzaym.u = zzayo.q(context, zzaynVar.f24507a);
                    zzbgb zzbgbVar = zzbgk.Y3;
                    zzbd zzbdVar = zzbd.f21150e;
                    if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                        zzayo.B = zzayw.a(context);
                    }
                    ExecutorService executorService = zzaym.u.f24559b;
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.Z3)).booleanValue() && executorService != null) {
                        zzayo.C = zzbac.a(context, executorService);
                    }
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.h3)).booleanValue()) {
                        zzayo.D = new zzazu();
                    }
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.n3)).booleanValue() || zzaynVar.f24509c.G()) {
                        zzayo.F = new zzayt(context, executorService);
                    }
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.i3)).booleanValue() || zzaynVar.f24509c.E()) {
                        zzayo.E = new zzaxn(context, executorService, zzaynVar.f24509c, zzayo.F);
                    }
                    zzayo.z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f21641b.set(new zzayp(context, zzaynVar));
    }

    public final zzayl o() {
        return ((!this.f21644e || this.f21643d) ? this.o : 1) == 2 ? (zzayl) this.f21642c.get() : (zzayl) this.f21641b.get();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            zzbgb zzbgbVar = zzbgk.d4;
            zzbd zzbdVar = zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                this.f21643d = l();
            }
            boolean z2 = this.f21650k.f21403d;
            final boolean z3 = false;
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.s1)).booleanValue() && z2) {
                z3 = true;
            }
            if (((!this.f21644e || this.f21643d) ? this.o : 1) == 1) {
                n(z3);
                if (this.o == 2) {
                    this.f21646g.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean z4 = z3;
                            zzk zzkVar = this.f21636a;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            try {
                                Context context = zzkVar.f21649j;
                                VersionInfoParcel versionInfoParcel = zzkVar.f21651l;
                                boolean z5 = zzkVar.f21652m;
                                zzaut zzautVarG = zzauu.G();
                                zzautVarG.j();
                                ((zzauu) zzautVarG.f34638b).I(z4);
                                String str = versionInfoParcel.f21400a;
                                zzautVarG.j();
                                ((zzauu) zzautVarG.f34638b).H(str);
                                zzauu zzauuVar = (zzauu) zzautVarG.l();
                                Context applicationContext = context.getApplicationContext();
                                if (applicationContext != null) {
                                    context = applicationContext;
                                }
                                zzayi.a(context, zzauuVar, z5).l();
                            } catch (NullPointerException e2) {
                                zzkVar.f21647h.c(2027, System.currentTimeMillis() - jCurrentTimeMillis, e2);
                            }
                        }
                    });
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    Context context = this.f21648i;
                    VersionInfoParcel versionInfoParcel = this.f21650k;
                    boolean z4 = this.f21652m;
                    zzaut zzautVarG = zzauu.G();
                    zzautVarG.j();
                    ((zzauu) zzautVarG.f34638b).I(z3);
                    String str = versionInfoParcel.f21400a;
                    zzautVarG.j();
                    ((zzauu) zzautVarG.f34638b).H(str);
                    zzauu zzauuVar = (zzauu) zzautVarG.l();
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    zzayi zzayiVarA = zzayi.a(context, zzauuVar, z4);
                    this.f21642c.set(zzayiVarA);
                    if (this.f21645f) {
                        synchronized (zzayiVarA) {
                            z = zzayiVarA.q;
                        }
                        if (!z) {
                            this.o = 1;
                            n(z3);
                        }
                    }
                } catch (NullPointerException e2) {
                    this.o = 1;
                    n(z3);
                    this.f21647h.c(2031, System.currentTimeMillis() - jCurrentTimeMillis, e2);
                }
            }
            this.n.countDown();
            this.f21648i = null;
            this.f21650k = null;
        } catch (Throwable th) {
            this.n.countDown();
            this.f21648i = null;
            this.f21650k = null;
            throw th;
        }
    }
}
