package in.juspay.hypersdk.ui;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import in.juspay.hypersdk.core.MerchantViewType;

/* loaded from: classes4.dex */
public abstract class HyperPaymentsCallbackAdapter implements HyperPaymentsCallback {
    @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
    @Nullable
    public WebViewClient createJuspaySafeWebViewClient() {
        return null;
    }

    @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
    @Nullable
    public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
        return null;
    }

    @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
    public void onStartWaitingDialogCreated(@Nullable View view) {
    }
}
