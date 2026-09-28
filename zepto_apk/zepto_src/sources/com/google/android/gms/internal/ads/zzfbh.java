package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfbh implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30806a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30807b;

    public zzfbh(String str, int i2) {
        this.f30806a = str;
        this.f30807b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        int i2;
        JSONObject jSONObject = (JSONObject) obj;
        String str = this.f30806a;
        if (TextUtils.isEmpty(str) || (i2 = this.f30807b) == -1) {
            return;
        }
        try {
            JSONObject jSONObjectG = com.google.android.gms.ads.internal.util.zzbp.g("pii", jSONObject);
            jSONObjectG.put("pvid", str);
            jSONObjectG.put("pvid_s", i2);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Failed putting gms core app set ID info.", e2);
        }
    }
}
