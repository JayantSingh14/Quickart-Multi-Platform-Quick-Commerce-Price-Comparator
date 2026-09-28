package in.juspay.hypersdk.safe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.b;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.media3.exoplayer.audio.i;
import coil3.network.internal.UtilsKt;
import in.juspay.airborne.services.FileProviderService;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.AcsInterface;
import in.juspay.hypersdk.core.DuiInterface;
import in.juspay.hypersdk.core.GodelJsInterface;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentUtils;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.HyperNetUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class Godel {
    private static final String GODEL = "Godel";
    private static final String LOG_TAG = "PaymentUtils";
    private static final long ON_EXCEPTION_GODEL_OFF_STICKINESS = 86400000;

    @NonNull
    private final AcsInterface acsInterface;

    @NonNull
    private final JSONObject bundleParameters;

    @NonNull
    private JSONObject config;

    @NonNull
    private final Context context;

    @NonNull
    private final DuiInterface duiInterface;

    @NonNull
    private final JuspayServices juspayServices;

    @NonNull
    private final JuspayWebChromeClient juspayWebChromeClient;

    @NonNull
    private final JuspayWebView juspayWebView;

    @NonNull
    private final JuspayWebViewClient juspayWebViewClient;

    @Nullable
    private final JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback;

    @NonNull
    private final PaymentSessionInfo paymentSessionInfo;

    @Nullable
    private final JSONObject processPayload;

    @NonNull
    private final SdkTracker sdkTracker;

    @NonNull
    private final Workspace workspace;

    @NonNull
    private final List<String> allowedDeeplinkPackages = new ArrayList();
    public boolean isRupaySupportedAdded = false;

    @UiThread
    public Godel(@NonNull JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        this.context = context;
        this.juspayServices = juspayServices;
        this.workspace = juspayServices.getWorkspace();
        Activity activity = juspayServices.getActivity();
        JuspayWebView juspayWebView = new JuspayWebView(activity != null ? activity : context);
        this.juspayWebView = juspayWebView;
        this.juspayWebViewClient = new JuspayWebViewClient(this, juspayWebView);
        this.juspayWebChromeClient = new JuspayWebChromeClient(this);
        this.acsInterface = new AcsInterface(juspayServices);
        this.juspayWebViewConfigurationCallback = juspayServices.getWebViewConfigurationCallback();
        this.sdkTracker = juspayServices.getSdkTracker();
        this.duiInterface = juspayServices.getJBridge();
        this.paymentSessionInfo = juspayServices.getPaymentSessionInfo();
        this.bundleParameters = juspayServices.getSessionInfo().getBundleParams();
        this.processPayload = juspayServices.getLastProcessPayload();
        this.config = new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[Catch: Exception -> 0x00e5, TryCatch #0 {Exception -> 0x00e5, blocks: (B:3:0x0001, B:5:0x0009, B:12:0x003a, B:14:0x004a, B:16:0x0050, B:19:0x005e, B:21:0x0064, B:23:0x0074, B:25:0x007c, B:26:0x008f, B:28:0x0095, B:29:0x00b0, B:31:0x00b6, B:33:0x00c2, B:34:0x00c8, B:35:0x00d1, B:36:0x00d9, B:38:0x00df, B:7:0x0013, B:9:0x001b), top: B:42:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df A[Catch: Exception -> 0x00e5, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e5, blocks: (B:3:0x0001, B:5:0x0009, B:12:0x003a, B:14:0x004a, B:16:0x0050, B:19:0x005e, B:21:0x0064, B:23:0x0074, B:25:0x007c, B:26:0x008f, B:28:0x0095, B:29:0x00b0, B:31:0x00b6, B:33:0x00c2, B:34:0x00c8, B:35:0x00d1, B:36:0x00d9, B:38:0x00df, B:7:0x0013, B:9:0x001b), top: B:42:0x0001 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.webkit.WebResourceResponse addAcsToJSFile(@androidx.annotation.NonNull android.webkit.WebResourceRequest r9, @androidx.annotation.NonNull java.lang.String r10, @androidx.annotation.NonNull java.lang.String r11, @androidx.annotation.NonNull org.json.JSONObject r12, @androidx.annotation.NonNull org.json.JSONObject r13) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "POST"
            boolean r1 = r10.equals(r1)     // Catch: java.lang.Exception -> Le5
            if (r1 == 0) goto L13
            okhttp3.Response r9 = r8.getPostRequestConnection(r13, r12, r9)     // Catch: java.lang.Exception -> Le5
            java.io.InputStream r10 = r8.getDataAcsFromPostRequest(r9, r11)     // Catch: java.lang.Exception -> Le5
        L11:
            r7 = r10
            goto L36
        L13:
            java.lang.String r11 = "GET"
            boolean r10 = r10.equals(r11)     // Catch: java.lang.Exception -> Le5
            if (r10 == 0) goto Le5
            in.juspay.hypersdk.utils.network.HyperNetUtils r10 = new in.juspay.hypersdk.utils.network.HyperNetUtils     // Catch: java.lang.Exception -> Le5
            android.content.Context r11 = r8.context     // Catch: java.lang.Exception -> Le5
            java.lang.String r12 = "connection_timeout"
            r1 = 10000(0x2710, float:1.4013E-41)
            int r12 = r13.optInt(r12, r1)     // Catch: java.lang.Exception -> Le5
            java.lang.String r2 = "read_timeout"
            int r13 = r13.optInt(r2, r1)     // Catch: java.lang.Exception -> Le5
            r10.<init>(r11, r12, r13)     // Catch: java.lang.Exception -> Le5
            java.io.InputStream r10 = r8.getDataFromGetRequest(r10, r9)     // Catch: java.lang.Exception -> Le5
            r9 = r0
            goto L11
        L36:
            if (r9 != 0) goto L3a
            goto Le5
        L3a:
            java.lang.String r10 = "content-type"
            java.lang.String r11 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)     // Catch: java.lang.Exception -> Le5
            java.lang.String r10 = r9.b(r10, r0)     // Catch: java.lang.Exception -> Le5
            r11 = -1
            r12 = 59
            if (r10 == 0) goto L5b
            int r13 = r10.indexOf(r12)     // Catch: java.lang.Exception -> Le5
            if (r13 <= r11) goto L5b
            int r13 = r10.indexOf(r12)     // Catch: java.lang.Exception -> Le5
            r1 = 0
            java.lang.String r13 = r10.substring(r1, r13)     // Catch: java.lang.Exception -> Le5
            r2 = r13
            goto L5c
        L5b:
            r2 = r10
        L5c:
            if (r10 == 0) goto L7b
            int r12 = r10.indexOf(r12)     // Catch: java.lang.Exception -> Le5
            if (r12 <= r11) goto L7b
            java.lang.String r11 = "charset=([\\w-_]+)"
            java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11)     // Catch: java.lang.Exception -> Le5
            java.util.regex.Matcher r10 = r11.matcher(r10)     // Catch: java.lang.Exception -> Le5
            boolean r11 = r10.find()     // Catch: java.lang.Exception -> Le5
            if (r11 == 0) goto L7b
            r11 = 1
            java.lang.String r10 = r10.group(r11)     // Catch: java.lang.Exception -> Le5
            r3 = r10
            goto L7c
        L7b:
            r3 = r0
        L7c:
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Exception -> Le5
            r6.<init>()     // Catch: java.lang.Exception -> Le5
            okhttp3.Headers r10 = r9.f56355f     // Catch: java.lang.Exception -> Le5
            java.util.TreeMap r10 = r10.k()     // Catch: java.lang.Exception -> Le5
            java.util.Set r10 = r10.entrySet()     // Catch: java.lang.Exception -> Le5
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Exception -> Le5
        L8f:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Exception -> Le5
            if (r11 == 0) goto Ld9
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Exception -> Le5
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch: java.lang.Exception -> Le5
            java.lang.Object r12 = r11.getKey()     // Catch: java.lang.Exception -> Le5
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Exception -> Le5
            java.lang.Object r11 = r11.getValue()     // Catch: java.lang.Exception -> Le5
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Exception -> Le5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le5
            r13.<init>()     // Catch: java.lang.Exception -> Le5
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Exception -> Le5
        Lb0:
            boolean r1 = r11.hasNext()     // Catch: java.lang.Exception -> Le5
            if (r1 == 0) goto Ld1
            java.lang.Object r1 = r11.next()     // Catch: java.lang.Exception -> Le5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Le5
            int r4 = r13.length()     // Catch: java.lang.Exception -> Le5
            if (r4 != 0) goto Lc8
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le5
            r13.<init>(r1)     // Catch: java.lang.Exception -> Le5
            goto Lb0
        Lc8:
            java.lang.String r4 = ","
            r13.append(r4)     // Catch: java.lang.Exception -> Le5
            r13.append(r1)     // Catch: java.lang.Exception -> Le5
            goto Lb0
        Ld1:
            java.lang.String r11 = r13.toString()     // Catch: java.lang.Exception -> Le5
            r6.put(r12, r11)     // Catch: java.lang.Exception -> Le5
            goto L8f
        Ld9:
            int r4 = r9.f56353d     // Catch: java.lang.Exception -> Le5
            java.lang.String r5 = r9.f56352c     // Catch: java.lang.Exception -> Le5
            if (r7 == 0) goto Le5
            android.webkit.WebResourceResponse r1 = new android.webkit.WebResourceResponse     // Catch: java.lang.Exception -> Le5
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> Le5
            return r1
        Le5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.safe.Godel.addAcsToJSFile(android.webkit.WebResourceRequest, java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONObject):android.webkit.WebResourceResponse");
    }

    @NonNull
    private String getAcsScript() {
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        StringBuilder sbX = b.x("window.juspayContext = {}; juspayContext['web_lab_rules'] = " + getWebLabRules(), ", ");
        sbX.append(fileProviderService.readFromFile(PaymentConstants.ACS));
        return sbX.toString();
    }

    @Nullable
    private String getConnectionData(Reader reader, int i2) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[i2];
            while (true) {
                int i3 = reader.read(cArr);
                if (i3 == -1) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i3);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private InputStream getDataAcsFromPostRequest(@Nullable Response response, @NonNull String str) {
        try {
            if (".html".matches(str)) {
                return handleHtmlFile(response);
            }
            if (!".js".matches(str) && !".jsp".matches(str)) {
                return null;
            }
            return handleJsFile(response);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private InputStream getDataFromGetRequest(@NonNull HyperNetUtils hyperNetUtils, @NonNull WebResourceRequest webResourceRequest) {
        try {
            return new SequenceInputStream(new ByteArrayInputStream(("window.addEventListener('load', function() { if(!window.GK) { " + getAcsScript() + " } });").getBytes(StandardCharsets.UTF_8)), hyperNetUtils.doGet(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders(), null, null, null).f56356g.a());
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private List<Pattern> getExcludeUrlsPatternList() throws JSONException {
        LinkedList linkedList = null;
        try {
            LinkedList linkedList2 = new LinkedList();
            try {
                JSONArray jSONArray = this.config.getJSONArray("exclude_url_patterns");
                if (isNotNull(jSONArray)) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        linkedList2.add(Pattern.compile(jSONArray.get(i2).toString()));
                    }
                }
                return linkedList2;
            } catch (JSONException e2) {
                e = e2;
                linkedList = linkedList2;
                this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Json Exception while fetching excludeUrlPatterns from config", e);
                return linkedList;
            } catch (Exception e3) {
                e = e3;
                linkedList = linkedList2;
                this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Exception while compiling patterns in excludeUrlPatterns from config", e);
                return linkedList;
            }
        } catch (JSONException e4) {
            e = e4;
        } catch (Exception e5) {
            e = e5;
        }
    }

    @Nullable
    private Response getPostRequestConnection(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull WebResourceRequest webResourceRequest) throws JSONException, InterruptedException {
        try {
            String sessionAttribute = this.juspayServices.getJBridge().getSessionAttribute("iframe_form_data", "wait_for_me");
            JSONObject jSONObject3 = this.config.getJSONObject("waiting_time_postparams");
            int iOptInt = jSONObject3.optInt("interval", 50);
            for (int iOptInt2 = jSONObject3.optInt("total_time", 1000); sessionAttribute.equals("wait_for_me") && iOptInt2 > 0; iOptInt2 -= iOptInt) {
                TimeUnit.MILLISECONDS.sleep(iOptInt);
                sessionAttribute = this.juspayServices.getJBridge().getSessionAttribute("iframe_form_data", "wait_for_me");
            }
            if (sessionAttribute.equals("wait_for_me")) {
                return null;
            }
            this.juspayServices.getJBridge().setSessionAttribute("iframe_form_data", "wait_for_me");
            HashMap<String, String> map = toMap(sessionAttribute);
            HyperNetUtils hyperNetUtils = new HyperNetUtils(this.context, jSONObject.optInt("connection_timeout", 10000), jSONObject.optInt("read_timeout", 10000));
            HashMap map2 = new HashMap();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, jSONObject2.getString(next));
            }
            return hyperNetUtils.postUrl(new URL(webResourceRequest.getUrl().toString()), map2, map, new JSONObject(), (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private List<String> getRupaySpecificDomains() throws JSONException {
        ArrayList arrayList = null;
        try {
            JSONArray jSONArray = this.config.getJSONArray("rupay_specific_domains");
            this.juspayServices.sdkDebug(LOG_TAG, "printing urlArray" + jSONArray);
            if (!isNotNull(jSONArray)) {
                return null;
            }
            int length = jSONArray.length();
            ArrayList arrayList2 = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    arrayList2.add(jSONArray.get(i2).toString());
                } catch (JSONException e2) {
                    e = e2;
                    arrayList = arrayList2;
                    this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Json Exception while fetching Rupay Urls from config", e);
                    return arrayList;
                } catch (Exception e3) {
                    e = e3;
                    arrayList = arrayList2;
                    this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Exception while getting rupay urls from config", e);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e4) {
            e = e4;
        } catch (Exception e5) {
            e = e5;
        }
    }

    @Nullable
    private InputStream handleHtmlFile(@Nullable Response response) throws IOException {
        BufferedReader bufferedReader;
        String connectionData;
        if (response != null) {
            try {
                String str = "<script>{ " + getAcsScript() + " } </script></body>";
                Intrinsics.checkNotNullParameter("content-encoding", CLConstants.FIELD_PAY_INFO_NAME);
                String strB = response.b("content-encoding", null);
                ResponseBody responseBody = response.f56356g;
                if (strB != null && strB.equalsIgnoreCase("gzip")) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(responseBody.a()), StandardCharsets.UTF_8), 8000);
                    try {
                        connectionData = getConnectionData(bufferedReader, 8000);
                        bufferedReader.close();
                    } finally {
                    }
                } else if (strB == null || strB.equals("")) {
                    bufferedReader = new BufferedReader(new InputStreamReader(responseBody.a()), 8000);
                    try {
                        String connectionData2 = getConnectionData(bufferedReader, 8000);
                        bufferedReader.close();
                        connectionData = connectionData2;
                    } finally {
                    }
                } else {
                    connectionData = null;
                }
                if (connectionData != null) {
                    return new ByteArrayInputStream(connectionData.replace("</body>", str).getBytes(StandardCharsets.UTF_8));
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Nullable
    private InputStream handleJsFile(@Nullable Response response) {
        if (response == null) {
            return null;
        }
        try {
            return new SequenceInputStream(new ByteArrayInputStream(("window.addEventListener('load', function() { if(!window.GK) { " + getAcsScript() + " } });").getBytes(StandardCharsets.UTF_8)), response.f56356g.a());
        } catch (Exception unused) {
            return null;
        }
    }

    @UiThread
    private void initializeJuspayWebView(@NonNull Context context) throws JSONException {
        this.sdkTracker.trackAction("system", "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "started", context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.juspayWebView.setId(R.id.juspay_browser_view);
        this.juspayWebView.setLayoutParams(layoutParams);
        this.juspayWebView.setHorizontalScrollBarEnabled(false);
        this.juspayWebView.setVerticalScrollBarEnabled(false);
        this.juspayWebView.addJavascriptInterface(this.acsInterface, "ACSGatekeeper");
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        this.paymentSessionInfo.setPaymentDetails(this.bundleParameters);
        fileProviderService.addToFileCacheWhiteList("acs.jsa");
        prepareWebView();
    }

    private boolean isAcsToBeAddedToResource(@NonNull URL url) throws JSONException {
        List<String> rupaySpecificDomains = getRupaySpecificDomains();
        if (rupaySpecificDomains == null) {
            return false;
        }
        Iterator<String> it = rupaySpecificDomains.iterator();
        while (it.hasNext()) {
            if (url.toString().toLowerCase(Locale.getDefault()).contains(it.next()) && url.getPath().toLowerCase(Locale.getDefault()).endsWith(".js") && !url.getPath().toLowerCase(Locale.getDefault()).endsWith(".jsp")) {
                return true;
            }
        }
        return false;
    }

    private boolean isClientWhitelistedForWebViewAccess(String str) {
        JSONArray jSONArrayOptJSONArray = Utils.optJSONArray(Utils.optJSONObject(Utils.optJSONObject(this.juspayServices.getSdkConfigService().getSdkConfig(), "godelConfig"), "webViewAccess"), "whitelistedClientIds");
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            try {
                if (str.contains(jSONArrayOptJSONArray.getString(i2))) {
                    return true;
                }
            } catch (JSONException e2) {
                this.sdkTracker.trackAndLogException(GODEL, "action", "system", Labels.System.GODEL_WEBVIEW_WHITELIST, "Failed to read whitelisted config", e2);
            }
        }
        return false;
    }

    private static boolean isNotNull(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray == JSONObject.NULL) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBrowserReady$0(Activity activity, String str, String str2, String str3) throws JSONException {
        addWebView(activity, str);
        loadPage(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBrowserReady$1(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) throws JSONException {
        addWebView(activity, str);
        this.juspayWebView.loadDataWithBaseURL(str2, str3, str4, str5, str6);
    }

    private boolean shouldDisableGodel(Context context) {
        long jCurrentTimeMillis;
        if (context == null || !this.workspace.isInSharedPreference("GODEL_EXCEPTION_OFF")) {
            return false;
        }
        long jOptLong = getConfig().optLong("ON_EXCEPTION_GODEL_OFF_STICKINESS", 86400000L);
        try {
            jCurrentTimeMillis = System.currentTimeMillis() - Long.parseLong(this.workspace.getFromSharedPreference("GODEL_EXCEPTION_OFF", String.valueOf(System.currentTimeMillis())));
        } catch (NumberFormatException e2) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.sdkTracker.trackAndLogException(GODEL, "action", LogSubCategory.Action.USER, Labels.User.SHOULD_DISABLE_GODEL, "Failed while parsing number", e2);
            jCurrentTimeMillis = jCurrentTimeMillis2;
        }
        this.sdkTracker.trackAction(LogSubCategory.Action.USER, "info", Labels.User.SHOULD_DISABLE_GODEL, "exception_info", this.workspace.getFromSharedPreference("EXCEPTION_INFO", null));
        if (jCurrentTimeMillis <= jOptLong) {
            return true;
        }
        this.workspace.removeFromSharedPreference("GODEL_EXCEPTION_OFF");
        this.workspace.removeFromSharedPreference("EXCEPTION_OFF");
        return false;
    }

    @Nullable
    private WebResourceResponse shouldExcludeResource(@NonNull String str) throws JSONException {
        String str2;
        Pattern patternCompile = Pattern.compile(".*\\.(gif|jpg|jpeg|png)([;?].*)?$");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        List<Pattern> excludeUrlsPatternList = getExcludeUrlsPatternList();
        if (excludeUrlsPatternList == null) {
            excludeUrlsPatternList = new ArrayList<>();
        }
        Iterator<Pattern> it = excludeUrlsPatternList.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                if (patternCompile.matcher(str).matches()) {
                    str2 = "text/html";
                } else {
                    byteArray = "[blocked]".getBytes();
                    str2 = UtilsKt.MIME_TYPE_TEXT_PLAIN;
                }
                return new WebResourceResponse(str2, "utf-8", new ByteArrayInputStream(byteArray));
            }
        }
        return null;
    }

    @Nullable
    private HashMap<String, String> toMap(@NonNull String str) {
        HashMap<String, String> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (JSONException unused) {
            JuspayLogger.d(LOG_TAG, "Not a json string. Passing as such");
            return null;
        }
    }

    private void turnOffGodelIfNeeded() {
        if (shouldDisableGodel(this.context)) {
            this.paymentSessionInfo.setGodelDisabled(PaymentConstants.GodelOffReasons.ON_GODEL_EXCEPTION);
        }
        if (!PaymentUtils.hasTelephonyService(this.juspayServices)) {
            this.juspayServices.sdkDebug(GODEL, "No telephony service found.. disabling JB");
            this.paymentSessionInfo.setGodelDisabled(PaymentConstants.GodelOffReasons.TELEPHONY_NOT_FOUND);
        }
        PaymentUtils.switchOffGodelIfLowOnMemory(this, this.juspayServices, this.paymentSessionInfo);
    }

    public void addWebView(@Nullable Activity activity, String str) throws JSONException {
        initializeJuspayWebView(this.context);
        FrameLayout frameLayout = this.juspayServices.getContainer() != null ? (FrameLayout) this.juspayServices.getContainer().findViewById(Integer.parseInt(str)) : null;
        if (frameLayout != null || activity == null) {
            this.sdkTracker.trackAction("system", "error", Labels.System.ADD_WEBVIEW, "missing", "activity");
        } else {
            frameLayout = (FrameLayout) activity.findViewById(Integer.parseInt(str));
        }
        if (frameLayout == null) {
            this.sdkTracker.trackAction("system", "error", Labels.System.ADD_WEBVIEW, "missing", "view");
            return;
        }
        if (this.juspayWebView.getParent() == frameLayout) {
            this.sdkTracker.trackAction("system", "warning", Labels.System.ADD_WEBVIEW, "parent", "parent view is same as before");
            return;
        }
        turnOffGodelIfNeeded();
        ViewParent parent = this.juspayWebView.getParent();
        if (parent != null) {
            this.sdkTracker.trackAction("system", "warning", Labels.System.ADD_WEBVIEW, "parent", "already present");
            if (!(parent instanceof ViewGroup)) {
                this.sdkTracker.trackAction("system", "error", Labels.System.ADD_WEBVIEW, "parent", "not a ViewGroup");
                return;
            }
            ((ViewGroup) parent).removeView(this.juspayWebView);
        }
        frameLayout.addView(this.juspayWebView, 0);
    }

    public void exit() {
        ExecutorManager.runOnMainThread(new com.swmansion.gesturehandler.react.b(this, 7));
    }

    @NonNull
    public AcsInterface getAcsInterface() {
        return this.acsInterface;
    }

    @NonNull
    public List<String> getAllowedDeeplinkPackages() {
        return this.allowedDeeplinkPackages;
    }

    @NonNull
    public JSONObject getConfig() {
        return this.config;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    @NonNull
    public DuiInterface getDuiInterface() {
        return this.duiInterface;
    }

    @NonNull
    public JuspayServices getJuspayServices() {
        return this.juspayServices;
    }

    @NonNull
    public JuspayWebView getJuspayWebView() {
        return this.juspayWebView;
    }

    @NonNull
    public PaymentSessionInfo getPaymentSessionInfo() {
        return this.paymentSessionInfo;
    }

    @Nullable
    public JSONObject getWebLabRules() {
        try {
            return this.config.getJSONObject("weblab");
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Unable to find weblab key in config", e2);
            return null;
        }
    }

    public boolean isDuiLoaded() {
        return true;
    }

    public void loadPage() {
        if (this.bundleParameters.has("url")) {
            loadPage("file:///android_assets/juspay/acs_blank.html", null);
        } else {
            loadPage(this.bundleParameters.optString("url"), this.bundleParameters.optString(PaymentConstants.POST_DATA));
        }
    }

    public void onBrowserReady(Activity activity, String str, String str2, String str3) {
        ExecutorManager.runOnMainThread(new i(this, activity, str3, str, str2, 3));
    }

    public void onDuiReady() {
        this.paymentSessionInfo.setGodelManager(this);
        this.juspayServices.getJBridge().attach(PaymentConstants.NETWORK_STATUS, "{}", "");
        setupAllowedDeeplinkPackages();
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.ON_DUI_READY, "class", "HyperFragment");
    }

    public void onDuiReleased() {
        this.sdkTracker.trackAction("system", "info", Labels.System.ON_DUI_RELEASED, "exit_sdk", JSONObject.NULL);
        exit();
        this.paymentSessionInfo.setGodelManager(null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void prepareWebView() throws JSONException {
        this.juspayWebView.getSettings().setJavaScriptEnabled(true);
        this.juspayWebView.getSettings().setDomStorageEnabled(true);
        JSONObject jSONObject = null;
        try {
            jSONObject = this.bundleParameters.getJSONObject(PaymentConstants.PAYLOAD);
            if (jSONObject.optBoolean("godel_receive_merchant_messages")) {
                this.juspayWebView.addJavascriptInterface(new GodelJsInterface(this.juspayServices), "GodelInterface");
            }
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(GODEL, "action", "system", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "Initiate payload is missing", e2);
        }
        this.juspayWebView.setDefaultWebViewClient(this.juspayWebViewClient);
        this.juspayWebView.setDefaultWebChromeClient(this.juspayWebChromeClient);
        this.juspayWebView.getSettings().setAllowFileAccess(true);
        this.juspayWebView.getSettings().setCacheMode(-1);
        this.sdkTracker.trackAction("system", "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "enabling_third_party_cookies", Boolean.TRUE);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.juspayWebView, true);
        if (!this.juspayServices.getJBridge().execute(PaymentConstants.NETWORK_STATUS, "", "{}", "").equals(String.valueOf(true))) {
            this.sdkTracker.trackAction("system", "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "no_network", "Setting web view to load from cache if there is no network");
            this.juspayWebView.getSettings().setCacheMode(1);
        }
        if (this.bundleParameters.has("clearCookies") && this.bundleParameters.optBoolean("clearCookies")) {
            this.sdkTracker.trackAction("system", "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "clearing", "cookies");
            PaymentUtils.clearCookies(this.juspayServices);
        }
        if (jSONObject == null) {
            this.sdkTracker.trackAction("system", "error", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "missing", "JuspayWebView");
            return;
        }
        String strOptString = jSONObject.optString("clientId", "");
        if (this.juspayWebViewConfigurationCallback == null || !isClientWhitelistedForWebViewAccess(strOptString)) {
            return;
        }
        this.juspayWebViewConfigurationCallback.configureJuspayWebView(this.juspayWebView);
        this.sdkTracker.trackAction("system", "info", Labels.System.GODEL_WEBVIEW_WHITELIST, "configured", "JuspayWebView");
    }

    public void resetWebView() {
        JuspayWebView juspayWebView = this.juspayWebView;
        juspayWebView.setDefaultWebChromeClient(juspayWebView.getWebChromeClient());
        JuspayWebView juspayWebView2 = this.juspayWebView;
        juspayWebView2.setDefaultWebViewClient(juspayWebView2.getWebViewClient());
        this.juspayWebView.stopLoading();
        this.juspayWebView.removeJavascriptInterface("ACSGatekeeper");
        this.juspayWebView.clearHistory();
        this.juspayWebView.destroy();
        if (this.juspayWebView.getParent() != null) {
            ((ViewManager) this.juspayWebView.getParent()).removeView(this.juspayWebView);
        }
    }

    public void setConfig(@NonNull JSONObject jSONObject) {
        this.config = jSONObject;
    }

    public void setIsRupaySupportedAdded(boolean z) {
        this.isRupaySupportedAdded = z;
    }

    public void setupAllowedDeeplinkPackages() {
        JSONObject jSONObject = this.processPayload;
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject(PaymentConstants.PAYLOAD) : null;
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("allowedDeepLinkPackages");
        this.allowedDeeplinkPackages.clear();
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                String strOptString = jSONArrayOptJSONArray.optString(i2);
                if (strOptString != null) {
                    this.allowedDeeplinkPackages.add(strOptString);
                }
            }
        }
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull String str) throws IOException {
        try {
            JuspayServices juspayServices = this.juspayServices;
            String str2 = LOG_TAG;
            juspayServices.sdkDebug(str2, "Intercepted URL: " + str);
            if (!URLUtil.isValidUrl(str) || !isAcsToBeAddedToResource(new URL(str)) || this.isRupaySupportedAdded) {
                WebResourceResponse webResourceResponseShouldExcludeResource = shouldExcludeResource(str);
                if (webResourceResponseShouldExcludeResource == null) {
                    return null;
                }
                this.sdkTracker.trackAction("system", "info", Labels.System.UTIL, "url_excluded", str);
                return webResourceResponseShouldExcludeResource;
            }
            URL url = new URL(str);
            this.juspayServices.sdkDebug(str2, "Intercepted URL and modified: " + str);
            setIsRupaySupportedAdded(true);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getAcsScript().getBytes(StandardCharsets.UTF_8));
            try {
                SequenceInputStream sequenceInputStream = new SequenceInputStream(byteArrayInputStream, url.openStream());
                try {
                    WebResourceResponse webResourceResponse = new WebResourceResponse("text/javascript", "utf-8", sequenceInputStream);
                    sequenceInputStream.close();
                    byteArrayInputStream.close();
                    return webResourceResponse;
                } finally {
                }
            } finally {
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Error while Caching Files", e2);
            return null;
        }
    }

    public void onBrowserReady(final Activity activity, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hypersdk.safe.a
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f48709a.lambda$onBrowserReady$1(activity, str6, str, str2, str3, str4, str5);
            }
        });
    }

    public void loadPage(String str, String str2) throws JSONException {
        try {
            this.bundleParameters.put("url", str);
            this.bundleParameters.put(PaymentConstants.POST_DATA, str2);
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(GODEL, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.System.LOAD_PAGE, "Failed to write to JSON bundle parameters", e2);
        }
        if (str2 != null) {
            this.juspayWebView.postUrl(str, str2.getBytes());
        } else {
            this.juspayWebView.loadUrl(str);
        }
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest) throws JSONException {
        Godel godel;
        Exception exc;
        JSONArray jSONArrayOptJSONArray;
        try {
            int i2 = 0;
            try {
                if (this.juspayServices.getSessionInfo().get("inject_acs_into_iframes", "false").equals("true") && webResourceRequest.getMethod().equals(UtilsKt.HTTP_METHOD_GET)) {
                    JSONArray jSONArrayOptJSONArray2 = this.config.optJSONArray("bank_js_urls_v2");
                    if (jSONArrayOptJSONArray2 == null) {
                        try {
                            JSONArray jSONArrayOptJSONArray3 = this.config.optJSONArray("bank_js_urls");
                            if (jSONArrayOptJSONArray3 != null) {
                                while (i2 < jSONArrayOptJSONArray3.length()) {
                                    if (Pattern.compile(jSONArrayOptJSONArray3.getString(i2)).matcher(webResourceRequest.getUrl().toString()).find()) {
                                        return addAcsToJSFile(webResourceRequest, UtilsKt.HTTP_METHOD_GET, ".*\\.jsp?$", new JSONObject(), new JSONObject());
                                    }
                                    i2++;
                                }
                            }
                        } catch (Exception e2) {
                            exc = e2;
                            godel = this;
                            godel.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Exception while adding ACS to js file", exc);
                            return null;
                        }
                    } else {
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            JSONArray jSONArray = jSONArrayOptJSONArray2.getJSONArray(i3);
                            if (Pattern.compile(jSONArray.getString(0)).matcher(webResourceRequest.getUrl().toString()).find()) {
                                return addAcsToJSFile(webResourceRequest, UtilsKt.HTTP_METHOD_GET, jSONArray.getString(1), new JSONObject(), new JSONObject());
                            }
                        }
                    }
                    return null;
                }
                godel = this;
                try {
                    if (!webResourceRequest.getMethod().equals("POST") || (jSONArrayOptJSONArray = godel.config.optJSONArray("post_urls")) == null) {
                        return null;
                    }
                    while (i2 < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                        if (Pattern.compile(jSONObject.getString("url")).matcher(webResourceRequest.getUrl().toString()).find()) {
                            return addAcsToJSFile(webResourceRequest, "POST", jSONObject.getString("file_type"), jSONObject.getJSONObject("headers"), jSONObject.getJSONObject("timeout"));
                        }
                        i2++;
                    }
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    exc = e;
                    godel.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UTIL, "Exception while adding ACS to js file", exc);
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                godel = null;
            }
        } catch (Exception e5) {
            e = e5;
            godel = this;
        }
    }
}
