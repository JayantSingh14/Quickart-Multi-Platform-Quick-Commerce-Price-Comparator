package com.chuckerteam.chucker.internal.ui;

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
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainViewModel$clearTransactions$1", f = "MainViewModel.kt", l = {43}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainViewModel$clearTransactions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16889a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainViewModel$clearTransactions$1(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainViewModel$clearTransactions$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16889a;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpTransactionRepository httpTransactionRepositoryB = RepositoryProvider.b();
            this.f16889a = 1;
            if (((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).a(this) == coroutineSingletons) {
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
