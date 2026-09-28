package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.reactnativecommunity.webview.RNCWebView;
import com.reactnativecommunity.webview.RNCWebViewModuleImpl;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class RNCWebViewClient extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public boolean f46270a = false;

    /* renamed from: b, reason: collision with root package name */
    public RNCWebView.ProgressChangedFilter f46271b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f46272c = null;

    /* renamed from: d, reason: collision with root package name */
    public RNCBasicAuthCredential f46273d = null;

    public final WritableMap a(WebView webView, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("target", RNCWebViewWrapper.a(webView));
        writableMapCreateMap.putString("url", str);
        writableMapCreateMap.putBoolean("loading", (this.f46270a || webView.getProgress() == 100) ? false : true);
        writableMapCreateMap.putString("title", webView.getTitle());
        writableMapCreateMap.putBoolean("canGoBack", webView.canGoBack());
        writableMapCreateMap.putBoolean("canGoForward", webView.canGoForward());
        return writableMapCreateMap;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        ((RNCWebView) webView).a(webView, new TopLoadingStartEvent(RNCWebViewWrapper.a(webView), a(webView, str)));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        String str2;
        super.onPageFinished(webView, str);
        if (this.f46270a) {
            return;
        }
        RNCWebView rNCWebView = (RNCWebView) webView;
        if (rNCWebView.getSettings().getJavaScriptEnabled() && (str2 = rNCWebView.f46244a) != null && !TextUtils.isEmpty(str2)) {
            rNCWebView.evaluateJavascript("(function() {\n" + rNCWebView.f46244a + ";\n})();", null);
        }
        int iA = RNCWebViewWrapper.a(webView);
        UIManagerHelper.b((ReactContext) webView.getContext(), iA).g(new TopLoadingFinishEvent(iA, a(webView, str)));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2;
        super.onPageStarted(webView, str, bitmap);
        this.f46270a = false;
        RNCWebView rNCWebView = (RNCWebView) webView;
        if (!rNCWebView.getSettings().getJavaScriptEnabled() || (str2 = rNCWebView.f46245b) == null || TextUtils.isEmpty(str2)) {
            return;
        }
        rNCWebView.evaluateJavascript("(function() {\n" + rNCWebView.f46245b + ";\n})();", null);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        String str3 = this.f46272c;
        if (str3 != null && str2.equals(str3) && i2 == -1 && str.equals("net::ERR_FAILED")) {
            this.f46272c = null;
            return;
        }
        super.onReceivedError(webView, i2, str, str2);
        this.f46270a = true;
        int iA = RNCWebViewWrapper.a(webView);
        UIManagerHelper.b((ReactContext) webView.getContext(), iA).g(new TopLoadingFinishEvent(iA, a(webView, str2)));
        WritableMap writableMapA = a(webView, str2);
        writableMapA.putDouble("code", i2);
        writableMapA.putString("description", str);
        int iA2 = RNCWebViewWrapper.a(webView);
        UIManagerHelper.b((ReactContext) webView.getContext(), iA2).g(new TopLoadingErrorEvent(iA2, writableMapA));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        RNCBasicAuthCredential rNCBasicAuthCredential = this.f46273d;
        if (rNCBasicAuthCredential != null) {
            httpAuthHandler.proceed(rNCBasicAuthCredential.f46228a, rNCBasicAuthCredential.f46229b);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            WritableMap writableMapA = a(webView, webResourceRequest.getUrl().toString());
            writableMapA.putInt("statusCode", webResourceResponse.getStatusCode());
            writableMapA.putString("description", webResourceResponse.getReasonPhrase());
            int iA = RNCWebViewWrapper.a(webView);
            UIManagerHelper.b((ReactContext) webView.getContext(), iA).g(new TopHttpErrorEvent(iA, writableMapA));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String url = webView.getUrl();
        String url2 = sslError.getUrl();
        sslErrorHandler.cancel();
        if (!url.equalsIgnoreCase(url2)) {
            b.A("Resource blocked from loading due to SSL error. Blocked URL: ", url2, "RNCWebViewClient");
        } else {
            int primaryError = sslError.getPrimaryError();
            onReceivedError(webView, primaryError, "SSL error: ".concat(primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid"), url2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        super.onRenderProcessGone(webView, renderProcessGoneDetail);
        if (renderProcessGoneDetail.didCrash()) {
            Log.e("RNCWebViewClient", "The WebView rendering process crashed.");
        } else {
            Log.w("RNCWebViewClient", "The WebView rendering process was killed by the system.");
        }
        if (webView == null) {
            return true;
        }
        WritableMap writableMapA = a(webView, webView.getUrl());
        writableMapA.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
        int iA = RNCWebViewWrapper.a(webView);
        UIManagerHelper.b((ReactContext) webView.getContext(), iA).g(new TopRenderProcessGoneEvent(iA, writableMapA));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Pair pair;
        RNCWebView rNCWebView = (RNCWebView) webView;
        if (((ReactContext) webView.getContext()).getJavaScriptContextHolder().get() == 0 || rNCWebView.f46250g == null) {
            FLog.q("RNCWebViewClient", "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load.");
            this.f46271b.f46267a = true;
            int iA = RNCWebViewWrapper.a(webView);
            UIManagerHelper.b((ReactContext) webView.getContext(), iA).g(new TopShouldStartLoadWithRequestEvent(iA, a(webView, str)));
            return true;
        }
        RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock = RNCWebViewModuleImpl.f46282g;
        synchronized (shouldOverrideUrlLoadingLock) {
            double d2 = shouldOverrideUrlLoadingLock.f46305a;
            shouldOverrideUrlLoadingLock.f46305a = 1.0d + d2;
            AtomicReference atomicReference = new AtomicReference(RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.f46307a);
            shouldOverrideUrlLoadingLock.f46306b.put(Double.valueOf(d2), atomicReference);
            pair = new Pair(Double.valueOf(d2), atomicReference);
        }
        Double d3 = (Double) pair.f2989a;
        double dDoubleValue = d3.doubleValue();
        AtomicReference atomicReference2 = (AtomicReference) pair.f2990b;
        WritableMap writableMapA = a(webView, str);
        writableMapA.putDouble("lockIdentifier", dDoubleValue);
        rNCWebView.b("onShouldStartLoadWithRequest", writableMapA);
        try {
            synchronized (atomicReference2) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                while (atomicReference2.get() == RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.f46307a) {
                    if (SystemClock.elapsedRealtime() - jElapsedRealtime > 250) {
                        FLog.q("RNCWebViewClient", "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading.");
                        RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock2 = RNCWebViewModuleImpl.f46282g;
                        synchronized (shouldOverrideUrlLoadingLock2) {
                            shouldOverrideUrlLoadingLock2.f46306b.remove(d3);
                        }
                        return false;
                    }
                    atomicReference2.wait(250L);
                }
                boolean z = atomicReference2.get() == RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.f46308b;
                RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock3 = RNCWebViewModuleImpl.f46282g;
                synchronized (shouldOverrideUrlLoadingLock3) {
                    shouldOverrideUrlLoadingLock3.f46306b.remove(d3);
                }
                return z;
            }
        } catch (InterruptedException e2) {
            FLog.h("RNCWebViewClient", "shouldOverrideUrlLoading was interrupted while waiting for result.", e2);
            RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock4 = RNCWebViewModuleImpl.f46282g;
            synchronized (shouldOverrideUrlLoadingLock4) {
                shouldOverrideUrlLoadingLock4.f46306b.remove(d3);
                return false;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
