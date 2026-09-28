package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzdyq {

    /* renamed from: a, reason: collision with root package name */
    public Long f28795a;

    /* renamed from: b, reason: collision with root package name */
    public final String f28796b;

    /* renamed from: c, reason: collision with root package name */
    public String f28797c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f28798d;

    /* renamed from: e, reason: collision with root package name */
    public String f28799e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f28800f;

    public /* synthetic */ zzdyq(String str) {
        this.f28796b = str;
    }

    public final String a() throws JSONException {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.eb);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", this.f28795a);
            jSONObject.put("eventCategory", this.f28796b);
            jSONObject.putOpt("event", this.f28797c);
            jSONObject.putOpt(CLConstants.FIELD_ERROR_CODE, this.f28798d);
            jSONObject.putOpt("rewardType", this.f28799e);
            jSONObject.putOpt("rewardAmount", this.f28800f);
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not convert parameters to JSON.");
        }
        String string = jSONObject.toString();
        int length = String.valueOf(str).length();
        return android.support.v4.media.a.n(new StringBuilder(String.valueOf(string).length() + length + 14 + 2), str, "(\"h5adsEvent\",", string, ");");
    }
}
