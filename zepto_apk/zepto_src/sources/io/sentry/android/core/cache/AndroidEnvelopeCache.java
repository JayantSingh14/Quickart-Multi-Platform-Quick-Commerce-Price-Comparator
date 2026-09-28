package io.sentry.android.core.cache;

import android.os.SystemClock;
import com.google.firebase.tracing.a;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AnrV2Integration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.util.AndroidCurrentDateProvider;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.cache.EnvelopeCache;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidEnvelopeCache extends EnvelopeCache {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f52246j = 0;

    /* renamed from: i, reason: collision with root package name */
    public final AndroidCurrentDateProvider f52247i;

    /* JADX WARN: Illegal instructions before constructor call */
    public AndroidEnvelopeCache(SentryAndroidOptions sentryAndroidOptions) {
        AndroidCurrentDateProvider androidCurrentDateProvider = AndroidCurrentDateProvider.f52306a;
        String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
        Objects.b(cacheDirPath, "cacheDirPath must not be null");
        super(sentryAndroidOptions, cacheDirPath, sentryAndroidOptions.getMaxCacheItems());
        this.f52247i = androidCurrentDateProvider;
    }

    @Override // io.sentry.cache.EnvelopeCache, io.sentry.cache.IEnvelopeCache
    public final void v0(SentryEnvelope sentryEnvelope, Hint hint) {
        super.v0(sentryEnvelope, hint);
        SentryOptions sentryOptions = this.f52671a;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        TimeSpan timeSpan = AppStartMetrics.b().f52370d;
        if (UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class.isInstance(HintUtils.b(hint)) && timeSpan.c()) {
            this.f52247i.getClass();
            long jUptimeMillis = SystemClock.uptimeMillis() - timeSpan.f52382c;
            if (jUptimeMillis <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                ILogger logger = sentryAndroidOptions.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                logger.c(sentryLevel, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", Long.valueOf(jUptimeMillis));
                String outboxPath = sentryOptions.getOutboxPath();
                if (outboxPath == null) {
                    sentryOptions.getLogger().c(sentryLevel, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
                } else {
                    try {
                        new File(outboxPath, "startup_crash").createNewFile();
                    } catch (Throwable th) {
                        sentryOptions.getLogger().b(SentryLevel.ERROR, "Error writing the startup crash marker file to the disk", th);
                    }
                }
            }
        }
        a aVar = new a(this, sentryAndroidOptions);
        Object objB = HintUtils.b(hint);
        if (!AnrV2Integration.AnrV2Hint.class.isInstance(HintUtils.b(hint)) || objB == null) {
            return;
        }
        AndroidEnvelopeCache androidEnvelopeCache = (AndroidEnvelopeCache) aVar.f45215a;
        androidEnvelopeCache.getClass();
        Long lValueOf = Long.valueOf(((AnrV2Integration.AnrV2Hint) objB).f52087d);
        ILogger logger2 = ((SentryAndroidOptions) aVar.f45216b).getLogger();
        SentryLevel sentryLevel2 = SentryLevel.DEBUG;
        logger2.c(sentryLevel2, "Writing last reported ANR marker with timestamp %d", lValueOf);
        SentryOptions sentryOptions2 = androidEnvelopeCache.f52671a;
        String cacheDirPath = sentryOptions2.getCacheDirPath();
        if (cacheDirPath == null) {
            sentryOptions2.getLogger().c(sentryLevel2, "Cache dir path is null, the ANR marker will not be written", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDirPath, "last_anr_report"));
            try {
                fileOutputStream.write(String.valueOf(lValueOf).getBytes(f52670e));
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th2) {
            sentryOptions2.getLogger().b(SentryLevel.ERROR, "Error writing the ANR marker to the disk", th2);
        }
    }
}
