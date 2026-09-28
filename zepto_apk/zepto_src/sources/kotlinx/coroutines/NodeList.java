package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public final boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList c() {
        return this;
    }
}
