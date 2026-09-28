package io.sentry;

import io.sentry.backpressure.IBackpressureMonitor;
import io.sentry.backpressure.NoOpBackpressureMonitor;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.clientreport.ClientReportRecorder;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.clientreport.NoOpClientReportRecorder;
import io.sentry.internal.debugmeta.IDebugMetaLoader;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.modules.IModulesLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.internal.viewhierarchy.ViewHierarchyExporter;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransportGate;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.transport.NoOpTransportGate;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Platform;
import io.sentry.util.SampleRateUtils;
import io.sentry.util.StringUtils;
import io.sentry.util.thread.IMainThreadChecker;
import io.sentry.util.thread.NoOpMainThreadChecker;
import java.io.File;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* loaded from: classes.dex */
public class SentryOptions {
    static final SentryLevel DEFAULT_DIAGNOSTIC_LEVEL = SentryLevel.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";

    @ApiStatus.Internal
    @NotNull
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;

    @NotNull
    private IBackpressureMonitor backpressureMonitor;

    @Nullable
    private BeforeBreadcrumbCallback beforeBreadcrumb;

    @Nullable
    private BeforeEmitMetricCallback beforeEmitMetricCallback;

    @Nullable
    private BeforeEnvelopeCallback beforeEnvelopeCallback;

    @Nullable
    private BeforeSendCallback beforeSend;

    @Nullable
    private BeforeSendReplayCallback beforeSendReplay;

    @Nullable
    private BeforeSendTransactionCallback beforeSendTransaction;

    @NotNull
    private final Set<String> bundleIds;

    @Nullable
    private String cacheDirPath;

    @NotNull
    IClientReportRecorder clientReportRecorder;

    @NotNull
    private IConnectionStatusProvider connectionStatusProvider;
    private int connectionTimeoutMillis;

    @NotNull
    private final List<String> contextTags;

    @ApiStatus.Experimental
    @Nullable
    private Cron cron;

    @ApiStatus.Internal
    @NotNull
    private final LazyEvaluator<SentryDateProvider> dateProvider;
    private boolean debug;

    @NotNull
    private IDebugMetaLoader debugMetaLoader;

    @NotNull
    private final List<String> defaultTracePropagationTargets;

    @NotNull
    private SentryLevel diagnosticLevel;

    @Nullable
    private String dist;

    @Nullable
    private String distinctId;

    @Nullable
    private String dsn;

    @Nullable
    private String dsnHash;
    private boolean enableAppStartProfiling;
    private boolean enableAutoSessionTracking;
    private boolean enableBackpressureHandling;
    private boolean enableDeduplication;
    private boolean enableDefaultTagsForMetrics;
    private boolean enableExternalConfiguration;
    private boolean enableMetrics;
    private boolean enablePrettySerializationOutput;
    private boolean enableScopePersistence;

    @ApiStatus.Experimental
    private boolean enableScreenTracking;
    private boolean enableShutdownHook;
    private boolean enableSpanLocalMetricAggregation;
    private boolean enableSpotlight;
    private boolean enableTimeToFullDisplayTracing;

    @Nullable
    private Boolean enableTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;

    @NotNull
    private IEnvelopeCache envelopeDiskCache;

    @NotNull
    private final LazyEvaluator<IEnvelopeReader> envelopeReader;

    @Nullable
    private String environment;

    @NotNull
    private final List<EventProcessor> eventProcessors;

    @NotNull
    private ISentryExecutorService executorService;

    @NotNull
    private final ExperimentalOptions experimental;
    private long flushTimeoutMillis;

    @NotNull
    private FullyDisplayedReporter fullyDisplayedReporter;

    @NotNull
    private final List<GestureTargetLocator> gestureTargetLocators;

    @Nullable
    private Long idleTimeout;

    @ApiStatus.Experimental
    @Nullable
    private List<String> ignoredCheckIns;

    @NotNull
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;

    @NotNull
    private final List<String> inAppExcludes;

    @NotNull
    private final List<String> inAppIncludes;

    @NotNull
    private Instrumenter instrumenter;

    @NotNull
    private final List<Integration> integrations;

    @NotNull
    private ILogger logger;

    @NotNull
    private IMainThreadChecker mainThreadChecker;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;

    @NotNull
    private RequestSize maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;

    @NotNull
    private IModulesLoader modulesLoader;

    @NotNull
    private final List<IScopeObserver> observers;

    @NotNull
    private final List<IOptionsObserver> optionsObservers;

    @NotNull
    private final LazyEvaluator<Dsn> parsedDsn;

    @NotNull
    private final List<IPerformanceCollector> performanceCollectors;
    private boolean printUncaughtStackTrace;

    @Nullable
    private Double profilesSampleRate;

    @Nullable
    private ProfilesSamplerCallback profilesSampler;
    private int profilingTracesHz;

    @Nullable
    private String proguardUuid;

    @Nullable
    private Proxy proxy;
    private int readTimeoutMillis;

    @Nullable
    private String release;

    @NotNull
    private ReplayController replayController;

    @Nullable
    private Double sampleRate;

    @Nullable
    private SdkVersion sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;

    @Nullable
    private String sentryClientName;

    @NotNull
    private final LazyEvaluator<ISerializer> serializer;

    @Nullable
    private String serverName;
    private long sessionFlushTimeoutMillis;

