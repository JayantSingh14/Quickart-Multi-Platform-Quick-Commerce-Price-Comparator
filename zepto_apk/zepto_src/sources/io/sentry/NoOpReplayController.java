package io.sentry;

import io.sentry.react.RNSentryReplayBreadcrumbConverter;

/* loaded from: classes.dex */
public final class NoOpReplayController implements ReplayController {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpReplayController f51709a = new NoOpReplayController();

    @Override // io.sentry.ReplayController
    public final void b(Boolean bool) {
    }

    @Override // io.sentry.ReplayController
    public final void pause() {
    }

    @Override // io.sentry.ReplayController
    public final ReplayBreadcrumbConverter r() {
        return NoOpReplayBreadcrumbConverter.f51708a;
    }

    @Override // io.sentry.ReplayController
    public final void resume() {
    }

    @Override // io.sentry.ReplayController
    public final void start() {
    }

    @Override // io.sentry.ReplayController
    public final void stop() {
    }

    @Override // io.sentry.ReplayController
    public final void c(RNSentryReplayBreadcrumbConverter rNSentryReplayBreadcrumbConverter) {
    }
}
