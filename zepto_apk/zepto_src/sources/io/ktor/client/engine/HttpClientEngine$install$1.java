package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", l = {70, 82}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class HttpClientEngine$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49342a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49343b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49344c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49345d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpClientEngine f49346e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$install$1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation continuation) {
        super(3, continuation);
        this.f49345d = httpClient;
        this.f49346e = httpClientEngine;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpClientEngine httpClientEngine = this.f49346e;
        HttpClientEngine$install$1 httpClientEngine$install$1 = new HttpClientEngine$install$1(this.f49345d, httpClientEngine, (Continuation) obj3);
        httpClientEngine$install$1.f49343b = (PipelineContext) obj;
        httpClientEngine$install$1.f49344c = obj2;
        return httpClientEngine$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x014e, code lost:
    
        if (r3.f(r6, r12) == r0) goto L39;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
