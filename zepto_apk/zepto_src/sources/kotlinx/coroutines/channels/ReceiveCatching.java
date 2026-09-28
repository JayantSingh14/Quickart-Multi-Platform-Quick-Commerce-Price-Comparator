package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;

@Metadata
/* loaded from: classes.dex */
final class ReceiveCatching<E> implements Waiter {

    /* renamed from: a, reason: collision with root package name */
    public final CancellableContinuationImpl f54427a;

    public ReceiveCatching(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f54427a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void a(Segment segment, int i2) {
        this.f54427a.a(segment, i2);
    }
}
