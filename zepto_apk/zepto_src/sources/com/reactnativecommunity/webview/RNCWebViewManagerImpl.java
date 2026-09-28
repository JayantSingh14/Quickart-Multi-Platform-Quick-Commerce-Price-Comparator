package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.media.b;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.facebook.react.uimanager.ThemedReactContext;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RNCWebViewManagerImpl {

    /* renamed from: a, reason: collision with root package name */
    public boolean f46274a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f46275b;

    /* renamed from: c, reason: collision with root package name */
    public String f46276c;

    /* renamed from: d, reason: collision with root package name */
    public String f46277d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46278e;

    /* renamed from: f, reason: collision with root package name */
    public String f46279f;

    /* renamed from: g, reason: collision with root package name */
    public String f46280g;

    @Metadata
    public static final class Companion {
    }

    public final RNCWebViewWrapper a(ThemedReactContext context, final RNCWebView webView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        c(webView);
        context.addLifecycleEventListener(webView);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(1);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        webView.setDownloadListener(new DownloadListener() { // from class: com.reactnativecommunity.webview.a
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) throws UnsupportedEncodingException {
                RNCWebViewManagerImpl rNCWebViewManagerImpl = this;
                RNCWebView rNCWebView = webView;
                rNCWebView.setIgnoreErrFailedForThisURL(str);
                RNCWebViewModule rNCWebViewModule = (RNCWebViewModule) rNCWebView.getThemedReactContext().f19479a.getNativeModule(RNCWebViewModule.class);
                if (rNCWebViewModule == null) {
                    return;
                }
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                    String strA = URLUtil.a(str, str3, str4);
                    Intrinsics.c(strA);
                    String strReplace = RNCWebViewManagerImplKt.a().replace(strA, Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
                    String strC = b.C("Downloading ", strReplace);
                    try {
                        URL url = new URL(str);
                        request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
                    } catch (MalformedURLException e2) {
                        rNCWebViewManagerImpl.getClass();
                        Log.w("RNCWebViewManagerImpl", "Error getting cookie for DownloadManager", e2);
                    }
                    request.addRequestHeader("User-Agent", str2);
                    request.setTitle(strReplace);
                    request.setDescription(strC);
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, strReplace);
                    rNCWebViewModule.setDownloadRequest(request);
                    String str5 = rNCWebViewManagerImpl.f46276c;
                    if (str5 == null) {
                        str5 = "Downloading";
                    }
                    String str6 = rNCWebViewManagerImpl.f46277d;
                    if (str6 == null) {
                        str6 = "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.";
                    }
                    if (rNCWebViewModule.grantFileDownloaderPermissions(str5, str6)) {
                        String str7 = rNCWebViewManagerImpl.f46276c;
                        rNCWebViewModule.downloadFile(str7 != null ? str7 : "Downloading");
                    }
                } catch (IllegalArgumentException e3) {
                    rNCWebViewManagerImpl.getClass();
                    Log.w("RNCWebViewManagerImpl", "Unsupported URI, aborting download", e3);
                }
            }
        });
        return new RNCWebViewWrapper(context, webView);
    }

    public final void b(RNCWebViewWrapper rNCWebViewWrapper) {
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (this.f46279f != null) {
            webView.getSettings().setUserAgentString(this.f46279f);
        } else if (this.f46280g != null) {
            webView.getSettings().setUserAgentString(this.f46280g);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    public final void c(final RNCWebView rNCWebView) {
        final Activity currentActivity = rNCWebView.getThemedReactContext().f19479a.getCurrentActivity();
        if (this.f46274a && currentActivity != null) {
            final int requestedOrientation = currentActivity.getRequestedOrientation();
            RNCWebChromeClient rNCWebChromeClient = new RNCWebChromeClient(rNCWebView) { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1
                @Override // android.webkit.WebChromeClient
                public final Bitmap getDefaultVideoPoster() {
                    return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
                }

                @Override // android.webkit.WebChromeClient
                public final void onHideCustomView() {
                    if (this.f46231b == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) this.f46230a.getThemedReactContext().f19479a.getCurrentActivity().findViewById(android.R.id.content);
                    View rootView = viewGroup.getRootView();
                    RNCWebView rNCWebView2 = this.f46230a;
                    if (rootView != rNCWebView2.getRootView()) {
                        rNCWebView2.getRootView().setVisibility(0);
                    } else {
                        rNCWebView2.setVisibility(0);
                    }
                    Activity activity = currentActivity;
                    activity.getWindow().clearFlags(512);
                    viewGroup.removeView(this.f46231b);
                    this.f46232c.onCustomViewHidden();
                    this.f46231b = null;
                    this.f46232c = null;
                    activity.setRequestedOrientation(requestedOrientation);
                    rNCWebView2.getThemedReactContext().removeLifecycleEventListener(this);
                }

                @Override // android.webkit.WebChromeClient
                public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    if (this.f46231b != null) {
                        callback.onCustomViewHidden();
                        return;
                    }
                    this.f46231b = view;
                    this.f46232c = callback;
                    Activity activity = currentActivity;
                    activity.setRequestedOrientation(-1);
                    this.f46231b.setSystemUiVisibility(7942);
                    activity.getWindow().setFlags(512, 512);
                    this.f46231b.setBackgroundColor(-16777216);
                    ViewGroup viewGroup = (ViewGroup) this.f46230a.getThemedReactContext().f19479a.getCurrentActivity().findViewById(android.R.id.content);
                    viewGroup.addView(this.f46231b, RNCWebChromeClient.n);
                    View rootView = viewGroup.getRootView();
                    RNCWebView rNCWebView2 = this.f46230a;
                    if (rootView != rNCWebView2.getRootView()) {
                        rNCWebView2.getRootView().setVisibility(8);
                    } else {
                        rNCWebView2.setVisibility(8);
                    }
                    rNCWebView2.getThemedReactContext().addLifecycleEventListener(this);
                }
            };
            rNCWebChromeClient.f46240k = this.f46275b;
            rNCWebChromeClient.f46241l = this.f46278e;
            rNCWebView.setWebChromeClient(rNCWebChromeClient);
            return;
        }
        RNCWebChromeClient rNCWebChromeClient2 = (RNCWebChromeClient) rNCWebView.getWebChromeClient();
        if (rNCWebChromeClient2 != null) {
            rNCWebChromeClient2.onHideCustomView();
        }
        RNCWebViewManagerImpl$setupWebChromeClient$1 rNCWebViewManagerImpl$setupWebChromeClient$1 = new RNCWebViewManagerImpl$setupWebChromeClient$1(rNCWebView);
        rNCWebViewManagerImpl$setupWebChromeClient$1.f46240k = this.f46275b;
        rNCWebViewManagerImpl$setupWebChromeClient$1.f46241l = this.f46278e;
        rNCWebView.setWebChromeClient(rNCWebViewManagerImpl$setupWebChromeClient$1);
    }
}
