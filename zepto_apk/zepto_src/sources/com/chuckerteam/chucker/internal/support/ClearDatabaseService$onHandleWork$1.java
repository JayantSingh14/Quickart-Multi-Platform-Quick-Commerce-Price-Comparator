package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import android.util.LongSparseArray;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.ClearDatabaseService$onHandleWork$1", f = "ClearDatabaseService.kt", l = {16}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ClearDatabaseService$onHandleWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16752a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ClearDatabaseService f16753b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearDatabaseService$onHandleWork$1(ClearDatabaseService clearDatabaseService, Continuation continuation) {
        super(2, continuation);
        this.f16753b = clearDatabaseService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ClearDatabaseService$onHandleWork$1(this.f16753b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ClearDatabaseService$onHandleWork$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16752a;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpTransactionRepository httpTransactionRepositoryB = RepositoryProvider.b();
            this.f16752a = 1;
            if (((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).a(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        LongSparseArray longSparseArray = NotificationHelper.f16779d;
        synchronized (longSparseArray) {
            longSparseArray.clear();
            NotificationHelper.f16780e.clear();
            Unit unit = Unit.f53572a;
        }
        Context applicationContext = this.f16753b.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        new NotificationHelper(applicationContext).f16782b.cancel(1138);
        return Unit.f53572a;
    }
}
