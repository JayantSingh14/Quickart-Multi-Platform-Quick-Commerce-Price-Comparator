package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapWMSTileManager extends ViewGroupManager<MapWMSTile> {
    public MapWMSTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapWMSTile";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumNativeZ")
    public void setMaximumNativeZ(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setMaximumNativeZ(f2);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumZ")
    public void setMaximumZ(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setMaximumZ(f2);
    }

    @ReactProp(defaultFloat = 0.0f, name = "minimumZ")
    public void setMinimumZ(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setMinimumZ(f2);
    }

    @ReactProp(defaultBoolean = false, name = "offlineMode")
    public void setOfflineMode(MapWMSTile mapWMSTile, boolean z) {
        mapWMSTile.setOfflineMode(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "tileCacheMaxAge")
    public void setTileCacheMaxAge(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setTileCacheMaxAge(f2);
    }

    @ReactProp(name = "tileCachePath")
    public void setTileCachePath(MapWMSTile mapWMSTile, String str) {
        mapWMSTile.setTileCachePath(str);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setTileSize(f2);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(MapWMSTile mapWMSTile, String str) {
        mapWMSTile.setUrlTemplate(str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapWMSTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapWMSTile(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setOpacity(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(MapWMSTile mapWMSTile, float f2) {
        mapWMSTile.setZIndex(f2);
    }
}