    @NotNull
    private SentryReplayOptions sessionReplay;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;

    @Nullable
    private String spotlightConnectionUrl;

    @Nullable
    private SSLSocketFactory sslSocketFactory;

    @NotNull
    private final Map<String, String> tags;
    private boolean traceOptionsRequests;

    @Nullable
    private List<String> tracePropagationTargets;
    private boolean traceSampling;

    @Nullable
    private Double tracesSampleRate;

    @Nullable
    private TracesSamplerCallback tracesSampler;

    @NotNull
    private TransactionPerformanceCollector transactionPerformanceCollector;

    @NotNull
    private ITransactionProfiler transactionProfiler;

    @NotNull
    private ITransportFactory transportFactory;

    @NotNull
    private ITransportGate transportGate;

    @NotNull
    private final List<ViewHierarchyExporter> viewHierarchyExporters;

    public interface BeforeBreadcrumbCallback {
        Breadcrumb a(Breadcrumb breadcrumb);
    }

    @ApiStatus.Experimental
    /* loaded from: classes3.dex */
    public interface BeforeEmitMetricCallback {
    }

    @ApiStatus.Internal
    public interface BeforeEnvelopeCallback {
        void a(SentryEnvelope sentryEnvelope);
    }

    public interface BeforeSendCallback {
        SentryEvent b(SentryEvent sentryEvent);
    }

    /* loaded from: classes3.dex */
    public interface BeforeSendReplayCallback {
        SentryReplayEvent d();
    }

    /* loaded from: classes3.dex */
    public interface BeforeSendTransactionCallback {
        SentryTransaction d();
    }

    /* loaded from: classes3.dex */
    public static final class Cron {

        /* renamed from: a, reason: collision with root package name */
        public Long f51848a;

        /* renamed from: b, reason: collision with root package name */
        public Long f51849b;

        /* renamed from: c, reason: collision with root package name */
        public String f51850c;

        /* renamed from: d, reason: collision with root package name */
        public Long f51851d;

        /* renamed from: e, reason: collision with root package name */
        public Long f51852e;

        public final Long a() {
            return this.f51848a;
        }

        public final Long b() {
            return this.f51851d;
        }

        public final Long c() {
            return this.f51849b;
        }

        public final Long d() {
            return this.f51852e;
        }

        public final String e() {
            return this.f51850c;
        }

        public final void f(Long l2) {
            this.f51848a = l2;
        }

        public final void g(Long l2) {
            this.f51851d = l2;
        }

        public final void h(Long l2) {
            this.f51849b = l2;
        }

        public final void i(Long l2) {
            this.f51852e = l2;
        }

        public final void j(String str) {
            this.f51850c = str;
        }
    }

    /* loaded from: classes3.dex */
    public interface ProfilesSamplerCallback {
        Double a();
    }

    /* loaded from: classes3.dex */
    public static final class Proxy {

        /* renamed from: a, reason: collision with root package name */
        public final String f51853a;

        /* renamed from: b, reason: collision with root package name */
        public final String f51854b;

        /* renamed from: c, reason: collision with root package name */
        public final String f51855c;

        /* renamed from: d, reason: collision with root package name */
        public final String f51856d;

        public Proxy() {
            this(null, null, null, null);
        }

        public final String a() {
            return this.f51853a;
        }

        public final String b() {
            return this.f51856d;
        }

        public final String c() {
            return this.f51854b;
        }

        public final String d() {
            return this.f51855c;
        }

        public Proxy(String str, String str2, String str3, String str4) {
            this.f51853a = str;
            this.f51854b = str2;
            this.f51855c = str3;
            this.f51856d = str4;
        }
    }

    public enum RequestSize {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    /* loaded from: classes3.dex */
    public interface TracesSamplerCallback {
        Double a();
    }

    public SentryOptions() {
        this(false);
    }

    public static /* synthetic */ Dsn a(SentryOptions sentryOptions) {
        return new Dsn(sentryOptions.dsn);
    }

    public static /* synthetic */ EnvelopeReader b(SentryOptions sentryOptions) {
        sentryOptions.getClass();
        return new EnvelopeReader((ISerializer) sentryOptions.serializer.a());
    }

    @ApiStatus.Internal
    @NotNull
    public static SentryOptions empty() {
        return new SentryOptions(true);
    }

    public void addBundleId(@Nullable String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.bundleIds.add(strTrim);
        }
    }

    public void addContextTag(@NotNull String str) {
        this.contextTags.add(str);
    }

