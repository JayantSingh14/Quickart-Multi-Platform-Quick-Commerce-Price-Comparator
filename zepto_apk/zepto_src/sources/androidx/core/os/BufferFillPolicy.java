package androidx.core.os;

import androidx.annotation.RequiresApi;
import kotlin.Metadata;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
public abstract class BufferFillPolicy {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Discard extends BufferFillPolicy {
    }

    @Metadata
    public static final class RingBuffer extends BufferFillPolicy {
    }

    static {
        new Discard();
        new RingBuffer();
    }
}
