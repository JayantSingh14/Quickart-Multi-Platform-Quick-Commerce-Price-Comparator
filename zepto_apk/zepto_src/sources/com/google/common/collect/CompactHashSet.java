package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient Object f42566a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f42567b;

    /* renamed from: c, reason: collision with root package name */
    public transient Object[] f42568c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f42569d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f42570e;

    public CompactHashSet(int i2) {
        k(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int iMin;
        if (o()) {
            d();
        }
        Set setG = g();
        if (setG != null) {
            return setG.add(obj);
        }
        int[] iArrQ = q();
        Object[] objArrP = p();
        int i2 = this.f42570e;
        int i3 = i2 + 1;
        int iC = Hashing.c(obj);
        int iS = (1 << (this.f42569d & 31)) - 1;
        int i4 = iC & iS;
        Object obj2 = this.f42566a;
        Objects.requireNonNull(obj2);
        int iE = CompactHashing.e(i4, obj2);
        if (iE != 0) {
            int i5 = ~iS;
            int i6 = iC & i5;
            int i7 = 0;
            while (true) {
                int i8 = iE - 1;
                int i9 = iArrQ[i8];
                if ((i9 & i5) == i6 && com.google.common.base.Objects.a(obj, objArrP[i8])) {
                    return false;
                }
                int i10 = i9 & iS;
                i7++;
                if (i10 != 0) {
                    iE = i10;
                } else {
                    if (i7 >= 9) {
                        return f().add(obj);
                    }
                    if (i3 > iS) {
                        iS = s(iS, CompactHashing.c(iS), iC, i2);
                    } else {
                        iArrQ[i8] = CompactHashing.b(i9, i3, iS);
                    }
                }
            }
        } else if (i3 > iS) {
            iS = s(iS, CompactHashing.c(iS), iC, i2);
        } else {
            Object obj3 = this.f42566a;
            Objects.requireNonNull(obj3);
            CompactHashing.f(i4, i3, obj3);
        }
        int length = q().length;
        if (i3 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            r(iMin);
        }
        m(obj, i2, iC, iS);
        this.f42570e = i3;
        this.f42569d += 32;
        return true;
    }

    public int b(int i2, int i3) {
        return i2 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (o()) {
            return;
        }
        this.f42569d += 32;
        Set setG = g();
        if (setG != null) {
            this.f42569d = Ints.c(size(), 3);
            setG.clear();
            this.f42566a = null;
            this.f42570e = 0;
            return;
        }
        Arrays.fill(p(), 0, this.f42570e, (Object) null);
        Object obj = this.f42566a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(q(), 0, this.f42570e, 0);
        this.f42570e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (o()) {
            return false;
        }
        Set setG = g();
        if (setG != null) {
            return setG.contains(obj);
        }
        int iC = Hashing.c(obj);
        int i2 = (1 << (this.f42569d & 31)) - 1;
        Object obj2 = this.f42566a;
        Objects.requireNonNull(obj2);
        int iE = CompactHashing.e(iC & i2, obj2);
        if (iE == 0) {
            return false;
        }
        int i3 = ~i2;
        int i4 = iC & i3;
        do {
            int i5 = iE - 1;
            int i6 = q()[i5];
            if ((i6 & i3) == i4 && com.google.common.base.Objects.a(obj, p()[i5])) {
                return true;
            }
            iE = i6 & i2;
        } while (iE != 0);
        return false;
    }

    public int d() {
        Preconditions.m("Arrays already allocated", o());
        int i2 = this.f42569d;
        int iMax = Math.max(4, Hashing.a(i2 + 1, 1.0d));
        this.f42566a = CompactHashing.a(iMax);
        this.f42569d = CompactHashing.b(this.f42569d, 32 - Integer.numberOfLeadingZeros(iMax - 1), 31);
        this.f42567b = new int[i2];
        this.f42568c = new Object[i2];
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkedHashSet f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(1 << (this.f42569d & 31), 1.0f);
        int i2 = i();
        while (i2 >= 0) {
            linkedHashSet.add(p()[i2]);
            i2 = j(i2);
        }
        this.f42566a = linkedHashSet;
        this.f42567b = null;
        this.f42568c = null;
        this.f42569d += 32;
        return linkedHashSet;
    }

    public final Set g() {
        Object obj = this.f42566a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public int i() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Set setG = g();
        return setG != null ? setG.iterator() : new Iterator<Object>() { // from class: com.google.common.collect.CompactHashSet.1

            /* renamed from: a, reason: collision with root package name */
            public int f42571a;

            /* renamed from: b, reason: collision with root package name */
            public int f42572b;

            /* renamed from: c, reason: collision with root package name */
            public int f42573c = -1;

            {
                this.f42571a = CompactHashSet.this.f42569d;
                this.f42572b = CompactHashSet.this.i();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f42572b >= 0;
            }

            @Override // java.util.Iterator
            public final Object next() {
                CompactHashSet compactHashSet = CompactHashSet.this;
                if (compactHashSet.f42569d != this.f42571a) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i2 = this.f42572b;
                this.f42573c = i2;
                Object obj = compactHashSet.p()[i2];
                this.f42572b = compactHashSet.j(this.f42572b);
                return obj;
            }

            @Override // java.util.Iterator
            public final void remove() {
                CompactHashSet compactHashSet = CompactHashSet.this;
                if (compactHashSet.f42569d != this.f42571a) {
                    throw new ConcurrentModificationException();
                }
                CollectPreconditions.d(this.f42573c >= 0);
                this.f42571a += 32;
                compactHashSet.remove(compactHashSet.p()[this.f42573c]);
                this.f42572b = compactHashSet.b(this.f42572b, this.f42573c);
                this.f42573c = -1;
            }
        };
    }

    public int j(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f42570e) {
            return i3;
        }
        return -1;
    }

    public void k(int i2) {
        Preconditions.g(i2 >= 0, "Expected size must be >= 0");
        this.f42569d = Ints.c(i2, 1);
    }

    public void m(Object obj, int i2, int i3, int i4) {
        q()[i2] = CompactHashing.b(i3, 0, i4);
        p()[i2] = obj;
    }

    public void n(int i2, int i3) {
        Object obj = this.f42566a;
        Objects.requireNonNull(obj);
        int[] iArrQ = q();
        Object[] objArrP = p();
        int size = size();
        int i4 = size - 1;
        if (i2 >= i4) {
            objArrP[i2] = null;
            iArrQ[i2] = 0;
            return;
        }
        Object obj2 = objArrP[i4];
        objArrP[i2] = obj2;
        objArrP[i4] = null;
        iArrQ[i2] = iArrQ[i4];
        iArrQ[i4] = 0;
        int iC = Hashing.c(obj2) & i3;
        int iE = CompactHashing.e(iC, obj);
        if (iE == size) {
            CompactHashing.f(iC, i2 + 1, obj);
            return;
        }
        while (true) {
            int i5 = iE - 1;
            int i6 = iArrQ[i5];
            int i7 = i6 & i3;
            if (i7 == size) {
                iArrQ[i5] = CompactHashing.b(i6, i2 + 1, i3);
                return;
            }
            iE = i7;
        }
    }

    public final boolean o() {
        return this.f42566a == null;
    }

    public final Object[] p() {
        Object[] objArr = this.f42568c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int[] q() {
        int[] iArr = this.f42567b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public void r(int i2) {
        this.f42567b = Arrays.copyOf(q(), i2);
        this.f42568c = Arrays.copyOf(p(), i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (o()) {
            return false;
        }
        Set setG = g();
        if (setG != null) {
            return setG.remove(obj);
        }
        int i2 = (1 << (this.f42569d & 31)) - 1;
        Object obj2 = this.f42566a;
        Objects.requireNonNull(obj2);
        int iD = CompactHashing.d(obj, null, i2, obj2, q(), p(), null);
        if (iD == -1) {
            return false;
        }
        n(iD, i2);
        this.f42570e--;
        this.f42569d += 32;
        return true;
    }

    public final int s(int i2, int i3, int i4, int i5) {
        Object objA = CompactHashing.a(i3);
        int i6 = i3 - 1;
        if (i5 != 0) {
            CompactHashing.f(i4 & i6, i5 + 1, objA);
        }
        Object obj = this.f42566a;
        Objects.requireNonNull(obj);
        int[] iArrQ = q();
        for (int i7 = 0; i7 <= i2; i7++) {
            int iE = CompactHashing.e(i7, obj);
            while (iE != 0) {
                int i8 = iE - 1;
                int i9 = iArrQ[i8];
                int i10 = ((~i2) & i9) | i7;
                int i11 = i10 & i6;
                int iE2 = CompactHashing.e(i11, objA);
                CompactHashing.f(i11, iE, objA);
                iArrQ[i8] = CompactHashing.b(i10, iE2, i6);
                iE = i9 & i2;
            }
        }
        this.f42566a = objA;
        this.f42569d = CompactHashing.b(this.f42569d, 32 - Integer.numberOfLeadingZeros(i6), 31);
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set setG = g();
        return setG != null ? setG.size() : this.f42570e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (o()) {
            return new Object[0];
        }
        Set setG = g();
        return setG != null ? setG.toArray() : Arrays.copyOf(p(), this.f42570e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (o()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set setG = g();
        if (setG != null) {
            return setG.toArray(objArr);
        }
        Object[] objArrP = p();
        int i2 = this.f42570e;
        Preconditions.l(0, i2, objArrP.length);
        if (objArr.length < i2) {
            objArr = Platform.b(i2, objArr);
        } else if (objArr.length > i2) {
            objArr[i2] = null;
        }
        System.arraycopy(objArrP, 0, objArr, 0, i2);
        return objArr;
    }
}
