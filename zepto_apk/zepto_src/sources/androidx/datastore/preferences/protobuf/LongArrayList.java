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
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: b, reason: collision with root package name */
    public long[] f4066b;

    /* renamed from: c, reason: collision with root package name */
    public int f4067c;

    static {
        new LongArrayList(new long[0], 0, false);
    }

    public LongArrayList(long[] jArr, int i2, boolean z) {
        super(z);
        this.f4066b = jArr;
        this.f4067c = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4067c)) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4067c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        long[] jArr = this.f4066b;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[a.x(i3, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f4066b, i2, jArr2, i2 + 1, this.f4067c - i2);
            this.f4066b = jArr2;
        }
        this.f4066b[i2] = jLongValue;
        this.f4067c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = Internal.f4024a;
        collection.getClass();
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i2 = longArrayList.f4067c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4067c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f4066b;
        if (i4 > jArr.length) {
            this.f4066b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(longArrayList.f4066b, 0, this.f4066b, this.f4067c, longArrayList.f4067c);
        this.f4067c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j2) {
        b();
        int i2 = this.f4067c;
        long[] jArr = this.f4066b;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[a.x(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f4066b = jArr2;
        }
        long[] jArr3 = this.f4066b;
        int i3 = this.f4067c;
        this.f4067c = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f4067c != longArrayList.f4067c) {
            return false;
        }
        long[] jArr = longArrayList.f4066b;
        for (int i2 = 0; i2 < this.f4067c; i2++) {
            if (this.f4066b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f4067c) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4067c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    public final long g(int i2) {
        f(i2);
        return this.f4066b[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return Long.valueOf(g(i2));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i2 = 0; i2 < this.f4067c; i2++) {
            iB = (iB * 31) + Internal.b(this.f4066b[i2]);
        }
        return iB;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i2 = this.f4067c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f4066b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        f(i2);
        long[] jArr = this.f4066b;
        long j2 = jArr[i2];
        if (i2 < this.f4067c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f4067c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f4066b;
        System.arraycopy(jArr, i3, jArr, i2, this.f4067c - i3);
        this.f4067c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        f(i2);
        long[] jArr = this.f4066b;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4067c;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.LongList a(int i2) {
        if (i2 >= this.f4067c) {
            return new LongArrayList(Arrays.copyOf(this.f4066b, i2), this.f4067c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
