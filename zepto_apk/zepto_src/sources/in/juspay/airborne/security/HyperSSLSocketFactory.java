package in.juspay.airborne.security;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import androidx.annotation.Keep;
import in.juspay.airborne.network.JuspaySSLSocketFactory;
import in.juspay.airborne.utils.OTAUtils;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class HyperSSLSocketFactory extends JuspaySSLSocketFactory {
    public static final X509TrustManager DEFAULT_TRUST_MANAGER = getDefaultTrustManager();
    private final SSLSocketFactory sslSocketFactory;

    public HyperSSLSocketFactory(Set<String> set) throws Exception {
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        X509TrustManager x509TrustManager = DEFAULT_TRUST_MANAGER;
        sSLContext.init(null, new TrustManager[]{new CustomX509TrustManager(x509TrustManager, new X509TrustManagerExtensions(x509TrustManager), set)}, new SecureRandom());
        this.sslSocketFactory = sSLContext.getSocketFactory();
    }

    private static X509TrustManager getDefaultTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        } catch (Exception unused) {
            return null;
        }
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @SuppressLint({"CustomX509TrustManager"})
    public static class CustomX509TrustManager implements X509TrustManager {
        private final Set<String> acceptedCerts;
        private final X509TrustManager defaultTrust;
        private final X509TrustManagerExtensions defaultTrustExtension;

        public CustomX509TrustManager(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions, Set<String> set) {
            this.defaultTrust = x509TrustManager;
            this.acceptedCerts = set;
            this.defaultTrustExtension = x509TrustManagerExtensions;
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.defaultTrust.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.defaultTrust.checkServerTrusted(x509CertificateArr, str);
            if (OTAUtils.validatePinning(x509CertificateArr, this.acceptedCerts)) {
                throw new CertificateException("SSL Pinning failed");
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.defaultTrust.getAcceptedIssuers();
        }

        @Keep
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            this.defaultTrustExtension.checkServerTrusted(x509CertificateArr, str, str2);
            if (OTAUtils.validatePinning(x509CertificateArr, this.acceptedCerts)) {
                throw new CertificateException("SSL Pinning failed");
            }
        }
    }
}
