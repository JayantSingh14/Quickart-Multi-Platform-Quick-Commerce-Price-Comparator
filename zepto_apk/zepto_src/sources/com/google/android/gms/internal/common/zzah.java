package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public abstract class zzah extends zzac implements List, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final zzal f36487b = new zzae(zzaj.f36488e, 0);

    public static zzah o() {
        return zzaj.f36488e;
    }

    public static zzah p(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return q((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return zzaj.f36488e;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            Object[] objArr = {next};
            zzai.a(1, objArr);
            return r(1, objArr);
        }
        zzad zzadVar = new zzad();
        zzadVar.a(next);
        while (it.hasNext()) {
            zzadVar.a(it.next());
        }
        return zzadVar.c();
    }

    public static zzah q(Collection collection) {
        if (!(collection instanceof zzac)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzai.a(length, array);
            return r(length, array);
        }
        zzah zzahVarI = ((zzac) collection).i();
        if (!zzahVarI.j()) {
            return zzahVarI;
        }
        Object[] array2 = zzahVarI.toArray(zzac.f36481a);
        return r(array2.length, array2);
    }

    public static zzah r(int i2, Object[] objArr) {
        return i2 == 0 ? zzaj.f36488e : new zzaj(objArr, i2);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.common.zzac
    /* renamed from: b */
    public final zzak iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
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

    @Override // com.google.android.gms.internal.common.zzac
    public final zzah i() {
        return this;
    }

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

    @Override // com.google.android.gms.internal.common.zzac, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.common.zzac
    public void k(Object[] objArr) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
    }

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
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    public zzah m() {
        return size() <= 1 ? this : new zzaf(this);
    }

    @Override // java.util.List
    /* renamed from: n */
    public zzah subList(int i2, int i3) {
        zzr.c(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? zzaj.f36488e : new zzag(this, i2, i4);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final zzal listIterator(int i2) {
        zzr.b(i2, size());
        return isEmpty() ? f36487b : new zzae(this, i2);
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }
}
