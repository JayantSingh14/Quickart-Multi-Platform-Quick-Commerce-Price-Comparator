package com.sudoplz.rninappupdates;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.e;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = SpReactNativeInAppUpdatesModule.NAME)
/* loaded from: classes.dex */
public class SpReactNativeInAppUpdatesModule extends ReactContextBaseJavaModule implements InstallStateUpdatedListener, ActivityEventListener {
    public static int IN_APP_UPDATE_REQUEST_CODE = 42139;
    public static String IN_APP_UPDATE_RESULT_KEY = "in_app_update_result";
    public static String IN_APP_UPDATE_STATUS_KEY = "in_app_update_status";
    public static final String NAME = "SpInAppUpdates";
    private AppUpdateManager appUpdateManager;
    private boolean subscribedToUpdateStatuses;

    public SpReactNativeInAppUpdatesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.appUpdateManager = null;
        this.subscribedToUpdateStatuses = false;
        AppUpdateManager appUpdateManagerA = AppUpdateManagerFactory.a(reactApplicationContext);
        this.appUpdateManager = appUpdateManagerA;
        appUpdateManagerA.a(this);
        reactApplicationContext.addActivityEventListener(this);
    }

    @MainThread
    private void emitToJS(String str, String str2) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext == null || !reactApplicationContext.hasActiveCatalystInstance()) {
            return;
        }
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, str2);
        } catch (Exception e2) {
            Log.wtf("InAppUpdates_EMITTER", "Error sending Event: sp_in_app_updates_" + str, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkNeedsUpdate$0(Promise promise, Exception exc) {
        promise.reject("Exception", exc.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$checkNeedsUpdate$1(Promise promise, AppUpdateInfo appUpdateInfo) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("updateAvailability", appUpdateInfo.f41662c);
        writableMapCreateMap.putBoolean("isImmediateUpdateAllowed", appUpdateInfo.a(AppUpdateOptions.c(1)) != null);
        writableMapCreateMap.putBoolean("isFlexibleUpdateAllowed", appUpdateInfo.a(AppUpdateOptions.c(0)) != null);
        writableMapCreateMap.putInt("updatePriority", appUpdateInfo.f41664e);
        Integer num = appUpdateInfo.f41663d;
        if (num != null) {
            writableMapCreateMap.putInt("dayStaleness", num.intValue());
        }
        writableMapCreateMap.putInt("versionCode", appUpdateInfo.f41661b);
        String str = appUpdateInfo.f41660a;
        if (str != null) {
            writableMapCreateMap.putString("packageName", str);
        }
        long j2 = appUpdateInfo.f41665f;
        if (j2 >= 0) {
            writableMapCreateMap.putDouble("totalBytes", j2);
        }
        promise.resolve(writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startUpdate$2(Promise promise, Exception exc) {
        promise.reject("Exception", exc.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$startUpdate$3(Promise promise, int i2, AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.f41662c != 2) {
            promise.reject("Error", "Update unavailable, check checkNeedsUpdate.updateAvailability first");
            return;
        }
        if (appUpdateInfo.a(AppUpdateOptions.c(i2)) == null) {
            promise.reject("Error", "Update type unavailable, check checkNeedsUpdate.isImmediateUpdateAllowed or checkNeedsUpdate.isFlexibleUpdateAllowed first.");
            return;
        }
        try {
            this.appUpdateManager.d(appUpdateInfo, i2, getCurrentActivity(), IN_APP_UPDATE_REQUEST_CODE);
            promise.resolve("Done");
        } catch (IntentSender.SendIntentException e2) {
            promise.reject("SendIntentException", "Error while starting the update flow: " + e2.toString());
        }
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void checkNeedsUpdate(Promise promise) {
        Task taskC = this.appUpdateManager.c();
        taskC.c(new a(0, promise));
        taskC.e(new a(1, promise));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("IN_APP_UPDATE_RESULT_KEY", IN_APP_UPDATE_RESULT_KEY);
        map.put("IN_APP_UPDATE_STATUS_KEY", IN_APP_UPDATE_STATUS_KEY);
        map.put("UPDATE_AVAILABLE", 2);
        map.put("UPDATE_NOT_AVAILABLE", 1);
        map.put("UPDATE_UNKNOWN", 0);
        e.x(6, 3, "UPDATE_DEV_TRIGGERED", "INSTALL_STATUS_CANCELED", map);
        map.put("INSTALL_STATUS_DOWNLOADED", 11);
        map.put("INSTALL_STATUS_DOWNLOADING", 2);
        android.support.v4.media.b.z(5, map, "INSTALL_STATUS_FAILED", 4, "INSTALL_STATUS_INSTALLED");
        map.put("INSTALL_STATUS_INSTALLING", 3);
        map.put("INSTALL_STATUS_PENDING", 1);
        map.put("APP_UPDATE_IMMEDIATE", 1);
        map.put("APP_UPDATE_FLEXIBLE", 0);
        return map;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void installUpdate() {
        this.appUpdateManager.b();
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        if (i2 != IN_APP_UPDATE_REQUEST_CODE) {
            return;
        }
        emitToJS(IN_APP_UPDATE_RESULT_KEY, String.valueOf(i3 == -1 ? 4 : 6));
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void removeListeners(double d2) {
    }

    @ReactMethod
    public void setStatusUpdateSubscription(Boolean bool) {
        this.subscribedToUpdateStatuses = bool.booleanValue();
    }

    @ReactMethod
    public void startUpdate(int i2, Promise promise) {
        Task taskC = this.appUpdateManager.c();
        taskC.c(new b(0, promise));
        taskC.e(new com.google.android.datatransport.runtime.scheduling.jobscheduling.b(i2, this, promise));
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public void onStateUpdate(InstallState installState) {
        if (this.subscribedToUpdateStatuses) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt(CLConstants.OTP_STATUS, installState.c());
            writableMapCreateMap.putString("bytesDownloaded", installState.a() + "");
            writableMapCreateMap.putString("totalBytesToDownload", installState.e() + "");
            emitToJS(IN_APP_UPDATE_STATUS_KEY, writableMapCreateMap);
        }
    }

    @MainThread
    private void emitToJS(String str, ReadableMap readableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext == null || !reactApplicationContext.hasActiveCatalystInstance()) {
            return;
        }
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, readableMap);
        } catch (Exception e2) {
            Log.wtf("InAppUpdates_EMITTER", "Error sending Event: sp_in_app_updates_" + str, e2);
        }
    }
}
