package g;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class p extends d<q> {

    /* renamed from: m, reason: collision with root package name */
    public final String f48426m;
    public final boolean n;

    public p(Context context, Bundle bundle, AppInfo appInfo, String str) {
        super(context, appInfo);
        this.f48426m = str;
        if (bundle != null) {
            this.n = bundle.getBoolean(AuthzConstants.BUNDLE_KEY.SANDBOX.val, false);
        }
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final r a(i iVar) {
        return new q(iVar);
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void i() {
    }

    @Override // g.e
    public final String l() {
        return "/user/profile";
    }

    @Override // g.e
    public final ArrayList m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("Authorization", "Bearer " + this.f48426m));
        return arrayList;
    }

    @Override // g.e
    public final ArrayList n() {
        return new ArrayList();
    }

    @Override // g.e
    public final boolean o() {
        return this.n;
    }
}
