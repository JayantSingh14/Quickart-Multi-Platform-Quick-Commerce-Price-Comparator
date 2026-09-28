package ch.qos.logback.core.boolex;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes3.dex */
public class Matcher extends ContextAwareBase implements LifeCycle {
    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return false;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("All Matcher objects must be named");
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
    }
}
