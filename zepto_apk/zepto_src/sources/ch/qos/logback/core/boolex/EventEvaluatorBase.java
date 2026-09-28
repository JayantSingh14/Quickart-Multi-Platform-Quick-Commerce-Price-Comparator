package ch.qos.logback.core.boolex;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public abstract class EventEvaluatorBase<E> extends ContextAwareBase implements EventEvaluator<E> {

    /* renamed from: d, reason: collision with root package name */
    public String f13457d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13458e;

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public final void a(String str) {
        if (this.f13457d != null) {
            throw new IllegalStateException("name has been already set");
        }
        this.f13457d = str;
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public final String getName() {
        return this.f13457d;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13458e;
    }

    public void start() {
        this.f13458e = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13458e = false;
    }
}
