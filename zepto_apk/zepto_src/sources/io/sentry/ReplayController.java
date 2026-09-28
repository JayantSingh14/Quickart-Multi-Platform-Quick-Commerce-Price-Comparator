package io.sentry;

import io.sentry.react.RNSentryReplayBreadcrumbConverter;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface ReplayController {
    void b(Boolean bool);

    void c(RNSentryReplayBreadcrumbConverter rNSentryReplayBreadcrumbConverter);

    void pause();

    ReplayBreadcrumbConverter r();

    void resume();

    void start();

    void stop();
}
