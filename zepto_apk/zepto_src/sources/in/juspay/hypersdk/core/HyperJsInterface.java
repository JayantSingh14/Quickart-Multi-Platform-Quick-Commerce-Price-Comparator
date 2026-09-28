package in.juspay.hypersdk.core;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class HyperJsInterface extends JsInterface {
    private static final String LOG_TAG = "HyperJsInterface";

    public HyperJsInterface(@NonNull JuspayServices juspayServices) {
        super(juspayServices);
    }

    @JavascriptInterface
    public String checkPermission(String[] strArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        for (String str : strArr) {
            try {
                jSONObject.put(str, Utils.checkIfGranted(this.juspayServices, str));
            } catch (JSONException e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Caught this exception while setting in JSON: ", e2);
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void downloadApps(String str) {
        JuspayLogger.e(LOG_TAG, "Method downloadApps() has empty body");
    }

    @JavascriptInterface
    public void exitApp(int i2, String str) {
    }

    @JavascriptInterface
    public void hideKeyboard() {
        JuspayLogger.e(LOG_TAG, "Method hideKeyboard() has empty body");
    }

    @JavascriptInterface
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        JuspayLogger.e(LOG_TAG, "Please override onRequestPermissionsResult");
    }

    @JavascriptInterface
    public void requestPermission(String[] strArr, String str) {
        this.juspayServices.requestPermission(strArr, Integer.parseInt(str));
    }

    @JavascriptInterface
    public void setClickFeedback(String str) {
        JuspayLogger.e(LOG_TAG, "Method setClickFeedback(String) has empty body");
    }
}
