package io.sentry.android.core;

import android.content.Context;
import androidx.annotation.WorkerThread;
import io.sentry.BackfillingEventProcessor;
import io.sentry.Hint;
import io.sentry.SentryExceptionFactory;
import io.sentry.SentryOptions;
import io.sentry.SentryStackTraceFactory;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.Backfillable;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@WorkerThread
/* loaded from: classes.dex */
public final class AnrV2EventProcessor implements BackfillingEventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52075a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryAndroidOptions f52076b;

    /* renamed from: c, reason: collision with root package name */
    public final BuildInfoProvider f52077c;

    /* renamed from: d, reason: collision with root package name */
    public final SentryExceptionFactory f52078d;

    /* renamed from: e, reason: collision with root package name */
    public final PersistingScopeObserver f52079e;

    public AnrV2EventProcessor(Context context, BuildInfoProvider buildInfoProvider, SentryAndroidOptions sentryAndroidOptions) {
        Context applicationContext = context.getApplicationContext();
        this.f52075a = applicationContext != null ? applicationContext : context;
        this.f52076b = sentryAndroidOptions;
        this.f52077c = buildInfoProvider;
        this.f52079e = sentryAndroidOptions.findPersistingScopeObserver();
        this.f52078d = new SentryExceptionFactory(new SentryStackTraceFactory(sentryAndroidOptions));
    }

    public static boolean d(Backfillable backfillable) {
        if (backfillable instanceof AbnormalExit) {
            return "anr_background".equals(((AbnormalExit) backfillable).h());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x0435  */
    @Override // io.sentry.EventProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.SentryEvent b(io.sentry.SentryEvent r26, io.sentry.Hint r27) {
        /*
            Method dump skipped, instructions count: 1572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AnrV2EventProcessor.b(io.sentry.SentryEvent, io.sentry.Hint):io.sentry.SentryEvent");
    }

    @Override // io.sentry.EventProcessor
    public final SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }

    public final Object e(SentryOptions sentryOptions, String str, Class cls) {
        PersistingScopeObserver persistingScopeObserver = this.f52079e;
        if (persistingScopeObserver == null) {
            return null;
        }
        return persistingScopeObserver.m(sentryOptions, str, cls);
    }
}
