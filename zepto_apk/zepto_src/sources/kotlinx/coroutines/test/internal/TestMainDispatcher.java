package kotlinx.coroutines.test.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TestMainDispatcher extends MainCoroutineDispatcher implements Delay {

    /* renamed from: b, reason: collision with root package name */
    public final NonConcurrentlyModifiable f55332b;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public static final class NonConcurrentlyModifiable<T> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f55333a = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "reader$volatile");

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f55334b = AtomicIntegerFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, "readers$volatile");

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f55335c = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "writer$volatile");

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f55336d = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "exceptionWhenReading$volatile");

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f55337e = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "_value$volatile");
        private volatile /* synthetic */ Object _value$volatile;
        private volatile /* synthetic */ Object exceptionWhenReading$volatile;
        private volatile /* synthetic */ Object reader$volatile;
        private volatile /* synthetic */ int readers$volatile;
        private volatile /* synthetic */ Object writer$volatile;

        public NonConcurrentlyModifiable(CoroutineDispatcher coroutineDispatcher) {
            this._value$volatile = coroutineDispatcher;
        }

        public final Object a() {
            f55333a.set(this, new Throwable("reader location"));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55334b;
            atomicIntegerFieldUpdater.incrementAndGet(this);
            Throwable th = (Throwable) f55335c.get(this);
            if (th != null) {
                f55336d.set(this, new IllegalStateException("Dispatchers.Main is used concurrently with setting it", th));
            }
            Object obj = f55337e.get(this);
            atomicIntegerFieldUpdater.decrementAndGet(this);
            return obj;
        }
    }

    public TestMainDispatcher(MainCoroutineDispatcher mainCoroutineDispatcher) {
        this.f55332b = new NonConcurrentlyModifiable(mainCoroutineDispatcher);
    }

    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        Object objA = this.f55332b.a();
        Delay delay = objA instanceof Delay ? (Delay) objA : null;
        if (delay == null) {
            delay = DefaultExecutorKt.f54086a;
        }
        delay.A(j2, cancellableContinuationImpl);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher O1() {
        MainCoroutineDispatcher mainCoroutineDispatcherO1;
        Object objA = this.f55332b.a();
        MainCoroutineDispatcher mainCoroutineDispatcher = objA instanceof MainCoroutineDispatcher ? (MainCoroutineDispatcher) objA : null;
        return (mainCoroutineDispatcher == null || (mainCoroutineDispatcherO1 = mainCoroutineDispatcher.O1()) == null) ? this : mainCoroutineDispatcherO1;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        Object objA = this.f55332b.a();
        Delay delay = objA instanceof Delay ? (Delay) objA : null;
        if (delay == null) {
            delay = DefaultExecutorKt.f54086a;
        }
        return delay.b(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        ((CoroutineDispatcher) this.f55332b.a()).c1(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        ((CoroutineDispatcher) this.f55332b.a()).l1(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext coroutineContext) {
        return ((CoroutineDispatcher) this.f55332b.a()).o1(coroutineContext);
    }
}
