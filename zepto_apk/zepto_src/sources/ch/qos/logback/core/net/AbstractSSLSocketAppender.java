package ch.qos.logback.core.net;

import ch.qos.logback.core.net.ssl.ConfigurableSSLSocketFactory;
import ch.qos.logback.core.net.ssl.SSLComponent;
import ch.qos.logback.core.net.ssl.SSLConfiguration;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;

/* loaded from: classes3.dex */
public abstract class AbstractSSLSocketAppender<E> extends AbstractSocketAppender<E> implements SSLComponent {
    public SSLConfiguration x;
    public ConfigurableSSLSocketFactory y;

    @Override // ch.qos.logback.core.net.AbstractSocketAppender
    public final SocketFactory X1() {
        return this.y;
    }

    @Override // ch.qos.logback.core.net.AbstractSocketAppender, ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        try {
            if (this.x == null) {
                this.x = new SSLConfiguration();
            }
            SSLContext sSLContextA = this.x.a(this);
            if (this.x == null) {
                this.x = new SSLConfiguration();
            }
            SSLParametersConfiguration sSLParametersConfigurationD = this.x.d();
            sSLParametersConfigurationD.V(this.f13733b);
            this.y = new ConfigurableSSLSocketFactory(sSLParametersConfigurationD, sSLContextA.getSocketFactory());
            super.start();
        } catch (Exception e2) {
            o1(e2.getMessage(), e2);
        }
    }
}
