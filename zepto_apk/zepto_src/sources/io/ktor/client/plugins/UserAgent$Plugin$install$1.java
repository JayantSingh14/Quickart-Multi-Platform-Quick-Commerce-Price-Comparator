package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.pipeline.PipelineContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.UserAgent$Plugin$install$1", f = "UserAgent.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class UserAgent$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49667a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAgent f49668b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAgent$Plugin$install$1(UserAgent userAgent, Continuation continuation) {
        super(3, continuation);
        this.f49668b = userAgent;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        UserAgent$Plugin$install$1 userAgent$Plugin$install$1 = new UserAgent$Plugin$install$1(this.f49668b, (Continuation) obj3);
        userAgent$Plugin$install$1.f49667a = (PipelineContext) obj;
        return userAgent$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        PipelineContext pipelineContext = this.f49667a;
        Logger logger = UserAgentKt.f49669a;
        StringBuilder sb = new StringBuilder("Adding User-Agent header: ");
        UserAgent userAgent = this.f49668b;
        sb.append(userAgent.f49665a);
        sb.append(" for ");
        sb.append(((HttpRequestBuilder) pipelineContext.f50587a).f50003a);
        logger.r(sb.toString());
        HttpMessageBuilder httpMessageBuilder = (HttpMessageBuilder) pipelineContext.f50587a;
        List list = HttpHeaders.f50204a;
        UtilsKt.a(httpMessageBuilder, "User-Agent", userAgent.f49665a);
        return Unit.f53572a;
    }
}
