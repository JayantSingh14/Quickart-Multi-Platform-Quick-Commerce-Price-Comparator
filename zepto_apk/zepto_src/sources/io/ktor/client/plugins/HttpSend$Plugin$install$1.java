package io.ktor.client.plugins;

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
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", l = {104, 105}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49637a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49638b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49639c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpSend f49640d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49641e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49640d = httpSend;
        this.f49641e = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.f49640d, this.f49641e, (Continuation) obj3);
        httpSend$Plugin$install$1.f49638b = (PipelineContext) obj;
        httpSend$Plugin$install$1.f49639c = obj2;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e2, code lost:
    
        if (r1.f((io.ktor.client.call.HttpClientCall) r11, r10) == r0) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend$Plugin$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
