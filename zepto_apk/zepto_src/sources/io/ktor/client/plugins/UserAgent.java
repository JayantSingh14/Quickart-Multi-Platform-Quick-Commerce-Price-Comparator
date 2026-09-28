package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class UserAgent {

    /* renamed from: b, reason: collision with root package name */
    public static final AttributeKey f49664b = new AttributeKey("UserAgent");

    /* renamed from: a, reason: collision with root package name */
    public final String f49665a;

    @KtorDsl
    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public String f49666a;

        public Config() {
            this(0);
        }

        public Config(int i2) {
            Intrinsics.checkNotNullParameter("Ktor http-client", "agent");
            this.f49666a = "Ktor http-client";
        }
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Config, UserAgent> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            UserAgent plugin = (UserAgent) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50018h, new UserAgent$Plugin$install$1(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config(0);
            block.invoke(config);
            return new UserAgent(config.f49666a);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return UserAgent.f49664b;
        }
    }

    public UserAgent(String str) {
        this.f49665a = str;
    }
}
