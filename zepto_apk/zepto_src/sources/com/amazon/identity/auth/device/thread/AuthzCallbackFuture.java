package com.amazon.identity.auth.device.thread;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.shared.APIListener;

/* loaded from: classes3.dex */
public class AuthzCallbackFuture extends MAPCallbackFuture implements AuthorizationListener {

    /* renamed from: a, reason: collision with root package name */
    public Bundle f15243a;

    public class a implements AuthorizationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APIListener f15244a;

        public a(APIListener aPIListener) {
            this.f15244a = aPIListener;
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener
        public final void onCancel(Bundle bundle) {
        }

        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
        public final /* bridge */ /* synthetic */ void onCancel(Object obj) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            APIListener aPIListener = this.f15244a;
            if (aPIListener != null) {
                aPIListener.onError(authError);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onSuccess(Bundle bundle) {
            APIListener aPIListener = this.f15244a;
            if (aPIListener != null) {
                aPIListener.onSuccess(bundle);
            }
        }
    }

    public AuthzCallbackFuture() {
        this((AuthorizationListener) null);
    }

    @Override // com.amazon.identity.auth.device.thread.MAPCallbackFuture
    public Bundle getResultHelper() {
        Bundle bundle = this.f15243a;
        return bundle != null ? bundle : super.getResultHelper();
    }

    public AuthzCallbackFuture(AuthorizationListener authorizationListener) {
        super(authorizationListener);
    }

    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
    public void onCancel(Bundle bundle) {
        this.f15243a = bundle;
        bundle.putSerializable(AuthzConstants.BUNDLE_KEY.FUTURE.val, AuthzConstants.FUTURE_TYPE.CANCEL);
        this.mLatch.countDown();
        this.mListener.onCancel(this.f15243a);
    }

    public AuthzCallbackFuture(APIListener aPIListener) {
        super(new a(aPIListener));
    }
}
