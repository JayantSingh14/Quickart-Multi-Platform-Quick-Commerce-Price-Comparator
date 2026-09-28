package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    SendChannel b();
}
