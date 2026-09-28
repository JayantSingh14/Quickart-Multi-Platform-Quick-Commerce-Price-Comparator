package j$.util;

import java.util.Arrays;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes2.dex */
public class Base64 {
    public static Encoder getEncoder() {
        return Encoder.f53502c;
    }

    public static Decoder getDecoder() {
        return Decoder.f53499c;
    }

    public static class Encoder {

        /* renamed from: a, reason: collision with root package name */
        public static final char[] f53500a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

        /* renamed from: b, reason: collision with root package name */
        public static final char[] f53501b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', Soundex.SILENT_MARKER, '_'};

        /* renamed from: c, reason: collision with root package name */
        public static final Encoder f53502c = new Encoder();

        public String encodeToString(byte[] bArr) {
            int length = ((bArr.length + 2) / 3) * 4;
            byte[] bArrCopyOf = new byte[length];
            int length2 = bArr.length;
            char[] cArr = f53500a;
            int i2 = (length2 / 3) * 3;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int iMin = Math.min(i3 + i2, i2);
                int i5 = i3;
                int i6 = i4;
                while (i5 < iMin) {
                    int i7 = i5 + 2;
                    int i8 = ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5] & 255) << 16);
                    i5 += 3;
                    int i9 = i8 | (bArr[i7] & 255);
                    bArrCopyOf[i6] = (byte) cArr[(i9 >>> 18) & 63];
                    bArrCopyOf[i6 + 1] = (byte) cArr[(i9 >>> 12) & 63];
                    int i10 = i6 + 3;
                    bArrCopyOf[i6 + 2] = (byte) cArr[(i9 >>> 6) & 63];
                    i6 += 4;
                    bArrCopyOf[i10] = (byte) cArr[i9 & 63];
                }
                int i11 = ((iMin - i3) / 3) * 4;
                i4 += i11;
                if (i11 == -1 && iMin < length2) {
                    throw null;
                }
                i3 = iMin;
            }
            if (i3 < length2) {
                int i12 = i3 + 1;
                int i13 = bArr[i3] & 255;
                int i14 = i4 + 1;
                bArrCopyOf[i4] = (byte) cArr[i13 >> 2];
                if (i12 == length2) {
                    bArrCopyOf[i14] = (byte) cArr[(i13 << 4) & 63];
                    int i15 = i4 + 3;
                    bArrCopyOf[i4 + 2] = 61;
                    i4 += 4;
                    bArrCopyOf[i15] = 61;
                } else {
                    int i16 = bArr[i12] & 255;
                    bArrCopyOf[i14] = (byte) cArr[((i13 << 4) & 63) | (i16 >> 4)];
                    int i17 = i4 + 3;
                    bArrCopyOf[i4 + 2] = (byte) cArr[(i16 << 2) & 63];
                    i4 += 4;
                    bArrCopyOf[i17] = 61;
                }
            }
            if (i4 != length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i4);
            }
            return new String(bArrCopyOf, 0, 0, bArrCopyOf.length);
        }
    }

    public static class Decoder {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f53497a;

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f53498b;

        /* renamed from: c, reason: collision with root package name */
        public static final Decoder f53499c;

        static {
            int[] iArr = new int[256];
            f53497a = iArr;
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < 64; i2++) {
                f53497a[Encoder.f53500a[i2]] = i2;
            }
            f53497a[61] = -2;
            int[] iArr2 = new int[256];
            f53498b = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i3 = 0; i3 < 64; i3++) {
                f53498b[Encoder.f53501b[i3]] = i3;
            }
            f53498b[61] = -2;
            f53499c = new Decoder();
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
        
            if (r10 != 18) goto L55;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public byte[] decode(java.lang.String r20) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.Base64.Decoder.decode(java.lang.String):byte[]");
        }
    }
}
