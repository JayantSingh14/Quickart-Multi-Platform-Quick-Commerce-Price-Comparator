package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public abstract class zzgtd extends zzgsz implements List, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final zzgvs f33183b = new zzgtb(0, zzguy.f33232e);

    public static zzgtd n(Object obj) {
        Object[] objArr = {obj};
        zzguw.a(1, objArr);
        return t(1, objArr);
    }

    public static zzgtd o(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzguw.a(2, objArr);
        return t(2, objArr);
    }

    public static zzgtd p(Long l2, Long l3, Long l4, Long l5, Long l6) {
        Object[] objArr = {l2, l3, l4, l5, l6};
        zzguw.a(5, objArr);
        return t(5, objArr);
    }

    public static zzgtd q(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        int i2 = length + 12;
        Object[] objArr2 = new Object[i2];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        zzguw.a(i2, objArr2);
        return t(i2, objArr2);
    }

    public static zzgtd r(Collection collection) {
        if (!(collection instanceof zzgsz)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzguw.a(length, array);
            return t(length, array);
        }
        zzgtd zzgtdVarI = ((zzgsz) collection).i();
        if (!zzgtdVarI.j()) {
            return zzgtdVarI;
        }
        Object[] array2 = zzgtdVarI.toArray(zzgsz.f33174a);
        return t(array2.length, array2);
    }

    public static zzgtd s(Object[] objArr) {
        if (objArr.length == 0) {
            return zzguy.f33232e;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzguw.a(length, objArr2);
        return t(length, objArr2);
    }

    public static zzgtd t(int i2, Object[] objArr) {
        return i2 == 0 ? zzguy.f33232e : new zzguy(objArr, i2);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    /* renamed from: b */
    public final zzgvr iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i2 = 0; i2 < size; i2++) {
                if (!Objects.equals(get(i2), list.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equals(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode = (iHashCode * 31) + get(i2).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final zzgtd i() {
        return this;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
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

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public int k(int i2, Object[] objArr) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
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
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public zzgtd subList(int i2, int i3) {
        zzgqa.k(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? zzguy.f33232e : new zzgtc(this, i2, i4);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final zzgvs listIterator(int i2) {
        zzgqa.j(i2, size());
        return isEmpty() ? f33183b : new zzgtb(i2, this);
    }
}
