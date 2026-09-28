package ch.qos.logback.classic.net;

import ch.qos.logback.core.net.ssl.ConfigurableSSLSocketFactory;
import ch.qos.logback.core.net.ssl.SSLComponent;
import ch.qos.logback.core.net.ssl.SSLConfiguration;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;

/* loaded from: classes3.dex */
public class SSLSocketReceiver extends SocketReceiver implements SSLComponent {

    /* renamed from: i, reason: collision with root package name */
    public SSLConfiguration f13295i;

    /* renamed from: j, reason: collision with root package name */
    public ConfigurableSSLSocketFactory f13296j;

    @Override // ch.qos.logback.classic.net.SocketReceiver, ch.qos.logback.classic.net.ReceiverBase
    public final boolean V1() {
        try {
            if (this.f13295i == null) {
                this.f13295i = new SSLConfiguration();
            }
            SSLContext sSLContextA = this.f13295i.a(this);
            if (this.f13295i == null) {
                this.f13295i = new SSLConfiguration();
            }
            SSLParametersConfiguration sSLParametersConfigurationD = this.f13295i.d();
            sSLParametersConfigurationD.V(this.f13733b);
            this.f13296j = new ConfigurableSSLSocketFactory(sSLParametersConfigurationD, sSLContextA.getSocketFactory());
            super.V1();
            return false;
        } catch (Exception e2) {
            o1(e2.getMessage(), e2);
            return false;
        }
    }

    @Override // ch.qos.logback.classic.net.SocketReceiver
    public final SocketFactory X1() {
        return this.f13296j;
    }
}
