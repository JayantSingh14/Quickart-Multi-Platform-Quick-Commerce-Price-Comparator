package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    public final void add(Object obj) {
        t().add(obj);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return t().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return t().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return t().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return t().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        t().set(obj);
    }

    @Override // com.google.common.collect.ForwardingIterator
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public abstract ListIterator t();
}
