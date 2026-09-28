package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {32, 33}, m = "emitAllImpl$FlowKt__ChannelsKt")
/* loaded from: classes.dex */
final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FlowCollector f54541a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54542b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54543c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f54544d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54545e;

    /* renamed from: f, reason: collision with root package name */
    public int f54546f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54545e = obj;
        this.f54546f |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.a(null, null, false, this);
    }
}
