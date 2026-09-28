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
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToOne$1$1", f = "FlowExtensions.kt", l = {Type.CDS}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FlowQuery$mapToOne$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13132a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Query f13133b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowQuery$mapToOne$1$1(Query query, Continuation continuation) {
        super(2, continuation);
        this.f13133b = query;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowQuery$mapToOne$1$1(this.f13133b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowQuery$mapToOne$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f13132a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        this.f13132a = 1;
        Object objB = QueryExtensionsKt.b(this.f13133b, this);
        return objB == coroutineSingletons ? coroutineSingletons : objB;
    }
}
