package com.zeptoconsumerapp;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import bridges.CommonAppPackage;
import bridges.CommsModule;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.defaults.DefaultReactHost;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.soloader.OpenSourceMergedSoMapping;
import com.facebook.soloader.SoLoader;
import com.falcon.FalconConfig;
import com.falcon.FalconContextContainer;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixEventListener;
import com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustPackage;
import com.zeptoconsumerapp.AppServiceStarter.AppServiceStarterPackage;
import com.zeptoconsumerapp.AppSetIdGenerator.AppSetIdGeneratorPackage;
import com.zeptoconsumerapp.AppShortcuts.AppShortcutsPackage;
import com.zeptoconsumerapp.AutoLogin.CredentialManager;
import com.zeptoconsumerapp.DeviceIntelligence.DeviceIntelligencePackage;
import com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreenPackage;
import com.zeptoconsumerapp.FusedLocation.FusedLocationPackage;
import com.zeptoconsumerapp.GoogleAdsManager.GAMPackage;
import com.zeptoconsumerapp.Haptics.RNReactNativeHapticFeedbackPackage;
import com.zeptoconsumerapp.HorizonProxy.HorizonProxyPackage;
import com.zeptoconsumerapp.NativeModules.DialerPackage;
import com.zeptoconsumerapp.NetworkLogger.NetworkLoggerPackage;
import com.zeptoconsumerapp.PDFPasswordChecker.PDFPasswordCheckerPackage;
import com.zeptoconsumerapp.PaymentUPIHelper.PaymentUPIHelperPackage;
import com.zeptoconsumerapp.PhoneNumberHint.PhoneNumberHintPackage;
import com.zeptoconsumerapp.ShakeDetector.ShakeDetectorPackage;
import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import com.zeptoconsumerapp.Startup.AppInitializer;
import com.zeptoconsumerapp.Startup.AppLifecycleManager;
import com.zeptoconsumerapp.Startup.AppPhoenixManager;
import com.zeptoconsumerapp.ZeptoImage.ZeptoImagePackage;
import com.zeptoconsumerapp.customisations.CustomBitmapMemoryCacheParamsSupplier;
import com.zeptoconsumerapp.gamification.scratchcard.ScratchRevealPackage;
import com.zeptoconsumerapp.modules.image.FrescoCacheKeyFactory;
import com.zeptoconsumerapp.modules.notification.silentPush.SilentPushRegistry;
import com.zeptoconsumerapp.otpVerify.OtpVerifyPackage;
import com.zeptoconsumerapp.performancemode.react.PerformanceModePackage;
import com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchPackage;
import com.zeptoconsumerapp.rsa.RSAOAEPPackage;
import com.zeptoconsumerapp.screenShotDetector.ScreenshotDetectionPackage;
import com.zeptoconsumerapp.slotmachine.SlotMachinePackage;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import timber.log.Timber;

@Metadata
/* loaded from: classes.dex */
public final class MainApplication extends Application implements ReactApplication {

    /* renamed from: a, reason: collision with root package name */
    public final MainApplication$reactNativeHost$1 f47525a = new DefaultReactNativeHost() { // from class: com.zeptoconsumerapp.MainApplication$reactNativeHost$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(this.f47526c);
            Intrinsics.checkNotNullParameter(this.f47526c, "application");
        }

        public static void j(ArrayList arrayList) {
            arrayList.add(new CommonAppPackage());
            if (Build.VERSION.SDK_INT >= 25) {
                arrayList.add(new AppShortcutsPackage());
            }
            arrayList.add(new AndroidKeyboardAdjustPackage());
            arrayList.add(new DynamicSplashScreenPackage());
            arrayList.add(new NetworkLoggerPackage());
            arrayList.add(new AppSetIdGeneratorPackage());
            arrayList.add(new RNReactNativeHapticFeedbackPackage());
            arrayList.add(new FusedLocationPackage());
            arrayList.add(new PDFPasswordCheckerPackage());
            arrayList.add(new PaymentUPIHelperPackage());
            arrayList.add(new SlotMachinePackage());
            arrayList.add(new ScratchRevealPackage());
            arrayList.add(new ShakeDetectorPackage());
            arrayList.add(new ScreenshotDetectionPackage());
            arrayList.add(new PhoneNumberHintPackage());
            arrayList.add(new RSAOAEPPackage());
            arrayList.add(new OtpVerifyPackage());
            arrayList.add(new PerformanceModePackage());
            arrayList.add(new GAMPackage());
            arrayList.add(new AppServiceStarterPackage());
            arrayList.add(new ZeptoImagePackage());
            arrayList.add(new LayoutPrefetchPackage());
            arrayList.add(new HorizonProxyPackage());
            arrayList.add(new DialerPackage());
            arrayList.add(new DeviceIntelligencePackage());
        }

