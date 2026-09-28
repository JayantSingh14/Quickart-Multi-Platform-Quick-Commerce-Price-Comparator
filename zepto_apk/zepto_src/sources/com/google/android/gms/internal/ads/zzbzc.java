package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbzc {

    /* renamed from: a, reason: collision with root package name */
    public final List f25733a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25734b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25735c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25736d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f25737e;

    /* renamed from: f, reason: collision with root package name */
    public final String f25738f;

    /* renamed from: g, reason: collision with root package name */
    public final int f25739g;

    /* renamed from: h, reason: collision with root package name */
    public final JSONObject f25740h;

    /* renamed from: i, reason: collision with root package name */
    public final String f25741i;

    /* renamed from: j, reason: collision with root package name */
    public final long f25742j;

    /* renamed from: k, reason: collision with root package name */
    public final long f25743k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f25744l;

    /* renamed from: m, reason: collision with root package name */
    public final String f25745m;

    public zzbzc(JSONObject jSONObject) throws NumberFormatException {
        this.f25738f = jSONObject.optString("url");
        this.f25734b = jSONObject.optString("base_uri");
        this.f25735c = jSONObject.optString("post_parameters");
        this.f25736d = a(jSONObject.optString("drt_include"));
        this.f25745m = jSONObject.optString("content_type");
        this.f25744l = a(jSONObject.optString("use_compression"));
        this.f25737e = a(jSONObject.optString("cookies_include", "true"));
        jSONObject.optString("request_id");
        jSONObject.optString("type");
        String strOptString = jSONObject.optString("errors");
        this.f25733a = strOptString == null ? null : Arrays.asList(strOptString.split(","));
        this.f25739g = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.f25740h = jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.f25741i = jSONObject.optString("pool_key");
        String strOptString2 = jSONObject.optString("start_time");
        Long lValueOf = -1L;
        if (!TextUtils.isEmpty(strOptString2)) {
            try {
                lValueOf = Long.valueOf(strOptString2);
            } catch (NumberFormatException unused) {
            }
        }
        this.f25742j = lValueOf.longValue();
        String strOptString3 = jSONObject.optString("end_time");
        Long lValueOf2 = -1L;
        if (!TextUtils.isEmpty(strOptString3)) {
            try {
                lValueOf2 = Long.valueOf(strOptString3);
            } catch (NumberFormatException unused2) {
            }
        }
        this.f25743k = lValueOf2.longValue();
    }

    public static boolean a(String str) {
        if (str != null) {
            return str.equals("1") || str.equals("true");
        }
        return false;
    }
}
