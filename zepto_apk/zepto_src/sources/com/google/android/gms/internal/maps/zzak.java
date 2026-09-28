package com.google.android.gms.internal.maps;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzak extends zza implements zzam {
    @Override // com.google.android.gms.internal.maps.zzam
    public final boolean Ib(zzam zzamVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzamVar);
        Parcel parcelG = g(8, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void Q0(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(4, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void r8(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(12, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final int zzf() {
        Parcel parcelG = g(9, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzh() {
        j1(2, z0());
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzi() {
        j1(1, z0());
    }
}
