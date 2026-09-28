package ch.qos.logback.core.net.ssl;

import java.net.InetAddress;
import java.net.ServerSocket;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/* loaded from: classes3.dex */
public class ConfigurableSSLServerSocketFactory extends ServerSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    public final SSLParametersConfiguration f13632a;

    /* renamed from: b, reason: collision with root package name */
    public final SSLServerSocketFactory f13633b;

    public ConfigurableSSLServerSocketFactory(SSLParametersConfiguration sSLParametersConfiguration, SSLServerSocketFactory sSLServerSocketFactory) {
        this.f13632a = sSLParametersConfiguration;
        this.f13633b = sSLServerSocketFactory;
    }

    @Override // javax.net.ServerSocketFactory
    public final ServerSocket createServerSocket(int i2, int i3, InetAddress inetAddress) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f13633b.createServerSocket(i2, i3, inetAddress);
        this.f13632a.T1(new SSLConfigurableServerSocket(sSLServerSocket));
        return sSLServerSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public final ServerSocket createServerSocket(int i2, int i3) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f13633b.createServerSocket(i2, i3);
        this.f13632a.T1(new SSLConfigurableServerSocket(sSLServerSocket));
        return sSLServerSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public final ServerSocket createServerSocket(int i2) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f13633b.createServerSocket(i2);
        this.f13632a.T1(new SSLConfigurableServerSocket(sSLServerSocket));
        return sSLServerSocket;
    }
}
