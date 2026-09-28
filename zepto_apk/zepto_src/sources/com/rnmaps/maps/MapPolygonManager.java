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
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapPolygonManager extends ViewGroupManager<MapPolygon> {
    private final DisplayMetrics metrics;

    public MapPolygonManager(ReactApplicationContext reactApplicationContext) {
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
        return "AIRMapPolygon";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setCoordinates(readableArray);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "fillColor")
    public void setFillColor(MapPolygon mapPolygon, int i2) {
        mapPolygon.setFillColor(i2);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setGeodesic(z);
    }

    @ReactProp(name = "holes")
    public void setHoles(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setHoles(readableArray);
    }

    @ReactProp(name = "lineDashPattern")
    public void setLineDashPattern(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setLineDashPattern(readableArray);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(MapPolygon mapPolygon, int i2) {
        mapPolygon.setStrokeColor(i2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapPolygon mapPolygon, float f2) {
        mapPolygon.setStrokeWidth(this.metrics.density * f2);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setTappable(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapPolygon createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolygon(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapPolygon mapPolygon, float f2) {
        mapPolygon.setZIndex(f2);
    }
}
