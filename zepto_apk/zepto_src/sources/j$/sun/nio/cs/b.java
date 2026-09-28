package j$.sun.nio.cs;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b extends CharsetEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final e f53168a;

    @Override // java.nio.charset.CharsetEncoder
    public final boolean canEncode(char c2) {
        return c2 <= 255;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final boolean isLegalReplacement(byte[] bArr) {
        return true;
    }

    public b(c cVar) {
        super(cVar, 1.0f, 1.0f);
        e eVar = new e();
        eVar.f53171a = CoderResult.UNDERFLOW;
        this.f53168a = eVar;
    }

    public static int a(char[] cArr, int i2, byte[] bArr, int i3, int i4) {
        int i5 = 0;
        if (i4 <= 0) {
            return 0;
        }
        Objects.requireNonNull(cArr);
        Objects.requireNonNull(bArr);
        if (i2 < 0 || i2 >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        if (i3 < 0 || i3 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
        int i6 = (i2 + i4) - 1;
        if (i6 < 0 || i6 >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i6);
        }
        int i7 = (i3 + i4) - 1;
        if (i7 < 0 || i7 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i7);
        }
        while (i5 < i4) {
            int i8 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 > 255) {
                break;
            }
            bArr[i3] = (byte) c2;
            i5++;
            i2 = i8;
            i3++;
        }
        return i5;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        CoderResult coderResultUnmappableForLength;
        CoderResult coderResultUnmappableForLength2;
        boolean zHasArray = charBuffer.hasArray();
        int i2 = 2;
        e eVar = this.f53168a;
        if (zHasArray && byteBuffer.hasArray()) {
            char[] cArrArray = charBuffer.array();
            int iArrayOffset = charBuffer.arrayOffset();
            int iPosition = charBuffer.position() + iArrayOffset;
            int iLimit = charBuffer.limit() + iArrayOffset;
            if (iPosition > iLimit) {
                iPosition = iLimit;
            }
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset2 = byteBuffer.arrayOffset();
            int iPosition2 = byteBuffer.position() + iArrayOffset2;
            int iLimit2 = byteBuffer.limit() + iArrayOffset2;
            if (iPosition2 > iLimit2) {
                iPosition2 = iLimit2;
            }
            int i3 = iLimit2 - iPosition2;
            int i4 = iLimit - iPosition;
            if (i3 >= i4) {
                i3 = i4;
            }
            try {
                int iA = a(cArrArray, iPosition, bArrArray, iPosition2, i3);
                int i5 = iPosition + iA;
                int i6 = iPosition2 + iA;
                if (iA != i3) {
                    if (eVar.b(cArrArray[i5], cArrArray, i5, iLimit) < 0) {
                        coderResultUnmappableForLength2 = eVar.f53171a;
                    } else {
                        if (!eVar.f53172b) {
                            i2 = 1;
                        }
                        coderResultUnmappableForLength2 = CoderResult.unmappableForLength(i2);
                    }
                } else if (i3 < i4) {
                    coderResultUnmappableForLength2 = CoderResult.OVERFLOW;
                } else {
                    coderResultUnmappableForLength2 = CoderResult.UNDERFLOW;
                }
                return coderResultUnmappableForLength2;
            } finally {
            }
        }
        int iPosition3 = charBuffer.position();
        while (true) {
            try {
                if (charBuffer.hasRemaining()) {
                    char c2 = charBuffer.get();
                    if (c2 <= 255) {
                        if (!byteBuffer.hasRemaining()) {
                            coderResultUnmappableForLength = CoderResult.OVERFLOW;
                            break;
                        }
                        byteBuffer.put((byte) c2);
                        iPosition3++;
                    } else if (eVar.a(c2, charBuffer) < 0) {
                        coderResultUnmappableForLength = eVar.f53171a;
                    } else {
                        if (!eVar.f53172b) {
                            i2 = 1;
                        }
                        coderResultUnmappableForLength = CoderResult.unmappableForLength(i2);
                    }
                } else {
                    coderResultUnmappableForLength = CoderResult.UNDERFLOW;
                    break;
                }
            } finally {
            }
        }
        return coderResultUnmappableForLength;
    }
}
