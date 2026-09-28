package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdnq extends zzdnr {

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f28039b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f28040c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f28041d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f28042e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f28043f;

    /* renamed from: g, reason: collision with root package name */
    public final String f28044g;

    /* renamed from: h, reason: collision with root package name */
    public final JSONObject f28045h;

    public zzdnq(zzfhr zzfhrVar, JSONObject jSONObject) {
        super(zzfhrVar);
        String[] strArr = {"tracking_urls_and_actions", "active_view"};
        JSONObject jSONObjectK = com.google.android.gms.ads.internal.util.zzbp.k(jSONObject, strArr);
        this.f28039b = jSONObjectK == null ? null : jSONObjectK.optJSONObject(strArr[1]);
        String[] strArr2 = {"allow_pub_owned_ad_view"};
        JSONObject jSONObjectK2 = com.google.android.gms.ads.internal.util.zzbp.k(jSONObject, strArr2);
        this.f28040c = jSONObjectK2 == null ? false : jSONObjectK2.optBoolean(strArr2[0], false);
        String[] strArr3 = {"attribution", "allow_pub_rendering"};
        JSONObject jSONObjectK3 = com.google.android.gms.ads.internal.util.zzbp.k(jSONObject, strArr3);
        this.f28041d = jSONObjectK3 == null ? false : jSONObjectK3.optBoolean(strArr3[1], false);
        String[] strArr4 = {"enable_omid"};
        JSONObject jSONObjectK4 = com.google.android.gms.ads.internal.util.zzbp.k(jSONObject, strArr4);
        this.f28042e = jSONObjectK4 == null ? false : jSONObjectK4.optBoolean(strArr4[0], false);
        String[] strArr5 = {"watermark_overlay_png_base64"};
        JSONObject jSONObjectK5 = com.google.android.gms.ads.internal.util.zzbp.k(jSONObject, strArr5);
        this.f28044g = jSONObjectK5 != null ? jSONObjectK5.optString(strArr5[0], "") : "";
        this.f28043f = jSONObject.optJSONObject("overlay") != null;
        this.f28045h = jSONObject.optJSONObject("omid_settings");
    }

    @Override // com.google.android.gms.internal.ads.zzdnr
    public final boolean a() {
        return this.f28043f;
    }

    @Override // com.google.android.gms.internal.ads.zzdnr
    public final boolean b() {
        return this.f28040c;
    }

    @Override // com.google.android.gms.internal.ads.zzdnr
    public final boolean c() {
        return this.f28042e;
    }

    @Override // com.google.android.gms.internal.ads.zzdnr
    public final boolean d() {
        return this.f28041d;
    }

    @Override // com.google.android.gms.internal.ads.zzdnr
    public final String e() {
        return this.f28044g;
    }

    @Override // com.google.android.gms.internal.ads.zzdnr
    public final zzfin f() {
        JSONObject jSONObject = this.f28045h;
        return jSONObject != null ? new zzfin(jSONObject) : this.f28046a.V;
    }
}
