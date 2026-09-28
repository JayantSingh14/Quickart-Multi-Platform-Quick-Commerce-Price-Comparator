package com.google.android.gms.internal.maps;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public final class zzp extends zza implements zzr {
    @Override // com.google.android.gms.internal.maps.zzr
    public final void G1(LatLngBounds latLngBounds) {
        Parcel parcelZ0 = z0();
        zzc.c(parcelZ0, latLngBounds);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void Ka(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(11, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void L0(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(15, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void P2(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(17, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean X7(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzrVar);
        Parcel parcelG = g(19, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void f0(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(22, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void x4(IObjectWrapper iObjectWrapper) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, iObjectWrapper);
        j1(21, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void z6(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(13, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzi() {
        Parcel parcelG = g(20, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final LatLng zzk() {
        Parcel parcelG = g(4, z0());
        LatLng latLng = (LatLng) zzc.a(parcelG, LatLng.CREATOR);
        parcelG.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzn() {
        j1(1, z0());
    }
}
