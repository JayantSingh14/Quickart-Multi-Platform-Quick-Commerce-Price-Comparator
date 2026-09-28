package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@GwtIncompatible
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset$1, reason: invalid class name */
    class AnonymousClass1 extends ForwardingSet<Object> {
        @Override // com.google.common.collect.ForwardingSet
        /* renamed from: B */
        public final Set t() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection collection) {
            return Collections2.a(this, collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            collection.getClass();
            return Sets.g(this, collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset$2, reason: invalid class name */
    class AnonymousClass2 extends AbstractIterator<Multiset.Entry<Object>> {
        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset$3, reason: invalid class name */
    class AnonymousClass3 extends ForwardingIterator<Multiset.Entry<Object>> {

        /* renamed from: a, reason: collision with root package name */
        public Multiset.Entry f42588a;

        @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
        public final Object next() {
            Multiset.Entry entry = (Multiset.Entry) super.next();
            this.f42588a = entry;
            return entry;
        }

        @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
        public final void remove() {
            Preconditions.m("no calls to next() since the last call to remove()", this.f42588a != null);
            this.f42588a.a();
            throw null;
        }

        @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        public final Object t() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingIterator
        /* renamed from: u */
        public final Iterator t() {
            throw null;
        }
    }

    public static class FieldSettersHolder {
        static {
            Serialization.a(ConcurrentHashMultiset.class, "countMap");
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int O1(Object obj) {
        obj.getClass();
        CollectPreconditions.b(0, "count");
        Maps.h(obj, null);
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int T(int i2, Object obj) {
        if (i2 == 0) {
            Maps.h(obj, null);
            throw null;
        }
        CollectPreconditions.c(i2, "occurrences");
        Maps.h(obj, null);
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int add(int i2, Object obj) {
        obj.getClass();
        if (i2 == 0) {
            Maps.h(obj, null);
            throw null;
        }
        CollectPreconditions.c(i2, "occurrences");
        Maps.h(obj, null);
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Set b() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Set d() {
        return new EntrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int f() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator i() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        Maps.h(obj, null);
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean u0(int i2, Object obj) {
        obj.getClass();
        CollectPreconditions.b(i2, "oldCount");
        CollectPreconditions.b(0, "newCount");
        Maps.h(obj, null);
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        throw null;
    }

    public class EntrySet extends AbstractMultiset<E>.EntrySet {
        public EntrySet() {
            super();
        }

        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        public final Multiset g() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            AbstractMultiset abstractMultiset = AbstractMultiset.this;
            int iF = abstractMultiset.f();
            CollectPreconditions.b(iF, "arraySize");
            ArrayList arrayList = new ArrayList(Ints.f(iF + 5 + (iF / 10)));
            Iterators.a(arrayList, abstractMultiset.i());
            return arrayList.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray(Object[] objArr) {
            AbstractMultiset abstractMultiset = AbstractMultiset.this;
            int iF = abstractMultiset.f();
            CollectPreconditions.b(iF, "arraySize");
            ArrayList arrayList = new ArrayList(Ints.f(iF + 5 + (iF / 10)));
            Iterators.a(arrayList, abstractMultiset.i());
            return arrayList.toArray(objArr);
        }
    }
}
