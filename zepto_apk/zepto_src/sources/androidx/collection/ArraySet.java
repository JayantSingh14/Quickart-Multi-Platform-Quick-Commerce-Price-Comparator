package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1401a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1402b;

    /* renamed from: c, reason: collision with root package name */
    public int f1403c;

    @Metadata
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.f1403c);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public final Object a(int i2) {
            return ArraySet.this.f1402b[i2];
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public final void b(int i2) {
            ArraySet.this.b(i2);
        }
    }

    public ArraySet(int i2) {
        this.f1401a = ContainerHelpersKt.f1610a;
        this.f1402b = ContainerHelpersKt.f1612c;
        if (i2 > 0) {
            ArraySetKt.a(this, i2);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i2;
        int iB;
        int i3 = this.f1403c;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            iB = ArraySetKt.b(this, null, 0);
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iB = ArraySetKt.b(this, obj, iHashCode);
        }
        if (iB >= 0) {
            return false;
        }
        int i4 = ~iB;
        int[] iArr = this.f1401a;
        if (i3 >= iArr.length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f1402b;
            ArraySetKt.a(this, i5);
            if (i3 != this.f1403c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f1401a;
            if (iArr2.length != 0) {
                ArraysKt.k(0, 0, iArr.length, iArr, iArr2);
                ArraysKt.n(objArr, 0, this.f1402b, objArr.length, 6);
            }
        }
        if (i4 < i3) {
            int[] iArr3 = this.f1401a;
            int i6 = i4 + 1;
            ArraysKt.k(i6, i4, i3, iArr3, iArr3);
            Object[] objArr2 = this.f1402b;
            ArraysKt.m(objArr2, i6, objArr2, i4, i3);
        }
        int i7 = this.f1403c;
        if (i3 == i7) {
            int[] iArr4 = this.f1401a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i2;
                this.f1402b[i4] = obj;
                this.f1403c = i7 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = elements.size() + this.f1403c;
        int i2 = this.f1403c;
        int[] iArr = this.f1401a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f1402b;
            ArraySetKt.a(this, size);
            int i3 = this.f1403c;
            if (i3 > 0) {
                ArraysKt.k(0, 0, i3, iArr, this.f1401a);
                ArraysKt.n(objArr, 0, this.f1402b, this.f1403c, 6);
            }
        }
        if (this.f1403c != i2) {
            throw new ConcurrentModificationException();
        }
        Iterator<E> it = elements.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object b(int i2) {
        int i3 = this.f1403c;
        Object[] objArr = this.f1402b;
        Object obj = objArr[i2];
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i4 = i3 - 1;
        int[] iArr = this.f1401a;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i2 < i4) {
                int i5 = i2 + 1;
                ArraysKt.k(i2, i5, i3, iArr, iArr);
                Object[] objArr2 = this.f1402b;
                ArraysKt.m(objArr2, i2, objArr2, i5, i3);
            }
            this.f1402b[i4] = null;
        } else {
            ArraySetKt.a(this, i3 > 8 ? i3 + (i3 >> 1) : 8);
            if (i2 > 0) {
                ArraysKt.k(0, 0, i2, iArr, this.f1401a);
                ArraysKt.n(objArr, 0, this.f1402b, i2, 6);
            }
            if (i2 < i4) {
                int i6 = i2 + 1;
                ArraysKt.k(i2, i6, i3, iArr, this.f1401a);
                ArraysKt.m(objArr, i2, this.f1402b, i6, i3);
            }
        }
        if (i3 != this.f1403c) {
            throw new ConcurrentModificationException();
        }
        this.f1403c = i4;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f1403c != 0) {
            int[] iArr = ContainerHelpersKt.f1610a;
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.f1401a = iArr;
            Object[] objArr = ContainerHelpersKt.f1612c;
            Intrinsics.checkNotNullParameter(objArr, "<set-?>");
            this.f1402b = objArr;
            this.f1403c = 0;
        }
        if (this.f1403c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int iB;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            iB = ArraySetKt.b(this, null, 0);
        } else {
            iB = ArraySetKt.b(this, obj, obj.hashCode());
        }
        return iB >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f1403c != ((Set) obj).size()) {
            return false;
        }
        try {
            int i2 = this.f1403c;
            for (int i3 = 0; i3 < i2; i3++) {
                if (!((Set) obj).contains(this.f1402b[i3])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f1401a;
        int i2 = this.f1403c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f1403c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iB;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            iB = ArraySetKt.b(this, null, 0);
        } else {
            iB = ArraySetKt.b(this, obj, obj.hashCode());
        }
        if (iB < 0) {
            return false;
        }
        b(iB);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<E> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        for (int i2 = this.f1403c - 1; -1 < i2; i2--) {
            if (!CollectionsKt.s(elements, this.f1402b[i2])) {
                b(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f1403c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.p(this.f1402b, 0, this.f1403c);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1403c * 14);
        sb.append('{');
        int i2 = this.f1403c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f1402b[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        Object[] result = ArraySetJvmUtil.a(this.f1403c, array);
        ArraysKt.m(this.f1402b, 0, result, 0, this.f1403c);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @JvmOverloads
    public ArraySet() {
        this(0);
    }
}
