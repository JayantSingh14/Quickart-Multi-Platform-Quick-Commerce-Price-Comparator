package kotlin.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53601d = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final Object[] f53602e = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f53603a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f53604b = f53602e;

    /* renamed from: c, reason: collision with root package name */
    public int f53605c;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        n();
        g(elements.size() + b());
        f(m(b() + this.f53603a), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        g(this.f53605c + 1);
        int length = this.f53603a;
        if (length == 0) {
            Object[] objArr = this.f53604b;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            length = objArr.length;
        }
        int i2 = length - 1;
        this.f53603a = i2;
        this.f53604b[i2] = obj;
        this.f53605c++;
    }

    public final void addLast(Object obj) {
        n();
        g(b() + 1);
        this.f53604b[m(b() + this.f53603a)] = obj;
        this.f53605c = b() + 1;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int b() {
        return this.f53605c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            k(this.f53603a, m(b() + this.f53603a));
        }
        this.f53603a = 0;
        this.f53605c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object d(int i2) {
        AbstractList.Companion companion = AbstractList.f53584a;
        int i3 = this.f53605c;
        companion.getClass();
        AbstractList.Companion.b(i2, i3);
        if (i2 == CollectionsKt.B(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        n();
        int iM = m(this.f53603a + i2);
        Object[] objArr = this.f53604b;
        Object obj = objArr[iM];
        if (i2 < (this.f53605c >> 1)) {
            int i4 = this.f53603a;
            if (iM >= i4) {
                ArraysKt.m(objArr, i4 + 1, objArr, i4, iM);
            } else {
                ArraysKt.m(objArr, 1, objArr, 0, iM);
                Object[] objArr2 = this.f53604b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.f53603a;
                ArraysKt.m(objArr2, i5 + 1, objArr2, i5, objArr2.length - 1);
            }
            Object[] objArr3 = this.f53604b;
            int i6 = this.f53603a;
            objArr3[i6] = null;
            this.f53603a = i(i6);
        } else {
            int iM2 = m(CollectionsKt.B(this) + this.f53603a);
            if (iM <= iM2) {
                Object[] objArr4 = this.f53604b;
                ArraysKt.m(objArr4, iM, objArr4, iM + 1, iM2 + 1);
            } else {
                Object[] objArr5 = this.f53604b;
                ArraysKt.m(objArr5, iM, objArr5, iM + 1, objArr5.length);
                Object[] objArr6 = this.f53604b;
                objArr6[objArr6.length - 1] = objArr6[0];
                ArraysKt.m(objArr6, 0, objArr6, 1, iM2 + 1);
            }
            this.f53604b[iM2] = null;
        }
        this.f53605c--;
        return obj;
    }

    public final void f(int i2, Collection collection) {
        Iterator<E> it = collection.iterator();
        int length = this.f53604b.length;
        while (i2 < length && it.hasNext()) {
            this.f53604b[i2] = it.next();
            i2++;
        }
        int i3 = this.f53603a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f53604b[i4] = it.next();
        }
        this.f53605c = collection.size() + this.f53605c;
    }

    public final void g(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f53604b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == f53602e) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f53604b = new Object[i2];
            return;
        }
        AbstractList.Companion companion = AbstractList.f53584a;
        int length = objArr.length;
        companion.getClass();
        Object[] objArr2 = new Object[AbstractList.Companion.e(length, i2)];
        Object[] objArr3 = this.f53604b;
        ArraysKt.m(objArr3, 0, objArr2, this.f53603a, objArr3.length);
        Object[] objArr4 = this.f53604b;
        int length2 = objArr4.length;
        int i3 = this.f53603a;
        ArraysKt.m(objArr4, length2 - i3, objArr2, 0, i3);
        this.f53603a = 0;
        this.f53604b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        AbstractList.Companion companion = AbstractList.f53584a;
        int i3 = this.f53605c;
        companion.getClass();
        AbstractList.Companion.b(i2, i3);
        return this.f53604b[m(this.f53603a + i2)];
    }

    public final int i(int i2) {
        Intrinsics.checkNotNullParameter(this.f53604b, "<this>");
        if (i2 == r0.length - 1) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i2;
        int iM = m(b() + this.f53603a);
        int length = this.f53603a;
        if (length < iM) {
            while (length < iM) {
                if (Intrinsics.b(obj, this.f53604b[length])) {
                    i2 = this.f53603a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM) {
            return -1;
        }
        int length2 = this.f53604b.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iM; i3++) {
                    if (Intrinsics.b(obj, this.f53604b[i3])) {
                        length = i3 + this.f53604b.length;
                        i2 = this.f53603a;
                    }
                }
                return -1;
            }
            if (Intrinsics.b(obj, this.f53604b[length])) {
                i2 = this.f53603a;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return b() == 0;
    }

    public final int j(int i2) {
        return i2 < 0 ? i2 + this.f53604b.length : i2;
    }

    public final void k(int i2, int i3) {
        if (i2 < i3) {
            ArraysKt.q(this.f53604b, null, i2, i3);
            return;
        }
        Object[] objArr = this.f53604b;
        int length = objArr.length;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Arrays.fill(objArr, i2, length, (Object) null);
        ArraysKt.q(this.f53604b, null, 0, i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i2;
        int iM = m(this.f53605c + this.f53603a);
        int i3 = this.f53603a;
        if (i3 < iM) {
            length = iM - 1;
            if (i3 <= length) {
                while (!Intrinsics.b(obj, this.f53604b[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i2 = this.f53603a;
                return length - i2;
            }
            return -1;
        }
        if (i3 > iM) {
            int i4 = iM - 1;
            while (true) {
                if (-1 >= i4) {
                    Object[] objArr = this.f53604b;
                    Intrinsics.checkNotNullParameter(objArr, "<this>");
                    length = objArr.length - 1;
                    int i5 = this.f53603a;
                    if (i5 <= length) {
                        while (!Intrinsics.b(obj, this.f53604b[length])) {
                            if (length != i5) {
                                length--;
                            }
                        }
                        i2 = this.f53603a;
                    }
                } else {
                    if (Intrinsics.b(obj, this.f53604b[i4])) {
                        length = i4 + this.f53604b.length;
                        i2 = this.f53603a;
                        break;
                    }
                    i4--;
                }
            }
        }
        return -1;
    }

    public final int m(int i2) {
        Object[] objArr = this.f53604b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public final void n() {
        ((java.util.AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        d(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iM;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f53604b.length != 0) {
            int iM2 = m(this.f53605c + this.f53603a);
            int i2 = this.f53603a;
            if (i2 < iM2) {
                iM = i2;
                while (i2 < iM2) {
                    Object obj = this.f53604b[i2];
                    if (elements.contains(obj)) {
                        z = true;
                    } else {
                        this.f53604b[iM] = obj;
                        iM++;
                    }
                    i2++;
                }
                ArraysKt.q(this.f53604b, null, iM, iM2);
            } else {
                int length = this.f53604b.length;
                boolean z2 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f53604b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (elements.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.f53604b[i3] = obj2;
                        i3++;
                    }
                    i2++;
                }
                iM = m(i3);
                for (int i4 = 0; i4 < iM2; i4++) {
                    Object[] objArr2 = this.f53604b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.f53604b[iM] = obj3;
                        iM = i(iM);
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.f53605c = j(iM - this.f53603a);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.f53604b;
        int i2 = this.f53603a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f53603a = i(i2);
        this.f53605c = b() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int iM = m(CollectionsKt.B(this) + this.f53603a);
        Object[] objArr = this.f53604b;
        Object obj = objArr[iM];
        objArr[iM] = null;
        this.f53605c = b() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        AbstractList.Companion companion = AbstractList.f53584a;
        int i4 = this.f53605c;
        companion.getClass();
        AbstractList.Companion.d(i2, i3, i4);
        int i5 = i3 - i2;
        if (i5 == 0) {
            return;
        }
        if (i5 == this.f53605c) {
            clear();
            return;
        }
        if (i5 == 1) {
            d(i2);
            return;
        }
        n();
        if (i2 < this.f53605c - i3) {
            int iM = m((i2 - 1) + this.f53603a);
            int iM2 = m((i3 - 1) + this.f53603a);
            while (i2 > 0) {
                int i6 = iM + 1;
                int iMin = Math.min(i2, Math.min(i6, iM2 + 1));
                Object[] objArr = this.f53604b;
                int i7 = iM2 - iMin;
                int i8 = iM - iMin;
                ArraysKt.m(objArr, i7 + 1, objArr, i8 + 1, i6);
                iM = j(i8);
                iM2 = j(i7);
                i2 -= iMin;
            }
            int iM3 = m(this.f53603a + i5);
            k(this.f53603a, iM3);
            this.f53603a = iM3;
        } else {
            int iM4 = m(this.f53603a + i3);
            int iM5 = m(this.f53603a + i2);
            int i9 = this.f53605c;
            while (true) {
                i9 -= i3;
                if (i9 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f53604b;
                i3 = Math.min(i9, Math.min(objArr2.length - iM4, objArr2.length - iM5));
                Object[] objArr3 = this.f53604b;
                int i10 = iM4 + i3;
                ArraysKt.m(objArr3, iM5, objArr3, iM4, i10);
                iM4 = m(i10);
                iM5 = m(iM5 + i3);
            }
            int iM6 = m(this.f53605c + this.f53603a);
            k(j(iM6 - i5), iM6);
        }
        this.f53605c -= i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iM;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f53604b.length != 0) {
            int iM2 = m(this.f53605c + this.f53603a);
            int i2 = this.f53603a;
            if (i2 < iM2) {
                iM = i2;
                while (i2 < iM2) {
                    Object obj = this.f53604b[i2];
                    if (elements.contains(obj)) {
                        this.f53604b[iM] = obj;
                        iM++;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                ArraysKt.q(this.f53604b, null, iM, iM2);
            } else {
                int length = this.f53604b.length;
                boolean z2 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f53604b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (elements.contains(obj2)) {
                        this.f53604b[i3] = obj2;
                        i3++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                iM = m(i3);
                for (int i4 = 0; i4 < iM2; i4++) {
                    Object[] objArr2 = this.f53604b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        this.f53604b[iM] = obj3;
                        iM = i(iM);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.f53605c = j(iM - this.f53603a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        AbstractList.Companion companion = AbstractList.f53584a;
        int i3 = this.f53605c;
        companion.getClass();
        AbstractList.Companion.b(i2, i3);
        int iM = m(this.f53603a + i2);
        Object[] objArr = this.f53604b;
        Object obj2 = objArr[iM];
        objArr[iM] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[b()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int length;
        AbstractList.Companion companion = AbstractList.f53584a;
        int i3 = this.f53605c;
        companion.getClass();
        AbstractList.Companion.c(i2, i3);
        if (i2 == this.f53605c) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        n();
        g(this.f53605c + 1);
        int iM = m(this.f53603a + i2);
        int i4 = this.f53605c;
        if (i2 < ((i4 + 1) >> 1)) {
            if (iM == 0) {
                Object[] objArr = this.f53604b;
                Intrinsics.checkNotNullParameter(objArr, "<this>");
                iM = objArr.length;
            }
            int i5 = iM - 1;
            int i6 = this.f53603a;
            if (i6 == 0) {
                Object[] objArr2 = this.f53604b;
                Intrinsics.checkNotNullParameter(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i6 - 1;
            }
            int i7 = this.f53603a;
            if (i5 >= i7) {
                Object[] objArr3 = this.f53604b;
                objArr3[length] = objArr3[i7];
                ArraysKt.m(objArr3, i7, objArr3, i7 + 1, i5 + 1);
            } else {
                Object[] objArr4 = this.f53604b;
                ArraysKt.m(objArr4, i7 - 1, objArr4, i7, objArr4.length);
                Object[] objArr5 = this.f53604b;
                objArr5[objArr5.length - 1] = objArr5[0];
                ArraysKt.m(objArr5, 0, objArr5, 1, i5 + 1);
            }
            this.f53604b[i5] = obj;
            this.f53603a = length;
        } else {
            int iM2 = m(i4 + this.f53603a);
            if (iM < iM2) {
                Object[] objArr6 = this.f53604b;
                ArraysKt.m(objArr6, iM + 1, objArr6, iM, iM2);
            } else {
                Object[] objArr7 = this.f53604b;
                ArraysKt.m(objArr7, 1, objArr7, 0, iM2);
                Object[] objArr8 = this.f53604b;
                objArr8[0] = objArr8[objArr8.length - 1];
                ArraysKt.m(objArr8, iM + 1, objArr8, iM, objArr8.length - 1);
            }
            this.f53604b[iM] = obj;
        }
        this.f53605c++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] reference) throws NegativeArraySizeException {
        Intrinsics.checkNotNullParameter(reference, "array");
        int length = reference.length;
        int i2 = this.f53605c;
        if (length < i2) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i2);
            Intrinsics.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            reference = (Object[]) objNewInstance;
        }
        int iM = m(this.f53605c + this.f53603a);
        int i3 = this.f53603a;
        if (i3 < iM) {
            ArraysKt.n(this.f53604b, i3, reference, iM, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f53604b;
            ArraysKt.m(objArr, 0, reference, this.f53603a, objArr.length);
            Object[] objArr2 = this.f53604b;
            ArraysKt.m(objArr2, objArr2.length - this.f53603a, reference, 0, iM);
        }
        CollectionsKt.a0(this.f53605c, reference);
        return reference;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion companion = AbstractList.f53584a;
        int i3 = this.f53605c;
        companion.getClass();
        AbstractList.Companion.c(i2, i3);
        if (elements.isEmpty()) {
            return false;
        }
        if (i2 == this.f53605c) {
            return addAll(elements);
        }
        n();
        g(elements.size() + this.f53605c);
        int iM = m(this.f53605c + this.f53603a);
        int iM2 = m(this.f53603a + i2);
        int size = elements.size();
        if (i2 < ((this.f53605c + 1) >> 1)) {
            int i4 = this.f53603a;
            int length = i4 - size;
            if (iM2 < i4) {
                Object[] objArr = this.f53604b;
                ArraysKt.m(objArr, length, objArr, i4, objArr.length);
                if (size >= iM2) {
                    Object[] objArr2 = this.f53604b;
                    ArraysKt.m(objArr2, objArr2.length - size, objArr2, 0, iM2);
                } else {
                    Object[] objArr3 = this.f53604b;
                    ArraysKt.m(objArr3, objArr3.length - size, objArr3, 0, size);
                    Object[] objArr4 = this.f53604b;
                    ArraysKt.m(objArr4, 0, objArr4, size, iM2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f53604b;
                ArraysKt.m(objArr5, length, objArr5, i4, iM2);
            } else {
                Object[] objArr6 = this.f53604b;
                length += objArr6.length;
                int i5 = iM2 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    ArraysKt.m(objArr6, length, objArr6, i4, iM2);
                } else {
                    ArraysKt.m(objArr6, length, objArr6, i4, i4 + length2);
                    Object[] objArr7 = this.f53604b;
                    ArraysKt.m(objArr7, 0, objArr7, this.f53603a + length2, iM2);
                }
            }
            this.f53603a = length;
            f(j(iM2 - size), elements);
            return true;
        }
        int i6 = iM2 + size;
        if (iM2 < iM) {
            int i7 = size + iM;
            Object[] objArr8 = this.f53604b;
            if (i7 <= objArr8.length) {
                ArraysKt.m(objArr8, i6, objArr8, iM2, iM);
            } else if (i6 >= objArr8.length) {
                ArraysKt.m(objArr8, i6 - objArr8.length, objArr8, iM2, iM);
            } else {
                int length3 = iM - (i7 - objArr8.length);
                ArraysKt.m(objArr8, 0, objArr8, length3, iM);
                Object[] objArr9 = this.f53604b;
                ArraysKt.m(objArr9, i6, objArr9, iM2, length3);
            }
        } else {
            Object[] objArr10 = this.f53604b;
            ArraysKt.m(objArr10, size, objArr10, 0, iM);
            Object[] objArr11 = this.f53604b;
            if (i6 >= objArr11.length) {
                ArraysKt.m(objArr11, i6 - objArr11.length, objArr11, iM2, objArr11.length);
            } else {
                ArraysKt.m(objArr11, 0, objArr11, objArr11.length - size, objArr11.length);
                Object[] objArr12 = this.f53604b;
                ArraysKt.m(objArr12, i6, objArr12, iM2, objArr12.length - size);
            }
        }
        f(iM2, elements);
        return true;
    }
}
