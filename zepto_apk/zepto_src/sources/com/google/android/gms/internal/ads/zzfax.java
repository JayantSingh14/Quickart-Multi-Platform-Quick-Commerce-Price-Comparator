package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfax implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final AdvertisingIdClient.Info f30786a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30787b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfzf f30788c;

    public zzfax(AdvertisingIdClient.Info info, String str, zzfzf zzfzfVar) {
        this.f30786a = info;
        this.f30787b = str;
        this.f30788c = zzfzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) throws JSONException {
        try {
            JSONObject jSONObjectG = com.google.android.gms.ads.internal.util.zzbp.g("pii", (JSONObject) obj);
            AdvertisingIdClient.Info info = this.f30786a;
            if (info != null) {
                String str = info.f21070a;
                if (!TextUtils.isEmpty(str)) {
                    jSONObjectG.put("rdid", str);
                    jSONObjectG.put("is_lat", info.f21071b);
                    jSONObjectG.put("idtype", "adid");
                    zzfzf zzfzfVar = this.f30788c;
                    String str2 = zzfzfVar.f32087a;
                    long j2 = zzfzfVar.f32088b;
                    if (str2 != null && j2 > 0) {
                        jSONObjectG.put("paidv1_id_android_3p", str2);
                        jSONObjectG.put("paidv1_creation_time_android_3p", j2);
                        return;
                    }
                    return;
                }
            }
            String str3 = this.f30787b;
            if (str3 != null) {
                jSONObjectG.put("pdid", str3);
                jSONObjectG.put("pdidtype", "ssaid");
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Failed putting Ad ID.", e2);
        }
    }
}
