package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import ch.qos.logback.core.net.ssl.SSLComponent;
import ch.qos.logback.core.net.ssl.SSLConfiguration;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;

/* loaded from: classes3.dex */
public abstract class SSLServerSocketAppenderBase<E> extends AbstractServerSocketAppender<E> implements SSLComponent {
    public SSLConfiguration n;
    public ConfigurableSSLServerSocketFactory o;

    @Override // ch.qos.logback.core.net.server.AbstractServerSocketAppender
    public final ServerSocketFactory V1() {
        return this.o;
    }

    @Override // ch.qos.logback.core.net.server.AbstractServerSocketAppender, ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        try {
            if (this.n == null) {
                this.n = new SSLConfiguration();
            }
            SSLContext sSLContextA = this.n.a(this);
            if (this.n == null) {
                this.n = new SSLConfiguration();
            }
            SSLParametersConfiguration sSLParametersConfigurationD = this.n.d();
            sSLParametersConfigurationD.V(this.f13733b);
            this.o = new ConfigurableSSLServerSocketFactory(sSLParametersConfigurationD, sSLContextA.getServerSocketFactory());
            super.start();
        } catch (Exception e2) {
            o1(e2.getMessage(), e2);
        }
    }
}
