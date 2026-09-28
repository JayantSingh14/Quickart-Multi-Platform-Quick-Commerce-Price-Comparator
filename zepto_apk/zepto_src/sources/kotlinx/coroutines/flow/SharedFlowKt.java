package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SharedFlowKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f54894a = new Symbol("NO_VALUE");

    public static final void a(Object[] objArr, long j2, Object obj) {
        objArr[((int) j2) & (objArr.length - 1)] = obj;
    }

    public static final Flow b(SharedFlow sharedFlow, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return ((i2 == 0 || i2 == -3) && bufferOverflow == BufferOverflow.f54203a) ? sharedFlow : new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i2, bufferOverflow);
    }
}
