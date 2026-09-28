package com.chuckerteam.chucker.api;

import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionRepository;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.api.ChuckerCollector$onResponseReceived$1$updated$1", f = "ChuckerCollector.kt", l = {75}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChuckerCollector$onResponseReceived$1$updated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16610a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpTransaction f16611b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChuckerCollector$onResponseReceived$1$updated$1(HttpTransaction httpTransaction, Continuation continuation) {
        super(2, continuation);
        this.f16611b = httpTransaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ChuckerCollector$onResponseReceived$1$updated$1(this.f16611b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChuckerCollector$onResponseReceived$1$updated$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16610a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        HttpTransactionRepository httpTransactionRepositoryB = RepositoryProvider.b();
        this.f16610a = 1;
        Object objF = ((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).f16717a.q().f(this.f16611b, this);
        return objF == coroutineSingletons ? coroutineSingletons : objF;
    }
}
