package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalEncodingApi
@Metadata
/* loaded from: classes3.dex */
final class EncodeOutputStream extends OutputStream implements AutoCloseable {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        throw new IOException("The output stream is closed.");
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        throw new IOException("The output stream is closed.");
    }

    @Override // java.io.OutputStream
    public final void write(byte[] source, int i2, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new IOException("The output stream is closed.");
    }
}
