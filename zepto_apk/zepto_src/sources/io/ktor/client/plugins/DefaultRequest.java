package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class DefaultRequest {

    /* renamed from: b, reason: collision with root package name */
    public static final Plugin f49455b = new Plugin();

    /* renamed from: c, reason: collision with root package name */
    public static final AttributeKey f49456c = new AttributeKey("DefaultRequest");

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f49457a;

    @KtorDsl
    @Metadata
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final HeadersBuilder f49458a = new HeadersBuilder(true);

        /* renamed from: b, reason: collision with root package name */
        public final URLBuilder f49459b = new URLBuilder(0);

        /* renamed from: c, reason: collision with root package name */
        public final Attributes f49460c = AttributesJvmKt.a();

        @Override // io.ktor.http.HttpMessageBuilder
        public final HeadersBuilder getHeaders() {
            return this.f49458a;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Plugin implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            DefaultRequest plugin = (DefaultRequest) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50017g, new DefaultRequest$Plugin$install$1(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new DefaultRequest(block);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return DefaultRequest.f49456c;
        }
    }

    public DefaultRequest(Function1 function1) {
        this.f49457a = function1;
    }
}
