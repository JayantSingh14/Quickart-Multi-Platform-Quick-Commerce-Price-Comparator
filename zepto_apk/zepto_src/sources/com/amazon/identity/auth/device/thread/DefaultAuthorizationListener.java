package com.amazon.identity.auth.device.thread;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;

/* loaded from: classes3.dex */
public class DefaultAuthorizationListener implements AuthorizationListener {
    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener
    public final void onCancel(Bundle bundle) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener
    public final void onError(AuthError authError) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener
    public final void onSuccess(Bundle bundle) {
    }

    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.api.CancellableListener
    public final /* bridge */ /* synthetic */ void onCancel(Object obj) {
    }

    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public final /* bridge */ /* synthetic */ void onError(AuthError authError) {
    }

    @Override // com.amazon.identity.auth.device.authorization.api.AuthorizationListener, com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public final /* bridge */ /* synthetic */ void onSuccess(Bundle bundle) {
    }
}
