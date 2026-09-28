package ch.qos.logback.core.encoder;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes.dex */
public abstract class EncoderBase<E> extends ContextAwareBase implements Encoder<E> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13475d;

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.f13475d;
    }

    public void start() {
        this.f13475d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.f13475d = false;
    }
}
