package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbss {

    /* renamed from: a, reason: collision with root package name */
    public final List f25534a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25535b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25536c;

    public zzbss(JSONObject jSONObject) throws JSONException {
        jSONObject.optString(CLConstants.SHARED_PREFERENCE_ITEM_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        this.f25534a = Collections.unmodifiableList(arrayList);
        jSONObject.optString("allocation_id", null);
        zzbsu zzbsuVar = com.google.android.gms.ads.internal.zzt.C.v;
        zzbsu.a("clickurl", jSONObject);
        zzbsu.a("imp_urls", jSONObject);
        zzbsu.a("downloaded_imp_urls", jSONObject);
        zzbsu.a("fill_urls", jSONObject);
        zzbsu.a("video_start_urls", jSONObject);
        zzbsu.a("video_complete_urls", jSONObject);
        zzbsu.a("video_reward_urls", jSONObject);
        jSONObject.optString("transaction_id");
        jSONObject.optString("valid_from_timestamp");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        if (jSONObjectOptJSONObject != null) {
            zzbsu.a("manual_impression_urls", jSONObjectOptJSONObject);
        }
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.toString();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.f25535b = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.optString("class_name");
        }
        jSONObject.optString("html_template", null);
        jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        if (jSONObjectOptJSONObject3 != null) {
            jSONObjectOptJSONObject3.toString();
        }
        zzbsu.a("template_ids", jSONObject);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        if (jSONObjectOptJSONObject4 != null) {
            jSONObjectOptJSONObject4.toString();
        }
        this.f25536c = jSONObject.optString("response_type", null);
        jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
