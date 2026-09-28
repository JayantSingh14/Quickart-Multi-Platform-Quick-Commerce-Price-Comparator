package com.google.android.gms.internal.maps;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public final class zzab extends zza implements zzad {
    @Override // com.google.android.gms.internal.maps.zzad
    public final void A9(float f2, float f3) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        parcelZ0.writeFloat(f3);
        j1(19, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void L1(float f2, float f3) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        parcelZ0.writeFloat(f3);
        j1(24, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void P0(String str) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void Q(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(22, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void Q1(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(14, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void S(IObjectWrapper iObjectWrapper) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, iObjectWrapper);
        j1(18, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void U9(String str) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean ab(zzad zzadVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzadVar);
        Parcel parcelG = g(16, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void h1(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void j0(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(27, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void k() {
        j1(11, z0());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void k3(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(20, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void mb(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(25, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void w2(LatLng latLng) {
        Parcel parcelZ0 = z0();
        zzc.c(parcelZ0, latLng);
        j1(3, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzg() {
        Parcel parcelG = g(17, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final LatLng zzj() {
        Parcel parcelG = g(4, z0());
        LatLng latLng = (LatLng) zzc.a(parcelG, LatLng.CREATOR);
        parcelG.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzl() {
        Parcel parcelG = g(8, z0());
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzm() {
        Parcel parcelG = g(6, z0());
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzn() {
        j1(12, z0());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzo() {
        j1(1, z0());
    }
}
