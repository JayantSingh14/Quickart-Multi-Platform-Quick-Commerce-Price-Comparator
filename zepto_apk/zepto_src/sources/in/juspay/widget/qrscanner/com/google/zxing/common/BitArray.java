package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes4.dex */
public final class BitArray implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f48863a;

    /* renamed from: b, reason: collision with root package name */
    private int f48864b;

    public BitArray() {
        this.f48864b = 0;
        this.f48863a = new int[1];
    }

    private void a(int i2) {
        if (i2 > this.f48863a.length * 32) {
            int[] iArrB = b(i2);
            int[] iArr = this.f48863a;
            System.arraycopy(iArr, 0, iArrB, 0, iArr.length);
            this.f48863a = iArrB;
        }
    }

    private static int[] b(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void appendBit(boolean z) {
        a(this.f48864b + 1);
        if (z) {
            int[] iArr = this.f48863a;
            int i2 = this.f48864b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f48864b++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i2 = bitArray.f48864b;
        a(this.f48864b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            appendBit(bitArray.get(i3));
        }
    }

    public void appendBits(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        a(this.f48864b + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i3--;
        }
    }

    public void clear() {
        int length = this.f48863a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f48863a[i2] = 0;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m65clone() {
        return new BitArray((int[]) this.f48863a.clone(), this.f48864b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.f48864b == bitArray.f48864b && Arrays.equals(this.f48863a, bitArray.f48863a);
    }

    public void flip(int i2) {
        int[] iArr = this.f48863a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public boolean get(int i2) {
        return ((1 << (i2 & 31)) & this.f48863a[i2 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.f48863a;
    }

    public int getNextSet(int i2) {
        int i3 = this.f48864b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.f48863a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f48863a;
            if (i4 == iArr.length) {
                return this.f48864b;
            }
            i5 = iArr[i4];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5) + (i4 * 32);
        int i6 = this.f48864b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int getNextUnset(int i2) {
        int i3 = this.f48864b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.f48863a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f48863a;
            if (i4 == iArr.length) {
                return this.f48864b;
            }
            i5 = ~iArr[i4];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5) + (i4 * 32);
        int i6 = this.f48864b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int getSize() {
        return this.f48864b;
    }

    public int getSizeInBytes() {
        return (this.f48864b + 7) / 8;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f48863a) + (this.f48864b * 31);
    }

    public boolean isRange(int i2, int i3, boolean z) {
        if (i3 < i2 || i2 < 0 || i3 > this.f48864b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.f48863a[i7] & i8;
            if (!z) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void reverse() {
        int[] iArr = new int[this.f48863a.length];
        int i2 = (this.f48864b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.f48863a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & 65535) << 16) | ((j6 >> 16) & 65535));
        }
        int i5 = this.f48864b;
        int i6 = i3 * 32;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i2] = i8;
        }
        this.f48863a = iArr;
    }

    public void set(int i2) {
        int[] iArr = this.f48863a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void setBulk(int i2, int i3) {
        this.f48863a[i2 / 32] = i3;
    }

    public void setRange(int i2, int i3) {
        if (i3 < i2 || i2 < 0 || i3 > this.f48864b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = 31;
            int i9 = i7 > i5 ? 0 : i2 & 31;
            if (i7 >= i6) {
                i8 = 31 & i4;
            }
            int i10 = (2 << i8) - (1 << i9);
            int[] iArr = this.f48863a;
            iArr[i7] = i10 | iArr[i7];
            i7++;
        }
    }

    public void toBytes(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (get(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f48864b);
        for (int i2 = 0; i2 < this.f48864b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X' : ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.f48864b != bitArray.f48864b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f48863a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ bitArray.f48863a[i2];
            i2++;
        }
    }

    public BitArray(int i2) {
        this.f48864b = i2;
        this.f48863a = b(i2);
    }

    public BitArray(int[] iArr, int i2) {
        this.f48863a = iArr;
        this.f48864b = i2;
    }
}
