package coil3.fetch;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ByteBufferFetcherKt {
    @NotNull
    public static final Source asSource(@NotNull ByteBuffer byteBuffer) {
        return new Source(byteBuffer) { // from class: coil3.fetch.ByteBufferFetcherKt.asSource.1
            private final ByteBuffer buffer;
            private final int len;

            {
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                this.buffer = byteBufferSlice;
                this.len = byteBufferSlice.capacity();
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j2) {
                if (this.buffer.position() == this.len) {
                    return -1L;
                }
                int iPosition = (int) (this.buffer.position() + j2);
                int i2 = this.len;
                if (iPosition > i2) {
                    iPosition = i2;
                }
                this.buffer.limit(iPosition);
                return buffer.write(this.buffer);
            }

            @Override // okio.Source
            public Timeout timeout() {
                return Timeout.f57001d;
            }
        };
    }
}
