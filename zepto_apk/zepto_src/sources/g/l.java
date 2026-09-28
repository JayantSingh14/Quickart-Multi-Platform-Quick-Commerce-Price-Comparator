package g;

import android.content.Context;
import android.util.Pair;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class l extends c<m> {
    public final String o;
    public final String p;
    public final String q;

    public l(String str, String str2, String str3, AppInfo appInfo, Context context) {
        super(context, appInfo);
        this.o = str;
        this.p = str3;
        this.q = str2;
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final r a(i iVar) {
        return new m(iVar, this.f48397m);
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void i() {
    }

    @Override // g.c
    public final ArrayList q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("code", this.o));
        arrayList.add(new Pair("redirect_uri", this.p));
        arrayList.add(new Pair("code_verifier", this.q));
        return arrayList;
    }

    @Override // g.c
    public final String r() {
        return "authorization_code";
    }
}
