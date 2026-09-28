package io.ktor.util.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public abstract class AtomicOp<T> extends OpDescriptor {

    @NotNull
    private volatile /* synthetic */ Object _consensus = LockFreeLinkedListKt.f50563c;

    static {
        AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    }

    @Override // io.ktor.util.internal.OpDescriptor
    public final Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object obj = this._consensus;
        if (obj != LockFreeLinkedListKt.f50563c) {
            b(lockFreeLinkedListNode);
            return obj;
        }
        c(lockFreeLinkedListNode);
        throw null;
    }

    public abstract void b(LockFreeLinkedListNode lockFreeLinkedListNode);

    public abstract Object c(LockFreeLinkedListNode lockFreeLinkedListNode);
}
