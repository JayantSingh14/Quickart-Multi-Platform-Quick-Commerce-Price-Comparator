package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class CancellableFlowImpl$collect$2<T> implements FlowCollector {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r4, kotlin.coroutines.Continuation r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof kotlinx.coroutines.flow.CancellableFlowImpl$collect$2$emit$1
            if (r4 == 0) goto L13
            r4 = r5
            kotlinx.coroutines.flow.CancellableFlowImpl$collect$2$emit$1 r4 = (kotlinx.coroutines.flow.CancellableFlowImpl$collect$2$emit$1) r4
            int r0 = r4.f54480c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.f54480c = r0
            goto L18
        L13:
            kotlinx.coroutines.flow.CancellableFlowImpl$collect$2$emit$1 r4 = new kotlinx.coroutines.flow.CancellableFlowImpl$collect$2$emit$1
            r4.<init>(r3, r5)
        L18:
            java.lang.Object r5 = r4.f54478a
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r4.f54480c
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            kotlin.ResultKt.b(r5)
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            kotlin.coroutines.CoroutineContext r5 = r4.getContext()
            kotlinx.coroutines.JobKt.d(r5)
            r4.f54480c = r1
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CancellableFlowImpl$collect$2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
