package com.rnmaps.maps;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public class RegionChangeEvent extends Event<RegionChangeEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final LatLngBounds f46663a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f46664b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f46665c;

    public RegionChangeEvent(int i2, LatLngBounds latLngBounds, boolean z, boolean z2) {
        super(i2);
        this.f46663a = latLngBounds;
        this.f46664b = z;
        this.f46665c = z2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("continuous", this.f46664b);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        LatLngBounds latLngBounds = this.f46663a;
        LatLng latLngB = latLngBounds.b();
        writableNativeMap2.putDouble("latitude", latLngB.f38475a);
        writableNativeMap2.putDouble("longitude", latLngB.f38476b);
        LatLng latLng = latLngBounds.f38478b;
        double d2 = latLng.f38475a;
        LatLng latLng2 = latLngBounds.f38477a;
        writableNativeMap2.putDouble("latitudeDelta", d2 - latLng2.f38475a);
        writableNativeMap2.putDouble("longitudeDelta", latLng.f38476b - latLng2.f38476b);
        writableNativeMap.putMap("region", writableNativeMap2);
        writableNativeMap.putBoolean("isGesture", this.f46665c);
        rCTEventEmitter.receiveEvent(getViewTag(), "topChange", writableNativeMap);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topChange";
    }
}
