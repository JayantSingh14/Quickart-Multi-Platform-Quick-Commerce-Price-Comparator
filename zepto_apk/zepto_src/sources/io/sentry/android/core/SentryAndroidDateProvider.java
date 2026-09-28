package io.sentry.android.core;

import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;
import io.sentry.SentryNanotimeDate;
import io.sentry.SentryNanotimeDateProvider;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryAndroidDateProvider implements SentryDateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final SentryNanotimeDateProvider f52195a = new SentryNanotimeDateProvider();

    @Override // io.sentry.SentryDateProvider
    public final SentryDate now() {
        this.f52195a.getClass();
        return new SentryNanotimeDate();
    }
}
