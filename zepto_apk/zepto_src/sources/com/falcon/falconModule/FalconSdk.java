package com.falcon.falconModule;

import android.app.NotificationManager;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.support.v4.media.a;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.falcon.falconModule.StorageHelper;
import com.falcon.notification.constants.NotificationConfig;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FalconSdk extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String MODULE_NAME = "FalconSdk";

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FalconSdk(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @ReactMethod
    public final void dismissStickyNotification(@NotNull String category, @NotNull ReadableMap data) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(data, "data");
        ReactApplicationContext context = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "getReactApplicationContext(...)");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationCategory[] notificationCategoryArr = NotificationCategory.f20448a;
        if (!Intrinsics.b(category, "PROMO_CASH_ONGOING")) {
            a.t("cancelStickyNotification: No handler for category=", category, "FalconNotificationUtils");
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            NotificationDataMap[] notificationDataMapArr = NotificationDataMap.f20450a;
            String string = data.getString("orderPlaceTime");
            StatusBarNotification statusBarNotification = null;
            Long lValueOf = string != null ? Long.valueOf(Long.parseLong(string)) : null;
            if (lValueOf == null) {
                Log.w("FalconNotificationUtils", "dismissPromoCashOngoingNotification: orderPlaceTime is null");
                return;
            }
            Object systemService = context.getSystemService("notification");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            Intrinsics.c(activeNotifications);
            int length = activeNotifications.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StatusBarNotification statusBarNotification2 = activeNotifications[i2];
                Bundle bundle = statusBarNotification2.getNotification().extras;
                NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
                long j2 = bundle.getLong("sticky_notification_creation_time", 0L);
                if (j2 > 0 && j2 < lValueOf.longValue()) {
                    statusBarNotification = statusBarNotification2;
                    break;
                }
                i2++;
            }
            if (statusBarNotification == null) {
                Log.d("FalconNotificationUtils", "dismissPromoCashOngoingNotification: No matching sticky notification found");
                return;
            }
            notificationManager.cancel(statusBarNotification.getId());
            Log.d("FalconNotificationUtils", "dismissPromoCashOngoingNotification: Cancelled sticky notification " + statusBarNotification.getId());
        } catch (Exception e2) {
            Log.e("FalconNotificationUtils", "dismissPromoCashOngoingNotification: Error " + e2.getMessage(), e2);
        }
    }

    @ReactMethod
    public final void getId(@NotNull String key, @NotNull Promise promise) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Gson gsonA = FalconNotificationUtils.a();
        StorageHelper.f20452a.a();
        try {
            objE = gsonA.e(StorageHelper.a(key), new TypeToken<String>() { // from class: com.falcon.falconModule.FalconSdk$getId$$inlined$get$1
            }.f45460b);
        } catch (Exception e2) {
            Log.w("FalconNotificationUtils", "Failed to parse JSON for key=" + key + ": " + e2.getMessage());
            objE = null;
        }
        String str = (String) objE;
        if (str != null) {
            promise.resolve(str);
        } else {
            promise.resolve(Arguments.createMap());
        }
    }

    @ReactMethod
    public final void getMeta(@NotNull String key, @NotNull Promise promise) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Gson gsonA = FalconNotificationUtils.a();
        StorageHelper.f20452a.a();
        try {
            objE = gsonA.e(StorageHelper.a(key), new TypeToken<Map<String, ? extends Object>>() { // from class: com.falcon.falconModule.FalconSdk$getMeta$$inlined$get$1
            }.f45460b);
        } catch (Exception e2) {
            Log.w("FalconNotificationUtils", "Failed to parse JSON for key=" + key + ": " + e2.getMessage());
            objE = null;
        }
        Map map = (Map) objE;
        if (map != null) {
            promise.resolve(Arguments.makeNativeMap((Map<String, Object>) map));
        } else {
            promise.resolve(Arguments.createMap());
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public final void setId(@NotNull String key, @NotNull String id) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(id, "id");
        try {
            Gson gsonA = FalconNotificationUtils.a();
            Gson gsonA2 = FalconNotificationUtils.a();
            StorageHelper.Companion companion = StorageHelper.f20452a;
            companion.a();
            try {
                objE = gsonA2.e(StorageHelper.a(key), new TypeToken<String>() { // from class: com.falcon.falconModule.FalconSdk$setId$$inlined$set$1
                }.f45460b);
            } catch (Exception e2) {
                Log.w("FalconNotificationUtils", "Failed to parse JSON for key=" + key + ": " + e2.getMessage());
                objE = null;
            }
            JsonElement jsonElementM = gsonA.m(objE);
            JsonObject jsonObject = (jsonElementM == null || !(jsonElementM instanceof JsonObject)) ? new JsonObject() : jsonElementM.f();
            JsonElement jsonElementM2 = gsonA.m(id);
            jsonElementM2.getClass();
            if (jsonElementM2 instanceof JsonObject) {
                FalconNotificationUtils.d(jsonObject, jsonElementM2.f());
            } else {
                jsonObject = jsonElementM2;
            }
            companion.a();
            String strI = gsonA.i(jsonObject);
            Intrinsics.checkNotNullExpressionValue(strI, "toJson(...)");
            StorageHelper.b(key, strI);
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public final void setMeta(@NotNull String key, @NotNull ReadableMap value) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            HashMap<String, Object> hashMap = value.toHashMap();
            Gson gsonA = FalconNotificationUtils.a();
            Gson gsonA2 = FalconNotificationUtils.a();
            StorageHelper.Companion companion = StorageHelper.f20452a;
            companion.a();
            try {
                objE = gsonA2.e(StorageHelper.a(key), new TypeToken<HashMap<String, Object>>() { // from class: com.falcon.falconModule.FalconSdk$setMeta$$inlined$set$1
                }.f45460b);
            } catch (Exception e2) {
                Log.w("FalconNotificationUtils", "Failed to parse JSON for key=" + key + ": " + e2.getMessage());
                objE = null;
            }
            JsonElement jsonElementM = gsonA.m(objE);
            JsonObject jsonObject = (jsonElementM == null || !(jsonElementM instanceof JsonObject)) ? new JsonObject() : jsonElementM.f();
            JsonElement jsonElementM2 = gsonA.m(hashMap);
            jsonElementM2.getClass();
            if (jsonElementM2 instanceof JsonObject) {
                FalconNotificationUtils.d(jsonObject, jsonElementM2.f());
            } else {
                jsonObject = jsonElementM2;
            }
            companion.a();
            String strI = gsonA.i(jsonObject);
            Intrinsics.checkNotNullExpressionValue(strI, "toJson(...)");
            StorageHelper.b(key, strI);
        } catch (Exception unused) {
        }
    }
}
