package com.rnmaps.maps;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapMarkerManager extends ViewGroupManager<MapMarker> {
    private final Map<String, AirMapMarkerSharedIcon> sharedIcons = new ConcurrentHashMap();

    public static class AirMapMarkerSharedIcon {

        /* renamed from: a, reason: collision with root package name */
        public BitmapDescriptor f46544a;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f46545b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakHashMap f46546c = new WeakHashMap();

        /* renamed from: d, reason: collision with root package name */
        public boolean f46547d = false;

        public final synchronized void a(BitmapDescriptor bitmapDescriptor, Bitmap bitmap) {
            this.f46544a = bitmapDescriptor;
            this.f46545b = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            if (this.f46546c.isEmpty()) {
                return;
            }
            for (Map.Entry entry : this.f46546c.entrySet()) {
                if (entry.getKey() != null) {
                    MapMarker mapMarker = (MapMarker) entry.getKey();
                    mapMarker.p = bitmapDescriptor;
                    mapMarker.q = bitmap;
                    mapMarker.l(true);
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("onSelect", MapBuilder.c("phasedRegistrationNames", MapBuilder.c("bubbled", "onSelect")));
        builderA.b("onDeselect", MapBuilder.c("phasedRegistrationNames", MapBuilder.c("bubbled", "onDeselect")));
        return builderA.a();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("onPress", MapBuilder.c("registrationName", "onPress"));
        builderA.b("onCalloutPress", MapBuilder.c("registrationName", "onCalloutPress"));
        builderA.b("onDragStart", MapBuilder.c("registrationName", "onDragStart"));
        builderA.b("onDrag", MapBuilder.c("registrationName", "onDrag"));
        builderA.b("onDragEnd", MapBuilder.c("registrationName", "onDragEnd"));
        return builderA.a();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapMarker";
    }

    public AirMapMarkerSharedIcon getSharedIcon(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon;
        AirMapMarkerSharedIcon airMapMarkerSharedIcon2 = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon2 != null) {
            return airMapMarkerSharedIcon2;
        }
        synchronized (this) {
            try {
                airMapMarkerSharedIcon = this.sharedIcons.get(str);
                if (airMapMarkerSharedIcon == null) {
                    airMapMarkerSharedIcon = new AirMapMarkerSharedIcon();
                    this.sharedIcons.put(str, airMapMarkerSharedIcon);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return airMapMarkerSharedIcon;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    public void removeSharedIconIfEmpty(String str) {
        boolean zIsEmpty;
        boolean zIsEmpty2;
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon == null) {
            return;
        }
        synchronized (airMapMarkerSharedIcon) {
            zIsEmpty = airMapMarkerSharedIcon.f46546c.isEmpty();
        }
        if (zIsEmpty) {
            return;
        }
        synchronized (this) {
            AirMapMarkerSharedIcon airMapMarkerSharedIcon2 = this.sharedIcons.get(str);
            if (airMapMarkerSharedIcon2 != null) {
                synchronized (airMapMarkerSharedIcon2) {
                    zIsEmpty2 = airMapMarkerSharedIcon2.f46546c.isEmpty();
                }
                if (!zIsEmpty2) {
                    this.sharedIcons.remove(str);
                }
            }
        }
    }

    @ReactProp(name = "anchor")
    public void setAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        double d2 = (readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x");
        double d3 = (readableMap == null || !readableMap.hasKey("y")) ? 1.0d : readableMap.getDouble("y");
        mapMarker.f46537i = true;
        float f2 = (float) d2;
        mapMarker.f46538j = f2;
        float f3 = (float) d3;
        mapMarker.f46539k = f3;
        Marker marker = mapMarker.f46530b;
        if (marker != null) {
            marker.e(f2, f3);
        }
        mapMarker.l(false);
    }

    @ReactProp(name = "calloutAnchor")
    public void setCalloutAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        double d2 = (readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x");
        double d3 = (readableMap == null || !readableMap.hasKey("y")) ? 0.0d : readableMap.getDouble("y");
        mapMarker.y = true;
        float f2 = (float) d2;
        mapMarker.w = f2;
        float f3 = (float) d3;
        mapMarker.x = f3;
        Marker marker = mapMarker.f46530b;
        if (marker != null) {
            marker.i(f2, f3);
        }
        mapMarker.l(false);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCoordinate(readableMap);
    }

    @ReactProp(name = "description")
    public void setDescription(MapMarker mapMarker, String str) {
        mapMarker.setSnippet(str);
    }

    @ReactProp(defaultBoolean = false, name = "draggable")
    public void setDraggable(MapMarker mapMarker, boolean z) {
        mapMarker.setDraggable(z);
    }

    @ReactProp(defaultBoolean = false, name = "flat")
    public void setFlat(MapMarker mapMarker, boolean z) {
        mapMarker.setFlat(z);
    }

    @ReactProp(name = "icon")
    public void setIcon(MapMarker mapMarker, @Nullable String str) throws Resources.NotFoundException, NumberFormatException {
        mapMarker.setImage(str);
    }

    @ReactProp(name = "identifier")
    public void setIdentifier(MapMarker mapMarker, String str) {
        mapMarker.setIdentifier(str);
    }

    @ReactProp(name = "image")
    public void setImage(MapMarker mapMarker, @Nullable String str) throws Resources.NotFoundException, NumberFormatException {
        mapMarker.setImage(str);
    }

    @ReactProp(defaultFloat = 0.0f, name = "rotation")
    public void setMarkerRotation(MapMarker mapMarker, float f2) {
        mapMarker.setRotation(f2);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "pinColor")
    public void setPinColor(MapMarker mapMarker, int i2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        mapMarker.setMarkerHue(fArr[0]);
    }

    @ReactProp(name = "title")
    public void setTitle(MapMarker mapMarker, String str) {
        mapMarker.setTitle(str);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "tracksViewChanges")
    public void setTracksViewChanges(MapMarker mapMarker, boolean z) {
        mapMarker.setTracksViewChanges(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapMarker createViewInstance(ThemedReactContext themedReactContext) {
        return new MapMarker(themedReactContext, this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull final MapMarker mapMarker, String str, @Nullable ReadableArray readableArray) {
        str.getClass();
        switch (str) {
            case "animateMarkerToCoordinate":
                if (readableArray != null) {
                    ReadableMap map = readableArray.getMap(0);
                    int i2 = readableArray.getInt(1);
                    LatLng latLng = new LatLng(map.getDouble("latitude"), map.getDouble("longitude"));
                    mapMarker.getClass();
                    ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(mapMarker.f46530b, (Property<Marker, V>) Property.of(Marker.class, LatLng.class, "position"), new TypeEvaluator<LatLng>() { // from class: com.rnmaps.maps.MapMarker.2
                        public AnonymousClass2() {
                        }

                        @Override // android.animation.TypeEvaluator
                        public final LatLng evaluate(float f2, LatLng latLng2, LatLng latLng3) {
                            LatLng latLng4 = latLng2;
                            LatLng latLng5 = latLng3;
                            MapMarker.this.getClass();
                            double d2 = latLng5.f38475a;
                            double d3 = latLng4.f38475a;
                            double d4 = f2;
                            double d5 = ((d2 - d3) * d4) + d3;
                            double d6 = latLng5.f38476b;
                            double d7 = latLng4.f38476b;
                            return new LatLng(d5, ((d6 - d7) * d4) + d7);
                        }
                    }, latLng);
                    objectAnimatorOfObject.setDuration(i2);
                    objectAnimatorOfObject.start();
                    break;
                }
                break;
            case "redraw":
                mapMarker.m();
                break;
            case "hideCallout":
                ((Marker) mapMarker.getFeature()).c();
                break;
            case "showCallout":
                ((Marker) mapMarker.getFeature()).o();
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setTag(com.facebook.react.R.id.accessibility_label, str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapMarker mapMarker, float f2) {
        super.setOpacity((MapMarkerManager) mapMarker, f2);
        mapMarker.setOpacity(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 0.0f, name = "zIndex")
    public void setZIndex(MapMarker mapMarker, float f2) {
        super.setZIndex((MapMarkerManager) mapMarker, f2);
        mapMarker.setZIndex(Math.round(f2));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapMarker mapMarker, View view, int i2) {
        if (view instanceof MapCallout) {
            mapMarker.setCalloutView((MapCallout) view);
        } else {
            super.addView((MapMarkerManager) mapMarker, view, i2);
            mapMarker.l(true);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(MapMarker mapMarker, int i2) {
        super.removeViewAt((MapMarkerManager) mapMarker, i2);
        mapMarker.l(true);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapMarker mapMarker, Object obj) {
        HashMap map = (HashMap) obj;
        float fFloatValue = ((Float) map.get(Snapshot.WIDTH)).floatValue();
        int iFloatValue = (int) ((Float) map.get(Snapshot.HEIGHT)).floatValue();
        mapMarker.f46531c = (int) fFloatValue;
        mapMarker.f46532d = iFloatValue;
        mapMarker.l(true);
    }
}
