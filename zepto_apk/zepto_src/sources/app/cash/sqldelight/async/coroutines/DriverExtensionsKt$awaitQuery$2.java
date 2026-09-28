package app.cash.sqldelight.async.coroutines;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class DriverExtensionsKt$awaitQuery$2 extends Lambda implements Function1<SqlCursor, QueryResult<Object>> {

    @Metadata
    @DebugMetadata(c = "app.cash.sqldelight.async.coroutines.DriverExtensionsKt$awaitQuery$2$1", f = "DriverExtensions.kt", l = {15}, m = "invokeSuspend")
    /* renamed from: app.cash.sqldelight.async.coroutines.DriverExtensionsKt$awaitQuery$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f13083a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SqlCursor f13084b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SqlCursor sqlCursor, Continuation continuation) {
            super(1, continuation);
            this.f13084b = sqlCursor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f13084b, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) create((Continuation) obj);
            Unit unit = Unit.f53572a;
            anonymousClass1.invokeSuspend(unit);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f13083a;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f13083a = 1;
                throw null;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SqlCursor it = (SqlCursor) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        AnonymousClass1 getter = new AnonymousClass1(it, null);
        Intrinsics.checkNotNullParameter(getter, "getter");
        return new QueryResult.AsyncValue(getter);
    }
}
