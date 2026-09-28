package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", l = {62}, m = "emit")
/* loaded from: classes3.dex */
final class ChannelFlowMerge$collectTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f54956a;

    /* renamed from: b, reason: collision with root package name */
    public Flow f54957b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54958c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ChannelFlowMerge$collectTo$2 f54959d;

    /* renamed from: e, reason: collision with root package name */
    public int f54960e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowMerge$collectTo$2$emit$1(ChannelFlowMerge$collectTo$2 channelFlowMerge$collectTo$2, Continuation continuation) {
        super(continuation);
        this.f54959d = channelFlowMerge$collectTo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54958c = obj;
        this.f54960e |= Integer.MIN_VALUE;
        return this.f54959d.a(null, this);
    }
}
