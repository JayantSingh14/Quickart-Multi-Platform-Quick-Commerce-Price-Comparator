package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ResponseObserver {

    /* renamed from: b, reason: collision with root package name */
    public static final AttributeKey f49951b = new AttributeKey("BodyInterceptor");

    /* renamed from: a, reason: collision with root package name */
    public final Function2 f49952a;

    @KtorDsl
    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public Function2 f49953a = new ResponseObserver$Config$responseHandler$1(2, null);
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Config, ResponseObserver> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            ResponseObserver plugin = (ResponseObserver) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49265h.g(HttpReceivePipeline.f50060i, new ResponseObserver$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new ResponseObserver(config.f49953a);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return ResponseObserver.f49951b;
        }
    }

    public ResponseObserver(Function2 responseHandler) {
        Intrinsics.checkNotNullParameter(responseHandler, "responseHandler");
        this.f49952a = responseHandler;
    }
}
