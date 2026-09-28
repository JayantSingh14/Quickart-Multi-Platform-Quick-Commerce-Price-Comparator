package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;

/* loaded from: classes3.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f4366a;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final String a(int i2, int i3) {
        byte[] bArr = this.f4366a;
        if ((i2 | i3 | ((bArr.length - i2) - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i4 = i2 + i3;
        char[] cArr = new char[i3];
        int i5 = 0;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                break;
            }
            i2++;
            cArr[i5] = (char) b2;
            i5++;
        }
        while (i2 < i4) {
            int i6 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                int i7 = i5 + 1;
                cArr[i5] = (char) b3;
                while (i6 < i4) {
                    byte b4 = bArr[i6];
                    if (b4 < 0) {
                        break;
                    }
                    i6++;
                    cArr[i7] = (char) b4;
                    i7++;
                }
                i5 = i7;
                i2 = i6;
            } else {
                if (b3 < -32) {
                    if (i6 >= i4) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    i2 += 2;
                    byte b5 = bArr[i6];
                    int i8 = i5 + 1;
                    if (b3 < -62) {
                        throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
                    }
                    if (Utf8.DecodeUtil.a(b5)) {
                        throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
                    }
                    cArr[i5] = (char) ((b5 & 63) | ((b3 & 31) << 6));
                    i5 = i8;
                } else {
                    if (b3 >= -16) {
                        if (i6 >= i4 - 2) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        byte b6 = bArr[i6];
                        int i9 = i2 + 3;
                        byte b7 = bArr[i2 + 2];
                        i2 += 4;
                        byte b8 = bArr[i9];
                        if (!Utf8.DecodeUtil.a(b6)) {
                            if ((((b6 + 112) + (b3 << 28)) >> 30) == 0 && !Utf8.DecodeUtil.a(b7) && !Utf8.DecodeUtil.a(b8)) {
                                int i10 = ((b6 & 63) << 12) | ((b3 & 7) << 18) | ((b7 & 63) << 6) | (b8 & 63);
                                cArr[i5] = (char) ((i10 >>> 10) + 55232);
                                cArr[i5 + 1] = (char) ((i10 & 1023) + 56320);
                                i5 += 2;
                            }
                        }
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    if (i6 >= i4 - 1) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    int i11 = i2 + 2;
                    byte b9 = bArr[i6];
                    i2 += 3;
                    byte b10 = bArr[i11];
                    int i12 = i5 + 1;
                    if (Utf8.DecodeUtil.a(b9) || ((b3 == -32 && b9 < -96) || ((b3 == -19 && b9 >= -96) || Utf8.DecodeUtil.a(b10)))) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    cArr[i5] = (char) (((b9 & 63) << 6) | ((b3 & 15) << 12) | (b10 & 63));
                    i5 = i12;
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final byte get(int i2) {
        return this.f4366a[i2];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final double getDouble(int i2) {
        return Double.longBitsToDouble(getLong(i2));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final float getFloat(int i2) {
        return Float.intBitsToFloat(getInt(i2));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final int getInt(int i2) {
        byte[] bArr = this.f4366a;
        return (bArr[i2] & 255) | (bArr[i2 + 3] << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final long getLong(int i2) {
        byte[] bArr = this.f4366a;
        return (bArr[i2 + 7] << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((255 & bArr[i2 + 6]) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final short getShort(int i2) {
        byte[] bArr = this.f4366a;
        return (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
    }

    public ArrayReadWriteBuf(int i2) {
        this.f4366a = new byte[i2];
    }
}
