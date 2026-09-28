package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.EventLoopImplBase;

@Metadata
/* loaded from: classes.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    public abstract Thread W1();

    public void X1(long j2, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.f54084i.c2(j2, delayedTask);
    }
}
