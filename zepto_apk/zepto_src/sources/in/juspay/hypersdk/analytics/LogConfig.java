package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LogConfig {
    JSONArray allowWhileBuffering;
    JSONArray defaultChannels;
    int defaultPriority;
    long dontPushIfFileIsLastModifiedBeforeInHours;
    String encryptionLevel;
    public String errorUrl;
    public JSONArray fallBackPublicKeys;
    public JSONArray fallBackUrl;
    public String fileFormat;
    long filesCountLimit;
    long folderSizeLimit;
    JSONArray logChannelsConfig;

    @NonNull
    JSONObject logHeaders;
    int logPostInterval;

    @NonNull
    public JSONObject logProperties;
    int logSessioniseInterval;
    int maxFilesAllowed;
    long maxLogFileSize;
    long maxLogLineSize;
    long maxLogValueSize;
    long maxLogsPerPush;
    int maxRetryPerBatch;
    long maxSizeLimitPerPush;
    long minMemoryRequired;
    int numFilesToLeaveIfMaxFilesExceeded;
    String prodLogUrl;
    JSONObject publicKey;
    JSONObject publicKeySandbox;
    String sandboxLogUrl;
    public boolean shouldPush;

    public LogConfig(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        this.minMemoryRequired = 16384L;
        this.maxLogLineSize = 20971520L;
        this.maxLogFileSize = 20971520L;
        this.maxLogValueSize = 32768L;
        this.maxFilesAllowed = 7;
        this.numFilesToLeaveIfMaxFilesExceeded = 5;
        this.dontPushIfFileIsLastModifiedBeforeInHours = 720L;
        this.logPostInterval = 2000;
        this.logSessioniseInterval = 2000;
        this.encryptionLevel = "encryption";
        this.maxLogsPerPush = 75L;
        this.maxSizeLimitPerPush = 204800L;
        this.maxRetryPerBatch = -1;
        this.defaultPriority = 5;
        this.folderSizeLimit = 52428800L;
        this.filesCountLimit = 200L;
        this.publicKeySandbox = new JSONObject();
        this.publicKey = new JSONObject();
        this.logChannelsConfig = new JSONArray();
        this.defaultChannels = new JSONArray();
        this.sandboxLogUrl = "https://debug.logs.juspay.net/godel/analytics";
        this.prodLogUrl = "https://logs.juspay.in/godel/analytics";
        this.shouldPush = true;
        this.fileFormat = "prefixByte";
        this.fallBackUrl = new JSONArray();
        this.fallBackPublicKeys = new JSONArray();
        this.errorUrl = "";
        this.logHeaders = new JSONObject();
        this.logProperties = new JSONObject();
        this.allowWhileBuffering = new JSONArray();
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logsConfig");
                jSONObjectOptJSONObject = jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
                this.maxLogLineSize = jSONObjectOptJSONObject.optLong("maxLogLineSize", 20971520L);
                this.maxLogFileSize = jSONObjectOptJSONObject.optLong("maxLogFileSize", 20971520L);
                this.minMemoryRequired = jSONObjectOptJSONObject.optLong("minMemoryRequired", 16384L);
                this.maxFilesAllowed = jSONObjectOptJSONObject.optInt("maxFilesAllowed", 7);
                this.maxLogValueSize = jSONObjectOptJSONObject.optLong("maxLogValueSize", 32768L);
                this.folderSizeLimit = jSONObjectOptJSONObject.optLong("folderSizeLimit", 52428800L);
                this.filesCountLimit = jSONObjectOptJSONObject.optLong("filesCountLimit", 200L);
                this.maxSizeLimitPerPush = jSONObjectOptJSONObject.optLong("maxSizeLimitPerPush", 204800L);
                this.encryptionLevel = jSONObjectOptJSONObject.optString("encryptionLevelKey", "encryption");
                this.publicKeySandbox = jSONObjectOptJSONObject.optJSONObject("publicKeySandbox");
                this.publicKey = jSONObjectOptJSONObject.optJSONObject("publicKey");
                this.defaultChannels = jSONObject.optJSONArray("defaultChannels");
                this.numFilesToLeaveIfMaxFilesExceeded = jSONObjectOptJSONObject.optInt("numFilesToLeaveIfMaxFilesExceeded", 5);
                this.dontPushIfFileIsLastModifiedBeforeInHours = jSONObjectOptJSONObject.optLong("dontPushIfFileIsLastModifiedBeforeInHours", 720L);
                this.shouldPush = jSONObjectOptJSONObject.optBoolean("shouldPush", true);
                String strOptString = jSONObjectOptJSONObject.optString("logsUrlKeySandbox", "");
                if (strOptString.isEmpty()) {
                    strOptString = jSONObject2 != null ? jSONObject2.optString("sandboxLogUrl", this.sandboxLogUrl) : this.sandboxLogUrl;
                }
                this.sandboxLogUrl = strOptString;
                String strOptString2 = jSONObjectOptJSONObject.optString("logsUrlKey", "");
                if (strOptString2.isEmpty()) {
                    strOptString2 = jSONObject2 != null ? jSONObject2.optString("prodLogUrl", this.prodLogUrl) : this.prodLogUrl;
                }
                this.prodLogUrl = strOptString2;
                this.defaultPriority = jSONObjectOptJSONObject.optInt("defaultPriority", 5);
                this.maxRetryPerBatch = jSONObjectOptJSONObject.optInt("retryAttempts", -1);
                this.maxLogsPerPush = jSONObjectOptJSONObject.optLong("batchCount", 75L);
                this.logPostInterval = jSONObjectOptJSONObject.optInt("logPusherTimerWithChannel", 2000);
                this.logSessioniseInterval = jSONObjectOptJSONObject.optInt("sessioniseTimer", 2000);
                this.logChannelsConfig = jSONObject.optJSONArray("logChannelsConfig");
                if (jSONObjectOptJSONObject.has("logHeaders")) {
                    this.logHeaders = jSONObjectOptJSONObject.getJSONObject("logHeaders");
                }
                if (jSONObjectOptJSONObject.has("logProperties")) {
                    this.logProperties = jSONObjectOptJSONObject.getJSONObject("logProperties");
                }
                if (jSONObjectOptJSONObject.has("allowWhileBuffering")) {
                    this.allowWhileBuffering = jSONObjectOptJSONObject.getJSONArray("allowWhileBuffering");
                }
                if (jSONObjectOptJSONObject.has("fileFormat")) {
                    this.fileFormat = jSONObjectOptJSONObject.optString("fileFormat", "prefixByte");
                }
                if (jSONObjectOptJSONObject.has("fallBackUrl")) {
                    this.fallBackUrl = jSONObjectOptJSONObject.optJSONArray("fallBackUrl");
                }
                if (jSONObjectOptJSONObject.has("fallBackPublicKeys")) {
                    this.fallBackPublicKeys = jSONObjectOptJSONObject.optJSONArray("fallBackPublicKeys");
                }
                if (jSONObjectOptJSONObject.has("errorUrl")) {
                    this.errorUrl = jSONObjectOptJSONObject.optString("errorUrl", "");
                }
            } catch (Exception unused) {
            }
        }
    }
}
