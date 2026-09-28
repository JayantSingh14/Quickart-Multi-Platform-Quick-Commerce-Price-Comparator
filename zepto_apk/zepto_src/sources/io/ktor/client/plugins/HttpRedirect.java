package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class HttpRedirect {

    /* renamed from: a, reason: collision with root package name */
    public static final Plugin f49555a = new Plugin();

    /* renamed from: b, reason: collision with root package name */
    public static final AttributeKey f49556b = new AttributeKey("HttpRedirect");

    /* renamed from: c, reason: collision with root package name */
    public static final EventDefinition f49557c = new EventDefinition();

    @KtorDsl
    @Metadata
    public static final class Config {
    }

    @Metadata
    @SourceDebugExtension
    public static final class Plugin implements HttpClientPlugin<Config, HttpRedirect> {
        /* JADX WARN: Removed duplicated region for block: B:20:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x015a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x015b -> B:34:0x0161). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object c(io.ktor.client.plugins.Sender r17, io.ktor.client.request.HttpRequestBuilder r18, io.ktor.client.call.HttpClientCall r19, io.ktor.client.HttpClient r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirect.Plugin.c(io.ktor.client.plugins.Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, io.ktor.client.HttpClient, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            HttpRedirect plugin = (HttpRedirect) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            ((HttpSend) HttpClientPluginKt.a(scope, HttpSend.f49625b)).a(new HttpRedirect$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(new Config());
            return new HttpRedirect();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpRedirect.f49556b;
        }
    }
}
