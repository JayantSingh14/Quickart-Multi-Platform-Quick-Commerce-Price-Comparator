package io.ktor.client.plugins;

import io.ktor.client.content.ObservableContent;
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
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$1", f = "BodyProgress.kt", l = {Type.A6}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class BodyProgress$handle$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49445a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49446b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49447c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        BodyProgress$handle$1 bodyProgress$handle$1 = new BodyProgress$handle$1(3, (Continuation) obj3);
        bodyProgress$handle$1.f49446b = (PipelineContext) obj;
        bodyProgress$handle$1.f49447c = obj2;
        return bodyProgress$handle$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49445a;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49446b;
            Object obj2 = this.f49447c;
            Function3 function3 = (Function3) ((HttpRequestBuilder) pipelineContext.f50587a).f50008f.f(BodyProgressKt.f49451a);
            if (function3 == null) {
                return Unit.f53572a;
            }
            Intrinsics.d(obj2, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
            ObservableContent observableContent = new ObservableContent((OutgoingContent) obj2, ((HttpRequestBuilder) pipelineContext.f50587a).f50007e, function3);
            this.f49446b = null;
            this.f49445a = 1;
            if (pipelineContext.f(observableContent, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
