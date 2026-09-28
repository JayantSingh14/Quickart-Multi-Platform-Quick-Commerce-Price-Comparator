package ch.qos.logback.core.net.ssl;

/* loaded from: classes3.dex */
public class SSLConfiguration extends SSLContextFactoryBean {

    /* renamed from: c, reason: collision with root package name */
    public SSLParametersConfiguration f13642c;

    public final SSLParametersConfiguration d() {
        if (this.f13642c == null) {
            this.f13642c = new SSLParametersConfiguration();
        }
        return this.f13642c;
    }
}
