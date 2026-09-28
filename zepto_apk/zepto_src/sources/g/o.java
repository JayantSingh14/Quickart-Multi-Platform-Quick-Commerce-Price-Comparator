package g;

import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.SDKInfo;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.amazon.identity.auth.device.token.AccessAtzToken;
import com.amazon.identity.auth.device.token.RefreshAtzToken;
import java.util.Date;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class o extends a {

    /* renamed from: d, reason: collision with root package name */
    public final String f48423d;

    /* renamed from: e, reason: collision with root package name */
    public AccessAtzToken f48424e;

    /* renamed from: f, reason: collision with root package name */
    public RefreshAtzToken f48425f;

    public o(i iVar, String str) {
        super(iVar);
        this.f48425f = null;
        this.f48423d = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0028, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [g.o] */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.amazon.identity.auth.device.token.RefreshAtzToken] */
    @Override // g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(org.json.JSONObject r11) throws org.json.JSONException, com.amazon.identity.auth.device.AuthError {
        /*
            r10 = this;
            java.lang.String r0 = "expires_in"
            java.lang.String r1 = "token_expires_in"
            java.lang.String r2 = "access_token"
            boolean r3 = r11.has(r2)     // Catch: org.json.JSONException -> L55
            if (r3 == 0) goto L4b
            java.lang.String r6 = r11.getString(r2)     // Catch: org.json.JSONException -> L55
            boolean r2 = r11.has(r1)     // Catch: org.json.JSONException -> L26
            if (r2 == 0) goto L1b
            long r0 = r11.getLong(r1)     // Catch: org.json.JSONException -> L26
            goto L28
        L1b:
            boolean r1 = r11.has(r0)     // Catch: org.json.JSONException -> L26
            if (r1 == 0) goto L26
            long r0 = r11.getLong(r0)     // Catch: org.json.JSONException -> L26
            goto L28
        L26:
            r0 = 0
        L28:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            com.amazon.identity.auth.device.token.AccessAtzToken r4 = new com.amazon.identity.auth.device.token.AccessAtzToken
            java.util.Date r7 = new java.util.Date
            r7.<init>()
            java.util.Date r8 = new java.util.Date
            long r2 = r7.getTime()
            long r2 = r2 + r0
            r8.<init>(r2)
            r9 = 1
            java.lang.String r5 = r10.f48423d
            r4.<init>(r5, r6, r7, r8, r9)
            r10.f48424e = r4
            com.amazon.identity.auth.device.token.RefreshAtzToken r11 = r10.j(r11)
            r10.f48425f = r11
            return
        L4b:
            com.amazon.identity.auth.device.AuthError r11 = new com.amazon.identity.auth.device.AuthError     // Catch: org.json.JSONException -> L55
            java.lang.String r0 = "JSON response did not contain an AccessAtzToken"
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r1 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_JSON     // Catch: org.json.JSONException -> L55
            r11.<init>(r0, r1)     // Catch: org.json.JSONException -> L55
            throw r11     // Catch: org.json.JSONException -> L55
        L55:
            com.amazon.identity.auth.device.AuthError r11 = new com.amazon.identity.auth.device.AuthError
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_JSON
            java.lang.String r1 = "Error reading JSON response"
            r11.<init>(r1, r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: g.o.c(org.json.JSONObject):void");
    }

    @Override // g.a
    public final String d() {
        return SDKInfo.VERSION;
    }

    @Override // g.a
    public final JSONObject e(JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject("response");
        } catch (JSONException unused) {
            return jSONObject;
        }
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
            if ("invalid_grant".equals(string) || "unsupported_grant_type".equals(string)) {
                jSONObject.toString();
                throw new AuthError("Invalid source authorization in exchange." + jSONObject, AuthError.ERROR_TYPE.ERROR_INVALID_GRANT);
            }
            if (i(string, string2)) {
                Objects.toString(jSONObject);
                throw new AuthError("Invalid Token in exchange." + jSONObject, AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN);
            }
            if ("invalid_client".equals(string)) {
                jSONObject.toString();
                throw new AuthError("Invalid Client. ApiKey is invalid " + jSONObject, AuthError.ERROR_TYPE.ERROR_INVALID_CLIENT);
            }
            if ("invalid_scope".equals(string) || "insufficient_scope".equals(string)) {
                jSONObject.toString();
                throw new AuthError("Invalid Scope. Authorization not valid for the requested scopes " + jSONObject, AuthError.ERROR_TYPE.ERROR_INVALID_SCOPE);
            }
            if ("unauthorized_client".equals(string)) {
                jSONObject.toString();
                throw new AuthError("Unauthorized Client.  The authenticated client is not authorized to use this authorization grant type. " + jSONObject, AuthError.ERROR_TYPE.ERROR_UNAUTHORIZED_CLIENT);
            }
            jSONObject.toString();
            throw new AuthError("Server error doing authorization exchange. " + jSONObject, AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        } catch (JSONException unused2) {
            if (!TextUtils.isEmpty(string)) {
                throw new AuthError(android.support.v4.media.b.C("Server Error : ", string), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
            }
        }
    }

    public boolean i(String str, String str2) {
        if ("invalid_token".equals(str)) {
            return true;
        }
        return "invalid_request".equals(str) && !TextUtils.isEmpty(str2) && str2.contains("access_token");
    }

    public RefreshAtzToken j(JSONObject jSONObject) throws JSONException, AuthError {
        try {
            if (!jSONObject.has("refresh_token")) {
                return null;
            }
            String string = jSONObject.getString("refresh_token");
            String str = this.f48423d;
            Date date = new Date();
            return new RefreshAtzToken(str, string, date, date, 2);
        } catch (JSONException unused) {
            throw new AuthError("Error reading JSON response", AuthError.ERROR_TYPE.ERROR_JSON);
        }
    }
}
