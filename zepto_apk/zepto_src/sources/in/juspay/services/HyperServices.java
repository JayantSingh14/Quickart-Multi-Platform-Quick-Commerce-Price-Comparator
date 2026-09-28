package in.juspay.services;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.services.HyperPaymentsServices;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class HyperServices {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static TenantParams tenantParams = new TenantParams() { // from class: in.juspay.services.HyperServices$Companion$tenantParams$1
        @Override // in.juspay.services.TenantParams
        @NotNull
        public List<Class<? extends HyperBridge>> getBridgeClasses() {
            return new ArrayList();
        }

        @Override // in.juspay.services.TenantParams
        @Nullable
        public JSONObject getLogsEndPoint() {
            TenantMap tenantMap = HyperServices.tenantVal;
            if (tenantMap != null) {
                return tenantMap.getLogsEndPoints();
            }
            Intrinsics.h("tenantVal");
            throw null;
        }

        @Override // in.juspay.services.TenantParams
        @NotNull
        public String getOTAEndPoint() {
            TenantMap tenantMap = HyperServices.tenantVal;
            if (tenantMap != null) {
                return tenantMap.getReleaseConfigTemplateUrl();
            }
            Intrinsics.h("tenantVal");
            throw null;
        }

        @Override // in.juspay.services.TenantParams
        @NotNull
        public String getTenant() {
            TenantMap tenantMap = HyperServices.tenantVal;
            if (tenantMap != null) {
                return tenantMap.getTenant();
            }
            Intrinsics.h("tenantVal");
            throw null;
        }
    };
    private static TenantMap tenantVal;

    @NotNull
    private HyperPaymentsServices hyperPaymentServices;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Keep
        @NotNull
        public final JSONObject getVersions(@NotNull Context context) throws JSONException {
            Intrinsics.checkNotNullParameter(context, "context");
            JSONObject versions = HyperPaymentsServices.getVersions(context);
            Intrinsics.checkNotNullExpressionValue(versions, "getVersions(context)");
            return versions;
        }

        @JvmStatic
        @Keep
        public final void preFetch(@NotNull Context context, @NotNull JSONObject payload) throws JSONException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(payload, "payload");
            HyperPaymentsServices.preFetch(context, payload);
        }

        private Companion() {
        }

        @JvmStatic
        @Keep
        public final void preFetch(@NotNull Context context, @NotNull JSONObject payload, @Nullable String str) throws JSONException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(payload, "payload");
            HyperPaymentsServices.preFetch(context, payload, str);
        }

        @JvmStatic
        @Keep
        public final void preFetch(@NotNull Context context, @NotNull JSONObject payload, @NotNull TenantParams tenantParams) throws JSONException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(payload, "payload");
            Intrinsics.checkNotNullParameter(tenantParams, "tenantParams");
            HyperPaymentsServices.preFetch(context, payload, null, tenantParams);
        }
    }

    @Keep
    public HyperServices(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.hyperPaymentServices = new HyperPaymentsServices(context, (TenantParams) null, (String) null);
    }

    private final TenantMap getTenant(String str) {
        String lowerCase;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            lowerCase = null;
        }
        return Intrinsics.b(lowerCase, "juspayglobal") ? TenantMap.GLOBAL : TenantMap.DEFAULT;
    }

    @JvmStatic
    @Keep
    @NotNull
    public static final JSONObject getVersions(@NotNull Context context) {
        return Companion.getVersions(context);
    }

    @JvmStatic
    @Keep
    public static final void preFetch(@NotNull Context context, @NotNull JSONObject jSONObject) {
        Companion.preFetch(context, jSONObject);
    }

    @Keep
    public final void initiate(@NotNull FragmentActivity activity, @NotNull ViewGroup container, @NotNull JSONObject params, @NotNull HyperPaymentsCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.hyperPaymentServices.initiate(activity, container, params, callback);
    }

    @Keep
    public final boolean isInitialised() {
        return this.hyperPaymentServices.isInitialised();
    }

    @Keep
    public final void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        this.hyperPaymentServices.onActivityResult(i2, i3, intent);
    }

    @Keep
    public final boolean onBackPressed() {
        return this.hyperPaymentServices.onBackPressed();
    }

    @Keep
    public final void onRequestPermissionsResult(int i2, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        this.hyperPaymentServices.onRequestPermissionsResult(i2, permissions, grantResults);
    }

    @Keep
    public final void process(@NotNull FragmentActivity activity, @NotNull JSONObject payload) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.hyperPaymentServices.process(activity, payload);
    }

    @Keep
    public final void resetActivity(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hyperPaymentServices.resetActivity(activity);
    }

    @Keep
    public final void setActivityLaunchDelegate(@NotNull ActivityLaunchDelegate activityLaunchDelegate) {
        Intrinsics.checkNotNullParameter(activityLaunchDelegate, "activityLaunchDelegate");
        this.hyperPaymentServices.setActivityLaunchDelegate(activityLaunchDelegate);
    }

    @Keep
    public final void setIntentSenderDelegate(@NotNull IntentSenderDelegate intentSenderDelegate) {
        Intrinsics.checkNotNullParameter(intentSenderDelegate, "intentSenderDelegate");
        this.hyperPaymentServices.setIntentSenderDelegate(intentSenderDelegate);
    }

    @Keep
    public final void setRequestPermissionDelegate(@NotNull RequestPermissionDelegate requestPermissionDelegate) {
        Intrinsics.checkNotNullParameter(requestPermissionDelegate, "requestPermissionDelegate");
        this.hyperPaymentServices.setRequestPermissionDelegate(requestPermissionDelegate);
    }

    @Keep
    public final void setWebViewConfigurationCallback(@NotNull JuspayWebViewConfigurationCallback webViewConfigurationCallback) {
        Intrinsics.checkNotNullParameter(webViewConfigurationCallback, "webViewConfigurationCallback");
        this.hyperPaymentServices.setWebViewConfigurationCallback(webViewConfigurationCallback);
    }

    @Keep
    public final void terminate() {
        this.hyperPaymentServices.terminate();
    }

    @JvmStatic
    @Keep
    public static final void preFetch(@NotNull Context context, @NotNull JSONObject jSONObject, @NotNull TenantParams tenantParams2) throws JSONException {
        Companion.preFetch(context, jSONObject, tenantParams2);
    }

    @Keep
    public final void initiate(@NotNull FragmentActivity activity, @NotNull JSONObject params, @NotNull HyperPaymentsCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.hyperPaymentServices.initiate(activity, params, callback);
    }

    @Keep
    public final void process(@NotNull FragmentActivity activity, @NotNull ViewGroup viewGroup, @NotNull JSONObject payload) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.hyperPaymentServices.process(activity, viewGroup, payload);
    }

    @Keep
    public final void terminate(@NotNull JSONObject payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.hyperPaymentServices.terminate(payload);
    }

    @JvmStatic
    @Keep
    public static final void preFetch(@NotNull Context context, @NotNull JSONObject jSONObject, @Nullable String str) throws JSONException {
        Companion.preFetch(context, jSONObject, str);
    }

    @Keep
    public final void initiate(@NotNull JSONObject params, @NotNull HyperPaymentsCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.hyperPaymentServices.initiate(params, callback);
    }

    @Keep
    public final void process(@NotNull JSONObject payload) throws JSONException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.hyperPaymentServices.process(payload);
    }

    @Keep
    public HyperServices(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.hyperPaymentServices = new HyperPaymentsServices(context, (TenantParams) null, str);
    }

    @Keep
    public HyperServices(@NotNull Context context, @NotNull String tenant, @NotNull String clientId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tenant, "tenant");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        tenantVal = getTenant(tenant);
        this.hyperPaymentServices = new HyperPaymentsServices(context, tenantParams, clientId);
    }

    @Keep
    public HyperServices(@NotNull Context context, @Nullable TenantParams tenantParams2, @NotNull String clientId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.hyperPaymentServices = new HyperPaymentsServices(context, tenantParams2, clientId);
    }

    public HyperServices(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hyperPaymentServices = new HyperPaymentsServices(activity);
    }

    @Keep
    public HyperServices(@NotNull FragmentActivity activity, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hyperPaymentServices = new HyperPaymentsServices(activity, str);
    }

    @Keep
    public HyperServices(@NotNull FragmentActivity activity, @NotNull String tenant, @NotNull String clientId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(tenant, "tenant");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        tenantVal = getTenant(tenant);
        this.hyperPaymentServices = new HyperPaymentsServices(activity, tenantParams, clientId);
    }

    @Keep
    public HyperServices(@NotNull FragmentActivity activity, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        this.hyperPaymentServices = new HyperPaymentsServices(activity, container, (String) null);
    }

    @Keep
    public HyperServices(@NotNull FragmentActivity activity, @NotNull ViewGroup container, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        this.hyperPaymentServices = new HyperPaymentsServices(activity, container, null, str);
    }

    @Keep
    public HyperServices(@NotNull FragmentActivity activity, @Nullable ViewGroup viewGroup, @Nullable TenantParams tenantParams2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hyperPaymentServices = new HyperPaymentsServices(activity, viewGroup, tenantParams2, str);
    }
}
