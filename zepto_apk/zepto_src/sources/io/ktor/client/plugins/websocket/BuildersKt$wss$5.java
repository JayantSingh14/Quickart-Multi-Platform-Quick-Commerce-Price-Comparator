package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLParserKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class BuildersKt$wss$5 extends Lambda implements Function1<HttpRequestBuilder, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        HttpRequestBuilder wss = (HttpRequestBuilder) obj;
        Intrinsics.checkNotNullParameter(wss, "$this$wss");
        URLParserKt.b(wss.f50003a, null);
        throw null;
    }
}
