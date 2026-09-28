package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", l = {298, 300}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$readDataAndUpdateCache$3 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends State<Object>, ? extends Boolean>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f3484a;

    /* renamed from: b, reason: collision with root package name */
    public int f3485b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3486c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$3(DataStoreImpl dataStoreImpl, Continuation continuation) {
        super(1, continuation);
        this.f3486c = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$readDataAndUpdateCache$3(this.f3486c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((DataStoreImpl$readDataAndUpdateCache$3) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        State readException;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f3485b;
        DataStoreImpl dataStoreImpl = this.f3486c;
        try {
        } catch (Throwable th2) {
            InterProcessCoordinator interProcessCoordinatorG = dataStoreImpl.g();
            this.f3484a = th2;
            this.f3485b = 2;
            Object objC = interProcessCoordinatorG.c(this);
            if (objC != coroutineSingletons) {
                th = th2;
                obj = objC;
            }
        }
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f3485b = 1;
            obj = DataStoreImpl.f(dataStoreImpl, true, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = this.f3484a;
                ResultKt.b(obj);
                readException = new ReadException(((Number) obj).intValue(), th);
                return new Pair(readException, Boolean.TRUE);
            }
            ResultKt.b(obj);
        }
        readException = (State) obj;
        return new Pair(readException, Boolean.TRUE);
    }
}
