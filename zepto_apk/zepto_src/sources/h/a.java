package h;

import android.content.Context;
import com.amazon.identity.auth.device.api.authorization.Region;
import com.amazon.identity.auth.device.api.authorization.SubRegion;
import com.amazon.identity.auth.device.authorization.Service;
import com.amazon.identity.auth.device.authorization.Stage;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f48428g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f48429h = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Service f48431b;

    /* renamed from: d, reason: collision with root package name */
    public Region f48433d;

    /* renamed from: e, reason: collision with root package name */
    public SubRegion f48434e;

    /* renamed from: f, reason: collision with root package name */
    public final String f48435f;

    /* renamed from: a, reason: collision with root package name */
    public Stage f48430a = Stage.PROD;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48432c = false;

    public a(Context context, AppInfo appInfo) {
        this.f48433d = Region.NA;
        this.f48433d = Region.valueOf(context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getString("com.amazon.lwa.regionMode", Region.AUTO.toString()));
        if (appInfo != null) {
            this.f48435f = appInfo.f15210g;
        }
    }

    public static String b(Service service, Stage stage, boolean z, Enum r4) {
        String string = service.toString();
        String string2 = stage.toString();
        String string3 = r4.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(string2);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(z);
        return android.support.v4.media.b.r(sb, CLConstants.DOT_SALT_DELIMETER, string3);
    }

    public static void c(Service service, Stage stage, boolean z, Region region, String str) {
        f48428g.put(b(service, stage, z, region), str);
        if (Region.AUTO == region || Service.PANDA != service) {
            return;
        }
        f48429h.put(str, region);
    }

    public final String a() {
        if (Region.AUTO == this.f48433d) {
            Region region = Region.NA;
            try {
                String str = this.f48435f;
                if (str != null) {
                    region = (Region) f48429h.get("https://" + new URL(str).getHost());
                }
            } catch (MalformedURLException unused) {
            }
            this.f48433d = region;
        }
        return (String) f48428g.get(b(this.f48431b, this.f48430a, this.f48432c, this.f48433d));
    }
}
