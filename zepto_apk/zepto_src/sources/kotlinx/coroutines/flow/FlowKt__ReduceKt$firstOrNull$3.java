package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = "firstOrNull")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$firstOrNull$3<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54762a;

    /* renamed from: b, reason: collision with root package name */
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 f54763b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54764c;

    /* renamed from: d, reason: collision with root package name */
    public int f54765d;

    public FlowKt__ReduceKt$firstOrNull$3(ContinuationImpl continuationImpl) {
        super(continuationImpl);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54764c = obj;
        this.f54765d |= Integer.MIN_VALUE;
        return FlowKt.k(null, null, this);
    }
}
