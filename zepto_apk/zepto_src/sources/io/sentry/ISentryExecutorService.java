package io.sentry;

import java.util.concurrent.Future;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface ISentryExecutorService {
    Future a(long j2, Runnable runnable);

    void b(long j2);

    boolean isClosed();

    Future submit(Runnable runnable);
}
