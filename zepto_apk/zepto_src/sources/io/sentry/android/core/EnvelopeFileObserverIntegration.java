package io.sentry.android.core;

import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.OutboxSender;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class EnvelopeFileObserverIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public EnvelopeFileObserver f52138a;

    /* renamed from: b, reason: collision with root package name */
    public ILogger f52139b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f52140c = false;

    /* renamed from: d, reason: collision with root package name */
    public final Object f52141d = new Object();

    public static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        private OutboxEnvelopeFileObserverIntegration() {
        }

        @Override // io.sentry.android.core.EnvelopeFileObserverIntegration
        public final String a(SentryOptions sentryOptions) {
            return sentryOptions.getOutboxPath();
        }

        public /* synthetic */ OutboxEnvelopeFileObserverIntegration(int i2) {
            this();
        }
    }

    public abstract String a(SentryOptions sentryOptions);

    public final void b(SentryOptions sentryOptions, String str) {
        EnvelopeFileObserver envelopeFileObserver = new EnvelopeFileObserver(str, new OutboxSender(HubAdapter.f51658a, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize()), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis());
        this.f52138a = envelopeFileObserver;
        try {
            envelopeFileObserver.startWatching();
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration installed.", new Object[0]);
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f52141d) {
            this.f52140c = true;
        }
        EnvelopeFileObserver envelopeFileObserver = this.f52138a;
        if (envelopeFileObserver != null) {
            envelopeFileObserver.stopWatching();
            ILogger iLogger = this.f52139b;
            if (iLogger != null) {
                iLogger.c(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        this.f52139b = sentryOptions.getLogger();
        String strA = a(sentryOptions);
        if (strA == null) {
            this.f52139b.c(SentryLevel.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        this.f52139b.c(SentryLevel.DEBUG, "Registering EnvelopeFileObserverIntegration for path: %s", strA);
        try {
            sentryOptions.getExecutorService().submit(new m(this, sentryOptions, strA, 1));
        } catch (Throwable th) {
            this.f52139b.b(SentryLevel.DEBUG, "Failed to start EnvelopeFileObserverIntegration on executor thread.", th);
        }
    }
}
