package ch.qos.logback.core.filter;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes.dex */
public abstract class Filter<E> extends ContextAwareBase implements LifeCycle {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13479d = false;

    public abstract FilterReply T1(Object obj);

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13479d;
    }

    public void start() {
        this.f13479d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13479d = false;
    }
}
