package kotlin.io.encoding;

import android.support.v4.media.b;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalEncodingApi
@Metadata
/* loaded from: classes3.dex */
final class DecodeInputStream extends InputStream implements AutoCloseable {
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        read(null, 0, 1);
        throw null;
    }

    @Override // java.io.InputStream
    public final int read(byte[] destination, int i2, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= destination.length) {
            throw new IOException("The input stream is closed.");
        }
        StringBuilder sbT = b.t(i2, i3, "offset: ", ", length: ", ", buffer size: ");
        sbT.append(destination.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }
}
