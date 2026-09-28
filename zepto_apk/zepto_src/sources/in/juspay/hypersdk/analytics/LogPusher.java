package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AppsFlyerProperties;
import in.juspay.airborne.network.JuspayHttpsResponse;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.security.JOSEUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.HyperNetUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public class LogPusher {
    private static final String TAG = "LogPusher";

    @NonNull
    private final JSONArray logChannelsConfig;

    @NonNull
    private final LogConfig logConfig;

    @NonNull
    private final Workspace workspace;
    private int logFlushTimerTaskErrorCounter = 0;
    private int setHeaderParametersErrorCounter = 0;
    private boolean isSandboxEnv = false;
    private boolean stopPushingLogs = false;

    @NonNull
    private final Map<String, LogChannel> channels = new HashMap();

    public static class IterableJSONArray implements Iterable<JSONObject> {
        JSONArray original;

        public IterableJSONArray(JSONArray jSONArray) {
            this.original = jSONArray;
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<JSONObject> iterator() {
            return new Iterator<JSONObject>() { // from class: in.juspay.hypersdk.analytics.LogPusher.IterableJSONArray.1
                int curr = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.curr < IterableJSONArray.this.original.length();
                }

                @Override // java.util.Iterator
                public void remove() {
                }

                @Override // java.util.Iterator
                @Nullable
                public JSONObject next() {
                    try {
                        JSONArray jSONArray = IterableJSONArray.this.original;
                        int i2 = this.curr;
                        this.curr = i2 + 1;
                        return jSONArray.optJSONObject(i2);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        return null;
                    }
                }
            };
        }
    }

    public class LogPushTimerTask extends TimerTask {
        private static final String TAG = "LogPushTimerTask";

        @NonNull
        private final Map<String, LogChannel> channels;
        private int getLogsToPushErrorCounter;
        private boolean isExceptionTracked;

        @NonNull
        private final LogConfig logConfig;

        @NonNull
        private final AtomicInteger logPushIteration;
        private int logPushTimerTaskErrorCounter;

        @NonNull
        private final Workspace workspace;

        private void acknowledgeLogsPushed(int i2, LogChannel logChannel) {
            while (i2 > 0) {
                try {
                    logChannel.pollLogsQueue();
                    i2--;
                } catch (Exception e2) {
                    this.logPushTimerTaskErrorCounter++;
                    if (this.logPushTimerTaskErrorCounter <= 2) {
                        SdkTracker.trackAndLogBootException(TAG, "action", "system", Labels.System.LOG_PUSHER, "Exception in removal of logs from persisted Queue file", e2);
                        return;
                    } else {
                        JuspayLogger.e(TAG, "Exception in removal of logs from persisted Queue file", e2);
                        return;
                    }
                }
            }
        }

        private JSONArray getLogsToPush(LogChannel logChannel) {
            JSONArray jSONArray = new JSONArray();
            Iterator<byte[]> it = logChannel.getLogsQueue().iterator();
            while (true) {
                if ((logChannel.getBatchCount() != -1 && jSONArray.length() >= logChannel.getBatchCount()) || !it.hasNext()) {
                    break;
                }
                try {
                    jSONArray.put(new JSONObject(new String(it.next())));
                } catch (JSONException e2) {
                    it.remove();
                    int i2 = this.getLogsToPushErrorCounter + 1;
                    this.getLogsToPushErrorCounter = i2;
                    if (i2 <= 2) {
                        SdkTracker.trackAndLogBootException(TAG, "action", "system", Labels.System.LOG_PUSHER, "Bad JSON while reading the Persisted Queue for Logs", e2);
                    } else {
                        JuspayLogger.e(TAG, "Bad JSON while reading the Persisted Queue for Logs", e2);
                    }
                }
            }
            return jSONArray;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$pushAllLogs$0() {
            for (Map.Entry<String, LogChannel> entry : this.channels.entrySet()) {
                pushAllLogsUtil(entry.getValue(), entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            LogConfig logConfig = this.logConfig;
            if (logConfig.shouldPush && LogUtils.isMinMemoryAvailable(logConfig).booleanValue()) {
                int andIncrement = this.logPushIteration.getAndIncrement();
                for (Map.Entry<String, LogChannel> entry : this.channels.entrySet()) {
                    LogChannel value = entry.getValue();
                    String key = entry.getKey();
                    if (andIncrement % value.getPriority() == 0) {
                        pushAllLogsUtil(value, key);
                    }
                }
            }
        }

        private void pushAllLogsUtil(LogChannel logChannel, String str) {
            int fromSharedPreference = LogUtils.getFromSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_READING_FILE, str), this.workspace);
            int fromSharedPreference2 = LogUtils.getFromSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_WRITING_FILE, str), this.workspace);
            if (JuspayCoreLib.getApplicationContext() != null && (fromSharedPreference2 - fromSharedPreference) + 1 > this.logConfig.maxFilesAllowed) {
                while ((fromSharedPreference2 - fromSharedPreference) + 1 > this.logConfig.numFilesToLeaveIfMaxFilesExceeded) {
                    File fileOpenInCache = this.workspace.openInCache(LogConstants.PERSISTENT_LOGS_FILE + str + fromSharedPreference + ".dat");
                    if (fileOpenInCache != null) {
                        try {
                            fileOpenInCache.delete();
                        } catch (Exception unused) {
                        }
                    }
                    fromSharedPreference++;
                }
                this.workspace.writeToSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_READING_FILE, str), String.valueOf(fromSharedPreference));
            }
            while (!logChannel.getLogsQueue().isEmpty()) {
                try {
                    JSONArray logsToPush = getLogsToPush(logChannel);
                    if (logsToPush.length() > 0) {
                        int iPushLogsToServer = LogPusher.this.pushLogsToServer(logsToPush, logChannel);
                        if (iPushLogsToServer == 200 || (logChannel.getRetryAttempts() != -1 && logChannel.getCurrentBatchRetryAttempts() >= logChannel.getRetryAttempts())) {
                            logChannel.setCurrentBatchRetryAttempts(0);
                            acknowledgeLogsPushed(logsToPush.length(), logChannel);
                        }
                        SdkTracker.trackBootAction("system", "error", Labels.System.LOG_PUSHER, "error_response", "" + iPushLogsToServer);
                        logChannel.setCurrentBatchRetryAttempts(logChannel.getCurrentBatchRetryAttempts() + 1);
                        return;
                    }
                } catch (Exception e2) {
                    if (!this.isExceptionTracked) {
                        SdkTracker.trackAndLogBootException(TAG, "action", "system", Labels.System.LOG_PUSHER, "Error while creating the payload to post", e2);
                    }
                    this.isExceptionTracked = true;
                }
            }
            int fromSharedPreference3 = LogUtils.getFromSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_WRITING_FILE, str), this.workspace);
            if (JuspayCoreLib.getApplicationContext() != null) {
                for (int fromSharedPreference4 = LogUtils.getFromSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_READING_FILE, str), this.workspace); fromSharedPreference4 <= fromSharedPreference3; fromSharedPreference4++) {
                    this.workspace.openInCache(LogConstants.PERSISTENT_LOGS_FILE + str + fromSharedPreference4 + ".dat").delete();
                }
            }
            this.workspace.writeToSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_READING_FILE, str), String.valueOf(0));
            this.workspace.writeToSharedPreference(android.support.v4.media.b.C(LogConstants.PERSISTENT_LOGS_WRITING_FILE, str), String.valueOf(0));
        }

        public void pushAllLogs() {
            ExecutorManager.runOnLogsPool(new c(this, 1));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ExecutorManager.runOnLogsPool(new c(this, 0));
        }

        private LogPushTimerTask(@NonNull Workspace workspace, @NonNull LogConfig logConfig, @NonNull Map<String, LogChannel> map) {
            this.isExceptionTracked = false;
            this.logPushIteration = new AtomicInteger(1);
            this.getLogsToPushErrorCounter = 0;
            this.logPushTimerTaskErrorCounter = 0;
            this.workspace = workspace;
            this.logConfig = logConfig;
            this.channels = map;
        }
    }

    public LogPusher(@NonNull Workspace workspace, @NonNull LogConfig logConfig) {
        this.workspace = workspace;
        this.logConfig = logConfig;
        this.logChannelsConfig = logConfig.logChannelsConfig;
    }

    private boolean addChannel(String str, int i2, long j2, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i3, String str4, String str5) {
        boolean zContainsKey = this.channels.containsKey(str);
        LogChannel logChannelMakeChannel = makeChannel(str, i2, j2, str2, str3, jSONObject, jSONObject2, map, i3, str4, str5);
        this.channels.put(str, logChannelMakeChannel);
        if (!zContainsKey) {
            String fromSharedPreference = this.workspace.getFromSharedPreference(LogConstants.LOG_CHANNEL_NAMES, "");
            this.workspace.writeToSharedPreference(LogConstants.LOG_CHANNEL_NAMES, android.support.v4.media.b.r(android.support.v4.media.b.w(fromSharedPreference), fromSharedPreference.length() != 0 ? "," : "", str));
        }
        this.workspace.writeToSharedPreference(android.support.v4.media.b.C("LOG_CHANNEL_INFO_", str), logChannelMakeChannel.toString());
        return true;
    }

    private String getEndPoint(LogChannel logChannel) {
        return this.isSandboxEnv ? logChannel.getEndpointSBX() : logChannel.getEndPointProd();
    }

    private JSONArray getLogChannels(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("channels")) {
            jSONArray = jSONObject.optJSONArray("channels");
        }
        if ((jSONArray == null || jSONArray.length() == 0) && jSONObject.has(AppsFlyerProperties.CHANNEL)) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObject.optString(AppsFlyerProperties.CHANNEL, LogConstants.DEFAULT_CHANNEL));
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = this.logConfig.defaultChannels != null ? new JSONArray(this.logConfig.defaultChannels.toString()) : new JSONArray();
        jSONArray2.put(LogConstants.DEFAULT_CHANNEL);
        return jSONArray2;
    }

    @Nullable
    private RSAPublicKey getLogEncryptionKey(LogChannel logChannel) {
        try {
            return JOSEUtils.JWKtoRSAPublicKey(this.isSandboxEnv ? logChannel.getKeySBX() : logChannel.getKeyProd());
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getLogEncryptionLevel(LogChannel logChannel) {
        return logChannel.getEncryptionLevel();
    }

    private List<String> getSNRanges(JSONArray jSONArray) throws JSONException {
        TreeSet treeSet = new TreeSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                int i3 = jSONArray.getJSONObject(i2).getInt("sn");
                if (treeSet.contains(Integer.valueOf(i3))) {
                    JuspayLogger.w(TAG, "Duplicate SN in logs: " + i3);
                }
                treeSet.add(Integer.valueOf(i3));
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!treeSet.isEmpty()) {
            int iIntValue = ((Integer) treeSet.first()).intValue();
            Iterator it = treeSet.tailSet(Integer.valueOf(((Integer) treeSet.first()).intValue() + 1)).iterator();
            int i4 = iIntValue;
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (iIntValue + 1 != iIntValue2) {
                    arrayList.add(i4 + "-" + iIntValue);
                    i4 = iIntValue2;
                }
                iIntValue = iIntValue2;
            }
            arrayList.add(i4 + "-" + iIntValue);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$addLogLines$2(java.lang.Iterable r23) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusher.lambda$addLogLines$2(java.lang.Iterable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogsFromSessioniser$1(Queue queue) throws JSONException {
        try {
            if (this.logConfig.shouldPush) {
                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = (JSONObject) it.next();
                    if (!shouldDropLog(jSONObject)) {
                        JSONArray logChannels = getLogChannels(jSONObject);
                        for (int i2 = 0; i2 < logChannels.length(); i2++) {
                            String string = logChannels.getString(i2);
                            if (this.channels.containsKey(string)) {
                                LogChannel channelObject = getChannelObject(string);
                                byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                                if (bytes.length <= this.logConfig.maxLogLineSize) {
                                    channelObject.addToLogsQueue(bytes);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogsToPersistedQueue$0(JSONObject jSONObject) throws IOException {
        if (this.logConfig.shouldPush) {
            try {
                if (JuspayCoreLib.getApplicationContext() != null) {
                    File file = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), LogConstants.CRASH_LOGS_FILE);
                    byte[] bytes = (jSONObject.toString() + LogConstants.LOG_DELIMITER).getBytes(StandardCharsets.UTF_8);
                    if (bytes.length < this.logConfig.maxLogLineSize) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                        fileOutputStream.write(bytes);
                        fileOutputStream.close();
                    }
                }
            } catch (Exception e2) {
                JuspayLogger.e(TAG, "addLogsToPersistedQueue failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setHeaders$3(String str, JSONObject jSONObject) {
        LogChannel channelObject = getChannelObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                channelObject.getHeaders().put(next, jSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLogHeaderValues$4(String str, JSONObject jSONObject) {
        LogChannel channelObject = getChannelObject(str);
        try {
            for (Map.Entry<String, String> entry : (!LogConstants.DEFAULT_CHANNEL.equals(str) ? channelObject.getHeaders() : LogUtils.toMap(this.logConfig.logHeaders)).entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                int iIndexOf = value.indexOf(36);
                int iIndexOf2 = value.indexOf(WKSRecord.Service.NTP);
                int iLastIndexOf = value.lastIndexOf(WKSRecord.Service.LOCUS_MAP);
                if (iIndexOf != -1 && iIndexOf2 != -1 && iLastIndexOf != -1 && iIndexOf2 - iIndexOf == 1 && iIndexOf2 < iLastIndexOf) {
                    String strSubstring = value.substring(iIndexOf2 + 1, iLastIndexOf);
                    String str2 = "${" + strSubstring + "}";
                    if (jSONObject.has(strSubstring)) {
                        value = value.replace(str2, jSONObject.optString(strSubstring));
                    }
                }
                channelObject.getHeaders().put(key, value);
            }
        } catch (Exception unused) {
            int i2 = this.setHeaderParametersErrorCounter + 1;
            this.setHeaderParametersErrorCounter = i2;
            if (i2 <= 2) {
                SdkTracker.trackBootAction(LogSubCategory.LifeCycle.HYPER_SDK, "warning", Labels.System.LOG_PUSHER, "sdk_config", "Unable log header properties in log headers");
            }
        }
    }

    private LogChannel makeChannel(String str, int i2, long j2, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i3, String str4, String str5) {
        return new LogChannel(i2, j2, str, str2, str3, jSONObject, jSONObject2, map, i3, str4, str5);
    }

    private void pushAllFiles(int i2, int i3, LogChannel logChannel) {
        while (i2 <= i3) {
            File fileOpenInCache = this.workspace.openInCache(LogConstants.PERSISTENT_LOGS_FILE + logChannel.getChannelName() + i2 + ".dat");
            if (fileOpenInCache != null) {
                if (fileOpenInCache.exists() && LogUtils.isFileEligibleToPush(fileOpenInCache, this.logConfig)) {
                    pushFileContentToServer(fileOpenInCache, logChannel);
                } else {
                    fileOpenInCache.delete();
                }
            }
            i2++;
        }
        if (JuspayCoreLib.getApplicationContext() != null) {
            LogChannel channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
            File fileOpenInCache2 = this.workspace.openInCache(LogConstants.CRASH_LOGS_FILE);
            if (fileOpenInCache2.exists() && LogUtils.isFileEligibleToPush(fileOpenInCache2, this.logConfig)) {
                pushFileContentToServer(fileOpenInCache2, channelObject);
            } else {
                fileOpenInCache2.delete();
            }
        }
    }

    private void pushFileContentToServer(File file, LogChannel logChannel) {
        if (file != null) {
            Queue<JSONObject> logsFromFile = LogUtils.getLogsFromFile(file);
            try {
                JSONArray jSONArray = new JSONArray();
                boolean z = true;
                while (logsFromFile.size() > 0) {
                    while (true) {
                        if ((logChannel.getBatchCount() != -1 && jSONArray.length() >= logChannel.getBatchCount()) || logsFromFile.size() <= 0) {
                            break;
                        } else {
                            jSONArray.put(logsFromFile.poll());
                        }
                    }
                    if (pushLogsToServer(jSONArray, logChannel) != 200) {
                        z = false;
                    }
                    jSONArray = new JSONArray();
                }
                if (z) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pushLogsToServer(JSONArray jSONArray, LogChannel logChannel) throws JSONException, IOException {
        JuspayHttpsResponse juspayHttpsResponse;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArray);
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        String logEncryptionLevel = getLogEncryptionLevel(logChannel);
        RSAPublicKey logEncryptionKey = getLogEncryptionKey(logChannel);
        HyperNetUtils hyperNetUtils = new HyperNetUtils(JuspayCoreLib.getApplicationContext(), 10000, 10000);
        Map<String, String> headers = logChannel.getHeaders();
        if (JuspayCoreLib.isAppDebuggable()) {
            List<String> sNRanges = getSNRanges(jSONArray);
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = sNRanges.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) ",");
                }
            }
            headers.put("x-jp-sn-ranges", sb.toString());
        }
        headers.put("x-logscount", String.valueOf(jSONArray.length()));
        headers.put(AppsFlyerProperties.CHANNEL, logChannel.getChannelName());
        if ("encryption".equals(logEncryptionLevel) && logEncryptionKey != null) {
            juspayHttpsResponse = new JuspayHttpsResponse(hyperNetUtils.doPost(new URL(getEndPoint(logChannel)), EncryptionHelper.gzipThenEncrypt(bytes, logEncryptionKey), "application/x-godel-gzip-pubkey-encrypted", headers, new JSONObject(), null));
        } else if ("gzip".equals(logEncryptionLevel)) {
            byte[] bArrGzipContent = Utils.gzipContent(bytes);
            headers.put("Content-Encoding", "gzip");
            juspayHttpsResponse = new JuspayHttpsResponse(hyperNetUtils.doPost(new URL(getEndPoint(logChannel)), bArrGzipContent, "application/gzip", headers, new JSONObject(), null));
        } else {
            juspayHttpsResponse = new JuspayHttpsResponse(hyperNetUtils.doPost(new URL(getEndPoint(logChannel)), bytes, "application/json", headers, new JSONObject(), null));
        }
        return juspayHttpsResponse.responseCode;
    }

    public boolean addChannelFromJS(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return addChannel(str2, jSONObject.optInt("retryAttempts", this.logConfig.maxRetryPerBatch), jSONObject.optLong("batchCount", this.logConfig.maxLogsPerPush), jSONObject.optString("logsUrlKey", this.logConfig.prodLogUrl), jSONObject.optString("logsUrlKeySandbox", this.logConfig.sandboxLogUrl), jSONObject.has("publicKey") ? jSONObject.getJSONObject("publicKey") : this.logConfig.publicKey, jSONObject.has("publicKeySandbox") ? jSONObject.getJSONObject("publicKeySandbox") : this.logConfig.publicKeySandbox, jSONObject.has("channelHeaders") ? LogUtils.toMap(jSONObject.getJSONObject("channelHeaders")) : new HashMap<>(), jSONObject.optInt("priority", this.logConfig.defaultPriority), jSONObject.optString(PaymentConstants.ENV, "all"), jSONObject.optString("encryptionLevel", this.logConfig.encryptionLevel));
        } catch (JSONException unused) {
            return false;
        }
    }

    public void addLogLines(JSONArray jSONArray) {
        if (this.stopPushingLogs || !this.logConfig.shouldPush) {
            return;
        }
        addLogLines(new IterableJSONArray(jSONArray));
    }

    public void addLogsFromSessioniser(Queue<JSONObject> queue) {
        ExecutorManager.runOnLogsPool(new in.juspay.hypernfc.b(5, this, queue));
    }

    public void addLogsToPersistedQueue(JSONObject jSONObject) {
        ExecutorManager.runOnLogsPool(new in.juspay.hypernfc.b(4, this, jSONObject));
    }

    public LogPushTimerTask createPusherTask() {
        return new LogPushTimerTask(this.workspace, this.logConfig, this.channels);
    }

    public String[] getChannelNames() {
        return (String[]) this.channels.keySet().toArray(new String[0]);
    }

    public LogChannel getChannelObject(String str) {
        return this.channels.containsKey(str) ? this.channels.get(str) : this.channels.get(LogConstants.DEFAULT_CHANNEL);
    }

    public void loadSavedChannels() throws JSONException {
        int i2;
        LogChannel logChannelMakeChannel;
        if (this.logConfig.shouldPush) {
            int i3 = 0;
            if (this.logChannelsConfig != null) {
                for (int i4 = 0; i4 < this.logChannelsConfig.length(); i4++) {
                    try {
                        JSONObject jSONObject = this.logChannelsConfig.getJSONObject(i4);
                        addChannelFromJS(jSONObject.toString(), jSONObject.getString(AppsFlyerProperties.CHANNEL));
                    } catch (JSONException unused) {
                    }
                }
            }
            String[] strArrSplit = this.workspace.getFromSharedPreference(LogConstants.LOG_CHANNEL_NAMES, "").split(",");
            this.workspace.writeToSharedPreference(LogConstants.LOG_CHANNEL_NAMES, "");
            LogConfig logConfig = this.logConfig;
            int i5 = logConfig.maxRetryPerBatch;
            long j2 = logConfig.maxLogsPerPush;
            String str = logConfig.prodLogUrl;
            String str2 = logConfig.sandboxLogUrl;
            JSONObject jSONObject2 = logConfig.publicKey;
            JSONObject jSONObject3 = logConfig.publicKeySandbox;
            HashMap map = new HashMap();
            LogConfig logConfig2 = this.logConfig;
            addChannel(LogConstants.DEFAULT_CHANNEL, i5, j2, str, str2, jSONObject2, jSONObject3, map, logConfig2.defaultPriority, "all", logConfig2.encryptionLevel);
            LogChannel channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
            int length = strArrSplit.length;
            while (i3 < length) {
                int i6 = length;
                String str3 = strArrSplit[i3];
                String fromSharedPreference = this.workspace.getFromSharedPreference("LOG_CHANNEL_INFO_" + str3, "");
                if (!this.channels.containsKey(str3)) {
                    this.workspace.removeFromSharedPreference("LOG_CHANNEL_INFO_" + str3);
                }
                if (fromSharedPreference.length() != 0) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(fromSharedPreference);
                        try {
                            str3 = str3;
                            i2 = i6;
                            try {
                                logChannelMakeChannel = makeChannel(str3, jSONObject4.optInt("retryAttempts", this.logConfig.maxRetryPerBatch), jSONObject4.optLong("batchCount", this.logConfig.maxLogsPerPush), jSONObject4.optString("logsUrlKey", this.logConfig.prodLogUrl), jSONObject4.optString("logsUrlKeySandbox", this.logConfig.sandboxLogUrl), jSONObject4.getJSONObject("publicKey"), jSONObject4.getJSONObject("publicKeySandbox"), LogUtils.toMap(new JSONObject(jSONObject4.getString("headers"))), jSONObject4.optInt("priority", this.logConfig.defaultPriority), jSONObject4.optString(PaymentConstants.ENV, "all"), jSONObject4.optString("encryptionLevel", this.logConfig.encryptionLevel));
                            } catch (JSONException unused2) {
                            }
                        } catch (JSONException unused3) {
                            str3 = str3;
                        }
                    } catch (JSONException unused4) {
                    }
                } else {
                    i2 = i6;
                    logChannelMakeChannel = null;
                }
                if (logChannelMakeChannel == null) {
                    LogConfig logConfig3 = this.logConfig;
                    logChannelMakeChannel = makeChannel(str3, logConfig3.maxRetryPerBatch, logConfig3.maxLogsPerPush, logConfig3.prodLogUrl, logConfig3.sandboxLogUrl, channelObject.getKeyProd(), channelObject.getKeySBX(), channelObject.getHeaders(), 1, "all", this.logConfig.encryptionLevel);
                }
                pushOldChannelLogs(logChannelMakeChannel);
                i3++;
                length = i2;
            }
            LogConfig logConfig4 = this.logConfig;
            pushOldChannelLogs(makeChannel("", logConfig4.maxRetryPerBatch, logConfig4.maxLogsPerPush, logConfig4.prodLogUrl, logConfig4.sandboxLogUrl, channelObject.getKeyProd(), channelObject.getKeySBX(), channelObject.getHeaders(), 1, "all", this.logConfig.encryptionLevel));
        }
    }

    public void pushOldChannelLogs(LogChannel logChannel) {
        int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE + logChannel.getChannelName(), this.workspace);
        int i2 = 0;
        if (fromSharedPreference == -1) {
            this.workspace.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE + logChannel.getChannelName(), String.valueOf(0));
            fromSharedPreference = 0;
        }
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + logChannel.getChannelName(), this.workspace);
        if (fromSharedPreference2 == -1) {
            this.workspace.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + logChannel.getChannelName(), String.valueOf(0));
        } else {
            i2 = fromSharedPreference2;
        }
        pushAllFiles(fromSharedPreference, i2, logChannel);
    }

    public void setEndPointSandbox(Boolean bool) {
        this.isSandboxEnv = bool.booleanValue();
    }

    public void setHeaders(JSONObject jSONObject, String str) {
        ExecutorManager.runOnLogsPool(new b(this, str, jSONObject, 0));
    }

    public void setLogHeaderValues(JSONObject jSONObject, String str) {
        ExecutorManager.runOnLogsPool(new b(this, str, jSONObject, 1));
    }

    public void setLogHeaderValuesForChannels(JSONObject jSONObject) {
        if (this.logChannelsConfig != null) {
            for (int i2 = 0; i2 < this.logChannelsConfig.length(); i2++) {
                try {
                    setLogHeaderValues(jSONObject, this.logChannelsConfig.getJSONObject(i2).getString(AppsFlyerProperties.CHANNEL));
                } catch (JSONException unused) {
                }
            }
        }
        setLogHeaderValues(jSONObject, LogConstants.DEFAULT_CHANNEL);
    }

    public void setPushState(boolean z) {
        this.stopPushingLogs = !z;
    }

    public boolean shouldDropLog(JSONObject jSONObject) {
        try {
            if (jSONObject.has(AppsFlyerProperties.CHANNEL)) {
                return !this.channels.containsKey(jSONObject.getString(AppsFlyerProperties.CHANNEL));
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    public void addLogLines(Iterable<JSONObject> iterable) {
        if (this.stopPushingLogs) {
            return;
        }
        ExecutorManager.runOnLogsPool(new in.juspay.hypernfc.b(6, this, iterable));
    }
}
