package okio;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f56924d = new ByteString(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f56925a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f56926b;

    /* renamed from: c, reason: collision with root package name */
    public transient String f56927c;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static ByteString a(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bArrA = Base64.a(str);
            if (bArrA != null) {
                return new ByteString(bArrA);
            }
            return null;
        }

        public static ByteString b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (okio.internal.ByteString.a(str.charAt(i3 + 1)) + (okio.internal.ByteString.a(str.charAt(i3)) << 4));
            }
            return new ByteString(bArr);
        }

        public static ByteString c(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            ByteString byteString = new ByteString(bytes);
            byteString.f56927c = str;
            return byteString;
        }

        public static ByteString d(int i2, byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Buffer.UnsafeCursor unsafeCursor = SegmentedByteString.f56899a;
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            if (i2 == SegmentedByteString.f56900b) {
                i2 = bArr.length;
            }
            SegmentedByteString.b(bArr.length, 0, i2);
            return new ByteString(ArraysKt.o(0, bArr, i2));
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f56925a = data;
    }

    public static int h(ByteString byteString, ByteString other) {
        byteString.getClass();
        Intrinsics.checkNotNullParameter(other, "other");
        return byteString.g(0, other.f56925a);
    }

    public static int p(ByteString byteString, ByteString other) {
        int i2 = SegmentedByteString.f56900b;
        byteString.getClass();
        Intrinsics.checkNotNullParameter(other, "other");
        return byteString.n(i2, other.f56925a);
    }

    public static ByteString u(ByteString byteString, int i2, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = SegmentedByteString.f56900b;
        }
        return byteString.t(i2, i3);
    }

    public void A(Buffer buffer, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.J1(this.f56925a, 0, i2);
    }

    public String a() {
        return Base64.b(this.f56925a);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iD = d();
        int iD2 = other.d();
        int iMin = Math.min(iD, iD2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int iL = l(i2) & 255;
            int iL2 = other.l(i2) & 255;
            if (iL != iL2) {
                return iL < iL2 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
    }

    public ByteString c(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.f56925a, 0, d());
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public int d() {
        return this.f56925a.length;
    }

    public String e() {
        byte[] bArr = this.f56925a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = okio.internal.ByteString.f57010a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 += 2;
            cArr[i3] = cArr2[b2 & 15];
        }
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int iD = byteString.d();
            byte[] bArr = this.f56925a;
            if (iD == bArr.length && byteString.q(0, 0, bArr, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int g(int i2, byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte[] bArr = this.f56925a;
        int length = bArr.length - other.length;
        int iMax = Math.max(i2, 0);
        if (iMax > length) {
            return -1;
        }
        while (!SegmentedByteString.a(bArr, iMax, 0, other, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public int hashCode() {
        int i2 = this.f56926b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f56925a);
        this.f56926b = iHashCode;
        return iHashCode;
    }

    public byte[] i() {
        return this.f56925a;
    }

    public byte l(int i2) {
        return this.f56925a[i2];
    }

    public int n(int i2, byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iC = SegmentedByteString.c(this, i2);
        byte[] bArr = this.f56925a;
        for (int iMin = Math.min(iC, bArr.length - other.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.a(bArr, iMin, 0, other, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean q(int i2, int i3, byte[] other, int i4) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0) {
            return false;
        }
        byte[] bArr = this.f56925a;
        return i2 <= bArr.length - i4 && i3 >= 0 && i3 <= other.length - i4 && SegmentedByteString.a(bArr, i2, i3, other, i4);
    }

    public boolean r(int i2, ByteString other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.q(0, i2, this.f56925a, i3);
    }

    public String s(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.f56925a, charset);
    }

    public ByteString t(int i2, int i3) {
        int iC = SegmentedByteString.c(this, i3);
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f56925a;
        if (iC > bArr.length) {
            throw new IllegalArgumentException(b.n(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (iC - i2 >= 0) {
            return (i2 == 0 && iC == bArr.length) ? this : new ByteString(ArraysKt.o(i2, bArr, iC));
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
    }

    public String toString() {
        byte b2;
        int i2;
        byte[] bArr = this.f56925a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            if (i3 >= length) {
                break;
            }
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                int i6 = i5 + 1;
                if (i5 == 64) {
                    break;
                }
                if ((b3 != 10 && b3 != 13 && ((b3 >= 0 && b3 < 32) || (127 <= b3 && b3 < 160))) || b3 == 65533) {
                    break;
                }
                i4 += b3 < 65536 ? 1 : 2;
                i3++;
                while (true) {
                    i5 = i6;
                    if (i3 < length && (b2 = bArr[i3]) >= 0) {
                        i3++;
                        i6 = i5 + 1;
                        if (i5 == 64) {
                            break loop0;
                        }
                        if ((b2 != 10 && b2 != 13 && ((b2 >= 0 && b2 < 32) || (127 <= b2 && b2 < 160))) || b2 == 65533) {
                            break loop0;
                        }
                        i4 += b2 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b3 >> 5) == -2) {
                int i7 = i3 + 1;
                if (length > i7) {
                    byte b4 = bArr[i7];
                    if ((b4 & 192) == 128) {
                        int i8 = (b4 ^ 3968) ^ (b3 << 6);
                        if (i8 >= 128) {
                            i2 = i5 + 1;
                            if (i5 == 64) {
                                break;
                            }
                            if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                                break;
                            }
                            i4 += i8 < 65536 ? 1 : 2;
                            Unit unit = Unit.f53572a;
                            i3 += 2;
                            i5 = i2;
                        } else if (i5 != 64) {
                            break;
                        }
                    } else if (i5 != 64) {
                        break;
                    }
                } else if (i5 != 64) {
                    break;
                }
            } else if ((b3 >> 4) == -2) {
                int i9 = i3 + 2;
                if (length > i9) {
                    byte b5 = bArr[i3 + 1];
                    if ((b5 & 192) == 128) {
                        byte b6 = bArr[i9];
                        if ((b6 & 192) == 128) {
                            int i10 = ((b6 ^ (-123008)) ^ (b5 << 6)) ^ (b3 << 12);
                            if (i10 < 2048) {
                                if (i5 != 64) {
                                    break;
                                }
                            } else if (55296 > i10 || i10 >= 57344) {
                                i2 = i5 + 1;
                                if (i5 == 64) {
                                    break;
                                }
                                if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                    break;
                                }
                                i4 += i10 < 65536 ? 1 : 2;
                                Unit unit2 = Unit.f53572a;
                                i3 += 3;
                                i5 = i2;
                            } else if (i5 != 64) {
                                break;
                            }
                        } else if (i5 != 64) {
                            break;
                        }
                    } else if (i5 != 64) {
                        break;
                    }
                } else if (i5 != 64) {
                    break;
                }
            } else if ((b3 >> 3) == -2) {
                int i11 = i3 + 3;
                if (length > i11) {
                    byte b7 = bArr[i3 + 1];
                    if ((b7 & 192) == 128) {
                        byte b8 = bArr[i3 + 2];
                        if ((b8 & 192) == 128) {
                            byte b9 = bArr[i11];
                            if ((b9 & 192) == 128) {
                                int i12 = (((b9 ^ 3678080) ^ (b8 << 6)) ^ (b7 << 12)) ^ (b3 << 18);
                                if (i12 > 1114111) {
                                    if (i5 != 64) {
                                        break;
                                    }
                                } else if (55296 > i12 || i12 >= 57344) {
                                    if (i12 >= 65536) {
                                        int i13 = i5 + 1;
                                        if (i5 == 64) {
                                            break;
                                        }
                                        if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                                            break;
                                        }
                                        i4 += i12 < 65536 ? 1 : 2;
                                        Unit unit3 = Unit.f53572a;
                                        i3 += 4;
                                        i5 = i13;
                                    } else if (i5 != 64) {
                                        break;
                                    }
                                } else if (i5 != 64) {
                                    break;
                                }
                            } else if (i5 != 64) {
                                break;
                            }
                        } else if (i5 != 64) {
                            break;
                        }
                    } else if (i5 != 64) {
                        break;
                    }
                } else if (i5 != 64) {
                    break;
                }
            } else if (i5 != 64) {
                break;
            }
        }
        i4 = -1;
        if (i4 != -1) {
            String strZ = z();
            String strSubstring = strZ.substring(0, i4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strK = StringsKt.K(StringsKt.K(StringsKt.K(strSubstring, "\\", "\\\\"), StringUtils.LF, "\\n"), StringUtils.CR, "\\r");
            if (i4 >= strZ.length()) {
                return e.l(']', "[text=", strK);
            }
            return "[size=" + bArr.length + " text=" + strK + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + e() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        int iC = SegmentedByteString.c(this, 64);
        if (iC > bArr.length) {
            throw new IllegalArgumentException(b.n(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (iC < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        sb.append((iC == bArr.length ? this : new ByteString(ArraysKt.o(0, bArr, iC))).e());
        sb.append("…]");
        return sb.toString();
    }

    public ByteString x() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f56925a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b3 = bArrCopyOf[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArrCopyOf[i3] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i2++;
        }
    }

    public byte[] y() {
        byte[] bArr = this.f56925a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final String z() {
        String str = this.f56927c;
        if (str != null) {
            return str;
        }
        byte[] bArrI = i();
        Intrinsics.checkNotNullParameter(bArrI, "<this>");
        String str2 = new String(bArrI, Charsets.UTF_8);
        this.f56927c = str2;
        return str2;
    }
}
