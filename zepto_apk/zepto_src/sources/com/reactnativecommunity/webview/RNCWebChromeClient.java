package com.reactnativecommunity.webview;

import android.content.ComponentCallbacks2;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.work.impl.c;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.reactnativecommunity.webview.RNCWebView;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopOpenWindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
    public static final FrameLayout.LayoutParams n = new FrameLayout.LayoutParams(-1, -1, 17);

    /* renamed from: a, reason: collision with root package name */
    public final RNCWebView f46230a;

    /* renamed from: b, reason: collision with root package name */
    public View f46231b;

    /* renamed from: c, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f46232c;

    /* renamed from: d, reason: collision with root package name */
    public PermissionRequest f46233d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f46234e;

    /* renamed from: f, reason: collision with root package name */
    public GeolocationPermissions.Callback f46235f;

    /* renamed from: g, reason: collision with root package name */
    public String f46236g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f46237h = false;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f46238i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public RNCWebView.ProgressChangedFilter f46239j = null;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46240k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f46241l = false;

    /* renamed from: m, reason: collision with root package name */
    public final c f46242m = new c(this, 4);

    public RNCWebChromeClient(RNCWebView rNCWebView) {
        this.f46230a = rNCWebView;
    }

    public final synchronized void a(List list) {
        if (this.f46237h) {
            this.f46238i.addAll(list);
            return;
        }
        ComponentCallbacks2 currentActivity = this.f46230a.getThemedReactContext().f19479a.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        }
        if (!(currentActivity instanceof PermissionAwareActivity)) {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
        this.f46237h = true;
        ((PermissionAwareActivity) currentActivity).d((String[]) list.toArray(new String[0]), 3, this.f46242m);
        this.f46238i.clear();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(final WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        if (this.f46241l) {
            webView2.setWebViewClient(new WebViewClient() { // from class: com.reactnativecommunity.webview.RNCWebChromeClient.1
                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView3, String str) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("targetUrl", str);
                    WebView webView4 = webView;
                    ((RNCWebView) webView4).a(webView4, new TopOpenWindowEvent(RNCWebViewWrapper.a(webView4), writableMapCreateMap));
                    return true;
                }
            });
        }
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (ContextCompat.a(this.f46230a.getThemedReactContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            callback.invoke(str, true, false);
            return;
        }
        this.f46235f = callback;
        this.f46236g = str;
        a(Collections.singletonList("android.permission.ACCESS_FINE_LOCATION"));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        View view = this.f46231b;
        if (view == null || view.getSystemUiVisibility() == 7942) {
            return;
        }
        this.f46231b.setSystemUiVisibility(7942);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        this.f46234e = new ArrayList();
        ArrayList arrayList = new ArrayList();
        String[] resources = permissionRequest.getResources();
        int length = resources.length;
        int i2 = 0;
        while (true) {
            String str = null;
            if (i2 >= length) {
                break;
            }
            String str2 = resources[i2];
            if (str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                str = "android.permission.RECORD_AUDIO";
            } else if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                str = "android.permission.CAMERA";
            } else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                if (this.f46240k) {
                    this.f46234e.add(str2);
                } else {
                    str = "android.webkit.resource.PROTECTED_MEDIA_ID";
                }
            }
            if (str != null) {
                if (ContextCompat.a(this.f46230a.getThemedReactContext(), str) == 0) {
                    this.f46234e.add(str2);
                } else {
                    arrayList.add(str);
                }
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            permissionRequest.grant((String[]) this.f46234e.toArray(new String[0]));
            this.f46234e = null;
        } else {
            this.f46233d = permissionRequest;
            a(arrayList);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        String url = webView.getUrl();
        if (this.f46239j.f46267a) {
            return;
        }
        int iA = RNCWebViewWrapper.a(webView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("target", iA);
        writableMapCreateMap.putString("title", webView.getTitle());
        writableMapCreateMap.putString("url", url);
        writableMapCreateMap.putBoolean("canGoBack", webView.canGoBack());
        writableMapCreateMap.putBoolean("canGoForward", webView.canGoForward());
        writableMapCreateMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, i2 / 100.0f);
        UIManagerHelper.b(this.f46230a.getThemedReactContext(), iA).g(new TopLoadingProgressEvent(iA, writableMapCreateMap));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return ((RNCWebViewModule) this.f46230a.getThemedReactContext().f19479a.getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, fileChooserParams.getAcceptTypes(), fileChooserParams.getMode() == 1, fileChooserParams.isCaptureEnabled());
    }
}
