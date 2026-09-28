package okhttp3.internal.cache2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

@Metadata
/* loaded from: classes3.dex */
public final class Relay {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public final class RelaySource implements Source {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j2) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            throw new IllegalStateException("Check failed.");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return null;
        }
    }

    static {
        ByteString byteString = ByteString.f56924d;
        ByteString.Companion.c("OkHttp cache v1\n");
        ByteString.Companion.c("OkHttp DIRTY :(\n");
    }
}
