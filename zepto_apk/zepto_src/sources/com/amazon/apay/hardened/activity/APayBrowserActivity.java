package com.amazon.apay.hardened.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.amazon.apay.hardened.R;
import com.amazon.apay.hardened.constant.AuthConstants;
import com.amazon.apay.hardened.external.AmazonPayManager;
import com.amazon.apay.hardened.external.model.APayAuthResponse;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.amazon.apay.hardened.external.model.APayError;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.amazon.apay.hardened.viewModel.ApayBrowserActivityViewModel;
import com.amazon.apay.instrumentation.logger.KuberMetricEventsLogger;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.authorization.AuthCancellation;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeListener;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.api.authorization.AuthorizeResult;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.amazon.identity.auth.device.authorization.InternalAuthManager;
import com.amazon.identity.auth.device.authorization.ServiceConnectionState;
import com.amazon.identity.auth.device.authorization.ThirdPartyAuthorizationHelper;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.google.android.gms.security.ProviderInstaller;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class APayBrowserActivity extends AppCompatActivity implements ProviderInstaller.ProviderInstallListener {
    public static final /* synthetic */ int o = 0;

    /* renamed from: i, reason: collision with root package name */
    public ApayBrowserActivityViewModel f14961i;

    /* renamed from: j, reason: collision with root package name */
    public RequestContext f14962j;

    /* renamed from: k, reason: collision with root package name */
    public a f14963k;

    /* renamed from: l, reason: collision with root package name */
    public b f14964l;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f14965m = new Handler();
    public com.amazon.apay.hardened.activity.b n;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            APayBrowserActivity.this.findViewById(R.id.cancelBtn).setVisibility(0);
            com.amazon.apay.hardened.manager.b.a("CancelBtnShown", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            APayBrowserActivity.this.findViewById(R.id.cancelBtn).setVisibility(0);
            com.amazon.apay.hardened.manager.b.a("DelayedCancel", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
        }
    }

    public final class c extends AuthorizeListener {
        public c() {
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener, com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener
        public final void onCancel(Object obj) throws PendingIntent.CanceledException {
            APayBrowserActivity.this.p((AuthCancellation) obj);
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener, com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) throws PendingIntent.CanceledException {
            int i2 = APayBrowserActivity.o;
            APayBrowserActivity.this.o(authError);
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener, com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(AuthorizeResult authorizeResult) throws PendingIntent.CanceledException {
            int i2 = APayBrowserActivity.o;
            APayBrowserActivity.this.q(authorizeResult);
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener
        public final void onCancel(AuthCancellation authCancellation) throws PendingIntent.CanceledException {
            APayBrowserActivity.this.p(authCancellation);
        }
    }

    public final String a() {
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        String str = apayBrowserActivityViewModel == null ? null : apayBrowserActivityViewModel.f15012g;
        if (str != null) {
            return str;
        }
        com.amazon.apay.hardened.manager.b.a("NullClientId", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
        return getCallingPackage() == null ? "UNKNOWN" : getCallingPackage();
    }

    public final boolean c() {
        com.amazon.apay.hardened.constant.a aVar = this.f14961i.f15007b;
        if (aVar != null) {
            return com.amazon.apay.hardened.constant.a.f14981a.equals(aVar) || com.amazon.apay.hardened.constant.a.f14982b.equals(this.f14961i.f15007b);
        }
        return false;
    }

    public final void l(Intent intent, int i2) throws PendingIntent.CanceledException {
        Timber.c("ApayBrowserActivity:handleOperationComplete invoked with data : %s", intent.toString());
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        if (apayBrowserActivityViewModel == null) {
            com.amazon.apay.hardened.manager.b.a("EmptyDataFailure", ".UnknownOperation");
            setResult(i2, intent);
            finish();
            return;
        }
        PendingIntent pendingIntent = apayBrowserActivityViewModel.f15008c;
        com.amazon.apay.hardened.constant.a aVar = apayBrowserActivityViewModel.f15007b;
        String strName = aVar != null ? aVar.name() : "UNKNOWN";
        if (i2 == 0) {
            PendingIntent pendingIntent2 = this.f14961i.f15009d;
            if (pendingIntent2 != null) {
                pendingIntent = pendingIntent2;
            }
            com.amazon.apay.hardened.manager.b.a(strName + ".OperationCancelled", strName);
        } else {
            com.amazon.apay.hardened.manager.b.a(strName + ".OperationCompleted", strName);
        }
        try {
            if (pendingIntent != null) {
                Timber.a("Sending data through PendingIntent: %s", Integer.valueOf(i2));
                pendingIntent.send(this, i2, intent);
                com.amazon.apay.hardened.manager.b.a("PendingIntentSuccess", "KUBER_HARDENED_SDK.SEND_RESULT_OPERATION");
            } else {
                Timber.a("Sending data through onActivityResult: %s", Integer.valueOf(i2));
                setResult(i2, intent);
                com.amazon.apay.hardened.manager.b.a("setResultSuccess", "KUBER_HARDENED_SDK.SEND_RESULT_OPERATION");
            }
            if (c()) {
                com.amazon.apay.hardened.manager.b.a("AuthComplete", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
            }
        } catch (PendingIntent.CanceledException e2) {
            Timber.b(e2, "Error sending results through PendingIntent", new Object[0]);
            String string = e2.toString();
            KuberMetricEventsLogger kuberMetricEventsLogger = com.amazon.apay.hardened.manager.b.f15004a;
            if (kuberMetricEventsLogger != null) {
                kuberMetricEventsLogger.addMetricEvent("PendingIntentError", "KUBER_HARDENED_SDK.SEND_RESULT_OPERATION", "", string);
            }
            if (c()) {
                com.amazon.apay.hardened.manager.b.a("LoginDroppedOff", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
            }
        }
        finish();
    }

    public final void m(Bundle bundle) throws PendingIntent.CanceledException {
        com.amazon.apay.hardened.manager.b.a("ExtractStateSuccess", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
        Timber.c("APayBrowserActivity:extractState invoked for operation: %s", this.f14961i.f15007b);
        this.f14961i.f15007b = (com.amazon.apay.hardened.constant.a) bundle.getSerializable("operation");
        this.f14961i.f15008c = (PendingIntent) bundle.getParcelable("COMPLETION_INTENT");
        this.f14961i.f15009d = (PendingIntent) bundle.getParcelable("CANCEL_INTENT");
        this.f14961i.f15013h = bundle.getBoolean("HAS_BROWSER_LAUNCHED", false);
        this.f14961i.f15014i = Boolean.valueOf(bundle.getBoolean("HAS_ON_NEW_INTENT_CALLED"));
        this.f14961i.f15011f = bundle.getString("codeChallenge");
        this.f14961i.f15012g = bundle.getString("clientId");
        this.f14961i.f15015j = bundle.getBoolean("onStopCalled", false);
        if (bundle.getString("PAY_URL") != null) {
            this.f14961i.f15010e = bundle.getString("PAY_URL");
        } else if (getIntent().getExtras() != null && getIntent().getExtras().getString("PAY_URL") != null) {
            this.f14961i.f15010e = getIntent().getExtras().getString("PAY_URL");
        }
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        com.amazon.apay.hardened.constant.a aVar = apayBrowserActivityViewModel.f15007b;
        if (aVar == null || ((com.amazon.apay.hardened.constant.a.f14983c.equals(aVar) || com.amazon.apay.hardened.constant.a.f14984d.equals(apayBrowserActivityViewModel.f15007b)) && apayBrowserActivityViewModel.f15010e == null)) {
            n(APayError.ErrorType.INVALID_REQUEST, "PARAMETER_VALIDATION_FAILED", "Invalid parameter passed", null);
        }
        Timber.c("extractState: with payUrl : %s", this.f14961i.f15010e);
    }

    public final void n(APayError.ErrorType errorType, String str, String str2, Exception exc) throws PendingIntent.CanceledException {
        Timber.b(exc, "ApayBrowserActivity:handleError invoked with error: %s", str);
        String string = exc != null ? exc.toString() : str2;
        String string2 = errorType.toString();
        KuberMetricEventsLogger kuberMetricEventsLogger = com.amazon.apay.hardened.manager.b.f15004a;
        if (kuberMetricEventsLogger != null) {
            kuberMetricEventsLogger.addMetricEvent("KUBER_HARDENED_SDK.HANDLE_ERROR", string2, str, string);
        }
        l(new APayError(errorType, str, str2, exc).getApayErrorIntent(), 0);
    }

    public final void o(AuthError authError) throws PendingIntent.CanceledException {
        Timber.b(authError, "LWAAuthorizeListener:onError invoked", new Object[0]);
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        if (apayBrowserActivityViewModel != null && (apayBrowserActivityViewModel.f15016k || apayBrowserActivityViewModel.f15017l)) {
            com.amazon.apay.hardened.manager.b.a("FalseLoginFailed", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            return;
        }
        s();
        com.amazon.apay.hardened.manager.b.a("AuthError", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        com.amazon.apay.hardened.manager.b.a("LoginFailed", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
        n(APayError.ErrorType.AUTH_ERROR, "START_BROWSING_ERROR", authError.getMessage(), authError);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() throws PendingIntent.CanceledException {
        if (this.f14961i.f15016k) {
            com.amazon.apay.hardened.manager.b.a("BackBtnClickAfterCancel", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            return;
        }
        Timber.c("ApayBrowserActivity:onBackPressed invoked", new Object[0]);
        com.amazon.apay.hardened.manager.b.a("BackBtnClick", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        com.amazon.apay.hardened.manager.b.a("LoginCanceled", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        this.f14961i.f15017l = true;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("AUTH_STATUS", APayAuthResponse.Status.DENIED);
        intent.putExtras(bundle);
        l(intent, 0);
    }

    public void onCancelBtnClick(View view) throws PendingIntent.CanceledException {
        Timber.a("ApayBrowserActivity:onCancelBtnClick called", new Object[0]);
        this.f14961i.f15016k = true;
        com.amazon.apay.hardened.manager.b.a("CancelBtnClick", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        com.amazon.apay.hardened.manager.b.a("LoginCanceled", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        findViewById(R.id.cancelBtn).setVisibility(4);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("AUTH_STATUS", APayAuthResponse.Status.DENIED);
        intent.putExtras(bundle);
        l(intent, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws PendingIntent.CanceledException {
        super.onCreate(bundle);
        Timber.a("APayBrowserActivity:onCreate invoked", new Object[0]);
        com.amazon.apay.hardened.activity.b bVar = new com.amazon.apay.hardened.activity.b();
        bVar.f14972a = this;
        bVar.f14973b = Thread.getDefaultUncaughtExceptionHandler();
        bVar.f14974c = this;
        this.n = bVar;
        Thread.setDefaultUncaughtExceptionHandler(bVar);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            com.amazon.apay.hardened.manager.b.a("IntentExtrasNotFound", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
            n(APayError.ErrorType.INVALID_REQUEST, CLConstants.ERROR_INVALID_REQUEST, "Invalid request", null);
            finish();
            return;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        Intrinsics.checkNotNullParameter(ApayBrowserActivityViewModel.class, "modelClass");
        Intrinsics.checkNotNullParameter(ApayBrowserActivityViewModel.class, "<this>");
        this.f14961i = (ApayBrowserActivityViewModel) viewModelProvider.a(Reflection.a(ApayBrowserActivityViewModel.class));
        if (bundle == null || bundle.isEmpty()) {
            m(extras);
        } else {
            m(bundle);
        }
        setContentView(R.layout.activity_browser_apay);
        if (c()) {
            ((TextView) findViewById(R.id.loading_text)).setText(R.string.auth_processing_text);
        } else {
            ((TextView) findViewById(R.id.loading_text)).setText(R.string.charge_processing_text);
        }
        ProviderInstaller.b(this, this);
        this.f14963k = new a();
        this.f14964l = new b();
        com.amazon.apay.hardened.manager.b.a("OnCreateCalled", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Timber.c("ApayBrowserActivity:onDestroy invoked", new Object[0]);
        this.f14961i = null;
        if (findViewById(R.id.cancelBtn) != null) {
            findViewById(R.id.cancelBtn).setVisibility(4);
        }
        Handler handler = this.f14965m;
        handler.removeCallbacks(this.f14963k);
        handler.removeCallbacks(this.f14964l);
        Thread.setDefaultUncaughtExceptionHandler(this.n.f14973b);
        com.amazon.apay.hardened.activity.b bVar = this.n;
        bVar.f14972a = null;
        bVar.f14973b = null;
        bVar.f14974c = null;
        this.n = null;
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Timber.a("ApayBrowserActivity:onNewIntent invoked", new Object[0]);
        setIntent(intent);
        this.f14961i.f15014i = Boolean.TRUE;
        com.amazon.apay.hardened.manager.b.a("OnNewIntentCalled", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() throws PendingIntent.CanceledException {
        super.onResume();
        Timber.a("ApayBrowserActivity:onResume invoked", new Object[0]);
        this.f14961i.getClass();
        if (ApayBrowserActivityViewModel.f15006m > 1) {
            com.amazon.apay.hardened.manager.b.a("AppSwitchDone", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
        }
        boolean z = this.f14961i.f15013h;
        Handler handler = this.f14965m;
        if (!z) {
            handler.postDelayed(this.f14964l, 12000L);
            if (c()) {
                com.amazon.apay.hardened.manager.b.a("AuthAttempted", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
                try {
                    Timber.c("ApayBrowserActivity:initAuthorize invoked", new Object[0]);
                    com.amazon.apay.hardened.manager.b.a("AuthInitialize", "KUBER_HARDENED_SDK.AUTH_OPERATION");
                    RequestContext requestContextCreate = RequestContext.create((FragmentActivity) this, getIntent(), AmazonPayManager.customTabsIntent);
                    this.f14962j = requestContextCreate;
                    requestContextCreate.registerListener(new c());
                    AuthorizeRequest authorizeRequestBuild = new AuthorizeRequest.Builder(this.f14962j).addScopes(AuthConstants.f14979c).shouldReturnUserData(false).forGrantType(AuthorizeRequest.GrantType.AUTHORIZATION_CODE).withProofKeyParameters(this.f14961i.f15011f, "S256").splitSignInForSubRegion(AuthConstants.f14978b).build();
                    AuthorizationManager.setRegion(this, AuthConstants.f14977a);
                    AuthorizationManager.authorize(authorizeRequestBuild);
                } catch (IllegalArgumentException e2) {
                    if (Objects.equals(e2.getMessage(), "Invalid API Key")) {
                        n(APayError.ErrorType.INVALID_API_KEY_ERROR, "INVALID_API_KEY_ERROR", "Invalid API key provided", e2);
                    } else {
                        n(APayError.ErrorType.AUTHORISATION_ERROR, "AUTH_FAILURE", "Authorisation failed", e2);
                    }
                } catch (Exception e3) {
                    n(APayError.ErrorType.AUTHORISATION_ERROR, "AUTH_FAILURE", "Authorisation failed", e3);
                }
            } else {
                com.amazon.apay.hardened.manager.b.a("ChargeAttempted", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
                final int i2 = 1;
                new Handler().postDelayed(new Runnable(this) { // from class: com.amazon.apay.hardened.activity.c

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ APayBrowserActivity f14976b;

                    {
                        this.f14976b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() throws PendingIntent.CanceledException {
                        APayBrowserActivity aPayBrowserActivity = this.f14976b;
                        switch (i2) {
                            case 0:
                                int i3 = APayBrowserActivity.o;
                                if (!aPayBrowserActivity.isFinishing() && ThirdPartyAuthorizationHelper.serviceStatus == ServiceConnectionState.UNINITIATED) {
                                    aPayBrowserActivity.f14961i.f15016k = true;
                                    aPayBrowserActivity.runOnUiThread(new a(aPayBrowserActivity));
                                    break;
                                }
                                break;
                            default:
                                int i4 = APayBrowserActivity.o;
                                Timber.c("Init charge Context ClientID:", aPayBrowserActivity.a());
                                try {
                                    com.amazon.apay.hardened.manager.a.a(aPayBrowserActivity).c(APayRequestContext.create(aPayBrowserActivity, aPayBrowserActivity.a(), AmazonPayManager.customTabsIntent), aPayBrowserActivity.f14961i.f15010e);
                                    break;
                                } catch (APayError e4) {
                                    com.amazon.apay.hardened.manager.b.a("PaymentFailure", "KUBER_HARDENED_SDK.CHARGE_OPERATION");
                                    aPayBrowserActivity.n(APayError.ErrorType.BROWSING_EXPERIENCE, "START_BROWSING_ERROR", e4.getMessage(), e4);
                                    aPayBrowserActivity.finish();
                                }
                        }
                    }
                }, 200L);
            }
            this.f14961i.f15013h = true;
            return;
        }
        Intent intent = getIntent();
        if (intent.getData() != null) {
            com.amazon.apay.hardened.manager.b.a("BrowserRedirectSuccess", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
            if (c()) {
                com.amazon.apay.hardened.manager.b.a("CCTAuthRedirectSuccess", "KUBER_HARDENED_SDK.AUTH_OPERATION");
            }
            Timber.c("ApayBrowserActivity:onResume with data:%s", intent.getData().toString());
            intent.putExtra(APayConstants.SUCCESS, getIntent().getData());
            l(intent, -1);
            return;
        }
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        Boolean bool = apayBrowserActivityViewModel.f15014i;
        if (apayBrowserActivityViewModel.f15015j && bool != null && !bool.booleanValue()) {
            handler.postDelayed(this.f14963k, 6000L);
        }
        if (this.f14962j != null) {
            Timber.c("In onResume: requestContext not null, sending redirect info to auth sdk", new Object[0]);
            this.f14962j.onResume();
            return;
        }
        String stringExtra = getIntent().getStringExtra("authResponse");
        if (stringExtra != null) {
            com.amazon.apay.hardened.manager.b.a("SuccessfulAuthAfterActivityDestroyed", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            try {
                r(stringExtra);
                return;
            } catch (AuthError e4) {
                o(e4);
                return;
            } catch (Exception unused) {
                com.amazon.apay.hardened.manager.b.a("AuthError", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
                n(APayError.ErrorType.AUTHORISATION_ERROR, "AUTH_FAILURE", "Authorisation failed", null);
                return;
            }
        }
        Timber.f58263c.e("onResume: Unable to continue with operation. Returning.", new Object[0]);
        if (c()) {
            final int i3 = 0;
            new Handler().postDelayed(new Runnable(this) { // from class: com.amazon.apay.hardened.activity.c

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ APayBrowserActivity f14976b;

                {
                    this.f14976b = this;
                }

                @Override // java.lang.Runnable
                public final void run() throws PendingIntent.CanceledException {
                    APayBrowserActivity aPayBrowserActivity = this.f14976b;
                    switch (i3) {
                        case 0:
                            int i32 = APayBrowserActivity.o;
                            if (!aPayBrowserActivity.isFinishing() && ThirdPartyAuthorizationHelper.serviceStatus == ServiceConnectionState.UNINITIATED) {
                                aPayBrowserActivity.f14961i.f15016k = true;
                                aPayBrowserActivity.runOnUiThread(new a(aPayBrowserActivity));
                                break;
                            }
                            break;
                        default:
                            int i4 = APayBrowserActivity.o;
                            Timber.c("Init charge Context ClientID:", aPayBrowserActivity.a());
                            try {
                                com.amazon.apay.hardened.manager.a.a(aPayBrowserActivity).c(APayRequestContext.create(aPayBrowserActivity, aPayBrowserActivity.a(), AmazonPayManager.customTabsIntent), aPayBrowserActivity.f14961i.f15010e);
                                break;
                            } catch (APayError e42) {
                                com.amazon.apay.hardened.manager.b.a("PaymentFailure", "KUBER_HARDENED_SDK.CHARGE_OPERATION");
                                aPayBrowserActivity.n(APayError.ErrorType.BROWSING_EXPERIENCE, "START_BROWSING_ERROR", e42.getMessage(), e42);
                                aPayBrowserActivity.finish();
                            }
                    }
                }
            }, 200L);
        } else {
            this.f14961i.f15016k = true;
            runOnUiThread(new com.amazon.apay.hardened.activity.a(this));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.amazon.apay.hardened.manager.b.a("SaveStateSuccess", "KUBER_HARDENED_SDK.APAY_ACTIVTIY_OPERATION");
        Timber.c("APayBrowserActivity:onSaveInstanceState invoked for operation: %s", this.f14961i.f15007b);
        bundle.putBoolean("HAS_BROWSER_LAUNCHED", this.f14961i.f15013h);
        bundle.putBoolean("HAS_ON_NEW_INTENT_CALLED", this.f14961i.f15014i.booleanValue());
        bundle.putParcelable("COMPLETION_INTENT", this.f14961i.f15008c);
        bundle.putParcelable("CANCEL_INTENT", this.f14961i.f15009d);
        bundle.putSerializable("operation", this.f14961i.f15007b);
        bundle.putSerializable("PAY_URL", this.f14961i.f15010e);
        bundle.putSerializable("codeChallenge", this.f14961i.f15011f);
        bundle.putSerializable("clientId", a());
        bundle.putBoolean("onStopCalled", this.f14961i.f15015j);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        this.f14961i.f15015j = true;
        ApayBrowserActivityViewModel.f15006m++;
        this.f14965m.removeCallbacks(this.f14964l);
        super.onStop();
    }

    public final void p(AuthCancellation authCancellation) throws PendingIntent.CanceledException {
        Timber.c("LWAAuthorizeListener: onCancel called %s", authCancellation.toString());
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        if (apayBrowserActivityViewModel != null && (apayBrowserActivityViewModel.f15016k || apayBrowserActivityViewModel.f15017l)) {
            com.amazon.apay.hardened.manager.b.a("FalseLoginCanceled", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            return;
        }
        s();
        com.amazon.apay.hardened.manager.b.a("AuthCancelled", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        com.amazon.apay.hardened.manager.b.a("LoginCanceled", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (authCancellation.getCause() == AuthCancellation.Cause.FAILED_AUTHENTICATION) {
            Timber.a("Auth cancelled/denied at consent", new Object[0]);
            bundle.putSerializable("AUTH_STATUS", APayAuthResponse.Status.DENIED);
        } else {
            Timber.a("Auth cancelled with unknown reason", new Object[0]);
            bundle.putSerializable("AUTH_STATUS", APayAuthResponse.Status.FAILURE);
        }
        intent.putExtras(bundle);
        l(intent, -1);
    }

    public final void q(AuthorizeResult authorizeResult) throws PendingIntent.CanceledException {
        Timber.c("LWAAuthorizeListener:onSuccess invoked: %s", authorizeResult);
        ApayBrowserActivityViewModel apayBrowserActivityViewModel = this.f14961i;
        if (apayBrowserActivityViewModel != null && (apayBrowserActivityViewModel.f15016k || apayBrowserActivityViewModel.f15017l)) {
            com.amazon.apay.hardened.manager.b.a("FalseLoginSuccess", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            return;
        }
        if (apayBrowserActivityViewModel == null || !apayBrowserActivityViewModel.f15014i.booleanValue()) {
            com.amazon.apay.hardened.manager.b.a("SSOAuthSuccess", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        } else {
            com.amazon.apay.hardened.manager.b.a("CCTAuthSuccess", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        }
        s();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("AUTH_STATUS", APayAuthResponse.Status.GRANTED);
        bundle.putSerializable("authCode", authorizeResult.getAuthorizationCode());
        bundle.putSerializable("lwaClientId", authorizeResult.getClientId());
        bundle.putSerializable(AuthorizationResponseParser.REDIRECT_URI_STATE, authorizeResult.getRedirectURI());
        intent.putExtras(bundle);
        intent.putExtras(bundle);
        l(intent, -1);
        finish();
    }

    public final void r(String str) throws AuthError, PendingIntent.CanceledException {
        Bundle bundleExtractResultsBundle = new AuthorizationResponseParser().extractResultsBundle(str, (String[]) null);
        if (bundleExtractResultsBundle.containsKey(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val)) {
            p(new AuthCancellation(bundleExtractResultsBundle));
            return;
        }
        if (!bundleExtractResultsBundle.getBoolean(AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE.val, false)) {
            com.amazon.apay.hardened.manager.b.a("AuthError", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            com.amazon.apay.hardened.manager.b.a("ReturnAuthCodeFalse", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            n(APayError.ErrorType.AUTHORISATION_ERROR, "AUTH_FAILURE", "Authorisation failed", null);
        } else if (TextUtils.isEmpty(bundleExtractResultsBundle.getString("code"))) {
            com.amazon.apay.hardened.manager.b.a("AuthError", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            com.amazon.apay.hardened.manager.b.a("EmptyCode", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
            n(APayError.ErrorType.AUTHORISATION_ERROR, "AUTH_FAILURE", "Authorisation failed", null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(AuthzConstants.BUNDLE_KEY.AUTHORIZATION_CODE.val, bundleExtractResultsBundle.getString("code"));
            bundle.putString(AuthzConstants.BUNDLE_KEY.CLIENT_ID.val, InternalAuthManager.getInstance(this).getClientId());
            bundle.putString(AuthzConstants.BUNDLE_KEY.REDIRECT_URI.val, InternalAuthManager.getInstance(this).getRedirectURI(this));
            q(new AuthorizeResult(bundle));
        }
    }

    public final void s() throws PendingIntent.CanceledException {
        if (this.f14961i != null || getIntent().getExtras() == null) {
            return;
        }
        com.amazon.apay.hardened.manager.b.a("ListenerCalledAfterActivityDestroyed", "KUBER_HARDENED_SDK.AUTH_RESPONSE");
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        Intrinsics.checkNotNullParameter(ApayBrowserActivityViewModel.class, "modelClass");
        Intrinsics.checkNotNullParameter(ApayBrowserActivityViewModel.class, "<this>");
        this.f14961i = (ApayBrowserActivityViewModel) viewModelProvider.a(Reflection.a(ApayBrowserActivityViewModel.class));
        m(getIntent().getExtras());
    }
}
