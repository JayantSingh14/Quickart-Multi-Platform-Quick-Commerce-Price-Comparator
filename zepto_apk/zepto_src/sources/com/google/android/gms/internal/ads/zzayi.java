package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public final class zzayi implements zzayl {
    public static zzayi r;

    /* renamed from: a, reason: collision with root package name */
    public final Context f24475a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfvp f24476b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfvw f24477c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfvy f24478d;

    /* renamed from: e, reason: collision with root package name */
    public final zzazn f24479e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfuf f24480f;

    /* renamed from: g, reason: collision with root package name */
    public final ExecutorService f24481g;

    /* renamed from: h, reason: collision with root package name */
    public final zzbbq f24482h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfvv f24483i;

    /* renamed from: k, reason: collision with root package name */
    public final zzbac f24485k;

    /* renamed from: l, reason: collision with root package name */
    public final zzazu f24486l;

    /* renamed from: m, reason: collision with root package name */
    public final zzazl f24487m;
    public volatile boolean p;
    public volatile boolean q;
    public volatile long n = 0;
    public final Object o = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final CountDownLatch f24484j = new CountDownLatch(1);

    public zzayi(Context context, zzfuf zzfufVar, zzfvp zzfvpVar, zzfvw zzfvwVar, zzfvy zzfvyVar, zzazn zzaznVar, ExecutorService executorService, zzfua zzfuaVar, zzbbq zzbbqVar, zzbac zzbacVar, zzazu zzazuVar, zzazl zzazlVar) {
        this.q = false;
        this.f24475a = context;
        this.f24480f = zzfufVar;
        this.f24476b = zzfvpVar;
        this.f24477c = zzfvwVar;
        this.f24478d = zzfvyVar;
        this.f24479e = zzaznVar;
        this.f24481g = executorService;
        this.f24482h = zzbbqVar;
        this.f24485k = zzbacVar;
        this.f24486l = zzazuVar;
        this.f24487m = zzazlVar;
        this.q = false;
        this.f24483i = new zzayg(this, zzfuaVar);
    }

    public static synchronized zzayi a(Context context, zzauu zzauuVar, boolean z) {
        zzfuj zzfujVar;
        zzfujVar = new zzfuj();
        zzfujVar.f31878b = false;
        byte b2 = (byte) (zzfujVar.f31882f | 1);
        zzfujVar.f31879c = true;
        zzfujVar.f31880d = 100L;
        zzfujVar.f31881e = 300L;
        zzfujVar.f31882f = (byte) (((byte) (((byte) (((byte) (((byte) (b2 | 2)) | 4)) | 8)) | 16)) | 32);
        String strC = zzauuVar.C();
        if (strC == null) {
            throw new NullPointerException("Null clientVersion");
        }
        zzfujVar.f31877a = strC;
        zzfujVar.f31878b = zzauuVar.D();
        zzfujVar.f31882f = (byte) (zzfujVar.f31882f | 1);
        return n(context, Executors.newCachedThreadPool(), zzfujVar.a(), z);
    }

    public static synchronized zzayi n(Context context, ExecutorService executorService, zzfuh zzfuhVar, boolean z) {
        try {
            if (r == null) {
                zzfuf zzfufVarA = zzfuf.a(context, executorService, z);
                zzbgb zzbgbVar = zzbgk.Y3;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                zzayw zzaywVarA = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() ? zzayw.a(context) : null;
                zzbac zzbacVarA = ((Boolean) zzbdVar.f21153c.a(zzbgk.Z3)).booleanValue() ? zzbac.a(context, executorService) : null;
                zzazu zzazuVar = ((Boolean) zzbdVar.f21153c.a(zzbgk.h3)).booleanValue() ? new zzazu() : null;
                zzazl zzazlVar = ((Boolean) zzbdVar.f21153c.a(zzbgk.q3)).booleanValue() ? new zzazl() : null;
                final zzfuv zzfuvVar = new zzfuv(context, executorService, zzfufVarA, new zzfur());
                Task taskC = Tasks.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzfut
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() throws PackageManager.NameNotFoundException {
                        Context context2 = zzfuvVar.f31911a;
                        return zzfum.a(context2, context2.getPackageName(), Integer.toString(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode));
                    }
                }, executorService);
                taskC.d(executorService, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfus
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final /* synthetic */ void onFailure(Exception exc) {
                        zzfuv zzfuvVar2 = zzfuvVar;
                        if (exc instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        zzfuvVar2.f31913c.c(2025, -1L, exc);
                    }
                });
                zzfuvVar.f31914d = taskC;
                zzazm zzazmVar = new zzazm(context);
                zzazn zzaznVar = new zzazn(zzfuhVar, zzfuvVar, new zzbaa(context, zzazmVar), zzazmVar, zzaywVarA, zzbacVarA, zzazuVar, zzazlVar);
                zzbbq zzbbqVarB = zzfvc.b(context, zzfufVarA);
                zzfua zzfuaVar = new zzfua();
                zzayi zzayiVar = new zzayi(context, zzfufVarA, new zzfvp(context, zzbbqVarB), new zzfvw(context, zzbbqVarB, new zzayf(zzfufVarA), ((Boolean) zzbdVar.f21153c.a(zzbgk.R2)).booleanValue()), new zzfvy(context, zzaznVar, zzfufVarA, zzfuaVar, false), zzaznVar, executorService, zzfuaVar, zzbbqVarB, zzbacVarA, zzazuVar, zzazlVar);
                r = zzayiVar;
                zzayiVar.k();
                r.l();
            }
        } catch (Throwable th) {
            throw th;
        }
        return r;
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void b(int i2, int i3, int i4) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.dd)).booleanValue() || (displayMetrics = this.f24475a.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f2 = i2;
        float f3 = displayMetrics.density;
        float f4 = i3;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f2 * f3, f4 * f3, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        f(motionEventObtain);
        motionEventObtain.recycle();
        float f5 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f2 * f5, f4 * f5, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        f(motionEventObtain2);
        motionEventObtain2.recycle();
        float f6 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i4, 1, f2 * f6, f4 * f6, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        f(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String c(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String d(Context context) {
        zzbac zzbacVar = this.f24485k;
        if (zzbacVar != null && zzbacVar.f24625d) {
            zzbacVar.f24623b = System.currentTimeMillis();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
            zzazu zzazuVar = this.f24486l;
            zzazuVar.f24572b = zzazuVar.f24571a;
            zzazuVar.f24571a = SystemClock.uptimeMillis();
        }
        l();
        zzfui zzfuiVarB = this.f24478d.b();
        if (zzfuiVarB == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = ((zzfvn) zzfuiVarB).a(context);
        this.f24480f.e(5001, System.currentTimeMillis() - jCurrentTimeMillis, null, strA, null);
        return strA;
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String e(Context context, String str, View view) {
        return g(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void f(MotionEvent motionEvent) {
        zzfui zzfuiVarB = this.f24478d.b();
        if (zzfuiVarB != null) {
            try {
                ((zzfvn) zzfuiVarB).d(motionEvent);
            } catch (zzfvx e2) {
                this.f24480f.c(e2.f31955a, -1L, e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String g(Context context, String str, View view, Activity activity) {
        zzbac zzbacVar = this.f24485k;
        if (zzbacVar != null && zzbacVar.f24625d) {
            zzbacVar.f24623b = System.currentTimeMillis();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
            zzazu zzazuVar = this.f24486l;
            zzazuVar.f24578h = zzazuVar.f24577g;
            zzazuVar.f24577g = SystemClock.uptimeMillis();
        }
        l();
        zzfui zzfuiVarB = this.f24478d.b();
        if (zzfuiVarB == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strC = ((zzfvn) zzfuiVarB).c(context, str, view, activity);
        this.f24480f.e(5000, System.currentTimeMillis() - jCurrentTimeMillis, null, strC, null);
        return strC;
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void h(StackTraceElement[] stackTraceElementArr) {
        zzazl zzazlVar = this.f24487m;
        if (zzazlVar != null) {
            zzazlVar.f24540a = new ArrayList(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void i(View view) {
        this.f24479e.f24544c.a(view);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String j(Context context, View view, Activity activity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzbac zzbacVar = this.f24485k;
        if (zzbacVar != null && zzbacVar.f24625d) {
            zzbacVar.f24623b = System.currentTimeMillis();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
            this.f24486l.a(context, view);
        }
        l();
        zzfui zzfuiVarB = this.f24478d.b();
        if (zzfuiVarB == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strB = ((zzfvn) zzfuiVarB).b(context, view, activity);
        this.f24480f.e(5002, System.currentTimeMillis() - jCurrentTimeMillis, null, strB, null);
        return strB;
    }

    public final synchronized void k() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfvo zzfvoVarO = o();
        if (zzfvoVarO == null) {
            this.f24480f.b(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.f24478d.a(zzfvoVarO)) {
            this.q = true;
            this.f24484j.countDown();
        }
    }

    public final void l() {
        zzfvo zzfvoVar;
        if (this.p) {
            return;
        }
        synchronized (this.o) {
            try {
                if (!this.p) {
                    if ((System.currentTimeMillis() / 1000) - this.n < 3600) {
                        return;
                    }
                    zzfvy zzfvyVar = this.f24478d;
                    synchronized (zzfvyVar.f31963g) {
                        try {
                            zzfvn zzfvnVar = zzfvyVar.f31962f;
                            zzfvoVar = zzfvnVar != null ? zzfvnVar.f31928b : null;
                        } finally {
                        }
                    }
                    if ((zzfvoVar == null || zzfvoVar.f31932a.E() - (System.currentTimeMillis() / 1000) < 3600) && zzfvc.a(this.f24482h)) {
                        this.f24481g.execute(new zzayh(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m() {
        String strC;
        String strD;
        int length;
        zzfvo zzfvoVarO;
        zzbby zzbbyVar;
        boolean zA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfvo zzfvoVarO2 = o();
        if (zzfvoVarO2 != null) {
            strC = zzfvoVarO2.f31932a.C();
            strD = zzfvoVarO2.f31932a.D();
        } else {
            strC = null;
            strD = null;
        }
        try {
            try {
                Context context = this.f24475a;
                zzbbq zzbbqVar = this.f24482h;
                zzfuf zzfufVar = this.f24480f;
                zzfvt zzfvtVarA = zzfuo.a(context, zzbbqVar, strC, strD, zzfufVar);
                byte[] bArr = zzfvtVarA.f31947b;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzfufVar.b(5009, System.currentTimeMillis() - jCurrentTimeMillis);
                } else {
                    try {
                        zzhzl zzhzlVarV = zzhzl.v(0, bArr, length);
                        zziab zziabVar = zziab.f34620b;
                        int i2 = zzhyy.f34536a;
                        zzbbs zzbbsVarF = zzbbs.F(zzhzlVarV, zziab.f34621c);
                        if (zzbbsVarF.C().C().isEmpty() || zzbbsVarF.C().D().isEmpty() || zzbbsVarF.E().z().length == 0 || ((zzfvoVarO = o()) != null && (zzbbyVar = zzfvoVarO.f31932a) != null && zzbbsVarF.C().C().equals(zzbbyVar.C()) && zzbbsVarF.C().D().equals(zzbbyVar.D()))) {
                            this.f24480f.b(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                        } else {
                            zzfvv zzfvvVar = this.f24483i;
                            int i3 = zzfvtVarA.f31948c;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P2)).booleanValue()) {
                                zA = this.f24476b.a(zzbbsVarF, zzfvvVar);
                            } else if (i3 == 3) {
                                zA = this.f24477c.b(zzbbsVarF);
                            } else {
                                if (i3 == 4) {
                                    zA = this.f24477c.a(zzbbsVarF, zzfvvVar);
                                }
                                this.f24480f.b(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                            if (zA) {
                                zzfvo zzfvoVarO3 = o();
                                if (zzfvoVarO3 != null) {
                                    if (this.f24478d.a(zzfvoVarO3)) {
                                        this.q = true;
                                    }
                                    this.n = System.currentTimeMillis() / 1000;
                                }
                            } else {
                                this.f24480f.b(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                    } catch (NullPointerException unused) {
                        this.f24480f.b(2030, System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
            } catch (Throwable th) {
                this.f24484j.countDown();
                throw th;
            }
        } catch (zzibg e2) {
            this.f24480f.c(4002, System.currentTimeMillis() - jCurrentTimeMillis, e2);
        }
        this.f24484j.countDown();
    }

    public final zzfvo o() throws IllegalArgumentException {
        if (zzfvc.a(this.f24482h)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P2)).booleanValue()) {
                zzfvw zzfvwVar = this.f24477c;
                long jCurrentTimeMillis = System.currentTimeMillis();
                synchronized (zzfvw.f31949f) {
                    try {
                        zzbby zzbbyVarF = zzfvwVar.f(1);
                        if (zzbbyVarF == null) {
                            zzfvwVar.e(4022, jCurrentTimeMillis);
                            return null;
                        }
                        File fileC = zzfvwVar.c(zzbbyVarF.C());
                        File file = new File(fileC, "pcam.jar");
                        if (!file.exists()) {
                            file = new File(fileC, "pcam");
                        }
                        File file2 = new File(fileC, "pcbc");
                        File file3 = new File(fileC, "pcopt");
                        zzfvwVar.e(5016, jCurrentTimeMillis);
                        return new zzfvo(zzbbyVarF, file, file2, file3);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            zzfvp zzfvpVar = this.f24476b;
            zzbby zzbbyVarB = zzfvpVar.b(1);
            if (zzbbyVarB != null) {
                String strC = zzbbyVarB.C();
                File fileA = zzfvq.a(zzfvpVar.c(), strC, "pcam.jar");
                if (!fileA.exists()) {
                    fileA = zzfvq.a(zzfvpVar.c(), strC, "pcam");
                }
                return new zzfvo(zzbbyVarB, fileA, zzfvq.a(zzfvpVar.c(), strC, "pcbc"), zzfvq.a(zzfvpVar.c(), strC, "pcopt"));
            }
        }
        return null;
    }
}
