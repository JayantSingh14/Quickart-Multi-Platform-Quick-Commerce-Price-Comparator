package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Continuation<R> f2877a;

    public ContinuationOutcomeReceiver(CancellableContinuationImpl cancellableContinuationImpl) {
        super(false);
        this.f2877a = cancellableContinuationImpl;
    }

    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            Continuation<R> continuation = this.f2877a;
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(ResultKt.a(th));
        }
    }

    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            Continuation<R> continuation = this.f2877a;
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
