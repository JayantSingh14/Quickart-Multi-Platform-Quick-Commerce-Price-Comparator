package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata
/* loaded from: classes.dex */
public interface ReceiveChannel<E> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    void e(CancellationException cancellationException);

    Object g(ContinuationImpl continuationImpl);

    ChannelIterator iterator();

    SelectClause1 j();

    SelectClause1 k();

    Object m();
}
