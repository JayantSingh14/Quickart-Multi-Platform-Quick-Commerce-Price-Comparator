package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzefs implements zzbry {
    @Override // com.google.android.gms.internal.ads.zzbry
    public final JSONObject zzb(Object obj) throws JSONException {
        zzeft zzeftVar = (zzeft) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ta)).booleanValue()) {
            zzbzc zzbzcVar = zzeftVar.f29241c;
            jSONObject2.put("ad_request_url", zzbzcVar.f25738f);
            jSONObject2.put("ad_request_post_body", zzbzcVar.f25735c);
        }
        zzbzc zzbzcVar2 = zzeftVar.f29241c;
        jSONObject2.put("base_url", zzbzcVar2.f25734b);
        jSONObject2.put("signals", zzeftVar.f29240b);
        zzefz zzefzVar = zzeftVar.f29239a;
        jSONObject3.put("body", zzefzVar.f29262c);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.l(zzefzVar.f29261b));
        jSONObject3.put("response_code", zzefzVar.f29260a);
        jSONObject3.put("latency", zzefzVar.f29263d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzbzcVar2.f25740h);
        return jSONObject;
    }
}
