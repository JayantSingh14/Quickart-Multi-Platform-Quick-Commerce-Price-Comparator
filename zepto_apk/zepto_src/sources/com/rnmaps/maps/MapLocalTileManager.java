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
public class MapLocalTileManager extends ViewGroupManager<MapLocalTile> {
    public MapLocalTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapLocalTile";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "pathTemplate")
    public void setPathTemplate(MapLocalTile mapLocalTile, String str) {
        mapLocalTile.setPathTemplate(str);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(MapLocalTile mapLocalTile, float f2) {
        mapLocalTile.setTileSize(f2);
    }

    @ReactProp(defaultBoolean = false, name = "useAssets")
    public void setUseAssets(MapLocalTile mapLocalTile, boolean z) {
        mapLocalTile.setUseAssets(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapLocalTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapLocalTile(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(MapLocalTile mapLocalTile, float f2) {
        mapLocalTile.setZIndex(f2);
    }
}
