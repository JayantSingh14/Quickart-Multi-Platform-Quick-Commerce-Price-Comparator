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
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f3746b;

    /* renamed from: c, reason: collision with root package name */
    public int f3747c;

    static {
        new BooleanArrayList(new boolean[0], 0, false);
    }

    public BooleanArrayList(boolean[] zArr, int i2, boolean z) {
        super(z);
        this.f3746b = zArr;
        this.f3747c = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f3747c)) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f3747c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        boolean[] zArr = this.f3746b;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[a.x(i3, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f3746b, i2, zArr2, i2 + 1, this.f3747c - i2);
            this.f3746b = zArr2;
        }
        this.f3746b[i2] = zBooleanValue;
        this.f3747c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = Internal.f4024a;
        collection.getClass();
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i2 = booleanArrayList.f3747c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3747c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f3746b;
        if (i4 > zArr.length) {
            this.f3746b = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(booleanArrayList.f3746b, 0, this.f3746b, this.f3747c, booleanArrayList.f3747c);
        this.f3747c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z) {
        b();
        int i2 = this.f3747c;
        boolean[] zArr = this.f3746b;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[a.x(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f3746b = zArr2;
        }
        boolean[] zArr3 = this.f3746b;
        int i3 = this.f3747c;
        this.f3747c = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.f3747c != booleanArrayList.f3747c) {
            return false;
        }
        boolean[] zArr = booleanArrayList.f3746b;
        for (int i2 = 0; i2 < this.f3747c; i2++) {
            if (this.f3746b[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f3747c) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f3747c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return Boolean.valueOf(getBoolean(i2));
    }

    public final boolean getBoolean(int i2) {
        f(i2);
        return this.f3746b[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f3747c; i3++) {
            int i4 = i2 * 31;
            boolean z = this.f3746b[i3];
            Charset charset = Internal.f4024a;
            i2 = i4 + (z ? 1231 : 1237);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.f3747c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f3746b[i3] == zBooleanValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        f(i2);
        boolean[] zArr = this.f3746b;
        boolean z = zArr[i2];
        if (i2 < this.f3747c - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.f3747c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f3746b;
        System.arraycopy(zArr, i3, zArr, i2, this.f3747c - i3);
        this.f3747c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        f(i2);
        boolean[] zArr = this.f3746b;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3747c;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.BooleanList a(int i2) {
        if (i2 >= this.f3747c) {
            return new BooleanArrayList(Arrays.copyOf(this.f3746b, i2), this.f3747c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }
}
