package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzv;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class AdapterResponseInfo {

    /* renamed from: a, reason: collision with root package name */
    public final zzv f21014a;

    /* renamed from: b, reason: collision with root package name */
    public final AdError f21015b;

    public AdapterResponseInfo(zzv zzvVar) {
        this.f21014a = zzvVar;
        com.google.android.gms.ads.internal.client.zze zzeVar = zzvVar.f21300c;
        this.f21015b = zzeVar == null ? null : zzeVar.b();
    }

    public final String a() {
        return this.f21014a.f21303f;
    }

    public final String b() {
        return this.f21014a.f21302e;
    }

    public final JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        zzv zzvVar = this.f21014a;
        jSONObject.put("Adapter", zzvVar.f21298a);
        jSONObject.put("Latency", zzvVar.f21299b);
        String str = zzvVar.f21302e;
        if (str == null) {
            jSONObject.put("Ad Source Name", "null");
        } else {
            jSONObject.put("Ad Source Name", str);
        }
        String str2 = zzvVar.f21303f;
        if (str2 == null) {
            jSONObject.put("Ad Source ID", "null");
        } else {
            jSONObject.put("Ad Source ID", str2);
        }
        String str3 = zzvVar.f21304g;
        if (str3 == null) {
            jSONObject.put("Ad Source Instance Name", "null");
        } else {
            jSONObject.put("Ad Source Instance Name", str3);
        }
        String str4 = zzvVar.f21305h;
        if (str4 == null) {
            jSONObject.put("Ad Source Instance ID", "null");
        } else {
            jSONObject.put("Ad Source Instance ID", str4);
        }
        JSONObject jSONObject2 = new JSONObject();
        Bundle bundle = zzvVar.f21301d;
        for (String str5 : bundle.keySet()) {
            jSONObject2.put(str5, bundle.get(str5));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.f21015b;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
            return jSONObject;
        }
        jSONObject.put("Ad Error", adError.b());
        return jSONObject;
    }

    public final String toString() {
        try {
            return c().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
