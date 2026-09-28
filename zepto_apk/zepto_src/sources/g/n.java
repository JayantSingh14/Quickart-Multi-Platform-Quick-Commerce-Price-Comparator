package g;

import android.content.Context;
import android.util.Pair;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.token.RefreshAtzToken;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class n extends c<o> {
    public final RefreshAtzToken o;

    public n(Context context, RefreshAtzToken refreshAtzToken, AppInfo appInfo) {
        super(context, appInfo);
        this.o = refreshAtzToken;
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final r a(i iVar) {
        return new o(iVar, this.f48397m);
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void i() {
        this.o.getClass();
    }

    @Override // g.c
    public final ArrayList q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("refresh_token", this.o.f15216c));
        return arrayList;
    }

    @Override // g.c
    public final String r() {
        return "refresh_token";
    }
}
