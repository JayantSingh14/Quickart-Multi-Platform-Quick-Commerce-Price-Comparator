package in.juspay.hypersdk.ui;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public interface HyperPaymentsCallback {
    @Nullable
    WebViewClient createJuspaySafeWebViewClient();

    @Nullable
    View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType);

    void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler);

    void onStartWaitingDialogCreated(@Nullable View view);
}
