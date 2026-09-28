package okio;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CipherSource implements Source {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j2 >= 0) {
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
    }

    @Override // okio.Source
    public final Timeout timeout() {
        throw null;
    }
}
