package ch.qos.logback.classic.net.server;

import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import ch.qos.logback.core.net.ssl.SSLComponent;
import ch.qos.logback.core.net.ssl.SSLConfiguration;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;

/* loaded from: classes3.dex */
public class SSLServerSocketReceiver extends ServerSocketReceiver implements SSLComponent {

    /* renamed from: h, reason: collision with root package name */
    public SSLConfiguration f13305h;

    /* renamed from: i, reason: collision with root package name */
    public ConfigurableSSLServerSocketFactory f13306i;

    @Override // ch.qos.logback.classic.net.server.ServerSocketReceiver
    public final ServerSocketFactory W1() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, KeyManagementException, NoSuchProviderException {
        if (this.f13306i == null) {
            if (this.f13305h == null) {
                this.f13305h = new SSLConfiguration();
            }
            SSLContext sSLContextA = this.f13305h.a(this);
            if (this.f13305h == null) {
                this.f13305h = new SSLConfiguration();
            }
            SSLParametersConfiguration sSLParametersConfigurationD = this.f13305h.d();
            sSLParametersConfigurationD.V(this.f13733b);
            this.f13306i = new ConfigurableSSLServerSocketFactory(sSLParametersConfigurationD, sSLContextA.getServerSocketFactory());
        }
        return this.f13306i;
    }
}
