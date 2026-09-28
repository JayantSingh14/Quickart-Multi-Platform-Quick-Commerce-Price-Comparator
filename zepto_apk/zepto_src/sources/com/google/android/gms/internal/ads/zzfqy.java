package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public abstract class zzfqy {

    /* renamed from: a, reason: collision with root package name */
    public final ClientApi f31667a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f31668b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31669c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfjg f31670d;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzft f31671e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfpp f31672f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f31673g;

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzce f31674h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzch f31675i;

    /* renamed from: j, reason: collision with root package name */
    public final Queue f31676j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfpy f31677k;

    /* renamed from: l, reason: collision with root package name */
    public final String f31678l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f31679m;
    public final ScheduledExecutorService n;
    public final zzfly o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public zzfqd r;
    public final Clock s;
    public final zzfqk t;

    public zzfqy(ClientApi clientApi, Context context, int i2, zzfjg zzfjgVar, com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfly zzflyVar, zzfpy zzfpyVar, Clock clock) {
        this("none", clientApi, context, i2, zzfjgVar, zzftVar, scheduledExecutorService, zzflyVar, zzfpyVar, clock, null);
        this.f31674h = zzceVar;
    }

    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        synchronized (this) {
            try {
                if (this.p.get()) {
                    com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzfqr(this, zzeVar));
                }
                this.f31679m.set(false);
                int i2 = zzeVar.f21161a;
                if (i2 != 1 && i2 != 8 && i2 != 10 && i2 != 11) {
                    c(true);
                    return;
                }
                com.google.android.gms.ads.internal.client.zzft zzftVar = this.f31671e;
                int i3 = zzftVar.f21240b;
                String str = zzftVar.f21239a;
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26 + String.valueOf(str).length() + 61);
                sb.append("Preloading ");
                sb.append(i3);
                sb.append(", for adUnitId:");
                sb.append(str);
                sb.append(", Ad load failed. Stop preloading due to non-retriable error:");
                String string = sb.toString();
                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.e(string);
                this.f31673g.set(false);
                zzfpp zzfppVar = this.f31672f;
                if (zzfppVar != null) {
                    zzfppVar.a(this);
                }
                zzfqj zzfqjVar = new zzfqj(this.f31671e.f21239a, o());
                zzfqjVar.f31642c = this.f31678l;
                this.r.e(this.s.currentTimeMillis(), new zzfqk(zzfqjVar), zzeVar, this.f31671e.f21242d, p(), f());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void b(Object obj) {
        try {
            com.google.android.gms.ads.internal.client.zzea zzeaVarH = h(obj);
            double d2 = !(zzeaVarH instanceof zzdad) ? 0.0d : ((zzdad) zzeaVarH).f27552j;
            com.google.android.gms.ads.internal.client.zzea zzeaVarH2 = h(obj);
            int i2 = zzeaVarH2 instanceof zzdad ? ((zzdad) zzeaVarH2).f27553k : 2;
            Clock clock = this.s;
            zzfqm zzfqmVar = new zzfqm(obj, clock, d2, i2);
            this.f31676j.add(zzfqmVar);
            com.google.android.gms.ads.internal.client.zzea zzeaVarH3 = h(obj);
            long jCurrentTimeMillis = clock.currentTimeMillis();
            if (this.p.get()) {
                com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzfqp(this, zzeaVarH3));
            }
            ScheduledExecutorService scheduledExecutorService = this.n;
            scheduledExecutorService.execute(new zzfqq(this, jCurrentTimeMillis, zzeaVarH3));
            if (this.f31672f != null) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.E)).booleanValue()) {
                    scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfqv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f31664a.d();
                        }
                    }, zzfqmVar.a(), TimeUnit.MILLISECONDS);
                    return;
                }
                zzfly zzflyVar = this.o;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfqw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f31665a.d();
                    }
                };
                long jA = zzfqmVar.a();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                zzflyVar.a(jA, runnable);
                return;
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.E)).booleanValue()) {
                scheduledExecutorService.schedule(new zzfqo(this), zzfqmVar.a(), TimeUnit.MILLISECONDS);
                return;
            }
            zzfly zzflyVar2 = this.o;
            zzfqo zzfqoVar = new zzfqo(this);
            long jA2 = zzfqmVar.a();
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            zzflyVar2.a(jA2, zzfqoVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(boolean z) {
        try {
            zzfpp zzfppVar = this.f31672f;
            if (zzfppVar != null) {
                if (z) {
                    this.f31677k.c();
                }
                zzfppVar.a(this);
            } else {
                zzfpy zzfpyVar = this.f31677k;
                if (zzfpyVar.d()) {
                    return;
                }
                if (z) {
                    zzfpyVar.c();
                }
                this.n.schedule(new zzfqo(this), zzfpyVar.b(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void d() {
        Iterator it = this.f31676j.iterator();
        while (it.hasNext()) {
            zzfqm zzfqmVar = (zzfqm) it.next();
            if (zzfqmVar.f31648c.currentTimeMillis() >= zzfqmVar.f31647b + zzfqmVar.f31649d) {
                it.remove();
                zzfpp zzfppVar = this.f31672f;
                if (zzfppVar != null) {
                    zzfppVar.a(this);
                }
            }
        }
    }

    public final synchronized void e() {
        try {
            if (this.q.get() && this.f31676j.isEmpty()) {
                this.q.set(false);
                if (this.p.get()) {
                    com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzfqs(this));
                }
                this.n.execute(new zzfqt(this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String f() {
        return true != "none".equals(this.f31678l) ? "2" : "1";
    }

    public abstract ListenableFuture g(Context context);

    public abstract com.google.android.gms.ads.internal.client.zzea h(Object obj);

    public final synchronized void i() {
        if (!this.f31679m.get() && this.f31673g.get() && this.f31676j.size() < this.f31671e.f21242d) {
            this.f31679m.set(true);
            this.n.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfqx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f31666a.s();
                }
            });
        }
    }

    public final synchronized boolean j() {
        try {
            zzbgb zzbgbVar = zzbgk.K;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                this.f31677k.a();
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.D)).booleanValue() && this.f31672f == null) {
                r();
            } else {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return !this.f31676j.isEmpty();
    }

    public final synchronized Object k() {
        try {
            zzbgb zzbgbVar = zzbgk.N;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            boolean z = true;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                if (!((Boolean) zzbdVar.f21153c.a(zzbgk.L)).booleanValue() || this.f31676j.size() == 1) {
                    this.f31677k.a();
                }
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.M)).booleanValue()) {
                d();
            }
            Queue queue = this.f31676j;
            zzfqm zzfqmVar = (zzfqm) queue.poll();
            AtomicBoolean atomicBoolean = this.q;
            if (zzfqmVar == null) {
                z = false;
            }
            atomicBoolean.set(z);
            if (zzfqmVar == null) {
                zzfqmVar = null;
            } else if (!queue.isEmpty()) {
                zzfqm zzfqmVar2 = (zzfqm) queue.peek();
                AdFormat adFormatA = AdFormat.a(this.f31671e.f21240b);
                com.google.android.gms.ads.internal.client.zzea zzeaVarH = h(zzfqmVar.f31646a);
                String str = !(zzeaVarH instanceof zzdad) ? null : ((zzdad) zzeaVarH).f27546d;
                if (zzfqmVar2 != null && adFormatA != null && str != null && zzfqmVar2.f31647b < zzfqmVar.f31647b) {
                    this.r.g("poll_ad", "psvroc_ts", this.s.currentTimeMillis(), this.f31671e.f21242d, p(), str, this.t, f());
                }
            }
            zzfpp zzfppVar = this.f31672f;
            if (zzfppVar != null) {
                zzfppVar.b(this);
            } else {
                zzbgb zzbgbVar2 = zzbgk.P;
                if (((Long) zzbdVar.f21153c.a(zzbgbVar2)).longValue() > 0) {
                    this.n.schedule(new zzfqo(this), ((Long) zzbdVar.f21153c.a(zzbgbVar2)).longValue(), TimeUnit.MILLISECONDS);
                } else {
                    r();
                }
            }
            if (zzfqmVar == null) {
                return null;
            }
            return zzfqmVar.f31646a;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void l() {
        this.f31673g.set(true);
        this.p.set(true);
        if (this.f31672f == null) {
            this.n.submit(new zzfqo(this));
        }
    }

    public final synchronized String m() {
        String str;
        Object obj;
        synchronized (this) {
            zzfqm zzfqmVar = (zzfqm) this.f31676j.peek();
            str = null;
            obj = zzfqmVar == null ? null : zzfqmVar.f31646a;
        }
        return str;
        com.google.android.gms.ads.internal.client.zzea zzeaVarH = obj == null ? null : h(obj);
        if (zzeaVarH instanceof zzdad) {
            str = ((zzdad) zzeaVarH).f27546d;
        }
        return str;
    }

    public final synchronized void n(int i2) {
        Preconditions.checkArgument(i2 >= 5);
        zzfpy zzfpyVar = this.f31677k;
        synchronized (zzfpyVar) {
            Preconditions.checkArgument(i2 > 0);
            zzfpyVar.f31610d = i2;
        }
    }

    public final AdFormat o() {
        return AdFormat.a(this.f31671e.f21240b);
    }

    public final synchronized int p() {
        return this.f31676j.size();
    }

    public final boolean q() {
        if (!this.f31673g.get() || this.f31679m.get() || p() >= this.f31671e.f21242d) {
            return false;
        }
        zzfpy zzfpyVar = this.f31677k;
        return zzfpyVar.f31612f.currentTimeMillis() >= zzfpyVar.f31611e;
    }

    public final synchronized void r() {
        d();
        e();
        if (!this.f31679m.get() && this.f31673g.get() && this.f31676j.size() < this.f31671e.f21242d) {
            this.f31679m.set(true);
            s();
        }
    }

    public final synchronized void s() {
        ListenableFuture listenableFutureG;
        try {
            Activity activityD = com.google.android.gms.ads.internal.zzt.C.f21683g.d();
            if (activityD == null) {
                String strValueOf = String.valueOf(this.f31671e.f21239a);
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Empty activity context at preloading: ".concat(strValueOf));
                listenableFutureG = g(this.f31668b);
            } else {
                listenableFutureG = g(activityD);
            }
            zzfqn zzfqnVar = new zzfqn(this);
            ScheduledExecutorService scheduledExecutorService = this.n;
            ((zzgxf) listenableFutureG).q(new zzgyk(listenableFutureG, zzfqnVar), scheduledExecutorService);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void t(int i2) {
        zzfpp zzfppVar;
        Preconditions.checkArgument(i2 > 0);
        AdFormat adFormatA = AdFormat.a(this.f31671e.f21240b);
        int i3 = this.f31671e.f21242d;
        int size = this.f31676j.size();
        synchronized (this) {
            try {
                com.google.android.gms.ads.internal.client.zzft zzftVar = this.f31671e;
                this.f31671e = new com.google.android.gms.ads.internal.client.zzft(zzftVar.f21239a, zzftVar.f21240b, zzftVar.f21241c, i2 > 0 ? i2 : zzftVar.f21242d);
                Queue queue = this.f31676j;
                if (queue.size() > i2) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.x)).booleanValue()) {
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < i2; i4++) {
                            zzfqm zzfqmVar = (zzfqm) queue.poll();
                            if (zzfqmVar != null) {
                                arrayList.add(zzfqmVar);
                            }
                        }
                        queue.clear();
                        queue.addAll(arrayList);
                        if (size > arrayList.size() && (zzfppVar = this.f31672f) != null) {
                            int size2 = size - arrayList.size();
                            if (arrayList.isEmpty()) {
                                size2--;
                            }
                            zzfppVar.c(this, size2);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzfqd zzfqdVar = this.r;
        if (zzfqdVar == null || adFormatA == null) {
            return;
        }
        long jCurrentTimeMillis = this.s.currentTimeMillis();
        zzfqk zzfqkVar = new zzfqk(new zzfqj(this.f31671e.f21239a, adFormatA));
        zzdxd zzdxdVarA = zzfqdVar.f31622a.a();
        zzdxdVarA.b("action", "cache_resize");
        zzdxdVarA.b("cs_ts", Long.toString(jCurrentTimeMillis));
        zzdxdVarA.b("orig_ma", Integer.toString(i3));
        zzdxdVarA.b("max_ads", Integer.toString(i2));
        zzdxdVarA.b("ad_format", zzfqkVar.a());
        zzdxdVarA.b("ad_unit_id", zzfqkVar.f31643a);
        zzdxdVarA.b("pid", zzfqkVar.f31645c);
        zzdxdVarA.b("pv", "1");
        zzdxdVarA.c();
    }

    public final void u(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.C)).booleanValue()) {
            Bundle bundle = zzmVar.B;
            bundle.putInt("plcs", p());
            bundle.putInt("plbs", this.f31671e.f21242d);
            bundle.putString("plid", this.f31678l);
        }
    }

    public zzfqy(String str, ClientApi clientApi, Context context, int i2, zzfjg zzfjgVar, com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfly zzflyVar, zzfpy zzfpyVar, Clock clock, zzfpp zzfppVar) {
        this(str, clientApi, context, i2, zzfjgVar, zzftVar, scheduledExecutorService, zzflyVar, zzfpyVar, clock, zzfppVar);
        this.f31675i = zzchVar;
    }

    public zzfqy(String str, ClientApi clientApi, Context context, int i2, zzfjg zzfjgVar, com.google.android.gms.ads.internal.client.zzft zzftVar, ScheduledExecutorService scheduledExecutorService, zzfly zzflyVar, zzfpy zzfpyVar, Clock clock, zzfpp zzfppVar) {
        Queue priorityQueue;
        this.f31678l = str;
        this.f31667a = clientApi;
        this.f31668b = context;
        this.f31669c = i2;
        this.f31670d = zzfjgVar;
        this.f31671e = zzftVar;
        int iMax = Math.max(1, zzftVar.f21242d);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V)).booleanValue()) {
            priorityQueue = new zzfrb();
        } else {
            priorityQueue = new PriorityQueue(iMax, zzfqu.f31663a);
        }
        this.f31676j = priorityQueue;
        this.f31673g = new AtomicBoolean(true);
        this.f31679m = new AtomicBoolean(false);
        this.n = scheduledExecutorService;
        this.o = zzflyVar;
        this.f31677k = zzfpyVar;
        this.p = new AtomicBoolean(true);
        this.q = new AtomicBoolean(false);
        this.s = clock;
        zzfqj zzfqjVar = new zzfqj(zzftVar.f21239a, AdFormat.a(this.f31671e.f21240b));
        zzfqjVar.f31642c = str;
        this.t = new zzfqk(zzfqjVar);
        this.f31672f = zzfppVar;
    }
}
