package com.chuckerteam.chucker.internal.ui;

import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.Sharable;
import com.chuckerteam.chucker.internal.support.TransactionListDetailsSharable;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity$onOptionsItemSelected$2$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainActivity$onOptionsItemSelected$2$1 extends SuspendLambda implements Function2<List<? extends HttpTransaction>, Continuation<? super Sharable>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f16868a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MainActivity$onOptionsItemSelected$2$1 mainActivity$onOptionsItemSelected$2$1 = new MainActivity$onOptionsItemSelected$2$1(2, continuation);
        mainActivity$onOptionsItemSelected$2$1.f16868a = obj;
        return mainActivity$onOptionsItemSelected$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivity$onOptionsItemSelected$2$1) create((List) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        return new TransactionListDetailsSharable((List) this.f16868a);
    }
}
