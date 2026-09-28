package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzell implements zzeji {

    /* renamed from: a, reason: collision with root package name */
    public final zzduu f29647a;

    public zzell(zzduu zzduuVar) {
        this.f29647a = zzduuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeji
    public final zzejj a(String str, JSONObject jSONObject) {
        return new zzejj(this.f29647a.a(str, jSONObject), new zzekv(), str);
    }
}
