package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.appsflyer.AppsFlyerProperties;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
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
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public class LogPusherExp {
    private static final String TAG = "LogPusher";
    private final File crashLogFile;
    private final LogConfig logConfig;
    private TimerTask logPushTimerTask;
    private final LogWorkspace logWorkspace;
    private final ConcurrentHashMap<String, LogChannelExp> channels = new ConcurrentHashMap<>();
    private int logFlushTimerTaskErrorCounter = 0;
    private int setHeaderParametersErrorCounter = 0;
    private boolean isSandboxEnv = false;

    @NonNull
    private Timer logPushTimer = new Timer();
    private final ConcurrentHashMap<String, Integer> fileCountMap = new ConcurrentHashMap<>();
    private boolean isExceptionTracked = false;

    public class LogPushTimerTask extends TimerTask {
        private static final String TAG = "LogPushTimerTask";

        public LogPushTimerTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (LogPusherExp.this.logConfig.shouldPush && LogUtils.isMinMemoryAvailable(LogPusherExp.this.logConfig).booleanValue()) {
                LogPusherExp.this.checkFolderLimit();
                LogPusherExp.this.pushAllLogs();
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ExecutorManager.runOnLogPusherThread(new g(this, 1));
        }
    }

    public LogPusherExp(@NonNull Workspace workspace, @NonNull LogConfig logConfig) {
        LogWorkspace logWorkspace = new LogWorkspace(workspace);
        this.logWorkspace = logWorkspace;
        this.logConfig = logConfig;
        this.crashLogFile = logWorkspace.open(LogConstants.CRASH_LOGS_FILE);
    }

    private static void acknowledgeLogsPushed(ArrayList<String> arrayList, LogChannelExp logChannelExp) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            logChannelExp.pollLogsQueue(it.next());
        }
    }

    private boolean addChannel(String str, int i2, long j2, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i3, String str4, String str5, JSONArray jSONArray, JSONArray jSONArray2, String str6) {
        boolean zContainsKey = this.channels.containsKey(str);
        LogChannelExp logChannelExpMakeChannel = makeChannel(str, i2, j2, str2, str3, jSONObject, jSONObject2, map, i3, str4, str5, jSONArray, jSONArray2, str6);
        this.channels.put(str, logChannelExpMakeChannel);
        if (!zContainsKey) {
            String fromSharedPreference = this.logWorkspace.getFromSharedPreference(LogConstants.LOG_CHANNEL_NAMES, "");
            this.logWorkspace.writeToSharedPreference(LogConstants.LOG_CHANNEL_NAMES, android.support.v4.media.b.r(android.support.v4.media.b.w(fromSharedPreference), fromSharedPreference.isEmpty() ? "" : ",", str));
        }
        this.logWorkspace.writeToSharedPreference(android.support.v4.media.b.C("LOG_CHANNEL_INFO_", str), logChannelExpMakeChannel.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFolderLimit() {
        File[] fileArrListFiles;
        File fileOpen = this.logWorkspace.open("");
        if (fileOpen == null || !fileOpen.exists() || (fileArrListFiles = fileOpen.listFiles()) == null) {
            return;
        }
        long length = 0;
        for (File file : fileArrListFiles) {
            if (file != null && file.exists() && file.isFile()) {
                length = file.length() + length;
            }
        }
        if (length < this.logConfig.folderSizeLimit) {
            return;
        }
        Arrays.sort(fileArrListFiles, new androidx.media3.datasource.cache.a(4));
        long j2 = (long) (this.logConfig.folderSizeLimit * 0.8d);
        for (File file2 : fileArrListFiles) {
            if (file2 != null && file2.exists() && file2.isFile()) {
                file2.delete();
                length -= file2.length();
            }
            if (length <= j2) {
                return;
            }
        }
    }

    public static int getBatchNum(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        int i2 = iLastIndexOf - 5;
        return Integer.parseInt(str.charAt(i2) == '-' ? str.substring(iLastIndexOf - 8, i2) : str.substring(iLastIndexOf - 3, iLastIndexOf));
    }

    private static JSONArray getBatchNumArray(ArrayList<String> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(getBatchNum(it.next()));
        }
        return jSONArray;
    }

    private LogChannelExp getChannelObject(String str) {
        return this.channels.containsKey(str) ? this.channels.get(str) : this.channels.get(LogConstants.DEFAULT_CHANNEL);
    }

    private String getEndPoint(LogChannelExp logChannelExp) {
        return this.isSandboxEnv ? logChannelExp.getEndpointSBX() : logChannelExp.getEndPointProd();
    }

    private int getFileCount(String str, File file) {
        Integer num;
        if (this.fileCountMap.containsKey(str) && (num = this.fileCountMap.get(str)) != null) {
            return num.intValue();
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int i2 = str.charAt(iLastIndexOf + (-5)) == '-' ? Integer.parseInt(str.substring(iLastIndexOf - 4, iLastIndexOf)) : traverseTheFile(str, file);
        this.fileCountMap.put(str, Integer.valueOf(i2));
        return i2;
    }

    private Pair<byte[], Integer> getFilesContent(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        int length = 0;
        int fileCount = 0;
        while (it.hasNext()) {
            String next = it.next();
            File fileOpen = this.logWorkspace.open(next);
            if (fileOpen != null && fileOpen.exists() && fileOpen.length() > 0) {
                byte[] logsFromFileExp = LogUtils.getLogsFromFileExp(fileOpen);
                length += logsFromFileExp.length;
                arrayList2.add(logsFromFileExp);
                fileCount += getFileCount(next, fileOpen);
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put((byte[]) it2.next());
        }
        return new Pair<>(byteBufferAllocate.array(), Integer.valueOf(fileCount));
    }

    private JSONObject getFirstLog(String str) throws IOException {
        JSONObject jSONObject = new JSONObject();
        if (str.contains(".ndjson")) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.logWorkspace.open(str)));
            try {
                JSONObject jSONObject2 = new JSONObject(bufferedReader.readLine());
                bufferedReader.close();
                return jSONObject2;
            } finally {
            }
        }
        if (str.contains(".dat")) {
            byte[] bArr = new byte[4];
            File fileOpen = this.logWorkspace.open(str);
            if (fileOpen != null && fileOpen.exists()) {
                FileInputStream fileInputStream = new FileInputStream(fileOpen);
                try {
                    fileInputStream.read(bArr);
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                    byteBufferAllocate.put(bArr);
                    byteBufferAllocate.rewind();
                    int i2 = byteBufferAllocate.getInt();
                    if (i2 >= 102400) {
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byte[] bArr2 = new byte[i2];
                    fileInputStream.read(bArr2);
                    JSONObject jSONObject3 = new JSONObject(new String(bArr2, StandardCharsets.UTF_8));
                    fileInputStream.close();
                    return jSONObject3;
                } finally {
                }
            }
        }
        return jSONObject;
        return jSONObject;
    }

    @Nullable
    private RSAPublicKey getLogEncryptionKey(LogChannelExp logChannelExp, int i2) {
        JSONObject keySBX;
        if (logChannelExp.getFallBackPublicKeys().length() == 0 || i2 < 0) {
            keySBX = null;
        } else {
            try {
                keySBX = (JSONObject) logChannelExp.getFallBackPublicKeys().get(i2);
            } catch (Exception unused) {
            }
        }
        if (keySBX == null) {
            keySBX = this.isSandboxEnv ? logChannelExp.getKeySBX() : logChannelExp.getKeyProd();
        }
        try {
            return JOSEUtils.JWKtoRSAPublicKey(keySBX);
        } catch (Exception unused2) {
            return null;
        }
    }

    private static String getLogEncryptionLevel(LogChannelExp logChannelExp) {
        return logChannelExp.getEncryptionLevel();
    }

    private void hitErrorUrl(String str, LogChannelExp logChannelExp, int i2) {
        try {
            if (Objects.equals(logChannelExp.getErrorUrl(), "")) {
                return;
            }
            JSONObject firstLog = getFirstLog(str);
            HashMap map = new HashMap();
            try {
                map.put("session_id", firstLog.optString("session_id", ""));
                map.put("start_with", String.valueOf(firstLog.optInt("sn", 0)));
                map.put("total_count", this.fileCountMap.containsKey(str) ? String.valueOf(this.fileCountMap.get(str)) : zzck.UNKNOWN_CONTENT_TYPE);
                map.put("channel_name", logChannelExp.getChannelName());
                map.put("response_code", String.valueOf(i2));
            } catch (Exception unused) {
            }
            Response responseDoGet = new HyperNetUtils(JuspayCoreLib.getApplicationContext(), 30000, 30000).doGet(logChannelExp.getErrorUrl(), new HashMap(), map, new JSONObject(), null);
            if (responseDoGet != null) {
                responseDoGet.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogLines$3(String str, String str2) {
        if (this.logConfig.shouldPush) {
            try {
                LogChannelExp channelObject = getChannelObject(str);
                if (channelObject == null) {
                    channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
                }
                File fileOpen = this.logWorkspace.open(str2);
                if (fileOpen == null || !fileOpen.exists() || fileOpen.length() <= 0) {
                    return;
                }
                channelObject.addToLogsQueue(str2);
            } catch (Exception e2) {
                int i2 = this.logFlushTimerTaskErrorCounter + 1;
                this.logFlushTimerTaskErrorCounter = i2;
                if (i2 <= 2) {
                    SdkTracker.trackAndLogBootException(TAG, "action", "system", Labels.System.LOG_PUSHER, "Exception while flushing the logs to persisted queue file", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogsToPersistedQueue$2(JSONObject jSONObject) {
        if (this.logConfig.shouldPush) {
            try {
                LogUtils.writeLogToFileExp(jSONObject, this.crashLogFile);
            } catch (Exception e2) {
                JuspayLogger.e(TAG, "addLogsToPersistedQueue failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$checkFolderLimit$4(File file, File file2) {
        return Long.compare(file.lastModified(), file2.lastModified());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearBacklog$0(String str, LogChannelExp logChannelExp) {
        pushChannelFiles(str, logChannelExp);
        this.logWorkspace.removeFromSharedPreference("LOG_CHANNEL_INFO_" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearBacklog$1() {
        pushChannelFiles(LogConstants.DEFAULT_CHANNEL, this.channels.get(LogConstants.DEFAULT_CHANNEL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pushAllLogs$6() {
        File fileOpen;
        File fileOpen2;
        Iterator<Map.Entry<String, LogChannelExp>> it = this.channels.entrySet().iterator();
        while (it.hasNext()) {
            LogChannelExp value = it.next().getValue();
            try {
                ArrayList<File> arrayList = new ArrayList<>();
                Iterator<String> it2 = value.getLogsQueueExp().iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (next.contains(".ndjson") && (fileOpen2 = this.logWorkspace.open(next)) != null && fileOpen2.exists()) {
                        arrayList.add(fileOpen2);
                    }
                }
                pushNdJsonFiles(arrayList, value, true);
                arrayList.clear();
                Iterator<String> it3 = value.getLogsQueueExp().iterator();
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    if (next2.contains(".dat") && (fileOpen = this.logWorkspace.open(next2)) != null && fileOpen.exists()) {
                        arrayList.add(fileOpen);
                    }
                }
                pushDatFiles(arrayList, value, true);
            } catch (Exception e2) {
                if (!this.isExceptionTracked) {
                    SdkTracker.trackAndLogBootException(TAG, "action", "system", Labels.System.LOG_PUSHER, "Error while creating the payload to post", e2);
                }
                this.isExceptionTracked = true;
            }
        }
        for (Map.Entry<String, LogChannelExp> entry : this.channels.entrySet()) {
            pushChannelFiles(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$pushChannelFiles$5(String str, File file, String str2) {
        return str2.contains(str);
    }

    private void loadSavedChannels() throws JSONException {
        JSONArray jSONArray = this.logConfig.logChannelsConfig;
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    addChannelFromJS(jSONObject.toString(), jSONObject.getString(AppsFlyerProperties.CHANNEL));
                } catch (JSONException unused) {
                    return;
                }
            }
        }
    }

    private LogChannelExp makeChannel(String str, int i2, long j2, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i3, String str4, String str5, JSONArray jSONArray, JSONArray jSONArray2, String str6) {
        return new LogChannelExp(i2, j2, str, str2, str3, jSONObject, jSONObject2, map, i3, str4, str5, jSONArray, jSONArray2, str6);
    }

    private void pushChannelFiles(final String str, LogChannelExp logChannelExp) {
        try {
            File file = this.logWorkspace.logsDir;
            if (file != null && file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: in.juspay.hypersdk.analytics.d
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file2, String str2) {
                        return LogPusherExp.lambda$pushChannelFiles$5(str, file2, str2);
                    }
                });
                ArrayList<File> arrayList = new ArrayList<>();
                ArrayList<File> arrayList2 = new ArrayList<>();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null && file2.exists() && file2.isFile()) {
                            if (file2.length() <= 0 || !LogUtils.isFileEligibleToPush(file2, this.logConfig)) {
                                file2.delete();
                            } else if (file2.getName().contains(".ndjson")) {
                                arrayList.add(file2);
                            } else {
                                arrayList2.add(file2);
                            }
                        }
                    }
                }
                pushNdJsonFiles(arrayList, logChannelExp, false);
                pushDatFiles(arrayList2, logChannelExp, false);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushCrashLogFile() {
        if (JuspayCoreLib.getApplicationContext() != null) {
            LogChannelExp channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
            File file = this.crashLogFile;
            if (file == null || !file.exists()) {
                return;
            }
            if (this.crashLogFile.length() <= 0 || !LogUtils.isFileEligibleToPush(this.crashLogFile, this.logConfig)) {
                this.crashLogFile.delete();
            } else {
                pushFileContentToServer(this.crashLogFile, channelObject);
            }
        }
    }

    private void pushFileContentToServer(File file, LogChannelExp logChannelExp) {
        try {
            if (pushLogsToServer(LogUtils.getLogsFromFileExp(file), getFileCount(file.getName(), file), new JSONArray().put(1), logChannelExp, false) == 200) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private int pushLogsToServer(byte[] bArr, int i2, JSONArray jSONArray, LogChannelExp logChannelExp, boolean z) throws JSONException {
        JuspayHttpsResponse juspayHttpsResponse;
        int currentBatchRetryAttempts;
        String logEncryptionLevel = getLogEncryptionLevel(logChannelExp);
        RSAPublicKey logEncryptionKey = getLogEncryptionKey(logChannelExp, logChannelExp.getRetryAttempts() - 1);
        HyperNetUtils hyperNetUtils = new HyperNetUtils(JuspayCoreLib.getApplicationContext(), 10000, 10000);
        Map<String, String> headers = logChannelExp.getHeaders();
        headers.put("x-logscount", String.valueOf(i2));
        headers.put(AppsFlyerProperties.CHANNEL, logChannelExp.getChannelName());
        headers.put("x-log-format", z ? "ndjson" : "byte-d-json");
        headers.put("x-batch-no", jSONArray.toString());
        String endPoint = getEndPoint(logChannelExp);
        JSONArray fallBackUrls = logChannelExp.getFallBackUrls();
        if (fallBackUrls.length() != 0 && (currentBatchRetryAttempts = logChannelExp.getCurrentBatchRetryAttempts()) > 0) {
            endPoint = fallBackUrls.getString((currentBatchRetryAttempts - 1) % fallBackUrls.length());
        }
        if ("encryption".equals(logEncryptionLevel) && logEncryptionKey != null) {
            juspayHttpsResponse = new JuspayHttpsResponse(hyperNetUtils.doPost(new URL(endPoint), EncryptionHelper.gzipThenEncryptExp(bArr, logEncryptionKey, headers), "application/x-godel-gzip-pubkey-encrypted", headers, new JSONObject(), null));
        } else if ("gzip".equals(logEncryptionLevel)) {
            byte[] bArrGzipContent = Utils.gzipContent(bArr);
            headers.put("Content-Encoding", "gzip");
            juspayHttpsResponse = new JuspayHttpsResponse(hyperNetUtils.doPost(new URL(endPoint), bArrGzipContent, "application/gzip", headers, new JSONObject(), null));
        } else {
            juspayHttpsResponse = new JuspayHttpsResponse(hyperNetUtils.doPost(new URL(endPoint), bArr, "application/json", headers, new JSONObject(), null));
        }
        return juspayHttpsResponse.responseCode;
    }

    public boolean addChannelFromJS(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return addChannel(str2, jSONObject.optInt("retryAttempts", this.logConfig.maxRetryPerBatch), jSONObject.optLong("batchCount", this.logConfig.maxLogsPerPush), jSONObject.optString("logsUrlKey", this.logConfig.prodLogUrl), jSONObject.optString("logsUrlKeySandbox", this.logConfig.sandboxLogUrl), jSONObject.has("publicKey") ? jSONObject.getJSONObject("publicKey") : this.logConfig.publicKey, jSONObject.has("publicKeySandbox") ? jSONObject.getJSONObject("publicKeySandbox") : this.logConfig.publicKeySandbox, jSONObject.has("channelHeaders") ? LogUtils.toMap(jSONObject.getJSONObject("channelHeaders")) : new HashMap<>(), jSONObject.optInt("priority", this.logConfig.defaultPriority), jSONObject.optString(PaymentConstants.ENV, "all"), jSONObject.optString("encryptionLevelKey", this.logConfig.encryptionLevel), jSONObject.has("fallBackUrls") ? jSONObject.optJSONArray("fallBackUrls") : this.logConfig.fallBackUrl, jSONObject.has("fallBackPublicKeys") ? jSONObject.optJSONArray("fallBackPublicKeys") : this.logConfig.fallBackPublicKeys, jSONObject.optString("errorUrl", this.logConfig.errorUrl));
        } catch (JSONException unused) {
            return false;
        }
    }

    public void addLogLines(String str, String str2) {
        ExecutorManager.runOnLogPusherThread(new androidx.media3.common.util.e(this, str, str2, 20));
    }

    public void addLogsToPersistedQueue(JSONObject jSONObject) {
        ExecutorManager.runOnLogSessioniserThread(new in.juspay.hypernfc.b(7, this, jSONObject));
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void clearBacklog() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusherExp.clearBacklog():void");
    }

    public Set<String> getChannelNames() {
        return this.channels.keySet();
    }

    public void pushAllLogs() {
        ExecutorManager.runOnLogPusherThread(new e(this, 0));
    }

    public void pushDatFiles(ArrayList<File> arrayList, LogChannelExp logChannelExp, boolean z) {
        LogChannelExp logChannelExp2;
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next == null || !next.exists() || next.length() <= 0) {
                    logChannelExp2 = logChannelExp;
                    if (next != null && z) {
                        arrayList2.add(next.getName());
                    }
                } else {
                    String name = next.getName();
                    if (next.length() > 0) {
                        logChannelExp2 = logChannelExp;
                        try {
                            int iPushLogsToServer = pushLogsToServer(LogUtils.getLogsFromFileExp(next), getFileCount(name, next), new JSONArray().put(getBatchNum(name)), logChannelExp2, false);
                            if (iPushLogsToServer != 200 && (logChannelExp2.getRetryAttempts() == -1 || logChannelExp2.getCurrentBatchRetryAttempts() < logChannelExp2.getRetryAttempts())) {
                                SdkTracker.trackBootAction("system", "error", Labels.System.LOG_PUSHER, "error_response", Integer.valueOf(iPushLogsToServer));
                                logChannelExp2.setCurrentBatchRetryAttempts(logChannelExp2.getCurrentBatchRetryAttempts() + 1);
                            }
                            if (logChannelExp2.getRetryAttempts() != -1 && logChannelExp2.getCurrentBatchRetryAttempts() >= logChannelExp2.getRetryAttempts()) {
                                hitErrorUrl(name, logChannelExp2, iPushLogsToServer);
                                logChannelExp2.setCurrentBatchRetryAttempts(0);
                                if (z) {
                                    arrayList2.add(name);
                                }
                            }
                            if (iPushLogsToServer == 200) {
                                logChannelExp2.setCurrentBatchRetryAttempts(0);
                                if (z) {
                                    arrayList2.add(name);
                                }
                                next.delete();
                            }
                        } catch (Exception unused) {
                            return;
                        }
                    } else {
                        logChannelExp2 = logChannelExp;
                        if (z) {
                            arrayList2.add(name);
                        }
                        next.delete();
                    }
                }
                logChannelExp = logChannelExp2;
            }
            acknowledgeLogsPushed(arrayList2, logChannelExp);
        } catch (Exception unused2) {
        }
    }

    public void pushNdJsonFiles(ArrayList<File> arrayList, LogChannelExp logChannelExp, boolean z) {
        try {
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i2 >= arrayList.size()) {
                    acknowledgeLogsPushed(arrayList2, logChannelExp);
                    return;
                }
                int i4 = i2;
                long j2 = 0;
                while (i4 < arrayList.size()) {
                    File file = arrayList.get(i4);
                    if (file != null && file.exists()) {
                        int fileCount = getFileCount(file.getName(), file);
                        if (j2 != 0 && fileCount + j2 > logChannelExp.getBatchCount()) {
                            break;
                        } else {
                            j2 += fileCount;
                        }
                    }
                    i4++;
                }
                if (j2 != 0) {
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    for (int i5 = i3; i5 < i4; i5++) {
                        arrayList3.add(arrayList.get(i5).getName());
                    }
                    Pair<byte[], Integer> filesContent = getFilesContent(arrayList3);
                    JSONArray batchNumArray = getBatchNumArray(arrayList3);
                    byte[] bArr = filesContent.f2989a;
                    if (bArr == null || bArr.length <= 0) {
                        while (i3 < i4) {
                            if (z) {
                                arrayList2.add(arrayList.get(i3).getName());
                            }
                            arrayList.get(i3).delete();
                            i3++;
                        }
                    } else {
                        byte[] bArr2 = bArr;
                        Integer num = filesContent.f2990b;
                        int iPushLogsToServer = pushLogsToServer(bArr2, num == null ? 1 : num.intValue(), batchNumArray, logChannelExp, true);
                        if (iPushLogsToServer != 200 && (logChannelExp.getRetryAttempts() == -1 || logChannelExp.getCurrentBatchRetryAttempts() < logChannelExp.getRetryAttempts())) {
                            SdkTracker.trackBootAction("system", "error", Labels.System.LOG_PUSHER, "error_response", Integer.valueOf(iPushLogsToServer));
                            logChannelExp.setCurrentBatchRetryAttempts(logChannelExp.getCurrentBatchRetryAttempts() + 1);
                        }
                        if (logChannelExp.getRetryAttempts() != -1 && logChannelExp.getCurrentBatchRetryAttempts() >= logChannelExp.getRetryAttempts()) {
                            for (int i6 = i3; i6 < i4; i6++) {
                                String name = arrayList.get(i6).getName();
                                hitErrorUrl(name, logChannelExp, iPushLogsToServer);
                                if (z) {
                                    arrayList2.add(name);
                                }
                            }
                            logChannelExp.setCurrentBatchRetryAttempts(0);
                        }
                        if (iPushLogsToServer == 200) {
                            logChannelExp.setCurrentBatchRetryAttempts(0);
                            while (i3 < i4) {
                                if (z) {
                                    arrayList2.add(arrayList.get(i3).getName());
                                }
                                arrayList.get(i3).delete();
                                i3++;
                            }
                        }
                    }
                } else {
                    while (i3 < i4) {
                        if (z) {
                            arrayList2.add(arrayList.get(i3).getName());
                        }
                        arrayList.get(i3).delete();
                        i3++;
                    }
                }
                i2 = i4;
            }
        } catch (Exception unused) {
        }
    }

    public void setEndPointSandbox(Boolean bool) {
        this.isSandboxEnv = bool.booleanValue();
    }

    public void setHeaders(JSONObject jSONObject, String str) {
        LogChannelExp channelObject = getChannelObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                channelObject.getHeaders().put(next, jSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
    }

    public void setLogHeaderValues(JSONObject jSONObject, String str) {
        LogChannelExp channelObject = getChannelObject(str);
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

    public void setLogHeaderValuesForChannels(JSONObject jSONObject) {
        JSONArray jSONArray = this.logConfig.logChannelsConfig;
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    setLogHeaderValues(jSONObject, jSONArray.getJSONObject(i2).getString(AppsFlyerProperties.CHANNEL));
                } catch (JSONException unused) {
                }
            }
        }
        setLogHeaderValues(jSONObject, LogConstants.DEFAULT_CHANNEL);
    }

    public void startLogPusher() {
        if (this.logConfig.shouldPush) {
            try {
                this.logPushTimer = new Timer();
                LogPushTimerTask logPushTimerTask = new LogPushTimerTask();
                this.logPushTimerTask = logPushTimerTask;
                this.logPushTimer.scheduleAtFixedRate(logPushTimerTask, 0L, this.logConfig.logPostInterval);
            } catch (Exception unused) {
            }
        }
    }

    public void stopLogPusherOnTerminate() {
        if (this.logConfig.shouldPush) {
            try {
                this.logPushTimer.cancel();
                this.logPushTimer = new Timer();
                LogPushTimerTask logPushTimerTask = new LogPushTimerTask();
                this.logPushTimerTask = logPushTimerTask;
                logPushTimerTask.run();
            } catch (Exception unused) {
            }
        }
    }

    public int traverseTheFile(String str, File file) throws IOException {
        int i2 = 0;
        if (!str.contains(".dat")) {
            if (!str.contains(".ndjson")) {
                return 1;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.logWorkspace.open(str)));
                try {
                    byte[] bArr = new byte[1024];
                    boolean z = false;
                    int i3 = 0;
                    while (true) {
                        int i4 = bufferedInputStream.read(bArr);
                        if (i4 == -1) {
                            break;
                        }
                        for (int i5 = 0; i5 < i4; i5++) {
                            if (bArr[i5] == 10) {
                                i3++;
                            }
                        }
                        z = bArr[i4 + (-1)] != 10;
                    }
                    if (z) {
                        i3++;
                    }
                    int i6 = i3;
                    bufferedInputStream.close();
                    return i6;
                } finally {
                }
            } catch (Exception unused) {
                return 0;
            }
        }
        long length = file.length();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i7 = 0;
            while (i2 < length) {
                try {
                    try {
                        byte[] bArr2 = new byte[4];
                        fileInputStream.read(bArr2);
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                        byteBufferAllocate.put(bArr2);
                        byteBufferAllocate.rewind();
                        int i8 = byteBufferAllocate.getInt();
                        if (i8 > 102400) {
                            fileInputStream.close();
                            return i7;
                        }
                        long j2 = i8;
                        if (fileInputStream.skip(j2) < j2) {
                            fileInputStream.close();
                            return i7;
                        }
                        i2 += i8 + 4;
                        i7++;
                    } finally {
                    }
                } catch (Exception unused2) {
                    return i7;
                }
            }
            fileInputStream.close();
            return i7;
        } catch (Exception unused3) {
            return 0;
        }
    }
}
