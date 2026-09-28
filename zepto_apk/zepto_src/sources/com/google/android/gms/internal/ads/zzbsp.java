package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzbsp implements zzbod {

    /* renamed from: a, reason: collision with root package name */
    public final zzcdt f25530a;

    public zzbsp(zzbsr zzbsrVar, zzcdt zzcdtVar) {
        Objects.requireNonNull(zzbsrVar);
        this.f25530a = zzcdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void b(String str) {
        zzcdt zzcdtVar = this.f25530a;
        try {
            if (str == null) {
                zzcdtVar.c(new zzbru());
            } else {
                zzcdtVar.c(new zzbru(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void c(JSONObject jSONObject) {
        zzcdt zzcdtVar = this.f25530a;
        try {
            zzcdtVar.b(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e2) {
            zzcdtVar.c(e2);
        }
    }
}
