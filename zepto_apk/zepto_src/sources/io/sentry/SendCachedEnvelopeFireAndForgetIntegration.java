package io.sentry;

import io.sentry.IConnectionStatusProvider;
import java.io.Closeable;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public final class SendCachedEnvelopeFireAndForgetIntegration implements Integration, IConnectionStatusProvider.IConnectionStatusObserver, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public SentryOptions f51774a;

    /* loaded from: classes.dex */
    public interface SendFireAndForget {
        void c1();
    }

    /* loaded from: classes.dex */
    public interface SendFireAndForgetDirPath {
    }

    /* loaded from: classes.dex */
    public interface SendFireAndForgetFactory {
        static boolean b(String str, ILogger iLogger) {
            if (str != null && !str.isEmpty()) {
                return true;
            }
            iLogger.c(SentryLevel.INFO, "No cached dir path is defined in options.", new Object[0]);
            return false;
        }

        h a(HubAdapter hubAdapter, SentryOptions sentryOptions);
    }

    @Override // io.sentry.IConnectionStatusProvider.IConnectionStatusObserver
    public final void a(IConnectionStatusProvider.ConnectionStatus connectionStatus) {
        SentryOptions sentryOptions = this.f51774a;
        synchronized (this) {
            try {
                try {
                    try {
                        sentryOptions.getExecutorService().submit(new in.juspay.hypernfc.b(19, this, sentryOptions));
                    } finally {
                    }
                } catch (RejectedExecutionException e2) {
                    sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", e2);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        this.f51774a = sentryOptions;
        sentryOptions.getCacheDirPath();
        sentryOptions.getLogger();
        throw null;
    }
}
