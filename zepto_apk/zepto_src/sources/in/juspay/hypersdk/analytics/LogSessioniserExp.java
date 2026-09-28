package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.appsflyer.AppsFlyerProperties;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.core.ExecutorManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LogSessioniserExp {
    private final LogConfig logConfig;
    private final LogPusherExp logPusherExp;
    private final LogWorkspace logWorkspace;

    @Nullable
    private TimerTask moveToPusher;

    @NonNull
    private String rawLogsrequestId = LogUtils.generateUUID().replace("-", "");

    @NonNull
    private Timer moveToPusherTimer = new Timer();

    @NonNull
    private final AtomicInteger batchNumber = new AtomicInteger(0);
    private boolean tempFlipDone = false;

    @NonNull
    private final AtomicBoolean pushFileCreated = new AtomicBoolean(false);

    @NonNull
    private LoggerState loggerState = LoggerState.IDLE;

    @NonNull
    private ConcurrentHashMap<String, FileOutputStream> fosMap = new ConcurrentHashMap<>();

    @NonNull
    private ConcurrentHashMap<String, ArrayList<String>> currentFilesObj = new ConcurrentHashMap<>();

    @NonNull
    private final ConcurrentLinkedQueue<String> filesObj = new ConcurrentLinkedQueue<>();

    @NonNull
    private final ConcurrentHashMap<String, Pair<Integer, Integer>> logsCount = new ConcurrentHashMap<>();

    public class LogSessioniserTimerTask extends TimerTask {
        private LogSessioniserTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (LogSessioniserExp.this.logConfig.shouldPush && LogUtils.isMinMemoryAvailable(LogSessioniserExp.this.logConfig).booleanValue()) {
                ExecutorManager.runOnLogSessioniserThread(new h(LogSessioniserExp.this, 0));
            }
        }
    }

    public LogSessioniserExp(@NonNull Workspace workspace, @NonNull LogConfig logConfig, @NonNull LogPusherExp logPusherExp) {
        this.logWorkspace = new LogWorkspace(workspace);
        this.logConfig = logConfig;
        this.logPusherExp = logPusherExp;
    }

    public static /* synthetic */ void access$200(LogSessioniserExp logSessioniserExp) throws IOException {
        logSessioniserExp.pushToPusher();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f5 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:2:0x0000, B:7:0x0013, B:10:0x0022, B:12:0x002c, B:14:0x003f, B:16:0x0049, B:18:0x004d, B:20:0x005c, B:24:0x00ed, B:26:0x00f5, B:29:0x0101, B:31:0x0107, B:33:0x0122, B:35:0x013c, B:37:0x0146, B:39:0x0157, B:41:0x015f, B:43:0x0163, B:38:0x014a, B:32:0x0115, B:45:0x016d, B:48:0x0177, B:50:0x0182, B:54:0x018d, B:56:0x0191, B:59:0x01a1, B:61:0x01d1, B:63:0x01db, B:64:0x01ec, B:66:0x01f8, B:67:0x0209, B:57:0x0196, B:53:0x0187, B:58:0x019d, B:60:0x01b8, B:22:0x008d, B:23:0x00bd), top: B:70:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0101 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:2:0x0000, B:7:0x0013, B:10:0x0022, B:12:0x002c, B:14:0x003f, B:16:0x0049, B:18:0x004d, B:20:0x005c, B:24:0x00ed, B:26:0x00f5, B:29:0x0101, B:31:0x0107, B:33:0x0122, B:35:0x013c, B:37:0x0146, B:39:0x0157, B:41:0x015f, B:43:0x0163, B:38:0x014a, B:32:0x0115, B:45:0x016d, B:48:0x0177, B:50:0x0182, B:54:0x018d, B:56:0x0191, B:59:0x01a1, B:61:0x01d1, B:63:0x01db, B:64:0x01ec, B:66:0x01f8, B:67:0x0209, B:57:0x0196, B:53:0x0187, B:58:0x019d, B:60:0x01b8, B:22:0x008d, B:23:0x00bd), top: B:70:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0177 A[Catch: Exception -> 0x020c, TRY_ENTER, TryCatch #0 {Exception -> 0x020c, blocks: (B:2:0x0000, B:7:0x0013, B:10:0x0022, B:12:0x002c, B:14:0x003f, B:16:0x0049, B:18:0x004d, B:20:0x005c, B:24:0x00ed, B:26:0x00f5, B:29:0x0101, B:31:0x0107, B:33:0x0122, B:35:0x013c, B:37:0x0146, B:39:0x0157, B:41:0x015f, B:43:0x0163, B:38:0x014a, B:32:0x0115, B:45:0x016d, B:48:0x0177, B:50:0x0182, B:54:0x018d, B:56:0x0191, B:59:0x01a1, B:61:0x01d1, B:63:0x01db, B:64:0x01ec, B:66:0x01f8, B:67:0x0209, B:57:0x0196, B:53:0x0187, B:58:0x019d, B:60:0x01b8, B:22:0x008d, B:23:0x00bd), top: B:70:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b8 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:2:0x0000, B:7:0x0013, B:10:0x0022, B:12:0x002c, B:14:0x003f, B:16:0x0049, B:18:0x004d, B:20:0x005c, B:24:0x00ed, B:26:0x00f5, B:29:0x0101, B:31:0x0107, B:33:0x0122, B:35:0x013c, B:37:0x0146, B:39:0x0157, B:41:0x015f, B:43:0x0163, B:38:0x014a, B:32:0x0115, B:45:0x016d, B:48:0x0177, B:50:0x0182, B:54:0x018d, B:56:0x0191, B:59:0x01a1, B:61:0x01d1, B:63:0x01db, B:64:0x01ec, B:66:0x01f8, B:67:0x0209, B:57:0x0196, B:53:0x0187, B:58:0x019d, B:60:0x01b8, B:22:0x008d, B:23:0x00bd), top: B:70:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01db A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:2:0x0000, B:7:0x0013, B:10:0x0022, B:12:0x002c, B:14:0x003f, B:16:0x0049, B:18:0x004d, B:20:0x005c, B:24:0x00ed, B:26:0x00f5, B:29:0x0101, B:31:0x0107, B:33:0x0122, B:35:0x013c, B:37:0x0146, B:39:0x0157, B:41:0x015f, B:43:0x0163, B:38:0x014a, B:32:0x0115, B:45:0x016d, B:48:0x0177, B:50:0x0182, B:54:0x018d, B:56:0x0191, B:59:0x01a1, B:61:0x01d1, B:63:0x01db, B:64:0x01ec, B:66:0x01f8, B:67:0x0209, B:57:0x0196, B:53:0x0187, B:58:0x019d, B:60:0x01b8, B:22:0x008d, B:23:0x00bd), top: B:70:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f8 A[Catch: Exception -> 0x020c, TryCatch #0 {Exception -> 0x020c, blocks: (B:2:0x0000, B:7:0x0013, B:10:0x0022, B:12:0x002c, B:14:0x003f, B:16:0x0049, B:18:0x004d, B:20:0x005c, B:24:0x00ed, B:26:0x00f5, B:29:0x0101, B:31:0x0107, B:33:0x0122, B:35:0x013c, B:37:0x0146, B:39:0x0157, B:41:0x015f, B:43:0x0163, B:38:0x014a, B:32:0x0115, B:45:0x016d, B:48:0x0177, B:50:0x0182, B:54:0x018d, B:56:0x0191, B:59:0x01a1, B:61:0x01d1, B:63:0x01db, B:64:0x01ec, B:66:0x01f8, B:67:0x0209, B:57:0x0196, B:53:0x0187, B:58:0x019d, B:60:0x01b8, B:22:0x008d, B:23:0x00bd), top: B:70:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void addToLogs(java.lang.String r13, java.lang.String r14, org.json.JSONObject r15) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogSessioniserExp.addToLogs(java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    private void getAllTempFiles(JSONObject jSONObject) throws JSONException {
        Iterator<String> it = this.filesObj.iterator();
        while (it.hasNext()) {
            try {
                jSONObject.put(it.next(), "");
            } catch (Exception unused) {
            }
        }
        Iterator<Map.Entry<String, ArrayList<String>>> it2 = this.currentFilesObj.entrySet().iterator();
        while (it2.hasNext()) {
            try {
                Iterator<String> it3 = it2.next().getValue().iterator();
                while (it3.hasNext()) {
                    jSONObject.put(it3.next(), "");
                }
            } catch (Exception unused2) {
            }
        }
    }

    private JSONArray getLogChannels(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channels");
        if ((jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) && jSONObject.has(AppsFlyerProperties.CHANNEL)) {
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            jSONArrayOptJSONArray.put(jSONObject.optString(AppsFlyerProperties.CHANNEL, LogConstants.DEFAULT_CHANNEL));
        }
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            return jSONArrayOptJSONArray;
        }
        try {
            jSONArray = this.logConfig.defaultChannels != null ? new JSONArray(this.logConfig.defaultChannels.toString()) : new JSONArray();
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        jSONArray.put(LogConstants.DEFAULT_CHANNEL);
        return jSONArray;
    }

    private int getLogCount(String str) {
        Integer num;
        if (this.logsCount.get(str) == null) {
            File fileOpen = this.logWorkspace.open(str);
            if (fileOpen != null) {
                return this.logPusherExp.traverseTheFile(str, fileOpen);
            }
            return 0;
        }
        Pair<Integer, Integer> pair = this.logsCount.get(str);
        if (pair != null && (num = pair.f2989a) != null) {
            return num.intValue();
        }
        File fileOpen2 = this.logWorkspace.open(str);
        if (fileOpen2 != null) {
            return this.logPusherExp.traverseTheFile(str, fileOpen2);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogLine$1(JSONObject jSONObject) throws JSONException {
        if (this.logConfig.shouldPush) {
            JSONArray logChannels = getLogChannels(jSONObject);
            Set<String> channelNames = this.logPusherExp.getChannelNames();
            boolean z = LoggerState.BUFFERING.equals(this.loggerState) && shouldAllowLog(jSONObject);
            for (int i2 = 0; i2 < logChannels.length(); i2++) {
                if (z) {
                    try {
                        String string = logChannels.getString(i2);
                        if (channelNames.contains(string)) {
                            String str = "logs-" + string + "-" + this.rawLogsrequestId + String.format(Locale.US, "-%03d", Integer.valueOf(this.batchNumber.incrementAndGet())) + "-0001" + (this.logConfig.fileFormat.equals("ndJson") ? ".ndjson" : ".dat");
                            try {
                                jSONObject.put("batch_number", this.batchNumber.get());
                            } catch (Exception unused) {
                            }
                            File fileOpen = this.logWorkspace.open("original/" + str);
                            LogUtils.writeLogToFileExp(jSONObject, fileOpen);
                            File fileOpen2 = this.logWorkspace.open(str);
                            if (fileOpen != null && fileOpen2 != null) {
                                fileOpen.renameTo(fileOpen2);
                            }
                            this.logPusherExp.addLogLines(string, str);
                        }
                    } catch (Exception unused2) {
                    }
                } else {
                    String string2 = logChannels.getString(i2);
                    if (channelNames.contains(string2)) {
                        addToLogs(string2, this.rawLogsrequestId, jSONObject);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pushToPusher$3(ConcurrentHashMap concurrentHashMap, boolean z) {
        StringBuilder sb;
        File fileOpen;
        if (LoggerState.BUFFERING.equals(this.loggerState)) {
            Iterator it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                ArrayList arrayList = (ArrayList) ((Map.Entry) it.next()).getValue();
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    int iLastIndexOf = str.lastIndexOf(46);
                    String str2 = str.substring(0, iLastIndexOf) + String.format(Locale.US, "-%04d", Integer.valueOf(getLogCount(str))) + str.substring(iLastIndexOf);
                    File fileOpen2 = this.logWorkspace.open("temp/".concat(str));
                    File fileOpen3 = this.logWorkspace.open("temp/" + str2);
                    if (fileOpen2 != null && fileOpen2.exists()) {
                        if (fileOpen3 != null) {
                            fileOpen2.renameTo(fileOpen3);
                        }
                        arrayList2.add(str2);
                    }
                }
                this.filesObj.addAll(arrayList2);
            }
        }
        if (LoggerState.PUSHING.equals(this.loggerState)) {
            try {
                Iterator<String> it3 = this.filesObj.iterator();
                while (it3.hasNext()) {
                    String next = it3.next();
                    File fileOpen4 = this.logWorkspace.open("temp/" + next);
                    if (fileOpen4 != null && fileOpen4.exists() && (fileOpen = this.logWorkspace.open(next)) != null) {
                        fileOpen4.renameTo(fileOpen);
                    }
                }
            } catch (Exception unused) {
            }
            Iterator it4 = concurrentHashMap.entrySet().iterator();
            while (it4.hasNext()) {
                try {
                    Iterator it5 = ((ArrayList) ((Map.Entry) it4.next()).getValue()).iterator();
                    while (it5.hasNext()) {
                        String str3 = (String) it5.next();
                        LogWorkspace logWorkspace = this.logWorkspace;
                        if (z) {
                            sb = new StringBuilder();
                            sb.append("temp/");
                            sb.append(str3);
                        } else {
                            sb = new StringBuilder();
                            sb.append("original/");
                            sb.append(str3);
                        }
                        File fileOpen5 = logWorkspace.open(sb.toString());
                        if (fileOpen5 != null && fileOpen5.exists()) {
                            int iLastIndexOf2 = str3.lastIndexOf(46);
                            File fileOpen6 = this.logWorkspace.open(str3.substring(0, iLastIndexOf2) + String.format(Locale.US, "-%04d", Integer.valueOf(getLogCount(str3))) + str3.substring(iLastIndexOf2));
                            if (fileOpen6 != null) {
                                fileOpen5.renameTo(fileOpen6);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPushing$2() throws JSONException, IOException {
        LoggerState loggerState = LoggerState.PUSHING;
        if (loggerState.equals(this.loggerState)) {
            return;
        }
        this.pushFileCreated.set(true);
        updatePushFile();
        synchronized (this.loggerState) {
            this.loggerState = loggerState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopLogSessioniserOnTerminate$0() {
        try {
            TimerTask timerTask = this.moveToPusher;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.moveToPusherTimer.cancel();
            if (this.logConfig.shouldPush) {
                pushToPusher();
            }
            this.loggerState = LoggerState.TERMINATED;
        } catch (Exception unused) {
        }
        LogPusherExp logPusherExp = this.logPusherExp;
        Objects.requireNonNull(logPusherExp);
        ExecutorManager.runOnLogPusherThread(new e(logPusherExp, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushToPusher() throws IOException {
        boolean z;
        this.rawLogsrequestId = LogUtils.generateUUID().replace("-", "");
        Iterator<Map.Entry<String, FileOutputStream>> it = this.fosMap.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().close();
            } catch (Exception unused) {
            }
        }
        this.fosMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap = this.currentFilesObj;
        this.currentFilesObj = new ConcurrentHashMap<>();
        synchronized (this.loggerState) {
            try {
                if (!LoggerState.PUSHING.equals(this.loggerState) || this.tempFlipDone) {
                    z = false;
                } else {
                    z = true;
                    this.tempFlipDone = true;
                }
                ExecutorManager.runOnBackgroundThread(new com.unistyles.a(this, concurrentHashMap, z));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean shouldAllowLog(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.logConfig.allowWhileBuffering;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (jSONObject.has(next)) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                if (Objects.equals(jSONArray2.get(i3), jSONObject.get(next))) {
                                    break;
                                }
                            }
                        }
                    }
                    return true;
                }
                continue;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePushFile() throws JSONException, IOException {
        File fileOpen = this.logWorkspace.open("temp/push.json");
        if (fileOpen != null) {
            JSONObject jSONObject = new JSONObject();
            if (fileOpen.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileOpen);
                    try {
                        byte[] bArr = new byte[(int) fileOpen.length()];
                        fileInputStream.read(bArr);
                        JSONObject jSONObject2 = new JSONObject(new String(bArr));
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            }
            getAllTempFiles(jSONObject);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileOpen);
                try {
                    fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.close();
                } finally {
                }
            } catch (Exception unused3) {
            }
        }
    }

    public void addLogLine(JSONObject jSONObject) {
        ExecutorManager.runOnLogSessioniserThread(new in.juspay.hypernfc.b(9, this, jSONObject));
    }

    public void startLogSessioniser() {
        if (LoggerState.PUSHING.equals(this.loggerState)) {
            return;
        }
        this.loggerState = LoggerState.BUFFERING;
        try {
            this.logPusherExp.startLogPusher();
            this.logWorkspace.open("temp/").mkdirs();
            this.logWorkspace.open("original/").mkdirs();
            this.moveToPusherTimer = new Timer();
            LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
            this.moveToPusher = logSessioniserTimerTask;
            this.moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0L, this.logConfig.logSessioniseInterval);
        } catch (Exception unused) {
        }
    }

    public void startPushing() {
        ExecutorManager.runOnLogSessioniserThread(new h(this, 2));
    }

    public void stopLogSessioniserOnTerminate() {
        ExecutorManager.runOnLogSessioniserThread(new h(this, 3));
    }
}
