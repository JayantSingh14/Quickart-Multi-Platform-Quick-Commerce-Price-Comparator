package okio;

import java.io.Closeable;
import java.io.Flushable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface Sink extends Closeable, Flushable, AutoCloseable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    Timeout timeout();

    void write(Buffer buffer, long j2);
}
