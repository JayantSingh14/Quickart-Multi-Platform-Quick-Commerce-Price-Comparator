package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class HttpRequestRetry$Configuration$noRetry$2 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Intrinsics.checkNotNullParameter((HttpRequestRetry.ShouldRetryContext) obj, "$this$null");
        Intrinsics.checkNotNullParameter((HttpRequestBuilder) obj2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter((Throwable) obj3, "<anonymous parameter 1>");
        return Boolean.FALSE;
    }
}
