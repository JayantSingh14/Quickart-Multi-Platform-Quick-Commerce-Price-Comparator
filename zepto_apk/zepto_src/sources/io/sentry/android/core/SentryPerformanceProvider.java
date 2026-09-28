package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.ITransactionProfiler;
import io.sentry.JsonSerializer;
import io.sentry.SentryAppStartProfilingOptions;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.TracesSamplingDecision;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryPerformanceProvider extends EmptySecureContentProvider {

    /* renamed from: e, reason: collision with root package name */
    public static final long f52201e = SystemClock.uptimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public Application f52202b;

    /* renamed from: c, reason: collision with root package name */
    public final AndroidLogger f52203c;

    /* renamed from: d, reason: collision with root package name */
    public final BuildInfoProvider f52204d;

    public SentryPerformanceProvider() {
        AndroidLogger androidLogger = new AndroidLogger();
        this.f52203c = androidLogger;
        this.f52204d = new BuildInfoProvider(androidLogger);
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        AppStartMetrics appStartMetricsB = AppStartMetrics.b();
        Context context = getContext();
        appStartMetricsB.f52370d.e(f52201e);
        BuildInfoProvider buildInfoProvider = this.f52204d;
        buildInfoProvider.getClass();
        appStartMetricsB.f52369c.e(Process.getStartUptimeMillis());
        if (context instanceof Application) {
            this.f52202b = (Application) context;
        }
        Application application = this.f52202b;
        if (application != null) {
            appStartMetricsB.d(application);
        }
        Context context2 = getContext();
        AndroidLogger androidLogger = this.f52203c;
        if (context2 == null) {
            androidLogger.c(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return true;
        }
        File file = new File(new File(context2.getCacheDir(), "sentry"), "app_start_profiling_config");
        if (!file.exists() || !file.canRead()) {
            return true;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                SentryAppStartProfilingOptions sentryAppStartProfilingOptions = (SentryAppStartProfilingOptions) new JsonSerializer(SentryOptions.empty()).d(bufferedReader, SentryAppStartProfilingOptions.class);
                if (sentryAppStartProfilingOptions == null) {
                    androidLogger.c(SentryLevel.WARNING, "Unable to deserialize the SentryAppStartProfilingOptions. App start profiling will not start.", new Object[0]);
                } else if (sentryAppStartProfilingOptions.f51787f) {
                    TracesSamplingDecision tracesSamplingDecision = new TracesSamplingDecision(Boolean.valueOf(sentryAppStartProfilingOptions.f51784c), sentryAppStartProfilingOptions.f51785d, Boolean.valueOf(sentryAppStartProfilingOptions.f51782a), sentryAppStartProfilingOptions.f51783b);
                    appStartMetricsB.f52375i = tracesSamplingDecision;
                    if (tracesSamplingDecision.b().booleanValue() && tracesSamplingDecision.d().booleanValue()) {
                        androidLogger.c(SentryLevel.DEBUG, "App start profiling started.", new Object[0]);
                        AndroidTransactionProfiler androidTransactionProfiler = new AndroidTransactionProfiler(context2, this.f52204d, new SentryFrameMetricsCollector(context2, androidLogger, buildInfoProvider), androidLogger, sentryAppStartProfilingOptions.f51786e, sentryAppStartProfilingOptions.f51787f, sentryAppStartProfilingOptions.f51788g, new SentryExecutorService());
                        appStartMetricsB.f52374h = androidTransactionProfiler;
                        androidTransactionProfiler.start();
                    } else {
                        androidLogger.c(SentryLevel.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
                    }
                } else {
                    androidLogger.c(SentryLevel.INFO, "Profiling is not enabled. App start profiling will not start.", new Object[0]);
                }
                bufferedReader.close();
                return true;
            } finally {
            }
        } catch (FileNotFoundException e2) {
            androidLogger.b(SentryLevel.ERROR, "App start profiling config file not found. ", e2);
            return true;
        } catch (Throwable th) {
            androidLogger.b(SentryLevel.ERROR, "Error reading app start profiling config file. ", th);
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        synchronized (AppStartMetrics.b()) {
            try {
                ITransactionProfiler iTransactionProfiler = AppStartMetrics.b().f52374h;
                if (iTransactionProfiler != null) {
                    iTransactionProfiler.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
