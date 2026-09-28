package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@GwtCompatible
@ReflectionSupport
/* loaded from: classes4.dex */
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f43388d;

    /* renamed from: e, reason: collision with root package name */
    public static final LazyLogger f43389e;

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicHelper f43390f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f43391g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f43392a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Listener f43393b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Waiter f43394c;

    public static abstract class AtomicHelper {
        public abstract boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract Listener d(AbstractFuture abstractFuture);

        public abstract Waiter e(AbstractFuture abstractFuture);

        public abstract void f(Waiter waiter, Waiter waiter2);

        public abstract void g(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {

        /* renamed from: c, reason: collision with root package name */
        public static final Cancellation f43395c;

        /* renamed from: d, reason: collision with root package name */
        public static final Cancellation f43396d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f43397a;

        /* renamed from: b, reason: collision with root package name */
        public final RuntimeException f43398b;

        static {
            if (AbstractFuture.f43388d) {
                f43396d = null;
                f43395c = null;
            } else {
                f43396d = new Cancellation(false, null);
                f43395c = new Cancellation(true, null);
            }
        }

        public Cancellation(boolean z, RuntimeException runtimeException) {
            this.f43397a = z;
            this.f43398b = runtimeException;
        }
    }

    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f43399b = new Failure(new AnonymousClass1("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f43400a;

        /* renamed from: com.google.common.util.concurrent.AbstractFuture$Failure$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public Failure(Throwable th) {
            th.getClass();
            this.f43400a = th;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f43405a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f43406b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f43407c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f43408d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f43409e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.f43405a = atomicReferenceFieldUpdater;
            this.f43406b = atomicReferenceFieldUpdater2;
            this.f43407c = atomicReferenceFieldUpdater3;
            this.f43408d = atomicReferenceFieldUpdater4;
            this.f43409e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f43408d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == listener);
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f43409e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == obj);
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f43407c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == waiter);
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final Listener d(AbstractFuture abstractFuture) {
            return (Listener) this.f43408d.getAndSet(abstractFuture, Listener.f43401d);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final Waiter e(AbstractFuture abstractFuture) {
            return (Waiter) this.f43407c.getAndSet(abstractFuture, Waiter.f43418c);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final void f(Waiter waiter, Waiter waiter2) {
            this.f43406b.lazySet(waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final void g(Waiter waiter, Thread thread) {
            this.f43405a.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractFuture f43410a;

        /* renamed from: b, reason: collision with root package name */
        public final ListenableFuture f43411b;

        public SetFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.f43410a = abstractFuture;
            this.f43411b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f43410a.f43392a != this) {
                return;
            }
            if (AbstractFuture.f43390f.b(this.f43410a, this, AbstractFuture.h(this.f43411b))) {
                AbstractFuture.e(this.f43410a, false);
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f43393b != listener) {
                        return false;
                    }
                    abstractFuture.f43393b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f43392a != obj) {
                        return false;
                    }
                    abstractFuture.f43392a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f43394c != waiter) {
                        return false;
                    }
                    abstractFuture.f43394c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final Listener d(AbstractFuture abstractFuture) {
            Listener listener;
            Listener listener2 = Listener.f43401d;
            synchronized (abstractFuture) {
                listener = abstractFuture.f43393b;
                if (listener != listener2) {
                    abstractFuture.f43393b = listener2;
                }
            }
            return listener;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final Waiter e(AbstractFuture abstractFuture) {
            Waiter waiter;
            Waiter waiter2 = Waiter.f43418c;
            synchronized (abstractFuture) {
                waiter = abstractFuture.f43394c;
                if (waiter != waiter2) {
                    abstractFuture.f43394c = waiter2;
                }
            }
            return waiter;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final void f(Waiter waiter, Waiter waiter2) {
            waiter.f43420b = waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final void g(Waiter waiter, Thread thread) {
            waiter.f43419a = thread;
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f43392a instanceof Cancellation;
        }
    }

    public static final class UnsafeAtomicHelper extends AtomicHelper {

        /* renamed from: a, reason: collision with root package name */
        public static final Unsafe f43412a;

        /* renamed from: b, reason: collision with root package name */
        public static final long f43413b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f43414c;

        /* renamed from: d, reason: collision with root package name */
        public static final long f43415d;

        /* renamed from: e, reason: collision with root package name */
        public static final long f43416e;

        /* renamed from: f, reason: collision with root package name */
        public static final long f43417f;

        /* renamed from: com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1, reason: invalid class name */
        public class AnonymousClass1 implements PrivilegedExceptionAction<Unsafe> {
            public static Unsafe a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }

            @Override // java.security.PrivilegedExceptionAction
            public final /* bridge */ /* synthetic */ Unsafe run() {
                return a();
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
            }
            try {
                f43414c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("c"));
                f43413b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("b"));
                f43415d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                f43416e = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("a"));
                f43417f = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("b"));
                f43412a = unsafe;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            return a.a(f43412a, abstractFuture, f43413b, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return a.a(f43412a, abstractFuture, f43415d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(f43412a, abstractFuture, f43414c, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final Listener d(AbstractFuture abstractFuture) {
            Listener listener;
            Listener listener2 = Listener.f43401d;
            do {
                listener = abstractFuture.f43393b;
                if (listener2 == listener) {
                    break;
                }
            } while (!a(abstractFuture, listener, listener2));
            return listener;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final Waiter e(AbstractFuture abstractFuture) {
            Waiter waiter;
            Waiter waiter2 = Waiter.f43418c;
            do {
                waiter = abstractFuture.f43394c;
                if (waiter2 == waiter) {
                    break;
                }
            } while (!c(abstractFuture, waiter, waiter2));
            return waiter;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final void f(Waiter waiter, Waiter waiter2) {
            f43412a.putObject(waiter, f43417f, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public final void g(Waiter waiter, Thread thread) {
            f43412a.putObject(waiter, f43416e, thread);
        }
    }

    public static final class Waiter {

        /* renamed from: c, reason: collision with root package name */
        public static final Waiter f43418c = new Waiter();

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f43419a;

        /* renamed from: b, reason: collision with root package name */
        public volatile Waiter f43420b;

        public Waiter() {
            AbstractFuture.f43390f.g(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        Throwable th;
        AtomicHelper synchronizedHelper;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f43388d = z;
        f43389e = new LazyLogger(AbstractFuture.class);
        Throwable th2 = null;
        try {
            synchronizedHelper = new UnsafeAtomicHelper();
            th = null;
        } catch (Error | Exception e2) {
            th = e2;
            try {
                synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            } catch (Error | Exception e3) {
                th2 = e3;
                synchronizedHelper = new SynchronizedHelper();
            }
        }
        f43390f = synchronizedHelper;
        if (th2 != null) {
            LazyLogger lazyLogger = f43389e;
            Logger loggerA = lazyLogger.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", th);
            lazyLogger.a().log(level, "SafeAtomicHelper is broken!", th2);
        }
        f43391g = new Object();
    }

    public static void e(AbstractFuture abstractFuture, boolean z) {
        Listener listener = null;
        while (true) {
            abstractFuture.getClass();
            for (Waiter waiterE = f43390f.e(abstractFuture); waiterE != null; waiterE = waiterE.f43420b) {
                Thread thread = waiterE.f43419a;
                if (thread != null) {
                    waiterE.f43419a = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                abstractFuture.j();
                z = false;
            }
            abstractFuture.c();
            Listener listener2 = listener;
            Listener listenerD = f43390f.d(abstractFuture);
            Listener listener3 = listener2;
            while (listenerD != null) {
                Listener listener4 = listenerD.f43404c;
                listenerD.f43404c = listener3;
                listener3 = listenerD;
                listenerD = listener4;
            }
            while (listener3 != null) {
                listener = listener3.f43404c;
                Runnable runnable = listener3.f43402a;
                Objects.requireNonNull(runnable);
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.f43410a;
                    if (abstractFuture.f43392a == setFuture) {
                        if (f43390f.b(abstractFuture, setFuture, h(setFuture.f43411b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = listener3.f43403b;
                    Objects.requireNonNull(executor);
                    f(runnable, executor);
                }
                listener3 = listener;
            }
            return;
        }
    }

    public static void f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            f43389e.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object g(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            RuntimeException runtimeException = ((Cancellation) obj).f43398b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(runtimeException);
            throw cancellationException;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f43400a);
        }
        if (obj == f43391g) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object h(ListenableFuture listenableFuture) {
        Throwable thA;
        if (listenableFuture instanceof Trusted) {
            Object cancellation = ((AbstractFuture) listenableFuture).f43392a;
            if (cancellation instanceof Cancellation) {
                Cancellation cancellation2 = (Cancellation) cancellation;
                if (cancellation2.f43397a) {
                    cancellation = cancellation2.f43398b != null ? new Cancellation(false, cancellation2.f43398b) : Cancellation.f43396d;
                }
            }
            Objects.requireNonNull(cancellation);
            return cancellation;
        }
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (thA = ((InternalFutureFailureAccess) listenableFuture).a()) != null) {
            return new Failure(thA);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f43388d) && zIsCancelled) {
            Cancellation cancellation3 = Cancellation.f43396d;
            Objects.requireNonNull(cancellation3);
            return cancellation3;
        }
        try {
            try {
                try {
                    Object objI = i(listenableFuture);
                    if (!zIsCancelled) {
                        return objI == null ? f43391g : objI;
                    }
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
                } catch (Error | Exception e2) {
                    e = e2;
                    return new Failure(e);
                }
            } catch (Error e3) {
                e = e3;
                return new Failure(e);
            }
        } catch (CancellationException e4) {
            if (zIsCancelled) {
                return new Cancellation(false, e4);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e4));
        } catch (ExecutionException e5) {
            if (!zIsCancelled) {
                return new Failure(e5.getCause());
            }
            return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e5));
        }
    }

    public static Object i(ListenableFuture listenableFuture) {
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

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    public final Throwable a() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.f43392a;
        if (obj instanceof Failure) {
            return ((Failure) obj).f43400a;
        }
        return null;
    }

    public final void b(StringBuilder sb) {
        try {
            Object objI = i(this);
            sb.append("SUCCESS, result=[");
            d(sb, objI);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.f43392a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (f43388d) {
            cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
        } else {
            cancellation = z ? Cancellation.f43395c : Cancellation.f43396d;
            Objects.requireNonNull(cancellation);
        }
        AbstractFuture<V> abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (f43390f.b(abstractFuture, obj, cancellation)) {
                e(abstractFuture, z);
                if (!(obj instanceof SetFuture)) {
                    break;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).f43411b;
                if (!(listenableFuture instanceof Trusted)) {
                    listenableFuture.cancel(z);
                    break;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.f43392a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    break;
                }
                z2 = true;
            } else {
                obj = abstractFuture.f43392a;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
        return true;
    }

    public final void d(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        long j3;
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f43392a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return g(obj);
        }
        long j4 = 0;
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.f43394c;
            Waiter waiter2 = Waiter.f43418c;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                z = true;
                while (true) {
                    AtomicHelper atomicHelper = f43390f;
                    atomicHelper.f(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        j3 = j4;
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                m(waiter3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f43392a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return g(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m(waiter3);
                    } else {
                        long j5 = j4;
                        waiter = this.f43394c;
                        if (waiter == waiter2) {
                            break;
                        }
                        j4 = j5;
                    }
                }
            }
            Object obj3 = this.f43392a;
            Objects.requireNonNull(obj3);
            return g(obj3);
        }
        z = true;
        j3 = 0;
        while (nanos > j3) {
            Object obj4 = this.f43392a;
            if ((obj4 != null ? z : false) && (!(obj4 instanceof SetFuture))) {
                return g(obj4);
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
        StringBuilder sbV = android.support.v4.media.b.v(j2, "Waited ", StringUtils.SPACE);
        sbV.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbV.toString();
        if (nanos + 1000 < j3) {
            String strK = android.support.v4.media.b.k(string3, " (plus ");
            long j6 = -nanos;
            long jConvert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
            long nanos2 = j6 - timeUnit.toNanos(jConvert);
            boolean z2 = (jConvert == j3 || nanos2 > 1000) ? z : false;
            if (jConvert > j3) {
                String strK2 = strK + jConvert + StringUtils.SPACE + lowerCase;
                if (z2) {
                    strK2 = android.support.v4.media.b.k(strK2, ",");
                }
                strK = android.support.v4.media.b.k(strK2, StringUtils.SPACE);
            }
            if (z2) {
                strK = strK + nanos2 + " nanoseconds ";
            }
            string3 = android.support.v4.media.b.k(strK, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(android.support.v4.media.b.k(string3, " but future completed as timeout expired"));
        }
        throw new TimeoutException(android.support.v4.media.b.l(string3, " for ", string));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f43392a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f43392a != null);
    }

    public void j() {
    }

    public final void k(Future future) {
        boolean z = false;
        if ((future != null) && isCancelled()) {
            Object obj = this.f43392a;
            if ((obj instanceof Cancellation) && ((Cancellation) obj).f43397a) {
                z = true;
            }
            future.cancel(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String l() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void m(Waiter waiter) {
        waiter.f43419a = null;
        while (true) {
            Waiter waiter2 = this.f43394c;
            if (waiter2 == Waiter.f43418c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f43420b;
                if (waiter2.f43419a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f43420b = waiter4;
                    if (waiter3.f43419a == null) {
                        break;
                    }
                } else if (!f43390f.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    public boolean n(Object obj) {
        if (obj == null) {
            obj = f43391g;
        }
        if (!f43390f.b(this, null, obj)) {
            return false;
        }
        e(this, false);
        return true;
    }

    public boolean o(Throwable th) {
        th.getClass();
        if (!f43390f.b(this, null, new Failure(th))) {
            return false;
        }
        e(this, false);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean p(com.google.common.util.concurrent.ListenableFuture r6) {
        /*
            r5 = this;
            r6.getClass()
            java.lang.Object r0 = r5.f43392a
            r1 = 0
            if (r0 != 0) goto L44
            boolean r0 = r6.isDone()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L20
            java.lang.Object r6 = h(r6)
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r0 = com.google.common.util.concurrent.AbstractFuture.f43390f
            boolean r6 = r0.b(r5, r3, r6)
            if (r6 == 0) goto L4f
            e(r5, r1)
            return r2
        L20:
            com.google.common.util.concurrent.AbstractFuture$SetFuture r0 = new com.google.common.util.concurrent.AbstractFuture$SetFuture
            r0.<init>(r5, r6)
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r4 = com.google.common.util.concurrent.AbstractFuture.f43390f
            boolean r3 = r4.b(r5, r3, r0)
            if (r3 == 0) goto L42
            com.google.common.util.concurrent.DirectExecutor r1 = com.google.common.util.concurrent.DirectExecutor.f43436a     // Catch: java.lang.Throwable -> L33
            r6.q(r0, r1)     // Catch: java.lang.Throwable -> L33
            return r2
        L33:
            r6 = move-exception
            com.google.common.util.concurrent.AbstractFuture$Failure r1 = new com.google.common.util.concurrent.AbstractFuture$Failure     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            goto L3c
        L3a:
            com.google.common.util.concurrent.AbstractFuture$Failure r1 = com.google.common.util.concurrent.AbstractFuture.Failure.f43399b
        L3c:
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r6 = com.google.common.util.concurrent.AbstractFuture.f43390f
            r6.b(r5, r0, r1)
            return r2
        L42:
            java.lang.Object r0 = r5.f43392a
        L44:
            boolean r2 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.Cancellation
            if (r2 == 0) goto L4f
            com.google.common.util.concurrent.AbstractFuture$Cancellation r0 = (com.google.common.util.concurrent.AbstractFuture.Cancellation) r0
            boolean r0 = r0.f43397a
            r6.cancel(r0)
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.p(com.google.common.util.concurrent.ListenableFuture):boolean");
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void q(Runnable runnable, Executor executor) {
        Listener listener;
        Listener listener2;
        Preconditions.j(runnable, "Runnable was null.");
        Preconditions.j(executor, "Executor was null.");
        if (!isDone() && (listener = this.f43393b) != (listener2 = Listener.f43401d)) {
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.f43404c = listener;
                if (f43390f.a(this, listener, listener3)) {
                    return;
                } else {
                    listener = this.f43393b;
                }
            } while (listener != listener2);
        }
        f(runnable, executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r6.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.google.common.util.concurrent."
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L21
            java.lang.Class r1 = r6.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            goto L2c
        L21:
            java.lang.Class r1 = r6.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
        L2c:
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r6)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            boolean r1 = r6.isCancelled()
            java.lang.String r2 = "]"
            if (r1 == 0) goto L50
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto Lcb
        L50:
            boolean r1 = r6.isDone()
            if (r1 == 0) goto L5b
            r6.b(r0)
            goto Lcb
        L5b:
            int r1 = r0.length()
            java.lang.String r3 = "PENDING"
            r0.append(r3)
            java.lang.Object r3 = r6.f43392a
            boolean r4 = r3 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            java.lang.String r5 = "Exception thrown from implementation: "
            if (r4 == 0) goto L93
            java.lang.String r4 = ", setFuture=["
            r0.append(r4)
            com.google.common.util.concurrent.AbstractFuture$SetFuture r3 = (com.google.common.util.concurrent.AbstractFuture.SetFuture) r3
            com.google.common.util.concurrent.ListenableFuture r3 = r3.f43411b
            if (r3 != r6) goto L81
            java.lang.String r3 = "this future"
            r0.append(r3)     // Catch: java.lang.StackOverflowError -> L7d java.lang.Exception -> L7f
            goto L8f
        L7d:
            r3 = move-exception
            goto L85
        L7f:
            r3 = move-exception
            goto L85
        L81:
            r0.append(r3)     // Catch: java.lang.StackOverflowError -> L7d java.lang.Exception -> L7f
            goto L8f
        L85:
            r0.append(r5)
            java.lang.Class r3 = r3.getClass()
            r0.append(r3)
        L8f:
            r0.append(r2)
            goto Lbb
        L93:
            java.lang.String r3 = r6.l()     // Catch: java.lang.StackOverflowError -> La1 java.lang.Exception -> La3
            if (r3 == 0) goto L9f
            boolean r4 = r3.isEmpty()     // Catch: java.lang.StackOverflowError -> La1 java.lang.Exception -> La3
            if (r4 == 0) goto Lb4
        L9f:
            r3 = 0
            goto Lb4
        La1:
            r3 = move-exception
            goto La4
        La3:
            r3 = move-exception
        La4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r5)
            java.lang.Class r3 = r3.getClass()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        Lb4:
            if (r3 == 0) goto Lbb
            java.lang.String r4 = ", info=["
            android.support.v4.media.a.u(r0, r4, r3, r2)
        Lbb:
            boolean r3 = r6.isDone()
            if (r3 == 0) goto Lcb
            int r3 = r0.length()
            r0.delete(r1, r3)
            r6.b(r0)
        Lcb:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.toString():java.lang.String");
    }

    public static final class Listener {

        /* renamed from: d, reason: collision with root package name */
        public static final Listener f43401d = new Listener();

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f43402a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f43403b;

        /* renamed from: c, reason: collision with root package name */
        public Listener f43404c;

        public Listener(Runnable runnable, Executor executor) {
            this.f43402a = runnable;
            this.f43403b = executor;
        }

        public Listener() {
            this.f43402a = null;
            this.f43403b = null;
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f43392a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return g(obj2);
            }
            Waiter waiter = this.f43394c;
            Waiter waiter2 = Waiter.f43418c;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                do {
                    AtomicHelper atomicHelper = f43390f;
                    atomicHelper.f(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f43392a;
                            } else {
                                m(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return g(obj);
                    }
                    waiter = this.f43394c;
                } while (waiter != waiter2);
            }
            Object obj3 = this.f43392a;
            Objects.requireNonNull(obj3);
            return g(obj3);
        }
        throw new InterruptedException();
    }
}
