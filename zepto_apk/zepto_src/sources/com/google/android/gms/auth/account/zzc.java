package com.google.android.gms.auth.account;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzc extends com.google.android.gms.internal.auth.zza implements zze {
    @Override // com.google.android.gms.auth.account.zze
    public final void R8(zzb zzbVar) {
        Parcel parcelG = g();
        com.google.android.gms.internal.auth.zzc.d(parcelG, zzbVar);
        parcelG.writeString(null);
        z0(2, parcelG);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void h8(zzb zzbVar) {
        Parcel parcelG = g();
        com.google.android.gms.internal.auth.zzc.d(parcelG, zzbVar);
        parcelG.writeInt(0);
        z0(3, parcelG);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzf() {
        Parcel parcelG = g();
        int i2 = com.google.android.gms.internal.auth.zzc.f36312a;
        parcelG.writeInt(0);
        z0(1, parcelG);
    }
}
