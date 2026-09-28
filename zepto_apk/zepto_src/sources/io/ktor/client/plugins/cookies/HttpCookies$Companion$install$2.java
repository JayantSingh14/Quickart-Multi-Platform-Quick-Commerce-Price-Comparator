package io.ktor.client.plugins.cookies;

import io.ktor.client.request.HttpRequestBuilder;
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
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$Companion$install$2", f = "HttpCookies.kt", l = {120}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HttpCookies$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49906a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49907b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49908c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$Companion$install$2(HttpCookies httpCookies, Continuation continuation) {
        super(3, continuation);
        this.f49908c = httpCookies;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCookies$Companion$install$2 httpCookies$Companion$install$2 = new HttpCookies$Companion$install$2(this.f49908c, (Continuation) obj3);
        httpCookies$Companion$install$2.f49907b = (PipelineContext) obj;
        return httpCookies$Companion$install$2.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49906a;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.f49907b.f50587a;
            this.f49906a = 1;
            if (this.f49908c.e(httpRequestBuilder, this) == coroutineSingletons) {
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
