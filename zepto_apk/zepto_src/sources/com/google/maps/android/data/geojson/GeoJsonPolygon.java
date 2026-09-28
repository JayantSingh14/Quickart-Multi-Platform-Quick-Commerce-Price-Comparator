package com.google.maps.android.data.geojson;

import com.google.maps.android.data.DataPolygon;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class GeoJsonPolygon implements DataPolygon {
    @Override // com.google.maps.android.data.Geometry
    public final String a() {
        return "Polygon";
    }

    @Override // com.google.maps.android.data.DataPolygon
    public final List b() {
        throw null;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public final List c() {
        new ArrayList();
        throw null;
    }

    @Override // com.google.maps.android.data.Geometry
    public final /* bridge */ /* synthetic */ Object d() {
        return null;
    }

    public final String toString() {
        return "Polygon{\n coordinates=null\n}\n";
    }
}
