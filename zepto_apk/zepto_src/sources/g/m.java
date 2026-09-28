package g;

import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.token.RefreshAtzToken;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class m extends o {
    @Override // g.o
    public final boolean i(String str, String str2) {
        return false;
    }

    @Override // g.o
    public final RefreshAtzToken j(JSONObject jSONObject) throws JSONException, AuthError {
        RefreshAtzToken refreshAtzTokenJ = super.j(jSONObject);
        if (refreshAtzTokenJ != null) {
            return refreshAtzTokenJ;
        }
        throw new AuthError("JSON response did not contain an AccessAtzToken", AuthError.ERROR_TYPE.ERROR_JSON);
    }
}
