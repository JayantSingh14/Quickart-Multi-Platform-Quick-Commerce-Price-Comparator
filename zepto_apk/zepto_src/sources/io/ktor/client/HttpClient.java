package io.ktor.client;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.plugins.BodyProgress;
import io.ktor.client.plugins.DefaultResponseValidationKt;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpPlainText;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.plugins.HttpRequestLifecycle;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.client.utils.HttpResponseReceiveFail;
import io.ktor.events.Events;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpClient implements CoroutineScope, Closeable, AutoCloseable {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f49257l = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");

    /* renamed from: a, reason: collision with root package name */
    public final HttpClientEngine f49258a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f49259b;

    /* renamed from: c, reason: collision with root package name */
    public final JobImpl f49260c;

    @NotNull
    private volatile /* synthetic */ int closed;

    /* renamed from: d, reason: collision with root package name */
    public final CoroutineContext f49261d;

    /* renamed from: e, reason: collision with root package name */
    public final HttpRequestPipeline f49262e;

    /* renamed from: f, reason: collision with root package name */
    public final HttpResponsePipeline f49263f;

    /* renamed from: g, reason: collision with root package name */
    public final HttpSendPipeline f49264g;

    /* renamed from: h, reason: collision with root package name */
    public final HttpReceivePipeline f49265h;

    /* renamed from: i, reason: collision with root package name */
    public final Attributes f49266i;

    /* renamed from: j, reason: collision with root package name */
    public final Events f49267j;

    /* renamed from: k, reason: collision with root package name */
    public final HttpClientConfig f49268k;

    @Metadata
    @DebugMetadata(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", l = {144, 146}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: io.ktor.client.HttpClient$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f49270a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ PipelineContext f49271b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f49272c;

        public AnonymousClass2(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass2 anonymousClass2 = HttpClient.this.new AnonymousClass2((Continuation) obj3);
            anonymousClass2.f49271b = (PipelineContext) obj;
            anonymousClass2.f49272c = obj2;
            return anonymousClass2.invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
        
            if (r3.f(r1, r8) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r8.f49270a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.ResultKt.b(r9)
                goto L6a
            L10:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L18:
                java.lang.Object r1 = r8.f49272c
                io.ktor.util.pipeline.PipelineContext r3 = r8.f49271b
                kotlin.ResultKt.b(r9)
                goto L48
            L20:
                kotlin.ResultKt.b(r9)
                io.ktor.util.pipeline.PipelineContext r9 = r8.f49271b
                java.lang.Object r1 = r8.f49272c
                boolean r4 = r1 instanceof io.ktor.client.call.HttpClientCall
                if (r4 == 0) goto L6d
                io.ktor.client.HttpClient r4 = io.ktor.client.HttpClient.this
                io.ktor.client.statement.HttpReceivePipeline r4 = r4.f49265h
                kotlin.Unit r5 = kotlin.Unit.f53572a
                r6 = r1
                io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6
                io.ktor.client.statement.HttpResponse r6 = r6.e()
                r8.f49271b = r9
                r8.f49272c = r1
                r8.f49270a = r3
                java.lang.Object r3 = r4.a(r5, r6, r8)
                if (r3 != r0) goto L45
                goto L69
            L45:
                r7 = r3
                r3 = r9
                r9 = r7
            L48:
                io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
                r4 = r1
                io.ktor.client.call.HttpClientCall r4 = (io.ktor.client.call.HttpClientCall) r4
                r4.getClass()
                java.lang.String r5 = "response"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r5)
                java.lang.String r5 = "<set-?>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r5)
                r4.f49304c = r9
                r9 = 0
                r8.f49271b = r9
                r8.f49272c = r9
                r8.f49270a = r2
                java.lang.Object r9 = r3.f(r1, r8)
                if (r9 != r0) goto L6a
            L69:
                return r0
            L6a:
                kotlin.Unit r9 = kotlin.Unit.f53572a
                return r9
            L6d:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                java.lang.String r0 = "Error: HttpClientCall expected, but found "
                r9.<init>(r0)
                r9.append(r1)
                r0 = 40
                r9.append(r0)
                java.lang.Class r0 = r1.getClass()
                kotlin.jvm.internal.ClassReference r0 = kotlin.jvm.internal.Reflection.a(r0)
                r9.append(r0)
                java.lang.String r0 = ")."
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r9 = r9.toString()
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.HttpClient.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata
    @DebugMetadata(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", l = {177}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.HttpClient$4, reason: invalid class name */
    final class AnonymousClass4 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f49275a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ PipelineContext f49276b;

        public AnonymousClass4(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass4 anonymousClass4 = HttpClient.this.new AnonymousClass4((Continuation) obj3);
            anonymousClass4.f49276b = (PipelineContext) obj;
            return anonymousClass4.invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext;
            Throwable th;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f49275a;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pipelineContext = this.f49276b;
                try {
                    ResultKt.b(obj);
                    return Unit.f53572a;
                } catch (Throwable th2) {
                    th = th2;
                    HttpClient.this.f49267j.a(ClientEventsKt.f50111d, new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.f50587a).e(), th));
                    throw th;
                }
            }
            ResultKt.b(obj);
            PipelineContext pipelineContext2 = this.f49276b;
            try {
                this.f49276b = pipelineContext2;
                this.f49275a = 1;
                if (pipelineContext2.e(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return Unit.f53572a;
            } catch (Throwable th3) {
                pipelineContext = pipelineContext2;
                th = th3;
                HttpClient.this.f49267j.a(ClientEventsKt.f50111d, new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.f50587a).e(), th));
                throw th;
            }
        }
    }

    public HttpClient(HttpClientEngine engine, HttpClientConfig other) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(other, "userConfig");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(other, "userConfig");
        this.f49258a = engine;
        this.closed = 0;
        JobImpl jobImpl = new JobImpl((Job) engine.r().get(Job.Key.f54121a));
        this.f49260c = jobImpl;
        this.f49261d = engine.r().plus(jobImpl);
        this.f49262e = new HttpRequestPipeline(other.f49287g);
        this.f49263f = new HttpResponsePipeline(other.f49287g);
        HttpSendPipeline httpSendPipeline = new HttpSendPipeline(other.f49287g);
        this.f49264g = httpSendPipeline;
        this.f49265h = new HttpReceivePipeline(other.f49287g);
        this.f49266i = AttributesJvmKt.a();
        this.f49267j = new Events();
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        this.f49268k = httpClientConfig;
        if (this.f49259b) {
            jobImpl.j0(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClient.1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    if (((Throwable) obj) != null) {
                        CoroutineScopeKt.b(HttpClient.this.f49258a, null);
                    }
                    return Unit.f53572a;
                }
            });
        }
        engine.K1(this);
        httpSendPipeline.g(HttpSendPipeline.f50034k, new AnonymousClass2(null));
        HttpRequestLifecycle.Plugin plugin = HttpRequestLifecycle.f49576a;
        HttpClientConfig$install$1 httpClientConfig$install$1 = HttpClientConfig$install$1.f49291c;
        httpClientConfig.b(plugin, httpClientConfig$install$1);
        httpClientConfig.b(BodyProgress.f49443a, httpClientConfig$install$1);
        if (other.f49286f) {
            HttpClient$3$1 block = HttpClient$3$1.f49274c;
            Intrinsics.checkNotNullParameter("DefaultTransformers", "key");
            Intrinsics.checkNotNullParameter(block, "block");
            httpClientConfig.f49283c.put("DefaultTransformers", block);
        }
        httpClientConfig.b(HttpSend.f49625b, httpClientConfig$install$1);
        httpClientConfig.b(HttpCallValidator.f49498d, httpClientConfig$install$1);
        if (other.f49285e) {
            httpClientConfig.b(HttpRedirect.f49555a, httpClientConfig$install$1);
        }
        Intrinsics.checkNotNullParameter(other, "other");
        httpClientConfig.f49285e = other.f49285e;
        httpClientConfig.f49286f = other.f49286f;
        httpClientConfig.f49281a.putAll(other.f49281a);
        httpClientConfig.f49282b.putAll(other.f49282b);
        httpClientConfig.f49283c.putAll(other.f49283c);
        if (other.f49286f) {
            httpClientConfig.b(HttpPlainText.f49538d, httpClientConfig$install$1);
        }
        DefaultResponseValidationKt.a(httpClientConfig);
        Intrinsics.checkNotNullParameter(this, "client");
        Iterator it = httpClientConfig.f49281a.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this);
        }
        Iterator it2 = httpClientConfig.f49283c.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(this);
        }
        this.f49263f.g(HttpResponsePipeline.f50069g, new AnonymousClass4(null));
        this.f49259b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.HttpClient$execute$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.HttpClient$execute$1 r0 = (io.ktor.client.HttpClient$execute$1) r0
            int r1 = r0.f49280c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49280c = r1
            goto L18
        L13:
            io.ktor.client.HttpClient$execute$1 r0 = new io.ktor.client.HttpClient$execute$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f49278a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49280c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r6)
            goto L46
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r6)
            io.ktor.events.EventDefinition r6 = io.ktor.client.utils.ClientEventsKt.f50108a
            io.ktor.events.Events r2 = r4.f49267j
            r2.a(r6, r5)
            java.lang.Object r6 = r5.f50006d
            r0.f49280c = r3
            io.ktor.client.request.HttpRequestPipeline r2 = r4.f49262e
            java.lang.Object r6 = r2.a(r5, r6, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.lang.String r5 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.Intrinsics.d(r6, r5)
            io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.HttpClient.a(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (f49257l.compareAndSet(this, 0, 1)) {
            Attributes attributes = (Attributes) this.f49266i.a(HttpClientPluginKt.f49537a);
            for (AttributeKey attributeKey : attributes.c()) {
                Intrinsics.d(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object objA = attributes.a(attributeKey);
                if (objA instanceof Closeable) {
                    ((Closeable) objA).close();
                }
            }
            this.f49260c.complete();
            if (this.f49259b) {
                this.f49258a.close();
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49261d;
    }

    public final String toString() {
        return "HttpClient[" + this.f49258a + ']';
    }
}
