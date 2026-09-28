package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata
/* loaded from: classes.dex */
public interface DataStore<T> {
    Object a(Function2 function2, ContinuationImpl continuationImpl);

    Flow getData();
}