    public void addEventProcessor(@NotNull EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public void addIgnoredExceptionForType(@NotNull Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void addInAppExclude(@NotNull String str) {
        this.inAppExcludes.add(str);
    }

    public void addInAppInclude(@NotNull String str) {
        this.inAppIncludes.add(str);
    }

    public void addIntegration(@NotNull Integration integration) {
        this.integrations.add(integration);
    }

    public void addOptionsObserver(@NotNull IOptionsObserver iOptionsObserver) {
        this.optionsObservers.add(iOptionsObserver);
    }

    @ApiStatus.Internal
    public void addPerformanceCollector(@NotNull IPerformanceCollector iPerformanceCollector) {
        this.performanceCollectors.add(iPerformanceCollector);
    }

    public void addScopeObserver(@NotNull IScopeObserver iScopeObserver) {
        this.observers.add(iScopeObserver);
    }

    @Deprecated
    public void addTracingOrigin(@NotNull String str) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.tracePropagationTargets.add(str);
    }

    public boolean containsIgnoredExceptionForType(@NotNull Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    @ApiStatus.Internal
    @Nullable
    public PersistingScopeObserver findPersistingScopeObserver() {
        for (IScopeObserver iScopeObserver : this.observers) {
            if (iScopeObserver instanceof PersistingScopeObserver) {
                return (PersistingScopeObserver) iScopeObserver;
            }
        }
        return null;
    }

    @ApiStatus.Internal
    @NotNull
    public IBackpressureMonitor getBackpressureMonitor() {
        return this.backpressureMonitor;
    }

    @Nullable
    public BeforeBreadcrumbCallback getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    @ApiStatus.Experimental
    @Nullable
    public BeforeEmitMetricCallback getBeforeEmitMetricCallback() {
        return this.beforeEmitMetricCallback;
    }

    @ApiStatus.Internal
    @Nullable
    public BeforeEnvelopeCallback getBeforeEnvelopeCallback() {
        return this.beforeEnvelopeCallback;
    }

    @Nullable
    public BeforeSendCallback getBeforeSend() {
        return this.beforeSend;
    }

    @Nullable
    public BeforeSendReplayCallback getBeforeSendReplay() {
        return this.beforeSendReplay;
    }

    @Nullable
    public BeforeSendTransactionCallback getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }

    @NotNull
    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    @Nullable
    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    @Nullable
    public String getCacheDirPathWithoutDsn() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath;
    }

