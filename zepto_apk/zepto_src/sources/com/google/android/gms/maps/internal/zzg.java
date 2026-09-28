package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* loaded from: classes4.dex */
public final class zzg extends com.google.android.gms.internal.maps.zza implements IGoogleMapDelegate {
    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void Aa(zzap zzapVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzapVar);
        j1(42, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzag B4(PolygonOptions polygonOptions) {
        com.google.android.gms.internal.maps.zzag zzaeVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, polygonOptions);
        Parcel parcelG = g(10, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzaf.f36710a;
        if (strongBinder == null) {
            zzaeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            zzaeVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzag ? (com.google.android.gms.internal.maps.zzag) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzae(strongBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
        }
        parcelG.recycle();
        return zzaeVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzad D6(MarkerOptions markerOptions) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, markerOptions);
        Parcel parcelG = g(11, parcelZ0);
        com.google.android.gms.internal.maps.zzad zzadVarZ0 = com.google.android.gms.internal.maps.zzac.z0(parcelG.readStrongBinder());
        parcelG.recycle();
        return zzadVarZ0;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzam Db(TileOverlayOptions tileOverlayOptions) {
        com.google.android.gms.internal.maps.zzam zzakVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, tileOverlayOptions);
        Parcel parcelG = g(13, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzal.f36712a;
        if (strongBinder == null) {
            zzakVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            zzakVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzam ? (com.google.android.gms.internal.maps.zzam) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzak(strongBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        }
        parcelG.recycle();
        return zzakVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzu Eb() {
        com.google.android.gms.internal.maps.zzu zzsVar;
        Parcel parcelG = g(44, z0());
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzt.f36742a;
        if (strongBinder == null) {
            zzsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            zzsVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzu ? (com.google.android.gms.internal.maps.zzu) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzs(strongBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        }
        parcelG.recycle();
        return zzsVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void F4(zzah zzahVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzahVar);
        j1(84, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzr G3(GroundOverlayOptions groundOverlayOptions) {
        com.google.android.gms.internal.maps.zzr zzpVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, groundOverlayOptions);
        Parcel parcelG = g(12, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzq.f36741a;
        if (strongBinder == null) {
            zzpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            zzpVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzr ? (com.google.android.gms.internal.maps.zzr) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzp(strongBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        }
        parcelG.recycle();
        return zzpVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void J1(zzad zzadVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzadVar);
        j1(32, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void J5(IObjectWrapper iObjectWrapper) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, iObjectWrapper);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void K9(zzar zzarVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzarVar);
        j1(29, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void M3(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(93, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void N3(zzt zztVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zztVar);
        j1(97, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void O6(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(41, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void R3(zzbh zzbhVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzbhVar);
        j1(85, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void S2(zzi zziVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zziVar);
        j1(33, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void S7(int i2, int i3, int i4, int i5) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        parcelZ0.writeInt(i3);
        parcelZ0.writeInt(i4);
        parcelZ0.writeInt(i5);
        j1(39, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void U4(zzan zzanVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzanVar);
        j1(28, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void U7(ILocationSourceDelegate iLocationSourceDelegate) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, iLocationSourceDelegate);
        j1(24, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void W4(zzz zzzVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzzVar);
        j1(83, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IUiSettingsDelegate Y9() {
        IUiSettingsDelegate zzcaVar;
        Parcel parcelG = g(25, z0());
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzcaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            zzcaVar = iInterfaceQueryLocalInterface instanceof IUiSettingsDelegate ? (IUiSettingsDelegate) iInterfaceQueryLocalInterface : new zzca(strongBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
        }
        parcelG.recycle();
        return zzcaVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final CameraPosition b3() {
        Parcel parcelG = g(1, z0());
        CameraPosition cameraPosition = (CameraPosition) com.google.android.gms.internal.maps.zzc.a(parcelG, CameraPosition.CREATOR);
        parcelG.recycle();
        return cameraPosition;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void c7(zzbw zzbwVar, ObjectWrapper objectWrapper) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzbwVar);
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        j1(38, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void c9(zzax zzaxVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzaxVar);
        j1(31, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void da(zzbj zzbjVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzbjVar);
        j1(87, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzaj db(PolylineOptions polylineOptions) {
        com.google.android.gms.internal.maps.zzaj zzahVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, polylineOptions);
        Parcel parcelG = g(9, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzai.f36711a;
        if (strongBinder == null) {
            zzahVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            zzahVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzaj ? (com.google.android.gms.internal.maps.zzaj) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzah(strongBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
        }
        parcelG.recycle();
        return zzahVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void e2(LatLngBounds latLngBounds) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, latLngBounds);
        j1(95, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void e3(zzbf zzbfVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzbfVar);
        j1(80, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void f2(zzab zzabVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzabVar);
        j1(45, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzl h2(CircleOptions circleOptions) {
        com.google.android.gms.internal.maps.zzl zzjVar;
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, circleOptions);
        Parcel parcelG = g(35, parcelZ0);
        IBinder strongBinder = parcelG.readStrongBinder();
        int i2 = com.google.android.gms.internal.maps.zzk.f36740a;
        if (strongBinder == null) {
            zzjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            zzjVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzl ? (com.google.android.gms.internal.maps.zzl) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzj(strongBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
        }
        parcelG.recycle();
        return zzjVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void i9(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(18, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void l3(zzv zzvVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzvVar);
        j1(96, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void l8(zzp zzpVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzpVar);
        j1(99, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void l9(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(92, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void lb(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(22, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void n8(IObjectWrapper iObjectWrapper) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, iObjectWrapper);
        j1(4, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IProjectionDelegate p5() {
        IProjectionDelegate zzbuVar;
        Parcel parcelG = g(26, z0());
        IBinder strongBinder = parcelG.readStrongBinder();
        if (strongBinder == null) {
            zzbuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            zzbuVar = iInterfaceQueryLocalInterface instanceof IProjectionDelegate ? (IProjectionDelegate) iInterfaceQueryLocalInterface : new zzbu(strongBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
        }
        parcelG.recycle();
        return zzbuVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean p7(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        Parcel parcelG = g(20, parcelZ0);
        boolean z2 = parcelG.readInt() != 0;
        parcelG.recycle();
        return z2;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void q4(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        j1(16, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void q9(zzav zzavVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzavVar);
        j1(30, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean u8(MapStyleOptions mapStyleOptions) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, mapStyleOptions);
        Parcel parcelG = g(91, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void x8(IObjectWrapper iObjectWrapper, int i2, zzd zzdVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, iObjectWrapper);
        parcelZ0.writeInt(i2);
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzdVar);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void x9(zzx zzxVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzxVar);
        j1(89, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void zb(zzbb zzbbVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzbbVar);
        j1(36, parcelZ0);
    }
}
