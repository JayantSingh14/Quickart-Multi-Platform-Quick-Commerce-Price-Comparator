package io.sentry;

import io.sentry.rrweb.RRWebEvent;

/* loaded from: classes.dex */
public final class NoOpReplayBreadcrumbConverter implements ReplayBreadcrumbConverter {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpReplayBreadcrumbConverter f51708a = new NoOpReplayBreadcrumbConverter();

    @Override // io.sentry.ReplayBreadcrumbConverter
    public final RRWebEvent a(Breadcrumb breadcrumb) {
        return null;
    }
}
