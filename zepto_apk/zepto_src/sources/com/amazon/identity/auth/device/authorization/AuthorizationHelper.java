package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.dataobject.RequestedScope;
import com.amazon.identity.auth.device.env.LWAEnvironment;
import h.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class AuthorizationHelper {
    public static final String AUTHZ_QUERY_PARAMS = "authzParams";

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(URLEncoder.encode(str));
        sb.append("=");
        if (str2 != null) {
            sb.append(URLEncoder.encode(str2));
        }
        return sb.toString();
    }

    public static String[] getCommonScopesForAuthorization(Context context, String[] strArr, List<RequestedScope> list) {
        List listAsList = Arrays.asList(strArr);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listAsList);
        if (list != null) {
            Iterator<RequestedScope> it = list.iterator();
            while (it.hasNext()) {
                String str = it.next().f15227b;
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String getCustomQueryParams(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(AUTHZ_QUERY_PARAMS);
        StringBuffer stringBuffer = new StringBuffer("");
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                stringBuffer.append('&');
                stringBuffer.append(a(str, bundle2.getString(str)));
            }
        }
        return stringBuffer.toString();
    }

    public static String getOAuth2ErrorUrl(Context context) {
        b bVar;
        synchronized (LWAEnvironment.class) {
            bVar = new b(context, null);
        }
        bVar.f48431b = Service.AUTHORIZATION;
        String strA = bVar.a();
        StringBuilder sb = new StringBuilder("/ap/oacerror");
        sb.append("?" + a(CLConstants.FIELD_ERROR_CODE, "400") + "&" + a("title", "lwa-android-session-expired-title") + "&" + a(APayConstants.Error.MESSAGE, "lwa-android-session-expired-body") + "&" + a("applicationName", ""));
        StringBuilder sb2 = new StringBuilder("&language=");
        sb2.append(Locale.getDefault().toString());
        sb.append(sb2.toString());
        try {
            URL url = new URL("https", strA, sb.toString());
            url.toString();
            return url.toString();
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0312  */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getOAuth2Url(android.content.Context r16, java.lang.String r17, java.lang.String r18, java.lang.String[] r19, java.lang.String r20, boolean r21, boolean r22, android.os.Bundle r23, com.amazon.identity.auth.device.dataobject.AppInfo r24) throws org.json.JSONException, java.net.MalformedURLException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.authorization.AuthorizationHelper.getOAuth2Url(android.content.Context, java.lang.String, java.lang.String, java.lang.String[], java.lang.String, boolean, boolean, android.os.Bundle, com.amazon.identity.auth.device.dataobject.AppInfo):java.lang.String");
    }

    public static void sendAuthorizationCodeAsResponse(String str, String str2, String str3, AuthorizationListener authorizationListener) throws AuthError {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new AuthError("Response bundle from Authorization does not contain authorization code", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
            }
            Bundle bundle = new Bundle();
            bundle.putString(AuthzConstants.BUNDLE_KEY.AUTHORIZATION_CODE.val, str);
            bundle.putString(AuthzConstants.BUNDLE_KEY.CLIENT_ID.val, str2);
            bundle.putString(AuthzConstants.BUNDLE_KEY.REDIRECT_URI.val, str3);
            bundle.toString();
            if (authorizationListener != null) {
                authorizationListener.onSuccess(bundle);
            }
        } catch (AuthError e2) {
            e2.getMessage();
            if (authorizationListener != null) {
                authorizationListener.onError(e2);
            }
        }
    }
}
