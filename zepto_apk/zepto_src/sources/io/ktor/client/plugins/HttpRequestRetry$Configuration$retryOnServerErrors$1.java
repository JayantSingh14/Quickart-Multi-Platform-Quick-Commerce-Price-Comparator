package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class HttpRequestRetry$Configuration$retryOnServerErrors$1 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequest, HttpResponse, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpRequestRetry$Configuration$retryOnServerErrors$1 f49602c = new HttpRequestRetry$Configuration$retryOnServerErrors$1(3);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpRequestRetry.ShouldRetryContext retryIf = (HttpRequestRetry.ShouldRetryContext) obj;
        HttpResponse response = (HttpResponse) obj3;
        Intrinsics.checkNotNullParameter(retryIf, "$this$retryIf");
        Intrinsics.checkNotNullParameter((HttpRequest) obj2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(response, "response");
        int i2 = response.e().f50229a;
        boolean z = false;
        if (500 <= i2 && i2 < 600) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
