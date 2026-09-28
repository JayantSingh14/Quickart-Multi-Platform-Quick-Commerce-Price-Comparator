package com.amazon.identity.auth.apay.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;
import com.amazon.android.apay.commonlibrary.commonlib.exception.ApayUncaughtExceptionHandler;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.Constants;
import com.amazon.identity.auth.device.api.authorization.AuthCancellation;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeListener;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.api.authorization.AuthorizeResult;
import com.amazon.identity.auth.device.api.authorization.Scope;
import com.amazon.identity.auth.device.api.authorization.ScopeFactory;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.amazon.identity.auth.device.authorization.InternalAuthManager;
import com.amazon.identity.auth.device.authorization.R;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class AuthActivity extends AppCompatActivity {
    public static CustomTabsIntent p;

    /* renamed from: i, reason: collision with root package name */
    public a.a f15067i;

    /* renamed from: j, reason: collision with root package name */
    public com.amazon.identity.auth.apay.activity.a f15068j;

    /* renamed from: k, reason: collision with root package name */
    public com.amazon.identity.auth.apay.activity.a f15069k;

    /* renamed from: l, reason: collision with root package name */
    public RequestContext f15070l;

    /* renamed from: m, reason: collision with root package name */
    public String f15071m;
    public ApayUncaughtExceptionHandler n;
    public final Handler o = new Handler();

    public final class a extends AuthorizeListener {
        public a() {
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener, com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener
        public final void onCancel(Object obj) {
            AuthActivity.this.n((AuthCancellation) obj);
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener, com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            CustomTabsIntent customTabsIntent = AuthActivity.p;
            AuthActivity authActivity = AuthActivity.this;
            if (authActivity.f15067i == null && authActivity.getIntent().getExtras() != null) {
                authActivity.m(authActivity.getIntent().getExtras());
                InstrumentUtil.addMetricEvent("ListenerInvokedAfterActivityDestroyed", "LWA_LITE_SDK.AUTH_RESPONSE", authActivity.f15071m);
            }
            a.a aVar = authActivity.f15067i;
            if ((aVar != null && aVar.f9e) || aVar.f10f) {
                InstrumentUtil.addMetricEvent("FalseLoginFailed", "LWA_LITE_SDK.AUTH_RESPONSE", authActivity.f15071m);
            } else {
                InstrumentUtil.addMetricEvent("AuthError", "LWA_LITE_SDK.AUTH_RESPONSE", authActivity.f15071m);
                authActivity.q("START_BROWSING_ERROR", authError.toString());
            }
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener, com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(AuthorizeResult authorizeResult) {
            CustomTabsIntent customTabsIntent = AuthActivity.p;
            AuthActivity.this.o(authorizeResult);
        }

        @Override // com.amazon.identity.auth.device.api.authorization.AuthorizeListener
        public final void onCancel(AuthCancellation authCancellation) {
            AuthActivity.this.n(authCancellation);
        }
    }

    public static Scope[] r(List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScopeFactory.scopeNamed("payments::conduct_silentpay"));
        arrayList.add(ScopeFactory.scopeNamed("profile:user_id"));
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ScopeFactory.scopeNamed((String) it.next()));
            }
        }
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    public final void l(int i2, String str, Intent intent) {
        intent.toString();
        InstrumentUtil.addMetricEvent("AUTHORIZE.OperationCompleted", "AUTHORIZE", str);
        setResult(i2, intent);
        InstrumentUtil.addMetricEvent("AuthComplete", "LWA_LITE_SDK.BUSINESS_METRICS", str);
        finish();
    }

    public final void m(Bundle bundle) {
        if (bundle == null) {
            InstrumentUtil.addMetricEvent("SavedBundleNotPresent", "LWA_LITE_SDK.AUTH_ACTIVITY_OPERATION", this.f15071m);
            q("AUTH_FAILURE", "SavedBundleNotPresent");
            return;
        }
        this.f15071m = bundle != null ? bundle.getString("stitchingId") : getIntent().getExtras() != null ? getIntent().getStringExtra("stitchingId") : UUID.randomUUID().toString();
        a.a aVar = (a.a) bundle.getParcelable("AuthRequest");
        this.f15067i = aVar;
        if (aVar == null) {
            InstrumentUtil.addMetricEvent("ExtractStateFailed", "LWA_LITE_SDK.AUTH_ACTIVITY_OPERATION", this.f15071m);
            q("AUTH_FAILURE", "NullAuthRequestExtracted");
        }
        InstrumentUtil.addMetricEvent("ExtractStateSuccess", "LWA_LITE_SDK.AUTH_ACTIVITY_OPERATION", this.f15071m);
    }

    public final void n(AuthCancellation authCancellation) {
        authCancellation.toString();
        if (this.f15067i == null && getIntent().getExtras() != null) {
            m(getIntent().getExtras());
            InstrumentUtil.addMetricEvent("ListenerInvokedAfterActivityDestroyed", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
        }
        if ((this.f15067i != null && this.f15067i.f9e) || this.f15067i.f10f) {
            InstrumentUtil.addMetricEvent("FalseLoginCanceled", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
            return;
        }
        InstrumentUtil.addMetricEvent("AuthCancelled", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
        if (authCancellation.getCause() == AuthCancellation.Cause.FAILED_AUTHENTICATION) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("AUTH_STATUS", "DENIED");
            intent.putExtras(bundle);
            l(-1, this.f15071m, intent);
            return;
        }
        Intent intent2 = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("AUTH_STATUS", "FAILURE");
        intent2.putExtras(bundle2);
        l(-1, this.f15071m, intent2);
    }

    public final void o(AuthorizeResult authorizeResult) {
        new StringBuilder("LWAAuthorizeListener:onSuccess invoked: ").append(authorizeResult);
        if (this.f15067i == null && getIntent().getExtras() != null) {
            m(getIntent().getExtras());
            InstrumentUtil.addMetricEvent("ListenerInvokedAfterActivityDestroyed", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
        }
        if (this.f15067i == null || !this.f15067i.f9e) {
            a.a aVar = this.f15067i;
            if (!aVar.f10f) {
                if (aVar.f7c) {
                    InstrumentUtil.addMetricEvent("CCTAuthSuccess", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                } else {
                    InstrumentUtil.addMetricEvent("SSOAuthSuccess", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("authCode", authorizeResult.getAuthorizationCode());
                bundle.putSerializable("lwaClientId", authorizeResult.getClientId());
                bundle.putSerializable(AuthorizationResponseParser.REDIRECT_URI_STATE, authorizeResult.getRedirectURI());
                intent.putExtras(bundle);
                Bundle extras = intent.getExtras();
                extras.putSerializable("AUTH_STATUS", "GRANTED");
                intent.putExtras(extras);
                l(-1, this.f15071m, intent);
                return;
            }
        }
        InstrumentUtil.addMetricEvent("FalseLoginSuccess", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        try {
            if (this.f15067i.f9e) {
                InstrumentUtil.addMetricEvent("BackBtnClickAfterCancel", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                return;
            }
            InstrumentUtil.addMetricEvent("BackBtnClick", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
            this.f15067i.f10f = true;
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("AUTH_STATUS", "DENIED");
            intent.putExtras(bundle);
            l(0, this.f15071m, intent);
        } catch (Exception e2) {
            q("OnBackPressFailed", e2.toString());
        }
    }

    public void onCancelBtnClick(View view) {
        try {
            this.f15067i.f9e = true;
            InstrumentUtil.addMetricEvent("CancelBtnClick", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
            findViewById(R.id.cancelBtn).setVisibility(4);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("AUTH_STATUS", "DENIED");
            intent.putExtras(bundle);
            l(-1, this.f15071m, intent);
        } catch (Exception e2) {
            q("CancelButtonFailed", e2.toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                setTheme(R.style.AppTheme_Opaque);
            }
            super.onCreate(bundle);
            Bundle extras = getIntent().getExtras();
            String string = bundle != null ? bundle.getString("stitchingId") : getIntent().getExtras() != null ? getIntent().getStringExtra("stitchingId") : UUID.randomUUID().toString();
            this.f15071m = string;
            if (extras == null) {
                q(CLConstants.ERROR_INVALID_REQUEST, "Invalid request");
                return;
            }
            ApayUncaughtExceptionHandler apayUncaughtExceptionHandler = new ApayUncaughtExceptionHandler(this, string);
            this.n = apayUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(apayUncaughtExceptionHandler);
            if (bundle == null || bundle.isEmpty()) {
                m(getIntent().getExtras());
            } else {
                m(bundle);
            }
            setContentView(R.layout.activity_browser_apay);
            ((TextView) findViewById(R.id.loading_text)).setText(R.string.processing_text);
            this.f15069k = new com.amazon.identity.auth.apay.activity.a(this, 0);
            this.f15068j = new com.amazon.identity.auth.apay.activity.a(this, 1);
            InstrumentUtil.addMetricEvent("OnCreateCalled", "LWA_LITE_SDK.AUTH_ACTIVITY_OPERATION", this.f15071m);
        } catch (Exception e2) {
            q("OnCreateFailed", e2.toString());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        try {
            super.onDestroy();
            this.f15067i = null;
            if (findViewById(R.id.cancelBtn) != null) {
                findViewById(R.id.cancelBtn).setVisibility(4);
            }
            Handler handler = this.o;
            handler.removeCallbacks(this.f15069k);
            handler.removeCallbacks(this.f15068j);
            Thread.setDefaultUncaughtExceptionHandler(this.n.getPrevDefaultExceptionHandler());
            this.n.tearDown();
            this.n = null;
        } catch (Exception e2) {
            q("OnDestroyFailed", e2.toString());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            setIntent(intent);
            a.a aVar = this.f15067i;
            aVar.f7c = true;
            InstrumentUtil.addMetricEvent("OnNewIntentCalled", "LWA_LITE_SDK.AUTH_ACTIVITY_OPERATION", aVar.f11g);
        } catch (Exception e2) {
            q("OnNewIntentFailed", e2.toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        try {
            super.onResume();
            if (this.f15067i == null) {
                q(CLConstants.ERROR_INVALID_REQUEST, "Invalid request");
            }
            if (this.f15067i.f13i.intValue() > 1) {
                InstrumentUtil.addMetricEvent("AppSwitchDone", "LWA_LITE_SDK.BUSINESS_METRICS", this.f15071m);
            }
            boolean z = this.f15067i.f6b;
            Handler handler = this.o;
            if (!z) {
                handler.postDelayed(this.f15068j, 12000L);
                s();
                this.f15067i.f6b = true;
                return;
            }
            Intent intent = getIntent();
            if (intent.getData() != null) {
                InstrumentUtil.addMetricEvent("CCTAuthRedirectSuccess", "LWA_LITE_SDK.AUTH_OPERATION", this.f15071m);
                intent.getData().toString();
                Bundle extras = intent.getExtras();
                extras.putSerializable("AUTH_STATUS", "GRANTED");
                intent.putExtras(extras);
                l(-1, this.f15071m, intent);
            }
            a.a aVar = this.f15067i;
            boolean z2 = aVar.f7c;
            if (aVar.f8d && !z2) {
                handler.postDelayed(this.f15069k, 6000L);
            }
            RequestContext requestContext = this.f15070l;
            if (requestContext != null) {
                requestContext.onResume();
                return;
            }
            String stringExtra = getIntent().getStringExtra("authResponse");
            if (stringExtra == null) {
                new Handler().postDelayed(new com.amazon.identity.auth.apay.activity.a(this, 2), 200L);
                return;
            }
            try {
                try {
                    p(stringExtra);
                } catch (Exception unused) {
                    q("AUTH_FAILURE", "Authorisation failed");
                }
            } catch (AuthError e2) {
                if (this.f15067i == null && getIntent().getExtras() != null) {
                    m(getIntent().getExtras());
                    InstrumentUtil.addMetricEvent("ListenerInvokedAfterActivityDestroyed", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                }
                a.a aVar2 = this.f15067i;
                if ((aVar2 != null && aVar2.f9e) || aVar2.f10f) {
                    InstrumentUtil.addMetricEvent("FalseLoginFailed", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                } else {
                    InstrumentUtil.addMetricEvent("AuthError", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                    q("START_BROWSING_ERROR", e2.toString());
                }
            }
        } catch (Exception e3) {
            q("OnResumeFailed", e3.toString());
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        InstrumentUtil.addMetricEvent("SaveStateSuccess", "LWA_LITE_SDK.AUTH_ACTIVITY_OPERATION", this.f15071m);
        bundle.putParcelable("AuthRequest", this.f15067i);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        try {
            super.onStop();
            a.a aVar = this.f15067i;
            aVar.f8d = true;
            aVar.f13i = Integer.valueOf(aVar.f13i.intValue() + 1);
            this.o.removeCallbacks(this.f15068j);
        } catch (Exception e2) {
            q("OnStopFailed", e2.toString());
        }
    }

    public final void p(String str) throws AuthError {
        Bundle bundleExtractResultsBundle = new AuthorizationResponseParser().extractResultsBundle(str, (String[]) null);
        if (bundleExtractResultsBundle.containsKey(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val)) {
            n(new AuthCancellation(bundleExtractResultsBundle));
            return;
        }
        if (!bundleExtractResultsBundle.getBoolean(AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE.val, false)) {
            InstrumentUtil.addMetricEvent("ReturnAuthCodeFalse", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
            q("AUTH_FAILURE", "Authorisation failed");
        } else {
            if (TextUtils.isEmpty(bundleExtractResultsBundle.getString("code"))) {
                InstrumentUtil.addMetricEvent("EmptyCode", "LWA_LITE_SDK.AUTH_RESPONSE", this.f15071m);
                q("AUTH_FAILURE", "Authorisation failed");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AuthzConstants.BUNDLE_KEY.AUTHORIZATION_CODE.val, bundleExtractResultsBundle.getString("code"));
            bundle.putString(AuthzConstants.BUNDLE_KEY.CLIENT_ID.val, InternalAuthManager.getInstance(this).getClientId());
            bundle.putString(AuthzConstants.BUNDLE_KEY.REDIRECT_URI.val, InternalAuthManager.getInstance(this).getRedirectURI(this));
            o(new AuthorizeResult(bundle));
        }
    }

    public final void q(String str, String str2) {
        InstrumentUtil.addMetricEvent(str, str2, this.f15071m);
        AmazonPayError amazonPayError = new AmazonPayError(MerchantConstants.AUTH_ERROR, str);
        Bundle bundle = new Bundle();
        bundle.putParcelable(MerchantConstants.ERROR, amazonPayError);
        l(0, this.f15071m, new Intent().putExtras(bundle));
    }

    public final void s() {
        InstrumentUtil.addMetricEvent("AuthInitialize", "LWA_LITE_SDK.AUTH_OPERATION", this.f15071m);
        try {
            new CustomTabColorSchemeParams.Builder().f1303a = -1;
            CustomTabColorSchemeParams customTabColorSchemeParams = new CustomTabColorSchemeParams(-1);
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.f1343a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
            builder.f1346d = customTabColorSchemeParams.a();
            CustomTabsIntent customTabsIntentA = builder.a();
            p = customTabsIntentA;
            customTabsIntentA.f1341a.setPackage("com.android.chrome");
            RequestContext requestContextCreate = RequestContext.create((FragmentActivity) this, getIntent(), p);
            this.f15070l = requestContextCreate;
            requestContextCreate.registerListener(new a());
            AuthorizeRequest authorizeRequestBuild = new AuthorizeRequest.Builder(this.f15070l).addScopes(r(this.f15067i.f14j)).shouldReturnUserData(false).forGrantType(AuthorizeRequest.GrantType.AUTHORIZATION_CODE).withProofKeyParameters(this.f15067i.f5a, "S256").splitSignInForSubRegion(Constants.AuthConstants.f15083b).build();
            AuthorizationManager.setRegion(this, Constants.AuthConstants.f15082a);
            AuthorizationManager.authorize(authorizeRequestBuild);
        } catch (Exception e2) {
            if (Objects.equals(e2.getMessage(), "Invalid API Key")) {
                q("INVALID_API_KEY_ERROR", "Invalid API key provided");
            } else {
                q("AUTH_FAILURE", "Authorisation failed");
            }
        }
    }
}
