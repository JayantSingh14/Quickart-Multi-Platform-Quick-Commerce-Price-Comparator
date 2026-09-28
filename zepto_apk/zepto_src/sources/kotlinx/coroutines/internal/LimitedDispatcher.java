package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55078g = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Delay f55079b;

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineDispatcher f55080c;

    /* renamed from: d, reason: collision with root package name */
    public final int f55081d;

    /* renamed from: e, reason: collision with root package name */
    public final LockFreeTaskQueue f55082e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f55083f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    @Metadata
    public final class Worker implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f55084a;

        public Worker(Runnable runnable) {
            this.f55084a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = 0;
            while (true) {
                try {
                    this.f55084a.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.a(EmptyCoroutineContext.f53685a, th);
                }
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = LimitedDispatcher.f55078g;
                LimitedDispatcher limitedDispatcher = LimitedDispatcher.this;
                Runnable runnableO1 = limitedDispatcher.O1();
                if (runnableO1 == null) {
                    return;
                }
                this.f55084a = runnableO1;
                i2++;
                if (i2 >= 16) {
                    CoroutineDispatcher coroutineDispatcher = limitedDispatcher.f55080c;
                    if (coroutineDispatcher.o1(limitedDispatcher)) {
                        coroutineDispatcher.c1(limitedDispatcher, this);
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i2) {
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.f55079b = delay == null ? DefaultExecutorKt.f54086a : delay;
        this.f55080c = coroutineDispatcher;
        this.f55081d = i2;
        this.f55082e = new LockFreeTaskQueue();
        this.f55083f = new Object();
    }

    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f55079b.A(j2, cancellableContinuationImpl);
    }

    public final Runnable O1() {
        while (true) {
            Runnable runnable = (Runnable) this.f55082e.c();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f55083f) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55078g;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f55082e.b() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean S1() {
        synchronized (this.f55083f) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55078g;
            if (atomicIntegerFieldUpdater.get(this) >= this.f55081d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f55079b.b(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableO1;
        this.f55082e.a(runnable);
        if (f55078g.get(this) >= this.f55081d || !S1() || (runnableO1 = O1()) == null) {
            return;
        }
        this.f55080c.c1(this, new Worker(runnableO1));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableO1;
        this.f55082e.a(runnable);
        if (f55078g.get(this) >= this.f55081d || !S1() || (runnableO1 = O1()) == null) {
            return;
        }
        this.f55080c.l1(this, new Worker(runnableO1));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher s1(int i2) {
        LimitedDispatcherKt.a(i2);
        return i2 >= this.f55081d ? this : super.s1(i2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f55080c);
        sb.append(".limitedParallelism(");
        return android.support.v4.media.b.n(sb, this.f55081d, ')');
    }
}
