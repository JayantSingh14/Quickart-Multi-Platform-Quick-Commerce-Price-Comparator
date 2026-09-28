package io.sentry.clientreport;

import io.sentry.util.LazyEvaluator;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
final class AtomicClientReportStorage implements IClientReportStorage {

    /* renamed from: a, reason: collision with root package name */
    public final LazyEvaluator f52711a = new LazyEvaluator(new a());
}
