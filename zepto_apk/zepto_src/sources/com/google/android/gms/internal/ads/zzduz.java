package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzduz {

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f28616b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f28617c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28618d;

    /* renamed from: e, reason: collision with root package name */
    public JSONObject f28619e;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f28615a = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f28620f = new AtomicBoolean(false);

    public zzduz(zzgyw zzgywVar) {
        this.f28617c = zzgywVar;
    }

    public final synchronized void a() {
        JSONObject jSONObject;
        Map map;
        try {
            this.f28618d = true;
            zzccv zzccvVarI = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i();
            if (zzccvVarI != null && (jSONObject = zzccvVarI.f25913g) != null) {
                this.f28616b = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.L4)).booleanValue() ? jSONObject.optJSONObject("common_settings") : null;
                this.f28619e = jSONObject.optJSONObject("ad_unit_patterns");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("ad_unit_id");
                            String strOptString2 = jSONObjectOptJSONObject.optString("format");
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("request_signals");
                            if (strOptString != null && jSONObjectOptJSONObject2 != null && strOptString2 != null) {
                                ConcurrentHashMap concurrentHashMap = this.f28615a;
                                if (concurrentHashMap.containsKey(strOptString2)) {
                                    map = (Map) concurrentHashMap.get(strOptString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                                    concurrentHashMap.put(strOptString2, concurrentHashMap2);
                                    map = concurrentHashMap2;
                                }
                                map.put(strOptString, jSONObjectOptJSONObject2);
                            }
                        }
                    }
                }
            }
        } finally {
        }
    }
}
