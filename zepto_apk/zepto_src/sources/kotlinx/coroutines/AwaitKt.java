package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitAll;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AwaitKt {
    public static final Object a(Collection collection, SuspendLambda frame) {
        if (collection.isEmpty()) {
            return EmptyList.f53609a;
        }
        Deferred[] deferredArr = (Deferred[]) collection.toArray(new Deferred[0]);
        AwaitAll awaitAll = new AwaitAll(deferredArr);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        int length = deferredArr.length;
        AwaitAll.AwaitAllNode[] awaitAllNodeArr = new AwaitAll.AwaitAllNode[length];
        for (int i2 = 0; i2 < length; i2++) {
            Deferred deferred = deferredArr[i2];
            deferred.start();
            AwaitAll.AwaitAllNode awaitAllNode = new AwaitAll.AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.f54042f = JobKt.f(deferred, awaitAllNode);
            Unit unit = Unit.f53572a;
            awaitAllNodeArr[i2] = awaitAllNode;
        }
        AwaitAll.DisposeHandlersOnCancel disposeHandlersOnCancel = new AwaitAll.DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i3 = 0; i3 < length; i3++) {
            AwaitAll.AwaitAllNode awaitAllNode2 = awaitAllNodeArr[i3];
            awaitAllNode2.getClass();
            AwaitAll.AwaitAllNode.f54040h.set(awaitAllNode2, disposeHandlersOnCancel);
        }
        if (CancellableContinuationImpl.f54059g.get(cancellableContinuationImpl) instanceof NotCompleted) {
            cancellableContinuationImpl.v(disposeHandlersOnCancel);
        } else {
            disposeHandlersOnCancel.a();
        }
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }
}
