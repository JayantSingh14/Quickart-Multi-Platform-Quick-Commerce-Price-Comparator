package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class g implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f53492a;

    public g(ArrayList arrayList) {
        this.f53492a = arrayList;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                h hVar = (h) h.class.cast(Class.forName(property, true, h.class.getClassLoader()).newInstance());
                h.b(hVar);
                this.f53492a.add(hVar);
                return null;
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }
        h.b(new h());
        return null;
    }
}
