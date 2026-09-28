package com.rnmaps.maps;

import android.view.View;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.WeightedLatLng;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapHeatmapManager extends ViewGroupManager<MapHeatmap> {
    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapHeatmap";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "gradient")
    public void setGradient(MapHeatmap mapHeatmap, ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray(LinearGradientManager.PROP_COLORS);
        int[] iArr = new int[array.size()];
        for (int i2 = 0; i2 < array.size(); i2++) {
            iArr[i2] = array.getInt(i2);
        }
        ReadableArray array2 = readableMap.getArray("startPoints");
        float[] fArr = new float[array2.size()];
        for (int i3 = 0; i3 < array2.size(); i3++) {
            fArr[i3] = (float) array2.getDouble(i3);
        }
        if (readableMap.hasKey("colorMapSize")) {
            mapHeatmap.setGradient(new Gradient(iArr, fArr, readableMap.getInt("colorMapSize")));
        } else {
            mapHeatmap.setGradient(new Gradient(fArr, iArr));
        }
    }

    @ReactProp(name = "opacity")
    public void setOpacity(MapHeatmap mapHeatmap, double d2) {
        mapHeatmap.setOpacity(d2);
    }

    @ReactProp(name = "points")
    public void setPoints(MapHeatmap mapHeatmap, ReadableArray readableArray) {
        WeightedLatLng[] weightedLatLngArr = new WeightedLatLng[readableArray.size()];
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            LatLng latLng = new LatLng(map.getDouble("latitude"), map.getDouble("longitude"));
            weightedLatLngArr[i2] = map.hasKey("weight") ? new WeightedLatLng(latLng, map.getDouble("weight")) : new WeightedLatLng(latLng);
        }
        mapHeatmap.setPoints(weightedLatLngArr);
    }

    @ReactProp(name = "radius")
    public void setRadius(MapHeatmap mapHeatmap, int i2) {
        mapHeatmap.setRadius(i2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapHeatmap createViewInstance(ThemedReactContext themedReactContext) {
        return new MapHeatmap(themedReactContext);
    }
}
