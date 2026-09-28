package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public interface IScopeObserver {
    void a(Collection collection);

    void b(SpanContext spanContext, Scope scope);

    void c(User user);

    void d(Breadcrumb breadcrumb);

    void e(String str, String str2);

    void f(String str, String str2);

    void g(SentryId sentryId);

    void h(Contexts contexts);

    void i(ConcurrentHashMap concurrentHashMap);

    void j(ConcurrentHashMap concurrentHashMap);

    void k(String str);
}
