package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) {
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5 = this;
            r0 = 0
            boolean r1 = r6 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r1 == 0) goto L14
            r1 = r6
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r1 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r1
            int r2 = r1.f54931c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L14
            int r2 = r2 - r3
            r1.f54931c = r2
            goto L19
        L14:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r1 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r1.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r1.f54929a
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r1.f54931c
            if (r1 == 0) goto L3a
            r2 = 1
            if (r1 == r2) goto L35
            r0 = 2
            if (r1 != r0) goto L2d
            kotlin.ResultKt.b(r6)
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L39
            throw r0
        L39:
            throw r0
        L3a:
            kotlin.ResultKt.b(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.b(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
