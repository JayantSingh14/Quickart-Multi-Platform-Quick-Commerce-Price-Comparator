package com.google.android.gms.internal.maps;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public final class zzj extends zza implements zzl {
    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean J3(zzl zzlVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzlVar);
        Parcel parcelG = g(17, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void K(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void Q(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(13, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void X9(double d2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeDouble(d2);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void Y3(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void Z7(LatLng latLng) {
        Parcel parcelZ0 = z0();
        zzc.c(parcelZ0, latLng);
        j1(3, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void a0(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        j1(11, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzi() {
        Parcel parcelG = g(18, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzn() {
        j1(1, z0());
    }
}
