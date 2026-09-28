package l;

import android.net.Uri;
import androidx.fragment.app.e;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f56127a;

    /* renamed from: b, reason: collision with root package name */
    public final String f56128b;

    /* renamed from: c, reason: collision with root package name */
    public final JSONObject f56129c;

    public b(Uri uri) {
        String queryParameter = uri.getQueryParameter("workflow_result");
        JSONObject jSONObject = null;
        if (queryParameter != null) {
            try {
                jSONObject = new JSONObject(queryParameter);
            } catch (JSONException unused) {
            }
        }
        this.f56129c = jSONObject;
        this.f56127a = uri.getQueryParameter("error");
        this.f56128b = uri.getQueryParameter(AuthorizationResponseParser.ERROR_DESCRIPTION);
        Boolean.parseBoolean(uri.getQueryParameter("error_recoverable"));
    }

    public final AuthError a() {
        String str;
        String str2 = this.f56127a;
        if (str2 != null && (str = this.f56128b) != null) {
            return new AuthError(e.p("error=", str2, " error_description=", str), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        if (this.f56129c == null) {
            return new AuthError("Failed to parse workflow response", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        return null;
    }
}
