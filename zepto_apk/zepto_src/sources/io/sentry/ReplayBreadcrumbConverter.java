package io.sentry;

import io.sentry.rrweb.RRWebEvent;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface ReplayBreadcrumbConverter {
    RRWebEvent a(Breadcrumb breadcrumb);
}
