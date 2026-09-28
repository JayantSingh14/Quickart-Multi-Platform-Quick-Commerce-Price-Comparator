package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class NdkIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Class f52155a;

    /* renamed from: b, reason: collision with root package name */
    public SentryAndroidOptions f52156b;

    public NdkIntegration(Class cls) {
        this.f52155a = cls;
    }

    public static void a(SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setEnableScopeSync(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SentryAndroidOptions sentryAndroidOptions = this.f52156b;
        if (sentryAndroidOptions == null || !sentryAndroidOptions.isEnableNdk()) {
            return;
        }
        Class cls = this.f52155a;
        try {
            if (cls != null) {
                try {
                    try {
                        cls.getMethod("close", null).invoke(null, null);
                        this.f52156b.getLogger().c(SentryLevel.DEBUG, "NdkIntegration removed.", new Object[0]);
                        a(this.f52156b);
                    } catch (NoSuchMethodException e2) {
                        this.f52156b.getLogger().b(SentryLevel.ERROR, "Failed to invoke the SentryNdk.close method.", e2);
                        a(this.f52156b);
                    }
                } catch (Throwable th) {
                    this.f52156b.getLogger().b(SentryLevel.ERROR, "Failed to close SentryNdk.", th);
                    a(this.f52156b);
                }
            }
        } catch (Throwable th2) {
            a(this.f52156b);
            throw th2;
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        Class cls;
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52156b = sentryAndroidOptions;
        boolean zIsEnableNdk = sentryAndroidOptions.isEnableNdk();
        ILogger logger = this.f52156b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "NdkIntegration enabled: %s", Boolean.valueOf(zIsEnableNdk));
        if (!zIsEnableNdk || (cls = this.f52155a) == null) {
            a(this.f52156b);
            return;
        }
        if (this.f52156b.getCacheDirPath() == null) {
            this.f52156b.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            a(this.f52156b);
            return;
        }
        try {
            cls.getMethod("init", SentryAndroidOptions.class).invoke(null, this.f52156b);
            this.f52156b.getLogger().c(sentryLevel, "NdkIntegration installed.", new Object[0]);
            IntegrationUtils.a("Ndk");
        } catch (NoSuchMethodException e2) {
            a(this.f52156b);
            this.f52156b.getLogger().b(SentryLevel.ERROR, "Failed to invoke the SentryNdk.init method.", e2);
        } catch (Throwable th) {
            a(this.f52156b);
            this.f52156b.getLogger().b(SentryLevel.ERROR, "Failed to initialize SentryNdk.", th);
        }
    }
}
