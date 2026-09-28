package io.sentry;

import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class DuplicateEventDetectionEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final Map f51613a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final SentryOptions f51614b;

    public DuplicateEventDetectionEventProcessor(SentryOptions sentryOptions) {
        Objects.b(sentryOptions, "options are required");
        this.f51614b = sentryOptions;
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        SentryOptions sentryOptions = this.f51614b;
        if (!sentryOptions.isEnableDeduplication()) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Event deduplication is disabled.", new Object[0]);
            return sentryEvent;
        }
        Throwable thA = sentryEvent.a();
        if (thA == null) {
            return sentryEvent;
        }
        Map map = this.f51613a;
        if (!map.containsKey(thA)) {
            ArrayList arrayList = new ArrayList();
            for (Throwable cause = thA; cause.getCause() != null; cause = cause.getCause()) {
                arrayList.add(cause.getCause());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (map.containsKey(it.next())) {
                }
            }
            map.put(thA, null);
            return sentryEvent;
        }
        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", sentryEvent.f51791a);
        return null;
    }
}
