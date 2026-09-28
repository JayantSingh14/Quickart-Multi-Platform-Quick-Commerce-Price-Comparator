package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class BitMatrix implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f48865a;

    /* renamed from: b, reason: collision with root package name */
    private int f48866b;

    /* renamed from: c, reason: collision with root package name */
    private int f48867c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f48868d;

    public BitMatrix(int i2) {
        this(i2, i2);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder((this.f48865a + 1) * this.f48866b);
        for (int i2 = 0; i2 < this.f48866b; i2++) {
            for (int i3 = 0; i3 < this.f48865a; i3++) {
                sb.append(get(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i2 = -1;
        int length = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i3 > i4) {
                    if (i2 == -1) {
                        i2 = i3 - i4;
                    } else if (i3 - i4 != i2) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i5++;
                    i4 = i3;
                }
                length++;
            } else {
                if (str.startsWith(str2, length)) {
                    length += str2.length();
                    zArr[i3] = true;
                } else {
                    if (!str.startsWith(str3, length)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(length));
                    }
                    length += str3.length();
                    zArr[i3] = false;
                }
                i3++;
            }
        }
        if (i3 > i4) {
            if (i2 == -1) {
                i2 = i3 - i4;
            } else if (i3 - i4 != i2) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i5++;
        }
        BitMatrix bitMatrix = new BitMatrix(i2, i5);
        for (int i6 = 0; i6 < i3; i6++) {
            if (zArr[i6]) {
                bitMatrix.set(i6 % i2, i6 / i2);
            }
        }
        return bitMatrix;
    }

    public void clear() {
        int length = this.f48868d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f48868d[i2] = 0;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m66clone() {
        return new BitMatrix(this.f48865a, this.f48866b, this.f48867c, (int[]) this.f48868d.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.f48865a == bitMatrix.f48865a && this.f48866b == bitMatrix.f48866b && this.f48867c == bitMatrix.f48867c && Arrays.equals(this.f48868d, bitMatrix.f48868d);
    }

    public void flip() {
        int length = this.f48868d.length;
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr = this.f48868d;
            iArr[i2] = ~iArr[i2];
        }
    }

    public boolean get(int i2, int i3) {
        return ((this.f48868d[(i2 / 32) + (i3 * this.f48867c)] >>> (i2 & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.f48868d.length - 1;
        while (length >= 0 && this.f48868d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f48867c;
        int i3 = length / i2;
        int i4 = (length % i2) * 32;
        int i5 = 31;
        while ((this.f48868d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public int[] getEnclosingRectangle() {
        int i2 = this.f48865a;
        int i3 = this.f48866b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.f48866b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = this.f48867c;
                if (i7 < i8) {
                    int i9 = this.f48868d[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 * 32;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        if (i4 < i2 || i5 < i3) {
            return null;
        }
        return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
    }

    public int getHeight() {
        return this.f48866b;
    }

    public BitArray getRow(int i2, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.f48865a) {
            bitArray = new BitArray(this.f48865a);
        } else {
            bitArray.clear();
        }
        int i3 = i2 * this.f48867c;
        for (int i4 = 0; i4 < this.f48867c; i4++) {
            bitArray.setBulk(i4 * 32, this.f48868d[i3 + i4]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.f48867c;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            iArr = this.f48868d;
            if (i3 >= iArr.length || iArr[i3] != 0) {
                break;
            }
            i3++;
        }
        if (i3 == iArr.length) {
            return null;
        }
        int i4 = this.f48867c;
        int i5 = i3 / i4;
        int i6 = (i3 % i4) * 32;
        while ((iArr[i3] << (31 - i2)) == 0) {
            i2++;
        }
        return new int[]{i6 + i2, i5};
    }

    public int getWidth() {
        return this.f48865a;
    }

    public int hashCode() {
        int i2 = this.f48865a;
        return Arrays.hashCode(this.f48868d) + (((((((i2 * 31) + i2) * 31) + this.f48866b) * 31) + this.f48867c) * 31);
    }

    public void set(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.f48867c);
        int[] iArr = this.f48868d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void setRegion(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 < 1 || i4 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i7 > this.f48866b || i6 > this.f48865a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i3 < i7) {
            int i8 = this.f48867c * i3;
            for (int i9 = i2; i9 < i6; i9++) {
                int[] iArr = this.f48868d;
                int i10 = (i9 / 32) + i8;
                iArr[i10] = iArr[i10] | (1 << (i9 & 31));
            }
            i3++;
        }
    }

    public void setRow(int i2, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.f48868d;
        int i3 = this.f48867c;
        System.arraycopy(bitArray2, 0, iArr, i2 * i3, i3);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.f48867c);
        int[] iArr = this.f48868d;
        iArr[i4] = (~(1 << (i2 & 31))) & iArr[i4];
    }

    public void xor(BitMatrix bitMatrix) {
        int i2 = this.f48865a;
        if (i2 != bitMatrix.f48865a || this.f48866b != bitMatrix.f48866b || this.f48867c != bitMatrix.f48867c) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray(i2);
        for (int i3 = 0; i3 < this.f48866b; i3++) {
            int i4 = this.f48867c * i3;
            int[] bitArray2 = bitMatrix.getRow(i3, bitArray).getBitArray();
            for (int i5 = 0; i5 < this.f48867c; i5++) {
                int[] iArr = this.f48868d;
                int i6 = i4 + i5;
                iArr[i6] = iArr[i6] ^ bitArray2[i5];
            }
        }
    }

    public BitMatrix(int i2, int i3) {
        if (i2 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f48865a = i2;
        this.f48866b = i3;
        int i4 = (i2 + 31) / 32;
        this.f48867c = i4;
        this.f48868d = new int[i4 * i3];
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int i2 = 0; i2 < length; i2++) {
            boolean[] zArr2 = zArr[i2];
            for (int i3 = 0; i3 < length2; i3++) {
                if (zArr2[i3]) {
                    bitMatrix.set(i3, i2);
                }
            }
        }
        return bitMatrix;
    }

    public void flip(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.f48867c);
        int[] iArr = this.f48868d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public String toString(String str, String str2) {
        return a(str, str2, org.apache.commons.lang3.StringUtils.LF);
    }

    private BitMatrix(int i2, int i3, int i4, int[] iArr) {
        this.f48865a = i2;
        this.f48866b = i3;
        this.f48867c = i4;
        this.f48868d = iArr;
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return a(str, str2, str3);
    }
}
