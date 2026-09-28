package com.chuckerteam.chucker.internal.ui.transaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$shareTransactionAsFile$1", f = "TransactionActivity.kt", l = {WKSRecord.Service.NETBIOS_SSN, WKSRecord.Service.EMFIS_CNTL}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TransactionActivity$shareTransactionAsFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16915a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TransactionActivity f16916b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f16917c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16918d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransactionActivity$shareTransactionAsFile$1(TransactionActivity transactionActivity, Function2 function2, String str, Continuation continuation) {
        super(2, continuation);
        this.f16916b = transactionActivity;
        this.f16917c = (SuspendLambda) function2;
        this.f16918d = str;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TransactionActivity$shareTransactionAsFile$1(this.f16916b, this.f16917c, this.f16918d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TransactionActivity$shareTransactionAsFile$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r8 == r0) goto L19;
     */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r7.f16915a
            r2 = 1
            r3 = 2
            com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity r4 = r7.f16916b
            if (r1 == 0) goto L1e
            if (r1 == r2) goto L1a
            if (r1 != r3) goto L12
            kotlin.ResultKt.b(r8)
            goto L64
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.b(r8)
            goto L4d
        L1e:
            kotlin.ResultKt.b(r8)
            int r8 = com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity.f16905l
            com.chuckerteam.chucker.internal.ui.transaction.TransactionViewModel r8 = r4.m()
            androidx.lifecycle.LiveData r8 = r8.f16971g
            java.lang.Object r8 = r8.d()
            com.chuckerteam.chucker.internal.data.entity.HttpTransaction r8 = (com.chuckerteam.chucker.internal.data.entity.HttpTransaction) r8
            if (r8 != 0) goto L42
            int r8 = com.chuckerteam.chucker.R.string.chucker_request_not_ready
            java.lang.String r8 = r4.getString(r8)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            com.chuckerteam.chucker.internal.ui.BaseChuckerActivity.l(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L42:
            r7.f16915a = r2
            kotlin.coroutines.jvm.internal.SuspendLambda r1 = r7.f16917c
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L4d
            goto L63
        L4d:
            com.chuckerteam.chucker.internal.support.Sharable r8 = (com.chuckerteam.chucker.internal.support.Sharable) r8
            kotlinx.coroutines.scheduling.DefaultScheduler r1 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r1 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$shareTransactionAsFile$1$shareIntent$1 r2 = new com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$shareTransactionAsFile$1$shareIntent$1
            java.lang.String r5 = r7.f16918d
            r6 = 0
            r2.<init>(r8, r4, r5, r6)
            r7.f16915a = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.e(r1, r2, r7)
            if (r8 != r0) goto L64
        L63:
            return r0
        L64:
            android.content.Intent r8 = (android.content.Intent) r8
            if (r8 == 0) goto L6c
            r4.startActivity(r8)
            goto L7a
        L6c:
            android.content.Context r8 = r4.getApplicationContext()
            int r0 = com.chuckerteam.chucker.R.string.chucker_export_no_file
            r1 = 0
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r0, r1)
            r8.show()
        L7a:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$shareTransactionAsFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
