package com.zeptoconsumerapp.PaymentUPIHelper;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class PaymentUPIHelperModule extends ReactContextBaseJavaModule {
    private static final String RESPONSE = "response";
    private static final String STATUS = "Status";
    private final String IS_INSTALLED;
    private final String PACKAGE_NAME;
    private final String UPI_SCHEME_URL;
    private static final Integer UPI_RESULT_CODE = Integer.valueOf(WKSRecord.Service.ERPC);
    private static final String TAG = "PaymentUPIHelperModule";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class Errors {

        /* renamed from: a, reason: collision with root package name */
        public static final Errors f47536a;

        /* renamed from: b, reason: collision with root package name */
        public static final Errors f47537b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Errors[] f47538c;

        static {
            Errors errors = new Errors("APP_NOT_INSTALLED", 0);
            f47536a = errors;
            Errors errors2 = new Errors("EXCEPTION", 1);
            f47537b = errors2;
            f47538c = new Errors[]{errors, errors2};
        }

        public static Errors valueOf(String str) {
            return (Errors) Enum.valueOf(Errors.class, str);
        }

        public static Errors[] values() {
            return (Errors[]) f47538c.clone();
        }
    }

    public PaymentUPIHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.PACKAGE_NAME = "packageName";
        this.IS_INSTALLED = "isInstalled";
        this.UPI_SCHEME_URL = "upi://pay";
    }

    private static String mapResultCodeToEnum(int i2) {
        return i2 != -1 ? i2 != 0 ? "UNKNOWN" : "CANCELLED" : MerchantConstants.SUCCESS;
    }

    public static void onActivityResult(ReactContext reactContext, int i2, int i3, Intent intent) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (i2 == UPI_RESULT_CODE.intValue()) {
            writableMapCreateMap.putString("resultCode", mapResultCodeToEnum(i3));
            if (intent != null) {
                String stringExtra = intent.getStringExtra(RESPONSE);
                String stringExtra2 = intent.getStringExtra(STATUS);
                if (stringExtra == null) {
                    stringExtra = "no response";
                }
                writableMapCreateMap.putString(RESPONSE, stringExtra);
                writableMapCreateMap.putString(CLConstants.OTP_STATUS, stringExtra2 != null ? stringExtra2.toUpperCase() : "UNKNOWN");
            }
            if (reactContext != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onUpiResult", writableMapCreateMap);
            }
        }
    }

    @ReactMethod
    public boolean canAppHandleUri(String str, String str2) throws PackageManager.NameNotFoundException {
        try {
            getReactApplicationContext().getPackageManager().getPackageInfo(str, 1);
            new Intent("android.intent.action.VIEW", Uri.parse(str2)).setPackage(str);
            return !r0.queryIntentActivities(r2, 65536).isEmpty();
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "PaymentUPIHelper";
    }

    @ReactMethod
    public void isInstalled(String str, String str2, Promise promise) throws PackageManager.NameNotFoundException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str2.isEmpty()) {
            str2 = "upi://pay";
        }
        if (str != null) {
            boolean zCanAppHandleUri = canAppHandleUri(str, str2);
            writableNativeMap.putString("packageName", str);
            writableNativeMap.putBoolean("isInstalled", zCanAppHandleUri);
            promise.resolve(writableNativeMap);
        }
        promise.reject("PackageName cannot be null");
    }

    @ReactMethod
    public void isInstalledBulk(ReadableArray readableArray, String str, Promise promise) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (str.isEmpty()) {
            str = "upi://pay";
        }
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            try {
                String string = readableArray.getString(i2);
                boolean zCanAppHandleUri = canAppHandleUri(string, str);
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("packageName", string);
                writableNativeMap.putBoolean("isInstalled", zCanAppHandleUri);
                writableNativeArray.pushMap(writableNativeMap);
            } catch (Exception e2) {
                promise.reject(e2);
                return;
            }
        }
        promise.resolve(writableNativeArray);
    }

    @ReactMethod
    public void openAppWithPackageAndDataUri(String str, String str2, Callback callback, Callback callback2) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            intent.addFlags(268435456);
            intent.setPackage(str);
            if (intent.resolveActivity(reactApplicationContext.getPackageManager()) == null) {
                callback2.invoke(Errors.f47536a);
            } else {
                reactApplicationContext.startActivity(intent);
                callback.invoke("App opened successfully");
            }
        } catch (Exception e2) {
            callback2.invoke(Errors.f47537b + e2.getMessage());
        }
    }

    @ReactMethod
    public void openAppWithPackageAndDataUriWithResult(String str, String str2, Callback callback, Callback callback2) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            intent.setPackage(str);
            if (intent.resolveActivity(reactApplicationContext.getPackageManager()) == null) {
                callback2.invoke(Errors.f47536a);
                return;
            }
            Activity currentActivity = getCurrentActivity();
            Objects.requireNonNull(currentActivity);
            currentActivity.startActivityForResult(intent, UPI_RESULT_CODE.intValue());
            callback.invoke("App opened successfully");
        } catch (Exception e2) {
            callback2.invoke(Errors.f47537b + e2.getMessage());
        }
    }
}
