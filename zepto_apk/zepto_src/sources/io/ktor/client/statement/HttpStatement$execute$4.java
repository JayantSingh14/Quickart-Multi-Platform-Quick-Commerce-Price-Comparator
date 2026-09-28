package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpStatement$execute$4 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50086a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50087b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        HttpStatement$execute$4 httpStatement$execute$4 = new HttpStatement$execute$4(2, continuation);
        httpStatement$execute$4.f50087b = obj;
        return httpStatement$execute$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HttpStatement$execute$4) create((HttpResponse) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f50086a;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpClientCall httpClientCallO1 = ((HttpResponse) this.f50087b).o1();
            this.f50086a = 1;
            obj = SavedCallKt.a(httpClientCallO1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return ((HttpClientCall) obj).e();
    }
}
