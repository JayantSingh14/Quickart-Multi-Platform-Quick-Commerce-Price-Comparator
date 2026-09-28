package in.juspay.hypersdk.core;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import in.juspay.airborne.services.FileProviderService;
import in.juspay.airborne.services.RemoteAssetService;
import in.juspay.airborne.services.Workspace;
import in.juspay.airborne.utils.OTAUtils;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.analytics.LogManager;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.utils.Utils;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsInterface {
    private static final String LOG_TAG = "JsInterface";

    @NonNull
    private final Context context;

    @NonNull
    private final FileProviderService fileProviderService;

    @NonNull
    protected final JuspayServices juspayServices;

    @NonNull
    private final LogManager logManager;

    @NonNull
    private final LogSessioniser logSessioniser;

    @NonNull
    private final RemoteAssetService remoteAssetService;
    private final SdkTracker sdkTracker;

    @NonNull
    private final SessionInfo sessionInfo;

    @NonNull
    protected final Workspace workspace;

    public JsInterface(@NonNull JuspayServices juspayServices) {
        this.context = juspayServices.getContext();
        this.juspayServices = juspayServices;
        this.workspace = juspayServices.getWorkspace();
        LogManager logManager = juspayServices.getLogManager();
        this.logManager = logManager;
        this.logSessioniser = logManager.logSessioniser;
        this.sessionInfo = juspayServices.getSessionInfo();
        this.sdkTracker = juspayServices.getSdkTracker();
        this.remoteAssetService = juspayServices.getRemoteAssetService();
        this.fileProviderService = juspayServices.getFileProviderService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogProperties$0(String str) {
        try {
            this.sdkTracker.addLogProperties(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestPendingLogs$2(String str, String str2) {
        this.juspayServices.getJBridge().invokeCallbackInDUIWebview(str2, (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) ? this.logSessioniser.getLogsFromSessionId(new JSONObject(str)) : "{}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAnalyticsHeader$1(JSONObject jSONObject, String str) {
        this.juspayServices.getLogManager().setHeaders(jSONObject, str);
    }

    @JavascriptInterface
    public boolean addChannel(String str, String str2) {
        return this.logManager.addChannel(str, str2);
    }

    @JavascriptInterface
    public boolean addChannelExp(String str, String str2) {
        return this.logManager.addChannelExp(str, str2);
    }

    @JavascriptInterface
    public void addLogProperties(String str) {
        ExecutorManager.runOnSdkTrackerPool(new l(5, this, str));
    }

    @JavascriptInterface
    public void addToLogList(String str) {
        if (this.sessionInfo.getSessionId() == null) {
            SdkTracker.addToBootLogs(str);
            return;
        }
        try {
            this.sdkTracker.track(new JSONObject(str));
        } catch (JSONException e2) {
            this.sdkTracker.trackException("action", "system", Labels.System.LOG_PUSHER, "Exception while parsing the JSON", e2);
        }
    }

    @JavascriptInterface
    public boolean checkIfVPNConnected() {
        return Utils.checkIfVPNConnected(this.context);
    }

    @JavascriptInterface
    public String getChannelNames() {
        return Arrays.toString(this.logManager.getChannelNames());
    }

    @JavascriptInterface
    public String getChannelNamesExp() {
        return Arrays.toString(this.logManager.getChannelNamesExp());
    }

    @JavascriptInterface
    public String getFileDownloadTimes() {
        return this.remoteAssetService.getFileDownloadTimes().toString();
    }

    @JavascriptInterface
    public String getFilePath(String str) {
        return this.fileProviderService.getHyperFileUtil().appendSdkNameAndVersion(str);
    }

    @JavascriptInterface
    public String getFromSharedPrefs(String str) {
        return this.workspace.getFromSharedPreference(str, "__failed");
    }

    @JavascriptInterface
    public String getLogList() {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.getLogList() method. It will be removed in future.");
        return "[]";
    }

    @JavascriptInterface
    public String getMd5(String str) {
        return OTAUtils.md5(str.getBytes());
    }

    @JavascriptInterface
    public String getResourceById(int i2) {
        return this.context.getResources().getString(i2);
    }

    @JavascriptInterface
    public String getResourceByName(String str) {
        return getResourceById(this.context.getResources().getIdentifier(str, "string", this.context.getPackageName()));
    }

    @JavascriptInterface
    public String getRootFragmentSize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.juspayServices.getContainer() != null) {
            try {
                try {
                    jSONObject.put(Snapshot.HEIGHT, String.valueOf(this.juspayServices.getContainer().getHeight()));
                    jSONObject.put(Snapshot.WIDTH, String.valueOf(this.juspayServices.getContainer().getWidth()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } catch (JSONException unused) {
                jSONObject.put(Snapshot.HEIGHT, this.sessionInfo.getScreenHeight() != null ? this.sessionInfo.getScreenHeight() : "");
                jSONObject.put(Snapshot.WIDTH, this.sessionInfo.getScreenWidth() != null ? this.sessionInfo.getScreenWidth() : "");
            }
        } else {
            try {
                jSONObject.put(Snapshot.HEIGHT, this.sessionInfo.getScreenHeight() != null ? this.sessionInfo.getScreenHeight() : "");
                jSONObject.put(Snapshot.WIDTH, this.sessionInfo.getScreenWidth() != null ? this.sessionInfo.getScreenWidth() : "");
            } catch (JSONException unused2) {
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getSessionAttribute(String str, String str2) {
        return this.sessionInfo.get(str, str2);
    }

    @JavascriptInterface
    public String getSessionId() {
        return this.sessionInfo.getSessionId();
    }

    @JavascriptInterface
    public String getSessionInfo() {
        this.sessionInfo.createSessionDataMap();
        return this.sessionInfo.toString();
    }

    @JavascriptInterface
    public String getWorkspaceRoot() {
        return this.juspayServices.getWorkspace().getRoot().toString();
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return this.fileProviderService.isFilePresent(this.context, str);
    }

    @JavascriptInterface
    public boolean isNetworkAvailable() {
        return this.sessionInfo.isNetworkAvailable();
    }

    @JavascriptInterface
    public String loadFileInDUI(String str, int i2) {
        return this.fileProviderService.readFromFile(str);
    }

    @JavascriptInterface
    public void postLogs(String str, String str2) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.postLogs() method. It will be removed in future.");
    }

    @JavascriptInterface
    public void removeAttribute(String str) {
        this.sessionInfo.removeAttribute(str);
    }

    @JavascriptInterface
    public void removeDataFromSharedPrefs(String str) {
        this.workspace.removeFromSharedPreference(str);
    }

    @JavascriptInterface
    public void removeFromSharedPrefs(String str) {
        this.workspace.removeFromSharedPreference(str);
    }

    @JavascriptInterface
    public void renewFile(String str) {
        renewFile(str, null, null);
    }

    @JavascriptInterface
    public void renewSdkConfig() {
        this.juspayServices.getSdkConfigService().renewConfig(this.context);
    }

    @JavascriptInterface
    public String requestPendingLogs(String str) {
        try {
            return (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) ? this.logSessioniser.getLogsFromSessionId(new JSONObject(str)) : "{}";
        } catch (JSONException unused) {
            return "{}";
        }
    }

    @JavascriptInterface
    public void sessioniseLogs(String str) {
        try {
            if (!Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") && !Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                return;
            }
            this.logSessioniser.sessioniseLogs(new JSONObject(str));
        } catch (JSONException e2) {
            this.sdkTracker.trackException("action", "system", Labels.System.JBRIDGE, android.support.v4.media.b.C("Logs request has invalid format", str), e2);
        }
    }

    @JavascriptInterface
    public void setAnalyticsEndPoint(String str) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.setAnalyticsEndPoint() method. It will be removed in future.");
    }

    @JavascriptInterface
    public boolean setAnalyticsHeader(String str) {
        return setAnalyticsHeader(str, LogConstants.DEFAULT_CHANNEL);
    }

    @JavascriptInterface
    public void setInSharedPrefs(String str, String str2) {
        this.workspace.writeToSharedPreference(str, str2);
    }

    @JavascriptInterface
    public void setSessionAttribute(String str, String str2) throws JSONException {
        this.sessionInfo.set(str, str2);
    }

    @JavascriptInterface
    public void setSessionId(String str) {
        JuspayLogger.d(LOG_TAG, "JBridge.setSessionId() is intended for changing the Session ID of the SDK. Not to be called by each micro-app");
        JuspayLogger.d(LOG_TAG, "Attempted Session ID: " + str);
    }

    @JavascriptInterface
    public void startPushingLogs() {
        this.logManager.startPushExp();
    }

    @JavascriptInterface
    public void submitAllLogs() {
    }

    @JavascriptInterface
    public void toast(String str) {
        Toast.makeText(this.context, str, 1).show();
    }

    @JavascriptInterface
    public void updateLogList(String str) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.updateLogList() method. It will be removed in future.");
    }

    @JavascriptInterface
    public String loadFileInDUI(String str) {
        return this.fileProviderService.readFromFile(str);
    }

    @JavascriptInterface
    public void renewFile(String str, String str2) {
        renewFile(str, str2, null);
    }

    @JavascriptInterface
    public boolean setAnalyticsHeader(String str, String str2) {
        try {
            ExecutorManager.runOnLogPusherThread(new r(this, new JSONObject(str), str2, 5));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void renewFile(String str, String str2, String str3) {
        this.remoteAssetService.renewFile(this.context, str, str2, System.currentTimeMillis(), this.juspayServices.getJBridge().fileDownloadCallback(str3));
    }

    @JavascriptInterface
    public void requestPendingLogs(String str, String str2) {
        ExecutorManager.runOnLogsPool(new r(this, str, (Object) str2, 4));
    }
}
