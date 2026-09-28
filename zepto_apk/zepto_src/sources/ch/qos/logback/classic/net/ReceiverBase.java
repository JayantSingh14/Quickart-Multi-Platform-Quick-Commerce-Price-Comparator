package ch.qos.logback.classic.net;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes3.dex */
public abstract class ReceiverBase extends ContextAwareBase implements LifeCycle {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13294d;

    public abstract Runnable T1();

    public abstract void U1();

    public abstract boolean V1();

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13294d;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        if (this.f13294d) {
            return;
        }
        if (this.f13733b == null) {
            throw new IllegalStateException("context not set");
        }
        if (V1()) {
            this.f13733b.T().execute(T1());
            this.f13294d = true;
        }
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        if (this.f13294d) {
            try {
                U1();
            } catch (RuntimeException e2) {
                o1("on stop: " + e2, e2);
            }
            this.f13294d = false;
        }
    }
}
