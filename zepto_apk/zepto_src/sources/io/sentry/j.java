package io.sentry;

import io.sentry.Scope;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.util.LazyEvaluator;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Scope.IWithSession, LazyEvaluator.Evaluator {
    @Override // io.sentry.util.LazyEvaluator.Evaluator
    public Object a() {
        return new LocalMetricsAggregator();
    }

    @Override // io.sentry.Scope.IWithSession
    public void b(Session session) {
    }
}
