package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.function.Function;

/* loaded from: classes4.dex */
public class MapUIBlock implements UIBlockInterface {

    /* renamed from: a, reason: collision with root package name */
    public final int f46603a;

    /* renamed from: b, reason: collision with root package name */
    public final Promise f46604b;

    /* renamed from: c, reason: collision with root package name */
    public final ReactApplicationContext f46605c;

    /* renamed from: d, reason: collision with root package name */
    public final Function f46606d;

    public MapUIBlock(int i2, Promise promise, ReactApplicationContext reactApplicationContext, Function function) {
        this.f46603a = i2;
        this.f46604b = promise;
        this.f46605c = reactApplicationContext;
        this.f46606d = function;
    }

    public final void a() {
        ((UIManagerModule) this.f46605c.getNativeModule(UIManagerModule.class)).addUIBlock(this);
    }

    public final void b(NativeViewHierarchyManager nativeViewHierarchyManager, UIBlockViewResolver uIBlockViewResolver) {
        int i2 = this.f46603a;
        MapView mapView = (MapView) (uIBlockViewResolver != null ? uIBlockViewResolver.resolveView(i2) : nativeViewHierarchyManager.resolveView(i2));
        Promise promise = this.f46604b;
        if (mapView == null) {
            promise.reject("AirMapView not found");
        } else if (mapView.f46620b == null) {
            promise.reject("AirMapView.map is not valid");
        } else {
            this.f46606d.apply(mapView);
        }
    }

    @Override // com.facebook.react.fabric.interop.UIBlock
    public final void execute(UIBlockViewResolver uIBlockViewResolver) {
        b(null, uIBlockViewResolver);
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public final void i(NativeViewHierarchyManager nativeViewHierarchyManager) {
        b(nativeViewHierarchyManager, null);
    }
}
