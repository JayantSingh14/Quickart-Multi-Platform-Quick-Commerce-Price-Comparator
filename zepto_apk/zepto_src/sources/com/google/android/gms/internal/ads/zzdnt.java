package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdnt implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcwb f28048a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdmk f28049b;

    public zzdnt(zzcwb zzcwbVar, zzdmk zzdmkVar) {
        this.f28048a = zzcwbVar;
        this.f28049b = zzdmkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzfhr zzfhrVarA = this.f28048a.a();
        JSONObject jSONObject = this.f28049b.f27968a.f27963a;
        zzijo.a(jSONObject);
        return new zzdnq(zzfhrVarA, jSONObject);
    }
}
