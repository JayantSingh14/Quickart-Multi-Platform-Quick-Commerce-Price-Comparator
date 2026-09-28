package io.sentry;

import java.util.Collection;
import java.util.Queue;

/* loaded from: classes.dex */
final class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    @Override // io.sentry.SynchronizedCollection
    public final Collection b() {
        return (Queue) this.f51942a;
    }

    @Override // java.util.Queue
    public final Object element() {
        Object objElement;
        synchronized (this.f51943b) {
            objElement = ((Queue) this.f51942a).element();
        }
        return objElement;
    }

    @Override // io.sentry.SynchronizedCollection, java.util.Collection
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f51943b) {
            zEquals = ((Queue) this.f51942a).equals(obj);
        }
        return zEquals;
    }

    @Override // io.sentry.SynchronizedCollection, java.util.Collection
    public final int hashCode() {
        int iHashCode;
        synchronized (this.f51943b) {
            iHashCode = ((Queue) this.f51942a).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        boolean zOffer;
        synchronized (this.f51943b) {
            zOffer = ((Queue) this.f51942a).offer(obj);
        }
        return zOffer;
    }

    @Override // java.util.Queue
    public final Object peek() {
        Object objPeek;
        synchronized (this.f51943b) {
            objPeek = ((Queue) this.f51942a).peek();
        }
        return objPeek;
    }

    @Override // java.util.Queue
    public final Object poll() {
        Object objPoll;
        synchronized (this.f51943b) {
            objPoll = ((Queue) this.f51942a).poll();
        }
        return objPoll;
    }

    @Override // java.util.Queue
    public final Object remove() {
        Object objRemove;
        synchronized (this.f51943b) {
            objRemove = ((Queue) this.f51942a).remove();
        }
        return objRemove;
    }

    @Override // io.sentry.SynchronizedCollection, java.util.Collection
    public final Object[] toArray() {
        Object[] array;
        synchronized (this.f51943b) {
            array = ((Queue) this.f51942a).toArray();
        }
        return array;
    }

    @Override // io.sentry.SynchronizedCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f51943b) {
            array = ((Queue) this.f51942a).toArray(objArr);
        }
        return array;
    }
}
