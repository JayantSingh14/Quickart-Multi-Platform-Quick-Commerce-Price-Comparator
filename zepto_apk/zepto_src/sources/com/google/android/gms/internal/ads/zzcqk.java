package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzcqk implements zzcpr {

    /* renamed from: a, reason: collision with root package name */
    public final zzcbp f26896a;

    public zzcqk(zzcbp zzcbpVar) {
        this.f26896a = zzcbpVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.internal.ads.zzcbn] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // com.google.android.gms.internal.ads.zzcpr
    public final void c(JSONObject jSONObject) {
        this.f26896a.f25845b.a(jSONObject.optBoolean("npa_reset") ? -1 : jSONObject.optBoolean("npa"), jSONObject.optLong("timestamp"));
    }
}
