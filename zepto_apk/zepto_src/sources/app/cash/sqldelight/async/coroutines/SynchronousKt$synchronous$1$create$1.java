package app.cash.sqldelight.async.coroutines;

import app.cash.sqldelight.driver.android.AndroidSqliteDriver;
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
@DebugMetadata(c = "app.cash.sqldelight.async.coroutines.SynchronousKt$synchronous$1$create$1", f = "Synchronous.kt", l = {14}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class SynchronousKt$synchronous$1$create$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidSqliteDriver f13100a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SynchronousKt$synchronous$1$create$1(AndroidSqliteDriver androidSqliteDriver, Continuation continuation) {
        super(2, continuation);
        this.f13100a = androidSqliteDriver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SynchronousKt$synchronous$1$create$1(this.f13100a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SynchronousKt$synchronous$1$create$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        throw null;
    }
}
