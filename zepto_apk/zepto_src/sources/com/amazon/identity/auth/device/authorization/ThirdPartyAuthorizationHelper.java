package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.appid.AppIdentifier;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.b;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.endpoint.TokenVendor;
import com.amazon.identity.auth.internal.BrowsingExperienceManager;
import d.c;
import d.d;
import d.e;
import f.k;
import f.m;
import f.n;
import in.juspay.hypersdk.core.PaymentConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class ThirdPartyAuthorizationHelper extends AuthorizationHelper {

    /* renamed from: c, reason: collision with root package name */
    public static int f15171c;
    public static ServiceConnectionState serviceStatus = ServiceConnectionState.UNINITIATED;

    /* renamed from: a, reason: collision with root package name */
    public final ThirdPartyServiceHelper f15172a;

    /* renamed from: b, reason: collision with root package name */
    public final c f15173b;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15174a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15175b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AuthorizeRequest f15176c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f15177d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15178e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f15179f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ AuthorizationListener f15180g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Bundle f15181h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ AppInfo f15182i;

        public a(boolean z, boolean z2, AuthorizeRequest authorizeRequest, Context context, String str, String[] strArr, AuthorizationListener authorizationListener, Bundle bundle, AppInfo appInfo) {
            this.f15174a = z;
            this.f15175b = z2;
            this.f15176c = authorizeRequest;
            this.f15177d = context;
            this.f15178e = str;
            this.f15179f = strArr;
            this.f15180g = authorizationListener;
            this.f15181h = bundle;
            this.f15182i = appInfo;
        }

        @Override // java.lang.Runnable
        public final void run() throws JSONException {
            AuthorizationListener authorizationListener = this.f15180g;
            try {
                if (!this.f15174a && !this.f15175b) {
                    authorizationListener.onError(new AuthError("WebView is not allowed for Authorization", AuthError.ERROR_TYPE.ERROR_BAD_PARAM));
                    return;
                }
                ThirdPartyAuthorizationHelper.a(ThirdPartyAuthorizationHelper.this, this.f15176c, this.f15177d, this.f15178e, this.f15179f, this.f15180g, this.f15181h, this.f15182i);
                this.f15177d.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putBoolean("com.amazon.lwa.isTokenObtainedFromSSO", false).commit();
            } catch (AuthError e2) {
                authorizationListener.onError(e2);
            }
        }
    }

    public ThirdPartyAuthorizationHelper() {
        this(new ThirdPartyServiceHelper());
    }

    public static void a(ThirdPartyAuthorizationHelper thirdPartyAuthorizationHelper, AuthorizeRequest authorizeRequest, Context context, String str, String[] strArr, AuthorizationListener authorizationListener, Bundle bundle, AppInfo appInfo) throws JSONException, AuthError {
        b bVar;
        thirdPartyAuthorizationHelper.getClass();
        bundle.getBundle(AuthzConstants.BUNDLE_KEY.EXTRA_URL_PARAMS.val).remove(PaymentConstants.CLIENT_ID);
        InstrumentUtil.addMetricEvent("StartingAuthWithBrowser", "LWA_LITE_SDK.AUTHORIZE_WITH_BROWSER", context, (String) null, (String) null);
        InstrumentUtil.addMetricEvent("LoginWithCCTInvoked", "LWA_LITE_SDK.BUSINESS_METRICS", context, (String) null, (String) null);
        AuthorizationRequest authorizationRequest = new AuthorizationRequest(authorizeRequest, str, strArr, bundle, appInfo, authorizationListener);
        synchronized (b.class) {
            try {
                if (b.f15200c == null) {
                    b.f15200c = new b(BrowsingExperienceManager.getInstance(context));
                }
                bVar = b.f15200c;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.b(authorizationRequest, context);
    }

    public void authorize(AuthorizeRequest authorizeRequest, Context context, String str, String str2, String str3, String[] strArr, boolean z, TokenVendor tokenVendor, AuthorizationListener authorizationListener, Bundle bundle) throws AuthError {
        n nVar;
        Bundle bundle2 = bundle;
        int i2 = j.a.f53503a;
        if (Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("authorize started on main thread");
        }
        new AppIdentifier();
        AppInfo appInfoA = AppIdentifier.a(context, str);
        tokenVendor.getClass();
        synchronized (n.class) {
            try {
                if (n.f48367b == null) {
                    n.f48367b = new n(k.b.b(context));
                }
                nVar = n.f48367b;
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayListE = nVar.e(null, null);
        String[] commonScopesForAuthorization = AuthorizationHelper.getCommonScopesForAuthorization(context, strArr, arrayListE);
        boolean z2 = bundle2.getBoolean(AuthzConstants.BUNDLE_KEY.SANDBOX.val, false);
        Bundle bundle3 = Bundle.EMPTY;
        if (bundle2 == bundle3) {
            bundle2 = new Bundle();
        }
        Bundle bundle4 = bundle2;
        bundle4.putBoolean(AuthzConstants.BUNDLE_KEY.CHECK_API_KEY.val, false);
        bundle4.putBoolean(AuthzConstants.BUNDLE_KEY.RETURN_CODE.val, true);
        bundle4.putString("com.amazon.identity.auth.device.authorization.region", AuthorizationManager.getRegion(context).getStringValue());
        bundle4.putString(AuthzConstants.BUNDLE_KEY.CLIENT_ID.val, str2);
        bundle4.putString(AuthzConstants.BUNDLE_KEY.SDK_VERSION.val, "LWAAndroidSDK3.0.7");
        try {
            bundle4.putBundle(AuthzConstants.BUNDLE_KEY.EXTRA_URL_PARAMS.val, a(bundle4));
            if (!z2 && ((context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getBoolean("com.amazon.lwa.isTokenObtainedFromSSO", false) || arrayListE.size() == 0) && (bundle3 = (Bundle) new e(commonScopesForAuthorization, bundle4).b(context, this.f15172a)) == null)) {
                bundle3 = new Bundle();
            }
            if (bundle3.containsKey("code") && !TextUtils.isEmpty(bundle3.getString("code"))) {
                if (bundle4.getBoolean(AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE.val, false)) {
                    AuthorizationHelper.sendAuthorizationCodeAsResponse(bundle3.getString("code"), str2, str3, authorizationListener);
                    return;
                }
                String str4 = this.f15173b.f48306a;
                j.a.f53504b.execute(new d.b(context, bundle3, bundle4, new AppIdentifier(), this, new d(authorizationListener), new TokenVendor(), str, str4));
                context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putBoolean("com.amazon.lwa.isTokenObtainedFromSSO", true).commit();
                return;
            }
            if (!bundle3.containsKey(AuthError.AUTH_ERROR_EXECEPTION) && !bundle3.containsKey(AuthzConstants.BUNDLE_KEY.AUTHORIZE.val) && !bundle3.containsKey(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val)) {
                m.k(context).f();
                new Handler(Looper.getMainLooper()).post(new a(z, z2, authorizeRequest, context, str2, commonScopesForAuthorization, authorizationListener, bundle4, appInfoA));
                return;
            }
            bundle3.setClassLoader(context.getClassLoader());
            if (bundle3.containsKey(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val)) {
                authorizationListener.onCancel(bundle3);
                return;
            }
            if (bundle3.containsKey(AuthError.AUTH_ERROR_EXECEPTION)) {
                authorizationListener.onError(AuthError.extractError(bundle3));
                return;
            }
            k.c(context);
            Bundle bundle5 = new Bundle();
            bundle5.putString(AuthzConstants.BUNDLE_KEY.AUTHORIZE.val, "authorized via service");
            authorizationListener.onSuccess(bundle5);
        } catch (AuthError e2) {
            authorizationListener.onError(e2);
        }
    }

    public ThirdPartyAuthorizationHelper(ThirdPartyServiceHelper thirdPartyServiceHelper) {
        if (c.f48305d == null) {
            c.f48305d = new c();
        }
        this.f15173b = c.f48305d;
        this.f15172a = thirdPartyServiceHelper;
        f15171c = 0;
    }

    public final Bundle a(Bundle bundle) throws AuthError {
        Bundle bundle2;
        if (bundle.getBoolean(AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE.val, false)) {
            String string = bundle.getString(AuthzConstants.BUNDLE_KEY.CODE_CHALLENGE.val);
            String string2 = bundle.getString(AuthzConstants.BUNDLE_KEY.CODE_CHALLENGE_METHOD.val);
            if (!TextUtils.isEmpty(string)) {
                bundle2 = new Bundle();
                bundle2.putString("code_challenge", string);
                bundle2.putString("code_challenge_method", string2);
            } else {
                throw new AuthError("Must provide code challenge parameter.", AuthError.ERROR_TYPE.ERROR_MISSING_CODE_CHALLENGE);
            }
        } else {
            c cVar = this.f15173b;
            cVar.getClass();
            byte[] bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
            String strEncodeToString = Base64.encodeToString(bArr, 11);
            cVar.f48306a = strEncodeToString;
            try {
                cVar.f48307b = "S256";
                cVar.f48308c = Base64.encodeToString(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(strEncodeToString.getBytes()), 11);
            } catch (NoSuchAlgorithmException unused) {
                cVar.f48307b = "plain";
                cVar.f48308c = cVar.f48306a;
            }
            bundle2 = new Bundle();
            bundle2.putString("code_challenge_method", cVar.f48307b);
            bundle2.putString("code_challenge", cVar.f48308c);
        }
        AuthzConstants.BUNDLE_KEY bundle_key = AuthzConstants.BUNDLE_KEY.SCOPE_DATA;
        if (bundle.getString(bundle_key.val) != null) {
            bundle2.putString("scope_data", bundle.getString(bundle_key.val));
        }
        AuthzConstants.BUNDLE_KEY bundle_key2 = AuthzConstants.BUNDLE_KEY.X_AMAZON_OPTIONS;
        if (bundle.getString(bundle_key2.val) != null) {
            bundle2.putString("com.amazon.oauth2.options", bundle.getString(bundle_key2.val));
        }
        bundle2.putString(PaymentConstants.CLIENT_ID, bundle.getString(AuthzConstants.BUNDLE_KEY.CLIENT_ID.val));
        return bundle2;
    }
}
