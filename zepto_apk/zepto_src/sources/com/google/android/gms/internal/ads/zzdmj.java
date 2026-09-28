package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdmj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdml f27967a;

    public zzdmj(zzdml zzdmlVar) {
        this.f27967a = zzdmlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdnq zzdnqVar = (zzdnq) this.f27967a.f27969a.zzb();
        zzijo.a(zzdnqVar);
        JSONObject jSONObject = zzdnqVar.f28039b;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(zzdnqVar.f28046a.z);
        } catch (JSONException unused) {
            return null;
        }
    }
}
