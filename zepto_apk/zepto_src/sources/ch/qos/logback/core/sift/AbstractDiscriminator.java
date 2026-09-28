package ch.qos.logback.core.sift;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public abstract class AbstractDiscriminator<E> extends ContextAwareBase implements Discriminator<E> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13730d;

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13730d;
    }

    public void start() {
        this.f13730d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13730d = false;
    }
}
