package okhttp3.internal.connection;

import android.support.v4.media.b;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Message;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* renamed from: b, reason: collision with root package name */
    public final Route f56535b;

    /* renamed from: c, reason: collision with root package name */
    public Socket f56536c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f56537d;

    /* renamed from: e, reason: collision with root package name */
    public Handshake f56538e;

    /* renamed from: f, reason: collision with root package name */
    public Protocol f56539f;

    /* renamed from: g, reason: collision with root package name */
    public Http2Connection f56540g;

    /* renamed from: h, reason: collision with root package name */
    public RealBufferedSource f56541h;

    /* renamed from: i, reason: collision with root package name */
    public RealBufferedSink f56542i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f56543j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f56544k;

    /* renamed from: l, reason: collision with root package name */
    public int f56545l;

    /* renamed from: m, reason: collision with root package name */
    public int f56546m;
    public int n;
    public int o;
    public final ArrayList p;
    public long q;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56547a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f56547a = iArr;
        }
    }

    public RealConnection(RealConnectionPool connectionPool, Route route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.f56535b = route;
        this.o = 1;
        this.p = new ArrayList();
        this.q = Long.MAX_VALUE;
    }

    public static void d(OkHttpClient client, Route failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.f56385b.type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.f56384a;
            address.f56139h.connectFailed(address.f56140i.i(), failedRoute.f56385b.address(), failure);
        }
        RouteDatabase routeDatabase = client.C;
        synchronized (routeDatabase) {
            Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
            routeDatabase.f56558a.add(failedRoute);
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final synchronized void a(Http2Connection connection, Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.o = (settings.f56764a & 16) != 0 ? settings.f56765b[4] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void b(Http2Stream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.c(ErrorCode.REFUSED_STREAM, null);
    }

    public final void c(int i2, int i3, int i4, boolean z, Call call, EventListener eventListener) throws Throwable {
        Route route;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        if (this.f56539f != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.f56535b.f56384a.f56142k;
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Address address = this.f56535b.f56384a;
        if (address.f56134c == null) {
            if (!list.contains(ConnectionSpec.f56212f)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f56535b.f56384a.f56140i.f56262d;
            Platform platform = Platform.f56791a;
            if (!Platform.f56791a.h(str)) {
                throw new RouteException(new UnknownServiceException(b.D("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (address.f56141j.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        do {
            try {
                Route route2 = this.f56535b;
                if (route2.f56384a.f56134c != null && route2.f56385b.type() == Proxy.Type.HTTP) {
                    f(i2, i3, i4, call, eventListener);
                    if (this.f56536c == null) {
                    }
                    route = this.f56535b;
                    if (route.f56384a.f56134c == null && route.f56385b.type() == Proxy.Type.HTTP && this.f56536c == null) {
                        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                    }
                    this.q = System.nanoTime();
                    return;
                }
                e(i2, i3, call, eventListener);
                g(connectionSpecSelector, call, eventListener);
                Route route3 = this.f56535b;
                eventListener.h(call, route3.f56386c, route3.f56385b, this.f56539f);
                route = this.f56535b;
                if (route.f56384a.f56134c == null) {
                }
                this.q = System.nanoTime();
                return;
            } catch (IOException e2) {
                Socket socket = this.f56537d;
                if (socket != null) {
                    Util.d(socket);
                }
                Socket socket2 = this.f56536c;
                if (socket2 != null) {
                    Util.d(socket2);
                }
                this.f56537d = null;
                this.f56536c = null;
                this.f56541h = null;
                this.f56542i = null;
                this.f56538e = null;
                this.f56539f = null;
                this.f56540g = null;
                this.o = 1;
                Route route4 = this.f56535b;
                eventListener.i(call, route4.f56386c, route4.f56385b, e2);
                if (routeException == null) {
                    routeException = new RouteException(e2);
                } else {
                    Intrinsics.checkNotNullParameter(e2, "e");
                    ExceptionsKt.a(routeException.f56559a, e2);
                    routeException.f56560b = e2;
                }
                if (!z) {
                    throw routeException;
                }
                Intrinsics.checkNotNullParameter(e2, "e");
                connectionSpecSelector.f56488d = true;
                if (!connectionSpecSelector.f56487c) {
                    throw routeException;
                }
                if (e2 instanceof ProtocolException) {
                    throw routeException;
                }
                if (e2 instanceof InterruptedIOException) {
                    throw routeException;
                }
                if ((e2 instanceof SSLHandshakeException) && (e2.getCause() instanceof CertificateException)) {
                    throw routeException;
                }
                if (e2 instanceof SSLPeerUnverifiedException) {
                    throw routeException;
                }
            }
        } while (e2 instanceof SSLException);
        throw routeException;
    }

    public final void e(int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Socket socketCreateSocket;
        Route route = this.f56535b;
        Proxy proxy = route.f56385b;
        Address address = route.f56384a;
        Proxy.Type type = proxy.type();
        int i4 = type == null ? -1 : WhenMappings.f56547a[type.ordinal()];
        if (i4 == 1 || i4 == 2) {
            socketCreateSocket = address.f56133b.createSocket();
            Intrinsics.c(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.f56536c = socketCreateSocket;
        eventListener.j(call, this.f56535b.f56386c, proxy);
        socketCreateSocket.setSoTimeout(i3);
        try {
            Platform platform = Platform.f56791a;
            Platform.f56791a.e(socketCreateSocket, this.f56535b.f56386c, i2);
            try {
                this.f56541h = Okio.d(Okio.k(socketCreateSocket));
                this.f56542i = Okio.c(Okio.g(socketCreateSocket));
            } catch (NullPointerException e2) {
                if (Intrinsics.b(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f56535b.f56386c);
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void f(int i2, int i3, int i4, Call call, EventListener eventListener) throws IOException, NumberFormatException {
        Call call2;
        EventListener eventListener2;
        int i5;
        Request.Builder builder = new Request.Builder();
        Route route = this.f56535b;
        HttpUrl url = route.f56384a.f56140i;
        Intrinsics.checkNotNullParameter(url, "url");
        builder.f56337a = url;
        builder.f("CONNECT", null);
        Address address = route.f56384a;
        builder.d("Host", Util.x(address.f56140i, true));
        builder.d("Proxy-Connection", "Keep-Alive");
        builder.d("User-Agent", "okhttp/4.12.0");
        Request request = builder.b();
        Response.Builder builder2 = new Response.Builder();
        Intrinsics.checkNotNullParameter(request, "request");
        builder2.f56363a = request;
        Protocol protocol = Protocol.HTTP_1_1;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        builder2.f56364b = protocol;
        builder2.f56365c = 407;
        Intrinsics.checkNotNullParameter("Preemptive Authenticate", APayConstants.Error.MESSAGE);
        builder2.f56366d = "Preemptive Authenticate";
        builder2.f56369g = Util.f56396c;
        builder2.f56373k = -1L;
        builder2.f56374l = -1L;
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", CLConstants.FIELD_PAY_INFO_NAME);
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", CLConstants.FIELD_PAY_INFO_VALUE);
        builder2.f56368f.h("Proxy-Authenticate", "OkHttp-Preemptive");
        Request requestA = address.f56137f.a(route, builder2.a());
        if (requestA == null) {
            i5 = i2;
            call2 = call;
            eventListener2 = eventListener;
        } else {
            request = requestA;
            call2 = call;
            eventListener2 = eventListener;
            i5 = i2;
        }
        e(i5, i3, call2, eventListener2);
        String str = "CONNECT " + Util.x(request.f56331a, true) + " HTTP/1.1";
        while (true) {
            RealBufferedSource realBufferedSource = this.f56541h;
            Intrinsics.c(realBufferedSource);
            RealBufferedSink realBufferedSink = this.f56542i;
            Intrinsics.c(realBufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, realBufferedSource, realBufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            realBufferedSource.f56984a.timeout().g(i3, timeUnit);
            realBufferedSink.f56980a.timeout().g(i4, timeUnit);
            http1ExchangeCodec.l(request.f56333c, str);
            http1ExchangeCodec.a();
            Response.Builder builderG = http1ExchangeCodec.g(false);
            Intrinsics.c(builderG);
            Intrinsics.checkNotNullParameter(request, "request");
            builderG.f56363a = request;
            Response responseA = builderG.a();
            http1ExchangeCodec.k(responseA);
            int i6 = responseA.f56353d;
            if (i6 == 200) {
                if (!realBufferedSource.f56985b.l() || !realBufferedSink.f56981b.l()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else {
                if (i6 != 407) {
                    throw new IOException(b.f(i6, "Unexpected response code for CONNECT: "));
                }
                Request requestA2 = address.f56137f.a(route, responseA);
                if (requestA2 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(responseA.b("Connection", null))) {
                    return;
                } else {
                    request = requestA2;
                }
            }
        }
    }

    public final void g(ConnectionSpecSelector connectionSpecSelector, Call call, EventListener eventListener) throws Throwable {
        Address address = this.f56535b.f56384a;
        SSLSocketFactory sSLSocketFactory = address.f56134c;
        Protocol protocolA = Protocol.HTTP_1_1;
        if (sSLSocketFactory == null) {
            List list = address.f56141j;
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(protocol)) {
                this.f56537d = this.f56536c;
                this.f56539f = protocolA;
                return;
            } else {
                this.f56537d = this.f56536c;
                this.f56539f = protocol;
                l();
                return;
            }
        }
        eventListener.C(call);
        final Address address2 = this.f56535b.f56384a;
        SSLSocketFactory sSLSocketFactory2 = address2.f56134c;
        SSLSocket sSLSocket = null;
        String strF = null;
        try {
            Intrinsics.c(sSLSocketFactory2);
            Socket socket = this.f56536c;
            HttpUrl httpUrl = address2.f56140i;
            Socket socketCreateSocket = sSLSocketFactory2.createSocket(socket, httpUrl.f56262d, httpUrl.f56263e, true);
            Intrinsics.d(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                ConnectionSpec connectionSpecA = connectionSpecSelector.a(sSLSocket2);
                if (connectionSpecA.f56214b) {
                    Platform platform = Platform.f56791a;
                    Platform.f56791a.d(sSLSocket2, address2.f56140i.f56262d, address2.f56141j);
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                final Handshake handshakeA = Handshake.Companion.a(sslSocketSession);
                HostnameVerifier hostnameVerifier = address2.f56135d;
                Intrinsics.c(hostnameVerifier);
                if (hostnameVerifier.verify(address2.f56140i.f56262d, sslSocketSession)) {
                    final CertificatePinner certificatePinner = address2.f56136e;
                    Intrinsics.c(certificatePinner);
                    this.f56538e = new Handshake(handshakeA.f56249a, handshakeA.f56250b, handshakeA.f56251c, new Function0<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            CertificateChainCleaner certificateChainCleaner = certificatePinner.f56190b;
                            Intrinsics.c(certificateChainCleaner);
                            return certificateChainCleaner.a(address2.f56140i.f56262d, handshakeA.a());
                        }
                    });
                    certificatePinner.b(address2.f56140i.f56262d, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Handshake handshake = this.f56551c.f56538e;
                            Intrinsics.c(handshake);
                            List<Certificate> listA = handshake.a();
                            ArrayList arrayList = new ArrayList(CollectionsKt.r(listA, 10));
                            for (Certificate certificate : listA) {
                                Intrinsics.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                                arrayList.add((X509Certificate) certificate);
                            }
                            return arrayList;
                        }
                    });
                    if (connectionSpecA.f56214b) {
                        Platform platform2 = Platform.f56791a;
                        strF = Platform.f56791a.f(sSLSocket2);
                    }
                    this.f56537d = sSLSocket2;
                    this.f56541h = Okio.d(Okio.k(sSLSocket2));
                    this.f56542i = Okio.c(Okio.g(sSLSocket2));
                    if (strF != null) {
                        protocolA = Protocol.Companion.a(strF);
                    }
                    this.f56539f = protocolA;
                    Platform platform3 = Platform.f56791a;
                    Platform.f56791a.a(sSLSocket2);
                    eventListener.B(call, this.f56538e);
                    if (this.f56539f == Protocol.HTTP_2) {
                        l();
                        return;
                    }
                    return;
                }
                List listA = handshakeA.a();
                if (listA.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address2.f56140i.f56262d + " not verified (no certificates)");
                }
                Object obj = listA.get(0);
                Intrinsics.d(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate certificate = (X509Certificate) obj;
                StringBuilder sb = new StringBuilder("\n              |Hostname ");
                sb.append(address2.f56140i.f56262d);
                sb.append(" not verified:\n              |    certificate: ");
                CertificatePinner certificatePinner2 = CertificatePinner.f56188c;
                sb.append(CertificatePinner.Companion.a(certificate));
                sb.append("\n              |    DN: ");
                sb.append(certificate.getSubjectDN().getName());
                sb.append("\n              |    subjectAltNames: ");
                Intrinsics.checkNotNullParameter(certificate, "certificate");
                sb.append(CollectionsKt.L(OkHostnameVerifier.a(certificate, 7), OkHostnameVerifier.a(certificate, 2)));
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(StringsKt.f0(sb.toString()));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform platform4 = Platform.f56791a;
                    Platform.f56791a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.d(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(okhttp3.Address r9, java.util.ArrayList r10) {
        /*
            r8 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            byte[] r0 = okhttp3.internal.Util.f56394a
            java.util.ArrayList r0 = r8.p
            int r0 = r0.size()
            int r1 = r8.o
            r2 = 0
            if (r0 >= r1) goto Lc7
            boolean r0 = r8.f56543j
            if (r0 == 0) goto L18
            goto Lc7
        L18:
            okhttp3.Route r0 = r8.f56535b
            okhttp3.Address r1 = r0.f56384a
            boolean r1 = r1.a(r9)
            if (r1 != 0) goto L24
            goto Lc7
        L24:
            okhttp3.HttpUrl r1 = r9.f56140i
            java.lang.String r3 = r1.f56262d
            okhttp3.Address r4 = r0.f56384a
            okhttp3.HttpUrl r5 = r4.f56140i
            java.lang.String r5 = r5.f56262d
            boolean r3 = kotlin.jvm.internal.Intrinsics.b(r3, r5)
            r5 = 1
            if (r3 == 0) goto L36
            return r5
        L36:
            okhttp3.internal.http2.Http2Connection r3 = r8.f56540g
            if (r3 != 0) goto L3c
            goto Lc7
        L3c:
            if (r10 == 0) goto Lc7
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L46
            goto Lc7
        L46:
            java.util.Iterator r10 = r10.iterator()
        L4a:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto Lc7
            java.lang.Object r3 = r10.next()
            okhttp3.Route r3 = (okhttp3.Route) r3
            java.net.Proxy r6 = r3.f56385b
            java.net.Proxy$Type r6 = r6.type()
            java.net.Proxy$Type r7 = java.net.Proxy.Type.DIRECT
            if (r6 != r7) goto L4a
            java.net.Proxy r6 = r0.f56385b
            java.net.Proxy$Type r6 = r6.type()
            if (r6 != r7) goto L4a
            java.net.InetSocketAddress r3 = r3.f56386c
            java.net.InetSocketAddress r6 = r0.f56386c
            boolean r3 = kotlin.jvm.internal.Intrinsics.b(r6, r3)
            if (r3 == 0) goto L4a
            okhttp3.internal.tls.OkHostnameVerifier r10 = okhttp3.internal.tls.OkHostnameVerifier.f56822a
            javax.net.ssl.HostnameVerifier r0 = r9.f56135d
            if (r0 == r10) goto L79
            goto Lc7
        L79:
            byte[] r10 = okhttp3.internal.Util.f56394a
            okhttp3.HttpUrl r10 = r4.f56140i
            int r0 = r10.f56263e
            int r3 = r1.f56263e
            if (r3 == r0) goto L84
            goto Lc7
        L84:
            java.lang.String r10 = r10.f56262d
            java.lang.String r0 = r1.f56262d
            boolean r10 = kotlin.jvm.internal.Intrinsics.b(r0, r10)
            if (r10 == 0) goto L8f
            goto Lb5
        L8f:
            boolean r10 = r8.f56544k
            if (r10 != 0) goto Lc7
            okhttp3.Handshake r10 = r8.f56538e
            if (r10 == 0) goto Lc7
            java.util.List r10 = r10.a()
            r1 = r10
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto Lc7
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.Intrinsics.d(r10, r1)
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            boolean r10 = okhttp3.internal.tls.OkHostnameVerifier.c(r0, r10)
            if (r10 == 0) goto Lc7
        Lb5:
            okhttp3.CertificatePinner r9 = r9.f56136e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc7
            kotlin.jvm.internal.Intrinsics.c(r9)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc7
            okhttp3.Handshake r10 = r8.f56538e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc7
            kotlin.jvm.internal.Intrinsics.c(r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc7
            java.util.List r10 = r10.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc7
            r9.a(r0, r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc7
            return r5
        Lc7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.h(okhttp3.Address, java.util.ArrayList):boolean");
    }

    public final boolean i(boolean z) throws SocketException {
        long j2;
        byte[] bArr = Util.f56394a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f56536c;
        Intrinsics.c(socket);
        Socket socket2 = this.f56537d;
        Intrinsics.c(socket2);
        RealBufferedSource source = this.f56541h;
        Intrinsics.c(source);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f56540g;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.f56662f) {
                    return false;
                }
                if (http2Connection.o < http2Connection.n) {
                    if (jNanoTime >= http2Connection.p) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j2 = jNanoTime - this.q;
        }
        if (j2 < 10000000000L || !z) {
            return true;
        }
        Intrinsics.checkNotNullParameter(socket2, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !source.a();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ExchangeCodec j(OkHttpClient client, RealInterceptorChain chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.f56537d;
        Intrinsics.c(socket);
        RealBufferedSource realBufferedSource = this.f56541h;
        Intrinsics.c(realBufferedSource);
        RealBufferedSink realBufferedSink = this.f56542i;
        Intrinsics.c(realBufferedSink);
        Http2Connection http2Connection = this.f56540g;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        int i2 = chain.f56584g;
        socket.setSoTimeout(i2);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        realBufferedSource.f56984a.timeout().g(i2, timeUnit);
        realBufferedSink.f56980a.timeout().g(chain.f56585h, timeUnit);
        return new Http1ExchangeCodec(client, this, realBufferedSource, realBufferedSink);
    }

    public final synchronized void k() {
        this.f56543j = true;
    }

    public final void l() throws SocketException {
        Socket socket = this.f56537d;
        Intrinsics.c(socket);
        RealBufferedSource source = this.f56541h;
        Intrinsics.c(source);
        RealBufferedSink sink = this.f56542i;
        Intrinsics.c(sink);
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.f56473h;
        Http2Connection.Builder builder = new Http2Connection.Builder(taskRunner);
        String peerName = this.f56535b.f56384a.f56140i.f56262d;
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(peerName, "peerName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(socket, "<set-?>");
        builder.f56700b = socket;
        String str = Util.f56400g + ' ' + peerName;
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        builder.f56701c = str;
        Intrinsics.checkNotNullParameter(source, "<set-?>");
        builder.f56702d = source;
        Intrinsics.checkNotNullParameter(sink, "<set-?>");
        builder.f56703e = sink;
        Intrinsics.checkNotNullParameter(this, "listener");
        builder.f56704f = this;
        Http2Connection http2Connection = new Http2Connection(builder);
        this.f56540g = http2Connection;
        Settings settings = Http2Connection.A;
        this.o = (settings.f56764a & 16) != 0 ? settings.f56765b[4] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Http2Writer http2Writer = http2Connection.x;
        synchronized (http2Writer) {
            try {
                if (http2Writer.f56755d) {
                    throw new IOException("closed");
                }
                Logger logger = Http2Writer.f56751f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.i(">> CONNECTION " + Http2.f56653a.e(), new Object[0]));
                }
                http2Writer.f56752a.D1(Http2.f56653a);
                http2Writer.f56752a.flush();
            } finally {
            }
        }
        Http2Writer http2Writer2 = http2Connection.x;
        Settings settings2 = http2Connection.q;
        synchronized (http2Writer2) {
            try {
                Intrinsics.checkNotNullParameter(settings2, "settings");
                if (http2Writer2.f56755d) {
                    throw new IOException("closed");
                }
                http2Writer2.c(0, Integer.bitCount(settings2.f56764a) * 6, 4, 0);
                int i2 = 0;
                while (i2 < 10) {
                    boolean z = true;
                    if (((1 << i2) & settings2.f56764a) == 0) {
                        z = false;
                    }
                    if (z) {
                        int i3 = i2 != 4 ? i2 != 7 ? i2 : 4 : 3;
                        RealBufferedSink realBufferedSink = http2Writer2.f56752a;
                        if (realBufferedSink.f56982c) {
                            throw new IllegalStateException("closed");
                        }
                        realBufferedSink.f56981b.V1(i3);
                        realBufferedSink.a();
                        http2Writer2.f56752a.b(settings2.f56765b[i2]);
                    }
                    i2++;
                }
                http2Writer2.f56752a.flush();
            } finally {
            }
        }
        if (http2Connection.q.a() != 65535) {
            http2Connection.x.x(0, r1 - Message.MAXLENGTH);
        }
        TaskQueue taskQueueE = taskRunner.e();
        final String str2 = http2Connection.f56659c;
        final Http2Connection.ReaderRunnable readerRunnable = http2Connection.y;
        taskQueueE.c(new Task(str2) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public final long a() throws Throwable {
                readerRunnable.invoke();
                return -1L;
            }
        }, 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        Route route = this.f56535b;
        sb.append(route.f56384a.f56140i.f56262d);
        sb.append(':');
        sb.append(route.f56384a.f56140i.f56263e);
        sb.append(", proxy=");
        sb.append(route.f56385b);
        sb.append(" hostAddress=");
        sb.append(route.f56386c);
        sb.append(" cipherSuite=");
        Handshake handshake = this.f56538e;
        if (handshake == null || (obj = handshake.f56250b) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f56539f);
        sb.append('}');
        return sb.toString();
    }
}
