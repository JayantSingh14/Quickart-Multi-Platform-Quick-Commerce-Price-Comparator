package com.google.android.gms.internal.ads;

import android.os.Bundle;
import in.juspay.hyper.constants.LogSubCategory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfca implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f30829a;

    public zzfca(Bundle bundle) {
        this.f30829a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) throws JSONException {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.f30829a;
        if (bundle != null) {
            try {
                com.google.android.gms.ads.internal.util.zzbp.g("play_store", com.google.android.gms.ads.internal.util.zzbp.g(LogSubCategory.Context.DEVICE, jSONObject)).put("parental_controls", com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.m(bundle));
            } catch (JSONException unused) {
                com.google.android.gms.ads.internal.util.zze.k("Failed putting parental controls bundle.");
            }
        }
    }
}
