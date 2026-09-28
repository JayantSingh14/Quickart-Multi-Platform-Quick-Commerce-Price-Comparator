package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = "first")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$first$3<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function2 f54753a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.ObjectRef f54754b;

    /* renamed from: c, reason: collision with root package name */
    public FlowKt__ReduceKt$first$$inlined$collectWhile$2 f54755c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54756d;

    /* renamed from: e, reason: collision with root package name */
    public int f54757e;

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            r5.f54756d = r6
            int r6 = r5.f54757e
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 | r0
            r5.f54757e = r6
            r1 = r6 & r0
            if (r1 == 0) goto L12
            int r6 = r6 - r0
            r5.f54757e = r6
            r6 = r5
            goto L17
        L12:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r6 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r6.<init>(r5)
        L17:
            java.lang.Object r0 = r6.f54756d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f54757e
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f55041a
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 != r3) goto L30
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r1 = r6.f54755c
            kotlin.jvm.internal.Ref$ObjectRef r3 = r6.f54754b
            kotlin.jvm.functions.Function2 r6 = r6.f54753a
            kotlin.ResultKt.b(r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2e
            goto L59
        L2e:
            r0 = move-exception
            goto L55
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r0.f53801a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r4 = 0
            r1.<init>(r4, r0)
            r6.f54753a = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r6.f54754b = r0     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r6.f54755c = r1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r6.f54757e = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            throw r4
        L51:
            r6 = move-exception
            r3 = r0
            r0 = r6
            r6 = r4
        L55:
            java.lang.Object r4 = r0.f54937a
            if (r4 != r1) goto L72
        L59:
            java.lang.Object r0 = r3.f53801a
            if (r0 == r2) goto L5e
            return r0
        L5e:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected at least one element matching the predicate "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L72:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
