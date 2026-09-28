package com.google.firebase.tracing;

import android.app.Activity;
import android.os.Trace;
import android.support.v4.media.b;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.swmansion.reanimated.ReanimatedModule;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.Integration;
import io.sentry.Scope;
import io.sentry.Sentry;
import io.sentry.SentryEvent;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.AnrIntegration;
import io.sentry.android.core.CurrentActivityHolder;
import io.sentry.android.core.NdkIntegration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.gestures.SentryGestureListener;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryPackage;
import io.sentry.react.RNSentryModuleImpl;
import io.sentry.react.RNSentryReplayBreadcrumbConverter;
import io.sentry.react.replay.RNSentryReplayMask;
import io.sentry.react.replay.RNSentryReplayUnmask;
import io.sentry.util.HintUtils;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ComponentFactory, UIBlock, HintUtils.SentryConsumer, Scope.IWithTransaction, SentryOptions.BeforeSendCallback, Sentry.OptionsConfiguration {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f45215a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f45216b;

    public /* synthetic */ a(Object obj, Object obj2) {
        this.f45215a = obj;
        this.f45216b = obj2;
    }

    @Override // io.sentry.Sentry.OptionsConfiguration
    public void a(SentryOptions sentryOptions) {
        ReadableMap map;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        RNSentryModuleImpl rNSentryModuleImpl = (RNSentryModuleImpl) this.f45215a;
        rNSentryModuleImpl.getClass();
        AndroidLogger androidLogger2 = RNSentryModuleImpl.f52986l;
        SdkVersion sdkVersion = sentryAndroidOptions.getSdkVersion();
        if (sdkVersion == null) {
            sdkVersion = new SdkVersion("sentry.java.android.react-native", "7.22.5");
        } else {
            sdkVersion.f52895a = "sentry.java.android.react-native";
        }
        SentryIntegrationPackageStorage.c().b("npm:@sentry/react-native", "6.13.0");
        sentryAndroidOptions.setSentryClientName(sdkVersion.f52895a + "/" + sdkVersion.f52896b);
        sentryAndroidOptions.setNativeSdkName("sentry.native.android.react-native");
        sentryAndroidOptions.setSdkVersion(sdkVersion);
        ReadableMap readableMap = (ReadableMap) this.f45216b;
        boolean z = true;
        if (readableMap.hasKey("debug") && readableMap.getBoolean("debug")) {
            sentryAndroidOptions.setDebug(true);
        }
        if (!readableMap.hasKey("dsn") || readableMap.getString("dsn") == null) {
            sentryAndroidOptions.setDsn("");
        } else {
            String string = readableMap.getString("dsn");
            androidLogger2.c(SentryLevel.INFO, b.D("Starting with DSN: '", string, "'"), new Object[0]);
            sentryAndroidOptions.setDsn(string);
        }
        if (readableMap.hasKey("sampleRate")) {
            sentryAndroidOptions.setSampleRate(Double.valueOf(readableMap.getDouble("sampleRate")));
        }
        if (readableMap.hasKey("sendClientReports")) {
            sentryAndroidOptions.setSendClientReports(readableMap.getBoolean("sendClientReports"));
        }
        if (readableMap.hasKey("maxBreadcrumbs")) {
            sentryAndroidOptions.setMaxBreadcrumbs(readableMap.getInt("maxBreadcrumbs"));
        }
        if (readableMap.hasKey("maxCacheItems")) {
            sentryAndroidOptions.setMaxCacheItems(readableMap.getInt("maxCacheItems"));
        }
        if (readableMap.hasKey(PaymentConstants.ENV) && readableMap.getString(PaymentConstants.ENV) != null) {
            sentryAndroidOptions.setEnvironment(readableMap.getString(PaymentConstants.ENV));
        }
        if (readableMap.hasKey("release") && readableMap.getString("release") != null) {
            sentryAndroidOptions.setRelease(readableMap.getString("release"));
        }
        if (readableMap.hasKey("dist") && readableMap.getString("dist") != null) {
            sentryAndroidOptions.setDist(readableMap.getString("dist"));
        }
        if (readableMap.hasKey("enableAutoSessionTracking")) {
            sentryAndroidOptions.setEnableAutoSessionTracking(readableMap.getBoolean("enableAutoSessionTracking"));
        }
        if (readableMap.hasKey("sessionTrackingIntervalMillis")) {
            sentryAndroidOptions.setSessionTrackingIntervalMillis(readableMap.getInt("sessionTrackingIntervalMillis"));
        }
        if (readableMap.hasKey("shutdownTimeout")) {
            sentryAndroidOptions.setShutdownTimeoutMillis(readableMap.getInt("shutdownTimeout"));
        }
        if (readableMap.hasKey("enableNdkScopeSync")) {
            sentryAndroidOptions.setEnableScopeSync(readableMap.getBoolean("enableNdkScopeSync"));
        }
        if (readableMap.hasKey("attachStacktrace")) {
            sentryAndroidOptions.setAttachStacktrace(readableMap.getBoolean("attachStacktrace"));
        }
        if (readableMap.hasKey("attachThreads")) {
            sentryAndroidOptions.setAttachThreads(readableMap.getBoolean("attachThreads"));
        }
        if (readableMap.hasKey("attachScreenshot")) {
            sentryAndroidOptions.setAttachScreenshot(readableMap.getBoolean("attachScreenshot"));
        }
        if (readableMap.hasKey("attachViewHierarchy")) {
            sentryAndroidOptions.setAttachViewHierarchy(readableMap.getBoolean("attachViewHierarchy"));
        }
        if (readableMap.hasKey("sendDefaultPii")) {
            sentryAndroidOptions.setSendDefaultPii(readableMap.getBoolean("sendDefaultPii"));
        }
        if (readableMap.hasKey("maxQueueSize")) {
            sentryAndroidOptions.setMaxQueueSize(readableMap.getInt("maxQueueSize"));
        }
        if (readableMap.hasKey("enableNdk")) {
            sentryAndroidOptions.setEnableNdk(readableMap.getBoolean("enableNdk"));
        }
        if (readableMap.hasKey("spotlight")) {
            if (readableMap.getType("spotlight") == ReadableType.Boolean) {
                sentryAndroidOptions.setEnableSpotlight(readableMap.getBoolean("spotlight"));
                sentryAndroidOptions.setSpotlightConnectionUrl(readableMap.getString("defaultSidecarUrl"));
            } else if (readableMap.getType("spotlight") == ReadableType.String) {
                sentryAndroidOptions.setEnableSpotlight(true);
                sentryAndroidOptions.setSpotlightConnectionUrl(readableMap.getString("spotlight"));
            }
        }
        SentryReplayOptions sentryReplayOptions = new SentryReplayOptions(false, new SdkVersion("sentry.javascript.react-native", "6.13.0"));
        CopyOnWriteArraySet copyOnWriteArraySet = sentryReplayOptions.f51859c;
        String str = null;
        if (readableMap.hasKey("replaysSessionSampleRate") || readableMap.hasKey("replaysOnErrorSampleRate")) {
            sentryReplayOptions.d(readableMap.hasKey("replaysSessionSampleRate") ? Double.valueOf(readableMap.getDouble("replaysSessionSampleRate")) : null);
            sentryReplayOptions.c(readableMap.hasKey("replaysOnErrorSampleRate") ? Double.valueOf(readableMap.getDouble("replaysOnErrorSampleRate")) : null);
            if (readableMap.hasKey("mobileReplayOptions") && (map = readableMap.getMap("mobileReplayOptions")) != null) {
                sentryReplayOptions.b(!map.hasKey("maskAllText") || map.getBoolean("maskAllText"));
                if (map.hasKey("maskAllImages") && !map.getBoolean("maskAllImages")) {
                    z = false;
                }
                sentryReplayOptions.a(z);
                if (!map.hasKey("maskAllVectors") || map.getBoolean("maskAllVectors")) {
                    copyOnWriteArraySet.add("com.horcrux.svg.SvgView");
                }
                String name = RNSentryReplayMask.class.getName();
                copyOnWriteArraySet.add(name);
                sentryReplayOptions.f51861e = name;
                sentryReplayOptions.f51862f = RNSentryReplayUnmask.class.getName();
            }
        }
        sentryAndroidOptions.setSessionReplay(sentryReplayOptions);
        if (sentryReplayOptions.f51857a != null || sentryReplayOptions.f51858b != null) {
            sentryAndroidOptions.getReplayController().c(new RNSentryReplayBreadcrumbConverter());
        }
        String string2 = readableMap.getString("dsn");
        if (string2 != null) {
            try {
                URI uri = new URI(string2);
                str = uri.getScheme() + "://" + uri.getHost();
            } catch (URISyntaxException unused) {
            }
        }
        sentryAndroidOptions.setBeforeBreadcrumb(new io.sentry.react.a(str, readableMap.getString("devServerUrl")));
        sentryAndroidOptions.addIgnoredExceptionForType(JavascriptException.class);
        sentryAndroidOptions.setBeforeSend(new a(rNSentryModuleImpl, sentryAndroidOptions));
        if (readableMap.hasKey("enableNativeCrashHandling") && !readableMap.getBoolean("enableNativeCrashHandling")) {
            List<Integration> integrations = sentryAndroidOptions.getIntegrations();
            for (Integration integration : integrations) {
                if ((integration instanceof UncaughtExceptionHandlerIntegration) || (integration instanceof AnrIntegration) || (integration instanceof NdkIntegration)) {
                    integrations.remove(integration);
                }
            }
        }
        androidLogger2.c(SentryLevel.INFO, String.format("Native Integrations '%s'", sentryAndroidOptions.getIntegrations()), new Object[0]);
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.f52112b;
        Activity currentActivity = rNSentryModuleImpl.f52988a.getCurrentActivity();
        if (currentActivity != null) {
            WeakReference weakReference = currentActivityHolder.f52113a;
            if (weakReference == null || weakReference.get() != currentActivity) {
                currentActivityHolder.f52113a = new WeakReference(currentActivity);
            }
        }
    }

    @Override // io.sentry.SentryOptions.BeforeSendCallback
    public SentryEvent b(SentryEvent sentryEvent) {
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        ((RNSentryModuleImpl) this.f45215a).getClass();
        SdkVersion sdkVersion = sentryEvent.f51793c;
        if (sdkVersion != null) {
            String str = sdkVersion.f52895a;
            str.getClass();
            if (str.equals("sentry.java.android.react-native")) {
                sentryEvent.b("event.origin", LogSubCategory.LifeCycle.ANDROID);
                sentryEvent.b("event.environment", "java");
            } else if (str.equals("sentry.native.android.react-native")) {
                sentryEvent.b("event.origin", LogSubCategory.LifeCycle.ANDROID);
                sentryEvent.b("event.environment", "native");
            }
        }
        SdkVersion sdkVersion2 = ((SentryAndroidOptions) this.f45216b).getSdkVersion();
        SdkVersion sdkVersion3 = sentryEvent.f51793c;
        if (sdkVersion3 != null && "sentry.javascript.react-native".equals(sdkVersion3.f52895a) && sdkVersion2 != null) {
            CopyOnWriteArraySet copyOnWriteArraySet = sdkVersion2.f52897c;
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = SentryIntegrationPackageStorage.c().f51838b;
            }
            Iterator it = new CopyOnWriteArrayList(copyOnWriteArraySet).iterator();
            while (it.hasNext()) {
                SentryPackage sentryPackage = (SentryPackage) it.next();
                SentryIntegrationPackageStorage.c().b(sentryPackage.f52909a, sentryPackage.f52910b);
            }
            CopyOnWriteArraySet copyOnWriteArraySet2 = sdkVersion2.f52898d;
            if (copyOnWriteArraySet2 == null) {
                copyOnWriteArraySet2 = SentryIntegrationPackageStorage.c().f51837a;
            }
            Iterator it2 = new CopyOnWriteArrayList(copyOnWriteArraySet2).iterator();
            while (it2.hasNext()) {
                SentryIntegrationPackageStorage.c().a((String) it2.next());
            }
            sentryEvent.f51793c = sdkVersion3;
        }
        return sentryEvent;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object c(ComponentContainer componentContainer) {
        String str = (String) this.f45215a;
        Component component = (Component) this.f45216b;
        try {
            Trace.beginSection(str);
            return component.f43561f.c(componentContainer);
        } finally {
            Trace.endSection();
        }
    }

    @Override // io.sentry.Scope.IWithTransaction
    public void e(ITransaction iTransaction) {
        if (iTransaction == ((SentryGestureListener) this.f45215a).f52267e) {
            ((IScope) this.f45216b).w();
        }
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public void i(NativeViewHierarchyManager nativeViewHierarchyManager) {
        ((ReanimatedModule) this.f45215a).lambda$willDispatchViewUpdates$1((ArrayList) this.f45216b, nativeViewHierarchyManager);
    }
}
