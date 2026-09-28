package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$killer$1", f = "HttpTimeout.kt", l = {164}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpTimeout$Plugin$install$1$1$killer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49656a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Long f49657b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpRequestBuilder f49658c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Job f49659d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeout$Plugin$install$1$1$killer$1(Long l2, HttpRequestBuilder httpRequestBuilder, Job job, Continuation continuation) {
        super(2, continuation);
        this.f49657b = l2;
        this.f49658c = httpRequestBuilder;
        this.f49659d = job;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpTimeout$Plugin$install$1$1$killer$1(this.f49657b, this.f49658c, this.f49659d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HttpTimeout$Plugin$install$1$1$killer$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49656a;
        if (i2 == 0) {
            ResultKt.b(obj);
            long jLongValue = this.f49657b.longValue();
            this.f49656a = 1;
            if (DelayKt.a(jLongValue, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        HttpRequestBuilder httpRequestBuilder = this.f49658c;
        HttpRequestTimeoutException httpRequestTimeoutException = new HttpRequestTimeoutException(httpRequestBuilder);
        HttpTimeoutKt.f49660a.r("Request timeout: " + httpRequestBuilder.f50003a);
        String message = httpRequestTimeoutException.getMessage();
        Intrinsics.c(message);
        ((JobSupport) this.f49659d).y(ExceptionsKt.a(message, httpRequestTimeoutException));
        return Unit.f53572a;
    }
}
