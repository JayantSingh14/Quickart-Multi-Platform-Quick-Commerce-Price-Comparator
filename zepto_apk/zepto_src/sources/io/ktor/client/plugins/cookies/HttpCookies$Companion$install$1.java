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
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$Companion$install$1", f = "HttpCookies.kt", l = {WKSRecord.Service.UUCP_PATH}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HttpCookies$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49903a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49904b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49905c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$Companion$install$1(HttpCookies httpCookies, Continuation continuation) {
        super(3, continuation);
        this.f49905c = httpCookies;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCookies$Companion$install$1 httpCookies$Companion$install$1 = new HttpCookies$Companion$install$1(this.f49905c, (Continuation) obj3);
        httpCookies$Companion$install$1.f49904b = (PipelineContext) obj;
        return httpCookies$Companion$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49903a;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.f49904b.f50587a;
            this.f49903a = 1;
            if (this.f49905c.a(httpRequestBuilder, this) == coroutineSingletons) {
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
