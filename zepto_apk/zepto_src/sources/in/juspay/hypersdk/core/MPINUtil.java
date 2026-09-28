package in.juspay.hypersdk.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.hyper.constants.Labels;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MPINUtil {
    private static final String TAG = "MPINUtil";

    @Nullable
    private static HashMap<String, MPINUtil> orchestrator;

    @NonNull
    private final ComponentName component;

    @Nullable
    private GodelServiceConnection connection;

    private MPINUtil(JuspayServices juspayServices, String str, String str2) {
        this.connection = new GodelServiceConnection(juspayServices);
        this.component = new ComponentName(str, str2);
    }

    private boolean bind(Context context) {
        Intent intent = new Intent();
        intent.setComponent(this.component);
        return context.bindService(intent, this.connection, 1);
    }

    public static void closeAllConnections(Context context) {
        HashMap<String, MPINUtil> map = orchestrator;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                closeConnection(it.next(), context);
            }
        }
        orchestrator = null;
    }

    public static void closeConnection(String str, Context context) {
        HashMap<String, MPINUtil> map = orchestrator;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        MPINUtil mPINUtil = orchestrator.get(str);
        if (mPINUtil != null) {
            mPINUtil.unbind(context);
        }
        orchestrator.remove(str);
    }

    public static void communicate(String str, String str2, int i2, Bundle bundle, @NonNull JuspayServices juspayServices, String str3) {
        MPINUtil mPINUtil;
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Attempting to communicate to " + str + "/" + str2);
            if (orchestrator == null) {
                orchestrator = new HashMap<>();
            }
            if (orchestrator.containsKey(str)) {
                sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Fetching existing instance from orchestrator");
                mPINUtil = orchestrator.get(str);
            } else {
                MPINUtil mPINUtil2 = new MPINUtil(juspayServices, str, str2);
                sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Creating new MPINUtil instance in orchestrator");
                if (!mPINUtil2.bind(juspayServices.getContext())) {
                    sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Failed to bind to MPIN SDK. Reporting Bind Failure back to mApp");
                    reportBindFailure(i2, juspayServices, str3);
                    return;
                } else {
                    orchestrator.put(str, mPINUtil2);
                    mPINUtil = mPINUtil2;
                }
            }
            if (mPINUtil != null && mPINUtil.connection != null) {
                sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Requesting a connection with MPIN SDK");
                mPINUtil.connection.request(i2, bundle, new GodelServiceResponseHandler(str3, juspayServices));
                return;
            }
            sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", (mPINUtil == null ? "mpinUtil" : "mpinUtil.connection").concat(" is null. Reporting Bind Failure back to mApp"));
            reportBindFailure(i2, juspayServices, str3);
        } catch (Exception e2) {
            sdkTracker.trackAction("system", "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Failed to bind to MPIN SDK. Reporting Bind Failure back to mApp");
            sdkTracker.trackAndLogException(TAG, "action", "system", Labels.System.MPIN_UTIL, "Exception while trying to connect", e2);
            reportBindFailure(i2, juspayServices, str3);
        }
    }

    public static void reportBindFailure(int i2, @NonNull JuspayServices juspayServices, String str) {
        if (str != null) {
            SdkTracker sdkTracker = juspayServices.getSdkTracker();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", i2);
                jSONObject.put("error", true);
                jSONObject.put(APayConstants.Error.MESSAGE, "BIND_FAILURE");
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(TAG, "action", "system", Labels.System.MPIN_UTIL, "Exception while creating bind failure response", e2);
            }
            juspayServices.getJBridge().invokeCallbackInDUIWebview(str, jSONObject.toString());
        }
    }

    private void unbind(Context context) {
        GodelServiceConnection godelServiceConnection = this.connection;
        if (godelServiceConnection == null || !godelServiceConnection.isBound) {
            return;
        }
        try {
            context.unbindService(godelServiceConnection);
        } catch (Exception unused) {
        }
        this.connection = null;
    }
}
