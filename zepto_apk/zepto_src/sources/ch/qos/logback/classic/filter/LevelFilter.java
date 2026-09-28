package ch.qos.logback.classic.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes3.dex */
public class LevelFilter extends AbstractMatcherFilter<ILoggingEvent> {
    @Override // ch.qos.logback.core.filter.Filter
    public final FilterReply T1(Object obj) {
        return !this.f13479d ? FilterReply.f13740b : ((ILoggingEvent) obj).a().equals(null) ? this.f13477e : this.f13478f;
    }

    @Override // ch.qos.logback.core.filter.Filter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
    }
}
