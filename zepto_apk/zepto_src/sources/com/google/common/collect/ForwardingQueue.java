package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Queue;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    @Override // com.google.common.collect.ForwardingCollection
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public abstract Queue t();

    @Override // java.util.Queue
    public final Object element() {
        return t().element();
    }

    public boolean offer(Object obj) {
        return t().offer(obj);
    }

    @Override // java.util.Queue
    public final Object peek() {
        return t().peek();
    }

    @Override // java.util.Queue
    public final Object poll() {
        return t().poll();
    }

    @Override // java.util.Queue
    public final Object remove() {
        return t().remove();
    }
}
