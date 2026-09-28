package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ConnectionSpec {

    /* renamed from: e, reason: collision with root package name */
    public static final ConnectionSpec f56211e;

    /* renamed from: f, reason: collision with root package name */
    public static final ConnectionSpec f56212f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56213a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f56214b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f56215c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f56216d;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f56217a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f56218b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f56219c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f56220d;

        public Builder(boolean z) {
            this.f56217a = z;
        }

        public final ConnectionSpec a() {
            return new ConnectionSpec(this.f56217a, this.f56220d, this.f56218b, this.f56219c);
        }

        public final void b(String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.f56217a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if (cipherSuites.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f56218b = (String[]) cipherSuites.clone();
        }

        public final void c(CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.f56217a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (CipherSuite cipherSuite : cipherSuites) {
                arrayList.add(cipherSuite.f56209a);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            b((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final void d(String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!this.f56217a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if (tlsVersions.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f56219c = (String[]) tlsVersions.clone();
        }

        public final void e(TlsVersion... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!this.f56217a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (TlsVersion tlsVersion : tlsVersions) {
                arrayList.add(tlsVersion.f56393a);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            d((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    @Metadata
    public static final class Companion {
    }

    static {
        CipherSuite cipherSuite = CipherSuite.r;
        CipherSuite cipherSuite2 = CipherSuite.s;
        CipherSuite cipherSuite3 = CipherSuite.t;
        CipherSuite cipherSuite4 = CipherSuite.f56207l;
        CipherSuite cipherSuite5 = CipherSuite.n;
        CipherSuite cipherSuite6 = CipherSuite.f56208m;
        CipherSuite cipherSuite7 = CipherSuite.o;
        CipherSuite cipherSuite8 = CipherSuite.q;
        CipherSuite cipherSuite9 = CipherSuite.p;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.f56205j, CipherSuite.f56206k, CipherSuite.f56203h, CipherSuite.f56204i, CipherSuite.f56201f, CipherSuite.f56202g, CipherSuite.f56200e};
        Builder builder = new Builder(true);
        builder.c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        builder.e(tlsVersion, tlsVersion2);
        if (!builder.f56217a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        builder.f56220d = true;
        builder.a();
        Builder builder2 = new Builder(true);
        builder2.c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, 16));
        builder2.e(tlsVersion, tlsVersion2);
        if (!builder2.f56217a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        builder2.f56220d = true;
        f56211e = builder2.a();
        Builder builder3 = new Builder(true);
        builder3.c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, 16));
        builder3.e(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        if (!builder3.f56217a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        builder3.f56220d = true;
        builder3.a();
        f56212f = new Builder(false).a();
    }

    public ConnectionSpec(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f56213a = z;
        this.f56214b = z2;
        this.f56215c = strArr;
        this.f56216d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f56215c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.f56197b.b(str));
        }
        return CollectionsKt.e0(arrayList);
    }

    public final boolean b(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.f56213a) {
            return false;
        }
        String[] strArr = this.f56216d;
        if (strArr != null && !Util.j(strArr, socket.getEnabledProtocols(), ComparisonsKt.c())) {
            return false;
        }
        String[] strArr2 = this.f56215c;
        return strArr2 == null || Util.j(strArr2, socket.getEnabledCipherSuites(), CipherSuite.f56198c);
    }

    public final List c() {
        String[] strArr = this.f56216d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.Companion.a(str));
        }
        return CollectionsKt.e0(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = connectionSpec.f56213a;
        boolean z2 = this.f56213a;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.f56215c, connectionSpec.f56215c) && Arrays.equals(this.f56216d, connectionSpec.f56216d) && this.f56214b == connectionSpec.f56214b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f56213a) {
            return 17;
        }
        String[] strArr = this.f56215c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f56216d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f56214b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f56213a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f56214b + ')';
    }
}
