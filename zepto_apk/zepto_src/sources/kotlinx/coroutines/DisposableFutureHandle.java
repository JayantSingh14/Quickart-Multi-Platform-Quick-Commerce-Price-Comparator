package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class DisposableFutureHandle implements DisposableHandle {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f54093a;

    public DisposableFutureHandle(ScheduledFuture scheduledFuture) {
        this.f54093a = scheduledFuture;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        this.f54093a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f54093a + ']';
    }
}
