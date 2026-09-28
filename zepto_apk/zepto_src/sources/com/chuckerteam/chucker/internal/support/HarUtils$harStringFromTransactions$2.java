package com.chuckerteam.chucker.internal.support;

import com.chuckerteam.chucker.internal.data.har.Har;
import com.chuckerteam.chucker.internal.data.har.log.Creator;
import com.google.gson.Gson;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$2", f = "HarUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HarUtils$harStringFromTransactions$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f16769a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16770b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16771c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HarUtils$harStringFromTransactions$2(List list, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f16769a = list;
        this.f16770b = str;
        this.f16771c = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HarUtils$harStringFromTransactions$2(this.f16769a, this.f16770b, this.f16771c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HarUtils$harStringFromTransactions$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        Object value = JsonConverter.f16772a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        Creator creator = new Creator(this.f16770b, this.f16771c);
        List transactions = this.f16769a;
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        Intrinsics.checkNotNullParameter(creator, "creator");
        return ((Gson) value).j(new Har(transactions, creator));
    }
}
