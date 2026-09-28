package okhttp3;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

@Metadata
/* loaded from: classes.dex */
public final class Address {

    /* renamed from: a, reason: collision with root package name */
    public final Dns f56132a;

    /* renamed from: b, reason: collision with root package name */
    public final SocketFactory f56133b;

    /* renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f56134c;

    /* renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f56135d;

    /* renamed from: e, reason: collision with root package name */
    public final CertificatePinner f56136e;

    /* renamed from: f, reason: collision with root package name */
    public final Authenticator f56137f;

    /* renamed from: g, reason: collision with root package name */
    public final Proxy f56138g;

    /* renamed from: h, reason: collision with root package name */
    public final ProxySelector f56139h;

    /* renamed from: i, reason: collision with root package name */
    public final HttpUrl f56140i;

    /* renamed from: j, reason: collision with root package name */
    public final List f56141j;

    /* renamed from: k, reason: collision with root package name */
    public final List f56142k;

    public Address(String host, int i2, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator proxyAuthenticator, Proxy proxy, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(host, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.f56132a = dns;
        this.f56133b = socketFactory;
        this.f56134c = sSLSocketFactory;
        this.f56135d = hostnameVerifier;
        this.f56136e = certificatePinner;
        this.f56137f = proxyAuthenticator;
        this.f56138g = proxy;
        this.f56139h = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String scheme = sSLSocketFactory != null ? "https" : "http";
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (scheme.equalsIgnoreCase("http")) {
            builder.f56269a = "http";
        } else {
            if (!scheme.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(scheme));
            }
            builder.f56269a = "https";
        }
        Intrinsics.checkNotNullParameter(host, "host");
        String strB = HostnamesKt.b(HttpUrl.Companion.e(0, 0, 7, host));
        if (strB == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(host));
        }
        builder.f56272d = strB;
        if (1 > i2 || i2 >= 65536) {
            throw new IllegalArgumentException(b.f(i2, "unexpected port: ").toString());
        }
        builder.f56273e = i2;
        this.f56140i = builder.a();
        this.f56141j = Util.y(protocols);
        this.f56142k = Util.y(connectionSpecs);
    }

    public final boolean a(Address that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.b(this.f56132a, that.f56132a) && Intrinsics.b(this.f56137f, that.f56137f) && Intrinsics.b(this.f56141j, that.f56141j) && Intrinsics.b(this.f56142k, that.f56142k) && Intrinsics.b(this.f56139h, that.f56139h) && Intrinsics.b(this.f56138g, that.f56138g) && Intrinsics.b(this.f56134c, that.f56134c) && Intrinsics.b(this.f56135d, that.f56135d) && Intrinsics.b(this.f56136e, that.f56136e) && this.f56140i.f56263e == that.f56140i.f56263e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Intrinsics.b(this.f56140i, address.f56140i) && a(address);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f56136e) + ((Objects.hashCode(this.f56135d) + ((Objects.hashCode(this.f56134c) + ((Objects.hashCode(this.f56138g) + ((this.f56139h.hashCode() + e.f(e.f((this.f56137f.hashCode() + ((this.f56132a.hashCode() + e.e(527, 31, this.f56140i.f56267i)) * 31)) * 31, 31, this.f56141j), 31, this.f56142k)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Address{");
        HttpUrl httpUrl = this.f56140i;
        sb.append(httpUrl.f56262d);
        sb.append(':');
        sb.append(httpUrl.f56263e);
        sb.append(", ");
        Proxy proxy = this.f56138g;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.f56139h;
        }
        return e.t(sb, str, '}');
    }
}
