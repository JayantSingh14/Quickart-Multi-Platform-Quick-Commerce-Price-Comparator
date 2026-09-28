package g;

import android.content.Context;
import android.util.Pair;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import g.r;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class c<T extends r> extends e<T> {

    /* renamed from: m, reason: collision with root package name */
    public final String f48397m;
    public final String n;

    public c(Context context, AppInfo appInfo) throws AuthError {
        super(context, appInfo);
        if (appInfo == null) {
            throw new AuthError("Appinfo can not be null to make an OAuthTokenRequest", AuthError.ERROR_TYPE.ERROR_UNKNOWN);
        }
        this.f48397m = appInfo.f15205b;
        this.n = appInfo.f15208e;
    }

    @Override // g.e
    public final String l() {
        return "/auth/o2/token";
    }

    @Override // g.e
    public final ArrayList m() {
        return new ArrayList();
    }

    @Override // g.e
    public final ArrayList n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("grant_type", r()));
        arrayList.add(new Pair(PaymentConstants.CLIENT_ID, this.n));
        arrayList.addAll(q());
        return arrayList;
    }

    public abstract ArrayList q();

    public abstract String r();
}
