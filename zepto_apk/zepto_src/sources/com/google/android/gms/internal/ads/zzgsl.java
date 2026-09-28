package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgsl {
    public static Object a(int i2) {
        if (i2 < 2 || i2 > 1073741824 || Integer.highestOneBit(i2) != i2) {
            throw new IllegalArgumentException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 41), i2, "must be power of 2 between 2^1 and 2^30: "));
        }
        return i2 <= 256 ? new byte[i2] : i2 <= 65536 ? new short[i2] : new int[i2];
    }

    public static int b(int i2, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i2] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i2] : ((int[]) obj)[i2];
    }

    public static void c(int i2, int i3, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i3;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i3;
        } else {
            ((int[]) obj)[i2] = i3;
        }
    }

    public static int d(Object obj, Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i3;
        int i4;
        int iB = zzgsw.b(obj);
        int i5 = iB & i2;
        int iB2 = b(i5, obj3);
        if (iB2 != 0) {
            int i6 = ~i2;
            int i7 = iB & i6;
            int i8 = -1;
            while (true) {
                i3 = iB2 - 1;
                int i9 = iArr[i3];
                i4 = i9 & i2;
                if ((i9 & i6) != i7 || !Objects.equals(obj, objArr[i3]) || (objArr2 != null && !Objects.equals(obj2, objArr2[i3]))) {
                    if (i4 == 0) {
                        break;
                    }
                    i8 = i3;
                    iB2 = i4;
                } else {
                    break;
                }
            }
            if (i8 == -1) {
                c(i5, i4, obj3);
                return i3;
            }
            iArr[i8] = (iArr[i8] & i6) | (i4 & i2);
            return i3;
        }
        return -1;
    }
}
