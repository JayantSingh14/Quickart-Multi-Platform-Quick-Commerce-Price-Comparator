package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class CancelFutureOnCancel implements CancelHandler {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f54056a;

    public CancelFutureOnCancel(ScheduledFuture scheduledFuture) {
        this.f54056a = scheduledFuture;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void b(Throwable th) {
        this.f54056a.cancel(false);
    }

    public final String toString() {
        return "CancelFutureOnCancel[" + this.f54056a + ']';
    }
}
