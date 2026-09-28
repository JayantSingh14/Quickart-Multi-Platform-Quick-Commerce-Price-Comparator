package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Buffer$outputStream$1 extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Buffer f56923a;

    public Buffer$outputStream$1(Buffer buffer) {
        this.f56923a = buffer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }

    public final String toString() {
        return this.f56923a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        this.f56923a.O1(i2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i2, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f56923a.J1(data, i2, i3);
    }
}
