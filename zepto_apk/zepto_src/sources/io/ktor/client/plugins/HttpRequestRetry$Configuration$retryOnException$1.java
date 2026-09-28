package io.ktor.client.plugins;

import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes3.dex */
final class HttpRequestRetry$Configuration$retryOnException$1 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpRequestRetry.ShouldRetryContext retryOnExceptionIf = (HttpRequestRetry.ShouldRetryContext) obj;
        Throwable cause = (Throwable) obj3;
        Intrinsics.checkNotNullParameter(retryOnExceptionIf, "$this$retryOnExceptionIf");
        Intrinsics.checkNotNullParameter((HttpRequestBuilder) obj2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Logger logger = HttpRequestRetryKt.f49619a;
        Throwable thA = ExceptionUtilsJvmKt.a(cause);
        boolean z = false;
        if (!(thA instanceof HttpRequestTimeoutException) && !(thA instanceof ConnectTimeoutException) && !(thA instanceof SocketTimeoutException) && !(cause instanceof CancellationException)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
