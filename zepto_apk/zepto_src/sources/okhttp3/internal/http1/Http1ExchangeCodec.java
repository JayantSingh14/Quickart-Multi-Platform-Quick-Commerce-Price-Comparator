package okhttp3.internal.http1;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ForwardingTimeout;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.Timeout$Companion$NONE$1;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f56596a;

    /* renamed from: b, reason: collision with root package name */
    public final RealConnection f56597b;

    /* renamed from: c, reason: collision with root package name */
    public final RealBufferedSource f56598c;

    /* renamed from: d, reason: collision with root package name */
    public final RealBufferedSink f56599d;

    /* renamed from: e, reason: collision with root package name */
    public int f56600e;

    /* renamed from: f, reason: collision with root package name */
    public final HeadersReader f56601f;

    /* renamed from: g, reason: collision with root package name */
    public Headers f56602g;

    @Metadata
    public abstract class AbstractSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f56603a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56604b;

        public AbstractSource() {
            this.f56603a = new ForwardingTimeout(Http1ExchangeCodec.this.f56598c.f56984a.timeout());
        }

        public final void a() {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            int i2 = http1ExchangeCodec.f56600e;
            if (i2 == 6) {
                return;
            }
            if (i2 == 5) {
                Http1ExchangeCodec.i(http1ExchangeCodec, this.f56603a);
                http1ExchangeCodec.f56600e = 6;
            } else {
                throw new IllegalStateException("state: " + http1ExchangeCodec.f56600e);
            }
        }

        @Override // okio.Source
        public long read(Buffer sink, long j2) throws IOException {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return http1ExchangeCodec.f56598c.read(sink, j2);
            } catch (IOException e2) {
                http1ExchangeCodec.f56597b.k();
                a();
                throw e2;
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.f56603a;
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class ChunkedSink implements Sink {

        /* renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f56606a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56607b;

        public ChunkedSink() {
            this.f56606a = new ForwardingTimeout(Http1ExchangeCodec.this.f56599d.f56980a.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.f56607b) {
                return;
            }
            this.f56607b = true;
            Http1ExchangeCodec.this.f56599d.Y("0\r\n\r\n");
            Http1ExchangeCodec.i(Http1ExchangeCodec.this, this.f56606a);
            Http1ExchangeCodec.this.f56600e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final synchronized void flush() {
            if (this.f56607b) {
                return;
            }
            Http1ExchangeCodec.this.f56599d.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.f56606a;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j2) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f56607b) {
                throw new IllegalStateException("closed");
            }
            if (j2 == 0) {
                return;
            }
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            RealBufferedSink realBufferedSink = http1ExchangeCodec.f56599d;
            if (realBufferedSink.f56982c) {
                throw new IllegalStateException("closed");
            }
            realBufferedSink.f56981b.T1(j2);
            realBufferedSink.a();
            RealBufferedSink realBufferedSink2 = http1ExchangeCodec.f56599d;
            realBufferedSink2.Y("\r\n");
            realBufferedSink2.write(source, j2);
            realBufferedSink2.Y("\r\n");
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class ChunkedSource extends AbstractSource {

        /* renamed from: d, reason: collision with root package name */
        public final HttpUrl f56609d;

        /* renamed from: e, reason: collision with root package name */
        public long f56610e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f56611f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Http1ExchangeCodec f56612g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super();
            Intrinsics.checkNotNullParameter(url, "url");
            this.f56612g = http1ExchangeCodec;
            this.f56609d = url;
            this.f56610e = -1L;
            this.f56611f = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56604b) {
                return;
            }
            if (this.f56611f) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!Util.h(this)) {
                    this.f56612g.f56597b.k();
                    a();
                }
            }
            this.f56604b = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ad, code lost:
        
            if (r10.f56611f == false) goto L34;
         */
        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long read(okio.Buffer r11, long r12) throws java.io.IOException, java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 274
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http1.Http1ExchangeCodec.ChunkedSource.read(okio.Buffer, long):long");
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public final class FixedLengthSource extends AbstractSource {

        /* renamed from: d, reason: collision with root package name */
        public long f56613d;

        public FixedLengthSource(long j2) {
            super();
            this.f56613d = j2;
            if (j2 == 0) {
                a();
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56604b) {
                return;
            }
            if (this.f56613d != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!Util.h(this)) {
                    Http1ExchangeCodec.this.f56597b.k();
                    a();
                }
            }
            this.f56604b = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer sink, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 < 0) {
                throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
            }
            if (this.f56604b) {
                throw new IllegalStateException("closed");
            }
            long j3 = this.f56613d;
            if (j3 == 0) {
                return -1L;
            }
            long j4 = super.read(sink, Math.min(j3, j2));
            if (j4 == -1) {
                Http1ExchangeCodec.this.f56597b.k();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
            long j5 = this.f56613d - j4;
            this.f56613d = j5;
            if (j5 == 0) {
                a();
            }
            return j4;
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class KnownLengthSink implements Sink {

        /* renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f56615a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f56616b;

        public KnownLengthSink() {
            this.f56615a = new ForwardingTimeout(Http1ExchangeCodec.this.f56599d.f56980a.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56616b) {
                return;
            }
            this.f56616b = true;
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            Http1ExchangeCodec.i(http1ExchangeCodec, this.f56615a);
            http1ExchangeCodec.f56600e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            if (this.f56616b) {
                return;
            }
            Http1ExchangeCodec.this.f56599d.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.f56615a;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j2) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f56616b) {
                throw new IllegalStateException("closed");
            }
            long j3 = source.f56914b;
            byte[] bArr = Util.f56394a;
            if (j2 < 0 || 0 > j3 || j3 < j2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Http1ExchangeCodec.this.f56599d.write(source, j2);
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class UnknownLengthSource extends AbstractSource {

        /* renamed from: d, reason: collision with root package name */
        public boolean f56618d;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56604b) {
                return;
            }
            if (!this.f56618d) {
                a();
            }
            this.f56604b = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public final long read(Buffer sink, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 < 0) {
                throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
            }
            if (this.f56604b) {
                throw new IllegalStateException("closed");
            }
            if (this.f56618d) {
                return -1L;
            }
            long j3 = super.read(sink, j2);
            if (j3 != -1) {
                return j3;
            }
            this.f56618d = true;
            a();
            return -1L;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection connection, RealBufferedSource source, RealBufferedSink sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f56596a = okHttpClient;
        this.f56597b = connection;
        this.f56598c = source;
        this.f56599d = sink;
        this.f56601f = new HeadersReader(source);
    }

    public static final void i(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        http1ExchangeCodec.getClass();
        Timeout timeout = forwardingTimeout.f56951e;
        Timeout$Companion$NONE$1 delegate = Timeout.f57001d;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        forwardingTimeout.f56951e = delegate;
        timeout.a();
        timeout.b();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void a() {
        this.f56599d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.a(response)) {
            return j(0L);
        }
        if ("chunked".equalsIgnoreCase(response.b("Transfer-Encoding", null))) {
            HttpUrl httpUrl = response.f56350a.f56331a;
            if (this.f56600e == 4) {
                this.f56600e = 5;
                return new ChunkedSource(this, httpUrl);
            }
            throw new IllegalStateException(("state: " + this.f56600e).toString());
        }
        long jK = Util.k(response);
        if (jK != -1) {
            return j(jK);
        }
        if (this.f56600e == 4) {
            this.f56600e = 5;
            this.f56597b.k();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException(("state: " + this.f56600e).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final RealConnection c() {
        return this.f56597b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        Socket socket = this.f56597b.f56536c;
        if (socket != null) {
            Util.d(socket);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long d(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.a(response)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(response.b("Transfer-Encoding", null))) {
            return -1L;
        }
        return Util.k(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink e(Request request, long j2) throws ProtocolException {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = request.f56334d;
        if (requestBody != null && requestBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(request.a("Transfer-Encoding"))) {
            if (this.f56600e == 1) {
                this.f56600e = 2;
                return new ChunkedSink();
            }
            throw new IllegalStateException(("state: " + this.f56600e).toString());
        }
        if (j2 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f56600e == 1) {
            this.f56600e = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException(("state: " + this.f56600e).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void f(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Proxy.Type proxyType = this.f56597b.f56535b.f56385b.type();
        Intrinsics.checkNotNullExpressionValue(proxyType, "connection.route().proxy.type()");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.f56332b);
        sb.append(' ');
        HttpUrl httpUrl = request.f56331a;
        if (httpUrl.f56268j || proxyType != Proxy.Type.HTTP) {
            sb.append(RequestLine.a(httpUrl));
        } else {
            sb.append(httpUrl);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        l(request.f56333c, string);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder g(boolean z) throws NumberFormatException, IOException {
        HeadersReader headersReader = this.f56601f;
        int i2 = this.f56600e;
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalStateException(("state: " + this.f56600e).toString());
        }
        try {
            String strZ = headersReader.f56594a.Z(headersReader.f56595b);
            headersReader.f56595b -= strZ.length();
            StatusLine statusLineA = StatusLine.Companion.a(strZ);
            int i3 = statusLineA.f56592b;
            Response.Builder builder = new Response.Builder();
            Protocol protocol = statusLineA.f56591a;
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            builder.f56364b = protocol;
            builder.f56365c = i3;
            String message = statusLineA.f56593c;
            Intrinsics.checkNotNullParameter(message, "message");
            builder.f56366d = message;
            Headers.Builder builder2 = new Headers.Builder();
            while (true) {
                String strZ2 = headersReader.f56594a.Z(headersReader.f56595b);
                headersReader.f56595b -= strZ2.length();
                if (strZ2.length() == 0) {
                    break;
                }
                builder2.b(strZ2);
            }
            builder.c(builder2.e());
            if (z && i3 == 100) {
                return null;
            }
            if (i3 == 100) {
                this.f56600e = 3;
                return builder;
            }
            if (102 > i3 || i3 >= 200) {
                this.f56600e = 4;
                return builder;
            }
            this.f56600e = 3;
            return builder;
        } catch (EOFException e2) {
            throw new IOException(b.C("unexpected end of stream on ", this.f56597b.f56535b.f56384a.f56140i.g()), e2);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void h() {
        this.f56599d.flush();
    }

    public final Source j(long j2) {
        if (this.f56600e == 4) {
            this.f56600e = 5;
            return new FixedLengthSource(j2);
        }
        throw new IllegalStateException(("state: " + this.f56600e).toString());
    }

    public final void k(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long jK = Util.k(response);
        if (jK == -1) {
            return;
        }
        Source sourceJ = j(jK);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Util.v(sourceJ, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        ((FixedLengthSource) sourceJ).close();
    }

    public final void l(Headers headers, String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.f56600e != 0) {
            throw new IllegalStateException(("state: " + this.f56600e).toString());
        }
        RealBufferedSink realBufferedSink = this.f56599d;
        realBufferedSink.Y(requestLine);
        realBufferedSink.Y("\r\n");
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            realBufferedSink.Y(headers.f(i2));
            realBufferedSink.Y(": ");
            realBufferedSink.Y(headers.m(i2));
            realBufferedSink.Y("\r\n");
        }
        realBufferedSink.Y("\r\n");
        this.f56600e = 1;
    }
}
