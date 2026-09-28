package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

@ElementTypesAreNonnullByDefault
@GwtCompatible
@ReflectionSupport
/* loaded from: classes4.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final Runnable f43456a = new DoNothingRunnable();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f43457b = new DoNothingRunnable();

    @VisibleForTesting
    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final InterruptibleTask f43458a;

        public Blocker(InterruptibleTask interruptibleTask) {
            this.f43458a = interruptibleTask;
        }

        public static void a(Blocker blocker, Thread thread) {
            blocker.setExclusiveOwnerThread(thread);
        }

        @Override // java.lang.Runnable
        public final void run() {
        }

        public final String toString() {
            return this.f43458a.toString();
        }
    }

    public static final class DoNothingRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public abstract void a(Throwable th);

    public abstract void b(Object obj);

    public abstract boolean c();

    public abstract Object d();

    public abstract String e();

    public final void f(Thread thread) {
        Runnable runnable = get();
        Blocker blocker = null;
        boolean z = false;
        int i2 = 0;
        while (true) {
            boolean z2 = runnable instanceof Blocker;
            Runnable runnable2 = f43457b;
            if (!z2 && runnable != runnable2) {
                break;
            }
            if (z2) {
                blocker = (Blocker) runnable;
            }
            i2++;
            if (i2 <= 1000) {
                Thread.yield();
            } else if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                z = Thread.interrupted() || z;
                LockSupport.park(blocker);
            }
            runnable = get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objD = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zC = c();
            Runnable runnable = f43456a;
            if (!zC) {
                try {
                    objD = d();
                } catch (Throwable th) {
                    try {
                        Platform.a(th);
                        if (!compareAndSet(threadCurrentThread, runnable)) {
                            f(threadCurrentThread);
                        }
                        if (zC) {
                            return;
                        }
                        a(th);
                        return;
                    } finally {
                        if (!compareAndSet(threadCurrentThread, runnable)) {
                            f(threadCurrentThread);
                        }
                        if (!zC) {
                            b(null);
                        }
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f43456a) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        StringBuilder sbX = android.support.v4.media.b.x(str, ", ");
        sbX.append(e());
        return sbX.toString();
    }
}
