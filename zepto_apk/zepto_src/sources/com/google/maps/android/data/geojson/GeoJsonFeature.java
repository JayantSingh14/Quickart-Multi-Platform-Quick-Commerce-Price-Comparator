package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Feature;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes4.dex */
public class GeoJsonFeature extends Feature implements Observer {
    public final void e(GeoJsonStyle geoJsonStyle) {
        if (c() && Arrays.asList(geoJsonStyle.a()).contains(this.f45526c.a())) {
            setChanged();
            notifyObservers();
        }
    }

    public final String toString() {
        return "Feature{\n bounding box=null,\n geometry=" + this.f45526c + ",\n point style=null,\n line string style=null,\n polygon style=null,\n id=" + this.f45524a + ",\n properties=" + this.f45525b.entrySet() + "\n}\n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        if (observable instanceof GeoJsonStyle) {
            e((GeoJsonStyle) observable);
        }
    }
}
