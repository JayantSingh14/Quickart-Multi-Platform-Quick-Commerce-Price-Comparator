package g;

import android.content.Context;
import android.util.Pair;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class j extends b<k> {

    /* renamed from: m, reason: collision with root package name */
    public final String f48422m;

    public j(Context context, AppInfo appInfo, String str) {
        super(context, appInfo);
        this.f48422m = str;
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final r a(i iVar) {
        return new k(iVar);
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void i() {
    }

    @Override // g.e
    public final String l() {
        return "/auth/relyingPartyLogout";
    }

    @Override // g.e
    public final ArrayList n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("token_type", "bearer"));
        arrayList.add(new Pair(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, this.f48422m));
        return arrayList;
    }
}
