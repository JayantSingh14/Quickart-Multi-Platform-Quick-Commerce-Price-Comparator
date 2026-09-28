package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class GeoJsonLineStringStyle extends Style implements GeoJsonStyle {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f45552d = {"LineString", "MultiLineString", "GeometryCollection"};

    public GeoJsonLineStringStyle() {
        PolylineOptions polylineOptions = new PolylineOptions();
        this.f45549b = polylineOptions;
        polylineOptions.f38530g = true;
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public final String[] a() {
        return f45552d;
    }

    public final String toString() {
        return "LineStringStyle{\n geometry type=" + Arrays.toString(f45552d) + ",\n color=" + this.f45549b.f38526c + ",\n clickable=" + this.f45549b.f38530g + ",\n geodesic=" + this.f45549b.f38529f + ",\n visible=" + this.f45549b.f38528e + ",\n width=" + this.f45549b.f38525b + ",\n z index=" + this.f45549b.f38527d + ",\n pattern=" + this.f45549b.f38534k + "\n}\n";
    }
}
