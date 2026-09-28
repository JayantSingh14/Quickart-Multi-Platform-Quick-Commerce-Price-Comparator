package in.juspay.hypersdkreact;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.media.b;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypercheckoutlite.HyperCheckoutLite;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.services.HyperServices;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = HyperSdkReactModule.NAME)
/* loaded from: classes.dex */
public class HyperSdkReactModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String HYPER_EVENT = "HyperEvent";
    static final String NAME = "HyperSdkReact";
    private static final ActivityResultDelegate activityResultDelegate;
    private static final Object lock = new Object();
    private static final RequestPermissionsResultDelegate requestPermissionsResultDelegate;
    private final ReactApplicationContext context;

    @Nullable
    private HyperServices hyperServices;

    @NonNull
    private WeakReference<Activity> processActivityRef;
    private boolean wasProcessWithActivity;

    public static class ActivityResultDelegate {

        @NonNull
        private WeakReference<HyperServices> hyperServicesHolder;

        public /* synthetic */ ActivityResultDelegate(int i2) {
            this();
        }

        public void onActivityResult(int i2, int i3, Intent intent) {
            HyperServices hyperServices = this.hyperServicesHolder.get();
            if (hyperServices == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", "onActivityResult", "hyperServices is null");
                return;
            }
            StringBuilder sbT = b.t(i2, i3, "onActivityResult() called with: requestCode = [", "], resultCode = [", "], data = [");
            sbT.append(intent);
            sbT.append("]");
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "hyper_sdk_react", "onActivityResult", sbT.toString());
            hyperServices.onActivityResult(i2, i3, intent);
        }

        public synchronized void set(@NonNull HyperServices hyperServices) {
            this.hyperServicesHolder = new WeakReference<>(hyperServices);
        }

        private ActivityResultDelegate() {
            this.hyperServicesHolder = new WeakReference<>(null);
        }
    }

    public static class RequestPermissionsResultDelegate {

        @NonNull
        private WeakReference<HyperServices> hyperServicesHolder;

        public /* synthetic */ RequestPermissionsResultDelegate(int i2) {
            this();
        }

        public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
            HyperServices hyperServices = this.hyperServicesHolder.get();
            if (hyperServices == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", "onRequestPermissionsResult", "hyperServices is null");
                return;
            }
            StringBuilder sbU = b.u(i2, "onRequestPermissionsResult() called with: requestCode = [", "], permissions = [");
            sbU.append(Arrays.toString(strArr));
            sbU.append("], grantResults = [");
            sbU.append(Arrays.toString(iArr));
            sbU.append("]");
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "hyper_sdk_react", "onRequestPermissionsResult", sbU.toString());
            hyperServices.onRequestPermissionsResult(i2, strArr, iArr);
        }

        public synchronized void set(@NonNull HyperServices hyperServices) {
            this.hyperServicesHolder = new WeakReference<>(hyperServices);
        }

        private RequestPermissionsResultDelegate() {
            this.hyperServicesHolder = new WeakReference<>(null);
        }
    }

    static {
        int i2 = 0;
        requestPermissionsResultDelegate = new RequestPermissionsResultDelegate(i2);
        activityResultDelegate = new ActivityResultDelegate(i2);
    }

    public HyperSdkReactModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.wasProcessWithActivity = false;
        this.processActivityRef = new WeakReference<>(null);
        this.context = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    @Keep
    public static Set<Integer> getIntentRequestCodes() {
        return ReactLaunchDelegate.getIntentRequestCodes();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getJSModule() {
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    public static Set<Integer> getPermissionRequestCodes() {
        return ReactRequestDelegate.getPermissionRequestCodes();
    }

    @Keep
    public static void onActivityResult(int i2, int i3, Intent intent) {
        synchronized (lock) {
            activityResultDelegate.onActivityResult(i2, i3, intent);
        }
    }

    public static void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        synchronized (lock) {
            requestPermissionsResultDelegate.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendEventToJS, reason: merged with bridge method [inline-methods] */
    public void lambda$sendEventToJS$0(JSONObject jSONObject) {
        DeviceEventManagerModule.RCTDeviceEventEmitter jSModule = getJSModule();
        if (jSModule == null) {
            new Handler().postDelayed(new in.juspay.hypernfc.b(14, this, jSONObject), 200L);
        } else {
            jSModule.emit(HYPER_EVENT, jSONObject.toString());
        }
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void createHyperServices() {
        synchronized (lock) {
            try {
                FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
                if (fragmentActivity == null) {
                    SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", "createHyperServices", "activity is null");
                    return;
                }
                if (this.hyperServices != null) {
                    SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "warn", "hyper_sdk_react", "createHyperServices", "hyperServices instance already exists");
                    return;
                }
                HyperServices hyperServices = new HyperServices(fragmentActivity);
                this.hyperServices = hyperServices;
                requestPermissionsResultDelegate.set(hyperServices);
                activityResultDelegate.set(this.hyperServices);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        return new HashMap<String, Object>() { // from class: in.juspay.hypersdkreact.HyperSdkReactModule.1
            {
                put(HyperSdkReactModule.HYPER_EVENT, HyperSdkReactModule.HYPER_EVENT);
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void initiate(String str) {
        JSONObject jSONObject;
        FragmentActivity fragmentActivity;
        synchronized (lock) {
            try {
                jSONObject = new JSONObject(str);
                fragmentActivity = (FragmentActivity) getCurrentActivity();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (fragmentActivity == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "activity is null");
                return;
            }
            HyperServices hyperServices = this.hyperServices;
            if (hyperServices == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "hyperServices is null");
            } else {
                hyperServices.initiate(fragmentActivity, jSONObject, new HyperPaymentsCallbackAdapter() { // from class: in.juspay.hypersdkreact.HyperSdkReactModule.2
                    @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
                    public void onEvent(JSONObject jSONObject2, JuspayResponseHandler juspayResponseHandler) {
                        if (jSONObject2.optString("event").equals("process_result") && HyperSdkReactModule.this.wasProcessWithActivity) {
                            Activity activity = (Activity) HyperSdkReactModule.this.processActivityRef.get();
                            if (activity != null) {
                                activity.finish();
                                activity.overridePendingTransition(0, android.R.anim.fade_out);
                            }
                            ProcessActivity.setActivityCallback(null);
                            HyperSdkReactModule.this.wasProcessWithActivity = false;
                            HyperSdkReactModule.this.processActivityRef = new WeakReference(null);
                        }
                        HyperSdkReactModule.this.lambda$sendEventToJS$0(jSONObject2);
                    }
                });
            }
        }
    }

    @ReactMethod
    public void isInitialised(Promise promise) {
        boolean zIsInitialised;
        synchronized (lock) {
            HyperServices hyperServices = this.hyperServices;
            if (hyperServices != null) {
                try {
                    zIsInitialised = hyperServices.isInitialised();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                zIsInitialised = false;
            }
        }
        promise.resolve(Boolean.valueOf(zIsInitialised));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isNull() {
        return this.hyperServices == null;
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean onBackPressed() {
        boolean z;
        synchronized (lock) {
            try {
                HyperServices hyperServices = this.hyperServices;
                z = hyperServices != null && hyperServices.onBackPressed();
            } finally {
            }
        }
        return z;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void openPaymentPage(String str) {
        final JSONObject jSONObject;
        FragmentActivity fragmentActivity;
        synchronized (lock) {
            try {
                jSONObject = new JSONObject(str);
                fragmentActivity = (FragmentActivity) getCurrentActivity();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (fragmentActivity == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "activity is null");
                return;
            }
            Intent intent = new Intent(fragmentActivity, (Class<?>) ProcessActivity.class);
            ProcessActivity.setActivityCallback(new ActivityCallback() { // from class: in.juspay.hypersdkreact.HyperSdkReactModule.4
                @Override // in.juspay.hypersdkreact.ActivityCallback
                public boolean onBackPressed() {
                    return HyperCheckoutLite.onBackPressed();
                }

                @Override // in.juspay.hypersdkreact.ActivityCallback
                public void onCreated(@NonNull final FragmentActivity fragmentActivity2) {
                    HyperCheckoutLite.openPaymentPage(fragmentActivity2, jSONObject, new HyperPaymentsCallbackAdapter() { // from class: in.juspay.hypersdkreact.HyperSdkReactModule.4.1
                        @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
                        public void onEvent(JSONObject jSONObject2, JuspayResponseHandler juspayResponseHandler) {
                            if (jSONObject2.optString("event").equals("process_result")) {
                                fragmentActivity2.finish();
                                fragmentActivity2.overridePendingTransition(0, android.R.anim.fade_out);
                                ProcessActivity.setActivityCallback(null);
                            }
                            HyperSdkReactModule.this.lambda$sendEventToJS$0(jSONObject2);
                        }
                    });
                }

                @Override // in.juspay.hypersdkreact.ActivityCallback
                public void resetActivity(@NonNull FragmentActivity fragmentActivity2) {
                }
            });
            fragmentActivity.startActivity(intent);
        }
    }

    @ReactMethod
    public void preFetch(String str) {
        try {
            HyperServices.preFetch(getReactApplicationContext(), new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @ReactMethod
    public void process(String str) {
        JSONObject jSONObject;
        FragmentActivity fragmentActivity;
        synchronized (lock) {
            try {
                jSONObject = new JSONObject(str);
                fragmentActivity = (FragmentActivity) getCurrentActivity();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (fragmentActivity == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "activity is null");
                return;
            }
            HyperServices hyperServices = this.hyperServices;
            if (hyperServices == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "hyperServices is null");
                return;
            }
            hyperServices.setActivityLaunchDelegate(new ReactLaunchDelegate(this.context));
            this.hyperServices.setRequestPermissionDelegate(new ReactRequestDelegate(fragmentActivity));
            this.hyperServices.process(fragmentActivity, jSONObject);
        }
    }

    @ReactMethod
    public void processWithActivity(String str) {
        final JSONObject jSONObject;
        FragmentActivity fragmentActivity;
        synchronized (lock) {
            try {
                jSONObject = new JSONObject(str);
                fragmentActivity = (FragmentActivity) getCurrentActivity();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (fragmentActivity == null) {
                SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "activity is null");
                return;
            }
            Intent intent = new Intent(fragmentActivity, (Class<?>) ProcessActivity.class);
            ProcessActivity.setActivityCallback(new ActivityCallback() { // from class: in.juspay.hypersdkreact.HyperSdkReactModule.3
                @Override // in.juspay.hypersdkreact.ActivityCallback
                public boolean onBackPressed() {
                    return HyperSdkReactModule.this.onBackPressed();
                }

                @Override // in.juspay.hypersdkreact.ActivityCallback
                public void onCreated(@NonNull FragmentActivity fragmentActivity2) {
                    if (HyperSdkReactModule.this.hyperServices == null) {
                        SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", Labels.HyperSdk.INITIATE, "hyperServices is null");
                        return;
                    }
                    HyperSdkReactModule.this.wasProcessWithActivity = true;
                    HyperSdkReactModule.this.processActivityRef = new WeakReference(fragmentActivity2);
                    HyperSdkReactModule.this.hyperServices.process(fragmentActivity2, jSONObject);
                }

                @Override // in.juspay.hypersdkreact.ActivityCallback
                public void resetActivity(@NonNull FragmentActivity fragmentActivity2) {
                    if (HyperSdkReactModule.this.hyperServices != null) {
                        HyperSdkReactModule.this.hyperServices.resetActivity(fragmentActivity2);
                    }
                }
            });
            fragmentActivity.startActivity(intent);
        }
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void terminate() {
        synchronized (lock) {
            try {
                HyperServices hyperServices = this.hyperServices;
                if (hyperServices != null) {
                    hyperServices.terminate();
                }
                this.hyperServices = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        synchronized (lock) {
            try {
                HyperServices hyperServices = this.hyperServices;
                if (hyperServices == null) {
                    SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "error", "hyper_sdk_react", "onActivityResult", "hyperServices is null");
                } else {
                    hyperServices.onActivityResult(i2, i3, intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
