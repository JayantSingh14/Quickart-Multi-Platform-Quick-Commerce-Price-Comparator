package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;

/* loaded from: classes4.dex */
public final class zze extends com.google.android.gms.internal.maps.zza implements zzf {
    @Override // com.google.android.gms.maps.internal.zzf
    public final void C7(ObjectWrapper objectWrapper, int i2) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        parcelZ0.writeInt(i2);
        j1(10, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IStreetViewPanoramaViewDelegate F7(ObjectWrapper objectWrapper) {
        IStreetViewPanoramaViewDelegate zzbzVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        parcelZ0.writeInt(0);
        Parcel parcelG = g(7, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzbzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            zzbzVar = iInterfaceQueryLocalInterface instanceof IStreetViewPanoramaViewDelegate ? (IStreetViewPanoramaViewDelegate) iInterfaceQueryLocalInterface : new zzbz(strongBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        }
        parcelG.recycle();
        return zzbzVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void G0(ObjectWrapper objectWrapper) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        j1(11, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void O0(ObjectWrapper objectWrapper) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        parcelZ0.writeInt(18020000);
        j1(6, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IStreetViewPanoramaFragmentDelegate Z6(ObjectWrapper objectWrapper) {
        IStreetViewPanoramaFragmentDelegate zzbyVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        Parcel parcelG = g(8, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzbyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            zzbyVar = iInterfaceQueryLocalInterface instanceof IStreetViewPanoramaFragmentDelegate ? (IStreetViewPanoramaFragmentDelegate) iInterfaceQueryLocalInterface : new zzby(strongBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        }
        parcelG.recycle();
        return zzbyVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapViewDelegate e8(ObjectWrapper objectWrapper, GoogleMapOptions googleMapOptions) {
        IMapViewDelegate zzlVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, googleMapOptions);
        Parcel parcelG = g(3, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzlVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            zzlVar = iInterfaceQueryLocalInterface instanceof IMapViewDelegate ? (IMapViewDelegate) iInterfaceQueryLocalInterface : new zzl(strongBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
        }
        parcelG.recycle();
        return zzlVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapFragmentDelegate m8(ObjectWrapper objectWrapper) {
        IMapFragmentDelegate zzkVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        Parcel parcelG = g(2, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            zzkVar = iInterfaceQueryLocalInterface instanceof IMapFragmentDelegate ? (IMapFragmentDelegate) iInterfaceQueryLocalInterface : new zzk(strongBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
        }
        parcelG.recycle();
        return zzkVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final int zzd() {
        Parcel parcelG = g(9, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final ICameraUpdateFactoryDelegate zze() {
        ICameraUpdateFactoryDelegate zzbVar;
        Parcel parcelG = g(4, z0());
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            zzbVar = iInterfaceQueryLocalInterface instanceof ICameraUpdateFactoryDelegate ? (ICameraUpdateFactoryDelegate) iInterfaceQueryLocalInterface : new zzb(strongBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        }
        parcelG.recycle();
        return zzbVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final com.google.android.gms.internal.maps.zzi zzj() {
        com.google.android.gms.internal.maps.zzi zzgVar;
        Parcel parcelG = g(5, z0());
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzh.f36739a;
        if (strongBinder == null) {
            zzgVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            zzgVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzi ? (com.google.android.gms.internal.maps.zzi) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzg(strongBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        }
        parcelG.recycle();
        return zzgVar;
    }
}
