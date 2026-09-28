package f;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface;
import com.amazon.identity.auth.device.utils.LWAServiceWrapper;

/* loaded from: classes4.dex */
public final class j extends LWAServiceWrapper<Bundle> {
    @Override // com.amazon.identity.auth.device.utils.LWAServiceWrapper
    public final Object a(Context context, AmazonAuthorizationServiceInterface amazonAuthorizationServiceInterface) throws AuthError, RemoteException {
        Bundle bundleClearAuthorizationState = amazonAuthorizationServiceInterface.clearAuthorizationState(null, context.getPackageName());
        if (bundleClearAuthorizationState == null || !bundleClearAuthorizationState.containsKey(AuthError.AUTH_ERROR_EXECEPTION)) {
            return new Bundle();
        }
        throw AuthError.extractError(bundleClearAuthorizationState);
    }
}
