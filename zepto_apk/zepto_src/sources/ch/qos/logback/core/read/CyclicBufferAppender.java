package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.helpers.CyclicBuffer;

/* loaded from: classes3.dex */
public class CyclicBufferAppender<E> extends AppenderBase<E> {

    /* renamed from: j, reason: collision with root package name */
    public CyclicBuffer f13701j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13702k = 512;

    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) {
        if (this.f13415d) {
            this.f13701j.a(obj);
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13701j = new CyclicBuffer(this.f13702k);
        this.f13415d = true;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13701j = null;
        this.f13415d = false;
    }
}
