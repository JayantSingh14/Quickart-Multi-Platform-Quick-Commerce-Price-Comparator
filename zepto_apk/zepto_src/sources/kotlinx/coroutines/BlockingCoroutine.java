package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {

    /* renamed from: d, reason: collision with root package name */
    public final Thread f54053d;

    /* renamed from: e, reason: collision with root package name */
    public final EventLoop f54054e;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f54053d = thread;
        this.f54054e = eventLoop;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void t(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f54053d;
        if (Intrinsics.b(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
