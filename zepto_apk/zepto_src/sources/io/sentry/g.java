package io.sentry;

import io.sentry.JsonObjectDeserializer;
import io.sentry.util.LazyEvaluator;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements JsonObjectDeserializer.NextValue, LazyEvaluator.Evaluator {
    @Override // io.sentry.util.LazyEvaluator.Evaluator
    public Object a() {
        String str = SentryOptions.DEFAULT_PROPAGATION_TARGETS;
        return new SentryAutoDateProvider();
    }

    @Override // io.sentry.JsonObjectDeserializer.NextValue
    public Object b() {
        return null;
    }
}
