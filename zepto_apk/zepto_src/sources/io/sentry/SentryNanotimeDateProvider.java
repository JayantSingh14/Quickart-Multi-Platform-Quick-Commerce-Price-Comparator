package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryNanotimeDateProvider implements SentryDateProvider {
    @Override // io.sentry.SentryDateProvider
    public final SentryDate now() {
        return new SentryNanotimeDate();
    }
}
