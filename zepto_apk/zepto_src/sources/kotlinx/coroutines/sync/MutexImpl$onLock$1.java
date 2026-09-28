package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexImpl.SelectInstanceWithOwner;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<MutexImpl, SelectInstance<?>, Object, Unit> {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int andDecrement;
        MutexImpl mutexImpl = (MutexImpl) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        if (obj3 != null) {
            while (true) {
                if (!mutexImpl.e()) {
                    break;
                }
                Object obj4 = MutexImpl.f55229h.get(mutexImpl);
                if (obj4 != MutexKt.f55235a) {
                    if (obj4 == obj3) {
                        selectInstance.c(MutexKt.f55236b);
                    }
                }
            }
        } else {
            mutexImpl.getClass();
        }
        Intrinsics.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        MutexImpl.SelectInstanceWithOwner selectInstanceWithOwner = mutexImpl.new SelectInstanceWithOwner((SelectInstanceInternal) selectInstance, obj3);
        while (true) {
            mutexImpl.getClass();
            do {
                andDecrement = SemaphoreAndMutexImpl.f55243g.getAndDecrement(mutexImpl);
            } while (andDecrement > mutexImpl.f55244a);
            if (andDecrement > 0) {
                selectInstanceWithOwner.c(Unit.f53572a);
                break;
            }
            if (mutexImpl.d(selectInstanceWithOwner)) {
                break;
            }
        }
        return Unit.f53572a;
    }
}
