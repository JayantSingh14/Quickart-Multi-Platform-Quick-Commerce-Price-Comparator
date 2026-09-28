package in.juspay.hypersdk.mystique;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes4.dex */
public class DUIWebViewClient extends WebViewClient {
    private WebClientCallback callback;

    public DUIWebViewClient(WebClientCallback webClientCallback) {
        this.callback = webClientCallback;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.callback.onRenderProcessGone(webView);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
