package com.amazon.apay.hardened.external;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.apay.hardened.activity.APayBrowserActivity;
import com.amazon.apay.hardened.external.model.APayCallback;
import com.amazon.apay.hardened.external.model.APayError;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.amazon.apay.hardened.util.ValidationUtil;
import com.amazon.apay.instrumentation.logger.CrashEventsLogger;
import com.amazon.apay.instrumentation.logger.KuberMetricEventsLogger;
import com.amazon.apay.instrumentation.model.ClientSdkData;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import timber.log.Timber;

/* loaded from: classes3.dex */
public final class AmazonPayManager {
    public static CustomTabsIntent customTabsIntent;

    public static class a implements Listener<Void, AuthError> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APayCallback f14987a;

        public a(APayCallback aPayCallback) {
            this.f14987a = aPayCallback;
        }

        @Override // com.amazon.identity.auth.device.api.Listener
        public void onError(AuthError authError) {
            AuthError authError2 = authError;
            String message = authError2.getMessage() != null ? authError2.getMessage() : "null";
            String strValueOf = String.valueOf(authError2.getType());
            KuberMetricEventsLogger kuberMetricEventsLogger = com.amazon.apay.hardened.manager.b.f15004a;
            if (kuberMetricEventsLogger != null) {
                kuberMetricEventsLogger.addMetricEvent("SignOutError", "KUBER_HARDENED_SDK.SIGN_OUT_OPERATION", strValueOf, message);
            }
            this.f14987a.onError(new APayError(APayError.ErrorType.AUTH_ERROR, "SIGN_OUT_FAILED", authError2.getMessage(), authError2));
        }

