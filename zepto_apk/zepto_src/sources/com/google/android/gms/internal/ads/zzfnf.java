package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzfnf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f31438a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f31439b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f31440c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f31441d;

    public zzfnf(zzclp zzclpVar, zzcmg zzcmgVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f31438a = zzclpVar;
        this.f31439b = zzcmgVar;
        this.f31440c = zzijfVar;
        this.f31441d = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f31438a.a();
        VersionInfoParcel versionInfoParcelA = this.f31439b.a();
        zzdur zzdurVar = (zzdur) this.f31440c.zzb();
        new zzegb();
        return new zzfnr(contextA, versionInfoParcelA, zzdurVar, new zzbzi(), (zzcld) this.f31441d.zzb());
    }
}
