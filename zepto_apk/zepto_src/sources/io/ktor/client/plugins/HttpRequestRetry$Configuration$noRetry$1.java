package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class HttpRequestRetry$Configuration$noRetry$1 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequest, HttpResponse, Boolean> {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Intrinsics.checkNotNullParameter((HttpRequestRetry.ShouldRetryContext) obj, "$this$null");
        Intrinsics.checkNotNullParameter((HttpRequest) obj2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter((HttpResponse) obj3, "<anonymous parameter 1>");
        return Boolean.FALSE;
    }
}
