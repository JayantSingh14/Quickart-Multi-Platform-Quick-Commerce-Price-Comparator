package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class zzct extends zzcr {
    public static zzcz A = null;
    public static zzed B = null;
    public static final Object x = new Object();
    public static boolean y = false;
    public static long z;
    public final String u;
    public zzeb v;
    public final HashMap w;

    public zzct(Context context) {
        super(context);
        this.w = new HashMap();
        this.u = "";
    }

    public static zzdu k(Context context, boolean z2) {
        if (zzcr.t == null) {
            synchronized (x) {
                try {
                    if (zzcr.t == null) {
                        zzdu zzduVarB = zzdu.b(context, z2);
                        if (zzduVarB.p) {
                            try {
                                if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.n)).booleanValue()) {
                                    zzduVarB.d("hwvIMOeohSBrCWT4pVkQok22g/l0cZbbqOTmNbjObWwcwhLlaFMNibQmd2cIB1Vb", "24f7+wNdQe8HQwz0gPH2QIzxUp8iQNA20yBU7Dg74Sc=", new Class[0]);
                                }
                            } catch (IllegalStateException unused) {
                            }
                            zzduVarB.d("ysEnh8zkgcN8WwINs5FP7vGybZW2TtVSX36HO6emvdUrcCkVbC9hrF5Pe5ZSZx3i", "3LpdW89cIASEFv5WvS5ZDEWsiVGQitP33SL3WZgJ6zE=", Context.class);
                            zzduVarB.d("joxZSCFIfSio2J1Z0g3HMtlcDGNvogfMyrj1e2b+qPNv6DXnDVXfwkgCXW9zFWFC", "iJiFXDBrMwFOGpG8WmWNKc3sGwXbWv8N6fPQac0mMm0=", Context.class);
                            zzduVarB.d("tPxcLkiesd8JzrYIyuRbLGxWAQfsX+C1jrJaS2rsRu6lU/ve1b9hEzSSzo6VwqXx", "0RWQk7vrKrAXtxwBYq7T9nI/JnUnK0yiZtx30+mk7/g=", Context.class);
                            zzduVarB.d("C6OPKdOx6rUdfDdOmaUimt8yM1FrOv7bKCITdJ0Uo74WwXDfvXouJ4oz4kHBjTSk", "dTWRHHPyYq/fNXOTAS/wjayGzv2SlrSwyDcB+vX+h5Q=", Context.class);
                            zzduVarB.d("Ls+ZUCEdSGy+47NpfWc5WNy2WCTB2lhysvWY8PCvkdyqiw8HkO3XVSxwPIsY4tvv", "1yJaDnXEM3em29nHb3kYjIOvpW6Mkce5Fji3syGd7T0=", Context.class);
                            Class cls = Boolean.TYPE;
                            zzduVarB.d("vkfQoQl1Rxr7/uvSSRcOrQI31A6S/KAPW33nf5P0hYbuVy6BLjHzjUB4OEnneXoS", "SfaCE2ReDSQ3+KDKcvA6SSrX7nuWYsM/FN3ZFmlH0dA=", Context.class, cls);
                            zzduVarB.d("6CWPidOWJZFxRWI8V7yi3OiMbOhIWZX/jTayTGRwqCM0W8dtKHQOPe60TuQicfhG", "gYPijpNio6OwLgbzbH6IuWSNtvp7bCV5UMbKZJCVNdg=", Context.class);
                            zzduVarB.d("6vt+8E5GP5AwoxquDM0Y7lVJzS23/VCjNo5D8xB8rgAaaF6IhToGZhlIAUkgigHl", "jx9F7EAIAhvEI8G+/hWsHBitt0z+K8moFRn7/w45eYc=", Context.class);
                            zzduVarB.d("tVSI3GZQAGRITfe/VNiB0JAqJe5Pfq0lPruET3IJQ2F3N6dl8hPg+ZOAK3nXD45u", "1VeJuVnEfsh9S8+TnOEDCfIzscTATtniwvJaQ7/W6I8=", MotionEvent.class, DisplayMetrics.class);
                            zzduVarB.d("CkzLLxV5zSb+jeaEDnt9Q3eBrpVMtqnw6wBKNocN2YzoApdHEqHkRi4x0VOMDtd4", "nVNp1WYfnkUt4CgZM9ftj8WNocg8ldySiFlqCJaJia4=", MotionEvent.class, DisplayMetrics.class);
                            zzduVarB.d("zwwnNjW/9dn+p0q/2u+mmA6XQB8+gtknmtJMKP3tBmoncBehPCILsKxRnck9yFjA", "vpqgk7W2OO4+emKKnTSxckIsP1c64LGVSWcdsnDvr3w=", new Class[0]);
                            zzduVarB.d("5BhEc19mhLCb3gixLpO/usqpdcrz8iDHUvKRNr8tUAX9rUzF0wog6vEOJrftvcpW", "yZHUQ89G8fTgEsMNs0hBrXwZIrb4VL1iE12C/t/Y3UE=", new Class[0]);
                            zzduVarB.d("Cv0JAL9ptzpRvgIi9AFTFGn0l5MhpPgpRN4VfZybymKMuiqBn9AG0bgJaX/QotAk", "/xONYRXeBwNZknPQ1yARx5KZSPQPbfL2mKAb1nbkf2s=", new Class[0]);
                            zzduVarB.d("XFxH1z0dBuMDP7aWA+P/3WKwW9qr8sC2ASjEfciaKHfSLryjCNl4cmJgfsh2Tylb", "r0MNv9zqwvoUwASL1pBJjOA1OkDa8Kcs5NaA6VOkJEI=", new Class[0]);
                            zzduVarB.d("N0mA2OgFUnHXhnZTWHrO10/LZw/fChWm76LMkbZzvR9G3lxQkMoE65IWMn9zBWSu", "uxIInGM9FQ+1gujg5A7z9IJxIqStl6tvqqzSbuEi494=", new Class[0]);
                            zzduVarB.d("sdX902x/AS9226TxUXaqji9wP1uHqRQA8nkg2YMN1TcruTTaw008l9z5V3jZGjLO", "z3i9M2k4RJ/f7GArNBcGbUcpUFpuRmLev6S20UO7Vqs=", new Class[0]);
                            zzduVarB.d("hhtrMjcGMTQSGdrv1+l2gakNTe0Pfchc8VT5kRHtsehlafuJ8JEE4iewNV4y5I/U", "o5W1eROpLyVNcsDGW3Y0lGc2x/V+mDPvMXouv3gbW6M=", Context.class, cls, String.class);
                            zzduVarB.d("d2tnKFzXPwiZyQGi+81r0jKuUmc/wF2bs8mf3rZLUgisIeswnimQDm/skPYjpEo4", "e/DvqiTz4SkFtBEBn/3V8Pr2h2slHO4xuLOBAItCJ4w=", StackTraceElement[].class);
                            zzduVarB.d("xcWDoPM3ZfO4P10VSUmZKRTMvsXPXnglJL31bwAJBgJGdSUy2IQG17s4MILOncV2", "9rXsTdb/WXYONX554dN5CJ2eqpcy9gFPMPi8uAjaHTA=", View.class, DisplayMetrics.class, cls, cls);
                            zzduVarB.d("RjfRn/7K/Mx2/M8Fl6a7u1D5niklht4X0VG1cOixOa4SuaPG6Qd7la4v6f0IM/MO", "cZ2qwY2ZIJRch325gepGJtH7dQ9IcqmfWvaHdfiFi6Y=", Context.class, cls);
                            zzduVarB.d("uJ6tafbdnitpIiJcEDt3zh4lzBZEYeFsW45S60suhbKyZNy2K2MuNEbuksualim4", "Cv/m6MvBjdOit7tT7cC+xPCpFEqovwYj4XIOcXUxCMs=", View.class, Activity.class, cls);
                            zzduVarB.d("mkunJHFc5vhTAVOcsaNSYx7OvFB6slgbORGrA/joIDO0IYq5rQvDcAbp2AI6CPUh", "k8GEQUoJxJPI/0jAlfeUix8QD7WaaXAfMcSQAzrpgrU=", Long.TYPE);
                            zzduVarB.d("w1mRpvC09hSNbQ10UvFXagm2P4TWR/T2KztJ+buPFQZnRnjxpdFVScAm9trUP6jM", "1tXSieficgPhud4YihA+CzunTIb+yA05iyb1BkAzMoc=", new Class[0]);
                            try {
                                if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.r)).booleanValue()) {
                                    zzduVarB.d("WepZYnT/MXyJE28LKN26NT6D3mAA2J2spDFApE1ixrQxTNXRg7wshW7BC/EU90LT", "sjYkfzJTuYKxh1jvZaP9n5dx9JGmzJotOUC/vdvgi4M=", Context.class);
                                }
                            } catch (IllegalStateException unused2) {
                            }
                            zzduVarB.d("AZwRbSS9Tjg/vY6NNyDfd3mU35mZBbQduzRpliDRt3qUNjlKylmreq0JkiCiO6dF", "lsjUo68NMWNsPUz4dBIEYtWAZHRXaEljQLBgt48XQs4=", Context.class);
                            try {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.s)).booleanValue()) {
                                        Class cls2 = Long.TYPE;
                                        zzduVarB.d("X9PgbTHLX0FFxbl3gdPDuVwcglfXy5CDrzo8siaVNaH+OIJ6JI34Wu3QK5rLega4", "JLulXGPEHVwHK+0FG96HP9my+NvwpTQbwIaIZrjn9OU=", NetworkCapabilities.class, cls2, cls2);
                                    }
                                }
                            } catch (IllegalStateException unused3) {
                            }
                            try {
                                if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.f37774k)).booleanValue()) {
                                    zzduVarB.d("RKC3mFMqGi7xOgQ7s39JMoZe9bnzGCFipcdUUf0vlgHDkBg7SvMkVmBGpwLs06ia", "8Xr1ilYJHo+oWZQAYAG91DIHBuqEmXK8yHtxL6KkyfU=", long[].class, Context.class, View.class);
                                }
                            } catch (IllegalStateException unused4) {
                            }
                        }
                        zzcr.t = zzduVarB;
                    }
                } finally {
                }
            }
        }
        return zzcr.t;
    }

    public static zzdw l(zzdu zzduVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzdm {
        Method methodC = zzduVar.c("tVSI3GZQAGRITfe/VNiB0JAqJe5Pfq0lPruET3IJQ2F3N6dl8hPg+ZOAK3nXD45u", "1VeJuVnEfsh9S8+TnOEDCfIzscTATtniwvJaQ7/W6I8=");
        if (methodC == null || motionEvent == null) {
            throw new zzdm();
        }
        try {
            return new zzdw((String) methodC.invoke(null, motionEvent, displayMetrics));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new zzdm(e2);
        }
    }

    public static synchronized void n(Context context, boolean z2) {
        try {
            if (y) {
                return;
            }
            z = System.currentTimeMillis() / 1000;
            zzcr.t = k(context, z2);
            if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.s)).booleanValue()) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                zzcz zzczVar = new zzcz();
                if (connectivityManager != null) {
                    try {
                        connectivityManager.registerDefaultNetworkCallback(new zzcy(zzczVar));
                    } catch (RuntimeException unused) {
                        synchronized (zzcz.class) {
                            zzczVar.f37604a = null;
                        }
                    }
                }
                A = zzczVar;
            }
            ExecutorService executorService = zzcr.t.f37635b;
            if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.t)).booleanValue() && executorService != null) {
                String[] strArr = zzed.f37682e;
                zzed zzedVar = new zzed();
                zzedVar.f37683a = 0L;
                zzedVar.f37684b = 0L;
                zzedVar.f37685c = -1L;
                zzedVar.f37686d = false;
                if (Build.VERSION.SDK_INT >= 30) {
                    try {
                        ((AppOpsManager) context.getSystemService("appops")).startWatchingActive(strArr, executorService, new zzec(zzedVar));
                    } catch (IllegalArgumentException | NoSuchMethodError unused2) {
                    }
                }
                B = zzedVar;
            }
            y = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final void o(List list) throws InterruptedException {
        ExecutorService executorService;
        if (zzcr.t == null || (executorService = zzcr.t.f37635b) == null || list.isEmpty()) {
            return;
        }
        try {
            executorService.invokeAll(list, ((Long) zzfv.f37741d.f37744c.a(zzgk.f37770g)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            char[] cArr = zzdx.f37659a;
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter(stringWriter));
            android.support.v4.media.a.t("class methods got exception: ", stringWriter.toString(), "zzct");
        }
    }

    @Override // com.google.android.gms.internal.pal.zzcr
    public zzr b(Context context, View view, Activity activity) throws InterruptedException {
        zzed zzedVar = B;
        if (zzedVar != null && zzedVar.f37686d) {
            zzedVar.f37684b = System.currentTimeMillis();
        }
        zzr zzrVarR = zzaf.R();
        String str = this.u;
        if (!TextUtils.isEmpty(str)) {
            zzrVarR.n(str);
        }
        m(k(context, false), zzrVarR, view, activity, true);
        return zzrVarR;
    }

    @Override // com.google.android.gms.internal.pal.zzcr
    public final zzr c(Context context, zzi zziVar) throws InterruptedException {
        zzed zzedVar = B;
        if (zzedVar != null && zzedVar.f37686d) {
            zzedVar.f37684b = System.currentTimeMillis();
        }
        zzr zzrVarR = zzaf.R();
        String str = this.u;
        if (!TextUtils.isEmpty(str)) {
            zzrVarR.n(str);
        }
        j(k(context, false), context, zzrVarR, zziVar);
        if (zziVar != null && zziVar.t()) {
            if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.f37775l)).booleanValue() && !zzdx.c(zziVar.r().r())) {
                zzar zzarVarP = zzas.p();
                String strR = zziVar.r().r();
                if (zzarVarP.f37406c) {
                    zzarVarP.k();
                    zzarVarP.f37406c = false;
                }
                zzas.q((zzas) zzarVarP.f37405b, strR);
                zzas zzasVar = (zzas) zzarVarP.h();
                if (zzrVarR.f37406c) {
                    zzrVarR.k();
                    zzrVarR.f37406c = false;
                }
                zzaf.P((zzaf) zzrVarR.f37405b, zzasVar);
            }
        }
        return zzrVarR;
    }

    @Override // com.google.android.gms.internal.pal.zzcr
    public zzr d(Context context, View view, Activity activity) throws InterruptedException {
        zzed zzedVar = B;
        if (zzedVar != null && zzedVar.f37686d) {
            zzedVar.f37684b = System.currentTimeMillis();
        }
        zzr zzrVarR = zzaf.R();
        zzrVarR.n(this.u);
        m(k(context, false), zzrVarR, view, activity, false);
        return zzrVarR;
    }

    public final long f(StackTraceElement[] stackTraceElementArr) throws zzdm {
        Method methodC = zzcr.t.c("d2tnKFzXPwiZyQGi+81r0jKuUmc/wF2bs8mf3rZLUgisIeswnimQDm/skPYjpEo4", "e/DvqiTz4SkFtBEBn/3V8Pr2h2slHO4xuLOBAItCJ4w=");
        if (methodC == null || stackTraceElementArr == null) {
            throw new zzdm();
        }
        try {
            return new zzdn((String) methodC.invoke(null, stackTraceElementArr)).f37622a.longValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new zzdm(e2);
        }
    }

    public final zzdw g(MotionEvent motionEvent) throws zzdm {
        Method methodC = zzcr.t.c("CkzLLxV5zSb+jeaEDnt9Q3eBrpVMtqnw6wBKNocN2YzoApdHEqHkRi4x0VOMDtd4", "nVNp1WYfnkUt4CgZM9ftj8WNocg8ldySiFlqCJaJia4=");
        if (methodC == null || motionEvent == null) {
            throw new zzdm();
        }
        try {
            return new zzdw((String) methodC.invoke(null, motionEvent, this.s));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new zzdm(e2);
        }
    }

    public final synchronized void h(zzdu zzduVar, zzr zzrVar) {
        MotionEvent motionEvent;
        try {
            try {
                zzdw zzdwVarL = l(zzduVar, this.f37583a, this.s);
                Long l2 = zzdwVarL.f37648a;
                if (l2 != null) {
                    long jLongValue = l2.longValue();
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.r0((zzaf) zzrVar.f37405b, jLongValue);
                }
                Long l3 = zzdwVarL.f37649b;
                if (l3 != null) {
                    long jLongValue2 = l3.longValue();
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.s0((zzaf) zzrVar.f37405b, jLongValue2);
                }
                Long l4 = zzdwVarL.f37650c;
                if (l4 != null) {
                    long jLongValue3 = l4.longValue();
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.t0((zzaf) zzrVar.f37405b, jLongValue3);
                }
                if (this.r) {
                    Long l5 = zzdwVarL.f37651d;
                    if (l5 != null) {
                        long jLongValue4 = l5.longValue();
                        if (zzrVar.f37406c) {
                            zzrVar.k();
                            zzrVar.f37406c = false;
                        }
                        zzaf.q((zzaf) zzrVar.f37405b, jLongValue4);
                    }
                    Long l6 = zzdwVarL.f37652e;
                    if (l6 != null) {
                        long jLongValue5 = l6.longValue();
                        if (zzrVar.f37406c) {
                            zzrVar.k();
                            zzrVar.f37406c = false;
                        }
                        zzaf.r((zzaf) zzrVar.f37405b, jLongValue5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        } catch (zzdm unused) {
        }
        zzab zzabVarP = zzac.p();
        if (this.f37585c > 0) {
            DisplayMetrics displayMetrics = this.s;
            char[] cArr = zzdx.f37659a;
            if ((displayMetrics == null || displayMetrics.density == 0.0f) ? false : true) {
                long jA = zzdx.a(this.f37592j, displayMetrics);
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.C((zzac) zzabVarP.f37405b, jA);
                long jA2 = zzdx.a(this.o - this.f37595m, this.s);
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.D((zzac) zzabVarP.f37405b, jA2);
                long jA3 = zzdx.a(this.p - this.n, this.s);
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.E((zzac) zzabVarP.f37405b, jA3);
                long jA4 = zzdx.a(this.f37595m, this.s);
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.I((zzac) zzabVarP.f37405b, jA4);
                long jA5 = zzdx.a(this.n, this.s);
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.J((zzac) zzabVarP.f37405b, jA5);
                if (this.r && (motionEvent = this.f37583a) != null) {
                    long jA6 = zzdx.a(((this.f37595m - this.o) + motionEvent.getRawX()) - this.f37583a.getX(), this.s);
                    if (jA6 != 0) {
                        if (zzabVarP.f37406c) {
                            zzabVarP.k();
                            zzabVarP.f37406c = false;
                        }
                        zzac.G((zzac) zzabVarP.f37405b, jA6);
                    }
                    long jA7 = zzdx.a(((this.n - this.p) + this.f37583a.getRawY()) - this.f37583a.getY(), this.s);
                    if (jA7 != 0) {
                        if (zzabVarP.f37406c) {
                            zzabVarP.k();
                            zzabVarP.f37406c = false;
                        }
                        zzac.H((zzac) zzabVarP.f37405b, jA7);
                    }
                }
            }
        }
        try {
            zzdw zzdwVarG = g(this.f37583a);
            Long l7 = zzdwVarG.f37648a;
            if (l7 != null) {
                long jLongValue6 = l7.longValue();
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.q((zzac) zzabVarP.f37405b, jLongValue6);
            }
            Long l8 = zzdwVarG.f37649b;
            if (l8 != null) {
                long jLongValue7 = l8.longValue();
                if (zzabVarP.f37406c) {
                    zzabVarP.k();
                    zzabVarP.f37406c = false;
                }
                zzac.r((zzac) zzabVarP.f37405b, jLongValue7);
            }
            long jLongValue8 = zzdwVarG.f37650c.longValue();
            if (zzabVarP.f37406c) {
                zzabVarP.k();
                zzabVarP.f37406c = false;
            }
            zzac.x((zzac) zzabVarP.f37405b, jLongValue8);
            if (this.r) {
                Long l9 = zzdwVarG.f37652e;
                if (l9 != null) {
                    long jLongValue9 = l9.longValue();
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.s((zzac) zzabVarP.f37405b, jLongValue9);
                }
                Long l10 = zzdwVarG.f37651d;
                if (l10 != null) {
                    long jLongValue10 = l10.longValue();
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.v((zzac) zzabVarP.f37405b, jLongValue10);
                }
                Long l11 = zzdwVarG.f37653f;
                int i2 = 2;
                if (l11 != null) {
                    int i3 = l11.longValue() != 0 ? 2 : 1;
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.K((zzac) zzabVarP.f37405b, i3);
                }
                long j2 = this.f37586d;
                if (j2 > 0) {
                    DisplayMetrics displayMetrics2 = this.s;
                    char[] cArr2 = zzdx.f37659a;
                    Long lValueOf = displayMetrics2 != null && (displayMetrics2.density > 0.0f ? 1 : (displayMetrics2.density == 0.0f ? 0 : -1)) != 0 ? Long.valueOf(Math.round(this.f37591i / j2)) : null;
                    if (lValueOf != null) {
                        long jLongValue11 = lValueOf.longValue();
                        if (zzabVarP.f37406c) {
                            zzabVarP.k();
                            zzabVarP.f37406c = false;
                        }
                        zzac.t((zzac) zzabVarP.f37405b, jLongValue11);
                    } else {
                        if (zzabVarP.f37406c) {
                            zzabVarP.k();
                            zzabVarP.f37406c = false;
                        }
                        zzac.u((zzac) zzabVarP.f37405b);
                    }
                    long jRound = Math.round(this.f37590h / this.f37586d);
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.w((zzac) zzabVarP.f37405b, jRound);
                }
                Long l12 = zzdwVarG.f37656i;
                if (l12 != null) {
                    long jLongValue12 = l12.longValue();
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.z((zzac) zzabVarP.f37405b, jLongValue12);
                }
                Long l13 = zzdwVarG.f37657j;
                if (l13 != null) {
                    long jLongValue13 = l13.longValue();
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.y((zzac) zzabVarP.f37405b, jLongValue13);
                }
                Long l14 = zzdwVarG.f37658k;
                if (l14 != null) {
                    if (l14.longValue() == 0) {
                        i2 = 1;
                    }
                    if (zzabVarP.f37406c) {
                        zzabVarP.k();
                        zzabVarP.f37406c = false;
                    }
                    zzac.L((zzac) zzabVarP.f37405b, i2);
                }
            }
        } catch (zzdm unused2) {
        }
        long j3 = this.f37589g;
        if (j3 > 0) {
            if (zzabVarP.f37406c) {
                zzabVarP.k();
                zzabVarP.f37406c = false;
            }
            zzac.A((zzac) zzabVarP.f37405b, j3);
        }
        zzac zzacVar = (zzac) zzabVarP.h();
        if (zzrVar.f37406c) {
            zzrVar.k();
            zzrVar.f37406c = false;
        }
        zzaf.E((zzaf) zzrVar.f37405b, zzacVar);
        long j4 = this.f37585c;
        if (j4 > 0) {
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.u((zzaf) zzrVar.f37405b, j4);
        }
        long j5 = this.f37586d;
        if (j5 > 0) {
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.t((zzaf) zzrVar.f37405b, j5);
        }
        long j6 = this.f37587e;
        if (j6 > 0) {
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.s((zzaf) zzrVar.f37405b, j6);
        }
        long j7 = this.f37588f;
        if (j7 > 0) {
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.v((zzaf) zzrVar.f37405b, j7);
        }
        try {
            int size = this.f37584b.size() - 1;
            if (size > 0) {
                if (zzrVar.f37406c) {
                    zzrVar.k();
                    zzrVar.f37406c = false;
                }
                zzaf.H((zzaf) zzrVar.f37405b);
                for (int i4 = 0; i4 < size; i4++) {
                    zzdw zzdwVarL2 = l(zzcr.t, (MotionEvent) this.f37584b.get(i4), this.s);
                    zzab zzabVarP2 = zzac.p();
                    long jLongValue14 = zzdwVarL2.f37648a.longValue();
                    if (zzabVarP2.f37406c) {
                        zzabVarP2.k();
                        zzabVarP2.f37406c = false;
                    }
                    zzac.q((zzac) zzabVarP2.f37405b, jLongValue14);
                    long jLongValue15 = zzdwVarL2.f37649b.longValue();
                    if (zzabVarP2.f37406c) {
                        zzabVarP2.k();
                        zzabVarP2.f37406c = false;
                    }
                    zzac.r((zzac) zzabVarP2.f37405b, jLongValue15);
                    zzac zzacVar2 = (zzac) zzabVarP2.h();
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.G((zzaf) zzrVar.f37405b, zzacVar2);
                }
            }
        } catch (zzdm unused3) {
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.H((zzaf) zzrVar.f37405b);
        }
    }

    public ArrayList i(zzdu zzduVar, Context context, zzr zzrVar, zzi zziVar) {
        long j2;
        int iA = zzduVar.a();
        ArrayList arrayList = new ArrayList();
        if (!zzduVar.p) {
            zzrVar.l(16384L);
            return arrayList;
        }
        zzei zzeiVar = new zzei(zzduVar, zzrVar, iA, context, zziVar);
        int i2 = iA;
        arrayList.add(zzeiVar);
        zzr zzrVar2 = zzrVar;
        arrayList.add(new zzel(zzduVar, zzrVar, z, i2));
        arrayList.add(new zzet(zzduVar, zzrVar2, i2));
        zzew zzewVar = new zzew(zzduVar, "tPxcLkiesd8JzrYIyuRbLGxWAQfsX+C1jrJaS2rsRu6lU/ve1b9hEzSSzo6VwqXx", "0RWQk7vrKrAXtxwBYq7T9nI/JnUnK0yiZtx30+mk7/g=", zzrVar2, i2, 31);
        zzewVar.f37708h = null;
        arrayList.add(zzewVar);
        arrayList.add(new zzfb(zzduVar, "5BhEc19mhLCb3gixLpO/usqpdcrz8iDHUvKRNr8tUAX9rUzF0wog6vEOJrftvcpW", "yZHUQ89G8fTgEsMNs0hBrXwZIrb4VL1iE12C/t/Y3UE=", zzrVar2, i2, 33));
        arrayList.add(new zzeh(zzduVar, zzrVar2, i2, context));
        arrayList.add(new zzej(zzduVar, zzrVar2, i2));
        arrayList.add(new zzes(zzduVar, zzrVar2, i2));
        arrayList.add(new zzeu(zzduVar, zzrVar2, i2));
        arrayList.add(new zzek(zzduVar, zzrVar2, i2));
        arrayList.add(new zzep(zzduVar, zzrVar2, i2));
        arrayList.add(new zzfc(zzduVar, zzrVar2, i2));
        arrayList.add(new zzeg(zzduVar, zzrVar2, i2));
        arrayList.add(new zzez(zzduVar, zzrVar2, i2));
        arrayList.add(new zzex(zzduVar, zzrVar2, i2));
        zzgc zzgcVar = zzgk.s;
        zzfv zzfvVar = zzfv.f37741d;
        if (((Boolean) zzfvVar.f37744c.a(zzgcVar)).booleanValue()) {
            zzed zzedVar = B;
            long j3 = -1;
            if (zzedVar != null) {
                long j4 = zzedVar.f37686d ? zzedVar.f37684b - zzedVar.f37683a : -1L;
                long j5 = zzedVar.f37685c;
                zzedVar.f37685c = -1L;
                j3 = j4;
                j2 = j5;
            } else {
                j2 = -1;
            }
            zzer zzerVar = new zzer(zzduVar, zzrVar2, i2, A, j3, j2);
            zzrVar2 = zzrVar2;
            i2 = i2;
            arrayList.add(zzerVar);
        }
        zzgc zzgcVar2 = zzgk.r;
        zzgi zzgiVar = zzfvVar.f37744c;
        if (((Boolean) zzgiVar.a(zzgcVar2)).booleanValue()) {
            arrayList.add(new zzev(zzduVar, "WepZYnT/MXyJE28LKN26NT6D3mAA2J2spDFApE1ixrQxTNXRg7wshW7BC/EU90LT", "sjYkfzJTuYKxh1jvZaP9n5dx9JGmzJotOUC/vdvgi4M=", zzrVar2, i2, 73));
        }
        arrayList.add(new zzeq(zzduVar, "AZwRbSS9Tjg/vY6NNyDfd3mU35mZBbQduzRpliDRt3qUNjlKylmreq0JkiCiO6dF", "lsjUo68NMWNsPUz4dBIEYtWAZHRXaEljQLBgt48XQs4=", zzrVar2, i2, 76));
        if (((Boolean) zzgiVar.a(zzgk.v)).booleanValue()) {
            arrayList.add(new zzef(zzduVar, zzrVar2, i2));
        }
        return arrayList;
    }

    public void j(zzdu zzduVar, Context context, zzr zzrVar, zzi zziVar) throws InterruptedException {
        if (zzduVar.f37635b == null) {
            return;
        }
        o(i(zzduVar, context, zzrVar, zziVar));
    }

    public final void m(zzdu zzduVar, zzr zzrVar, View view, Activity activity, boolean z2) throws InterruptedException {
        List listAsList;
        View view2;
        if (zzduVar.p) {
            h(zzduVar, zzrVar);
            ArrayList arrayList = new ArrayList();
            if (zzduVar.f37635b != null) {
                int iA = zzduVar.a();
                arrayList.add(new zzen(zzduVar, zzrVar));
                arrayList.add(new zzet(zzduVar, zzrVar, iA));
                arrayList.add(new zzel(zzduVar, zzrVar, z, iA));
                arrayList.add(new zzek(zzduVar, zzrVar, iA));
                arrayList.add(new zzes(zzduVar, zzrVar, iA));
                arrayList.add(new zzeu(zzduVar, zzrVar, iA));
                arrayList.add(new zzep(zzduVar, zzrVar, iA));
                arrayList.add(new zzej(zzduVar, zzrVar, iA));
                arrayList.add(new zzfc(zzduVar, zzrVar, iA));
                arrayList.add(new zzeg(zzduVar, zzrVar, iA));
                arrayList.add(new zzez(zzduVar, zzrVar, iA));
                arrayList.add(new zzey(zzduVar, zzrVar, iA, new Throwable().getStackTrace()));
                arrayList.add(new zzfd(zzduVar, zzrVar, iA, view));
                arrayList.add(new zzex(zzduVar, zzrVar, iA));
                zzgc zzgcVar = zzgk.f37771h;
                zzfv zzfvVar = zzfv.f37741d;
                if (((Boolean) zzfvVar.f37744c.a(zzgcVar)).booleanValue()) {
                    view2 = view;
                    arrayList.add(new zzee(zzduVar, zzrVar, iA, view2, activity));
                } else {
                    view2 = view;
                }
                zzgc zzgcVar2 = zzgk.v;
                zzgi zzgiVar = zzfvVar.f37744c;
                if (((Boolean) zzgiVar.a(zzgcVar2)).booleanValue()) {
                    arrayList.add(new zzef(zzduVar, zzrVar, iA));
                }
                if (!z2) {
                    try {
                        if (((Boolean) zzgiVar.a(zzgk.f37774k)).booleanValue()) {
                            arrayList.add(new zzeo(zzduVar, zzrVar, iA, this.w, view2));
                        }
                    } catch (IllegalStateException unused) {
                    }
                } else if (((Boolean) zzgiVar.a(zzgk.f37773j)).booleanValue()) {
                    arrayList.add(new zzfa(zzduVar, zzrVar, iA, this.v));
                }
            }
            listAsList = arrayList;
        } else {
            zzrVar.l(16384L);
            listAsList = Arrays.asList(new zzen(zzduVar, zzrVar));
        }
        o(listAsList);
    }

    public zzct(Context context, int i2) {
        super(context);
        this.w = new HashMap();
        this.u = "h.3.2.2/n.android.3.2.2";
    }
}
