package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzelh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29639a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f29640b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f29641c;

    public zzelh(zzcmg zzcmgVar, zzijf zzijfVar, zzijh zzijhVar) {
        this.f29639a = zzijfVar;
        this.f29640b = zzcmgVar;
        this.f29641c = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f29639a.zzb();
        VersionInfoParcel versionInfoParcelA = this.f29640b.a();
        zzdkz zzdkzVar = (zzdkz) this.f29641c.f34899a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzelg(context, versionInfoParcelA, zzdkzVar, zzgywVar);
    }
}
