package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpSend {

    /* renamed from: b, reason: collision with root package name */
    public static final Plugin f49625b = new Plugin();

    /* renamed from: c, reason: collision with root package name */
    public static final AttributeKey f49626c = new AttributeKey("HttpSend");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f49627a = new ArrayList();

    @KtorDsl
    @Metadata
    public static final class Config {
    }

    @Metadata
    public static final class DefaultSender implements Sender {

        /* renamed from: a, reason: collision with root package name */
        public final HttpClient f49628a;

        /* renamed from: b, reason: collision with root package name */
        public int f49629b;

        /* renamed from: c, reason: collision with root package name */
        public HttpClientCall f49630c;

        public DefaultSender(HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            this.f49628a = client;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // io.ktor.client.plugins.Sender
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(io.ktor.client.request.HttpRequestBuilder r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                if (r0 == 0) goto L13
                r0 = r7
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = (io.ktor.client.plugins.HttpSend$DefaultSender$execute$1) r0
                int r1 = r0.f49634d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49634d = r1
                goto L18
            L13:
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = new io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f49632b
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f49634d
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L34
                if (r2 != r4) goto L2c
                java.lang.Object r6 = r0.f49631a
                io.ktor.client.plugins.HttpSend$DefaultSender r6 = (io.ktor.client.plugins.HttpSend.DefaultSender) r6
                kotlin.ResultKt.b(r7)
                goto L59
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                kotlin.ResultKt.b(r7)
                io.ktor.client.call.HttpClientCall r7 = r5.f49630c
                if (r7 == 0) goto L3e
                kotlinx.coroutines.CoroutineScopeKt.b(r7, r3)
            L3e:
                int r7 = r5.f49629b
                r2 = 20
                if (r7 >= r2) goto L7d
                int r7 = r7 + r4
                r5.f49629b = r7
                io.ktor.client.HttpClient r7 = r5.f49628a
                io.ktor.client.request.HttpSendPipeline r7 = r7.f49264g
                java.lang.Object r2 = r6.f50006d
                r0.f49631a = r5
                r0.f49634d = r4
                java.lang.Object r7 = r7.a(r6, r2, r0)
                if (r7 != r1) goto L58
                return r1
            L58:
                r6 = r5
            L59:
                boolean r0 = r7 instanceof io.ktor.client.call.HttpClientCall
                if (r0 == 0) goto L60
                r3 = r7
                io.ktor.client.call.HttpClientCall r3 = (io.ktor.client.call.HttpClientCall) r3
            L60:
                if (r3 == 0) goto L65
                r6.f49630c = r3
                return r3
            L65:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
                r0.<init>(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            L7d:
                io.ktor.client.plugins.SendCountExceedException r6 = new io.ktor.client.plugins.SendCountExceedException
                java.lang.String r7 = "Max send count 20 exceeded. Consider increasing the property maxSendCount if more is required."
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend.DefaultSender.a(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }
    }

    @Metadata
    public static final class InterceptedSender implements Sender {

        /* renamed from: a, reason: collision with root package name */
        public final Function3 f49635a;

        /* renamed from: b, reason: collision with root package name */
        public final Sender f49636b;

        public InterceptedSender(Function3 interceptor, Sender nextSender) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Intrinsics.checkNotNullParameter(nextSender, "nextSender");
            this.f49635a = interceptor;
            this.f49636b = nextSender;
        }

        @Override // io.ktor.client.plugins.Sender
        public final Object a(HttpRequestBuilder httpRequestBuilder, ContinuationImpl continuationImpl) {
            return this.f49635a.invoke(this.f49636b, httpRequestBuilder, continuationImpl);
        }
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Config, HttpSend> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            HttpSend plugin = (HttpSend) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50021k, new HttpSend$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(new Config());
            return new HttpSend();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpSend.f49626c;
        }
    }

    public final void a(Function3 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.f49627a.add(block);
    }
}
