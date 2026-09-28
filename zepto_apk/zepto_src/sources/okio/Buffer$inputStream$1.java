package okio;

import com.google.android.gms.common.api.Api;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Buffer$inputStream$1 extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Buffer f56922a;

    public Buffer$inputStream$1(Buffer buffer) {
        this.f56922a = buffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return (int) Math.min(this.f56922a.f56914b, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.InputStream
    public final int read() {
        Buffer buffer = this.f56922a;
        if (buffer.f56914b > 0) {
            return buffer.k0() & 255;
        }
        return -1;
    }

    public final String toString() {
        return this.f56922a + ".inputStream()";
    }

    @Override // java.io.InputStream
    public final int read(byte[] sink, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.f56922a.read(sink, i2, i3);
    }
}
