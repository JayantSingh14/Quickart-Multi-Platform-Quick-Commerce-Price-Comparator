package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import io.sentry.DeduplicateMultithreadedEventProcessor;
import io.sentry.DefaultTransactionPerformanceCollector;
import io.sentry.ITransactionProfiler;
import io.sentry.NoOpConnectionStatusProvider;
import io.sentry.SendFireAndForgetEnvelopeSender;
import io.sentry.SendFireAndForgetOutboxSender;
import io.sentry.SentryLevel;
import io.sentry.android.core.EnvelopeFileObserverIntegration;
import io.sentry.android.core.cache.AndroidEnvelopeCache;
import io.sentry.android.core.internal.debugmeta.AssetsDebugMetaLoader;
import io.sentry.android.core.internal.gestures.AndroidViewGestureTargetLocator;
import io.sentry.android.core.internal.modules.AssetsModulesLoader;
import io.sentry.android.core.internal.util.AndroidConnectionStatusProvider;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.replay.DefaultReplayBreadcrumbConverter;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.cache.PersistingOptionsObserver;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class AndroidOptionsInitializer {
    public static void a(SentryAndroidOptions sentryAndroidOptions, Context context, BuildInfoProvider buildInfoProvider, LoadClass loadClass, ActivityFramesTracker activityFramesTracker) {
        Context context2;
        BuildInfoProvider buildInfoProvider2;
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof NoOpEnvelopeCache)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new AndroidEnvelopeCache(sentryAndroidOptions));
        }
        if (sentryAndroidOptions.getConnectionStatusProvider() instanceof NoOpConnectionStatusProvider) {
            sentryAndroidOptions.setConnectionStatusProvider(new AndroidConnectionStatusProvider(context, sentryAndroidOptions.getLogger(), buildInfoProvider));
        }
        if (sentryAndroidOptions.getCacheDirPath() != null) {
            sentryAndroidOptions.addScopeObserver(new PersistingScopeObserver(sentryAndroidOptions));
            sentryAndroidOptions.addOptionsObserver(new PersistingOptionsObserver(sentryAndroidOptions));
        }
        sentryAndroidOptions.addEventProcessor(new DeduplicateMultithreadedEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new DefaultAndroidEventProcessor(context, buildInfoProvider, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new PerformanceAndroidEventProcessor(sentryAndroidOptions, activityFramesTracker));
        sentryAndroidOptions.addEventProcessor(new ScreenshotEventProcessor(sentryAndroidOptions, buildInfoProvider));
        sentryAndroidOptions.addEventProcessor(new ViewHierarchyEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new AnrV2EventProcessor(context, buildInfoProvider, sentryAndroidOptions));
        sentryAndroidOptions.setTransportGate(new AndroidTransportGate(sentryAndroidOptions));
        synchronized (AppStartMetrics.b()) {
            try {
                ITransactionProfiler iTransactionProfiler = AppStartMetrics.b().f52374h;
                if (iTransactionProfiler != null) {
                    sentryAndroidOptions.setTransactionProfiler(iTransactionProfiler);
                    AppStartMetrics.b().f52374h = null;
                    context2 = context;
                    buildInfoProvider2 = buildInfoProvider;
                } else {
                    SentryFrameMetricsCollector frameMetricsCollector = sentryAndroidOptions.getFrameMetricsCollector();
                    Objects.b(frameMetricsCollector, "options.getFrameMetricsCollector is required");
                    context2 = context;
                    buildInfoProvider2 = buildInfoProvider;
                    sentryAndroidOptions.setTransactionProfiler(new AndroidTransactionProfiler(context2, buildInfoProvider2, frameMetricsCollector, sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.isProfilingEnabled(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        sentryAndroidOptions.setModulesLoader(new AssetsModulesLoader(context2, sentryAndroidOptions.getLogger()));
        sentryAndroidOptions.setDebugMetaLoader(new AssetsDebugMetaLoader(context2, sentryAndroidOptions.getLogger()));
        boolean zA = LoadClass.a(sentryAndroidOptions, "androidx.core.view.ScrollingView");
        boolean zA2 = LoadClass.a(sentryAndroidOptions, "androidx.compose.ui.node.Owner");
        if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new AndroidViewGestureTargetLocator(zA));
            if (zA2 && LoadClass.a(sentryAndroidOptions, "io.sentry.compose.gestures.ComposeGestureTargetLocator")) {
                arrayList.add(new ComposeGestureTargetLocator(sentryAndroidOptions.getLogger()));
            }
            sentryAndroidOptions.setGestureTargetLocators(arrayList);
        }
        if (sentryAndroidOptions.getViewHierarchyExporters().isEmpty() && zA2 && LoadClass.a(sentryAndroidOptions, "io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter")) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(new ComposeViewHierarchyExporter(sentryAndroidOptions.getLogger()));
            sentryAndroidOptions.setViewHierarchyExporters(arrayList2);
        }
        sentryAndroidOptions.setMainThreadChecker(AndroidMainThreadChecker.f52307a);
        if (sentryAndroidOptions.getPerformanceCollectors().isEmpty()) {
            sentryAndroidOptions.addPerformanceCollector(new AndroidMemoryCollector());
            sentryAndroidOptions.addPerformanceCollector(new AndroidCpuCollector(sentryAndroidOptions.getLogger(), buildInfoProvider2));
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                SentryFrameMetricsCollector frameMetricsCollector2 = sentryAndroidOptions.getFrameMetricsCollector();
                Objects.b(frameMetricsCollector2, "options.getFrameMetricsCollector is required");
                sentryAndroidOptions.addPerformanceCollector(new SpanFrameMetricsCollector(sentryAndroidOptions, frameMetricsCollector2));
            }
        }
        sentryAndroidOptions.setTransactionPerformanceCollector(new DefaultTransactionPerformanceCollector(sentryAndroidOptions));
    }

    public static void b(Context context, SentryAndroidOptions sentryAndroidOptions, BuildInfoProvider buildInfoProvider, LoadClass loadClass, ActivityFramesTracker activityFramesTracker, boolean z, boolean z2, boolean z3) {
        LazyEvaluator lazyEvaluator = new LazyEvaluator(new f(sentryAndroidOptions));
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new SendFireAndForgetEnvelopeSender(new f(sentryAndroidOptions)), lazyEvaluator));
        sentryAndroidOptions.addIntegration(new NdkIntegration(LoadClass.b("io.sentry.android.ndk.SentryNdk", sentryAndroidOptions.getLogger())));
        sentryAndroidOptions.addIntegration(new EnvelopeFileObserverIntegration.OutboxEnvelopeFileObserverIntegration(0));
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new SendFireAndForgetOutboxSender(new f(sentryAndroidOptions)), lazyEvaluator));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(Build.VERSION.SDK_INT >= 30 ? new AnrV2Integration(context) : new AnrIntegration(context));
        if (context instanceof Application) {
            Application application = (Application) context;
            sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(application, buildInfoProvider, activityFramesTracker));
            sentryAndroidOptions.addIntegration(new ActivityBreadcrumbsIntegration(application));
            sentryAndroidOptions.addIntegration(new CurrentActivityIntegration(application));
            sentryAndroidOptions.addIntegration(new UserInteractionIntegration(application));
            if (z) {
                sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration(application, true, true));
            }
        } else {
            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (z2) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(context, sentryAndroidOptions.getLogger(), buildInfoProvider));
        if (z3) {
            ReplayIntegration replayIntegration = new ReplayIntegration(context);
            DefaultReplayBreadcrumbConverter converter = new DefaultReplayBreadcrumbConverter();
            Intrinsics.checkNotNullParameter(converter, "converter");
            replayIntegration.f52447m = converter;
            sentryAndroidOptions.addIntegration(replayIntegration);
            sentryAndroidOptions.setReplayController(replayIntegration);
        }
    }
}
