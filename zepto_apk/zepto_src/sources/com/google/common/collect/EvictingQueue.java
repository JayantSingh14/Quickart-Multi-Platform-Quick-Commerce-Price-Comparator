package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    @Override // com.google.common.collect.ForwardingQueue
    /* renamed from: B */
    public final Queue t() {
        return null;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        obj.getClass();
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        int size = collection.size();
        if (size < 0) {
            return Iterators.a(this, collection.iterator());
        }
        clear();
        Preconditions.g(size >= 0, "number to skip cannot be negative");
        Iterable anonymousClass6 = new FluentIterable<Object>(size, collection) { // from class: com.google.common.collect.Iterables.6

            /* renamed from: b */
            public final /* synthetic */ Collection f42745b;

            /* renamed from: c */
            public final /* synthetic */ int f42746c;

            /* renamed from: com.google.common.collect.Iterables$6$1 */
            class AnonymousClass1 implements Iterator<Object> {

                /* renamed from: a */
                public boolean f42747a = true;

                /* renamed from: b */
                public final /* synthetic */ Iterator f42748b;

                public AnonymousClass1(Iterator it) {
                    it = it;
                }

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public final Object next() {
                    Object next = it.next();
                    this.f42747a = false;
                    return next;
                }

                @Override // java.util.Iterator
                public final void remove() {
                    CollectPreconditions.d(!this.f42747a);
                    it.remove();
                }
            }

            public AnonymousClass6(int size2, Collection collection2) {
                this.f42745b = collection2;
                this.f42746c = size2;
            }

            @Override // java.lang.Iterable
            public final Iterator iterator() {
                Collection collection2 = this.f42745b;
                boolean z = collection2 instanceof List;
                int i2 = this.f42746c;
                if (z) {
                    List list = (List) collection2;
                    return list.subList(Math.min(list.size(), i2), list.size()).iterator();
                }
                Iterator it = collection2.iterator();
                it.getClass();
                Preconditions.g(i2 >= 0, "numberToAdvance must be nonnegative");
                for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
                    it.next();
                }
                return new Iterator<Object>() { // from class: com.google.common.collect.Iterables.6.1

                    /* renamed from: a */
                    public boolean f42747a = true;

                    /* renamed from: b */
                    public final /* synthetic */ Iterator f42748b;

                    public AnonymousClass1(Iterator it2) {
                        it = it2;
                    }

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public final Object next() {
                        Object next = it.next();
                        this.f42747a = false;
                        return next;
                    }

                    @Override // java.util.Iterator
                    public final void remove() {
                        CollectPreconditions.d(!this.f42747a);
                        it.remove();
                    }
                };
            }
        };
        return anonymousClass6 instanceof Collection ? addAll((Collection) anonymousClass6) : Iterators.a(this, anonymousClass6.iterator());
    }

    @Override // com.google.common.collect.ForwardingQueue, java.util.Queue
    public final boolean offer(Object obj) {
        obj.getClass();
        return true;
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final /* bridge */ /* synthetic */ Object t() {
        return null;
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection
    /* renamed from: u */
    public final /* bridge */ /* synthetic */ Collection t() {
        return null;
    }
}
