package ch.qos.logback.core.rolling;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public abstract class TimeBasedFileNamingAndTriggeringPolicyBase<E> extends ContextAwareBase implements TimeBasedFileNamingAndTriggeringPolicy<E> {
    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return false;
    }

    public void start() {
        throw null;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
    }
}
