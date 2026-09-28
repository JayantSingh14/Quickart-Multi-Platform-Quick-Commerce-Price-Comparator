package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class OutputStreamSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f56970a;

    /* renamed from: b, reason: collision with root package name */
    public final Timeout f56971b;

    public OutputStreamSink(OutputStream out, Timeout timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f56970a = out;
        this.f56971b = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f56970a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        this.f56970a.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.f56971b;
    }

    public final String toString() {
        return "sink(" + this.f56970a + ')';
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.f56914b, 0L, j2);
        while (j2 > 0) {
            this.f56971b.f();
            Segment segment = source.f56913a;
            Intrinsics.c(segment);
            int iMin = (int) Math.min(j2, segment.f56990c - segment.f56989b);
            this.f56970a.write(segment.f56988a, segment.f56989b, iMin);
            int i2 = segment.f56989b + iMin;
            segment.f56989b = i2;
            long j3 = iMin;
            j2 -= j3;
            source.f56914b -= j3;
            if (i2 == segment.f56990c) {
                source.f56913a = segment.a();
                SegmentPool.a(segment);
            }
        }
    }
}
