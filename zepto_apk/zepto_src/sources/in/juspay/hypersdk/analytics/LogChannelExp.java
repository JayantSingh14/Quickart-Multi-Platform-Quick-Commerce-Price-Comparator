package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LogChannelExp extends LogChannel {

    @NonNull
    private final String errorUrl;

    @NonNull
    private final JSONArray fallBackPublicKeys;

    @NonNull
    private final JSONArray fallBackUrls;

    @NonNull
    private final ArrayList<String> logsQueue;

    public LogChannelExp(int i2, long j2, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull Map<String, String> map, int i3, @NonNull String str4, @NonNull String str5, @NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull String str6) {
        super(i2, j2, str, str2, str3, jSONObject, jSONObject2, map, i3, str4, str5);
        this.logsQueue = new ArrayList<>();
        this.fallBackUrls = jSONArray;
        this.fallBackPublicKeys = jSONArray2;
        this.errorUrl = str6;
    }

    public void addToLogsQueue(String str) {
        this.logsQueue.add(str);
    }

    @NonNull
    public String getErrorUrl() {
        return this.errorUrl;
    }

    @NonNull
    public JSONArray getFallBackPublicKeys() {
        return this.fallBackPublicKeys;
    }

    @NonNull
    public JSONArray getFallBackUrls() {
        return this.fallBackUrls;
    }

    @NonNull
    public ArrayList<String> getLogsQueueExp() {
        return this.logsQueue;
    }

    public void pollLogsQueue(String str) {
        this.logsQueue.remove(str);
    }

    @Override // in.juspay.hypersdk.analytics.LogChannel
    @NonNull
    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelName", this.channelName).put("endPointProd", this.endPointProd).put("headers", this.headers).put("endpointSBX", this.endpointSBX).put("keyProd", this.keyProd).put("keySBX", this.keySBX).put("encryptionLevel", this.encryptionLevel).put("priority", this.priority).put(PaymentConstants.ENV, this.environment).put("retryAttempts", this.retryAttempts).put("batchCount", this.batchCount).put("fallBackUrls", this.fallBackUrls).put("fallBackPublicKeys", this.fallBackUrls).put("errorUrl", this.errorUrl);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
