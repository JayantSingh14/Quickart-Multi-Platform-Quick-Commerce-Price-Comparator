package okio;

import android.support.v4.media.b;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class GzipSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    public byte f56952a;

    /* renamed from: b, reason: collision with root package name */
    public final RealBufferedSource f56953b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f56954c;

    /* renamed from: d, reason: collision with root package name */
    public final InflaterSource f56955d;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f56956e;

    public GzipSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.f56953b = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f56954c = inflater;
        this.f56955d = new InflaterSource(realBufferedSource, inflater);
        this.f56956e = new CRC32();
    }

    public static void a(int i2, int i3, String str) throws IOException {
        if (i3 == i2) {
            return;
        }
        StringBuilder sbX = b.x(str, ": actual 0x");
        sbX.append(StringsKt.D(8, SegmentedByteString.e(i3)));
        sbX.append(" != expected 0x");
        sbX.append(StringsKt.D(8, SegmentedByteString.e(i2)));
        throw new IOException(sbX.toString());
    }

    public final void b(Buffer buffer, long j2, long j3) {
        Segment segment = buffer.f56913a;
        Intrinsics.c(segment);
        while (true) {
            int i2 = segment.f56990c;
            int i3 = segment.f56989b;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            segment = segment.f56993f;
            Intrinsics.c(segment);
        }
        while (j3 > 0) {
            int iMin = (int) Math.min(segment.f56990c - r6, j3);
            this.f56956e.update(segment.f56988a, (int) (segment.f56989b + j2), iMin);
            j3 -= iMin;
            segment = segment.f56993f;
            Intrinsics.c(segment);
            j2 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f56955d.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) throws IOException {
        GzipSource gzipSource = this;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        byte b2 = gzipSource.f56952a;
        CRC32 crc32 = gzipSource.f56956e;
        RealBufferedSource realBufferedSource = gzipSource.f56953b;
        if (b2 == 0) {
            realBufferedSource.j0(10L);
            Buffer buffer = realBufferedSource.f56985b;
            byte bX = buffer.x(3L);
            boolean z = ((bX >> 1) & 1) == 1;
            if (z) {
                gzipSource.b(realBufferedSource.f56985b, 0L, 10L);
            }
            a(8075, realBufferedSource.O(), "ID1ID2");
            realBufferedSource.k0(8L);
            if (((bX >> 2) & 1) == 1) {
                realBufferedSource.j0(2L);
                if (z) {
                    b(realBufferedSource.f56985b, 0L, 2L);
                }
                long jD0 = buffer.D0() & 65535;
                realBufferedSource.j0(jD0);
                if (z) {
                    b(realBufferedSource.f56985b, 0L, jD0);
                }
                realBufferedSource.k0(jD0);
            }
            if (((bX >> 3) & 1) == 1) {
                long jB = realBufferedSource.b((byte) 0, 0L, Long.MAX_VALUE);
                if (jB == -1) {
                    throw new EOFException();
                }
                if (z) {
                    b(realBufferedSource.f56985b, 0L, jB + 1);
                }
                realBufferedSource.k0(jB + 1);
            }
            if (((bX >> 4) & 1) == 1) {
                long jB2 = realBufferedSource.b((byte) 0, 0L, Long.MAX_VALUE);
                if (jB2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    gzipSource = this;
                    gzipSource.b(realBufferedSource.f56985b, 0L, jB2 + 1);
                } else {
                    gzipSource = this;
                }
                realBufferedSource.k0(jB2 + 1);
            } else {
                gzipSource = this;
            }
            if (z) {
                a(realBufferedSource.T(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            gzipSource.f56952a = (byte) 1;
        }
        if (gzipSource.f56952a == 1) {
            long j3 = sink.f56914b;
            long j4 = gzipSource.f56955d.read(sink, j2);
            if (j4 != -1) {
                gzipSource.b(sink, j3, j4);
                return j4;
            }
            gzipSource.f56952a = (byte) 2;
        }
        if (gzipSource.f56952a == 2) {
            a(realBufferedSource.D(), (int) crc32.getValue(), "CRC");
            a(realBufferedSource.D(), (int) gzipSource.f56954c.getBytesWritten(), "ISIZE");
            gzipSource.f56952a = (byte) 3;
            if (!realBufferedSource.a()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.f56953b.f56984a.timeout();
    }
}
