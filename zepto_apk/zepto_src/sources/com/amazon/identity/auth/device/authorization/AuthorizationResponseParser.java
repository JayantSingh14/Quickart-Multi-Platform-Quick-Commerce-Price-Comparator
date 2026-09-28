package com.amazon.identity.auth.device.authorization;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.e;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class AuthorizationResponseParser {
    public static final String ACCESS_NOT_PERMITTED = "Access not permitted.";
    public static final String ACCESS_NOT_PERMITTED_ALT = "Access+not+permitted.";
    public static final int CAUSE_FAILED_AUTHENTICATION = 0;
    public static final String CLIENT_ID_STATE = "clientId";
    public static final String CLIENT_REQUEST_ID_STATE = "clientRequestId";
    public static final String CODE = "code";
    public static final String ERROR = "error";
    public static final String ERROR_ACCESS_DENIED = "access_denied";
    public static final String ERROR_DESCRIPTION = "error_description";
    public static final String ERROR_INVALID_ATN_TOKEN = "invalid_atn_token";
    public static final String REDIRECT_URI_STATE = "redirectUri";
    public static final String RESPONSE_URL = "responseUrl";
    public static final String SCOPE = "scope";

    public Bundle extractResultsBundle(String str, String[] strArr) throws AuthError {
        return extractResultsBundle(Uri.parse(str), strArr);
    }

    public Bundle extractResultsBundle(Uri uri, String[] strArr) throws AuthError {
        Bundle bundle = new Bundle();
        uri.toString();
        bundle.putString(RESPONSE_URL, Base64.encodeToString(uri.toString().getBytes(), 0));
        String queryParameter = uri.getQueryParameter("code");
        bundle.putString("code", queryParameter);
        String queryParameter2 = uri.getQueryParameter("error");
        if (!TextUtils.isEmpty(queryParameter2)) {
            String queryParameter3 = uri.getQueryParameter(ERROR_DESCRIPTION);
            if (ERROR_ACCESS_DENIED.equals(queryParameter2) && !TextUtils.isEmpty(queryParameter3) && (ACCESS_NOT_PERMITTED.equals(queryParameter3) || ACCESS_NOT_PERMITTED_ALT.equals(queryParameter3))) {
                bundle.putInt(AuthzConstants.BUNDLE_KEY.CAUSE_ID.val, 0);
                bundle.putString(AuthzConstants.BUNDLE_KEY.ON_CANCEL_TYPE.val, queryParameter2);
                bundle.putString(AuthzConstants.BUNDLE_KEY.ON_CANCEL_DESCRIPTION.val, queryParameter3);
                return bundle;
            }
            AuthError.ERROR_TYPE error_type = AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE;
            if (ERROR_INVALID_ATN_TOKEN.equals(queryParameter2)) {
                error_type = AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN;
            }
            throw new AuthError(e.p("Error=", queryParameter2, " error_description=", queryParameter3), error_type);
        }
        if (TextUtils.isEmpty(queryParameter)) {
            throw new AuthError("No code in OAuth2 response", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        String queryParameter4 = uri.getQueryParameter(SCOPE);
        String queryParameter5 = uri.getQueryParameter("state");
        if (queryParameter5 == null) {
            throw new AuthError(b.C("Response does not have a state parameter: ", uri.toString()), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        HashMap map = new HashMap();
        for (String str : TextUtils.split(queryParameter5, "&")) {
            String[] strArrSplit = TextUtils.split(str, "=");
            if (strArrSplit != null && strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        bundle.putString("clientId", (String) map.get("clientId"));
        bundle.putString(REDIRECT_URI_STATE, (String) map.get(REDIRECT_URI_STATE));
        AuthzConstants.BUNDLE_KEY bundle_key = AuthzConstants.BUNDLE_KEY.GET_AUTH_CODE;
        bundle.putBoolean(bundle_key.val, Boolean.parseBoolean((String) map.get(bundle_key.val)));
        if (queryParameter4 != null) {
            bundle.putStringArray(SCOPE, ScopesHelper.getScopesFromString(queryParameter4));
            return bundle;
        }
        bundle.putStringArray(SCOPE, strArr);
        return bundle;
    }
}
