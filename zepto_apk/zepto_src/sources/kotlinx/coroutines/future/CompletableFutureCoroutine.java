package kotlinx.coroutines.future;

import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.AbstractCoroutine;

@Metadata
/* loaded from: classes3.dex */
final class CompletableFutureCoroutine<T> extends AbstractCoroutine<T> implements BiFunction<T, Throwable, Unit> {
    @Override // java.util.function.BiFunction
    public final Unit apply(Object obj, Throwable th) {
        e(null);
        return Unit.f53572a;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void w0(boolean z, Throwable th) {
        throw null;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0(Object obj) {
        throw null;
    }
}
