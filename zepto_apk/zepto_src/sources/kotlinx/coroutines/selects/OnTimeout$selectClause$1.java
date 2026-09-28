package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<OnTimeout, SelectInstance<?>, Object, Unit> {

    /* renamed from: b, reason: collision with root package name */
    public static final OnTimeout$selectClause$1 f55173b = new OnTimeout$selectClause$1(3, OnTimeout.class, CLConstants.CRED_SUB_TYPE_MANDATE_REGISTER, "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        final OnTimeout onTimeout = (OnTimeout) obj;
        final SelectInstance selectInstance = (SelectInstance) obj2;
        long j2 = onTimeout.f55170a;
        if (j2 <= 0) {
            selectInstance.c(Unit.f53572a);
        } else {
            Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.selects.OnTimeout$register$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    selectInstance.e(onTimeout, Unit.f53572a);
                }
            };
            Intrinsics.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            SelectImplementation selectImplementation = (SelectImplementation) selectInstance;
            CoroutineContext coroutineContext = selectImplementation.f55184a;
            selectImplementation.f55186c = DelayKt.b(coroutineContext).b(j2, runnable, coroutineContext);
        }
        return Unit.f53572a;
    }
}
