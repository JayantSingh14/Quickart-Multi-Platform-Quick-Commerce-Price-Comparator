package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class GeoJsonPolygonStyle extends Style implements GeoJsonStyle {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f45554d = {"Polygon", "MultiPolygon", "GeometryCollection"};

    public GeoJsonPolygonStyle() {
        PolygonOptions polygonOptions = new PolygonOptions();
        this.f45550c = polygonOptions;
        polygonOptions.f38520i = true;
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public final String[] a() {
        return f45554d;
    }

    public final String toString() {
        return "PolygonStyle{\n geometry type=" + Arrays.toString(f45554d) + ",\n fill color=" + this.f45550c.f38516e + ",\n geodesic=" + this.f45550c.f38519h + ",\n stroke color=" + this.f45550c.f38515d + ",\n stroke joint type=" + this.f45550c.f38521j + ",\n stroke pattern=" + this.f45550c.f38522k + ",\n stroke width=" + this.f45550c.f38514c + ",\n visible=" + this.f45550c.f38518g + ",\n z index=" + this.f45550c.f38517f + ",\n clickable=" + this.f45550c.f38520i + "\n}\n";
    }
}
