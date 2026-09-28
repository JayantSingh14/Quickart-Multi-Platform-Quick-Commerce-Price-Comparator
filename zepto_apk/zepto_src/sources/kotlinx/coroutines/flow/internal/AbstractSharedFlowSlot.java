package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean a(AbstractSharedFlow abstractSharedFlow);

    public abstract Continuation[] b(AbstractSharedFlow abstractSharedFlow);
}
