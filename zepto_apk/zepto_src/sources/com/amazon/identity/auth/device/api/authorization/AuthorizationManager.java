package com.amazon.identity.auth.device.api.authorization;

import android.content.Context;
import android.os.Bundle;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.authorization.InternalAuthManager;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.shared.APIListener;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AuthorizationManager {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f15091a;

    public class a implements Listener<Void, AuthError> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f15092a;

        public a(CountDownLatch countDownLatch) {
            this.f15092a = countDownLatch;
        }

        @Override // com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            this.f15092a.countDown();
        }

        @Override // com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Void r1) {
            this.f15092a.countDown();
        }
    }

    public class b implements AuthorizationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15093a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AuthorizeRequest f15094b;

        public b(Context context, AuthorizeRequest authorizeRequest) {
            this.f15093a = context;
            this.f15094b = authorizeRequest;
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            this.f15094b.onError(authError);
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
        public final void onCancel(Bundle bundle) {
            this.f15094b.onCancel(new AuthCancellation(bundle));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Bundle bundle) {
            bundle.toString();
            Context context = this.f15093a;
            AuthorizeRequest authorizeRequest = this.f15094b;
            boolean zShouldReturnUserData = authorizeRequest.shouldReturnUserData();
            if (bundle.getString(AuthzConstants.BUNDLE_KEY.AUTHORIZATION_CODE.val) == null && zShouldReturnUserData) {
                User.fetch(context, new c.a(authorizeRequest, bundle));
            } else {
                authorizeRequest.onSuccess(new AuthorizeResult(bundle));
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener
        public final void onError(AuthError authError) {
            this.f15094b.onError(authError);
        }
    }

    public class c implements APIListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Listener f15095a;

        public c(Listener listener) {
            this.f15095a = listener;
        }

        @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            this.f15095a.onError(authError);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Bundle bundle) {
            this.f15095a.onSuccess(new AuthorizeResult(bundle));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.shared.APIListener
        public final void onError(AuthError authError) {
            this.f15095a.onError(authError);
        }
    }

    public class d implements APIListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Listener f15096a;

        public d(Listener listener) {
            this.f15096a = listener;
        }

        @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            this.f15096a.onError(authError);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Bundle bundle) {
            this.f15096a.onSuccess(null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.shared.APIListener
        public final void onError(AuthError authError) {
            this.f15096a.onError(authError);
        }
    }

    public static void authorize(AuthorizeRequest authorizeRequest) {
        Context context = authorizeRequest.getContext();
        context.getPackageName();
        List<Scope> scopes = authorizeRequest.getScopes();
        int size = scopes.size();
        String[] strArr = new String[size];
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < size; i2++) {
            Scope scope = scopes.get(i2);
            String name = scope.getName();
            strArr[i2] = name;
            if (scope.getScopeData() != null) {
                try {
                    jSONObject.put(name, scope.getScopeData());
                } catch (JSONException unused) {
                    scope.getScopeData().toString();
                }
            }
        }
        Bundle bundle = new Bundle();
        if (jSONObject.length() > 0) {
            bundle.putString(AuthzConstants.BUNDLE_KEY.SCOPE_DATA.val, jSONObject.toString());
        }
        if (authorizeRequest.getGrantType() == AuthorizeRequest.GrantType.AUTHORIZATION_CODE) {
            bundle.putBoolean(AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE.val, true);
        }
        if (authorizeRequest.getCodeChallenge() != null) {
            bundle.putString(AuthzConstants.BUNDLE_KEY.CODE_CHALLENGE.val, authorizeRequest.getCodeChallenge());
        }
        if (authorizeRequest.getCodeChallengeMethod() != null) {
            bundle.putString(AuthzConstants.BUNDLE_KEY.CODE_CHALLENGE_METHOD.val, authorizeRequest.getCodeChallengeMethod());
        }
        if (authorizeRequest.getSplitSignInForSubRegion() != null) {
            bundle.putString("com.amazon.identity.auth.device.authorization.splitSignInSubRegion", authorizeRequest.getSplitSignInForSubRegion().getStringValue());
        }
        bundle.putBoolean("com.amazon.identity.auth.device.authorization.returnAccessToken", true);
        bundle.putBoolean("com.amazon.identity.auth.device.authorizationshowProgress", authorizeRequest.shouldShowProgress());
        InternalAuthManager.getInstance(context).authorize(authorizeRequest, context, strArr, bundle, new b(context, authorizeRequest));
        InstrumentUtil.addMetricEvent("authorizeInvoked", "LWA_LITE_SDK.AUTHORIZATION_MANAGER_OPERATION", context, (String) null, (String) null);
    }

    public static Region getRegion(Context context) {
        return InternalAuthManager.getInstance(context).getRegion(context);
    }

    public static void getToken(Context context, Scope[] scopeArr, Listener<AuthorizeResult, AuthError> listener) throws JSONException {
        context.getPackageName();
        String[] strArr = new String[scopeArr.length];
        for (int i2 = 0; i2 < scopeArr.length; i2++) {
            strArr[i2] = scopeArr[i2].getName();
        }
        InternalAuthManager.getInstance(context).getToken(context, strArr, new c(listener));
        InstrumentUtil.addMetricEvent("GetTokenInvoked", "LWA_LITE_SDK.AUTHORIZATION_MANAGER_OPERATION", context, (String) null, (String) null);
    }

    public static boolean isSandboxMode(Context context) {
        if (f15091a == null) {
            f15091a = Boolean.valueOf(context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getBoolean("com.amazon.lwa.sandboxMode", false));
        }
        return f15091a.booleanValue();
    }

    public static void setRegion(Context context, Region region) {
        InternalAuthManager.getInstance(context).setRegion(context, region);
        InstrumentUtil.addMetricEvent("RegionSetTo=" + region.getStringValue(), "LWA_LITE_SDK.AUTHORIZATION_MANAGER_OPERATION", context, (String) null, (String) null);
    }

    public static void setSandboxMode(Context context, boolean z) throws JSONException {
        if (isSandboxMode(context) != z) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            signOut(context, new a(countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            } finally {
                context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putBoolean("com.amazon.lwa.sandboxMode", z).commit();
            }
        }
        f15091a = Boolean.valueOf(z);
    }

    public static void signOut(Context context, Listener<Void, AuthError> listener) throws JSONException {
        context.getPackageName();
        InternalAuthManager.getInstance(context).clearAuthorizationState(context, new d(listener));
        InstrumentUtil.addMetricEvent("SignOutInvoked", "LWA_LITE_SDK.AUTHORIZATION_MANAGER_OPERATION", context, (String) null, (String) null);
    }
}
