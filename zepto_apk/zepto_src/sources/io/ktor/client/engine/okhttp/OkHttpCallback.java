package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancelledContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata
/* loaded from: classes.dex */
final class OkHttpCallback implements Callback {

    /* renamed from: a, reason: collision with root package name */
    public final HttpRequestData f49366a;

    /* renamed from: b, reason: collision with root package name */
    public final CancellableContinuationImpl f49367b;

    public OkHttpCallback(HttpRequestData requestData, CancellableContinuationImpl continuation) {
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.f49366a = requestData;
        this.f49367b = continuation;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException e2) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e2, "e");
        CancellableContinuationImpl cancellableContinuationImpl = this.f49367b;
        cancellableContinuationImpl.getClass();
        if (CancellableContinuationImpl.f54059g.get(cancellableContinuationImpl) instanceof CancelledContinuation) {
            return;
        }
        Result.Companion companion = Result.f53538b;
        if (e2 instanceof StreamAdapterIOException) {
            Throwable cause = e2.getCause();
            if (cause != null) {
                e2 = cause;
            }
        } else if (e2 instanceof SocketTimeoutException) {
            String message = e2.getMessage();
            HttpRequestData httpRequestData = this.f49366a;
            e2 = (message == null || !StringsKt.n(message, "connect", true)) ? HttpTimeoutKt.b(httpRequestData, e2) : HttpTimeoutKt.a(httpRequestData, e2);
        }
        cancellableContinuationImpl.resumeWith(ResultKt.a(e2));
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (call.s()) {
            return;
        }
        Result.Companion companion = Result.f53538b;
        this.f49367b.resumeWith(response);
    }
}
