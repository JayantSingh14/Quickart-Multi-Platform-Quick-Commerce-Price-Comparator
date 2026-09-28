package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LogChannel {
    final long batchCount;

    @NonNull
    final String channelName;

    @NonNull
    final String encryptionLevel;

    @NonNull
    final String endPointProd;

    @NonNull
    final String endpointSBX;

    @NonNull
    final String environment;

    @NonNull
    Map<String, String> headers;
    final JSONObject keyProd;
    final JSONObject keySBX;
    final int priority;
    final int retryAttempts;
    private int currentBatchRetryAttempts = 0;

    @NonNull
    private final ConcurrentLinkedQueue<byte[]> logsQueue = new ConcurrentLinkedQueue<>();

    public LogChannel(int i2, long j2, @NonNull String str, @NonNull String str2, @NonNull String str3, JSONObject jSONObject, JSONObject jSONObject2, @NonNull Map<String, String> map, int i3, @NonNull String str4, @NonNull String str5) {
        this.channelName = str;
        this.endPointProd = str2;
        this.endpointSBX = str3;
        this.keyProd = jSONObject;
        this.keySBX = jSONObject2;
        this.headers = map;
        this.priority = i3;
        this.environment = str4;
        this.encryptionLevel = str5;
        this.retryAttempts = i2;
        this.batchCount = j2;
    }

    public void addToLogsQueue(byte[] bArr) {
        this.logsQueue.add(bArr);
    }

    public long getBatchCount() {
        return this.batchCount;
    }

    @NonNull
    public String getChannelName() {
        return this.channelName;
    }

    public int getCurrentBatchRetryAttempts() {
        return this.currentBatchRetryAttempts;
    }

    @NonNull
    public String getEncryptionLevel() {
        return this.encryptionLevel;
    }

    @NonNull
    public String getEndPointProd() {
        return this.endPointProd;
    }

    @NonNull
    public String getEndpointSBX() {
        return this.endpointSBX;
    }

    @NonNull
    public String getEnvironment() {
        return this.environment;
    }

    @NonNull
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public JSONObject getKeyProd() {
        return this.keyProd;
    }

    public JSONObject getKeySBX() {
        return this.keySBX;
    }

    @NonNull
    public ConcurrentLinkedQueue<byte[]> getLogsQueue() {
        return this.logsQueue;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRetryAttempts() {
        return this.retryAttempts;
    }

    public void pollLogsQueue() {
        this.logsQueue.poll();
    }

    public void setCurrentBatchRetryAttempts(int i2) {
        this.currentBatchRetryAttempts = i2;
    }

    public void setHeaders(@NonNull Map<String, String> map) {
        this.headers = map;
    }

    @NonNull
    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelName", this.channelName).put("endPointProd", this.endPointProd).put("headers", this.headers).put("endpointSBX", this.endpointSBX).put("keyProd", this.keyProd).put("keySBX", this.keySBX).put("encryptionLevel", this.encryptionLevel).put("priority", this.priority).put(PaymentConstants.ENV, this.environment).put("retryAttempts", this.retryAttempts).put("batchCount", this.batchCount);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
