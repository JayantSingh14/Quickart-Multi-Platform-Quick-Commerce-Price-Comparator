package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {

    @JvmField
    @Nullable
    public volatile Continuation<? super T> cont;

    @Override // java.util.function.BiFunction
    public final Unit apply(Object obj, Throwable th) {
        Throwable cause;
        Throwable th2 = th;
        Continuation<? super T> continuation = this.cont;
        if (continuation != null) {
            if (th2 == null) {
                Result.Companion companion = Result.f53538b;
                continuation.resumeWith(obj);
            } else {
                CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
                if (completionException != null && (cause = completionException.getCause()) != null) {
                    th2 = cause;
                }
                Result.Companion companion2 = Result.f53538b;
                continuation.resumeWith(ResultKt.a(th2));
            }
        }
        return Unit.f53572a;
    }
}
