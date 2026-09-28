package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1;
import io.ktor.util.LRUCache;
import io.ktor.util.StringValues;
import io.ktor.util.date.GMTDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class OkHttpEngine extends HttpClientEngineBase {

    /* renamed from: i, reason: collision with root package name */
    public static final Lazy f49372i = LazyKt.b(OkHttpEngine$Companion$okHttpClientPrototype$2.f49380c);

    /* renamed from: d, reason: collision with root package name */
    public final OkHttpConfig f49373d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f49374e;

    /* renamed from: f, reason: collision with root package name */
    public final CoroutineContext f49375f;

    /* renamed from: g, reason: collision with root package name */
    public final CoroutineContext f49376g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f49377h;

    @Metadata
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", l = {50}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f49378a;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return OkHttpEngine.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f49378a;
            OkHttpEngine okHttpEngine = OkHttpEngine.this;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    CoroutineContext.Element element = okHttpEngine.f49375f.get(Job.Key.f54121a);
                    Intrinsics.c(element);
                    this.f49378a = 1;
                    if (((Job) element).T0(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                while (it.hasNext()) {
                    OkHttpClient okHttpClient = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient.f56298b.a();
                    ((ThreadPoolExecutor) okHttpClient.f56297a.a()).shutdown();
                }
                return Unit.f53572a;
            } finally {
                it = okHttpEngine.f49377h.entrySet().iterator();
                while (it.hasNext()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient2.f56298b.a();
                    ((ThreadPoolExecutor) okHttpClient2.f56297a.a()).shutdown();
                }
            }
        }
    }

    @Metadata
    public static final class Companion {
    }

    public OkHttpEngine(OkHttpConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f49373d = config;
        HttpClientEngineCapability[] elements = {HttpTimeout.f49642d, WebSocketCapability.f49973a};
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.f49374e = ArraysKt.H(elements);
        OkHttpEngine$clientCache$1 supplier = new OkHttpEngine$clientCache$1(1, this, OkHttpEngine.class, "createOkHttpClient", "createOkHttpClient(Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;)Lokhttp3/OkHttpClient;", 0);
        OkHttpEngine$clientCache$2 close = OkHttpEngine$clientCache$2.f49381c;
        int i2 = config.f49370c;
        Intrinsics.checkNotNullParameter(supplier, "supplier");
        Intrinsics.checkNotNullParameter(close, "close");
        Map mapSynchronizedMap = Collections.synchronizedMap(new LRUCache(supplier, close, i2));
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(LRUCache…upplier, close, maxSize))");
        this.f49377h = mapSynchronizedMap;
        CoroutineContext.Element element = super.r().get(Job.Key.f54121a);
        Intrinsics.c(element);
        CoroutineContext coroutineContextC = CoroutineContext.Element.DefaultImpls.c((JobSupport) SupervisorKt.a((Job) element), new CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.f54075a));
        this.f49375f = coroutineContextC;
        this.f49376g = super.r().plus(coroutineContextC);
        BuildersKt.b(GlobalScope.f54113a, super.r(), CoroutineStart.f54080c, new AnonymousClass1(null));
    }

    public static HttpResponseData a(Response response, GMTDate gMTDate, Object obj, CoroutineContext coroutineContext) {
        HttpProtocolVersion httpProtocolVersion;
        HttpStatusCode httpStatusCode = new HttpStatusCode(response.f56353d, response.f56352c);
        Protocol protocol = response.f56351b;
        Intrinsics.checkNotNullParameter(protocol, "<this>");
        int iOrdinal = protocol.ordinal();
        if (iOrdinal == 0) {
            httpProtocolVersion = HttpProtocolVersion.f50213g;
        } else if (iOrdinal == 1) {
            httpProtocolVersion = HttpProtocolVersion.f50212f;
        } else if (iOrdinal == 2) {
            httpProtocolVersion = HttpProtocolVersion.f50214h;
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            httpProtocolVersion = HttpProtocolVersion.f50211e;
        } else {
            if (iOrdinal != 5) {
                throw new NoWhenBranchMatchedException();
            }
            httpProtocolVersion = HttpProtocolVersion.f50215i;
        }
        HttpProtocolVersion httpProtocolVersion2 = httpProtocolVersion;
        final Headers headers = response.f56355f;
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return new HttpResponseData(httpStatusCode, gMTDate, new io.ktor.http.Headers() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt$fromOkHttp$1
            @Override // io.ktor.util.StringValues
            public final List a(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                List listN = headers.n(name);
                if (listN.isEmpty()) {
                    return null;
                }
                return listN;
            }

            @Override // io.ktor.util.StringValues
            public final String b(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(name, "name");
                List listA = a(name);
                if (listA != null) {
                    return (String) CollectionsKt.firstOrNull(listA);
                }
                return null;
            }

            @Override // io.ktor.util.StringValues
            public final void c(Function2 body) {
                Intrinsics.checkNotNullParameter(body, "body");
                StringValues.DefaultImpls.a(this, body);
            }

            @Override // io.ktor.util.StringValues
            public final Set d() {
                return headers.k().entrySet();
            }

            @Override // io.ktor.util.StringValues
            public final boolean e() {
                return true;
            }
        }, httpProtocolVersion2, obj, coroutineContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q0(io.ktor.client.request.HttpRequestData r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.Q0(io.ktor.client.request.HttpRequestData, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public final Set Z0() {
        return this.f49374e;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(okhttp3.OkHttpClient r7, okhttp3.Request r8, kotlin.coroutines.CoroutineContext r9, io.ktor.client.request.HttpRequestData r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r11 instanceof io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1) r0
            int r1 = r0.f49393g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49393g = r1
            goto L18
        L13:
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1
            r0.<init>(r6, r11)
        L18:
            java.lang.Object r11 = r0.f49391e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49393g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            io.ktor.util.date.GMTDate r7 = r0.f49390d
            io.ktor.client.request.HttpRequestData r10 = r0.f49389c
            kotlin.coroutines.CoroutineContext r9 = r0.f49388b
            io.ktor.client.engine.okhttp.OkHttpEngine r8 = r0.f49387a
            kotlin.ResultKt.b(r11)
            goto L7b
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.b(r11)
            io.ktor.util.date.GMTDate r11 = io.ktor.util.date.DateJvmKt.b(r3)
            r0.f49387a = r6
            r0.f49388b = r9
            r0.f49389c = r10
            r0.f49390d = r11
            r0.f49393g = r4
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r2.<init>(r4, r5)
            r2.s()
            okhttp3.internal.connection.RealCall r7 = r7.a(r8)
            io.ktor.client.engine.okhttp.OkHttpCallback r8 = new io.ktor.client.engine.okhttp.OkHttpCallback
            r8.<init>(r10, r2)
            r7.l0(r8)
            io.ktor.client.engine.okhttp.OkUtilsKt$execute$2$1 r8 = new io.ktor.client.engine.okhttp.OkUtilsKt$execute$2$1
            r8.<init>()
            r2.u(r8)
            java.lang.Object r7 = r2.r()
            if (r7 != r1) goto L74
            java.lang.String r8 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r8)
        L74:
            if (r7 != r1) goto L77
            return r1
        L77:
            r8 = r11
            r11 = r7
            r7 = r8
            r8 = r6
        L7b:
            okhttp3.Response r11 = (okhttp3.Response) r11
            okhttp3.ResponseBody r0 = r11.f56356g
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.Key.f54121a
            kotlin.coroutines.CoroutineContext$Element r1 = r9.get(r1)
            kotlin.jvm.internal.Intrinsics.c(r1)
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2 r2 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2
            r2.<init>()
            r1.j0(r2)
            if (r0 == 0) goto Lac
            okio.BufferedSource r0 = r0.source()
            if (r0 == 0) goto Lac
            kotlinx.coroutines.GlobalScope r1 = kotlinx.coroutines.GlobalScope.f54113a
            io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1 r2 = new io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1
            r2.<init>(r0, r9, r10, r3)
            r10 = 0
            io.ktor.utils.io.WriterJob r10 = io.ktor.utils.io.CoroutinesKt.a(r1, r9, r10, r2)
            io.ktor.utils.io.ByteChannel r10 = r10.t0()
            if (r10 != 0) goto Lb5
        Lac:
            io.ktor.utils.io.ByteReadChannel$Companion r10 = io.ktor.utils.io.ByteReadChannel.f51074a
            r10.getClass()
            io.ktor.utils.io.ByteReadChannel r10 = io.ktor.utils.io.ByteReadChannel.Companion.a()
        Lb5:
            r8.getClass()
            io.ktor.client.request.HttpResponseData r7 = a(r11, r7, r10, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.c(okhttp3.OkHttpClient, okhttp3.Request, kotlin.coroutines.CoroutineContext, io.ktor.client.request.HttpRequestData, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        CoroutineContext.Element element = this.f49375f.get(Job.Key.f54121a);
        Intrinsics.d(element, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((CompletableJob) element).complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(okhttp3.OkHttpClient r6, okhttp3.Request r7, kotlin.coroutines.CoroutineContext r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1) r0
            int r1 = r0.f49401g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49401g = r1
            goto L18
        L13:
            io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f49399e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49401g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r6 = r0.f49398d
            io.ktor.util.date.GMTDate r7 = r0.f49397c
            kotlin.coroutines.CoroutineContext r8 = r0.f49396b
            io.ktor.client.engine.okhttp.OkHttpEngine r0 = r0.f49395a
            kotlin.ResultKt.b(r9)
            goto L65
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.b(r9)
            r9 = 0
            io.ktor.util.date.GMTDate r9 = io.ktor.util.date.DateJvmKt.b(r9)
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r2 = new io.ktor.client.engine.okhttp.OkHttpWebsocketSession
            io.ktor.client.engine.okhttp.OkHttpConfig r4 = r5.f49373d
            r4.getClass()
            r2.<init>(r6, r6, r7, r8)
            r2.i()
            kotlinx.coroutines.CompletableDeferred r6 = r2.h()
            r0.f49395a = r5
            r0.f49396b = r8
            r0.f49397c = r9
            r0.f49398d = r2
            r0.f49401g = r3
            java.lang.Object r6 = r6.V(r0)
            if (r6 != r1) goto L61
            return r1
        L61:
            r0 = r5
            r7 = r9
            r9 = r6
            r6 = r2
        L65:
            okhttp3.Response r9 = (okhttp3.Response) r9
            r0.getClass()
            io.ktor.client.request.HttpResponseData r6 = a(r9, r7, r6, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.e(okhttp3.OkHttpClient, okhttp3.Request, kotlin.coroutines.CoroutineContext, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49376g;
    }
}
