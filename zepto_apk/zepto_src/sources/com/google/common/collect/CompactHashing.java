package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class CompactHashing {
    public static Object a(int i2) {
        if (i2 < 2 || i2 > 1073741824 || Integer.highestOneBit(i2) != i2) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "must be power of 2 between 2^1 and 2^30: "));
        }
        return i2 <= 256 ? new byte[i2] : i2 <= 65536 ? new short[i2] : new int[i2];
    }

    public static int b(int i2, int i3, int i4) {
        return (i2 & (~i4)) | (i3 & i4);
    }

    public static int c(int i2) {
        return (i2 + 1) * (i2 < 32 ? 4 : 2);
    }

    public static int d(Object obj, Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i3;
        int i4;
        int iC = Hashing.c(obj);
        int i5 = iC & i2;
        int iE = e(i5, obj3);
        if (iE != 0) {
            int i6 = ~i2;
            int i7 = iC & i6;
            int i8 = -1;
            while (true) {
                i3 = iE - 1;
                i4 = iArr[i3];
                if ((i4 & i6) == i7 && Objects.a(obj, objArr[i3]) && (objArr2 == null || Objects.a(obj2, objArr2[i3]))) {
                    break;
                }
                int i9 = i4 & i2;
                if (i9 == 0) {
                    break;
                }
                i8 = i3;
                iE = i9;
            }
            int i10 = i4 & i2;
            if (i8 == -1) {
                f(i5, i10, obj3);
                return i3;
            }
            iArr[i8] = b(iArr[i8], i10, i2);
            return i3;
        }
        return -1;
    }

    public static int e(int i2, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i2] & 255 : obj instanceof short[] ? ((short[]) obj)[i2] & 65535 : ((int[]) obj)[i2];
    }

    public static void f(int i2, int i3, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i3;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i3;
        } else {
            ((int[]) obj)[i2] = i3;
        }
    }
}
