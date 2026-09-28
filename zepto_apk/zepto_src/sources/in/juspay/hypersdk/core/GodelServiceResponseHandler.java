package in.juspay.hypersdk.core;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import in.juspay.hyper.constants.Labels;
import in.juspay.hypersdk.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class GodelServiceResponseHandler extends Handler {
    private static final String TAG = "GodelServiceResponseHandler";
    private String callBackFnName;

    @NonNull
    private final JuspayServices juspayServices;

    public GodelServiceResponseHandler(String str, @NonNull JuspayServices juspayServices) {
        this.callBackFnName = str;
        this.juspayServices = juspayServices;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException {
        if (this.callBackFnName != null) {
            SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
            try {
                JSONObject json = Utils.toJSON(message.getData());
                json.put("code", message.what);
                sdkTracker.trackAction("system", "info", Labels.System.GODEL_SERVICE_RESPONSE_HANDLER, "gsrh_handle_message", "Got response from the MPIN SDK: " + json.toString(2));
                sdkTracker.trackAction("system", "info", Labels.System.GODEL_SERVICE_RESPONSE_HANDLER, "gsrh_handle_message", "Sending response back to micro-app");
                this.juspayServices.getJBridge().invokeCallbackInDUIWebview(this.callBackFnName, json.toString());
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(TAG, "action", "system", Labels.System.MPIN_UTIL, "Exception while trying to handle message", e2);
            }
        }
        this.callBackFnName = null;
    }
}
