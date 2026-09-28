package com.chuckerteam.chucker.internal.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity$exportTransactions$1", f = "MainActivity.kt", l = {241, 247, Type.TKEY}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainActivity$exportTransactions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16860a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16861b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f16862c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f16863d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f16864e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MainActivity$exportTransactions$1(MainActivity mainActivity, Context context, Function2 function2, String str, Continuation continuation) {
        super(2, continuation);
        this.f16861b = mainActivity;
        this.f16862c = context;
        this.f16863d = (SuspendLambda) function2;
        this.f16864e = str;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainActivity$exportTransactions$1(this.f16861b, this.f16862c, this.f16863d, this.f16864e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivity$exportTransactions$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r10 != r0) goto L25;
     */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r9.f16860a
            java.lang.String r2 = "getString(...)"
            android.content.Context r3 = r9.f16862c
            r4 = 3
            r5 = 1
            r6 = 2
            com.chuckerteam.chucker.internal.ui.MainActivity r7 = r9.f16861b
            if (r1 == 0) goto L29
            if (r1 == r5) goto L25
            if (r1 == r6) goto L21
            if (r1 != r4) goto L19
            kotlin.ResultKt.b(r10)
            goto L87
        L19:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L21:
            kotlin.ResultKt.b(r10)
            goto L70
        L25:
            kotlin.ResultKt.b(r10)
            goto L4e
        L29:
            kotlin.ResultKt.b(r10)
            int r10 = com.chuckerteam.chucker.internal.ui.MainActivity.p
            androidx.lifecycle.ViewModelLazy r10 = r7.f16849j
            java.lang.Object r10 = r10.getValue()
            com.chuckerteam.chucker.internal.ui.MainViewModel r10 = (com.chuckerteam.chucker.internal.ui.MainViewModel) r10
            r9.f16860a = r5
            r10.getClass()
            com.chuckerteam.chucker.internal.data.repository.HttpTransactionRepository r10 = com.chuckerteam.chucker.internal.data.repository.RepositoryProvider.b()
            com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository r10 = (com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository) r10
            com.chuckerteam.chucker.internal.data.room.ChuckerDatabase r10 = r10.f16717a
            com.chuckerteam.chucker.internal.data.room.HttpTransactionDao r10 = r10.q()
            java.lang.Object r10 = r10.e(r9)
            if (r10 != r0) goto L4e
            goto L86
        L4e:
            java.util.List r10 = (java.util.List) r10
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L65
            int r10 = com.chuckerteam.chucker.R.string.chucker_export_empty_text
            java.lang.String r10 = r3.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            com.chuckerteam.chucker.internal.ui.BaseChuckerActivity.l(r7, r10)
            kotlin.Unit r10 = kotlin.Unit.f53572a
            return r10
        L65:
            r9.f16860a = r6
            kotlin.coroutines.jvm.internal.SuspendLambda r1 = r9.f16863d
            java.lang.Object r10 = r1.invoke(r10, r9)
            if (r10 != r0) goto L70
            goto L86
        L70:
            com.chuckerteam.chucker.internal.support.Sharable r10 = (com.chuckerteam.chucker.internal.support.Sharable) r10
            kotlinx.coroutines.scheduling.DefaultScheduler r1 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r1 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.chuckerteam.chucker.internal.ui.MainActivity$exportTransactions$1$shareIntent$1 r5 = new com.chuckerteam.chucker.internal.ui.MainActivity$exportTransactions$1$shareIntent$1
            java.lang.String r6 = r9.f16864e
            r8 = 0
            r5.<init>(r10, r7, r6, r8)
            r9.f16860a = r4
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.e(r1, r5, r9)
            if (r10 != r0) goto L87
        L86:
            return r0
        L87:
            android.content.Intent r10 = (android.content.Intent) r10
            if (r10 == 0) goto L8f
            r7.startActivity(r10)
            goto L9b
        L8f:
            int r10 = com.chuckerteam.chucker.R.string.chucker_export_no_file
            java.lang.String r10 = r3.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            com.chuckerteam.chucker.internal.ui.BaseChuckerActivity.l(r7, r10)
        L9b:
            kotlin.Unit r10 = kotlin.Unit.f53572a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.MainActivity$exportTransactions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