        @Override // com.facebook.react.ReactNativeHost
        public final String b() {
            return Phoenix.Companion.e();
        }

        @Override // com.facebook.react.ReactNativeHost
        public final String d() {
            return "index";
        }

        @Override // com.facebook.react.ReactNativeHost
        public final ArrayList e() {
            Context context = this.f47526c.getApplicationContext();
            ImagePipelineConfig.DefaultImageRequestConfig defaultImageRequestConfig = ImagePipelineConfig.A;
            Intrinsics.c(context);
            Intrinsics.checkNotNullParameter(context, "context");
            ImagePipelineConfig.Builder builder = new ImagePipelineConfig.Builder(context);
            builder.f17848b = new FrescoCacheKeyFactory();
            DiskCacheConfig.Builder builder2 = new DiskCacheConfig.Builder(context);
            builder2.f17027b = 1073741824L;
            builder2.f17028c = 209715200L;
            builder2.f17029d = 52428800L;
            builder.f17851e = new DiskCacheConfig(builder2);
            builder.f17847a = new CustomBitmapMemoryCacheParamsSupplier(context);
            MainPackageConfig mainPackageConfig = new MainPackageConfig(new ImagePipelineConfig(builder));
            try {
                ArrayList arrayListA = new PackageList(mainPackageConfig).a();
                Intrinsics.checkNotNullExpressionValue(arrayListA, "getPackages(...)");
                ArrayList arrayListF0 = CollectionsKt.f0(arrayListA);
                j(arrayListF0);
                return arrayListF0;
            } catch (Exception unused) {
                ArrayList arrayListA2 = new PackageList(mainPackageConfig).a();
                Intrinsics.checkNotNullExpressionValue(arrayListA2, "getPackages(...)");
                ArrayList arrayListF02 = CollectionsKt.f0(arrayListA2);
                j(arrayListF02);
                return arrayListF02;
            }
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        public final Boolean i() {
            return Boolean.TRUE;
        }
    };

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.ReactApplication
    public final MainApplication$reactNativeHost$1 a() {
        return this.f47525a;
    }

    @Override // com.facebook.react.ReactApplication
    public final ReactHost b() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return DefaultReactHost.a(applicationContext, this.f47525a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "HORIZON_OKHTTP_INSTANCE".equals(name) ? OkHttpClientProvider.b() : super.getSystemService(name);
    }

