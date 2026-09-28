package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzib implements zzjf {
    public static volatile zzib E;
    public int A;
    public int B;
    public final long D;

    /* renamed from: a, reason: collision with root package name */
    public final Context f39084a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f39085b;

    /* renamed from: c, reason: collision with root package name */
    public final zzae f39086c;

    /* renamed from: d, reason: collision with root package name */
    public final zzal f39087d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhg f39088e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgt f39089f;

    /* renamed from: g, reason: collision with root package name */
    public final zzhy f39090g;

    /* renamed from: h, reason: collision with root package name */
    public final zzob f39091h;

    /* renamed from: i, reason: collision with root package name */
    public final zzpo f39092i;

    /* renamed from: j, reason: collision with root package name */
    public final zzgm f39093j;

    /* renamed from: k, reason: collision with root package name */
    public final Clock f39094k;

    /* renamed from: l, reason: collision with root package name */
    public final zzma f39095l;

    /* renamed from: m, reason: collision with root package name */
    public final zzli f39096m;
    public final zzd n;
    public final zzln o;
    public final String p;
    public zzgk q;
    public zznk r;
    public zzba s;
    public zzgh t;
    public zzlp u;
    public Boolean w;
    public long x;
    public volatile Boolean y;
    public volatile boolean z;
    public boolean v = false;
    public final AtomicInteger C = new AtomicInteger(0);

    public zzib(zzjr zzjrVar) {
        Preconditions.checkNotNull(zzjrVar);
        Context context = zzjrVar.f39212a;
        zzae zzaeVar = new zzae();
        this.f39086c = zzaeVar;
        zzfr.f38891a = zzaeVar;
        this.f39084a = context;
        this.f39085b = zzjrVar.f39216e;
        this.y = zzjrVar.f39213b;
        this.p = zzjrVar.f39218g;
        this.z = true;
        com.google.android.gms.internal.measurement.zzkl.b(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.f39094k = defaultClock;
        Long l2 = zzjrVar.f39217f;
        this.D = l2 != null ? l2.longValue() : defaultClock.currentTimeMillis();
        zzal zzalVar = new zzal(this);
        zzalVar.f38690d = zzaj.f38687a;
        this.f39087d = zzalVar;
        zzhg zzhgVar = new zzhg(this);
        zzhgVar.j();
        this.f39088e = zzhgVar;
        zzgt zzgtVar = new zzgt(this);
        zzgtVar.j();
        this.f39089f = zzgtVar;
        zzpo zzpoVar = new zzpo(this);
        zzpoVar.j();
        this.f39092i = zzpoVar;
        this.f39093j = new zzgm(new zzjq(this, zzjrVar));
        this.n = new zzd(this);
        zzma zzmaVar = new zzma(this);
        zzmaVar.i();
        this.f39095l = zzmaVar;
        zzli zzliVar = new zzli(this);
        zzliVar.i();
        this.f39096m = zzliVar;
        zzob zzobVar = new zzob(this);
        zzobVar.i();
        this.f39091h = zzobVar;
        zzln zzlnVar = new zzln(this);
        zzlnVar.j();
        this.o = zzlnVar;
        zzhy zzhyVar = new zzhy(this);
        zzhyVar.j();
        this.f39090g = zzhyVar;
        com.google.android.gms.internal.measurement.zzdd zzddVar = zzjrVar.f39215d;
        boolean z = zzddVar == null || zzddVar.f36832b == 0;
        if (context.getApplicationContext() instanceof Application) {
            k(zzliVar);
            if (zzliVar.f39180a.f39084a.getApplicationContext() instanceof Application) {
                Application application = (Application) zzliVar.f39180a.f39084a.getApplicationContext();
                if (zzliVar.f39315c == null) {
                    zzliVar.f39315c = new zzkx(zzliVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzliVar.f39315c);
                    application.registerActivityLifecycleCallbacks(zzliVar.f39315c);
                    zzgt zzgtVar2 = zzliVar.f39180a.f39089f;
                    l(zzgtVar2);
                    zzgtVar2.n.a("Registered activity lifecycle callback");
                }
            }
        } else {
            l(zzgtVar);
            zzgtVar.f38961i.a("Application context is not an Application");
        }
        zzhyVar.p(new zzhz(this, zzjrVar));
    }

    public static final void i(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void j(zzjd zzjdVar) {
        if (zzjdVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void k(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzgVar.f38915b) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzgVar.getClass())));
        }
    }

    public static final void l(zzje zzjeVar) {
        if (zzjeVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzjeVar.f39181b) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzjeVar.getClass())));
        }
    }

    public static zzib r(Context context, com.google.android.gms.internal.measurement.zzdd zzddVar, Long l2) {
        Bundle bundle;
        if (zzddVar != null) {
            Bundle bundle2 = zzddVar.f36834d;
            zzddVar = new com.google.android.gms.internal.measurement.zzdd(zzddVar.f36831a, zzddVar.f36832b, zzddVar.f36833c, bundle2, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (E == null) {
            synchronized (zzib.class) {
                try {
                    if (E == null) {
                        E = new zzib(new zzjr(context, zzddVar, l2));
                    }
                } finally {
                }
            }
        } else if (zzddVar != null && (bundle = zzddVar.f36834d) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(E);
            E.y = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(E);
        return E;
    }

    public final boolean a() {
        return g() == 0;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzgt b() {
        zzgt zzgtVar = this.f39089f;
        l(zzgtVar);
        return zzgtVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzhy c() {
        zzhy zzhyVar = this.f39090g;
        l(zzhyVar);
        return zzhyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzae d() {
        return this.f39086c;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final Context e() {
        return this.f39084a;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final Clock f() {
        return this.f39094k;
    }

    public final int g() {
        zzhy zzhyVar = this.f39090g;
        l(zzhyVar);
        zzhyVar.g();
        zzal zzalVar = this.f39087d;
        if (zzalVar.t()) {
            return 1;
        }
        l(zzhyVar);
        zzhyVar.g();
        if (!this.z) {
            return 8;
        }
        zzhg zzhgVar = this.f39088e;
        j(zzhgVar);
        zzhgVar.g();
        Boolean boolValueOf = zzhgVar.k().contains("measurement_enabled") ? Boolean.valueOf(zzhgVar.k().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        zzae zzaeVar = zzalVar.f39180a.f39086c;
        Boolean boolS = zzalVar.s("firebase_analytics_collection_enabled");
        return boolS != null ? boolS.booleanValue() ? 0 : 4 : (this.y == null || this.y.booleanValue()) ? 0 : 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h() {
        /*
            r6 = this;
            boolean r0 = r6.v
            if (r0 == 0) goto L93
            com.google.android.gms.measurement.internal.zzhy r0 = r6.f39090g
            l(r0)
            r0.g()
            java.lang.Boolean r0 = r6.w
            com.google.android.gms.common.util.Clock r1 = r6.f39094k
            if (r0 == 0) goto L31
            long r2 = r6.x
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L31
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L8c
            long r2 = r1.elapsedRealtime()
            long r4 = r6.x
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L8c
        L31:
            long r0 = r1.elapsedRealtime()
            r6.x = r0
            com.google.android.gms.measurement.internal.zzpo r0 = r6.f39092i
            j(r0)
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r0.C(r1)
            r2 = 0
            if (r1 == 0) goto L72
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r0.C(r1)
            if (r1 == 0) goto L72
            android.content.Context r1 = r6.f39084a
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)
            boolean r3 = r3.isCallerInstantApp()
            r4 = 1
            if (r3 != 0) goto L71
            com.google.android.gms.measurement.internal.zzal r3 = r6.f39087d
            boolean r3 = r3.j()
            if (r3 != 0) goto L71
            boolean r3 = com.google.android.gms.measurement.internal.zzpo.V(r1)
            if (r3 == 0) goto L72
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            boolean r1 = com.google.android.gms.measurement.internal.zzpo.z(r1)
            if (r1 == 0) goto L72
        L71:
            r2 = r4
        L72:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r6.w = r1
            if (r2 == 0) goto L8c
            com.google.android.gms.measurement.internal.zzgh r1 = r6.q()
            java.lang.String r1 = r1.n()
            boolean r0 = r0.k(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.w = r0
        L8c:
            java.lang.Boolean r0 = r6.w
            boolean r0 = r0.booleanValue()
            return r0
        L93:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "AppMeasurement is not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.h():boolean");
    }

    public final zzgm m() {
        return this.f39093j;
    }

    public final zzgk n() {
        k(this.q);
        return this.q;
    }

    public final zznk o() {
        k(this.r);
        return this.r;
    }

    public final zzba p() {
        l(this.s);
        return this.s;
    }

    public final zzgh q() {
        k(this.t);
        return this.t;
    }
}
