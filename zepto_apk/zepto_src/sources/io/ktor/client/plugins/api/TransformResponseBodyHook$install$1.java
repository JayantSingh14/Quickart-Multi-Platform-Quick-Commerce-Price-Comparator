package io.ktor.client.plugins.api;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.content.NullBody;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.api.TransformResponseBodyHook$install$1", f = "KtorCallContexts.kt", l = {Type.EUI48, WKSRecord.Service.SFTP}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TransformResponseBodyHook$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public TypeInfo f49679a;

    /* renamed from: b, reason: collision with root package name */
    public int f49680b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49681c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49680b;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49681c;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) pipelineContext.d();
            TypeInfo typeInfo = httpResponseContainer.f50062a;
            if (!(httpResponseContainer.f50063b instanceof ByteReadChannel)) {
                return Unit.f53572a;
            }
            new TransformResponseBodyContext();
            ((HttpClientCall) pipelineContext.f50587a).e();
            this.f49681c = pipelineContext;
            this.f49679a = typeInfo;
            this.f49680b = 1;
            throw null;
        }
        if (i2 == 1) {
            TypeInfo typeInfo2 = this.f49679a;
            PipelineContext pipelineContext2 = this.f49681c;
            ResultKt.b(obj);
            if (obj == null) {
                return Unit.f53572a;
            }
            if (!(obj instanceof NullBody) && !typeInfo2.f50602a.h(obj)) {
                throw new IllegalStateException("transformResponseBody returned " + obj + " but expected value of type " + typeInfo2);
            }
            HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo2, obj);
            this.f49681c = null;
            this.f49679a = null;
            this.f49680b = 2;
            if (pipelineContext2.f(httpResponseContainer2, this) == coroutineSingletons) {
                return coroutineSingletons;
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
