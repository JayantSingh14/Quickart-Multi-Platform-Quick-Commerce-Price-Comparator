package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final UnmodifiableListIterator f42665b = new Itr(0, RegularImmutableList.f43010e);

    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            super(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        /* renamed from: b */
        public final ImmutableCollection.ArrayBasedBuilder c(Object obj) {
            super.c(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public final ImmutableCollection.Builder c(Object obj) {
            super.c(obj);
            return this;
        }

        public final void h(Object obj) {
            super.c(obj);
        }

        public final void i(Object... objArr) {
            d(objArr.length, objArr);
        }

        public final ImmutableList j() {
            this.f42659c = true;
            return ImmutableList.m(this.f42658b, this.f42657a);
        }
    }

    public static class Itr<E> extends AbstractIndexedListIterator<E> {

        /* renamed from: c, reason: collision with root package name */
        public final ImmutableList f42666c;

        public Itr(int i2, ImmutableList immutableList) {
            super(immutableList.size(), i2);
            this.f42666c = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public final Object a(int i2) {
            return this.f42666c.get(i2);
        }
    }

    /* loaded from: classes4.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableList f42667c;

        public ReverseImmutableList(ImmutableList immutableList) {
            this.f42667c = immutableList;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return this.f42667c.contains(obj);
        }

        @Override // java.util.List
        public final Object get(int i2) {
            ImmutableList immutableList = this.f42667c;
            Preconditions.i(i2, immutableList.size());
            return immutableList.get((immutableList.size() - 1) - i2);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final int indexOf(Object obj) {
            int iLastIndexOf = this.f42667c.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return (r0.size() - 1) - iLastIndexOf;
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return this.f42667c.j();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final int lastIndexOf(Object obj) {
            int iIndexOf = this.f42667c.indexOf(obj);
            if (iIndexOf >= 0) {
                return (r0.size() - 1) - iIndexOf;
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42667c.size();
        }

        @Override // com.google.common.collect.ImmutableList
        public final ImmutableList w() {
            return this.f42667c;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final ImmutableList subList(int i2, int i3) {
            ImmutableList immutableList = this.f42667c;
            Preconditions.l(i2, i3, immutableList.size());
            return immutableList.subList(immutableList.size() - i3, immutableList.size() - i2).w();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return listIterator(i2);
        }
    }

    @J2ktIncompatible
    /* loaded from: classes4.dex */
    public static class SerializedForm implements Serializable {
    }

    /* loaded from: classes4.dex */
    public class SubList extends ImmutableList<E> {

        /* renamed from: c, reason: collision with root package name */
        public final transient int f42668c;

        /* renamed from: d, reason: collision with root package name */
        public final transient int f42669d;

        public SubList(int i2, int i3) {
            this.f42668c = i2;
            this.f42669d = i3;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final Object[] f() {
            return ImmutableList.this.f();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int g() {
            return ImmutableList.this.i() + this.f42668c + this.f42669d;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, this.f42669d);
            return ImmutableList.this.get(i2 + this.f42668c);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int i() {
            return ImmutableList.this.i() + this.f42668c;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f42669d;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: z */
        public final ImmutableList subList(int i2, int i3) {
            Preconditions.l(i2, i3, this.f42669d);
            int i4 = this.f42668c;
            return ImmutableList.this.subList(i2 + i4, i3 + i4);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return listIterator(i2);
        }
    }

    public static ImmutableList m(int i2, Object[] objArr) {
        return i2 == 0 ? RegularImmutableList.f43010e : new RegularImmutableList(objArr, i2);
    }

    public static Builder n(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        return new Builder(i2);
    }

    public static ImmutableList o(Collection collection) {
        if (!(collection instanceof ImmutableCollection)) {
            Object[] array = collection.toArray();
            ObjectArrays.a(array.length, array);
            return m(array.length, array);
        }
        ImmutableList immutableListB = ((ImmutableCollection) collection).b();
        if (!immutableListB.j()) {
            return immutableListB;
        }
        Object[] array2 = immutableListB.toArray(ImmutableCollection.f42656a);
        return m(array2.length, array2);
    }

    public static ImmutableList p(Object[] objArr) {
        if (objArr.length == 0) {
            return RegularImmutableList.f43010e;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        ObjectArrays.a(objArr2.length, objArr2);
        return m(objArr2.length, objArr2);
    }

    public static ImmutableList r() {
        return RegularImmutableList.f43010e;
    }

    public static ImmutableList s(Long l2, Long l3, Long l4, Long l5, Long l6) {
        Object[] objArr = {l2, l3, l4, l5, l6};
        ObjectArrays.a(5, objArr);
        return m(5, objArr);
    }

    public static ImmutableList t(Object obj) {
        Object[] objArr = {obj};
        ObjectArrays.a(1, objArr);
        return m(1, objArr);
    }

    public static ImmutableList u(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        ObjectArrays.a(2, objArr);
        return m(2, objArr);
    }

    public static ImmutableList v(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Object... objArr) {
        Preconditions.g(objArr.length <= 2147483635, "the total number of elements must fit in an int");
        int length = objArr.length + 12;
        Object[] objArr2 = new Object[length];
        objArr2[0] = str;
        objArr2[1] = str2;
        objArr2[2] = str3;
        objArr2[3] = str4;
        objArr2[4] = str5;
        objArr2[5] = str6;
        objArr2[6] = str7;
        objArr2[7] = str8;
        objArr2[8] = str9;
        objArr2[9] = str10;
        objArr2[10] = str11;
        objArr2[11] = str12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        ObjectArrays.a(length, objArr2);
        return m(length, objArr2);
    }

    public static ImmutableList y(Ordering ordering, Collection collection) {
        ordering.getClass();
        Object[] objArrH = Iterables.h(collection);
        ObjectArrays.a(objArrH.length, objArrH);
        Arrays.sort(objArrH, ordering);
        return m(objArrH.length, objArrH);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList b() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int d(int i2, Object[] objArr) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(list instanceof RandomAccess)) {
                    return Iterators.e(iterator(), list.iterator());
                }
                for (int i2 = 0; i2 < size; i2++) {
                    if (Objects.a(get(i2), list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~(get(i3).hashCode() + (i2 * 31)));
        }
        return i2;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public UnmodifiableListIterator listIterator(int i2) {
        Preconditions.k(i2, size());
        return isEmpty() ? f42665b : new Itr(i2, this);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList w() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    /* renamed from: z */
    public ImmutableList subList(int i2, int i3) {
        Preconditions.l(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? RegularImmutableList.f43010e : new SubList(i2, i4);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }
}
