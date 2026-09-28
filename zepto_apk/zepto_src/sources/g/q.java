package g;

import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.SDKInfo;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class q extends a {

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f48427d;

    @Override // g.a
    public final void c(JSONObject jSONObject) {
        this.f48427d = jSONObject;
    }

    @Override // g.a
    public final String d() {
        return SDKInfo.VERSION;
    }

    @Override // g.a
    public final JSONObject e(JSONObject jSONObject) {
        return jSONObject;
    }

    @Override // g.a
    public final void h(JSONObject jSONObject) throws JSONException, AuthError {
        String string;
        try {
            string = jSONObject.getString("error");
        } catch (JSONException unused) {
            string = null;
        }
        try {
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String string2 = jSONObject.getString(AuthorizationResponseParser.ERROR_DESCRIPTION);
            if ("insufficient_scope".equals(string)) {
                jSONObject.toString();
                throw new AuthError("Profile request not valid for authorized scopes", AuthError.ERROR_TYPE.ERROR_BAD_API_PARAM);
            }
            if (!"invalid_token".equals(string) && (!"invalid_request".equals(string) || TextUtils.isEmpty(string2) || !string2.contains("access_token"))) {
                jSONObject.toString();
                throw new AuthError("Server error doing authorization exchange. " + jSONObject, AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
            }
            jSONObject.toString();
            throw new AuthError("Invalid Token in exchange. " + jSONObject, AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN);
        } catch (JSONException unused2) {
            if (!TextUtils.isEmpty(string)) {
                throw new AuthError(android.support.v4.media.b.C("Server Error : ", string), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
            }
        }
    }
}
