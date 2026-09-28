package io.sentry.react;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.util.e;
import androidx.media3.exoplayer.analytics.d;
import androidx.work.impl.c;
import com.facebook.hermes.instrumentation.HermesSamplingProfiler;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.common.Scopes;
import com.reactnativecommunity.clipboard.ClipboardModule;
import io.sentry.Breadcrumb;
import io.sentry.HubAdapter;
import io.sentry.IScope;
import io.sentry.Sentry;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.AndroidProfiler;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.InternalSentrySdk;
import io.sentry.android.core.SentryAndroid;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.ViewHierarchyEventProcessor;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.util.FileUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.vendor.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNSentryModule extends ReactContextBaseJavaModule {
    private final RNSentryModuleImpl impl;

    public RNSentryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.impl = new RNSentryModuleImpl(reactApplicationContext);
    }

    @ReactMethod
    public void addBreadcrumb(ReadableMap readableMap) {
        this.impl.getClass();
        Sentry.c(new c(readableMap, 9));
    }

    @ReactMethod
    public void addListener(String str) {
        this.impl.getClass();
        RNSentryModuleImpl.f52986l.c(SentryLevel.ERROR, "addListener of NativeEventEmitter can't be used on Android!", new Object[0]);
    }

    @ReactMethod
    public void captureEnvelope(String str, ReadableMap readableMap, Promise promise) {
        this.impl.getClass();
        try {
            InternalSentrySdk.b(Base64.a(str), (readableMap.hasKey("hardCrashed") && readableMap.getBoolean("hardCrashed")) ? false : true);
        } catch (Throwable unused) {
            RNSentryModuleImpl.f52986l.c(SentryLevel.ERROR, "Error while capturing envelope", new Object[0]);
            promise.resolve(Boolean.FALSE);
        }
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public void captureReplay(boolean z, Promise promise) {
        SentryId sentryIdZ;
        this.impl.getClass();
        Sentry.d().y().getReplayController().b(Boolean.valueOf(z));
        IScope iScopeE = InternalSentrySdk.e();
        promise.resolve((iScopeE == null || (sentryIdZ = iScopeE.z()) == SentryId.f52907b) ? null : sentryIdZ.toString());
    }

    @ReactMethod
    public void captureScreenshot(Promise promise) throws JSONException, IllegalAccessException, InterruptedException, InstantiationException {
        byte[] bArr;
        Activity currentActivity = this.impl.f52988a.getCurrentActivity();
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        if (currentActivity == null) {
            androidLogger.c(SentryLevel.WARNING, "CurrentActivity is null, can't capture screenshot.", new Object[0]);
            promise.resolve(null);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        byte[][] bArr2 = {new byte[0]};
        e eVar = new e(bArr2, currentActivity, countDownLatch, 25);
        if (UiThreadUtil.isOnUiThread()) {
            eVar.run();
        } else {
            UiThreadUtil.runOnUiThread(eVar);
        }
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
            bArr = bArr2[0];
        } catch (InterruptedException unused) {
            androidLogger.c(SentryLevel.ERROR, "Screenshot process was interrupted.", new Object[0]);
            bArr = new byte[0];
        }
        if (bArr == null || bArr.length == 0) {
            androidLogger.c(SentryLevel.WARNING, "Screenshot is null, screen was not captured.", new Object[0]);
            promise.resolve(null);
            return;
        }
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (byte b2 : bArr) {
            writableNativeArray.pushInt(b2);
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("contentType", ClipboardModule.MIMETYPE_PNG);
        writableNativeMap.putArray("data", writableNativeArray);
        writableNativeMap.putString("filename", "screenshot.png");
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        writableNativeArray2.pushMap(writableNativeMap);
        promise.resolve(writableNativeArray2);
    }

    @ReactMethod
    public void clearBreadcrumbs() {
        this.impl.getClass();
        Sentry.c(new com.google.common.net.a(9));
    }

    @ReactMethod
    public void closeNativeSdk(Promise promise) {
        FrameMetricsAggregator frameMetricsAggregator;
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.getClass();
        Sentry.b();
        if (rNSentryModuleImpl.f52991d && (frameMetricsAggregator = rNSentryModuleImpl.f52990c) != null) {
            frameMetricsAggregator.e();
            rNSentryModuleImpl.f52990c = null;
        }
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public void crash() {
        this.impl.getClass();
        throw new RuntimeException("TEST - Sentry Client Crash (only works in release mode)");
    }

    @ReactMethod
    public void crashedLastRun(Promise promise) {
        this.impl.getClass();
        promise.resolve(Sentry.d().C());
    }

    @ReactMethod
    public void disableNativeFramesTracking() {
        FrameMetricsAggregator frameMetricsAggregator;
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        if (!rNSentryModuleImpl.f52991d || (frameMetricsAggregator = rNSentryModuleImpl.f52990c) == null) {
            return;
        }
        frameMetricsAggregator.e();
        rNSentryModuleImpl.f52990c = null;
    }

    @ReactMethod
    public void enableNativeFramesTracking() {
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.f52991d = true;
        rNSentryModuleImpl.f52990c = new FrameMetricsAggregator();
        Activity currentActivity = rNSentryModuleImpl.f52988a.getCurrentActivity();
        FrameMetricsAggregator frameMetricsAggregator = rNSentryModuleImpl.f52990c;
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        if (frameMetricsAggregator == null || currentActivity == null) {
            androidLogger.c(SentryLevel.INFO, "currentActivity isn't available.", new Object[0]);
            return;
        }
        try {
            frameMetricsAggregator.a(currentActivity);
            androidLogger.c(SentryLevel.INFO, "FrameMetricsAggregator installed.", new Object[0]);
        } catch (Throwable unused) {
            androidLogger.c(SentryLevel.ERROR, "Error adding Activity to frameMetricsAggregator.", new Object[0]);
        }
    }

    @ReactMethod
    public void fetchModules(Promise promise) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.impl.f52988a.getResources().getAssets().open("modules.json"));
            try {
                byte[] bArr = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bArr);
                bufferedInputStream.close();
                promise.resolve(new String(bArr, RNSentryModuleImpl.n));
                bufferedInputStream.close();
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            promise.resolve(null);
        } catch (Throwable unused2) {
            RNSentryModuleImpl.f52986l.c(SentryLevel.WARNING, "Fetching JS Modules failed.", new Object[0]);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void fetchNativeAppStart(Promise promise) {
        this.impl.getClass();
        AppStartMetrics appStartMetricsB = AppStartMetrics.b();
        HashMap mapD = InternalSentrySdk.d();
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        if (!appStartMetricsB.f52368b) {
            androidLogger.c(SentryLevel.WARNING, "Invalid app start data: app not launched in foreground.", new Object[0]);
            promise.resolve(null);
            return;
        }
        WritableMap writableMap = (WritableMap) RNSentryMapConverter.a(mapD);
        long j2 = appStartMetricsB.f52369c.f52381b;
        long j3 = RNSentryModuleImpl.o;
        boolean z = j3 > 0 && j3 == j2;
        writableMap.putBoolean("has_fetched", z);
        if (RNSentryModuleImpl.o < 0) {
            androidLogger.c(SentryLevel.DEBUG, "App Start data reported to the RN layer for the first time.", new Object[0]);
        } else if (z) {
            androidLogger.c(SentryLevel.DEBUG, "App Start data already fetched from native before.", new Object[0]);
        } else {
            androidLogger.c(SentryLevel.DEBUG, "App Start data updated, reporting to the RN layer again.", new Object[0]);
        }
        RNSentryModuleImpl.o = j2;
        appStartMetricsB.f52377k = false;
        appStartMetricsB.f52372f.clear();
        appStartMetricsB.f52373g.clear();
        promise.resolve(writableMap);
    }

    @ReactMethod
    public void fetchNativeDeviceContexts(Promise promise) {
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.getClass();
        SentryOptions sentryOptionsY = HubAdapter.f51658a.y();
        Context applicationContext = rNSentryModuleImpl.f52988a.getApplicationContext();
        IScope iScopeE = InternalSentrySdk.e();
        if (!(sentryOptionsY instanceof SentryAndroidOptions)) {
            promise.resolve(null);
            return;
        }
        if (applicationContext == null) {
            promise.resolve(null);
            return;
        }
        if (iScopeE != null) {
            Iterator it = iScopeE.i().iterator();
            while (it.hasNext()) {
                if ("react-native".equals(((Breadcrumb) it.next()).f51561g)) {
                    it.remove();
                }
            }
        }
        promise.resolve(RNSentryMapConverter.a(InternalSentrySdk.f(applicationContext, (SentryAndroidOptions) sentryOptionsY, iScopeE)));
    }

    @ReactMethod
    public void fetchNativeFrames(Promise promise) {
        int i2;
        int i3;
        int i4;
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        if (!(rNSentryModuleImpl.f52991d && rNSentryModuleImpl.f52990c != null)) {
            promise.resolve(null);
            return;
        }
        try {
            SparseIntArray sparseIntArray = rNSentryModuleImpl.f52990c.b()[0];
            if (sparseIntArray != null) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                    int iKeyAt = sparseIntArray.keyAt(i5);
                    int iValueAt = sparseIntArray.valueAt(i5);
                    i2 += iValueAt;
                    if (iKeyAt > 700) {
                        i4 += iValueAt;
                    } else if (iKeyAt > 16) {
                        i3 += iValueAt;
                    }
                }
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("totalFrames", i2);
            writableMapCreateMap.putInt("slowFrames", i3);
            writableMapCreateMap.putInt("frozenFrames", i4);
            promise.resolve(writableMapCreateMap);
        } catch (Throwable unused) {
            RNSentryModuleImpl.f52986l.c(SentryLevel.WARNING, "Error fetching native frames.", new Object[0]);
            promise.resolve(null);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String fetchNativePackageName() {
        return this.impl.f52989b.packageName;
    }

    @ReactMethod
    public void fetchNativeRelease(Promise promise) {
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.getClass();
        WritableMap writableMapCreateMap = Arguments.createMap();
        PackageInfo packageInfo = rNSentryModuleImpl.f52989b;
        writableMapCreateMap.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, packageInfo.packageName);
        writableMapCreateMap.putString("version", packageInfo.versionName);
        writableMapCreateMap.putString("build", String.valueOf(packageInfo.versionCode));
        promise.resolve(writableMapCreateMap);
    }

    @ReactMethod
    public void fetchNativeSdkInfo(Promise promise) {
        this.impl.getClass();
        SdkVersion sdkVersion = HubAdapter.f51658a.y().getSdkVersion();
        if (sdkVersion == null) {
            promise.resolve(null);
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(CLConstants.FIELD_PAY_INFO_NAME, sdkVersion.f52895a);
        writableNativeMap.putString("version", sdkVersion.f52896b);
        promise.resolve(writableNativeMap);
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap fetchNativeStackFramesBy(ReadableArray readableArray) {
        return null;
    }

    @ReactMethod
    public void fetchViewHierarchy(Promise promise) {
        Activity currentActivity = this.impl.f52988a.getCurrentActivity();
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        ViewHierarchy viewHierarchyE = ViewHierarchyEventProcessor.e(currentActivity, new ArrayList(0), AndroidMainThreadChecker.f52307a, androidLogger);
        if (viewHierarchyE == null) {
            androidLogger.c(SentryLevel.ERROR, "Could not get ViewHierarchy.", new Object[0]);
            promise.resolve(null);
            return;
        }
        byte[] bArrB = JsonSerializationUtils.b(HubAdapter.f51658a.y().getSerializer(), androidLogger, viewHierarchyE);
        if (bArrB == null) {
            androidLogger.c(SentryLevel.ERROR, "Could not serialize ViewHierarchy.", new Object[0]);
            promise.resolve(null);
        } else {
            if (bArrB.length < 1) {
                androidLogger.c(SentryLevel.ERROR, "Got empty bytes array after serializing ViewHierarchy.", new Object[0]);
                promise.resolve(null);
                return;
            }
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            for (byte b2 : bArrB) {
                writableNativeArray.pushInt(b2);
            }
            promise.resolve(writableNativeArray);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getCurrentReplayId() {
        SentryId sentryIdZ;
        this.impl.getClass();
        IScope iScopeE = InternalSentrySdk.e();
        if (iScopeE == null || (sentryIdZ = iScopeE.z()) == SentryId.f52907b) {
            return null;
        }
        return sentryIdZ.toString();
    }

    @ReactMethod
    public void getDataFromUri(String str, Promise promise) throws IOException {
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.getClass();
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        try {
            InputStream inputStreamOpenInputStream = rNSentryModuleImpl.f52988a.getContentResolver().openInputStream(Uri.parse(str));
            try {
                if (inputStreamOpenInputStream == null) {
                    String str2 = "File not found for uri: " + str;
                    androidLogger.c(SentryLevel.ERROR, str2, new Object[0]);
                    promise.reject(new Exception(str2));
                    if (inputStreamOpenInputStream == null) {
                        return;
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, i2);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (byte b2 : byteArray) {
                        writableArrayCreateArray.pushInt(b2 & 255);
                    }
                    promise.resolve(writableArrayCreateArray);
                }
                inputStreamOpenInputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            StringBuilder sbY = android.support.v4.media.b.y("Error reading uri: ", str, ": ");
            sbY.append(e2.getMessage());
            String string = sbY.toString();
            androidLogger.c(SentryLevel.ERROR, string, new Object[0]);
            promise.reject(new Exception(string));
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSentry";
    }

    @ReactMethod
    public void getNewScreenTimeToDisplay(Promise promise) {
        RNSentryTimeToDisplay.a(promise, this.impl.f52998k);
    }

    @ReactMethod
    public void initNativeReactNavigationNewFrameTracking(Promise promise) {
        FragmentManager supportFragmentManager;
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        RNSentryReactFragmentLifecycleTracer rNSentryReactFragmentLifecycleTracer = new RNSentryReactFragmentLifecycleTracer(RNSentryModuleImpl.f52987m, rNSentryModuleImpl.f52997j);
        FragmentActivity fragmentActivity = (FragmentActivity) rNSentryModuleImpl.f52988a.getCurrentActivity();
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.Z(rNSentryReactFragmentLifecycleTracer);
    }

    @ReactMethod
    public void initNativeSdk(ReadableMap readableMap, Promise promise) {
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        Context context = rNSentryModuleImpl.f52988a;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            RNSentryModuleImpl.f52986l.c(SentryLevel.ERROR, "ApplicationContext is null, using ReactApplicationContext fallback.", new Object[0]);
        } else {
            context = applicationContext;
        }
        com.google.firebase.tracing.a aVar = new com.google.firebase.tracing.a(rNSentryModuleImpl, readableMap);
        int i2 = SentryAndroid.f52194b;
        SentryAndroid.b(context, new AndroidLogger(), aVar);
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public void popTimeToDisplayFor(String str, Promise promise) {
        this.impl.getClass();
        if (str != null) {
            promise.resolve(RNSentryTimeToDisplay.b(str));
        } else {
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void removeListeners(double d2) {
        this.impl.getClass();
        RNSentryModuleImpl.f52986l.c(SentryLevel.ERROR, "removeListeners of NativeEventEmitter can't be used on Android!", new Object[0]);
    }

    @ReactMethod
    public boolean setActiveSpanId(String str) {
        this.impl.getClass();
        RNSentryTimeToDisplay.e(str);
        return true;
    }

    @ReactMethod
    public void setContext(String str, ReadableMap readableMap) {
        this.impl.getClass();
        if (str == null) {
            RNSentryModuleImpl.f52986l.c(SentryLevel.ERROR, "RNSentry.setContext called with null key, can't change context.", new Object[0]);
        } else {
            Sentry.c(new d(24, readableMap, str));
        }
    }

    @ReactMethod
    public void setExtra(String str, String str2) {
        this.impl.getClass();
        if (str == null || str2 == null) {
            RNSentryModuleImpl.f52986l.c(SentryLevel.ERROR, "RNSentry.setExtra called with null key or value, can't change extra.", new Object[0]);
        } else {
            Sentry.c(new d(23, str, str2));
        }
    }

    @ReactMethod
    public void setTag(String str, String str2) {
        this.impl.getClass();
        Sentry.c(new a(str, str2));
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap, ReadableMap readableMap2) {
        this.impl.getClass();
        Sentry.c(new d(22, readableMap, readableMap2));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap startProfiling(boolean z) {
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.getClass();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (rNSentryModuleImpl.f52992e == null && z) {
            if (rNSentryModuleImpl.f52996i == null) {
                rNSentryModuleImpl.f52996i = new SentryExecutorService();
            }
            String str = rNSentryModuleImpl.f52995h;
            ReactApplicationContext reactApplicationContext = rNSentryModuleImpl.f52988a;
            if (str == null) {
                rNSentryModuleImpl.f52995h = new File(reactApplicationContext.getCacheDir(), "sentry/react").getAbsolutePath();
            }
            File file = new File(rNSentryModuleImpl.f52995h, "profiling_trace");
            file.mkdirs();
            String absolutePath = file.getAbsolutePath();
            int micros = ((int) TimeUnit.SECONDS.toMicros(1L)) / 101;
            AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
            BuildInfoProvider buildInfoProvider = RNSentryModuleImpl.f52987m;
            rNSentryModuleImpl.f52992e = new AndroidProfiler(absolutePath, micros, new SentryFrameMetricsCollector(reactApplicationContext, androidLogger, buildInfoProvider), rNSentryModuleImpl.f52996i, androidLogger, buildInfoProvider);
        }
        try {
            HermesSamplingProfiler.enable();
            AndroidProfiler androidProfiler = rNSentryModuleImpl.f52992e;
            if (androidProfiler != null) {
                androidProfiler.d();
            }
            writableNativeMap.putBoolean("started", true);
            return writableNativeMap;
        } catch (Throwable th) {
            writableNativeMap.putBoolean("started", false);
            writableNativeMap.putString("error", th.toString());
            return writableNativeMap;
        }
    }

    /* JADX WARN: Finally extract failed */
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap stopProfiling() {
        AndroidProfiler.ProfileEndData profileEndDataB;
        BufferedReader bufferedReader;
        RNSentryModuleImpl rNSentryModuleImpl = this.impl;
        rNSentryModuleImpl.getClass();
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        boolean zIsDebug = HubAdapter.f51658a.y().isDebug();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        File fileCreateTempFile = null;
        try {
            AndroidProfiler androidProfiler = rNSentryModuleImpl.f52992e;
            profileEndDataB = androidProfiler != null ? androidProfiler.b(null, false) : null;
            HermesSamplingProfiler.disable();
            fileCreateTempFile = File.createTempFile("sampling-profiler-trace", ".cpuprofile", rNSentryModuleImpl.f52988a.getCacheDir());
            if (zIsDebug) {
                androidLogger.c(SentryLevel.INFO, "Profile saved to: " + fileCreateTempFile.getAbsolutePath(), new Object[0]);
            }
            HermesSamplingProfiler.dumpSampledTraceToFile(fileCreateTempFile.getPath());
            bufferedReader = new BufferedReader(new FileReader(fileCreateTempFile));
        } catch (Throwable th) {
            try {
                writableNativeMap.putString("error", th.toString());
                if (fileCreateTempFile != null) {
                    try {
                        if (!fileCreateTempFile.delete()) {
                            androidLogger.c(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                        }
                    } catch (Throwable unused) {
                        androidLogger.c(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                if (fileCreateTempFile != null) {
                    try {
                        if (!fileCreateTempFile.delete()) {
                            androidLogger.c(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                        }
                    } catch (Throwable unused2) {
                        androidLogger.c(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                    }
                }
                throw th2;
            }
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append('\n');
            }
            String string = sb.toString();
            bufferedReader.close();
            writableNativeMap.putString(Scopes.PROFILE, string);
            if (profileEndDataB != null) {
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putString("sampled_profile", Base64.c(FileUtils.b(5242880L, profileEndDataB.f52047c.getPath())));
                RNSentryModuleImpl.f52987m.getClass();
                writableNativeMap2.putInt("android_api_level", Build.VERSION.SDK_INT);
                writableNativeMap2.putString("build_id", rNSentryModuleImpl.a());
                writableNativeMap.putMap("androidProfile", writableNativeMap2);
            }
            try {
                if (!fileCreateTempFile.delete()) {
                    androidLogger.c(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                    return writableNativeMap;
                }
            } catch (Throwable unused3) {
                androidLogger.c(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
            }
            return writableNativeMap;
        } catch (Throwable th3) {
            try {
                bufferedReader.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }
}
