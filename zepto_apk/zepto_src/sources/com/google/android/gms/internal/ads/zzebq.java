package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzebq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f29024a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f29025b;

    public zzebq(zzclp zzclpVar, zzcmg zzcmgVar) {
        this.f29024a = zzclpVar;
        this.f29025b = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f29024a.a();
        VersionInfoParcel versionInfoParcelA = this.f29025b.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzebp(contextA, versionInfoParcelA, zzgywVar);
    }
}
