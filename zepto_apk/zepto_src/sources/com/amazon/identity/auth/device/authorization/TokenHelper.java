package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.b;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.appid.AppIdentifier;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.endpoint.TokenVendor;
import com.amazon.identity.auth.device.shared.APIListener;
import d.f;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class TokenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final TokenVendor f15197a = new TokenVendor();

    public static void clearAuthStateServerSide(Context context, AppInfo appInfo, Bundle bundle) throws AuthError {
        try {
            f15197a.d(context, appInfo);
        } catch (IOException e2) {
            e2.getMessage();
            throw new AuthError(e2.getMessage(), AuthError.ERROR_TYPE.ERROR_IO);
        }
    }

    public static void getToken(Context context, String str, String str2, String[] strArr, APIListener aPIListener, AppIdentifier appIdentifier, Bundle bundle) throws AuthError {
        Bundle bundle2;
        Arrays.toString(strArr);
        appIdentifier.getClass();
        AppInfo appInfoA = AppIdentifier.a(context, str);
        if (appInfoA == null) {
            aPIListener.onError(new AuthError(b.C("APIKey info is unavailable for ", str), null, AuthError.ERROR_TYPE.ERROR_ACCESS_DENIED));
            return;
        }
        try {
            String tokenInternal = getTokenInternal(context, str, strArr, appInfoA, bundle);
            if (tokenInternal == null) {
                bundle2 = new Bundle();
            } else {
                String str3 = AuthzConstants.BUNDLE_KEY.TOKEN.val;
                Bundle bundle3 = new Bundle();
                bundle3.putString(str3, tokenInternal);
                bundle2 = bundle3;
            }
            aPIListener.onSuccess(bundle2);
        } catch (AuthError e2) {
            aPIListener.onError(e2);
        }
    }

    public static String getTokenInternal(Context context, String str, String[] strArr, AppInfo appInfo, Bundle bundle) throws Throwable {
        try {
            String strC = f15197a.c(context, strArr, appInfo, bundle);
            return strC == null ? (String) new f(str, strArr).b(context, new ThirdPartyServiceHelper()) : strC;
        } catch (IOException e2) {
            e2.getMessage();
            throw new AuthError("Error communicating with server", e2, AuthError.ERROR_TYPE.ERROR_IO);
        }
    }
}
