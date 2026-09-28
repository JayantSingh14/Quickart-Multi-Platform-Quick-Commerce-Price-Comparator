package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: classes3.dex */
final class StandardTestDispatcherImpl extends TestDispatcher {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f55267d = 0;

    /* renamed from: c, reason: collision with root package name */
    public final TestCoroutineScheduler f55268c = new TestCoroutineScheduler();

    @Override // kotlinx.coroutines.test.TestDispatcher
    public final TestCoroutineScheduler O1() {
        return this.f55268c;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        this.f55268c.c1(this, 0L, runnable, coroutineContext, new a(0));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        StringBuilder sbX = android.support.v4.media.b.x("StandardTestDispatcher", "[scheduler=");
        sbX.append(this.f55268c);
        sbX.append(']');
        return sbX.toString();
    }
}
