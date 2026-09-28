package com.google.android.gms.internal.maps;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzv extends zza implements zzx {
    @Override // com.google.android.gms.internal.maps.zzx
    public final boolean Ha(zzx zzxVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzxVar);
        Parcel parcelG = g(4, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final int zzd() {
        Parcel parcelG = g(5, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final String zze() {
        Parcel parcelG = g(1, z0());
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final String zzf() {
        Parcel parcelG = g(2, z0());
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final void zzg() {
        j1(3, z0());
    }
}
