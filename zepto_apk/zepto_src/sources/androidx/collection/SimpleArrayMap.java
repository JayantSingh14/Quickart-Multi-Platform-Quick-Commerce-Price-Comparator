package androidx.collection;

import android.support.v4.media.b;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1603a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1604b;

    /* renamed from: c, reason: collision with root package name */
    public int f1605c;

    @JvmOverloads
    public SimpleArrayMap() {
        this(0);
    }

    public final int a(Object obj) {
        int i2 = this.f1605c * 2;
        Object[] objArr = this.f1604b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i2) {
        int i3 = this.f1605c;
        int[] iArr = this.f1603a;
        if (iArr.length < i2) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f1603a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1604b, i2 * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f1604b = objArrCopyOf;
        }
        if (this.f1605c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i2, Object obj) {
        int i3 = this.f1605c;
        if (i3 == 0) {
            return -1;
        }
        int iA = ContainerHelpersKt.a(i3, i2, this.f1603a);
        if (iA < 0 || Intrinsics.b(obj, this.f1604b[iA << 1])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f1603a[i4] == i2) {
            if (Intrinsics.b(obj, this.f1604b[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f1603a[i5] == i2; i5--) {
            if (Intrinsics.b(obj, this.f1604b[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public void clear() {
        if (this.f1605c > 0) {
            this.f1603a = ContainerHelpersKt.f1610a;
            this.f1604b = ContainerHelpersKt.f1612c;
            this.f1605c = 0;
        }
        if (this.f1605c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i2 = this.f1605c;
        if (i2 == 0) {
            return -1;
        }
        int iA = ContainerHelpersKt.a(i2, 0, this.f1603a);
        if (iA < 0 || this.f1604b[iA << 1] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f1603a[i3] == 0) {
            if (this.f1604b[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f1603a[i4] == 0; i4--) {
            if (this.f1604b[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                int i2 = this.f1605c;
                if (i2 != ((SimpleArrayMap) obj).f1605c) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                for (int i3 = 0; i3 < i2; i3++) {
                    Object objF = f(i3);
                    Object objJ = j(i3);
                    Object obj2 = simpleArrayMap.get(objF);
                    if (objJ == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objJ.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f1605c != ((Map) obj).size()) {
                return false;
            }
            int i4 = this.f1605c;
            for (int i5 = 0; i5 < i4; i5++) {
                Object objF2 = f(i5);
                Object objJ2 = j(i5);
                Object obj3 = ((Map) obj).get(objF2);
                if (objJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objJ2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i2) {
        if (i2 < 0 || i2 >= this.f1605c) {
            throw new IllegalArgumentException(b.f(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.f1604b[i2 << 1];
    }

    public void g(SimpleArrayMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        int i2 = map.f1605c;
        b(this.f1605c + i2);
        if (this.f1605c != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(map.f(i3), map.j(i3));
            }
        } else if (i2 > 0) {
            ArraysKt.k(0, 0, i2, map.f1603a, this.f1603a);
            ArraysKt.m(map.f1604b, 0, this.f1604b, 0, i2 << 1);
            this.f1605c = i2;
        }
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f1604b[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f1604b[(iD << 1) + 1] : obj2;
    }

    public Object h(int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.f1605c)) {
            throw new IllegalArgumentException(b.f(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.f1604b;
        int i4 = i2 << 1;
        Object obj = objArr[i4 + 1];
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i5 = i3 - 1;
        int[] iArr = this.f1603a;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i2 < i5) {
                int i6 = i2 + 1;
                ArraysKt.k(i2, i6, i3, iArr, iArr);
                Object[] objArr2 = this.f1604b;
                ArraysKt.m(objArr2, i4, objArr2, i6 << 1, i3 << 1);
            }
            Object[] objArr3 = this.f1604b;
            int i7 = i5 << 1;
            objArr3[i7] = null;
            objArr3[i7 + 1] = null;
        } else {
            int i8 = i3 > 8 ? i3 + (i3 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i8);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f1603a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1604b, i8 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f1604b = objArrCopyOf;
            if (i3 != this.f1605c) {
                throw new ConcurrentModificationException();
            }
            if (i2 > 0) {
                ArraysKt.k(0, 0, i2, iArr, this.f1603a);
                ArraysKt.m(objArr, 0, this.f1604b, 0, i4);
            }
            if (i2 < i5) {
                int i9 = i2 + 1;
                ArraysKt.k(i2, i9, i3, iArr, this.f1603a);
                ArraysKt.m(objArr, i4, this.f1604b, i9 << 1, i3 << 1);
            }
        }
        if (i3 != this.f1605c) {
            throw new ConcurrentModificationException();
        }
        this.f1605c = i5;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f1603a;
        Object[] objArr = this.f1604b;
        int i2 = this.f1605c;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    public Object i(int i2, Object obj) {
        if (i2 < 0 || i2 >= this.f1605c) {
            throw new IllegalArgumentException(b.f(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f1604b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.f1605c <= 0;
    }

    public final Object j(int i2) {
        if (i2 < 0 || i2 >= this.f1605c) {
            throw new IllegalArgumentException(b.f(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.f1604b[(i2 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i2 = this.f1605c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i3 = (iC << 1) + 1;
            Object[] objArr = this.f1604b;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i4 = ~iC;
        int[] iArr = this.f1603a;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f1603a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1604b, i5 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f1604b = objArrCopyOf;
            if (i2 != this.f1605c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr2 = this.f1603a;
            int i6 = i4 + 1;
            ArraysKt.k(i6, i4, i2, iArr2, iArr2);
            Object[] objArr2 = this.f1604b;
            ArraysKt.m(objArr2, i6 << 1, objArr2, i4 << 1, this.f1605c << 1);
        }
        int i7 = this.f1605c;
        if (i2 == i7) {
            int[] iArr3 = this.f1603a;
            if (i4 < iArr3.length) {
                iArr3[i4] = iHashCode;
                Object[] objArr3 = this.f1604b;
                int i8 = i4 << 1;
                objArr3[i8] = obj;
                objArr3[i8 + 1] = obj2;
                this.f1605c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return i(iD, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f1605c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1605c * 28);
        sb.append('{');
        int i2 = this.f1605c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object objF = f(i3);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i3);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public SimpleArrayMap(int i2) {
        this.f1603a = i2 == 0 ? ContainerHelpersKt.f1610a : new int[i2];
        this.f1604b = i2 == 0 ? ContainerHelpersKt.f1612c : new Object[i2 << 1];
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !Intrinsics.b(obj2, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !Intrinsics.b(obj2, j(iD))) {
            return false;
        }
        i(iD, obj3);
        return true;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this(0);
        if (simpleArrayMap != null) {
            g(simpleArrayMap);
        }
    }
}
