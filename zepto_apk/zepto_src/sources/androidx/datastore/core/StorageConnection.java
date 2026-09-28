package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: classes.dex */
public interface StorageConnection<T> extends Closeable {
    Object b(Function3 function3, ContinuationImpl continuationImpl);

    Object c(Function2 function2, ContinuationImpl continuationImpl);

    InterProcessCoordinator e();
}
