package kotlin.collections.builders;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Companion f53627d = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final ListBuilder f53628e;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f53629a;

    /* renamed from: b, reason: collision with root package name */
    public int f53630b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f53631c;

    @Metadata
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f53632a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53633b;

        /* renamed from: c, reason: collision with root package name */
        public int f53634c;

        /* renamed from: d, reason: collision with root package name */
        public final BuilderSubList f53635d;

        /* renamed from: e, reason: collision with root package name */
        public final ListBuilder f53636e;

        @Metadata
        @SourceDebugExtension
        public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {

            /* renamed from: a, reason: collision with root package name */
            public final BuilderSubList f53637a;

            /* renamed from: b, reason: collision with root package name */
            public int f53638b;

            /* renamed from: c, reason: collision with root package name */
            public int f53639c;

            /* renamed from: d, reason: collision with root package name */
            public int f53640d;

            public Itr(BuilderSubList list, int i2) {
                Intrinsics.checkNotNullParameter(list, "list");
                this.f53637a = list;
                this.f53638b = i2;
                this.f53639c = -1;
                this.f53640d = ((AbstractList) list).modCount;
            }

            public final void a() {
                if (((AbstractList) this.f53637a.f53636e).modCount != this.f53640d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public final void add(Object obj) {
                a();
                int i2 = this.f53638b;
                this.f53638b = i2 + 1;
                BuilderSubList builderSubList = this.f53637a;
                builderSubList.add(i2, obj);
                this.f53639c = -1;
                this.f53640d = ((AbstractList) builderSubList).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final boolean hasNext() {
                return this.f53638b < this.f53637a.f53634c;
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return this.f53638b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final Object next() {
                a();
                int i2 = this.f53638b;
                BuilderSubList builderSubList = this.f53637a;
                if (i2 >= builderSubList.f53634c) {
                    throw new NoSuchElementException();
                }
                this.f53638b = i2 + 1;
                this.f53639c = i2;
                return builderSubList.f53632a[builderSubList.f53633b + i2];
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return this.f53638b;
            }

            @Override // java.util.ListIterator
            public final Object previous() {
                a();
                int i2 = this.f53638b;
                if (i2 <= 0) {
                    throw new NoSuchElementException();
                }
                int i3 = i2 - 1;
                this.f53638b = i3;
                this.f53639c = i3;
                BuilderSubList builderSubList = this.f53637a;
                return builderSubList.f53632a[builderSubList.f53633b + i3];
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return this.f53638b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final void remove() {
                a();
                int i2 = this.f53639c;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                BuilderSubList builderSubList = this.f53637a;
                builderSubList.d(i2);
                this.f53638b = this.f53639c;
                this.f53639c = -1;
                this.f53640d = ((AbstractList) builderSubList).modCount;
            }

            @Override // java.util.ListIterator
            public final void set(Object obj) {
                a();
                int i2 = this.f53639c;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.f53637a.set(i2, obj);
            }
        }

        public BuilderSubList(Object[] backing, int i2, int i3, BuilderSubList builderSubList, ListBuilder root) {
            Intrinsics.checkNotNullParameter(backing, "backing");
            Intrinsics.checkNotNullParameter(root, "root");
            this.f53632a = backing;
            this.f53633b = i2;
            this.f53634c = i3;
            this.f53635d = builderSubList;
            this.f53636e = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean add(Object obj) {
            k();
            j();
            i(this.f53633b + this.f53634c, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            k();
            j();
            int size = elements.size();
            g(this.f53633b + this.f53634c, elements, size);
            return size > 0;
        }

        @Override // kotlin.collections.AbstractMutableList
        public final int b() {
            j();
            return this.f53634c;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final void clear() {
            k();
            j();
            n(this.f53633b, this.f53634c);
        }

        @Override // kotlin.collections.AbstractMutableList
        public final Object d(int i2) {
            k();
            j();
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i3 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.b(i2, i3);
            return m(this.f53633b + i2);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            j();
            if (obj == this) {
                return true;
            }
            if (obj instanceof List) {
                return ListBuilderKt.a(this.f53632a, this.f53633b, this.f53634c, (List) obj);
            }
            return false;
        }

        public final void g(int i2, Collection collection, int i3) {
            ((java.util.AbstractList) this).modCount++;
            ListBuilder listBuilder = this.f53636e;
            BuilderSubList builderSubList = this.f53635d;
            if (builderSubList != null) {
                builderSubList.g(i2, collection, i3);
            } else {
                ListBuilder listBuilder2 = ListBuilder.f53628e;
                listBuilder.g(i2, collection, i3);
            }
            this.f53632a = listBuilder.f53629a;
            this.f53634c += i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            j();
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i3 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.b(i2, i3);
            return this.f53632a[this.f53633b + i2];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            j();
            Object[] objArr = this.f53632a;
            int i2 = this.f53634c;
            int iHashCode = 1;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = objArr[this.f53633b + i3];
                iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
            return iHashCode;
        }

        public final void i(int i2, Object obj) {
            ((java.util.AbstractList) this).modCount++;
            ListBuilder listBuilder = this.f53636e;
            BuilderSubList builderSubList = this.f53635d;
            if (builderSubList != null) {
                builderSubList.i(i2, obj);
            } else {
                ListBuilder listBuilder2 = ListBuilder.f53628e;
                listBuilder.i(i2, obj);
            }
            this.f53632a = listBuilder.f53629a;
            this.f53634c++;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            j();
            for (int i2 = 0; i2 < this.f53634c; i2++) {
                if (Intrinsics.b(this.f53632a[this.f53633b + i2], obj)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            j();
            return this.f53634c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator(0);
        }

        public final void j() {
            if (((java.util.AbstractList) this.f53636e).modCount != ((java.util.AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public final void k() {
            if (this.f53636e.f53631c) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            j();
            for (int i2 = this.f53634c - 1; i2 >= 0; i2--) {
                if (Intrinsics.b(this.f53632a[this.f53633b + i2], obj)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        public final Object m(int i2) {
            Object objN;
            ((java.util.AbstractList) this).modCount++;
            BuilderSubList builderSubList = this.f53635d;
            if (builderSubList != null) {
                objN = builderSubList.m(i2);
            } else {
                ListBuilder listBuilder = ListBuilder.f53628e;
                objN = this.f53636e.n(i2);
            }
            this.f53634c--;
            return objN;
        }

        public final void n(int i2, int i3) {
            if (i3 > 0) {
                ((java.util.AbstractList) this).modCount++;
            }
            BuilderSubList builderSubList = this.f53635d;
            if (builderSubList != null) {
                builderSubList.n(i2, i3);
            } else {
                ListBuilder listBuilder = ListBuilder.f53628e;
                this.f53636e.o(i2, i3);
            }
            this.f53634c -= i3;
        }

        public final int o(int i2, int i3, Collection collection, boolean z) {
            int iP;
            BuilderSubList builderSubList = this.f53635d;
            if (builderSubList != null) {
                iP = builderSubList.o(i2, i3, collection, z);
            } else {
                ListBuilder listBuilder = ListBuilder.f53628e;
                iP = this.f53636e.p(i2, i3, collection, z);
            }
            if (iP > 0) {
                ((java.util.AbstractList) this).modCount++;
            }
            this.f53634c -= iP;
            return iP;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean remove(Object obj) {
            k();
            j();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                d(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            k();
            j();
            return o(this.f53633b, this.f53634c, elements, false) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            k();
            j();
            return o(this.f53633b, this.f53634c, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            k();
            j();
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i3 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.b(i2, i3);
            Object[] objArr = this.f53632a;
            int i4 = this.f53633b + i2;
            Object obj2 = objArr[i4];
            objArr[i4] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i4 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.d(i2, i3, i4);
            return new BuilderSubList(this.f53632a, this.f53633b + i2, i3 - i2, this, this.f53636e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            j();
            int length = array.length;
            int i2 = this.f53634c;
            int i3 = this.f53633b;
            if (length < i2) {
                Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f53632a, i3, i2 + i3, array.getClass());
                Intrinsics.checkNotNullExpressionValue(objArrCopyOfRange, "copyOfRange(...)");
                return objArrCopyOfRange;
            }
            ArraysKt.m(this.f53632a, 0, array, i3, i2 + i3);
            CollectionsKt.a0(this.f53634c, array);
            return array;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            j();
            return ListBuilderKt.b(this.f53632a, this.f53633b, this.f53634c, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            j();
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i3 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.c(i2, i3);
            return new Itr(this, i2);
        }

        @Override // java.util.AbstractList, java.util.List
        public final void add(int i2, Object obj) {
            k();
            j();
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i3 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.c(i2, i3);
            i(this.f53633b + i2, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public final boolean addAll(int i2, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            k();
            j();
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int i3 = this.f53634c;
            companion.getClass();
            AbstractList.Companion.c(i2, i3);
            int size = elements.size();
            g(this.f53633b + i2, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray() {
            j();
            Object[] objArr = this.f53632a;
            int i2 = this.f53634c;
            int i3 = this.f53633b;
            return ArraysKt.p(objArr, i3, i2 + i3);
        }
    }

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {

        /* renamed from: a, reason: collision with root package name */
        public final ListBuilder f53641a;

        /* renamed from: b, reason: collision with root package name */
        public int f53642b;

        /* renamed from: c, reason: collision with root package name */
        public int f53643c;

        /* renamed from: d, reason: collision with root package name */
        public int f53644d;

        public Itr(ListBuilder list, int i2) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f53641a = list;
            this.f53642b = i2;
            this.f53643c = -1;
            this.f53644d = ((java.util.AbstractList) list).modCount;
        }

        public final void a() {
            if (((java.util.AbstractList) this.f53641a).modCount != this.f53644d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            a();
            int i2 = this.f53642b;
            this.f53642b = i2 + 1;
            ListBuilder listBuilder = this.f53641a;
            listBuilder.add(i2, obj);
            this.f53643c = -1;
            this.f53644d = ((java.util.AbstractList) listBuilder).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f53642b < this.f53641a.f53630b;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f53642b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            a();
            int i2 = this.f53642b;
            ListBuilder listBuilder = this.f53641a;
            if (i2 >= listBuilder.f53630b) {
                throw new NoSuchElementException();
            }
            this.f53642b = i2 + 1;
            this.f53643c = i2;
            return listBuilder.f53629a[i2];
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f53642b;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            a();
            int i2 = this.f53642b;
            if (i2 <= 0) {
                throw new NoSuchElementException();
            }
            int i3 = i2 - 1;
            this.f53642b = i3;
            this.f53643c = i3;
            return this.f53641a.f53629a[i3];
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f53642b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            a();
            int i2 = this.f53643c;
            if (i2 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            ListBuilder listBuilder = this.f53641a;
            listBuilder.d(i2);
            this.f53642b = this.f53643c;
            this.f53643c = -1;
            this.f53644d = ((java.util.AbstractList) listBuilder).modCount;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            a();
            int i2 = this.f53643c;
            if (i2 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f53641a.set(i2, obj);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.f53631c = true;
        f53628e = listBuilder;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        k();
        int i2 = this.f53630b;
        ((java.util.AbstractList) this).modCount++;
        m(i2, 1);
        this.f53629a[i2] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        k();
        int size = elements.size();
        g(this.f53630b, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int b() {
        return this.f53630b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        k();
        o(0, this.f53630b);
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object d(int i2) {
        k();
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i3 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.b(i2, i3);
        return n(i2);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (ListBuilderKt.a(this.f53629a, 0, this.f53630b, (List) obj)) {
                return true;
            }
        }
        return false;
    }

    public final void g(int i2, Collection collection, int i3) {
        ((java.util.AbstractList) this).modCount++;
        m(i2, i3);
        Iterator<E> it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f53629a[i2 + i4] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i3 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.b(i2, i3);
        return this.f53629a[i2];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f53629a;
        int i2 = this.f53630b;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, Object obj) {
        ((java.util.AbstractList) this).modCount++;
        m(i2, 1);
        this.f53629a[i2] = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f53630b; i2++) {
            if (Intrinsics.b(this.f53629a[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f53630b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final ListBuilder j() {
        k();
        this.f53631c = true;
        return this.f53630b > 0 ? this : f53628e;
    }

    public final void k() {
        if (this.f53631c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i2 = this.f53630b - 1; i2 >= 0; i2--) {
            if (Intrinsics.b(this.f53629a[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final void m(int i2, int i3) {
        int i4 = this.f53630b + i3;
        if (i4 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f53629a;
        if (i4 > objArr.length) {
            AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
            int length = objArr.length;
            companion.getClass();
            int iE = AbstractList.Companion.e(length, i4);
            Object[] objArr2 = this.f53629a;
            Intrinsics.checkNotNullParameter(objArr2, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, iE);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f53629a = objArrCopyOf;
        }
        Object[] objArr3 = this.f53629a;
        ArraysKt.m(objArr3, i2 + i3, objArr3, i2, this.f53630b);
        this.f53630b += i3;
    }

    public final Object n(int i2) {
        ((java.util.AbstractList) this).modCount++;
        Object[] objArr = this.f53629a;
        Object obj = objArr[i2];
        ArraysKt.m(objArr, i2, objArr, i2 + 1, this.f53630b);
        Object[] objArr2 = this.f53629a;
        int i3 = this.f53630b - 1;
        Intrinsics.checkNotNullParameter(objArr2, "<this>");
        objArr2[i3] = null;
        this.f53630b--;
        return obj;
    }

    public final void o(int i2, int i3) {
        if (i3 > 0) {
            ((java.util.AbstractList) this).modCount++;
        }
        Object[] objArr = this.f53629a;
        ArraysKt.m(objArr, i2, objArr, i2 + i3, this.f53630b);
        Object[] objArr2 = this.f53629a;
        int i4 = this.f53630b;
        ListBuilderKt.c(objArr2, i4 - i3, i4);
        this.f53630b -= i3;
    }

    public final int p(int i2, int i3, Collection collection, boolean z) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.f53629a[i6]) == z) {
                Object[] objArr = this.f53629a;
                i4++;
                objArr[i5 + i2] = objArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        Object[] objArr2 = this.f53629a;
        ArraysKt.m(objArr2, i2 + i5, objArr2, i3 + i2, this.f53630b);
        Object[] objArr3 = this.f53629a;
        int i8 = this.f53630b;
        ListBuilderKt.c(objArr3, i8 - i7, i8);
        if (i7 > 0) {
            ((java.util.AbstractList) this).modCount++;
        }
        this.f53630b -= i7;
        return i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        k();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            d(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        k();
        return p(0, this.f53630b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        k();
        return p(0, this.f53630b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        k();
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i3 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.b(i2, i3);
        Object[] objArr = this.f53629a;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i4 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.d(i2, i3, i4);
        return new BuilderSubList(this.f53629a, i2, i3 - i2, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i2 = this.f53630b;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f53629a, 0, i2, array.getClass());
            Intrinsics.checkNotNullExpressionValue(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        ArraysKt.m(this.f53629a, 0, array, 0, i2);
        CollectionsKt.a0(this.f53630b, array);
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return ListBuilderKt.b(this.f53629a, 0, this.f53630b, this);
    }

    public /* synthetic */ ListBuilder(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i3 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.c(i2, i3);
        return new Itr(this, i2);
    }

    public ListBuilder(int i2) {
        if (i2 >= 0) {
            this.f53629a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        k();
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i3 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.c(i2, i3);
        int size = elements.size();
        g(i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return ArraysKt.p(this.f53629a, 0, this.f53630b);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        k();
        AbstractList.Companion companion = kotlin.collections.AbstractList.f53584a;
        int i3 = this.f53630b;
        companion.getClass();
        AbstractList.Companion.c(i2, i3);
        ((java.util.AbstractList) this).modCount++;
        m(i2, 1);
        this.f53629a[i2] = obj;
    }
}
