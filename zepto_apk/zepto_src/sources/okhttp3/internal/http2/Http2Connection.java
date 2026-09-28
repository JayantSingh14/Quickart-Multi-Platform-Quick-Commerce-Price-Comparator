package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.PushObserver;
import okhttp3.internal.platform.Platform;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import org.xbill.DNS.Message;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Http2Connection implements Closeable, AutoCloseable {
    public static final Settings A;

    /* renamed from: a, reason: collision with root package name */
    public final Listener f56657a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f56658b;

    /* renamed from: c, reason: collision with root package name */
    public final String f56659c;

    /* renamed from: d, reason: collision with root package name */
    public int f56660d;

    /* renamed from: e, reason: collision with root package name */
    public int f56661e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f56662f;

    /* renamed from: g, reason: collision with root package name */
    public final TaskRunner f56663g;

    /* renamed from: h, reason: collision with root package name */
    public final TaskQueue f56664h;

    /* renamed from: i, reason: collision with root package name */
    public final TaskQueue f56665i;

    /* renamed from: j, reason: collision with root package name */
    public final TaskQueue f56666j;

    /* renamed from: k, reason: collision with root package name */
    public final PushObserver f56667k;

    /* renamed from: l, reason: collision with root package name */
    public long f56668l;

    /* renamed from: m, reason: collision with root package name */
    public long f56669m;
    public long n;
    public long o;
    public long p;
    public final Settings q;
    public Settings r;
    public long s;
    public long t;
    public long u;
    public long v;
    public final Socket w;
    public final Http2Writer x;
    public final ReaderRunnable y;
    public final LinkedHashSet z;

    @Metadata
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final TaskRunner f56699a;

        /* renamed from: b, reason: collision with root package name */
        public Socket f56700b;

        /* renamed from: c, reason: collision with root package name */
        public String f56701c;

        /* renamed from: d, reason: collision with root package name */
        public RealBufferedSource f56702d;

        /* renamed from: e, reason: collision with root package name */
        public RealBufferedSink f56703e;

        /* renamed from: f, reason: collision with root package name */
        public Listener f56704f;

        /* renamed from: g, reason: collision with root package name */
        public final PushObserver f56705g;

        public Builder(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.f56699a = taskRunner;
            this.f56704f = Listener.f56706a;
            this.f56705g = PushObserver.f56763a;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static abstract class Listener {

        /* renamed from: a, reason: collision with root package name */
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 f56706a = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        @Metadata
        public static final class Companion {
        }

        public void a(Http2Connection connection, Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void b(Http2Stream http2Stream);
    }

    @Metadata
    @SourceDebugExtension
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final Http2Reader f56707a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Http2Connection f56708b;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.f56708b = http2Connection;
            this.f56707a = reader;
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x0103, code lost:
        
            if (r19 == false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
        
            r4.i(okhttp3.internal.Util.f56395b, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x010a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(final boolean r19, final int r20, okio.RealBufferedSource r21, final int r22) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 267
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.a(boolean, int, okio.RealBufferedSource, int):void");
        }

        public final void e(final int i2, final List requestHeaders, final boolean z) {
            Intrinsics.checkNotNullParameter(requestHeaders, "headerBlock");
            this.f56708b.getClass();
            if (i2 != 0 && (i2 & 1) == 0) {
                final Http2Connection http2Connection = this.f56708b;
                http2Connection.getClass();
                Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
                final String str = http2Connection.f56659c + '[' + i2 + "] onHeaders";
                http2Connection.f56665i.c(new Task(str, http2Connection, i2, requestHeaders, z) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$default$1

                    /* renamed from: e, reason: collision with root package name */
                    public final /* synthetic */ Http2Connection f56683e;

                    /* renamed from: f, reason: collision with root package name */
                    public final /* synthetic */ int f56684f;

                    /* renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ List f56685g;

                    @Override // okhttp3.internal.concurrent.Task
                    public final long a() {
                        PushObserver pushObserver = this.f56683e.f56667k;
                        List responseHeaders = this.f56685g;
                        ((PushObserver.Companion.PushObserverCancel) pushObserver).getClass();
                        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                        try {
                            this.f56683e.x.s(this.f56684f, ErrorCode.CANCEL);
                            synchronized (this.f56683e) {
                                this.f56683e.z.remove(Integer.valueOf(this.f56684f));
                            }
                            return -1L;
                        } catch (IOException unused) {
                            return -1L;
                        }
                    }
                }, 0L);
                return;
            }
            final Http2Connection http2Connection2 = this.f56708b;
            synchronized (http2Connection2) {
                Http2Stream http2StreamC = http2Connection2.c(i2);
                if (http2StreamC != null) {
                    Unit unit = Unit.f53572a;
                    http2StreamC.i(Util.w(requestHeaders), z);
                    return;
                }
                if (http2Connection2.f56662f) {
                    return;
                }
                if (i2 <= http2Connection2.f56660d) {
                    return;
                }
                if (i2 % 2 == http2Connection2.f56661e % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i2, http2Connection2, false, z, Util.w(requestHeaders));
                http2Connection2.f56660d = i2;
                http2Connection2.f56658b.put(Integer.valueOf(i2), http2Stream);
                TaskQueue taskQueueE = http2Connection2.f56663g.e();
                final String str2 = http2Connection2.f56659c + '[' + i2 + "] onStream";
                taskQueueE.c(new Task(str2) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$lambda$2$$inlined$execute$default$1
                    @Override // okhttp3.internal.concurrent.Task
                    public final long a() {
                        try {
                            http2Connection2.f56657a.b(http2Stream);
                            return -1L;
                        } catch (IOException e2) {
                            Platform platform = Platform.f56791a;
                            Platform platform2 = Platform.f56791a;
                            String str3 = "Http2Connection.Listener failure for " + http2Connection2.f56659c;
                            platform2.getClass();
                            Platform.i(4, str3, e2);
                            try {
                                http2Stream.c(ErrorCode.PROTOCOL_ERROR, e2);
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }
                }, 0L);
            }
        }

        public final void f(final int i2, final List requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            final Http2Connection http2Connection = this.f56708b;
            http2Connection.getClass();
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            synchronized (http2Connection) {
                if (http2Connection.z.contains(Integer.valueOf(i2))) {
                    http2Connection.x(i2, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                http2Connection.z.add(Integer.valueOf(i2));
                TaskQueue taskQueue = http2Connection.f56665i;
                final String str = http2Connection.f56659c + '[' + i2 + "] onRequest";
                taskQueue.c(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$default$1
                    @Override // okhttp3.internal.concurrent.Task
                    public final long a() {
                        PushObserver pushObserver = http2Connection.f56667k;
                        List requestHeaders2 = requestHeaders;
                        ((PushObserver.Companion.PushObserverCancel) pushObserver).getClass();
                        Intrinsics.checkNotNullParameter(requestHeaders2, "requestHeaders");
                        try {
                            http2Connection.x.s(i2, ErrorCode.CANCEL);
                            synchronized (http2Connection) {
                                http2Connection.z.remove(Integer.valueOf(i2));
                            }
                            return -1L;
                        } catch (IOException unused) {
                            return -1L;
                        }
                    }
                }, 0L);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() throws Throwable {
            ErrorCode errorCode;
            Throwable th;
            Http2Connection http2Connection = this.f56708b;
            Http2Reader http2Reader = this.f56707a;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                try {
                    Intrinsics.checkNotNullParameter(this, "handler");
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e2 = e3;
                errorCode = errorCode2;
            }
            if (!http2Reader.a(true, this)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            do {
                try {
                } catch (Throwable th3) {
                    th = th3;
                    errorCode = errorCode2;
                    http2Connection.a(errorCode, errorCode2, e2);
                    Util.c(http2Reader);
                    throw th;
                }
            } while (http2Reader.a(false, this));
            errorCode = ErrorCode.NO_ERROR;
            try {
                try {
                    http2Connection.a(errorCode, ErrorCode.CANCEL, null);
                } catch (IOException e4) {
                    e2 = e4;
                    ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                    http2Connection.a(errorCode3, errorCode3, e2);
                    Util.c(http2Reader);
                    return Unit.f53572a;
                }
                Util.c(http2Reader);
                return Unit.f53572a;
            } catch (Throwable th4) {
                th = th4;
                http2Connection.a(errorCode, errorCode2, e2);
                Util.c(http2Reader);
                throw th;
            }
        }
    }

    static {
        Settings settings = new Settings();
        settings.c(7, Message.MAXLENGTH);
        settings.c(5, 16384);
        A = settings;
    }

    public Http2Connection(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f56657a = builder.f56704f;
        this.f56658b = new LinkedHashMap();
        String str = builder.f56701c;
        if (str == null) {
            Intrinsics.h("connectionName");
            throw null;
        }
        this.f56659c = str;
        this.f56661e = 3;
        TaskRunner taskRunner = builder.f56699a;
        this.f56663g = taskRunner;
        this.f56664h = taskRunner.e();
        this.f56665i = taskRunner.e();
        this.f56666j = taskRunner.e();
        this.f56667k = builder.f56705g;
        Settings settings = new Settings();
        settings.c(7, 16777216);
        this.q = settings;
        this.r = A;
        this.v = r0.a();
        Socket socket = builder.f56700b;
        if (socket == null) {
            Intrinsics.h("socket");
            throw null;
        }
        this.w = socket;
        RealBufferedSink realBufferedSink = builder.f56703e;
        if (realBufferedSink == null) {
            Intrinsics.h("sink");
            throw null;
        }
        this.x = new Http2Writer(realBufferedSink);
        RealBufferedSource realBufferedSource = builder.f56702d;
        if (realBufferedSource == null) {
            Intrinsics.h("source");
            throw null;
        }
        this.y = new ReaderRunnable(this, new Http2Reader(realBufferedSource));
        this.z = new LinkedHashSet();
    }

    public final void A(final int i2, final long j2) {
        final String str = this.f56659c + '[' + i2 + "] windowUpdate";
        this.f56664h.c(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            @Override // okhttp3.internal.concurrent.Task
            public final long a() throws IOException {
                Http2Connection http2Connection = this;
                try {
                    http2Connection.x.x(i2, j2);
                    return -1L;
                } catch (IOException e2) {
                    Settings settings = Http2Connection.A;
                    http2Connection.b(e2);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void a(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) throws IOException {
        int i2;
        Object[] array;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        byte[] bArr = Util.f56394a;
        try {
            l(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f56658b.isEmpty()) {
                    array = null;
                } else {
                    array = this.f56658b.values().toArray(new Http2Stream[0]);
                    this.f56658b.clear();
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.c(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.x.close();
        } catch (IOException unused3) {
        }
        try {
            this.w.close();
        } catch (IOException unused4) {
        }
        this.f56664h.f();
        this.f56665i.f();
        this.f56666j.f();
    }

    public final void b(IOException iOException) throws IOException {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        a(errorCode, errorCode, iOException);
    }

    public final synchronized Http2Stream c(int i2) {
        return (Http2Stream) this.f56658b.get(Integer.valueOf(i2));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final synchronized Http2Stream e(int i2) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.f56658b.remove(Integer.valueOf(i2));
        notifyAll();
        return http2Stream;
    }

    public final void flush() {
        this.x.flush();
    }

    public final void l(ErrorCode statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.x) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.f56662f) {
                    return;
                }
                this.f56662f = true;
                int i2 = this.f56660d;
                intRef.f53799a = i2;
                Unit unit = Unit.f53572a;
                this.x.e(i2, statusCode, Util.f56394a);
            }
        }
    }

    public final synchronized void r(long j2) {
        long j3 = this.s + j2;
        this.s = j3;
        long j4 = j3 - this.t;
        if (j4 >= this.q.a() / 2) {
            A(0, j4);
            this.t += j4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.x.f56754c);
        r6 = r2;
        r8.u += r6;
        r4 = kotlin.Unit.f53572a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(int r9, boolean r10, okio.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.x
            r12.b(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L6a
            monitor-enter(r8)
        L12:
            long r4 = r8.u     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            long r6 = r8.v     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f56658b     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            goto L12
        L2a:
            r9 = move-exception
            goto L68
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            okhttp3.internal.http2.Http2Writer r4 = r8.x     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f56754c     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.u     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.u = r4     // Catch: java.lang.Throwable -> L2a
            kotlin.Unit r4 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.x
            if (r10 == 0) goto L56
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = r3
        L57:
            r4.b(r5, r9, r11, r2)
            goto Ld
        L5b:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L68:
            monitor-exit(r8)
            throw r9
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.s(int, boolean, okio.Buffer, long):void");
    }

    public final void x(final int i2, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        final String str = this.f56659c + '[' + i2 + "] writeSynReset";
        this.f56664h.c(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$default$1
            @Override // okhttp3.internal.concurrent.Task
            public final long a() throws IOException {
                Http2Connection http2Connection = this;
                try {
                    int i3 = i2;
                    ErrorCode statusCode = errorCode;
                    http2Connection.getClass();
                    Intrinsics.checkNotNullParameter(statusCode, "statusCode");
                    http2Connection.x.s(i3, statusCode);
                    return -1L;
                } catch (IOException e2) {
                    Settings settings = Http2Connection.A;
                    http2Connection.b(e2);
                    return -1L;
                }
            }
        }, 0L);
    }
}
