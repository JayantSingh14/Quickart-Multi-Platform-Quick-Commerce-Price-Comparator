package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1", f = "ResponseObserver.kt", l = {WKSRecord.Service.BOOTPC, 77}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ResponseObserver$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public HttpResponse f49954a;

    /* renamed from: b, reason: collision with root package name */
    public HttpClient f49955b;

    /* renamed from: c, reason: collision with root package name */
    public int f49956c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49957d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ HttpResponse f49958e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ResponseObserver f49959f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49960g;

    @Metadata
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1", f = "ResponseObserver.kt", l = {69, WKSRecord.Service.NETRJS_3}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f49961a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f49962b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HttpResponse f49963c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ResponseObserver f49964d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpResponse httpResponse, ResponseObserver responseObserver, Continuation continuation) {
            super(2, continuation);
            this.f49963c = httpResponse;
            this.f49964d = responseObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f49963c, this.f49964d, continuation);
            anonymousClass1.f49962b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
        
            if (r7 == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r6.f49961a
                io.ktor.client.statement.HttpResponse r2 = r6.f49963c
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L12
                goto L65
            L12:
                r7 = move-exception
                goto L73
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1c:
                java.lang.Object r1 = r6.f49962b
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L24
                goto L40
            L24:
                r7 = move-exception
                goto L45
            L26:
                kotlin.ResultKt.b(r7)
                java.lang.Object r7 = r6.f49962b
                kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
                io.ktor.client.plugins.observer.ResponseObserver r1 = r6.f49964d
                kotlin.Result$Companion r5 = kotlin.Result.f53538b     // Catch: java.lang.Throwable -> L24
                kotlin.jvm.functions.Function2 r1 = r1.f49952a     // Catch: java.lang.Throwable -> L24
                r6.f49962b = r7     // Catch: java.lang.Throwable -> L24
                r6.f49961a = r4     // Catch: java.lang.Throwable -> L24
                io.ktor.client.plugins.observer.ResponseObserver$Config$responseHandler$1 r1 = (io.ktor.client.plugins.observer.ResponseObserver$Config$responseHandler$1) r1     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = r1.invoke(r2, r6)     // Catch: java.lang.Throwable -> L24
                if (r7 != r0) goto L40
                goto L64
            L40:
                kotlin.Unit r7 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L24
                kotlin.Result$Companion r7 = kotlin.Result.f53538b     // Catch: java.lang.Throwable -> L24
                goto L4a
            L45:
                kotlin.Result$Companion r1 = kotlin.Result.f53538b
                kotlin.ResultKt.a(r7)
            L4a:
                io.ktor.utils.io.ByteReadChannel r7 = r2.a()
                boolean r1 = r7.K()
                if (r1 != 0) goto L78
                r1 = 0
                r6.f49962b = r1     // Catch: java.lang.Throwable -> L12
                r6.f49961a = r3     // Catch: java.lang.Throwable -> L12
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                java.lang.Object r7 = r7.D(r1, r6)     // Catch: java.lang.Throwable -> L12
                if (r7 != r0) goto L65
            L64:
                return r0
            L65:
                java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Throwable -> L12
                long r0 = r7.longValue()     // Catch: java.lang.Throwable -> L12
                java.lang.Long r7 = new java.lang.Long     // Catch: java.lang.Throwable -> L12
                r7.<init>(r0)     // Catch: java.lang.Throwable -> L12
                kotlin.Result$Companion r7 = kotlin.Result.f53538b     // Catch: java.lang.Throwable -> L12
                goto L78
            L73:
                kotlin.Result$Companion r0 = kotlin.Result.f53538b
                kotlin.ResultKt.a(r7)
            L78:
                kotlin.Unit r7 = kotlin.Unit.f53572a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseObserver$Plugin$install$1(ResponseObserver responseObserver, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49959f = responseObserver;
        this.f49960g = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ResponseObserver$Plugin$install$1 responseObserver$Plugin$install$1 = new ResponseObserver$Plugin$install$1(this.f49959f, this.f49960g, (Continuation) obj3);
        responseObserver$Plugin$install$1.f49957d = (PipelineContext) obj;
        responseObserver$Plugin$install$1.f49958e = (HttpResponse) obj2;
        return responseObserver$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
    
        if (r6.f(r5, r10) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r10.f49956c
            r2 = 2
            io.ktor.client.plugins.observer.ResponseObserver r3 = r10.f49959f
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r11)
            goto L9b
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            io.ktor.client.HttpClient r1 = r10.f49955b
            io.ktor.client.statement.HttpResponse r4 = r10.f49954a
            io.ktor.client.statement.HttpResponse r5 = r10.f49958e
            io.ktor.util.pipeline.PipelineContext r6 = r10.f49957d
            kotlin.ResultKt.b(r11)
            goto L7f
        L27:
            kotlin.ResultKt.b(r11)
            io.ktor.util.pipeline.PipelineContext r6 = r10.f49957d
            io.ktor.client.statement.HttpResponse r11 = r10.f49958e
            r3.getClass()
            io.ktor.utils.io.ByteReadChannel r1 = r11.a()
            kotlin.Pair r1 = io.ktor.util.ByteChannelsKt.a(r1, r11)
            java.lang.Object r5 = r1.f53533a
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            java.lang.Object r1 = r1.f53534b
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            io.ktor.client.call.HttpClientCall r7 = r11.o1()
            io.ktor.client.plugins.observer.DelegatedCall r1 = io.ktor.client.plugins.observer.DelegatedCallKt.a(r7, r1)
            io.ktor.client.statement.HttpResponse r1 = r1.e()
            io.ktor.client.call.HttpClientCall r11 = r11.o1()
            io.ktor.client.plugins.observer.DelegatedCall r11 = io.ktor.client.plugins.observer.DelegatedCallKt.a(r11, r5)
            io.ktor.client.statement.HttpResponse r11 = r11.e()
            r10.f49957d = r6
            r10.f49958e = r1
            r10.f49954a = r11
            io.ktor.client.HttpClient r5 = r10.f49960g
            r10.f49955b = r5
            r10.f49956c = r4
            kotlin.coroutines.CoroutineContext r4 = r10.getContext()
            kotlinx.coroutines.slf4j.MDCContext$Key r7 = kotlinx.coroutines.slf4j.MDCContext.f55221b
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r7)
            kotlinx.coroutines.slf4j.MDCContext r4 = (kotlinx.coroutines.slf4j.MDCContext) r4
            if (r4 == 0) goto L74
            goto L76
        L74:
            kotlin.coroutines.EmptyCoroutineContext r4 = kotlin.coroutines.EmptyCoroutineContext.f53685a
        L76:
            if (r4 != r0) goto L79
            goto L9a
        L79:
            r9 = r4
            r4 = r11
            r11 = r9
            r9 = r5
            r5 = r1
            r1 = r9
        L7f:
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1 r7 = new io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1
            r8 = 0
            r7.<init>(r4, r3, r8)
            kotlinx.coroutines.BuildersKt.c(r1, r11, r7, r2)
            r10.f49957d = r8
            r10.f49958e = r8
            r10.f49954a = r8
            r10.f49955b = r8
            r10.f49956c = r2
            java.lang.Object r11 = r6.f(r5, r10)
            if (r11 != r0) goto L9b
        L9a:
            return r0
        L9b:
            kotlin.Unit r11 = kotlin.Unit.f53572a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
