package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpRequestLifecycle {

    /* renamed from: a, reason: collision with root package name */
    public static final Plugin f49576a = new Plugin();

    /* renamed from: b, reason: collision with root package name */
    public static final AttributeKey f49577b = new AttributeKey("RequestLifecycle");

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Unit, HttpRequestLifecycle> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            HttpRequestLifecycle plugin = (HttpRequestLifecycle) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50017g, new HttpRequestLifecycle$Plugin$install$1(scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new HttpRequestLifecycle();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpRequestLifecycle.f49577b;
        }
    }
}
