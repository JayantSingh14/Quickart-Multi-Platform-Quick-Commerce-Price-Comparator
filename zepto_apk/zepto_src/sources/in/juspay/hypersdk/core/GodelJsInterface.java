package in.juspay.hypersdk.core;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import in.juspay.hyper.constants.Labels;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class GodelJsInterface {
    private static final String LOG_TAG = "GodelJsInterface";

    @NonNull
    private final JuspayServices juspayServices;

    public GodelJsInterface(@NonNull JuspayServices juspayServices) {
        this.juspayServices = juspayServices;
    }

    @JavascriptInterface
    public void sendMessage(String str) throws JSONException {
        if (this.juspayServices.getHyperCallback() == null) {
            return;
        }
        HyperPaymentsCallback hyperCallback = this.juspayServices.getHyperCallback();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "godel_merchant_message");
            jSONObject.put(PaymentConstants.PAYLOAD, str);
        } catch (JSONException e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "exception on godelJsInterface", e2);
        }
        hyperCallback.onEvent(jSONObject, null);
    }
}
