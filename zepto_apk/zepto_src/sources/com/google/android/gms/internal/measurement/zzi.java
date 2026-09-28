package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzi {
    public static zzao a(Object obj) {
        if (obj == null) {
            return zzao.p0;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            zzae zzaeVar = new zzae();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzaeVar.p(zzaeVar.n(), a(it.next()));
            }
            return zzaeVar;
        }
        zzal zzalVar = new zzal();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            zzao zzaoVarA = a(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                zzalVar.d((String) string, zzaoVarA);
            }
        }
        return zzalVar;
    }

    public static zzao b(zzje zzjeVar) {
        if (zzjeVar == null) {
            return zzao.o0;
        }
        int iA = zzjeVar.A() - 1;
        if (iA == 1) {
            return zzjeVar.u() ? new zzas(zzjeVar.v()) : zzao.v0;
        }
        if (iA == 2) {
            return zzjeVar.y() ? new zzah(Double.valueOf(zzjeVar.z())) : new zzah(null);
        }
        if (iA == 3) {
            return zzjeVar.w() ? new zzaf(Boolean.valueOf(zzjeVar.x())) : new zzaf(null);
        }
        if (iA != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List listS = zzjeVar.s();
        ArrayList arrayList = new ArrayList();
        Iterator it = listS.iterator();
        while (it.hasNext()) {
            arrayList.add(b((zzje) it.next()));
        }
        return new zzap(zzjeVar.t(), arrayList);
    }
}
