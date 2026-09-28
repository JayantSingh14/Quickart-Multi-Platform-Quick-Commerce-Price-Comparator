package com.zoontek.rnpermissions;

import android.Manifest;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import in.juspay.airborne.ota.Constants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = RNPermissionsModule.NAME)
/* loaded from: classes.dex */
public class RNPermissionsModule extends NativePermissionsModuleSpec implements PermissionListener {
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    public static final String NAME = "RNPermissionsModule";
    private final String BLOCKED;
    private final String DENIED;
    private final String GRANTED;
    private final String UNAVAILABLE;
    private final SparseArray<Callback> mCallbacks;
    private int mRequestCode;

    public RNPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRequestCode = 0;
        this.GRANTED = "granted";
        this.DENIED = "denied";
        this.UNAVAILABLE = "unavailable";
        this.BLOCKED = "blocked";
        this.mCallbacks = new SparseArray<>();
    }

    @Nullable
    private String getFieldName(String str) {
        if (str.equals("android.permission.ACCEPT_HANDOVER")) {
            return "ACCEPT_HANDOVER";
        }
        if (str.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return "ACCESS_BACKGROUND_LOCATION";
        }
        if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
            return "ACCESS_COARSE_LOCATION";
        }
        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
            return "ACCESS_FINE_LOCATION";
        }
        if (str.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
            return "ACCESS_MEDIA_LOCATION";
        }
        if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
            return "ACTIVITY_RECOGNITION";
        }
        if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
            return "ADD_VOICEMAIL";
        }
        if (str.equals("android.permission.ANSWER_PHONE_CALLS")) {
            return "ANSWER_PHONE_CALLS";
        }
        if (str.equals("android.permission.BLUETOOTH_ADVERTISE")) {
            return "BLUETOOTH_ADVERTISE";
        }
        if (str.equals("android.permission.BLUETOOTH_CONNECT")) {
            return "BLUETOOTH_CONNECT";
        }
        if (str.equals("android.permission.BLUETOOTH_SCAN")) {
            return "BLUETOOTH_SCAN";
        }
        if (str.equals("android.permission.BODY_SENSORS")) {
            return "BODY_SENSORS";
        }
        if (str.equals("android.permission.BODY_SENSORS_BACKGROUND")) {
            return "BODY_SENSORS_BACKGROUND";
        }
        if (str.equals("android.permission.CALL_PHONE")) {
            return "CALL_PHONE";
        }
        if (str.equals("android.permission.CAMERA")) {
            return "CAMERA";
        }
        if (str.equals("android.permission.GET_ACCOUNTS")) {
            return "GET_ACCOUNTS";
        }
        if (str.equals("android.permission.NEARBY_WIFI_DEVICES")) {
            return "NEARBY_WIFI_DEVICES";
        }
        if (str.equals("android.permission.POST_NOTIFICATIONS")) {
            return "POST_NOTIFICATIONS";
        }
        if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
            return "PROCESS_OUTGOING_CALLS";
        }
        if (str.equals("android.permission.READ_CALENDAR")) {
            return "READ_CALENDAR";
        }
        if (str.equals("android.permission.READ_CALL_LOG")) {
            return "READ_CALL_LOG";
        }
        if (str.equals("android.permission.READ_CONTACTS")) {
            return "READ_CONTACTS";
        }
        if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
            return "READ_EXTERNAL_STORAGE";
        }
        if (str.equals("android.permission.READ_MEDIA_AUDIO")) {
            return "READ_MEDIA_AUDIO";
        }
        if (str.equals("android.permission.READ_MEDIA_IMAGES")) {
            return "READ_MEDIA_IMAGES";
        }
        if (str.equals("android.permission.READ_MEDIA_VIDEO")) {
            return "READ_MEDIA_VIDEO";
        }
        if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
            return "READ_PHONE_NUMBERS";
        }
        if (str.equals("android.permission.READ_PHONE_STATE")) {
            return "READ_PHONE_STATE";
        }
        if (str.equals("android.permission.READ_SMS")) {
            return "READ_SMS";
        }
        if (str.equals("android.permission.RECEIVE_MMS")) {
            return "RECEIVE_MMS";
        }
        if (str.equals("android.permission.RECEIVE_SMS")) {
            return "RECEIVE_SMS";
        }
        if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
            return "RECEIVE_WAP_PUSH";
        }
        if (str.equals("android.permission.RECORD_AUDIO")) {
            return "RECORD_AUDIO";
        }
        if (str.equals("android.permission.SEND_SMS")) {
            return PaymentConstants.SEND_SMS;
        }
        if (str.equals("android.permission.USE_SIP")) {
            return "USE_SIP";
        }
        if (str.equals("android.permission.UWB_RANGING")) {
            return "UWB_RANGING";
        }
        if (str.equals("android.permission.WRITE_CALENDAR")) {
            return "WRITE_CALENDAR";
        }
        if (str.equals("android.permission.WRITE_CALL_LOG")) {
            return "WRITE_CALL_LOG";
        }
        if (str.equals("android.permission.WRITE_CONTACTS")) {
            return "WRITE_CONTACTS";
        }
        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
            return "WRITE_EXTERNAL_STORAGE";
        }
        return null;
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        ComponentCallbacks2 currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        }
        if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        }
        throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
    }

    private boolean permissionExists(String str) throws NoSuchFieldException {
        String fieldName = getFieldName(str);
        if (fieldName == null) {
            return false;
        }
        try {
            Manifest.permission.class.getField(fieldName);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public void check(String str, Promise promise) {
        promise.reject("Permissions:check", "check is not supported on Android");
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public void checkLocationAccuracy(Promise promise) {
        promise.reject("Permissions:checkLocationAccuracy", "checkLocationAccuracy is not supported on Android");
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void checkMultiplePermissions(ReadableArray readableArray, Promise promise) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Context baseContext = getReactApplicationContext().getBaseContext();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            if (!permissionExists(string)) {
                writableNativeMap.putString(string, "unavailable");
            } else if (baseContext.checkSelfPermission(string) == 0) {
                writableNativeMap.putString(string, "granted");
            } else {
                writableNativeMap.putString(string, "denied");
            }
        }
        promise.resolve(writableNativeMap);
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void checkNotifications(Promise promise) {
        boolean zA = NotificationManagerCompat.c(getReactApplicationContext()).a();
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap.putString(CLConstants.OTP_STATUS, zA ? "granted" : "blocked");
        writableMapCreateMap.putMap("settings", writableMapCreateMap2);
        promise.resolve(writableMapCreateMap);
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void checkPermission(String str, Promise promise) {
        if (str == null || !permissionExists(str)) {
            promise.resolve("unavailable");
        } else if (getReactApplicationContext().getBaseContext().checkSelfPermission(str) == 0) {
            promise.resolve("granted");
        } else {
            promise.resolve("denied");
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public Map<String, Object> getTypedExportedConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mCallbacks.get(i2).invoke(iArr, getPermissionAwareActivity());
        this.mCallbacks.remove(i2);
        return this.mCallbacks.size() == 0;
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public void openLimitedPhotoLibraryPicker(Promise promise) {
        promise.reject("Permissions:openLimitedPhotoLibraryPicker", "openLimitedPhotoLibraryPicker is not supported on Android");
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void openSettings(Promise promise) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intent intent = new Intent();
            String packageName = reactApplicationContext.getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts(Constants.PACKAGE_DIR_NAME, packageName, null));
            reactApplicationContext.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public void request(String str, Promise promise) {
        promise.reject("Permissions:request", "request is not supported on Android");
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public void requestLocationAccuracy(String str, Promise promise) {
        promise.reject("Permissions:requestLocationAccuracy", "requestLocationAccuracy is not supported on Android");
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void requestMultiplePermissions(ReadableArray readableArray, final Promise promise) {
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        final ArrayList arrayList = new ArrayList();
        Context baseContext = getReactApplicationContext().getBaseContext();
        int i2 = 0;
        for (int i3 = 0; i3 < readableArray.size(); i3++) {
            String string = readableArray.getString(i3);
            if (!permissionExists(string)) {
                writableNativeMap.putString(string, "unavailable");
            } else if (baseContext.checkSelfPermission(string) == 0) {
                writableNativeMap.putString(string, "granted");
            } else {
                arrayList.add(string);
            }
            i2++;
        }
        if (readableArray.size() == i2) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            this.mCallbacks.put(this.mRequestCode, new Callback() { // from class: com.zoontek.rnpermissions.RNPermissionsModule.2
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object... objArr) {
                    int i4 = 0;
                    int[] iArr = (int[]) objArr[0];
                    PermissionAwareActivity permissionAwareActivity2 = (PermissionAwareActivity) objArr[1];
                    while (true) {
                        ArrayList arrayList2 = arrayList;
                        int size = arrayList2.size();
                        WritableNativeMap writableNativeMap2 = writableNativeMap;
                        if (i4 >= size) {
                            promise.resolve(writableNativeMap2);
                            return;
                        }
                        String str = (String) arrayList2.get(i4);
                        if (iArr.length > 0 && iArr[i4] == 0) {
                            writableNativeMap2.putString(str, "granted");
                        } else if (permissionAwareActivity2.shouldShowRequestPermissionRationale(str)) {
                            writableNativeMap2.putString(str, "denied");
                        } else {
                            writableNativeMap2.putString(str, "blocked");
                        }
                        i4++;
                    }
                }
            });
            permissionAwareActivity.d((String[]) arrayList.toArray(new String[0]), this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    public void requestNotifications(ReadableArray readableArray, Promise promise) {
        promise.reject("Permissions:requestNotifications", "requestNotifications is not supported on Android");
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void requestPermission(final String str, final Promise promise) {
        if (str == null || !permissionExists(str)) {
            promise.resolve("unavailable");
            return;
        }
        if (getReactApplicationContext().getBaseContext().checkSelfPermission(str) == 0) {
            promise.resolve("granted");
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            this.mCallbacks.put(this.mRequestCode, new Callback() { // from class: com.zoontek.rnpermissions.RNPermissionsModule.1
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object... objArr) {
                    int[] iArr = (int[]) objArr[0];
                    int length = iArr.length;
                    Promise promise2 = promise;
                    if (length > 0 && iArr[0] == 0) {
                        promise2.resolve("granted");
                    } else if (((PermissionAwareActivity) objArr[1]).shouldShowRequestPermissionRationale(str)) {
                        promise2.resolve("denied");
                    } else {
                        promise2.resolve("blocked");
                    }
                }
            });
            permissionAwareActivity.d(new String[]{str}, this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }

    @Override // com.zoontek.rnpermissions.NativePermissionsModuleSpec
    @ReactMethod
    public void shouldShowRequestPermissionRationale(String str, Promise promise) {
        if (str == null) {
            promise.resolve(Boolean.FALSE);
            return;
        }
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(str)));
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }
}
