package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class ScopeObserverAdapter implements IScopeObserver {
    @Override // io.sentry.IScopeObserver
    public void a(Collection collection) {
    }

    @Override // io.sentry.IScopeObserver
    public void c(User user) {
    }

    @Override // io.sentry.IScopeObserver
    public void d(Breadcrumb breadcrumb) {
    }

    @Override // io.sentry.IScopeObserver
    public void e(String str, String str2) {
    }

    @Override // io.sentry.IScopeObserver
    public void f(String str, String str2) {
    }

    @Override // io.sentry.IScopeObserver
    public void g(SentryId sentryId) {
    }

    @Override // io.sentry.IScopeObserver
    public void h(Contexts contexts) {
    }

    @Override // io.sentry.IScopeObserver
    public void k(String str) {
    }

    @Override // io.sentry.IScopeObserver
    public void i(ConcurrentHashMap concurrentHashMap) {
    }

    @Override // io.sentry.IScopeObserver
    public void j(ConcurrentHashMap concurrentHashMap) {
    }

    @Override // io.sentry.IScopeObserver
    public void b(SpanContext spanContext, Scope scope) {
    }
}
