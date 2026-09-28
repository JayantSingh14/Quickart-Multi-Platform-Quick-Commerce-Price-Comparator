package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.async.coroutines.QueryExtensionsKt;
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
@DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$1$1", f = "FlowExtensions.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FlowQuery$mapToOneNotNull$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13134a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Query f13135b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowQuery$mapToOneNotNull$1$1(Query query, Continuation continuation) {
        super(2, continuation);
        this.f13135b = query;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowQuery$mapToOneNotNull$1$1(this.f13135b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowQuery$mapToOneNotNull$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f13134a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        this.f13134a = 1;
        Object objC = QueryExtensionsKt.c(this.f13135b, this);
        return objC == coroutineSingletons ? coroutineSingletons : objC;
    }
}
