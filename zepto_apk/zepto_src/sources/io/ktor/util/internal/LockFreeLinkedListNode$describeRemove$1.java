package io.ktor.util.internal;

import io.ktor.util.internal.LockFreeLinkedListNode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class LockFreeLinkedListNode$describeRemove$1 extends LockFreeLinkedListNode.AbstractAtomicDesc {

    @NotNull
    private volatile /* synthetic */ Object _originalNext;

    static {
        AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode$describeRemove$1.class, Object.class, "_originalNext");
    }
}
