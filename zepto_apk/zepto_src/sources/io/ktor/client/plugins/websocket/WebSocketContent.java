package io.ktor.client.plugins.websocket;

import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.util.Base64Kt;
import io.ktor.util.CryptoKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WebSocketContent extends ClientUpgradeContent {

    /* renamed from: b, reason: collision with root package name */
    public final HeadersImpl f49974b;

    public WebSocketContent() {
        String strA = Base64Kt.a(CryptoKt.b());
        Intrinsics.checkNotNullExpressionValue(strA, "StringBuilder().apply(builderAction).toString()");
        HeadersBuilder headersBuilder = new HeadersBuilder(true);
        List list = HttpHeaders.f50204a;
        headersBuilder.c("Upgrade", "websocket");
        headersBuilder.c("Connection", "Upgrade");
        headersBuilder.c("Sec-WebSocket-Key", strA);
        headersBuilder.c("Sec-WebSocket-Version", "13");
        this.f49974b = headersBuilder.l();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Headers c() {
        return this.f49974b;
    }

    public final String toString() {
        return "WebSocketContent";
    }
}
