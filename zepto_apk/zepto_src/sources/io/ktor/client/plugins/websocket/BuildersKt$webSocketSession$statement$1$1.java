package io.ktor.client.plugins.websocket;

import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class BuildersKt$webSocketSession$statement$1$1 extends Lambda implements Function2<URLBuilder, URLBuilder, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        URLBuilder url = (URLBuilder) obj;
        URLBuilder it = (URLBuilder) obj2;
        Intrinsics.checkNotNullParameter(url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        url.e(URLProtocol.f50254d);
        url.f50243c = url.f50241a.f50258b;
        return Unit.f53572a;
    }
}
