package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzcxw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f27386a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27387b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcmg f27388c;

    public zzcxw(zzclp zzclpVar, zzcmg zzcmgVar, zzijf zzijfVar) {
        this.f27386a = zzclpVar;
        this.f27387b = zzijfVar;
        this.f27388c = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f27386a.a();
        zzfnr zzfnrVar = (zzfnr) this.f27387b.zzb();
        VersionInfoParcel versionInfoParcelA = this.f27388c.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzcxv(contextA, zzfnrVar, versionInfoParcelA, zzgywVar);
    }
}
