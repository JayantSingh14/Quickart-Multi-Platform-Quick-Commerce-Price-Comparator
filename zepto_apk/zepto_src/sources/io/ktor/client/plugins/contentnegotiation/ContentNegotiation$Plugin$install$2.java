package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$2", f = "ContentNegotiation.kt", l = {264, 267}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class ContentNegotiation$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49858a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49859b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49860c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ContentNegotiation f49861d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$Plugin$install$2(ContentNegotiation contentNegotiation, Continuation continuation) {
        super(3, continuation);
        this.f49861d = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ContentNegotiation$Plugin$install$2 contentNegotiation$Plugin$install$2 = new ContentNegotiation$Plugin$install$2(this.f49861d, (Continuation) obj3);
        contentNegotiation$Plugin$install$2.f49859b = (PipelineContext) obj;
        contentNegotiation$Plugin$install$2.f49860c = (HttpResponseContainer) obj2;
        return contentNegotiation$Plugin$install$2.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a7, code lost:
    
        if (r4.f(r5, r12) == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws io.ktor.http.BadContentTypeFormatException {
        /*
            r12 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r12.f49858a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.b(r13)
            r11 = r12
            goto Laa
        L13:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1b:
            java.lang.Object r1 = r12.f49860c
            io.ktor.util.reflect.TypeInfo r1 = (io.ktor.util.reflect.TypeInfo) r1
            io.ktor.util.pipeline.PipelineContext r4 = r12.f49859b
            kotlin.ResultKt.b(r13)
            r11 = r12
            goto L93
        L27:
            kotlin.ResultKt.b(r13)
            io.ktor.util.pipeline.PipelineContext r13 = r12.f49859b
            java.lang.Object r1 = r12.f49860c
            io.ktor.client.statement.HttpResponseContainer r1 = (io.ktor.client.statement.HttpResponseContainer) r1
            io.ktor.util.reflect.TypeInfo r7 = r1.a()
            java.lang.Object r8 = r1.b()
            java.lang.Object r1 = r13.f50587a
            io.ktor.client.call.HttpClientCall r1 = (io.ktor.client.call.HttpClientCall) r1
            io.ktor.client.statement.HttpResponse r1 = r1.e()
            java.lang.String r5 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            io.ktor.http.Headers r1 = r1.getHeaders()
            java.util.List r5 = io.ktor.http.HttpHeaders.f50204a
            java.lang.String r5 = "Content-Type"
            java.lang.String r1 = r1.b(r5)
            if (r1 == 0) goto L5b
            io.ktor.http.ContentType r5 = io.ktor.http.ContentType.f50126e
            io.ktor.http.ContentType r1 = io.ktor.http.ContentType.Companion.a(r1)
            r9 = r1
            goto L5c
        L5b:
            r9 = r2
        L5c:
            if (r9 != 0) goto L68
            org.slf4j.Logger r13 = io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt.f49876a
            java.lang.String r0 = "Response doesn't have \"Content-Type\" header, skipping ContentNegotiation plugin"
            r13.r(r0)
            kotlin.Unit r13 = kotlin.Unit.f53572a
            return r13
        L68:
            java.lang.Object r1 = r13.f50587a
            io.ktor.client.call.HttpClientCall r1 = (io.ktor.client.call.HttpClientCall) r1
            io.ktor.client.request.HttpRequest r5 = r1.d()
            io.ktor.http.Headers r5 = r5.getHeaders()
            java.nio.charset.Charset r10 = io.ktor.serialization.ContentConverterKt.b(r5)
            io.ktor.client.request.HttpRequest r1 = r1.d()
            io.ktor.http.Url r6 = r1.N()
            r12.f49859b = r13
            r12.f49860c = r7
            r12.f49858a = r4
            io.ktor.client.plugins.contentnegotiation.ContentNegotiation r5 = r12.f49861d
            r11 = r12
            java.lang.Object r1 = r5.b(r6, r7, r8, r9, r10, r11)
            if (r1 != r0) goto L90
            goto La9
        L90:
            r4 = r13
            r13 = r1
            r1 = r7
        L93:
            if (r13 != 0) goto L98
            kotlin.Unit r13 = kotlin.Unit.f53572a
            return r13
        L98:
            io.ktor.client.statement.HttpResponseContainer r5 = new io.ktor.client.statement.HttpResponseContainer
            r5.<init>(r1, r13)
            r11.f49859b = r2
            r11.f49860c = r2
            r11.f49858a = r3
            java.lang.Object r13 = r4.f(r5, r12)
            if (r13 != r0) goto Laa
        La9:
            return r0
        Laa:
            kotlin.Unit r13 = kotlin.Unit.f53572a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
