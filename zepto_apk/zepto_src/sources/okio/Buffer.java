package okio;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public Segment f56913a;

    /* renamed from: b, reason: collision with root package name */
    public long f56914b;

    @Metadata
    @SourceDebugExtension
    public static final class UnsafeCursor implements Closeable, AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public Buffer f56915a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56916b;

        /* renamed from: c, reason: collision with root package name */
        public Segment f56917c;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f56919e;

        /* renamed from: d, reason: collision with root package name */
        public long f56918d = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f56920f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f56921g = -1;

        public final void a(long j2) {
            Buffer buffer = this.f56915a;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f56916b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j3 = buffer.f56914b;
            if (j2 <= j3) {
                if (j2 < 0) {
                    throw new IllegalArgumentException(b.i(j2, "newSize < 0: ").toString());
                }
                long j4 = j3 - j2;
                while (true) {
                    if (j4 <= 0) {
                        break;
                    }
                    Segment segment = buffer.f56913a;
                    Intrinsics.c(segment);
                    Segment segment2 = segment.f56994g;
                    Intrinsics.c(segment2);
                    int i2 = segment2.f56990c;
                    long j5 = i2 - segment2.f56989b;
                    if (j5 > j4) {
                        segment2.f56990c = i2 - ((int) j4);
                        break;
                    } else {
                        buffer.f56913a = segment2.a();
                        SegmentPool.a(segment2);
                        j4 -= j5;
                    }
                }
                this.f56917c = null;
                this.f56918d = j2;
                this.f56919e = null;
                this.f56920f = -1;
                this.f56921g = -1;
            } else if (j2 > j3) {
                long j6 = j2 - j3;
                int i3 = 1;
                boolean z = true;
                for (long j7 = 0; j6 > j7; j7 = 0) {
                    Segment segmentO1 = buffer.o1(i3);
                    int iMin = (int) Math.min(j6, 8192 - segmentO1.f56990c);
                    int i4 = segmentO1.f56990c + iMin;
                    segmentO1.f56990c = i4;
                    j6 -= iMin;
                    if (z) {
                        this.f56917c = segmentO1;
                        this.f56918d = j3;
                        this.f56919e = segmentO1.f56988a;
                        this.f56920f = i4 - iMin;
                        this.f56921g = i4;
                        z = false;
                    }
                    i3 = 1;
                }
            }
            buffer.f56914b = j2;
        }

        public final int b(long j2) {
            Buffer buffer = this.f56915a;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j2 >= -1) {
                long j3 = buffer.f56914b;
                if (j2 <= j3) {
                    if (j2 == -1 || j2 == j3) {
                        this.f56917c = null;
                        this.f56918d = j2;
                        this.f56919e = null;
                        this.f56920f = -1;
                        this.f56921g = -1;
                        return -1;
                    }
                    Segment segment = buffer.f56913a;
                    Segment segment2 = this.f56917c;
                    long j4 = 0;
                    if (segment2 != null) {
                        long j5 = this.f56918d - (this.f56920f - segment2.f56989b);
                        if (j5 > j2) {
                            segment2 = segment;
                            segment = segment2;
                            j3 = j5;
                        } else {
                            j4 = j5;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j3 - j2 > j2 - j4) {
                        while (true) {
                            Intrinsics.c(segment2);
                            long j6 = (segment2.f56990c - segment2.f56989b) + j4;
                            if (j2 < j6) {
                                break;
                            }
                            segment2 = segment2.f56993f;
                            j4 = j6;
                        }
                    } else {
                        while (j3 > j2) {
                            Intrinsics.c(segment);
                            segment = segment.f56994g;
                            Intrinsics.c(segment);
                            j3 -= segment.f56990c - segment.f56989b;
                        }
                        segment2 = segment;
                        j4 = j3;
                    }
                    if (this.f56916b) {
                        Intrinsics.c(segment2);
                        if (segment2.f56991d) {
                            byte[] bArr = segment2.f56988a;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                            Segment segment3 = new Segment(bArrCopyOf, segment2.f56989b, segment2.f56990c, false, true);
                            if (buffer.f56913a == segment2) {
                                buffer.f56913a = segment3;
                            }
                            segment2.b(segment3);
                            Segment segment4 = segment3.f56994g;
                            Intrinsics.c(segment4);
                            segment4.a();
                            segment2 = segment3;
                        }
                    }
                    this.f56917c = segment2;
                    this.f56918d = j2;
                    Intrinsics.c(segment2);
                    this.f56919e = segment2.f56988a;
                    int i2 = segment2.f56989b + ((int) (j2 - j4));
                    this.f56920f = i2;
                    int i3 = segment2.f56990c;
                    this.f56921g = i3;
                    return i3 - i2;
                }
            }
            StringBuilder sbV = b.v(j2, "offset=", " > size=");
            sbV.append(buffer.f56914b);
            throw new ArrayIndexOutOfBoundsException(sbV.toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56915a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f56915a = null;
            this.f56917c = null;
            this.f56918d = -1L;
            this.f56919e = null;
            this.f56920f = -1;
            this.f56921g = -1;
        }
    }

    public final long A(byte b2, long j2, long j3) {
        Segment segment;
        long j4 = 0;
        if (0 > j2 || j2 > j3) {
            StringBuilder sb = new StringBuilder("size=");
            sb.append(this.f56914b);
            e.A(sb, " fromIndex=", j2, " toIndex=");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        long j5 = this.f56914b;
        if (j3 > j5) {
            j3 = j5;
        }
        if (j2 == j3 || (segment = this.f56913a) == null) {
            return -1L;
        }
        if (j5 - j2 < j2) {
            while (j5 > j2) {
                segment = segment.f56994g;
                Intrinsics.c(segment);
                j5 -= segment.f56990c - segment.f56989b;
            }
            while (j5 < j3) {
                int iMin = (int) Math.min(segment.f56990c, (segment.f56989b + j3) - j5);
                for (int i2 = (int) ((segment.f56989b + j2) - j5); i2 < iMin; i2++) {
                    if (segment.f56988a[i2] == b2) {
                        return (i2 - segment.f56989b) + j5;
                    }
                }
                j5 += segment.f56990c - segment.f56989b;
                segment = segment.f56993f;
                Intrinsics.c(segment);
                j2 = j5;
            }
            return -1L;
        }
        while (true) {
            long j6 = (segment.f56990c - segment.f56989b) + j4;
            if (j6 > j2) {
                break;
            }
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j4 = j6;
        }
        while (j4 < j3) {
            int iMin2 = (int) Math.min(segment.f56990c, (segment.f56989b + j3) - j4);
            for (int i3 = (int) ((segment.f56989b + j2) - j4); i3 < iMin2; i3++) {
                if (segment.f56988a[i3] == b2) {
                    return (i3 - segment.f56989b) + j4;
                }
            }
            j4 += segment.f56990c - segment.f56989b;
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j2 = j4;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public final String A1() {
        return T0(this.f56914b, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public final Buffer B() {
        return this;
    }

    public final long D(long j2, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (bytes.f56925a.length <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "fromIndex < 0: ").toString());
        }
        Segment segment = this.f56913a;
        if (segment == null) {
            return -1L;
        }
        long j4 = this.f56914b;
        long j5 = j4 - j2;
        byte[] bArr = bytes.f56925a;
        if (j5 < j2) {
            while (j4 > j2) {
                segment = segment.f56994g;
                Intrinsics.c(segment);
                j4 -= segment.f56990c - segment.f56989b;
            }
            byte b2 = bArr[0];
            int length = bArr.length;
            long j6 = (this.f56914b - length) + 1;
            while (j4 < j6) {
                int iMin = (int) Math.min(segment.f56990c, (segment.f56989b + j6) - j4);
                for (int i2 = (int) ((segment.f56989b + j2) - j4); i2 < iMin; i2++) {
                    if (segment.f56988a[i2] == b2 && okio.internal.Buffer.a(segment, i2 + 1, bArr, length)) {
                        return (i2 - segment.f56989b) + j4;
                    }
                }
                j4 += segment.f56990c - segment.f56989b;
                segment = segment.f56993f;
                Intrinsics.c(segment);
                j2 = j4;
            }
            return -1L;
        }
        while (true) {
            long j7 = (segment.f56990c - segment.f56989b) + j3;
            if (j7 > j2) {
                break;
            }
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j3 = j7;
        }
        byte b3 = bArr[0];
        int length2 = bArr.length;
        long j8 = (this.f56914b - length2) + 1;
        while (j3 < j8) {
            int iMin2 = (int) Math.min(segment.f56990c, (segment.f56989b + j8) - j3);
            for (int i3 = (int) ((segment.f56989b + j2) - j3); i3 < iMin2; i3++) {
                if (segment.f56988a[i3] == b3 && okio.internal.Buffer.a(segment, i3 + 1, bArr, length2)) {
                    return (i3 - segment.f56989b) + j3;
                }
            }
            j3 += segment.f56990c - segment.f56989b;
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j2 = j3;
        }
        return -1L;
    }

    public final short D0() throws EOFException {
        short sZ0 = z0();
        UnsafeCursor unsafeCursor = SegmentedByteString.f56899a;
        return (short) (((sZ0 & 255) << 8) | ((65280 & sZ0) >>> 8));
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink D1(ByteString byteString) {
        s1(byteString);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink E0(long j2) {
        S1(j2);
        return this;
    }

    @Override // okio.BufferedSource
    public final long F1(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j2 = this.f56914b;
        if (j2 > 0) {
            sink.write(this, j2);
        }
        return j2;
    }

    public final void J1(byte[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j2 = i3;
        SegmentedByteString.b(source.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment segmentO1 = o1(1);
            int iMin = Math.min(i4 - i2, 8192 - segmentO1.f56990c);
            int i5 = i2 + iMin;
            ArraysKt.l(source, segmentO1.f56990c, i2, segmentO1.f56988a, i5);
            segmentO1.f56990c += iMin;
            i2 = i5;
        }
        this.f56914b += j2;
    }

    public final long O(long j2, ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "fromIndex < 0: ").toString());
        }
        Segment segment = this.f56913a;
        if (segment == null) {
            return -1L;
        }
        long j4 = this.f56914b;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                segment = segment.f56994g;
                Intrinsics.c(segment);
                j4 -= segment.f56990c - segment.f56989b;
            }
            byte[] bArr = targetBytes.f56925a;
            if (bArr.length == 2) {
                byte b2 = bArr[0];
                byte b3 = bArr[1];
                while (j4 < this.f56914b) {
                    int i2 = segment.f56990c;
                    for (int i3 = (int) ((segment.f56989b + j2) - j4); i3 < i2; i3++) {
                        byte b4 = segment.f56988a[i3];
                        if (b4 == b2 || b4 == b3) {
                            return (i3 - segment.f56989b) + j4;
                        }
                    }
                    j4 += segment.f56990c - segment.f56989b;
                    segment = segment.f56993f;
                    Intrinsics.c(segment);
                    j2 = j4;
                }
                return -1L;
            }
            while (j4 < this.f56914b) {
                int i4 = segment.f56990c;
                for (int i5 = (int) ((segment.f56989b + j2) - j4); i5 < i4; i5++) {
                    byte b5 = segment.f56988a[i5];
                    for (byte b6 : bArr) {
                        if (b5 == b6) {
                            return (i5 - segment.f56989b) + j4;
                        }
                    }
                }
                j4 += segment.f56990c - segment.f56989b;
                segment = segment.f56993f;
                Intrinsics.c(segment);
                j2 = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = (segment.f56990c - segment.f56989b) + j3;
            if (j5 > j2) {
                break;
            }
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j3 = j5;
        }
        byte[] bArr2 = targetBytes.f56925a;
        if (bArr2.length == 2) {
            byte b7 = bArr2[0];
            byte b8 = bArr2[1];
            while (j3 < this.f56914b) {
                int i6 = segment.f56990c;
                for (int i7 = (int) ((segment.f56989b + j2) - j3); i7 < i6; i7++) {
                    byte b9 = segment.f56988a[i7];
                    if (b9 == b7 || b9 == b8) {
                        return (i7 - segment.f56989b) + j3;
                    }
                }
                j3 += segment.f56990c - segment.f56989b;
                segment = segment.f56993f;
                Intrinsics.c(segment);
                j2 = j3;
            }
            return -1L;
        }
        while (j3 < this.f56914b) {
            int i8 = segment.f56990c;
            for (int i9 = (int) ((segment.f56989b + j2) - j3); i9 < i8; i9++) {
                byte b10 = segment.f56988a[i9];
                for (byte b11 : bArr2) {
                    if (b10 == b11) {
                        return (i9 - segment.f56989b) + j3;
                    }
                }
            }
            j3 += segment.f56990c - segment.f56989b;
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j2 = j3;
        }
        return -1L;
    }

    public final void O1(int i2) {
        Segment segmentO1 = o1(1);
        int i3 = segmentO1.f56990c;
        segmentO1.f56990c = i3 + 1;
        segmentO1.f56988a[i3] = (byte) i2;
        this.f56914b++;
    }

    @Override // okio.BufferedSink
    public final OutputStream P1() {
        return new Buffer$outputStream$1(this);
    }

    @Override // okio.BufferedSource
    public final InputStream Q1() {
        return new Buffer$inputStream$1(this);
    }

    @Override // okio.BufferedSource
    public final int R1(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int iC = okio.internal.Buffer.c(this, options, false);
        if (iC == -1) {
            return -1;
        }
        j1(options.f56968b[iC].d());
        return iC;
    }

    public final void S1(long j2) {
        boolean z;
        byte[] bArr;
        if (j2 == 0) {
            O1(48);
            return;
        }
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                X1("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment segmentO1 = o1(i2);
        int i3 = segmentO1.f56990c + i2;
        while (true) {
            bArr = segmentO1.f56988a;
            if (j2 == 0) {
                break;
            }
            long j3 = 10;
            i3--;
            bArr[i3] = okio.internal.Buffer.f57009a[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        segmentO1.f56990c += i2;
        this.f56914b += i2;
    }

    public final long T(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return O(0L, targetBytes);
    }

    public final String T0(long j2, Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j2 < 0 || j2 > TTL.MAX_VALUE) {
            throw new IllegalArgumentException(b.i(j2, "byteCount: ").toString());
        }
        if (this.f56914b < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        int i2 = segment.f56989b;
        if (i2 + j2 > segment.f56990c) {
            return new String(r0(j2), charset);
        }
        int i3 = (int) j2;
        String str = new String(segment.f56988a, i2, i3, charset);
        int i4 = segment.f56989b + i3;
        segment.f56989b = i4;
        this.f56914b -= j2;
        if (i4 == segment.f56990c) {
            this.f56913a = segment.a();
            SegmentPool.a(segment);
        }
        return str;
    }

    public final void T1(long j2) {
        if (j2 == 0) {
            O1(48);
            return;
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        Segment segmentO1 = o1(i2);
        int i3 = segmentO1.f56990c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            segmentO1.f56988a[i4] = okio.internal.Buffer.f57009a[(int) (15 & j2)];
            j2 >>>= 4;
        }
        segmentO1.f56990c += i2;
        this.f56914b += i2;
    }

    @Override // okio.BufferedSource
    public final byte[] U0() {
        return r0(this.f56914b);
    }

    public final void U1(int i2) {
        Segment segmentO1 = o1(4);
        int i3 = segmentO1.f56990c;
        byte[] bArr = segmentO1.f56988a;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        segmentO1.f56990c = i3 + 4;
        this.f56914b += 4;
    }

    public final boolean V(long j2, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int length = bytes.f56925a.length;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (j2 >= 0 && length >= 0 && this.f56914b - j2 >= length) {
            byte[] bArr = bytes.f56925a;
            if (bArr.length >= length) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (x(i2 + j2) == bArr[i2]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void V1(int i2) {
        Segment segmentO1 = o1(2);
        int i3 = segmentO1.f56990c;
        byte[] bArr = segmentO1.f56988a;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        segmentO1.f56990c = i3 + 2;
        this.f56914b += 2;
    }

    public final void W1(int i2, int i3, String string) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "beginIndex < 0: ").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(b.d(i3, i2, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i3 > string.length()) {
            StringBuilder sbU = b.u(i3, "endIndex > string.length: ", " > ");
            sbU.append(string.length());
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        while (i2 < i3) {
            char cCharAt2 = string.charAt(i2);
            if (cCharAt2 < 128) {
                Segment segmentO1 = o1(1);
                int i4 = segmentO1.f56990c - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                byte[] bArr = segmentO1.f56988a;
                bArr[i2 + i4] = (byte) cCharAt2;
                while (true) {
                    i2 = i5;
                    if (i2 >= iMin || (cCharAt = string.charAt(i2)) >= 128) {
                        break;
                    }
                    i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                }
                int i6 = segmentO1.f56990c;
                int i7 = (i4 + i2) - i6;
                segmentO1.f56990c = i6 + i7;
                this.f56914b += i7;
            } else {
                if (cCharAt2 < 2048) {
                    Segment segmentO12 = o1(2);
                    int i8 = segmentO12.f56990c;
                    byte[] bArr2 = segmentO12.f56988a;
                    bArr2[i8] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segmentO12.f56990c = i8 + 2;
                    this.f56914b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment segmentO13 = o1(3);
                    int i9 = segmentO13.f56990c;
                    byte[] bArr3 = segmentO13.f56988a;
                    bArr3[i9] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segmentO13.f56990c = i9 + 3;
                    this.f56914b += 3;
                } else {
                    int i10 = i2 + 1;
                    char cCharAt3 = i10 < i3 ? string.charAt(i10) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        O1(63);
                        i2 = i10;
                    } else {
                        int i11 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentO14 = o1(4);
                        int i12 = segmentO14.f56990c;
                        byte[] bArr4 = segmentO14.f56988a;
                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        segmentO14.f56990c = i12 + 4;
                        this.f56914b += 4;
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }

    public final void X1(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        W1(0, string.length(), string);
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink Y(String str) {
        X1(str);
        return this;
    }

    public final void Y1(int i2) {
        if (i2 < 128) {
            O1(i2);
            return;
        }
        if (i2 < 2048) {
            Segment segmentO1 = o1(2);
            int i3 = segmentO1.f56990c;
            byte[] bArr = segmentO1.f56988a;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            segmentO1.f56990c = i3 + 2;
            this.f56914b += 2;
            return;
        }
        if (55296 <= i2 && i2 < 57344) {
            O1(63);
            return;
        }
        if (i2 < 65536) {
            Segment segmentO12 = o1(3);
            int i4 = segmentO12.f56990c;
            byte[] bArr2 = segmentO12.f56988a;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            segmentO12.f56990c = i4 + 3;
            this.f56914b += 3;
            return;
        }
        if (i2 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(SegmentedByteString.e(i2)));
        }
        Segment segmentO13 = o1(4);
        int i5 = segmentO13.f56990c;
        byte[] bArr3 = segmentO13.f56988a;
        bArr3[i5] = (byte) ((i2 >> 18) | 240);
        bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
        bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
        bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
        segmentO13.f56990c = i5 + 4;
        this.f56914b += 4;
    }

    public final void a() {
        j1(this.f56914b);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f56914b == 0) {
            return buffer;
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        Segment segmentC = segment.c();
        buffer.f56913a = segmentC;
        segmentC.f56994g = segmentC;
        segmentC.f56993f = segmentC;
        for (Segment segment2 = segment.f56993f; segment2 != segment; segment2 = segment2.f56993f) {
            Segment segment3 = segmentC.f56994g;
            Intrinsics.c(segment3);
            Intrinsics.c(segment2);
            segment3.b(segment2.c());
        }
        buffer.f56914b = this.f56914b;
        return buffer;
    }

    public final long c() {
        long j2 = this.f56914b;
        if (j2 == 0) {
            return 0L;
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        Segment segment2 = segment.f56994g;
        Intrinsics.c(segment2);
        return (segment2.f56990c >= 8192 || !segment2.f56992e) ? j2 : j2 - (r3 - segment2.f56989b);
    }

    public final int c1() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (this.f56914b == 0) {
            throw new EOFException();
        }
        byte bX = x(0L);
        if ((bX & 128) == 0) {
            i2 = bX & 127;
            i4 = 0;
            i3 = 1;
        } else if ((bX & 224) == 192) {
            i2 = bX & 31;
            i3 = 2;
            i4 = 128;
        } else if ((bX & 240) == 224) {
            i2 = bX & 15;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((bX & 248) != 240) {
                j1(1L);
                return 65533;
            }
            i2 = bX & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j2 = i3;
        if (this.f56914b < j2) {
            StringBuilder sbU = b.u(i3, "size < ", ": ");
            sbU.append(this.f56914b);
            sbU.append(" (to read code point prefixed 0x");
            sbU.append(SegmentedByteString.d(bX));
            sbU.append(')');
            throw new EOFException(sbU.toString());
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j3 = i5;
            byte bX2 = x(j3);
            if ((bX2 & 192) != 128) {
                j1(j3);
                return 65533;
            }
            i2 = (i2 << 6) | (bX2 & 63);
        }
        j1(j2);
        if (i2 > 1114111) {
            return 65533;
        }
        if ((55296 > i2 || i2 >= 57344) && i2 >= i4) {
            return i2;
        }
        return 65533;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
    }

    public final void e(Buffer out, long j2, long j3) {
        Intrinsics.checkNotNullParameter(out, "out");
        long j4 = j2;
        SegmentedByteString.b(this.f56914b, j4, j3);
        if (j3 == 0) {
            return;
        }
        out.f56914b += j3;
        Segment segment = this.f56913a;
        while (true) {
            Intrinsics.c(segment);
            long j5 = segment.f56990c - segment.f56989b;
            if (j4 < j5) {
                break;
            }
            j4 -= j5;
            segment = segment.f56993f;
        }
        Segment segment2 = segment;
        long j6 = j3;
        while (j6 > 0) {
            Intrinsics.c(segment2);
            Segment segmentC = segment2.c();
            int i2 = segmentC.f56989b + ((int) j4);
            segmentC.f56989b = i2;
            segmentC.f56990c = Math.min(i2 + ((int) j6), segmentC.f56990c);
            Segment segment3 = out.f56913a;
            if (segment3 == null) {
                segmentC.f56994g = segmentC;
                segmentC.f56993f = segmentC;
                out.f56913a = segmentC;
            } else {
                Segment segment4 = segment3.f56994g;
                Intrinsics.c(segment4);
                segment4.b(segmentC);
            }
            j6 -= segmentC.f56990c - segmentC.f56989b;
            segment2 = segment2.f56993f;
            j4 = 0;
        }
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        boolean z2 = false;
        if (!(obj instanceof Buffer)) {
            return false;
        }
        long j2 = this.f56914b;
        Buffer buffer = (Buffer) obj;
        if (j2 != buffer.f56914b) {
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        Segment segment2 = buffer.f56913a;
        Intrinsics.c(segment2);
        int i2 = segment.f56989b;
        int i3 = segment2.f56989b;
        long j3 = 0;
        while (j3 < this.f56914b) {
            long jMin = Math.min(segment.f56990c - i2, segment2.f56990c - i3);
            long j4 = 0;
            while (j4 < jMin) {
                int i4 = i2 + 1;
                boolean z3 = z;
                byte b2 = segment.f56988a[i2];
                int i5 = i3 + 1;
                boolean z4 = z2;
                if (b2 != segment2.f56988a[i3]) {
                    return z4;
                }
                j4++;
                i3 = i5;
                i2 = i4;
                z = z3;
                z2 = z4;
            }
            boolean z5 = z;
            boolean z6 = z2;
            if (i2 == segment.f56990c) {
                Segment segment3 = segment.f56993f;
                Intrinsics.c(segment3);
                i2 = segment3.f56989b;
                segment = segment3;
            }
            if (i3 == segment2.f56990c) {
                segment2 = segment2.f56993f;
                Intrinsics.c(segment2);
                i3 = segment2.f56989b;
            }
            j3 += jMin;
            z = z5;
            z2 = z6;
        }
        return z;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer g() {
        return this;
    }

    @Override // okio.BufferedSink
    public final long g0(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(this, 8192L);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
        }
    }

    @Override // okio.BufferedSource
    public final boolean h0(long j2) {
        return this.f56914b >= j2;
    }

    public final int hashCode() {
        Segment segment = this.f56913a;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.f56990c;
            for (int i4 = segment.f56989b; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.f56988a[i4];
            }
            segment = segment.f56993f;
            Intrinsics.c(segment);
        } while (segment != this.f56913a);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final UnsafeCursor j0(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        byte[] bArr = okio.internal.Buffer.f57009a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        UnsafeCursor unsafeCursor2 = SegmentedByteString.f56899a;
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor == SegmentedByteString.f56899a) {
            unsafeCursor = new UnsafeCursor();
        }
        if (unsafeCursor.f56915a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.f56915a = this;
        unsafeCursor.f56916b = true;
        return unsafeCursor;
    }

    public final void j1(long j2) {
        while (j2 > 0) {
            Segment segment = this.f56913a;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, segment.f56990c - segment.f56989b);
            long j3 = iMin;
            this.f56914b -= j3;
            j2 -= j3;
            int i2 = segment.f56989b + iMin;
            segment.f56989b = i2;
            if (i2 == segment.f56990c) {
                this.f56913a = segment.a();
                SegmentPool.a(segment);
            }
        }
    }

    public final byte k0() {
        if (this.f56914b == 0) {
            throw new EOFException();
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        int i2 = segment.f56989b;
        int i3 = segment.f56990c;
        int i4 = i2 + 1;
        byte b2 = segment.f56988a[i2];
        this.f56914b--;
        if (i4 != i3) {
            segment.f56989b = i4;
            return b2;
        }
        this.f56913a = segment.a();
        SegmentPool.a(segment);
        return b2;
    }

    public final boolean l() {
        return this.f56914b == 0;
    }

    public final ByteString l1(int i2) {
        if (i2 == 0) {
            return ByteString.f56924d;
        }
        SegmentedByteString.b(this.f56914b, 0L, i2);
        Segment segment = this.f56913a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Intrinsics.c(segment);
            int i6 = segment.f56990c;
            int i7 = segment.f56989b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            segment = segment.f56993f;
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        Segment segment2 = this.f56913a;
        int i8 = 0;
        while (i3 < i2) {
            Intrinsics.c(segment2);
            bArr[i8] = segment2.f56988a;
            i3 += segment2.f56990c - segment2.f56989b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = segment2.f56989b;
            segment2.f56991d = true;
            i8++;
            segment2 = segment2.f56993f;
        }
        return new C0124SegmentedByteString(bArr, iArr);
    }

    public final Segment o1(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.f56913a;
        if (segment == null) {
            Segment segmentB = SegmentPool.b();
            this.f56913a = segmentB;
            segmentB.f56994g = segmentB;
            segmentB.f56993f = segmentB;
            return segmentB;
        }
        Segment segment2 = segment.f56994g;
        Intrinsics.c(segment2);
        if (segment2.f56990c + i2 <= 8192 && segment2.f56992e) {
            return segment2;
        }
        Segment segmentB2 = SegmentPool.b();
        segment2.b(segmentB2);
        return segmentB2;
    }

    @Override // okio.BufferedSource
    public final String p0() throws EOFException {
        if (Long.MAX_VALUE < 0) {
            throw new IllegalArgumentException(b.i(Long.MAX_VALUE, "limit < 0: ").toString());
        }
        long j2 = Long.MAX_VALUE != Long.MAX_VALUE ? Long.MAX_VALUE + 1 : Long.MAX_VALUE;
        long jA = A((byte) 10, 0L, j2);
        if (jA != -1) {
            return okio.internal.Buffer.b(this, jA);
        }
        if (j2 < this.f56914b && x(j2 - 1) == 13 && x(j2) == 10) {
            return okio.internal.Buffer.b(this, j2);
        }
        Buffer buffer = new Buffer();
        e(buffer, 0L, Math.min(32, this.f56914b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f56914b, Long.MAX_VALUE) + " content=" + buffer.s0(buffer.f56914b).e() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public final String p1(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return T0(this.f56914b, charset);
    }

    @Override // okio.BufferedSource
    public final RealBufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    public final byte[] r0(long j2) throws EOFException {
        if (j2 < 0 || j2 > TTL.MAX_VALUE) {
            throw new IllegalArgumentException(b.i(j2, "byteCount: ").toString());
        }
        if (this.f56914b < j2) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j2];
        t0(bArr);
        return bArr;
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
        }
        long j3 = this.f56914b;
        if (j3 == 0) {
            return -1L;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        sink.write(this, j2);
        return j2;
    }

    public final ByteString s0(long j2) throws EOFException {
        if (j2 < 0 || j2 > TTL.MAX_VALUE) {
            throw new IllegalArgumentException(b.i(j2, "byteCount: ").toString());
        }
        if (this.f56914b < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new ByteString(r0(j2));
        }
        ByteString byteStringL1 = l1((int) j2);
        j1(j2);
        return byteStringL1;
    }

    public final void s1(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.A(this, byteString.d());
    }

    public final void t0(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i2 = 0;
        while (i2 < sink.length) {
            int i3 = read(sink, i2, sink.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.f57001d;
    }

    public final String toString() {
        long j2 = this.f56914b;
        if (j2 <= TTL.MAX_VALUE) {
            return l1((int) j2).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f56914b).toString());
    }

    public final int u0() throws EOFException {
        if (this.f56914b < 4) {
            throw new EOFException();
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        int i2 = segment.f56989b;
        int i3 = segment.f56990c;
        if (i3 - i2 < 4) {
            return ((k0() & 255) << 24) | ((k0() & 255) << 16) | ((k0() & 255) << 8) | (k0() & 255);
        }
        byte[] bArr = segment.f56988a;
        int i4 = i2 + 3;
        int i5 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i6 = i2 + 4;
        int i7 = i5 | (bArr[i4] & 255);
        this.f56914b -= 4;
        if (i6 != i3) {
            segment.f56989b = i6;
            return i7;
        }
        this.f56913a = segment.a();
        SegmentPool.a(segment);
        return i7;
    }

    public final long v0() throws EOFException {
        if (this.f56914b < 8) {
            throw new EOFException();
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        int i2 = segment.f56989b;
        int i3 = segment.f56990c;
        if (i3 - i2 < 8) {
            return ((u0() & 4294967295L) << 32) | (4294967295L & u0());
        }
        byte[] bArr = segment.f56988a;
        int i4 = i2 + 7;
        long j2 = ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
        int i5 = i2 + 8;
        long j3 = j2 | (bArr[i4] & 255);
        this.f56914b -= 8;
        if (i5 != i3) {
            segment.f56989b = i5;
            return j3;
        }
        this.f56913a = segment.a();
        SegmentPool.a(segment);
        return j3;
    }

    public final void w1(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        J1(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr) {
        w1(bArr);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeByte(int i2) {
        O1(i2);
        return this;
    }

    public final byte x(long j2) {
        SegmentedByteString.b(this.f56914b, j2, 1L);
        Segment segment = this.f56913a;
        if (segment == null) {
            Intrinsics.c(null);
            throw null;
        }
        long j3 = this.f56914b;
        if (j3 - j2 < j2) {
            while (j3 > j2) {
                segment = segment.f56994g;
                Intrinsics.c(segment);
                j3 -= segment.f56990c - segment.f56989b;
            }
            return segment.f56988a[(int) ((segment.f56989b + j2) - j3)];
        }
        long j4 = 0;
        while (true) {
            int i2 = segment.f56990c;
            int i3 = segment.f56989b;
            long j5 = (i2 - i3) + j4;
            if (j5 > j2) {
                return segment.f56988a[(int) ((i3 + j2) - j4)];
            }
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j4 = j5;
        }
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink x0(int i2, byte[] bArr, int i3) {
        J1(bArr, i2, i3);
        return this;
    }

    public final short z0() throws EOFException {
        if (this.f56914b < 2) {
            throw new EOFException();
        }
        Segment segment = this.f56913a;
        Intrinsics.c(segment);
        int i2 = segment.f56989b;
        int i3 = segment.f56990c;
        if (i3 - i2 < 2) {
            return (short) (((k0() & 255) << 8) | (k0() & 255));
        }
        int i4 = i2 + 1;
        byte[] bArr = segment.f56988a;
        int i5 = (bArr[i2] & 255) << 8;
        int i6 = i2 + 2;
        int i7 = (bArr[i4] & 255) | i5;
        this.f56914b -= 2;
        if (i6 == i3) {
            this.f56913a = segment.a();
            SegmentPool.a(segment);
        } else {
            segment.f56989b = i6;
        }
        return (short) i7;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) {
        Segment segmentB;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        SegmentedByteString.b(source.f56914b, 0L, j2);
        while (j2 > 0) {
            Segment segment = source.f56913a;
            Intrinsics.c(segment);
            int i2 = segment.f56990c;
            Segment segment2 = source.f56913a;
            Intrinsics.c(segment2);
            long j3 = i2 - segment2.f56989b;
            int i3 = 0;
            if (j2 < j3) {
                Segment segment3 = this.f56913a;
                Segment segment4 = segment3 != null ? segment3.f56994g : null;
                if (segment4 != null && segment4.f56992e) {
                    if ((segment4.f56990c + j2) - (segment4.f56991d ? 0 : segment4.f56989b) <= 8192) {
                        Segment segment5 = source.f56913a;
                        Intrinsics.c(segment5);
                        segment5.d(segment4, (int) j2);
                        source.f56914b -= j2;
                        this.f56914b += j2;
                        return;
                    }
                }
                Segment segment6 = source.f56913a;
                Intrinsics.c(segment6);
                int i4 = (int) j2;
                if (i4 <= 0 || i4 > segment6.f56990c - segment6.f56989b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i4 >= 1024) {
                    segmentB = segment6.c();
                } else {
                    segmentB = SegmentPool.b();
                    int i5 = segment6.f56989b;
                    ArraysKt.l(segment6.f56988a, 0, i5, segmentB.f56988a, i5 + i4);
                }
                segmentB.f56990c = segmentB.f56989b + i4;
                segment6.f56989b += i4;
                Segment segment7 = segment6.f56994g;
                Intrinsics.c(segment7);
                segment7.b(segmentB);
                source.f56913a = segmentB;
            }
            Segment segment8 = source.f56913a;
            Intrinsics.c(segment8);
            long j4 = segment8.f56990c - segment8.f56989b;
            source.f56913a = segment8.a();
            Segment segment9 = this.f56913a;
            if (segment9 == null) {
                this.f56913a = segment8;
                segment8.f56994g = segment8;
                segment8.f56993f = segment8;
            } else {
                Segment segment10 = segment9.f56994g;
                Intrinsics.c(segment10);
                segment10.b(segment8);
                Segment segment11 = segment8.f56994g;
                if (segment11 == segment8) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.c(segment11);
                if (segment11.f56992e) {
                    int i6 = segment8.f56990c - segment8.f56989b;
                    Segment segment12 = segment8.f56994g;
                    Intrinsics.c(segment12);
                    int i7 = 8192 - segment12.f56990c;
                    Segment segment13 = segment8.f56994g;
                    Intrinsics.c(segment13);
                    if (!segment13.f56991d) {
                        Segment segment14 = segment8.f56994g;
                        Intrinsics.c(segment14);
                        i3 = segment14.f56989b;
                    }
                    if (i6 <= i7 + i3) {
                        Segment segment15 = segment8.f56994g;
                        Intrinsics.c(segment15);
                        segment8.d(segment15, i6);
                        segment8.a();
                        SegmentPool.a(segment8);
                    }
                }
            }
            source.f56914b -= j4;
            this.f56914b += j4;
            j2 -= j4;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment segment = this.f56913a;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), segment.f56990c - segment.f56989b);
        sink.put(segment.f56988a, segment.f56989b, iMin);
        int i2 = segment.f56989b + iMin;
        segment.f56989b = i2;
        this.f56914b -= iMin;
        if (i2 == segment.f56990c) {
            this.f56913a = segment.a();
            SegmentPool.a(segment);
        }
        return iMin;
    }

    public final int read(byte[] sink, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.b(sink.length, i2, i3);
        Segment segment = this.f56913a;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i3, segment.f56990c - segment.f56989b);
        int i4 = segment.f56989b;
        ArraysKt.l(segment.f56988a, i2, i4, sink, i4 + iMin);
        int i5 = segment.f56989b + iMin;
        segment.f56989b = i5;
        this.f56914b -= iMin;
        if (i5 == segment.f56990c) {
            this.f56913a = segment.a();
            SegmentPool.a(segment);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            Segment segmentO1 = o1(1);
            int iMin = Math.min(i2, 8192 - segmentO1.f56990c);
            source.get(segmentO1.f56988a, segmentO1.f56990c, iMin);
            i2 -= iMin;
            segmentO1.f56990c += iMin;
        }
        this.f56914b += iRemaining;
        return iRemaining;
    }
}
