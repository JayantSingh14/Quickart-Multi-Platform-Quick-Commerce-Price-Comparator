package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: classes.dex */
final class DistinctFlowImpl$collect$2<T> implements FlowCollector {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl f54484a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f54485b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f54486c;

    public DistinctFlowImpl$collect$2(DistinctFlowImpl distinctFlowImpl, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        this.f54484a = distinctFlowImpl;
        this.f54485b = objectRef;
        this.f54486c = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.f54489c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54489c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f54487a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54489c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r7)
            goto L56
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl r7 = r5.f54484a
            r7.getClass()
            kotlin.jvm.internal.Ref$ObjectRef r7 = r5.f54485b
            java.lang.Object r2 = r7.f53801a
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f55041a
            if (r2 == r4) goto L49
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r2, r6)
            if (r2 != 0) goto L46
            goto L49
        L46:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L49:
            r7.f53801a = r6
            r0.f54489c = r3
            kotlinx.coroutines.flow.FlowCollector r7 = r5.f54486c
            java.lang.Object r6 = r7.a(r6, r0)
            if (r6 != r1) goto L56
            return r1
        L56:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
