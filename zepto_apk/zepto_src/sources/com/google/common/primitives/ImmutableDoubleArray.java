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
public final class ImmutableDoubleArray implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableDoubleArray f43299d = new ImmutableDoubleArray(new double[0], 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final double[] f43300a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f43301b;

    /* renamed from: c, reason: collision with root package name */
    public final int f43302c;

    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableDoubleArray f43303a;

        public AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.f43303a = immutableDoubleArray;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            boolean z = obj instanceof AsList;
            ImmutableDoubleArray immutableDoubleArray = this.f43303a;
            if (z) {
                return immutableDoubleArray.equals(((AsList) obj).f43303a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (immutableDoubleArray.b() != list.size()) {
                return false;
            }
            int i2 = immutableDoubleArray.f43301b;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i3 = i2 + 1;
                    if (ImmutableDoubleArray.a(immutableDoubleArray.f43300a[i2], ((Double) obj2).doubleValue())) {
                        i2 = i3;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            ImmutableDoubleArray immutableDoubleArray = this.f43303a;
            Preconditions.i(i2, immutableDoubleArray.b());
            return Double.valueOf(immutableDoubleArray.f43300a[immutableDoubleArray.f43301b + i2]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            return this.f43303a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                ImmutableDoubleArray immutableDoubleArray = this.f43303a;
                int i2 = immutableDoubleArray.f43301b;
                for (int i3 = i2; i3 < immutableDoubleArray.f43302c; i3++) {
                    if (ImmutableDoubleArray.a(immutableDoubleArray.f43300a[i3], dDoubleValue)) {
                        return i3 - i2;
                    }
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            int i2;
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                ImmutableDoubleArray immutableDoubleArray = this.f43303a;
                int i3 = immutableDoubleArray.f43302c;
                do {
                    i3--;
                    i2 = immutableDoubleArray.f43301b;
                    if (i3 >= i2) {
                    }
                } while (!ImmutableDoubleArray.a(immutableDoubleArray.f43300a[i3], dDoubleValue));
                return i3 - i2;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f43303a.b();
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i2, int i3) {
            ImmutableDoubleArray immutableDoubleArray;
            ImmutableDoubleArray immutableDoubleArray2 = this.f43303a;
            Preconditions.l(i2, i3, immutableDoubleArray2.b());
            if (i2 == i3) {
                immutableDoubleArray = ImmutableDoubleArray.f43299d;
            } else {
                int i4 = immutableDoubleArray2.f43301b;
                immutableDoubleArray = new ImmutableDoubleArray(immutableDoubleArray2.f43300a, i2 + i4, i4 + i3);
            }
            return new AsList(immutableDoubleArray);
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            return this.f43303a.toString();
        }
    }

    public static final class Builder {
    }

    public ImmutableDoubleArray(double[] dArr, int i2, int i3) {
        this.f43300a = dArr;
        this.f43301b = i2;
        this.f43302c = i3;
    }

    public static boolean a(double d2, double d3) {
        return Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3);
    }

    public final int b() {
        return this.f43302c - this.f43301b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableDoubleArray) {
            ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
            if (b() == immutableDoubleArray.b()) {
                for (int i2 = 0; i2 < b(); i2++) {
                    Preconditions.i(i2, b());
                    double d2 = this.f43300a[this.f43301b + i2];
                    Preconditions.i(i2, immutableDoubleArray.b());
                    if (a(d2, immutableDoubleArray.f43300a[immutableDoubleArray.f43301b + i2])) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (int i2 = this.f43301b; i2 < this.f43302c; i2++) {
            double d2 = this.f43300a[i2];
            int i3 = Doubles.f43292a;
            iHashCode = (iHashCode * 31) + Double.valueOf(d2).hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        int i2 = this.f43302c;
        int i3 = this.f43301b;
        if (i2 == i3) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(b() * 5);
        sb.append('[');
        double[] dArr = this.f43300a;
        sb.append(dArr[i3]);
        while (true) {
            i3++;
            if (i3 >= i2) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(dArr[i3]);
        }
    }
}
