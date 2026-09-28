package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzhy extends zzje {

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicLong f39070k = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    public zzhx f39071c;

    /* renamed from: d, reason: collision with root package name */
    public zzhx f39072d;

    /* renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue f39073e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedBlockingQueue f39074f;

    /* renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f39075g;

    /* renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f39076h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f39077i;

    /* renamed from: j, reason: collision with root package name */
    public final Semaphore f39078j;

    public zzhy(zzib zzibVar) {
        super(zzibVar);
        this.f39077i = new Object();
        this.f39078j = new Semaphore(2);
        this.f39073e = new PriorityBlockingQueue();
        this.f39074f = new LinkedBlockingQueue();
        this.f39075g = new zzhv(this, "Thread death: Uncaught exception on worker thread");
        this.f39076h = new zzhv(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzjd
    public final void g() {
        if (Thread.currentThread() != this.f39071c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final boolean h() {
        return false;
    }

    public final void k() {
        if (Thread.currentThread() != this.f39072d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void l() {
        if (Thread.currentThread() == this.f39071c) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean m() {
        return Thread.currentThread() == this.f39071c;
    }

    public final Future n(Callable callable) {
        i();
        Preconditions.checkNotNull(callable);
        zzhw zzhwVar = new zzhw(this, callable, false);
        if (Thread.currentThread() != this.f39071c) {
            t(zzhwVar);
            return zzhwVar;
        }
        if (!this.f39073e.isEmpty()) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.a("Callable skipped the worker queue.");
        }
        zzhwVar.run();
        return zzhwVar;
    }

    public final Future o(Callable callable) {
        i();
        Preconditions.checkNotNull(callable);
        zzhw zzhwVar = new zzhw(this, callable, true);
        if (Thread.currentThread() == this.f39071c) {
            zzhwVar.run();
            return zzhwVar;
        }
        t(zzhwVar);
        return zzhwVar;
    }

    public final void p(Runnable runnable) {
        i();
        Preconditions.checkNotNull(runnable);
        t(new zzhw(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object q(AtomicReference atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzhy zzhyVar = this.f39180a.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(runnable);
            try {
                atomicReference.wait(j2);
            } catch (InterruptedException unused) {
                zzgt zzgtVar = this.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgr zzgrVar = zzgtVar.f38961i;
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                zzgrVar.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            zzgt zzgtVar2 = this.f39180a.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38961i.a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void r(Runnable runnable) {
        i();
        Preconditions.checkNotNull(runnable);
        t(new zzhw(this, runnable, true, "Task exception on worker thread"));
    }

    public final void s(Runnable runnable) {
        i();
        Preconditions.checkNotNull(runnable);
        zzhw zzhwVar = new zzhw(this, runnable, false, "Task exception on network thread");
        synchronized (this.f39077i) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.f39074f;
                linkedBlockingQueue.add(zzhwVar);
                zzhx zzhxVar = this.f39072d;
                if (zzhxVar == null) {
                    zzhx zzhxVar2 = new zzhx(this, "Measurement Network", linkedBlockingQueue);
                    this.f39072d = zzhxVar2;
                    zzhxVar2.setUncaughtExceptionHandler(this.f39076h);
                    this.f39072d.start();
                } else {
                    Object obj = zzhxVar.f39066a;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(zzhw zzhwVar) {
        synchronized (this.f39077i) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f39073e;
                priorityBlockingQueue.add(zzhwVar);
                zzhx zzhxVar = this.f39071c;
                if (zzhxVar == null) {
                    zzhx zzhxVar2 = new zzhx(this, "Measurement Worker", priorityBlockingQueue);
                    this.f39071c = zzhxVar2;
                    zzhxVar2.setUncaughtExceptionHandler(this.f39075g);
                    this.f39071c.start();
                } else {
                    Object obj = zzhxVar.f39066a;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
