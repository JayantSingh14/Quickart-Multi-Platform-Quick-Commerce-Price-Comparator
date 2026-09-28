package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = "first")
/* loaded from: classes.dex */
final class FlowKt__ReduceKt$first$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54749a;

    /* renamed from: b, reason: collision with root package name */
    public FlowKt__ReduceKt$first$$inlined$collectWhile$1 f54750b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54751c;

    /* renamed from: d, reason: collision with root package name */
    public int f54752d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54751c = obj;
        this.f54752d |= Integer.MIN_VALUE;
        return FlowKt.i(null, this);
    }
}
