package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import java.util.LinkedHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzfpp {

    /* renamed from: a, reason: collision with root package name */
    public final int f31579a;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledFuture f31581c;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f31584f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfqd f31585g;

    /* renamed from: h, reason: collision with root package name */
    public final Clock f31586h;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f31580b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f31582d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f31583e = new AtomicBoolean(false);

    public zzfpp(int i2, ScheduledExecutorService scheduledExecutorService, zzfqd zzfqdVar, Clock clock) {
        this.f31579a = i2;
        this.f31584f = scheduledExecutorService;
        this.f31585g = zzfqdVar;
        this.f31586h = clock;
    }

    public static String g(String str, AdFormat adFormat) {
        return str + ":" + adFormat;
    }

    public final void a(zzfqy zzfqyVar) {
        int i2 = 1;
        if (zzfqyVar.p() <= 0 && !zzfqyVar.f31679m.get()) {
            i2 = 0;
        }
        c(zzfqyVar, i2);
    }

    public final synchronized void b(zzfqy zzfqyVar) {
        try {
            if (h(zzfqyVar)) {
                return;
            }
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.T)).longValue();
            if (jLongValue <= 0) {
                a(zzfqyVar);
                return;
            }
            if (zzfqyVar.p() > 0 || zzfqyVar.f31679m.get()) {
                m(zzfqyVar, 1);
            }
            this.f31580b.set(true);
            ScheduledFuture scheduledFuture = this.f31581c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f31581c = null;
            this.f31583e.set(true);
            this.f31581c = this.f31584f.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfpo
                @Override // java.lang.Runnable
                public final void run() {
                    zzfpp zzfppVar = this.f31578a;
                    synchronized (zzfppVar) {
                        zzfppVar.f31580b.set(false);
                        zzfppVar.k();
                    }
                }
            }, jLongValue, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(zzfqy zzfqyVar, int i2) {
        if (h(zzfqyVar)) {
            return;
        }
        if (i2 > 0) {
            m(zzfqyVar, i2);
        }
        if (!n(zzfqyVar)) {
            j(0L);
        } else {
            j(((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R)).longValue());
        }
    }

    public final void d(String str, AdFormat adFormat, zzfqy zzfqyVar) {
        LinkedHashMap linkedHashMap = this.f31582d;
        String strG = g(str, adFormat);
        synchronized (linkedHashMap) {
            try {
                if (!linkedHashMap.containsKey(strG)) {
                    linkedHashMap.put(strG, zzfqyVar);
                    n(zzfqyVar);
                    j(((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R)).longValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(String str, AdFormat adFormat) {
        zzfqy zzfqyVar;
        LinkedHashMap linkedHashMap = this.f31582d;
        String strG = g(str, adFormat);
        synchronized (linkedHashMap) {
            zzfqyVar = (zzfqy) linkedHashMap.remove(strG);
        }
        if (zzfqyVar == null) {
            return;
        }
        int iP = zzfqyVar.p();
        int i2 = iP - 1;
        if (!zzfqyVar.f31679m.get()) {
            iP = i2;
        }
        int iMax = Math.max(iP, 0);
        if (iMax > 0) {
            m(zzfqyVar, iMax);
        }
        if (zzfqyVar.p() > 0 || zzfqyVar.f31679m.get()) {
            j(0L);
        }
    }

    public final int f() {
        int iMax;
        LinkedHashMap linkedHashMap = this.f31582d;
        synchronized (linkedHashMap) {
            try {
                iMax = 0;
                for (zzfqy zzfqyVar : linkedHashMap.values()) {
                    int iP = zzfqyVar.p();
                    int i2 = iP - 1;
                    if (!zzfqyVar.f31679m.get()) {
                        iP = i2;
                    }
                    iMax += Math.max(iP, 0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iMax;
    }

    public final boolean h(zzfqy zzfqyVar) {
        AdFormat adFormatO = zzfqyVar.o();
        if (adFormatO == null) {
            return true;
        }
        LinkedHashMap linkedHashMap = this.f31582d;
        synchronized (linkedHashMap) {
            try {
                return !linkedHashMap.containsKey(g(zzfqyVar.f31678l, adFormatO));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i() {
        LinkedHashMap linkedHashMap = this.f31582d;
        synchronized (linkedHashMap) {
            try {
                for (zzfqy zzfqyVar : linkedHashMap.values()) {
                    if (zzfqyVar.p() == 0 && zzfqyVar.q()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void j(long j2) {
        if (this.f31583e.compareAndSet(false, true)) {
            if (j2 > 0) {
                this.f31581c = this.f31584f.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfpl
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f31575a.k();
                    }
                }, j2, TimeUnit.MILLISECONDS);
            } else {
                this.f31584f.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfpk
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f31574a.k();
                    }
                });
            }
        }
    }

    public final synchronized void k() {
        zzgtd zzgtdVarR;
        try {
            if (this.f31580b.get()) {
                return;
            }
            zzfqy zzfqyVar = null;
            this.f31581c = null;
            if (f() < this.f31579a || i()) {
                LinkedHashMap linkedHashMap = this.f31582d;
                synchronized (linkedHashMap) {
                    zzgtdVarR = zzgtd.r(linkedHashMap.values());
                }
                int size = zzgtdVarR.size();
                double d2 = Double.MAX_VALUE;
                for (int i2 = 0; i2 < size; i2++) {
                    zzfqy zzfqyVar2 = (zzfqy) zzgtdVarR.get(i2);
                    if (zzfqyVar2.q()) {
                        double dP = zzfqyVar2.p() / zzfqyVar2.f31671e.f21242d;
                        if (dP < d2) {
                            d2 = dP;
                        }
                        if (dP < d2) {
                            zzfqyVar = zzfqyVar2;
                        }
                    }
                }
                if (zzfqyVar != null) {
                    zzfqyVar.i();
                    if (zzfqyVar.p() > 0) {
                        this.f31585g.h("acmpa", this.f31586h.currentTimeMillis(), zzfqyVar.f31678l, zzfqyVar.f31671e.f21239a, zzfqyVar.o(), zzfqyVar.f31671e.f21242d, zzfqyVar.p(), 0, f(), this.f31579a);
                    }
                }
                int iF = f();
                int i3 = this.f31579a;
                if (iF >= i3) {
                    l();
                }
                if (f() >= i3) {
                    if (i()) {
                    }
                }
                if (i()) {
                    this.f31584f.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfpn
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f31577a.k();
                        }
                    });
                    return;
                }
                this.f31581c = this.f31584f.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfpm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f31576a.k();
                    }
                }, ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.S)).longValue(), TimeUnit.MILLISECONDS);
                return;
            }
            l();
            this.f31583e.set(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l() {
        int size;
        LinkedHashMap linkedHashMap = this.f31582d;
        synchronized (linkedHashMap) {
            size = linkedHashMap.size();
        }
        zzfqd zzfqdVar = this.f31585g;
        Clock clock = this.f31586h;
        int i2 = this.f31579a;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        zzdxd zzdxdVarA = zzfqdVar.f31622a.a();
        zzdxdVarA.b("action", "acmlr");
        zzdxdVarA.b("pat", Long.toString(jCurrentTimeMillis));
        zzdxdVarA.b("mpl", Integer.toString(i2));
        zzdxdVarA.b("pas", Integer.toString(size));
        zzdxdVarA.c();
    }

    public final void m(zzfqy zzfqyVar, int i2) {
        this.f31585g.h("acmpr", this.f31586h.currentTimeMillis(), zzfqyVar.f31678l, zzfqyVar.f31671e.f21239a, zzfqyVar.o(), zzfqyVar.f31671e.f21242d, zzfqyVar.p(), i2, f(), this.f31579a);
    }

    public final synchronized boolean n(zzfqy zzfqyVar) {
        if (!this.f31580b.get() && zzfqyVar.p() == 0 && zzfqyVar.q()) {
            zzfqyVar.i();
            return true;
        }
        return false;
    }
}
