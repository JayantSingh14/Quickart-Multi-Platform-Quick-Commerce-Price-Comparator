package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Deque;
import java.util.Iterator;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public abstract Deque t();

    @Override // java.util.Deque
    public final void addFirst(Object obj) {
        t().addFirst(obj);
    }

    @Override // java.util.Deque
    public final void addLast(Object obj) {
        t().addLast(obj);
    }

    @Override // java.util.Deque
    public final Iterator descendingIterator() {
        return t().descendingIterator();
    }

    @Override // java.util.Deque
    public final Object getFirst() {
        return t().getFirst();
    }

    @Override // java.util.Deque
    public final Object getLast() {
        return t().getLast();
    }

    @Override // java.util.Deque
    public final boolean offerFirst(Object obj) {
        return t().offerFirst(obj);
    }

    @Override // java.util.Deque
    public final boolean offerLast(Object obj) {
        return t().offerLast(obj);
    }

    @Override // java.util.Deque
    public final Object peekFirst() {
        return t().peekFirst();
    }

    @Override // java.util.Deque
    public final Object peekLast() {
        return t().peekLast();
    }

    @Override // java.util.Deque
    public final Object pollFirst() {
        return t().pollFirst();
    }

    @Override // java.util.Deque
    public final Object pollLast() {
        return t().pollLast();
    }

    @Override // java.util.Deque
    public final Object pop() {
        return t().pop();
    }

    @Override // java.util.Deque
    public final void push(Object obj) {
        t().push(obj);
    }

    @Override // java.util.Deque
    public final Object removeFirst() {
        return t().removeFirst();
    }

    @Override // java.util.Deque
    public final boolean removeFirstOccurrence(Object obj) {
        return t().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    public final Object removeLast() {
        return t().removeLast();
    }

    @Override // java.util.Deque
    public final boolean removeLastOccurrence(Object obj) {
        return t().removeLastOccurrence(obj);
    }
}
