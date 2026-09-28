package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfco implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30849a;

    public zzfco(String str) {
        this.f30849a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            String str = this.f30849a;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.google.android.gms.ads.internal.util.zzbp.g("pii", jSONObject).put("adsid", str);
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed putting trustless token.", e2);
        }
    }
}
