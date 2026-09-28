package com.google.android.gms.internal.ads;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfcs implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f30858a;

    public zzfcs(HashMap map) {
        this.f30858a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) throws JSONException {
        try {
            ((JSONObject) obj).put("video_decoders", com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.l(this.f30858a));
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.k("Could not encode video decoder properties: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
