package androidx.webkit.internal;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

@RequiresApi
/* loaded from: classes3.dex */
public class WebViewRenderProcessClientFrameworkAdapter extends WebViewRenderProcessClient {
    public final void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = WebViewRenderProcessImpl.f12466b;
        if (((WebViewRenderProcessImpl) weakHashMap.get(webViewRenderProcess)) == null) {
            WebViewRenderProcessImpl webViewRenderProcessImpl = new WebViewRenderProcessImpl();
            new WeakReference(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, webViewRenderProcessImpl);
        }
        throw null;
    }

    public final void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = WebViewRenderProcessImpl.f12466b;
        if (((WebViewRenderProcessImpl) weakHashMap.get(webViewRenderProcess)) == null) {
            WebViewRenderProcessImpl webViewRenderProcessImpl = new WebViewRenderProcessImpl();
            new WeakReference(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, webViewRenderProcessImpl);
        }
        throw null;
    }
}
