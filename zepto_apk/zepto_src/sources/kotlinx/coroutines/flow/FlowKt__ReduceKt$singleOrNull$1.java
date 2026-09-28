package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = "singleOrNull")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$singleOrNull$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54787a;

    /* renamed from: b, reason: collision with root package name */
    public FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 f54788b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54789c;

    /* renamed from: d, reason: collision with root package name */
    public int f54790d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            r6.f54789c = r7
            int r0 = r6.f54790d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r6.f54790d = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f55041a
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L26
            if (r0 != r3) goto L1e
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 r0 = r6.f54788b
            kotlin.jvm.internal.Ref$ObjectRef r3 = r6.f54787a
            kotlin.ResultKt.b(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L1c
            goto L44
        L1c:
            r7 = move-exception
            goto L40
        L1e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L26:
            kotlin.ResultKt.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.f53801a = r1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
            r0.<init>()
            r6.f54787a = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3c
            r6.f54788b = r0     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3c
            r6.f54790d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L3c
            throw r2
        L3c:
            r3 = move-exception
            r5 = r3
            r3 = r7
            r7 = r5
        L40:
            java.lang.Object r4 = r7.f54937a
            if (r4 != r0) goto L4b
        L44:
            java.lang.Object r7 = r3.f53801a
            if (r7 != r1) goto L49
            goto L4a
        L49:
            r2 = r7
        L4a:
            return r2
        L4b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
