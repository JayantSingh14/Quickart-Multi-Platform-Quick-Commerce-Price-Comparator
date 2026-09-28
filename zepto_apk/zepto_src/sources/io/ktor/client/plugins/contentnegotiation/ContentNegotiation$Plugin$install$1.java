package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$1", f = "ContentNegotiation.kt", l = {253, 254}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class ContentNegotiation$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49855a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49856b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ContentNegotiation f49857c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$Plugin$install$1(ContentNegotiation contentNegotiation, Continuation continuation) {
        super(3, continuation);
        this.f49857c = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ContentNegotiation$Plugin$install$1 contentNegotiation$Plugin$install$1 = new ContentNegotiation$Plugin$install$1(this.f49857c, (Continuation) obj3);
        contentNegotiation$Plugin$install$1.f49856b = (PipelineContext) obj;
        return contentNegotiation$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r1.f(r6, r5) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f49855a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.b(r6)
            goto L49
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            io.ktor.util.pipeline.PipelineContext r1 = r5.f49856b
            kotlin.ResultKt.b(r6)
            goto L38
        L1e:
            kotlin.ResultKt.b(r6)
            io.ktor.util.pipeline.PipelineContext r1 = r5.f49856b
            java.lang.Object r6 = r1.f50587a
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            java.lang.Object r4 = r1.d()
            r5.f49856b = r1
            r5.f49855a = r3
            io.ktor.client.plugins.contentnegotiation.ContentNegotiation r3 = r5.f49857c
            java.lang.Object r6 = r3.a(r6, r4, r5)
            if (r6 != r0) goto L38
            goto L48
        L38:
            if (r6 != 0) goto L3d
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L3d:
            r3 = 0
            r5.f49856b = r3
            r5.f49855a = r2
            java.lang.Object r6 = r1.f(r6, r5)
            if (r6 != r0) goto L49
        L48:
            return r0
        L49:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
