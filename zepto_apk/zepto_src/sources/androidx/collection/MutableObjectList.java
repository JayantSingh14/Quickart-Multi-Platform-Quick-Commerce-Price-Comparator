package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableObjectList<E> extends ObjectList<E> {

    @Metadata
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, KMutableListIterator {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1492a;

        /* renamed from: b, reason: collision with root package name */
        public int f1493b;

        public MutableObjectListIterator(List list, int i2) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f1492a = list;
            this.f1493b = i2 - 1;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator
        public final void add(Object obj) {
            int i2 = this.f1493b + 1;
            this.f1493b = i2;
            this.f1492a.add(i2, obj);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f1493b < this.f1492a.size() - 1;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f1493b >= 0;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            int i2 = this.f1493b + 1;
            this.f1493b = i2;
            return this.f1492a.get(i2);
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f1493b + 1;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator
        public final Object previous() {
            int i2 = this.f1493b;
            this.f1493b = i2 - 1;
            return this.f1492a.get(i2);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f1493b;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            this.f1492a.remove(this.f1493b);
            this.f1493b--;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator
        public final void set(Object obj) {
            this.f1492a.set(this.f1493b, obj);
        }
    }

    @Metadata
    public static final class ObjectListMutableList<T> implements List<T>, KMutableList {
        @Override // java.util.List, java.util.Collection
        public final boolean add(Object obj) {
            throw null;
        }

        @Override // java.util.List
        public final boolean addAll(int i2, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            ObjectListKt.a(i2, this);
            throw null;
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            throw null;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            throw null;
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // java.util.List
        public final Object set(int i2, Object obj) {
            ObjectListKt.a(i2, this);
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            throw null;
        }

        @Override // java.util.List
        public final List subList(int i2, int i3) {
            ObjectListKt.b(i2, i3, this);
            return new SubList(i2, i3, this);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List
        public final void add(int i2, Object obj) {
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i2) {
            return new MutableObjectListIterator(this, i2);
        }

        @Override // java.util.List
        public final Object remove(int i2) {
            ObjectListKt.a(i2, this);
            throw null;
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.b(this, array);
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class SubList<T> implements List<T>, KMutableList {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1494a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1495b;

        /* renamed from: c, reason: collision with root package name */
        public int f1496c;

        public SubList(int i2, int i3, List list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f1494a = list;
            this.f1495b = i2;
            this.f1496c = i3;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean add(Object obj) {
            int i2 = this.f1496c;
            this.f1496c = i2 + 1;
            this.f1494a.add(i2, obj);
            return true;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final boolean addAll(int i2, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.f1494a.addAll(i2 + this.f1495b, elements);
            this.f1496c = elements.size() + this.f1496c;
            return elements.size() > 0;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final void clear() {
            int i2 = this.f1496c - 1;
            int i3 = this.f1495b;
            if (i3 <= i2) {
                while (true) {
                    this.f1494a.remove(i2);
                    if (i2 == i3) {
                        break;
                    } else {
                        i2--;
                    }
                }
            }
            this.f1496c = i3;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            int i2 = this.f1496c;
            for (int i3 = this.f1495b; i3 < i2; i3++) {
                if (Intrinsics.b(this.f1494a.get(i3), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final Object get(int i2) {
            ObjectListKt.a(i2, this);
            return this.f1494a.get(i2 + this.f1495b);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final int indexOf(Object obj) {
            int i2 = this.f1496c;
            int i3 = this.f1495b;
            for (int i4 = i3; i4 < i2; i4++) {
                if (Intrinsics.b(this.f1494a.get(i4), obj)) {
                    return i4 - i3;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f1496c == this.f1495b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            int i2 = this.f1496c - 1;
            int i3 = this.f1495b;
            if (i3 > i2) {
                return -1;
            }
            while (!Intrinsics.b(this.f1494a.get(i2), obj)) {
                if (i2 == i3) {
                    return -1;
                }
                i2--;
            }
            return i2 - i3;
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            int i2 = this.f1496c;
            for (int i3 = this.f1495b; i3 < i2; i3++) {
                ?? r2 = this.f1494a;
                if (Intrinsics.b(r2.get(i3), obj)) {
                    r2.remove(i3);
                    this.f1496c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int i2 = this.f1496c;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i2 != this.f1496c;
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int i2 = this.f1496c;
            int i3 = i2 - 1;
            int i4 = this.f1495b;
            if (i4 <= i3) {
                while (true) {
                    ?? r3 = this.f1494a;
                    if (!elements.contains(r3.get(i3))) {
                        r3.remove(i3);
                        this.f1496c--;
                    }
                    if (i3 == i4) {
                        break;
                    }
                    i3--;
                }
            }
            return i2 != this.f1496c;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final Object set(int i2, Object obj) {
            ObjectListKt.a(i2, this);
            return this.f1494a.set(i2 + this.f1495b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f1496c - this.f1495b;
        }

        @Override // java.util.List
        public final List subList(int i2, int i3) {
            ObjectListKt.b(i2, i3, this);
            return new SubList(i2, i3, this);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.a(this);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final void add(int i2, Object obj) {
            this.f1494a.add(i2 + this.f1495b, obj);
            this.f1496c++;
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i2) {
            return new MutableObjectListIterator(this, i2);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.b(this, array);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.f1494a.addAll(this.f1496c, elements);
            this.f1496c = elements.size() + this.f1496c;
            return elements.size() > 0;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final Object remove(int i2) {
            ObjectListKt.a(i2, this);
            this.f1496c--;
            return this.f1494a.remove(i2 + this.f1495b);
        }
    }

    public MutableObjectList(int i2) {
        this.f1551a = i2 == 0 ? ObjectListKt.f1553a : new Object[i2];
    }

    public MutableObjectList() {
        this(16);
    }
}