        @Override // com.amazon.identity.auth.device.api.Listener
        public void onSuccess(Void r2) {
            com.amazon.apay.hardened.manager.b.a("SignOutSuccess", "KUBER_HARDENED_SDK.SIGN_OUT_OPERATION");
            this.f14987a.onSuccess();
        }
    }

    public static class b extends Timber.Tree {
        @Override // timber.log.Timber.Tree
        public void log(int i2, @Nullable String str, @NotNull String str2, @Nullable Throwable th) {
        }
    }

    public static void a(APayRequestContext aPayRequestContext, com.amazon.apay.hardened.constant.a aVar) {
        b bVar = new b();
        if (bVar == Timber.f58263c) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        ArrayList arrayList = Timber.f58261a;
        synchronized (arrayList) {
            arrayList.add(bVar);
            Timber.f58262b = (Timber.Tree[]) arrayList.toArray(new Timber.Tree[arrayList.size()]);
        }
        Timber.a("AmazonPayManager:init invoked: %s", aVar);
        Context context = aPayRequestContext.getContext();
        String clientId = aPayRequestContext.getClientId();
        Timber.a("in InstrumentationManager init", new Object[0]);
        ClientSdkData clientSdkData = new ClientSdkData("f6feefbb-ec15-40fc-a95d-920d767d36f0", context.getApplicationContext(), "KUBER_HARDENED_SDK", "H.1.1.13", android.support.v4.media.b.D("{\"MerchantID\":\"", clientId, "\"}"));
        com.amazon.apay.hardened.manager.b.f15004a = KuberMetricEventsLogger.Companion.getInstance(clientSdkData);
        com.amazon.apay.hardened.manager.b.f15005b = CrashEventsLogger.Companion.getInstance(clientSdkData);
        com.amazon.apay.hardened.manager.b.a("MetricsInit", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
        Context context2 = aPayRequestContext.getContext();
        ValidationUtil.a(context2, "Context");
        if (!(context2 instanceof Activity)) {
            throw new IllegalArgumentException("Do not pass ApplicationContext. Pass activity context instead.");
        }
        customTabsIntent = aPayRequestContext.getCustomTabsIntent();
    }

    public static void authorize(APayRequestContext aPayRequestContext, String str) {
        com.amazon.apay.hardened.constant.a aVar = com.amazon.apay.hardened.constant.a.f14982b;
        a(aPayRequestContext, aVar);
        Timber.c("authorize called. Custom tab intent supplied: %s , cancel Intent supplied = %s", String.valueOf(aPayRequestContext.getCustomTabsIntent() != null), String.valueOf(aPayRequestContext.getCancelIntent() != null));
        com.amazon.apay.hardened.manager.b.a("AuthorizeCalled", "KUBER_HARDENED_SDK.AUTH_OPERATION");
        ValidationUtil.a(aPayRequestContext.getCompletionIntent(), "Completion Intent");
        ValidationUtil.a(str, "Code Challenge");
        Intent intent = new Intent(aPayRequestContext.getContext(), (Class<?>) APayBrowserActivity.class);
        intent.putExtra("codeChallenge", str);
        intent.putExtra("operation", aVar);
        intent.putExtra("clientId", aPayRequestContext.getClientId());
        intent.putExtra("COMPLETION_INTENT", aPayRequestContext.getCompletionIntent());
        intent.putExtra("CANCEL_INTENT", aPayRequestContext.getCancelIntent());
        aPayRequestContext.getContext().startActivity(intent);
    }

    public static void charge(APayRequestContext aPayRequestContext, String str) {
        com.amazon.apay.hardened.constant.a aVar = com.amazon.apay.hardened.constant.a.f14983c;
        a(aPayRequestContext, aVar);
        Timber.c("charge called with payUrl %s. Custom tab intent supplied: %s", str, String.valueOf(customTabsIntent != null));
        com.amazon.apay.hardened.manager.b.a("ChargeCalled", "KUBER_HARDENED_SDK.CHARGE_OPERATION");
        ValidationUtil.b(str);
        ValidationUtil.a(aPayRequestContext.getCompletionIntent(), "CompletionIntent");
        Intent intent = new Intent(aPayRequestContext.getContext(), (Class<?>) APayBrowserActivity.class);
        intent.putExtra("PAY_URL", str);
        intent.putExtra("operation", aVar);
        intent.putExtra("clientId", aPayRequestContext.getClientId());
        intent.putExtra("COMPLETION_INTENT", aPayRequestContext.getCompletionIntent());
        intent.putExtra("CANCEL_INTENT", aPayRequestContext.getCancelIntent());
        aPayRequestContext.getContext().startActivity(intent);
    }

    public static Intent getAuthorizationIntent(APayRequestContext aPayRequestContext, String str) {
        com.amazon.apay.hardened.constant.a aVar = com.amazon.apay.hardened.constant.a.f14981a;
        a(aPayRequestContext, aVar);
        Timber.c("getAuthorizationIntent called. Custom tab intent supplied: %s", String.valueOf(customTabsIntent != null));
        com.amazon.apay.hardened.manager.b.a("GetAuthIntentCalled", "KUBER_HARDENED_SDK.AUTH_OPERATION");
        ValidationUtil.c(str, "Code Challenge");
        Intent intent = new Intent(aPayRequestContext.getContext(), (Class<?>) APayBrowserActivity.class);
        intent.putExtra("codeChallenge", str);
        intent.putExtra("operation", aVar);
        intent.putExtra("clientId", aPayRequestContext.getClientId());
        return intent;
    }

    public static Intent getChargeIntent(APayRequestContext aPayRequestContext, String str) {
        com.amazon.apay.hardened.constant.a aVar = com.amazon.apay.hardened.constant.a.f14984d;
        a(aPayRequestContext, aVar);
        Timber.c("getChargeIntent called with payUrl %s. Custom tab intent supplied: %s", str, String.valueOf(customTabsIntent != null));
        com.amazon.apay.hardened.manager.b.a("ChargeIntentCalled", "KUBER_HARDENED_SDK.CHARGE_OPERATION");
        ValidationUtil.b(str);
        Intent intent = new Intent(aPayRequestContext.getContext(), (Class<?>) APayBrowserActivity.class);
        intent.putExtra("PAY_URL", str);
        intent.putExtra("operation", aVar);
        intent.putExtra("clientId", aPayRequestContext.getClientId());
        return intent;
    }

    public static void signOut(APayRequestContext aPayRequestContext, APayCallback aPayCallback) throws JSONException {
        a(aPayRequestContext, com.amazon.apay.hardened.constant.a.f14985e);
        Timber.c("AmazonPayManager:signOut invoked", new Object[0]);
        com.amazon.apay.hardened.manager.b.a("SignOutCalled", "KUBER_HARDENED_SDK.SIGN_OUT_OPERATION");
        ValidationUtil.a(aPayCallback, "APayCallback");
        AuthorizationManager.signOut(aPayRequestContext.getContext(), new a(aPayCallback));
    }
}
