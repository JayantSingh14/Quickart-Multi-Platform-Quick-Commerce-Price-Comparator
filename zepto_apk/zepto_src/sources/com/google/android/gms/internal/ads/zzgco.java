package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzgco implements zzgcf, zzgcb, zzgcu {
    public static final zzied t;

    /* renamed from: a, reason: collision with root package name */
    public final Context f32266a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgbj f32267b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f32268c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgbc f32269d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f32270e;

    /* renamed from: f, reason: collision with root package name */
    public final String f32271f;

    /* renamed from: g, reason: collision with root package name */
    public final long f32272g;

    /* renamed from: h, reason: collision with root package name */
    public final long f32273h;

    /* renamed from: i, reason: collision with root package name */
    public final double f32274i;

    /* renamed from: j, reason: collision with root package name */
    public final String f32275j;

    /* renamed from: k, reason: collision with root package name */
    public final long f32276k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f32277l = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    public final Object f32278m = new Object();
    public final Object n = new Object();
    public final Object o = new Object();
    public final zzauv p = zzauw.C();
    public final ArrayList q = new ArrayList();
    public boolean r = false;
    public final HashMap s = new HashMap();

    static {
        zziec zziecVarC = zzied.C();
        zziecVarC.j();
        ((zzied) zziecVarC.f34638b).D(17);
        t = (zzied) zziecVarC.l();
    }

    public zzgco(Context context, zzgbj zzgbjVar, ExecutorService executorService, zzgbc zzgbcVar, Random random, String str, long j2, long j3, double d2, String str2, long j4) {
        this.f32266a = context;
        this.f32267b = zzgbjVar;
        this.f32268c = executorService;
        this.f32269d = zzgbcVar;
        this.f32271f = str;
        this.f32272g = j2;
        this.f32273h = j3;
        this.f32274i = d2;
        this.f32275j = str2;
        this.f32276k = j4;
        this.f32270e = random.nextDouble() < d2;
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final void a(zzgct zzgctVar) {
        synchronized (this.f32278m) {
            zzauv zzauvVar = this.p;
            String strZza = zzgctVar.zza();
            zzauvVar.j();
            ((zzauw) zzauvVar.f34638b).M(strZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void b(int i2, long j2, String str, Throwable th) {
        long jLongValue;
        if (this.f32270e) {
            synchronized (this.n) {
                try {
                    ArrayList arrayList = this.q;
                    synchronized (this.o) {
                        try {
                            HashMap map = this.s;
                            Integer numValueOf = Integer.valueOf(i2);
                            Long l2 = (Long) map.get(numValueOf);
                            if (l2 == null) {
                                l2 = 0L;
                            }
                            jLongValue = 1 + l2.longValue();
                            map.put(numValueOf, Long.valueOf(jLongValue));
                        } finally {
                        }
                    }
                    arrayList.add(new zzgcl(i2, j2, th, str, jLongValue));
                    if (!this.r) {
                        this.r = true;
                        this.f32267b.a(this.f32273h, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgcn
                            @Override // java.lang.Runnable
                            public final void run() throws IOException {
                                zzauv zzauvVar;
                                zzgtd zzgtdVarR;
                                String string;
                                zzgco zzgcoVar = this.f32265a;
                                synchronized (zzgcoVar.f32278m) {
                                    zzauv zzauvVar2 = zzgcoVar.p;
                                    zzial zzialVar = (zzial) zzauvVar2.f34637a.y(zziaq.f34644e, null);
                                    zzialVar.f34638b = zzauvVar2.n0();
                                    zzauvVar = (zzauv) zzialVar;
                                }
                                synchronized (zzgcoVar.n) {
                                    ArrayList arrayList2 = zzgcoVar.q;
                                    zzgtdVarR = zzgtd.r(arrayList2);
                                    arrayList2.clear();
                                    zzgcoVar.r = false;
                                }
                                int size = zzgtdVarR.size();
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < size) {
                                    zzgcl zzgclVar = (zzgcl) zzgtdVarR.get(i3);
                                    if (i4 >= zzgcoVar.f32272g) {
                                        zzgcoVar.c((zzauw) zzauvVar.l());
                                        zzauvVar.j();
                                        ((zzauw) zzauvVar.f34638b).E();
                                        i4 = 0;
                                    }
                                    zzavn zzavnVarC = zzavo.C();
                                    long j3 = zzgclVar.f32259a;
                                    zzavnVarC.j();
                                    ((zzavo) zzavnVarC.f34638b).D(j3);
                                    long j4 = zzgclVar.f32260b;
                                    zzavnVarC.j();
                                    ((zzavo) zzavnVarC.f34638b).E(j4);
                                    long j5 = zzgclVar.f32263e;
                                    zzavnVarC.j();
                                    ((zzavo) zzavnVarC.f34638b).H(j5);
                                    String str2 = zzgclVar.f32262d;
                                    if (str2 != null) {
                                        zzavnVarC.j();
                                        ((zzavo) zzavnVarC.f34638b).I(str2);
                                    }
                                    Throwable th2 = zzgclVar.f32261c;
                                    int i5 = th2 == null ? 2 : 3;
                                    zzavnVarC.j();
                                    ((zzavo) zzavnVarC.f34638b).J(i5);
                                    if (th2 != null) {
                                        String name = th2.getClass().getName();
                                        zzavnVarC.j();
                                        ((zzavo) zzavnVarC.f34638b).F(name);
                                        try {
                                            StringWriter stringWriter = new StringWriter();
                                            try {
                                                PrintWriter printWriter = new PrintWriter(stringWriter);
                                                try {
                                                    th2.printStackTrace(printWriter);
                                                    string = stringWriter.toString();
                                                    printWriter.close();
                                                    stringWriter.close();
                                                } catch (Throwable th3) {
                                                    try {
                                                        printWriter.close();
                                                    } catch (Throwable th4) {
                                                        th3.addSuppressed(th4);
                                                    }
                                                    throw th3;
                                                }
                                            } catch (Throwable th5) {
                                                try {
                                                    stringWriter.close();
                                                } catch (Throwable th6) {
                                                    th5.addSuppressed(th6);
                                                }
                                                throw th5;
                                            }
                                        } catch (IOException unused) {
                                            string = "";
                                        }
                                        zzavnVarC.j();
                                        ((zzavo) zzavnVarC.f34638b).G(string);
                                    }
                                    zzavo zzavoVar = (zzavo) zzavnVarC.l();
                                    zzauvVar.j();
                                    ((zzauw) zzauvVar.f34638b).D(zzavoVar);
                                    i3++;
                                    i4++;
                                }
                                if (i4 > 0) {
                                    zzgcoVar.c((zzauw) zzauvVar.l());
                                    zzauvVar.j();
                                    ((zzauw) zzauvVar.f34638b).E();
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void c(zzauw zzauwVar) {
        try {
            zzgcj zzgcjVarC = zzgck.C();
            zzied zziedVar = t;
            zzgcjVarC.j();
            ((zzgck) zzgcjVarC.f34638b).E(zziedVar);
            zzgch zzgchVarC = zzgci.C();
            zzgchVarC.j();
            ((zzgci) zzgchVarC.f34638b).D(zzauwVar);
            zzgci zzgciVar = (zzgci) zzgchVarC.l();
            zzgcjVarC.j();
            ((zzgck) zzgcjVarC.f34638b).D(zzgciVar);
            this.f32269d.b(this.f32271f, ((zzgck) zzgcjVarC.l()).g());
        } catch (RuntimeException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final ListenableFuture zza() {
        zzgzl zzgzlVar = new zzgzl(Executors.callable(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgcm
            @Override // java.lang.Runnable
            public final void run() {
                int i2;
                zzgco zzgcoVar = this.f32264a;
                if (!zzgcoVar.f32270e || zzgcoVar.f32277l.getAndSet(true)) {
                    return;
                }
                Context context = zzgcoVar.f32266a;
                String str = zzgcoVar.f32275j;
                double d2 = zzgcoVar.f32274i;
                long j2 = zzgcoVar.f32276k;
                Locale locale = Locale.getDefault();
                zzauv zzauvVarC = zzauw.C();
                long j3 = Build.VERSION.SDK_INT;
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).F(j3);
                String str2 = Build.MODEL;
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).G(str2);
                String language = locale.getLanguage();
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).H(language);
                String country = locale.getCountry();
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).I(country);
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).L(str);
                String packageName = context.getPackageName();
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).J(packageName);
                zzauvVarC.j();
                ((zzauw) zzauvVarC.f34638b).O(j2);
                if (d2 > 0.0d) {
                    zzauvVarC.j();
                    ((zzauw) zzauvVarC.f34638b).N((int) (1.0d / d2));
                }
                PackageManager packageManager = context.getPackageManager();
                try {
                    long j4 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                    zzauvVarC.j();
                    ((zzauw) zzauvVarC.f34638b).K(j4);
                } catch (Exception unused) {
                }
                try {
                    if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                        i2 = 5;
                    } else if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                        i2 = 4;
                    } else if (packageManager.hasSystemFeature("android.hardware.type.pc")) {
                        i2 = 7;
                    } else {
                        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
                        i2 = (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) ? 2 : 6;
                    }
                    zzauvVarC.j();
                    ((zzauw) zzauvVarC.f34638b).P(i2);
                } catch (RuntimeException unused2) {
                }
                zzauw zzauwVar = (zzauw) zzauvVarC.l();
                synchronized (zzgcoVar.f32278m) {
                    zzgcoVar.p.m(zzauwVar);
                }
            }
        }, null));
        this.f32268c.execute(zzgzlVar);
        return zzgzlVar;
    }
}
