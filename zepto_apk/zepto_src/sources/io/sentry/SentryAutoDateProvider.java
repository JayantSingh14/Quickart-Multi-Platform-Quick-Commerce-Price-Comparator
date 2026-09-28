package io.sentry;

import io.sentry.util.Platform;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class SentryAutoDateProvider implements SentryDateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final SentryDateProvider f51790a;

    public SentryAutoDateProvider() {
        if (Platform.f53129a || !Platform.f53130b) {
            this.f51790a = new SentryNanotimeDateProvider();
        } else {
            this.f51790a = new SentryInstantDateProvider();
        }
    }

    @Override // io.sentry.SentryDateProvider
    public final SentryDate now() {
        return this.f51790a.now();
    }
}
