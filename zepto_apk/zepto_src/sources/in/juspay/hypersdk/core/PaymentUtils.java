package in.juspay.hypersdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.safe.JuspayWebView;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class PaymentUtils extends Utils {
    private static final String LOG_TAG = "PaymentUtils";

    public static void clearCookies(JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            CookieSyncManager.createInstance(context).sync();
            CookieManager.getInstance().removeAllCookie();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Failed to clear cookies", e2);
        }
    }

    public static String getConfigVariableDeclarations(@NonNull Context context, SessionInfo sessionInfo, @NonNull String str) {
        String deviceId = sessionInfo.getDeviceId();
        String androidId = sessionInfo.getAndroidId();
        if (deviceId == null || deviceId.isEmpty()) {
            deviceId = "";
        }
        StringBuilder sb = new StringBuilder("var clientId = '");
        sb.append(sessionInfo.getClientId());
        sb.append("';var juspayDeviceId = '");
        sb.append(deviceId);
        sb.append("';var juspayAndroidId = '");
        sb.append(androidId);
        sb.append("';var godelRemotesVersion = '");
        sb.append(PaymentSessionInfo.getGodelRemotesVersion(context));
        sb.append("';var godelVersion = '");
        sb.append(IntegrationUtils.getGodelVersion(context));
        sb.append("';var buildVersion = '");
        sb.append(IntegrationUtils.getGodelBuildVersion(context));
        sb.append("';var os_version = '");
        sb.append(SessionInfo.getOSVersion());
        return android.support.v4.media.b.s(sb, "';var tenantId = '", str, "';");
    }

    public static ConnectivityReceiver getConnectivityReceiver(JuspayServices juspayServices) {
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            return new ConnectivityReceiver(juspayServices);
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Failed to register Connectivity receiver (Ignoring)", th);
            return null;
        }
    }

    public static boolean hasTelephonyService(JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Exception while trying to get telephony service. Returning false.", th);
            return false;
        }
    }

    public static boolean isClassAvailable(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void logMemoryInfo(SdkTracker sdkTracker, ActivityManager.MemoryInfo memoryInfo) {
        sdkTracker.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "available_memory", Long.valueOf(memoryInfo.availMem));
        sdkTracker.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "threshold_memory", Long.valueOf(memoryInfo.threshold));
        sdkTracker.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "total_memory", Long.valueOf(memoryInfo.totalMem));
    }

    public static void refreshPage(JuspayWebView juspayWebView) {
        if (juspayWebView != null) {
            juspayWebView.addJsToWebView("window.location.reload(true);");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[Catch: Exception -> 0x00a3, TryCatch #1 {Exception -> 0x00a3, blocks: (B:3:0x0004, B:17:0x0059, B:19:0x0062, B:20:0x0081, B:15:0x004a), top: B:25:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void switchOffGodelIfLowOnMemory(in.juspay.hypersdk.safe.Godel r11, in.juspay.hypersdk.core.JuspayServices r12, in.juspay.hypersdk.data.PaymentSessionInfo r13) {
        /*
            java.lang.String r1 = " MB"
            java.lang.String r2 = "low on memory - Available memory : "
            android.content.Context r0 = r12.getContext()     // Catch: java.lang.Exception -> La3
            in.juspay.hypersdk.core.SdkTracker r3 = r12.getSdkTracker()     // Catch: java.lang.Exception -> La3
            java.lang.String r12 = "activity"
            java.lang.Object r12 = r0.getSystemService(r12)     // Catch: java.lang.Exception -> La3
            android.app.ActivityManager r12 = (android.app.ActivityManager) r12     // Catch: java.lang.Exception -> La3
            android.app.ActivityManager$MemoryInfo r10 = new android.app.ActivityManager$MemoryInfo     // Catch: java.lang.Exception -> La3
            r10.<init>()     // Catch: java.lang.Exception -> La3
            r4 = 4
            org.json.JSONObject r11 = r11.getWebLabRules()     // Catch: java.lang.Exception -> L44
            if (r11 == 0) goto L48
            java.lang.String r0 = "shouldUseMemory"
            int r11 = r11.getInt(r0)     // Catch: java.lang.Exception -> L44
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "util"
            java.lang.String r7 = "weblab_shouldUseMemory"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L41
            r0.<init>()     // Catch: java.lang.Exception -> L41
            r0.append(r11)     // Catch: java.lang.Exception -> L41
            r0.append(r1)     // Catch: java.lang.Exception -> L41
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L41
            r3.trackAction(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L41
            goto L57
        L41:
            r0 = move-exception
            r9 = r0
            goto L4a
        L44:
            r0 = move-exception
            r9 = r0
            r11 = r4
            goto L4a
        L48:
            r11 = r4
            goto L57
        L4a:
            java.lang.String r4 = in.juspay.hypersdk.core.PaymentUtils.LOG_TAG     // Catch: java.lang.Exception -> La3
            java.lang.String r5 = "action"
            java.lang.String r6 = "system"
            java.lang.String r7 = "util"
            java.lang.String r8 = "Exception while fetching shouldUseMemory from config"
            r3.trackAndLogException(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> La3
        L57:
            if (r12 == 0) goto La3
            r12.getMemoryInfo(r10)     // Catch: java.lang.Exception -> La3
            int r12 = r12.getMemoryClass()     // Catch: java.lang.Exception -> La3
            if (r12 >= r11) goto L81
            java.lang.String r0 = "LOW_ON_MEMORY"
            r13.setGodelDisabled(r0)     // Catch: java.lang.Exception -> La3
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "util"
            java.lang.String r7 = "switching_godel_off"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La3
            r13.<init>(r2)     // Catch: java.lang.Exception -> La3
            r13.append(r12)     // Catch: java.lang.Exception -> La3
            r13.append(r1)     // Catch: java.lang.Exception -> La3
            java.lang.String r8 = r13.toString()     // Catch: java.lang.Exception -> La3
            r3.trackAction(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> La3
        L81:
            logMemoryInfo(r3, r10)     // Catch: java.lang.Exception -> La3
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "util"
            java.lang.String r7 = "switchoffgodeliflowonmemory"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La3
            r13.<init>()     // Catch: java.lang.Exception -> La3
            r13.append(r12)     // Catch: java.lang.Exception -> La3
            java.lang.String r12 = " MB <"
            r13.append(r12)     // Catch: java.lang.Exception -> La3
            r13.append(r11)     // Catch: java.lang.Exception -> La3
            java.lang.String r8 = r13.toString()     // Catch: java.lang.Exception -> La3
            r3.trackAction(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> La3
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.PaymentUtils.switchOffGodelIfLowOnMemory(in.juspay.hypersdk.safe.Godel, in.juspay.hypersdk.core.JuspayServices, in.juspay.hypersdk.data.PaymentSessionInfo):void");
    }

    @Keep
    public static String toJavascriptArray(@Nullable ArrayList<String> arrayList) {
        if (arrayList == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append("\"");
            sb.append(it.next());
            sb.append("\"");
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
