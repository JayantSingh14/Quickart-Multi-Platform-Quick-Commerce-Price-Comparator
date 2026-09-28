package androidx.datastore.preferences.protobuf;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final ProtobufArrayList f4115d = new ProtobufArrayList(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public Object[] f4116b;

    /* renamed from: c, reason: collision with root package name */
    public int f4117c;

    public ProtobufArrayList(Object[] objArr, int i2, boolean z) {
        super(z);
        this.f4116b = objArr;
        this.f4117c = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.ProtobufList a(int i2) {
        if (i2 >= this.f4117c) {
            return new ProtobufArrayList(Arrays.copyOf(this.f4116b, i2), this.f4117c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i2 = this.f4117c;
        Object[] objArr = this.f4116b;
        if (i2 == objArr.length) {
            this.f4116b = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f4116b;
        int i3 = this.f4117c;
        this.f4117c = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 >= this.f4117c) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4117c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        d(i2);
        return this.f4116b[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        d(i2);
        Object[] objArr = this.f4116b;
        Object obj = objArr[i2];
        if (i2 < this.f4117c - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f4117c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        d(i2);
        Object[] objArr = this.f4116b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4117c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        b();
        if (i2 >= 0 && i2 <= (i3 = this.f4117c)) {
            Object[] objArr = this.f4116b;
            if (i3 < objArr.length) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i3 - i2);
            } else {
                Object[] objArr2 = new Object[a.x(i3, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                System.arraycopy(this.f4116b, i2, objArr2, i2 + 1, this.f4117c - i2);
                this.f4116b = objArr2;
            }
            this.f4116b[i2] = obj;
            this.f4117c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbU = b.u(i2, "Index:", ", Size:");
        sbU.append(this.f4117c);
        throw new IndexOutOfBoundsException(sbU.toString());
    }
}
