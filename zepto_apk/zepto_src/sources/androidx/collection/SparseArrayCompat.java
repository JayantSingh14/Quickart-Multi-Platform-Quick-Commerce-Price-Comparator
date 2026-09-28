package androidx.collection;

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
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f1606a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f1607b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f1608c;

    @JvmOverloads
    public SparseArrayCompat() {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f1606a = new int[i5];
        this.f1607b = new Object[i5];
    }

    public final void a(int i2, Object obj) {
        int i3 = this.f1608c;
        if (i3 != 0 && i2 <= this.f1606a[i3 - 1]) {
            c(i2, obj);
            return;
        }
        if (i3 >= this.f1606a.length) {
            int i4 = (i3 + 1) * 4;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f1606a, i7);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f1606a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1607b, i7);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f1607b = objArrCopyOf;
        }
        this.f1606a[i3] = i2;
        this.f1607b[i3] = obj;
        this.f1608c = i3 + 1;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final SparseArrayCompat clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.f1606a = (int[]) this.f1606a.clone();
        sparseArrayCompat.f1607b = (Object[]) this.f1607b.clone();
        return sparseArrayCompat;
    }

    public final void c(int i2, Object obj) {
        int iA = ContainerHelpersKt.a(this.f1608c, i2, this.f1606a);
        if (iA >= 0) {
            this.f1607b[iA] = obj;
            return;
        }
        int i3 = ~iA;
        int i4 = this.f1608c;
        if (i3 < i4) {
            Object[] objArr = this.f1607b;
            if (objArr[i3] == SparseArrayCompatKt.f1609a) {
                this.f1606a[i3] = i2;
                objArr[i3] = obj;
                return;
            }
        }
        if (i4 >= this.f1606a.length) {
            int i5 = (i4 + 1) * 4;
            int i6 = 4;
            while (true) {
                if (i6 >= 32) {
                    break;
                }
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
            int i8 = i5 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f1606a, i8);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f1606a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f1607b, i8);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f1607b = objArrCopyOf;
        }
        int i9 = this.f1608c;
        if (i9 - i3 != 0) {
            int[] iArr = this.f1606a;
            int i10 = i3 + 1;
            ArraysKt.k(i10, i3, i9, iArr, iArr);
            Object[] objArr2 = this.f1607b;
            ArraysKt.m(objArr2, i10, objArr2, i3, this.f1608c);
        }
        this.f1606a[i3] = i2;
        this.f1607b[i3] = obj;
        this.f1608c++;
    }

    public final String toString() {
        int i2 = this.f1608c;
        if (i2 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i2 * 28);
        sb.append('{');
        int i3 = this.f1608c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(this.f1606a[i4]);
            sb.append('=');
            Object obj = this.f1607b[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
}
