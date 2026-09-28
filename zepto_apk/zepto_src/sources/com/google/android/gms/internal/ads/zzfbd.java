package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfbd implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30800a;

    public zzfbd(String str) {
        this.f30800a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        try {
            ((JSONObject) obj).put("ms", this.f30800a);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Failed putting Ad ID.", e2);
        }
    }
}
