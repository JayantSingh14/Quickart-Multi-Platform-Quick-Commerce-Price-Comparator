package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EventEvaluatorBase;

/* loaded from: classes3.dex */
public class GEventEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public final /* bridge */ /* synthetic */ boolean k0(Object obj) {
        return false;
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluatorBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("Empty expression");
    }
}
