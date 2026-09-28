package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Collections2 {

    public static class FilteredCollection<E> extends AbstractCollection<E> {

        /* renamed from: a, reason: collision with root package name */
        public final Collection f42536a;

        /* renamed from: b, reason: collision with root package name */
        public final Predicate f42537b;

        public FilteredCollection(Collection collection, Predicate predicate) {
            this.f42536a = collection;
            this.f42537b = predicate;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean add(Object obj) {
            Preconditions.f(this.f42537b.apply(obj));
            return this.f42536a.add(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.f(this.f42537b.apply(it.next()));
            }
            return this.f42536a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            Iterables.f(this.f42536a, this.f42537b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (Collections2.c(obj, this.f42536a)) {
                return this.f42537b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean containsAll(Collection collection) {
            return Collections2.a(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return !Iterables.a(this.f42536a, this.f42537b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return Iterators.f(this.f42536a.iterator(), this.f42537b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            return contains(obj) && this.f42536a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection collection) {
            Iterator<E> it = this.f42536a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f42537b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection collection) {
            Iterator<E> it = this.f42536a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f42537b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            Iterator<E> it = this.f42536a.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (this.f42537b.apply(it.next())) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return Lists.a(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return Lists.a(iterator()).toArray(objArr);
        }
    }

    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof List) {
                throw null;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            return "orderedPermutationCollection(null)";
        }
    }

    public static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f42538c;

        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            ArrayList arrayList = this.f42538c;
            if (arrayList == null) {
                this.f42456a = AbstractIterator.State.f42461c;
                return null;
            }
            ImmutableList immutableListO = ImmutableList.o(arrayList);
            Objects.requireNonNull(this.f42538c);
            int size = this.f42538c.size();
            int i2 = size - 2;
            if (i2 < 0) {
                this.f42538c = null;
                return immutableListO;
            }
            this.f42538c.get(i2);
            this.f42538c.get(size - 1);
            throw null;
        }
    }

    public static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof List) {
                throw null;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            new PermutationIterator();
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            throw null;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            return "permutations(null)";
        }
    }

    public static class PermutationIterator<E> extends AbstractIterator<List<E>> {

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f42539c = new ArrayList((Collection) null);

        /* renamed from: d, reason: collision with root package name */
        public int f42540d;

        public PermutationIterator() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            if (this.f42540d <= 0) {
                this.f42456a = AbstractIterator.State.f42461c;
                return null;
            }
            ArrayList arrayList = this.f42539c;
            ImmutableList immutableListO = ImmutableList.o(arrayList);
            int size = arrayList.size() - 1;
            this.f42540d = size;
            if (size == -1) {
                return immutableListO;
            }
            throw null;
        }
    }

    public static class TransformedCollection<F, T> extends AbstractCollection<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Collection f42541a;

        /* renamed from: b, reason: collision with root package name */
        public final Function f42542b;

        public TransformedCollection(Collection collection, Function function) {
            collection.getClass();
            this.f42541a = collection;
            function.getClass();
            this.f42542b = function;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f42541a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return this.f42541a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return Iterators.n(this.f42541a.iterator(), this.f42542b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f42541a.size();
        }
    }

    public static boolean a(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static Collection b(Predicate predicate) {
        throw null;
    }

    public static boolean c(Object obj, Collection collection) {
        collection.getClass();
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
