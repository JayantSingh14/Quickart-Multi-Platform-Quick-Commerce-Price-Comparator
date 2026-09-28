package g;

import android.util.Pair;
import coil3.network.internal.UtilsKt;
import com.amazon.identity.auth.device.AuthError;
import g.r;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class b<T extends r> extends e<T> {
    @Override // g.e
    public final ArrayList m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(UtilsKt.CONTENT_TYPE, "application/json"));
        return arrayList;
    }

    @Override // g.e
    public final String p() throws JSONException, AuthError {
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator it = this.f48399f.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                jSONObject.put((String) pair.first, pair.second);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new AuthError("Received JSONException while building request", e2, AuthError.ERROR_TYPE.ERROR_BAD_PARAM);
        }
    }
}
