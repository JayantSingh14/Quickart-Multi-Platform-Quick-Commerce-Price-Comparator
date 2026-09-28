package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfbl implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f30812a;

    public zzfbl(JSONObject jSONObject) {
        this.f30812a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        try {
            ((JSONObject) obj).put("cache_state", this.f30812a);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.k("Unable to get cache_state");
        }
    }
}
