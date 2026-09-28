package ch.qos.logback.core.db;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public abstract class ConnectionSourceBase extends ContextAwareBase implements ConnectionSource {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13461d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13462e = false;

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13461d;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.f13461d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13461d = false;
    }
}
