package kotlinx.coroutines.channels;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlinx.coroutines.channels.Channel;

@Metadata
/* loaded from: classes.dex */
public final class ChannelKt {
    public static BufferedChannel a(int i2, BufferOverflow bufferOverflow, int i3) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.f54203a;
        }
        if (i2 == -2) {
            if (bufferOverflow != BufferOverflow.f54203a) {
                return new ConflatedBufferedChannel(1, bufferOverflow);
            }
            Channel.z0.getClass();
            return new BufferedChannel(Channel.Factory.a());
        }
        if (i2 != -1) {
            return i2 != 0 ? i2 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.f54203a ? new BufferedChannel(i2) : new ConflatedBufferedChannel(i2, bufferOverflow) : new BufferedChannel(Api.BaseClientBuilder.API_PRIORITY_OTHER) : bufferOverflow == BufferOverflow.f54203a ? new BufferedChannel(0) : new ConflatedBufferedChannel(1, bufferOverflow);
        }
        if (bufferOverflow == BufferOverflow.f54203a) {
            return new ConflatedBufferedChannel(1, BufferOverflow.f54204b);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }
}
