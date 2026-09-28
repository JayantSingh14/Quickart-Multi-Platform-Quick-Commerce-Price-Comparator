package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.events.TopCustomMenuSelectionEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RNCWebView extends WebView implements LifecycleEventListener {

    /* renamed from: a, reason: collision with root package name */
    public String f46244a;

    /* renamed from: b, reason: collision with root package name */
    public String f46245b;

    /* renamed from: c, reason: collision with root package name */
    public RNCWebViewBridge f46246c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f46247d;

    /* renamed from: e, reason: collision with root package name */
    public String f46248e;

    /* renamed from: f, reason: collision with root package name */
    public RNCWebViewClient f46249f;

    /* renamed from: g, reason: collision with root package name */
    public CatalystInstance f46250g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f46251h;

    /* renamed from: i, reason: collision with root package name */
    public OnScrollDispatchHelper f46252i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f46253j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46254k;

    /* renamed from: l, reason: collision with root package name */
    public ProgressChangedFilter f46255l;

    /* renamed from: m, reason: collision with root package name */
    public List f46256m;
    public WebChromeClient n;

    public static class ProgressChangedFilter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f46267a;
    }

    /* loaded from: classes4.dex */
    public class RNCWebViewBridge {

        /* renamed from: a, reason: collision with root package name */
        public final RNCWebView f46268a;

        /* renamed from: b, reason: collision with root package name */
        public String f46269b;

        public RNCWebViewBridge(RNCWebView rNCWebView) {
            this.f46268a = rNCWebView;
        }

        public final void a(String str) {
            this.f46269b = str;
        }

        @JavascriptInterface
        public String injectedObjectJson() {
            return this.f46269b;
        }

        @JavascriptInterface
        public void postMessage(final String str) {
            final RNCWebView rNCWebView = this.f46268a;
            if (!rNCWebView.getMessagingEnabled()) {
                FLog.q("RNCWebViewBridge", "ReactNativeWebView.postMessage method was called but messaging is disabled. Pass an onMessage handler to the WebView.");
                return;
            }
            rNCWebView.getThemedReactContext();
            if (rNCWebView.f46249f != null) {
                rNCWebView.post(new Runnable() { // from class: com.reactnativecommunity.webview.RNCWebView.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        RNCWebView rNCWebView2 = RNCWebView.this;
                        RNCWebViewClient rNCWebViewClient = rNCWebView2.f46249f;
                        if (rNCWebViewClient == null) {
                            return;
                        }
                        WebView webView = rNCWebView;
                        WritableMap writableMapA = rNCWebViewClient.a(webView, webView.getUrl());
                        writableMapA.putString("data", str);
                        if (rNCWebView2.f46250g != null) {
                            rNCWebView.b("onMessage", writableMapA);
                        } else {
                            rNCWebView2.a(webView, new TopMessageEvent(RNCWebViewWrapper.a(webView), writableMapA));
                        }
                    }
                });
                return;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("data", str);
            if (rNCWebView.f46250g != null) {
                rNCWebView.b("onMessage", writableMapCreateMap);
            } else {
                rNCWebView.a(rNCWebView, new TopMessageEvent(RNCWebViewWrapper.a(rNCWebView), writableMapCreateMap));
            }
        }
    }

    public final void a(WebView webView, Event event) {
        UIManagerHelper.b(getThemedReactContext(), RNCWebViewWrapper.a(webView)).g(event);
    }

    public final void b(String str, WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        writableNativeArray.pushMap(writableNativeMap);
        this.f46250g.callFunction(this.f46248e, str, writableNativeArray);
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        WebChromeClient webChromeClient = this.n;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        }
        super.destroy();
    }

    public boolean getMessagingEnabled() {
        return this.f46247d;
    }

    @Nullable
    public RNCWebViewClient getRNCWebViewClient() {
        return this.f46249f;
    }

    public ThemedReactContext getThemedReactContext() {
        return (ThemedReactContext) getContext();
    }

    @Override // android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        return this.n;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        setWebViewClient(null);
        destroy();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.f46253j) {
            if (this.f46252i == null) {
                this.f46252i = new OnScrollDispatchHelper();
            }
            if (this.f46252i.a(i2, i3)) {
                OnScrollDispatchHelper onScrollDispatchHelper = this.f46252i;
                float f2 = onScrollDispatchHelper.f20016c;
                float f3 = onScrollDispatchHelper.f20017d;
                int iComputeHorizontalScrollRange = computeHorizontalScrollRange();
                int iComputeVerticalScrollRange = computeVerticalScrollRange();
                int width = getWidth();
                int height = getHeight();
                Pools.SynchronizedPool synchronizedPool = ScrollEvent.f20072k;
                a(this, ScrollEvent.Companion.a(-1, RNCWebViewWrapper.a(this), ScrollEventType.f20086d, i2, i3, f2, f3, iComputeHorizontalScrollRange, iComputeVerticalScrollRange, width, height));
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f46251h) {
            a(this, new ContentSizeChangeEvent(RNCWebViewWrapper.a(this), i2, i3));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f46254k) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBasicAuthCredential(RNCBasicAuthCredential rNCBasicAuthCredential) {
        this.f46249f.f46273d = rNCBasicAuthCredential;
    }

    public void setHasScrollEvent(boolean z) {
        this.f46253j = z;
    }

    public void setIgnoreErrFailedForThisURL(String str) {
        this.f46249f.f46272c = str;
    }

    public void setInjectedJavaScriptObject(String str) {
        if (getSettings().getJavaScriptEnabled()) {
            if (this.f46246c == null) {
                RNCWebViewBridge rNCWebViewBridge = new RNCWebViewBridge(this);
                this.f46246c = rNCWebViewBridge;
                addJavascriptInterface(rNCWebViewBridge, "ReactNativeWebView");
            }
            this.f46246c.a(str);
        }
    }

    public void setMenuCustomItems(List<Map<String, String>> list) {
        this.f46256m = list;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void setMessagingEnabled(boolean z) {
        if (this.f46247d == z) {
            return;
        }
        this.f46247d = z;
        if (z && this.f46246c == null) {
            RNCWebViewBridge rNCWebViewBridge = new RNCWebViewBridge(this);
            this.f46246c = rNCWebViewBridge;
            addJavascriptInterface(rNCWebViewBridge, "ReactNativeWebView");
        }
    }

    public void setNestedScrollEnabled(boolean z) {
        this.f46254k = z;
    }

    public void setSendContentSizeChangeEvents(boolean z) {
        this.f46251h = z;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.n = webChromeClient;
        super.setWebChromeClient(webChromeClient);
        if (webChromeClient instanceof RNCWebChromeClient) {
            ((RNCWebChromeClient) webChromeClient).f46239j = this.f46255l;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof RNCWebViewClient) {
            RNCWebViewClient rNCWebViewClient = (RNCWebViewClient) webViewClient;
            this.f46249f = rNCWebViewClient;
            rNCWebViewClient.f46271b = this.f46255l;
        }
    }

    @Override // android.view.View
    public final ActionMode startActionMode(final ActionMode.Callback callback, int i2) {
        return this.f46256m == null ? super.startActionMode(callback, i2) : super.startActionMode(new ActionMode.Callback2() { // from class: com.reactnativecommunity.webview.RNCWebView.1
            @Override // android.view.ActionMode.Callback
            public final boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
                final WritableMap writableMapCreateMap = Arguments.createMap();
                RNCWebView.this.evaluateJavascript("(function(){return {selection: window.getSelection().toString()} })()", new ValueCallback<String>() { // from class: com.reactnativecommunity.webview.RNCWebView.1.1
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(String str) throws JSONException {
                        String string;
                        String str2 = str;
                        RNCWebView rNCWebView = RNCWebView.this;
                        Map map = (Map) rNCWebView.f46256m.get(menuItem.getItemId());
                        String str3 = (String) map.get("label");
                        WritableMap writableMap = writableMapCreateMap;
                        writableMap.putString("label", str3);
                        writableMap.putString("key", (String) map.get("key"));
                        try {
                            string = new JSONObject(str2).getString("selection");
                        } catch (JSONException unused) {
                            string = "";
                        }
                        writableMap.putString("selectedText", string);
                        rNCWebView.a(rNCWebView, new TopCustomMenuSelectionEvent(RNCWebViewWrapper.a(rNCWebView), writableMap));
                        actionMode.finish();
                    }
                });
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                int i3 = 0;
                while (true) {
                    RNCWebView rNCWebView = RNCWebView.this;
                    if (i3 >= rNCWebView.f46256m.size()) {
                        return true;
                    }
                    menu.add(0, i3, i3, (CharSequence) ((Map) rNCWebView.f46256m.get(i3)).get("label"));
                    i3++;
                }
            }

            @Override // android.view.ActionMode.Callback
            public final void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback2
            public final void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
                ActionMode.Callback callback2 = callback;
                if (callback2 instanceof ActionMode.Callback2) {
                    ((ActionMode.Callback2) callback2).onGetContentRect(actionMode, view, rect);
                } else {
                    super.onGetContentRect(actionMode, view, rect);
                }
            }

            @Override // android.view.ActionMode.Callback
            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        }, i2);
    }
}
