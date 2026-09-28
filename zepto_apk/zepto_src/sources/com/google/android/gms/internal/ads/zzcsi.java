package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcsi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcwb f27057a;

    public zzcsi(zzcwb zzcwbVar) {
        this.f27057a = zzcwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(this.f27057a.a().z);
        } catch (JSONException unused) {
            return null;
        }
    }
}
