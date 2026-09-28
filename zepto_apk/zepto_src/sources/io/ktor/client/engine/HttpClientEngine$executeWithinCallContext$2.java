package io.ktor.client.engine;

import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpClientEngine$executeWithinCallContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponseData>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpClientEngine f49340b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpRequestData f49341c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$executeWithinCallContext$2(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData, Continuation continuation) {
        super(2, continuation);
        this.f49340b = httpClientEngine;
        this.f49341c = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpClientEngine$executeWithinCallContext$2(this.f49340b, this.f49341c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HttpClientEngine$executeWithinCallContext$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49339a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        HttpClientEngine httpClientEngine = this.f49340b;
        Job job = (Job) httpClientEngine.r().get(Job.Key.f54121a);
        if (!(job != null ? job.a() : false)) {
            throw new ClientEngineClosedException(0);
        }
        this.f49339a = 1;
        Object objQ0 = httpClientEngine.Q0(this.f49341c, this);
        return objQ0 == coroutineSingletons ? coroutineSingletons : objQ0;
    }
}
