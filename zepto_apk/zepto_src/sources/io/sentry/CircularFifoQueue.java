package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: classes.dex */
final class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient Object[] f51573a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f51574b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f51575c;

    /* renamed from: d, reason: collision with root package name */
    public transient boolean f51576d;

    /* renamed from: e, reason: collision with root package name */
    public final int f51577e;

    public CircularFifoQueue() {
        this(32);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        int size = size();
        int i2 = this.f51577e;
        if (size == i2) {
            remove();
        }
        int i3 = this.f51575c;
        int i4 = i3 + 1;
        this.f51575c = i4;
        this.f51573a[i3] = obj;
        if (i4 >= i2) {
            this.f51575c = 0;
        }
        if (this.f51575c == this.f51574b) {
            this.f51576d = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f51576d = false;
        this.f51574b = 0;
        this.f51575c = 0;
        Arrays.fill(this.f51573a, (Object) null);
    }

    @Override // java.util.Queue
    public final Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new Iterator<Object>() { // from class: io.sentry.CircularFifoQueue.1

            /* renamed from: a, reason: collision with root package name */
            public int f51578a;

            /* renamed from: b, reason: collision with root package name */
            public int f51579b = -1;

            /* renamed from: c, reason: collision with root package name */
            public boolean f51580c;

            {
                this.f51578a = CircularFifoQueue.this.f51574b;
                this.f51580c = CircularFifoQueue.this.f51576d;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f51580c || this.f51578a != CircularFifoQueue.this.f51575c;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f51580c = false;
                int i2 = this.f51578a;
                this.f51579b = i2;
                CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                int i3 = i2 + 1;
                this.f51578a = i3 < circularFifoQueue.f51577e ? i3 : 0;
                return circularFifoQueue.f51573a[i2];
            }

            @Override // java.util.Iterator
            public final void remove() {
                int i2;
                int i3 = this.f51579b;
                if (i3 == -1) {
                    throw new IllegalStateException();
                }
                CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                int i4 = circularFifoQueue.f51574b;
                if (i3 == i4) {
                    circularFifoQueue.remove();
                    this.f51579b = -1;
                    return;
                }
                int i5 = i3 + 1;
                int i6 = circularFifoQueue.f51577e;
                if (i4 >= i3 || i5 >= (i2 = circularFifoQueue.f51575c)) {
                    while (i5 != circularFifoQueue.f51575c) {
                        if (i5 >= i6) {
                            Object[] objArr = circularFifoQueue.f51573a;
                            objArr[i5 - 1] = objArr[0];
                        } else {
                            Object[] objArr2 = circularFifoQueue.f51573a;
                            int i7 = i5 - 1;
                            if (i7 < 0) {
                                i7 = i6 - 1;
                            }
                            objArr2[i7] = objArr2[i5];
                            i5++;
                            if (i5 >= i6) {
                            }
                        }
                        i5 = 0;
                    }
                } else {
                    Object[] objArr3 = circularFifoQueue.f51573a;
                    System.arraycopy(objArr3, i5, objArr3, i3, i2 - i5);
                }
                this.f51579b = -1;
                int i8 = circularFifoQueue.f51575c - 1;
                if (i8 < 0) {
                    i8 = i6 - 1;
                }
                circularFifoQueue.f51575c = i8;
                circularFifoQueue.f51573a[i8] = null;
                circularFifoQueue.f51576d = false;
                int i9 = this.f51578a - 1;
                if (i9 < 0) {
                    i9 = i6 - 1;
                }
                this.f51578a = i9;
            }
        };
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f51573a[this.f51574b];
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public final Object remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        int i2 = this.f51574b;
        Object[] objArr = this.f51573a;
        Object obj = objArr[i2];
        if (obj != null) {
            int i3 = i2 + 1;
            this.f51574b = i3;
            objArr[i2] = null;
            if (i3 >= this.f51577e) {
                this.f51574b = 0;
            }
            this.f51576d = false;
        }
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i2 = this.f51575c;
        int i3 = this.f51574b;
        int i4 = this.f51577e;
        if (i2 < i3) {
            return (i4 - i3) + i2;
        }
        if (i2 != i3) {
            return i2 - i3;
        }
        if (this.f51576d) {
            return i4;
        }
        return 0;
    }

    public CircularFifoQueue(int i2) {
        this.f51574b = 0;
        this.f51575c = 0;
        this.f51576d = false;
        if (i2 <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        Object[] objArr = new Object[i2];
        this.f51573a = objArr;
        this.f51577e = objArr.length;
    }
}
