package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfhw {

    /* renamed from: a, reason: collision with root package name */
    public final String f31179a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31180b;

    /* renamed from: c, reason: collision with root package name */
    public final JSONObject f31181c;

    /* renamed from: d, reason: collision with root package name */
    public final JSONObject f31182d;

    public zzfhw(JsonReader jsonReader) {
        JSONObject jSONObjectC = com.google.android.gms.ads.internal.util.zzbp.c(jsonReader);
        this.f31182d = jSONObjectC;
        this.f31179a = jSONObjectC.optString("ad_html", null);
        this.f31180b = jSONObjectC.optString("ad_base_url", null);
        this.f31181c = jSONObjectC.optJSONObject("ad_json");
    }
}
