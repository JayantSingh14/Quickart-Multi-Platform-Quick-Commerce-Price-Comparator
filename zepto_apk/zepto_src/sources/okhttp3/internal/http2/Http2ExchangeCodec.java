package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http2.Http2Stream;
import okio.ByteString;
import okio.Sink;
import okio.Source;

@Metadata
/* loaded from: classes.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {

    /* renamed from: g, reason: collision with root package name */
    public static final List f56709g = Util.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h, reason: collision with root package name */
    public static final List f56710h = Util.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public final RealConnection f56711a;

    /* renamed from: b, reason: collision with root package name */
    public final RealInterceptorChain f56712b;

    /* renamed from: c, reason: collision with root package name */
    public final Http2Connection f56713c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Http2Stream f56714d;

    /* renamed from: e, reason: collision with root package name */
    public final Protocol f56715e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f56716f;

    @Metadata
    public static final class Companion {
    }

    public Http2ExchangeCodec(OkHttpClient client, RealConnection connection, RealInterceptorChain chain, Http2Connection http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.f56711a = connection;
        this.f56712b = chain;
        this.f56713c = http2Connection;
        List list = client.t;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f56715e = list.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void a() throws IOException {
        Http2Stream http2Stream = this.f56714d;
        Intrinsics.c(http2Stream);
        http2Stream.f().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Http2Stream http2Stream = this.f56714d;
        Intrinsics.c(http2Stream);
        return http2Stream.f56735i;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final RealConnection c() {
        return this.f56711a;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.f56716f = true;
        Http2Stream http2Stream = this.f56714d;
        if (http2Stream != null) {
            http2Stream.e(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long d(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (HttpHeaders.a(response)) {
            return Util.k(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink e(Request request, long j2) {
        Intrinsics.checkNotNullParameter(request, "request");
        Http2Stream http2Stream = this.f56714d;
        Intrinsics.c(http2Stream);
        return http2Stream.f();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void f(Request request) throws IOException {
        int i2;
        Http2Stream http2Stream;
        boolean z = true;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.f56714d != null) {
            return;
        }
        boolean z2 = request.f56334d != null;
        Intrinsics.checkNotNullParameter(request, "request");
        Headers headers = request.f56333c;
        ArrayList requestHeaders = new ArrayList(headers.size() + 4);
        requestHeaders.add(new Header(Header.f56629f, request.f56332b));
        ByteString byteString = Header.f56630g;
        HttpUrl httpUrl = request.f56331a;
        requestHeaders.add(new Header(byteString, RequestLine.a(httpUrl)));
        String strA = request.a("Host");
        if (strA != null) {
            requestHeaders.add(new Header(Header.f56632i, strA));
        }
        requestHeaders.add(new Header(Header.f56631h, httpUrl.f56259a));
        int size = headers.size();
        for (int i3 = 0; i3 < size; i3++) {
            String strF = headers.f(i3);
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = strF.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!f56709g.contains(lowerCase) || (Intrinsics.b(lowerCase, "te") && Intrinsics.b(headers.m(i3), "trailers"))) {
                requestHeaders.add(new Header(lowerCase, headers.m(i3)));
            }
        }
        Http2Connection http2Connection = this.f56713c;
        http2Connection.getClass();
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        boolean z3 = !z2;
        synchronized (http2Connection.x) {
            synchronized (http2Connection) {
                try {
                    if (http2Connection.f56661e > 1073741823) {
                        http2Connection.l(ErrorCode.REFUSED_STREAM);
                    }
                    if (http2Connection.f56662f) {
                        throw new ConnectionShutdownException();
                    }
                    i2 = http2Connection.f56661e;
                    http2Connection.f56661e = i2 + 2;
                    http2Stream = new Http2Stream(i2, http2Connection, z3, false, null);
                    if (z2 && http2Connection.u < http2Connection.v && http2Stream.f56731e < http2Stream.f56732f) {
                        z = false;
                    }
                    if (http2Stream.h()) {
                        http2Connection.f56658b.put(Integer.valueOf(i2), http2Stream);
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            http2Connection.x.l(z3, i2, requestHeaders);
        }
        if (z) {
            http2Connection.x.flush();
        }
        this.f56714d = http2Stream;
        if (this.f56716f) {
            Http2Stream http2Stream2 = this.f56714d;
            Intrinsics.c(http2Stream2);
            http2Stream2.e(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream3 = this.f56714d;
        Intrinsics.c(http2Stream3);
        Http2Stream.StreamTimeout streamTimeout = http2Stream3.f56737k;
        long j2 = this.f56712b.f56584g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        streamTimeout.g(j2, timeUnit);
        Http2Stream http2Stream4 = this.f56714d;
        Intrinsics.c(http2Stream4);
        http2Stream4.f56738l.g(this.f56712b.f56585h, timeUnit);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder g(boolean z) throws NumberFormatException, IOException {
        Headers headerBlock;
        Http2Stream http2Stream = this.f56714d;
        if (http2Stream == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (http2Stream) {
            http2Stream.f56737k.i();
            while (http2Stream.f56733g.isEmpty() && http2Stream.f56739m == null) {
                try {
                    http2Stream.k();
                } catch (Throwable th) {
                    http2Stream.f56737k.m();
                    throw th;
                }
            }
            http2Stream.f56737k.m();
            if (http2Stream.f56733g.isEmpty()) {
                IOException iOException = http2Stream.n;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode = http2Stream.f56739m;
                Intrinsics.c(errorCode);
                throw new StreamResetException(errorCode);
            }
            Object objRemoveFirst = http2Stream.f56733g.removeFirst();
            Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "headersQueue.removeFirst()");
            headerBlock = (Headers) objRemoveFirst;
        }
        Protocol protocol = this.f56715e;
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Headers.Builder builder = new Headers.Builder();
        int size = headerBlock.size();
        StatusLine statusLineA = null;
        for (int i2 = 0; i2 < size; i2++) {
            String strF = headerBlock.f(i2);
            String strM = headerBlock.m(i2);
            if (Intrinsics.b(strF, ":status")) {
                statusLineA = StatusLine.Companion.a("HTTP/1.1 " + strM);
            } else if (!f56710h.contains(strF)) {
                builder.c(strF, strM);
            }
        }
        if (statusLineA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.Builder builder2 = new Response.Builder();
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        builder2.f56364b = protocol;
        builder2.f56365c = statusLineA.f56592b;
        String message = statusLineA.f56593c;
        Intrinsics.checkNotNullParameter(message, "message");
        builder2.f56366d = message;
        builder2.c(builder.e());
        if (z && builder2.f56365c == 100) {
            return null;
        }
        return builder2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void h() {
        this.f56713c.flush();
    }
}
