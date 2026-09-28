package kotlinx.coroutines.test;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.AbstractLongTimeSource;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import kotlinx.coroutines.test.TestCoroutineScheduler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TestCoroutineScheduler extends AbstractCoroutineContextElement implements CoroutineContext.Element {

    /* renamed from: f, reason: collision with root package name */
    public static final Key f55302f = new Key();

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f55303g = AtomicLongFieldUpdater.newUpdater(TestCoroutineScheduler.class, "count$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final ThreadSafeHeap f55304a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f55305b;

    /* renamed from: c, reason: collision with root package name */
    public long f55306c;
    private volatile /* synthetic */ long count$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final BufferedChannel f55307d;

    /* renamed from: e, reason: collision with root package name */
    public final BufferedChannel f55308e;

    @Metadata
    public static final class Key implements CoroutineContext.Key<TestCoroutineScheduler> {
    }

    public TestCoroutineScheduler() {
        super(f55302f);
        this.f55304a = new ThreadSafeHeap();
        this.f55305b = new Object();
        this.f55307d = ChannelKt.a(-1, null, 6);
        this.f55308e = ChannelKt.a(-1, null, 6);
        final DurationUnit durationUnit = DurationUnit.f54021d;
        new AbstractLongTimeSource(durationUnit) { // from class: kotlinx.coroutines.test.TestCoroutineScheduler$timeSource$1
            @Override // kotlin.time.AbstractLongTimeSource
            public final long a() {
                long j2;
                TestCoroutineScheduler testCoroutineScheduler = this.f55310c;
                synchronized (testCoroutineScheduler.f55305b) {
                    j2 = testCoroutineScheduler.f55306c;
                }
                return j2;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r15v9, types: [kotlinx.coroutines.test.c] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.test.b] */
    public final c c1(TestDispatcher testDispatcher, long j2, final Runnable runnable, CoroutineContext coroutineContext, final Function1 function1) {
        long j3;
        ?? r15;
        if (j2 < 0) {
            throw new IllegalArgumentException(("Attempted scheduling an event earlier in time (with the time delta " + j2 + ')').toString());
        }
        TestCoroutineSchedulerKt.a(this, coroutineContext);
        long andIncrement = f55303g.getAndIncrement(this);
        BackgroundWork backgroundWork = BackgroundWork.f55264a;
        boolean z = coroutineContext.get(backgroundWork) == null;
        synchronized (this.f55305b) {
            synchronized (this.f55305b) {
                j3 = this.f55306c;
            }
            long j4 = j3 + j2;
            if (j4 < 0) {
                j4 = Long.MAX_VALUE;
            }
            Intrinsics.d(runnable, "null cannot be cast to non-null type kotlin.Any");
            final TestDispatchEvent testDispatchEvent = new TestDispatchEvent(testDispatcher, andIncrement, j4, runnable, z, new Function0() { // from class: kotlinx.coroutines.test.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    TestCoroutineScheduler.Key key = TestCoroutineScheduler.f55302f;
                    Boolean bool = (Boolean) function1.invoke(runnable);
                    bool.getClass();
                    return bool;
                }
            });
            ThreadSafeHeap threadSafeHeap = this.f55304a;
            synchronized (threadSafeHeap) {
                threadSafeHeap.a(testDispatchEvent);
                Unit unit = Unit.f53572a;
            }
            BufferedChannel bufferedChannel = this.f55308e;
            Unit unit2 = Unit.f53572a;
            bufferedChannel.i(unit2);
            if (coroutineContext.get(backgroundWork) != backgroundWork) {
                this.f55307d.i(unit2);
            }
            r15 = new DisposableHandle() { // from class: kotlinx.coroutines.test.c
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    TestCoroutineScheduler testCoroutineScheduler = this.f55325a;
                    TestDispatchEvent testDispatchEvent2 = testDispatchEvent;
                    synchronized (testCoroutineScheduler.f55305b) {
                        ThreadSafeHeap threadSafeHeap2 = testCoroutineScheduler.f55304a;
                        synchronized (threadSafeHeap2) {
                            if (testDispatchEvent2.f55316f != null) {
                                threadSafeHeap2.b(testDispatchEvent2.f55317g);
                            }
                        }
                        Unit unit3 = Unit.f53572a;
                    }
                }
            };
        }
        return r15;
    }

    public final boolean l1(Function0 function0) {
        ThreadSafeHeapNode threadSafeHeapNodeB;
        long j2;
        synchronized (this.f55305b) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return false;
            }
            ThreadSafeHeap threadSafeHeap = this.f55304a;
            synchronized (threadSafeHeap) {
                threadSafeHeapNodeB = ThreadSafeHeap.f55113b.get(threadSafeHeap) > 0 ? threadSafeHeap.b(0) : null;
            }
            TestDispatchEvent testDispatchEvent = (TestDispatchEvent) threadSafeHeapNodeB;
            if (testDispatchEvent == null) {
                return false;
            }
            synchronized (this.f55305b) {
                j2 = this.f55306c;
            }
            long j3 = testDispatchEvent.f55313c;
            if (j2 > j3) {
                throw new IllegalStateException("The test scheduler entered an invalid state. Please report this at https://github.com/Kotlin/kotlinx.coroutines/issues.");
            }
            this.f55306c = j3;
            TestDispatcher testDispatcher = testDispatchEvent.f55311a;
            Runnable runnable = testDispatchEvent.f55314d;
            testDispatcher.getClass();
            if (runnable == null) {
                throw new IllegalStateException("Check failed.");
            }
            runnable.run();
            return true;
        }
    }
}
