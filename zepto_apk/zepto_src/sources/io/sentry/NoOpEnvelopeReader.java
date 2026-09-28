package io.sentry;

import java.io.InputStream;

/* loaded from: classes3.dex */
public final class NoOpEnvelopeReader implements IEnvelopeReader {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpEnvelopeReader f51704a = new NoOpEnvelopeReader();

    @Override // io.sentry.IEnvelopeReader
    public final SentryEnvelope a(InputStream inputStream) {
        return null;
    }
}
