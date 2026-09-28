package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import in.juspay.hypersdk.core.Constants;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;

@SuppressSignatureCheck
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: a, reason: collision with root package name */
    public final X509TrustManager f56793a;

    /* renamed from: b, reason: collision with root package name */
    public final X509TrustManagerExtensions f56794b;

    @Metadata
    public static final class Companion {
    }

    public AndroidCertificateChainCleaner(X509TrustManager trustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f56793a = trustManager;
        this.f56794b = x509TrustManagerExtensions;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public final List a(String hostname, List chain) throws CertificateException, SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f56794b.checkServerTrusted((X509Certificate[]) chain.toArray(new X509Certificate[0]), Constants.ALG_RSA, hostname);
            Intrinsics.checkNotNullExpressionValue(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) obj).f56793a == this.f56793a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f56793a);
    }
}
