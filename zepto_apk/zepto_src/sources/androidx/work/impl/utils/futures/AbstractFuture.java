package androidx.work.impl.utils.futures;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

@RestrictTo
/* loaded from: classes.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f13032d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f13033e = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicHelper f13034f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f13035g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f13036a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Listener f13037b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Waiter f13038c;

    public static abstract class AtomicHelper {
        public abstract boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    /* loaded from: classes3.dex */
    public static final class Cancellation {

        /* renamed from: c, reason: collision with root package name */
        public static final Cancellation f13039c;

        /* renamed from: d, reason: collision with root package name */
        public static final Cancellation f13040d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f13041a;

        /* renamed from: b, reason: collision with root package name */
        public final CancellationException f13042b;

        static {
            if (AbstractFuture.f13032d) {
                f13040d = null;
                f13039c = null;
            } else {
                f13040d = new Cancellation(false, null);
                f13039c = new Cancellation(true, null);
            }
        }

        public Cancellation(boolean z, CancellationException cancellationException) {
            this.f13041a = z;
            this.f13042b = cancellationException;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f13043b = new Failure(new AnonymousClass1("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f13044a;

        /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$Failure$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public Failure(Throwable th) {
            boolean z = AbstractFuture.f13032d;
            th.getClass();
            this.f13044a = th;
        }
    }

    public static final class Listener {

        /* renamed from: d, reason: collision with root package name */
        public static final Listener f13045d = new Listener(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f13046a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f13047b;

        /* renamed from: c, reason: collision with root package name */
        public Listener f13048c;

        public Listener(Runnable runnable, Executor executor) {
            this.f13046a = runnable;
            this.f13047b = executor;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f13049a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f13050b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f13051c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f13052d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f13053e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.f13049a = atomicReferenceFieldUpdater;
            this.f13050b = atomicReferenceFieldUpdater2;
            this.f13051c = atomicReferenceFieldUpdater3;
            this.f13052d = atomicReferenceFieldUpdater4;
            this.f13053e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f13052d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == listener);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f13053e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == obj);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f13051c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == waiter);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void d(Waiter waiter, Waiter waiter2) {
            this.f13050b.lazySet(waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void e(Waiter waiter, Thread thread) {
            this.f13049a.lazySet(waiter, thread);
        }
    }

    /* loaded from: classes3.dex */
    public static final class SetFuture<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SettableFuture f13054a;

        /* renamed from: b, reason: collision with root package name */
        public final ListenableFuture f13055b;

        public SetFuture(SettableFuture settableFuture, ListenableFuture listenableFuture) {
            this.f13054a = settableFuture;
            this.f13055b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f13054a.f13036a != this) {
                return;
            }
            if (AbstractFuture.f13034f.b(this.f13054a, this, AbstractFuture.e(this.f13055b))) {
                AbstractFuture.b(this.f13054a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class SynchronizedHelper extends AtomicHelper {
        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f13037b != listener) {
                        return false;
                    }
                    abstractFuture.f13037b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f13036a != obj) {
                        return false;
                    }
                    abstractFuture.f13036a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f13038c != waiter) {
                        return false;
                    }
                    abstractFuture.f13038c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void d(Waiter waiter, Waiter waiter2) {
            waiter.f13058b = waiter2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void e(Waiter waiter, Thread thread) {
            waiter.f13057a = thread;
        }
    }

    public static final class Waiter {

        /* renamed from: c, reason: collision with root package name */
        public static final Waiter f13056c = new Waiter();

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f13057a;

        /* renamed from: b, reason: collision with root package name */
        public volatile Waiter f13058b;

        public Waiter() {
            AbstractFuture.f13034f.e(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        f13034f = synchronizedHelper;
        if (th != null) {
            f13033e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f13035g = new Object();
    }

    public static void b(AbstractFuture abstractFuture) {
        Listener listener;
        Listener listener2;
        Listener listener3 = null;
        while (true) {
            Waiter waiter = abstractFuture.f13038c;
            if (f13034f.c(abstractFuture, waiter, Waiter.f13056c)) {
                while (waiter != null) {
                    Thread thread = waiter.f13057a;
                    if (thread != null) {
                        waiter.f13057a = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.f13058b;
                }
                do {
                    listener = abstractFuture.f13037b;
                } while (!f13034f.a(abstractFuture, listener, Listener.f13045d));
                while (true) {
                    listener2 = listener3;
                    listener3 = listener;
                    if (listener3 == null) {
                        break;
                    }
                    listener = listener3.f13048c;
                    listener3.f13048c = listener2;
                }
                while (listener2 != null) {
                    listener3 = listener2.f13048c;
                    Runnable runnable = listener2.f13046a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.f13054a;
                        if (abstractFuture.f13036a == setFuture) {
                            if (f13034f.b(abstractFuture, setFuture, e(setFuture.f13055b))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        c(runnable, listener2.f13047b);
                    }
                    listener2 = listener3;
                }
                return;
            }
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f13033e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object d(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            CancellationException cancellationException = ((Cancellation) obj).f13042b;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f13044a);
        }
        if (obj == f13035g) {
            return null;
        }
        return obj;
    }

    public static Object e(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).f13036a;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            return cancellation.f13041a ? cancellation.f13042b != null ? new Cancellation(false, cancellation.f13042b) : Cancellation.f13040d : obj;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f13032d) && zIsCancelled) {
            return Cancellation.f13040d;
        }
        try {
            Object objF = f(listenableFuture);
            return objF == null ? f13035g : objF;
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new Cancellation(false, e2);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
        } catch (ExecutionException e3) {
            return new Failure(e3.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    public static Object f(ListenableFuture listenableFuture) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = listenableFuture.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objF = f(this);
            sb.append("SUCCESS, result=[");
            sb.append(objF == this ? "this future" : String.valueOf(objF));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f13036a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
            r3 = r1
            goto L9
        L8:
            r3 = r2
        L9:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L5b
            boolean r3 = androidx.work.impl.utils.futures.AbstractFuture.f13032d
            if (r3 == 0) goto L1f
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = new androidx.work.impl.utils.futures.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L26
        L1f:
            if (r8 == 0) goto L24
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = androidx.work.impl.utils.futures.AbstractFuture.Cancellation.f13039c
            goto L26
        L24:
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r3 = androidx.work.impl.utils.futures.AbstractFuture.Cancellation.f13040d
        L26:
            r4 = r7
            r5 = r2
        L28:
            androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper r6 = androidx.work.impl.utils.futures.AbstractFuture.f13034f
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L54
            b(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            if (r4 == 0) goto L53
            androidx.work.impl.utils.futures.AbstractFuture$SetFuture r0 = (androidx.work.impl.utils.futures.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.f13055b
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture
            if (r4 == 0) goto L50
            r4 = r0
            androidx.work.impl.utils.futures.AbstractFuture r4 = (androidx.work.impl.utils.futures.AbstractFuture) r4
            java.lang.Object r0 = r4.f13036a
            if (r0 != 0) goto L48
            r5 = r1
            goto L49
        L48:
            r5 = r2
        L49:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L53
            r5 = r1
            goto L28
        L50:
            r0.cancel(r8)
        L53:
            return r1
        L54:
            java.lang.Object r0 = r4.f13036a
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.SetFuture
            if (r6 != 0) goto L28
            return r5
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.cancel(boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String g() {
        Object obj = this.f13036a;
        if (obj instanceof SetFuture) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ListenableFuture listenableFuture = ((SetFuture) obj).f13055b;
            return b.r(sb, listenableFuture == this ? "this future" : String.valueOf(listenableFuture), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f13036a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return d(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.f13038c;
            Waiter waiter2 = Waiter.f13056c;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                z = true;
                do {
                    AtomicHelper atomicHelper = f13034f;
                    atomicHelper.d(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(waiter3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f13036a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return d(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(waiter3);
                    } else {
                        waiter = this.f13038c;
                    }
                } while (waiter != waiter2);
            }
            return d(this.f13036a);
        }
        z = true;
        while (nanos > 0) {
            Object obj3 = this.f13036a;
            if ((obj3 != null ? z : false) && (!(obj3 instanceof SetFuture))) {
                return d(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sbV = b.v(j2, "Waited ", StringUtils.SPACE);
        sbV.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbV.toString();
        if (nanos + 1000 < 0) {
            String strK = b.k(string3, " (plus ");
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z2 = (jConvert == 0 || nanos2 > 1000) ? z : false;
            if (jConvert > 0) {
                String strK2 = strK + jConvert + StringUtils.SPACE + lowerCase;
                if (z2) {
                    strK2 = b.k(strK2, ",");
                }
                strK = b.k(strK2, StringUtils.SPACE);
            }
            if (z2) {
                strK = strK + nanos2 + " nanoseconds ";
            }
            string3 = b.k(strK, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(b.k(string3, " but future completed as timeout expired"));
        }
        throw new TimeoutException(b.l(string3, " for ", string));
    }

    public final void h(Waiter waiter) {
        waiter.f13057a = null;
        while (true) {
            Waiter waiter2 = this.f13038c;
            if (waiter2 == Waiter.f13056c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f13058b;
                if (waiter2.f13057a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f13058b = waiter4;
                    if (waiter3.f13057a == null) {
                        break;
                    }
                } else if (!f13034f.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f13036a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f13036a != null);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        Listener listener = this.f13037b;
        Listener listener2 = Listener.f13045d;
        if (listener != listener2) {
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.f13048c = listener;
                if (f13034f.a(this, listener, listener3)) {
                    return;
                } else {
                    listener = this.f13037b;
                }
            } while (listener != listener2);
        }
        c(runnable, executor);
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f13036a instanceof Cancellation) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e2) {
                strG = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                a.u(sb, "PENDING, info=[", strG, "]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f13036a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return d(obj2);
            }
            Waiter waiter = this.f13038c;
            Waiter waiter2 = Waiter.f13056c;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                do {
                    AtomicHelper atomicHelper = f13034f;
                    atomicHelper.d(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f13036a;
                            } else {
                                h(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return d(obj);
                    }
                    waiter = this.f13038c;
                } while (waiter != waiter2);
            }
            return d(this.f13036a);
        }
        throw new InterruptedException();
    }
}
