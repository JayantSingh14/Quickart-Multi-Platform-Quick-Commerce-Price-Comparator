package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: classes.dex */
public final class FlowKt {
    public static final Flow a(Function2 function2) {
        return new CallbackFlowBuilder(function2);
    }

    public static final FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 b(Flow flow, Function3 function3) {
        return FlowKt__ErrorsKt.a(flow, function3);
    }

    public static final Flow c(Flow flow) {
        return FlowKt__ContextKt.a(flow);
    }

    public static final Flow d(Flow flow, long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Debounce timeout should not be negative");
        }
        if (j2 == 0) {
            return flow;
        }
        final FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(new a(j2), flow, null);
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object c(FlowCollector flowCollector, Continuation frame) {
                FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(flowKt__DelayKt$debounceInternal$1, flowCollector, null);
                FlowCoroutine flowCoroutine = new FlowCoroutine(frame, frame.getContext());
                Object objA = UndispatchedKt.a(flowCoroutine, flowCoroutine, flowCoroutineKt$scopedFlow$1$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                if (objA == coroutineSingletons) {
                    Intrinsics.checkNotNullParameter(frame, "frame");
                }
                return objA == coroutineSingletons ? objA : Unit.f53572a;
            }
        };
    }

    public static final Flow e(Flow flow) {
        if (flow instanceof StateFlow) {
            return flow;
        }
        if (!(flow instanceof DistinctFlowImpl)) {
            return new DistinctFlowImpl(flow);
        }
        ((DistinctFlowImpl) flow).getClass();
        return flow;
    }

    public static final FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 f(FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1, Function2 function2) {
        return FlowKt__LimitKt.a(function2, flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1);
    }

    public static final Object g(FlowCollector flowCollector, ReceiveChannel receiveChannel, SuspendLambda suspendLambda) {
        Object objA = FlowKt__ChannelsKt.a(flowCollector, receiveChannel, true, suspendLambda);
        return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
    }

    public static final Object h(FlowCollector flowCollector, FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1, Continuation continuation) {
        return FlowKt__CollectKt.a((ContinuationImpl) continuation, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1, flowCollector);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(kotlinx.coroutines.flow.Flow r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r0
            int r1 = r0.f54752d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54752d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f54751c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54752d
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f55041a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1 r5 = r0.f54750b
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.f54749a
            kotlin.ResultKt.b(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L5d
        L2d:
            r6 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r6.f53801a = r3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
            r2.<init>()
            r0.f54749a = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            r0.f54750b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            r0.f54752d = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            java.lang.Object r5 = r5.c(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            if (r5 != r1) goto L53
            return r1
        L53:
            r0 = r6
            goto L5d
        L55:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L59:
            java.lang.Object r1 = r6.f54937a
            if (r1 != r5) goto L6a
        L5d:
            java.lang.Object r5 = r0.f53801a
            if (r5 == r3) goto L62
            return r5
        L62:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L6a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.i(kotlinx.coroutines.flow.Flow, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(kotlinx.coroutines.flow.Flow r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) r0
            int r1 = r0.f54761d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54761d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f54760c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54761d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 r4 = r0.f54759b
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.f54758a
            kotlin.ResultKt.b(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2b
            goto L59
        L2b:
            r5 = move-exception
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
            r2.<init>()
            r0.f54758a = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.f54759b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.f54761d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            java.lang.Object r4 = r4.c(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r0 = r5
            goto L59
        L51:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L55:
            java.lang.Object r1 = r5.f54937a
            if (r1 != r4) goto L5c
        L59:
            java.lang.Object r4 = r0.f53801a
            return r4
        L5c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.j(kotlinx.coroutines.flow.Flow, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(kotlinx.coroutines.flow.Flow r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) r0
            int r1 = r0.f54765d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54765d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f54764c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54765d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = r0.f54763b
            kotlin.jvm.internal.Ref$ObjectRef r5 = r0.f54762a
            kotlin.ResultKt.b(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2b
            goto L59
        L2b:
            r6 = move-exception
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f54762a = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.f54763b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.f54765d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            java.lang.Object r4 = r4.c(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r5 = r6
            goto L59
        L51:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L55:
            java.lang.Object r0 = r6.f54937a
            if (r0 != r4) goto L5c
        L59:
            java.lang.Object r4 = r5.f53801a
            return r4
        L5c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.k(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Flow l(Function2 function2) {
        return new SafeFlow(function2);
    }

    public static final Flow m(ReceiveChannel receiveChannel) {
        return new ChannelAsFlow(receiveChannel, EmptyCoroutineContext.f53685a, -3, BufferOverflow.f54203a);
    }

    public static final FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 n(FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1, Function2 function2) {
        return FlowKt__LimitKt.b(flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1, function2);
    }
}
