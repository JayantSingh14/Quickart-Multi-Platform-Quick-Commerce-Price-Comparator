package com.google.android.gms.ads.internal.util.client;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzv {

    /* renamed from: a, reason: collision with root package name */
    public final zzx f21451a;

    public zzv() {
        this.f21451a = new zzn(1, 0, 1.0d, false);
    }

    public static zzv a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ping_strategy");
        return new zzv(jSONObjectOptJSONObject == null ? new zzn(1, 0, 1.0d, false) : new zzn(jSONObjectOptJSONObject.optInt("max_attempts", 1), jSONObjectOptJSONObject.optInt("initial_backoff_ms", 0), jSONObjectOptJSONObject.optDouble("backoff_multiplier", 1.0d), jSONObjectOptJSONObject.optBoolean("buffer_after_max_attempts", false)));
    }

    public zzv(zzx zzxVar) {
        this.f21451a = zzxVar;
    }
}
