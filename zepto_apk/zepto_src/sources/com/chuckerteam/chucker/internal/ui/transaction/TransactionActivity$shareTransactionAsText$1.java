package com.chuckerteam.chucker.internal.ui.transaction;

import android.content.Intent;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.support.Sharable;
import com.chuckerteam.chucker.internal.support.SharableKt;
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
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$shareTransactionAsText$1", f = "TransactionActivity.kt", l = {118}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TransactionActivity$shareTransactionAsText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16922a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sharable f16923b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TransactionActivity f16924c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionActivity$shareTransactionAsText$1(Sharable sharable, TransactionActivity transactionActivity, Continuation continuation) {
        super(2, continuation);
        this.f16923b = sharable;
        this.f16924c = transactionActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TransactionActivity$shareTransactionAsText$1(this.f16923b, this.f16924c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TransactionActivity$shareTransactionAsText$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16922a;
        TransactionActivity transactionActivity = this.f16924c;
        if (i2 == 0) {
            ResultKt.b(obj);
            String string = transactionActivity.getString(R.string.chucker_share_transaction_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = transactionActivity.getString(R.string.chucker_share_transaction_subject);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.f16922a = 1;
            obj = SharableKt.b(this.f16923b, transactionActivity, string, string2, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        transactionActivity.startActivity((Intent) obj);
        return Unit.f53572a;
    }
}
