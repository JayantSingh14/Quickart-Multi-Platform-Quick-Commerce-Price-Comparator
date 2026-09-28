package androidx.collection;

import android.support.v4.media.b;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f1476a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f1477b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f1478c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f1479d;

    public LongSparseArray(int i2) {
        if (i2 == 0) {
            this.f1477b = ContainerHelpersKt.f1611b;
            this.f1478c = ContainerHelpersKt.f1612c;
            return;
        }
        int i3 = i2 * 8;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (i3 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 8;
        this.f1477b = new long[i6];
        this.f1478c = new Object[i6];
    }

    public final void a() {
        int i2 = this.f1479d;
        Object[] objArr = this.f1478c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1479d = 0;
        this.f1476a = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final LongSparseArray clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray longSparseArray = (LongSparseArray) objClone;
        longSparseArray.f1477b = (long[]) this.f1477b.clone();
        longSparseArray.f1478c = (Object[]) this.f1478c.clone();
        return longSparseArray;
    }

    public final Object c(long j2) {
        Object obj;
        int iB = ContainerHelpersKt.b(this.f1477b, this.f1479d, j2);
        if (iB < 0 || (obj = this.f1478c[iB]) == LongSparseArrayKt.f1480a) {
            return null;
        }
        return obj;
    }

    public final Object d(long j2) {
        Object obj;
        int iB = ContainerHelpersKt.b(this.f1477b, this.f1479d, j2);
        if (iB < 0 || (obj = this.f1478c[iB]) == LongSparseArrayKt.f1480a) {
            return -1L;
        }
        return obj;
    }

    public final int e(long j2) {
        if (this.f1476a) {
            int i2 = this.f1479d;
            long[] jArr = this.f1477b;
            Object[] objArr = this.f1478c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != LongSparseArrayKt.f1480a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f1476a = false;
            this.f1479d = i3;
        }
        return ContainerHelpersKt.b(this.f1477b, this.f1479d, j2);
    }

    public final long f(int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.f1479d)) {
            throw new IllegalArgumentException(b.f(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f1476a) {
            long[] jArr = this.f1477b;
            Object[] objArr = this.f1478c;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = objArr[i5];
                if (obj != LongSparseArrayKt.f1480a) {
                    if (i5 != i4) {
                        jArr[i4] = jArr[i5];
                        objArr[i4] = obj;
                        objArr[i5] = null;
                    }
                    i4++;
                }
            }
            this.f1476a = false;
            this.f1479d = i4;
        }
        return this.f1477b[i2];
    }

    public final void g(long j2, Object obj) {
        int iB = ContainerHelpersKt.b(this.f1477b, this.f1479d, j2);
        if (iB >= 0) {
            this.f1478c[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i3 = this.f1479d;
        Object obj2 = LongSparseArrayKt.f1480a;
        if (i2 < i3) {
            Object[] objArr = this.f1478c;
            if (objArr[i2] == obj2) {
                this.f1477b[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f1476a) {
            long[] jArr = this.f1477b;
            if (i3 >= jArr.length) {
                Object[] objArr2 = this.f1478c;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj3 = objArr2[i5];
                    if (obj3 != obj2) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr2[i4] = obj3;
                            objArr2[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f1476a = false;
                this.f1479d = i4;
                i2 = ~ContainerHelpersKt.b(this.f1477b, i4, j2);
            }
        }
        int i6 = this.f1479d;
        if (i6 >= this.f1477b.length) {
            int i7 = (i6 + 1) * 8;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f1477b, i10);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(this, newSize)");
            this.f1477b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1478c, i10);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f1478c = objArrCopyOf;
        }
        int i11 = this.f1479d - i2;
        if (i11 != 0) {
            long[] destination = this.f1477b;
            int i12 = i2 + 1;
            Intrinsics.checkNotNullParameter(destination, "<this>");
            Intrinsics.checkNotNullParameter(destination, "destination");
            System.arraycopy(destination, i2, destination, i12, i11);
            Object[] objArr3 = this.f1478c;
            ArraysKt.m(objArr3, i12, objArr3, i2, this.f1479d);
        }
        this.f1477b[i2] = j2;
        this.f1478c[i2] = obj;
        this.f1479d++;
    }

    public final int h() {
        if (this.f1476a) {
            int i2 = this.f1479d;
            long[] jArr = this.f1477b;
            Object[] objArr = this.f1478c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != LongSparseArrayKt.f1480a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f1476a = false;
            this.f1479d = i3;
        }
        return this.f1479d;
    }

    public final Object i(int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.f1479d)) {
            throw new IllegalArgumentException(b.f(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f1476a) {
            long[] jArr = this.f1477b;
            Object[] objArr = this.f1478c;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = objArr[i5];
                if (obj != LongSparseArrayKt.f1480a) {
                    if (i5 != i4) {
                        jArr[i4] = jArr[i5];
                        objArr[i4] = obj;
                        objArr[i5] = null;
                    }
                    i4++;
                }
            }
            this.f1476a = false;
            this.f1479d = i4;
        }
        return this.f1478c[i2];
    }

    public final String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1479d * 28);
        sb.append('{');
        int i2 = this.f1479d;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(f(i3));
            sb.append('=');
            Object objI = i(i3);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @JvmOverloads
    public LongSparseArray() {
        this(10);
    }
}
