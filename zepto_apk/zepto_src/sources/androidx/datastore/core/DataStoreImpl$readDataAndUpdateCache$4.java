package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, 309}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$readDataAndUpdateCache$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Pair<? extends State<Object>, ? extends Boolean>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f3487a;

    /* renamed from: b, reason: collision with root package name */
    public int f3488b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f3489c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3490d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3491e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl dataStoreImpl, int i2, Continuation continuation) {
        super(2, continuation);
        this.f3490d = dataStoreImpl;
        this.f3491e = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.f3490d, this.f3491e, continuation);
        dataStoreImpl$readDataAndUpdateCache$4.f3489c = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(bool, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        int iIntValue;
        boolean z;
        State state;
        boolean z2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        boolean z3 = this.f3488b;
        DataStoreImpl dataStoreImpl = this.f3490d;
        try {
        } catch (Throwable th2) {
            if (z3 != 0) {
                InterProcessCoordinator interProcessCoordinatorG = dataStoreImpl.g();
                this.f3487a = th2;
                this.f3489c = z3;
                this.f3488b = 2;
                Object objC = interProcessCoordinatorG.c(this);
                if (objC != coroutineSingletons) {
                    z = z3;
                    th = th2;
                    obj = objC;
                }
            } else {
                boolean z4 = z3;
                th = th2;
                iIntValue = this.f3491e;
                z = z4;
            }
        }
        if (z3 == 0) {
            ResultKt.b(obj);
            boolean z5 = this.f3489c;
            this.f3489c = z5;
            this.f3488b = 1;
            obj = DataStoreImpl.f(dataStoreImpl, z5, this);
            z3 = z5;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (z3 != 1) {
                if (z3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.f3489c;
                th = this.f3487a;
                ResultKt.b(obj);
                iIntValue = ((Number) obj).intValue();
                ReadException readException = new ReadException(iIntValue, th);
                z2 = z;
                state = readException;
                return new Pair(state, Boolean.valueOf(z2));
            }
            boolean z6 = this.f3489c;
            ResultKt.b(obj);
            z3 = z6;
        }
        state = (State) obj;
        z2 = z3;
        return new Pair(state, Boolean.valueOf(z2));
    }
}
