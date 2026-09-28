package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.api.TransformRequestBodyHook$install$1", f = "KtorCallContexts.kt", l = {82, 83}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TransformRequestBodyHook$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49677a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49678b;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49677a;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49678b;
            new TransformRequestBodyContext();
            this.f49678b = pipelineContext;
            this.f49677a = 1;
            throw null;
        }
        if (i2 == 1) {
            PipelineContext pipelineContext2 = this.f49678b;
            ResultKt.b(obj);
            OutgoingContent outgoingContent = (OutgoingContent) obj;
            if (outgoingContent != null) {
                this.f49678b = null;
                this.f49677a = 2;
                if (pipelineContext2.f(outgoingContent, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
