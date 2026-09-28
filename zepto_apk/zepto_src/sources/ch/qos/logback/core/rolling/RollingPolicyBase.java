package ch.qos.logback.core.rolling;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public abstract class RollingPolicyBase extends ContextAwareBase implements RollingPolicy {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13716d;

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13716d;
    }

    public void start() {
        this.f13716d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.f13716d = false;
    }
}
