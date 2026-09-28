package androidx.concurrent.futures;

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
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1614d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f1615e = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicHelper f1616f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f1617g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f1618a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Listener f1619b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Waiter f1620c;

    /* loaded from: classes3.dex */
    public static abstract class AtomicHelper {
        public abstract boolean a(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    /* loaded from: classes3.dex */
    public static final class Cancellation {

        /* renamed from: c, reason: collision with root package name */
        public static final Cancellation f1621c;

        /* renamed from: d, reason: collision with root package name */
        public static final Cancellation f1622d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1623a;

        /* renamed from: b, reason: collision with root package name */
        public final CancellationException f1624b;

        static {
            if (AbstractResolvableFuture.f1614d) {
                f1622d = null;
                f1621c = null;
            } else {
                f1622d = new Cancellation(false, null);
                f1621c = new Cancellation(true, null);
            }
        }

        public Cancellation(boolean z, CancellationException cancellationException) {
            this.f1623a = z;
            this.f1624b = cancellationException;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Failure {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1625a;

        /* renamed from: androidx.concurrent.futures.AbstractResolvableFuture$Failure$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new Failure(new AnonymousClass1("Failure occurred while trying to finish a future."));
        }

        public Failure(Throwable th) {
            boolean z = AbstractResolvableFuture.f1614d;
            th.getClass();
            this.f1625a = th;
        }
    }

    public static final class Listener {

        /* renamed from: d, reason: collision with root package name */
        public static final Listener f1626d = new Listener(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f1627a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f1628b;

        /* renamed from: c, reason: collision with root package name */
        public Listener f1629c;

        public Listener(Runnable runnable, Executor executor) {
            this.f1627a = runnable;
            this.f1628b = executor;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1630a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1631b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1632c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1633d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1634e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.f1630a = atomicReferenceFieldUpdater;
            this.f1631b = atomicReferenceFieldUpdater2;
            this.f1632c = atomicReferenceFieldUpdater3;
            this.f1633d = atomicReferenceFieldUpdater4;
            this.f1634e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final boolean a(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1633d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == listener);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1634e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final boolean c(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1632c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == waiter);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final void d(Waiter waiter, Waiter waiter2) {
            this.f1631b.lazySet(waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final void e(Waiter waiter, Thread thread) {
            this.f1630a.lazySet(waiter, thread);
        }
    }

    /* loaded from: classes3.dex */
    public static final class SetFuture<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SynchronizedHelper extends AtomicHelper {
        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final boolean a(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f1619b != listener) {
                        return false;
                    }
                    abstractResolvableFuture.f1619b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f1618a != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f1618a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final boolean c(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f1620c != waiter) {
                        return false;
                    }
                    abstractResolvableFuture.f1620c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final void d(Waiter waiter, Waiter waiter2) {
            waiter.f1637b = waiter2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public final void e(Waiter waiter, Thread thread) {
            waiter.f1636a = thread;
        }
    }

    public static final class Waiter {

        /* renamed from: c, reason: collision with root package name */
        public static final Waiter f1635c = new Waiter();

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f1636a;

        /* renamed from: b, reason: collision with root package name */
        public volatile Waiter f1637b;

        public Waiter() {
            AbstractResolvableFuture.f1616f.e(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        f1616f = synchronizedHelper;
        if (th != null) {
            f1615e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1617g = new Object();
    }

    public static void c(AbstractResolvableFuture abstractResolvableFuture) {
        Waiter waiter;
        Listener listener;
        do {
            waiter = abstractResolvableFuture.f1620c;
        } while (!f1616f.c(abstractResolvableFuture, waiter, Waiter.f1635c));
        while (waiter != null) {
            Thread thread = waiter.f1636a;
            if (thread != null) {
                waiter.f1636a = null;
                LockSupport.unpark(thread);
            }
            waiter = waiter.f1637b;
        }
        abstractResolvableFuture.b();
        do {
            listener = abstractResolvableFuture.f1619b;
        } while (!f1616f.a(abstractResolvableFuture, listener, Listener.f1626d));
        Listener listener2 = null;
        while (listener != null) {
            Listener listener3 = listener.f1629c;
            listener.f1629c = listener2;
            listener2 = listener;
            listener = listener3;
        }
        while (listener2 != null) {
            Listener listener4 = listener2.f1629c;
            Runnable runnable = listener2.f1627a;
            if (runnable instanceof SetFuture) {
                ((SetFuture) runnable).getClass();
                throw null;
            }
            d(runnable, listener2.f1628b);
            listener2 = listener4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f1615e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            CancellationException cancellationException = ((Cancellation) obj).f1624b;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f1625a);
        }
        if (obj == f1617g) {
            return null;
        }
        return obj;
    }

    public static Object g(AbstractResolvableFuture abstractResolvableFuture) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = abstractResolvableFuture.get();
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
            Object objG = g(this);
            sb.append("SUCCESS, result=[");
            sb.append(objG == this ? "this future" : String.valueOf(objG));
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

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.f1618a;
        if ((obj == null) | (obj instanceof SetFuture)) {
            Cancellation cancellation = f1614d ? new Cancellation(z, new CancellationException("Future.cancel() was called.")) : z ? Cancellation.f1621c : Cancellation.f1622d;
            while (!f1616f.b(this, obj, cancellation)) {
                obj = this.f1618a;
                if (!(obj instanceof SetFuture)) {
                }
            }
            c(this);
            if (!(obj instanceof SetFuture)) {
                return true;
            }
            ((SetFuture) obj).getClass();
            throw null;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1618a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.f1620c;
            Waiter waiter2 = Waiter.f1635c;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                z = true;
                do {
                    AtomicHelper atomicHelper = f1616f;
                    atomicHelper.d(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                i(waiter3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1618a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return e(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        i(waiter3);
                    } else {
                        waiter = this.f1620c;
                    }
                } while (waiter != waiter2);
            }
            return e(this.f1618a);
        }
        z = true;
        while (nanos > 0) {
            Object obj3 = this.f1618a;
            if ((obj3 != null ? z : false) && (!(obj3 instanceof SetFuture))) {
                return e(obj3);
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

    /* JADX WARN: Multi-variable type inference failed */
    public String h() {
        Object obj = this.f1618a;
        if (obj instanceof SetFuture) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ((SetFuture) obj).getClass();
            sb.append("null");
            sb.append("]");
            return sb.toString();
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(Waiter waiter) {
        waiter.f1636a = null;
        while (true) {
            Waiter waiter2 = this.f1620c;
            if (waiter2 == Waiter.f1635c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f1637b;
                if (waiter2.f1636a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f1637b = waiter4;
                    if (waiter3.f1636a == null) {
                        break;
                    }
                } else if (!f1616f.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1618a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f1618a != null);
    }

    public boolean l(Object obj) {
        if (obj == null) {
            obj = f1617g;
        }
        if (!f1616f.b(this, null, obj)) {
            return false;
        }
        c(this);
        return true;
    }

    public boolean n(Throwable th) {
        th.getClass();
        if (!f1616f.b(this, null, new Failure(th))) {
            return false;
        }
        c(this);
        return true;
    }

    public final boolean p() {
        Object obj = this.f1618a;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f1623a;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        Listener listener = this.f1619b;
        Listener listener2 = Listener.f1626d;
        if (listener != listener2) {
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.f1629c = listener;
                if (f1616f.a(this, listener, listener3)) {
                    return;
                } else {
                    listener = this.f1619b;
                }
            } while (listener != listener2);
        }
        d(runnable, executor);
    }

    public final String toString() {
        String strH;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f1618a instanceof Cancellation) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strH = h();
            } catch (RuntimeException e2) {
                strH = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strH != null && !strH.isEmpty()) {
                a.u(sb, "PENDING, info=[", strH, "]");
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
            Object obj2 = this.f1618a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return e(obj2);
            }
            Waiter waiter = this.f1620c;
            Waiter waiter2 = Waiter.f1635c;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                do {
                    AtomicHelper atomicHelper = f1616f;
                    atomicHelper.d(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1618a;
                            } else {
                                i(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return e(obj);
                    }
                    waiter = this.f1620c;
                } while (waiter != waiter2);
            }
            return e(this.f1618a);
        }
        throw new InterruptedException();
    }
}
