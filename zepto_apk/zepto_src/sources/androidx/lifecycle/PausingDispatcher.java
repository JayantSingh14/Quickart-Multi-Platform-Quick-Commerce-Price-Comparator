package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes3.dex */
public final class PausingDispatcher extends CoroutineDispatcher {

    /* renamed from: b, reason: collision with root package name */
    public final DispatchQueue f4855b = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext context, Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "block");
        DispatchQueue dispatchQueue = this.f4855b;
        dispatchQueue.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        MainCoroutineDispatcher mainCoroutineDispatcherO1 = MainDispatcherLoader.f55099a.O1();
        if (mainCoroutineDispatcherO1.o1(context) || !dispatchQueue.f4791a) {
            mainCoroutineDispatcherO1.c1(context, new androidx.constraintlayout.motion.widget.a(2, dispatchQueue, runnable));
        } else {
            if (!dispatchQueue.f4793c.offer(runnable)) {
                throw new IllegalStateException("cannot enqueue any more runnables");
            }
            dispatchQueue.a();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        if (MainDispatcherLoader.f55099a.O1().o1(context)) {
            return true;
        }
        this.f4855b.getClass();
        return !(!r2.f4791a);
    }
}
