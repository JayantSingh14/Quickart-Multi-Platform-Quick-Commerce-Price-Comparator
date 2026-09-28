package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealBufferedSink$outputStream$1 extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealBufferedSink f56983a;

    public RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.f56983a = realBufferedSink;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.f56983a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        RealBufferedSink realBufferedSink = this.f56983a;
        if (realBufferedSink.f56982c) {
            return;
        }
        realBufferedSink.flush();
    }

    public final String toString() {
        return this.f56983a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        RealBufferedSink realBufferedSink = this.f56983a;
        if (realBufferedSink.f56982c) {
            throw new IOException("closed");
        }
        realBufferedSink.f56981b.O1((byte) i2);
        realBufferedSink.a();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i2, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        RealBufferedSink realBufferedSink = this.f56983a;
        if (!realBufferedSink.f56982c) {
            realBufferedSink.f56981b.J1(data, i2, i3);
            realBufferedSink.a();
            return;
        }
        throw new IOException("closed");
    }
}
