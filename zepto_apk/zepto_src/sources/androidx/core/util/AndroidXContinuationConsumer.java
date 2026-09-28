package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Continuation<T> f2979a;

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        if (compareAndSet(false, true)) {
            Continuation<T> continuation = this.f2979a;
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
