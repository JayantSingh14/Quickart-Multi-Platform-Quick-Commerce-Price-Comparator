package kotlinx.coroutines.channels;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", l = {179}, m = "send")
/* loaded from: classes3.dex */
final class BroadcastChannelImpl$send$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public BroadcastChannelImpl f54193a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54194b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f54195c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54196d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BroadcastChannelImpl f54197e;

    /* renamed from: f, reason: collision with root package name */
    public int f54198f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$send$1(BroadcastChannelImpl broadcastChannelImpl, Continuation continuation) {
        super(continuation);
        this.f54197e = broadcastChannelImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54196d = obj;
        this.f54198f |= Integer.MIN_VALUE;
        return this.f54197e.o(null, this);
    }
}
