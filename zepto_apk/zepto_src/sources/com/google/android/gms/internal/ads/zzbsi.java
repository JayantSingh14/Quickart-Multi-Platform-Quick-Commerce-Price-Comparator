package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzbsi implements zzbod {

    /* renamed from: a, reason: collision with root package name */
    public final zzbrl f25515a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcdt f25516b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbsj f25517c;

    public zzbsi(zzbrl zzbrlVar, zzbsj zzbsjVar, zzcdt zzcdtVar) {
        Objects.requireNonNull(zzbsjVar);
        this.f25517c = zzbsjVar;
        this.f25515a = zzbrlVar;
        this.f25516b = zzcdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void b(String str) {
        zzcdt zzcdtVar = this.f25516b;
        zzbrl zzbrlVar = this.f25515a;
        try {
            if (str == null) {
                zzcdtVar.c(new zzbru());
            } else {
                zzcdtVar.c(new zzbru(str));
            }
        } catch (IllegalStateException unused) {
        } catch (Throwable th) {
            zzbrlVar.d();
            throw th;
        }
        zzbrlVar.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void c(JSONObject jSONObject) {
        zzbrl zzbrlVar = this.f25515a;
        zzcdt zzcdtVar = this.f25516b;
        try {
            try {
                zzcdtVar.b(this.f25517c.f25518a.c(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e2) {
                zzcdtVar.c(e2);
            }
        } finally {
            zzbrlVar.d();
        }
    }
}
