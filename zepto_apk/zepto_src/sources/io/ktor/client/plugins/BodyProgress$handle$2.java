package io.ktor.client.plugins;

import io.ktor.client.plugins.observer.DelegatedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$2", f = "BodyProgress.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class BodyProgress$handle$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49448a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49449b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpResponse f49450c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        BodyProgress$handle$2 bodyProgress$handle$2 = new BodyProgress$handle$2(3, (Continuation) obj3);
        bodyProgress$handle$2.f49449b = (PipelineContext) obj;
        bodyProgress$handle$2.f49450c = (HttpResponse) obj2;
        return bodyProgress$handle$2.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49448a;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49449b;
            HttpResponse httpResponse = this.f49450c;
            Function3 listener = (Function3) httpResponse.o1().d().j1().f(BodyProgressKt.f49452b);
            if (listener == null) {
                return Unit.f53572a;
            }
            Intrinsics.checkNotNullParameter(httpResponse, "<this>");
            Intrinsics.checkNotNullParameter(listener, "listener");
            ByteReadChannel byteReadChannelA = httpResponse.a();
            CoroutineContext coroutineContextR = httpResponse.r();
            Intrinsics.checkNotNullParameter(httpResponse, "<this>");
            Headers headers = httpResponse.getHeaders();
            List list = HttpHeaders.f50204a;
            String strB = headers.b("Content-Length");
            HttpResponse httpResponseE = DelegatedCallKt.a(httpResponse.o1(), ByteChannelUtilsKt.a(byteReadChannelA, coroutineContextR, strB != null ? Long.valueOf(Long.parseLong(strB)) : null, listener)).e();
            this.f49449b = null;
            this.f49448a = 1;
            if (pipelineContext.f(httpResponseE, this) == coroutineSingletons) {
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
