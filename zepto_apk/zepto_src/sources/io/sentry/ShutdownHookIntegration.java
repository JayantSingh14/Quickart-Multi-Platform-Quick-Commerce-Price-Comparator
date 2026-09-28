package io.sentry;

import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class ShutdownHookIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Runtime f51907a;

    /* renamed from: b, reason: collision with root package name */
    public Thread f51908b;

    public ShutdownHookIntegration() {
        Runtime runtime = Runtime.getRuntime();
        Objects.b(runtime, "Runtime is required");
        this.f51907a = runtime;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f51908b != null) {
            try {
                new Runnable() { // from class: io.sentry.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShutdownHookIntegration shutdownHookIntegration = this.f52984a;
                        shutdownHookIntegration.f51907a.removeShutdownHook(shutdownHookIntegration.f51908b);
                    }
                }.run();
            } catch (IllegalStateException e2) {
                String message = e2.getMessage();
                if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                    throw e2;
                }
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        if (!sentryOptions.isEnableShutdownHook()) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "enableShutdownHook is disabled.", new Object[0]);
            return;
        }
        this.f51908b = new Thread(new i(sentryOptions, 3));
        try {
            this.f51907a.addShutdownHook(this.f51908b);
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
            IntegrationUtils.a("ShutdownHook");
        } catch (IllegalStateException e2) {
            String message = e2.getMessage();
            if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                throw e2;
            }
        }
    }
}
