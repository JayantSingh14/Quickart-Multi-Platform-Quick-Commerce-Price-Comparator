package com.amazon.identity.auth.device.endpoint;

import android.content.Context;
import android.net.ConnectivityManager;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.dataobject.AuthorizationToken;
import com.amazon.identity.auth.device.token.RefreshAtzToken;
import f.k;
import g.n;
import g.o;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ServerCommunication {
    public static AuthorizationToken[] a(RefreshAtzToken refreshAtzToken, String[] strArr, Context context, AppInfo appInfo) throws AuthError, IOException {
        Arrays.toString(strArr);
        String str = appInfo.f15205b;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            throw new IOException("Network is unavailable");
        }
        try {
            o oVar = (o) new n(context, refreshAtzToken, appInfo).k();
            oVar.f();
            return new AuthorizationToken[]{oVar.f48424e, oVar.f48425f};
        } catch (AuthError e2) {
            if (AuthError.ERROR_TYPE.ERROR_INVALID_GRANT.equals(e2.getType())) {
                k.c(context);
            }
            throw e2;
        }
    }
}
