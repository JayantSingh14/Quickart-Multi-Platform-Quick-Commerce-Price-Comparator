package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.collections.CircleManager;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class GoogleMap {

    /* renamed from: a, reason: collision with root package name */
    public final IGoogleMapDelegate f38395a;

    /* renamed from: b, reason: collision with root package name */
    public UiSettings f38396b;

    public interface CancelableCallback {
    }

    /* loaded from: classes.dex */
    public interface InfoWindowAdapter {
        View c(Marker marker);

        View f(Marker marker);
    }

    @Deprecated
    public interface OnCameraChangeListener {
    }

    public interface OnCameraIdleListener {
        void b();
    }

    public interface OnCameraMoveCanceledListener {
    }

    public interface OnCameraMoveListener {
        void a();
    }

    public interface OnCameraMoveStartedListener {
        void a(int i2);
    }

    public interface OnCircleClickListener {
    }

    public interface OnGroundOverlayClickListener {
        void d(GroundOverlay groundOverlay);
    }

    /* loaded from: classes.dex */
    public interface OnIndoorStateChangeListener {
    }

    public interface OnInfoWindowClickListener {
        void a(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
    }

    public interface OnInfoWindowLongClickListener {
    }

    public interface OnMapCapabilitiesChangedListener {
    }

    public interface OnMapClickListener {
        void a(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void a();
    }

    public interface OnMapLongClickListener {
        void a(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean g(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnMarkerDragListener {
    }

    public interface OnMyLocationButtonClickListener {
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void a(Location location);
    }

    public interface OnMyLocationClickListener {
    }

    /* loaded from: classes.dex */
    public interface OnPoiClickListener {
        void a(PointOfInterest pointOfInterest);
    }

    public interface OnPolygonClickListener {
        void e(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void b(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void a(Bitmap bitmap);
    }

    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        new HashMap();
        new HashMap();
        this.f38395a = (IGoogleMapDelegate) Preconditions.checkNotNull(iGoogleMapDelegate);
    }

    public final void A(OnMapClickListener onMapClickListener) {
        try {
            this.f38395a.U4(new zzz(onMapClickListener));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void B(OnMapLoadedCallback onMapLoadedCallback) {
        try {
            this.f38395a.Aa(new zzj(onMapLoadedCallback));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void C(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.f38395a.K9(new zzaa(onMapLongClickListener));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void D(MarkerManager markerManager) {
        try {
            this.f38395a.q9(new zza(markerManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void E(MarkerManager markerManager) {
        try {
            this.f38395a.c9(new zzb(markerManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void F(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.f38395a.zb(new zzg(onMyLocationChangeListener));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void G(OnPoiClickListener onPoiClickListener) {
        IGoogleMapDelegate iGoogleMapDelegate = this.f38395a;
        try {
            if (onPoiClickListener == null) {
                iGoogleMapDelegate.e3(null);
            } else {
                iGoogleMapDelegate.e3(new zzr(onPoiClickListener));
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void H(PolygonManager polygonManager) {
        try {
            this.f38395a.R3(new zzo(polygonManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void I(PolylineManager polylineManager) {
        try {
            this.f38395a.da(new zzp(polylineManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void J(int i2, int i3, int i4, int i5) {
        try {
            this.f38395a.S7(i2, i3, i4, i5);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void K(boolean z) {
        try {
            this.f38395a.i9(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void L(SnapshotReadyCallback snapshotReadyCallback) {
        Preconditions.checkNotNull(snapshotReadyCallback, "Callback must not be null.");
        Preconditions.checkNotNull(snapshotReadyCallback, "Callback must not be null.");
        try {
            this.f38395a.c7(new zzq(snapshotReadyCallback), null);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final TileOverlay a(TileOverlayOptions tileOverlayOptions) {
        try {
            Preconditions.checkNotNull(tileOverlayOptions, "TileOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.zzam zzamVarDb = this.f38395a.Db(tileOverlayOptions);
            if (zzamVarDb != null) {
                return new TileOverlay(zzamVarDb);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(CameraUpdate cameraUpdate) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.f38395a.J5(cameraUpdate.f38393a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(CameraUpdate cameraUpdate, int i2) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.f38395a.x8(cameraUpdate.f38393a, i2, null);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final CameraPosition d() {
        try {
            return this.f38395a.b3();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final IndoorBuilding e() {
        try {
            com.google.android.gms.internal.maps.zzu zzuVarEb = this.f38395a.Eb();
            if (zzuVarEb != null) {
                return new IndoorBuilding(zzuVarEb);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Projection f() {
        try {
            return new Projection(this.f38395a.p5());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final UiSettings g() {
        try {
            if (this.f38396b == null) {
                this.f38396b = new UiSettings(this.f38395a.Y9());
            }
            return this.f38396b;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void h(CameraUpdate cameraUpdate) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.f38395a.n8(cameraUpdate.f38393a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void i(boolean z) {
        try {
            this.f38395a.O6(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void j(boolean z) {
        try {
            this.f38395a.p7(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void k(MarkerManager markerManager) {
        try {
            this.f38395a.S2(new zzf(markerManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void l(LatLngBounds latLngBounds) {
        try {
            this.f38395a.e2(latLngBounds);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void m(LocationSource locationSource) {
        IGoogleMapDelegate iGoogleMapDelegate = this.f38395a;
        try {
            if (locationSource == null) {
                iGoogleMapDelegate.U7(null);
            } else {
                iGoogleMapDelegate.U7(new zzt(locationSource));
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void n(MapStyleOptions mapStyleOptions) {
        try {
            this.f38395a.u8(mapStyleOptions);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void o(int i2) {
        try {
            this.f38395a.q4(i2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void p(float f2) {
        try {
            this.f38395a.M3(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void q(float f2) {
        try {
            this.f38395a.l9(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void r(boolean z) {
        try {
            this.f38395a.lb(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void s(OnCameraIdleListener onCameraIdleListener) {
        try {
            this.f38395a.l8(new zzy(onCameraIdleListener));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void t(OnCameraMoveListener onCameraMoveListener) {
        try {
            this.f38395a.N3(new zzw(onCameraMoveListener));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void u(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        try {
            this.f38395a.l3(new zzv(onCameraMoveStartedListener));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void v(CircleManager circleManager) {
        try {
            this.f38395a.x9(new zzn(circleManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void w(GroundOverlayManager groundOverlayManager) {
        try {
            this.f38395a.W4(new zzm(groundOverlayManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void x(com.rnmaps.maps.MapView mapView) {
        try {
            this.f38395a.f2(new zzk(mapView));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void y(MarkerManager markerManager) {
        try {
            this.f38395a.J1(new zzc(markerManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void z(MarkerManager markerManager) {
        try {
            this.f38395a.F4(new zzd(markerManager));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
