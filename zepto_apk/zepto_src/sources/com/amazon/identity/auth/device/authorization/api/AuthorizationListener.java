package com.amazon.identity.auth.device.authorization.api;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.CancellableListener;
import com.amazon.identity.auth.device.shared.APIListener;

/* loaded from: classes3.dex */
public interface AuthorizationListener extends APIListener, CancellableListener<Bundle, Bundle, AuthError> {
    @Override // com.amazon.identity.auth.device.api.CancellableListener
    void onCancel(Bundle bundle);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    void onError(AuthError authError);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    void onSuccess(Bundle bundle);
}
