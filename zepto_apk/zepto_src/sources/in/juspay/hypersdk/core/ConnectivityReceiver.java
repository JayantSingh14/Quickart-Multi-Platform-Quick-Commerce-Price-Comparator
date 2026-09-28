package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.constants.Labels;
import in.juspay.hypersmshandler.JuspayDuiHook;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ConnectivityReceiver extends BroadcastReceiver implements JuspayDuiHook {
    private static final String LOG_TAG = "ConnectivityReceiver";

    @NonNull
    private final Map<Activity, Boolean> attachedMap = new WeakHashMap();

    @NonNull
    private final JuspayServices juspayServices;

    public ConnectivityReceiver(@NonNull JuspayServices juspayServices) {
        this.juspayServices = juspayServices;
    }

    private String getNetworkType() {
        return this.juspayServices.getSessionInfo().getNetworkInfo() != null ? this.juspayServices.getSessionInfo().getNetworkInfo() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isMobileDataOn() {
        /*
            r7 = this;
            r0 = 0
            in.juspay.hypersdk.core.JuspayServices r1 = r7.juspayServices     // Catch: java.lang.Exception -> L4d
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Exception -> L4d
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch: java.lang.Exception -> L4d
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Exception -> L4d
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch: java.lang.Exception -> L4d
            java.lang.String r4 = "airplane_mode_on"
            int r3 = android.provider.Settings.Global.getInt(r3, r4, r0)     // Catch: java.lang.Exception -> L4d
            r4 = 1
            if (r3 != 0) goto L1e
            r3 = r4
            goto L1f
        L1e:
            r3 = r0
        L1f:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L4d
            r6 = 29
            if (r5 < r6) goto L32
            java.lang.String r5 = "android.permission.READ_BASIC_PHONE_STATE"
            int r1 = androidx.core.content.ContextCompat.a(r1, r5)     // Catch: java.lang.Exception -> L4d
            if (r1 != 0) goto L47
            boolean r1 = com.bumptech.glide.load.resource.bitmap.a.x(r2)     // Catch: java.lang.Exception -> L4d
            goto L48
        L32:
            int r2 = r2.getSimState()     // Catch: java.lang.Exception -> L4d
            r5 = 5
            if (r2 != r5) goto L47
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L4d
            java.lang.String r2 = "mobile_data"
            int r1 = android.provider.Settings.Global.getInt(r1, r2, r4)     // Catch: java.lang.Exception -> L4d
            if (r1 != r4) goto L47
            r1 = r4
            goto L48
        L47:
            r1 = r0
        L48:
            if (r1 == 0) goto L4d
            if (r3 == 0) goto L4d
            return r4
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.ConnectivityReceiver.isMobileDataOn():boolean");
    }

    private boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.juspayServices.getContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.IS_NETWORK_AVAILABLE, "network failure", e2);
            return false;
        }
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public void attach(@NonNull Activity activity) {
        Boolean bool = this.attachedMap.get(activity);
        if (bool == null || !bool.booleanValue()) {
            activity.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            JuspayServices juspayServices = this.juspayServices;
            String str = LOG_TAG;
            juspayServices.sdkDebug(str, "Attaching the " + str);
            this.attachedMap.put(activity, Boolean.TRUE);
        }
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public void detach(@NonNull Activity activity) {
        Boolean bool = this.attachedMap.get(activity);
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        activity.unregisterReceiver(this);
        JuspayServices juspayServices = this.juspayServices;
        String str = LOG_TAG;
        juspayServices.sdkDebug(str, "Detaching the " + str);
        this.attachedMap.put(activity, Boolean.FALSE);
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public String execute(@NonNull Activity activity, @Nullable String str, @Nullable JSONObject jSONObject) {
        return String.valueOf(isNetworkAvailable());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("connected", String.valueOf(isNetworkAvailable()));
            jSONObject.put("networkType", getNetworkType());
            jSONObject.put("isMobileDataOn", String.valueOf(isMobileDataOn()));
        } catch (JSONException unused) {
        }
        this.juspayServices.getJBridge().invokeFnInDUIWebview("onNetworkChange", jSONObject.toString());
    }
}
