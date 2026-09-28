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
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$shareTransactionAsFile$1$shareIntent$1", f = "TransactionActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TransactionActivity$shareTransactionAsFile$1$shareIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Intent>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sharable f16919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TransactionActivity f16920b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16921c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionActivity$shareTransactionAsFile$1$shareIntent$1(Sharable sharable, TransactionActivity transactionActivity, String str, Continuation continuation) {
        super(2, continuation);
        this.f16919a = sharable;
        this.f16920b = transactionActivity;
        this.f16921c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TransactionActivity$shareTransactionAsFile$1$shareIntent$1(this.f16919a, this.f16920b, this.f16921c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TransactionActivity$shareTransactionAsFile$1$shareIntent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        int i2 = R.string.chucker_share_transaction_title;
        TransactionActivity transactionActivity = this.f16920b;
        String string = transactionActivity.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.f16920b.getString(R.string.chucker_share_transaction_subject);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return SharableKt.a(this.f16919a, transactionActivity, this.f16921c, string, string2, "transaction");
    }
}
