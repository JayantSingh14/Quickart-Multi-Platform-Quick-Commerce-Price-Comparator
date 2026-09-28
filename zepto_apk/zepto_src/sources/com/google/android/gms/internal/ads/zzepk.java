package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzepk {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f30031a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f30032b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f30033c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f30034d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f30035e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final zzgyw f30036f;

    /* renamed from: g, reason: collision with root package name */
    public JSONObject f30037g;

    public zzepk(zzgyw zzgywVar) {
        this.f30036f = zzgywVar;
    }

    public static final Bundle j(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.optString(next, ""));
            }
        }
        return bundle;
    }

    public final synchronized zzgtg a(String str, String str2) {
        Map map;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25911e) && (map = (Map) this.f30033c.get(str)) != null) {
                List<zzepm> list = (List) map.get(str2);
                if (list == null) {
                    String strA = zzdvb.a(this.f30037g, str2, str);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ac)).booleanValue()) {
                        strA = strA.toLowerCase(Locale.ROOT);
                    }
                    list = (List) map.get(strA);
                }
                if (list != null) {
                    HashMap map2 = new HashMap();
                    for (zzepm zzepmVar : list) {
                        String str3 = zzepmVar.f30038a;
                        if (!map2.containsKey(str3)) {
                            map2.put(str3, new ArrayList());
                        }
                        ((List) map2.get(str3)).add(zzepmVar.f30039b);
                    }
                    return zzgtg.a(map2);
                }
            }
            return zzgvd.f33244g;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap map = this.f30031a;
            if (!map.containsKey(str)) {
                map.put(str, new zzepm(str, new Bundle()));
            }
        }
    }

    public final synchronized void c() {
        this.f30032b.clear();
        this.f30031a.clear();
        this.f30035e.clear();
        this.f30034d.clear();
        f();
        d();
        e();
    }

    public final synchronized void d() {
        JSONObject jSONObject;
        if (!((Boolean) zzbiq.f25208f.c()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g2)).booleanValue() && (jSONObject = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25913g) != null) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("signal_adapters");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        Bundle bundleJ = j(jSONObject2.optJSONObject("data"));
                        String strOptString = jSONObject2.optString("adapter_class_name");
                        boolean zOptBoolean = jSONObject2.optBoolean("render", false);
                        boolean zOptBoolean2 = jSONObject2.optBoolean("collect_signals", false);
                        if (!TextUtils.isEmpty(strOptString)) {
                            this.f30032b.put(strOptString, new zzepo(strOptString, zOptBoolean2, zOptBoolean, true, bundleJ));
                        }
                    }
                } catch (JSONException e2) {
                    com.google.android.gms.ads.internal.util.zze.l("Malformed config loading JSON.", e2);
                }
            }
        }
    }

    public final synchronized void e() {
        JSONObject jSONObject;
        try {
            if (!((Boolean) zzbiq.f25204b.c()).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h2)).booleanValue() && (jSONObject = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25913g) != null) {
                    JSONArray jSONArray = jSONObject.getJSONArray("adapter_settings");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String strOptString = jSONObject2.optString("adapter_class_name");
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("permission_set");
                        if (!TextUtils.isEmpty(strOptString) && jSONArrayOptJSONArray != null) {
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i3);
                                boolean zOptBoolean = jSONObject3.optBoolean("enable_rendering", false);
                                boolean zOptBoolean2 = jSONObject3.optBoolean("collect_secure_signals", false);
                                boolean zOptBoolean3 = jSONObject3.optBoolean("collect_secure_signals_on_full_app", false);
                                String strOptString2 = jSONObject3.optString("platform");
                                zzepo zzepoVar = new zzepo(strOptString, zOptBoolean2, zOptBoolean, zOptBoolean3, new Bundle());
                                if (strOptString2.equals("ADMOB")) {
                                    this.f30034d.put(strOptString, zzepoVar);
                                } else if (strOptString2.equals("AD_MANAGER")) {
                                    this.f30035e.put(strOptString, zzepoVar);
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Malformed config loading JSON.", e2);
        } finally {
        }
    }

    public final synchronized void f() {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25913g;
            if (jSONObject != null) {
                try {
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ad_unit_id_settings");
                    this.f30037g = jSONObject.optJSONObject("ad_unit_patterns");
                    if (jSONArrayOptJSONArray2 != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                            String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ac)).booleanValue() ? jSONObject2.optString("ad_unit_id", "").toLowerCase(Locale.ROOT) : jSONObject2.optString("ad_unit_id", "");
                            String strOptString = jSONObject2.optString("format", "");
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("mediation_config");
                            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ad_networks")) != null) {
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                    arrayList.addAll(g(jSONArrayOptJSONArray.getJSONObject(i3)));
                                }
                            }
                            h(strOptString, lowerCase, arrayList);
                        }
                    }
                } catch (JSONException e2) {
                    com.google.android.gms.ads.internal.util.zze.l("Malformed config loading JSON.", e2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ArrayList g(JSONObject jSONObject) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            if (jSONObject != null) {
                Bundle bundleJ = j(jSONObject.optJSONObject("data"));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rtb_adapters");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2, "");
                        if (!TextUtils.isEmpty(strOptString)) {
                            arrayList2.add(strOptString);
                        }
                    }
                    int size = arrayList2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str = (String) arrayList2.get(i3);
                        b(str);
                        if (((zzepm) this.f30031a.get(str)) != null) {
                            arrayList.add(new zzepm(str, bundleJ));
                        }
                    }
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized void h(String str, String str2, ArrayList arrayList) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            HashMap map = this.f30033c;
            Map map2 = (Map) map.get(str);
            if (map2 == null) {
                map2 = new HashMap();
            }
            map.put(str, map2);
            List arrayList2 = (List) map2.get(str2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            arrayList2.addAll(arrayList);
            map2.put(str2, arrayList2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzgtg i(String str) {
        HashMap map;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25911e)) {
                zzbgb zzbgbVar = zzbgk.P3;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zMatches = Pattern.matches((String) zzbdVar.f21153c.a(zzbgbVar), str);
                boolean zMatches2 = Pattern.matches((String) zzbdVar.f21153c.a(zzbgk.Q3), str);
                if (zMatches) {
                    map = new HashMap(this.f30035e);
                } else if (zMatches2) {
                    map = new HashMap(this.f30034d);
                }
                return zzgtg.a(map);
            }
            return zzgvd.f33244g;
        } catch (Throwable th) {
            throw th;
        }
    }
}
