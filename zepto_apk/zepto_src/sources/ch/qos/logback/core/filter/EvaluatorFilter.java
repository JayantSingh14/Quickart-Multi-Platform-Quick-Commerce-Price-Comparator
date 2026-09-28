package ch.qos.logback.core.filter;

import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes3.dex */
public class EvaluatorFilter<E> extends AbstractMatcherFilter<E> {
    @Override // ch.qos.logback.core.filter.Filter
    public final FilterReply T1(Object obj) {
        if (this.f13479d) {
            throw null;
        }
        return FilterReply.f13740b;
    }

    @Override // ch.qos.logback.core.filter.Filter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("No evaluator set for filter null");
    }
}
