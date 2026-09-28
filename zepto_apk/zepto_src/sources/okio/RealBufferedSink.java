package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: a, reason: collision with root package name */
    public final Sink f56980a;

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f56981b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56982c;

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f56980a = sink;
        this.f56981b = new Buffer();
    }

    @Override // okio.BufferedSink
    public final BufferedSink D1(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        this.f56981b.s1(byteString);
        a();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink E0(long j2) {
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        this.f56981b.S1(j2);
        a();
        return this;
    }

    @Override // okio.BufferedSink
    public final OutputStream P1() {
        return new RealBufferedSink$outputStream$1(this);
    }

    @Override // okio.BufferedSink
    public final BufferedSink Y(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        this.f56981b.X1(string);
        a();
        return this;
    }

    public final BufferedSink a() {
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.f56981b;
        long jC = buffer.c();
        if (jC > 0) {
            this.f56980a.write(buffer, jC);
        }
        return this;
    }

    public final BufferedSink b(int i2) {
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        this.f56981b.U1(i2);
        a();
        return this;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Sink sink = this.f56980a;
        if (this.f56982c) {
            return;
        }
        try {
            Buffer buffer = this.f56981b;
            long j2 = buffer.f56914b;
            if (j2 > 0) {
                sink.write(buffer, j2);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f56982c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.f56981b;
        long j2 = buffer.f56914b;
        Sink sink = this.f56980a;
        if (j2 > 0) {
            sink.write(buffer, j2);
        }
        sink.flush();
    }

    @Override // okio.BufferedSink
    public final Buffer g() {
        return this.f56981b;
    }

    @Override // okio.BufferedSink
    public final long g0(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(this.f56981b, 8192L);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
            a();
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f56982c;
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.f56980a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f56980a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f56981b.write(source);
        a();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int i2) {
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        this.f56981b.O1(i2);
        a();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink x0(int i2, byte[] source, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f56982c) {
            throw new IllegalStateException("closed");
        }
        this.f56981b.J1(source, i2, i3);
        a();
        return this;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f56982c) {
            this.f56981b.write(source, j2);
            a();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f56982c) {
            this.f56981b.w1(source);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