    @ApiStatus.Internal
    @NotNull
    public IClientReportRecorder getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    @NotNull
    public IConnectionStatusProvider getConnectionStatusProvider() {
        return this.connectionStatusProvider;
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    @NotNull
    public List<String> getContextTags() {
        return this.contextTags;
    }

    @Nullable
    public Cron getCron() {
        return this.cron;
    }

    @ApiStatus.Internal
    @NotNull
    public SentryDateProvider getDateProvider() {
        return (SentryDateProvider) this.dateProvider.a();
    }

    @ApiStatus.Internal
    @NotNull
    public IDebugMetaLoader getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    @NotNull
    public SentryLevel getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    @Nullable
    public String getDist() {
        return this.dist;
    }

    @ApiStatus.Internal
    @Nullable
    public String getDistinctId() {
        return this.distinctId;
    }

    @Nullable
    public String getDsn() {
        return this.dsn;
    }

    @Deprecated
    @Nullable
    public Boolean getEnableTracing() {
        return this.enableTracing;
    }

    @NotNull
    public IEnvelopeCache getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    @NotNull
    public IEnvelopeReader getEnvelopeReader() {
        return (IEnvelopeReader) this.envelopeReader.a();
    }

    @Nullable
    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    @NotNull
    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    @ApiStatus.Internal
    @NotNull
    public ISentryExecutorService getExecutorService() {
        return this.executorService;
    }

    @NotNull
    public ExperimentalOptions getExperimental() {
        return this.experimental;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    @ApiStatus.Internal
    @NotNull
    public FullyDisplayedReporter getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public List<GestureTargetLocator> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    @Nullable
    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    @ApiStatus.Experimental
    @Nullable
    public List<String> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    @NotNull
    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    @NotNull
    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    @NotNull
    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    @NotNull
    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    @NotNull
    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    @NotNull
    public ILogger getLogger() {
        return this.logger;
    }

    @NotNull
    public IMainThreadChecker getMainThreadChecker() {
        return this.mainThreadChecker;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    @NotNull
    public RequestSize getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    @ApiStatus.Experimental
    public int getMaxSpans() {
        return this.maxSpans;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    @ApiStatus.Internal
    @NotNull
    public IModulesLoader getModulesLoader() {
        return this.modulesLoader;
    }

    @NotNull
    public List<IOptionsObserver> getOptionsObservers() {
        return this.optionsObservers;
    }

    @Nullable
    public String getOutboxPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }

    @ApiStatus.Internal
    @NotNull
    public List<IPerformanceCollector> getPerformanceCollectors() {
        return this.performanceCollectors;
    }

    @Nullable
    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    @Nullable
    public ProfilesSamplerCallback getProfilesSampler() {
        return this.profilesSampler;
    }

    @Nullable
    public String getProfilingTracesDirPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }

    @ApiStatus.Internal
    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    @Nullable
    public String getProguardUuid() {
        return this.proguardUuid;
    }

    @Nullable
    public Proxy getProxy() {
        return this.proxy;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Nullable
    public String getRelease() {
        return this.release;
    }

    @NotNull
    public ReplayController getReplayController() {
        return this.replayController;
    }

    @Nullable
    public Double getSampleRate() {
        return this.sampleRate;
    }

    @NotNull
    public List<IScopeObserver> getScopeObservers() {
        return this.observers;
    }

    @Nullable
    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    @Nullable
    public String getSentryClientName() {
        return this.sentryClientName;
    }

    @NotNull
    public ISerializer getSerializer() {
        return (ISerializer) this.serializer.a();
    }

    @Nullable
    public String getServerName() {
        return this.serverName;
    }

    @ApiStatus.Internal
    public long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    @NotNull
    public SentryReplayOptions getSessionReplay() {
        return this.sessionReplay;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    @ApiStatus.ScheduledForRemoval
    @Deprecated
    public long getShutdownTimeout() {
        return this.shutdownTimeoutMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    @ApiStatus.Experimental
    @Nullable
    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    @Nullable
    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public Map<String, String> getTags() {
        return this.tags;
    }

    @NotNull
    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    @Nullable
    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    @Nullable
    public TracesSamplerCallback getTracesSampler() {
        return this.tracesSampler;
    }

    @Deprecated
    @NotNull
    public List<String> getTracingOrigins() {
        return getTracePropagationTargets();
    }

    @ApiStatus.Internal
    @NotNull
    public TransactionPerformanceCollector getTransactionPerformanceCollector() {
        return this.transactionPerformanceCollector;
    }

    @NotNull
    public ITransactionProfiler getTransactionProfiler() {
        return this.transactionProfiler;
    }

    @NotNull
    public ITransportFactory getTransportFactory() {
        return this.transportFactory;
    }

    @NotNull
    public ITransportGate getTransportGate() {
        return this.transportGate;
    }

    @NotNull
    public final List<ViewHierarchyExporter> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableAppStartProfiling() {
        return isProfilingEnabled() && this.enableAppStartProfiling;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    @ApiStatus.Experimental
    public boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    @ApiStatus.Experimental
    public boolean isEnableDefaultTagsForMetrics() {
        return isEnableMetrics() && this.enableDefaultTagsForMetrics;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    @ApiStatus.Experimental
    public boolean isEnableMetrics() {
        return this.enableMetrics;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isEnableScopePersistence() {
        return this.enableScopePersistence;
    }

    @ApiStatus.Experimental
    public boolean isEnableScreenTracking() {
        return this.enableScreenTracking;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    @ApiStatus.Experimental
    public boolean isEnableSpanLocalMetricAggregation() {
        return isEnableMetrics() && this.enableSpanLocalMetricAggregation;
    }

    @ApiStatus.Experimental
    public boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public boolean isProfilingEnabled() {
        return (getProfilesSampleRate() != null && getProfilesSampleRate().doubleValue() > 0.0d) || getProfilesSampler() != null;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    @ApiStatus.Experimental
    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    public boolean isTracingEnabled() {
        Boolean bool = this.enableTracing;
        return bool != null ? bool.booleanValue() : (getTracesSampleRate() == null && getTracesSampler() == null) ? false : true;
    }

    public void loadLazyFields() throws IllegalArgumentException {
        getSerializer();
        retrieveParsedDsn();
        getEnvelopeReader();
        getDateProvider();
    }

    public void merge(@NotNull ExternalOptions externalOptions) {
        if (externalOptions.g() != null) {
            setDsn(externalOptions.g());
        }
        if (externalOptions.k() != null) {
            setEnvironment(externalOptions.k());
        }
        if (externalOptions.u() != null) {
            setRelease(externalOptions.u());
        }
        if (externalOptions.f() != null) {
            setDist(externalOptions.f());
        }
        if (externalOptions.w() != null) {
            setServerName(externalOptions.w());
        }
        if (externalOptions.t() != null) {
            setProxy(externalOptions.t());
        }
        if (externalOptions.j() != null) {
            setEnableUncaughtExceptionHandler(externalOptions.j().booleanValue());
        }
        if (externalOptions.q() != null) {
            setPrintUncaughtStackTrace(externalOptions.q().booleanValue());
        }
        if (externalOptions.i() != null) {
            setEnableTracing(externalOptions.i());
        }
        if (externalOptions.z() != null) {
            setTracesSampleRate(externalOptions.z());
        }
        if (externalOptions.r() != null) {
            setProfilesSampleRate(externalOptions.r());
        }
        if (externalOptions.e() != null) {
            setDebug(externalOptions.e().booleanValue());
        }
        if (externalOptions.h() != null) {
            setEnableDeduplication(externalOptions.h().booleanValue());
        }
        if (externalOptions.v() != null) {
            setSendClientReports(externalOptions.v().booleanValue());
        }
        for (Map.Entry entry : new HashMap(externalOptions.x()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        Iterator it = new ArrayList(externalOptions.p()).iterator();
        while (it.hasNext()) {
            addInAppInclude((String) it.next());
        }
        Iterator it2 = new ArrayList(externalOptions.o()).iterator();
        while (it2.hasNext()) {
            addInAppExclude((String) it2.next());
        }
        Iterator it3 = new HashSet(externalOptions.n()).iterator();
        while (it3.hasNext()) {
            addIgnoredExceptionForType((Class) it3.next());
        }
        if (externalOptions.y() != null) {
            setTracePropagationTargets(new ArrayList(externalOptions.y()));
        }
        Iterator it4 = new ArrayList(externalOptions.c()).iterator();
        while (it4.hasNext()) {
            addContextTag((String) it4.next());
        }
        if (externalOptions.s() != null) {
            setProguardUuid(externalOptions.s());
        }
        if (externalOptions.l() != null) {
            setIdleTimeout(externalOptions.l());
        }
        Iterator it5 = externalOptions.b().iterator();
        while (it5.hasNext()) {
            addBundleId((String) it5.next());
        }
        if (externalOptions.C() != null) {
            setEnabled(externalOptions.C().booleanValue());
        }
        if (externalOptions.B() != null) {
            setEnablePrettySerializationOutput(externalOptions.B().booleanValue());
        }
        if (externalOptions.D() != null) {
            setSendModules(externalOptions.D().booleanValue());
        }
        if (externalOptions.m() != null) {
            setIgnoredCheckIns(new ArrayList(externalOptions.m()));
        }
        if (externalOptions.A() != null) {
            setEnableBackpressureHandling(externalOptions.A().booleanValue());
        }
        if (externalOptions.d() != null) {
            if (getCron() == null) {
                setCron(externalOptions.d());
                return;
            }
            if (externalOptions.d().a() != null) {
                getCron().f(externalOptions.d().a());
            }
            if (externalOptions.d().c() != null) {
                getCron().h(externalOptions.d().c());
            }
            if (externalOptions.d().e() != null) {
                getCron().j(externalOptions.d().e());
            }
            if (externalOptions.d().b() != null) {
                getCron().g(externalOptions.d().b());
            }
            if (externalOptions.d().d() != null) {
                getCron().i(externalOptions.d().d());
            }
        }
    }

    @ApiStatus.Internal
    @NotNull
    public Dsn retrieveParsedDsn() throws IllegalArgumentException {
        return (Dsn) this.parsedDsn.a();
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    @ApiStatus.Internal
    public void setBackpressureMonitor(@NotNull IBackpressureMonitor iBackpressureMonitor) {
        this.backpressureMonitor = iBackpressureMonitor;
    }

    public void setBeforeBreadcrumb(@Nullable BeforeBreadcrumbCallback beforeBreadcrumbCallback) {
        this.beforeBreadcrumb = beforeBreadcrumbCallback;
    }

    @ApiStatus.Experimental
    public void setBeforeEmitMetricCallback(@Nullable BeforeEmitMetricCallback beforeEmitMetricCallback) {
        this.beforeEmitMetricCallback = beforeEmitMetricCallback;
    }

    @ApiStatus.Internal
    public void setBeforeEnvelopeCallback(@Nullable BeforeEnvelopeCallback beforeEnvelopeCallback) {
        this.beforeEnvelopeCallback = beforeEnvelopeCallback;
    }

    public void setBeforeSend(@Nullable BeforeSendCallback beforeSendCallback) {
        this.beforeSend = beforeSendCallback;
    }

    public void setBeforeSendReplay(@Nullable BeforeSendReplayCallback beforeSendReplayCallback) {
        this.beforeSendReplay = beforeSendReplayCallback;
    }

    public void setBeforeSendTransaction(@Nullable BeforeSendTransactionCallback beforeSendTransactionCallback) {
        this.beforeSendTransaction = beforeSendTransactionCallback;
    }

    public void setCacheDirPath(@Nullable String str) {
        this.cacheDirPath = str;
    }

    public void setConnectionStatusProvider(@NotNull IConnectionStatusProvider iConnectionStatusProvider) {
        this.connectionStatusProvider = iConnectionStatusProvider;
    }

    public void setConnectionTimeoutMillis(int i2) {
        this.connectionTimeoutMillis = i2;
    }

    @ApiStatus.Experimental
    public void setCron(@Nullable Cron cron) {
        this.cron = cron;
    }

    @ApiStatus.Internal
    public void setDateProvider(@NotNull SentryDateProvider sentryDateProvider) {
        LazyEvaluator<SentryDateProvider> lazyEvaluator = this.dateProvider;
        synchronized (lazyEvaluator) {
            lazyEvaluator.f53125a = sentryDateProvider;
        }
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    @ApiStatus.Internal
    public void setDebugMetaLoader(@Nullable IDebugMetaLoader iDebugMetaLoader) {
        if (iDebugMetaLoader == null) {
            iDebugMetaLoader = NoOpDebugMetaLoader.f52750a;
        }
        this.debugMetaLoader = iDebugMetaLoader;
    }

    public void setDiagnosticLevel(@Nullable SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            sentryLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = sentryLevel;
    }

    public void setDist(@Nullable String str) {
        this.dist = str;
    }

    @ApiStatus.Internal
    public void setDistinctId(@Nullable String str) {
        this.distinctId = str;
    }

    public void setDsn(@Nullable String str) {
        String string;
        this.dsn = str;
        LazyEvaluator<Dsn> lazyEvaluator = this.parsedDsn;
        synchronized (lazyEvaluator) {
            string = null;
            lazyEvaluator.f53125a = null;
        }
        String str2 = this.dsn;
        ILogger iLogger = this.logger;
        Charset charset = StringUtils.f53134a;
        if (str2 != null && !str2.isEmpty()) {
            try {
                string = new StringBuilder(new BigInteger(1, MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest(str2.getBytes(StringUtils.f53134a))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e2) {
                iLogger.b(SentryLevel.INFO, "SHA-1 isn't available to calculate the hash.", e2);
            } catch (Throwable th) {
                iLogger.c(SentryLevel.INFO, "string: %s could not calculate its hash", th, str2);
            }
        }
        this.dsnHash = string;
    }

    public void setEnableAppStartProfiling(boolean z) {
        this.enableAppStartProfiling = z;
    }

    public void setEnableAutoSessionTracking(boolean z) {
        this.enableAutoSessionTracking = z;
    }

    @ApiStatus.Experimental
    public void setEnableBackpressureHandling(boolean z) {
        this.enableBackpressureHandling = z;
    }

    public void setEnableDeduplication(boolean z) {
        this.enableDeduplication = z;
    }

    @ApiStatus.Experimental
    public void setEnableDefaultTagsForMetrics(boolean z) {
        this.enableDefaultTagsForMetrics = z;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    @ApiStatus.Experimental
    public void setEnableMetrics(boolean z) {
        this.enableMetrics = z;
    }

    public void setEnablePrettySerializationOutput(boolean z) {
        this.enablePrettySerializationOutput = z;
    }

    public void setEnableScopePersistence(boolean z) {
        this.enableScopePersistence = z;
    }

    @ApiStatus.Experimental
    public void setEnableScreenTracking(boolean z) {
        this.enableScreenTracking = z;
    }

    public void setEnableShutdownHook(boolean z) {
        this.enableShutdownHook = z;
    }

    @ApiStatus.Experimental
    public void setEnableSpanLocalMetricAggregation(boolean z) {
        this.enableSpanLocalMetricAggregation = z;
    }

    @ApiStatus.Experimental
    public void setEnableSpotlight(boolean z) {
        this.enableSpotlight = z;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z) {
        this.enableTimeToFullDisplayTracing = z;
    }

    @Deprecated
    public void setEnableTracing(@Nullable Boolean bool) {
        this.enableTracing = bool;
    }

    public void setEnableUncaughtExceptionHandler(boolean z) {
        this.enableUncaughtExceptionHandler = z;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z) {
        this.enableUserInteractionBreadcrumbs = z;
    }

    public void setEnableUserInteractionTracing(boolean z) {
        this.enableUserInteractionTracing = z;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setEnvelopeDiskCache(@Nullable IEnvelopeCache iEnvelopeCache) {
        if (iEnvelopeCache == null) {
            iEnvelopeCache = NoOpEnvelopeCache.f53097a;
        }
        this.envelopeDiskCache = iEnvelopeCache;
    }

    public void setEnvelopeReader(@Nullable IEnvelopeReader iEnvelopeReader) {
        LazyEvaluator<IEnvelopeReader> lazyEvaluator = this.envelopeReader;
        if (iEnvelopeReader == null) {
            iEnvelopeReader = NoOpEnvelopeReader.f51704a;
        }
        synchronized (lazyEvaluator) {
            lazyEvaluator.f53125a = iEnvelopeReader;
        }
    }

    public void setEnvironment(@Nullable String str) {
        this.environment = str;
    }

    @TestOnly
    @ApiStatus.Internal
    public void setExecutorService(@NotNull ISentryExecutorService iSentryExecutorService) {
        if (iSentryExecutorService != null) {
            this.executorService = iSentryExecutorService;
        }
    }

    public void setFlushTimeoutMillis(long j2) {
        this.flushTimeoutMillis = j2;
    }

    @TestOnly
    @ApiStatus.Internal
    public void setFullyDisplayedReporter(@NotNull FullyDisplayedReporter fullyDisplayedReporter) {
        this.fullyDisplayedReporter = fullyDisplayedReporter;
    }

    public void setGestureTargetLocators(@NotNull List<GestureTargetLocator> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public void setIdleTimeout(@Nullable Long l2) {
        this.idleTimeout = l2;
    }

    @ApiStatus.Experimental
    public void setIgnoredCheckIns(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public void setInstrumenter(@NotNull Instrumenter instrumenter) {
        this.instrumenter = instrumenter;
    }

    public void setLogger(@Nullable ILogger iLogger) {
        this.logger = iLogger == null ? NoOpLogger.f51707a : new DiagnosticLogger(this, iLogger);
    }

    public void setMainThreadChecker(@NotNull IMainThreadChecker iMainThreadChecker) {
        this.mainThreadChecker = iMainThreadChecker;
    }

    public void setMaxAttachmentSize(long j2) {
        this.maxAttachmentSize = j2;
    }

    public void setMaxBreadcrumbs(int i2) {
        this.maxBreadcrumbs = i2;
    }

    public void setMaxCacheItems(int i2) {
        this.maxCacheItems = i2;
    }

    public void setMaxDepth(int i2) {
        this.maxDepth = i2;
    }

    public void setMaxQueueSize(int i2) {
        if (i2 > 0) {
            this.maxQueueSize = i2;
        }
    }

    public void setMaxRequestBodySize(@NotNull RequestSize requestSize) {
        this.maxRequestBodySize = requestSize;
    }

    @ApiStatus.Experimental
    public void setMaxSpans(int i2) {
        this.maxSpans = i2;
    }

    public void setMaxTraceFileSize(long j2) {
        this.maxTraceFileSize = j2;
    }

    @ApiStatus.Internal
    public void setModulesLoader(@Nullable IModulesLoader iModulesLoader) {
        if (iModulesLoader == null) {
            iModulesLoader = NoOpModulesLoader.f52766a;
        }
        this.modulesLoader = iModulesLoader;
    }

    public void setPrintUncaughtStackTrace(boolean z) {
        this.printUncaughtStackTrace = z;
    }

    public void setProfilesSampleRate(@Nullable Double d2) {
        if (SampleRateUtils.a(true, d2)) {
            this.profilesSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setProfilesSampler(@Nullable ProfilesSamplerCallback profilesSamplerCallback) {
        this.profilesSampler = profilesSamplerCallback;
    }

    @Deprecated
    public void setProfilingEnabled(boolean z) {
        if (getProfilesSampleRate() == null) {
            setProfilesSampleRate(z ? Double.valueOf(1.0d) : null);
        }
    }

    @ApiStatus.Internal
    public void setProfilingTracesHz(int i2) {
        this.profilingTracesHz = i2;
    }

    public void setProguardUuid(@Nullable String str) {
        this.proguardUuid = str;
    }

    public void setProxy(@Nullable Proxy proxy) {
        this.proxy = proxy;
    }

    public void setReadTimeoutMillis(int i2) {
        this.readTimeoutMillis = i2;
    }

    public void setRelease(@Nullable String str) {
        this.release = str;
    }

    public void setReplayController(@Nullable ReplayController replayController) {
        if (replayController == null) {
            replayController = NoOpReplayController.f51709a;
        }
        this.replayController = replayController;
    }

    public void setSampleRate(Double d2) {
        if (SampleRateUtils.a(true, d2)) {
            this.sampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    @ApiStatus.Internal
    public void setSdkVersion(@Nullable SdkVersion sdkVersion) {
        SdkVersion sdkVersion2 = getSessionReplay().f51869m;
        SdkVersion sdkVersion3 = this.sdkVersion;
        if (sdkVersion3 != null && sdkVersion2 != null && sdkVersion3.equals(sdkVersion2)) {
            getSessionReplay().f51869m = sdkVersion;
        }
        this.sdkVersion = sdkVersion;
    }

    public void setSendClientReports(boolean z) {
        this.sendClientReports = z;
        if (z) {
            this.clientReportRecorder = new ClientReportRecorder(this);
        } else {
            this.clientReportRecorder = new NoOpClientReportRecorder();
        }
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void setSendModules(boolean z) {
        this.sendModules = z;
    }

    public void setSentryClientName(@Nullable String str) {
        this.sentryClientName = str;
    }

    public void setSerializer(@Nullable ISerializer iSerializer) {
        LazyEvaluator<ISerializer> lazyEvaluator = this.serializer;
        if (iSerializer == null) {
            iSerializer = NoOpSerializer.f51712a;
        }
        synchronized (lazyEvaluator) {
            lazyEvaluator.f53125a = iSerializer;
        }
    }

    public void setServerName(@Nullable String str) {
        this.serverName = str;
    }

    @ApiStatus.Internal
    public void setSessionFlushTimeoutMillis(long j2) {
        this.sessionFlushTimeoutMillis = j2;
    }

    public void setSessionReplay(@NotNull SentryReplayOptions sentryReplayOptions) {
        this.sessionReplay = sentryReplayOptions;
    }

    public void setSessionTrackingIntervalMillis(long j2) {
        this.sessionTrackingIntervalMillis = j2;
    }

    @ApiStatus.ScheduledForRemoval
    @Deprecated
    public void setShutdownTimeout(long j2) {
        this.shutdownTimeoutMillis = j2;
    }

    public void setShutdownTimeoutMillis(long j2) {
        this.shutdownTimeoutMillis = j2;
    }

    @ApiStatus.Experimental
    public void setSpotlightConnectionUrl(@Nullable String str) {
        this.spotlightConnectionUrl = str;
    }

    public void setSslSocketFactory(@Nullable SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setTag(@NotNull String str, @NotNull String str2) {
        this.tags.put(str, str2);
    }

    public void setTraceOptionsRequests(boolean z) {
        this.traceOptionsRequests = z;
    }

    @ApiStatus.Internal
    public void setTracePropagationTargets(@Nullable List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    @Deprecated
    public void setTraceSampling(boolean z) {
        this.traceSampling = z;
    }

    public void setTracesSampleRate(@Nullable Double d2) {
        if (SampleRateUtils.a(true, d2)) {
            this.tracesSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setTracesSampler(@Nullable TracesSamplerCallback tracesSamplerCallback) {
        this.tracesSampler = tracesSamplerCallback;
    }

    @ApiStatus.Internal
    @Deprecated
    public void setTracingOrigins(@Nullable List<String> list) {
        setTracePropagationTargets(list);
    }

    @ApiStatus.Internal
    public void setTransactionPerformanceCollector(@NotNull TransactionPerformanceCollector transactionPerformanceCollector) {
        this.transactionPerformanceCollector = transactionPerformanceCollector;
    }

    public void setTransactionProfiler(@Nullable ITransactionProfiler iTransactionProfiler) {
        if (this.transactionProfiler != NoOpTransactionProfiler.f51716a || iTransactionProfiler == null) {
            return;
        }
        this.transactionProfiler = iTransactionProfiler;
    }

    public void setTransportFactory(@Nullable ITransportFactory iTransportFactory) {
        if (iTransportFactory == null) {
            iTransportFactory = NoOpTransportFactory.f51717a;
        }
        this.transportFactory = iTransportFactory;
    }

    public void setTransportGate(@Nullable ITransportGate iTransportGate) {
        if (iTransportGate == null) {
            iTransportGate = NoOpTransportGate.f53099a;
        }
        this.transportGate = iTransportGate;
    }

    public void setViewHierarchyExporters(@NotNull List<ViewHierarchyExporter> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    public SentryOptions(boolean z) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.bundleIds = new CopyOnWriteArraySet();
        final int i2 = 0;
        this.parsedDsn = new LazyEvaluator<>(new LazyEvaluator.Evaluator(this) { // from class: io.sentry.p

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SentryOptions f52792b;

            {
                this.f52792b = this;
            }

            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object a() {
                SentryOptions sentryOptions = this.f52792b;
                switch (i2) {
                    case 0:
                        return SentryOptions.a(sentryOptions);
                    case 1:
                        String str = SentryOptions.DEFAULT_PROPAGATION_TARGETS;
                        sentryOptions.getClass();
                        return new JsonSerializer(sentryOptions);
                    default:
                        return SentryOptions.b(sentryOptions);
                }
            }
        });
        this.shutdownTimeoutMillis = 2000L;
        this.flushTimeoutMillis = 15000L;
        this.sessionFlushTimeoutMillis = 15000L;
        this.logger = NoOpLogger.f51707a;
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        final int i3 = 1;
        this.serializer = new LazyEvaluator<>(new LazyEvaluator.Evaluator(this) { // from class: io.sentry.p

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SentryOptions f52792b;

            {
                this.f52792b = this;
            }

            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object a() {
                SentryOptions sentryOptions = this.f52792b;
                switch (i3) {
                    case 0:
                        return SentryOptions.a(sentryOptions);
                    case 1:
                        String str = SentryOptions.DEFAULT_PROPAGATION_TARGETS;
                        sentryOptions.getClass();
                        return new JsonSerializer(sentryOptions);
                    default:
                        return SentryOptions.b(sentryOptions);
                }
            }
        });
        final int i4 = 2;
        this.envelopeReader = new LazyEvaluator<>(new LazyEvaluator.Evaluator(this) { // from class: io.sentry.p

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SentryOptions f52792b;

            {
                this.f52792b = this;
            }

            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object a() {
                SentryOptions sentryOptions = this.f52792b;
                switch (i4) {
                    case 0:
                        return SentryOptions.a(sentryOptions);
                    case 1:
                        String str = SentryOptions.DEFAULT_PROPAGATION_TARGETS;
                        sentryOptions.getClass();
                        return new JsonSerializer(sentryOptions);
                    default:
                        return SentryOptions.b(sentryOptions);
                }
            }
        });
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = NoOpTransportFactory.f51717a;
        this.transportGate = NoOpTransportGate.f53099a;
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000L;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = NoOpSentryExecutorService.f51711a;
        this.connectionTimeoutMillis = 5000;
        this.readTimeoutMillis = 5000;
        this.envelopeDiskCache = NoOpEnvelopeCache.f53097a;
        this.sendDefaultPii = false;
        this.observers = new CopyOnWriteArrayList();
        this.optionsObservers = new CopyOnWriteArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520L;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = RequestSize.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880L;
        this.transactionProfiler = NoOpTransactionProfiler.f51716a;
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(".*");
        this.idleTimeout = 3000L;
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new ClientReportRecorder(this);
        this.modulesLoader = NoOpModulesLoader.f52766a;
        this.debugMetaLoader = NoOpDebugMetaLoader.f52750a;
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = Instrumenter.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.viewHierarchyExporters = new ArrayList();
        this.mainThreadChecker = NoOpMainThreadChecker.f53138a;
        this.traceOptionsRequests = true;
        this.dateProvider = new LazyEvaluator<>(new g());
        this.performanceCollectors = new ArrayList();
        this.transactionPerformanceCollector = NoOpTransactionPerformanceCollector.f51715a;
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = FullyDisplayedReporter.f51633b;
        this.connectionStatusProvider = new NoOpConnectionStatusProvider();
        this.enabled = true;
        this.enablePrettySerializationOutput = true;
        this.sendModules = true;
        this.enableSpotlight = false;
        this.enableScopePersistence = true;
        this.ignoredCheckIns = null;
        this.backpressureMonitor = NoOpBackpressureMonitor.f52668a;
        this.enableBackpressureHandling = true;
        this.enableAppStartProfiling = false;
        this.enableMetrics = false;
        this.enableDefaultTagsForMetrics = true;
        this.enableSpanLocalMetricAggregation = true;
        this.beforeEmitMetricCallback = null;
        this.profilingTracesHz = 101;
        this.cron = null;
        this.replayController = NoOpReplayController.f51709a;
        this.enableScreenTracking = true;
        SdkVersion sdkVersion = new SdkVersion("sentry.java", "7.22.5");
        sdkVersion.f52896b = "7.22.5";
        this.experimental = new ExperimentalOptions();
        this.sessionReplay = new SentryReplayOptions(z, sdkVersion);
        if (z) {
            return;
        }
        this.executorService = new SentryExecutorService();
        copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
        copyOnWriteArrayList2.add(new ShutdownHookIntegration());
        copyOnWriteArrayList2.add(new SpotlightIntegration());
        copyOnWriteArrayList.add(new MainEventProcessor(this));
        copyOnWriteArrayList.add(new DuplicateEventDetectionEventProcessor(this));
        if (!Platform.f53129a) {
            copyOnWriteArrayList.add(new SentryRuntimeEventProcessor());
        }
        setSentryClientName("sentry.java/7.22.5");
        setSdkVersion(sdkVersion);
        SentryIntegrationPackageStorage.c().b("maven:io.sentry:sentry", "7.22.5");
    }
}
