package io.sentry.cache;

import com.appsflyer.internal.p;
import io.sentry.Breadcrumb;
import io.sentry.Scope;
import io.sentry.ScopeObserverAdapter;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanContext;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.cache.tape.ObjectQueue;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.LazyEvaluator;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class PersistingScopeObserver extends ScopeObserverAdapter {

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f52680c = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final SentryAndroidOptions f52681a;

    /* renamed from: b, reason: collision with root package name */
    public final LazyEvaluator f52682b = new LazyEvaluator(new a(this, 1));

    public PersistingScopeObserver(SentryAndroidOptions sentryAndroidOptions) {
        this.f52681a = sentryAndroidOptions;
    }

    public static void o(SentryOptions sentryOptions, Object obj, String str) {
        CacheUtils.d(sentryOptions, obj, ".scope-cache", str);
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void a(Collection collection) {
        if (collection.isEmpty()) {
            n(new Runnable() { // from class: io.sentry.cache.c
                @Override // java.lang.Runnable
                public final void run() {
                    Charset charset = PersistingScopeObserver.f52680c;
                    PersistingScopeObserver persistingScopeObserver = this.f52686a;
                    persistingScopeObserver.getClass();
                    try {
                        ((ObjectQueue) persistingScopeObserver.f52682b.a()).clear();
                    } catch (IOException e2) {
                        persistingScopeObserver.f52681a.getLogger().b(SentryLevel.ERROR, "Failed to clear breadcrumbs from file queue", e2);
                    }
                }
            });
        }
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void b(SpanContext spanContext, Scope scope) {
        n(new p(this, spanContext, scope, 3));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void c(User user) {
        n(new in.juspay.hypernfc.b(24, this, user));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void d(Breadcrumb breadcrumb) {
        n(new androidx.media3.common.util.c(6, this, breadcrumb));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void g(SentryId sentryId) {
        n(new in.juspay.hypernfc.b(25, this, sentryId));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void h(Contexts contexts) {
        n(new androidx.media3.common.util.c(10, this, contexts));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void i(ConcurrentHashMap concurrentHashMap) {
        n(new in.juspay.hypernfc.b(26, this, concurrentHashMap));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void j(ConcurrentHashMap concurrentHashMap) {
        n(new androidx.media3.common.util.c(9, this, concurrentHashMap));
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void k(String str) {
        n(new androidx.media3.common.util.c(7, this, str));
    }

    public final void l(String str) {
        CacheUtils.a(this.f52681a, ".scope-cache", str);
    }

    public final Object m(SentryOptions sentryOptions, String str, Class cls) {
        if (!str.equals("breadcrumbs.json")) {
            return CacheUtils.c(sentryOptions, ".scope-cache", str, cls);
        }
        try {
            ObjectQueue objectQueue = (ObjectQueue) this.f52682b.a();
            int iMin = Math.min(objectQueue.size(), objectQueue.size());
            ArrayList arrayList = new ArrayList(iMin);
            Iterator<T> it = objectQueue.iterator();
            for (int i2 = 0; i2 < iMin; i2++) {
                arrayList.add(it.next());
            }
            return cls.cast(Collections.unmodifiableList(arrayList));
        } catch (IOException unused) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "Unable to read serialized breadcrumbs from QueueFile", new Object[0]);
            return null;
        }
    }

    public final void n(Runnable runnable) {
        SentryAndroidOptions sentryAndroidOptions = this.f52681a;
        if (sentryAndroidOptions.isEnableScopePersistence()) {
            if (Thread.currentThread().getName().contains("SentryExecutor")) {
                try {
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Serialization task failed", th);
                    return;
                }
            }
            try {
                sentryAndroidOptions.getExecutorService().submit(new androidx.media3.common.util.c(8, this, runnable));
            } catch (Throwable th2) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Serialization task could not be scheduled", th2);
            }
        }
    }

    public final void p(Object obj, String str) {
        o(this.f52681a, obj, str);
    }
}
