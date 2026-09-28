package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* loaded from: classes4.dex */
abstract class zzgxo extends zzgxs {
    public static final zzgyu o = new zzgyu(zzgxo.class);

    /* renamed from: l, reason: collision with root package name */
    public zzgsz f33350l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f33351m;
    public final boolean n;

    public zzgxo(zzgsz zzgszVar, boolean z, boolean z2) {
        int size = zzgszVar.size();
        this.f33356h = null;
        this.f33357i = size;
        this.f33350l = zzgszVar;
        this.f33351m = z;
        this.n = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final void e() {
        zzgsz zzgszVar = this.f33350l;
        s(1);
        if ((zzgszVar != null) && isCancelled()) {
            boolean zL = l();
            zzgvr it = zzgszVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zL);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String f() {
        zzgsz zzgszVar = this.f33350l;
        return zzgszVar != null ? "futures=".concat(zzgszVar.toString()) : super.f();
    }

    public void s(int i2) {
        this.f33350l = null;
    }

    public final void t(int i2, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.f33350l = null;
                cancel(false);
            } else {
                try {
                    x(i2, zzgzn.a(listenableFuture));
                } catch (ExecutionException e2) {
                    u(e2.getCause());
                } catch (Throwable th) {
                    u(th);
                }
            }
        } finally {
            v(null);
        }
    }

    public final void u(Throwable th) {
        th.getClass();
        if (this.f33351m && !d(th)) {
            Set set = this.f33356h;
            if (set == null) {
                Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                setNewSetFromMap.getClass();
                if (!isCancelled()) {
                    Throwable thA = a();
                    Objects.requireNonNull(thA);
                    while (thA != null && setNewSetFromMap.add(thA)) {
                        thA = thA.getCause();
                    }
                }
                zzgxs.f33354j.a(this, setNewSetFromMap);
                set = this.f33356h;
                Objects.requireNonNull(set);
            }
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                if (set.add(cause)) {
                }
            }
            o.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
            return;
        }
        boolean z = th instanceof Error;
        if (z) {
            o.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != z ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
        }
    }

    public final void v(zzgsz zzgszVar) {
        int iB = zzgxs.f33354j.b(this);
        int i2 = 0;
        zzgqa.g("Less than 0 remaining futures", iB >= 0);
        if (iB == 0) {
            if (zzgszVar != null) {
                zzgvr it = zzgszVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        try {
                            x(i2, zzgzn.a(future));
                        } catch (ExecutionException e2) {
                            u(e2.getCause());
                        } catch (Throwable th) {
                            u(th);
                        }
                    }
                    i2++;
                }
            }
            this.f33356h = null;
            y();
            s(2);
        }
    }

    public final void w() {
        Objects.requireNonNull(this.f33350l);
        if (this.f33350l.isEmpty()) {
            y();
            return;
        }
        zzgyb zzgybVar = zzgyb.f33369a;
        if (this.f33351m) {
            zzgvr it = this.f33350l.iterator();
            final int i2 = 0;
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                int i3 = i2 + 1;
                if (listenableFuture.isDone()) {
                    t(i2, listenableFuture);
                } else {
                    listenableFuture.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgxn
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f33347a.t(i2, listenableFuture);
                        }
                    }, zzgybVar);
                }
                i2 = i3;
            }
            return;
        }
        zzgsz zzgszVar = this.f33350l;
        final zzgsz zzgszVar2 = true != this.n ? null : zzgszVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgxm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f33345a.v(zzgszVar2);
            }
        };
        zzgvr it2 = zzgszVar.iterator();
        while (it2.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture) it2.next();
            if (listenableFuture2.isDone()) {
                v(zzgszVar2);
            } else {
                listenableFuture2.q(runnable, zzgybVar);
            }
        }
    }

    public abstract void x(int i2, Object obj);

    public abstract void y();
}
