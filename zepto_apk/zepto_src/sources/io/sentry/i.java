package io.sentry;

import io.sentry.cache.PersistingScopeObserver;
import io.sentry.cache.tape.ObjectQueue;
import io.sentry.util.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52748a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52749b;

    public /* synthetic */ i(Object obj, int i2) {
        this.f52748a = i2;
        this.f52749b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        Object obj = this.f52749b;
        switch (this.f52748a) {
            case 0:
                ThreadLocal threadLocal = Sentry.f51777a;
                SentryOptions sentryOptions = (SentryOptions) obj;
                String cacheDirPathWithoutDsn = sentryOptions.getCacheDirPathWithoutDsn();
                if (cacheDirPathWithoutDsn != null) {
                    File file = new File(cacheDirPathWithoutDsn, "app_start_profiling_config");
                    try {
                        FileUtils.a(file);
                        if (sentryOptions.isEnableAppStartProfiling()) {
                            if (!sentryOptions.isTracingEnabled()) {
                                sentryOptions.getLogger().c(SentryLevel.INFO, "Tracing is disabled and app start profiling will not start.", new Object[0]);
                                return;
                            }
                            if (file.createNewFile()) {
                                SentryAppStartProfilingOptions sentryAppStartProfilingOptions = new SentryAppStartProfilingOptions(sentryOptions, new TracesSampler(sentryOptions).a(new SamplingContext(new TransactionContext())));
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Sentry.f51780d));
                                    try {
                                        sentryOptions.getSerializer().e(sentryAppStartProfilingOptions, bufferedWriter);
                                        bufferedWriter.close();
                                        fileOutputStream.close();
                                        return;
                                    } finally {
                                    }
                                } finally {
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        sentryOptions.getLogger().b(SentryLevel.ERROR, "Unable to create app start profiling config file. ", th);
                        return;
                    }
                }
                return;
            case 1:
                ThreadLocal threadLocal2 = Sentry.f51777a;
                ((SentryOptions) obj).loadLazyFields();
                return;
            case 2:
                ThreadLocal threadLocal3 = Sentry.f51777a;
                SentryOptions sentryOptions2 = (SentryOptions) obj;
                for (IOptionsObserver iOptionsObserver : sentryOptions2.getOptionsObservers()) {
                    iOptionsObserver.g(sentryOptions2.getRelease());
                    iOptionsObserver.e(sentryOptions2.getProguardUuid());
                    iOptionsObserver.f(sentryOptions2.getSdkVersion());
                    iOptionsObserver.b(sentryOptions2.getDist());
                    iOptionsObserver.d(sentryOptions2.getEnvironment());
                    iOptionsObserver.a(sentryOptions2.getTags());
                    iOptionsObserver.c(sentryOptions2.getSessionReplay().f51858b);
                }
                PersistingScopeObserver persistingScopeObserverFindPersistingScopeObserver = sentryOptions2.findPersistingScopeObserver();
                if (persistingScopeObserverFindPersistingScopeObserver != null) {
                    try {
                        ((ObjectQueue) persistingScopeObserverFindPersistingScopeObserver.f52682b.a()).clear();
                    } catch (IOException e2) {
                        persistingScopeObserverFindPersistingScopeObserver.f52681a.getLogger().b(SentryLevel.ERROR, "Failed to clear breadcrumbs from file queue", e2);
                    }
                    persistingScopeObserverFindPersistingScopeObserver.l("user.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("level.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("request.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("fingerprint.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("contexts.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("extras.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("tags.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("trace.json");
                    persistingScopeObserverFindPersistingScopeObserver.l("transaction.json");
                    return;
                }
                return;
            case 3:
                HubAdapter.f51658a.v(((SentryOptions) obj).getFlushTimeoutMillis());
                return;
            default:
                ThreadLocal threadLocal4 = Sentry.f51777a;
                File[] fileArrListFiles = ((File) obj).listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                for (File file2 : fileArrListFiles) {
                    if (file2.lastModified() < Sentry.f51781e - TimeUnit.MINUTES.toMillis(5L)) {
                        FileUtils.a(file2);
                    }
                }
                return;
        }
    }
}
