package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzccv {

    /* renamed from: d, reason: collision with root package name */
    public String f25910d;

    /* renamed from: e, reason: collision with root package name */
    public String f25911e;

    /* renamed from: f, reason: collision with root package name */
    public long f25912f;

    /* renamed from: g, reason: collision with root package name */
    public JSONObject f25913g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f25914h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f25916j;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f25907a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f25908b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f25909c = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f25915i = new ArrayList();

    public zzccv(String str, long j2) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject3;
        this.f25910d = "";
        this.f25914h = false;
        this.f25916j = false;
        this.f25911e = str;
        this.f25912f = j2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f25913g = new JSONObject(str);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Mc)).booleanValue() && a()) {
                return;
            }
            if (this.f25913g.optInt(CLConstants.OTP_STATUS, -1) != 1) {
                this.f25914h = false;
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("App settings could not be fetched successfully.");
                return;
            }
            this.f25914h = true;
            this.f25910d = this.f25913g.optString("app_id");
            JSONArray jSONArrayOptJSONArray2 = this.f25913g.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(i3);
                    String strOptString = jSONObject.optString("format");
                    String strOptString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if ("interstitial".equalsIgnoreCase(strOptString)) {
                            this.f25908b.add(strOptString2);
                        } else if (("rewarded".equalsIgnoreCase(strOptString) || "rewarded_interstitial".equals(strOptString)) && (jSONObjectOptJSONObject3 = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.f25909c.put(strOptString2, new zzbst(jSONObjectOptJSONObject3));
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray3 = this.f25913g.optJSONArray("persistable_banner_ad_unit_ids");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                    this.f25907a.add(jSONArrayOptJSONArray3.optString(i4));
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z7)).booleanValue() && (jSONObjectOptJSONObject2 = this.f25913g.optJSONObject("common_settings")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("loeid")) != null) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                    this.f25915i.add(jSONArrayOptJSONArray.get(i5).toString());
                }
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.U6)).booleanValue() || (jSONObjectOptJSONObject = this.f25913g.optJSONObject("common_settings")) == null) {
                return;
            }
            this.f25916j = jSONObjectOptJSONObject.optBoolean("is_prefetching_enabled", false);
        } catch (JSONException e2) {
            int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Exception occurred while processing app setting json", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AppSettings.parseAppSettingsJson", e2);
        }
    }

    public final boolean a() {
        if (b()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Q4)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            zzdxe zzdxeVar = zztVar.f21684h.f25939i;
            if (zzdxeVar != null) {
                zzdxd zzdxdVarA = zzdxeVar.a();
                zzdxdVarA.b("action", "cld_reset");
                zzdxdVarA.b("cld_lut_ms", String.valueOf(this.f25912f));
                zzdxdVarA.b("event_timestamp", String.valueOf(zztVar.f21687k.currentTimeMillis()));
                zzdxdVarA.b("cld_ttl_sec", String.valueOf(c()));
                zzdxdVarA.c();
            }
        }
        this.f25907a.clear();
        this.f25908b.clear();
        this.f25909c.clear();
        this.f25910d = "";
        this.f25911e = "";
        this.f25913g = null;
        this.f25914h = false;
        this.f25915i.clear();
        this.f25916j = false;
        return true;
    }

    public final boolean b() {
        if (!TextUtils.isEmpty(this.f25911e) && this.f25913g != null) {
            long jC = c();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
            if (jC >= 0) {
                long j2 = this.f25912f;
                if (j2 > jCurrentTimeMillis || TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis - j2) > jC) {
                    return false;
                }
            }
        }
        return true;
    }

    public final long c() {
        zzbgb zzbgbVar = zzbgk.Pc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        return (!((Boolean) zzbdVar.f21153c.a(zzbgk.Oc)).booleanValue() || TextUtils.isEmpty(this.f25911e)) ? ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue() : this.f25913g.optLong("cache_ttl_sec", ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue());
    }
}
