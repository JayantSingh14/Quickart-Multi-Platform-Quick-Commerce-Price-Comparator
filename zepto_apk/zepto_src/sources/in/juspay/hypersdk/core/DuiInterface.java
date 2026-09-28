package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.airborne.services.RemoteAssetService;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.CallbackInvoker;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.ResultAwaitingDuiHook;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.safe.Godel;
import in.juspay.hypersdk.safe.JuspayWebView;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersmshandler.JuspayDuiHook;
import in.juspay.hypersmshandler.OnResultHook;
import in.juspay.hypersmshandler.SmsEventInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class DuiInterface extends HyperJsInterface implements CallbackInvoker {
    private static final String LOG_TAG = "DuiInterface";

    @Nullable
    protected Activity activity;

    @NonNull
    protected Map<String, String> callBackMapper;

    @Nullable
    protected ViewGroup container;

    @NonNull
    private final Context context;

    @Nullable
    private Godel godelManager;
    private int lastFocusedEditView;

    @NonNull
    protected Map<String, Object> listenerMap;

    @NonNull
    private final ArrayList<Integer> merchantViewIds;

    @NonNull
    private final RemoteAssetService remoteAssetService;

    @NonNull
    private final SdkTracker sdkTracker;

    @NonNull
    protected final SessionInfo sessionInfo;

    /* renamed from: in.juspay.hypersdk.core.DuiInterface$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents;

        static {
            int[] iArr = new int[SmsEventInterface.RetrieverEvents.values().length];
            $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents = iArr;
            try {
                iArr[SmsEventInterface.RetrieverEvents.ON_ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents[SmsEventInterface.RetrieverEvents.ON_EXECUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents[SmsEventInterface.RetrieverEvents.ON_RECEIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DuiInterface(@NonNull JuspayServices juspayServices) {
        super(juspayServices);
        this.merchantViewIds = new ArrayList<>();
        this.lastFocusedEditView = -1;
        this.context = juspayServices.getContext();
        this.sdkTracker = juspayServices.getSdkTracker();
        this.sessionInfo = juspayServices.getSessionInfo();
        this.remoteAssetService = juspayServices.getRemoteAssetService();
        this.listenerMap = new HashMap();
        this.callBackMapper = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attachMerchantView$1(int i2, String str) {
        ViewGroup viewGroup;
        try {
            Activity activity = this.activity;
            ViewGroup viewGroup2 = activity != null ? (ViewGroup) activity.findViewById(i2) : null;
            if (viewGroup2 == null && (viewGroup = this.container) != null) {
                viewGroup2 = (ViewGroup) viewGroup.findViewById(i2);
            }
            HyperPaymentsCallback hyperCallback = this.juspayServices.getHyperCallback();
            if (viewGroup2 == null || hyperCallback == null) {
                return;
            }
            this.merchantViewIds.add(Integer.valueOf(i2));
            View merchantView = hyperCallback.getMerchantView(viewGroup2, MerchantViewType.valueOf(str));
            if (merchantView != null) {
                viewGroup2.addView(merchantView);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error while attaching merchant view", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearMerchantViews$0(Activity activity) {
        Iterator<Integer> it = this.merchantViewIds.iterator();
        while (it.hasNext()) {
            View viewFindViewById = activity.findViewById(it.next().intValue());
            if (viewFindViewById instanceof ViewGroup) {
                ((ViewGroup) viewFindViewById).removeAllViews();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fileDownloadCallback$10(String str, boolean z, String str2, String str3) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("window.callUICallback('");
            sb.append(str);
            sb.append("', '");
            sb.append(z);
            sb.append("', '");
            String strN = android.support.v4.media.a.n(sb, str2, "', '", str3, "');");
            Log.d("FileDownloadCallback", strN);
            this.juspayServices.addJsToWebView(strN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadUrl$6(String str, JuspayWebView juspayWebView, String str2) {
        if (str != null) {
            juspayWebView.postUrl(str2, str.getBytes());
        } else {
            juspayWebView.loadUrl(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDuiReady$2() {
        if (this.godelManager != null) {
            return;
        }
        Godel godel = new Godel(this.juspayServices);
        this.godelManager = godel;
        godel.setupAllowedDeeplinkPackages();
        this.godelManager.onDuiReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeyboardHide$9() {
        try {
            Activity activity = this.activity;
            if (activity != null) {
                View currentFocus = activity.getCurrentFocus();
                if (currentFocus == null) {
                    currentFocus = this.activity.getWindow().getDecorView();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
                if (inputMethodManager == null || currentFocus.getRootView() == null) {
                    this.sdkTracker.trackAction("system", "error", Labels.System.KEYBOARD, "hidden", "failed");
                } else {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getRootView().getWindowToken(), 0);
                    this.sdkTracker.trackAction("system", "info", Labels.System.KEYBOARD, "hidden", APayConstants.SUCCESS);
                }
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.KEYBOARD, "Hide Keyboard Exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeyboardShow$7(String str) throws NumberFormatException {
        try {
            if (this.activity != null) {
                int i2 = Integer.parseInt(str);
                InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
                View viewFindViewById = this.activity.findViewById(i2);
                int i3 = this.lastFocusedEditView;
                View viewFindViewById2 = i3 != -1 ? this.activity.findViewById(i3) : null;
                if (inputMethodManager != null && viewFindViewById != null) {
                    if (viewFindViewById2 != null && this.lastFocusedEditView != i2) {
                        viewFindViewById2.clearFocus();
                    }
                    viewFindViewById.requestFocus();
                    inputMethodManager.showSoftInput(viewFindViewById, 1);
                }
                if (i2 != this.lastFocusedEditView) {
                    this.lastFocusedEditView = Integer.parseInt(str);
                }
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.KEYBOARD, "Show Keyboard Exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInJuspayBrowser$3(String str, SdkTracker sdkTracker) {
        Activity activity = this.activity;
        if (activity != null) {
            try {
                View viewFindViewById = activity.findViewById(Integer.parseInt(str));
                if (this.juspayServices.getHyperCallback() != null) {
                    this.juspayServices.getHyperCallback().onStartWaitingDialogCreated(viewFindViewById);
                }
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "Exception while trying to find a view", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInJuspayBrowser$4(String str, final String str2, final SdkTracker sdkTracker) {
        try {
            if (this.juspayServices.getHyperCallback() != null) {
                this.juspayServices.getHyperCallback().onEvent(new JSONObject(str), new JuspayResponseHandler() { // from class: in.juspay.hypersdk.core.DuiInterface.2
                    @Override // in.juspay.hypersdk.data.JuspayResponseHandler
                    public void onError(String str3) throws JSONException {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(CLConstants.OTP_STATUS, "onError");
                            try {
                                jSONObject.put(PaymentConstants.PAYLOAD, new JSONObject(str3));
                            } catch (Exception unused) {
                                jSONObject.put(PaymentConstants.PAYLOAD, str3);
                            }
                            DuiInterface.this.invokeCallbackInDUIWebview(str2, jSONObject.toString());
                        } catch (Exception e2) {
                            sdkTracker.trackAndLogException(DuiInterface.LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "Exception while manipulating JSON", e2);
                        }
                    }

                    @Override // in.juspay.hypersdk.data.JuspayResponseHandler
                    public void onResponse(String str3) throws JSONException {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(CLConstants.OTP_STATUS, "onResponse");
                            try {
                                jSONObject.put(PaymentConstants.PAYLOAD, new JSONObject(str3));
                            } catch (Exception unused) {
                                jSONObject.put(PaymentConstants.PAYLOAD, str3);
                            }
                            DuiInterface.this.invokeCallbackInDUIWebview(str2, jSONObject.toString());
                        } catch (Exception e2) {
                            sdkTracker.trackException("lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "Exception while manipulating JSON", e2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                    }

                    @Override // in.juspay.hypersdk.data.JuspayResponseHandler
                    public void onResponse(Bundle bundle) throws JSONException {
                        onResponse(Utils.toJSON(bundle).toString());
                    }
                });
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "Exception in onEvent handler", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInJuspayWebView$5(String str, JuspayWebView juspayWebView) {
        str.getClass();
        switch (str) {
            case "requestPhoneKeyboardShow":
                juspayWebView.requestPhoneKeyboardShow();
                break;
            case "requestNumericKeyboardShow":
                juspayWebView.requestNumericKeyboardShow();
                break;
            case "requestPasswordKeyboardShow":
                juspayWebView.requestPasswordKeyboardShow();
                break;
            case "goBack":
                juspayWebView.goBack();
                break;
            case "reload":
                PaymentUtils.refreshPage(juspayWebView);
                break;
            case "goForward":
                juspayWebView.goForward();
                break;
            case "loadFirstPage":
                Godel godel = this.godelManager;
                if (godel != null) {
                    godel.loadPage();
                    break;
                }
                break;
            default:
                this.juspayServices.getSdkTracker().trackAction("system", "error", Labels.System.RUN_IN_JUSPAY_WEBVIEW, "missing", str);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$suppressKeyboard$8() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.getWindow().setSoftInputMode(3);
        }
    }

    private void trackWebViewEvent(String str) {
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", str, APayConstants.Error.MESSAGE, "Received event from web view.");
    }

    @JavascriptInterface
    public void addDataToSharedPrefs(String str, String str2) {
        this.workspace.writeToSharedPreference(str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attach(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.attach(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public void attachMerchantView(int i2, String str) {
        if (this.juspayServices.getHyperCallback() != null) {
            ExecutorManager.runOnMainThread(new f(this, i2, str));
        }
    }

    @Override // in.juspay.hypersdk.core.HyperJsInterface
    @JavascriptInterface
    public String checkPermission(String[] strArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : strArr) {
                jSONObject.put(str.replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, str));
            }
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.READ_SMS_PERMISSION, "Error while inserting in json", e2);
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String checkReadSMSPermission() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("android.permission.READ_SMS".replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, "android.permission.READ_SMS"));
            jSONObject.put("android.permission.RECEIVE_SMS".replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, "android.permission.RECEIVE_SMS"));
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.READ_SMS_PERMISSION, "Error while inserting in json", e2);
        }
        return jSONObject.toString();
    }

    public void clearMerchantViews(Activity activity) {
        if (activity == null) {
            return;
        }
        ExecutorManager.runOnMainThread(new l(2, this, activity));
    }

    @JavascriptInterface
    public void closeBrowser(String str) {
        reset();
    }

    @JavascriptInterface
    public void detach(String[] strArr) {
        JuspayDuiHook juspayDuiHook;
        for (String str : strArr) {
            if (this.listenerMap.containsKey(str) && this.activity != null) {
                if ((this.listenerMap.get(str) instanceof JuspayDuiHook) && (juspayDuiHook = (JuspayDuiHook) this.listenerMap.get(str)) != null) {
                    juspayDuiHook.detach(this.activity);
                }
                this.listenerMap.remove(str);
            }
        }
    }

    @JavascriptInterface
    public void doHandShake(String str, String str2) throws JSONException {
        String str3;
        Exception exc;
        String string;
        String string2;
        int i2;
        Bundle bundle;
        try {
            this.sdkTracker.trackAction("system", "info", Labels.System.JBRIDGE, "dui_interface_do_handshake", "Doing handshake with following parameters: " + str);
            JSONObject jSONObject = new JSONObject(str);
            string = jSONObject.getString("packageName");
            string2 = jSONObject.getString("className");
            i2 = jSONObject.getInt("code");
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(PaymentConstants.PAYLOAD));
            bundle = new Bundle();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject2.getString(next));
                } catch (Exception e2) {
                    exc = e2;
                    str3 = str2;
                    MPINUtil.reportBindFailure(-1, this.juspayServices, str3);
                    this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception at doHandShake", exc);
                }
            }
            str3 = str2;
        } catch (Exception e3) {
            e = e3;
            str3 = str2;
        }
        try {
            MPINUtil.communicate(string, string2, i2, bundle, this.juspayServices, str3);
        } catch (Exception e4) {
            e = e4;
            exc = e;
            MPINUtil.reportBindFailure(-1, this.juspayServices, str3);
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception at doHandShake", exc);
        }
    }

    @JavascriptInterface
    public void enableWebViewRecreate(String str) {
        this.juspayServices.getDynamicUI().setWebViewRecreate(str.equals("true"));
    }

    @JavascriptInterface
    public String execute(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!this.listenerMap.containsKey(str) || this.activity == null) {
                return "";
            }
            JuspayDuiHook juspayDuiHook = (JuspayDuiHook) this.listenerMap.get(str);
            if (juspayDuiHook == null) {
                return "__failed";
            }
            if (PaymentConstants.SMS_RETRIEVER.equals(str)) {
                if ("getOtp".equals(str2)) {
                    this.callBackMapper.put(PaymentConstants.SMS_RETRIEVER + SmsEventInterface.RetrieverEvents.ON_RECEIVE, str4);
                } else if ("cancel".equals(str2)) {
                    this.callBackMapper.put(PaymentConstants.SMS_RETRIEVER + SmsEventInterface.RetrieverEvents.ON_RECEIVE, null);
                }
            }
            return juspayDuiHook.execute(this.activity, str2, jSONObject);
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, androidx.fragment.app.e.p("Error while executing ", str2, " with args ", str3), e2);
            return "";
        }
    }

    @JavascriptInterface
    public String fetchFromInbox(String str) {
        return this.juspayServices.getSmsServices().fetchSms(str, "inbox", null);
    }

    @JavascriptInterface
    public void fetchSMS(String str, String str2, String str3, String str4) {
        invokeCallbackInDUIWebview(str4, this.juspayServices.getSmsServices().fetchSms(str, str2, str3));
    }

    public RemoteAssetService.DownloadCallback fileDownloadCallback(String str) {
        return new p(this, str);
    }

    @JavascriptInterface
    public String findViewType(String str) {
        Activity activity;
        try {
            View viewFindViewById = this.juspayServices.getContainer() != null ? this.juspayServices.getContainer().findViewById(Integer.parseInt(str)) : null;
            if (viewFindViewById == null && (activity = this.activity) != null) {
                viewFindViewById = activity.findViewById(Integer.parseInt(str));
            }
            return viewFindViewById != null ? viewFindViewById.getClass().getName() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String getActivityData(String str) {
        return this.juspayServices.getDynamicUI().getActivityData(str);
    }

    @JavascriptInterface
    public String getClipboardItems() {
        return "[]";
    }

    @JavascriptInterface
    public String getConfigVariables() {
        try {
            return PaymentUtils.getConfigVariableDeclarations(this.juspayServices.getContext(), this.juspayServices.getSessionInfo(), this.juspayServices.getTenant());
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "", e2);
            return "var clientId = null;var juspayDeviceId = null;var juspayAndroidId = null;var godelRemotesVersion = null;var godelVersion = null;var buildVersion = null;var os_version = null;";
        }
    }

    @JavascriptInterface
    public String getDataFromSharedPrefs(String str, String str2) {
        return this.workspace.getFromSharedPreference(str, str2);
    }

    @JavascriptInterface
    public String getIndexBundleHash(String str) {
        String strReplace = str.replace(".zip", ".jsa");
        try {
            return this.remoteAssetService.getMetadata(strReplace.substring(strReplace.lastIndexOf("/") + 1).replace(".zip", ".jsa")).getString("hashInDisk");
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "exception during IndexBundleHash", e2);
            return null;
        }
    }

    @JavascriptInterface
    public String getKeysInSharedPrefs() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.workspace.getKeysInSharedPreference().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.SHARED_PREF, "Exception while getting all keys from shared prefs", e2);
            return "[]";
        }
    }

    @JavascriptInterface
    public String getNetworkType() {
        return this.sessionInfo.getNetworkInfo();
    }

    @JavascriptInterface
    public String getPackageInfo(String str) throws JSONException, PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = this.juspayServices.getContext().getPackageManager().getPackageInfo(str, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("packageName", packageInfo.packageName);
            jSONObject.put("versionName", packageInfo.versionName);
            jSONObject.put("versionCode", packageInfo.versionCode);
            return jSONObject.toString();
        } catch (Exception e2) {
            this.sdkTracker.trackAction("system", "debug", Labels.System.JBRIDGE, "Exception at getPackageInfo", e2);
            return "{}";
        }
    }

    @JavascriptInterface
    public String getPaymentDetails() {
        return this.juspayServices.getPaymentSessionInfo().getPaymentDetails().toString();
    }

    @JavascriptInterface
    public float getPixels() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    @JavascriptInterface
    public int getResourceIdentifier(String str, String str2) {
        try {
            return this.context.getResources().getIdentifier(str, str2, this.context.getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    @JavascriptInterface
    public String getSessionAttribute(String str) {
        return getSessionAttribute(str, "");
    }

    @JavascriptInterface
    public String getSessionDetails() {
        return this.juspayServices.getPaymentSessionInfo().getSessionDetails().toString();
    }

    @Override // in.juspay.hypersdk.core.JsInterface
    @JavascriptInterface
    public String getSessionInfo() {
        this.juspayServices.getPaymentSessionInfo().createSessionDataMap();
        return this.sessionInfo.getSessionData().toString();
    }

    public SmsEventInterface getSmsEventInterface() {
        return new SmsEventInterface() { // from class: in.juspay.hypersdk.core.DuiInterface.1
            @Override // in.juspay.hypersmshandler.SmsEventInterface
            public void onActivityResultEvent(@NonNull String str) {
                DuiInterface duiInterface = DuiInterface.this;
                duiInterface.invokeCallbackInDUIWebview(duiInterface.callBackMapper.get(PaymentConstants.SMS_CONSENT), str);
            }

            @Override // in.juspay.hypersmshandler.SmsEventInterface
            public void onSentReceiverEvent(int i2) {
                String strK;
                if (DuiInterface.this.callBackMapper.get(PaymentConstants.SEND_SMS) != null) {
                    String str = "window.callUICallback(\"" + DuiInterface.this.callBackMapper.get(PaymentConstants.SEND_SMS);
                    if (i2 == -1) {
                        Toast.makeText(DuiInterface.this.context, "SMS SENT", 0).show();
                        strK = str + "\", \"SUCCESS\")";
                    } else if (i2 == 1) {
                        Toast.makeText(DuiInterface.this.context, "SMS GENERIC FAILURE", 0).show();
                        strK = str + "\", \"Generic failure\", \"837\")";
                    } else if (i2 == 2) {
                        Toast.makeText(DuiInterface.this.context, "SMS RADIO OFF", 0).show();
                        strK = str + "\", \"Radio off\", \"840\")";
                    } else if (i2 == 3) {
                        Toast.makeText(DuiInterface.this.context, "SMS NULL PDU", 0).show();
                        strK = str + "\", \"Null PDU\", \"839\")";
                    } else if (i2 != 4) {
                        strK = android.support.v4.media.b.k(str, "\", \"Unable to Send SMS\", \"837\")");
                    } else {
                        Toast.makeText(DuiInterface.this.context, "SMS NO SERVICE", 0).show();
                        strK = str + "\", \"No service\", \"838\")";
                    }
                    DuiInterface.this.invokeFnInDUIWebview(strK);
                }
            }

            @Override // in.juspay.hypersmshandler.SmsEventInterface
            public void onSmsConsentEvent(@NonNull Intent intent, int i2, @Nullable Bundle bundle) {
                DuiInterface.this.juspayServices.startActivityForResult(intent, i2, bundle);
                DuiInterface.this.invokeFnInDUIWebview("onSMSConsentShown", "{ }");
            }

            @Override // in.juspay.hypersmshandler.SmsEventInterface
            public void onSmsReceiverEvent(@NonNull String str) {
                DuiInterface duiInterface = DuiInterface.this;
                duiInterface.invokeCallbackInDUIWebview(duiInterface.callBackMapper.get(PaymentConstants.SMS_RECEIVE), str);
            }

            @Override // in.juspay.hypersmshandler.SmsEventInterface
            public void onSmsRetrieverEvent(@NonNull SmsEventInterface.RetrieverEvents retrieverEvents, @NonNull String str) {
                int i2 = AnonymousClass3.$SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents[retrieverEvents.ordinal()];
                if (i2 == 1) {
                    DuiInterface duiInterface = DuiInterface.this;
                    duiInterface.invokeCallbackInDUIWebview(duiInterface.callBackMapper.get(PaymentConstants.SMS_RETRIEVER + SmsEventInterface.RetrieverEvents.ON_ATTACH), str);
                    return;
                }
                if (i2 == 2) {
                    DuiInterface duiInterface2 = DuiInterface.this;
                    duiInterface2.invokeCallbackInDUIWebview(duiInterface2.callBackMapper.get(PaymentConstants.SMS_RETRIEVER + SmsEventInterface.RetrieverEvents.ON_RECEIVE), str);
                    return;
                }
                if (i2 != 3) {
                    return;
                }
                DuiInterface duiInterface3 = DuiInterface.this;
                Map<String, String> map = duiInterface3.callBackMapper;
                StringBuilder sb = new StringBuilder(PaymentConstants.SMS_RETRIEVER);
                SmsEventInterface.RetrieverEvents retrieverEvents2 = SmsEventInterface.RetrieverEvents.ON_RECEIVE;
                sb.append(retrieverEvents2);
                duiInterface3.invokeCallbackInDUIWebview(map.get(sb.toString()), str);
                if ("TIMEOUT".equals(str)) {
                    return;
                }
                DuiInterface.this.callBackMapper.put(PaymentConstants.SMS_RETRIEVER + retrieverEvents2, null);
            }
        };
    }

    @JavascriptInterface
    public void invokeCallbackInACSWebview(String str, String str2) {
        if (this.godelManager == null) {
            return;
        }
        this.godelManager.getJuspayWebView().addJsToWebView(android.support.v4.media.b.m("window.__PROXY_FN['", str, "'](atob('", Base64.encodeToString(str2.getBytes(), 2), "'))"));
    }

    @Override // in.juspay.hyper.core.CallbackInvoker
    @JavascriptInterface
    public void invokeCallbackInDUIWebview(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "null";
        }
        this.juspayServices.getDynamicUI().addJsToWebView(android.support.v4.media.b.m("window.callUICallback('", str, "',atob('", Base64.encodeToString(str2.getBytes(), 2), "'));"));
    }

    @JavascriptInterface
    public void invokeCustomFnInDUIWebview(String str) {
        this.juspayServices.getDynamicUI().addJsToWebView(str);
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str, String str2, String str3) {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.getAcsInterface().invoke(str, str2, str3);
        }
    }

    @JavascriptInterface
    public void invokeInACSWebview(String str, String str2, String str3) {
        if (this.godelManager == null) {
            return;
        }
        this.godelManager.getJuspayWebView().addJsToWebView(android.support.v4.media.b.r(androidx.fragment.app.e.v("javascript:window.onAcsFunctionCalled('", str, "',atob('", Base64.encodeToString(str2.getBytes(), 2), "'),'"), str3, "')"));
    }

    @JavascriptInterface
    public String isAppInstalled(String str) throws PackageManager.NameNotFoundException {
        try {
            this.juspayServices.getContext().getPackageManager().getPackageInfo(str, 128);
            return "true";
        } catch (PackageManager.NameNotFoundException unused) {
            return "false";
        }
    }

    @JavascriptInterface
    public String isDeviceSecure() {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
            return keyguardManager != null ? keyguardManager.isDeviceSecure() ? "SECURE" : "NOT_SECURE" : "UNKNOWN";
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while checking KeyguardManager.isDeviceSecure()", e2);
            return "UNKNOWN";
        }
    }

    @JavascriptInterface
    public boolean isHookSupported(String str) {
        str.getClass();
        switch (str) {
            case "NETWORK_STATUS":
            case "SMS_CONSENT":
            case "SMS_RECEIVE":
            case "SMS_RETRIEVER":
            case "DELIVER_SMS":
            case "SEND_SMS":
                return true;
            default:
                return false;
        }
    }

    @JavascriptInterface
    public boolean isOnline() {
        NetworkInfo activeNetworkInfo;
        Activity activity = this.activity;
        ConnectivityManager connectivityManager = activity != null ? (ConnectivityManager) activity.getSystemService("connectivity") : null;
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    @JavascriptInterface
    public boolean isPermissionDeclaredInManifest(String str) {
        if (str == null) {
            this.sdkTracker.trackAction("system", "warning", Labels.System.PERMISSION, "isPermissionDeclaredInManifest called with null permission", JSONObject.NULL);
            return false;
        }
        try {
            String[] strArr = this.juspayServices.getContext().getPackageManager().getPackageInfo(this.juspayServices.getContext().getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (TextUtils.equals(str2, str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception in isPermissionDeclaredInManifest : ", e2);
            return false;
        }
    }

    @JavascriptInterface
    public void loadUrl(String str, @Nullable String str2) {
        Godel godel = this.godelManager;
        if (godel == null || str == null) {
            return;
        }
        ExecutorManager.runOnMainThread(new r(str2, godel.getJuspayWebView(), str));
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        for (Object obj : this.listenerMap.values()) {
            if ((obj instanceof ResultAwaitingDuiHook) && ((ResultAwaitingDuiHook) obj).onActivityResult(i2, i3, intent)) {
                this.sdkTracker.trackAction("system", "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Result consumed by ResultAwaitingDuiHook ".concat(obj.getClass().getName()));
                return;
            } else if ((obj instanceof OnResultHook) && ((OnResultHook) obj).onActivityResult(i2, i3, intent)) {
                this.sdkTracker.trackAction("system", "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Result consumed by OnResultHook ".concat(obj.getClass().getName()));
                return;
            }
        }
        if (intent == null) {
            this.sdkTracker.trackAction("system", "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Got empty data in onActivityResult. Passing callback to micro-app.");
            invokeFnInDUIWebview(android.support.v4.media.b.e(i2, i3, "window.onActivityResult('", "', '", "', '{}')"));
            return;
        }
        JSONObject json = Utils.toJSON(intent.getExtras());
        String strEncodeToString = Base64.encodeToString(json.toString().getBytes(), 2);
        this.sdkTracker.trackAction("system", "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Passing data to micro-app. Data is " + json);
        StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "window.onActivityResult('", "', '", "', atob('");
        sbT.append(strEncodeToString);
        sbT.append("'))");
        invokeFnInDUIWebview(sbT.toString());
    }

    @JavascriptInterface
    public void onDuiReady() {
        ExecutorManager.runOnMainThread(new o(this, 1));
    }

    @Override // in.juspay.hypersdk.core.HyperJsInterface
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) throws JSONException {
        try {
            Object obj = this.listenerMap.get("ReqPermi" + i2);
            if (obj instanceof String) {
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    jSONObject.put(strArr[i3].replace("android.permission.", ""), iArr[i3] == 0);
                }
                invokeCallbackInDUIWebview((String) obj, jSONObject.toString());
                return;
            }
            if (obj instanceof Handler.Callback) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = iArr;
                ((Handler.Callback) obj).handleMessage(messageObtain);
            } else {
                JuspayLogger.e(LOG_TAG, "callback instance not understandable");
                this.sdkTracker.trackAction("system", "error", Labels.System.ON_REQUEST_PERMISSION_RESULT, obj + " : onRequestPermissionsResult callback instance not understandable", JSONObject.NULL);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.ON_REQUEST_PERMISSION_RESULT, "Error while inserting in json", e2);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2, String str3, String str4) {
        if (!str4.equalsIgnoreCase("base64")) {
            Godel godel = this.godelManager;
            if (godel != null) {
                godel.onBrowserReady(this.activity, str2, str3, "text/html", "UTF-8", null, str);
                return;
            }
            return;
        }
        try {
            byte[] bArrDecode = Base64.decode(str3, 2);
            Godel godel2 = this.godelManager;
            if (godel2 != null) {
                godel2.onBrowserReady(this.activity, str2, new String(bArrDecode), "text/html", "UTF-8", null, str);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.ON_WEBVIEW_READY, "Exception while trying to decode content", e2);
        }
    }

    @JavascriptInterface
    public void onWebViewReleased() {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.onDuiReleased();
            this.godelManager = null;
        }
    }

    @JavascriptInterface
    public void openAppWithAction(String str, String str2, String str3, int i2, int i3, String str4) {
        try {
            if (str == null || str2 == null || str3 == null) {
                invokeCallbackInDUIWebview(str4, "Invalid parameters.");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setFlags(i2);
            intent.putExtra(str2, str3);
            this.juspayServices.startActivityForResult(intent, i3, null);
        } catch (Exception e2) {
            invokeCallbackInDUIWebview(str4, e2.toString());
        }
    }

    @JavascriptInterface
    public void openAppWithExplicitIntent(String str, String str2, String str3, int i2, int i3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("data", str3);
            Intent intent = new Intent();
            if (i3 >= 0) {
                intent.setFlags(i3);
            }
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName(str, str2));
            this.juspayServices.startActivityForResult(intent, Math.max(i2, -1), null);
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "on method openAppWithExplicitIntent: ", e2);
        }
    }

    @JavascriptInterface
    public void refreshPage() {
        Godel godel = this.godelManager;
        if (godel == null) {
            return;
        }
        PaymentUtils.refreshPage(godel.getJuspayWebView());
    }

    @JavascriptInterface
    public void requestKeyboardHide() {
        ExecutorManager.runOnMainThread(new o(this, 0));
    }

    @JavascriptInterface
    public void requestKeyboardShow() {
        Godel godel = this.godelManager;
        if (godel == null) {
            return;
        }
        JuspayWebView juspayWebView = godel.getJuspayWebView();
        InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(juspayWebView, 1);
        }
    }

    @JavascriptInterface
    public void requestPermission(String[] strArr, String str, String str2) {
        this.juspayServices.requestPermission(strArr, Integer.parseInt(str));
        this.listenerMap.put("ReqPermi" + str, str2);
    }

    @JavascriptInterface
    public void requestSMSPermission(String str) {
        requestPermission(new String[]{"android.permission.READ_SMS", "android.permission.RECEIVE_SMS"}, String.valueOf(7), str);
    }

    public void reset() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.listenerMap.keySet()) {
                if (this.listenerMap.get(str) instanceof JuspayDuiHook) {
                    arrayList.add(str);
                }
            }
            detach((String[]) arrayList.toArray(new String[0]));
            Godel godel = this.godelManager;
            if (godel != null) {
                godel.onDuiReleased();
                this.godelManager = null;
            }
            this.container = null;
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while removing Dui Hooks", e2);
        }
    }

    @JavascriptInterface
    public void revokePermissions(String[] strArr) {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    arrayList.add(str);
                }
                this.context.revokeSelfPermissionsOnKill(arrayList);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.PERMISSION, "Error while revoking permission", e2);
        }
    }

    @JavascriptInterface
    public void runInJuspayBrowser(String str, String str2, String str3) throws JSONException {
        int i2;
        int i3;
        SdkTracker sdkTracker;
        JSONObject jSONObject;
        JSONObject bundleParameters;
        i2 = 3;
        i3 = 0;
        sdkTracker = this.juspayServices.getSdkTracker();
        str.getClass();
        switch (str) {
            case "onHtmlReady":
                trackWebViewEvent(Labels.HyperSdk.ON_HTML_READY);
                this.juspayServices.getDynamicUI().setWebViewActive();
                break;
            case "onBundleLoaded":
                updateLoaded(str2, "loaded");
                break;
            case "onError":
                updateLoaded(str2, "not_loaded");
                break;
            case "onEvent":
                if (!this.juspayServices.isPrefetch()) {
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (JSONException e2) {
                        sdkTracker.trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "error while dealing with json onEvent", e2);
                    }
                    if (!jSONObject.optString("event", "").equals("onJOSReady")) {
                        if (jSONObject.optString("action", "").equals("DUI_READY")) {
                            trackWebViewEvent(Labels.HyperSdk.DUI_READY);
                        }
                        ExecutorManager.runOnMainThread(new h(this, str2, str3, sdkTracker, 4));
                        break;
                    } else {
                        trackWebViewEvent(Labels.HyperSdk.ON_JOS_READY);
                        if (this.juspayServices.getBundleParameters() != null) {
                            JuspayServices juspayServices = this.juspayServices;
                            juspayServices.onMerchantEvent(Labels.HyperSdk.INITIATE, juspayServices.getBundleParameters());
                            break;
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (Objects.equals(jSONObject2.optString("event"), "prefetch_result")) {
                            JuspayServices juspayServices2 = this.juspayServices;
                            Objects.requireNonNull(juspayServices2);
                            ExecutorManager.runOnMainThread(new n(juspayServices2, i3));
                        }
                        if (jSONObject2.getString("event").equals("onJOSReady") && (bundleParameters = this.juspayServices.getBundleParameters()) != null) {
                            invokeCustomFnInDUIWebview("window.onMerchantEvent('prefetch',atob('" + Base64.encodeToString(bundleParameters.toString().getBytes(), 2) + "'));");
                            break;
                        }
                    } catch (JSONException e3) {
                        sdkTracker.trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, android.support.v4.media.b.C("error while dealing with json onEvent ", str2), e3);
                        return;
                    }
                }
                break;
            case "onStartWaitingDialogCreated":
                ExecutorManager.runOnMainThread(new r((JsInterface) this, str2, (Object) sdkTracker, i2));
                break;
            case "onScriptError":
                try {
                    JSONObject jSONObject3 = new JSONObject(str2);
                    sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", Labels.HyperSdk.ON_SCRIPT_ERROR, APayConstants.Error.MESSAGE, "Failed to load script for app: '" + jSONObject3.optString(in.juspay.airborne.ota.Constants.APP_DIR, "") + "', due to error: " + jSONObject3.optString("serializedError", ""));
                    break;
                } catch (JSONException e4) {
                    sdkTracker.trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "error while dealing with json onEvent", e4);
                    return;
                }
            default:
                sdkTracker.trackAction("system", "error", Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "missing", str);
                break;
        }
    }

    @JavascriptInterface
    public void runInJuspayWebView(String str, String str2) {
    }

    public void setActivity(@Nullable Activity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void setCardBrand(String str) {
        this.juspayServices.getPaymentSessionInfo().setPaymentDetails("card_brand", str);
    }

    @JavascriptInterface
    public void setConfig(String str) {
        if (this.godelManager == null) {
            return;
        }
        try {
            this.godelManager.setConfig(new JSONObject(str));
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error while capturing config json", e2);
        }
    }

    public void setContainer(@Nullable ViewGroup viewGroup) {
        this.container = viewGroup;
    }

    @JavascriptInterface
    public void setIsRupaySupportedAdded(boolean z) {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.setIsRupaySupportedAdded(z);
        }
    }

    @JavascriptInterface
    public void setSessionDetails(String str, String str2) {
        this.juspayServices.getPaymentSessionInfo().addToSessionDetails(str, str2);
    }

    @JavascriptInterface
    public void setSessionInfo() {
    }

    @Nullable
    @JavascriptInterface
    public String shouldShowRequestPermissionRationale(String str) {
        try {
            Activity activity = this.activity;
            if (activity != null) {
                return String.valueOf(activity.shouldShowRequestPermissionRationale(str));
            }
            return null;
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.PERMISSION, "Exception while checking shouldShowRequestPermissionRationale", e2);
            return null;
        }
    }

    @JavascriptInterface
    public void storeActivityData(String str, String str2) {
        this.juspayServices.getDynamicUI().storeActivityData(str, str2);
    }

    @JavascriptInterface
    public void storeCookies() {
        CookieSyncManager.getInstance().sync();
    }

    @JavascriptInterface
    public void suppressKeyboard() {
        ExecutorManager.runOnMainThread(new o(this, 2));
    }

    @JavascriptInterface
    public void updateLoaded(String str, String str2) throws JSONException {
        String string;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        string = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            string = jSONObject.has("fileName") ? jSONObject.getString("fileName") : "";
            JSONObject jSONObject2 = new JSONObject(getDataFromSharedPrefs(PaymentConstants.JP_HASH_AND_STATUS, "{}"));
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2.has(string)) {
                jSONObject3 = jSONObject2.getJSONObject(string);
            } else {
                sdkTracker.trackAction("system", LogLevel.CRITICAL, "auto_fallback", "loaded", "hash doesn't have a filename");
            }
            jSONObject3.put(CLConstants.OTP_STATUS, str2);
            jSONObject2.put(string, jSONObject3);
            addDataToSharedPrefs(PaymentConstants.JP_HASH_AND_STATUS, jSONObject2.toString());
            JuspayLogger.d(LOG_TAG, "udpateLoaded: ");
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, "auto_fallback", android.support.v4.media.b.C("Exception while updating the loaded status for file ", string), e2);
        }
    }

    @JavascriptInterface
    public void runInJuspayWebView(String str) {
        Godel godel = this.godelManager;
        if (godel == null) {
            return;
        }
        ExecutorManager.runOnMainThread(new r((JsInterface) this, str, (Object) godel.getJuspayWebView(), 2));
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str, String str2) {
        this.juspayServices.getDynamicUI().addJsToWebView(android.support.v4.media.b.m("window[\"onEvent'\"]('", str, "',atob('", Base64.encodeToString(str2.getBytes(), 2), "'))"));
    }

    public void requestPermission(String[] strArr, String str, Handler.Callback callback) {
        this.juspayServices.requestPermission(strArr, Integer.parseInt(str));
        this.listenerMap.put("ReqPermi" + str, callback);
    }

    @JavascriptInterface
    public void requestKeyboardShow(String str) {
        ExecutorManager.runOnMainThread(new l(3, this, str));
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2) {
        if (URLUtil.isValidUrl(str2)) {
            onWebViewReady(str, str2, null);
        } else {
            this.sdkTracker.trackAction("system", "error", Labels.System.ON_WEBVIEW_READY, "valid_url", Boolean.FALSE);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2, String str3) {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.onBrowserReady(this.activity, str2, str3, str);
        }
    }

    @Override // in.juspay.hyper.core.CallbackInvoker
    @JavascriptInterface
    public void invokeFnInDUIWebview(@NonNull String str) {
        invokeCustomFnInDUIWebview(str);
    }

    @JavascriptInterface
    public void invokeInACSWebview(String str, String str2) {
        if (this.godelManager == null) {
            return;
        }
        this.godelManager.getJuspayWebView().addJsToWebView(android.support.v4.media.b.m("javascript:window.onAcsFunctionCalled('", str, "',atob('", Base64.encodeToString(str2.getBytes(), 2), "'))"));
    }
}
