package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f42719c = 0;

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableList f42720b;

    /* loaded from: classes4.dex */
    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            super(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Builder c(Object obj) {
            obj.getClass();
            super.c(obj);
            return this;
        }

        public Builder i(Object... objArr) {
            d(objArr.length, objArr);
            return this;
        }

        public Builder j(Iterable iterable) {
            iterable.getClass();
            e(iterable);
            return this;
        }

        public ImmutableSet k() {
            int i2 = this.f42658b;
            if (i2 == 0) {
                int i3 = ImmutableSet.f42719c;
                return RegularImmutableSet.f43033j;
            }
            if (i2 != 1) {
                ImmutableSet immutableSetN = ImmutableSet.n(i2, this.f42657a);
                this.f42658b = immutableSetN.size();
                this.f42659c = true;
                return immutableSetN;
            }
            Object obj = this.f42657a[0];
            Objects.requireNonNull(obj);
            int i4 = ImmutableSet.f42719c;
            return new SingletonImmutableSet(obj);
        }

        public Builder l(Builder builder) {
            d(builder.f42658b, builder.f42657a);
            return this;
        }
    }

    @J2ktIncompatible
    /* loaded from: classes4.dex */
    public static class SerializedForm implements Serializable {
    }

    public static int m(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            Preconditions.g(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static ImmutableSet n(int i2, Object... objArr) {
        if (i2 == 0) {
            return RegularImmutableSet.f43033j;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new SingletonImmutableSet(obj);
        }
        int iM = m(i2);
        Object[] objArr2 = new Object[iM];
        int i3 = iM - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            Object obj2 = objArr[i6];
            if (obj2 == null) {
                throw new NullPointerException(android.support.v4.media.b.f(i6, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iB = Hashing.b(iHashCode);
            while (true) {
                int i7 = iB & i3;
                Object obj3 = objArr2[i7];
                if (obj3 == null) {
                    objArr[i5] = obj2;
                    objArr2[i7] = obj2;
                    i4 += iHashCode;
                    i5++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i5, i2, (Object) null);
        if (i5 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new SingletonImmutableSet(obj4);
        }
        if (m(i5) < iM / 2) {
            return n(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new RegularImmutableSet(objArr, i4, objArr2, i3, i5);
    }

    public static ImmutableSet o(Collection collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet immutableSet = (ImmutableSet) collection;
            if (!immutableSet.j()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return n(array.length, array);
    }

    public static ImmutableSet p(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? n(objArr.length, (Object[]) objArr.clone()) : new SingletonImmutableSet(objArr[0]) : RegularImmutableSet.f43033j;
    }

    public static ImmutableSet s() {
        return RegularImmutableSet.f43033j;
    }

    public static ImmutableSet t(String str) {
        return new SingletonImmutableSet(str);
    }

    public static ImmutableSet u(String str, String str2, String str3, String str4, String str5, String str6, Object... objArr) {
        Preconditions.g(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = str;
        objArr2[1] = str2;
        objArr2[2] = str3;
        objArr2[3] = str4;
        objArr2[4] = str5;
        objArr2[5] = str6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return n(length, objArr2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList b() {
        ImmutableList immutableList = this.f42720b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList immutableListQ = q();
        this.f42720b = immutableListQ;
        return immutableListQ;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && r() && ((ImmutableSet) obj).r() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.e(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public ImmutableList q() {
        Object[] array = toArray(ImmutableCollection.f42656a);
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        return ImmutableList.m(array.length, array);
    }

    public boolean r() {
        return this instanceof EmptyContiguousSet;
    }
}