    @Override // android.app.Application
    public final void onCreate() throws IOException {
        registerActivityLifecycleCallbacks(new MainApplication$registerActivityCallbacks$1());
        if (!AppCoroutineManager.f47544a) {
            Job jobB = SupervisorKt.b();
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            AppCoroutineManager.f47545b = CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c((JobSupport) jobB, defaultScheduler));
            AppCoroutineManager.f47546c = CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c((JobSupport) SupervisorKt.b(), DefaultIoScheduler.f55150b));
            AppCoroutineManager.f47547d = CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c((JobSupport) SupervisorKt.b(), defaultScheduler));
            AppCoroutineManager.f47544a = true;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        AppInitializer appInitializer = new AppInitializer(applicationContext);
        AppPhoenixManager listener = new AppPhoenixManager(applicationContext);
        try {
            Intrinsics.checkNotNullParameter(BuildConfig.ANDROID_PHOENIX_ID, CLConstants.SALT_FIELD_APP_ID);
            Intrinsics.checkNotNullParameter("PROD", "env");
            Phoenix.f46111a = BuildConfig.ANDROID_PHOENIX_ID;
            Intrinsics.checkNotNullParameter(listener, "phoenixApplication");
            Phoenix.f46112b = listener;
            ArrayList arrayList = PhoenixEventListener.f46123a;
            Intrinsics.checkNotNullParameter(listener, "listener");
            PhoenixEventListener.f46123a.add(listener);
        } catch (Exception e2) {
            Utils.i(e2);
        }
        CredentialManager.initialize(this);
        super.onCreate();
        OpenSourceMergedSoMapping openSourceMergedSoMapping = OpenSourceMergedSoMapping.f19365a;
        boolean z = SoLoader.f20285a;
        synchronized (SoLoader.class) {
            SoLoader.o = openSourceMergedSoMapping;
        }
        SoLoader.init(this, 0);
        appInitializer.a();
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(BuildConfig.EVENT_SERVICE_BASE_URL, "baseUrl");
        Intrinsics.checkNotNullParameter(CommsModule.SHARED_PREFERENCE_NAME, "clientSharedPrefsName");
        Intrinsics.checkNotNullParameter("PROD", PaymentConstants.ENV);
        Intrinsics.checkNotNullParameter(BuildConfig.MIXPANEL_KEY, "mixpanelKey");
        Intrinsics.checkNotNullParameter(BuildConfig.DEFAULT_DEEPLINK_URL, "defaultDeeplinkUrl");
        Intrinsics.checkNotNullParameter(this, "context");
        FalconContextContainer.f20435a = this;
        FalconConfig.Companion companion = FalconConfig.f20433a;
        Intrinsics.checkNotNullParameter(BuildConfig.EVENT_SERVICE_BASE_URL, "baseUrl");
        Intrinsics.checkNotNullParameter(CommsModule.SHARED_PREFERENCE_NAME, "clientSharedPrefsName");
        Intrinsics.checkNotNullParameter("PROD", PaymentConstants.ENV);
        Intrinsics.checkNotNullParameter(BuildConfig.MIXPANEL_KEY, "mixpanelKey");
        Intrinsics.checkNotNullParameter(BuildConfig.DEFAULT_DEEPLINK_URL, "defaultDeeplinkUrl");
        if (FalconConfig.f20434b == null) {
            synchronized (companion) {
                try {
                    if (FalconConfig.f20434b == null) {
                        FalconConfig.f20434b = new FalconConfig();
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        SilentPushRegistry silentPushRegistry = SilentPushRegistry.f47702a;
        Intrinsics.checkNotNullParameter(this, "context");
        if (SilentPushRegistry.f47703b) {
            Timber.d("SilentPush").d("SilentPushRegistry already initialized, skipping.", new Object[0]);
            return;
        }
        synchronized (silentPushRegistry) {
            if (SilentPushRegistry.f47703b) {
                return;
            }
            try {
                SilentPushRegistry.f47705d = getApplicationContext();
                SilentPushRegistry.f();
                SilentPushRegistry.f47703b = true;
                Timber.d("SilentPush").i("SilentPushRegistry initialized successfully", new Object[0]);
            } catch (Throwable th2) {
                Timber.d("SilentPush").e(th2, "Failed to initialize SilentPushRegistry", new Object[0]);
            }
            Unit unit2 = Unit.f53572a;
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onLowMemory() {
        ImagePipeline imagePipelineA;
        super.onLowMemory();
        boolean z = AppLifecycleManager.f47550a;
        try {
            if (!Fresco.f17199b || (imagePipelineA = Fresco.a()) == null) {
                return;
            }
            imagePipelineA.a();
        } catch (Exception e2) {
            Timber.d("AppLifecycleManager").e(e2, "Error in low memory callback", new Object[0]);
        }
    }

    @Override // android.app.Application
    public final void onTerminate() {
        super.onTerminate();
        ContextScope contextScope = AppCoroutineManager.f47545b;
        if (contextScope != null) {
            CoroutineScopeKt.b(contextScope, null);
        }
        ContextScope contextScope2 = AppCoroutineManager.f47546c;
        if (contextScope2 != null) {
            CoroutineScopeKt.b(contextScope2, null);
        }
        ContextScope contextScope3 = AppCoroutineManager.f47547d;
        if (contextScope3 != null) {
            CoroutineScopeKt.b(contextScope3, null);
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        ImagePipeline imagePipelineA;
        super.onTrimMemory(i2);
        boolean z = AppLifecycleManager.f47550a;
        if (i2 >= 60) {
            try {
                if (!Fresco.f17199b || (imagePipelineA = Fresco.a()) == null) {
                    return;
                }
                imagePipelineA.a();
            } catch (Exception e2) {
                Timber.d("AppLifecycleManager").e(e2, "Error in trim memory callback", new Object[0]);
            }
        }
    }
}
