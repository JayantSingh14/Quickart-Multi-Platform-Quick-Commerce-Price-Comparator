package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Multisets {

    /* renamed from: com.google.common.collect.Multisets$1, reason: invalid class name */
    class AnonymousClass1 extends ViewMultiset<Object> {

        /* renamed from: com.google.common.collect.Multisets$1$1, reason: invalid class name and collision with other inner class name */
        class C00371 extends AbstractIterator<Multiset.Entry<Object>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Set b() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
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

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Multisets$2, reason: invalid class name */
    class AnonymousClass2 extends ViewMultiset<Object> {

        /* renamed from: com.google.common.collect.Multisets$2$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Multiset.Entry<Object>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Set b() {
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

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Multisets$3, reason: invalid class name */
    class AnonymousClass3 extends ViewMultiset<Object> {

        /* renamed from: com.google.common.collect.Multisets$3$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Multiset.Entry<Object>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Set b() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
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

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection
        public final int size() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Multisets$4, reason: invalid class name */
    class AnonymousClass4 extends ViewMultiset<Object> {

        /* renamed from: com.google.common.collect.Multisets$4$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Object> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        /* renamed from: com.google.common.collect.Multisets$4$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractIterator<Multiset.Entry<Object>> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset
        public final int f() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Iterator g() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Iterator i() {
            throw null;
        }

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Multisets$5, reason: invalid class name */
    class AnonymousClass5 extends TransformedIterator<Multiset.Entry<Object>, Object> {
        @Override // com.google.common.collect.TransformedIterator
        public final Object a(Object obj) {
            return ((Multiset.Entry) obj).a();
        }
    }

    public static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        public final boolean equals(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                if (getCount() == entry.getCount() && Objects.a(a(), entry.a())) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Object objA = a();
            return (objA == null ? 0 : objA.hashCode()) ^ getCount();
        }

        public final String toString() {
            String strValueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    public static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
        @Override // java.util.Comparator
        public final int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    public static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return g().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection collection) {
            return g().containsAll(collection);
        }

        public abstract Multiset g();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return g().T(Api.BaseClientBuilder.API_PRIORITY_OTHER, obj) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g().entrySet().size();
        }
    }

    public static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && g().o1(entry.a()) == entry.getCount();
        }

        public abstract Multiset g();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            Object objA = entry.a();
            int count = entry.getCount();
            if (count != 0) {
                return g().u0(count, objA);
            }
            return false;
        }
    }

    public static final class FilteredMultiset<E> extends ViewMultiset<E> {

        /* renamed from: com.google.common.collect.Multisets$FilteredMultiset$1, reason: invalid class name */
        class AnonymousClass1 implements Predicate<Multiset.Entry<Object>> {
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                throw null;
            }
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public final int T(int i2, Object obj) {
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0 || contains(obj)) {
                throw null;
            }
            return 0;
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public final int add(int i2, Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Set b() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Set d() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Iterator g() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Iterator i() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }
    }

    public static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42958a;

        /* renamed from: b, reason: collision with root package name */
        public final int f42959b;

        public ImmutableEntry(Object obj, int i2) {
            this.f42958a = obj;
            this.f42959b = i2;
            CollectPreconditions.b(i2, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final Object a() {
            return this.f42958a;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.f42959b;
        }
    }

    public static final class MultisetIteratorImpl<E> implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        public final Multiset f42960a;

        /* renamed from: b, reason: collision with root package name */
        public final Iterator f42961b;

        /* renamed from: c, reason: collision with root package name */
        public Multiset.Entry f42962c;

        /* renamed from: d, reason: collision with root package name */
        public int f42963d;

        /* renamed from: e, reason: collision with root package name */
        public int f42964e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f42965f;

        public MultisetIteratorImpl(Multiset multiset, Iterator it) {
            this.f42960a = multiset;
            this.f42961b = it;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42963d > 0 || this.f42961b.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f42963d == 0) {
                Multiset.Entry entry = (Multiset.Entry) this.f42961b.next();
                this.f42962c = entry;
                int count = entry.getCount();
                this.f42963d = count;
                this.f42964e = count;
            }
            this.f42963d--;
            this.f42965f = true;
            Multiset.Entry entry2 = this.f42962c;
            java.util.Objects.requireNonNull(entry2);
            return entry2.a();
        }

        @Override // java.util.Iterator
        public final void remove() {
            CollectPreconditions.d(this.f42965f);
            if (this.f42964e == 1) {
                this.f42961b.remove();
            } else {
                Multiset.Entry entry = this.f42962c;
                java.util.Objects.requireNonNull(entry);
                this.f42960a.remove(entry.a());
            }
            this.f42964e--;
            this.f42965f = false;
        }
    }

    public static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final SortedMultiset f42966a;

        /* renamed from: b, reason: collision with root package name */
        public transient Set f42967b;

        /* renamed from: c, reason: collision with root package name */
        public transient Set f42968c;

        public UnmodifiableMultiset(SortedMultiset sortedMultiset) {
            this.f42966a = sortedMultiset;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public Multiset t() {
            return this.f42966a;
        }

        public Set C() {
            return Collections.unmodifiableSet(this.f42966a.e());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public final int O1(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public final int T(int i2, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set e() {
            Set set = this.f42967b;
            if (set != null) {
                return set;
            }
            Set setC = C();
            this.f42967b = setC;
            return setC;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public final Set entrySet() {
            Set set = this.f42968c;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.f42966a.entrySet());
            this.f42968c = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return Iterators.o(this.f42966a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public final boolean u0(int i2, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public final int add(int i2, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e().clear();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int f() {
            return e().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Multisets.b(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            long count = 0;
            while (entrySet().iterator().hasNext()) {
                count += ((Multiset.Entry) r0.next()).getCount();
            }
            return Ints.f(count);
        }
    }

    public static boolean a(Multiset multiset, Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (!(obj instanceof Multiset)) {
            return false;
        }
        Multiset multiset2 = (Multiset) obj;
        if (multiset.size() != multiset2.size() || multiset.entrySet().size() != multiset2.entrySet().size()) {
            return false;
        }
        for (Multiset.Entry entry : multiset2.entrySet()) {
            if (multiset.o1(entry.a()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static Iterator b(Multiset multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }
}
