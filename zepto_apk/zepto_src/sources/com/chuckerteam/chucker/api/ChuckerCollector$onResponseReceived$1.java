package com.chuckerteam.chucker.api;

import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.api.ChuckerCollector$onResponseReceived$1", f = "ChuckerCollector.kt", l = {WKSRecord.Service.NETRJS_4}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChuckerCollector$onResponseReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16607a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChuckerCollector f16608b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpTransaction f16609c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChuckerCollector$onResponseReceived$1(ChuckerCollector chuckerCollector, HttpTransaction httpTransaction, Continuation continuation) {
        super(2, continuation);
        this.f16608b = chuckerCollector;
        this.f16609c = httpTransaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ChuckerCollector$onResponseReceived$1(this.f16608b, this.f16609c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChuckerCollector$onResponseReceived$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16607a;
        HttpTransaction httpTransaction = this.f16609c;
        if (i2 == 0) {
            ResultKt.b(obj);
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.f55150b;
            ChuckerCollector$onResponseReceived$1$updated$1 chuckerCollector$onResponseReceived$1$updated$1 = new ChuckerCollector$onResponseReceived$1$updated$1(httpTransaction, null);
            this.f16607a = 1;
            obj = BuildersKt.e(defaultIoScheduler, chuckerCollector$onResponseReceived$1$updated$1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        int iIntValue = ((Number) obj).intValue();
        ChuckerCollector chuckerCollector = this.f16608b;
        if (chuckerCollector.f16596a && iIntValue > 0) {
            chuckerCollector.f16598c.a(httpTransaction);
        }
        return Unit.f53572a;
    }
}
