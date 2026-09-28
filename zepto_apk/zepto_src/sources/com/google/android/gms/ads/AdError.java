package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class AdError {

    /* renamed from: a, reason: collision with root package name */
    public final int f20981a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20982b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20983c;

    /* renamed from: d, reason: collision with root package name */
    public final AdError f20984d;

    public AdError(int i2, String str, String str2, AdError adError) {
        this.f20981a = i2;
        this.f20982b = str;
        this.f20983c = str2;
        this.f20984d = adError;
    }

    public final com.google.android.gms.ads.internal.client.zze a() {
        AdError adError = this.f20984d;
        return new com.google.android.gms.ads.internal.client.zze(this.f20981a, this.f20982b, this.f20983c, adError == null ? null : new com.google.android.gms.ads.internal.client.zze(adError.f20981a, adError.f20982b, adError.f20983c, null, null), null);
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.f20981a);
        jSONObject.put("Message", this.f20982b);
        jSONObject.put("Domain", this.f20983c);
        AdError adError = this.f20984d;
        if (adError == null) {
            jSONObject.put("Cause", "null");
            return jSONObject;
        }
        jSONObject.put("Cause", adError.b());
        return jSONObject;
    }

    public String toString() {
        try {
            return b().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
