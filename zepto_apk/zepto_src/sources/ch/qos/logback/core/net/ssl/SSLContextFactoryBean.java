package ch.qos.logback.core.net.ssl;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes3.dex */
public class SSLContextFactoryBean {

    /* renamed from: a, reason: collision with root package name */
    public KeyStoreFactoryBean f13643a;

    /* renamed from: b, reason: collision with root package name */
    public KeyStoreFactoryBean f13644b;

    public static KeyStoreFactoryBean c(String str) {
        if (System.getProperty(str) == null) {
            return null;
        }
        KeyStoreFactoryBean keyStoreFactoryBean = new KeyStoreFactoryBean();
        String property = System.getProperty(str);
        if (property != null && !property.startsWith("file:")) {
            property = "file:".concat(property);
        }
        keyStoreFactoryBean.f13636a = property;
        keyStoreFactoryBean.f13637b = System.getProperty(str.concat("Provider"));
        keyStoreFactoryBean.f13639d = System.getProperty(str.concat("Password"));
        keyStoreFactoryBean.f13638c = System.getProperty(str.concat("Type"));
        return keyStoreFactoryBean;
    }

    public final SSLContext a(ContextAwareBase contextAwareBase) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, KeyManagementException, NoSuchProviderException {
        KeyManager[] keyManagers;
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        contextAwareBase.s1("SSL protocol '" + sSLContext.getProtocol() + "' provider '" + sSLContext.getProvider() + "'");
        TrustManager[] trustManagers = null;
        if (b() == null) {
            keyManagers = null;
        } else {
            KeyStore keyStoreA = b().a();
            contextAwareBase.s1("key store of type '" + keyStoreA.getType() + "' provider '" + keyStoreA.getProvider() + "': " + b().f13636a);
            new KeyManagerFactoryFactoryBean();
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            contextAwareBase.s1("key manager algorithm '" + keyManagerFactory.getAlgorithm() + "' provider '" + keyManagerFactory.getProvider() + "'");
            String str = b().f13639d;
            if (str == null) {
                str = "changeit";
            }
            keyManagerFactory.init(keyStoreA, str.toCharArray());
            keyManagers = keyManagerFactory.getKeyManagers();
        }
        if (this.f13644b == null) {
            this.f13644b = c("javax.net.ssl.trustStore");
        }
        KeyStoreFactoryBean keyStoreFactoryBean = this.f13644b;
        if (keyStoreFactoryBean != null) {
            if (keyStoreFactoryBean == null) {
                this.f13644b = c("javax.net.ssl.trustStore");
            }
            KeyStore keyStoreA2 = this.f13644b.a();
            StringBuilder sb = new StringBuilder("trust store of type '");
            sb.append(keyStoreA2.getType());
            sb.append("' provider '");
            sb.append(keyStoreA2.getProvider());
            sb.append("': ");
            if (this.f13644b == null) {
                this.f13644b = c("javax.net.ssl.trustStore");
            }
            sb.append(this.f13644b.f13636a);
            contextAwareBase.s1(sb.toString());
            new TrustManagerFactoryFactoryBean();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            contextAwareBase.s1("trust manager algorithm '" + trustManagerFactory.getAlgorithm() + "' provider '" + trustManagerFactory.getProvider() + "'");
            trustManagerFactory.init(keyStoreA2);
            trustManagers = trustManagerFactory.getTrustManagers();
        }
        new SecureRandomFactoryBean();
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            contextAwareBase.s1("secure random algorithm '" + secureRandom.getAlgorithm() + "' provider '" + secureRandom.getProvider() + "'");
            sSLContext.init(keyManagers, trustManagers, secureRandom);
            return sSLContext;
        } catch (NoSuchAlgorithmException unused) {
            throw new NoSuchAlgorithmException("no such secure random algorithm: SHA1PRNG");
        } catch (NoSuchProviderException unused2) {
            throw new NoSuchProviderException("no such secure random provider: null");
        }
    }

    public final KeyStoreFactoryBean b() {
        if (this.f13643a == null) {
            this.f13643a = c("javax.net.ssl.keyStore");
        }
        return this.f13643a;
    }
}
