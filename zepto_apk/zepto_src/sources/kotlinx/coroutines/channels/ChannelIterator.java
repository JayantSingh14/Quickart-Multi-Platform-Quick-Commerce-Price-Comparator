package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes.dex */
public interface ChannelIterator<E> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Object b(Continuation continuation);

    Object next();
}
