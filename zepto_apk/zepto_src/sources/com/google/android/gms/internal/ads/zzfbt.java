package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfbt implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30820a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30821b;

    public zzfbt(String str, String str2) {
        this.f30820a = str;
        this.f30821b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        try {
            JSONObject jSONObjectG = com.google.android.gms.ads.internal.util.zzbp.g("pii", (JSONObject) obj);
            jSONObjectG.put("doritos", this.f30820a);
            jSONObjectG.put("doritos_v2", this.f30821b);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.k("Failed putting doritos string.");
        }
    }
}
