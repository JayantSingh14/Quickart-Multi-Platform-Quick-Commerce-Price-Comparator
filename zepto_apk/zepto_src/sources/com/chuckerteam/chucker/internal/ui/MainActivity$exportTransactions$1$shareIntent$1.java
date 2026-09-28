package com.chuckerteam.chucker.internal.ui;

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
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity$exportTransactions$1$shareIntent$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainActivity$exportTransactions$1$shareIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Intent>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sharable f16865a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16866b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16867c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$exportTransactions$1$shareIntent$1(Sharable sharable, MainActivity mainActivity, String str, Continuation continuation) {
        super(2, continuation);
        this.f16865a = sharable;
        this.f16866b = mainActivity;
        this.f16867c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainActivity$exportTransactions$1$shareIntent$1(this.f16865a, this.f16866b, this.f16867c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivity$exportTransactions$1$shareIntent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        int i2 = R.string.chucker_share_all_transactions_title;
        MainActivity mainActivity = this.f16866b;
        String string = mainActivity.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.f16866b.getString(R.string.chucker_share_all_transactions_subject);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return SharableKt.a(this.f16865a, mainActivity, this.f16867c, string, string2, "transactions");
    }
}
