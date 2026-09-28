package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public final class Lists {

    /* renamed from: com.google.common.collect.Lists$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 extends RandomAccessListWrapper<Object> {
        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Lists$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 extends AbstractListWrapper<Object> {
        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public static class AbstractListWrapper<E> extends AbstractList<E> {
        @Override // java.util.AbstractList, java.util.List
        public final void add(int i2, Object obj) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final boolean addAll(int i2, Collection collection) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object remove(int i2) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public static final class CharSequenceAsList extends AbstractList<Character> {
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public static class Partition<T> extends AbstractList<List<T>> {
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
    }

    /* loaded from: classes4.dex */
    public static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
    }

    /* loaded from: classes4.dex */
    public static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
    }

    /* loaded from: classes4.dex */
    public static class ReverseList<T> extends AbstractList<T> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f42812b = 0;

        /* renamed from: a, reason: collision with root package name */
        public final List f42813a;

        public ReverseList(List list) {
            list.getClass();
            this.f42813a = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public final void add(int i2, Object obj) {
            this.f42813a.add(b(i2), obj);
        }

        public final int b(int i2) {
            int size = this.f42813a.size();
            Preconditions.k(i2, size);
            return size - i2;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final void clear() {
            this.f42813a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            List list = this.f42813a;
            int size = list.size();
            Preconditions.i(i2, size);
            return list.get((size - 1) - i2);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            final ListIterator listIterator = this.f42813a.listIterator(b(i2));
            return new ListIterator<Object>() { // from class: com.google.common.collect.Lists.ReverseList.1

                /* renamed from: a, reason: collision with root package name */
                public boolean f42814a;

                @Override // java.util.ListIterator
                public final void add(Object obj) {
                    ListIterator listIterator2 = listIterator;
                    listIterator2.add(obj);
                    listIterator2.previous();
                    this.f42814a = false;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public final boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public final boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public final Object next() {
                    ListIterator listIterator2 = listIterator;
                    if (!listIterator2.hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    this.f42814a = true;
                    return listIterator2.previous();
                }

                @Override // java.util.ListIterator
                public final int nextIndex() {
                    int iNextIndex = listIterator.nextIndex();
                    int i3 = ReverseList.f42812b;
                    return ReverseList.this.b(iNextIndex);
                }

                @Override // java.util.ListIterator
                public final Object previous() {
                    ListIterator listIterator2 = listIterator;
                    if (!listIterator2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f42814a = true;
                    return listIterator2.next();
                }

                @Override // java.util.ListIterator
                public final int previousIndex() {
                    return nextIndex() - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public final void remove() {
                    CollectPreconditions.d(this.f42814a);
                    listIterator.remove();
                    this.f42814a = false;
                }

                @Override // java.util.ListIterator
                public final void set(Object obj) {
                    Preconditions.n(this.f42814a);
                    listIterator.set(obj);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object remove(int i2) {
            List list = this.f42813a;
            int size = list.size();
            Preconditions.i(i2, size);
            return list.remove((size - 1) - i2);
        }

        @Override // java.util.AbstractList
        public final void removeRange(int i2, int i3) {
            subList(i2, i3).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            List list = this.f42813a;
            int size = list.size();
            Preconditions.i(i2, size);
            return list.set((size - 1) - i2, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42813a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            List list = this.f42813a;
            Preconditions.l(i2, i3, list.size());
            List listSubList = list.subList(b(i3), b(i2));
            return listSubList instanceof ImmutableList ? ((ImmutableList) listSubList).w() : listSubList instanceof ReverseList ? ((ReverseList) listSubList).f42813a : listSubList instanceof RandomAccess ? new RandomAccessReverseList(listSubList) : new ReverseList(listSubList);
        }
    }

    /* loaded from: classes4.dex */
    public static final class StringAsImmutableList extends ImmutableList<Character> {

        /* renamed from: c, reason: collision with root package name */
        public final String f42817c;

        public StringAsImmutableList(String str) {
            this.f42817c = str;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            String str = this.f42817c;
            Preconditions.i(i2, str.length());
            return Character.valueOf(str.charAt(i2));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return this.f42817c.indexOf(((Character) obj).charValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return this.f42817c.lastIndexOf(((Character) obj).charValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42817c.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: z */
        public final ImmutableList subList(int i2, int i3) {
            String str = this.f42817c;
            Preconditions.l(i2, i3, str.length());
            String strSubstring = str.substring(i2, i3);
            strSubstring.getClass();
            return new StringAsImmutableList(strSubstring);
        }
    }

    /* loaded from: classes4.dex */
    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final List f42818a;

        /* renamed from: b, reason: collision with root package name */
        public final Function f42819b;

        public TransformingRandomAccessList(Function function, List list) {
            list.getClass();
            this.f42818a = list;
            this.f42819b = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            return this.f42819b.apply(this.f42818a.get(i2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            return this.f42818a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            return new TransformedListIterator<Object, Object>(this.f42818a.listIterator(i2)) { // from class: com.google.common.collect.Lists.TransformingRandomAccessList.1
                @Override // com.google.common.collect.TransformedIterator
                public final Object a(Object obj) {
                    return TransformingRandomAccessList.this.f42819b.apply(obj);
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractList, java.util.List
        public final Object remove(int i2) {
            return this.f42819b.apply(this.f42818a.remove(i2));
        }

        @Override // java.util.AbstractList
        public final void removeRange(int i2, int i3) {
            this.f42818a.subList(i2, i3).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42818a.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final List f42821a;

        /* renamed from: b, reason: collision with root package name */
        public final Function f42822b;

        public TransformingSequentialList(Function function, List list) {
            list.getClass();
            this.f42821a = list;
            this.f42822b = function;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            return new TransformedListIterator<Object, Object>(this.f42821a.listIterator(i2)) { // from class: com.google.common.collect.Lists.TransformingSequentialList.1
                @Override // com.google.common.collect.TransformedIterator
                public final Object a(Object obj) {
                    return TransformingSequentialList.this.f42822b.apply(obj);
                }
            };
        }

        @Override // java.util.AbstractList
        public final void removeRange(int i2, int i3) {
            this.f42821a.subList(i2, i3).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42821a.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            if (i2 == 0 || i2 == 1) {
                return null;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    public static ArrayList a(Iterator it) {
        ArrayList arrayList = new ArrayList();
        Iterators.a(arrayList, it);
        return arrayList;
    }

    public static ArrayList b(Object... objArr) {
        int length = objArr.length;
        CollectPreconditions.b(length, "arraySize");
        ArrayList arrayList = new ArrayList(Ints.f(length + 5 + (length / 10)));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static ArrayList c() {
        CollectPreconditions.b(3, "initialArraySize");
        return new ArrayList(3);
    }

    public static AbstractList d(Function function, List list) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(function, list) : new TransformingSequentialList(function, list);
    }
}
