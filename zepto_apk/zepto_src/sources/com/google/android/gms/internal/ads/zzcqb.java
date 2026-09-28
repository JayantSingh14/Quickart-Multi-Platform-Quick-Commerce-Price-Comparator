package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcqb implements zzcpr {

    /* renamed from: a, reason: collision with root package name */
    public final zzeak f26888a;

    public zzcqb(zzeak zzeakVar) {
        this.f26888a = zzeakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpr
    public final void c(JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.qa)).booleanValue()) {
            zzeak zzeakVar = this.f26888a;
            synchronized (zzeakVar) {
                zzeakVar.p = jSONObject;
            }
        }
    }
}
