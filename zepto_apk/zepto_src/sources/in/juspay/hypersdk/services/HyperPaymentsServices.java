package in.juspay.hypersdk.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.audio.f;
import androidx.media3.exoplayer.video.h;
import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PrefetchServices;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.data.JuspayResponseHandlerDummyImpl;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.LogType;
import in.juspay.hypersdk.utils.TrackerFallback;
import in.juspay.services.TenantParams;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Message;

@Keep
/* loaded from: classes4.dex */
public class HyperPaymentsServices {
    private static final String LOG_TAG = "HyperPaymentsServices";
    private static final String REQUEST_ID = "requestId";

    @Nullable
    protected FragmentActivity activity;

    @NonNull
    private final HashMap<WeakReference<FragmentActivity>, String> activityIds;

    @Nullable
    protected ViewGroup container;

    @NonNull
    private final Context context;

    @Nullable
    private String currentActivityId;
    private HyperExceptionHandler hyperExceptionHandler;
    protected boolean jpConsumingBackPress;

    @NonNull
    private final JuspayServices juspayServices;

    @Nullable
    protected HyperPaymentsCallback merchantCallback;

    @NonNull
    private final OnBackPressedCallback onBackPressedCallback;
    private final Set<String> onBackPressedCallbackSet;
    private final Queue<Runnable> processWaitingQueue;
    private final AtomicReference<SDKState> sdkStateReference;

    @NonNull
    private final TrackerFallback trackerFallBack;

