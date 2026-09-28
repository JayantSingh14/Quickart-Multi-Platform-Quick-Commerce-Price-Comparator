package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.e;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.BuildIdInfo;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.c;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Deferred.DeferredHandler, BreadcrumbSource, AnalyticsEventLogger, ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f43697a;

    public /* synthetic */ a(Object obj) {
        this.f43697a = obj;
    }

    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public void a(BreadcrumbHandler breadcrumbHandler) {
        AnalyticsDeferredProxy analyticsDeferredProxy = (AnalyticsDeferredProxy) this.f43697a;
        synchronized (analyticsDeferredProxy) {
            try {
                if (analyticsDeferredProxy.f43688c instanceof DisabledBreadcrumbSource) {
                    analyticsDeferredProxy.f43689d.add(breadcrumbHandler);
                }
                analyticsDeferredProxy.f43688c.a(breadcrumbHandler);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object c(ComponentContainer componentContainer) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        long j2;
        String str;
        IOException iOException;
        FirebaseCrashlytics firebaseCrashlytics;
        int i2 = CrashlyticsRegistrar.f43692d;
        CrashlyticsRegistrar crashlyticsRegistrar = (CrashlyticsRegistrar) this.f43697a;
        crashlyticsRegistrar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.a(FirebaseApp.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class);
        Deferred deferredI = componentContainer.i(CrashlyticsNativeComponent.class);
        Deferred deferredI2 = componentContainer.i(AnalyticsConnector.class);
        Deferred deferredI3 = componentContainer.i(FirebaseRemoteConfigInterop.class);
        ExecutorService executorService = (ExecutorService) componentContainer.e(crashlyticsRegistrar.f43693a);
        ExecutorService executorService2 = (ExecutorService) componentContainer.e(crashlyticsRegistrar.f43694b);
        ExecutorService executorService3 = (ExecutorService) componentContainer.e(crashlyticsRegistrar.f43695c);
        firebaseApp.a();
        Context context = firebaseApp.f43489a;
        String packageName = context.getPackageName();
        Logger logger = Logger.f43705a;
        int i3 = 1;
        logger.d("Initializing Firebase Crashlytics 19.4.4 for " + packageName);
        CrashlyticsWorkers crashlyticsWorkers = new CrashlyticsWorkers(executorService, executorService2);
        FileStore fileStore = new FileStore(context);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        IdManager idManager = new IdManager(context, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferredI);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferredI2);
        CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber = new CrashlyticsAppQualitySessionsSubscriber(dataCollectionArbiter, fileStore);
        FirebaseSessionsDependencies.d(crashlyticsAppQualitySessionsSubscriber);
        CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, new a(analyticsDeferredProxy), new a(analyticsDeferredProxy), fileStore, crashlyticsAppQualitySessionsSubscriber, new RemoteConfigDeferredProxy(deferredI3), crashlyticsWorkers);
        firebaseApp.a();
        String str2 = firebaseApp.f43491c.f43507b;
        int iE = CommonUtils.e(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (iE == 0) {
            iE = CommonUtils.e(context, "com.crashlytics.android.build_id", "string");
        }
        String string = iE != 0 ? context.getResources().getString(iE) : null;
        ArrayList arrayList = new ArrayList();
        int iE2 = CommonUtils.e(context, "com.google.firebase.crashlytics.build_ids_lib", "array");
        int iE3 = CommonUtils.e(context, "com.google.firebase.crashlytics.build_ids_arch", "array");
        int iE4 = CommonUtils.e(context, "com.google.firebase.crashlytics.build_ids_build_id", "array");
        if (iE2 == 0 || iE3 == 0 || iE4 == 0) {
            j2 = jCurrentTimeMillis;
            str = str2;
            iOException = null;
            logger.b(String.format("Could not find resources: %d %d %d", Integer.valueOf(iE2), Integer.valueOf(iE3), Integer.valueOf(iE4)), null);
        } else {
            String[] stringArray = context.getResources().getStringArray(iE2);
            String[] stringArray2 = context.getResources().getStringArray(iE3);
            String[] stringArray3 = context.getResources().getStringArray(iE4);
            j2 = jCurrentTimeMillis;
            if (stringArray.length == stringArray3.length && stringArray2.length == stringArray3.length) {
                int i4 = 0;
                while (i4 < stringArray3.length) {
                    int i5 = i4;
                    arrayList.add(new BuildIdInfo(stringArray[i4], stringArray2[i5], stringArray3[i5]));
                    i4 = i5 + 1;
                    str2 = str2;
                }
                str = str2;
                iOException = null;
            } else {
                str = str2;
                iOException = null;
                logger.b(String.format("Lengths did not match: %d %d %d", Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length)), null);
            }
        }
        logger.b("Mapping file ID is: " + string, iOException);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BuildIdInfo buildIdInfo = (BuildIdInfo) it.next();
            String strC = buildIdInfo.c();
            String strA = buildIdInfo.a();
            String strB = buildIdInfo.b();
            StringBuilder sbV = e.v("Build id for ", strC, " on ", strA, ": ");
            sbV.append(strB);
            logger.b(sbV.toString(), null);
        }
        DevelopmentPlatformProvider developmentPlatformProvider = new DevelopmentPlatformProvider(context);
        try {
            String packageName2 = context.getPackageName();
            String strD = idManager.d();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName2, 0);
            String string2 = Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
            String str3 = packageInfo.versionName;
            if (str3 == null) {
                str3 = "0.0";
            }
            String str4 = str3;
            AppData appData = new AppData(str, string, arrayList, strD, packageName2, string2, str4, developmentPlatformProvider);
            logger.e("Installer package name is: " + strD);
            SettingsController settingsControllerA = SettingsController.a(context, str, idManager, new HttpRequestFactory(), string2, str4, fileStore, dataCollectionArbiter);
            settingsControllerA.e(crashlyticsWorkers).d(executorService3, new androidx.work.impl.model.a(9));
            if (crashlyticsCore.f(appData, settingsControllerA)) {
                crashlyticsCore.p.f43874a.a(new c(i3, crashlyticsCore, settingsControllerA));
            }
            firebaseCrashlytics = new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e2) {
            logger.c("Error retrieving app package info.", e2);
            firebaseCrashlytics = null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j2;
        if (jCurrentTimeMillis2 > 16) {
            logger.b("Initializing Crashlytics blocked main for " + jCurrentTimeMillis2 + " ms", null);
        }
        return firebaseCrashlytics;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void d(Bundle bundle) {
        ((AnalyticsDeferredProxy) this.f43697a).f43687b.d(bundle);
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void f(Provider provider) {
        AnalyticsDeferredProxy analyticsDeferredProxy = (AnalyticsDeferredProxy) this.f43697a;
        analyticsDeferredProxy.getClass();
        Logger logger = Logger.f43705a;
        logger.b("AnalyticsConnector now available.", null);
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) provider.get();
        CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
        CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleC = analyticsConnector.c("clx", crashlyticsAnalyticsListener);
        if (analyticsConnectorHandleC == null) {
            logger.b("Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
            analyticsConnectorHandleC = analyticsConnector.c("crash", crashlyticsAnalyticsListener);
            if (analyticsConnectorHandleC != null) {
                logger.f("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
            }
        }
        if (analyticsConnectorHandleC == null) {
            logger.f("Could not register Firebase Analytics listener; a listener is already registered.", null);
            return;
        }
        logger.b("Registered Firebase Analytics listener.", null);
        BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger);
        synchronized (analyticsDeferredProxy) {
            try {
                Iterator it = analyticsDeferredProxy.f43689d.iterator();
                while (it.hasNext()) {
                    breadcrumbAnalyticsEventReceiver.a((BreadcrumbHandler) it.next());
                }
                crashlyticsAnalyticsListener.f43691b = breadcrumbAnalyticsEventReceiver;
                crashlyticsAnalyticsListener.f43690a = blockingAnalyticsEventLogger;
                analyticsDeferredProxy.f43688c = breadcrumbAnalyticsEventReceiver;
                analyticsDeferredProxy.f43687b = blockingAnalyticsEventLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
