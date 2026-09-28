package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f42512a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f42513b;

    public class ElementSet extends Multisets.ElementSet<E> {
        public ElementSet() {
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public final Multiset g() {
            return AbstractMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return AbstractMultiset.this.g();
        }
    }

    public class EntrySet extends Multisets.EntrySet<E> {
        public EntrySet() {
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        public Multiset g() {
            return AbstractMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return AbstractMultiset.this.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return AbstractMultiset.this.f();
        }
    }

    public int O1(Object obj) {
        CollectPreconditions.b(0, "count");
        int iO1 = o1(obj);
        int i2 = 0 - iO1;
        if (i2 > 0) {
            add(i2, obj);
            return iO1;
        }
        if (i2 < 0) {
            T(-i2, obj);
        }
        return iO1;
    }

    public int T(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        add(1, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (!(collection instanceof Multiset)) {
            if (collection.isEmpty()) {
                return false;
            }
            return Iterators.a(this, collection.iterator());
        }
        Multiset multiset = (Multiset) collection;
        if (multiset instanceof AbstractMapBasedMultiset) {
            if (((AbstractMapBasedMultiset) multiset).isEmpty()) {
                return false;
            }
            throw null;
        }
        if (multiset.isEmpty()) {
            return false;
        }
        for (Multiset.Entry entry : multiset.entrySet()) {
            add(entry.getCount(), entry.a());
        }
        return true;
    }

    public Set b() {
        return new ElementSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return o1(obj) > 0;
    }

    public Set d() {
        return new EntrySet();
    }

    @Override // com.google.common.collect.Multiset
    public Set e() {
        Set set = this.f42512a;
        if (set != null) {
            return set;
        }
        Set setB = b();
        this.f42512a = setB;
        return setB;
    }

    @Override // com.google.common.collect.Multiset
    public Set entrySet() {
        Set set = this.f42513b;
        if (set != null) {
            return set;
        }
        Set setD = d();
        this.f42513b = setD;
        return setD;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(Object obj) {
        return Multisets.a(this, obj);
    }

    public abstract int f();

    public abstract Iterator g();

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    public abstract Iterator i();

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        return T(1, obj) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        return e().removeAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        return e().retainAll(collection);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    public boolean u0(int i2, Object obj) {
        CollectPreconditions.b(i2, "oldCount");
        CollectPreconditions.b(0, "newCount");
        if (o1(obj) != i2) {
            return false;
        }
        O1(obj);
        return true;
    }

    public int add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }
}
