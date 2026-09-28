package ch.qos.logback.core.net.ssl;

import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public class SSLConfigurableSocket implements SSLConfigurable {

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocket f13641a;

    public SSLConfigurableSocket(SSLSocket sSLSocket) {
        this.f13641a = sSLSocket;
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] a() {
        return this.f13641a.getSupportedProtocols();
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final void b(String[] strArr) {
        this.f13641a.setEnabledProtocols(strArr);
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] c() {
        return this.f13641a.getSupportedCipherSuites();
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] d() {
        return this.f13641a.getEnabledCipherSuites();
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final void e(String[] strArr) {
        this.f13641a.setEnabledCipherSuites(strArr);
    }

    @Override // ch.qos.logback.core.net.ssl.SSLConfigurable
    public final String[] f() {
        return this.f13641a.getEnabledProtocols();
    }
}
