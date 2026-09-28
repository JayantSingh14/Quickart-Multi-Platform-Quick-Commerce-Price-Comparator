package io.sentry.android.core;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SentryLevel;
import io.sentry.android.core.cache.AndroidEnvelopeCache;
import io.sentry.util.LazyEvaluator;
import java.io.File;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements LazyEvaluator.Evaluator, SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SentryAndroidOptions f52253a;

    public /* synthetic */ f(SentryAndroidOptions sentryAndroidOptions) {
        this.f52253a = sentryAndroidOptions;
    }

    @Override // io.sentry.util.LazyEvaluator.Evaluator
    public Object a() {
        int i2 = AndroidEnvelopeCache.f52246j;
        SentryAndroidOptions sentryAndroidOptions = this.f52253a;
        String outboxPath = sentryAndroidOptions.getOutboxPath();
        boolean z = false;
        if (outboxPath == null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
        } else {
            File file = new File(outboxPath, "startup_crash");
            try {
                boolean zExists = file.exists();
                if (zExists && !file.delete()) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete the startup crash marker file. %s.", file.getAbsolutePath());
                }
                z = zExists;
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Error reading/deleting the startup crash marker file on the disk", th);
            }
        }
        return Boolean.valueOf(z);
    }
}
