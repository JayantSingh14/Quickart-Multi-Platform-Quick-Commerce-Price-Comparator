package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class LoadAdError extends AdError {

    /* renamed from: e, reason: collision with root package name */
    public final ResponseInfo f21017e;

    public LoadAdError(int i2, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i2, str, str2, adError);
        this.f21017e = responseInfo;
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject b() throws JSONException {
        JSONObject jSONObjectB = super.b();
        ResponseInfo responseInfo = this.f21017e;
        if (responseInfo == null) {
            jSONObjectB.put("Response Info", "null");
            return jSONObjectB;
        }
        jSONObjectB.put("Response Info", responseInfo.d());
        return jSONObjectB;
    }

    @Override // com.google.android.gms.ads.AdError
    public final String toString() {
        try {
            return b().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
