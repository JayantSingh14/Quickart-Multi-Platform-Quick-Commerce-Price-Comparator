package g;

import android.text.TextUtils;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.amazon.identity.auth.device.AuthError;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a implements r {

    /* renamed from: a, reason: collision with root package name */
    public final String f48394a;

    /* renamed from: b, reason: collision with root package name */
    public final int f48395b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f48396c;

    public a(i iVar) {
        this.f48395b = iVar.f48419a;
        this.f48394a = iVar.f48420b;
        this.f48396c = iVar.f48421c;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.f48394a);
        JSONObject jSONObjectE = e(jSONObject);
        try {
            jSONObject.getString("request_id");
        } catch (JSONException unused) {
        }
        return jSONObjectE;
    }

    public final void b(String str) throws AuthError {
        StringBuilder sbY = android.support.v4.media.b.y("Error code: ", str, " Server response: ");
        sbY.append(this.f48394a);
        throw new AuthError("Server Error : ".concat(sbY.toString()), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
    }

    public abstract void c(JSONObject jSONObject);

    public String d() {
        return "3.5.9";
    }

    public JSONObject e(JSONObject jSONObject) {
        return jSONObject.getJSONObject("response");
    }

    public final void f() throws AuthError {
        try {
            if (this.f48395b >= 500) {
            }
            JSONObject jSONObjectA = a();
            h(jSONObjectA);
            c(jSONObjectA);
            g(jSONObjectA);
        } catch (IOException e2) {
            e2.toString();
            throw new AuthError(e2.getMessage(), e2, AuthError.ERROR_TYPE.ERROR_COM);
        } catch (JSONException e3) {
            String str = this.f48394a;
            if (!TextUtils.isEmpty(str) && str.contains("!DOCTYPE html")) {
                throw new AuthError("Server sending back default error page - BAD request", e3, AuthError.ERROR_TYPE.ERROR_JSON);
            }
            e3.toString();
            throw new AuthError(e3.getMessage(), e3, AuthError.ERROR_TYPE.ERROR_JSON);
        }
    }

    public final void g(JSONObject jSONObject) throws JSONException, AuthError {
        String str = null;
        try {
            String string = jSONObject.getString("force_update");
            if (string != null) {
                try {
                    if (string.equals("1")) {
                        throw new AuthError("Server denied request, requested Force Update ver:".concat(d()), null, AuthError.ERROR_TYPE.ERROR_FORCE_UPDATE);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str = string;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    e.toString();
                    throw new AuthError(e.getMessage(), e, AuthError.ERROR_TYPE.ERROR_JSON);
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public void h(JSONObject jSONObject) throws JSONException, AuthError {
        JSONObject jSONObject2 = null;
        try {
            JSONObject jSONObject3 = jSONObject.getJSONObject("error");
            try {
                String string = jSONObject3.getString("code");
                if ("ServerError".equalsIgnoreCase(string)) {
                    if (jSONObject3.getString(APayConstants.Error.MESSAGE).startsWith("INVALID_TOKEN")) {
                        throw new AuthError("Invalid Exchange parameter - SERVER_ERROR.", AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN);
                    }
                    b(string);
                    throw null;
                }
                if ("InvalidSourceToken".equalsIgnoreCase(string)) {
                    throw new AuthError("Invalid Source Token in exchange parameter", AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN);
                }
                if ("InvalidToken".equals(string)) {
                    throw new AuthError("Token used is invalid.", AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN);
                }
                int i2 = this.f48395b;
                if (i2 < 500 || i2 >= 600) {
                    b(string);
                    throw null;
                }
                b("500 error (status=" + i2 + ")" + string);
                throw null;
            } catch (JSONException e2) {
                e = e2;
                jSONObject2 = jSONObject3;
                if (jSONObject2 != null) {
                    throw new AuthError("JSON exception parsing json error response:", e, AuthError.ERROR_TYPE.ERROR_JSON);
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }
}
