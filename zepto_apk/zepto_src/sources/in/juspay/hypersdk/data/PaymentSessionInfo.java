package in.juspay.hypersdk.data;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.constants.Labels;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.safe.Godel;
import in.juspay.hypersdk.utils.IntegrationUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PaymentSessionInfo {
    private static final String LOG_TAG = "PaymentSessionInfo";

    @Nullable
    private String acsJsHash;
    private boolean godelDisabled;

    @NonNull
    private final JuspayServices juspayServices;

    @Nullable
    private JSONObject paymentDetails;

    @NonNull
    private final SdkTracker sdkTracker;

    @NonNull
    private final SessionInfo sessionInfo;

    @NonNull
    private final JSONObject sessionDetails = new JSONObject();

    @NonNull
    private WeakReference<Godel> godelManager = new WeakReference<>(null);

    public PaymentSessionInfo(JuspayServices juspayServices) {
        this.juspayServices = juspayServices;
        this.sessionInfo = juspayServices.getSessionInfo();
        this.sdkTracker = juspayServices.getSdkTracker();
    }

    public static String getGodelRemotesVersion(Context context) {
        return context.getString(R.string.godel_remotes_version);
    }

    public void addToSessionDetails(String str, String str2) {
        try {
            this.sessionDetails.put(str, str2);
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.PAYMENT_SESSION_INFO, "Exception when adding to sessionDetails", e2);
        }
    }

    public void createSessionDataMap() {
        try {
            this.sessionInfo.createSessionDataMap();
            JSONObject sessionData = this.sessionInfo.getSessionData();
            sessionData.put(PaymentConstants.GODEL_VERSION, IntegrationUtils.getGodelVersion(this.juspayServices.getContext()));
            sessionData.put(PaymentConstants.GODEL_BUILD_VERSION, IntegrationUtils.getGodelBuildVersion(this.juspayServices.getContext()));
            sessionData.put("godel_remotes_version", getGodelRemotesVersion(this.juspayServices.getContext()));
            sessionData.put("is_godel", isGodelEnabled());
            this.sessionInfo.updateSessionData(sessionData);
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.PAYMENT_SESSION_INFO, "Exception while creatingSession Data Map", e2);
        }
    }

    @Nullable
    public String getAcsJsHash() {
        return this.acsJsHash;
    }

    public JSONObject getPaymentDetails() {
        JSONObject jSONObject = this.paymentDetails;
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    @NonNull
    public JSONObject getSessionDetails() {
        return this.sessionDetails;
    }

    public boolean isGodelEnabled() throws JSONException {
        Godel godel;
        if (this.godelDisabled || (godel = this.godelManager.get()) == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (godel.getConfig().has("weblab")) {
                jSONObject = godel.getConfig().getJSONObject("weblab");
            }
            if (jSONObject.has(PaymentConstants.GODEL)) {
                return Integer.parseInt(String.valueOf(jSONObject.get(PaymentConstants.GODEL))) != 0;
            }
            return true;
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.PAYMENT_SESSION_INFO, "Exception while retrieving Godel value", e2);
            return false;
        }
    }

    public void setAcsJsHash(@NonNull String str) {
        this.acsJsHash = str;
    }

    public void setGodelDisabled(String str) {
        this.godelDisabled = true;
        this.sdkTracker.trackAction("system", "info", Labels.System.PAYMENT_SESSION_INFO, "godel_switching_off", str);
    }

    public void setGodelManager(@Nullable Godel godel) {
        this.godelManager = new WeakReference<>(godel);
    }

    public void setPaymentDetails(String str, String str2) {
        try {
            if (this.paymentDetails == null) {
                this.paymentDetails = new JSONObject();
            }
            this.paymentDetails.put(str, str2);
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.PAYMENT_SESSION_INFO, "Exception while trying to set payment details", e2);
        }
    }

    public void setPaymentDetails(@NonNull JSONObject jSONObject) {
        this.paymentDetails = jSONObject;
    }
}
