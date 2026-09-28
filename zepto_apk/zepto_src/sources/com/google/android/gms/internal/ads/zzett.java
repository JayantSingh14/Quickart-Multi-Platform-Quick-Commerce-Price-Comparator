package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzett implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmg f30317a;

    public zzett(zzcmg zzcmgVar) {
        this.f30317a = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzetr zzb() {
        VersionInfoParcel versionInfoParcelA = this.f30317a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzetr(versionInfoParcelA, zzgywVar);
    }
}
