package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes.dex */
public interface Flow<T> {
    Object c(FlowCollector flowCollector, Continuation continuation);
}
