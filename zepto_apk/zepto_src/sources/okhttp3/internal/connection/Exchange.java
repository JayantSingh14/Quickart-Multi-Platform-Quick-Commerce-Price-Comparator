package okhttp3.internal.connection;

import android.support.v4.media.b;
import coil3.network.internal.UtilsKt;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.EventListener;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;

@Metadata
/* loaded from: classes.dex */
public final class Exchange {

    /* renamed from: a, reason: collision with root package name */
    public final RealCall f56489a;

    /* renamed from: b, reason: collision with root package name */
    public final EventListener f56490b;

    /* renamed from: c, reason: collision with root package name */
    public final ExchangeFinder f56491c;

    /* renamed from: d, reason: collision with root package name */
    public final ExchangeCodec f56492d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f56493e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f56494f;

    /* renamed from: g, reason: collision with root package name */
    public final RealConnection f56495g;

    @Metadata
    @SourceDebugExtension
    public final class RequestBodySink extends ForwardingSink {

        /* renamed from: b, reason: collision with root package name */
        public final long f56496b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56497c;

        /* renamed from: d, reason: collision with root package name */
        public long f56498d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f56499e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Exchange f56500f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink delegate, long j2) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f56500f = exchange;
            this.f56496b = j2;
        }

        public final IOException a(IOException iOException) {
            if (this.f56497c) {
                return iOException;
            }
            this.f56497c = true;
            return this.f56500f.a(this.f56498d, false, true, iOException);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f56499e) {
                return;
            }
            this.f56499e = true;
            long j2 = this.f56496b;
            if (j2 != -1 && this.f56498d != j2) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e2) {
                throw a(e2);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw a(e2);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public final void write(Buffer source, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f56499e) {
                throw new IllegalStateException("closed");
            }
            long j3 = this.f56496b;
            if (j3 != -1 && this.f56498d + j2 > j3) {
                StringBuilder sbV = b.v(j3, "expected ", " bytes but received ");
                sbV.append(this.f56498d + j2);
                throw new ProtocolException(sbV.toString());
            }
            try {
                super.write(source, j2);
                this.f56498d += j2;
            } catch (IOException e2) {
                throw a(e2);
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class ResponseBodySource extends ForwardingSource {

        /* renamed from: a, reason: collision with root package name */
        public final long f56501a;

        /* renamed from: b, reason: collision with root package name */
        public long f56502b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56503c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f56504d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f56505e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Exchange f56506f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source delegate, long j2) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f56506f = exchange;
            this.f56501a = j2;
            this.f56503c = true;
            if (j2 == 0) {
                a(null);
            }
        }

        public final IOException a(IOException iOException) {
            if (this.f56504d) {
                return iOException;
            }
            this.f56504d = true;
            if (iOException == null && this.f56503c) {
                this.f56503c = false;
                Exchange exchange = this.f56506f;
                exchange.f56490b.w(exchange.f56489a);
            }
            return this.f56506f.a(this.f56502b, true, false, iOException);
        }

        @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f56505e) {
                return;
            }
            this.f56505e = true;
            try {
                super.close();
                a(null);
            } catch (IOException e2) {
                throw a(e2);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public final long read(Buffer sink, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.f56505e) {
                throw new IllegalStateException("closed");
            }
            try {
                long j3 = delegate().read(sink, j2);
                if (this.f56503c) {
                    this.f56503c = false;
                    Exchange exchange = this.f56506f;
                    exchange.f56490b.w(exchange.f56489a);
                }
                if (j3 == -1) {
                    a(null);
                    return -1L;
                }
                long j4 = this.f56502b + j3;
                long j5 = this.f56501a;
                if (j5 == -1 || j4 <= j5) {
                    this.f56502b = j4;
                    if (j4 == j5) {
                        a(null);
                    }
                    return j3;
                }
                throw new ProtocolException("expected " + j5 + " bytes but received " + j4);
            } catch (IOException e2) {
                throw a(e2);
            }
        }
    }

    public Exchange(RealCall call, EventListener eventListener, ExchangeFinder finder, ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.f56489a = call;
        this.f56490b = eventListener;
        this.f56491c = finder;
        this.f56492d = codec;
        this.f56495g = codec.c();
    }

    public final IOException a(long j2, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            f(iOException);
        }
        EventListener eventListener = this.f56490b;
        RealCall realCall = this.f56489a;
        if (z2) {
            if (iOException != null) {
                eventListener.s(realCall, iOException);
            } else {
                eventListener.q(realCall, j2);
            }
        }
        if (z) {
            if (iOException != null) {
                eventListener.x(realCall, iOException);
            } else {
                eventListener.v(realCall, j2);
            }
        }
        return realCall.g(this, z2, z, iOException);
    }

    public final Sink b(Request request, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f56493e = z;
        RequestBody requestBody = request.f56334d;
        Intrinsics.c(requestBody);
        long jContentLength = requestBody.contentLength();
        this.f56490b.r(this.f56489a);
        return new RequestBodySink(this, this.f56492d.e(request, jContentLength), jContentLength);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [okhttp3.internal.connection.RealConnection$newWebSocketStreams$1] */
    public final RealConnection$newWebSocketStreams$1 c() throws SocketException {
        RealCall realCall = this.f56489a;
        if (realCall.f56527k) {
            throw new IllegalStateException("Check failed.");
        }
        realCall.f56527k = true;
        realCall.f56522f.j();
        RealConnection realConnectionC = this.f56492d.c();
        realConnectionC.getClass();
        Intrinsics.checkNotNullParameter(this, "exchange");
        Socket socket = realConnectionC.f56537d;
        Intrinsics.c(socket);
        final RealBufferedSource realBufferedSource = realConnectionC.f56541h;
        Intrinsics.c(realBufferedSource);
        final RealBufferedSink realBufferedSink = realConnectionC.f56542i;
        Intrinsics.c(realBufferedSink);
        socket.setSoTimeout(0);
        realConnectionC.k();
        return new RealWebSocket.Streams(realBufferedSource, realBufferedSink) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                this.a(-1L, true, true, null);
            }
        };
    }

    public final RealResponseBody d(Response response) throws IOException {
        ExchangeCodec exchangeCodec = this.f56492d;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String strB = response.b(UtilsKt.CONTENT_TYPE, null);
            long jD = exchangeCodec.d(response);
            return new RealResponseBody(strB, jD, Okio.d(new ResponseBodySource(this, exchangeCodec.b(response), jD)));
        } catch (IOException e2) {
            this.f56490b.x(this.f56489a, e2);
            f(e2);
            throw e2;
        }
    }

    public final Response.Builder e(boolean z) throws IOException {
        try {
            Response.Builder builderG = this.f56492d.g(z);
            if (builderG != null) {
                Intrinsics.checkNotNullParameter(this, "deferredTrailers");
                builderG.f56375m = this;
            }
            return builderG;
        } catch (IOException e2) {
            this.f56490b.x(this.f56489a, e2);
            f(e2);
            throw e2;
        }
    }

    public final void f(IOException iOException) {
        this.f56494f = true;
        this.f56491c.c(iOException);
        RealConnection realConnectionC = this.f56492d.c();
        RealCall call = this.f56489a;
        synchronized (realConnectionC) {
            try {
                Intrinsics.checkNotNullParameter(call, "call");
                if (!(iOException instanceof StreamResetException)) {
                    if (!(realConnectionC.f56540g != null) || (iOException instanceof ConnectionShutdownException)) {
                        realConnectionC.f56543j = true;
                        if (realConnectionC.f56546m == 0) {
                            RealConnection.d(call.f56517a, realConnectionC.f56535b, iOException);
                            realConnectionC.f56545l++;
                        }
                    }
                } else if (((StreamResetException) iOException).f56766a == ErrorCode.REFUSED_STREAM) {
                    int i2 = realConnectionC.n + 1;
                    realConnectionC.n = i2;
                    if (i2 > 1) {
                        realConnectionC.f56543j = true;
                        realConnectionC.f56545l++;
                    }
                } else if (((StreamResetException) iOException).f56766a != ErrorCode.CANCEL || !call.p) {
                    realConnectionC.f56543j = true;
                    realConnectionC.f56545l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
