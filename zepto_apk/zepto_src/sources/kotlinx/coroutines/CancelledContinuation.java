package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class CancelledContinuation extends CompletedExceptionally {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54064c = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public CancelledContinuation(CancellableContinuationImpl cancellableContinuationImpl, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + cancellableContinuationImpl + " was cancelled normally");
        }
        super(z, th);
        this._resumed$volatile = 0;
    }
}
