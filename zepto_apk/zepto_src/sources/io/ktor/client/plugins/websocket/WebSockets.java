package io.ktor.client.plugins.websocket;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.websocket.WebSocketExtensionsConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebSockets {

    /* renamed from: d, reason: collision with root package name */
    public static final Plugin f49976d = new Plugin();

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49977e = new AttributeKey("Websocket");

    /* renamed from: a, reason: collision with root package name */
    public final long f49978a;

    /* renamed from: b, reason: collision with root package name */
    public final long f49979b;

    /* renamed from: c, reason: collision with root package name */
    public final WebSocketExtensionsConfig f49980c;

    @KtorDsl
    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public final WebSocketExtensionsConfig f49981a = new WebSocketExtensionsConfig();

        /* renamed from: b, reason: collision with root package name */
        public final long f49982b = -1;

        /* renamed from: c, reason: collision with root package name */
        public final long f49983c = TTL.MAX_VALUE;
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Config, WebSockets> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            WebSockets plugin = (WebSockets) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            boolean zContains = scope.f49258a.Z0().contains(WebSocketExtensionsCapability.f49975a);
            scope.f49262e.g(HttpRequestPipeline.f50020j, new WebSockets$Plugin$install$1(plugin, null, zContains));
            scope.f49263f.g(HttpResponsePipeline.f50071i, new WebSockets$Plugin$install$2(plugin, null, zContains));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new WebSockets(config.f49982b, config.f49983c, config.f49981a);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return WebSockets.f49977e;
        }
    }

    public WebSockets(long j2, long j3, WebSocketExtensionsConfig extensionsConfig) {
        Intrinsics.checkNotNullParameter(extensionsConfig, "extensionsConfig");
        this.f49978a = j2;
        this.f49979b = j3;
        this.f49980c = extensionsConfig;
    }

    public WebSockets() {
        this(-1L, TTL.MAX_VALUE, new WebSocketExtensionsConfig());
    }
}
