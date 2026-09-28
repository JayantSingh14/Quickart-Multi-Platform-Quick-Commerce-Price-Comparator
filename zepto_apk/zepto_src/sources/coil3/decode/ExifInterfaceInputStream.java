package coil3.decode;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class ExifInterfaceInputStream extends InputStream implements AutoCloseable {
    private int availableBytes = 1073741824;

    @NotNull
    private final InputStream delegate;

    public ExifInterfaceInputStream(@NotNull InputStream inputStream) {
        this.delegate = inputStream;
    }

    private final int interceptBytesRead(int i2) {
        if (i2 == -1) {
            this.availableBytes = 0;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.availableBytes;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // java.io.InputStream
    public int read() {
        return interceptBytesRead(this.delegate.read());
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        return this.delegate.skip(j2);
    }

    @Override // java.io.InputStream
    public int read(@NotNull byte[] bArr) {
        return interceptBytesRead(this.delegate.read(bArr));
    }

    @Override // java.io.InputStream
    public int read(@NotNull byte[] bArr, int i2, int i3) {
        return interceptBytesRead(this.delegate.read(bArr, i2, i3));
    }
}
