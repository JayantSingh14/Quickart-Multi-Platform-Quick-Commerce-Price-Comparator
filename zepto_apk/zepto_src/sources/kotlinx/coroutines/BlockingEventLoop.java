package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class BlockingEventLoop extends EventLoopImplBase {

    /* renamed from: i, reason: collision with root package name */
    public final Thread f54055i;

    public BlockingEventLoop(Thread thread) {
        this.f54055i = thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final Thread W1() {
        return this.f54055i;
    }
}
