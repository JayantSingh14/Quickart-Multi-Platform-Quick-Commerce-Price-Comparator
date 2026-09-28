package okhttp3.internal.http2;

import android.support.v4.media.b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Http2Stream {

    /* renamed from: a, reason: collision with root package name */
    public final int f56727a;

    /* renamed from: b, reason: collision with root package name */
    public final Http2Connection f56728b;

    /* renamed from: c, reason: collision with root package name */
    public long f56729c;

    /* renamed from: d, reason: collision with root package name */
    public long f56730d;

    /* renamed from: e, reason: collision with root package name */
    public long f56731e;

    /* renamed from: f, reason: collision with root package name */
    public long f56732f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f56733g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f56734h;

    /* renamed from: i, reason: collision with root package name */
    public final FramingSource f56735i;

    /* renamed from: j, reason: collision with root package name */
    public final FramingSink f56736j;

    /* renamed from: k, reason: collision with root package name */
    public final StreamTimeout f56737k;

    /* renamed from: l, reason: collision with root package name */
    public final StreamTimeout f56738l;

    /* renamed from: m, reason: collision with root package name */
    public ErrorCode f56739m;
    public IOException n;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public final class FramingSink implements Sink {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f56740a;

        /* renamed from: b, reason: collision with root package name */
        public final Buffer f56741b = new Buffer();

        /* renamed from: c, reason: collision with root package name */
        public boolean f56742c;

        public FramingSink(boolean z) {
            this.f56740a = z;
        }

        /* JADX WARN: Finally extract failed */
        public final void a(boolean z) throws IOException {
            long jMin;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                try {
                    http2Stream.f56738l.i();
                    while (http2Stream.f56731e >= http2Stream.f56732f && !this.f56740a && !this.f56742c) {
                        try {
                            synchronized (http2Stream) {
                                ErrorCode errorCode = http2Stream.f56739m;
                                if (errorCode != null) {
                                    break;
                                } else {
                                    http2Stream.k();
                                }
                            }
                        } catch (Throwable th) {
                            http2Stream.f56738l.m();
                            throw th;
                        }
                    }
                    http2Stream.f56738l.m();
                    http2Stream.b();
                    jMin = Math.min(http2Stream.f56732f - http2Stream.f56731e, this.f56741b.f56914b);
                    http2Stream.f56731e += jMin;
                    z2 = z && jMin == this.f56741b.f56914b;
                    Unit unit = Unit.f53572a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            Http2Stream.this.f56738l.i();
            try {
                Http2Stream http2Stream2 = Http2Stream.this;
                http2Stream2.f56728b.s(http2Stream2.f56727a, z2, this.f56741b, jMin);
            } finally {
                Http2Stream.this.f56738l.m();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            boolean z;
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.f56394a;
            synchronized (http2Stream) {
                if (this.f56742c) {
                    return;
                }
                synchronized (http2Stream) {
                    z = http2Stream.f56739m == null;
                    Unit unit = Unit.f53572a;
                }
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.f56736j.f56740a) {
                    if (this.f56741b.f56914b > 0) {
                        while (this.f56741b.f56914b > 0) {
                            a(true);
                        }
                    } else if (z) {
                        http2Stream2.f56728b.s(http2Stream2.f56727a, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f56742c = true;
                    Unit unit2 = Unit.f53572a;
                }
                Http2Stream.this.f56728b.flush();
                Http2Stream.this.a();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.f56394a;
            synchronized (http2Stream) {
                http2Stream.b();
                Unit unit = Unit.f53572a;
            }
            while (this.f56741b.f56914b > 0) {
                a(false);
                Http2Stream.this.f56728b.flush();
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return Http2Stream.this.f56738l;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            byte[] bArr = Util.f56394a;
            Buffer buffer = this.f56741b;
            buffer.write(source, j2);
            while (buffer.f56914b >= 16384) {
                a(false);
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class FramingSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final long f56744a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56745b;

        /* renamed from: c, reason: collision with root package name */
        public final Buffer f56746c = new Buffer();

        /* renamed from: d, reason: collision with root package name */
        public final Buffer f56747d = new Buffer();

        /* renamed from: e, reason: collision with root package name */
        public boolean f56748e;

        public FramingSource(long j2, boolean z) {
            this.f56744a = j2;
            this.f56745b = z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long j2;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.f56748e = true;
                Buffer buffer = this.f56747d;
                j2 = buffer.f56914b;
                buffer.a();
                http2Stream.notifyAll();
                Unit unit = Unit.f53572a;
            }
            if (j2 > 0) {
                byte[] bArr = Util.f56394a;
                Http2Stream.this.f56728b.r(j2);
            }
            Http2Stream.this.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0089 A[LOOP:0: B:4:0x000e->B:45:0x0089, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x008c A[SYNTHETIC] */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long read(okio.Buffer r15, long r16) throws java.lang.Throwable {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                java.lang.String r3 = "sink"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r3)
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 < 0) goto Laa
            Le:
                okhttp3.internal.http2.Http2Stream r5 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r5)
                okhttp3.internal.http2.Http2Stream$StreamTimeout r6 = r5.f56737k     // Catch: java.lang.Throwable -> L95
                r6.i()     // Catch: java.lang.Throwable -> L95
                monitor-enter(r5)     // Catch: java.lang.Throwable -> L31
                okhttp3.internal.http2.ErrorCode r6 = r5.f56739m     // Catch: java.lang.Throwable -> L9f
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L31
                if (r6 == 0) goto L37
                boolean r6 = r14.f56745b     // Catch: java.lang.Throwable -> L31
                if (r6 != 0) goto L37
                java.io.IOException r6 = r5.n     // Catch: java.lang.Throwable -> L31
                if (r6 != 0) goto L38
                okhttp3.internal.http2.StreamResetException r6 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L31
                monitor-enter(r5)     // Catch: java.lang.Throwable -> L31
                okhttp3.internal.http2.ErrorCode r7 = r5.f56739m     // Catch: java.lang.Throwable -> L34
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L31
                kotlin.jvm.internal.Intrinsics.c(r7)     // Catch: java.lang.Throwable -> L31
                r6.<init>(r7)     // Catch: java.lang.Throwable -> L31
                goto L38
            L31:
                r0 = move-exception
                goto La2
            L34:
                r0 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L34
                throw r0     // Catch: java.lang.Throwable -> L31
            L37:
                r6 = 0
            L38:
                boolean r7 = r14.f56748e     // Catch: java.lang.Throwable -> L31
                if (r7 != 0) goto L97
                okio.Buffer r7 = r14.f56747d     // Catch: java.lang.Throwable -> L31
                long r8 = r7.f56914b     // Catch: java.lang.Throwable -> L31
                int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                r11 = -1
                r13 = 0
                if (r10 <= 0) goto L74
                long r8 = java.lang.Math.min(r1, r8)     // Catch: java.lang.Throwable -> L31
                long r7 = r7.read(r15, r8)     // Catch: java.lang.Throwable -> L31
                long r9 = r5.f56729c     // Catch: java.lang.Throwable -> L31
                long r9 = r9 + r7
                r5.f56729c = r9     // Catch: java.lang.Throwable -> L31
                long r3 = r5.f56730d     // Catch: java.lang.Throwable -> L31
                long r9 = r9 - r3
                if (r6 != 0) goto L7f
                okhttp3.internal.http2.Http2Connection r3 = r5.f56728b     // Catch: java.lang.Throwable -> L31
                okhttp3.internal.http2.Settings r3 = r3.q     // Catch: java.lang.Throwable -> L31
                int r3 = r3.a()     // Catch: java.lang.Throwable -> L31
                int r3 = r3 / 2
                long r3 = (long) r3     // Catch: java.lang.Throwable -> L31
                int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r3 < 0) goto L7f
                okhttp3.internal.http2.Http2Connection r3 = r5.f56728b     // Catch: java.lang.Throwable -> L31
                int r4 = r5.f56727a     // Catch: java.lang.Throwable -> L31
                r3.A(r4, r9)     // Catch: java.lang.Throwable -> L31
                long r3 = r5.f56729c     // Catch: java.lang.Throwable -> L31
                r5.f56730d = r3     // Catch: java.lang.Throwable -> L31
                goto L7f
            L74:
                boolean r3 = r14.f56745b     // Catch: java.lang.Throwable -> L31
                if (r3 != 0) goto L7e
                if (r6 != 0) goto L7e
                r5.k()     // Catch: java.lang.Throwable -> L31
                r13 = 1
            L7e:
                r7 = r11
            L7f:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r3 = r5.f56737k     // Catch: java.lang.Throwable -> L95
                r3.m()     // Catch: java.lang.Throwable -> L95
                kotlin.Unit r3 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L95
                monitor-exit(r5)
                if (r13 == 0) goto L8c
                r3 = 0
                goto Le
            L8c:
                int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r0 == 0) goto L91
                return r7
            L91:
                if (r6 != 0) goto L94
                return r11
            L94:
                throw r6
            L95:
                r0 = move-exception
                goto La8
            L97:
                java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L31
                java.lang.String r1 = "stream closed"
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L31
                throw r0     // Catch: java.lang.Throwable -> L31
            L9f:
                r0 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L9f
                throw r0     // Catch: java.lang.Throwable -> L31
            La2:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r5.f56737k     // Catch: java.lang.Throwable -> L95
                r1.m()     // Catch: java.lang.Throwable -> L95
                throw r0     // Catch: java.lang.Throwable -> L95
            La8:
                monitor-exit(r5)
                throw r0
            Laa:
                java.lang.String r0 = "byteCount < 0: "
                java.lang.String r0 = android.support.v4.media.b.i(r1, r0)
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return Http2Stream.this.f56737k;
        }
    }

    @Metadata
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        public final IOException k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public final void l() {
            Http2Stream.this.e(ErrorCode.CANCEL);
            final Http2Connection http2Connection = Http2Stream.this.f56728b;
            synchronized (http2Connection) {
                long j2 = http2Connection.o;
                long j3 = http2Connection.n;
                if (j2 < j3) {
                    return;
                }
                http2Connection.n = j3 + 1;
                http2Connection.p = System.nanoTime() + 1000000000;
                Unit unit = Unit.f53572a;
                TaskQueue taskQueue = http2Connection.f56664h;
                final String strR = b.r(new StringBuilder(), http2Connection.f56659c, " ping");
                taskQueue.c(new Task(strR) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$default$1
                    @Override // okhttp3.internal.concurrent.Task
                    public final long a() throws IOException {
                        Http2Connection http2Connection2 = http2Connection;
                        http2Connection2.getClass();
                        try {
                            http2Connection2.x.r(2, 0, false);
                            return -1L;
                        } catch (IOException e2) {
                            http2Connection2.b(e2);
                            return -1L;
                        }
                    }
                }, 0L);
            }
        }

        public final void m() throws IOException {
            if (j()) {
                throw k(null);
            }
        }
    }

    public Http2Stream(int i2, Http2Connection connection, boolean z, boolean z2, Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f56727a = i2;
        this.f56728b = connection;
        this.f56732f = connection.r.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f56733g = arrayDeque;
        this.f56735i = new FramingSource(connection.q.a(), z2);
        this.f56736j = new FramingSink(z);
        this.f56737k = new StreamTimeout();
        this.f56738l = new StreamTimeout();
        if (headers == null) {
            if (!g()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (g()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r3 = this;
            byte[] r0 = okhttp3.internal.Util.f56394a
            monitor-enter(r3)
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r3.f56735i     // Catch: java.lang.Throwable -> L19
            boolean r1 = r0.f56745b     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto L1b
            boolean r0 = r0.f56748e     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r3.f56736j     // Catch: java.lang.Throwable -> L19
            boolean r1 = r0.f56740a     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto L17
            boolean r0 = r0.f56742c     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
        L17:
            r0 = 1
            goto L1c
        L19:
            r0 = move-exception
            goto L36
        L1b:
            r0 = 0
        L1c:
            boolean r1 = r3.h()     // Catch: java.lang.Throwable -> L19
            kotlin.Unit r2 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L19
            monitor-exit(r3)
            if (r0 == 0) goto L2c
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL
            r1 = 0
            r3.c(r0, r1)
            return
        L2c:
            if (r1 != 0) goto L35
            okhttp3.internal.http2.Http2Connection r0 = r3.f56728b
            int r1 = r3.f56727a
            r0.e(r1)
        L35:
            return
        L36:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.a():void");
    }

    public final void b() throws IOException {
        FramingSink framingSink = this.f56736j;
        if (framingSink.f56742c) {
            throw new IOException("stream closed");
        }
        if (framingSink.f56740a) {
            throw new IOException("stream finished");
        }
        if (this.f56739m != null) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f56739m;
            Intrinsics.c(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void c(ErrorCode statusCode, IOException iOException) {
        Intrinsics.checkNotNullParameter(statusCode, "rstStatusCode");
        if (d(statusCode, iOException)) {
            Http2Connection http2Connection = this.f56728b;
            http2Connection.getClass();
            Intrinsics.checkNotNullParameter(statusCode, "statusCode");
            http2Connection.x.s(this.f56727a, statusCode);
        }
    }

    public final boolean d(ErrorCode errorCode, IOException iOException) {
        byte[] bArr = Util.f56394a;
        synchronized (this) {
            if (this.f56739m != null) {
                return false;
            }
            this.f56739m = errorCode;
            this.n = iOException;
            notifyAll();
            if (this.f56735i.f56745b && this.f56736j.f56740a) {
                return false;
            }
            Unit unit = Unit.f53572a;
            this.f56728b.e(this.f56727a);
            return true;
        }
    }

    public final void e(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (d(errorCode, null)) {
            this.f56728b.x(this.f56727a, errorCode);
        }
    }

    public final FramingSink f() {
        synchronized (this) {
            try {
                if (!this.f56734h && !g()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f56736j;
    }

    public final boolean g() {
        boolean z = (this.f56727a & 1) == 1;
        this.f56728b.getClass();
        return true == z;
    }

    public final synchronized boolean h() {
        if (this.f56739m != null) {
            return false;
        }
        FramingSource framingSource = this.f56735i;
        if (framingSource.f56745b || framingSource.f56748e) {
            FramingSink framingSink = this.f56736j;
            if (framingSink.f56740a || framingSink.f56742c) {
                if (this.f56734h) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void i(Headers headers, boolean z) {
        boolean zH;
        Intrinsics.checkNotNullParameter(headers, "headers");
        byte[] bArr = Util.f56394a;
        synchronized (this) {
            try {
                if (this.f56734h && z) {
                    this.f56735i.getClass();
                } else {
                    this.f56734h = true;
                    this.f56733g.add(headers);
                }
                if (z) {
                    this.f56735i.f56745b = true;
                }
                zH = h();
                notifyAll();
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.f56728b.e(this.f56727a);
    }

    public final synchronized void j(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f56739m == null) {
            this.f56739m = errorCode;
            notifyAll();
        }
    }

    public final void k() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
