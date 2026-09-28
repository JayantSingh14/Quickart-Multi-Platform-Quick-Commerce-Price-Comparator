package com.amazon.identity.auth.device.api.authorization;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseProcessor;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;

/* loaded from: classes3.dex */
public abstract class AuthorizeListener implements InteractiveListener<AuthorizeResult, AuthCancellation, AuthError> {

    public class a implements AuthorizationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15097a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15098b;

        public a(Context context, boolean z) {
            this.f15097a = context;
            this.f15098b = z;
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            AuthorizeListener.this.onError(authError);
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
        public final void onCancel(Bundle bundle) {
            AuthorizeListener.this.onCancel(new AuthCancellation(bundle));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Bundle bundle) {
            Context context = this.f15097a;
            AuthorizeListener authorizeListener = AuthorizeListener.this;
            boolean z = this.f15098b;
            if (bundle.getString(AuthzConstants.BUNDLE_KEY.AUTHORIZATION_CODE.val) == null && z) {
                User.fetch(context, new c.a(authorizeListener, bundle));
            } else {
                authorizeListener.onSuccess((AuthorizeListener) new AuthorizeResult(bundle));
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener
        public final void onError(AuthError authError) {
            AuthorizeListener.this.onError(authError);
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveAPI
    public final String getRequestType() {
        return "com.amazon.identity.auth.device.authorization.request.authorize";
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener
    public abstract void onCancel(AuthCancellation authCancellation);

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    public abstract void onError(AuthError authError);

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public final void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, l.a aVar) {
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, i.f
    public final void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        Bundle requestExtras = interactiveRequestRecord.getRequestExtras();
        AuthorizationResponseProcessor.handleResponse(context, uri, requestExtras.getStringArray("requestedScopes"), true, new a(context, requestExtras.getBoolean("shouldReturnUserData")));
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public final void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        if (exc instanceof AuthError) {
            onError((AuthError) exc);
        } else {
            onError(new AuthError("Could not complete the authorization request", exc, AuthError.ERROR_TYPE.ERROR_UNKNOWN));
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    public abstract void onSuccess(AuthorizeResult authorizeResult);
}
