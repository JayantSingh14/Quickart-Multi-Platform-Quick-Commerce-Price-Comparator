package okhttp3;

import androidx.work.impl.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final List D = Util.l(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List E = Util.l(ConnectionSpec.f56211e, ConnectionSpec.f56212f);
    public final int A;
    public final long B;
    public final RouteDatabase C;

    /* renamed from: a, reason: collision with root package name */
    public final Dispatcher f56297a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectionPool f56298b;

    /* renamed from: c, reason: collision with root package name */
    public final List f56299c;

    /* renamed from: d, reason: collision with root package name */
    public final List f56300d;

    /* renamed from: e, reason: collision with root package name */
    public final EventListener.Factory f56301e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f56302f;

    /* renamed from: g, reason: collision with root package name */
    public final Authenticator f56303g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f56304h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f56305i;

    /* renamed from: j, reason: collision with root package name */
    public final CookieJar f56306j;

    /* renamed from: k, reason: collision with root package name */
    public final Cache f56307k;

    /* renamed from: l, reason: collision with root package name */
    public final Dns f56308l;

    /* renamed from: m, reason: collision with root package name */
    public final Proxy f56309m;
    public final ProxySelector n;
    public final Authenticator o;
    public final SocketFactory p;
    public final SSLSocketFactory q;
    public final X509TrustManager r;
    public final List s;
    public final List t;
    public final OkHostnameVerifier u;
    public final CertificatePinner v;
    public final CertificateChainCleaner w;
    public final int x;
    public final int y;
    public final int z;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {
        public int A;
        public long B;
        public RouteDatabase C;

        /* renamed from: a, reason: collision with root package name */
        public Dispatcher f56310a = new Dispatcher();

        /* renamed from: b, reason: collision with root package name */
        public ConnectionPool f56311b = new ConnectionPool();

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f56312c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f56313d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public EventListener.Factory f56314e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f56315f;

        /* renamed from: g, reason: collision with root package name */
        public Authenticator f56316g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f56317h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f56318i;

        /* renamed from: j, reason: collision with root package name */
        public CookieJar f56319j;

        /* renamed from: k, reason: collision with root package name */
        public Cache f56320k;

        /* renamed from: l, reason: collision with root package name */
        public Dns f56321l;

        /* renamed from: m, reason: collision with root package name */
        public Proxy f56322m;
        public ProxySelector n;
        public Authenticator o;
        public SocketFactory p;
        public SSLSocketFactory q;
        public X509TrustManager r;
        public List s;
        public List t;
        public OkHostnameVerifier u;
        public CertificatePinner v;
        public CertificateChainCleaner w;
        public int x;
        public int y;
        public int z;

        public Builder() {
            EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = EventListener.f56243a;
            byte[] bArr = Util.f56394a;
            Intrinsics.checkNotNullParameter(eventListener$Companion$NONE$1, "<this>");
            this.f56314e = new c(eventListener$Companion$NONE$1, 11);
            this.f56315f = true;
            Authenticator authenticator = Authenticator.f56143a;
            this.f56316g = authenticator;
            this.f56317h = true;
            this.f56318i = true;
            this.f56319j = CookieJar.f56237a;
            this.f56321l = Dns.f56242a;
            this.o = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.p = socketFactory;
            this.s = OkHttpClient.E;
            this.t = OkHttpClient.D;
            this.u = OkHostnameVerifier.f56822a;
            this.v = CertificatePinner.f56188c;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 1024L;
        }

        public final void a(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.f56312c.add(interceptor);
        }

        public final void b(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.y = Util.b(j2, unit);
        }

        public final void c(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.z = Util.b(j2, unit);
        }

        public final void d(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.A = Util.b(j2, unit);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public OkHttpClient(Builder builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f56297a = builder.f56310a;
        this.f56298b = builder.f56311b;
        this.f56299c = Util.y(builder.f56312c);
        this.f56300d = Util.y(builder.f56313d);
        this.f56301e = builder.f56314e;
        this.f56302f = builder.f56315f;
        this.f56303g = builder.f56316g;
        this.f56304h = builder.f56317h;
        this.f56305i = builder.f56318i;
        this.f56306j = builder.f56319j;
        this.f56307k = builder.f56320k;
        this.f56308l = builder.f56321l;
        Proxy proxy = builder.f56322m;
        this.f56309m = proxy;
        if (proxy != null) {
            proxySelector = NullProxySelector.f56812a;
        } else {
            proxySelector = builder.n;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.f56812a;
            }
        }
        this.n = proxySelector;
        this.o = builder.o;
        this.p = builder.p;
        List list = builder.s;
        this.s = list;
        this.t = builder.t;
        this.u = builder.u;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = builder.A;
        this.B = builder.B;
        RouteDatabase routeDatabase = builder.C;
        this.C = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            this.q = null;
            this.w = null;
            this.r = null;
            this.v = CertificatePinner.f56188c;
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).f56213a) {
                    SSLSocketFactory sSLSocketFactory = builder.q;
                    if (sSLSocketFactory != null) {
                        this.q = sSLSocketFactory;
                        CertificateChainCleaner certificateChainCleaner = builder.w;
                        Intrinsics.c(certificateChainCleaner);
                        this.w = certificateChainCleaner;
                        X509TrustManager x509TrustManager = builder.r;
                        Intrinsics.c(x509TrustManager);
                        this.r = x509TrustManager;
                        CertificatePinner certificatePinner = builder.v;
                        certificatePinner.getClass();
                        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
                        this.v = Intrinsics.b(certificatePinner.f56190b, certificateChainCleaner) ? certificatePinner : new CertificatePinner(certificatePinner.f56189a, certificateChainCleaner);
                    } else {
                        Platform platform = Platform.f56791a;
                        X509TrustManager trustManager = Platform.f56791a.n();
                        this.r = trustManager;
                        this.q = Platform.f56791a.m(trustManager);
                        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
                        CertificateChainCleaner certificateChainCleaner2 = Platform.f56791a.b(trustManager);
                        this.w = certificateChainCleaner2;
                        CertificatePinner certificatePinner2 = builder.v;
                        certificatePinner2.getClass();
                        Intrinsics.checkNotNullParameter(certificateChainCleaner2, "certificateChainCleaner");
                        this.v = Intrinsics.b(certificatePinner2.f56190b, certificateChainCleaner2) ? certificatePinner2 : new CertificatePinner(certificatePinner2.f56189a, certificateChainCleaner2);
                    }
                }
            }
            this.q = null;
            this.w = null;
            this.r = null;
            this.v = CertificatePinner.f56188c;
        }
        List list3 = this.f56299c;
        Intrinsics.d(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        List list4 = this.f56300d;
        Intrinsics.d(list4, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list4.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list4).toString());
        }
        List list5 = this.s;
        boolean z = list5 instanceof Collection;
        X509TrustManager x509TrustManager2 = this.r;
        CertificateChainCleaner certificateChainCleaner3 = this.w;
        SSLSocketFactory sSLSocketFactory2 = this.q;
        if (!z || !list5.isEmpty()) {
            Iterator it2 = list5.iterator();
            while (it2.hasNext()) {
                if (((ConnectionSpec) it2.next()).f56213a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (certificateChainCleaner3 == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager2 == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (certificateChainCleaner3 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!Intrinsics.b(this.v, CertificatePinner.f56188c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    @Override // okhttp3.Call.Factory
    public final RealCall a(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public final RealWebSocket b(Request request, WebSocketListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.f56473h, request, listener, new Random(), 0, this.B);
        realWebSocket.e(this);
        return realWebSocket;
    }

    public final Builder c() {
        Intrinsics.checkNotNullParameter(this, "okHttpClient");
        Builder builder = new Builder();
        builder.f56310a = this.f56297a;
        builder.f56311b = this.f56298b;
        CollectionsKt.i(builder.f56312c, this.f56299c);
        CollectionsKt.i(builder.f56313d, this.f56300d);
        builder.f56314e = this.f56301e;
        builder.f56315f = this.f56302f;
        builder.f56316g = this.f56303g;
        builder.f56317h = this.f56304h;
        builder.f56318i = this.f56305i;
        builder.f56319j = this.f56306j;
        builder.f56320k = this.f56307k;
        builder.f56321l = this.f56308l;
        builder.f56322m = this.f56309m;
        builder.n = this.n;
        builder.o = this.o;
        builder.p = this.p;
        builder.q = this.q;
        builder.r = this.r;
        builder.s = this.s;
        builder.t = this.t;
        builder.u = this.u;
        builder.v = this.v;
        builder.w = this.w;
        builder.x = this.x;
        builder.y = this.y;
        builder.z = this.z;
        builder.A = this.A;
        builder.B = this.B;
        builder.C = this.C;
        return builder;
    }

    public final Object clone() {
        return super.clone();
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
