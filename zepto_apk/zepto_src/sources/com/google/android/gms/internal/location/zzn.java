package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;

/* loaded from: classes4.dex */
public final class zzn extends zza implements zzo {
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void A7(IStatusCallback iStatusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        zzc.d(parcelG, iStatusCallback);
        j1(84, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void H6(IStatusCallback iStatusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        zzc.d(parcelG, iStatusCallback);
        j1(85, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void H8(zzdb zzdbVar, IStatusCallback iStatusCallback) {
        Parcel parcelG = g();
        zzc.c(parcelG, zzdbVar);
        zzc.d(parcelG, iStatusCallback);
        j1(89, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void I7(LastLocationRequest lastLocationRequest, zzq zzqVar) {
        Parcel parcelG = g();
        zzc.c(parcelG, lastLocationRequest);
        zzc.d(parcelG, zzqVar);
        j1(82, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void I8(StatusCallback statusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        zzc.d(parcelG, statusCallback);
        j1(73, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void Ma(StatusCallback statusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        zzc.d(parcelG, statusCallback);
        j1(69, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void P5(zzm zzmVar, String str) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        zzc.d(parcelG, zzmVar);
        parcelG.writeString(str);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void Q7(zzdf zzdfVar) {
        Parcel parcelG = g();
        zzc.c(parcelG, zzdfVar);
        j1(59, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void a6(LocationSettingsRequest locationSettingsRequest, zzr zzrVar) {
        Parcel parcelG = g();
        zzc.c(parcelG, locationSettingsRequest);
        zzc.d(parcelG, zzrVar);
        parcelG.writeString(null);
        j1(63, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void c() {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        j1(13, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final LocationAvailability c0(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        Parcel parcelZ0 = z0(34, parcelG);
        LocationAvailability locationAvailability = (LocationAvailability) zzc.a(parcelZ0, LocationAvailability.CREATOR);
        parcelZ0.recycle();
        return locationAvailability;
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final ICancelToken c5(zzq zzqVar) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        zzc.d(parcelG, zzqVar);
        Parcel parcelZ0 = z0(87, parcelG);
        ICancelToken iCancelTokenAsInterface = ICancelToken.Stub.asInterface(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return iCancelTokenAsInterface;
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void j() {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        j1(12, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void p2(StatusCallback statusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        parcelG.writeInt(0);
        zzc.d(parcelG, statusCallback);
        j1(70, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void rb(StatusCallback statusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        parcelG.writeInt(0);
        zzc.d(parcelG, statusCallback);
        j1(72, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void s6(zzdb zzdbVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) {
        Parcel parcelG = g();
        zzc.c(parcelG, zzdbVar);
        zzc.c(parcelG, locationRequest);
        zzc.d(parcelG, iStatusCallback);
        j1(88, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void w5(IStatusCallback iStatusCallback) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        parcelG.writeInt(0);
        zzc.d(parcelG, iStatusCallback);
        j1(79, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void w6(zzk zzkVar) {
        Parcel parcelG = g();
        zzc.d(parcelG, zzkVar);
        j1(67, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void x6(zzm zzmVar) {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        parcelG.writeInt(0);
        zzc.d(parcelG, zzmVar);
        j1(57, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final Location zzd() {
        Parcel parcelZ0 = z0(7, g());
        Location location = (Location) zzc.a(parcelZ0, Location.CREATOR);
        parcelZ0.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzm() {
        Parcel parcelG = g();
        int i2 = zzc.f36639a;
        parcelG.writeInt(0);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzr() {
        Parcel parcelG = g();
        parcelG.writeLong(0L);
        int i2 = zzc.f36639a;
        parcelG.writeInt(1);
        parcelG.writeInt(0);
        j1(5, parcelG);
    }
}