    /* renamed from: in.juspay.hypersdk.services.HyperPaymentsServices$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersdk$services$SDKState;

        static {
            int[] iArr = new int[SDKState.values().length];
            $SwitchMap$in$juspay$hypersdk$services$SDKState = iArr;
            try {
                iArr[SDKState.INSTANTIATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$services$SDKState[SDKState.INITIATE_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$services$SDKState[SDKState.INITIATE_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$in$juspay$hypersdk$services$SDKState[SDKState.TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class HyperExceptionHandler implements Thread.UncaughtExceptionHandler {
        private static final String LOG_TAG = "UncaughtExceptionHandler";
        private WeakReference<HyperPaymentsServices> hyperPaymentServices;
        private Thread.UncaughtExceptionHandler merchantHandler;

        public HyperExceptionHandler(HyperPaymentsServices hyperPaymentsServices) {
            this.hyperPaymentServices = new WeakReference<>(hyperPaymentsServices);
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "created HyperExceptionHandler");
        }

        public void clearHyperExceptionHandler() {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.merchantHandler;
            if (uncaughtExceptionHandler == null || !(uncaughtExceptionHandler instanceof HyperExceptionHandler)) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            this.hyperPaymentServices = new WeakReference<>(null);
            this.merchantHandler = null;
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "destroyed HyperExceptionHandler and registered merchant's exception handler as default");
        }

        public void setAsDefaultExceptionHandler() {
            this.merchantHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "registered HyperExceptionHandler as default uncaught exception handler");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            HyperPaymentsServices hyperPaymentsServices = this.hyperPaymentServices.get();
            if (hyperPaymentsServices != null) {
                JuspayLogger.w(LOG_TAG, "sending crash to tracker");
                hyperPaymentsServices.uncaughtException(th);
            }
            if (this.merchantHandler != null) {
                JuspayLogger.w(LOG_TAG, "forwarding crash to merchant");
                this.merchantHandler.uncaughtException(thread, th);
            } else {
                JuspayLogger.e(LOG_TAG, "merchant exception handler not found, exiting");
                System.exit(1);
            }
        }
    }

    @Keep
    public HyperPaymentsServices(@NonNull Context context) {
        this(context, (TenantParams) null, (String) null);
    }

    private void doProcess(@NonNull JSONObject jSONObject) throws JSONException {
        try {
            logSafeEvents("info", Labels.HyperSdk.PROCESS, "started", jSONObject);
            this.trackerFallBack.log(jSONObject, this.juspayServices, LogType.PROCESS_START);
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.PAYLOAD);
            ViewGroup viewGroup = this.container;
            jSONObject2.put("merchant_root_view", viewGroup != null ? String.valueOf(viewGroup.getId()) : -1);
            FragmentActivity fragmentActivity = this.activity;
            jSONObject2.put("merchant_keyboard_mode", fragmentActivity != null ? fragmentActivity.getWindow().getAttributes().softInputMode : -1);
            jSONObject2.put("processStartedTime", System.currentTimeMillis());
            jSONObject2.put("currentActivityId", this.currentActivityId);
            jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
            this.juspayServices.setUpMerchantFragments(jSONObject2);
        } catch (JSONException unused) {
        }
        if (jSONObject.has(REQUEST_ID)) {
            ExecutorManager.runOnMainThread(new h(this, System.currentTimeMillis(), jSONObject, 1));
        } else {
            logSafeEvents("error", Labels.HyperSdk.PROCESS, "request_id_present", Boolean.FALSE);
        }
    }

    private String getIdForActivity(FragmentActivity fragmentActivity) {
        for (Map.Entry<WeakReference<FragmentActivity>, String> entry : this.activityIds.entrySet()) {
            if (entry.getKey().get() == fragmentActivity) {
                return entry.getValue();
            }
        }
        String string = UUID.randomUUID().toString();
        this.activityIds.put(new WeakReference<>(fragmentActivity), string);
        return string;
    }

    public static JSONObject getVersions(@NonNull Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PaymentConstants.SDK_VERSION, IntegrationUtils.getSdkVersion(context));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void initiateNotCalled() {
        throw new IllegalStateException("initiate() must be called before calling process()");
    }

    private void initiateTerminated(JSONObject jSONObject) throws JSONException {
        notifyMerchant("JP_017", "process() called after terminate()", "process_result", jSONObject);
        logSafeEvents("error", Labels.HyperSdk.PROCESS, "interrupted", "process() called after terminate()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doProcess$11(long j2, JSONObject jSONObject) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "debug", Labels.HyperSdk.PROCESS, "main_thread_handover", Long.valueOf(System.currentTimeMillis() - j2));
        this.juspayServices.onMerchantEvent(Labels.HyperSdk.PROCESS, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOnEvent$0() {
        this.onBackPressedCallback.setEnabled(this.jpConsumingBackPress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOnEvent$1() {
        this.sdkStateReference.set(SDKState.INITIATE_COMPLETED);
        runProcessWaitQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$3() {
        if (this.hyperExceptionHandler == null) {
            this.hyperExceptionHandler = new HyperExceptionHandler(this);
        }
        this.hyperExceptionHandler.setAsDefaultExceptionHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$4(long j2, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) throws JSONException {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "debug", Labels.HyperSdk.INITIATE, "main_thread_handover", Long.valueOf(System.currentTimeMillis() - j2));
        setupJuspayServices(jSONObject, hyperPaymentsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$process$10(FragmentActivity fragmentActivity) {
        try {
            OnBackPressedDispatcher onBackPressedDispatcher = fragmentActivity.getOnBackPressedDispatcher();
            OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
            onBackPressedDispatcher.getClass();
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            onBackPressedDispatcher.b(onBackPressedCallback);
        } catch (Exception e2) {
            logSafeExceptions(LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.ON_BACKPRESSED_CALLBACK, "Exception while adding onBackPressedCallback", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$process$6(JSONObject jSONObject) {
        HyperPaymentsCallback hyperPaymentsCallback = this.merchantCallback;
        if (hyperPaymentsCallback != null) {
            hyperPaymentsCallback.onEvent(jSONObject, new JuspayResponseHandlerDummyImpl());
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$process$7(FragmentActivity fragmentActivity, ViewGroup viewGroup, JSONObject jSONObject) throws JSONException {
        process(fragmentActivity, viewGroup, jSONObject, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$process$8(FragmentActivity fragmentActivity, ViewGroup viewGroup, JSONObject jSONObject) throws JSONException {
        process(fragmentActivity, viewGroup, jSONObject, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$process$9(SDKState sDKState, final JSONObject jSONObject, final FragmentActivity fragmentActivity, final ViewGroup viewGroup) {
        if (sDKState != SDKState.INITIATE_STARTED) {
            final int i2 = 1;
            ExecutorManager.runOnBackgroundThread(new Runnable(this) { // from class: in.juspay.hypersdk.services.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ HyperPaymentsServices f48718b;

                {
                    this.f48718b = this;
                }

                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    switch (i2) {
                        case 0:
                            this.f48718b.lambda$process$7(fragmentActivity, viewGroup, jSONObject);
                            break;
                        default:
                            this.f48718b.lambda$process$8(fragmentActivity, viewGroup, jSONObject);
                            break;
                    }
                }
            });
            return;
        }
        this.trackerFallBack.log(jSONObject, this.juspayServices, LogType.PROCESS_QUEUED);
        logSafeEvents("info", Labels.HyperSdk.PROCESS, "queued process " + this.processWaitingQueue.size(), jSONObject);
        final int i3 = 0;
        this.processWaitingQueue.add(new Runnable(this) { // from class: in.juspay.hypersdk.services.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HyperPaymentsServices f48718b;

            {
                this.f48718b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                switch (i3) {
                    case 0:
                        this.f48718b.lambda$process$7(fragmentActivity, viewGroup, jSONObject);
                        break;
                    default:
                        this.f48718b.lambda$process$8(fragmentActivity, viewGroup, jSONObject);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runProcessWaitQueue$5() {
        logSafeEvents("info", Labels.HyperSdk.PROCESS_WAIT_QUEUE, "pending_processes", Integer.valueOf(this.processWaitingQueue.size()));
        while (!this.processWaitingQueue.isEmpty()) {
            Runnable runnablePoll = this.processWaitingQueue.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupJuspayServices$2(JSONObject jSONObject) throws JSONException {
        this.sdkStateReference.set(SDKState.INITIATE_COMPLETED);
        notifyMerchant("JP_020", "No web view is present in the device", "initiate_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$terminate$12(long j2) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "debug", Labels.HyperSdk.TERMINATE, "main_thread_handover", Long.valueOf(System.currentTimeMillis() - j2));
        try {
            this.juspayServices.terminate();
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.TERMINATE, "Failed to remove the fragment", e2);
        }
        this.container = null;
        this.activity = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uncaughtException$13(Throwable th) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        sdkTracker.addLogToPersistedQueue(sdkTracker.getExceptionLog("lifecycle", LogSubCategory.LifeCycle.HYPER_SDK, Labels.System.SDK_CRASHED, "SDK Crashed Uncaught exception handler", th));
    }

    private void logSafeEvents(String str, String str2, String str3, Object obj) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, str, str2, str3, obj);
    }

    private void logSafeExceptions(String str, String str2, String str3, Throwable th) {
        this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "lifecycle", str, str2, str3, th);
    }

    private void notifyMerchant(String str, String str2, String str3, JSONObject jSONObject) throws JSONException {
        HyperPaymentsCallback hyperPaymentsCallback = this.merchantCallback;
        if (hyperPaymentsCallback != null) {
            logSafeEvents("error", str3.equals("initiate_result") ? Labels.HyperSdk.INITIATE : Labels.HyperSdk.PROCESS, "ended", notifyMerchant(hyperPaymentsCallback, str, str2, str3, jSONObject));
        }
    }

    private boolean objectMatch(Object obj, Object obj2) {
        if (Objects.equals(obj, null) || Objects.equals(obj2, null) || !obj.getClass().equals(obj2.getClass())) {
            return false;
        }
        if (!(obj2 instanceof JSONObject)) {
            return obj2 instanceof String ? obj2.equals(obj) : obj == obj2;
        }
        JSONObject jSONObject = (JSONObject) obj2;
        if (jSONObject.length() == 0) {
            return false;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!objectMatch(jSONObject2.opt(next), jSONObject.opt(next))) {
                return false;
            }
        }
        return true;
    }

    public static void preFetch(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        preFetch(context, jSONObject, null, null);
    }

    private void runProcessWaitQueue() {
        ExecutorManager.runOnBackgroundThread(new b(this, 0));
    }

    private void setupJuspayServices(@NonNull JSONObject jSONObject, @NonNull HyperPaymentsCallback hyperPaymentsCallback) throws JSONException {
        this.merchantCallback = hyperPaymentsCallback;
        modifyParams(jSONObject);
        this.juspayServices.setBundleParameter(jSONObject);
        this.juspayServices.setHyperCallback(new HyperPaymentsCallbackAdapter() { // from class: in.juspay.hypersdk.services.HyperPaymentsServices.2
            @Override // in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter, in.juspay.hypersdk.ui.HyperPaymentsCallback
            @Nullable
            public WebViewClient createJuspaySafeWebViewClient() {
                return HyperPaymentsServices.this.merchantCallback.createJuspaySafeWebViewClient();
            }

            @Override // in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter, in.juspay.hypersdk.ui.HyperPaymentsCallback
            @Nullable
            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                return HyperPaymentsServices.this.merchantCallback.getMerchantView(viewGroup, merchantViewType);
            }

            @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
            public void onEvent(JSONObject jSONObject2, JuspayResponseHandler juspayResponseHandler) {
                if (HyperPaymentsServices.this.handleOnEvent(jSONObject2)) {
                    HyperPaymentsServices.this.merchantCallback.onEvent(jSONObject2, juspayResponseHandler);
                }
            }

            @Override // in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter, in.juspay.hypersdk.ui.HyperPaymentsCallback
            public void onStartWaitingDialogCreated(@Nullable View view) {
                HyperPaymentsServices.this.merchantCallback.onStartWaitingDialogCreated(view);
            }
        });
        this.juspayServices.initiate(new in.juspay.hypernfc.b(13, this, jSONObject));
    }

    private boolean shouldPushExp(String str, JSONObject jSONObject) {
        if (!this.juspayServices.getLogManager().experimentalEnabled()) {
            return false;
        }
        try {
            JSONObject jSONObjectOptJSONObject = this.juspayServices.getSdkConfigService().getSdkConfig().optJSONObject("logsConfig");
            if (jSONObjectOptJSONObject != null) {
                if (!str.equals(jSONObjectOptJSONObject.optString("bufferLogsTill", str))) {
                    return false;
                }
                if (!shouldStopBuffer(jSONObjectOptJSONObject, jSONObject)) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    private boolean shouldStopBuffer(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (!jSONObject.has("dontStopBufferOn")) {
            return true;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dontStopBufferOn");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (objectMatch(jSONObject2, jSONArray.get(i2))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uncaughtException(Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new in.juspay.hypernfc.b(11, this, th));
    }

    public boolean checkAndStartInitiate(JSONObject jSONObject) throws JSONException {
        SDKState sDKState = this.sdkStateReference.get();
        SDKState sDKState2 = SDKState.INITIATE_STARTED;
        if (sDKState == sDKState2 || sDKState == SDKState.INITIATE_COMPLETED) {
            notifyMerchant("JP_017", "initiate() can only be called once without terminate()", "initiate_result", jSONObject);
            logSafeEvents("error", Labels.HyperSdk.INITIATE, "interrupted", "initiate() can only be called once without terminate()");
            return false;
        }
        this.sdkStateReference.set(sDKState2);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "started", "Started initiating the SDK");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleOnEvent(org.json.JSONObject r12) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.services.HyperPaymentsServices.handleOnEvent(org.json.JSONObject):boolean");
    }

    @Keep
    public void initiate(@NonNull FragmentActivity fragmentActivity, @NonNull ViewGroup viewGroup, @NonNull JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) throws JSONException {
        this.container = viewGroup;
        initiate(fragmentActivity, jSONObject, hyperPaymentsCallback);
    }

    @Keep
    public boolean isInitialised() throws JSONException {
        SDKState sDKState = this.sdkStateReference.get();
        boolean z = sDKState == SDKState.INITIATE_STARTED || sDKState == SDKState.INITIATE_COMPLETED;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkState", String.valueOf(sDKState));
            jSONObject.put("isInitialised", z);
        } catch (JSONException unused) {
        }
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "isInitialised()", jSONObject);
        return z;
    }

    public void modifyParams(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put("service_based", true);
            jSONObject.put("use_local_assets", jSONObject.optBoolean("useLocalAssets", this.context.getResources().getBoolean(R.bool.use_local_assets)));
            jSONObject.getJSONObject(PaymentConstants.PAYLOAD).put("currentActivityId", this.currentActivityId);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "Failed to write to JSON", e2);
        }
    }

    @Keep
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.juspayServices.onActivityResult(i2 & Message.MAXLENGTH, i3, intent);
    }

    public boolean onBackPressed() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consuming_backpress", this.jpConsumingBackPress);
            jSONObject.put("triggered_on", "HyperPaymentsServices.onBackPressed()");
        } catch (Exception unused) {
        }
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.ANDROID, "info", Labels.Android.BACK_PRESSED, jSONObject);
        if (!this.jpConsumingBackPress) {
            return false;
        }
        this.juspayServices.onBackPressed();
        return true;
    }

    @Keep
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) throws JSONException {
        this.juspayServices.onRequestPermissionsResult(i2 & Message.MAXLENGTH, strArr, iArr);
    }

    @Keep
    public void process(@NonNull FragmentActivity fragmentActivity, @NonNull JSONObject jSONObject) throws JSONException {
        process(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(android.R.id.content), jSONObject, Boolean.FALSE);
    }

    @Keep
    public void resetActivity(FragmentActivity fragmentActivity) {
        if (fragmentActivity != this.activity) {
            return;
        }
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.TERMINATE, "resetActivity()", "called");
        this.juspayServices.reset();
        OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
        Objects.requireNonNull(onBackPressedCallback);
        ExecutorManager.runOnMainThread(new com.swmansion.gesturehandler.react.b(onBackPressedCallback, 8));
        this.onBackPressedCallbackSet.clear();
        this.activity = null;
        this.currentActivityId = null;
        this.container = null;
    }

    @Keep
    public void setActivityLaunchDelegate(@NonNull ActivityLaunchDelegate activityLaunchDelegate) {
        this.juspayServices.setActivityLaunchDelegate(activityLaunchDelegate);
    }

    @Keep
    public void setIntentSenderDelegate(@NonNull IntentSenderDelegate intentSenderDelegate) {
        this.juspayServices.setIntentSenderDelegate(intentSenderDelegate);
    }

    @Keep
    public void setRequestPermissionDelegate(@NonNull RequestPermissionDelegate requestPermissionDelegate) {
        this.juspayServices.setRequestPermissionDelegate(requestPermissionDelegate);
    }

    @Keep
    public void setWebViewConfigurationCallback(@NonNull JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        this.juspayServices.setWebViewConfigurationCallback(juspayWebViewConfigurationCallback);
    }

    public void terminate(JSONObject jSONObject) {
        logSafeEvents("info", Labels.HyperSdk.TERMINATE_PROCESS, "request", jSONObject);
        this.juspayServices.onMerchantEvent(Labels.HyperSdk.TERMINATE, jSONObject);
    }

    @Keep
    public HyperPaymentsServices(@NonNull Context context, @Nullable String str) {
        this(context, (TenantParams) null, str);
    }

    @Keep
    public static void preFetch(@NonNull Context context, @NonNull JSONObject jSONObject, @Nullable String str) throws JSONException {
        PrefetchServices.preFetch(context, jSONObject, str, null);
    }

    @Keep
    public void process(@NonNull FragmentActivity fragmentActivity, @NonNull ViewGroup viewGroup, @NonNull JSONObject jSONObject) throws JSONException {
        process(fragmentActivity, viewGroup, jSONObject, Boolean.FALSE);
    }

    @Keep
    public HyperPaymentsServices(@NonNull Context context, @Nullable TenantParams tenantParams, @Nullable String str) {
        this.processWaitingQueue = new LinkedList();
        this.onBackPressedCallbackSet = Collections.newSetFromMap(new ConcurrentHashMap());
        this.context = context;
        JuspayCoreLib.setApplicationContext(context.getApplicationContext());
        this.activityIds = new HashMap<>();
        this.jpConsumingBackPress = false;
        JuspayServices juspayServices = new JuspayServices(context, tenantParams, str, false);
        this.juspayServices = juspayServices;
        this.hyperExceptionHandler = new HyperExceptionHandler(this);
        this.sdkStateReference = new AtomicReference<>(SDKState.INSTANTIATED);
        this.trackerFallBack = new TrackerFallback(context, juspayServices.getSdkConfigService().getSdkConfig());
        this.onBackPressedCallback = new OnBackPressedCallback(false) { // from class: in.juspay.hypersdk.services.HyperPaymentsServices.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("triggered_on", "onBackPressedCallback.handleOnBackPressed()");
                } catch (Exception unused) {
                }
                HyperPaymentsServices.this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.ANDROID, "info", Labels.Android.BACK_PRESSED, jSONObject);
                HyperPaymentsServices.this.juspayServices.onBackPressed();
            }
        };
    }

    @Keep
    public static void preFetch(@NonNull Context context, @NonNull JSONObject jSONObject, @Nullable String str, @Nullable TenantParams tenantParams) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (str == null || str.isEmpty()) {
            if (jSONObject.has("clientId")) {
                str = jSONObject.optString("clientId", null);
            } else if (jSONObject.has(PaymentConstants.PAYLOAD) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(PaymentConstants.PAYLOAD)) != null && jSONObjectOptJSONObject.has("clientId")) {
                str = jSONObjectOptJSONObject.optString("clientId", null);
            }
        }
        PrefetchServices.preFetch(context, jSONObject, str, tenantParams);
    }

    @Keep
    private void process(@NonNull final FragmentActivity fragmentActivity, @NonNull final ViewGroup viewGroup, @NonNull final JSONObject jSONObject, Boolean bool) throws JSONException {
        final SDKState sDKState = this.sdkStateReference.get();
        try {
            if (!bool.booleanValue()) {
                ArrayList<HyperBridge> arrayList = this.juspayServices.getRegisteredServices().get(jSONObject.getString(PaymentConstants.SERVICE));
                if (arrayList != null) {
                    com.brentvatne.react.c cVar = new com.brentvatne.react.c(this, 6);
                    Iterator<HyperBridge> it = arrayList.iterator();
                    while (it.hasNext()) {
                        HyperBridge next = it.next();
                        if (next.process(jSONObject, cVar).getProcessConsumed()) {
                            logSafeEvents("info", Labels.HyperSdk.PROCESS, "process_consumed_by_bridge", next.getInterfaceName());
                            return;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            logSafeExceptions(LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.PROCESS, "Exception while forwarding process call to bridge", e2);
        }
        int i2 = AnonymousClass3.$SwitchMap$in$juspay$hypersdk$services$SDKState[sDKState.ordinal()];
        if (i2 == 1) {
            logSafeEvents("error", Labels.HyperSdk.PROCESS, "called_before_initiate", jSONObject);
            initiateNotCalled();
            return;
        }
        if (i2 == 2) {
            ExecutorManager.runOnProcessQueuePool(new Runnable() { // from class: in.juspay.hypersdk.services.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48728a.lambda$process$9(sDKState, jSONObject, fragmentActivity, viewGroup);
                }
            });
            return;
        }
        if (i2 == 3) {
            logSafeEvents("info", Labels.HyperSdk.PROCESS, "called_and_started", jSONObject);
            if (!this.juspayServices.isWebViewAvailable()) {
                notifyMerchant("JP_020", "No web view is present in the device", "process_result", jSONObject);
                return;
            }
            if (fragmentActivity != this.activity) {
                logSafeEvents("info", Labels.HyperSdk.PROCESS, "activity_changed", "true");
            }
            if (this.onBackPressedCallbackSet.add(getIdForActivity(fragmentActivity))) {
                ExecutorManager.runOnMainThread(new in.juspay.hypernfc.b(12, this, fragmentActivity));
            }
            this.container = viewGroup;
            this.activity = fragmentActivity;
            this.currentActivityId = getIdForActivity(fragmentActivity);
            this.juspayServices.getSessionInfo().addOrderIdInSessionData(jSONObject);
            this.juspayServices.process(fragmentActivity, this.container);
            if (shouldPushExp(Labels.HyperSdk.PROCESS, jSONObject)) {
                this.juspayServices.getLogManager().startPushExp();
            }
            doProcess(jSONObject);
        } else if (i2 == 4) {
            logSafeEvents("error", Labels.HyperSdk.PROCESS, "called_after_terminate", jSONObject);
            initiateTerminated(jSONObject);
        }
    }

    @Keep
    public void initiate(@NonNull FragmentActivity fragmentActivity, @NonNull JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) throws JSONException {
        if (this.activity != fragmentActivity) {
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "activity_changed", "true");
        }
        this.activity = fragmentActivity;
        this.currentActivityId = getIdForActivity(fragmentActivity);
        initiate(jSONObject, hyperPaymentsCallback);
    }

    @Keep
    public void terminate() {
        SDKState sDKState = this.sdkStateReference.get();
        SDKState sDKState2 = SDKState.TERMINATED;
        if (sDKState == sDKState2) {
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "warning", Labels.HyperSdk.TERMINATE, "started", "Terminate called again, skipping");
            return;
        }
        if (sDKState == SDKState.INSTANTIATED) {
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "warning", Labels.HyperSdk.TERMINATE, "started", "Terminate called without initiate, skipping");
            return;
        }
        this.sdkStateReference.set(sDKState2);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.TERMINATE, "started", "Terminating the SDK");
        this.jpConsumingBackPress = false;
        HyperExceptionHandler hyperExceptionHandler = this.hyperExceptionHandler;
        if (hyperExceptionHandler != null) {
            hyperExceptionHandler.clearHyperExceptionHandler();
            this.hyperExceptionHandler = null;
        }
        resetActivity(this.activity);
        ExecutorManager.runOnMainThread(new f(this, 1, System.currentTimeMillis()));
        this.juspayServices.getSessionInfo().resetSession();
        this.juspayServices.getLogManager().stopPushTasks();
    }

    private JSONObject notifyMerchant(@NonNull HyperPaymentsCallback hyperPaymentsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(REQUEST_ID, jSONObject.optString(REQUEST_ID, ""));
            jSONObject2.put(PaymentConstants.SERVICE, jSONObject.optString(PaymentConstants.SERVICE, PaymentConstants.SERVICE));
            jSONObject2.put("error", true);
            jSONObject2.put(CLConstants.FIELD_ERROR_CODE, str);
            jSONObject2.put("errorMessage", str2);
            jSONObject2.put("event", str3);
            jSONObject2.put(PaymentConstants.PAYLOAD, new JSONObject());
            hyperPaymentsCallback.onEvent(jSONObject2, new JuspayResponseHandlerDummyImpl());
            return jSONObject2;
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", Labels.HyperSdk.EXIT_SDK_ERROR, "Error while sending response to merchant", e2);
            return jSONObject2;
        }
    }

    @Keep
    public void initiate(@NonNull final JSONObject jSONObject, @NonNull final HyperPaymentsCallback hyperPaymentsCallback) throws JSONException {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.PAYLOAD);
            jSONObject2.put("initiateStartedTime", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
        } catch (JSONException unused) {
        }
        if (checkAndStartInitiate(jSONObject)) {
            this.trackerFallBack.log(jSONObject, this.juspayServices, LogType.INITIATE_START);
            this.juspayServices.getSdkTracker().resetSerialNumber();
            this.juspayServices.getSessionInfo().setSessionId();
            this.juspayServices.getLogManager().startPushTasks(shouldPushExp(Labels.HyperSdk.INITIATE, jSONObject));
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "started", jSONObject);
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "fragment_activity_used", String.valueOf(this.activity != null));
            ExecutorManager.runOnBackgroundThread(new b(this, 1));
            final long jCurrentTimeMillis = System.currentTimeMillis();
            ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hypersdk.services.c
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f48724a.lambda$initiate$4(jCurrentTimeMillis, jSONObject, hyperPaymentsCallback);
                }
            });
        }
    }

    @Keep
    @Deprecated
    public HyperPaymentsServices(Activity activity) throws InstantiationException {
        String strD;
        this.processWaitingQueue = new LinkedList();
        this.onBackPressedCallbackSet = Collections.newSetFromMap(new ConcurrentHashMap());
        if (activity != null) {
            strD = android.support.v4.media.b.D(" (", activity.getClass().getName(), ")");
        } else {
            strD = "";
        }
        throw new InstantiationException(android.support.v4.media.b.D("Instantiating HyperPaymentsServices with plain Activity", strD, " is not allowed, please pass FragmentActivity"));
    }

    @Keep
    public HyperPaymentsServices(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(android.R.id.content), (String) null);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.HYPER_SERVICE, "view_group", Boolean.FALSE);
    }

    @Keep
    public HyperPaymentsServices(@NonNull FragmentActivity fragmentActivity, @Nullable String str) {
        this(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(android.R.id.content), str);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.HYPER_SERVICE, "view_group", Boolean.FALSE);
    }

    @Keep
    public void process(@NonNull JSONObject jSONObject) throws JSONException {
        SDKState sDKState = this.sdkStateReference.get();
        if (sDKState == SDKState.INSTANTIATED) {
            initiateNotCalled();
            return;
        }
        if (sDKState == SDKState.TERMINATED) {
            initiateTerminated(jSONObject);
            return;
        }
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity == null) {
            notifyMerchant("JP_003", "FragmentActivity needs to be send in process", "process_result", jSONObject);
            return;
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            process(fragmentActivity, viewGroup, jSONObject);
        } else {
            process(fragmentActivity, jSONObject);
        }
    }

    @Keep
    public HyperPaymentsServices(@NonNull FragmentActivity fragmentActivity, @NonNull ViewGroup viewGroup) {
        this(fragmentActivity, viewGroup, (String) null);
    }

    @Keep
    public HyperPaymentsServices(@NonNull FragmentActivity fragmentActivity, @NonNull ViewGroup viewGroup, @Nullable String str) {
        this(fragmentActivity, viewGroup, null, str);
    }

    @Keep
    public HyperPaymentsServices(@NonNull FragmentActivity fragmentActivity, @Nullable ViewGroup viewGroup, @Nullable TenantParams tenantParams, @Nullable String str) {
        this(fragmentActivity.getApplicationContext(), tenantParams, str);
        this.activity = fragmentActivity;
        this.container = viewGroup;
        this.currentActivityId = getIdForActivity(fragmentActivity);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.HYPER_SERVICE, "sdk_create", APayConstants.SUCCESS);
    }
}
