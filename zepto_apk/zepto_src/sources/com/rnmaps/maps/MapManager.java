package com.rnmaps.maps;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapManager extends ViewGroupManager<MapView> {
    private static final String REACT_CLASS = "AIRMap";
    private final Map<String, Integer> MAP_TYPES = MapBuilder.f("standard", 1, "satellite", 2, "hybrid", 4, "terrain", 3, "none", 0);
    private final Map<String, Integer> MY_LOCATION_PRIORITY = MapBuilder.b("balanced", 102, "high", 100, "low", 104, "passive", 105);
    private final ReactApplicationContext appContext;
    protected GoogleMapOptions googleMapOptions;
    private MapMarkerManager markerManager;
    protected MapsInitializer.Renderer renderer;

    public MapManager(ReactApplicationContext reactApplicationContext) {
        this.appContext = reactApplicationContext;
    }

    private void emitMapError(ThemedReactContext themedReactContext, String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str);
        writableMapCreateMap.putString("type", str2);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) themedReactContext.f19479a.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onError", writableMapCreateMap);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        HashMap mapF = MapBuilder.f("onMapReady", MapBuilder.c("registrationName", "onMapReady"), "onPress", MapBuilder.c("registrationName", "onPress"), "onLongPress", MapBuilder.c("registrationName", "onLongPress"), "onMarkerPress", MapBuilder.c("registrationName", "onMarkerPress"), "onCalloutPress", MapBuilder.c("registrationName", "onCalloutPress"));
        HashMap mapC = MapBuilder.c("registrationName", "onUserLocationChange");
        HashMap mapC2 = MapBuilder.c("registrationName", "onMarkerDragStart");
        HashMap mapC3 = MapBuilder.c("registrationName", "onMarkerDrag");
        HashMap mapC4 = MapBuilder.c("registrationName", "onMarkerDragEnd");
        HashMap mapC5 = MapBuilder.c("registrationName", "onPanDrag");
        HashMap mapC6 = MapBuilder.c("registrationName", "onKmlReady");
        HashMap mapC7 = MapBuilder.c("registrationName", "onPoiClick");
        HashMap map = new HashMap();
        map.put("onUserLocationChange", mapC);
        map.put("onMarkerDragStart", mapC2);
        map.put("onMarkerDrag", mapC3);
        map.put("onMarkerDragEnd", mapC4);
        map.put("onPanDrag", mapC5);
        map.put("onKmlReady", mapC6);
        map.put("onPoiClick", mapC7);
        mapF.putAll(map);
        HashMap mapC8 = MapBuilder.c("registrationName", "onIndoorLevelActivated");
        HashMap mapC9 = MapBuilder.c("registrationName", "onIndoorBuildingFocused");
        HashMap mapC10 = MapBuilder.c("registrationName", "onDoublePress");
        HashMap mapC11 = MapBuilder.c("registrationName", "onMapLoaded");
        HashMap mapC12 = MapBuilder.c("registrationName", "onMarkerSelect");
        HashMap mapC13 = MapBuilder.c("registrationName", "onMarkerDeselect");
        HashMap mapC14 = MapBuilder.c("registrationName", "onRegionChangeStart");
        HashMap map2 = new HashMap();
        map2.put("onIndoorLevelActivated", mapC8);
        map2.put("onIndoorBuildingFocused", mapC9);
        map2.put("onDoublePress", mapC10);
        map2.put("onMapLoaded", mapC11);
        map2.put("onMarkerSelect", mapC12);
        map2.put("onMarkerDeselect", mapC13);
        map2.put("onRegionChangeStart", mapC14);
        mapF.putAll(map2);
        return mapF;
    }

    public MapMarkerManager getMarkerManager() {
        return this.markerManager;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    public void pushEvent(ThemedReactContext themedReactContext, View view, String str, WritableMap writableMap) {
        ((RCTEventEmitter) themedReactContext.f19479a.getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), str, writableMap);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(defaultBoolean = false, name = "cacheEnabled")
    public void setCacheEnabled(MapView mapView, boolean z) {
        mapView.setCacheEnabled(z);
    }

    @ReactProp(name = "camera")
    public void setCamera(MapView mapView, ReadableMap readableMap) {
        mapView.setCamera(readableMap);
    }

    @ReactProp(name = "googleMapId")
    public void setGoogleMapId(MapView mapView, @Nullable String str) {
        if (str != null) {
            this.googleMapOptions.A(str);
        }
    }

    @ReactProp(name = "googleRenderer")
    public void setGoogleRenderer(MapView mapView, @Nullable String str) {
    }

    @ReactProp(defaultBoolean = false, name = "handlePanDrag")
    public void setHandlePanDrag(MapView mapView, boolean z) {
        mapView.setHandlePanDrag(z);
    }

    @ReactProp(name = "initialCamera")
    public void setInitialCamera(MapView mapView, ReadableMap readableMap) {
        mapView.setInitialCamera(readableMap);
    }

    @ReactProp(name = "initialRegion")
    public void setInitialRegion(MapView mapView, ReadableMap readableMap) {
        mapView.setInitialRegion(readableMap);
    }

    @ReactProp(name = "kmlSrc")
    public void setKmlSrc(MapView mapView, String str) {
        if (str != null) {
            mapView.setKmlSrc(str);
        }
    }

    @ReactProp(defaultBoolean = false, name = "liteMode")
    public void setLiteMode(MapView mapView, boolean z) {
        this.googleMapOptions.s(z);
    }

    @ReactProp(customType = "Color", name = "loadingBackgroundColor")
    public void setLoadingBackgroundColor(MapView mapView, @Nullable Integer num) {
        mapView.setLoadingBackgroundColor(num);
    }

    @ReactProp(defaultBoolean = false, name = "loadingEnabled")
    public void setLoadingEnabled(MapView mapView, boolean z) {
        mapView.o(z);
    }

    @ReactProp(customType = "Color", name = "loadingIndicatorColor")
    public void setLoadingIndicatorColor(MapView mapView, @Nullable Integer num) {
        mapView.setLoadingIndicatorColor(num);
    }

    @ReactProp(name = "mapPadding")
    public void setMapPadding(MapView mapView, @Nullable ReadableMap readableMap) {
        int i2;
        int i3;
        int i4;
        double d2 = mapView.getResources().getDisplayMetrics().density;
        if (readableMap != null) {
            int i5 = readableMap.hasKey("left") ? (int) (readableMap.getDouble("left") * d2) : 0;
            i3 = readableMap.hasKey("top") ? (int) (readableMap.getDouble("top") * d2) : 0;
            i4 = readableMap.hasKey("right") ? (int) (readableMap.getDouble("right") * d2) : 0;
            i2 = readableMap.hasKey("bottom") ? (int) (readableMap.getDouble("bottom") * d2) : 0;
            i = i5;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        mapView.j(i, i3, i4, i2);
        mapView.f46620b.J(i, i3, i4, i2);
    }

    @ReactProp(name = "customMapStyleString")
    public void setMapStyle(MapView mapView, @Nullable String str) {
        mapView.setMapStyle(str);
    }

    @ReactProp(name = "mapType")
    public void setMapType(MapView mapView, @Nullable String str) {
        mapView.f46620b.o(this.MAP_TYPES.get(str).intValue());
    }

    public void setMarkerManager(MapMarkerManager mapMarkerManager) {
        this.markerManager = mapMarkerManager;
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(MapView mapView, float f2) {
        mapView.f46620b.p(f2);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(MapView mapView, float f2) {
        mapView.f46620b.q(f2);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "moveOnMarkerPress")
    public void setMoveOnMarkerPress(MapView mapView, boolean z) {
        mapView.setMoveOnMarkerPress(z);
    }

    @ReactProp(defaultBoolean = false, name = "pitchEnabled")
    public void setPitchEnabled(MapView mapView, boolean z) {
        mapView.f46620b.g().i(z);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "poiClickEnabled")
    public void setPoiClickEnabled(MapView mapView, boolean z) {
        mapView.setPoiClickEnabled(z);
    }

    @ReactProp(name = "region")
    public void setRegion(MapView mapView, ReadableMap readableMap) {
        mapView.setRegion(readableMap);
    }

    @ReactProp(defaultBoolean = false, name = "rotateEnabled")
    public void setRotateEnabled(MapView mapView, boolean z) {
        mapView.f46620b.g().f(z);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "scrollDuringRotateOrZoomEnabled")
    public void setScrollDuringRotateOrZoomEnabled(MapView mapView, boolean z) {
        mapView.f46620b.g().h(z);
    }

    @ReactProp(defaultBoolean = false, name = "scrollEnabled")
    public void setScrollEnabled(MapView mapView, boolean z) {
        mapView.f46620b.g().g(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsBuildings")
    public void setShowBuildings(MapView mapView, boolean z) {
        mapView.f46620b.i(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoors")
    public void setShowIndoors(MapView mapView, boolean z) {
        mapView.f46620b.j(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsTraffic")
    public void setShowTraffic(MapView mapView, boolean z) {
        mapView.f46620b.K(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsCompass")
    public void setShowsCompass(MapView mapView, boolean z) {
        mapView.f46620b.g().b(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoorLevelPicker")
    public void setShowsIndoorLevelPicker(MapView mapView, boolean z) {
        mapView.f46620b.g().c(z);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "showsMyLocationButton")
    public void setShowsMyLocationButton(MapView mapView, boolean z) {
        mapView.setShowsMyLocationButton(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsUserLocation")
    public void setShowsUserLocation(MapView mapView, boolean z) {
        mapView.setShowsUserLocation(z);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "toolbarEnabled")
    public void setToolbarEnabled(MapView mapView, boolean z) {
        mapView.setToolbarEnabled(z);
    }

    @ReactProp(defaultInt = 5000, name = "userLocationFastestInterval")
    public void setUserLocationFastestInterval(MapView mapView, int i2) {
        mapView.setUserLocationFastestInterval(i2);
    }

    @ReactProp(name = "userLocationPriority")
    public void setUserLocationPriority(MapView mapView, @Nullable String str) {
        mapView.setUserLocationPriority(this.MY_LOCATION_PRIORITY.get(str).intValue());
    }

    @ReactProp(defaultInt = 5000, name = "userLocationUpdateInterval")
    public void setUserLocationUpdateInterval(MapView mapView, int i2) {
        mapView.setUserLocationUpdateInterval(i2);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "zoomControlEnabled")
    public void setZoomControlEnabled(MapView mapView, boolean z) {
        mapView.f46620b.g().j(z);
    }

    @ReactProp(defaultBoolean = false, name = "zoomEnabled")
    public void setZoomEnabled(MapView mapView, boolean z) {
        mapView.f46620b.g().k(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(MapView mapView) {
        mapView.n();
        super.onDropViewInstance((MapManager) mapView);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull MapView mapView, String str, @Nullable ReadableArray readableArray) {
        boolean z;
        int i2;
        str.getClass();
        z = true;
        i2 = 0;
        switch (str) {
            case "fitToSuppliedMarkers":
                if (readableArray != null) {
                    ReadableArray array = readableArray.getArray(0);
                    ReadableMap map = readableArray.getMap(1);
                    boolean z2 = readableArray.getBoolean(2);
                    if (mapView.f46620b != null) {
                        LatLngBounds.Builder builder = new LatLngBounds.Builder();
                        String[] strArr = new String[array.size()];
                        for (int i3 = 0; i3 < array.size(); i3++) {
                            strArr[i3] = array.getString(i3);
                        }
                        List listAsList = Arrays.asList(strArr);
                        Iterator it = mapView.J.iterator();
                        while (it.hasNext()) {
                            MapFeature mapFeature = (MapFeature) it.next();
                            if (mapFeature instanceof MapMarker) {
                                String identifier = ((MapMarker) mapFeature).getIdentifier();
                                Marker marker = (Marker) mapFeature.getFeature();
                                if (listAsList.contains(identifier)) {
                                    builder.b(marker.a());
                                    i2 = 1;
                                }
                            }
                        }
                        if (i2 != 0) {
                            CameraUpdate cameraUpdateB = CameraUpdateFactory.b(builder.a());
                            if (map != null) {
                                mapView.i(map.getInt("left"), map.getInt("top"), map.getInt("right"), map.getInt("bottom"));
                            }
                            if (z2) {
                                mapView.f46620b.b(cameraUpdateB);
                            } else {
                                mapView.f46620b.h(cameraUpdateB);
                            }
                            mapView.f46620b.J(mapView.M0, mapView.O0, mapView.N0, mapView.P0);
                            break;
                        }
                    }
                }
                break;
            case "setIndoorActiveLevelIndex":
                if (readableArray != null) {
                    mapView.setIndoorActiveLevelIndex(readableArray.getInt(0));
                    break;
                }
                break;
            case "setCamera":
                if (readableArray != null) {
                    mapView.h(0, readableArray.getMap(0));
                    break;
                }
                break;
            case "setMapBoundaries":
                if (readableArray != null) {
                    ReadableMap map2 = readableArray.getMap(0);
                    ReadableMap map3 = readableArray.getMap(1);
                    if (mapView.f46620b != null) {
                        LatLngBounds.Builder builder2 = new LatLngBounds.Builder();
                        builder2.b(new LatLng(map2.getDouble("latitude"), map2.getDouble("longitude")));
                        builder2.b(new LatLng(map3.getDouble("latitude"), map3.getDouble("longitude")));
                        mapView.f46620b.l(builder2.a());
                        break;
                    }
                }
                break;
            case "fitToElements":
                if (readableArray != null) {
                    ReadableMap map4 = readableArray.getMap(0);
                    boolean z3 = readableArray.getBoolean(1);
                    if (mapView.f46620b != null) {
                        LatLngBounds.Builder builder3 = new LatLngBounds.Builder();
                        Iterator it2 = mapView.J.iterator();
                        while (it2.hasNext()) {
                            MapFeature mapFeature2 = (MapFeature) it2.next();
                            if (mapFeature2 instanceof MapMarker) {
                                builder3.b(((Marker) mapFeature2.getFeature()).a());
                                i2 = 1;
                            }
                        }
                        if (i2 != 0) {
                            CameraUpdate cameraUpdateB2 = CameraUpdateFactory.b(builder3.a());
                            if (map4 != null) {
                                mapView.i(map4.getInt("left"), map4.getInt("top"), map4.getInt("right"), map4.getInt("bottom"));
                            }
                            if (z3) {
                                mapView.f46620b.b(cameraUpdateB2);
                            } else {
                                mapView.f46620b.h(cameraUpdateB2);
                            }
                            mapView.f46620b.J(mapView.M0, mapView.O0, mapView.N0, mapView.P0);
                            break;
                        }
                    }
                }
                break;
            case "animateCamera":
                if (readableArray != null) {
                    mapView.h(readableArray.getInt(1), readableArray.getMap(0));
                    break;
                }
                break;
            case "animateToRegion":
                if (readableArray != null) {
                    ReadableMap map5 = readableArray.getMap(0);
                    int i4 = readableArray.getInt(1);
                    double d2 = map5.getDouble("longitude");
                    double d3 = map5.getDouble("latitude");
                    double d4 = map5.getDouble("longitudeDelta");
                    double d5 = map5.getDouble("latitudeDelta") / 2.0d;
                    double d6 = d4 / 2.0d;
                    LatLngBounds latLngBounds = new LatLngBounds(new LatLng(d3 - d5, d2 - d6), new LatLng(d3 + d5, d2 + d6));
                    GoogleMap googleMap = mapView.f46620b;
                    if (googleMap != null) {
                        if (i4 <= 0) {
                            googleMap.h(CameraUpdateFactory.b(latLngBounds));
                            break;
                        } else {
                            googleMap.c(CameraUpdateFactory.b(latLngBounds), i4);
                            break;
                        }
                    }
                }
                break;
            case "fitToCoordinates":
                if (readableArray != null) {
                    ReadableArray array2 = readableArray.getArray(0);
                    ReadableMap map6 = readableArray.getMap(1);
                    boolean z4 = readableArray.getBoolean(2);
                    if (mapView.f46620b != null) {
                        LatLngBounds.Builder builder4 = new LatLngBounds.Builder();
                        while (i2 < array2.size()) {
                            ReadableMap map7 = array2.getMap(i2);
                            builder4.b(new LatLng(map7.getDouble("latitude"), map7.getDouble("longitude")));
                            i2++;
                            z = z;
                        }
                        CameraUpdate cameraUpdateB3 = CameraUpdateFactory.b(builder4.a());
                        if (map6 != null) {
                            mapView.i(map6.getInt("left"), map6.getInt("top"), map6.getInt("right"), map6.getInt("bottom"));
                        }
                        if (z4) {
                            mapView.f46620b.b(cameraUpdateB3);
                        } else {
                            mapView.f46620b.h(cameraUpdateB3);
                        }
                        mapView.f46620b.J(mapView.M0, mapView.O0, mapView.N0, mapView.P0);
                        break;
                    }
                }
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(MapView mapView, @Nullable String str) {
        mapView.setTag(com.facebook.react.R.id.accessibility_label, str);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapView mapView, View view, int i2) {
        mapView.g(i2, view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new MapView(themedReactContext, this.appContext, this, this.googleMapOptions);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(MapView mapView, int i2) {
        return (View) mapView.J.get(i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(MapView mapView) {
        return mapView.getFeatureCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(MapView mapView, int i2) {
        MapFeature mapFeature = (MapFeature) mapView.J.remove(i2);
        if (mapFeature instanceof MapMarker) {
            mapView.K.remove(mapFeature.getFeature());
            mapFeature.j(mapView.f46622d);
            mapView.K0.removeView(mapFeature);
            return;
        }
        if (mapFeature instanceof MapHeatmap) {
            mapView.A0.remove(mapFeature.getFeature());
            mapFeature.j(mapView.f46620b);
            return;
        }
        if (mapFeature instanceof MapCircle) {
            mapFeature.j(mapView.f46627i);
            return;
        }
        if (mapFeature instanceof MapOverlay) {
            mapFeature.j(mapView.f46629k);
            return;
        }
        if (mapFeature instanceof MapPolygon) {
            mapFeature.j(mapView.f46626h);
        } else if (mapFeature instanceof MapPolyline) {
            mapFeature.j(mapView.f46624f);
        } else {
            mapFeature.j(mapView.f46620b);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapView mapView, Object obj) {
        mapView.u(obj);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(int i2, @NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        CameraPosition cameraPositionL;
        this.googleMapOptions = new GoogleMapOptions();
        if (reactStylesDiffMap != null) {
            ReadableMap readableMap = reactStylesDiffMap.f19469a;
            if (readableMap.getString("googleMapId") != null) {
                this.googleMapOptions.A(readableMap.getString("googleMapId"));
            }
            if (readableMap.hasKey("liteMode")) {
                this.googleMapOptions.s(readableMap.isNull("liteMode") ? false : readableMap.getBoolean("liteMode"));
            }
            if (readableMap.hasKey("initialCamera")) {
                CameraPosition cameraPositionL2 = MapView.l(readableMap.getMap("initialCamera"));
                if (cameraPositionL2 != null) {
                    this.googleMapOptions.b(cameraPositionL2);
                }
            } else if (readableMap.hasKey("camera") && (cameraPositionL = MapView.l(readableMap.getMap("camera"))) != null) {
                this.googleMapOptions.b(cameraPositionL);
            }
            if (readableMap.hasKey("googleRenderer") && "LEGACY".equals(readableMap.getString("googleRenderer"))) {
                this.renderer = MapsInitializer.Renderer.f38414a;
            } else {
                this.renderer = MapsInitializer.Renderer.f38415b;
            }
        }
        return (MapView) super.createViewInstance(i2, themedReactContext, reactStylesDiffMap, stateWrapper);
    }
}
