package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcsb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmg f27038a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27039b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijg f27040c;

    public zzcsb(zzcmg zzcmgVar, zzijf zzijfVar, zzijg zzijgVar) {
        this.f27038a = zzcmgVar;
        this.f27039b = zzijfVar;
        this.f27040c = zzijgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        VersionInfoParcel versionInfoParcelA = this.f27038a.a();
        JSONObject jSONObject = (JSONObject) this.f27039b.zzb();
        String str = (String) this.f27040c.zzb();
        boolean zEquals = "native".equals(str);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        return new zzbch(UUID.randomUUID().toString(), versionInfoParcelA, str, jSONObject, zEquals);
    }
}
