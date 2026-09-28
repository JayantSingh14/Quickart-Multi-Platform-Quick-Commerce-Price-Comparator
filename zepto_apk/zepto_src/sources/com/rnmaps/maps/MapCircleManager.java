package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapCircleManager extends ViewGroupManager<MapCircle> {
    private final DisplayMetrics metrics;

    public MapCircleManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapCircle";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "center")
    public void setCenter(MapCircle mapCircle, ReadableMap readableMap) {
        mapCircle.setCenter(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "fillColor")
    public void setFillColor(MapCircle mapCircle, int i2) {
        mapCircle.setFillColor(i2);
    }

    @ReactProp(defaultDouble = 0.0d, name = "radius")
    public void setRadius(MapCircle mapCircle, double d2) {
        mapCircle.setRadius(d2);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(MapCircle mapCircle, int i2) {
        mapCircle.setStrokeColor(i2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapCircle mapCircle, float f2) {
        mapCircle.setStrokeWidth(this.metrics.density * f2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapCircle createViewInstance(ThemedReactContext themedReactContext) {
        return new MapCircle(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapCircle mapCircle, float f2) {
        mapCircle.setZIndex(f2);
    }
}
