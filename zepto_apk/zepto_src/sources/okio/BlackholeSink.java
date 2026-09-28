package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class BlackholeSink implements Sink {
    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return Timeout.f57001d;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        source.j1(j2);
    }
}
