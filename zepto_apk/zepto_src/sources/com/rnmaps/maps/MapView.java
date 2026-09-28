package com.rnmaps.maps;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.maps.android.collections.CircleManager;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class MapView extends com.google.android.gms.maps.MapView implements GoogleMap.InfoWindowAdapter, GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnPoiClickListener, GoogleMap.OnIndoorStateChangeListener {
    public static final String[] V0 = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    public ReadableMap A;
    public final HashMap A0;
    public ReadableMap B;
    public final HashMap B0;
    public ReadableMap C;
    public final GestureDetectorCompat C0;
    public String D;
    public final MapManager D0;
    public boolean E;
    public LifecycleEventListener E0;
    public boolean F;
    public boolean F0;
    public LatLngBounds G;
    public boolean G0;
    public int H;
    public final ThemedReactContext H0;
    public MapMarker I;
    public final EventDispatcher I0;
    public final ArrayList J;
    public final FusedLocationSource J0;
    public final HashMap K;
    public final ViewAttacherGroup K0;
    public final HashMap L;
    public LatLng L0;
    public final HashMap M;
    public int M0;
    public int N0;
    public int O0;
    public int P0;
    public final HashMap Q;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public final Runnable U0;

    /* renamed from: b, reason: collision with root package name */
    public GoogleMap f46620b;

    /* renamed from: c, reason: collision with root package name */
    public MarkerManager f46621c;

    /* renamed from: d, reason: collision with root package name */
    public MarkerManager.Collection f46622d;

    /* renamed from: e, reason: collision with root package name */
    public PolylineManager f46623e;

    /* renamed from: f, reason: collision with root package name */
    public PolylineManager.Collection f46624f;

    /* renamed from: g, reason: collision with root package name */
    public PolygonManager f46625g;

    /* renamed from: h, reason: collision with root package name */
    public PolygonManager.Collection f46626h;

    /* renamed from: i, reason: collision with root package name */
    public CircleManager.Collection f46627i;

    /* renamed from: j, reason: collision with root package name */
    public GroundOverlayManager f46628j;

    /* renamed from: k, reason: collision with root package name */
    public GroundOverlayManager.Collection f46629k;

    /* renamed from: l, reason: collision with root package name */
    public ProgressBar f46630l;

    /* renamed from: m, reason: collision with root package name */
    public RelativeLayout f46631m;
    public ImageView n;
    public Boolean o;
    public Integer p;
    public Integer q;
    public LatLngBounds r;
    public CameraUpdate s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ReadableMap z;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MapView(com.facebook.react.uimanager.ThemedReactContext r4, com.facebook.react.bridge.ReactApplicationContext r5, com.rnmaps.maps.MapManager r6, com.google.android.gms.maps.GoogleMapOptions r7) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapView.<init>(com.facebook.react.uimanager.ThemedReactContext, com.facebook.react.bridge.ReactApplicationContext, com.rnmaps.maps.MapManager, com.google.android.gms.maps.GoogleMapOptions):void");
    }

    public static void e(MapView mapView, MapMarker mapMarker) {
        synchronized (mapView) {
            try {
                MapMarker mapMarker2 = mapView.I;
                if (mapMarker2 == mapMarker) {
                    return;
                }
                if (mapMarker2 != null) {
                    WritableNativeMap writableNativeMapR = mapView.r(mapMarker2.getPosition());
                    writableNativeMapR.putString("action", "marker-deselect");
                    writableNativeMapR.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, mapView.I.getIdentifier());
                    mapView.D0.pushEvent(mapView.H0, mapView.I, "onDeselect", writableNativeMapR);
                    WritableNativeMap writableNativeMapR2 = mapView.r(mapView.I.getPosition());
                    writableNativeMapR2.putString("action", "marker-deselect");
                    writableNativeMapR2.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, mapView.I.getIdentifier());
                    mapView.D0.pushEvent(mapView.H0, mapView, "onMarkerDeselect", writableNativeMapR2);
                }
                if (mapMarker != null) {
                    WritableNativeMap writableNativeMapR3 = mapView.r(mapMarker.getPosition());
                    writableNativeMapR3.putString("action", "marker-select");
                    writableNativeMapR3.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, mapMarker.getIdentifier());
                    mapView.D0.pushEvent(mapView.H0, mapMarker, "onSelect", writableNativeMapR3);
                    WritableNativeMap writableNativeMapR4 = mapView.r(mapMarker.getPosition());
                    writableNativeMapR4.putString("action", "marker-select");
                    writableNativeMapR4.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, mapMarker.getIdentifier());
                    mapView.D0.pushEvent(mapView.H0, mapView, "onMarkerSelect", writableNativeMapR4);
                }
                mapView.I = mapMarker;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ImageView getCacheImageView() {
        if (this.n == null) {
            ImageView imageView = new ImageView(getContext());
            this.n = imageView;
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            this.n.setVisibility(4);
        }
        return this.n;
    }

    private RelativeLayout getMapLoadingLayoutView() {
        if (this.f46631m == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.f46631m = relativeLayout;
            relativeLayout.setBackgroundColor(-3355444);
            addView(this.f46631m, new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f46631m.addView(getMapLoadingProgressBar(), layoutParams);
            this.f46631m.setVisibility(4);
        }
        setLoadingBackgroundColor(this.p);
        return this.f46631m;
    }

    private ProgressBar getMapLoadingProgressBar() {
        if (this.f46630l == null) {
            ProgressBar progressBar = new ProgressBar(getContext());
            this.f46630l = progressBar;
            progressBar.setIndeterminate(true);
        }
        Integer num = this.q;
        if (num != null) {
            setLoadingIndicatorColor(num);
        }
        return this.f46630l;
    }

    public static CameraPosition l(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder();
        ReadableMap map = readableMap.getMap("center");
        if (map != null) {
            builder.c(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        builder.d((float) readableMap.getDouble("pitch"));
        builder.a((float) readableMap.getDouble("heading"));
        builder.e((float) readableMap.getDouble("zoom"));
        return builder.b();
    }

    public static boolean m(Context context) {
        return context == null || context.getResources() == null || context.getResources().getConfiguration() == null;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPoiClickListener
    public final void a(PointOfInterest pointOfInterest) {
        WritableNativeMap writableNativeMapR = r(pointOfInterest.f38508a);
        writableNativeMapR.putString("placeId", pointOfInterest.f38509b);
        writableNativeMapR.putString(CLConstants.FIELD_PAY_INFO_NAME, pointOfInterest.f38510c);
        this.D0.pushEvent(this.H0, this, "onPoiClick", writableNativeMapR);
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public final void b(final GoogleMap googleMap) {
        if (this.G0) {
            return;
        }
        this.f46620b = googleMap;
        MarkerManager markerManager = new MarkerManager(googleMap);
        this.f46621c = markerManager;
        this.f46622d = markerManager.j();
        PolylineManager polylineManager = new PolylineManager(googleMap);
        this.f46623e = polylineManager;
        this.f46624f = polylineManager.j();
        PolygonManager polygonManager = new PolygonManager(googleMap);
        this.f46625g = polygonManager;
        this.f46626h = polygonManager.j();
        this.f46627i = new CircleManager(googleMap).j();
        GroundOverlayManager groundOverlayManager = new GroundOverlayManager(googleMap);
        this.f46628j = groundOverlayManager;
        this.f46629k = groundOverlayManager.j();
        this.f46622d.i(this);
        this.f46622d.l(this);
        this.f46620b.x(this);
        ReadableMap readableMap = this.z;
        if (readableMap != null) {
            t(readableMap);
            this.E = true;
        } else {
            ReadableMap readableMap2 = this.A;
            if (readableMap2 != null) {
                t(readableMap2);
            } else {
                ReadableMap readableMap3 = this.B;
                if (readableMap3 != null) {
                    s(readableMap3);
                    this.F = true;
                } else {
                    ReadableMap readableMap4 = this.C;
                    if (readableMap4 != null) {
                        s(readableMap4);
                    }
                }
            }
        }
        if (this.D != null) {
            this.f46620b.n(new MapStyleOptions(this.D));
        }
        setPoiClickEnabled(this.y);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        MapManager mapManager = this.D0;
        ThemedReactContext themedReactContext = this.H0;
        mapManager.pushEvent(themedReactContext, this, "onMapReady", writableNativeMap);
        googleMap.F(new GoogleMap.OnMyLocationChangeListener() { // from class: com.rnmaps.maps.MapView.3
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
            public final void a(Location location) {
                WritableMap writableNativeMap2 = new WritableNativeMap();
                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                writableNativeMap3.putDouble("latitude", location.getLatitude());
                writableNativeMap3.putDouble("longitude", location.getLongitude());
                writableNativeMap3.putDouble("altitude", location.getAltitude());
                writableNativeMap3.putDouble("timestamp", location.getTime());
                writableNativeMap3.putDouble("accuracy", location.getAccuracy());
                writableNativeMap3.putDouble("speed", location.getSpeed());
                writableNativeMap3.putDouble("heading", location.getBearing());
                writableNativeMap3.putBoolean("isFromMockProvider", location.isFromMockProvider());
                writableNativeMap2.putMap("coordinate", writableNativeMap3);
                MapView mapView = MapView.this;
                mapView.D0.pushEvent(mapView.H0, this, "onUserLocationChange", writableNativeMap2);
            }
        });
        this.f46622d.k(new GoogleMap.OnMarkerClickListener() { // from class: com.rnmaps.maps.MapView.4
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean g(Marker marker) {
                String[] strArr = MapView.V0;
                MapView mapView = MapView.this;
                MapMarker mapMarkerP = mapView.p(marker);
                WritableNativeMap writableNativeMapR = mapView.r(marker.a());
                writableNativeMapR.putString("action", "marker-press");
                writableNativeMapR.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, mapMarkerP.getIdentifier());
                MapManager mapManager2 = mapView.D0;
                ThemedReactContext themedReactContext2 = mapView.H0;
                MapView mapView2 = this;
                mapManager2.pushEvent(themedReactContext2, mapView2, "onMarkerPress", writableNativeMapR);
                WritableNativeMap writableNativeMapR2 = mapView.r(marker.a());
                writableNativeMapR2.putString("action", "marker-press");
                writableNativeMapR2.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, mapMarkerP.getIdentifier());
                mapManager2.pushEvent(themedReactContext2, mapMarkerP, "onPress", writableNativeMapR2);
                MapView.e(mapView, mapMarkerP);
                if (mapView2.w) {
                    return false;
                }
                marker.o();
                return true;
            }
        });
        this.f46626h.i(new GoogleMap.OnPolygonClickListener() { // from class: com.rnmaps.maps.MapView.5
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public final void e(Polygon polygon) {
                MapView mapView = MapView.this;
                WritableNativeMap writableNativeMapR = mapView.r(mapView.L0);
                writableNativeMapR.putString("action", "polygon-press");
                mapView.D0.pushEvent(mapView.H0, (View) mapView.M.get(polygon), "onPress", writableNativeMapR);
            }
        });
        this.f46624f.i(new GoogleMap.OnPolylineClickListener() { // from class: com.rnmaps.maps.MapView.6
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public final void b(Polyline polyline) {
                MapView mapView = MapView.this;
                WritableNativeMap writableNativeMapR = mapView.r(mapView.L0);
                writableNativeMapR.putString("action", "polyline-press");
                mapView.D0.pushEvent(mapView.H0, (View) mapView.L.get(polyline), "onPress", writableNativeMapR);
            }
        });
        this.f46622d.j(new GoogleMap.OnInfoWindowClickListener() { // from class: com.rnmaps.maps.MapView.7
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public final void a(Marker marker) {
                LatLng latLngA = marker.a();
                MapView mapView = MapView.this;
                WritableNativeMap writableNativeMapR = mapView.r(latLngA);
                writableNativeMapR.putString("action", "callout-press");
                MapManager mapManager2 = mapView.D0;
                ThemedReactContext themedReactContext2 = mapView.H0;
                mapManager2.pushEvent(themedReactContext2, this, "onCalloutPress", writableNativeMapR);
                WritableNativeMap writableNativeMapR2 = mapView.r(marker.a());
                writableNativeMapR2.putString("action", "callout-press");
                MapMarker mapMarkerP = mapView.p(marker);
                mapManager2.pushEvent(themedReactContext2, mapMarkerP, "onCalloutPress", writableNativeMapR2);
                WritableNativeMap writableNativeMapR3 = mapView.r(marker.a());
                writableNativeMapR3.putString("action", "callout-press");
                MapCallout calloutView = mapMarkerP.getCalloutView();
                if (calloutView != null) {
                    mapManager2.pushEvent(themedReactContext2, calloutView, "onPress", writableNativeMapR3);
                }
            }
        });
        googleMap.A(new GoogleMap.OnMapClickListener() { // from class: com.rnmaps.maps.MapView.8
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void a(LatLng latLng) {
                MapView mapView = MapView.this;
                WritableNativeMap writableNativeMapR = mapView.r(latLng);
                writableNativeMapR.putString("action", "press");
                mapView.D0.pushEvent(mapView.H0, this, "onPress", writableNativeMapR);
                MapView.e(mapView, null);
            }
        });
        googleMap.C(new GoogleMap.OnMapLongClickListener() { // from class: com.rnmaps.maps.MapView.9
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public final void a(LatLng latLng) {
                MapView mapView = MapView.this;
                mapView.r(latLng).putString("action", "long-press");
                WritableNativeMap writableNativeMapR = mapView.r(latLng);
                mapView.D0.pushEvent(mapView.H0, this, "onLongPress", writableNativeMapR);
            }
        });
        this.f46629k.i(new GoogleMap.OnGroundOverlayClickListener() { // from class: com.rnmaps.maps.MapView.10
            @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
            public final void d(GroundOverlay groundOverlay) {
                try {
                    LatLng latLngZzk = groundOverlay.f38460a.zzk();
                    MapView mapView = MapView.this;
                    WritableNativeMap writableNativeMapR = mapView.r(latLngZzk);
                    writableNativeMapR.putString("action", "overlay-press");
                    mapView.D0.pushEvent(mapView.H0, (View) mapView.Q.get(groundOverlay), "onPress", writableNativeMapR);
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            }
        });
        googleMap.u(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.rnmaps.maps.MapView.11
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void a(int i2) {
                MapView mapView = MapView.this;
                mapView.H = i2;
                boolean z = 1 == i2;
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putBoolean("isGesture", z);
                mapView.D0.pushEvent(mapView.H0, this, "onRegionChangeStart", writableNativeMap2);
            }
        });
        googleMap.t(new GoogleMap.OnCameraMoveListener() { // from class: com.rnmaps.maps.MapView.12
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void a() {
                LatLngBounds latLngBounds = googleMap.f().b().f38577e;
                MapView mapView = MapView.this;
                mapView.G = null;
                mapView.I0.g(new RegionChangeEvent(mapView.getId(), latLngBounds, true, 1 == mapView.H));
            }
        });
        googleMap.s(new GoogleMap.OnCameraIdleListener() { // from class: com.rnmaps.maps.MapView.13
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void b() {
                LatLngBounds latLngBounds = googleMap.f().b().f38577e;
                MapView mapView = MapView.this;
                if (mapView.H != 0) {
                    LatLngBounds latLngBounds2 = mapView.G;
                    if (latLngBounds2 != null) {
                        LatLng latLngB = latLngBounds.b();
                        LatLng latLng = latLngBounds.f38478b;
                        double d2 = latLng.f38475a;
                        LatLng latLng2 = latLngBounds.f38477a;
                        double d3 = d2 - latLng2.f38475a;
                        double d4 = latLng.f38476b - latLng2.f38476b;
                        LatLng latLngB2 = latLngBounds2.b();
                        LatLng latLng3 = latLngBounds2.f38478b;
                        double d5 = latLng3.f38475a;
                        LatLng latLng4 = latLngBounds2.f38477a;
                        double d6 = d5 - latLng4.f38475a;
                        double d7 = latLng3.f38476b - latLng4.f38476b;
                        double dMin = Math.min(Math.abs(latLng.f38475a - latLng2.f38475a), Math.abs(d6)) / 2560.0d;
                        double dMin2 = Math.min(Math.abs(d4), Math.abs(d7)) / 2560.0d;
                        if (!LatLngBoundsUtils.a(latLngB.f38475a, latLngB2.f38475a, dMin) && !LatLngBoundsUtils.a(latLngB.f38476b, latLngB2.f38476b, dMin2) && !LatLngBoundsUtils.a(d3, d6, dMin) && !LatLngBoundsUtils.a(d4, d7, dMin2)) {
                            return;
                        }
                    }
                    mapView.G = latLngBounds;
                    mapView.I0.g(new RegionChangeEvent(mapView.getId(), latLngBounds, false, 1 == mapView.H));
                }
            }
        });
        googleMap.B(new GoogleMap.OnMapLoadedCallback() { // from class: com.rnmaps.maps.MapView.14
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
            public final void a() {
                Boolean bool = Boolean.TRUE;
                MapView mapView = MapView.this;
                mapView.o = bool;
                mapView.D0.pushEvent(mapView.H0, this, "onMapLoaded", new WritableNativeMap());
                mapView.k();
            }
        });
        LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() { // from class: com.rnmaps.maps.MapView.15
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public final void onHostDestroy() {
                MapView.this.n();
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public final void onHostPause() {
                MapView mapView = MapView.this;
                String[] strArr = MapView.V0;
                if (mapView.q()) {
                    googleMap.r(false);
                }
                synchronized (MapView.this) {
                    MapView mapView2 = MapView.this;
                    if (!mapView2.G0) {
                        mapView2.f38411a.g();
                    }
                    MapView.this.F0 = true;
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public final void onHostResume() {
                MapView mapView = MapView.this;
                String[] strArr = MapView.V0;
                if (mapView.q()) {
                    googleMap.r(MapView.this.u);
                    googleMap.m(MapView.this.J0);
                }
                synchronized (MapView.this) {
                    MapView mapView2 = MapView.this;
                    if (!mapView2.G0) {
                        mapView2.f38411a.h();
                    }
                    MapView.this.F0 = false;
                }
            }
        };
        this.E0 = lifecycleEventListener;
        themedReactContext.addLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public final View c(Marker marker) {
        return p(marker).getInfoContents();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.C0.f3041a.onTouchEvent(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        GoogleMap googleMap = this.f46620b;
        if (googleMap != null) {
            this.L0 = googleMap.f().a(new Point(x, y));
        }
        int iA = MotionEventCompat.a(motionEvent);
        boolean z = false;
        if (iA == 0) {
            ViewParent parent = getParent();
            GoogleMap googleMap2 = this.f46620b;
            if (googleMap2 != null && googleMap2.g().a()) {
                z = true;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        } else if (iA == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public final View f(Marker marker) {
        return p(marker).getCallout();
    }

    public final void g(int i2, View view) {
        boolean z = view instanceof MapMarker;
        ArrayList arrayList = this.J;
        if (z) {
            MapMarker mapMarker = (MapMarker) view;
            MarkerManager.Collection collection = this.f46622d;
            mapMarker.getClass();
            mapMarker.f46530b = collection.h(mapMarker.getMarkerOptions());
            mapMarker.n();
            arrayList.add(i2, mapMarker);
            int visibility = mapMarker.getVisibility();
            mapMarker.setVisibility(4);
            ViewGroup viewGroup = (ViewGroup) mapMarker.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mapMarker);
            }
            this.K0.addView(mapMarker);
            mapMarker.setVisibility(visibility);
            this.K.put((Marker) mapMarker.getFeature(), mapMarker);
            return;
        }
        if (view instanceof MapPolyline) {
            MapPolyline mapPolyline = (MapPolyline) view;
            PolylineManager.Collection collection2 = this.f46624f;
            mapPolyline.getClass();
            Polyline polylineH = collection2.h(mapPolyline.getPolylineOptions());
            mapPolyline.f46579b = polylineH;
            polylineH.a(mapPolyline.f46583f);
            arrayList.add(i2, mapPolyline);
            this.L.put((Polyline) mapPolyline.getFeature(), mapPolyline);
            return;
        }
        if (view instanceof MapGradientPolyline) {
            MapGradientPolyline mapGradientPolyline = (MapGradientPolyline) view;
            GoogleMap googleMap = this.f46620b;
            mapGradientPolyline.getClass();
            mapGradientPolyline.f46497e = googleMap;
            mapGradientPolyline.f46498f = googleMap.a(mapGradientPolyline.k());
            arrayList.add(i2, mapGradientPolyline);
            this.B0.put((TileOverlay) mapGradientPolyline.getFeature(), mapGradientPolyline);
            return;
        }
        if (view instanceof MapPolygon) {
            MapPolygon mapPolygon = (MapPolygon) view;
            PolygonManager.Collection collection3 = this.f46626h;
            mapPolygon.getClass();
            Polygon polygonH = collection3.h(mapPolygon.getPolygonOptions());
            mapPolygon.f46567b = polygonH;
            polygonH.a(mapPolygon.f46574i);
            arrayList.add(i2, mapPolygon);
            this.M.put((Polygon) mapPolygon.getFeature(), mapPolygon);
            return;
        }
        if (view instanceof MapCircle) {
            MapCircle mapCircle = (MapCircle) view;
            CircleManager.Collection collection4 = this.f46627i;
            mapCircle.getClass();
            mapCircle.f46486b = collection4.h(mapCircle.getCircleOptions());
            arrayList.add(i2, mapCircle);
            return;
        }
        if (view instanceof MapUrlTile) {
            MapUrlTile mapUrlTile = (MapUrlTile) view;
            GoogleMap googleMap2 = this.f46620b;
            mapUrlTile.getClass();
            mapUrlTile.f46608b = googleMap2.a(mapUrlTile.getTileOverlayOptions());
            arrayList.add(i2, mapUrlTile);
            return;
        }
        if (view instanceof MapWMSTile) {
            MapWMSTile mapWMSTile = (MapWMSTile) view;
            GoogleMap googleMap3 = this.f46620b;
            mapWMSTile.getClass();
            mapWMSTile.f46608b = googleMap3.a(mapWMSTile.getTileOverlayOptions());
            arrayList.add(i2, mapWMSTile);
            return;
        }
        if (view instanceof MapLocalTile) {
            MapLocalTile mapLocalTile = (MapLocalTile) view;
            GoogleMap googleMap4 = this.f46620b;
            mapLocalTile.getClass();
            mapLocalTile.f46519b = googleMap4.a(mapLocalTile.getTileOverlayOptions());
            arrayList.add(i2, mapLocalTile);
            return;
        }
        if (view instanceof MapOverlay) {
            MapOverlay mapOverlay = (MapOverlay) view;
            GroundOverlayManager.Collection collection5 = this.f46629k;
            mapOverlay.getClass();
            GroundOverlayOptions groundOverlayOptions = mapOverlay.getGroundOverlayOptions();
            if (groundOverlayOptions != null) {
                GroundOverlay groundOverlayH = collection5.h(groundOverlayOptions);
                mapOverlay.f46557b = groundOverlayH;
                groundOverlayH.b(mapOverlay.f46561f);
            } else {
                mapOverlay.f46565j = collection5;
            }
            arrayList.add(i2, mapOverlay);
            this.Q.put((GroundOverlay) mapOverlay.getFeature(), mapOverlay);
            return;
        }
        if (view instanceof MapHeatmap) {
            MapHeatmap mapHeatmap = (MapHeatmap) view;
            GoogleMap googleMap5 = this.f46620b;
            mapHeatmap.getClass();
            mapHeatmap.f46512b = googleMap5.a(mapHeatmap.getHeatmapOptions());
            arrayList.add(i2, mapHeatmap);
            this.A0.put((TileOverlay) mapHeatmap.getFeature(), mapHeatmap);
            return;
        }
        if (!(view instanceof ViewGroup)) {
            addView(view, i2);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) view;
        for (int i3 = 0; i3 < viewGroup2.getChildCount(); i3++) {
            g(i2, viewGroup2.getChildAt(i3));
        }
    }

    public int getFeatureCount() {
        return this.J.size();
    }

    public double[][] getMapBoundaries() {
        LatLngBounds latLngBounds = this.f46620b.f().b().f38577e;
        LatLng latLng = latLngBounds.f38478b;
        double[] dArr = {latLng.f38476b, latLng.f38475a};
        LatLng latLng2 = latLngBounds.f38477a;
        return new double[][]{dArr, new double[]{latLng2.f38476b, latLng2.f38475a}};
    }

    public final void h(int i2, ReadableMap readableMap) {
        GoogleMap googleMap = this.f46620b;
        if (googleMap == null) {
            return;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder(googleMap.d());
        if (readableMap.hasKey("zoom")) {
            builder.e((float) readableMap.getDouble("zoom"));
        }
        if (readableMap.hasKey("heading")) {
            builder.a((float) readableMap.getDouble("heading"));
        }
        if (readableMap.hasKey("pitch")) {
            builder.d((float) readableMap.getDouble("pitch"));
        }
        if (readableMap.hasKey("center")) {
            ReadableMap map = readableMap.getMap("center");
            builder.c(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        CameraUpdate cameraUpdateA = CameraUpdateFactory.a(builder.b());
        if (i2 <= 0) {
            this.f46620b.h(cameraUpdateA);
        } else {
            this.f46620b.c(cameraUpdateA, i2);
        }
    }

    public final void i(int i2, int i3, int i4, int i5) {
        double d2 = getResources().getDisplayMetrics().density;
        int i6 = (int) (i2 * d2);
        this.Q0 = i6;
        int i7 = (int) (i3 * d2);
        this.S0 = i7;
        int i8 = (int) (i4 * d2);
        this.R0 = i8;
        int i9 = (int) (i5 * d2);
        this.T0 = i9;
        this.f46620b.J(i6 + this.M0, i7 + this.O0, i8 + this.N0, i9 + this.P0);
    }

    public final void j(int i2, int i3, int i4, int i5) {
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.M0 = i2;
            this.N0 = i4;
            this.O0 = i3;
            this.P0 = i5;
            this.t = true;
            return;
        }
        this.f46620b.J(this.Q0 + this.M0, this.S0 + this.O0, this.R0 + this.N0, this.T0 + this.P0);
        CameraUpdate cameraUpdateA = CameraUpdateFactory.a(this.f46620b.d());
        this.M0 = i2;
        this.N0 = i4;
        this.O0 = i3;
        this.P0 = i5;
        this.f46620b.J(this.Q0 + i2, this.S0 + i3, this.R0 + i4, this.T0 + i5);
        this.f46620b.h(cameraUpdateA);
        this.f46620b.J(i2, i3, i4, i5);
    }

    public final void k() {
        if (this.x) {
            final ImageView cacheImageView = getCacheImageView();
            final RelativeLayout mapLoadingLayoutView = getMapLoadingLayoutView();
            cacheImageView.setVisibility(4);
            mapLoadingLayoutView.setVisibility(0);
            if (this.o.booleanValue()) {
                this.f46620b.L(new GoogleMap.SnapshotReadyCallback() { // from class: com.rnmaps.maps.MapView.16
                    @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                    public final void a(Bitmap bitmap) {
                        ImageView imageView = cacheImageView;
                        imageView.setImageBitmap(bitmap);
                        imageView.setVisibility(0);
                        mapLoadingLayoutView.setVisibility(4);
                    }
                });
                return;
            }
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            ((ViewGroup) imageView.getParent()).removeView(this.n);
            this.n = null;
        }
        if (this.o.booleanValue()) {
            ProgressBar progressBar = this.f46630l;
            if (progressBar != null) {
                ((ViewGroup) progressBar.getParent()).removeView(this.f46630l);
                this.f46630l = null;
            }
            RelativeLayout relativeLayout = this.f46631m;
            if (relativeLayout != null) {
                ((ViewGroup) relativeLayout.getParent()).removeView(this.f46631m);
                this.f46631m = null;
            }
        }
    }

    public final synchronized void n() {
        ThemedReactContext themedReactContext;
        try {
            if (this.G0) {
                return;
            }
            this.G0 = true;
            LifecycleEventListener lifecycleEventListener = this.E0;
            if (lifecycleEventListener != null && (themedReactContext = this.H0) != null) {
                themedReactContext.removeLifecycleEventListener(lifecycleEventListener);
                this.E0 = null;
            }
            if (!this.F0) {
                this.f38411a.g();
                this.F0 = true;
            }
            this.f38411a.e();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void o(boolean z) {
        if (!z || this.o.booleanValue()) {
            return;
        }
        getMapLoadingLayoutView().setVisibility(0);
    }

    public final MapMarker p(Marker marker) {
        HashMap map = this.K;
        MapMarker mapMarker = (MapMarker) map.get(marker);
        if (mapMarker != null) {
            return mapMarker;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Marker) entry.getKey()).a().equals(marker.a()) && ((Marker) entry.getKey()).b().equals(marker.b())) {
                return (MapMarker) entry.getValue();
            }
        }
        return mapMarker;
    }

    public final boolean q() {
        Context context = getContext();
        String[] strArr = V0;
        return PermissionChecker.a(context, strArr[0]) == 0 || PermissionChecker.a(getContext(), strArr[1]) == 0;
    }

    public final WritableNativeMap r(LatLng latLng) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("latitude", latLng.f38475a);
        writableNativeMap2.putDouble("longitude", latLng.f38476b);
        writableNativeMap.putMap("coordinate", writableNativeMap2);
        Point pointC = this.f46620b.f().c(latLng);
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap3.putDouble("x", pointC.x);
        writableNativeMap3.putDouble("y", pointC.y);
        writableNativeMap.putMap("position", writableNativeMap3);
        return writableNativeMap;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        post(this.U0);
    }

    public final void s(ReadableMap readableMap) {
        CameraPosition cameraPositionL = l(readableMap);
        if (cameraPositionL == null) {
            return;
        }
        CameraUpdate cameraUpdateA = CameraUpdateFactory.a(cameraPositionL);
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.s = cameraUpdateA;
        } else {
            this.f46620b.h(cameraUpdateA);
            this.s = null;
        }
    }

    public void setCacheEnabled(boolean z) {
        this.x = z;
        k();
    }

    public void setCamera(ReadableMap readableMap) {
        this.C = readableMap;
        if (readableMap == null || this.f46620b == null) {
            return;
        }
        s(readableMap);
    }

    public void setHandlePanDrag(boolean z) {
        this.v = z;
    }

    public void setIndoorActiveLevelIndex(int i2) {
        IndoorLevel indoorLevel;
        IndoorBuilding indoorBuildingE = this.f46620b.e();
        if (indoorBuildingE == null || i2 < 0 || i2 >= indoorBuildingE.b().size() || (indoorLevel = (IndoorLevel) indoorBuildingE.b().get(i2)) == null) {
            return;
        }
        indoorLevel.a();
    }

    public void setInitialCamera(ReadableMap readableMap) {
        this.B = readableMap;
        if (this.F || this.f46620b == null) {
            return;
        }
        s(readableMap);
        this.F = true;
    }

    public void setInitialRegion(ReadableMap readableMap) {
        this.z = readableMap;
        if (this.E || this.f46620b == null) {
            return;
        }
        t(readableMap);
        this.E = true;
    }

    public void setKmlSrc(String str) {
        String str2 = CLConstants.FIELD_PAY_INFO_NAME;
        ThemedReactContext themedReactContext = this.H0;
        try {
            InputStream inputStream = new FileUtil(themedReactContext).execute(str).get();
            if (inputStream == null) {
                return;
            }
            KmlLayer kmlLayer = new KmlLayer(this.f46620b, inputStream, this.H0, this.f46621c, this.f46625g, this.f46623e, this.f46628j);
            kmlLayer.a();
            WritableMap writableNativeMap = new WritableNativeMap();
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            ArrayList arrayListB = kmlLayer.b();
            MapManager mapManager = this.D0;
            if (arrayListB == null) {
                mapManager.pushEvent(themedReactContext, this, "onKmlReady", writableNativeMap);
                return;
            }
            KmlContainer kmlContainer = (KmlContainer) kmlLayer.b().iterator().next();
            if (kmlContainer == null) {
                mapManager.pushEvent(themedReactContext, this, "onKmlReady", writableNativeMap);
                return;
            }
            if (kmlContainer.a().iterator().hasNext()) {
                kmlContainer = (KmlContainer) kmlContainer.a().iterator().next();
            }
            Iterator it = kmlContainer.b().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                KmlPlacemark kmlPlacemark = (KmlPlacemark) it.next();
                MarkerOptions markerOptions = new MarkerOptions();
                if (kmlPlacemark.e() != null) {
                    markerOptions = kmlPlacemark.f();
                } else {
                    markerOptions.W1(BitmapDescriptorFactory.a());
                }
                LatLng latLng = (LatLng) kmlPlacemark.a().d();
                String strB = kmlPlacemark.d(str2) ? kmlPlacemark.b(str2) : "";
                String strB2 = kmlPlacemark.d("description") ? kmlPlacemark.b("description") : "";
                markerOptions.a2(latLng);
                markerOptions.d2(strB);
                markerOptions.c2(strB2);
                String str3 = str2;
                Iterator it2 = it;
                MapMarker mapMarker = new MapMarker(themedReactContext, markerOptions, mapManager.getMarkerManager());
                if (kmlPlacemark.e() != null && kmlPlacemark.e().d() != null) {
                    mapMarker.setImage(kmlPlacemark.e().d());
                } else if (kmlContainer.c(kmlPlacemark.g()) != null) {
                    mapMarker.setImage(kmlContainer.c(kmlPlacemark.g()).d());
                }
                String str4 = strB + " - " + i2;
                mapMarker.setIdentifier(str4);
                g(i2, mapMarker);
                WritableNativeMap writableNativeMapR = r(latLng);
                writableNativeMapR.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, str4);
                writableNativeMapR.putString("title", strB);
                writableNativeMapR.putString("description", strB2);
                writableNativeArray.pushMap(writableNativeMapR);
                it = it2;
                i2++;
                str2 = str3;
            }
            writableNativeMap.putArray("markers", writableNativeArray);
            mapManager.pushEvent(themedReactContext, this, "onKmlReady", writableNativeMap);
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
        } catch (InterruptedException e3) {
            e = e3;
            e.printStackTrace();
        } catch (ExecutionException e4) {
            e = e4;
            e.printStackTrace();
        } catch (XmlPullParserException e5) {
            e = e5;
            e.printStackTrace();
        }
    }

    public void setLoadingBackgroundColor(Integer num) {
        this.p = num;
        RelativeLayout relativeLayout = this.f46631m;
        if (relativeLayout != null) {
            if (num == null) {
                relativeLayout.setBackgroundColor(-1);
            } else {
                relativeLayout.setBackgroundColor(num.intValue());
            }
        }
    }

    public void setLoadingIndicatorColor(Integer num) {
        this.q = num;
        if (this.f46630l != null) {
            if (num == null) {
                Color.parseColor("#606060");
            }
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(num.intValue());
            ColorStateList colorStateListValueOf2 = ColorStateList.valueOf(num.intValue());
            ColorStateList colorStateListValueOf3 = ColorStateList.valueOf(num.intValue());
            this.f46630l.setProgressTintList(colorStateListValueOf);
            this.f46630l.setSecondaryProgressTintList(colorStateListValueOf2);
            this.f46630l.setIndeterminateTintList(colorStateListValueOf3);
        }
    }

    public void setMapStyle(@Nullable String str) {
        this.D = str;
        GoogleMap googleMap = this.f46620b;
        if (googleMap == null || str == null) {
            return;
        }
        googleMap.n(new MapStyleOptions(str));
    }

    public void setMoveOnMarkerPress(boolean z) {
        this.w = z;
    }

    public void setPoiClickEnabled(boolean z) {
        this.y = z;
        this.f46620b.G(z ? this : null);
    }

    public void setRegion(ReadableMap readableMap) {
        this.A = readableMap;
        if (readableMap == null || this.f46620b == null) {
            return;
        }
        t(readableMap);
    }

    public void setShowsMyLocationButton(boolean z) {
        if (q() || !z) {
            this.f46620b.g().e(z);
        }
    }

    public void setShowsUserLocation(boolean z) {
        this.u = z;
        if (q()) {
            this.f46620b.m(this.J0);
            this.f46620b.r(z);
        }
    }

    public void setToolbarEnabled(boolean z) {
        if (q() || !z) {
            this.f46620b.g().d(z);
        }
    }

    public void setUserLocationFastestInterval(int i2) {
        this.J0.b(i2);
    }

    public void setUserLocationPriority(int i2) {
        this.J0.d(i2);
    }

    public void setUserLocationUpdateInterval(int i2) {
        this.J0.c(i2);
    }

    public final void t(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        double d2 = readableMap.getDouble("longitude");
        double d3 = readableMap.getDouble("latitude");
        double d4 = readableMap.getDouble("longitudeDelta");
        double d5 = readableMap.getDouble("latitudeDelta") / 2.0d;
        double d6 = d4 / 2.0d;
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(d3 - d5, d2 - d6), new LatLng(d5 + d3, d6 + d2));
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.f46620b.h(CameraUpdateFactory.d(new LatLng(d3, d2)));
            this.r = latLngBounds;
        } else {
            this.f46620b.h(CameraUpdateFactory.b(latLngBounds));
            this.r = null;
        }
    }

    public final void u(Object obj) {
        if (this.t && super.getHeight() > 0 && super.getWidth() > 0) {
            CameraUpdate cameraUpdateA = CameraUpdateFactory.a(this.f46620b.d());
            this.f46620b.J(this.Q0 + this.M0, this.S0 + this.O0, this.R0 + this.N0, this.T0 + this.P0);
            this.f46620b.h(cameraUpdateA);
            this.f46620b.J(this.M0, this.O0, this.N0, this.P0);
            this.t = false;
        }
        if (this.r == null) {
            CameraUpdate cameraUpdate = this.s;
            if (cameraUpdate != null) {
                this.f46620b.h(cameraUpdate);
                this.s = null;
                return;
            }
            return;
        }
        HashMap map = (HashMap) obj;
        int iIntValue = map.get(Snapshot.WIDTH) == null ? 0 : ((Float) map.get(Snapshot.WIDTH)).intValue();
        int iIntValue2 = map.get(Snapshot.HEIGHT) != null ? ((Float) map.get(Snapshot.HEIGHT)).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0) {
            this.f46620b.h(CameraUpdateFactory.b(this.r));
        } else {
            this.f46620b.h(CameraUpdateFactory.c(this.r, iIntValue, iIntValue2));
        }
        this.r = null;
        this.s = null;
    }
}
