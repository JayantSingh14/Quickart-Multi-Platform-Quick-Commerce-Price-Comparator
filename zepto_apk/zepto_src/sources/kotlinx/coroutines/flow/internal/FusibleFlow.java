package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface FusibleFlow<T> extends Flow<T> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Flow b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow);
}
