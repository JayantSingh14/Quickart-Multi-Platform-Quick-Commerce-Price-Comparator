package io.ktor.client.plugins.cookies;

import io.ktor.client.statement.HttpResponse;
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
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$Companion$install$3", f = "HttpCookies.kt", l = {124}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HttpCookies$Companion$install$3 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49909a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ HttpResponse f49910b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49911c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$Companion$install$3(HttpCookies httpCookies, Continuation continuation) {
        super(3, continuation);
        this.f49911c = httpCookies;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCookies$Companion$install$3 httpCookies$Companion$install$3 = new HttpCookies$Companion$install$3(this.f49911c, (Continuation) obj3);
        httpCookies$Companion$install$3.f49910b = (HttpResponse) obj2;
        return httpCookies$Companion$install$3.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49909a;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpResponse httpResponse = this.f49910b;
            this.f49909a = 1;
            if (this.f49911c.c(httpResponse, this) == coroutineSingletons) {
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
