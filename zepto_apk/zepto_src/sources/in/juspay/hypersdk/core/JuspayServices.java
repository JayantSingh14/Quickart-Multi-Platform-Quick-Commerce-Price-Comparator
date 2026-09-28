package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import in.juspay.airborne.HyperOTAServices;
import in.juspay.airborne.TrackerCallback;
import in.juspay.airborne.ota.ApplicationManager;
import in.juspay.airborne.ota.ReleaseConfigCallback;
import in.juspay.airborne.services.FileProviderService;
import in.juspay.airborne.services.RemoteAssetService;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.bridge.BridgeList;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.CallbackInvoker;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.FileProviderInterface;
import in.juspay.hyper.core.FragmentHooks;
import in.juspay.hyper.core.IWorkspace;
import in.juspay.hyper.core.JsCallback;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.SessionInfoInterface;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hyperalipay.AlipayBridge;
import in.juspay.hyperapay.APayBridge;
import in.juspay.hyperapayupi.APayUPIBridge;
import in.juspay.hyperbiometric.FIDOAuthManagerBridge;
import in.juspay.hypercredunbundle.CredUnbundleBridge;
import in.juspay.hypergpay.GPayBridge;
import in.juspay.hypergpayintl.GPayIntlBridge;
import in.juspay.hypernfc.NfcBridge;
import in.juspay.hyperpaypal.PaypalBridge;
import in.juspay.hyperpayu.PayUBridge;
import in.juspay.hyperqr.QrBridge;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.analytics.LogManager;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.data.SdkInfo;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.lifecycle.ActivityResultHolder;
import in.juspay.hypersdk.lifecycle.EventListener;
import in.juspay.hypersdk.lifecycle.FragmentEvent;
import in.juspay.hypersdk.lifecycle.HyperActivityLaunchDelegate;
import in.juspay.hypersdk.lifecycle.HyperFragment;
import in.juspay.hypersdk.lifecycle.HyperIntentSenderDelegate;
import in.juspay.hypersdk.lifecycle.HyperRequestPermissionDelegate;
import in.juspay.hypersdk.lifecycle.RequestPermissionResult;
import in.juspay.hypersdk.mystique.Callback;
import in.juspay.hypersdk.ota.Mode;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersimpl.SimplBridge;
import in.juspay.hypersmshandler.SmsComponents;
import in.juspay.hypersmshandler.SmsEventInterface;
import in.juspay.hypersmshandler.SmsServices;
import in.juspay.hypersmshandler.Tracker;
import in.juspay.hypertrident.TridentBridge;
import in.juspay.hyperupi.UPIBridge;
import in.juspay.hyperwechatpay.WeChatPayBridge;
import in.juspay.mobility.app.MobilityAppBridge;
import in.juspay.mobility.customer.MobilityCustomerBridge;
import in.juspay.mobility.driver.MobilityDriverBridge;
import in.juspay.services.TenantParams;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JuspayServices implements FragmentHooks {
    private static final String DEFAULT_WORKSPACE_PATH = "juspay";
    private static final String fragmentTag = "JuspayServiceFragment";

    @Nullable
    private FragmentActivity activity;

    @NonNull
    private ActivityLaunchDelegate activityLaunchDelegate;

    @NonNull
    private ApplicationManager applicationManager;

    @NonNull
    private final BridgeComponents bridgeComponents;

    @Nullable
    private JSONObject bundleParameters;

    @Nullable
    private final String clientId;

    @Nullable
    private FrameLayout container;

    @NonNull
    private final Context context;

    @NonNull
    private final DynamicUI dynamicUI;

    @NonNull
    private final FileProviderService fileProviderService;

    @NonNull
    private final EnumSet<FragmentEvent> fragmentEvents;

    @Nullable
    private HyperPaymentsCallback hyperCallback;

    @NonNull
    private final HyperOTAServices hyperOTAServices;

    @NonNull
    private IntentSenderDelegate intentSenderDelegate;
    private boolean isPrefetch;

    @NonNull
    private final JBridge jBridge;

    @Nullable
    private JSONObject lastProcessPayload;

    @NonNull
    private final LogManager logManager;

    @Nullable
    private String merchantClientId;

    @NonNull
    private final PaymentSessionInfo paymentSessionInfo;

    @NonNull
    private final RemoteAssetService remoteAssetService;

    @NonNull
    private RequestPermissionDelegate requestPermissionDelegate;

    @NonNull
    private final SdkConfigService sdkConfigService;

    @NonNull
    private final SdkInfo sdkInfo;

    @NonNull
    private final SdkTracker sdkTracker;

    @NonNull
    private final SessionInfo sessionInfo;

    @NonNull
    private final SmsServices smsServices;

    @Nullable
    private final TenantParams tenantParams;

    @Nullable
    private JuspayWebViewConfigurationCallback webViewConfigurationCallback;

    @Nullable
    Runnable webViewCrashCallback;

    @NonNull
    private final Workspace workspace;
    private final String LOG_TAG = getClass().getSimpleName();

    @NonNull
    private final BridgeList bridgeList = new BridgeList();

    @NonNull
    private final Map<String, ArrayList<HyperBridge>> registeredServices = new HashMap();

    @Nullable
    HyperFragment fragment = null;
    private boolean paused = false;
    private boolean isWebViewAvailable = true;
    SmsComponents smsComponents = new SmsComponents() { // from class: in.juspay.hypersdk.core.JuspayServices.7
        @Override // in.juspay.hypersmshandler.SmsComponents
        @NonNull
        public Context getContext() {
            return JuspayServices.this.context;
        }

        @Override // in.juspay.hypersmshandler.SmsComponents
        @NonNull
        public SmsEventInterface getSmsEventInterface() {
            return JuspayServices.this.jBridge.getSmsEventInterface();
        }

        @Override // in.juspay.hypersmshandler.SmsComponents
        @NonNull
        public Tracker getTracker() {
            return JuspayServices.this.sdkTracker;
        }
    };

    /* renamed from: in.juspay.hypersdk.core.JuspayServices$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent;

        static {
            int[] iArr = new int[FragmentEvent.values().length];
            $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent = iArr;
            try {
                iArr[FragmentEvent.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[FragmentEvent.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[FragmentEvent.ON_ATTACH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[FragmentEvent.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public JuspayServices(@NonNull Context context, @Nullable TenantParams tenantParams, @Nullable String str, boolean z) {
        this.isPrefetch = false;
        this.clientId = str;
        this.tenantParams = tenantParams;
        SdkInfo sdkInfo = IntegrationUtils.getSdkInfo(context);
        this.sdkInfo = sdkInfo;
        this.context = context.getApplicationContext();
        String str2 = "jus_" + IntegrationUtils.getSdkVersion(context, "-") + Attributes.PREDEFINED_ATTRIBUTE_PREFIX + IntegrationUtils.getAssetAarVersion(context, str);
        String tenant = getTenant();
        tenant = str != null ? android.support.v4.media.b.l(tenant, "/", str) : tenant;
        SdkTracker sdkTracker = new SdkTracker(this);
        this.sdkTracker = sdkTracker;
        HyperOTAServices hyperOTAServices = new HyperOTAServices(context, tenant, str2, "", getTrackerCallback(), null, sdkInfo.usesLocalAssets(), false);
        this.hyperOTAServices = hyperOTAServices;
        Workspace workspace = hyperOTAServices.getWorkspace();
        this.workspace = workspace;
        this.isPrefetch = z;
        Callback callback = new Callback() { // from class: in.juspay.hypersdk.core.JuspayServices.1
            @Override // in.juspay.hypersdk.mystique.Callback
            public void onError(String str3, String str4) {
                JuspayLogger.e("DynamicUI", str3 + StringUtils.SPACE + str4);
                JuspayServices.this.sdkTracker.trackAction(LogSubCategory.Action.DUI, "error", Labels.HyperSdk.MYSTIQUE, str3.toLowerCase(Locale.getDefault()), str4);
            }

            @Override // in.juspay.hypersdk.mystique.Callback
            public void onException(String str3, String str4, Throwable th) {
                JuspayLogger.e("DynamicUI", str3 + StringUtils.SPACE + str4);
                JuspayServices.this.sdkTracker.trackException("action", LogSubCategory.Action.DUI, Labels.HyperSdk.MYSTIQUE, str4, th);
            }

            @Override // in.juspay.hypersdk.mystique.Callback
            public void onRenderProcessGone(boolean z2) throws JSONException {
                if (JuspayServices.this.hyperCallback != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("action", "OnRenderProcessGone");
                        jSONObject.put("isRecreating", z2);
                        JuspayServices.this.hyperCallback.onEvent(jSONObject, null);
                    } catch (Exception unused) {
                    }
                    if (JuspayServices.this.bundleParameters != null) {
                        try {
                            JuspayServices.this.bundleParameters.put("isWebViewRecreated", true);
                        } catch (JSONException unused2) {
                        }
                    }
                }
            }

            @Override // in.juspay.hypersdk.mystique.Callback
            public void webViewLoaded(Exception exc) {
                if (exc != null) {
                    JuspayServices juspayServices = JuspayServices.this;
                    if (juspayServices.webViewCrashCallback != null) {
                        juspayServices.isWebViewAvailable = false;
                        JuspayServices.this.webViewCrashCallback.run();
                    }
                }
                JuspayServices.this.webViewCrashCallback = null;
            }
        };
        DuiLogger duiLogger = new DuiLogger() { // from class: in.juspay.hypersdk.core.JuspayServices.2
            @Override // in.juspay.hypersdk.core.DuiLogger
            public void d(String str3, String str4) {
            }

            @Override // in.juspay.hypersdk.core.DuiLogger
            public void e(String str3, String str4) {
                JuspayLogger.e(str3, str4);
                JuspayServices.this.sdkTracker.trackAction(LogSubCategory.Action.DUI, "error", Labels.HyperSdk.MYSTIQUE, str3.toLowerCase(Locale.getDefault()), str4);
            }

            @Override // in.juspay.hypersdk.core.DuiLogger
            public void i(String str3, String str4) {
            }

            @Override // in.juspay.hypersdk.core.DuiLogger
            public void logLifeCycleException(String str3, String str4, Exception exc) {
                JuspayServices.this.sdkTracker.trackAndLogException(JuspayServices.this.LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.ANDROID, str3, str4, exc);
            }

            @Override // in.juspay.hypersdk.core.DuiLogger
            public void logLifeCycleInfo(String str3, String str4) {
                JuspayServices.this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.JUSPAY_SERVICES, str3, str4);
            }
        };
        DUIMerchantView dUIMerchantView = new DUIMerchantView() { // from class: in.juspay.hypersdk.core.JuspayServices.3
            @Override // in.juspay.hypersdk.core.DUIMerchantView
            @Nullable
            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                if (JuspayServices.this.getHyperCallback() != null) {
                    return JuspayServices.this.getHyperCallback().getMerchantView(viewGroup, merchantViewType);
                }
                return null;
            }
        };
        this.sessionInfo = new SessionInfo(this);
        this.fileProviderService = hyperOTAServices.getOtaServices().getFileProviderService();
        this.remoteAssetService = hyperOTAServices.getOtaServices().getRemoteAssetService();
        SdkConfigService sdkConfigService = new SdkConfigService(this);
        this.sdkConfigService = sdkConfigService;
        this.logManager = LogManager.registerWorkspace(context, workspace, sdkConfigService.getSdkConfig(), tenantParams != null ? tenantParams.getLogsEndPoint() : null, sdkConfigService);
        this.jBridge = new JBridge(this, hyperOTAServices);
        this.activityLaunchDelegate = new HyperActivityLaunchDelegate(this);
        this.intentSenderDelegate = new HyperIntentSenderDelegate(this);
        this.requestPermissionDelegate = new HyperRequestPermissionDelegate(this);
        BridgeComponents bridgeComponentsCreateBridgeComponents = createBridgeComponents();
        this.bridgeComponents = bridgeComponentsCreateBridgeComponents;
        String baseContent = tenantParams != null ? tenantParams.getBaseContent() : null;
        this.applicationManager = createApplicationManager();
        this.dynamicUI = new DynamicUI(context, duiLogger, callback, bridgeComponentsCreateBridgeComponents, baseContent, getJavaScriptInterfaces(), sdkConfigService.getSdkConfig(), this.applicationManager, dUIMerchantView, z);
        this.paymentSessionInfo = new PaymentSessionInfo(this);
        logMemoryInfo(sdkTracker, context);
        this.fragmentEvents = EnumSet.allOf(FragmentEvent.class);
        this.smsServices = new SmsServices(this.smsComponents);
        JSONObject jSONObjectOptJSONObject = sdkConfigService.getSdkConfig().optJSONObject("logsConfig");
        if (jSONObjectOptJSONObject != null) {
            ExecutorManager.runOnBackgroundThread(new i0(this, jSONObjectOptJSONObject, 0));
        }
    }

    private void addFragment(@NonNull FragmentActivity fragmentActivity) {
        ExecutorManager.runOnMainThread(new l(6, this, fragmentActivity));
    }

    private void commitFragmentTransaction(FragmentTransaction fragmentTransaction) {
        if (useCommit()) {
            fragmentTransaction.d();
        } else {
            fragmentTransaction.f();
        }
    }

    private ApplicationManager createApplicationManager() throws JSONException {
        boolean z;
        String string;
        try {
            z = this.sdkConfigService.getSdkConfig().getJSONObject("flags").getBoolean("sendUpdateNetworkMetrics");
        } catch (Exception unused) {
            z = true;
        }
        try {
            string = this.sdkConfigService.getSdkConfig().getJSONObject("url").getJSONObject("assets").getString("prod");
        } catch (Exception unused2) {
            string = "https://assets.juspay.in";
        }
        HyperOTAServices hyperOTAServices = this.hyperOTAServices;
        TenantParams tenantParams = this.tenantParams;
        return hyperOTAServices.createApplicationManager(tenantParams != null ? tenantParams.getHeaders() : null, z ? android.support.v4.media.b.k(string, "/network-summary") : null);
    }

    @NonNull
    private BridgeComponents createBridgeComponents() {
        return new BridgeComponents() { // from class: in.juspay.hypersdk.core.JuspayServices.6
            @Override // in.juspay.hyper.core.BridgeComponents
            @Nullable
            public Activity getActivity() {
                return JuspayServices.this.activity;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public CallbackInvoker getCallbackInvoker() {
                return JuspayServices.this.jBridge;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @Nullable
            public String getClientId() {
                try {
                    return JuspayServices.this.getSessionInfo().getClientId();
                } catch (Exception unused) {
                    return null;
                }
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public Context getContext() {
                return JuspayServices.this.context;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public FileProviderInterface getFileProviderInterface() {
                return new FileProviderInterface() { // from class: in.juspay.hypersdk.core.JuspayServices.6.2
                    @Override // in.juspay.hyper.core.FileProviderInterface
                    @NonNull
                    public String readFromFile(@NonNull Context context, @NonNull String str) {
                        return JuspayServices.this.fileProviderService.readFromFile(str);
                    }

                    @Override // in.juspay.hyper.core.FileProviderInterface
                    public void renewFile(@NonNull String str, @NonNull String str2, long j2) {
                        JuspayServices.this.remoteAssetService.renewFile(JuspayServices.this.context, str, str2, j2, null);
                    }
                };
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public FragmentHooks getFragmentHooks() {
                return JuspayServices.this;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public JsCallback getJsCallback() {
                return JuspayServices.this.dynamicUI;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public JSONObject getSdkConfig() {
                return JuspayServices.this.sdkConfigService.getSdkConfig();
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public String getSdkName() {
                return JuspayServices.this.sdkInfo.getSdkName();
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public SessionInfoInterface getSessionInfoInterface() {
                return JuspayServices.this.sessionInfo;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public TrackerInterface getTrackerInterface() {
                return JuspayServices.this.sdkTracker;
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            @NonNull
            public IWorkspace getWorkspace() {
                return new IWorkspace() { // from class: in.juspay.hypersdk.core.JuspayServices.6.1
                    @Override // in.juspay.hyper.core.IWorkspace
                    @Nullable
                    public String getFromSharedPreference(@Nullable String str, @Nullable String str2) {
                        return JuspayServices.this.workspace.getFromSharedPreference(str, str2);
                    }
                };
            }

            @Override // in.juspay.hyper.core.BridgeComponents
            public void registerService(@NonNull String str, @NonNull HyperBridge hyperBridge) {
                ArrayList arrayList = (ArrayList) JuspayServices.this.registeredServices.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    JuspayServices.this.registeredServices.put(str, arrayList);
                }
                arrayList.add(hyperBridge);
            }
        };
    }

    private FrameLayout createSubLayout(Activity activity) {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setVisibility(0);
        return frameLayout;
    }

    private void deleteLogFiles(File file) {
        try {
            File[] fileArrListFiles = new File(file.toString()).listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    String name = file2.getName();
                    if (name.startsWith(LogConstants.PERSISTENT_LOGS_FILE) || name.startsWith(LogConstants.LOGS_FILE) || name.startsWith(LogConstants.TEMP_LOGS_FILE)) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void firstTimeSetup() {
        String fromSharedPreference = this.workspace.getFromSharedPreference(PaymentConstants.BUILD_ID, "__failed");
        String str = this.clientId;
        if (str == null) {
            String str2 = this.merchantClientId;
            str = str2 != null ? str2.toLowerCase(Locale.getDefault()).split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)[0] : null;
        }
        String assetAarVersion = IntegrationUtils.getAssetAarVersion(this.context, str);
        if (assetAarVersion.equals("undefined")) {
            assetAarVersion = IntegrationUtils.getAssetAarVersion(this.context, null);
        }
        String str3 = "jus_" + IntegrationUtils.getSdkVersion(this.context, Attributes.PREDEFINED_ATTRIBUTE_PREFIX) + Attributes.PREDEFINED_ATTRIBUTE_PREFIX + assetAarVersion;
        if (fromSharedPreference.equals(str3)) {
            return;
        }
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "first_time_setup", "started", null);
        this.workspace.writeToSharedPreference(PaymentConstants.BUILD_ID, str3);
        this.workspace.removeFromSharedPreference("asset_metadata.json");
        try {
            File cacheRoot = this.workspace.getCacheRoot();
            new File(cacheRoot, "juspay-logs-queue.dat").delete();
            new File(cacheRoot, "temp-logs-queue.dat").delete();
            new File(cacheRoot, "juspay-pre-logs-queue.dat").delete();
            deleteLogFiles(cacheRoot);
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "first_time_setup", "completed", null);
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(this.LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, "first_time_setup", "Exception while fetching meta-data for manifest.json file", e2);
        }
    }

    private int generateNewToss(long j2) throws JSONException {
        int iNextInt = new Random().nextInt(99);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", j2);
            jSONObject.put("toss", iNextInt);
            this.workspace.writeToSharedPreference(in.juspay.hypersdk.ota.Constants.PATCH_TOSS, jSONObject.toString());
            return iNextInt;
        } catch (Exception e2) {
            e2.printStackTrace();
            return iNextInt;
        }
    }

    private Map<String, Object> getJavaScriptInterfaces() throws SecurityException {
        HashMap map = new HashMap();
        map.put("JBridge", this.jBridge);
        map.put(this.bridgeList.getInterfaceName(), this.bridgeList);
        if (PaymentUtils.isClassAvailable("in.juspay.hyperupi.UPIBridge")) {
            this.bridgeList.addHyperBridge(new UPIBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperapayupi.APayUPIBridge")) {
            this.bridgeList.addHyperBridge(new APayUPIBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypersimpl.SimplBridge")) {
            this.bridgeList.addHyperBridge(new SimplBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypergpayintl.GPayIntlBridge")) {
            this.bridgeList.addHyperBridge(new GPayIntlBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperapay.APayBridge")) {
            this.bridgeList.addHyperBridge(new APayBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperpaypal.PaypalBridge")) {
            this.bridgeList.addHyperBridge(new PaypalBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperqr.QrBridge")) {
            this.bridgeList.addHyperBridge(new QrBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypernfc.NfcBridge")) {
            this.bridgeList.addHyperBridge(new NfcBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypergpay.GPayBridge")) {
            this.bridgeList.addHyperBridge(new GPayBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperpayu.PayUBridge")) {
            this.bridgeList.addHyperBridge(new PayUBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypertrident.TridentBridge")) {
            this.bridgeList.addHyperBridge(new TridentBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperbiometric.FIDOAuthManagerBridge")) {
            this.bridgeList.addHyperBridge(new FIDOAuthManagerBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperalipay.AlipayBridge")) {
            this.bridgeList.addHyperBridge(new AlipayBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperwechatpay.WeChatPayBridge")) {
            this.bridgeList.addHyperBridge(new WeChatPayBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypercredunbundle.CredUnbundleBridge")) {
            this.bridgeList.addHyperBridge(new CredUnbundleBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.mobility.customer.MobilityCustomerBridge")) {
            this.bridgeList.addHyperBridge(new MobilityCustomerBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.mobility.driver.MobilityDriverBridge")) {
            this.bridgeList.addHyperBridge(new MobilityDriverBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.mobility.app.MobilityAppBridge")) {
            this.bridgeList.addHyperBridge(new MobilityAppBridge(this.bridgeComponents));
        }
        try {
            TenantParams tenantParams = this.tenantParams;
            if (tenantParams != null) {
                Iterator<Class<? extends HyperBridge>> it = tenantParams.getBridgeClasses().iterator();
                while (it.hasNext()) {
                    for (Constructor<?> constructor : it.next().getConstructors()) {
                        if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0].equals(BridgeComponents.class)) {
                            this.bridgeList.addHyperBridge((HyperBridge) constructor.newInstance(this.bridgeComponents));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(this.LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.ADD_BRIDGE, "Exception while trying to add tenant bridge", e2);
        }
        map.putAll(this.bridgeList.getBridgeList());
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReleaseConfigUrl(Mode mode, String str) {
        String lowerCase = str.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)[0].toLowerCase();
        int timedToss = getTimedToss();
        if (mode instanceof Mode.Release) {
            return "https://assets.juspay.in/hyper/bundles/in.juspay.merchants/" + lowerCase + "/android/release/release-config-v2.json?toss=" + timedToss;
        }
        if (mode instanceof Mode.CUG) {
            return "https://assets.juspay.in/hyper/bundles/in.juspay.merchants/" + lowerCase + "/android/cug/release-config-v2.json?toss=" + timedToss;
        }
        if (mode instanceof Mode.Beta) {
            return "https://sandbox.assets.juspay.in/hyper/bundles/in.juspay.merchants/" + lowerCase + "/android/beta/release-config-v2.json?toss=" + timedToss;
        }
        if (!(mode instanceof Mode.DevQa)) {
            return "";
        }
        StringBuilder sbV = androidx.fragment.app.e.v("https://sandbox.assets.juspay.in/hyper/bundles/in.juspay.merchants/", lowerCase, "/android/", android.support.v4.media.b.C("devqa-", ((Mode.DevQa) mode).getTicket()), "/release-config-v2.json?toss=");
        sbV.append(timedToss);
        return sbV.toString();
    }

    private int getTimedToss() {
        String fromSharedPreference = this.workspace.getFromSharedPreference(in.juspay.hypersdk.ota.Constants.PATCH_TOSS, null);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (fromSharedPreference == null) {
            return generateNewToss(jCurrentTimeMillis);
        }
        try {
            JSONObject jSONObject = new JSONObject(fromSharedPreference);
            return jCurrentTimeMillis - jSONObject.optLong("ts") > 604800 ? generateNewToss(jCurrentTimeMillis) : jSONObject.optInt("toss");
        } catch (Exception unused) {
            return generateNewToss(jCurrentTimeMillis);
        }
    }

    private void insetUpdated(WindowInsets windowInsets) {
        float systemWindowInsetTop;
        float systemWindowInsetRight;
        float systemWindowInsetBottom;
        int systemWindowInsetLeft;
        float stableInsetTop;
        float stableInsetRight;
        float stableInsetBottom;
        int stableInsetLeft;
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity == null) {
            return;
        }
        float f2 = fragmentActivity.getResources().getDisplayMetrics().density;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            systemWindowInsetTop = r3.top / f2;
            systemWindowInsetRight = r3.right / f2;
            systemWindowInsetBottom = r3.bottom / f2;
            systemWindowInsetLeft = windowInsets.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.ime()).left;
        } else {
            systemWindowInsetTop = windowInsets.getSystemWindowInsetTop() / f2;
            systemWindowInsetRight = windowInsets.getSystemWindowInsetRight() / f2;
            systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom() / f2;
            systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
        }
        float f3 = systemWindowInsetLeft / f2;
        if (i2 >= 30) {
            stableInsetTop = r10.top / f2;
            stableInsetRight = r10.right / f2;
            stableInsetBottom = r10.bottom / f2;
            stableInsetLeft = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars()).left;
        } else {
            stableInsetTop = windowInsets.getStableInsetTop() / f2;
            stableInsetRight = windowInsets.getStableInsetRight() / f2;
            stableInsetBottom = windowInsets.getStableInsetBottom() / f2;
            stableInsetLeft = windowInsets.getStableInsetLeft();
        }
        this.dynamicUI.addJsToWebView("window.insetUpdated(" + systemWindowInsetTop + "," + systemWindowInsetRight + "," + systemWindowInsetBottom + "," + f3 + "," + stableInsetTop + "," + stableInsetRight + "," + stableInsetBottom + "," + (stableInsetLeft / f2) + ",)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFragment$10(FragmentEvent fragmentEvent, String str, HyperFragment hyperFragment) {
        this.sdkTracker.trackLifecycle("system", "debug", Labels.Android.FRAGMENT_LIFECYCLE_EVENT, "event", fragmentEvent.getKey());
        int i2 = AnonymousClass8.$SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[fragmentEvent.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && hyperFragment == this.fragment) {
                        this.fragment = null;
                    }
                } else if (hyperFragment == this.fragment) {
                    ActivityLaunchDelegate activityLaunchDelegate = this.activityLaunchDelegate;
                    if (activityLaunchDelegate instanceof HyperActivityLaunchDelegate) {
                        ((HyperActivityLaunchDelegate) activityLaunchDelegate).fragmentAttached();
                    }
                    RequestPermissionDelegate requestPermissionDelegate = this.requestPermissionDelegate;
                    if (requestPermissionDelegate instanceof HyperRequestPermissionDelegate) {
                        ((HyperRequestPermissionDelegate) requestPermissionDelegate).fragmentAttached();
                    }
                    IntentSenderDelegate intentSenderDelegate = this.intentSenderDelegate;
                    if (intentSenderDelegate instanceof HyperIntentSenderDelegate) {
                        ((HyperIntentSenderDelegate) intentSenderDelegate).fragmentAttached();
                    }
                }
            } else if (hyperFragment == this.fragment) {
                this.paused = false;
                getDynamicUI().onResumeCallback();
            }
        } else if (hyperFragment == this.fragment) {
            this.paused = true;
            this.logManager.flushLogPush();
            getDynamicUI().onPauseCallback();
        }
        this.jBridge.invokeFnInDUIWebview(fragmentEvent.getKey(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$addFragment$11(FragmentActivity fragmentActivity) {
        try {
            this.fragment = new HyperFragment();
            FragmentTransaction fragmentTransactionD = fragmentActivity.getSupportFragmentManager().d();
            fragmentTransactionD.h(0, this.fragment, fragmentTag, 1);
            commitFragmentTransaction(fragmentTransactionD);
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.FRAGMENT_OPERATION, "fragment_transaction", "Fragment Addition Done Successfully");
            Iterator<FragmentEvent> it = this.fragmentEvents.iterator();
            while (it.hasNext()) {
                final FragmentEvent next = it.next();
                this.fragment.registerForEvent(next, new EventListener() { // from class: in.juspay.hypersdk.core.j0
                    @Override // in.juspay.hypersdk.lifecycle.EventListener
                    public final void onEvent(String str, HyperFragment hyperFragment) {
                        this.f48606a.lambda$addFragment$10(next, str, hyperFragment);
                    }
                });
            }
            this.fragment.registerOnActivityResult(new ActivityResultHolder() { // from class: in.juspay.hypersdk.core.k0
                @Override // in.juspay.hypersdk.lifecycle.ActivityResultHolder
                public final void onActivityResult(int i2, int i3, Intent intent) {
                    this.f48611a.onActivityResult(i2, i3, intent);
                }
            });
            this.fragment.registerOnRequestPermissionResult(new RequestPermissionResult() { // from class: in.juspay.hypersdk.core.l0
                @Override // in.juspay.hypersdk.lifecycle.RequestPermissionResult
                public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) throws JSONException {
                    this.f48615a.onRequestPermissionsResult(i2, strArr, iArr);
                }
            });
        } catch (Exception e2) {
            this.sdkTracker.trackException("lifecycle", LogSubCategory.LifeCycle.ANDROID, Labels.Android.FRAGMENT_OPERATION, "Exception while committing fragment", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$4(String str) {
        this.applicationManager.loadApplication(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$5(Runnable runnable) {
        if (this.dynamicUI.initiate()) {
            return;
        }
        this.webViewCrashCallback = null;
        this.isWebViewAvailable = false;
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$6() {
        ApplicationManager applicationManager = this.applicationManager;
        String str = this.clientId;
        if (str == null) {
            str = this.merchantClientId;
        }
        applicationManager.loadApplication(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logMemoryInfo$1(Context context, SdkTracker sdkTracker) throws JSONException {
        ActivityManager.MemoryInfo memoryInfo = Utils.getMemoryInfo(context);
        if (memoryInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("available_memory", memoryInfo.availMem);
            jSONObject.put("threshold_memory", memoryInfo.threshold);
            jSONObject.put("total_memory", memoryInfo.totalMem);
            sdkTracker.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "memory_info", jSONObject);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(this.LOG_TAG, "action", "system", "session_info", "Exception while logging memory_info", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(JSONObject jSONObject) throws JSONException {
        this.sdkTracker.setLabelsToDrop(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$process$7(View view, WindowInsets windowInsets) {
        view.onApplyWindowInsets(windowInsets);
        insetUpdated(windowInsets);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$process$8(ViewGroup viewGroup, FragmentActivity fragmentActivity) {
        FrameLayout frameLayout = this.container;
        if (frameLayout == null || frameLayout.getParent() != viewGroup) {
            FrameLayout frameLayoutCreateSubLayout = createSubLayout(fragmentActivity);
            viewGroup.addView(frameLayoutCreateSubLayout);
            FrameLayout frameLayout2 = this.container;
            if (frameLayout2 != null) {
                ViewParent parent = frameLayout2.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.container);
                }
            }
            this.dynamicUI.setContainer(frameLayoutCreateSubLayout);
            viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: in.juspay.hypersdk.core.m0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f48622a.lambda$process$7(view, windowInsets);
                }
            });
            this.container = frameLayoutCreateSubLayout;
            this.jBridge.setContainer(viewGroup);
            this.dynamicUI.setContainer(frameLayoutCreateSubLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$removeFragment$12() {
        HyperFragment hyperFragment;
        if (this.activity != null && (hyperFragment = this.fragment) != null && hyperFragment.isAdded()) {
            try {
                FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
                if (!supportFragmentManager.K && supportFragmentManager.E(fragmentTag) != null) {
                    FragmentTransaction fragmentTransactionD = supportFragmentManager.d();
                    fragmentTransactionD.i(this.fragment);
                    commitFragmentTransaction(fragmentTransactionD);
                    this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.FRAGMENT_OPERATION, "fragment_transaction", "Fragment Removed successfully");
                }
            } catch (Exception e2) {
                this.sdkTracker.trackException("lifecycle", LogSubCategory.LifeCycle.ANDROID, Labels.Android.FRAGMENT_OPERATION, "Exception while removing fragment", e2);
            }
        }
        this.fragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reset$9() {
        this.jBridge.clearMerchantViews(this.activity);
        removeFragment();
        this.activity = null;
        this.jBridge.setActivity(null);
        this.dynamicUI.resetActivity();
        this.jBridge.reset();
        resetBridges();
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.container);
            }
        }
        this.container = null;
        this.dynamicUI.setContainer(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBundleParameter$2(JSONObject jSONObject) {
        this.logManager.setLogHeaderValues(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBundleParameter$3() throws JSONException {
        this.sessionInfo.createSessionDataMap();
        this.sessionInfo.logDeviceIdentifiers();
        JSONObject sessionData = this.sessionInfo.getSessionData();
        try {
            sessionData.put(PaymentConstants.MERCHANT_ID, this.sessionInfo.getMerchantId());
            sessionData.put(PaymentConstants.CLIENT_ID, this.sessionInfo.getClientId().split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)[0].toLowerCase(Locale.getDefault()));
            sessionData.put("session_id", this.sessionInfo.getSessionId());
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(this.LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.SET_BUNDLE_PARAMS, "Exception while setting bundle parameter", e2);
        }
        this.sessionInfo.logSessionInfo();
        ExecutorManager.runOnLogSessioniserThread(new i0(this, sessionData, 1));
    }

    private void logMemoryInfo(SdkTracker sdkTracker, Context context) {
        ExecutorManager.runOnBackgroundThread(new r(this, context, sdkTracker, 7));
    }

    private void removeFragment() {
        ExecutorManager.runOnMainThread(new n(this, 1));
    }

    private void resetBridges() {
        Iterator<HyperBridge> it = this.bridgeList.getBridgeList().values().iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    private void setLastProcessPayload(@NonNull JSONObject jSONObject) {
        this.lastProcessPayload = jSONObject;
    }

    private boolean useCommit() {
        if (this.merchantClientId == null) {
            return true;
        }
        return !Utils.optJSONObject(this.sdkConfigService.getSdkConfig(), "useCommitNowClientIds").optString(this.merchantClientId.toLowerCase(Locale.getDefault()).split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)[0]).equals("true");
    }

    public void addJsToWebView(String str) {
        this.dynamicUI.addJsToWebView(str);
    }

    @Nullable
    public Activity getActivity() {
        return this.activity;
    }

    @Nullable
    public JSONObject getAppWithPackageName(String str, String str2) throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(this.jBridge.findApps(str));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.optString("packageName", "").contains(str2)) {
                    return jSONObject;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @NonNull
    public ApplicationManager getApplicationManager() {
        return this.applicationManager;
    }

    @Nullable
    public JSONObject getBundleParameters() {
        return this.bundleParameters;
    }

    @Nullable
    public FrameLayout getContainer() {
        return this.container;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    @NonNull
    public DynamicUI getDynamicUI() {
        return this.dynamicUI;
    }

    @NonNull
    public FileProviderService getFileProviderService() {
        return this.fileProviderService;
    }

    @Nullable
    public HyperFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public HyperPaymentsCallback getHyperCallback() {
        return this.hyperCallback;
    }

    @NonNull
    public JBridge getJBridge() {
        return this.jBridge;
    }

    public Map<String, HyperBridge> getJBridgeList() {
        return this.bridgeList.getBridgeList();
    }

    @Nullable
    public JSONObject getLastProcessPayload() {
        return this.lastProcessPayload;
    }

    @NonNull
    public LogManager getLogManager() {
        return this.logManager;
    }

    @NonNull
    public PaymentSessionInfo getPaymentSessionInfo() {
        return this.paymentSessionInfo;
    }

    @NonNull
    public Map<String, ArrayList<HyperBridge>> getRegisteredServices() {
        return this.registeredServices;
    }

    @NonNull
    public RemoteAssetService getRemoteAssetService() {
        return this.remoteAssetService;
    }

    @NonNull
    public SdkConfigService getSdkConfigService() {
        return this.sdkConfigService;
    }

    @NonNull
    public final SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    @NonNull
    public SdkTracker getSdkTracker() {
        return this.sdkTracker;
    }

    @NonNull
    public SessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @NonNull
    public SmsServices getSmsServices() {
        return this.smsServices;
    }

    public String getTenant() {
        TenantParams tenantParams = this.tenantParams;
        return (tenantParams == null || tenantParams.getTenant() == null) ? DEFAULT_WORKSPACE_PATH : this.tenantParams.getTenant();
    }

    @NonNull
    public TrackerCallback getTrackerCallback() {
        return new TrackerCallback() { // from class: in.juspay.hypersdk.core.JuspayServices.4
            @Override // in.juspay.airborne.TrackerCallback
            public void track(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull JSONObject jSONObject) {
                str.getClass();
                switch (str) {
                    case "action":
                        JuspayServices.this.sdkTracker.trackAction(str2, str3, str4, str5, jSONObject);
                    case "lifecycle":
                        JuspayServices.this.sdkTracker.trackLifecycle(str2, str3, str4, str5, jSONObject);
                    case "sdk":
                        JuspayServices.this.sdkTracker.trackContext(str2, str3, str4, str5, jSONObject);
                        break;
                }
            }

            @Override // in.juspay.airborne.TrackerCallback
            public void trackException(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull Throwable th) {
                JuspayServices.this.sdkTracker.trackException(str, str2, str3, str4, th);
            }
        };
    }

    @Nullable
    public JuspayWebViewConfigurationCallback getWebViewConfigurationCallback() {
        return this.webViewConfigurationCallback;
    }

    @NonNull
    public String getWorkingLogger() {
        return "json-array";
    }

    @NonNull
    public Workspace getWorkspace() {
        return this.workspace;
    }

    public void initiate(Runnable runnable) {
        firstTimeSetup();
        boolean zOptBoolean = this.context.getResources().getBoolean(R.bool.use_local_assets);
        JSONObject bundleParameters = getBundleParameters();
        if (bundleParameters != null) {
            zOptBoolean = bundleParameters.optBoolean("useLocalAssets", zOptBoolean);
        }
        JSONObject jSONObject = this.bundleParameters;
        if (jSONObject != null) {
            jSONObject.optBoolean(PaymentConstants.BETA_ASSETS, false);
        }
        this.applicationManager.setShouldUpdate(!zOptBoolean);
        if (this.isPrefetch) {
            if (this.clientId == null && this.merchantClientId == null) {
                return;
            }
            ExecutorManager.runOnBackgroundThread(new n(this, 4));
            return;
        }
        this.webViewCrashCallback = runnable;
        String str = this.clientId;
        if (str == null) {
            str = this.merchantClientId;
        }
        if (str == null) {
            this.sdkTracker.trackContext(LogSubCategory.LifeCycle.HYPER_SDK, LogLevel.CRITICAL, Labels.HyperSdk.JUSPAY_SERVICES, "Cannot initiate sdk as clientId is null");
        } else {
            ExecutorManager.runOnBackgroundThread(new l(7, this, str));
        }
        ExecutorManager.runOnMainThread(new l(8, this, runnable));
    }

    public Boolean isCug() {
        return Boolean.valueOf(getAppWithPackageName(Constants.CUG_PACKAGE_URI, Constants.CUG_PACKAGE_NAME) != null);
    }

    @Nullable
    public String isDevQAUser() throws JSONException {
        JSONObject appWithPackageName = getAppWithPackageName(Constants.DEVQA_PACKAGE_URI, Constants.DEVQA_PACKAGE_NAME);
        if (appWithPackageName == null) {
            return null;
        }
        String strOptString = appWithPackageName.optString("packageName", "");
        return strOptString.length() > 15 ? strOptString.substring(15) : "";
    }

    public Boolean isForceCug() {
        return Boolean.valueOf(getAppWithPackageName(Constants.CUG_PACKAGE_URI, Constants.FORCE_CUG_PACKAGE_NAME) != null);
    }

    public boolean isPaused() {
        return this.paused;
    }

    public boolean isPrefetch() {
        return this.isPrefetch;
    }

    public boolean isWebViewAvailable() {
        return this.isWebViewAvailable;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i3 == -1) {
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.ON_ACTIVITY_RESULT, "result_code", "RESULT_OK");
            if (intent != null && intent.getExtras() != null) {
                this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.ON_ACTIVITY_RESULT, "result_code", Utils.toJSON(intent.getExtras()));
            }
        } else if (i3 == 0) {
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.ON_ACTIVITY_RESULT, "result_code", "RESULT_CANCELLED");
        }
        Iterator<HyperBridge> it = this.bridgeList.getBridgeList().values().iterator();
        while (it.hasNext()) {
            if (it.next().onActivityResult(i2, i3, intent)) {
                return;
            }
        }
        this.jBridge.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.ANDROID, "info", Labels.Android.BACK_PRESSED, "class", "juspayServices");
        this.jBridge.requestKeyboardHide();
        this.jBridge.invokeFnInDUIWebview("onBackPressed", "{\"shouldShowBackPressDialog\":true}");
    }

    public void onMerchantEvent(@NonNull JSONObject jSONObject) {
        onMerchantEvent(LogConstants.DEFAULT_CHANNEL, jSONObject);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) throws JSONException {
        SdkTracker sdkTracker = this.sdkTracker;
        StringBuilder sbU = android.support.v4.media.b.u(i2, "requestCode = [", "],permissions = [");
        sbU.append(Arrays.toString(strArr));
        sbU.append("], grantResults = [");
        sbU.append(Arrays.toString(iArr));
        sbU.append("]");
        sdkTracker.trackAction("system", "info", Labels.System.ON_REQUEST_PERMISSION_RESULT, "data", sbU.toString());
        Iterator<HyperBridge> it = this.bridgeList.getBridgeList().values().iterator();
        while (it.hasNext()) {
            if (it.next().onRequestPermissionResult(i2, strArr, iArr)) {
                return;
            }
        }
        this.jBridge.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void process(@NonNull FragmentActivity fragmentActivity, @NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        this.smsServices.createSMSConsent();
        if (fragmentActivity == this.activity && (frameLayout2 = this.container) != null && viewGroup == frameLayout2.getParent()) {
            return;
        }
        if (this.activity != fragmentActivity || ((frameLayout = this.container) != null && frameLayout.getParent() != viewGroup)) {
            this.jBridge.clearMerchantViews(this.activity);
            this.jBridge.clearMerchantViews(fragmentActivity);
        }
        if (fragmentActivity != this.activity) {
            removeFragment();
            addFragment(fragmentActivity);
            this.activity = fragmentActivity;
            this.jBridge.setActivity(fragmentActivity);
            this.dynamicUI.setActivity(fragmentActivity);
        }
        ExecutorManager.runOnMainThread(new r(this, viewGroup, fragmentActivity, 6));
    }

    @Override // in.juspay.hyper.core.FragmentHooks
    public void requestPermission(@NonNull String[] strArr, int i2) {
        this.requestPermissionDelegate.requestPermission(strArr, i2);
    }

    public void reset() {
        ExecutorManager.runOnMainThread(new n(this, 3));
    }

    public void sdkDebug(String str, String str2) {
        if (this.sdkInfo.isSdkDebuggable()) {
            JuspayLogger.d(str, str2);
        }
    }

    public void setActivityLaunchDelegate(@NonNull ActivityLaunchDelegate activityLaunchDelegate) {
        this.activityLaunchDelegate = activityLaunchDelegate;
    }

    public void setBundleParameter(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.put(PaymentConstants.SDK_NAME, this.sdkInfo.getSdkName());
            jSONObject.put(PaymentConstants.SDK_VERSION, this.sdkInfo.getSdkVersion());
            this.bundleParameters = jSONObject;
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.PAYLOAD);
            this.sdkTracker.setEndPointSandbox(Boolean.valueOf(jSONObject2.has(PaymentConstants.ENV) ? jSONObject2.getString(PaymentConstants.ENV).equalsIgnoreCase(PaymentConstants.ENVIRONMENT.SANDBOX) : false));
            if (jSONObject2.has("clientId")) {
                this.merchantClientId = jSONObject2.getString("clientId");
            }
            setUpMerchantFragments(jSONObject2);
            jSONObject2.put("tenantId", getTenant());
            this.sessionInfo.setBundleParams(jSONObject);
            this.applicationManager.setReleaseConfigCallback(new ReleaseConfigCallback() { // from class: in.juspay.hypersdk.core.JuspayServices.5
                Mode mode = Mode.Release.INSTANCE;

                @Override // in.juspay.airborne.ota.ReleaseConfigCallback
                @NotNull
                public String getReleaseConfig(boolean z) throws JSONException {
                    String oTAEndPoint = JuspayServices.this.tenantParams != null ? JuspayServices.this.tenantParams.getOTAEndPoint() : null;
                    if (oTAEndPoint != null) {
                        return oTAEndPoint;
                    }
                    this.mode = Mode.Release.INSTANCE;
                    if (!z) {
                        String strIsDevQAUser = JuspayServices.this.isDevQAUser();
                        if (strIsDevQAUser != null) {
                            this.mode = new Mode.DevQa(strIsDevQAUser);
                        } else if (JuspayServices.this.bundleParameters != null && JuspayServices.this.bundleParameters.optBoolean(PaymentConstants.BETA_ASSETS, false)) {
                            this.mode = Mode.Beta.INSTANCE;
                        } else if (JuspayServices.this.isCug().booleanValue() || JuspayServices.this.isForceCug().booleanValue()) {
                            this.mode = Mode.CUG.INSTANCE;
                        }
                    }
                    JuspayServices juspayServices = JuspayServices.this;
                    return juspayServices.getReleaseConfigUrl(this.mode, juspayServices.merchantClientId);
                }

                @Override // in.juspay.airborne.ota.ReleaseConfigCallback
                public boolean shouldRetry() {
                    return this.mode != Mode.Release.INSTANCE;
                }
            });
            this.applicationManager.setSessionId(this.sessionInfo.getSessionId());
            ExecutorManager.runOnBackgroundThread(new n(this, 2));
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(this.LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.SET_BUNDLE_PARAMS, "Exception while setting bundle parameter", e2);
        }
    }

    public void setHyperCallback(@NonNull HyperPaymentsCallback hyperPaymentsCallback) {
        this.hyperCallback = hyperPaymentsCallback;
    }

    public void setIntentSenderDelegate(@NonNull IntentSenderDelegate intentSenderDelegate) {
        this.intentSenderDelegate = intentSenderDelegate;
    }

    public void setPrefetch(boolean z) {
        this.isPrefetch = z;
    }

    public void setRequestPermissionDelegate(@NonNull RequestPermissionDelegate requestPermissionDelegate) {
        this.requestPermissionDelegate = requestPermissionDelegate;
    }

    public void setUpMerchantFragments(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(PaymentConstants.FRAGMENT_VIEW_GROUPS) || this.activity == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.FRAGMENT_VIEW_GROUPS);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject2.opt(next);
                if (objOpt instanceof ViewGroup) {
                    FrameLayout frameLayoutCreateSubLayout = createSubLayout(this.activity);
                    ((ViewGroup) objOpt).addView(frameLayoutCreateSubLayout);
                    jSONObject2.put(next, this.dynamicUI.addToContainerList(frameLayoutCreateSubLayout));
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void setWebViewConfigurationCallback(@Nullable JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        this.webViewConfigurationCallback = juspayWebViewConfigurationCallback;
    }

    @Override // in.juspay.hyper.core.FragmentHooks
    public void startActivityForResult(@NonNull Intent intent, int i2, @Nullable Bundle bundle) {
        this.activityLaunchDelegate.startActivityForResult(intent, i2, bundle);
    }

    @Override // in.juspay.hyper.core.FragmentHooks
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.intentSenderDelegate.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void terminate() throws JSONException {
        MPINUtil.closeAllConnections(getContext());
        this.jBridge.reset();
        ApplicationManager applicationManagerCreateApplicationManager = createApplicationManager();
        this.applicationManager = applicationManagerCreateApplicationManager;
        this.dynamicUI.setApplicationManager(applicationManagerCreateApplicationManager);
        Iterator<HyperBridge> it = this.bridgeList.getBridgeList().values().iterator();
        while (it.hasNext()) {
            it.next().terminate();
        }
        ActivityLaunchDelegate activityLaunchDelegate = this.activityLaunchDelegate;
        if (activityLaunchDelegate instanceof HyperActivityLaunchDelegate) {
            ((HyperActivityLaunchDelegate) activityLaunchDelegate).clearQueue();
        }
        IntentSenderDelegate intentSenderDelegate = this.intentSenderDelegate;
        if (intentSenderDelegate instanceof HyperIntentSenderDelegate) {
            ((HyperIntentSenderDelegate) intentSenderDelegate).clearQueue();
        }
        RequestPermissionDelegate requestPermissionDelegate = this.requestPermissionDelegate;
        if (requestPermissionDelegate instanceof HyperRequestPermissionDelegate) {
            ((HyperRequestPermissionDelegate) requestPermissionDelegate).clearQueue();
        }
        this.dynamicUI.terminate();
        this.smsServices.unregisterSmsConsent();
    }

    public void onMerchantEvent(String str, @NonNull JSONObject jSONObject) {
        if (str.equals(Labels.HyperSdk.PROCESS)) {
            setLastProcessPayload(jSONObject);
        }
        this.jBridge.invokeCustomFnInDUIWebview(android.support.v4.media.b.m("window.onMerchantEvent('", str, "',", this.dynamicUI.encodeUtfAndWrapDecode(jSONObject.toString(), this.LOG_TAG), ");"));
    }
}
