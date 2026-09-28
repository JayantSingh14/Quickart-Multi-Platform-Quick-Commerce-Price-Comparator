package okio;

import android.support.v4.media.b;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
class InputStreamSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f56961a;

    /* renamed from: b, reason: collision with root package name */
    public final Timeout f56962b;

    public InputStreamSource(InputStream input, Timeout timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f56961a = input;
        this.f56962b = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f56961a.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j2 == 0) {
            return 0L;
        }
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
        }
        try {
            this.f56962b.f();
            Segment segmentO1 = sink.o1(1);
            int i2 = this.f56961a.read(segmentO1.f56988a, segmentO1.f56990c, (int) Math.min(j2, 8192 - segmentO1.f56990c));
            if (i2 != -1) {
                segmentO1.f56990c += i2;
                long j3 = i2;
                sink.f56914b += j3;
                return j3;
            }
            if (segmentO1.f56989b != segmentO1.f56990c) {
                return -1L;
            }
            sink.f56913a = segmentO1.a();
            SegmentPool.a(segmentO1);
            return -1L;
        } catch (AssertionError e2) {
            if (Okio.e(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.f56962b;
    }

    public final String toString() {
        return "source(" + this.f56961a + ')';
    }
}
