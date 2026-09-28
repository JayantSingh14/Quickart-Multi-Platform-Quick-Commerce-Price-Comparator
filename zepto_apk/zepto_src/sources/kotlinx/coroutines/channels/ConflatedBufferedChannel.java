package kotlinx.coroutines.channels;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {

    /* renamed from: k, reason: collision with root package name */
    public final BufferOverflow f54420k;

    public ConflatedBufferedChannel(int i2, BufferOverflow bufferOverflow) {
        super(i2);
        this.f54420k = bufferOverflow;
        if (bufferOverflow != BufferOverflow.f54203a) {
            if (i2 < 1) {
                throw new IllegalArgumentException(b.g(i2, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.a(BufferedChannel.class).i() + " instead").toString());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean G() {
        return this.f54420k == BufferOverflow.f54204b;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void N(SelectInstance selectInstance, Object obj) {
        Object objW = W(obj, false);
        if (!(objW instanceof ChannelResult.Failed)) {
            selectInstance.c(Unit.f53572a);
        } else {
            if (!(objW instanceof ChannelResult.Closed)) {
                throw new IllegalStateException("unreachable");
            }
            ChannelResult.a(objW);
            selectInstance.c(BufferedChannelKt.f54246l);
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final Object P(Object obj, Continuation continuation) {
        Object objW = W(obj, true);
        if (objW instanceof ChannelResult.Failed) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean Q() {
        return false;
    }

    public final Object W(Object obj, boolean z) {
        ChannelSegment channelSegment;
        ConflatedBufferedChannel<E> conflatedBufferedChannel;
        Object obj2;
        if (this.f54420k == BufferOverflow.f54205c) {
            Object objI = super.i(obj);
            ChannelResult.Failed failed = ChannelResult.f54254b;
            return (!(objI instanceof ChannelResult.Failed) || (objI instanceof ChannelResult.Closed)) ? objI : Unit.f53572a;
        }
        Object obj3 = BufferedChannelKt.f54238d;
        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.f54212f.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f54208b.getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zD = D(andIncrement, false);
            long j3 = BufferedChannelKt.f54236b;
            long j4 = j2 / j3;
            int i2 = (int) (j2 % j3);
            if (channelSegment2.f55105c != j4) {
                ChannelSegment channelSegmentA = BufferedChannel.a(this, j4, channelSegment2);
                if (channelSegmentA != null) {
                    channelSegment = channelSegmentA;
                    obj2 = obj;
                    conflatedBufferedChannel = this;
                } else if (zD) {
                    ChannelResult.Failed failed2 = ChannelResult.f54254b;
                    return ChannelResult.Companion.a(z());
                }
            } else {
                channelSegment = channelSegment2;
                conflatedBufferedChannel = this;
                obj2 = obj;
            }
            int iN = BufferedChannel.n(conflatedBufferedChannel, channelSegment, i2, obj2, j2, obj3, zD);
            channelSegment2 = channelSegment;
            if (iN == 0) {
                channelSegment2.a();
                ChannelResult.Failed failed3 = ChannelResult.f54254b;
                return Unit.f53572a;
            }
            if (iN == 1) {
                ChannelResult.Failed failed4 = ChannelResult.f54254b;
                return Unit.f53572a;
            }
            if (iN == 2) {
                if (zD) {
                    channelSegment2.i();
                    ChannelResult.Failed failed5 = ChannelResult.f54254b;
                    return ChannelResult.Companion.a(z());
                }
                Waiter waiter = obj3 instanceof Waiter ? (Waiter) obj3 : null;
                if (waiter != null) {
                    BufferedChannel.f(this, waiter, channelSegment2, i2);
                }
                u((channelSegment2.f55105c * j3) + i2);
                ChannelResult.Failed failed6 = ChannelResult.f54254b;
                return Unit.f53572a;
            }
            if (iN == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iN == 4) {
                if (j2 < BufferedChannel.f54209c.get(this)) {
                    channelSegment2.a();
                }
                ChannelResult.Failed failed7 = ChannelResult.f54254b;
                return ChannelResult.Companion.a(z());
            }
            if (iN == 5) {
                channelSegment2.a();
            }
            obj = obj2;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object i(Object obj) {
        return W(obj, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object o(Object obj, Continuation continuation) throws Throwable {
        Object objW = W(obj, true);
        if (!(objW instanceof ChannelResult.Closed)) {
            return Unit.f53572a;
        }
        ChannelResult.a(objW);
        throw z();
    }
}
