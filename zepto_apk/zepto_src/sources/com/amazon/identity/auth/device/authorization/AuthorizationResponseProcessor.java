package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.appid.AppIdentifier;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.endpoint.TokenVendor;
import d.b;
import d.c;

/* loaded from: classes3.dex */
public final class AuthorizationResponseProcessor {

    public class a implements AuthorizationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuthorizationListener f15138a;

        public a(AuthorizationListener authorizationListener) {
            this.f15138a = authorizationListener;
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
        public final void onCancel(Bundle bundle) {
            AuthorizationListener authorizationListener = this.f15138a;
            if (authorizationListener != null) {
                authorizationListener.onCancel(bundle);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            authError.getMessage();
            AuthorizationListener authorizationListener = this.f15138a;
            if (authorizationListener != null) {
                authorizationListener.onError(authError);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Bundle bundle) {
            AuthorizationListener authorizationListener = this.f15138a;
            if (authorizationListener != null) {
                authorizationListener.onSuccess(bundle);
            }
        }
    }

    public static void handleResponse(Context context, Uri uri, String[] strArr, boolean z, AuthorizationListener authorizationListener) {
        AuthorizationResponseParser authorizationResponseParser = new AuthorizationResponseParser();
        uri.toString();
        try {
            Bundle bundleExtractResultsBundle = authorizationResponseParser.extractResultsBundle(uri, strArr);
            if (bundleExtractResultsBundle.containsKey(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val)) {
                authorizationListener.onCancel(bundleExtractResultsBundle);
                return;
            }
            if (bundleExtractResultsBundle.getBoolean(AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE.val, false)) {
                AuthorizationHelper.sendAuthorizationCodeAsResponse(bundleExtractResultsBundle.getString("code"), InternalAuthManager.getInstance(context).getClientId(), InternalAuthManager.getInstance(context).getRedirectURI(context), authorizationListener);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.amazon.identity.auth.device.authorization.returnAccessToken", z);
            AuthorizationHelper authorizationHelper = new AuthorizationHelper();
            if (c.f48305d == null) {
                c.f48305d = new c();
            }
            String str = c.f48305d.f48306a;
            String packageName = context.getPackageName();
            TokenVendor tokenVendor = new TokenVendor();
            j.a.f53504b.execute(new b(context, bundleExtractResultsBundle, bundle, new AppIdentifier(), authorizationHelper, new a(authorizationListener), tokenVendor, packageName, str));
        } catch (AuthError e2) {
            if (authorizationListener != null) {
                authorizationListener.onError(e2);
            }
        }
    }
}
