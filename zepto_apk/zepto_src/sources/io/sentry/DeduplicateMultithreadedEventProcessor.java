package io.sentry;

import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.hints.EventDropReason;
import io.sentry.protocol.SentryException;
import io.sentry.util.HintUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class DeduplicateMultithreadedEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final Map f51584a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    public final SentryAndroidOptions f51585b;

    public DeduplicateMultithreadedEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        this.f51585b = sentryAndroidOptions;
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        SentryException sentryExceptionE;
        String str;
        Long l2;
        if (!UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class.isInstance(HintUtils.b(hint)) || (sentryExceptionE = sentryEvent.e()) == null || (str = sentryExceptionE.f52900a) == null || (l2 = sentryExceptionE.f52903d) == null) {
            return sentryEvent;
        }
        Map map = this.f51584a;
        Long l3 = (Long) map.get(str);
        if (l3 == null || l3.equals(l2)) {
            map.put(str, l2);
            return sentryEvent;
        }
        this.f51585b.getLogger().c(SentryLevel.INFO, "Event %s has been dropped due to multi-threaded deduplication", sentryEvent.f51791a);
        hint.c(EventDropReason.MULTITHREADED_DEDUPLICATION, "sentry:eventDropReason");
        return null;
    }
}
