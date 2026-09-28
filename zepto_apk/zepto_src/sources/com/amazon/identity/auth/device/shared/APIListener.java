package com.amazon.identity.auth.device.shared;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;

/* loaded from: classes3.dex */
public interface APIListener extends Listener<Bundle, AuthError> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.api.Listener
    void onError(AuthError authError);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.api.Listener
    void onSuccess(Bundle bundle);
}
