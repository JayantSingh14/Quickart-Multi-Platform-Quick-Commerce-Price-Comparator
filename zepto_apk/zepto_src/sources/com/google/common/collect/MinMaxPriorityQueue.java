package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f42933a;

    /* renamed from: b, reason: collision with root package name */
    public int f42934b;

    /* renamed from: c, reason: collision with root package name */
    public int f42935c;

    public static final class Builder<B> {
    }

    public class Heap {
    }

    public static class MoveDesc<E> {
    }

    public class QueueIterator implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        public int f42936a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f42937b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f42938c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f42939d;

        public QueueIterator() {
            this.f42938c = MinMaxPriorityQueue.this.f42935c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
            if (minMaxPriorityQueue.f42935c != this.f42938c) {
                throw new ConcurrentModificationException();
            }
            int i2 = this.f42936a + 1;
            if (this.f42937b < i2) {
                this.f42937b = i2;
            }
            return this.f42937b < minMaxPriorityQueue.f42934b;
        }

        @Override // java.util.Iterator
        public final Object next() {
            MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
            if (minMaxPriorityQueue.f42935c != this.f42938c) {
                throw new ConcurrentModificationException();
            }
            int i2 = this.f42936a + 1;
            if (this.f42937b < i2) {
                this.f42937b = i2;
            }
            int i3 = this.f42937b;
            if (i3 >= minMaxPriorityQueue.f42934b) {
                throw new NoSuchElementException("iterator moved past last element in queue.");
            }
            this.f42936a = i3;
            this.f42939d = true;
            Object obj = minMaxPriorityQueue.f42933a[i3];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            CollectPreconditions.d(this.f42939d);
            MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
            int i2 = minMaxPriorityQueue.f42935c;
            int i3 = this.f42938c;
            if (i2 != i3) {
                throw new ConcurrentModificationException();
            }
            this.f42939d = false;
            this.f42938c = i3 + 1;
            int i4 = this.f42936a;
            if (i4 >= minMaxPriorityQueue.f42934b) {
                throw null;
            }
            minMaxPriorityQueue.b(i4);
            this.f42936a--;
            this.f42937b--;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        offer(obj);
        throw null;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        Iterator<E> it = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        offer(it.next());
        throw null;
    }

    public final void b(int i2) {
        Preconditions.k(i2, this.f42934b);
        this.f42935c++;
        int i3 = this.f42934b - 1;
        this.f42934b = i3;
        if (i3 == i2) {
            this.f42933a[i3] = null;
        } else {
            Objects.requireNonNull(this.f42933a[i3]);
            Preconditions.m("negative index", (~(~(this.f42934b + 1))) > 0);
            throw null;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        for (int i2 = 0; i2 < this.f42934b; i2++) {
            this.f42933a[i2] = null;
        }
        this.f42934b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new QueueIterator();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        obj.getClass();
        this.f42935c++;
        int i2 = this.f42934b + 1;
        this.f42934b = i2;
        Object[] objArr = this.f42933a;
        if (i2 > objArr.length) {
            int length = objArr.length;
            Object[] objArr2 = new Object[Math.min((length < 64 ? (length + 1) * 2 : IntMath.b(length / 2)) - 1, 0) + 1];
            Object[] objArr3 = this.f42933a;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f42933a = objArr2;
        }
        Preconditions.m("negative index", (~(~i2)) > 0);
        throw null;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (isEmpty()) {
            return null;
        }
        Object obj = this.f42933a[0];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (isEmpty()) {
            return null;
        }
        Object obj = this.f42933a[0];
        Objects.requireNonNull(obj);
        b(0);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f42934b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int i2 = this.f42934b;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f42933a, 0, objArr, 0, i2);
        return objArr;
    }
}
