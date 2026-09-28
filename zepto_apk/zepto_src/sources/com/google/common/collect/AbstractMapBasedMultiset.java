package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public transient long f42499c;

    public abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f42502a;

        /* renamed from: b, reason: collision with root package name */
        public int f42503b;

        /* renamed from: c, reason: collision with root package name */
        public int f42504c;

        public Itr() {
            AbstractMapBasedMultiset.this.getClass();
            throw null;
        }

        public abstract Object a(int i2);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            AbstractMapBasedMultiset.this.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            a(this.f42502a);
            this.f42503b = this.f42502a;
            AbstractMapBasedMultiset.this.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            AbstractMapBasedMultiset.this.getClass();
            throw null;
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int O1(Object obj) {
        CollectPreconditions.b(0, "count");
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int T(int i2, Object obj) {
        if (i2 == 0) {
            throw null;
        }
        Preconditions.e("occurrences cannot be negative: %s", i2, i2 > 0);
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int add(int i2, Object obj) {
        if (i2 == 0) {
            throw null;
        }
        Preconditions.e("occurrences cannot be negative: %s", i2, i2 > 0);
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int f() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator g() {
        return new AbstractMapBasedMultiset<Object>.Itr<Object>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public final Object a(int i2) {
                AbstractMapBasedMultiset.this.getClass();
                throw null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator i() {
        return new AbstractMapBasedMultiset<Object>.Itr<Multiset.Entry<Object>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public final Object a(int i2) {
                AbstractMapBasedMultiset.this.getClass();
                throw null;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return Ints.f(this.f42499c);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean u0(int i2, Object obj) {
        CollectPreconditions.b(i2, "oldCount");
        CollectPreconditions.b(0, "newCount");
        throw null;
    }
}
