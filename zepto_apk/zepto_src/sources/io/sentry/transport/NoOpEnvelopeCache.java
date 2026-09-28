package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import io.sentry.cache.IEnvelopeCache;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class NoOpEnvelopeCache implements IEnvelopeCache {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpEnvelopeCache f53097a = new NoOpEnvelopeCache();

    @Override // java.lang.Iterable
    public final Iterator<SentryEnvelope> iterator() {
        return Collections.emptyIterator();
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public final void v0(SentryEnvelope sentryEnvelope, Hint hint) {
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public final void x(SentryEnvelope sentryEnvelope) {
    }
}
