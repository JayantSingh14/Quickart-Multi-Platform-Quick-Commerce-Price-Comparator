package h;

import android.content.Context;
import com.amazon.identity.auth.device.api.authorization.Region;
import com.amazon.identity.auth.device.api.authorization.SubRegion;
import com.amazon.identity.auth.device.authorization.Service;
import com.amazon.identity.auth.device.authorization.Stage;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class b extends a {
    static {
        Service service = Service.AUTHORIZATION;
        Stage stage = Stage.PROD;
        Region region = Region.NA;
        a.c(service, stage, false, region, "https://na.account.amazon.com");
        Region region2 = Region.EU;
        a.c(service, stage, false, region2, "https://eu.account.amazon.com");
        Region region3 = Region.FE;
        a.c(service, stage, false, region3, "https://apac.account.amazon.com");
        Service service2 = Service.PANDA;
        a.c(service2, stage, true, region, "https://api.sandbox.amazon.com");
        a.c(service2, stage, true, region2, "https://api.sandbox.amazon.co.uk");
        a.c(service2, stage, true, region3, "https://api-sandbox.amazon.co.jp");
        a.c(service2, stage, false, region, "https://api.amazon.com");
        a.c(service2, stage, false, region2, "https://api.amazon.co.uk");
        a.c(service2, stage, false, region3, "https://api.amazon.co.jp");
        SubRegion subRegion = SubRegion.IN;
        String strB = a.b(service, stage, false, subRegion);
        HashMap map = a.f48428g;
        map.put(strB, "https://lwa.amazon.in");
        Region region4 = Region.AUTO;
        Region associatedRegion = subRegion.getAssociatedRegion();
        HashMap map2 = a.f48429h;
        if (region4 != associatedRegion && service2 == service) {
            map2.put("https://lwa.amazon.in", subRegion.getAssociatedRegion());
        }
        map.put(a.b(service2, stage, true, subRegion), "https://api.sandbox.amazon.co.uk");
        if (region4 != subRegion.getAssociatedRegion()) {
            map2.put("https://api.sandbox.amazon.co.uk", subRegion.getAssociatedRegion());
        }
        map.put(a.b(service2, stage, false, subRegion), "https://api.amazon.in");
        if (region4 != subRegion.getAssociatedRegion()) {
            map2.put("https://api.amazon.in", subRegion.getAssociatedRegion());
        }
    }

    public b(Context context, AppInfo appInfo) {
        super(context, appInfo);
        this.f48430a = Stage.PROD;
    }
}
