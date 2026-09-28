package com.google.maps.android.collections;

import android.os.RemoteException;
import android.view.View;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.AdvancedMarker;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.collections.MapObjectManager;
import com.rnmaps.maps.MapManager;
import com.rnmaps.maps.MapView;

/* loaded from: classes4.dex */
public class MarkerManager extends MapObjectManager<Marker, Collection> implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowLongClickListener {

    public class Collection extends MapObjectManager.Collection {

        /* renamed from: c, reason: collision with root package name */
        public GoogleMap.OnInfoWindowClickListener f45515c;

        /* renamed from: d, reason: collision with root package name */
        public GoogleMap.OnMarkerClickListener f45516d;

        /* renamed from: e, reason: collision with root package name */
        public MapView f45517e;

        /* renamed from: f, reason: collision with root package name */
        public GoogleMap.InfoWindowAdapter f45518f;

        public Collection() {
            super();
        }

        public final Marker h(MarkerOptions markerOptions) {
            GoogleMap googleMap = MarkerManager.this.f45510a;
            googleMap.getClass();
            if (markerOptions instanceof AdvancedMarkerOptions) {
                markerOptions.q = 1;
            }
            try {
                Preconditions.checkNotNull(markerOptions, "MarkerOptions must not be null.");
                zzad zzadVarD6 = googleMap.f38395a.D6(markerOptions);
                Marker advancedMarker = zzadVarD6 != null ? markerOptions.q == 1 ? new AdvancedMarker(zzadVarD6) : new Marker(zzadVarD6) : null;
                a(advancedMarker);
                return advancedMarker;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void i(MapView mapView) {
            this.f45518f = mapView;
        }

        public final void j(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
            this.f45515c = onInfoWindowClickListener;
        }

        public final void k(GoogleMap.OnMarkerClickListener onMarkerClickListener) {
            this.f45516d = onMarkerClickListener;
        }

        public final void l(MapView mapView) {
            this.f45517e = mapView;
        }
    }

    public MarkerManager(GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public final void a(Marker marker) {
        GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (onInfoWindowClickListener = collection.f45515c) == null) {
            return;
        }
        onInfoWindowClickListener.a(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public final View c(Marker marker) {
        GoogleMap.InfoWindowAdapter infoWindowAdapter;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (infoWindowAdapter = collection.f45518f) == null) {
            return null;
        }
        return infoWindowAdapter.c(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public final View f(Marker marker) {
        GoogleMap.InfoWindowAdapter infoWindowAdapter;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (infoWindowAdapter = collection.f45518f) == null) {
            return null;
        }
        return infoWindowAdapter.f(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public final boolean g(Marker marker) {
        GoogleMap.OnMarkerClickListener onMarkerClickListener;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (onMarkerClickListener = collection.f45516d) == null) {
            return false;
        }
        return onMarkerClickListener.g(marker);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void h(Object obj) {
        Marker marker = (Marker) obj;
        marker.getClass();
        try {
            marker.f38485a.zzo();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void i() {
        GoogleMap googleMap = this.f45510a;
        if (googleMap != null) {
            googleMap.y(this);
            googleMap.z(this);
            googleMap.D(this);
            googleMap.E(this);
            googleMap.k(this);
        }
    }

    public final Collection j() {
        return new Collection();
    }

    public final void k(Marker marker) {
    }

    public final void l(Marker marker) {
        MapView mapView;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (mapView = collection.f45517e) == null) {
            return;
        }
        mapView.getClass();
        WritableNativeMap writableNativeMapR = mapView.r(marker.a());
        MapManager mapManager = mapView.D0;
        ThemedReactContext themedReactContext = mapView.H0;
        mapManager.pushEvent(themedReactContext, mapView, "onMarkerDrag", writableNativeMapR);
        mapManager.pushEvent(themedReactContext, mapView.p(marker), "onDrag", mapView.r(marker.a()));
    }

    public final void m(Marker marker) {
        MapView mapView;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (mapView = collection.f45517e) == null) {
            return;
        }
        mapView.getClass();
        WritableNativeMap writableNativeMapR = mapView.r(marker.a());
        MapManager mapManager = mapView.D0;
        ThemedReactContext themedReactContext = mapView.H0;
        mapManager.pushEvent(themedReactContext, mapView, "onMarkerDragEnd", writableNativeMapR);
        mapManager.pushEvent(themedReactContext, mapView.p(marker), "onDragEnd", mapView.r(marker.a()));
    }

    public final void n(Marker marker) {
        MapView mapView;
        Collection collection = (Collection) this.f45511b.get(marker);
        if (collection == null || (mapView = collection.f45517e) == null) {
            return;
        }
        mapView.getClass();
        WritableNativeMap writableNativeMapR = mapView.r(marker.a());
        MapManager mapManager = mapView.D0;
        ThemedReactContext themedReactContext = mapView.H0;
        mapManager.pushEvent(themedReactContext, mapView, "onMarkerDragStart", writableNativeMapR);
        mapManager.pushEvent(themedReactContext, mapView.p(marker), "onDragStart", mapView.r(marker.a()));
    }
}
