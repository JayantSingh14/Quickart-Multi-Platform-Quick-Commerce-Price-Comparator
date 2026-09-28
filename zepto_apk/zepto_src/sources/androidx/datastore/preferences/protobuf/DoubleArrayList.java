package androidx.datastore.preferences.protobuf;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: b, reason: collision with root package name */
    public double[] f3940b;

    /* renamed from: c, reason: collision with root package name */
    public int f3941c;

    static {
        new DoubleArrayList(new double[0], 0, false);
    }

    public DoubleArrayList(double[] dArr, int i2, boolean z) {
        super(z);
        this.f3940b = dArr;
        this.f3941c = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f3941c)) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f3941c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        double[] dArr = this.f3940b;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[a.x(i3, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f3940b, i2, dArr2, i2 + 1, this.f3941c - i2);
            this.f3940b = dArr2;
        }
        this.f3940b[i2] = dDoubleValue;
        this.f3941c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = Internal.f4024a;
        collection.getClass();
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i2 = doubleArrayList.f3941c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3941c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f3940b;
        if (i4 > dArr.length) {
            this.f3940b = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(doubleArrayList.f3940b, 0, this.f3940b, this.f3941c, doubleArrayList.f3941c);
        this.f3941c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d2) {
        b();
        int i2 = this.f3941c;
        double[] dArr = this.f3940b;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[a.x(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f3940b = dArr2;
        }
        double[] dArr3 = this.f3940b;
        int i3 = this.f3941c;
        this.f3941c = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.f3941c != doubleArrayList.f3941c) {
            return false;
        }
        double[] dArr = doubleArrayList.f3940b;
        for (int i2 = 0; i2 < this.f3941c; i2++) {
            if (Double.doubleToLongBits(this.f3940b[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f3941c) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f3941c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return Double.valueOf(getDouble(i2));
    }

    public final double getDouble(int i2) {
        f(i2);
        return this.f3940b[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i2 = 0; i2 < this.f3941c; i2++) {
            iB = (iB * 31) + Internal.b(Double.doubleToLongBits(this.f3940b[i2]));
        }
        return iB;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i2 = this.f3941c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f3940b[i3] == dDoubleValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        f(i2);
        double[] dArr = this.f3940b;
        double d2 = dArr[i2];
        if (i2 < this.f3941c - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.f3941c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f3940b;
        System.arraycopy(dArr, i3, dArr, i2, this.f3941c - i3);
        this.f3941c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        f(i2);
        double[] dArr = this.f3940b;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3941c;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.DoubleList a(int i2) {
        if (i2 >= this.f3941c) {
            return new DoubleArrayList(Arrays.copyOf(this.f3940b, i2), this.f3941c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }
}
