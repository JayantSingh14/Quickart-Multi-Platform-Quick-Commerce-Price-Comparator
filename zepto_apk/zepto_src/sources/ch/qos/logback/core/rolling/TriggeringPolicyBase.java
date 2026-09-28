package ch.qos.logback.core.rolling;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public abstract class TriggeringPolicyBase<E> extends ContextAwareBase implements TriggeringPolicy<E> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13721d;

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13721d;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13721d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13721d = false;
    }
}
