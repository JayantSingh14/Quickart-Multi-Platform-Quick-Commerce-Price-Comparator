package ch.qos.logback.core.db;

import ch.qos.logback.core.UnsynchronizedAppenderBase;

/* loaded from: classes3.dex */
public abstract class DBAppenderBase<E> extends UnsynchronizedAppenderBase<E> {
    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public final void T1(Object obj) {
        try {
            throw null;
        } catch (Throwable th) {
            o1("problem appending event", th);
        }
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        throw new IllegalStateException("DBAppender cannot function without a connection source");
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13451d = false;
    }
}
