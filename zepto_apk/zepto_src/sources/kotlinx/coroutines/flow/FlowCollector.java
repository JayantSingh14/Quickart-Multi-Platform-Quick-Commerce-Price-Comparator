package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes.dex */
public interface FlowCollector<T> {
    Object a(Object obj, Continuation continuation);
}
