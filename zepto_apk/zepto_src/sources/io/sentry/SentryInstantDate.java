package io.sentry;

import j$.time.Instant;

/* loaded from: classes3.dex */
public final class SentryInstantDate extends SentryDate {

    /* renamed from: a, reason: collision with root package name */
    public final Instant f51835a = Instant.now();

    @Override // io.sentry.SentryDate
    public final long d() {
        return (this.f51835a.getEpochSecond() * 1000000000) + r0.getNano();
    }
}
