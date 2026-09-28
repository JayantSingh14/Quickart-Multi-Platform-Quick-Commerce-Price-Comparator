package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
public interface Semaphore {
    Object a(ContinuationImpl continuationImpl);

    void release();
}
