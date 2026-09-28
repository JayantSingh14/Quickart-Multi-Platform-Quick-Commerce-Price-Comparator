package ch.qos.logback.core.net.ssl;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class ConfigurableSSLSocketFactory extends SocketFactory {

    /* renamed from: a, reason: collision with root package name */
    public final SSLParametersConfiguration f13634a;

    /* renamed from: b, reason: collision with root package name */
    public final SSLSocketFactory f13635b;

    public ConfigurableSSLSocketFactory(SSLParametersConfiguration sSLParametersConfiguration, SSLSocketFactory sSLSocketFactory) {
        this.f13634a = sSLParametersConfiguration;
        this.f13635b = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        SSLSocket sSLSocket = (SSLSocket) this.f13635b.createSocket(inetAddress, i2, inetAddress2, i3);
        this.f13634a.T1(new SSLConfigurableSocket(sSLSocket));
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f13635b.createSocket(inetAddress, i2);
        this.f13634a.T1(new SSLConfigurableSocket(sSLSocket));
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        SSLSocket sSLSocket = (SSLSocket) this.f13635b.createSocket(str, i2, inetAddress, i3);
        this.f13634a.T1(new SSLConfigurableSocket(sSLSocket));
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f13635b.createSocket(str, i2);
        this.f13634a.T1(new SSLConfigurableSocket(sSLSocket));
        return sSLSocket;
    }
}
