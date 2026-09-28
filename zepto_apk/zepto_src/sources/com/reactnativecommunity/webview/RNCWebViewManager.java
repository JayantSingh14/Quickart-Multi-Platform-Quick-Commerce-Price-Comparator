package com.reactnativecommunity.webview;

import android.os.Build;
import android.support.v4.media.b;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.RNCWebView;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RNCWebViewManager extends ViewGroupManager<RNCWebViewWrapper> {
    private final RNCWebViewManagerImpl mRNCWebViewManagerImpl = new RNCWebViewManagerImpl();

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        this.mRNCWebViewManagerImpl.getClass();
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("goBack", 1);
        builderA.b("goForward", 2);
        builderA.b("reload", 3);
        builderA.b("stopLoading", 4);
        builderA.b("postMessage", 5);
        builderA.b("injectJavaScript", 6);
        builderA.b("loadUrl", 7);
        builderA.b("requestFocus", 8);
        builderA.b("clearFormData", 1000);
        builderA.b("clearCache", Integer.valueOf(DateUtils.SEMI_MONTH));
        builderA.b("clearHistory", 1002);
        return builderA.a();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingStart", MapBuilder.c("registrationName", "onLoadingStart"));
        exportedCustomDirectEventTypeConstants.put("topLoadingFinish", MapBuilder.c("registrationName", "onLoadingFinish"));
        exportedCustomDirectEventTypeConstants.put("topLoadingError", MapBuilder.c("registrationName", "onLoadingError"));
        exportedCustomDirectEventTypeConstants.put("topMessage", MapBuilder.c("registrationName", "onMessage"));
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", MapBuilder.c("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", MapBuilder.c("registrationName", "onShouldStartLoadWithRequest"));
        ScrollEventType scrollEventType = ScrollEventType.f20086d;
        ScrollEventType.f20083a.getClass();
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.Companion.a(scrollEventType), MapBuilder.c("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put("topHttpError", MapBuilder.c("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put("topRenderProcessGone", MapBuilder.c("registrationName", "onRenderProcessGone"));
        exportedCustomDirectEventTypeConstants.put("topCustomMenuSelection", MapBuilder.c("registrationName", "onCustomMenuSelection"));
        exportedCustomDirectEventTypeConstants.put("topOpenWindow", MapBuilder.c("registrationName", "onOpenWindow"));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCWebView";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowFileAccess(z);
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(RNCWebViewWrapper viewWrapper, boolean z) {
        RNCWebViewManagerImpl rNCWebViewManagerImpl = this.mRNCWebViewManagerImpl;
        rNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        rNCWebViewManagerImpl.f46274a = z;
        rNCWebViewManagerImpl.c(webView);
    }

    @ReactProp(name = "allowsProtectedMedia")
    public void setAllowsProtectedMedia(RNCWebViewWrapper viewWrapper, boolean z) {
        WebChromeClient webChromeClient;
        RNCWebViewManagerImpl rNCWebViewManagerImpl = this.mRNCWebViewManagerImpl;
        rNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        rNCWebViewManagerImpl.f46275b = z;
        if (Build.VERSION.SDK_INT < 26 || (webChromeClient = webView.getWebChromeClient()) == null || !(webChromeClient instanceof RNCWebChromeClient)) {
            return;
        }
        ((RNCWebChromeClient) webChromeClient).f46240k = z;
    }

    @ReactProp(name = "androidLayerType")
    public void setAndroidLayerType(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setLayerType(Intrinsics.b(str, "hardware") ? 2 : Intrinsics.b(str, "software") ? 1 : 0, null);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        RNCWebViewManagerImpl rNCWebViewManagerImpl = this.mRNCWebViewManagerImpl;
        rNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        if (str != null) {
            rNCWebViewManagerImpl.f46280g = b.l(WebSettings.getDefaultUserAgent(viewWrapper.getWebView().getContext()), StringUtils.SPACE, str);
        } else {
            rNCWebViewManagerImpl.f46280g = null;
        }
        rNCWebViewManagerImpl.b(viewWrapper);
    }

    @ReactProp(name = "basicAuthCredential")
    public void setBasicAuthCredential(RNCWebViewWrapper viewWrapper, @Nullable ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setBasicAuthCredential((readableMap != null && readableMap.hasKey("username") && readableMap.hasKey("password")) ? new RNCBasicAuthCredential(readableMap.getString("username"), readableMap.getString("password")) : null);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setCacheMode(z ? -1 : 2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @ReactProp(name = "cacheMode")
    public void setCacheMode(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        WebSettings settings = viewWrapper.getWebView().getSettings();
        int i2 = -1;
        if (str != null) {
            switch (str.hashCode()) {
                case -2059164003:
                    if (str.equals("LOAD_NO_CACHE")) {
                        i2 = 2;
                        break;
                    }
                    break;
                case -1215135800:
                    str.equals("LOAD_DEFAULT");
                    break;
                case -873877826:
                    if (str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1548620642:
                    if (str.equals("LOAD_CACHE_ONLY")) {
                        i2 = 3;
                        break;
                    }
                    break;
            }
        }
        settings.setCacheMode(i2);
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setDomStorageEnabled(z);
    }

    @ReactProp(name = "downloadingMessage")
    public void setDownloadingMessage(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.f46276c = str;
    }

    @ReactProp(name = "forceDarkOn")
    public void setForceDarkOn(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (Build.VERSION.SDK_INT > 28) {
            if (WebViewFeature.a("FORCE_DARK")) {
                WebSettingsCompat.a(webView.getSettings(), z ? 2 : 0);
            }
            if (z && WebViewFeature.a("FORCE_DARK_STRATEGY")) {
                WebSettingsCompat.b(webView.getSettings());
            }
        }
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setGeolocationEnabled(z);
    }

    @ReactProp(name = "hasOnOpenWindowEvent")
    public void setHasOnOpenWindowEvent(RNCWebViewWrapper viewWrapper, boolean z) {
        RNCWebViewManagerImpl rNCWebViewManagerImpl = this.mRNCWebViewManagerImpl;
        rNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        rNCWebViewManagerImpl.f46278e = z;
        rNCWebViewManagerImpl.c(webView);
    }

    @ReactProp(name = "hasOnScroll")
    public void setHasOnScroll(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setHasScrollEvent(z);
    }

    @ReactProp(name = "incognito")
    public void setIncognito(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (z) {
            CookieManager.getInstance().removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().f46244a = str;
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().f46245b = str;
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getClass();
    }

    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getClass();
    }

    @ReactProp(name = "injectedJavaScriptObject")
    public void setInjectedJavaScriptObject(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setInjectedJavaScriptObject(str);
    }

    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setJavaScriptEnabled(z);
    }

    @ReactProp(name = "lackPermissionToDownloadMessage")
    public void setLackPermissionToDownloadMessage(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.f46277d = str;
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @ReactProp(name = "menuItems")
    public void setMenuCustomItems(RNCWebViewWrapper viewWrapper, @Nullable ReadableArray value) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        Intrinsics.checkNotNullParameter(value, "value");
        RNCWebView webView = viewWrapper.getWebView();
        ArrayList<Object> arrayList = value.toArrayList();
        Intrinsics.d(arrayList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>");
        webView.setMenuCustomItems(arrayList);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setMessagingEnabled(z);
    }

    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().f46248e = str;
    }

    @ReactProp(name = "minimumFontSize")
    public void setMinimumFontSize(RNCWebViewWrapper viewWrapper, int i2) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setMinimumFontSize(i2);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (str == null || "never".equals(str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if ("always".equals(str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if ("compatibility".equals(str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().f46254k = z;
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        int i2 = 0;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode == -1414557169) {
                str.equals("always");
            } else if (iHashCode != 104712844) {
                if (iHashCode == 951530617 && str.equals("content")) {
                    i2 = 1;
                }
            } else if (str.equals("never")) {
                i2 = 2;
            }
        }
        webView.setOverScrollMode(i2);
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setSaveFormData(!z);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    @ReactProp(name = "setBuiltInZoomControls")
    public void setSetBuiltInZoomControls(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setBuiltInZoomControls(z);
    }

    @ReactProp(name = "setDisplayZoomControls")
    public void setSetDisplayZoomControls(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setDisplayZoomControls(z);
    }

    @ReactProp(name = "setSupportMultipleWindows")
    public void setSetSupportMultipleWindows(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setSupportMultipleWindows(z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "source")
    public void setSource(RNCWebViewWrapper viewWrapper, @Nullable ReadableMap readableMap) {
        byte[] bytes;
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                String string = readableMap.getString("html");
                String string2 = readableMap.hasKey("baseUrl") ? readableMap.getString("baseUrl") : "";
                Intrinsics.c(string);
                webView.loadDataWithBaseURL(string2, string, "text/html", "UTF-8", null);
                return;
            }
            if (readableMap.hasKey("uri")) {
                String string3 = readableMap.getString("uri");
                String url = webView.getUrl();
                if (url == null || !url.equals(string3)) {
                    if (readableMap.hasKey("method") && StringsKt.t(readableMap.getString("method"), "POST", true)) {
                        if (readableMap.hasKey("body")) {
                            String string4 = readableMap.getString("body");
                            try {
                                Intrinsics.c(string4);
                                Charset charsetForName = Charset.forName("UTF-8");
                                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                                bytes = string4.getBytes(charsetForName);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            } catch (UnsupportedEncodingException unused) {
                                Intrinsics.c(string4);
                                bytes = string4.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            }
                        } else {
                            bytes = null;
                        }
                        if (bytes == null) {
                            bytes = new byte[0];
                        }
                        Intrinsics.c(string3);
                        webView.postUrl(string3, bytes);
                        return;
                    }
                    HashMap map = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        ReadableMap map2 = readableMap.getMap("headers");
                        Intrinsics.c(map2);
                        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map2.keySetIterator();
                        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                            Locale ENGLISH = Locale.ENGLISH;
                            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                            String lowerCase = strNextKey.toLowerCase(ENGLISH);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if ("user-agent".equals(lowerCase)) {
                                webView.getSettings().setUserAgentString(map2.getString(strNextKey));
                            } else {
                                map.put(strNextKey, map2.getString(strNextKey));
                            }
                        }
                    }
                    Intrinsics.c(string3);
                    webView.loadUrl(string3, map);
                    return;
                }
                return;
            }
        }
        webView.loadUrl("about:blank");
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(RNCWebViewWrapper viewWrapper, int i2) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setTextZoom(i2);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        CookieManager.getInstance().setAcceptThirdPartyCookies(viewWrapper.getWebView(), z);
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(RNCWebViewWrapper viewWrapper, @Nullable String str) {
        RNCWebViewManagerImpl rNCWebViewManagerImpl = this.mRNCWebViewManagerImpl;
        rNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        rNCWebViewManagerImpl.f46279f = str;
        rNCWebViewManagerImpl.b(viewWrapper);
    }

    @ReactProp(name = "webviewDebuggingEnabled")
    public void setWebviewDebuggingEnabled(RNCWebViewWrapper viewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        WebView.setWebContentsDebuggingEnabled(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NonNull ThemedReactContext themedReactContext, RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().setWebViewClient(new RNCWebViewClient());
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RNCWebViewWrapper createViewInstance(ThemedReactContext context) {
        RNCWebViewManagerImpl rNCWebViewManagerImpl = this.mRNCWebViewManagerImpl;
        rNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        RNCWebView rNCWebView = new RNCWebView(context);
        rNCWebView.f46247d = false;
        rNCWebView.f46251h = false;
        rNCWebView.f46253j = false;
        rNCWebView.f46254k = false;
        ThemedReactContext themedReactContext = (ThemedReactContext) rNCWebView.getContext();
        if (themedReactContext != null) {
            rNCWebView.f46250g = themedReactContext.f19479a.getCatalystInstance();
        }
        RNCWebView.ProgressChangedFilter progressChangedFilter = new RNCWebView.ProgressChangedFilter();
        progressChangedFilter.f46267a = false;
        rNCWebView.f46255l = progressChangedFilter;
        return rNCWebViewManagerImpl.a(context, rNCWebView);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NonNull RNCWebViewWrapper viewWrapper) {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        webView.getThemedReactContext().removeLifecycleEventListener(webView);
        webView.setWebViewClient(null);
        webView.destroy();
        webView.n = null;
        super.onDropViewInstance((RNCWebViewManager) viewWrapper);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull RNCWebViewWrapper viewWrapper, String commandId, @Nullable ReadableArray args) throws JSONException {
        this.mRNCWebViewManagerImpl.getClass();
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        Intrinsics.checkNotNullParameter(args, "args");
        RNCWebView webView = viewWrapper.getWebView();
        switch (commandId.hashCode()) {
            case -1241591313:
                if (commandId.equals("goBack")) {
                    webView.goBack();
                    break;
                }
                break;
            case -948122918:
                if (commandId.equals("stopLoading")) {
                    webView.stopLoading();
                    break;
                }
                break;
            case -934641255:
                if (commandId.equals("reload")) {
                    webView.reload();
                    break;
                }
                break;
            case -759238347:
                if (commandId.equals("clearCache")) {
                    webView.clearCache(args.getBoolean(0));
                    break;
                }
                break;
            case -318289731:
                if (commandId.equals("goForward")) {
                    webView.goForward();
                    break;
                }
                break;
            case -265032709:
                if (commandId.equals("clearFormData")) {
                    webView.clearFormData();
                    break;
                }
                break;
            case 336631465:
                if (commandId.equals("loadUrl")) {
                    webView.f46255l.f46267a = false;
                    String string = args.getString(0);
                    Intrinsics.c(string);
                    webView.loadUrl(string);
                    break;
                }
                break;
            case 903120263:
                if (commandId.equals("clearHistory")) {
                    webView.clearHistory();
                    break;
                }
                break;
            case 1280029577:
                if (commandId.equals("requestFocus")) {
                    webView.requestFocus();
                    break;
                }
                break;
            case 1490029383:
                if (commandId.equals("postMessage")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", args.getString(0));
                        webView.evaluateJavascript("(function () {var event;var data = " + jSONObject + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();", null);
                        break;
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                break;
            case 2104576510:
                if (commandId.equals("injectJavaScript")) {
                    webView.evaluateJavascript(args.getString(0), null);
                    break;
                }
                break;
        }
        super.receiveCommand((RNCWebViewManager) viewWrapper, commandId, args);
    }

    public RNCWebViewWrapper createViewInstance(ThemedReactContext themedReactContext, RNCWebViewWrapper rNCWebViewWrapper) {
        return this.mRNCWebViewManagerImpl.a(themedReactContext, rNCWebViewWrapper.getWebView());
    }
}
