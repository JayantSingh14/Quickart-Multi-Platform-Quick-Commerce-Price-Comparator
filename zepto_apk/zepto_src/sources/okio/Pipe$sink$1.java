package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Pipe$sink$1 implements Sink {
    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        throw null;
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return null;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw null;
    }
}
