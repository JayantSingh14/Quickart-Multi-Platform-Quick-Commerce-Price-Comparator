package in.juspay.hypersdk.safe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.support.v4.media.b;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import in.juspay.airborne.services.FileProviderService;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.utils.Utils;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JuspayWebViewClient extends WebViewClient {
    private static final String LOG_TAG = "in.juspay.hypersdk.safe.JuspayWebViewClient";

    @Nullable
    private WebViewClient delegate;

    @NonNull
    private final Godel godelManager;

    @NonNull
    private final JuspayWebView juspayWebView;

    @Nullable
    public String latestStartUrl;

    public JuspayWebViewClient(@NonNull Godel godel, @NonNull JuspayWebView juspayWebView) {
        this.godelManager = godel;
        this.juspayWebView = juspayWebView;
        if (godel.getJuspayServices().getHyperCallback() != null) {
            this.delegate = godel.getJuspayServices().getHyperCallback().createJuspaySafeWebViewClient();
        }
    }

    private JSONArray getIntentUris() {
        return Utils.optJSONArray(this.godelManager.getJuspayServices().getSdkConfigService().getSdkConfig(), "intentURIs");
    }

    private void insertACS() throws JSONException {
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        FileProviderService fileProviderService = juspayServices.getFileProviderService();
        PaymentSessionInfo paymentSessionInfo = this.godelManager.getPaymentSessionInfo();
        if (paymentSessionInfo.isGodelEnabled()) {
            this.godelManager.getDuiInterface().setSessionAttribute(PaymentConstants.Category.CONFIG, this.godelManager.getConfig().toString());
            this.juspayWebView.addJsToWebView("window.juspayContext = {}; juspayContext['web_lab_rules'] = " + this.godelManager.getConfig().getJSONObject("weblab"));
        }
        if (!paymentSessionInfo.isGodelEnabled()) {
            juspayServices.sdkDebug(LOG_TAG, "disabling_insertion_of_java_script_since_jb_is_disabled");
            return;
        }
        String fromFile = fileProviderService.readFromFile(PaymentConstants.ACS);
        this.juspayWebView.addJsToWebView(fromFile);
        juspayServices.sdkDebug(LOG_TAG, "Tracking weblab rules in acs");
        this.juspayWebView.addJsToWebView("__juspay.trackWebLabRules();");
        if (paymentSessionInfo.getAcsJsHash() == null) {
            paymentSessionInfo.setAcsJsHash(EncryptionHelper.md5(fromFile));
            juspayServices.getSdkTracker().trackAction("system", "info", Labels.System.JUSPAY_WEBVIEW_CLIENT, "hash_of_inserted_acs_min_script", paymentSessionInfo.getAcsJsHash());
        }
    }

    private boolean openIntentFromGodel(String str) throws JSONException {
        JSONArray intentUris = getIntentUris();
        for (int i2 = 0; i2 < intentUris.length(); i2++) {
            try {
                if (str.startsWith(intentUris.getString(i2))) {
                    this.godelManager.getJuspayServices().getSdkTracker().trackAction("system", "info", Labels.System.JUSPAY_WEBVIEW_CLIENT, "intent_uri", str);
                    this.godelManager.getJuspayServices().startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), -1, null);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    this.godelManager.getAcsInterface().invoke("openIntentFromGodel", jSONObject.toString());
                    return true;
                }
            } catch (Exception e2) {
                this.godelManager.getJuspayServices().getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception in shouldOverrideUrlLoading", e2);
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi
    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onPageFinished(WebView webView, String str) throws JSONException {
        super.onPageFinished(webView, str);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        try {
            if (this.godelManager.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("title", webView.getTitle());
                this.godelManager.getAcsInterface().invoke("onPageFinished", jSONObject.toString());
            }
            CookieSyncManager.getInstance().sync();
            insertACS();
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onPageFinished event", e2);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) throws JSONException {
        super.onPageStarted(webView, str, bitmap);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        Godel godel = this.godelManager;
        godel.isRupaySupportedAdded = false;
        if (godel.isDuiLoaded()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
            } catch (JSONException e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onPageStarted event", e2);
            }
            this.godelManager.getAcsInterface().invoke("onPageStarted", jSONObject.toString());
        }
        this.latestStartUrl = str;
        juspayServices.getSessionInfo().set("currentUrl", str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
        try {
            List<String> allowedDeeplinkPackages = this.godelManager.getAllowedDeeplinkPackages();
            if (allowedDeeplinkPackages.size() == 0) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            List<ResolveInfo> listQueryIntentActivities = this.godelManager.getContext().getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities == null) {
                return;
            }
            String str2 = null;
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                JuspayLogger.d(LOG_TAG, resolveInfo.activityInfo.packageName);
                if (str2 == null && allowedDeeplinkPackages.contains(resolveInfo.activityInfo.packageName)) {
                    str2 = resolveInfo.activityInfo.packageName;
                }
            }
            if (str2 == null && listQueryIntentActivities.size() > 1) {
                JuspayLogger.e(LOG_TAG, "Too many activities");
                return;
            }
            if (listQueryIntentActivities.size() != 0 && allowedDeeplinkPackages.contains(listQueryIntentActivities.get(0).activityInfo.packageName)) {
                intent.setPackage(str2);
                this.godelManager.getJuspayServices().startActivityForResult(intent, -1, null);
                this.godelManager.getJuspayServices().addJsToWebView("if (window.onDeepLinkUrlAppOpen != null) { window.onDeepLinkUrlAppOpen('{}'); }");
            }
        } catch (Exception e3) {
            sdkTracker.trackException(PaymentConstants.Category.GODEL, LogSubCategory.ApiCall.SDK, Labels.SDK.WEBVIEW_CLIENT, b.C("Exception when trying to launch deeplink activity for ", str), e3);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    @CallSuper
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) throws JSONException {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        try {
            if (this.godelManager.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", webView.getUrl());
                jSONObject.put("title", webView.getTitle());
                jSONObject.put("statusCode", webResourceError.getErrorCode());
                this.godelManager.getAcsInterface().invoke("onReceivedError", jSONObject.toString());
                insertACS();
                CookieSyncManager.getInstance().sync();
            }
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onReceivedError event", e2);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    @CallSuper
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, @Nullable String str2, String str3) {
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView != this.juspayWebView) {
            return true;
        }
        this.godelManager.getJuspayServices().getSdkTracker().trackLifecycle("system", "error", Labels.System.ON_RENDER_PROCESS_GONE, "error", "godel render process is gone");
        this.godelManager.getAcsInterface().invoke("onRenderProcessGone", JSONObject.NULL.toString());
        this.godelManager.getDuiInterface().onWebViewReleased();
        return true;
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi
    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i2, SafeBrowsingResponse safeBrowsingResponse) {
        super.onSafeBrowsingHit(webView, webResourceRequest, i2, safeBrowsingResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f2, float f3) {
        super.onScaleChanged(webView, f2, f3);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f2, f3);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        super.onTooManyRedirects(webView, message, message2);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) throws JSONException {
        WebResourceResponse webResourceResponseShouldInterceptRequest = this.godelManager.shouldInterceptRequest(webResourceRequest);
        WebViewClient webViewClient = this.delegate;
        return (webViewClient == null || webResourceResponseShouldInterceptRequest != null) ? webResourceResponseShouldInterceptRequest : webViewClient.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, str);
        }
        if (openIntentFromGodel(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) throws IOException {
        WebResourceResponse webResourceResponseShouldInterceptRequest = this.godelManager.shouldInterceptRequest(str);
        WebViewClient webViewClient = this.delegate;
        return (webViewClient == null || webResourceResponseShouldInterceptRequest != null) ? webResourceResponseShouldInterceptRequest : webViewClient.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        if (openIntentFromGodel(webResourceRequest.getUrl().toString())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) throws JSONException {
        super.onReceivedError(webView, i2, str, str2);
        JuspayServices juspayServices = this.godelManager.getJuspayServices();
        try {
            if (this.godelManager.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", webView.getUrl());
                jSONObject.put("title", webView.getTitle());
                jSONObject.put("statusCode", i2);
                this.godelManager.getAcsInterface().invoke("onReceivedError", jSONObject.toString());
                insertACS();
            }
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onReceivedError event", e2);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i2, str, str2);
        }
    }
}
