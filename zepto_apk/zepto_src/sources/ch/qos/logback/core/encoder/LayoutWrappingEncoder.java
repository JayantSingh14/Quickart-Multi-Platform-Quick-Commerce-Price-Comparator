package ch.qos.logback.core.encoder;

import ch.qos.logback.core.LayoutBase;

/* loaded from: classes.dex */
public class LayoutWrappingEncoder<E> extends EncoderBase<E> {

    /* renamed from: e, reason: collision with root package name */
    public LayoutBase f13476e;

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return false;
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.f13475d = true;
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13475d = false;
    }
}
