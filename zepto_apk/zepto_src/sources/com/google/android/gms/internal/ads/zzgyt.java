package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes4.dex */
abstract class zzgyt extends AtomicReference implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final Runnable f33381a = new zzgys();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f33382b = new zzgys();

    public abstract Object a();

    public final void b(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzgyr zzgyrVar = null;
        boolean z = false;
        int i2 = 0;
        while (true) {
            boolean z2 = runnable instanceof zzgyr;
            Runnable runnable2 = f33382b;
            if (!z2) {
                if (runnable != runnable2) {
                    break;
                }
            } else {
                zzgyrVar = (zzgyr) runnable;
            }
            i2++;
            if (i2 <= 1000) {
                Thread.yield();
            } else if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                z = Thread.interrupted() || z;
                LockSupport.park(zzgyrVar);
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    public abstract String c();

    public abstract boolean d();

    public abstract void e(Object obj);

    public abstract void f(Throwable th);

    public final void g() {
        Runnable runnable = f33382b;
        Runnable runnable2 = f33381a;
        Runnable runnable3 = (Runnable) get();
        if (runnable3 instanceof Thread) {
            zzgyr zzgyrVar = new zzgyr(this);
            zzgyrVar.a(Thread.currentThread());
            if (compareAndSet(runnable3, zzgyrVar)) {
                try {
                    Thread thread = (Thread) runnable3;
                    thread.interrupt();
                    if (((Runnable) getAndSet(runnable2)) == runnable) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(runnable2)) == runnable) {
                        LockSupport.unpark((Thread) runnable3);
                    }
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objA = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zD = d();
            Runnable runnable = f33381a;
            if (!zD) {
                try {
                    objA = a();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, runnable)) {
                            b(threadCurrentThread);
                        }
                        f(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, runnable)) {
                            b(threadCurrentThread);
                        }
                        e(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, runnable)) {
                b(threadCurrentThread);
            }
            if (zD) {
                return;
            }
            e(objA);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String strS;
        Runnable runnable = (Runnable) get();
        if (runnable == f33381a) {
            strS = "running=[DONE]";
        } else if (runnable instanceof zzgyr) {
            strS = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            strS = android.support.v4.media.b.s(new StringBuilder(String.valueOf(name).length() + 21), "running=[RUNNING ON ", name, "]");
        } else {
            strS = "running=[NOT STARTED YET]";
        }
        String strC = c();
        return android.support.v4.media.b.s(new StringBuilder(strS.length() + 2 + String.valueOf(strC).length()), strS, ", ", strC);
    }
}
