package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdmq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmg f27975a;

    public zzdmq(zzcmg zzcmgVar) {
        this.f27975a = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        VersionInfoParcel versionInfoParcelA = this.f27975a.a();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        return new zzbch(UUID.randomUUID().toString(), versionInfoParcelA, "native", new JSONObject(), true);
    }
}
