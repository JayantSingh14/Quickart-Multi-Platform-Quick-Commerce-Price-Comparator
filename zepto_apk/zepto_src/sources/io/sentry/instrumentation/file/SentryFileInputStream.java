package io.sentry.instrumentation.file;

import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class SentryFileInputStream extends FileInputStream implements AutoCloseable {

    public static final class Factory {
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read() {
        new AtomicInteger(0);
        throw null;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final long skip(long j2) {
        throw null;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        throw null;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        throw null;
    }
}
