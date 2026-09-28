package okhttp3;

import android.support.v4.media.b;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MultipartReader implements Closeable, AutoCloseable {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Part implements Closeable, AutoCloseable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class PartSource implements Source {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j2) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 >= 0) {
                throw null;
            }
            throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return null;
        }
    }

    static {
        int i2 = Options.f56967d;
        ByteString byteString = ByteString.f56924d;
        Options.Companion.b(ByteString.Companion.c("\r\n"), ByteString.Companion.c("--"), ByteString.Companion.c(StringUtils.SPACE), ByteString.Companion.c("\t"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
