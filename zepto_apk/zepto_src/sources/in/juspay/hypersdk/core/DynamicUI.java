package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.airborne.ota.ApplicationManager;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JsCallback;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.mystique.Callback;
import in.juspay.hypersdk.mystique.DUIWebViewClient;
import in.juspay.hypersdk.mystique.WebClientCallback;
import in.juspay.hypersdk.ota.OTABaseHTML;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class DynamicUI implements JsCallback {

    @Nullable
    private Activity activity;

    @NonNull
    private final HashMap<Activity, Set<ViewGroup>> activityContainerMap;

    @NonNull
    private final AndroidInterface androidInterface;

    @NonNull
    private Context appContext;

    @NonNull
    private ApplicationManager applicationManager;

    @NonNull
    private final String baseContent;

    @NonNull
    private final BridgeComponents bridgeComponents;

    @Nullable
    private WebView browser;

    @NonNull
    private final Callback callback;

    @Nullable
    private FrameLayout container;

    @NonNull
    private final DUIMerchantView duiMerchantView;

    @NonNull
    private ConcurrentHashMap<String, ViewGroup> fragments;

    @NonNull
    private final InflateView inflateView;

    @NonNull
    final Map<String, Object> jsInterfaces;

    @Nullable
    private String loadCallJS;

    @NonNull
    private final DuiLogger mLogger;

    @NonNull
    private final Renderer renderer;

    @NonNull
    private final Map<String, Object> screenMap;

    @NonNull
    private final HashMap<String, JSONArray> storedFunctions;

    @NonNull
    private final AtomicReference<WebViewState> webViewState;

    @Nullable
    private Exception webViewCrashException = null;

    @NonNull
    private final HashMap<String, Object> globalState = new HashMap<>();

    @NonNull
    private final HashMap<String, String> activityData = new HashMap<>();
    private boolean isForeGround = true;
    private boolean isInitiated = false;
    private int totalWebViewFailure = 0;
    private boolean enableWebViewRecreate = false;

    /* renamed from: in.juspay.hypersdk.core.DynamicUI$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersdk$core$WebViewState;

        static {
            int[] iArr = new int[WebViewState.values().length];
            $SwitchMap$in$juspay$hypersdk$core$WebViewState = iArr;
            try {
                iArr[WebViewState.Recreating.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$core$WebViewState[WebViewState.Broken.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$core$WebViewState[WebViewState.Crashed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$core$WebViewState[WebViewState.Null.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$core$WebViewState[WebViewState.Created.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$core$WebViewState[WebViewState.Active.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public DynamicUI(@NonNull Context context, @NonNull DuiLogger duiLogger, @NonNull Callback callback, @NonNull BridgeComponents bridgeComponents, @Nullable String str, Map<String, Object> map, JSONObject jSONObject, @NonNull ApplicationManager applicationManager, @NonNull DUIMerchantView dUIMerchantView, boolean z) {
        HashMap map2 = new HashMap();
        this.jsInterfaces = map2;
        this.mLogger = duiLogger;
        this.callback = callback;
        this.bridgeComponents = bridgeComponents;
        this.webViewState = new AtomicReference<>(WebViewState.Null);
        this.storedFunctions = new HashMap<>();
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        this.appContext = context.getApplicationContext();
        this.screenMap = new HashMap();
        this.fragments = new ConcurrentHashMap<>();
        this.activityContainerMap = new HashMap<>();
        this.duiMerchantView = dUIMerchantView;
        this.applicationManager = applicationManager;
        AndroidInterface androidInterface = new AndroidInterface(this);
        this.androidInterface = androidInterface;
        this.renderer = new Renderer(this, jSONObject);
        this.inflateView = new InflateJSON(this);
        this.baseContent = str == null ? OTABaseHTML.HTML : str;
        map2.put("Android", androidInterface);
        map2.putAll(map);
        if (z) {
            return;
        }
        ExecutorManager.runOnMainThread(new q(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    public void createWebView() {
        try {
            this.browser = new WebView(this.appContext);
            this.webViewState.set(WebViewState.Created);
            setupWebView();
            this.browser.getSettings().setJavaScriptEnabled(true);
            for (Map.Entry<String, Object> entry : this.jsInterfaces.entrySet()) {
                this.browser.addJavascriptInterface(entry.getValue(), entry.getKey());
            }
            loadBaseHtml();
            this.callback.webViewLoaded(null);
            this.totalWebViewFailure = 0;
        } catch (Exception e2) {
            this.totalWebViewFailure++;
            if (isWebViewBroken()) {
                this.webViewState.set(WebViewState.Broken);
                this.webViewCrashException = e2;
                this.callback.webViewLoaded(e2);
                this.mLogger.logLifeCycleException(Labels.Android.WEBVIEW, "WebView creation failed " + this.totalWebViewFailure, e2);
                return;
            }
            this.browser = null;
            this.webViewState.set(WebViewState.Recreating);
            this.mLogger.logLifeCycleException(Labels.Android.WEBVIEW, "Webview crashed, recreating " + this.totalWebViewFailure, e2);
            ExecutorManager.postOnMainThread((long) ((this.totalWebViewFailure + 1) * 50), new q(this, 0));
        }
    }

    private String getStringStackTraceFromError(Error error) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : error.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    private String getStringStackTraceFromException(Exception exc) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    private boolean isWebViewBroken() {
        return this.totalWebViewFailure > 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addJavascriptInterface$2(Object obj, String str) {
        WebView webView = this.browser;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
        this.jsInterfaces.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addJsToWebView$1(String str) {
        try {
            WebView webView = this.browser;
            if (webView != null) {
                webView.evaluateJavascript(str, null);
            } else {
                logError("browser null, call start first");
            }
        } catch (Exception e2) {
            String stringStackTraceFromException = getStringStackTraceFromException(e2);
            logError(android.support.v4.media.b.C("Exception :", stringStackTraceFromException));
            this.callback.onError("addJsToWebView", stringStackTraceFromException);
        } catch (OutOfMemoryError e3) {
            String stringStackTraceFromError = getStringStackTraceFromError(e3);
            logError(android.support.v4.media.b.C("OutOfMemoryError :", stringStackTraceFromError));
            this.callback.onError("addJsToWebView", stringStackTraceFromError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupWebView$0(WebView webView) {
        if (webView == this.browser) {
            recreateWebView();
        }
    }

    private void loadBaseHtml() {
        ExecutorManager.runOnMainThread(new q(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        WebView webView = this.browser;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, this.baseContent, "text/html", "utf-8", null);
            this.mLogger.logLifeCycleInfo("url_loaded", "base.html");
        }
    }

    private void logError(String str) {
        this.mLogger.e("DynamicUI", str);
    }

    private void recreateWebView() {
        this.webViewState.set(WebViewState.Null);
        this.callback.onRenderProcessGone(this.enableWebViewRecreate);
        if (this.enableWebViewRecreate) {
            this.browser = null;
            if (this.isForeGround) {
                ExecutorManager.runOnMainThread(new q(this, 0));
            } else {
                this.webViewState.set(WebViewState.Crashed);
            }
        }
    }

    private void setupWebView() {
        if (this.browser != null) {
            if (this.appContext.getResources().getBoolean(R.bool.godel_debuggable)) {
                this.browser.setWebChromeClient(new WebChromeClient());
            } else {
                this.browser.setWebChromeClient(new WebChromeClient() { // from class: in.juspay.hypersdk.core.DynamicUI.1
                    @Override // android.webkit.WebChromeClient
                    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        return true;
                    }
                });
            }
            this.browser.setWebViewClient(new DUIWebViewClient(new WebClientCallback() { // from class: in.juspay.hypersdk.core.s
                @Override // in.juspay.hypersdk.mystique.WebClientCallback
                public final void onRenderProcessGone(WebView webView) {
                    this.f48670a.lambda$setupWebView$0(webView);
                }
            }));
        }
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        ExecutorManager.runOnMainThread(new r(this, obj, str, 0));
    }

    @Override // in.juspay.hyper.core.JsCallback
    public void addJsToWebView(@NonNull String str) {
        ExecutorManager.runOnMainThread(new l(1, this, str));
    }

    public String addToContainerList(@NonNull ViewGroup viewGroup) {
        String string = UUID.randomUUID().toString();
        this.fragments.put(string, viewGroup);
        setContainerInMap(viewGroup);
        return string;
    }

    public void addToScreenMap(String str, Object obj) {
        this.screenMap.put(str, obj);
    }

    public String encodeUtfAndWrapDecode(String str, String str2) {
        try {
            return "decodeURIComponent('" + URLEncoder.encode(str, "UTF-8").replace("+", "%20") + "')";
        } catch (UnsupportedEncodingException unused) {
            JuspayLogger.e(str2, "Failed to encode using URLEncoder");
            return android.support.v4.media.b.D("atob('", Base64.encodeToString(str.getBytes(), 2), "')");
        }
    }

    @Nullable
    public Activity getActivity() {
        return this.activity;
    }

    public String getActivityData(String str) {
        return this.activityData.containsKey(str) ? this.activityData.get(str) : "";
    }

    @Keep
    public HashMap<String, JSONArray> getAllFunctions() {
        return this.storedFunctions;
    }

    @Keep
    public HashMap<String, Object> getAllGlobalState() {
        return this.globalState;
    }

    @NonNull
    public AndroidInterface getAndroidInterface() {
        return this.androidInterface;
    }

    @NonNull
    public Context getAppContext() {
        return this.appContext;
    }

    @NonNull
    public ApplicationManager getApplicationManager() {
        return this.applicationManager;
    }

    @NonNull
    public BridgeComponents getBridgeComponents() {
        return this.bridgeComponents;
    }

    @Nullable
    public ViewGroup getContainer(String str) {
        return str == null ? this.container : this.fragments.get(str);
    }

    public Callback getErrorCallback() {
        return this.callback;
    }

    public JSONArray getFunction(String str) {
        return this.storedFunctions.get(str);
    }

    public Object getGlobalState(String str) {
        return this.globalState.get(str);
    }

    @NonNull
    public InflateView getInflateView() {
        return this.inflateView;
    }

    public DuiLogger getLogger() {
        return this.mLogger;
    }

    @Nullable
    public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
        return this.duiMerchantView.getMerchantView(viewGroup, merchantViewType);
    }

    @NonNull
    public Renderer getRenderer() {
        return this.renderer;
    }

    public String getState() {
        return this.androidInterface.getState();
    }

    public Object getViewFromScreenName(String str) {
        if (this.screenMap.containsKey(str)) {
            return this.screenMap.get(str);
        }
        return null;
    }

    @Nullable
    public Exception getWebViewCrashException() {
        return this.webViewCrashException;
    }

    public boolean initiate() {
        this.loadCallJS = "window.bootLoad()";
        this.totalWebViewFailure = 0;
        this.isInitiated = true;
        int i2 = AnonymousClass2.$SwitchMap$in$juspay$hypersdk$core$WebViewState[this.webViewState.get().ordinal()];
        if (i2 != 1) {
            if (i2 == 3) {
                ExecutorManager.runOnMainThread(new q(this, 0));
            } else if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 != 6) {
                        return false;
                    }
                    addJsToWebView(this.loadCallJS);
                    return true;
                }
            }
            ExecutorManager.runOnMainThread(new q(this, 0));
        }
        return true;
    }

    public void onPauseCallback() {
        this.isForeGround = false;
    }

    public void onResumeCallback() {
        this.isForeGround = true;
        if (this.webViewState.get() == WebViewState.Crashed) {
            ExecutorManager.runOnMainThread(new q(this, 0));
        }
    }

    @Keep
    public void putFunction(String str, JSONArray jSONArray) {
        this.storedFunctions.put(str, jSONArray);
    }

    public void resetActivity() {
        Set<ViewGroup> setRemove = this.activityContainerMap.remove(this.activity);
        if (setRemove != null) {
            for (ViewGroup viewGroup : setRemove) {
                if (viewGroup != null) {
                    this.renderer.resetContainer(viewGroup);
                    if (this.fragments.containsValue(viewGroup)) {
                        for (Map.Entry<String, ViewGroup> entry : this.fragments.entrySet()) {
                            if (Objects.equals(entry.getValue(), entry)) {
                                this.fragments.remove(entry.getKey());
                            }
                        }
                    }
                }
            }
        }
        this.activity = null;
        getInflateView().resetState();
    }

    public void setActivity(@NonNull Activity activity) {
        if (this.activity != activity) {
            this.fragments = new ConcurrentHashMap<>();
            getInflateView().resetState();
        }
        this.activity = activity;
        this.appContext = activity.getApplicationContext();
    }

    public void setApplicationManager(@NonNull ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    public void setContainer(@Nullable FrameLayout frameLayout) {
        this.container = frameLayout;
        setContainerInMap(frameLayout);
        FrameLayout frameLayout2 = this.container;
        if (frameLayout2 == null || !frameLayout2.isHardwareAccelerated()) {
            return;
        }
        this.container.setLayerType(2, null);
    }

    public void setContainerInMap(ViewGroup viewGroup) {
        Set<ViewGroup> hashSet = this.activityContainerMap.get(this.activity);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(viewGroup);
        this.activityContainerMap.put(this.activity, hashSet);
    }

    public void setGlobalState(String str, Object obj) {
        this.globalState.put(str, obj);
    }

    public void setState(String str) {
        this.androidInterface.setState(str);
    }

    public void setWebViewActive() {
        if (this.isInitiated) {
            addJsToWebView(this.loadCallJS);
        }
        this.webViewState.set(WebViewState.Active);
    }

    public void setWebViewRecreate(boolean z) {
        this.enableWebViewRecreate = z;
    }

    public void storeActivityData(String str, String str2) {
        this.activityData.put(str, str2);
    }

    public void terminate() {
        if (this.browser == null) {
            logError("Browser is not present");
            return;
        }
        this.isInitiated = false;
        this.webViewState.set(WebViewState.Null);
        this.browser.loadDataWithBaseURL("http://juspay.in", "<html></html>", "text/html", "utf-8", null);
        this.browser.stopLoading();
        this.browser.destroy();
        this.browser = null;
    }
}
