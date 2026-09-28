package ch.qos.logback.classic.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes3.dex */
public class ThresholdFilter extends Filter<ILoggingEvent> {
    @Override // ch.qos.logback.core.filter.Filter
    public final FilterReply T1(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        if (!this.f13479d) {
            return FilterReply.f13740b;
        }
        int i2 = iLoggingEvent.a().f13240a;
        throw null;
    }

    @Override // ch.qos.logback.core.filter.Filter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
    }
}
