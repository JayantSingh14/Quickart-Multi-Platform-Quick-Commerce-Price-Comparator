package ch.qos.logback.core.sift;

import ch.qos.logback.core.AppenderBase;

/* loaded from: classes3.dex */
public abstract class SiftingAppenderBase<E> extends AppenderBase<E> {
    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) {
        if (this.f13415d) {
            throw null;
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("Missing discriminator. Aborting");
        throw null;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        throw null;
    }
}
