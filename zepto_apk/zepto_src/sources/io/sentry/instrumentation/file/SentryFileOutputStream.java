package io.sentry.instrumentation.file;

import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public final class SentryFileOutputStream extends FileOutputStream implements AutoCloseable {

    public static final class Factory {
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(int i2) {
        throw null;
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        throw null;
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        throw null;
    }
}
