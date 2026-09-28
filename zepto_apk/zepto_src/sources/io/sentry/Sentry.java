package io.sentry;

import io.sentry.Stack;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.backpressure.BackpressureMonitor;
import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.config.PropertiesProviderFactory;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.debugmeta.ResourcesDebugMetaLoader;
import io.sentry.internal.modules.CompositeModulesLoader;
import io.sentry.internal.modules.IModulesLoader;
import io.sentry.internal.modules.ManifestModulesLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.internal.modules.ResourcesModulesLoader;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.Platform;
import io.sentry.util.thread.MainThreadChecker;
import io.sentry.util.thread.NoOpMainThreadChecker;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class Sentry {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f51777a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static volatile IHub f51778b = NoOpHub.f51705b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f51779c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f51780d = Charset.forName("UTF-8");

    /* renamed from: e, reason: collision with root package name */
    public static final long f51781e = System.currentTimeMillis();

    public interface OptionsConfiguration<T extends SentryOptions> {
        void a(SentryOptions sentryOptions);
    }

    public static void a(Throwable th) {
        d().D(th);
    }

    public static synchronized void b() {
        IHub iHubD = d();
        f51778b = NoOpHub.f51705b;
        f51777a.remove();
        iHubD.n(false);
    }

    public static void c(ScopeCallback scopeCallback) {
        d().w(scopeCallback);
    }

    public static IHub d() {
        if (f51779c) {
            return f51778b;
        }
        ThreadLocal threadLocal = f51777a;
        IHub iHub = (IHub) threadLocal.get();
        if (iHub != null && !(iHub instanceof NoOpHub)) {
            return iHub;
        }
        IHub iHubM67clone = f51778b.m68clone();
        threadLocal.set(iHubM67clone);
        return iHubM67clone;
    }

    public static void e(OptionsContainer optionsContainer, io.sentry.android.core.d dVar) {
        SentryOptions sentryOptions = (SentryOptions) SentryAndroidOptions.class.getDeclaredConstructor(null).newInstance(null);
        try {
            dVar.a(sentryOptions);
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
        synchronized (Sentry.class) {
            try {
                if (d().isEnabled()) {
                    sentryOptions.getLogger().c(SentryLevel.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
                }
                if (f(sentryOptions)) {
                    try {
                        sentryOptions.getExecutorService().submit(new i(sentryOptions, 1));
                    } catch (RejectedExecutionException e2) {
                        sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to call the executor. Lazy fields will not be loaded. Did you call Sentry.close()?", e2);
                    }
                    sentryOptions.getLogger().c(SentryLevel.INFO, "GlobalHubMode: '%s'", String.valueOf(true));
                    f51779c = true;
                    IHub iHubD = d();
                    if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
                        throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub if no DSN is available.");
                    }
                    f51778b = new Hub(sentryOptions, new Stack(sentryOptions.getLogger(), new Stack.StackItem(sentryOptions, new SentryClient(sentryOptions), new Scope(sentryOptions))));
                    f51777a.set(f51778b);
                    iHubD.n(true);
                    if (sentryOptions.getExecutorService().isClosed()) {
                        sentryOptions.setExecutorService(new SentryExecutorService());
                    }
                    Iterator<Integration> it = sentryOptions.getIntegrations().iterator();
                    while (it.hasNext()) {
                        it.next().l(sentryOptions);
                    }
                    try {
                        sentryOptions.getExecutorService().submit(new i(sentryOptions, 2));
                    } catch (Throwable th2) {
                        sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to notify options observers.", th2);
                    }
                    try {
                        sentryOptions.getExecutorService().submit(new PreviousSessionFinalizer(sentryOptions));
                    } catch (Throwable th3) {
                        sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to finalize previous session.", th3);
                    }
                    try {
                        sentryOptions.getExecutorService().submit(new i(sentryOptions, 0));
                    } catch (Throwable th4) {
                        sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. App start profiling config will not be changed. Did you call Sentry.close()?", th4);
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public static boolean f(SentryOptions sentryOptions) throws IllegalArgumentException {
        IEnvelopeCache envelopeCache;
        if (sentryOptions.isEnableExternalConfiguration()) {
            sentryOptions.merge(ExternalOptions.a(PropertiesProviderFactory.a(), sentryOptions.getLogger()));
        }
        String dsn = sentryOptions.getDsn();
        if (!sentryOptions.isEnabled() || (dsn != null && dsn.isEmpty())) {
            b();
            return false;
        }
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        }
        sentryOptions.retrieveParsedDsn();
        ILogger logger = sentryOptions.getLogger();
        if (sentryOptions.isDebug() && (logger instanceof NoOpLogger)) {
            sentryOptions.setLogger(new SystemOutLogger());
            logger = sentryOptions.getLogger();
        }
        SentryLevel sentryLevel = SentryLevel.INFO;
        logger.c(sentryLevel, "Initializing SDK with DSN: '%s'", sentryOptions.getDsn());
        String outboxPath = sentryOptions.getOutboxPath();
        if (outboxPath != null) {
            new File(outboxPath).mkdirs();
        } else {
            logger.c(sentryLevel, "No outbox dir path is defined in options.", new Object[0]);
        }
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath != null) {
            new File(cacheDirPath).mkdirs();
            if (sentryOptions.getEnvelopeDiskCache() instanceof NoOpEnvelopeCache) {
                int i2 = EnvelopeCache.f52676h;
                String cacheDirPath2 = sentryOptions.getCacheDirPath();
                int maxCacheItems = sentryOptions.getMaxCacheItems();
                if (cacheDirPath2 == null) {
                    sentryOptions.getLogger().c(SentryLevel.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
                    envelopeCache = NoOpEnvelopeCache.f53097a;
                } else {
                    envelopeCache = new EnvelopeCache(sentryOptions, cacheDirPath2, maxCacheItems);
                }
                sentryOptions.setEnvelopeDiskCache(envelopeCache);
            }
        }
        String profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
        if (sentryOptions.isProfilingEnabled() && profilingTracesDirPath != null) {
            File file = new File(profilingTracesDirPath);
            file.mkdirs();
            try {
                sentryOptions.getExecutorService().submit(new i(file, 4));
            } catch (RejectedExecutionException e2) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", e2);
            }
        }
        IModulesLoader modulesLoader = sentryOptions.getModulesLoader();
        if (!sentryOptions.isSendModules()) {
            sentryOptions.setModulesLoader(NoOpModulesLoader.f52766a);
        } else if (modulesLoader instanceof NoOpModulesLoader) {
            sentryOptions.setModulesLoader(new CompositeModulesLoader(Arrays.asList(new ManifestModulesLoader(sentryOptions.getLogger()), new ResourcesModulesLoader(sentryOptions.getLogger())), sentryOptions.getLogger()));
        }
        if (sentryOptions.getDebugMetaLoader() instanceof NoOpDebugMetaLoader) {
            sentryOptions.setDebugMetaLoader(new ResourcesDebugMetaLoader(sentryOptions.getLogger()));
        }
        List listA = sentryOptions.getDebugMetaLoader().a();
        if (listA != null) {
            if (sentryOptions.getBundleIds().isEmpty()) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    String property = ((Properties) it.next()).getProperty("io.sentry.bundle-ids");
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "Bundle IDs found: %s", property);
                    if (property != null) {
                        for (String str : property.split(",", -1)) {
                            sentryOptions.addBundleId(str);
                        }
                    }
                }
            }
            if (sentryOptions.getProguardUuid() == null) {
                Iterator it2 = listA.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String property2 = ((Properties) it2.next()).getProperty("io.sentry.ProguardUuids");
                    if (property2 != null) {
                        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Proguard UUID found: %s", property2);
                        sentryOptions.setProguardUuid(property2);
                        break;
                    }
                }
            }
        }
        if (sentryOptions.getMainThreadChecker() instanceof NoOpMainThreadChecker) {
            sentryOptions.setMainThreadChecker(MainThreadChecker.b());
        }
        if (sentryOptions.getPerformanceCollectors().isEmpty()) {
            sentryOptions.addPerformanceCollector(new JavaMemoryCollector());
        }
        if (sentryOptions.isEnableBackpressureHandling() && !Platform.f53129a) {
            sentryOptions.setBackpressureMonitor(new BackpressureMonitor(sentryOptions));
            sentryOptions.getBackpressureMonitor().start();
        }
        return true;
    }
}
