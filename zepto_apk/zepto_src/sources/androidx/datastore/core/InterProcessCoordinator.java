package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata
/* loaded from: classes.dex */
public interface InterProcessCoordinator {
    Object a(Function2 function2, ContinuationImpl continuationImpl);

    Flow b();

    Object c(ContinuationImpl continuationImpl);

    Object d(Function1 function1, ContinuationImpl continuationImpl);

    Object e(Continuation continuation);
}
