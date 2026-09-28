package androidx.datastore.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class UncloseableOutputStream extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f3642a;

    public UncloseableOutputStream(FileOutputStream fileOutputStream) {
        Intrinsics.checkNotNullParameter(fileOutputStream, "fileOutputStream");
        this.f3642a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f3642a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        this.f3642a.write(i2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b2) throws IOException {
        Intrinsics.checkNotNullParameter(b2, "b");
        this.f3642a.write(b2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i2, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f3642a.write(bytes, i2, i3);
    }
}
