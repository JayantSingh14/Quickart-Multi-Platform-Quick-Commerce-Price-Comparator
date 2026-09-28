package in.juspay.hypersdk.services;

import android.content.Context;
import androidx.annotation.NonNull;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SdkConfigService {
    private static final String sdkConfigLocation = "sdk_config.json";

    @NonNull
    private final JuspayServices juspayServices;

    @NonNull
    private JSONObject sdkConfig = new JSONObject();

    public SdkConfigService(@NonNull JuspayServices juspayServices) {
        this.juspayServices = juspayServices;
        renewConfig(juspayServices.getContext());
    }

    @NonNull
    public JSONObject getSdkConfig() {
        return this.sdkConfig;
    }

    public void renewConfig(@NonNull Context context) {
        try {
            String fromFile = this.juspayServices.getFileProviderService().readFromFile(sdkConfigLocation);
            if (fromFile.isEmpty()) {
                fromFile = "{}";
            }
            this.sdkConfig = new JSONObject(fromFile);
        } catch (JSONException e2) {
            this.juspayServices.getSdkTracker().trackException("lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, PaymentConstants.SDK_CONFIG, "Exception while parsing renewed sdk config", e2);
        }
    }
}
