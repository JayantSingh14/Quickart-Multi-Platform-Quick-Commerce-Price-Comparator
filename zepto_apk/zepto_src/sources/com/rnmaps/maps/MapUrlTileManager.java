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
public class MapUrlTileManager extends ViewGroupManager<MapUrlTile> {
    public MapUrlTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapUrlTile";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(defaultBoolean = false, name = "doubleTileSize")
    public void setDoubleTileSize(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setDoubleTileSize(z);
    }

    @ReactProp(defaultBoolean = false, name = "flipY")
    public void setFlipY(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setFlipY(z);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumNativeZ")
    public void setMaximumNativeZ(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setMaximumNativeZ(f2);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumZ")
    public void setMaximumZ(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setMaximumZ(f2);
    }

    @ReactProp(defaultFloat = 0.0f, name = "minimumZ")
    public void setMinimumZ(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setMinimumZ(f2);
    }

    @ReactProp(defaultBoolean = false, name = "offlineMode")
    public void setOfflineMode(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setOfflineMode(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "tileCacheMaxAge")
    public void setTileCacheMaxAge(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setTileCacheMaxAge(f2);
    }

    @ReactProp(name = "tileCachePath")
    public void setTileCachePath(MapUrlTile mapUrlTile, String str) {
        mapUrlTile.setTileCachePath(str);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setTileSize(f2);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(MapUrlTile mapUrlTile, String str) {
        mapUrlTile.setUrlTemplate(str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapUrlTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapUrlTile(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setOpacity(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(MapUrlTile mapUrlTile, float f2) {
        mapUrlTile.setZIndex(f2);
    }
}
