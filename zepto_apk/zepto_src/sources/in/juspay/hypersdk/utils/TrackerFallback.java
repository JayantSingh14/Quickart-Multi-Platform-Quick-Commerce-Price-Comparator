package in.juspay.hypersdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.source.h;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.utils.network.HyperNetUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.Response;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class TrackerFallback {
    private int count;
    private boolean enableTrackerFallback;

    @Nullable
    private HyperNetUtils netUtils;

    @Nullable
    private List<String> requiredKeysList;

    public TrackerFallback(Context context, JSONObject jSONObject) {
        this.count = 3;
        if (jSONObject == null || !jSONObject.has("enableTrackerFallback")) {
            return;
        }
        try {
            this.netUtils = new HyperNetUtils(context, 0, 0);
            this.enableTrackerFallback = jSONObject.optBoolean("enableTrackerFallback", true);
            this.count = jSONObject.optInt("trackerFallbackAttempts", 3);
            this.requiredKeysList = Arrays.asList("action", PaymentConstants.ORDER_ID_CAMEL, "clientId", PaymentConstants.MERCHANT_ID_CAMEL, "customerId", "os", "os_version", "app_version", "requestId");
        } catch (Exception unused) {
        }
    }

    private HashMap<String, String> getQueryParams(JuspayServices juspayServices, JSONObject jSONObject, LogType logType) {
        ArrayList arrayList = new ArrayList();
        LogType logType2 = LogType.PROCESS_END;
        if (logType == logType2) {
            arrayList.add("errorMessage");
            arrayList.add(CLConstants.FIELD_ERROR_CODE);
        }
        if (logType == LogType.INITIATE_RESULT || logType == logType2) {
            arrayList.add(PaymentConstants.CLIENT_ID);
            arrayList.add(PaymentConstants.MERCHANT_ID);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(PaymentConstants.PAYLOAD);
        JSONObject sessionData = juspayServices.getSessionInfo().getSessionData();
        HashMap<String, String> map = new HashMap<>();
        List<String> list = this.requiredKeysList;
        if (list != null) {
            for (String str : list) {
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(str)) {
                    map.put(str, jSONObjectOptJSONObject.optString(str, ""));
                } else if (sessionData.has(str)) {
                    map.put(str, sessionData.optString(str, ""));
                } else if (jSONObject.has(str)) {
                    map.put(str, jSONObject.optString(str, ""));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(str2)) {
                map.put(str2, jSONObjectOptJSONObject.optString(str2, ""));
            } else if (jSONObject.has(str2)) {
                map.put(str2, jSONObject.optString(str2, ""));
            }
        }
        map.put("sessionId", juspayServices.getSessionInfo().getSessionId());
        map.put("logtype", logType.name());
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$log$0(JuspayServices juspayServices, JSONObject jSONObject, LogType logType) {
        try {
            if (!this.enableTrackerFallback || this.netUtils == null) {
                return;
            }
            for (int i2 = 0; i2 < this.count; i2++) {
                Response responseDoGet = this.netUtils.doGet("https://assets.juspay.in/a.html", new HashMap(), getQueryParams(juspayServices, jSONObject, logType), new JSONObject(), null);
                try {
                    if (responseDoGet.f56353d == 200) {
                        responseDoGet.close();
                        return;
                    }
                    responseDoGet.close();
                } finally {
                }
            }
        } catch (Exception unused) {
        }
    }

    public void log(JSONObject jSONObject, JuspayServices juspayServices, LogType logType) {
        ExecutorManager.runOnBackgroundThread(new h(this, juspayServices, jSONObject, logType, 9));
    }
}
