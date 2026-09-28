package com.google.android.gms.maps.internal;

import android.os.IInterface;
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
public interface IGoogleMapDelegate extends IInterface {
    void Aa(zzap zzapVar);

    com.google.android.gms.internal.maps.zzag B4(PolygonOptions polygonOptions);

    com.google.android.gms.internal.maps.zzad D6(MarkerOptions markerOptions);

    com.google.android.gms.internal.maps.zzam Db(TileOverlayOptions tileOverlayOptions);

    com.google.android.gms.internal.maps.zzu Eb();

    void F4(zzah zzahVar);

    com.google.android.gms.internal.maps.zzr G3(GroundOverlayOptions groundOverlayOptions);

    void J1(zzad zzadVar);

    void J5(IObjectWrapper iObjectWrapper);

    void K9(zzar zzarVar);

    void M3(float f2);

    void N3(zzt zztVar);

    void O6(boolean z);

    void R3(zzbh zzbhVar);

    void S2(zzi zziVar);

    void S7(int i2, int i3, int i4, int i5);

    void U4(zzan zzanVar);

    void U7(ILocationSourceDelegate iLocationSourceDelegate);

    void W4(zzz zzzVar);

    IUiSettingsDelegate Y9();

    CameraPosition b3();

    void c7(zzbw zzbwVar, ObjectWrapper objectWrapper);

    void c9(zzax zzaxVar);

    void da(zzbj zzbjVar);

    com.google.android.gms.internal.maps.zzaj db(PolylineOptions polylineOptions);

    void e2(LatLngBounds latLngBounds);

    void e3(zzbf zzbfVar);

    void f2(zzab zzabVar);

    com.google.android.gms.internal.maps.zzl h2(CircleOptions circleOptions);

    void i9(boolean z);

    void l3(zzv zzvVar);

    void l8(zzp zzpVar);

    void l9(float f2);

    void lb(boolean z);

    void n8(IObjectWrapper iObjectWrapper);

    IProjectionDelegate p5();

    boolean p7(boolean z);

    void q4(int i2);

    void q9(zzav zzavVar);

    boolean u8(MapStyleOptions mapStyleOptions);

    void x8(IObjectWrapper iObjectWrapper, int i2, zzd zzdVar);

    void x9(zzx zzxVar);

    void zb(zzbb zzbbVar);
}
