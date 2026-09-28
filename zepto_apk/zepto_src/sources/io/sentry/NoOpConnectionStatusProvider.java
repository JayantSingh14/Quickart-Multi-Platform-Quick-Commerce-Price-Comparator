package io.sentry;

import io.sentry.IConnectionStatusProvider;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class NoOpConnectionStatusProvider implements IConnectionStatusProvider {
    @Override // io.sentry.IConnectionStatusProvider
    public final String a() {
        return null;
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final IConnectionStatusProvider.ConnectionStatus b() {
        return IConnectionStatusProvider.ConnectionStatus.UNKNOWN;
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final boolean c(IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
        return false;
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final void d(IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
    }
}
