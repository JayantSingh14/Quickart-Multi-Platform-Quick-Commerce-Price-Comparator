package in.juspay.hypersdk.core;

import android.app.ActivityManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersmshandler.Tracker;
import in.juspay.hyperutil.constants.LogLevel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class SdkTracker implements TrackerInterface, Tracker {
    private static final String LOG_TAG = "SdkTracker";
    private static final int MAX_LOG_SIZE = 22528;
    private static final Queue<JSONObject> bootLogs = new ConcurrentLinkedQueue();

    @NonNull
    private String godelBuildVersion;

    @NonNull
    private String godelVersion;

    @NonNull
    private String hyperSdkVersion;

    @NonNull
    private final JuspayServices juspayServices;
    private AtomicInteger serialNumberCounter = new AtomicInteger(1);
    private final JSONObject logProperties = new JSONObject();
    private final HashSet<String> labelsToDrop = new HashSet<>();

    public SdkTracker(@NonNull JuspayServices juspayServices) {
        this.hyperSdkVersion = "";
        this.godelVersion = "";
        this.godelBuildVersion = "";
        this.juspayServices = juspayServices;
        try {
            this.hyperSdkVersion = IntegrationUtils.getSdkVersion(juspayServices.getContext());
            this.godelVersion = IntegrationUtils.getGodelVersion(juspayServices.getContext());
            this.godelBuildVersion = IntegrationUtils.getGodelBuildVersion(juspayServices.getContext());
        } catch (Exception unused) {
        }
        ExecutorManager.runOnSdkTrackerPool(new com.amazon.android.amazonpay.api.c(3));
    }

    public static void addToBootLogs(String str) {
        ExecutorManager.runOnSdkTrackerPool(new v(str, 2));
    }

    @NonNull
    private static JSONObject cloneJSON(@NonNull JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            jSONArrayNames = new JSONArray();
        }
        JSONObject jSONObject2 = new JSONObject();
        for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
            String str = (String) jSONArrayNames.opt(i2);
            Object objOpt = jSONObject.opt(str);
            if (objOpt instanceof JSONObject) {
                jSONObject2.put(str, cloneJSON((JSONObject) objOpt));
            } else if (objOpt instanceof JSONArray) {
                jSONObject2.put(str, cloneJSONArray((JSONArray) objOpt));
            } else {
                jSONObject2.put(str, objOpt);
            }
        }
        return jSONObject2;
    }

    @NonNull
    private static JSONArray cloneJSONArray(@NonNull JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object objOpt = jSONArray.opt(i2);
            if (objOpt instanceof JSONObject) {
                jSONArray2.put(cloneJSON((JSONObject) objOpt));
            } else if (objOpt instanceof JSONArray) {
                jSONArray2.put(cloneJSONArray((JSONArray) objOpt));
            } else {
                jSONArray2.put(objOpt);
            }
        }
        return jSONArray2;
    }

    private static Object cloneObject(Object obj) {
        try {
            return obj instanceof JSONObject ? cloneJSON((JSONObject) obj) : obj instanceof JSONArray ? cloneJSONArray((JSONArray) obj) : obj;
        } catch (Exception unused) {
            return obj;
        }
    }

    @NonNull
    private JSONObject createApiExceptionLog(String str, String str2, String str3, Long l2, Long l3, Object obj, String str4, String str5, String str6, Throwable th, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayNames;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("url", str4);
            jSONObject3.put("start_time", l2);
            jSONObject3.put("end_time", l3);
            jSONObject3.put(PaymentConstants.PAYLOAD, obj == null ? JSONObject.NULL : cloneObject(obj));
            jSONObject3.put("method", str5);
            jSONObject3.put(APayConstants.Error.MESSAGE, str6 + ". " + th.getLocalizedMessage());
            jSONObject3.put("stacktrace", formatThrowable(th));
            jSONObject2.put("category", str);
            jSONObject2.put("subcategory", str2);
            jSONObject2.put("level", LogLevel.EXCEPTION);
            jSONObject2.put("label", str3 + Attributes.PREDEFINED_ATTRIBUTE_PREFIX + Utils.getLogLevelFromThrowable(th));
            jSONObject2.put(CLConstants.FIELD_PAY_INFO_VALUE, jSONObject3);
            jSONObject2.put("at", System.currentTimeMillis());
            jSONObject2.put(PaymentConstants.SERVICE, "sdk");
            jSONObject2.put("channels", jSONArray);
            if (jSONObject != null && (jSONArrayNames = jSONObject.names()) != null) {
                for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                    String string = jSONArrayNames.getString(i2);
                    jSONObject2.put(string, jSONObject.getString(string));
                }
            }
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding API exception log: ", e2);
        }
        return jSONObject2;
    }

    @NonNull
    private static JSONObject createApiLog(String str, String str2, String str3, @Nullable Integer num, String str4, Long l2, Long l3, Object obj, Object obj2, String str5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str4);
            jSONObject2.put("status_code", num);
            jSONObject2.put("start_time", l2);
            jSONObject2.put("end_time", l3);
            jSONObject2.put(PaymentConstants.PAYLOAD, obj == null ? JSONObject.NULL : cloneObject(obj));
            jSONObject2.put("response", cloneObject(obj2));
            jSONObject2.put("method", str5);
            jSONObject.put("category", LogCategory.API_CALL);
            jSONObject.put("subcategory", str);
            jSONObject.put("level", str2);
            jSONObject.put("label", str3);
            jSONObject.put(CLConstants.FIELD_PAY_INFO_VALUE, jSONObject2);
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.SERVICE, "sdk");
            return jSONObject;
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
            return jSONObject;
        }
    }

    @NonNull
    private static JSONObject createExceptionLog(String str, String str2, String str3, @Nullable String str4, @NonNull Throwable th, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(APayConstants.Error.MESSAGE, str4 + ". " + th.getLocalizedMessage());
            if (z) {
                jSONObject2.put("stacktrace", formatThrowable(th));
            } else {
                jSONObject2.put("stacktrace", Log.getStackTraceString(th));
            }
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put("level", LogLevel.EXCEPTION);
            jSONObject.put("label", str3 + Attributes.PREDEFINED_ATTRIBUTE_PREFIX + Utils.getLogLevelFromThrowable(th));
            jSONObject.put(CLConstants.FIELD_PAY_INFO_VALUE, jSONObject2);
            jSONObject.put(PaymentConstants.SERVICE, "sdk");
            jSONObject.put("at", System.currentTimeMillis());
            return jSONObject;
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding log: ", e2);
            return jSONObject;
        }
    }

    private static JSONObject createLog(String str, String str2, String str3, String str4, String str5, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(str5, obj == null ? JSONObject.NULL : cloneObject(obj));
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put("level", str3);
            jSONObject.put("label", str4);
            jSONObject.put(CLConstants.FIELD_PAY_INFO_VALUE, jSONObject2);
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.SERVICE, "sdk");
            return jSONObject;
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
            return jSONObject;
        }
    }

    @NonNull
    private static JSONObject createLogWithValue(String str, String str2, String str3, String str4, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put("level", str3);
            jSONObject.put("label", str4);
            jSONObject.put(CLConstants.FIELD_PAY_INFO_VALUE, cloneObject(obj));
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.SERVICE, "sdk");
            return jSONObject;
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
            return jSONObject;
        }
    }

    @NonNull
    private static String formatThrowable(Throwable th) {
        StringBuilder sb = new StringBuilder(getStackTraceAsString(th));
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            sb.append("\nCaused by ");
            sb.append(getStackTraceAsString(cause));
        }
        return sb.toString();
    }

    @NonNull
    private static String getStackTraceAsString(@NonNull Throwable th) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                return "e.getStackTrace returned null in SdkTracker.getStackTraceAsString";
            }
            StringBuilder sb = new StringBuilder(th.toString());
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append("\n\tat ");
                sb.append(stackTraceElement.toString());
            }
            return sb.toString();
        } catch (Exception e2) {
            return "Couldn't fetch stacktrace as there is an exception in getStackTraceAsString " + e2.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogToPersistedQueue$14(JSONObject jSONObject) {
        try {
            this.juspayServices.getLogManager().addLogsToPersistedQueue(jSONObject);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "addLogToPersistedQueue failed", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addToBootLogs$1(String str) throws JSONException {
        JuspayLogger.log(LOG_TAG, "DEBUG", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("at")) {
                jSONObject.put("at", System.currentTimeMillis());
            }
            bootLogs.add(jSONObject);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "addToBootLogs", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0() {
        ExecutorManager.setTrackerThreadId(Thread.currentThread().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEndPointSandbox$18(Boolean bool) {
        this.juspayServices.getLogManager().setEndPointSandbox(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$track$17(JSONObject jSONObject) throws JSONException {
        try {
            if (shouldDropLog(jSONObject.optString("label", ""))) {
                return;
            }
            jSONObject.put("at", System.currentTimeMillis());
            trackParsed(jSONObject);
        } catch (JSONException e2) {
            trackException("action", "system", Labels.System.LOG_PUSHER, "Exception while parsing the JSON", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackAction$8(String str, String str2, String str3, String str4, Object obj) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateLog = createLog("action", str2, str3, str, str4, obj);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateLog);
        } else {
            trackParsed(jSONObjectCreateLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackAndLogApiException$16(String str, String str2, Throwable th, String str3, String str4, String str5, Long l2, Long l3, Object obj, String str6, String str7, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        JuspayLogger.e(str, str2, th);
        if (shouldDropLog(str3)) {
            return;
        }
        trackPhoneState();
        JSONObject jSONObjectCreateApiExceptionLog = createApiExceptionLog(str4, str5, str3, l2, l3, obj, str6, str7, str2, th, jSONArray, jSONObject);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateApiExceptionLog);
        } else {
            trackParsed(jSONObjectCreateApiExceptionLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$trackAndLogBootException$5(String str, String str2, Throwable th, String str3, String str4, String str5) throws JSONException {
        JuspayLogger.e(str, str2, th);
        bootLogs.add(createExceptionLog(str3, str4, str5, str2, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackAndLogException$15(String str, String str2, String str3, Throwable th, String str4, String str5) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JuspayLogger.e(str2, str3, th);
        trackPhoneState();
        JSONObject jSONObjectCreateExceptionLog = createExceptionLog(str4, str5, str, str3, th);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateExceptionLog);
        } else {
            trackParsed(jSONObjectCreateExceptionLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackApiCalls$10(String str, String str2, String str3, Integer num, String str4, String str5, long j2, Long l2, Object obj, Object obj2, String str6, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectCreateApiLog = createApiLog(str, str2, str3, num, str4, str5, Long.valueOf(j2), l2, obj, obj2, str6, jSONArray, jSONObject);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateApiLog);
        } else {
            trackParsed(jSONObjectCreateApiLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackApiCalls$9(String str, String str2, String str3, Integer num, String str4, Long l2, Long l3, Object obj, Object obj2, String str5) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateApiLog = createApiLog(str2, str3, str, num, str4, l2, l3, obj, obj2, str5);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateApiLog);
        } else {
            trackParsed(jSONObjectCreateApiLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$trackBootAction$3(String str, String str2, String str3, String str4, Object obj) throws JSONException {
        bootLogs.add(createLog("action", str, str2, str3, str4, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$trackBootException$4(String str, String str2, String str3, String str4, Throwable th) throws JSONException {
        bootLogs.add(createExceptionLog(str, str2, str3, str4, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$trackBootLifecycle$2(String str, String str2, String str3, String str4, Object obj) throws JSONException {
        bootLogs.add(createLog("lifecycle", str, str2, str3, str4, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackContext$11(String str, String str2, String str3, String str4, Object obj) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateLog = createLog(LogCategory.CONTEXT, str2, str3, str, str4, obj);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateLog);
        } else {
            trackParsed(jSONObjectCreateLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackContext$12(String str, String str2, String str3, Object obj) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateLogWithValue = createLogWithValue(LogCategory.CONTEXT, str2, str3, str, obj);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateLogWithValue);
        } else {
            trackParsed(jSONObjectCreateLogWithValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackException$13(String str, String str2, String str3, String str4, Throwable th) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateExceptionLog = createExceptionLog(str2, str3, str, str4, th);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateExceptionLog);
        } else {
            trackParsed(jSONObjectCreateExceptionLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackLifecycle$6(String str, String str2, String str3, String str4, Object obj) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateLog = createLog("lifecycle", str2, str3, str, str4, obj);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateLog);
        } else {
            trackParsed(jSONObjectCreateLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trackLifecycle$7(String str, String str2, String str3, JSONObject jSONObject) throws JSONException {
        if (shouldDropLog(str)) {
            return;
        }
        JSONObject jSONObjectCreateLogWithValue = createLogWithValue("lifecycle", str2, str3, str, jSONObject);
        if (this.juspayServices.getSessionInfo() == null || this.juspayServices.getSessionInfo().getSessionId() == null) {
            bootLogs.add(jSONObjectCreateLogWithValue);
        } else {
            trackParsed(jSONObjectCreateLogWithValue);
        }
    }

    private void processBootLogs() {
        while (true) {
            Queue<JSONObject> queue = bootLogs;
            if (queue.isEmpty()) {
                return;
            }
            JSONObject jSONObjectPoll = queue.poll();
            if (jSONObjectPoll != null) {
                try {
                    if (!shouldDropLog(jSONObjectPoll.optString("label", ""))) {
                        signLog(jSONObjectPoll);
                        this.juspayServices.getLogManager().addLogLine(this.juspayServices.getSessionInfo().getSessionId(), jSONObjectPoll);
                    }
                } catch (Exception e2) {
                    trackException("action", "system", Labels.System.LOG_PUSHER, "Exception while signing log line", e2);
                }
            }
        }
    }

    private boolean shouldDropLog(String str) {
        return this.labelsToDrop.contains(str);
    }

    private void signLog(@NonNull JSONObject jSONObject) throws JSONException {
        SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
        if (!jSONObject.has("session_id")) {
            jSONObject.put("session_id", sessionInfo.getSessionId());
        }
        String clientId = sessionInfo.getClientId();
        if (!jSONObject.has(PaymentConstants.CLIENT_ID) && !clientId.isEmpty()) {
            String[] strArrSplit = clientId.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX, 2);
            if (strArrSplit.length > 0) {
                jSONObject.put(PaymentConstants.CLIENT_ID, strArrSplit[0].toLowerCase(Locale.getDefault()));
            }
        }
        String merchantId = sessionInfo.getMerchantId();
        if (!merchantId.isEmpty() && !jSONObject.has(PaymentConstants.MERCHANT_ID)) {
            jSONObject.put(PaymentConstants.MERCHANT_ID, merchantId);
        }
        String orderId = sessionInfo.getOrderId();
        if (!orderId.isEmpty() && !jSONObject.has(PaymentConstants.ORDER_ID)) {
            jSONObject.put(PaymentConstants.ORDER_ID, orderId);
        }
        if (!jSONObject.has("package_name")) {
            jSONObject.put("package_name", sessionInfo.getPackageName());
        }
        if (!jSONObject.has("log_version")) {
            jSONObject.put("log_version", PaymentConstants.LOG_VERSION);
        }
        jSONObject.put("sn", this.serialNumberCounter.getAndIncrement());
        if (!jSONObject.has("hyper_sdk_version")) {
            jSONObject.put("hyper_sdk_version", this.hyperSdkVersion);
        }
        if (!jSONObject.has(PaymentConstants.GODEL_VERSION)) {
            jSONObject.put(PaymentConstants.GODEL_VERSION, this.godelVersion);
        }
        if (!jSONObject.has(PaymentConstants.GODEL_BUILD_VERSION)) {
            jSONObject.put(PaymentConstants.GODEL_BUILD_VERSION, this.godelBuildVersion);
        }
        Iterator<String> itKeys = this.logProperties.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, this.logProperties.optString(next));
        }
    }

    public static void trackAndLogBootException(String str, String str2, String str3, String str4, @Nullable String str5, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new com.amazon.android.apay.commonlibrary.instrumentationlib.logger.a(str, str5, str2, str3, str4, 2, th));
    }

    public static void trackBootAction(String str, String str2, String str3, @Nullable String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new q0(str, str2, str3, str4, obj, 1));
    }

    public static void trackBootException(String str, String str2, String str3, @Nullable String str4, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new b(str, str2, str3, str4, th));
    }

    public static void trackBootLifecycle(String str, String str2, String str3, @Nullable String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new q0(str, str2, str3, str4, obj, 0));
    }

    private void trackParsed(JSONObject jSONObject) {
        try {
            if (!this.juspayServices.getLogManager().logConfig.shouldPush) {
                bootLogs.clear();
                return;
            }
            truncateLog(jSONObject);
            signLog(jSONObject);
            this.juspayServices.getLogManager().addLogLine(this.juspayServices.getSessionInfo().getSessionId(), jSONObject);
            processBootLogs();
        } catch (Exception e2) {
            trackException("action", "system", Labels.System.LOG_PUSHER, "Exception while signing log line", e2);
        }
    }

    private void trackPhoneState() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
            ActivityManager.MemoryInfo memoryInfo = Utils.getMemoryInfo(this.juspayServices.getContext());
            if (memoryInfo != null) {
                jSONObject.put("available_memory", memoryInfo.availMem);
                jSONObject.put("threshold_memory", memoryInfo.threshold);
                jSONObject.put("total_memory", memoryInfo.totalMem);
            }
            jSONObject.put("network_info", sessionInfo.getNetworkInfo());
            jSONObject.put("network_type", String.valueOf(sessionInfo.getNetworkType()));
            jSONObject.put("ip_address", Utils.getIPAddress(this.juspayServices));
            trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.PHONE_STATE, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void truncateLog(@NonNull JSONObject jSONObject) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() > MAX_LOG_SIZE) {
                    jSONObject.put(next, str.substring(0, MAX_LOG_SIZE));
                }
            } else if (obj instanceof JSONObject) {
                truncateLog((JSONObject) obj);
            }
        }
    }

    public void addLogProperties(JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObject2 = this.juspayServices.getLogManager().logConfig.logProperties;
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject2.getString(next);
                int iIndexOf = string.indexOf(36);
                int iIndexOf2 = string.indexOf(WKSRecord.Service.NTP);
                int iLastIndexOf = string.lastIndexOf(WKSRecord.Service.LOCUS_MAP);
                if (iIndexOf != -1 && iIndexOf2 != -1 && iLastIndexOf != -1 && iIndexOf2 - iIndexOf == 1 && iIndexOf2 < iLastIndexOf) {
                    String strSubstring = string.substring(iIndexOf2 + 1, iLastIndexOf);
                    if (jSONObject.has(strSubstring)) {
                        this.logProperties.put(next, string.replace("${" + strSubstring + "}", jSONObject.optString(strSubstring)));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // in.juspay.hyper.core.TrackerInterface
    public void addLogToPersistedQueue(@NonNull JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new o0(this, jSONObject, 0));
    }

    @NonNull
    public JSONObject getExceptionLog(String str, String str2, String str3, String str4, Throwable th) throws JSONException {
        JSONObject jSONObjectCreateExceptionLog = createExceptionLog(str, str2, str3, str4, th, true);
        try {
            signLog(jSONObjectCreateExceptionLog);
            return jSONObjectCreateExceptionLog;
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "getExceptionLog failed", e2);
            return jSONObjectCreateExceptionLog;
        }
    }

    public void resetSerialNumber() {
        this.serialNumberCounter = new AtomicInteger(1);
    }

    public void setEndPointSandbox(Boolean bool) {
        ExecutorManager.runOnLogSessioniserThread(new l(11, this, bool));
    }

    public void setLabelsToDrop(JSONObject jSONObject) throws JSONException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("labelsToDrop");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.labelsToDrop.add(jSONArray.getString(i2));
            }
        } catch (Exception unused) {
        }
    }

    @Override // in.juspay.hyper.core.TrackerInterface
    public void track(@NonNull JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new o0(this, jSONObject, 1));
    }

    @Override // in.juspay.hyper.core.TrackerInterface, in.juspay.hypersmshandler.Tracker
    public void trackAction(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @NonNull Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new n0(this, str3, str, str2, str4, obj, 1));
    }

    public void trackAndLogApiException(final String str, final String str2, final String str3, final String str4, final Long l2, final Long l3, final Object obj, final String str5, final String str6, final String str7, final Throwable th, final JSONArray jSONArray, final JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new Runnable() { // from class: in.juspay.hypersdk.core.t0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f48685a.lambda$trackAndLogApiException$16(str, str7, th, str4, str2, str3, l2, l3, obj, str5, str6, jSONArray, jSONObject);
            }
        });
    }

    @Override // in.juspay.hyper.core.TrackerInterface, in.juspay.hypersmshandler.Tracker
    public void trackAndLogException(@NonNull final String str, @NonNull final String str2, @NonNull final String str3, @NonNull final String str4, @NonNull final String str5, @NonNull final Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new Runnable() { // from class: in.juspay.hypersdk.core.p0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f48639a.lambda$trackAndLogException$15(str4, str, str5, th, str2, str3);
            }
        });
    }

    @Override // in.juspay.hyper.core.TrackerInterface
    public void trackApiCalls(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Integer num, @Nullable String str4, @Nullable Long l2, @Nullable Long l3, @Nullable Object obj, @Nullable Object obj2, String str5) {
        ExecutorManager.runOnSdkTrackerPool(new r0(this, str3, str, str2, num, str4, l2, l3, obj, obj2, str5));
    }

    public void trackContext(String str, String str2, String str3, @Nullable String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new n0(this, str3, str, str2, str4, obj, 2));
    }

    public void trackException(String str, String str2, String str3, String str4, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new com.amazon.android.apay.commonlibrary.instrumentationlib.logger.a(this, str3, str, str2, str4, th));
    }

    @Override // in.juspay.hyper.core.TrackerInterface
    public void trackLifecycle(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new n0(this, str3, str, str2, str4, obj, 0));
    }

    public void trackApiCalls(final String str, final String str2, final String str3, @Nullable final Integer num, final String str4, final String str5, final long j2, final Long l2, final Object obj, final Object obj2, final String str6, final JSONArray jSONArray, final JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new Runnable() { // from class: in.juspay.hypersdk.core.s0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f48671a.lambda$trackApiCalls$10(str, str2, str3, num, str4, str5, j2, l2, obj, obj2, str6, jSONArray, jSONObject);
            }
        });
    }

    public void trackContext(String str, String str2, String str3, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new b(this, str3, str, str2, obj, 4));
    }

    public void trackLifecycle(String str, String str2, String str3, JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new b(this, str3, str, str2, jSONObject, 3));
    }

    @NonNull
    private static JSONObject createExceptionLog(String str, String str2, String str3, @Nullable String str4, Throwable th) throws JSONException {
        return createExceptionLog(str, str2, str3, str4, th, false);
    }

    @NonNull
    private static JSONObject createApiLog(String str, String str2, String str3, @Nullable Integer num, String str4, String str5, Long l2, Long l3, Object obj, Object obj2, String str6, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayNames;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("url", str4);
            jSONObject3.put("status_code", num);
            jSONObject3.put("start_time", l2);
            jSONObject3.put("end_time", l3);
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject3.put(PaymentConstants.PAYLOAD, obj);
            jSONObject3.put("response", obj2);
            jSONObject3.put("method", str6);
            if (str5 != null) {
                jSONObject3.put("api_tag", str5);
            }
            jSONObject2.put("category", LogCategory.API_CALL);
            jSONObject2.put("subcategory", str);
            jSONObject2.put("level", str2);
            jSONObject2.put("label", str3);
            jSONObject2.put("channels", jSONArray);
            jSONObject2.put(CLConstants.FIELD_PAY_INFO_VALUE, jSONObject3);
            jSONObject2.put("at", System.currentTimeMillis());
            jSONObject2.put(PaymentConstants.SERVICE, "sdk");
            if (jSONObject != null && (jSONArrayNames = jSONObject.names()) != null) {
                for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                    String string = jSONArrayNames.getString(i2);
                    jSONObject2.put(string, jSONObject.getString(string));
                }
            }
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
        }
        return jSONObject2;
    }
}
