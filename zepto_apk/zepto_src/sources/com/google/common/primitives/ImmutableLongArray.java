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
public final class ImmutableLongArray implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableLongArray f43309d = new ImmutableLongArray(new long[0], 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long[] f43310a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f43311b;

    /* renamed from: c, reason: collision with root package name */
    public final int f43312c;

    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableLongArray f43313a;

        public AsList(ImmutableLongArray immutableLongArray) {
            this.f43313a = immutableLongArray;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            boolean z = obj instanceof AsList;
            ImmutableLongArray immutableLongArray = this.f43313a;
            if (z) {
                return immutableLongArray.equals(((AsList) obj).f43313a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (immutableLongArray.a() != list.size()) {
                return false;
            }
            int i2 = immutableLongArray.f43311b;
            for (Object obj2 : list) {
                if (obj2 instanceof Long) {
                    int i3 = i2 + 1;
                    if (immutableLongArray.f43310a[i2] == ((Long) obj2).longValue()) {
                        i2 = i3;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            ImmutableLongArray immutableLongArray = this.f43313a;
            Preconditions.i(i2, immutableLongArray.a());
            return Long.valueOf(immutableLongArray.f43310a[immutableLongArray.f43311b + i2]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            return this.f43313a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Long) {
                long jLongValue = ((Long) obj).longValue();
                ImmutableLongArray immutableLongArray = this.f43313a;
                int i2 = immutableLongArray.f43311b;
                for (int i3 = i2; i3 < immutableLongArray.f43312c; i3++) {
                    if (immutableLongArray.f43310a[i3] == jLongValue) {
                        return i3 - i2;
                    }
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            int i2;
            if (obj instanceof Long) {
                long jLongValue = ((Long) obj).longValue();
                ImmutableLongArray immutableLongArray = this.f43313a;
                int i3 = immutableLongArray.f43312c;
                do {
                    i3--;
                    i2 = immutableLongArray.f43311b;
                    if (i3 >= i2) {
                    }
                } while (immutableLongArray.f43310a[i3] != jLongValue);
                return i3 - i2;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f43313a.a();
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            ImmutableLongArray immutableLongArray;
            ImmutableLongArray immutableLongArray2 = this.f43313a;
            Preconditions.l(i2, i3, immutableLongArray2.a());
            if (i2 == i3) {
                immutableLongArray = ImmutableLongArray.f43309d;
            } else {
                int i4 = immutableLongArray2.f43311b;
                immutableLongArray = new ImmutableLongArray(immutableLongArray2.f43310a, i2 + i4, i4 + i3);
            }
            return new AsList(immutableLongArray);
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            return this.f43313a.toString();
        }
    }

    public static final class Builder {
    }

    public ImmutableLongArray(long[] jArr, int i2, int i3) {
        this.f43310a = jArr;
        this.f43311b = i2;
        this.f43312c = i3;
    }

    public final int a() {
        return this.f43312c - this.f43311b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableLongArray) {
            ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
            if (a() == immutableLongArray.a()) {
                for (int i2 = 0; i2 < a(); i2++) {
                    Preconditions.i(i2, a());
                    long j2 = this.f43310a[this.f43311b + i2];
                    Preconditions.i(i2, immutableLongArray.a());
                    if (j2 == immutableLongArray.f43310a[immutableLongArray.f43311b + i2]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iA = 1;
        for (int i2 = this.f43311b; i2 < this.f43312c; i2++) {
            iA = (iA * 31) + Longs.a(this.f43310a[i2]);
        }
        return iA;
    }

    public final String toString() {
        int i2 = this.f43312c;
        int i3 = this.f43311b;
        if (i2 == i3) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(a() * 5);
        sb.append('[');
        long[] jArr = this.f43310a;
        sb.append(jArr[i3]);
        while (true) {
            i3++;
            if (i3 >= i2) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(jArr[i3]);
        }
    }
}
