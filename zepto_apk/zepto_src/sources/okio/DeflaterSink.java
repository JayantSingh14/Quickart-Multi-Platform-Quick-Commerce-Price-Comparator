package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DeflaterSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSink f56928a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f56929b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56930c;

    public DeflaterSink(Buffer sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        RealBufferedSink sink2 = Okio.c(sink);
        Intrinsics.checkNotNullParameter(sink2, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.f56928a = sink2;
        this.f56929b = deflater;
    }

    public final void a(boolean z) throws IOException {
        Segment segmentO1;
        int iDeflate;
        RealBufferedSink realBufferedSink = this.f56928a;
        Buffer buffer = realBufferedSink.f56981b;
        while (true) {
            segmentO1 = buffer.o1(1);
            Deflater deflater = this.f56929b;
            byte[] bArr = segmentO1.f56988a;
            if (z) {
                try {
                    int i2 = segmentO1.f56990c;
                    iDeflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
                } catch (NullPointerException e2) {
                    throw new IOException("Deflater already closed", e2);
                }
            } else {
                int i3 = segmentO1.f56990c;
                iDeflate = deflater.deflate(bArr, i3, 8192 - i3);
            }
            if (iDeflate > 0) {
                segmentO1.f56990c += iDeflate;
                buffer.f56914b += iDeflate;
                realBufferedSink.a();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (segmentO1.f56989b == segmentO1.f56990c) {
            buffer.f56913a = segmentO1.a();
            SegmentPool.a(segmentO1);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.f56929b;
        if (this.f56930c) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f56928a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f56930c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f56928a.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.f56928a.f56980a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f56928a + ')';
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.f56914b, 0L, j2);
        while (j2 > 0) {
            Segment segment = source.f56913a;
            Intrinsics.c(segment);
            int iMin = (int) Math.min(j2, segment.f56990c - segment.f56989b);
            this.f56929b.setInput(segment.f56988a, segment.f56989b, iMin);
            a(false);
            long j3 = iMin;
            source.f56914b -= j3;
            int i2 = segment.f56989b + iMin;
            segment.f56989b = i2;
            if (i2 == segment.f56990c) {
                source.f56913a = segment.a();
                SegmentPool.a(segment);
            }
            j2 -= j3;
        }
    }
}
