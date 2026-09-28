package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Continuation<T> f2980a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (compareAndSet(false, true)) {
            Continuation<T> continuation = this.f2980a;
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
