package okio;

import android.support.v4.media.b;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0124SegmentedByteString extends ByteString {

    /* renamed from: e, reason: collision with root package name */
    public final transient byte[][] f56998e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int[] f56999f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0124SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.f56924d.f56925a);
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.f56998e = segments;
        this.f56999f = directory;
    }

    @Override // okio.ByteString
    public final void A(Buffer buffer, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iA = okio.internal.SegmentedByteString.a(this, 0);
        int i3 = 0;
        while (i3 < i2) {
            int[] iArr = this.f56999f;
            int i4 = iA == 0 ? 0 : iArr[iA - 1];
            int i5 = iArr[iA] - i4;
            byte[][] bArr = this.f56998e;
            int i6 = iArr[bArr.length + iA];
            int iMin = Math.min(i2, i5 + i4) - i3;
            int i7 = (i3 - i4) + i6;
            Segment segment = new Segment(bArr[iA], i7, i7 + iMin, true, false);
            Segment segment2 = buffer.f56913a;
            if (segment2 == null) {
                segment.f56994g = segment;
                segment.f56993f = segment;
                buffer.f56913a = segment;
            } else {
                Segment segment3 = segment2.f56994g;
                Intrinsics.c(segment3);
                segment3.b(segment);
            }
            i3 += iMin;
            iA++;
        }
        buffer.f56914b += i2;
    }

    public final ByteString B() {
        return new ByteString(y());
    }

    @Override // okio.ByteString
    public final String a() {
        return Base64.b(B().f56925a);
    }

    @Override // okio.ByteString
    public final ByteString c(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[][] bArr = this.f56998e;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f56999f;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            messageDigest.update(bArr[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public final int d() {
        return this.f56999f[this.f56998e.length - 1];
    }

    @Override // okio.ByteString
    public final String e() {
        return B().e();
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.d() == d() && r(0, byteString, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final int g(int i2, byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return B().g(i2, other);
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i2 = this.f56926b;
        if (i2 != 0) {
            return i2;
        }
        byte[][] bArr = this.f56998e;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            int[] iArr = this.f56999f;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            byte[] bArr2 = bArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr2[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.f56926b = i4;
        return i4;
    }

    @Override // okio.ByteString
    public final byte[] i() {
        return y();
    }

    @Override // okio.ByteString
    public final byte l(int i2) {
        byte[][] bArr = this.f56998e;
        int length = bArr.length - 1;
        int[] iArr = this.f56999f;
        SegmentedByteString.b(iArr[length], i2, 1L);
        int iA = okio.internal.SegmentedByteString.a(this, i2);
        return bArr[iA][(i2 - (iA == 0 ? 0 : iArr[iA - 1])) + iArr[bArr.length + iA]];
    }

    @Override // okio.ByteString
    public final int n(int i2, byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return B().n(i2, other);
    }

    @Override // okio.ByteString
    public final boolean q(int i2, int i3, byte[] other, int i4) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0 || i2 > d() - i4 || i3 < 0 || i3 > other.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iA = okio.internal.SegmentedByteString.a(this, i2);
        while (i2 < i5) {
            int[] iArr = this.f56999f;
            int i6 = iA == 0 ? 0 : iArr[iA - 1];
            int i7 = iArr[iA] - i6;
            byte[][] bArr = this.f56998e;
            int i8 = iArr[bArr.length + iA];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!SegmentedByteString.a(bArr[iA], (i2 - i6) + i8, i3, other, iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iA++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final boolean r(int i2, ByteString other, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 >= 0 && i2 <= d() - i3) {
            int i4 = i3 + i2;
            int iA = okio.internal.SegmentedByteString.a(this, i2);
            int i5 = 0;
            while (i2 < i4) {
                int[] iArr = this.f56999f;
                int i6 = iA == 0 ? 0 : iArr[iA - 1];
                int i7 = iArr[iA] - i6;
                byte[][] bArr = this.f56998e;
                int i8 = iArr[bArr.length + iA];
                int iMin = Math.min(i4, i7 + i6) - i2;
                if (other.q(i5, (i2 - i6) + i8, bArr[iA], iMin)) {
                    i5 += iMin;
                    i2 += iMin;
                    iA++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.ByteString
    public final String s(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return B().s(charset);
    }

    @Override // okio.ByteString
    public final ByteString t(int i2, int i3) {
        int iC = SegmentedByteString.c(this, i3);
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "beginIndex=", " < 0").toString());
        }
        if (iC > d()) {
            StringBuilder sbU = b.u(iC, "endIndex=", " > length(");
            sbU.append(d());
            sbU.append(')');
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        int i4 = iC - i2;
        if (i4 < 0) {
            throw new IllegalArgumentException(b.d(iC, i2, "endIndex=", " < beginIndex=").toString());
        }
        if (i2 == 0 && iC == d()) {
            return this;
        }
        if (i2 == iC) {
            return ByteString.f56924d;
        }
        int iA = okio.internal.SegmentedByteString.a(this, i2);
        int iA2 = okio.internal.SegmentedByteString.a(this, iC - 1);
        byte[][] bArr = this.f56998e;
        byte[][] bArr2 = (byte[][]) ArraysKt.p(bArr, iA, iA2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f56999f;
        if (iA <= iA2) {
            int i5 = iA;
            int i6 = 0;
            while (true) {
                iArr[i6] = Math.min(iArr2[i5] - i2, i4);
                int i7 = i6 + 1;
                iArr[i6 + bArr2.length] = iArr2[bArr.length + i5];
                if (i5 == iA2) {
                    break;
                }
                i5++;
                i6 = i7;
            }
        }
        int i8 = iA != 0 ? iArr2[iA - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i2 - i8) + iArr[length];
        return new C0124SegmentedByteString(bArr2, iArr);
    }

    @Override // okio.ByteString
    public final String toString() {
        return B().toString();
    }

    @Override // okio.ByteString
    public final ByteString x() {
        return B().x();
    }

    @Override // okio.ByteString
    public final byte[] y() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.f56998e;
        int length = bArr2.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.f56999f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = i6 - i3;
            ArraysKt.l(bArr2[i2], i4, i5, bArr, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }
}
