package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class Okio {
    public static final Sink a(File file) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return i(new FileOutputStream(file, true));
    }

    public static final Sink b() {
        return new BlackholeSink();
    }

    public static final RealBufferedSink c(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    public static final RealBufferedSource d(Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final boolean e(AssertionError assertionError) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? StringsKt.n(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static final ZipFileSystem f(FileSystem fileSystem, Path path) {
        return Okio__ZlibOkioKt.a(fileSystem, path);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [okio.AsyncTimeout$sink$1] */
    public static final AsyncTimeout$sink$1 g(Socket socket) throws IOException {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        final SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        final OutputStreamSink sink = new OutputStreamSink(outputStream, socketAsyncTimeout);
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                Sink sink2 = sink;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.i();
                try {
                    ((OutputStreamSink) sink2).close();
                    Unit unit = Unit.f53572a;
                    if (asyncTimeout.j()) {
                        throw asyncTimeout.k(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.j()) {
                        throw e2;
                    }
                    throw asyncTimeout.k(e2);
                } finally {
                    asyncTimeout.j();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public final void flush() throws IOException {
                Sink sink2 = sink;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.i();
                try {
                    ((OutputStreamSink) sink2).flush();
                    Unit unit = Unit.f53572a;
                    if (asyncTimeout.j()) {
                        throw asyncTimeout.k(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.j()) {
                        throw e2;
                    }
                    throw asyncTimeout.k(e2);
                } finally {
                    asyncTimeout.j();
                }
            }

            @Override // okio.Sink
            public final Timeout timeout() {
                return socketAsyncTimeout;
            }

            public final String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public final void write(Buffer source, long j2) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                SegmentedByteString.b(source.f56914b, 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    Segment segment = source.f56913a;
                    Intrinsics.c(segment);
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += segment.f56990c - segment.f56989b;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        } else {
                            segment = segment.f56993f;
                            Intrinsics.c(segment);
                        }
                    }
                    Sink sink2 = sink;
                    AsyncTimeout asyncTimeout = socketAsyncTimeout;
                    asyncTimeout.i();
                    try {
                        try {
                            ((OutputStreamSink) sink2).write(source, j3);
                            Unit unit = Unit.f53572a;
                            if (asyncTimeout.j()) {
                                throw asyncTimeout.k(null);
                            }
                            j2 -= j3;
                        } catch (IOException e2) {
                            if (!asyncTimeout.j()) {
                                throw e2;
                            }
                            throw asyncTimeout.k(e2);
                        }
                    } catch (Throwable th) {
                        asyncTimeout.j();
                        throw th;
                    }
                }
            }
        };
    }

    public static final Sink h(File file) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return j(file);
    }

    public static final Sink i(OutputStream outputStream) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static Sink j(File file) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return i(new FileOutputStream(file, false));
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [okio.AsyncTimeout$source$1] */
    public static final AsyncTimeout$source$1 k(Socket socket) throws IOException {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        final SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        final InputStreamSource source = new InputStreamSource(inputStream, socketAsyncTimeout);
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                Source source2 = source;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.i();
                try {
                    ((InputStreamSource) source2).close();
                    Unit unit = Unit.f53572a;
                    if (asyncTimeout.j()) {
                        throw asyncTimeout.k(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.j()) {
                        throw e2;
                    }
                    throw asyncTimeout.k(e2);
                } finally {
                    asyncTimeout.j();
                }
            }

            @Override // okio.Source
            public final long read(Buffer sink, long j2) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                Source source2 = source;
                AsyncTimeout asyncTimeout = socketAsyncTimeout;
                asyncTimeout.i();
                try {
                    long j3 = ((InputStreamSource) source2).read(sink, j2);
                    if (asyncTimeout.j()) {
                        throw asyncTimeout.k(null);
                    }
                    return j3;
                } catch (IOException e2) {
                    if (asyncTimeout.j()) {
                        throw asyncTimeout.k(e2);
                    }
                    throw e2;
                } finally {
                    asyncTimeout.j();
                }
            }

            @Override // okio.Source
            public final Timeout timeout() {
                return socketAsyncTimeout;
            }

            public final String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    public static final Source l(File file) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.f57001d);
    }

    public static final Source m(InputStream inputStream) {
        Logger logger = Okio__JvmOkioKt.f56966a;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }
}
