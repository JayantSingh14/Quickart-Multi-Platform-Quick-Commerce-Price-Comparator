package com.appsflyer.internal;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFh1ySDK {
    public static void getCurrencyIso4217Code(String str, @Nullable JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("appsflyerKey")) {
                    jSONObject.put("appsflyerKey", getMediationNetwork(jSONObject.getString("appsflyerKey")));
                }
                if (jSONObject.has("tcstring")) {
                    jSONObject.put("tcstring", "tcstring");
                }
                if (jSONObject.has("referrer")) {
                    jSONObject.put("referrer", "referrer");
                }
                if (jSONObject.has("pia_token")) {
                    jSONObject.put("pia_token", "pia_token");
                }
                AFLogger aFLogger = AFLogger.INSTANCE;
                AFg1cSDK aFg1cSDK = AFg1cSDK.OTHER;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(jSONObject);
                aFLogger.i(aFg1cSDK, sb.toString());
            } catch (JSONException e2) {
                AFLogger.INSTANCE.e(AFg1cSDK.OTHER, "Not able to log the payload", e2);
            }
        }
    }

    @VisibleForTesting
    private static String getMediationNetwork(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (i2 == 0 || i2 == str.length() - 1) {
                sb.append(str.charAt(i2));
            } else {
                sb.append("*");
            }
        }
        return sb.toString();
    }
}
