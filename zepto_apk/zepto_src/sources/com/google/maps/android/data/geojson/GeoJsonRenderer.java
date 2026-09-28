package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Renderer;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes4.dex */
public class GeoJsonRenderer extends Renderer implements Observer {
    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        if (observable instanceof GeoJsonFeature) {
            GeoJsonFeature geoJsonFeature = (GeoJsonFeature) observable;
            BiMultiMap biMultiMap = this.f45532b;
            boolean z = biMultiMap.get(geoJsonFeature) != null;
            if (z && geoJsonFeature.c()) {
                i(biMultiMap.get(geoJsonFeature));
                biMultiMap.put(geoJsonFeature, null);
                if (this.f45531a == null || !geoJsonFeature.c()) {
                    return;
                }
                biMultiMap.put(geoJsonFeature, b(geoJsonFeature, geoJsonFeature.f45526c));
                return;
            }
            if (z && !geoJsonFeature.c()) {
                i(biMultiMap.get(geoJsonFeature));
                biMultiMap.put(geoJsonFeature, null);
            } else {
                if (z || !geoJsonFeature.c()) {
                    return;
                }
                a(geoJsonFeature);
                if (this.f45541k) {
                    geoJsonFeature.addObserver(this);
                }
            }
        }
    }
}
