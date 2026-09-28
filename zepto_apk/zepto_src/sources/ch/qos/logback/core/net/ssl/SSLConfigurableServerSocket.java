package ch.qos.logback.core.net.ssl;

import javax.net.ssl.SSLServerSocket;

/* loaded from: classes3.dex */
public class SSLConfigurableServerSocket implements SSLConfigurable {

    /* renamed from: a, reason: collision with root package name */
    public final SSLServerSocket f13640a;

    public SSLConfigurableServerSocket(SSLServerSocket sSLServerSocket) {
        this.f13640a = sSLServerSocket;
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] a() {
        return this.f13640a.getSupportedProtocols();
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final void b(String[] strArr) {
        this.f13640a.setEnabledProtocols(strArr);
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] c() {
        return this.f13640a.getSupportedCipherSuites();
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] d() {
        return this.f13640a.getEnabledCipherSuites();
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final void e(String[] strArr) {
        this.f13640a.setEnabledCipherSuites(strArr);
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] f() {
        return this.f13640a.getEnabledProtocols();
    }
}
