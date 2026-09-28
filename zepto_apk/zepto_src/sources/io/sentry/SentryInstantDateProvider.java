package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class SentryInstantDateProvider implements SentryDateProvider {
    @Override // io.sentry.SentryDateProvider
    public final SentryDate now() {
        return new SentryInstantDate();
    }
}
