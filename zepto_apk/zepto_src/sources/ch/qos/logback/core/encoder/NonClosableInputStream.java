package ch.qos.logback.core.encoder;

import java.io.FilterInputStream;

/* loaded from: classes3.dex */
public class NonClosableInputStream extends FilterInputStream implements AutoCloseable {
    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
