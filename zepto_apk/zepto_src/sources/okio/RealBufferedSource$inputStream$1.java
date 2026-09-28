package okio;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealBufferedSource$inputStream$1 extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealBufferedSource f56987a;

    public RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.f56987a = realBufferedSource;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        RealBufferedSource realBufferedSource = this.f56987a;
        if (realBufferedSource.f56986c) {
            throw new IOException("closed");
        }
        return (int) Math.min(realBufferedSource.f56985b.f56914b, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f56987a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        RealBufferedSource realBufferedSource = this.f56987a;
        if (realBufferedSource.f56986c) {
            throw new IOException("closed");
        }
        Buffer buffer = realBufferedSource.f56985b;
        if (buffer.f56914b == 0 && realBufferedSource.f56984a.read(buffer, 8192L) == -1) {
            return -1;
        }
        return buffer.k0() & 255;
    }

    public final String toString() {
        return this.f56987a + ".inputStream()";
    }

    @Override // java.io.InputStream
    public final int read(byte[] data, int i2, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        RealBufferedSource realBufferedSource = this.f56987a;
        if (!realBufferedSource.f56986c) {
            SegmentedByteString.b(data.length, i2, i3);
            Buffer buffer = realBufferedSource.f56985b;
            if (buffer.f56914b == 0 && realBufferedSource.f56984a.read(buffer, 8192L) == -1) {
                return -1;
            }
            return buffer.read(data, i2, i3);
        }
        throw new IOException("closed");
    }
}
