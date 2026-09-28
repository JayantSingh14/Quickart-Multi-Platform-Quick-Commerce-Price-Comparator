package in.juspay.hypersdk.data;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.SessionInfoInterface;
import in.juspay.hypersdk.core.Constants;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hyperupi.UPIConstants;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SessionInfo implements SessionInfoInterface {
    private static final String LOG_TAG = "in.juspay.hypersdk.data.SessionInfo";

    @NonNull
    private final Context context;

    @Nullable
    private DisplayMetrics displayMetrics;

    @NonNull
    private final JuspayServices juspayServices;

    @Nullable
    private String sessionId;

    @NonNull
    private JSONObject sessionInfo = new JSONObject();

    @NonNull
    private JSONObject bundleParams = new JSONObject();

    @NonNull
    private final String androidId = generateId("juspay_android_id");

    @NonNull
    private final String deviceId = generateId("juspay_device_id");

    public SessionInfo(@NonNull JuspayServices juspayServices) {
        this.juspayServices = juspayServices;
        this.context = juspayServices.getContext().getApplicationContext();
    }

    private void addOrUpdateOrderId(String str) throws JSONException {
        JSONObject sessionData = getSessionData();
        if (sessionData.optString(PaymentConstants.ORDER_ID).equals(str) || str.equals("")) {
            return;
        }
        try {
            sessionData.put(PaymentConstants.ORDER_ID, str);
        } catch (JSONException unused) {
        }
    }

    private boolean devOptionsEnabled() {
        return Settings.Secure.getInt(this.context.getContentResolver(), "development_settings_enabled", 0) == 1;
    }

    @NonNull
    private String generateId(String str) {
        String fromSharedPreference = this.juspayServices.getWorkspace().getFromSharedPreference(str, null);
        if (fromSharedPreference != null) {
            return fromSharedPreference;
        }
        String string = UUID.randomUUID().toString();
        this.juspayServices.getWorkspace().writeToSharedPreference(str, string);
        return string;
    }

    private DisplayMetrics getDisplayMetrics() {
        try {
            if (this.displayMetrics == null) {
                this.displayMetrics = this.context.getResources().getDisplayMetrics();
            }
            return this.displayMetrics;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    private String getOrderIdFromPayload(JSONObject jSONObject, String str) {
        return jSONObject.has(PaymentConstants.ORDER_ID_CAMEL) ? jSONObject.optString(PaymentConstants.ORDER_ID_CAMEL) : jSONObject.has(PaymentConstants.ORDER_ID) ? jSONObject.optString(PaymentConstants.ORDER_ID) : str;
    }

    private String getScreenPpi() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return String.valueOf(displayMetrics.xdpi);
        }
        return null;
    }

    private int getVersionCode() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private String getVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isRooted() {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private String randomUUID() {
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[4];
        new SecureRandom().nextBytes(bArr2);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putLong(System.currentTimeMillis());
        System.arraycopy(byteBufferAllocate.array(), 2, bArr, 0, 6);
        System.arraycopy(bArr2, 0, bArr, 12, 4);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 16; i2++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return sb.toString();
    }

    public void addOrderIdInSessionData(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(PaymentConstants.PAYLOAD);
        if (jSONObjectOptJSONObject != null) {
            try {
                if (jSONObjectOptJSONObject.has(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL)) {
                    addOrUpdateOrderId(getOrderIdFromPayload(new JSONObject(jSONObjectOptJSONObject.optString(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL, "{}")), jSONObjectOptJSONObject.optString(PaymentConstants.ORDER_ID_CAMEL)));
                } else if (jSONObjectOptJSONObject.has(PaymentConstants.ORDER_DETAILS_CAMEL)) {
                    addOrUpdateOrderId(getOrderIdFromPayload(new JSONObject(jSONObjectOptJSONObject.optString(PaymentConstants.ORDER_DETAILS_CAMEL, "{}")), jSONObjectOptJSONObject.optString(PaymentConstants.ORDER_ID_CAMEL)));
                } else {
                    addOrUpdateOrderId(getOrderIdFromPayload(jSONObjectOptJSONObject, ""));
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void createSessionDataMap() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("device_id", getDeviceId());
            jSONObject.put("android_id", EncryptionHelper.getSHA256Hash(getAndroidId()));
            jSONObject.put("os", LogSubCategory.LifeCycle.ANDROID);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("android_api_level", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("locale", Locale.getDefault().getDisplayLanguage());
            jSONObject.put("app_name", this.context.getApplicationInfo().loadLabel(this.context.getPackageManager()));
            jSONObject.put("app_version", getVersionName());
            jSONObject.put("app_version_code", getVersionCode());
            String clientId = getClientId();
            if (!Objects.equals(clientId, "")) {
                jSONObject.put(PaymentConstants.CLIENT_ID, clientId);
            }
            String merchantId = getMerchantId();
            if (!Objects.equals(merchantId, "")) {
                jSONObject.put(PaymentConstants.MERCHANT_ID, merchantId);
            }
            jSONObject.put("dir_name", this.context.getApplicationInfo().sourceDir);
            jSONObject.put("package_name", this.context.getApplicationInfo().packageName);
            jSONObject.put("network_info", getNetworkInfo());
            jSONObject.put("network_type", String.valueOf(getNetworkType()));
            jSONObject.put("ip_address", Utils.getIPAddress(this.juspayServices));
            jSONObject.put("vpn_connected", String.valueOf(Utils.checkIfVPNConnected(this.context)));
            jSONObject.put("is_rooted", String.valueOf(isRooted()));
            jSONObject.put("is_dev_enabled", String.valueOf(devOptionsEnabled()));
            jSONObject.put("app_debuggable", JuspayCoreLib.isAppDebuggable());
            jSONObject.put("sdk_debuggable", this.juspayServices.getSdkInfo().isSdkDebuggable());
            jSONObject.put("screen_width", getScreenWidth());
            jSONObject.put("screen_height", getScreenHeight());
            jSONObject.put("screen_ppi", getScreenPpi());
            updateSessionData(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public String get(String str, String str2) {
        return this.sessionInfo.optString(str, str2);
    }

    @NonNull
    public String getAndroidId() {
        return this.androidId;
    }

    public String getAppName() {
        String strOptString = this.sessionInfo.optString("app_name");
        return !strOptString.equals("") ? strOptString : getClientId();
    }

    @NonNull
    public JSONObject getBundleParams() {
        return this.bundleParams;
    }

    @NonNull
    public String getClientId() {
        JSONObject jSONObjectOptJSONObject;
        return (!this.bundleParams.has(PaymentConstants.PAYLOAD) || (jSONObjectOptJSONObject = this.bundleParams.optJSONObject(PaymentConstants.PAYLOAD)) == null) ? "" : jSONObjectOptJSONObject.has("clientId") ? jSONObjectOptJSONObject.optString("clientId") : jSONObjectOptJSONObject.has(PaymentConstants.CLIENT_ID) ? jSONObjectOptJSONObject.optString(PaymentConstants.CLIENT_ID) : "";
    }

    @Override // in.juspay.hyper.core.SessionInfoInterface
    @NonNull
    public String getDeviceId() {
        return this.deviceId;
    }

    @NonNull
    public String getMerchantId() {
        JSONObject jSONObjectOptJSONObject;
        if (!this.bundleParams.has(PaymentConstants.PAYLOAD) || (jSONObjectOptJSONObject = this.bundleParams.optJSONObject(PaymentConstants.PAYLOAD)) == null) {
            return "";
        }
        try {
            if (jSONObjectOptJSONObject.has(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL)) {
                JSONObject jSONObject = new JSONObject(jSONObjectOptJSONObject.optString(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL, "{}"));
                if (jSONObject.has(PaymentConstants.MERCHANT_ID_CAMEL)) {
                    return jSONObject.optString(PaymentConstants.MERCHANT_ID_CAMEL);
                }
                if (jSONObject.has(PaymentConstants.MERCHANT_ID)) {
                    return jSONObject.optString(PaymentConstants.MERCHANT_ID);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObjectOptJSONObject.has(PaymentConstants.MERCHANT_ID_CAMEL) ? jSONObjectOptJSONObject.optString(PaymentConstants.MERCHANT_ID_CAMEL) : jSONObjectOptJSONObject.has(PaymentConstants.MERCHANT_ID) ? jSONObjectOptJSONObject.optString(PaymentConstants.MERCHANT_ID) : "";
    }

    public String getNetworkInfo() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(1)) != null) {
                if (networkInfo.isConnected()) {
                    return "wifi";
                }
            }
            return "cellular";
        } catch (Exception unused) {
            return null;
        }
    }

    public String getNetworkName() {
        int networkType = getNetworkType();
        if ("wifi".equals(getNetworkInfo())) {
            return UPIConstants.WIFI;
        }
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G_OR_5G";
            case 18:
                return "4G";
            case 19:
            default:
                return "OTHER";
            case 20:
                return "5G";
        }
    }

    public int getNetworkType() {
        TelephonyManager telephonyManager;
        try {
            if (ContextCompat.a(this.context, "android.permission.READ_BASIC_PHONE_STATE") == 0 && (telephonyManager = (TelephonyManager) this.context.getSystemService("phone")) != null) {
                return telephonyManager.getDataNetworkType();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @NonNull
    public String getOrderId() {
        JSONObject sessionData = getSessionData();
        return sessionData.has(PaymentConstants.ORDER_ID) ? sessionData.optString(PaymentConstants.ORDER_ID) : "";
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public String getScreenHeight() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return String.valueOf(displayMetrics.heightPixels);
        }
        return null;
    }

    public String getScreenSizeDensity() throws Exception {
        try {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            if (displayMetrics == null) {
                throw new Exception("display metrics null");
            }
            float f2 = displayMetrics.density;
            return (this.context.getResources().getConfiguration().screenLayout & 15) + "-" + f2;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getScreenWidth() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return String.valueOf(displayMetrics.widthPixels);
        }
        return null;
    }

    @NonNull
    public JSONObject getSessionData() {
        JSONObject jSONObjectOptJSONObject = this.sessionInfo.optJSONObject("sessionData");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject : new JSONObject();
    }

    @Nullable
    public String getSessionId() {
        return this.sessionId;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isVerifyAssetsEnabled() {
        return this.sessionInfo.optBoolean(Constants.VERIFY_ASSETS, true);
    }

    public void logDeviceIdentifiers() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", getDeviceId());
            jSONObject.put("android_id", getAndroidId());
            this.juspayServices.getSdkTracker().trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.IDENTIFIERS, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void logSessionInfo() {
        try {
            this.juspayServices.getSdkTracker().trackContext(LogSubCategory.Context.DEVICE, "info", "session_info", this.sessionInfo);
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", "session_info", "Exception while logging ", e2);
        }
    }

    public void removeAttribute(String str) {
        this.sessionInfo.remove(str);
    }

    public void resetSession() {
        this.sessionId = null;
        this.sessionInfo = new JSONObject();
        this.bundleParams = new JSONObject();
    }

    public void set(String str, String str2) throws JSONException {
        try {
            this.sessionInfo.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public void setBundleParams(JSONObject jSONObject) throws JSONException {
        try {
            JSONArray jSONArrayNames = this.bundleParams.names();
            if (jSONArrayNames != null) {
                for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                    this.bundleParams.remove(jSONArrayNames.getString(i2));
                }
            }
            JSONArray jSONArrayNames2 = jSONObject.names();
            if (jSONArrayNames2 != null) {
                for (int i3 = 0; i3 < jSONArrayNames2.length(); i3++) {
                    String string = jSONArrayNames2.getString(i3);
                    this.bundleParams.put(string, jSONObject.get(string));
                }
            }
            set("bundleParams", this.bundleParams.toString());
        } catch (JSONException unused) {
        }
    }

    public void setSessionId() {
        this.sessionId = randomUUID();
        JuspayLogger.d(LOG_TAG, "Session ID: " + this.sessionId);
    }

    @Nullable
    public String tryGetClientId() {
        String clientId = getClientId();
        if (clientId.equals("")) {
            return null;
        }
        return clientId;
    }

    @Nullable
    public String tryGetMerchantId() {
        String merchantId = getMerchantId();
        if (merchantId.equals("")) {
            return null;
        }
        return merchantId;
    }

    public void updateSessionData(JSONObject jSONObject) throws JSONException {
        this.sessionInfo.remove("sessionData");
        try {
            this.sessionInfo.put("sessionData", jSONObject);
        } catch (JSONException e2) {
            this.juspayServices.sdkDebug(LOG_TAG, "Unable to update sessionInfo: " + e2);
        }
    }
}
