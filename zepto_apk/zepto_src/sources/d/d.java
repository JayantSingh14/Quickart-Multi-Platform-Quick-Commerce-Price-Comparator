package d;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.ThirdPartyAuthorizationHelper;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;

/* loaded from: classes4.dex */
public final class d implements AuthorizationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthorizationListener f48309a;

    public d(AuthorizationListener authorizationListener) {
        this.f48309a = authorizationListener;
    }

    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
    public final void onCancel(Bundle bundle) {
        int i2 = ThirdPartyAuthorizationHelper.f15171c;
        AuthorizationListener authorizationListener = this.f48309a;
        if (authorizationListener != null) {
            authorizationListener.onCancel(bundle);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public final void onError(AuthError authError) {
        int i2 = ThirdPartyAuthorizationHelper.f15171c;
        authError.getMessage();
        AuthorizationListener authorizationListener = this.f48309a;
        if (authorizationListener != null) {
            authorizationListener.onError(authError);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public final void onSuccess(Bundle bundle) {
        int i2 = ThirdPartyAuthorizationHelper.f15171c;
        AuthorizationListener authorizationListener = this.f48309a;
        if (authorizationListener != null) {
            authorizationListener.onSuccess(bundle);
        }
    }
}
