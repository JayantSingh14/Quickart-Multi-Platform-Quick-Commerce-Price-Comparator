package com.google.android.gms.internal.ads;

import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzeus implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f30364a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f30365b;

    public zzeus(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f30364a = jSONObject;
        this.f30365b = jSONObject2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        JSONObject jSONObject = this.f30364a;
        if (jSONObject != null) {
            bundle.putString("fwd_cld", jSONObject.toString());
        }
        JSONObject jSONObject2 = this.f30365b;
        if (jSONObject2 != null) {
            bundle.putString("fwd_common_cld", jSONObject2.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        JSONObject jSONObject = this.f30365b;
        if (jSONObject != null) {
            zzczmVar.f27482b.putString("fwd_common_cld", jSONObject.toString());
        }
    }
}
