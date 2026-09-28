package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class CancellableContinuationRunnable implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final CancellableContinuationImpl f55265a;

    /* renamed from: b, reason: collision with root package name */
    public final TestDispatcher f55266b;

    public CancellableContinuationRunnable(CancellableContinuationImpl cancellableContinuationImpl, TestDispatcher testDispatcher) {
        this.f55265a = cancellableContinuationImpl;
        this.f55266b = testDispatcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f55265a.B(this.f55266b, Unit.f53572a);
    }
}
