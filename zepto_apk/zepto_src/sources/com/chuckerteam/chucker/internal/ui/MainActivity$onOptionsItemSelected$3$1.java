package com.chuckerteam.chucker.internal.ui;

import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.HarUtils;
import com.chuckerteam.chucker.internal.support.Sharable;
import com.chuckerteam.chucker.internal.support.TransactionDetailsHarSharable;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity$onOptionsItemSelected$3$1", f = "MainActivity.kt", l = {199}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainActivity$onOptionsItemSelected$3$1 extends SuspendLambda implements Function2<List<? extends HttpTransaction>, Continuation<? super Sharable>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16869a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16870b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16871c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$onOptionsItemSelected$3$1(MainActivity mainActivity, Continuation continuation) {
        super(2, continuation);
        this.f16871c = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MainActivity$onOptionsItemSelected$3$1 mainActivity$onOptionsItemSelected$3$1 = new MainActivity$onOptionsItemSelected$3$1(this.f16871c, continuation);
        mainActivity$onOptionsItemSelected$3$1.f16870b = obj;
        return mainActivity$onOptionsItemSelected$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivity$onOptionsItemSelected$3$1) create((List) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16869a;
        if (i2 == 0) {
            ResultKt.b(obj);
            List list = (List) this.f16870b;
            HarUtils harUtils = HarUtils.f16765a;
            int i3 = R.string.chucker_name;
            MainActivity mainActivity = this.f16871c;
            String string = mainActivity.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = mainActivity.getString(R.string.chucker_version);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.f16869a = 1;
            obj = harUtils.a(list, string, string2, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return new TransactionDetailsHarSharable((String) obj);
    }
}
