package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapGradientPolylineManager extends ViewGroupManager<MapGradientPolyline> {
    private final DisplayMetrics metrics;

    public MapGradientPolylineManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapGradientPolyline";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinates(MapGradientPolyline mapGradientPolyline, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            arrayList.add(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        mapGradientPolyline.setCoordinates(arrayList);
    }

    @ReactProp(customType = "ColorArray", name = "strokeColors")
    public void setStrokeColors(MapGradientPolyline mapGradientPolyline, ReadableArray readableArray) {
        if (readableArray == null) {
            mapGradientPolyline.setStrokeColors(new int[]{0, 0});
            return;
        }
        if (readableArray.size() == 0) {
            mapGradientPolyline.setStrokeColors(new int[]{0, 0});
            return;
        }
        if (readableArray.size() == 1) {
            mapGradientPolyline.setStrokeColors(new int[]{readableArray.getInt(0), readableArray.getInt(0)});
            return;
        }
        int[] iArr = new int[readableArray.size()];
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            iArr[i2] = readableArray.getInt(i2);
        }
        mapGradientPolyline.setStrokeColors(iArr);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapGradientPolyline mapGradientPolyline, float f2) {
        mapGradientPolyline.setWidth(this.metrics.density * f2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapGradientPolyline createViewInstance(ThemedReactContext themedReactContext) {
        return new MapGradientPolyline(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapGradientPolyline mapGradientPolyline, float f2) {
        mapGradientPolyline.setZIndex(f2);
    }
}
