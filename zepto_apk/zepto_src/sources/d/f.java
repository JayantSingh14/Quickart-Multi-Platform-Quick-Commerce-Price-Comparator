package d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface;
import com.amazon.identity.auth.device.authorization.ThirdPartyServiceHelper;
import com.amazon.identity.auth.device.authorization.TokenHelper;
import com.amazon.identity.auth.device.endpoint.TokenVendor;
import com.amazon.identity.auth.device.utils.LWAServiceWrapper;
import f.k;
import f.m;

/* loaded from: classes4.dex */
public final class f extends LWAServiceWrapper<String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f48312a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f48313b;

    public f(String str, String[] strArr) {
        this.f48312a = strArr;
        this.f48313b = str;
    }

    @Override // com.amazon.identity.auth.device.utils.LWAServiceWrapper
    public final Object a(Context context, AmazonAuthorizationServiceInterface amazonAuthorizationServiceInterface) throws AuthError, RemoteException {
        TokenVendor tokenVendor = TokenHelper.f15197a;
        k.c(context);
        m.k(context).f();
        Bundle token = amazonAuthorizationServiceInterface.getToken(null, this.f48313b, this.f48312a);
        if (token != null) {
            token.setClassLoader(context.getClassLoader());
            String string = token.getString("accessAtzToken");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            AuthError authError = (AuthError) token.getParcelable(AuthError.AUTH_ERROR_EXECEPTION);
            if (authError != null) {
                if (AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN == authError.getType()) {
                    m.k(context).f();
                    return null;
                }
                authError.getMessage();
                ThirdPartyServiceHelper.clearCachedService(context);
                throw authError;
            }
        }
        return null;
    }
}
