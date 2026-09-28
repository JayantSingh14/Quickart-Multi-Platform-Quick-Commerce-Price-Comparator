package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.SquareCap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapPolylineManager extends ViewGroupManager<MapPolyline> {
    private final DisplayMetrics metrics;

    public MapPolylineManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.c("onPress", MapBuilder.c("registrationName", "onPress"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapPolyline";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(MapPolyline mapPolyline, ReadableArray readableArray) {
        mapPolyline.setCoordinates(readableArray);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setGeodesic(z);
    }

    @ReactProp(name = "lineDashPattern")
    public void setLineDashPattern(MapPolyline mapPolyline, ReadableArray readableArray) {
        mapPolyline.setLineDashPattern(readableArray);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(MapPolyline mapPolyline, int i2) {
        mapPolyline.setColor(i2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapPolyline mapPolyline, float f2) {
        mapPolyline.setWidth(this.metrics.density * f2);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setTappable(z);
    }

    @ReactProp(name = "lineCap")
    public void setlineCap(MapPolyline mapPolyline, String str) {
        Cap squareCap;
        str.getClass();
        switch (str) {
            case "square":
                squareCap = new SquareCap();
                break;
            case "butt":
                squareCap = new ButtCap();
                break;
            case "round":
                squareCap = new RoundCap();
                break;
            default:
                squareCap = new RoundCap();
                break;
        }
        mapPolyline.setLineCap(squareCap);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapPolyline createViewInstance(ThemedReactContext themedReactContext) {
        MapPolyline mapPolyline = new MapPolyline(themedReactContext);
        mapPolyline.f46586i = new RoundCap();
        return mapPolyline;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapPolyline mapPolyline, float f2) {
        mapPolyline.setZIndex(f2);
    }
}
