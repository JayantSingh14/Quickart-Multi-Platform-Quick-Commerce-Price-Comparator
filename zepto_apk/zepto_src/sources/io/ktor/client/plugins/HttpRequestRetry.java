package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HttpRequestRetry {

    /* renamed from: g, reason: collision with root package name */
    public static final AttributeKey f49584g = new AttributeKey("RetryFeature");

    /* renamed from: h, reason: collision with root package name */
    public static final EventDefinition f49585h = new EventDefinition();

    /* renamed from: a, reason: collision with root package name */
    public final Function3 f49586a;

    /* renamed from: b, reason: collision with root package name */
    public final Function3 f49587b;

    /* renamed from: c, reason: collision with root package name */
    public final Function2 f49588c;

    /* renamed from: d, reason: collision with root package name */
    public final Function2 f49589d;

    /* renamed from: e, reason: collision with root package name */
    public final int f49590e;

    /* renamed from: f, reason: collision with root package name */
    public final Function2 f49591f;

    @KtorDsl
    @Metadata
    public static final class Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final Function3 f49592a;

        /* renamed from: b, reason: collision with root package name */
        public final Function3 f49593b;

        /* renamed from: c, reason: collision with root package name */
        public final Function2 f49594c;

        /* renamed from: d, reason: collision with root package name */
        public final Function2 f49595d = HttpRequestRetry$Configuration$modifyRequest$1.f49601c;

        /* renamed from: e, reason: collision with root package name */
        public final Function2 f49596e = new HttpRequestRetry$Configuration$delay$1(2, null);

        /* renamed from: f, reason: collision with root package name */
        public final int f49597f;

        public Configuration() {
            HttpRequestRetry$Configuration$retryOnServerErrors$1 block = HttpRequestRetry$Configuration$retryOnServerErrors$1.f49602c;
            Intrinsics.checkNotNullParameter(block, "block");
            this.f49597f = 3;
            Intrinsics.checkNotNullParameter(block, "<set-?>");
            this.f49592a = block;
            HttpRequestRetry$Configuration$retryOnException$1 block2 = new HttpRequestRetry$Configuration$retryOnException$1(3);
            Intrinsics.checkNotNullParameter(block2, "block");
            this.f49597f = 3;
            Intrinsics.checkNotNullParameter(block2, "<set-?>");
            this.f49593b = block2;
            final HttpRequestRetry$Configuration$exponentialDelay$1 block3 = new HttpRequestRetry$Configuration$exponentialDelay$1(2);
            Intrinsics.checkNotNullParameter(block3, "block");
            Function2<DelayContext, Integer, Long> function2 = new Function2<DelayContext, Integer, Long>() { // from class: io.ktor.client.plugins.HttpRequestRetry$Configuration$delayMillis$1
                {
                    super(2);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
                @Override // kotlin.jvm.functions.Function2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invoke(java.lang.Object r6, java.lang.Object r7) {
                    /*
                        r5 = this;
                        io.ktor.client.plugins.HttpRequestRetry$DelayContext r6 = (io.ktor.client.plugins.HttpRequestRetry.DelayContext) r6
                        java.lang.Number r7 = (java.lang.Number) r7
                        int r7 = r7.intValue()
                        java.lang.String r0 = "$this$null"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        kotlin.jvm.functions.Function2 r0 = r1
                        io.ktor.client.statement.HttpResponse r1 = r6.f49603a
                        if (r1 == 0) goto L36
                        io.ktor.http.Headers r1 = r1.getHeaders()
                        if (r1 == 0) goto L36
                        java.util.List r2 = io.ktor.http.HttpHeaders.f50204a
                        java.lang.String r2 = "Retry-After"
                        java.lang.String r1 = r1.b(r2)
                        if (r1 == 0) goto L36
                        java.lang.Long r1 = kotlin.text.StringsKt.a0(r1)
                        if (r1 == 0) goto L36
                        long r1 = r1.longValue()
                        r3 = 1000(0x3e8, float:1.401E-42)
                        long r3 = (long) r3
                        long r1 = r1 * r3
                        java.lang.Long r1 = java.lang.Long.valueOf(r1)
                        goto L37
                    L36:
                        r1 = 0
                    L37:
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                        io.ktor.client.plugins.HttpRequestRetry$Configuration$exponentialDelay$1 r0 = (io.ktor.client.plugins.HttpRequestRetry$Configuration$exponentialDelay$1) r0
                        java.lang.Object r6 = r0.invoke(r6, r7)
                        java.lang.Number r6 = (java.lang.Number) r6
                        long r6 = r6.longValue()
                        if (r1 == 0) goto L4e
                        long r0 = r1.longValue()
                        goto L50
                    L4e:
                        r0 = 0
                    L50:
                        long r6 = java.lang.Math.max(r6, r0)
                        java.lang.Long r6 = java.lang.Long.valueOf(r6)
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$Configuration$delayMillis$1.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            };
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.f49594c = function2;
        }
    }

    @Metadata
    public static final class DelayContext {

        /* renamed from: a, reason: collision with root package name */
        public final HttpResponse f49603a;

        public DelayContext(HttpRequestBuilder request, HttpResponse httpResponse) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f49603a = httpResponse;
        }
    }

    @Metadata
    public static final class ModifyRequestContext {
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Configuration, HttpRequestRetry> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient client) {
            HttpRequestRetry plugin = (HttpRequestRetry) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(client, "scope");
            plugin.getClass();
            Intrinsics.checkNotNullParameter(client, "client");
            ((HttpSend) HttpClientPluginKt.a(client, HttpSend.f49625b)).a(new HttpRequestRetry$intercept$1(plugin, client, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Configuration configuration = new Configuration();
            block.invoke(configuration);
            return new HttpRequestRetry(configuration);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpRequestRetry.f49584g;
        }
    }

    @Metadata
    public static final class RetryEventData {

        /* renamed from: a, reason: collision with root package name */
        public final HttpRequestBuilder f49604a;

        /* renamed from: b, reason: collision with root package name */
        public final HttpResponse f49605b;

        public RetryEventData(HttpRequestBuilder request, int i2, HttpResponse httpResponse, Throwable th) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f49604a = request;
            this.f49605b = httpResponse;
        }
    }

    @Metadata
    public static final class ShouldRetryContext {
    }

    public HttpRequestRetry(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Function3 function3 = configuration.f49592a;
        if (function3 == null) {
            Intrinsics.h("shouldRetry");
            throw null;
        }
        this.f49586a = function3;
        Function3 function32 = configuration.f49593b;
        if (function32 == null) {
            Intrinsics.h("shouldRetryOnException");
            throw null;
        }
        this.f49587b = function32;
        Function2 function2 = configuration.f49594c;
        if (function2 == null) {
            Intrinsics.h("delayMillis");
            throw null;
        }
        this.f49588c = function2;
        this.f49589d = configuration.f49596e;
        this.f49590e = configuration.f49597f;
        this.f49591f = HttpRequestRetry$Configuration$modifyRequest$1.f49601c;
    }
}
