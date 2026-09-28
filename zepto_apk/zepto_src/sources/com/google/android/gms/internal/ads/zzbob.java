package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbob implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzebh f25383a;

    public zzbob(zzebh zzebhVar) {
        this.f25383a = zzebhVar;
    }

    public static final Bundle b(Map map) throws JSONException {
        Bundle bundleI = androidx.fragment.app.e.i("request_origin", "inspector_ooct");
        if (map.containsKey("networkExtras")) {
            try {
                JSONObject jSONObject = new JSONObject((String) map.get("networkExtras"));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject.get(next);
                    if (obj instanceof String) {
                        bundleI.putString(next, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundleI.putInt(next, ((Integer) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        bundleI.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        bundleI.putFloat(next, ((Float) obj).floatValue());
                    } else if (obj instanceof Double) {
                        bundleI.putDouble(next, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundleI.putLong(next, ((Long) obj).longValue());
                    }
                }
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("OutOfContextTestingGmsgHandler.generateNetworkExtras", e2);
            }
        }
        return bundleI;
    }

    public static final ArrayList c(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.getString(i2));
            }
            return arrayList;
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("OutOfContextTestingGmsgHandler.stringArrayToList.".concat(str2), e2);
            return new ArrayList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x0419  */
    @Override // com.google.android.gms.internal.ads.zzbnn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r9, java.util.Map r10) {
        /*
            Method dump skipped, instructions count: 1548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbob.a(java.lang.Object, java.util.Map):void");
    }
}
