package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class ForwardingSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    public final Sink f56950a;

    public ForwardingSink(Sink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f56950a = delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f56950a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f56950a.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.f56950a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f56950a + ')';
    }

    @Override // okio.Sink
    public void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f56950a.write(source, j2);
    }
}
