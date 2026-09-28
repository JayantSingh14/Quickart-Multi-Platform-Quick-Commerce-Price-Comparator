package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes.dex */
public abstract class LayoutBase<E> extends ContextAwareBase implements Layout<E> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13445d;

    @Override // ch.qos.logback.core.Layout
    public String D0() {
        return null;
    }

    @Override // ch.qos.logback.core.spi.ContextAwareBase, ch.qos.logback.core.spi.ContextAware
    public final void V(Context context) {
        this.f13733b = context;
    }

    @Override // ch.qos.logback.core.Layout
    public String Z() {
        return null;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13445d;
    }

    @Override // ch.qos.logback.core.Layout
    public String j0() {
        return null;
    }

    @Override // ch.qos.logback.core.Layout
    public String j1() {
        return null;
    }

    public void start() {
        this.f13445d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13445d = false;
    }
}
