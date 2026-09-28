package coil3.network.okhttp.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
final class ContinuationCallback implements Callback, Function1<Throwable, Unit> {

    @NotNull
    private final Call call;

    @NotNull
    private final CancellableContinuation<Response> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationCallback(@NotNull Call call, @NotNull CancellableContinuation<? super Response> cancellableContinuation) {
        this.call = call;
        this.continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f53572a;
    }

    @Override // okhttp3.Callback
    public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
        if (call.s()) {
            return;
        }
        CancellableContinuation<Response> cancellableContinuation = this.continuation;
        Result.Companion companion = Result.f53538b;
        cancellableContinuation.resumeWith(ResultKt.a(iOException));
    }

    @Override // okhttp3.Callback
    public void onResponse(@NotNull Call call, @NotNull Response response) {
        CancellableContinuation<Response> cancellableContinuation = this.continuation;
        Result.Companion companion = Result.f53538b;
        cancellableContinuation.resumeWith(response);
    }

    public void invoke(@Nullable Throwable th) {
        try {
            this.call.cancel();
        } catch (Throwable unused) {
        }
    }
}
