package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes3.dex */
public abstract class TurboFilter extends ContextAwareBase implements LifeCycle {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13408d = false;

    public abstract FilterReply T1(Level level, String str);

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13408d;
    }

    public void start() {
        this.f13408d = true;
    }

    public void stop() {
        this.f13408d = false;
    }
}
