package in.juspay.hypersdk.analytics;

import androidx.annotation.NonNull;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class LogSessioniser {

    @NonNull
    private final LogConfig logConfig;

    @NonNull
    private final LogPusher logPusher;
    private TimerTask moveToPusher;

    @NonNull
    private final Workspace workspace;
    private JSONObject logs = new JSONObject();
    private JSONObject rawLogs = new JSONObject();
    private final ArrayList<String> activeRequestIDs = new ArrayList<>();
    private int timerModulus = 0;
    private Timer moveToPusherTimer = new Timer();
    private boolean stopPushingLogs = false;
    private boolean timerStopped = false;

    public class LogSessioniserTimerTask extends TimerTask {
        private LogSessioniserTimerTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (LogSessioniser.this.logConfig.shouldPush && LogUtils.isMinMemoryAvailable(LogSessioniser.this.logConfig).booleanValue()) {
                boolean z = LogSessioniser.this.timerModulus == 1;
                LogSessioniser.this.deleteOldFileIfNecessary(LogConstants.LOGS_READING_FILE, LogConstants.LOGS_WRITING_FILE, LogConstants.LOGS_FILE, ".dat");
                LogSessioniser.this.deleteOldFileIfNecessary(LogConstants.TEMP_LOGS_READING_FILE, LogConstants.TEMP_LOGS_WRITING_FILE, LogConstants.TEMP_LOGS_FILE, ".dat");
                if (z) {
                    LogSessioniser.this.activeRequestIDs.clear();
                    LogSessioniser logSessioniser = LogSessioniser.this;
                    logSessioniser.pushLogsFromJsonToPusher(logSessioniser.logs);
                    LogSessioniser.this.clearAllLogFiles(LogConstants.TEMP_LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, LogSessioniser.this.workspace), LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, LogSessioniser.this.workspace));
                    LogSessioniser.this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                    LogSessioniser.this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
                }
                if (z) {
                    LogSessioniser logSessioniser2 = LogSessioniser.this;
                    logSessioniser2.logs = logSessioniser2.rawLogs;
                    LogSessioniser.this.rawLogs = new JSONObject();
                } else {
                    LogSessioniser.this.clearAllLogFiles(LogConstants.LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE, LogSessioniser.this.workspace), LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE, LogSessioniser.this.workspace));
                    LogSessioniser.this.workspace.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                    LogSessioniser.this.workspace.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
                    try {
                        LogSessioniser logSessioniser3 = LogSessioniser.this;
                        logSessioniser3.pushJsonToFile(logSessioniser3.rawLogs, LogConstants.LOGS_FILE, ".dat", LogConstants.LOGS_WRITING_FILE, 0);
                    } catch (Exception unused) {
                    }
                }
                if (z) {
                    int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, LogSessioniser.this.workspace);
                    int i2 = fromSharedPreference == -1 ? 0 : fromSharedPreference;
                    try {
                        LogSessioniser logSessioniser4 = LogSessioniser.this;
                        logSessioniser4.pushJsonToFile(logSessioniser4.logs, LogConstants.TEMP_LOGS_FILE, ".dat", LogConstants.TEMP_LOGS_WRITING_FILE, i2);
                    } catch (Exception unused2) {
                    }
                }
                if (LogSessioniser.this.logs.length() == 0 && LogSessioniser.this.rawLogs.length() == 0) {
                    LogSessioniser.this.moveToPusherTimer.cancel();
                    LogSessioniser.this.timerStopped = true;
                }
                LogSessioniser.access$104(LogSessioniser.this);
                LogSessioniser.access$144(LogSessioniser.this, 5);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ExecutorManager.runOnLogsPool(new g(this, 0));
        }
    }

    public LogSessioniser(@NonNull Workspace workspace, @NonNull LogConfig logConfig, @NonNull LogPusher logPusher) {
        this.workspace = workspace;
        this.logConfig = logConfig;
        this.logPusher = logPusher;
    }

    public static /* synthetic */ int access$104(LogSessioniser logSessioniser) {
        int i2 = logSessioniser.timerModulus + 1;
        logSessioniser.timerModulus = i2;
        return i2;
    }

    public static /* synthetic */ int access$144(LogSessioniser logSessioniser, int i2) {
        int i3 = logSessioniser.timerModulus % i2;
        logSessioniser.timerModulus = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllLogFiles(String str, String str2, int i2, int i3) {
        while (i2 <= i3) {
            try {
                File fileOpenInCache = this.workspace.openInCache(str + i2 + str2);
                if (fileOpenInCache != null) {
                    fileOpenInCache.delete();
                }
            } catch (Exception unused) {
            }
            i2++;
        }
    }

    private static String constructErrorMessage(String str, String str2) {
        return android.support.v4.media.b.m("{\"requestId\":\"", str2, "\",\"error\":true,\"logs\":{},\"errorMessage\":\"", str, "\"}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOldFileIfNecessary(String str, String str2, String str3, String str4) {
        int fromSharedPreference = LogUtils.getFromSharedPreference(str, this.workspace);
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(str2, this.workspace);
        if (JuspayCoreLib.getApplicationContext() == null || (fromSharedPreference2 - fromSharedPreference) + 1 <= this.logConfig.maxFilesAllowed) {
            return;
        }
        while ((fromSharedPreference2 - fromSharedPreference) + 1 > this.logConfig.numFilesToLeaveIfMaxFilesExceeded) {
            File fileOpenInCache = this.workspace.openInCache(str3 + fromSharedPreference + str4);
            if (fileOpenInCache != null) {
                try {
                    fileOpenInCache.delete();
                } catch (Exception unused) {
                }
            }
            fromSharedPreference++;
        }
        this.workspace.writeToSharedPreference(str, String.valueOf(fromSharedPreference));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogLine$4(JSONObject jSONObject, String str) throws JSONException {
        try {
            if (jSONObject.getJSONObject(CLConstants.FIELD_PAY_INFO_VALUE).toString().getBytes().length > this.logConfig.maxLogValueSize) {
                jSONObject.put(CLConstants.FIELD_PAY_INFO_VALUE, "Filtered");
                JuspayLogger.i("LogSessioniser", "Filtering the value of log as the size of value is greater than 32 KB");
            }
            startLogSessioniserOnLogCount();
            if (this.rawLogs.has(str)) {
                this.rawLogs.accumulate(str, jSONObject);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.rawLogs.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pushLogsToPusher$2() {
        try {
            if (pushLogsFromJsonToPusher(this.logs)) {
                this.logs = new JSONObject();
                clearAllLogFiles(LogConstants.TEMP_LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, this.workspace), LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, this.workspace));
                this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
            }
            if (pushLogsFromJsonToPusher(this.rawLogs)) {
                this.rawLogs = new JSONObject();
                clearAllLogFiles(LogConstants.LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE, this.workspace), LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE, this.workspace));
                this.workspace.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                this.workspace.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sessioniseLogs$5(JSONObject jSONObject) throws JSONException {
        try {
            String string = jSONObject.getString("sessionId");
            String string2 = jSONObject.getString("requestId");
            JSONArray jSONArray = jSONObject.getJSONArray("logs");
            if (!this.activeRequestIDs.contains(string2) || jSONArray.toString().getBytes().length > this.logConfig.maxLogLineSize) {
                return;
            }
            startLogSessioniserOnLogCount();
            this.logs.put(string, jSONArray);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startLogSessioniser$0() {
        try {
            this.stopPushingLogs = false;
            this.moveToPusherTimer = new Timer();
            LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
            this.moveToPusher = logSessioniserTimerTask;
            this.moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0L, this.logConfig.logSessioniseInterval);
            this.timerStopped = false;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startLogSessioniserOnLogCount$1() {
        try {
            if (this.timerStopped) {
                this.moveToPusherTimer = new Timer();
                LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
                this.moveToPusher = logSessioniserTimerTask;
                this.moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0L, this.logConfig.logSessioniseInterval);
                this.timerStopped = false;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopLogSessioniserOnTerminate$3() {
        try {
            this.moveToPusherTimer.cancel();
            pushLogsToPusher();
            this.timerStopped = true;
            this.stopPushingLogs = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushJsonToFile(JSONObject jSONObject, String str, String str2, String str3, int i2) throws JSONException, IOException {
        boolean z;
        Iterator<String> itKeys = jSONObject.keys();
        Workspace workspace = this.workspace;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i3 = i2;
        sb.append(i3);
        sb.append(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(workspace.openInCache(sb.toString()), true);
        while (itKeys.hasNext()) {
            JSONArray jSONArray = jSONObject.getJSONArray(itKeys.next());
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                byte[] bytes = (jSONArray.getJSONObject(i4).toString() + LogConstants.LOG_DELIMITER).getBytes(StandardCharsets.UTF_8);
                long length = (long) bytes.length;
                long length2 = this.workspace.openInCache(str + i3 + str2).length() + length;
                LogConfig logConfig = this.logConfig;
                if (length2 <= logConfig.maxLogFileSize) {
                    fileOutputStream.write(bytes);
                } else {
                    if (length <= logConfig.maxLogLineSize) {
                        i3++;
                        this.workspace.writeToSharedPreference(str3, String.valueOf(i3));
                        z = true;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.workspace.openInCache(str + i3 + str2), true);
                        fileOutputStream2.write(bytes);
                        fileOutputStream = fileOutputStream2;
                    }
                }
                z = true;
            }
        }
        fileOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pushLogsFromJsonToPusher(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                this.logPusher.addLogLines(jSONObject.getJSONArray(itKeys.next()));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void startLogSessioniserOnLogCount() {
        ExecutorManager.runOnLogsPool(new f(this, 2));
    }

    public void addLogLine(String str, JSONObject jSONObject) {
        if (this.stopPushingLogs || !this.logConfig.shouldPush) {
            return;
        }
        ExecutorManager.runOnLogsPool(new androidx.media3.common.util.e(this, jSONObject, str, 21));
    }

    public void clearBacklog() {
        int i2;
        int i3;
        String str;
        if (this.logConfig.shouldPush) {
            ExecutorManager.setLogsThreadId(Thread.currentThread().getId());
            int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE, this.workspace);
            int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE, this.workspace);
            int i4 = 0;
            if (fromSharedPreference == -1) {
                this.workspace.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
                fromSharedPreference = 0;
            }
            if (fromSharedPreference2 == -1) {
                this.workspace.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                fromSharedPreference2 = 0;
            }
            int fromSharedPreference3 = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, this.workspace);
            int fromSharedPreference4 = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, this.workspace);
            if (fromSharedPreference3 == -1) {
                this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
                fromSharedPreference3 = 0;
            }
            if (fromSharedPreference4 == -1) {
                this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                fromSharedPreference4 = 0;
            }
            deleteOldFileIfNecessary(LogConstants.LOGS_READING_FILE, LogConstants.LOGS_WRITING_FILE, LogConstants.LOGS_FILE, ".dat");
            deleteOldFileIfNecessary(LogConstants.TEMP_LOGS_READING_FILE, LogConstants.TEMP_LOGS_WRITING_FILE, LogConstants.TEMP_LOGS_FILE, ".dat");
            while (fromSharedPreference4 <= fromSharedPreference3) {
                try {
                    str = LogConstants.TEMP_LOGS_FILE + fromSharedPreference4 + ".dat";
                } catch (Exception unused) {
                }
                if (JuspayCoreLib.getApplicationContext() != null) {
                    File file = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str);
                    i2 = i4;
                    i3 = fromSharedPreference3;
                    try {
                        if (file.length() <= this.logConfig.maxLogFileSize && file.exists() && LogUtils.isFileEligibleToPush(file, this.logConfig)) {
                            this.logPusher.addLogsFromSessioniser(LogUtils.getLogsFromFile(file));
                        }
                        file.delete();
                    } catch (Exception unused2) {
                    }
                } else {
                    i2 = i4;
                    i3 = fromSharedPreference3;
                }
                fromSharedPreference4++;
                i4 = i2;
                fromSharedPreference3 = i3;
            }
            int i5 = i4;
            this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(i5));
            this.workspace.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(i5));
            while (fromSharedPreference2 <= fromSharedPreference) {
                try {
                    String str2 = LogConstants.LOGS_FILE + fromSharedPreference2 + ".dat";
                    if (JuspayCoreLib.getApplicationContext() != null) {
                        File file2 = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str2);
                        if (file2.length() <= this.logConfig.maxLogFileSize && file2.exists() && LogUtils.isFileEligibleToPush(file2, this.logConfig)) {
                            this.logPusher.addLogsFromSessioniser(LogUtils.getLogsFromFile(file2));
                        }
                        file2.delete();
                    }
                } catch (Exception unused3) {
                }
                fromSharedPreference2++;
            }
            this.workspace.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(i5));
            this.workspace.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(i5));
        }
    }

    public String getLogsFromSessionId(JSONObject jSONObject) throws JSONException {
        String string;
        String string2;
        if (jSONObject == null) {
            return constructErrorMessage("Request Invalid", "");
        }
        try {
            string2 = jSONObject.getString("requestId");
            try {
                string = jSONObject.getString("sessionId");
                try {
                    this.activeRequestIDs.add(string2);
                    JSONArray jSONArrayOptJSONArray = this.logs.optJSONArray(string);
                    return jSONArrayOptJSONArray != null ? new JSONObject().put("requestId", string2).put("error", false).put("logs", jSONArrayOptJSONArray).toString() : constructErrorMessage("No logs saved to file", string2);
                } catch (JSONException unused) {
                    return constructErrorMessage(string2.equals("") ? "RequestId not sent" : string.equals("") ? "SessionId not sent" : "Request invalid", string2);
                }
            } catch (JSONException unused2) {
                string = "";
            }
        } catch (JSONException unused3) {
            string = "";
            string2 = string;
        }
    }

    public void pushLogsToPusher() {
        ExecutorManager.runOnLogsPool(new f(this, 0));
    }

    public void sessioniseLogs(JSONObject jSONObject) {
        if (this.stopPushingLogs || !this.logConfig.shouldPush) {
            return;
        }
        ExecutorManager.runOnLogsPool(new in.juspay.hypernfc.b(8, this, jSONObject));
    }

    public void startLogSessioniser() {
        ExecutorManager.runOnLogsPool(new f(this, 3));
    }

    public void stopLogSessioniserOnTerminate() {
        ExecutorManager.runOnLogsPool(new f(this, 1));
    }
}
