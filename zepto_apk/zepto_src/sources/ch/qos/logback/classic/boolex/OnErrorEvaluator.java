package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EventEvaluatorBase;

/* loaded from: classes3.dex */
public class OnErrorEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public final boolean k0(Object obj) {
        return ((ILoggingEvent) obj).a().f13240a >= 40000;
    }
}
