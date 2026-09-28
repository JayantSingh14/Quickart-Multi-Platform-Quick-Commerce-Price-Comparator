package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {26}, m = "emit")
/* loaded from: classes3.dex */
final class ChannelFlowTransformLatest$flowCollect$3$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f54978a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54979b;

    /* renamed from: c, reason: collision with root package name */
    public Job f54980c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54981d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1 f54982e;

    /* renamed from: f, reason: collision with root package name */
    public int f54983f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3$1$emit$1(ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f54982e = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54981d = obj;
        this.f54983f |= Integer.MIN_VALUE;
        return this.f54982e.a(null, this);
    }
}
