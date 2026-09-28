package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class BuildersKt$wss$2 extends Lambda implements Function1<HttpRequestBuilder, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        HttpRequestBuilder webSocket = (HttpRequestBuilder) obj;
        Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
        webSocket.f50003a.e(URLProtocol.f50255e);
        URLBuilder uRLBuilder = webSocket.f50003a;
        uRLBuilder.f50243c = uRLBuilder.f50241a.f50258b;
        throw null;
    }
}
