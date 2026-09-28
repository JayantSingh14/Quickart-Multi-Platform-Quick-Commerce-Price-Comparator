package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@ElementTypesAreNonnullByDefault
@Immutable
@GwtCompatible
/* loaded from: classes4.dex */
public final class ImmutableIntArray implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableIntArray f43304d = new ImmutableIntArray(0, 0, new int[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f43305a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f43306b;

    /* renamed from: c, reason: collision with root package name */
    public final int f43307c;

    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableIntArray f43308a;

        public AsList(ImmutableIntArray immutableIntArray) {
            this.f43308a = immutableIntArray;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            boolean z = obj instanceof AsList;
            ImmutableIntArray immutableIntArray = this.f43308a;
            if (z) {
                return immutableIntArray.equals(((AsList) obj).f43308a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (immutableIntArray.a() != list.size()) {
                return false;
            }
            int i2 = immutableIntArray.f43306b;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i3 = i2 + 1;
                    if (immutableIntArray.f43305a[i2] == ((Integer) obj2).intValue()) {
                        i2 = i3;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            ImmutableIntArray immutableIntArray = this.f43308a;
            Preconditions.i(i2, immutableIntArray.a());
            return Integer.valueOf(immutableIntArray.f43305a[immutableIntArray.f43306b + i2]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            return this.f43308a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                ImmutableIntArray immutableIntArray = this.f43308a;
                int i2 = immutableIntArray.f43306b;
                for (int i3 = i2; i3 < immutableIntArray.f43307c; i3++) {
                    if (immutableIntArray.f43305a[i3] == iIntValue) {
                        return i3 - i2;
                    }
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            int i2;
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                ImmutableIntArray immutableIntArray = this.f43308a;
                int i3 = immutableIntArray.f43307c;
                do {
                    i3--;
                    i2 = immutableIntArray.f43306b;
                    if (i3 >= i2) {
                    }
                } while (immutableIntArray.f43305a[i3] != iIntValue);
                return i3 - i2;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f43308a.a();
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            ImmutableIntArray immutableIntArray;
            ImmutableIntArray immutableIntArray2 = this.f43308a;
            Preconditions.l(i2, i3, immutableIntArray2.a());
            if (i2 == i3) {
                immutableIntArray = ImmutableIntArray.f43304d;
            } else {
                int i4 = immutableIntArray2.f43306b;
                immutableIntArray = new ImmutableIntArray(i2 + i4, i4 + i3, immutableIntArray2.f43305a);
            }
            return new AsList(immutableIntArray);
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            return this.f43308a.toString();
        }
    }

    public static final class Builder {
    }

    public ImmutableIntArray(int i2, int i3, int[] iArr) {
        this.f43305a = iArr;
        this.f43306b = i2;
        this.f43307c = i3;
    }

    public final int a() {
        return this.f43307c - this.f43306b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableIntArray) {
            ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
            if (a() == immutableIntArray.a()) {
                for (int i2 = 0; i2 < a(); i2++) {
                    Preconditions.i(i2, a());
                    int i3 = this.f43305a[this.f43306b + i2];
                    Preconditions.i(i2, immutableIntArray.a());
                    if (i3 == immutableIntArray.f43305a[immutableIntArray.f43306b + i2]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = this.f43306b; i3 < this.f43307c; i3++) {
            i2 = (i2 * 31) + this.f43305a[i3];
        }
        return i2;
    }

    public final String toString() {
        int i2 = this.f43307c;
        int i3 = this.f43306b;
        if (i2 == i3) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(a() * 5);
        sb.append('[');
        int[] iArr = this.f43305a;
        sb.append(iArr[i3]);
        while (true) {
            i3++;
            if (i3 >= i2) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i3]);
        }
    }
}
