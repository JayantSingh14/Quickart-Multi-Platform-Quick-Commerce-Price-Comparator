package okhttp3.logging;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealCall;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata
/* loaded from: classes3.dex */
public final class LoggingEventListener extends EventListener {

    /* renamed from: b, reason: collision with root package name */
    public final HttpLoggingInterceptor.Logger f56895b;

    /* renamed from: c, reason: collision with root package name */
    public long f56896c;

    @Metadata
    public static class Factory implements EventListener.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final HttpLoggingInterceptor.Logger f56897a;

        @JvmOverloads
        public Factory() {
            HttpLoggingInterceptor.Logger logger = HttpLoggingInterceptor.Logger.f56894a;
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.f56897a = logger;
        }

        @Override // okhttp3.EventListener.Factory
        public final EventListener d(RealCall call) {
            Intrinsics.checkNotNullParameter(call, "call");
            return new LoggingEventListener(this.f56897a);
        }
    }

    public LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.f56895b = logger;
    }

    @Override // okhttp3.EventListener
    public final void A(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        D("satisfactionFailure: " + response);
    }

    @Override // okhttp3.EventListener
    public final void B(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("secureConnectEnd: " + handshake);
    }

    @Override // okhttp3.EventListener
    public final void C(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("secureConnectStart");
    }

    public final void D(String str) {
        this.f56895b.a("[" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.f56896c) + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public final void a(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
        D("cacheConditionalHit: " + cachedResponse);
    }

    @Override // okhttp3.EventListener
    public final void b(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        D("cacheHit: " + response);
    }

    @Override // okhttp3.EventListener
    public final void c(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("cacheMiss");
    }

    @Override // okhttp3.EventListener
    public final void d(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("callEnd");
    }

    @Override // okhttp3.EventListener
    public final void e(RealCall call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("callFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public final void f(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f56896c = System.nanoTime();
        D("callStart: " + call.f56518b);
    }

    @Override // okhttp3.EventListener
    public final void g(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("canceled");
    }

    @Override // okhttp3.EventListener
    public final void h(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        D("connectEnd: " + protocol);
    }

    @Override // okhttp3.EventListener
    public final void i(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("connectFailed: null " + ioe);
    }

    @Override // okhttp3.EventListener
    public final void j(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        D("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    @Override // okhttp3.EventListener
    public final void k(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        D("connectionAcquired: " + connection);
    }

    @Override // okhttp3.EventListener
    public final void l(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        D("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public final void m(Call call, String domainName, List inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
        D("dnsEnd: " + inetAddressList);
    }

    @Override // okhttp3.EventListener
    public final void n(String domainName, Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        D("dnsStart: ".concat(domainName));
    }

    @Override // okhttp3.EventListener
    public final void o(Call call, HttpUrl url, List proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
        D("proxySelectEnd: " + proxies);
    }

    @Override // okhttp3.EventListener
    public final void p(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        D("proxySelectStart: " + url);
    }

    @Override // okhttp3.EventListener
    public final void q(Call call, long j2) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("requestBodyEnd: byteCount=" + j2);
    }

    @Override // okhttp3.EventListener
    public final void r(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public final void s(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("requestFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public final void t(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
        D("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public final void u(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public final void v(Call call, long j2) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("responseBodyEnd: byteCount=" + j2);
    }

    @Override // okhttp3.EventListener
    public final void w(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public final void x(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("responseFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public final void y(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        D("responseHeadersEnd: " + response);
    }

    @Override // okhttp3.EventListener
    public final void z(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("responseHeadersStart");
    }
}
