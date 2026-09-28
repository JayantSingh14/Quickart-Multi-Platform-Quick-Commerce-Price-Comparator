package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
public interface Mutex {

    @Metadata
    public static final class DefaultImpls {
    }

    void b(Object obj);

    Object c(ContinuationImpl continuationImpl);
}
