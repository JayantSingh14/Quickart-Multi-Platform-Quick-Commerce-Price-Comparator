package com.amazon.identity.auth.device.endpoint;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.dataobject.AuthorizationToken;
import com.amazon.identity.auth.device.dataobject.RequestedScope;
import com.amazon.identity.auth.device.token.AccessAtzToken;
import com.amazon.identity.auth.device.token.RefreshAtzToken;
import e.a;
import f.e;
import f.n;
import g.j;
import g.l;
import g.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import k.b;

/* loaded from: classes3.dex */
public class TokenVendor {

    /* renamed from: a, reason: collision with root package name */
    public final ServerCommunication f15237a = new ServerCommunication();

    public static AccessAtzToken b(RequestedScope[] requestedScopeArr, Context context) {
        if (requestedScopeArr == null || requestedScopeArr.length == 0) {
            return null;
        }
        e eVarK = e.k(context);
        AccessAtzToken accessAtzToken = (AccessAtzToken) ((AuthorizationToken) eVarK.c(requestedScopeArr[0].f15230e));
        if (accessAtzToken == null) {
            return null;
        }
        for (int i2 = 1; i2 < requestedScopeArr.length; i2++) {
            AuthorizationToken authorizationToken = (AuthorizationToken) eVarK.c(requestedScopeArr[i2].f15230e);
            if (authorizationToken == null || authorizationToken.f15203a != accessAtzToken.f15203a) {
                return null;
            }
        }
        return accessAtzToken;
    }

    public static void e(String str, String[] strArr, Context context, AccessAtzToken accessAtzToken, RefreshAtzToken refreshAtzToken) {
        for (RequestedScope requestedScope : f(str, strArr, context)) {
            if (requestedScope.f15203a == -1) {
                requestedScope.f15230e = accessAtzToken.f15203a;
                requestedScope.f15231f = refreshAtzToken.f15203a;
                requestedScope.toString();
                requestedScope.c(context).b(requestedScope, context);
            } else {
                AuthorizationToken authorizationToken = (AuthorizationToken) e.k(context).c(requestedScope.f15230e);
                if (authorizationToken != null) {
                    authorizationToken.a(context);
                }
                requestedScope.f15230e = accessAtzToken.f15203a;
                refreshAtzToken.getClass();
                AuthorizationToken authorizationToken2 = (AuthorizationToken) e.k(context).c(requestedScope.f15231f);
                if (authorizationToken2 != null) {
                    authorizationToken2.a(context);
                }
                requestedScope.f15231f = refreshAtzToken.f15203a;
                requestedScope.toString();
                requestedScope.e(context);
            }
        }
    }

    public static RequestedScope[] f(String str, String[] strArr, Context context) {
        n nVar;
        int length = strArr.length;
        RequestedScope[] requestedScopeArr = new RequestedScope[length];
        for (int i2 = 0; i2 < length; i2++) {
            synchronized (n.class) {
                try {
                    if (n.f48367b == null) {
                        n.f48367b = new n(b.b(context));
                    }
                    nVar = n.f48367b;
                } catch (Throwable th) {
                    throw th;
                }
            }
            String str2 = strArr[i2];
            nVar.getClass();
            String[] strArr2 = RequestedScope.f15226g;
            RequestedScope requestedScope = (RequestedScope) nVar.g(new String[]{strArr2[1], strArr2[2], strArr2[3]}, new String[]{str2, str, null});
            if (requestedScope != null) {
                requestedScopeArr[i2] = requestedScope;
            } else {
                Objects.toString(requestedScope);
                requestedScopeArr[i2] = new RequestedScope(strArr[i2], str, null);
            }
        }
        return requestedScopeArr;
    }

    public final Bundle a(String str, String str2, String str3, String[] strArr, Context context, AppInfo appInfo, Bundle bundle) throws AuthError, IOException {
        if (strArr == null || strArr.length == 0) {
            throw new AuthError("No scopes provided in parameters", AuthError.ERROR_TYPE.ERROR_BAD_API_PARAM);
        }
        this.f15237a.getClass();
        Arrays.toString(strArr);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            throw new IOException("Network is unavailable");
        }
        m mVar = (m) new l(str, str2, str3, appInfo, context).k();
        mVar.f();
        AccessAtzToken accessAtzToken = mVar.f48424e;
        AuthorizationToken[] authorizationTokenArr = {accessAtzToken, mVar.f48425f};
        if (accessAtzToken == null) {
            throw new AuthError("Access Atz token was null from server communication", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        if (e.k(context).b(accessAtzToken, context) == -1) {
            throw new AuthError("Unable to insert " + a.a(accessAtzToken.f15220g) + " token into db", AuthError.ERROR_TYPE.ERROR_DATA_STORAGE);
        }
        RefreshAtzToken refreshAtzToken = (RefreshAtzToken) authorizationTokenArr[1];
        if (refreshAtzToken == null) {
            throw new AuthError("Refresh Atz token was null from server communication", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        if (e.k(context).b(refreshAtzToken, context) == -1) {
            throw new AuthError("Unable to insert " + a.a(refreshAtzToken.f15220g) + " token into db", AuthError.ERROR_TYPE.ERROR_DATA_STORAGE);
        }
        e(appInfo.f15205b, strArr, context, accessAtzToken, refreshAtzToken);
        Bundle bundle2 = new Bundle();
        bundle2.putString(AuthzConstants.BUNDLE_KEY.AUTHORIZE.val, "authorized");
        if (bundle.getBoolean("com.amazon.identity.auth.device.authorization.returnAccessToken")) {
            bundle2.putString(AuthzConstants.BUNDLE_KEY.TOKEN.val, accessAtzToken.f15216c);
        }
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c(android.content.Context r18, java.lang.String[] r19, com.amazon.identity.auth.device.dataobject.AppInfo r20, android.os.Bundle r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.endpoint.TokenVendor.c(android.content.Context, java.lang.String[], com.amazon.identity.auth.device.dataobject.AppInfo, android.os.Bundle):java.lang.String");
    }

    public final void d(Context context, AppInfo appInfo) throws AuthError, IOException {
        n nVar;
        AccessAtzToken accessAtzTokenB;
        synchronized (n.class) {
            try {
                if (n.f48367b == null) {
                    n.f48367b = new n(b.b(context));
                }
                nVar = n.f48367b;
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayListE = nVar.e(null, null);
        if (arrayListE.isEmpty() || (accessAtzTokenB = b((RequestedScope[]) arrayListE.toArray(new RequestedScope[arrayListE.size()]), context)) == null) {
            return;
        }
        ServerCommunication serverCommunication = this.f15237a;
        j jVar = new j(context, appInfo, accessAtzTokenB.f15216c);
        serverCommunication.getClass();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            throw new IOException("Network is unavailable");
        }
        g.a aVar = (g.a) jVar.k();
        aVar.f();
    }
}
