package in.juspay.hypersdk.core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.R;
import in.juspay.services.TenantParams;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PrefetchServices {
    private static final String LOG_TAG = "PrefetchServices";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preFetch$0() {
    }

    public static void preFetch(@NonNull Context context, @NonNull JSONObject jSONObject, @Nullable String str, @Nullable TenantParams tenantParams) throws JSONException {
        JuspayCoreLib.setApplicationContext(context.getApplicationContext());
        try {
            jSONObject.put("pre_fetch", "true");
            jSONObject.put("use_local_assets", jSONObject.optBoolean("useLocalAssets", context.getResources().getBoolean(R.bool.use_local_assets)));
            JuspayServices juspayServices = new JuspayServices(context, tenantParams, str, true);
            juspayServices.setBundleParameter(jSONObject);
            juspayServices.initiate(new com.amazon.android.amazonpay.api.c(2));
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.PREFETCH, "Exception happened in PREFETCH", e2);
        }
    }
}
