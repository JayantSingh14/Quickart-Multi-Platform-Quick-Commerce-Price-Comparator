package androidx.datastore.preferences.protobuf;

import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.UnsafeUtil;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class Utf8 {

    /* renamed from: a, reason: collision with root package name */
    public static final Processor f4190a;

    public static class DecodeUtil {
        public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (!d(b3)) {
                if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !d(b4) && !d(b5)) {
                    int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                    cArr[i2] = (char) ((i3 >>> 10) + 55232);
                    cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                    return;
                }
            }
            throw InvalidProtocolBufferException.b();
        }

        public static void b(byte b2, byte b3, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (b2 < -62 || d(b3)) {
                throw InvalidProtocolBufferException.b();
            }
            cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
        }

        public static void c(byte b2, byte b3, byte b4, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (d(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || d(b4)))) {
                throw InvalidProtocolBufferException.b();
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
        }

        public static boolean d(byte b2) {
            return b2 > -65;
        }
    }

    public static abstract class Processor {
        public static String b(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte b2 = byteBuffer.get(i2);
                if (b2 < 0) {
                    break;
                }
                i2++;
                cArr[i5] = (char) b2;
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte b3 = byteBuffer.get(i2);
                if (b3 >= 0) {
                    int i8 = i6 + 1;
                    cArr[i6] = (char) b3;
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b4 = byteBuffer.get(i9);
                        if (b4 < 0) {
                            break;
                        }
                        i9++;
                        cArr[i8] = (char) b4;
                        i8++;
                    }
                    i6 = i8;
                    i2 = i9;
                } else if (b3 < -32) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.b();
                    }
                    i2 += 2;
                    DecodeUtil.b(b3, byteBuffer.get(i7), cArr, i6);
                    i6++;
                } else if (b3 < -16) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int i10 = i2 + 2;
                    i2 += 3;
                    DecodeUtil.c(b3, byteBuffer.get(i7), byteBuffer.get(i10), cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    byte b5 = byteBuffer.get(i7);
                    int i11 = i2 + 3;
                    byte b6 = byteBuffer.get(i2 + 2);
                    i2 += 4;
                    DecodeUtil.a(b3, b5, b6, byteBuffer.get(i11), cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        public static int g(ByteBuffer byteBuffer, int i2, int i3, int i4) {
            byte b2;
            int i5;
            byte b3;
            int i6;
            int i7 = i3;
            if (i2 != 0) {
                if (i7 >= i4) {
                    return i2;
                }
                byte b4 = (byte) i2;
                if (b4 < -32) {
                    if (b4 < -62) {
                        return -1;
                    }
                    int i8 = i7 + 1;
                    if (byteBuffer.get(i7) > -65) {
                        return -1;
                    }
                    i7 = i8;
                } else if (b4 < -16) {
                    byte b5 = (byte) (~(i2 >> 8));
                    if (b5 == 0) {
                        i6 = i7 + 1;
                        b3 = byteBuffer.get(i7);
                        if (i6 >= i4) {
                            return Utf8.e(b4, b3);
                        }
                    } else {
                        b3 = b5;
                        i6 = i7;
                    }
                    if (b3 > -65) {
                        return -1;
                    }
                    if (b4 == -32 && b3 < -96) {
                        return -1;
                    }
                    if (b4 == -19 && b3 >= -96) {
                        return -1;
                    }
                    i7 = i6 + 1;
                    if (byteBuffer.get(i6) > -65) {
                        return -1;
                    }
                } else {
                    byte b6 = (byte) (~(i2 >> 8));
                    if (b6 == 0) {
                        i5 = i7 + 1;
                        b6 = byteBuffer.get(i7);
                        if (i5 >= i4) {
                            return Utf8.e(b4, b6);
                        }
                        b2 = 0;
                    } else {
                        b2 = (byte) (i2 >> 16);
                        i5 = i7;
                    }
                    if (b2 == 0) {
                        int i9 = i5 + 1;
                        byte b7 = byteBuffer.get(i5);
                        if (i9 >= i4) {
                            return Utf8.f(b4, b6, b7);
                        }
                        b2 = b7;
                        i5 = i9;
                    }
                    if (b6 > -65) {
                        return -1;
                    }
                    if ((((b6 + 112) + (b4 << 28)) >> 30) != 0 || b2 > -65) {
                        return -1;
                    }
                    i7 = i5 + 1;
                    if (byteBuffer.get(i5) > -65) {
                        return -1;
                    }
                }
            }
            Processor processor = Utf8.f4190a;
            int i10 = i4 - 7;
            int i11 = i7;
            while (i11 < i10 && (byteBuffer.getLong(i11) & (-9187201950435737472L)) == 0) {
                i11 += 8;
            }
            int i12 = (i11 - i7) + i7;
            while (i12 < i4) {
                int i13 = i12 + 1;
                byte b8 = byteBuffer.get(i12);
                if (b8 >= 0) {
                    i12 = i13;
                } else if (b8 < -32) {
                    if (i13 >= i4) {
                        return b8;
                    }
                    if (b8 < -62 || byteBuffer.get(i13) > -65) {
                        return -1;
                    }
                    i12 += 2;
                } else if (b8 < -16) {
                    if (i13 >= i4 - 1) {
                        return Utf8.b(byteBuffer, b8, i13, i4 - i13);
                    }
                    int i14 = i12 + 2;
                    byte b9 = byteBuffer.get(i13);
                    if (b9 > -65) {
                        return -1;
                    }
                    if (b8 == -32 && b9 < -96) {
                        return -1;
                    }
                    if ((b8 == -19 && b9 >= -96) || byteBuffer.get(i14) > -65) {
                        return -1;
                    }
                    i12 += 3;
                } else {
                    if (i13 >= i4 - 2) {
                        return Utf8.b(byteBuffer, b8, i13, i4 - i13);
                    }
                    int i15 = i12 + 2;
                    byte b10 = byteBuffer.get(i13);
                    if (b10 > -65) {
                        return -1;
                    }
                    if ((((b10 + 112) + (b8 << 28)) >> 30) != 0) {
                        return -1;
                    }
                    int i16 = i12 + 3;
                    if (byteBuffer.get(i15) > -65) {
                        return -1;
                    }
                    i12 += 4;
                    if (byteBuffer.get(i16) > -65) {
                        return -1;
                    }
                }
            }
            return 0;
        }

        public abstract String a(int i2, byte[] bArr, int i3);

        public abstract String c(ByteBuffer byteBuffer, int i2, int i3);

        public abstract int d(String str, byte[] bArr, int i2, int i3);

        public abstract int e(int i2, int i3, byte[] bArr, int i4);

        public final int f(ByteBuffer byteBuffer, int i2, int i3, int i4) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? h(byteBuffer, i2, i3, i4) : g(byteBuffer, i2, i3, i4);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return e(i2, i3 + iArrayOffset, byteBuffer.array(), iArrayOffset + i4);
        }

        public abstract int h(ByteBuffer byteBuffer, int i2, int i3, int i4);
    }

    public static final class SafeProcessor extends Processor {
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final String a(int i2, byte[] bArr, int i3) throws InvalidProtocolBufferException {
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
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 >= 0) {
                    int i8 = i6 + 1;
                    cArr[i6] = (char) b3;
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b4 = bArr[i9];
                        if (b4 < 0) {
                            break;
                        }
                        i9++;
                        cArr[i8] = (char) b4;
                        i8++;
                    }
                    i6 = i8;
                    i2 = i9;
                } else if (b3 < -32) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.b();
                    }
                    i2 += 2;
                    DecodeUtil.b(b3, bArr[i7], cArr, i6);
                    i6++;
                } else if (b3 < -16) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int i10 = i2 + 2;
                    i2 += 3;
                    DecodeUtil.c(b3, bArr[i7], bArr[i10], cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    byte b5 = bArr[i7];
                    int i11 = i2 + 3;
                    byte b6 = bArr[i2 + 2];
                    i2 += 4;
                    DecodeUtil.a(b3, b5, b6, bArr[i11], cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final String c(ByteBuffer byteBuffer, int i2, int i3) {
            return Processor.b(byteBuffer, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final int d(String str, byte[] bArr, int i2, int i3) {
            int i4;
            int i5;
            char cCharAt;
            int length = str.length();
            int i6 = i3 + i2;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i2) < i6 && (cCharAt = str.charAt(i7)) < 128) {
                bArr[i5] = (byte) cCharAt;
                i7++;
            }
            if (i7 == length) {
                return i2 + length;
            }
            int i8 = i2 + i7;
            while (i7 < length) {
                char cCharAt2 = str.charAt(i7);
                if (cCharAt2 < 128 && i8 < i6) {
                    bArr[i8] = (byte) cCharAt2;
                    i8++;
                } else if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                    i8 += 2;
                    bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                        if (i8 > i6 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                        }
                        int i10 = i7 + 1;
                        if (i10 != str.length()) {
                            char cCharAt3 = str.charAt(i10);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i11 = i8 + 3;
                                bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i8 += 4;
                                bArr[i11] = (byte) ((codePoint & 63) | 128);
                                i7 = i10;
                            } else {
                                i7 = i10;
                            }
                        }
                        throw new UnpairedSurrogateException(i7 - 1, length);
                    }
                    bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i12 = i8 + 2;
                    bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i8 += 3;
                    bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
                }
                i7++;
            }
            return i8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        
            if (r14[r13] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
        
            if (r14[r13] > (-65)) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0082, code lost:
        
            if (r14[r13] > (-65)) goto L50;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int e(int r12, int r13, byte[] r14, int r15) {
            /*
                Method dump skipped, instructions count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.SafeProcessor.e(int, int, byte[], int):int");
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final int h(ByteBuffer byteBuffer, int i2, int i3, int i4) {
            return Processor.g(byteBuffer, i2, i3, i4);
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i2, int i3) {
            super(b.d(i2, i3, "Unpaired surrogate at index ", " of "));
        }
    }

    public static final class UnsafeProcessor extends Processor {
        public static int i(int i2, int i3, long j2) {
            if (i3 == 0) {
                Processor processor = Utf8.f4190a;
                if (i2 > -12) {
                    return -1;
                }
                return i2;
            }
            if (i3 == 1) {
                return Utf8.e(i2, UnsafeUtil.f4183c.f(j2));
            }
            if (i3 != 2) {
                throw new AssertionError();
            }
            UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
            return Utf8.f(i2, memoryAccessor.f(j2), memoryAccessor.f(j2 + 1));
        }

        public static int j(long j2, byte[] bArr, int i2, int i3) {
            if (i3 == 0) {
                Processor processor = Utf8.f4190a;
                if (i2 > -12) {
                    return -1;
                }
                return i2;
            }
            if (i3 == 1) {
                return Utf8.e(i2, UnsafeUtil.h(j2, bArr));
            }
            if (i3 == 2) {
                return Utf8.f(i2, UnsafeUtil.h(j2, bArr), UnsafeUtil.h(j2 + 1, bArr));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final String a(int i2, byte[] bArr, int i3) throws InvalidProtocolBufferException {
            Charset charset = Internal.f4024a;
            String str = new String(bArr, i2, i3, charset);
            if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i2, i3 + i2))) {
                throw InvalidProtocolBufferException.b();
            }
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final String c(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            long j2;
            byte bF;
            byte bF2;
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            long jB = UnsafeUtil.b(byteBuffer) + i2;
            long j3 = i3 + jB;
            char[] cArr = new char[i3];
            int i4 = 0;
            while (true) {
                j2 = 1;
                if (jB >= j3 || (bF2 = UnsafeUtil.f4183c.f(jB)) < 0) {
                    break;
                }
                jB++;
                cArr[i4] = (char) bF2;
                i4++;
            }
            int i5 = i4;
            while (jB < j3) {
                long j4 = jB + j2;
                UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
                byte bF3 = memoryAccessor.f(jB);
                if (bF3 >= 0) {
                    int i6 = i5 + 1;
                    cArr[i5] = (char) bF3;
                    while (j4 < j3 && (bF = UnsafeUtil.f4183c.f(j4)) >= 0) {
                        j4 += j2;
                        cArr[i6] = (char) bF;
                        i6++;
                    }
                    i5 = i6;
                    jB = j4;
                } else {
                    if (!(bF3 < -32)) {
                        if (bF3 < -16) {
                            if (j4 >= j3 - j2) {
                                throw InvalidProtocolBufferException.b();
                            }
                            long j5 = jB + 2;
                            jB += 3;
                            DecodeUtil.c(bF3, memoryAccessor.f(j4), memoryAccessor.f(j5), cArr, i5);
                            i5++;
                        } else {
                            if (j4 >= j3 - 2) {
                                throw InvalidProtocolBufferException.b();
                            }
                            byte bF4 = memoryAccessor.f(j4);
                            long j6 = jB + 3;
                            byte bF5 = memoryAccessor.f(jB + 2);
                            jB += 4;
                            DecodeUtil.a(bF3, bF4, bF5, memoryAccessor.f(j6), cArr, i5);
                            i5 += 2;
                        }
                    } else {
                        if (j4 >= j3) {
                            throw InvalidProtocolBufferException.b();
                        }
                        jB += 2;
                        DecodeUtil.b(bF3, memoryAccessor.f(j4), cArr, i5);
                        i5++;
                    }
                }
                j2 = 1;
            }
            return new String(cArr, 0, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final int d(String str, byte[] bArr, int i2, int i3) {
            long j2;
            long j3;
            long j4;
            int i4;
            char cCharAt;
            long j5 = i2;
            long j6 = i3 + j5;
            int length = str.length();
            if (length > i3 || bArr.length - i3 < i2) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i2 + i3));
            }
            int i5 = 0;
            while (true) {
                j2 = 1;
                if (i5 >= length || (cCharAt = str.charAt(i5)) >= 128) {
                    break;
                }
                UnsafeUtil.m(bArr, j5, (byte) cCharAt);
                i5++;
                j5 = 1 + j5;
            }
            if (i5 == length) {
                return (int) j5;
            }
            while (i5 < length) {
                char cCharAt2 = str.charAt(i5);
                if (cCharAt2 < 128 && j5 < j6) {
                    UnsafeUtil.m(bArr, j5, (byte) cCharAt2);
                    j4 = j6;
                    j3 = j2;
                    j5 += j2;
                } else if (cCharAt2 >= 2048 || j5 > j6 - 2) {
                    j3 = j2;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j5 > j6 - 3) {
                        j4 = j6;
                        if (j5 > j4 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(cCharAt2, str.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i5, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j5);
                        }
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char cCharAt3 = str.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.m(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.m(bArr, j5 + j3, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j7 = j5 + 3;
                                UnsafeUtil.m(bArr, j5 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j5 += 4;
                                UnsafeUtil.m(bArr, j7, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new UnpairedSurrogateException(i5 - 1, length);
                    }
                    UnsafeUtil.m(bArr, j5, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j8 = j5 + 2;
                    j4 = j6;
                    UnsafeUtil.m(bArr, j5 + j3, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j5 += 3;
                    UnsafeUtil.m(bArr, j8, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j3 = j2;
                    long j9 = j5 + j3;
                    UnsafeUtil.m(bArr, j5, (byte) ((cCharAt2 >>> 6) | 960));
                    j5 += 2;
                    UnsafeUtil.m(bArr, j9, (byte) ((cCharAt2 & '?') | 128));
                    j4 = j6;
                }
                i5++;
                j2 = j3;
                j6 = j4;
            }
            return (int) j5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.h(r4, r22) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.h(r4, r22) > (-65)) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b0, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.h(r4, r22) > (-65)) goto L54;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int e(int r20, int r21, byte[] r22, int r23) {
            /*
                Method dump skipped, instructions count: 435
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.e(int, int, byte[], int):int");
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public final int h(ByteBuffer byteBuffer, int i2, int i3, int i4) {
            long j2;
            byte b2;
            int i5;
            byte bF;
            long j3;
            if ((i3 | i4 | (byteBuffer.limit() - i4)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            long jB = UnsafeUtil.b(byteBuffer) + i3;
            long j4 = (i4 - i3) + jB;
            if (i2 == 0) {
                j2 = 1;
                b2 = 0;
            } else {
                if (jB >= j4) {
                    return i2;
                }
                b2 = 0;
                byte b3 = (byte) i2;
                if (b3 < -32) {
                    if (b3 < -62) {
                        return -1;
                    }
                    j3 = jB + 1;
                    if (UnsafeUtil.f4183c.f(jB) > -65) {
                        return -1;
                    }
                } else if (b3 < -16) {
                    byte bF2 = (byte) (~(i2 >> 8));
                    if (bF2 == 0) {
                        long j5 = jB + 1;
                        bF2 = UnsafeUtil.f4183c.f(jB);
                        if (j5 >= j4) {
                            return Utf8.e(b3, bF2);
                        }
                        jB = j5;
                    }
                    if (bF2 > -65) {
                        return -1;
                    }
                    if (b3 == -32 && bF2 < -96) {
                        return -1;
                    }
                    if (b3 == -19 && bF2 >= -96) {
                        return -1;
                    }
                    j3 = jB + 1;
                    if (UnsafeUtil.f4183c.f(jB) > -65) {
                        return -1;
                    }
                } else {
                    j2 = 1;
                    byte b4 = (byte) (~(i2 >> 8));
                    if (b4 == 0) {
                        long j6 = jB + 1;
                        byte bF3 = UnsafeUtil.f4183c.f(jB);
                        if (j6 >= j4) {
                            return Utf8.e(b3, bF3);
                        }
                        jB = j6;
                        b4 = bF3;
                        bF = 0;
                    } else {
                        bF = (byte) (i2 >> 16);
                    }
                    if (bF == 0) {
                        long j7 = jB + 1;
                        bF = UnsafeUtil.f4183c.f(jB);
                        if (j7 >= j4) {
                            return Utf8.f(b3, b4, bF);
                        }
                        jB = j7;
                    }
                    if (b4 > -65) {
                        return -1;
                    }
                    if ((((b4 + 112) + (b3 << 28)) >> 30) != 0 || bF > -65) {
                        return -1;
                    }
                    long j8 = jB + 1;
                    if (UnsafeUtil.f4183c.f(jB) > -65) {
                        return -1;
                    }
                    jB = j8;
                }
                j2 = 1;
                jB = j3;
            }
            int i6 = (int) (j4 - jB);
            if (i6 < 16) {
                i5 = b2;
            } else {
                int i7 = (int) ((-jB) & 7);
                long j9 = jB;
                int i8 = i7;
                while (true) {
                    if (i8 > 0) {
                        long j10 = j9 + j2;
                        if (UnsafeUtil.f4183c.f(j9) < 0) {
                            i5 = i7 - i8;
                            break;
                        }
                        i8--;
                        j9 = j10;
                    } else {
                        int i9 = i6 - i7;
                        while (i9 >= 8 && (UnsafeUtil.f4183c.k(j9) & (-9187201950435737472L)) == 0) {
                            j9 += 8;
                            i9 -= 8;
                        }
                        i5 = i6 - i9;
                    }
                }
            }
            long j11 = jB + i5;
            int i10 = i6 - i5;
            while (true) {
                byte bF4 = b2;
                while (true) {
                    if (i10 <= 0) {
                        break;
                    }
                    long j12 = j11 + j2;
                    bF4 = UnsafeUtil.f4183c.f(j11);
                    if (bF4 < 0) {
                        j11 = j12;
                        break;
                    }
                    i10--;
                    j11 = j12;
                }
                if (i10 == 0) {
                    return b2;
                }
                int i11 = i10 - 1;
                if (bF4 < -32) {
                    if (i11 == 0) {
                        return bF4;
                    }
                    i10 -= 2;
                    if (bF4 < -62) {
                        return -1;
                    }
                    long j13 = j11 + j2;
                    if (UnsafeUtil.f4183c.f(j11) > -65) {
                        return -1;
                    }
                    j11 = j13;
                } else if (bF4 < -16) {
                    if (i11 < 2) {
                        return i(bF4, i11, j11);
                    }
                    i10 -= 3;
                    long j14 = j11 + j2;
                    UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
                    byte bF5 = memoryAccessor.f(j11);
                    if (bF5 > -65) {
                        return -1;
                    }
                    if (bF4 == -32 && bF5 < -96) {
                        return -1;
                    }
                    if (bF4 == -19 && bF5 >= -96) {
                        return -1;
                    }
                    j11 += 2;
                    if (memoryAccessor.f(j14) > -65) {
                        return -1;
                    }
                } else {
                    if (i11 < 3) {
                        return i(bF4, i11, j11);
                    }
                    i10 -= 4;
                    long j15 = j11 + j2;
                    UnsafeUtil.MemoryAccessor memoryAccessor2 = UnsafeUtil.f4183c;
                    byte bF6 = memoryAccessor2.f(j11);
                    if (bF6 > -65) {
                        return -1;
                    }
                    if ((((bF6 + 112) + (bF4 << 28)) >> 30) != 0) {
                        return -1;
                    }
                    long j16 = 2 + j11;
                    if (memoryAccessor2.f(j15) > -65) {
                        return -1;
                    }
                    j11 += 3;
                    if (memoryAccessor2.f(j16) > -65) {
                        return -1;
                    }
                }
            }
        }
    }

    static {
        f4190a = (UnsafeUtil.f4185e && UnsafeUtil.f4184d && !Android.a()) ? new UnsafeProcessor() : new SafeProcessor();
    }

    public static int a(int i2, byte[] bArr, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            if (b2 > -12) {
                return -1;
            }
            return b2;
        }
        if (i4 == 1) {
            return e(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return f(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static int b(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        if (i4 == 0) {
            if (i2 > -12) {
                return -1;
            }
            return i2;
        }
        if (i4 == 1) {
            return e(i2, byteBuffer.get(i3));
        }
        if (i4 == 2) {
            return f(i2, byteBuffer.get(i3), byteBuffer.get(i3 + 1));
        }
        throw new AssertionError();
    }

    public static String c(ByteBuffer byteBuffer, int i2, int i3) {
        Processor processor = f4190a;
        processor.getClass();
        if (byteBuffer.hasArray()) {
            return processor.a(byteBuffer.arrayOffset() + i2, byteBuffer.array(), i3);
        }
        return byteBuffer.isDirect() ? processor.c(byteBuffer, i2, i3) : Processor.b(byteBuffer, i2, i3);
    }

    public static int d(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && str.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                int length2 = str.length();
                while (i3 < length2) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) < 65536) {
                                throw new UnpairedSurrogateException(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i4 + 4294967296L));
    }

    public static int e(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    public static int f(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }
}
