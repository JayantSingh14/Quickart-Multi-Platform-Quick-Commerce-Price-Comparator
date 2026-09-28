package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ArraySetKt {
    public static final void a(ArraySet arraySet, int i2) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int[] iArr = new int[i2];
        arraySet.getClass();
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        arraySet.f1401a = iArr;
        Object[] objArr = new Object[i2];
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        arraySet.f1402b = objArr;
    }

    public static final int b(ArraySet arraySet, Object obj, int i2) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int i3 = arraySet.f1403c;
        if (i3 == 0) {
            return -1;
        }
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        try {
            int iA = ContainerHelpersKt.a(arraySet.f1403c, i2, arraySet.f1401a);
            if (iA < 0 || Intrinsics.b(obj, arraySet.f1402b[iA])) {
                return iA;
            }
            int i4 = iA + 1;
            while (i4 < i3 && arraySet.f1401a[i4] == i2) {
                if (Intrinsics.b(obj, arraySet.f1402b[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iA - 1; i5 >= 0 && arraySet.f1401a[i5] == i2; i5--) {
                if (Intrinsics.b(obj, arraySet.f1402b[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
