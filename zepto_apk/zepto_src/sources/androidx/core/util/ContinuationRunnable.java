package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Continuation<Unit> f2981a;

    @Override // java.lang.Runnable
    public final void run() {
        if (compareAndSet(false, true)) {
            Continuation<Unit> continuation = this.f2981a;
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(Unit.f53572a);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
