package app.cash.sqldelight.async.coroutines;

import app.cash.sqldelight.db.AfterVersion;
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
@DebugMetadata(c = "app.cash.sqldelight.async.coroutines.SynchronousKt$synchronous$1$migrate$1", f = "Synchronous.kt", l = {24}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class SynchronousKt$synchronous$1$migrate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidSqliteDriver f13101a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f13102b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f13103c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AfterVersion[] f13104d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SynchronousKt$synchronous$1$migrate$1(AndroidSqliteDriver androidSqliteDriver, long j2, long j3, AfterVersion[] afterVersionArr, Continuation continuation) {
        super(2, continuation);
        this.f13101a = androidSqliteDriver;
        this.f13102b = j2;
        this.f13103c = j3;
        this.f13104d = afterVersionArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SynchronousKt$synchronous$1$migrate$1(this.f13101a, this.f13102b, this.f13103c, this.f13104d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SynchronousKt$synchronous$1$migrate$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        AfterVersion[] afterVersionArr = this.f13104d;
        throw null;
    }
}
