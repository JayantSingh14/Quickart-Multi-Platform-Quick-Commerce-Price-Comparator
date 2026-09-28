package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final HashFunction f43218a = new Murmur3_32HashFunction();

    /* loaded from: classes4.dex */
    public static final class Murmur3_32Hasher extends AbstractHasher {
    }

    static {
        int i2 = Hashing.f43208a;
    }

    public static HashCode b(int i2, int i3) {
        int i4 = i2 ^ i3;
        int i5 = (i4 ^ (i4 >>> 16)) * (-2048144789);
        int i6 = (i5 ^ (i5 >>> 13)) * (-1028477387);
        int i7 = i6 ^ (i6 >>> 16);
        char[] cArr = HashCode.f43206a;
        return new HashCode.IntHashCode(i7);
    }

    public static int d(int i2, int i3) {
        return (Integer.rotateLeft(i2 ^ i3, 13) * 5) - 430675100;
    }

    public static int e(int i2) {
        return Integer.rotateLeft(i2 * (-862048943), 15) * 461845907;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106 A[SYNTHETIC] */
    @Override // com.google.common.hash.HashFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.hash.HashCode a(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_32HashFunction.a(java.lang.String):com.google.common.hash.HashCode");
    }

    public final HashCode c(int i2, byte[] bArr) {
        int iA = 0;
        Preconditions.l(0, i2, bArr.length);
        int i3 = 0;
        int iD = 0;
        while (true) {
            int i4 = i3 + 4;
            if (i4 > i2) {
                break;
            }
            iD = d(iD, e(Ints.d(bArr[i3 + 3], bArr[i3 + 2], bArr[i3 + 1], bArr[i3])));
            i3 = i4;
        }
        int i5 = 0;
        while (i3 < i2) {
            iA ^= UnsignedBytes.a(bArr[i3]) << i5;
            i3++;
            i5 += 8;
        }
        return b(e(iA) ^ iD, i2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        ((Murmur3_32HashFunction) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Murmur3_32HashFunction.class.hashCode();
    }

    public final String toString() {
        return "Hashing.murmur3_32(0)";
    }
}
