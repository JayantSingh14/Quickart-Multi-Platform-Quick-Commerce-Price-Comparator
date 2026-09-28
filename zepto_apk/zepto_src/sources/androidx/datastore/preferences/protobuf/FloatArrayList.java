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
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: b, reason: collision with root package name */
    public float[] f4002b;

    /* renamed from: c, reason: collision with root package name */
    public int f4003c;

    static {
        new FloatArrayList(new float[0], 0, false);
    }

    public FloatArrayList(float[] fArr, int i2, boolean z) {
        super(z);
        this.f4002b = fArr;
        this.f4003c = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4003c)) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4003c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        float[] fArr = this.f4002b;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[a.x(i3, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f4002b, i2, fArr2, i2 + 1, this.f4003c - i2);
            this.f4002b = fArr2;
        }
        this.f4002b[i2] = fFloatValue;
        this.f4003c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = Internal.f4024a;
        collection.getClass();
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i2 = floatArrayList.f4003c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4003c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f4002b;
        if (i4 > fArr.length) {
            this.f4002b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(floatArrayList.f4002b, 0, this.f4002b, this.f4003c, floatArrayList.f4003c);
        this.f4003c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f2) {
        b();
        int i2 = this.f4003c;
        float[] fArr = this.f4002b;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[a.x(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f4002b = fArr2;
        }
        float[] fArr3 = this.f4002b;
        int i3 = this.f4003c;
        this.f4003c = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.f4003c != floatArrayList.f4003c) {
            return false;
        }
        float[] fArr = floatArrayList.f4002b;
        for (int i2 = 0; i2 < this.f4003c; i2++) {
            if (Float.floatToIntBits(this.f4002b[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f4003c) {
            StringBuilder sbU = b.u(i2, "Index:", ", Size:");
            sbU.append(this.f4003c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    public final float g(int i2) {
        f(i2);
        return this.f4002b[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return Float.valueOf(g(i2));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f4003c; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f4002b[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i2 = this.f4003c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f4002b[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        f(i2);
        float[] fArr = this.f4002b;
        float f2 = fArr[i2];
        if (i2 < this.f4003c - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.f4003c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f4002b;
        System.arraycopy(fArr, i3, fArr, i2, this.f4003c - i3);
        this.f4003c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        b();
        f(i2);
        float[] fArr = this.f4002b;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4003c;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.FloatList a(int i2) {
        if (i2 >= this.f4003c) {
            return new FloatArrayList(Arrays.copyOf(this.f4002b, i2), this.f4003c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }
}
