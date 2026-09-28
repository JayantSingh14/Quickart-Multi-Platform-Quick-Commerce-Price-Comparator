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
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: d, reason: collision with root package name */
    public static final IntArrayList f4021d = new IntArrayList(new int[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public int[] f4022b;

    /* renamed from: c, reason: collision with root package name */
    public int f4023c;

    public IntArrayList(int[] iArr, int i2, boolean z) {
        super(z);
        this.f4022b = iArr;
        this.f4023c = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4023c)) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4023c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        int[] iArr = this.f4022b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f4022b, i2, iArr2, i2 + 1, this.f4023c - i2);
            this.f4022b = iArr2;
        }
        this.f4022b[i2] = iIntValue;
        this.f4023c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = Internal.f4024a;
        collection.getClass();
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i2 = intArrayList.f4023c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4023c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f4022b;
        if (i4 > iArr.length) {
            this.f4022b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(intArrayList.f4022b, 0, this.f4022b, this.f4023c, intArrayList.f4023c);
        this.f4023c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        b();
        int i3 = this.f4023c;
        int[] iArr = this.f4022b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[a.x(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f4022b = iArr2;
        }
        int[] iArr3 = this.f4022b;
        int i4 = this.f4023c;
        this.f4023c = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f4023c != intArrayList.f4023c) {
            return false;
        }
        int[] iArr = intArrayList.f4022b;
        for (int i2 = 0; i2 < this.f4023c; i2++) {
            if (this.f4022b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f4023c) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4023c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return Integer.valueOf(getInt(i2));
    }

    public final int getInt(int i2) {
        f(i2);
        return this.f4022b[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4023c; i3++) {
            i2 = (i2 * 31) + this.f4022b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f4023c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f4022b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        f(i2);
        int[] iArr = this.f4022b;
        int i3 = iArr[i2];
        if (i2 < this.f4023c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f4023c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f4022b;
        System.arraycopy(iArr, i3, iArr, i2, this.f4023c - i3);
        this.f4023c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        f(i2);
        int[] iArr = this.f4022b;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4023c;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.IntList a(int i2) {
        if (i2 >= this.f4023c) {
            return new IntArrayList(Arrays.copyOf(this.f4022b, i2), this.f4023c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
