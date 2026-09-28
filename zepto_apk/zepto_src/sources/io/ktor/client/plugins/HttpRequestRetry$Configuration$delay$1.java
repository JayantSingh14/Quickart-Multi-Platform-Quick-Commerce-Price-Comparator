package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$Configuration$delay$1", f = "HttpRequestRetry.kt", l = {WKSRecord.Service.SUNRPC}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpRequestRetry$Configuration$delay$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49598a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long f49599b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        HttpRequestRetry$Configuration$delay$1 httpRequestRetry$Configuration$delay$1 = new HttpRequestRetry$Configuration$delay$1(2, continuation);
        httpRequestRetry$Configuration$delay$1.f49599b = ((Number) obj).longValue();
        return httpRequestRetry$Configuration$delay$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HttpRequestRetry$Configuration$delay$1) create(Long.valueOf(((Number) obj).longValue()), (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49598a;
        if (i2 == 0) {
            ResultKt.b(obj);
            long j2 = this.f49599b;
            this.f49598a = 1;
            if (DelayKt.a(j2, this) == coroutineSingletons) {
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
