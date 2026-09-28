package kotlinx.coroutines.test;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.channels.BufferedChannel;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public final class TestCoroutineDispatcher extends TestDispatcher implements Delay {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f55297e = 0;

    /* renamed from: c, reason: collision with root package name */
    public final TestCoroutineScheduler f55298c = new TestCoroutineScheduler();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f55299d = true;

    @Override // kotlinx.coroutines.test.TestDispatcher
    public final TestCoroutineScheduler O1() {
        return this.f55298c;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        TestCoroutineScheduler testCoroutineScheduler = this.f55298c;
        TestCoroutineSchedulerKt.a(testCoroutineScheduler, coroutineContext);
        if (!this.f55299d) {
            this.f55298c.c1(this, 0L, runnable, coroutineContext, new a(1));
            return;
        }
        BufferedChannel bufferedChannel = testCoroutineScheduler.f55308e;
        Unit unit = Unit.f53572a;
        bufferedChannel.i(unit);
        BackgroundWork backgroundWork = BackgroundWork.f55264a;
        if (coroutineContext.get(backgroundWork) != backgroundWork) {
            testCoroutineScheduler.f55307d.i(unit);
        }
        runnable.run();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        TestCoroutineSchedulerKt.a(this.f55298c, coroutineContext);
        this.f55298c.c1(this, 0L, runnable, coroutineContext, new a(1));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "TestCoroutineDispatcher[scheduler=" + this.f55298c + ']';
    }
}
