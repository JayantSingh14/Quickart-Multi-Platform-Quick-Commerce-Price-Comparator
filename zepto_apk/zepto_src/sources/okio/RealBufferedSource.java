package okio;

import android.support.v4.media.b;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okio.Buffer;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: a, reason: collision with root package name */
    public final Source f56984a;

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f56985b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56986c;

    public RealBufferedSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f56984a = source;
        this.f56985b = new Buffer();
    }

    public final int A() throws EOFException {
        j0(4L);
        return this.f56985b.u0();
    }

    @Override // okio.BufferedSource
    public final String A1() {
        Source source = this.f56984a;
        Buffer buffer = this.f56985b;
        buffer.g0(source);
        return buffer.A1();
    }

    @Override // okio.BufferedSource
    public final Buffer B() {
        return this.f56985b;
    }

    public final int D() throws EOFException {
        j0(4L);
        int iU0 = this.f56985b.u0();
        Buffer.UnsafeCursor unsafeCursor = SegmentedByteString.f56899a;
        return ((iU0 & 255) << 24) | (((-16777216) & iU0) >>> 24) | ((16711680 & iU0) >>> 8) | ((65280 & iU0) << 8);
    }

    @Override // okio.BufferedSource
    public final long F1(Sink sink) {
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j2 = 0;
        while (true) {
            Source source = this.f56984a;
            buffer = this.f56985b;
            if (source.read(buffer, 8192L) == -1) {
                break;
            }
            long jC = buffer.c();
            if (jC > 0) {
                j2 += jC;
                sink.write(buffer, jC);
            }
        }
        long j3 = buffer.f56914b;
        if (j3 <= 0) {
            return j2;
        }
        long j4 = j2 + j3;
        sink.write(buffer, j3);
        return j4;
    }

    public final long N() throws EOFException {
        j0(8L);
        long jV0 = this.f56985b.v0();
        Buffer.UnsafeCursor unsafeCursor = SegmentedByteString.f56899a;
        return ((jV0 & 255) << 56) | (((-72057594037927936L) & jV0) >>> 56) | ((71776119061217280L & jV0) >>> 40) | ((280375465082880L & jV0) >>> 24) | ((1095216660480L & jV0) >>> 8) | ((4278190080L & jV0) << 8) | ((16711680 & jV0) << 24) | ((65280 & jV0) << 40);
    }

    public final short O() throws EOFException {
        j0(2L);
        return this.f56985b.z0();
    }

    @Override // okio.BufferedSource
    public final InputStream Q1() {
        return new RealBufferedSource$inputStream$1(this);
    }

    @Override // okio.BufferedSource
    public final int R1(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.f56986c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            Buffer buffer = this.f56985b;
            int iC = okio.internal.Buffer.c(buffer, options, true);
            if (iC != -2) {
                if (iC != -1) {
                    buffer.j1(options.f56968b[iC].d());
                    return iC;
                }
            } else if (this.f56984a.read(buffer, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    public final short T() throws EOFException {
        j0(2L);
        return this.f56985b.D0();
    }

    @Override // okio.BufferedSource
    public final byte[] U0() {
        Source source = this.f56984a;
        Buffer buffer = this.f56985b;
        buffer.g0(source);
        return buffer.r0(buffer.f56914b);
    }

    public final String V(long j2) throws EOFException {
        j0(j2);
        Buffer buffer = this.f56985b;
        buffer.getClass();
        return buffer.T0(j2, Charsets.UTF_8);
    }

    public final String Z(long j2) throws EOFException {
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "limit < 0: ").toString());
        }
        long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        long jB = b((byte) 10, 0L, j3);
        Buffer buffer = this.f56985b;
        if (jB != -1) {
            return okio.internal.Buffer.b(buffer, jB);
        }
        if (j3 < Long.MAX_VALUE && h0(j3) && buffer.x(j3 - 1) == 13 && h0(j3 + 1) && buffer.x(j3) == 10) {
            return okio.internal.Buffer.b(buffer, j3);
        }
        Buffer buffer2 = new Buffer();
        buffer.e(buffer2, 0L, Math.min(32, buffer.f56914b));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.f56914b, j2) + " content=" + buffer2.s0(buffer2.f56914b).e() + (char) 8230);
    }

    public final boolean a() {
        if (this.f56986c) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.f56985b;
        return buffer.l() && this.f56984a.read(buffer, 8192L) == -1;
    }

    public final long b(byte b2, long j2, long j3) {
        if (this.f56986c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j3) {
            throw new IllegalArgumentException(b.i(j3, "fromIndex=0 toIndex=").toString());
        }
        long jMax = 0;
        while (jMax < j3) {
            byte b3 = b2;
            long j4 = j3;
            long jA = this.f56985b.A(b3, jMax, j4);
            if (jA != -1) {
                return jA;
            }
            Buffer buffer = this.f56985b;
            long j5 = buffer.f56914b;
            if (j5 >= j4 || this.f56984a.read(buffer, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j5);
            b2 = b3;
            j3 = j4;
        }
        return -1L;
    }

    public final long c(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (this.f56986c) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            Buffer buffer = this.f56985b;
            long jO = buffer.O(jMax, targetBytes);
            if (jO != -1) {
                return jO;
            }
            long j2 = buffer.f56914b;
            if (this.f56984a.read(buffer, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f56986c) {
            return;
        }
        this.f56986c = true;
        this.f56984a.close();
        this.f56985b.a();
    }

    public final byte e() throws EOFException {
        j0(1L);
        return this.f56985b.k0();
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer g() {
        return this.f56985b;
    }

    @Override // okio.BufferedSource
    public final boolean h0(long j2) {
        Buffer buffer;
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
        }
        if (this.f56986c) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.f56985b;
            if (buffer.f56914b >= j2) {
                return true;
            }
        } while (this.f56984a.read(buffer, 8192L) != -1);
        return false;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f56986c;
    }

    public final void j0(long j2) throws EOFException {
        if (!h0(j2)) {
            throw new EOFException();
        }
    }

    public final void k0(long j2) throws EOFException {
        if (this.f56986c) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            Buffer buffer = this.f56985b;
            if (buffer.f56914b == 0 && this.f56984a.read(buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, buffer.f56914b);
            buffer.j1(jMin);
            j2 -= jMin;
        }
    }

    public final ByteString l(long j2) throws EOFException {
        j0(j2);
        return this.f56985b.s0(j2);
    }

    @Override // okio.BufferedSource
    public final String p0() {
        return Z(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final String p1(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Source source = this.f56984a;
        Buffer buffer = this.f56985b;
        buffer.g0(source);
        return buffer.p1(charset);
    }

    @Override // okio.BufferedSource
    public final RealBufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        r1 = new okio.Buffer();
        r1.S1(r8);
        r1.O1(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009d, code lost:
    
        if (r2 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        r1.k0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: ".concat(r1.A1()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long r() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.r():long");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Buffer buffer = this.f56985b;
        if (buffer.f56914b == 0 && this.f56984a.read(buffer, 8192L) == -1) {
            return -1;
        }
        return buffer.read(sink);
    }

    public final void s(Buffer sink, long j2) throws EOFException {
        Buffer buffer = this.f56985b;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            j0(j2);
            buffer.getClass();
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j3 = buffer.f56914b;
            if (j3 >= j2) {
                sink.write(buffer, j2);
            } else {
                sink.write(buffer, j3);
                throw new EOFException();
            }
        } catch (EOFException e2) {
            sink.g0(buffer);
            throw e2;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.f56984a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f56984a + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4 A[EDGE_INSN: B:70:0x00e4->B:58:0x00e4 BREAK  A[LOOP:1: B:26:0x0062->B:72:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long x() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.x():long");
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j2 >= 0) {
            if (!this.f56986c) {
                Buffer buffer = this.f56985b;
                if (buffer.f56914b == 0) {
                    if (j2 == 0) {
                        return 0L;
                    }
                    if (this.f56984a.read(buffer, 8192L) == -1) {
                        return -1L;
                    }
                }
                return buffer.read(sink, Math.min(j2, buffer.f56914b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
    }
}
