package okhttp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealCall;

@Metadata
/* loaded from: classes.dex */
public abstract class EventListener {

    /* renamed from: a, reason: collision with root package name */
    public static final EventListener$Companion$NONE$1 f56243a = new EventListener$Companion$NONE$1();

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface Factory {
        EventListener d(RealCall realCall);
    }

    public void A(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void B(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void C(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void a(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
    }

    public void b(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void c(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void d(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void e(RealCall call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void f(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void g(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void h(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void i(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void j(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void k(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void l(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void m(Call call, String domainName, List inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
    }

    public void n(String domainName, Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
    }

    public void o(Call call, HttpUrl url, List proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
    }

    public void p(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void q(Call call, long j2) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void r(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void s(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void t(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    public void u(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void v(Call call, long j2) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void w(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void x(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void y(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void z(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }
}
